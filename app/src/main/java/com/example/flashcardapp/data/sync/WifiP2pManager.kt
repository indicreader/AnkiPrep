package com.example.flashcardapp.data.sync

import android.content.Context
import android.net.nsd.NsdManager
import android.net.nsd.NsdServiceInfo
import android.util.Log
import com.example.flashcardapp.data.backup.BackupRestoreUtils
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.ServerSocket
import java.net.Socket
import kotlin.random.Random

sealed class SyncState {
    object Idle : SyncState()
    data class Advertising(val pin: String) : SyncState()
    object Discovering : SyncState()
    data class DiscoveredPeers(val peers: List<NsdServiceInfo>) : SyncState()
    data class Connecting(val peerName: String) : SyncState()
    object Transferring : SyncState()
    data class Success(val message: String) : SyncState()
    data class Error(val error: String) : SyncState()
}

class WifiP2pManager(private val context: Context) {
    private val TAG = "WifiP2pManager"
    private val SERVICE_TYPE = "_ankiprepsync._tcp."
    private val SERVICE_NAME = "AnkiPrepSync_${Random.nextInt(1000, 9999)}"

    private val nsdManager = context.getSystemService(Context.NSD_SERVICE) as NsdManager
    
    private val _syncState = MutableStateFlow<SyncState>(SyncState.Idle)
    val syncState: StateFlow<SyncState> = _syncState

    private var serverSocket: ServerSocket? = null
    private var activeSocket: Socket? = null
    
    private var registrationListener: NsdManager.RegistrationListener? = null
    private var discoveryListener: NsdManager.DiscoveryListener? = null
    
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private val discoveredPeersList = mutableListOf<NsdServiceInfo>()

    // Mode tracking: true if we are transferring local data to peer, false if receiving from peer
    private var isSendMode = false

    fun startAdvertising(sendMode: Boolean) {
        isSendMode = sendMode
        stopAll()
        
        val pin = String.format("%04d", Random.nextInt(0, 10000))
        _syncState.value = SyncState.Advertising(pin)

        scope.launch {
            try {
                val server = ServerSocket(0) // Let system allocate a free port
                serverSocket = server
                val localPort = server.localPort

                registerService(localPort)

                Log.d(TAG, "Server socket listening on port: $localPort, PIN: $pin")
                
                while (coroutineContext.isActive) {
                    val socket = server.accept()
                    activeSocket = socket
                    handleServerConnection(socket, pin)
                    break
                }
            } catch (e: Exception) {
                Log.e(TAG, "Server socket error", e)
                if (serverSocket?.isClosed == false) {
                    _syncState.value = SyncState.Error("Server error: ${e.message}")
                }
            } finally {
                stopAll()
            }
        }
    }

    fun startDiscovery() {
        stopAll()
        discoveredPeersList.clear()
        _syncState.value = SyncState.Discovering
        
        discoveryListener = object : NsdManager.DiscoveryListener {
            override fun onStartDiscoveryFailed(serviceType: String?, errorCode: Int) {
                Log.e(TAG, "Start discovery failed: $errorCode")
                _syncState.value = SyncState.Error("Discovery start failed")
            }

            override fun onStopDiscoveryFailed(serviceType: String?, errorCode: Int) {
                Log.e(TAG, "Stop discovery failed: $errorCode")
            }

            override fun onDiscoveryStarted(serviceType: String?) {
                Log.d(TAG, "Service discovery started")
            }

            override fun onDiscoveryStopped(serviceType: String?) {
                Log.d(TAG, "Service discovery stopped")
            }

            override fun onServiceFound(serviceInfo: NsdServiceInfo?) {
                if (serviceInfo == null) return
                Log.d(TAG, "Service found: ${serviceInfo.serviceName}")
                if (serviceInfo.serviceType == SERVICE_TYPE && serviceInfo.serviceName != SERVICE_NAME) {
                    // Resolve service to get port and address
                    nsdManager.resolveService(serviceInfo, object : NsdManager.ResolveListener {
                        override fun onResolveFailed(serviceInfo: NsdServiceInfo?, errorCode: Int) {
                            Log.e(TAG, "Resolve failed: $errorCode")
                        }

                        override fun onServiceResolved(resolvedInfo: NsdServiceInfo?) {
                            if (resolvedInfo == null) return
                            Log.d(TAG, "Service resolved: ${resolvedInfo.host}:${resolvedInfo.port}")
                            scope.launch(Dispatchers.Main) {
                                if (discoveredPeersList.none { it.serviceName == resolvedInfo.serviceName }) {
                                    discoveredPeersList.add(resolvedInfo)
                                    _syncState.value = SyncState.DiscoveredPeers(discoveredPeersList.toList())
                                }
                            }
                        }
                    })
                }
            }

            override fun onServiceLost(serviceInfo: NsdServiceInfo?) {
                if (serviceInfo == null) return
                Log.d(TAG, "Service lost: ${serviceInfo.serviceName}")
                scope.launch(Dispatchers.Main) {
                    discoveredPeersList.removeAll { it.serviceName == serviceInfo.serviceName }
                    _syncState.value = SyncState.DiscoveredPeers(discoveredPeersList.toList())
                }
            }
        }

        nsdManager.discoverServices(SERVICE_TYPE, NsdManager.PROTOCOL_DNS_SD, discoveryListener)
    }

    fun connectToPeer(peer: NsdServiceInfo, pinCode: String, sendMode: Boolean) {
        isSendMode = sendMode
        stopDiscovery()
        _syncState.value = SyncState.Connecting(peer.serviceName)

        scope.launch {
            try {
                val host = peer.host ?: throw IllegalArgumentException("Host address is unresolved")
                val port = peer.port
                Log.d(TAG, "Connecting to host: $host, port: $port")

                val socket = Socket(host, port)
                activeSocket = socket
                
                val output = DataOutputStream(socket.getOutputStream())
                val input = DataInputStream(socket.getInputStream())

                // 1. Send PIN
                output.writeUTF(pinCode)
                output.flush()

                // 2. Read Auth Result
                val authorized = input.readBoolean()
                if (!authorized) {
                    _syncState.value = SyncState.Error("Invalid PIN authorization")
                    socket.close()
                    return@launch
                }

                // PIN is valid, start transfer
                _syncState.value = SyncState.Transferring

                // 3. Determine flow based on Mode
                // If Sender is SendMode -> Server receives.
                // If Sender is ReceiveMode -> Server sends.
                // So here, the Sender initiates writing or reading.
                // Send mode: write our backup ZIP. Receive mode: read incoming backup ZIP.
                if (isSendMode) {
                    output.writeBoolean(true) // Indicate we are sending
                    output.flush()

                    val success = BackupRestoreUtils.exportBackup(context, output)
                    if (success) {
                        _syncState.value = SyncState.Success("Data sent successfully to peer!")
                    } else {
                        _syncState.value = SyncState.Error("Failed to pack/send database backup")
                    }
                } else {
                    output.writeBoolean(false) // Indicate we are receiving
                    output.flush()

                    val success = BackupRestoreUtils.importBackup(context, input)
                    if (success) {
                        _syncState.value = SyncState.Success("Database mirrored successfully from peer!")
                    } else {
                        _syncState.value = SyncState.Error("Failed to restore incoming database")
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "Connection failed", e)
                _syncState.value = SyncState.Error("Sync failed: ${e.message}")
            } finally {
                stopAll()
            }
        }
    }

    private fun handleServerConnection(socket: Socket, pin: String) {
        try {
            val input = DataInputStream(socket.getInputStream())
            val output = DataOutputStream(socket.getOutputStream())

            // 1. Read PIN
            val receivedPin = input.readUTF()
            val isAuthorized = receivedPin == pin
            
            output.writeBoolean(isAuthorized)
            output.flush()

            if (!isAuthorized) {
                Log.w(TAG, "Client authorization failed (PIN mismatch)")
                _syncState.value = SyncState.Error("Handshake failed: Invalid PIN")
                return
            }

            _syncState.value = SyncState.Transferring

            // 2. Read mode direction from client
            val clientSending = input.readBoolean()

            // If client is sending, we receive.
            // If client is receiving, we send.
            if (clientSending) {
                val success = BackupRestoreUtils.importBackup(context, input)
                if (success) {
                    _syncState.value = SyncState.Success("Database mirrored successfully from peer!")
                } else {
                    _syncState.value = SyncState.Error("Failed to restore peer's database")
                }
            } else {
                val success = BackupRestoreUtils.exportBackup(context, output)
                if (success) {
                    _syncState.value = SyncState.Success("Data sent successfully to peer!")
                } else {
                    _syncState.value = SyncState.Error("Failed to pack/send local database")
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Socket transaction failed", e)
            _syncState.value = SyncState.Error("Transfer interrupted: ${e.message}")
        }
    }

    private fun registerService(port: Int) {
        val serviceInfo = NsdServiceInfo().apply {
            serviceName = SERVICE_NAME
            serviceType = SERVICE_TYPE
            setPort(port)
        }

        registrationListener = object : NsdManager.RegistrationListener {
            override fun onRegistrationFailed(serviceInfo: NsdServiceInfo?, errorCode: Int) {
                Log.e(TAG, "Service registration failed: $errorCode")
            }

            override fun onUnregistrationFailed(serviceInfo: NsdServiceInfo?, errorCode: Int) {
                Log.e(TAG, "Service unregistration failed: $errorCode")
            }

            override fun onServiceRegistered(serviceInfo: NsdServiceInfo?) {
                Log.d(TAG, "Service registered successfully: ${serviceInfo?.serviceName}")
            }

            override fun onServiceUnregistered(serviceInfo: NsdServiceInfo?) {
                Log.d(TAG, "Service unregistered successfully")
            }
        }

        nsdManager.registerService(serviceInfo, NsdManager.PROTOCOL_DNS_SD, registrationListener)
    }

    fun stopDiscovery() {
        discoveryListener?.let {
            try {
                nsdManager.stopServiceDiscovery(it)
            } catch (e: Exception) {
                Log.e(TAG, "Failed to stop discovery", e)
            }
        }
        discoveryListener = null
    }

    fun stopAll() {
        stopDiscovery()
        
        registrationListener?.let {
            try {
                nsdManager.unregisterService(it)
            } catch (e: Exception) {
                Log.e(TAG, "Failed to unregister service", e)
            }
        }
        registrationListener = null

        try {
            serverSocket?.close()
        } catch (e: Exception) {
            Log.e(TAG, "Failed to close server socket", e)
        }
        serverSocket = null

        try {
            activeSocket?.close()
        } catch (e: Exception) {
            Log.e(TAG, "Failed to close active socket", e)
        }
        activeSocket = null
    }
}

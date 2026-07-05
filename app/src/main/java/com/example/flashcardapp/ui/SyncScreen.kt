package com.example.flashcardapp.ui

import android.net.nsd.NsdServiceInfo
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.data.sync.SyncState
import com.example.flashcardapp.data.sync.WifiP2pManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SyncScreen(
    onBack: () -> Unit
) {
    val context = LocalContext.current
    val wifiManager = remember { WifiP2pManager(context) }
    val syncState by wifiManager.syncState.collectAsState()

    var selectedTab by remember { mutableStateOf(0) } // 0: Send, 1: Receive
    var showPinDialog by remember { mutableStateOf(false) }
    var targetPeer by remember { mutableStateOf<NsdServiceInfo?>(null) }
    var pinValue by remember { mutableStateOf("") }

    DisposableEffect(Unit) {
        onDispose {
            wifiManager.stopAll()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Local Wi-Fi Sync Engine", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Description banner
            Surface(
                color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Outlined.Info,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Sync SQLite databases, flashcards, review states, and image resources instantly over local Wi-Fi networks.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            // Tabs
            TabRow(
                selectedTabIndex = selectedTab,
                containerColor = Color.Transparent,
                divider = {}
            ) {
                Tab(
                    selected = selectedTab == 0,
                    onClick = {
                        selectedTab = 0
                        wifiManager.stopAll()
                    },
                    text = { Text("Push Local Data", fontWeight = FontWeight.Bold) }
                )
                Tab(
                    selected = selectedTab == 1,
                    onClick = {
                        selectedTab = 1
                        wifiManager.stopAll()
                    },
                    text = { Text("Pull/Receive Data", fontWeight = FontWeight.Bold) }
                )
            }

            // Sync State Info Card
            if (syncState !is SyncState.Idle) {
                Surface(
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "Status: ${getStatusLabel(syncState)}",
                            fontWeight = FontWeight.Bold,
                            color = getStatusColor(syncState)
                        )

                        when (val state = syncState) {
                            is SyncState.Advertising -> {
                                Text(
                                    text = "Share this 4-Digit PIN with the sending device to securely authenticate.",
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    textAlign = TextAlign.Center
                                )

                                Surface(
                                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.08f),
                                    shape = RoundedCornerShape(12.dp),
                                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.3f))
                                ) {
                                    Text(
                                        text = state.pin,
                                        fontSize = 32.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        fontFamily = FontFamily.Monospace,
                                        letterSpacing = 8.sp,
                                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp),
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                            }
                            is SyncState.Success -> {
                                Icon(
                                    Icons.Outlined.CheckCircle,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(36.dp)
                                )
                                Text(
                                    text = state.message,
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                            is SyncState.Error -> {
                                Text(
                                    text = state.error,
                                    color = MaterialTheme.colorScheme.error,
                                    textAlign = TextAlign.Center,
                                    fontSize = 13.sp
                                )
                            }
                            else -> {
                                LinearProgressIndicator(
                                    modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(4.dp)),
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }
                }
            }

            // Tab Content
            if (selectedTab == 0) {
                // Send mode UI
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Discovered Devices",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        IconButton(onClick = { wifiManager.startDiscovery() }) {
                            Icon(Icons.Outlined.Refresh, contentDescription = "Scan")
                        }
                    }

                    if (syncState is SyncState.Discovering) {
                        Box(
                            modifier = Modifier.weight(1f).fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
                                Text("Scanning local Wi-Fi subnet...", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }
                    } else if (syncState is SyncState.DiscoveredPeers) {
                        val peers = (syncState as SyncState.DiscoveredPeers).peers
                        if (peers.isEmpty()) {
                            Box(
                                modifier = Modifier.weight(1f).fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("No peer devices discovered. Make sure AnkiPrep is open on both devices on the same Wi-Fi.", color = MaterialTheme.colorScheme.onSurfaceVariant, textAlign = TextAlign.Center)
                            }
                        } else {
                            LazyColumn(
                                modifier = Modifier.weight(1f).fillMaxWidth(),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                items(peers) { peer ->
                                    Card(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clickable {
                                                targetPeer = peer
                                                pinValue = ""
                                                showPinDialog = true
                                            },
                                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                                    ) {
                                        Row(
                                            modifier = Modifier.padding(16.dp),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Column {
                                                Text(peer.serviceName, fontWeight = FontWeight.Bold)
                                                Text("IP: ${peer.host?.hostAddress ?: "Resolving..."}", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                            }
                                            Icon(Icons.Outlined.Send, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        Box(
                            modifier = Modifier.weight(1f).fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Button(
                                onClick = { wifiManager.startDiscovery() },
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Icon(Icons.Outlined.Share, contentDescription = null)
                                Spacer(Modifier.width(8.dp))
                                Text("Scan for Nearby Devices")
                            }
                        }
                    }
                }
            } else {
                // Receive mode UI
                Box(
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    if (syncState is SyncState.Advertising) {
                        Text(
                            text = "Waiting for connecting device...",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 32.dp)
                        )
                    } else {
                        Button(
                            onClick = { wifiManager.startAdvertising(sendMode = false) },
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Icon(Icons.Outlined.Share, contentDescription = null)
                            Spacer(Modifier.width(8.dp))
                            Text("Ready to Receive Data")
                        }
                    }
                }
            }
        }
    }

    if (showPinDialog && targetPeer != null) {
        AlertDialog(
            onDismissRequest = { showPinDialog = false },
            title = { Text("Pair with Peer") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Enter the 4-digit security PIN displayed on ${targetPeer?.serviceName}:")
                    OutlinedTextField(
                        value = pinValue,
                        onValueChange = { if (it.length <= 4) pinValue = it },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        label = { Text("PIN Code") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        showPinDialog = false
                        wifiManager.connectToPeer(targetPeer!!, pinValue, sendMode = true)
                    },
                    enabled = pinValue.length == 4
                ) {
                    Text("Sync Data")
                }
            },
            dismissButton = {
                TextButton(onClick = { showPinDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

private fun getStatusLabel(state: SyncState): String {
    return when (state) {
        SyncState.Idle -> "Idle"
        is SyncState.Advertising -> "Advertising Server (Waiting for client...)"
        SyncState.Discovering -> "Discovering Nearby Devices..."
        is SyncState.DiscoveredPeers -> "Discovered Peers"
        is SyncState.Connecting -> "Connecting to ${state.peerName}..."
        SyncState.Transferring -> "Transferring SQLite Database..."
        is SyncState.Success -> "Success!"
        is SyncState.Error -> "Sync Error"
    }
}

@Composable
private fun getStatusColor(state: SyncState): Color {
    return when (state) {
        is SyncState.Success -> MaterialTheme.colorScheme.primary
        is SyncState.Error -> MaterialTheme.colorScheme.error
        else -> MaterialTheme.colorScheme.secondary
    }
}

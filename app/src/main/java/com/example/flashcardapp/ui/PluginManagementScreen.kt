package com.example.flashcardapp.ui

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.data.entities.PluginEntity
import com.example.flashcardapp.data.plugin.PluginPresetTemplates
import com.example.flashcardapp.data.plugin.PluginRepository
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PluginManagementScreen(
    pluginRepository: PluginRepository,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    val plugins by pluginRepository.observeAllPlugins().collectAsState(initial = emptyList())

    var showUrlDialog by remember { mutableStateOf(false) }
    var urlInput by remember { mutableStateOf("") }
    var isDownloading by remember { mutableStateOf(false) }

    var showPresetsDialog by remember { mutableStateOf(false) }
    var selectedScriptForView by remember { mutableStateOf<PluginEntity?>(null) }
    var pluginToDelete by remember { mutableStateOf<PluginEntity?>(null) }

    // Seed preset templates on launch if list is empty
    LaunchedEffect(Unit) {
        pluginRepository.seedPresetPluginsIfEmpty()
    }

    // Local JS File Picker
    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri != null) {
            coroutineScope.launch {
                pluginRepository.installPluginFromUri(context, uri)
                    .onSuccess { plugin ->
                        Toast.makeText(context, "Installed plugin: ${plugin.name}", Toast.LENGTH_SHORT).show()
                    }
                    .onFailure { error ->
                        Toast.makeText(context, "Install failed: ${error.localizedMessage}", Toast.LENGTH_LONG).show()
                    }
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Question Parser Plugins", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                        Text("QuickJS Sandboxed Engine", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { showPresetsDialog = true }) {
                        Icon(Icons.Outlined.AutoAwesome, contentDescription = "Presets", tint = MaterialTheme.colorScheme.primary)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        floatingActionButton = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    onClick = { showUrlDialog = true },
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(Icons.Default.CloudDownload, contentDescription = null, modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("URL")
                }

                ExtendedFloatingActionButton(
                    onClick = { filePickerLauncher.launch("*/*") },
                    icon = { Icon(Icons.Default.FileOpen, contentDescription = null) },
                    text = { Text("Install .js File") },
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            // Status & Quick Stats Banner
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Default.Extension,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(28.dp)
                        )
                        Spacer(Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "${plugins.size} Plugins Installed",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = "${plugins.count { it.isEnabled }} Enabled for MCQ Parsing",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Surface(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Native QuickJS",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            if (plugins.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            Icons.Outlined.ExtensionOff,
                            contentDescription = null,
                            modifier = Modifier.size(64.dp),
                            tint = MaterialTheme.colorScheme.outline
                        )
                        Spacer(Modifier.height(16.dp))
                        Text(
                            "No Plugins Installed",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            "Install a custom JS parser file or remote URL script.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.outline
                        )
                    }
                }
            } else {
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    contentPadding = PaddingValues(bottom = 88.dp)
                ) {
                    items(plugins, key = { it.id }) { plugin ->
                        PluginItemCard(
                            plugin = plugin,
                            onToggleEnabled = { enabled ->
                                coroutineScope.launch {
                                    pluginRepository.togglePluginEnabled(plugin.id, enabled)
                                }
                            },
                            onViewSource = { selectedScriptForView = plugin },
                            onDelete = { pluginToDelete = plugin }
                        )
                    }
                }
            }
        }
    }

    // Remote URL Install Dialog
    if (showUrlDialog) {
        AlertDialog(
            onDismissRequest = { if (!isDownloading) showUrlDialog = false },
            title = { Text("Install Plugin from URL") },
            text = {
                Column {
                    Text(
                        "Enter a URL pointing to a raw .js plugin script (e.g., GitHub raw or Gist):",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.height(12.dp))
                    OutlinedTextField(
                        value = urlInput,
                        onValueChange = { urlInput = it },
                        placeholder = { Text("https://raw.githubusercontent.com/.../parser.js") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        enabled = !isDownloading
                    )
                    if (isDownloading) {
                        Spacer(Modifier.height(12.dp))
                        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (urlInput.isNotBlank()) {
                            isDownloading = true
                            coroutineScope.launch {
                                pluginRepository.installPluginFromUrl(urlInput.trim())
                                    .onSuccess { plugin ->
                                        isDownloading = false
                                        showUrlDialog = false
                                        urlInput = ""
                                        Toast.makeText(context, "Plugin '${plugin.name}' installed!", Toast.LENGTH_SHORT).show()
                                    }
                                    .onFailure { error ->
                                        isDownloading = false
                                        Toast.makeText(context, "Error: ${error.localizedMessage}", Toast.LENGTH_LONG).show()
                                    }
                            }
                        }
                    },
                    enabled = urlInput.isNotBlank() && !isDownloading
                ) {
                    Text("Download & Install")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showUrlDialog = false },
                    enabled = !isDownloading
                ) {
                    Text("Cancel")
                }
            }
        )
    }

    // Presets Template Dialog
    if (showPresetsDialog) {
        AlertDialog(
            onDismissRequest = { showPresetsDialog = false },
            title = { Text("Preset Community Plugins") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    PluginPresetTemplates.allPresets.forEach { preset ->
                        OutlinedCard(
                            onClick = {
                                coroutineScope.launch {
                                    pluginRepository.installPluginFromScript(preset.scriptContent, preset.id)
                                        .onSuccess {
                                            Toast.makeText(context, "Installed ${preset.name}", Toast.LENGTH_SHORT).show()
                                        }
                                    showPresetsDialog = false
                                }
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(preset.name, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                                    Text("Input: ${preset.inputType}", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
                                }
                                Icon(Icons.Default.AddCircleOutline, contentDescription = "Add", tint = MaterialTheme.colorScheme.primary)
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showPresetsDialog = false }) { Text("Close") }
            }
        )
    }

    // View Source Dialog
    selectedScriptForView?.let { plugin ->
        AlertDialog(
            onDismissRequest = { selectedScriptForView = null },
            title = { Text("${plugin.name} (v${plugin.version})") },
            text = {
                Column {
                    Text("Input Type: ${plugin.inputType}", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary)
                    Spacer(Modifier.height(8.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(max = 300.dp)
                            .background(Color(0xFF1E1E1E), shape = RoundedCornerShape(8.dp))
                            .padding(12.dp)
                    ) {
                        Text(
                            text = plugin.scriptContent,
                            color = Color(0xFFD4D4D4),
                            fontFamily = FontFamily.Monospace,
                            fontSize = 11.sp,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { selectedScriptForView = null }) { Text("Close") }
            }
        )
    }

    // Delete Confirmation Dialog
    pluginToDelete?.let { plugin ->
        AlertDialog(
            onDismissRequest = { pluginToDelete = null },
            title = { Text("Delete Plugin?") },
            text = { Text("Are you sure you want to remove '${plugin.name}'?") },
            confirmButton = {
                Button(
                    onClick = {
                        coroutineScope.launch {
                            pluginRepository.deletePlugin(plugin.id)
                            pluginToDelete = null
                            Toast.makeText(context, "Plugin deleted", Toast.LENGTH_SHORT).show()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                ) {
                    Text("Delete")
                }
            },
            dismissButton = {
                TextButton(onClick = { pluginToDelete = null }) { Text("Cancel") }
            }
        )
    }
}

@Composable
private fun PluginItemCard(
    plugin: PluginEntity,
    onToggleEnabled: (Boolean) -> Unit,
    onViewSource: () -> Unit,
    onDelete: () -> Unit
) {
    val inputColor = when (plugin.inputType) {
        "TEXT_PDF" -> Color(0xFFE53935)
        "RSS_ATOM" -> Color(0xFFFB8C00)
        "HTML_SCRAPE" -> Color(0xFF1E88E5)
        else -> MaterialTheme.colorScheme.primary
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (plugin.isEnabled)
                MaterialTheme.colorScheme.surface
            else
                MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = plugin.name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(Modifier.width(8.dp))
                    Surface(
                        color = inputColor.copy(alpha = 0.15f),
                        shape = RoundedCornerShape(6.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, inputColor.copy(alpha = 0.4f))
                    ) {
                        Text(
                            text = plugin.inputType,
                            style = MaterialTheme.typography.labelSmall,
                            color = inputColor,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }

                Switch(
                    checked = plugin.isEnabled,
                    onCheckedChange = onToggleEnabled
                )
            }

            if (plugin.description.isNotBlank()) {
                Spacer(Modifier.height(4.dp))
                Text(
                    text = plugin.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "v${plugin.version} • by ${plugin.author}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.outline
                )

                Row {
                    TextButton(onClick = onViewSource, contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)) {
                        Icon(Icons.Outlined.Code, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(Modifier.width(4.dp))
                        Text("JS Source", style = MaterialTheme.typography.labelMedium)
                    }

                    IconButton(onClick = onDelete, modifier = Modifier.size(32.dp)) {
                        Icon(Icons.Outlined.Delete, contentDescription = "Delete", tint = MaterialTheme.colorScheme.error, modifier = Modifier.size(18.dp))
                    }
                }
            }
        }
    }
}

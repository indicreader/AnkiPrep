package com.example.flashcardapp.ui

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.data.AppLanguage
import com.example.flashcardapp.data.SettingsRepository
import com.example.flashcardapp.ui.theme.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.os.PowerManager
import android.media.projection.MediaProjectionManager

import android.os.Build

fun sha256(input: String): String {
    val md = java.security.MessageDigest.getInstance("SHA-256")
    val digest = md.digest(input.toByteArray())
    return digest.joinToString("") { "%02x".format(it) }
}

fun getFileName(context: Context, uri: android.net.Uri): String {
    var result: String? = null
    if (uri.scheme == "content") {
        val cursor = context.contentResolver.query(uri, null, null, null, null)
        try {
            if (cursor != null && cursor.moveToFirst()) {
                val index = cursor.getColumnIndex(android.provider.OpenableColumns.DISPLAY_NAME)
                if (index != -1) {
                    result = cursor.getString(index)
                }
            }
        } finally {
            cursor?.close()
        }
    }
    if (result == null) {
        result = uri.path
        val cut = result?.lastIndexOf('/') ?: -1
        if (cut != -1) {
            result = result?.substring(cut + 1)
        }
    }
    return result ?: "custom_font_${System.currentTimeMillis()}.ttf"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsTab(
    isDarkMode: Boolean,
    onDarkModeToggle: (Boolean) -> Unit,
    themePreset: String,
    onThemePresetChange: (String) -> Unit,
    fontFamilyType: String,
    onFontFamilyTypeChange: (String) -> Unit,
    onNavigateToProfile: () -> Unit
) {
    val context = LocalContext.current
    val repository = remember { SettingsRepository.getInstance(context) }
    val sharedPrefs = remember { context.getSharedPreferences("AnkiPrepProfile", android.content.Context.MODE_PRIVATE) }
    var avatarUriStr by remember { mutableStateOf(sharedPrefs.getString("avatar_uri", null)) }
    DisposableEffect(sharedPrefs) {
        val listener = android.content.SharedPreferences.OnSharedPreferenceChangeListener { prefs, key ->
            if (key == "avatar_uri") {
                avatarUriStr = prefs.getString("avatar_uri", null)
            }
        }
        sharedPrefs.registerOnSharedPreferenceChangeListener(listener)
        onDispose {
            sharedPrefs.unregisterOnSharedPreferenceChangeListener(listener)
        }
    }
    val avatarUri = remember(avatarUriStr) { avatarUriStr?.let { android.net.Uri.parse(it) } }

    val currentLanguage by com.example.flashcardapp.data.TranslationManager.currentLanguage.collectAsState()
    var customFontPath by remember { mutableStateOf(repository.customFontPath) }
    var addedFonts by remember {
        mutableStateOf(
            java.io.File(context.filesDir, "fonts")
                .listFiles()
                ?.filter { it.isFile && (it.name.endsWith(".ttf", ignoreCase = true) || it.name.endsWith(".otf", ignoreCase = true)) }
                ?: emptyList()
        )
    }
    var dailyMasteryGoal by remember { mutableStateOf(repository.questionLimit) }
    var defaultAlgorithm by remember { mutableStateOf(repository.defaultAlgorithm) }
    var hapticEnabled by remember { mutableStateOf(repository.vibrationEnabled) }
    var showExplanations by remember { mutableStateOf(repository.showExplanations) }
    var whiteboardAutoStylusMode by remember { mutableStateOf(repository.whiteboardAutoStylusMode) }
    var whiteboardHighlighterAlpha by remember { mutableStateOf(repository.whiteboardHighlighterAlpha) }
    var whiteboardDefaultPenColor by remember { mutableStateOf(repository.whiteboardDefaultPenColor) }
    var whiteboardToolbarPosition by remember { mutableStateOf(repository.whiteboardToolbarPosition) }
    var whiteboardOneFingerDoubleTapAction by remember { mutableStateOf(repository.whiteboardOneFingerDoubleTapAction) }
    var whiteboardTwoFingerSingleTapAction by remember { mutableStateOf(repository.whiteboardTwoFingerSingleTapAction) }
    var whiteboardTwoFingerDoubleTapAction by remember { mutableStateOf(repository.whiteboardTwoFingerDoubleTapAction) }
    var whiteboardThreeFingerSingleTapAction by remember { mutableStateOf(repository.whiteboardThreeFingerSingleTapAction) }
    var whiteboardThreeFingerDoubleTapAction by remember { mutableStateOf(repository.whiteboardThreeFingerDoubleTapAction) }

    var showGuideModal by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()
    var showSyncScreen by remember { mutableStateOf(false) }
    var isBackingUp by remember { mutableStateOf(false) }
    var isRestoring by remember { mutableStateOf(false) }
    var backupSafUri by remember { mutableStateOf(repository.backupSafUri) }
    var backupInterval by remember { mutableStateOf(repository.backupInterval) }

    val backupDirPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocumentTree()
    ) { uri ->
        uri?.let {
            val flags = Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
            context.contentResolver.takePersistableUriPermission(it, flags)
            repository.backupSafUri = it.toString()
            backupSafUri = it.toString()
            com.example.flashcardapp.data.backup.BackupScheduler.updateSchedule(context)
            android.widget.Toast.makeText(context, "Backup folder configured successfully!", android.widget.Toast.LENGTH_SHORT).show()
        }
    }

    val restoreFilePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri ->
        uri?.let {
            coroutineScope.launch {
                isRestoring = true
                val success = withContext(kotlinx.coroutines.Dispatchers.IO) {
                    try {
                        context.contentResolver.openInputStream(it)?.use { inputStream ->
                            com.example.flashcardapp.data.backup.BackupRestoreUtils.importBackup(context, inputStream)
                        } ?: false
                    } catch (e: Exception) {
                        false
                    }
                }
                isRestoring = false
                if (success) {
                    android.widget.Toast.makeText(context, "Database restored successfully!", android.widget.Toast.LENGTH_SHORT).show()
                } else {
                    android.widget.Toast.makeText(context, "Failed to restore database", android.widget.Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    if (showSyncScreen) {
        SyncScreen(onBack = { showSyncScreen = false })
        return
    }



    // Practice mode states
    var practiceAlgorithm by remember { mutableStateOf("Spaced Repetition") }
    var practiceAlgoExpanded by remember { mutableStateOf(false) }

    // Mock test states
    var mockQuestionLimit by remember { mutableStateOf(repository.questionLimit) }
    var mockTimeLimitSec by remember { mutableStateOf(repository.timeLimitSeconds) }
    var mockAlgorithm by remember { mutableStateOf("Exam Standard") }
    var mockAlgoExpanded by remember { mutableStateOf(false) }

    // Smart revision states
    var revisionBatchSize by remember { mutableStateOf(35f) }
    var revisionAlgorithm by remember { mutableStateOf("Focus on Weak Areas") }
    var revisionAlgoExpanded by remember { mutableStateOf(false) }

    // Theme Color Palettes
    val themePresets = listOf(
        Triple("Teal", Color(0xFF00695C), "EMERALD"),
        Triple("Blue", Color(0xFF3F51B5), "OCEAN"),
        Triple("Slate", Color(0xFF455A64), "LAVENDER"),
        Triple("Crimson", Color(0xFFD81B60), "LAVENDER"),
        Triple("Orange", Color(0xFFE65100), "SUNSET")
    )
    val activeThemeIndex = remember(themePreset) { 
        themePresets.indexOfFirst { it.third == themePreset }.coerceAtLeast(0) 
    }

    if (showGuideModal) {
        AlertDialog(
            onDismissRequest = { showGuideModal = false },
            title = { Text("How to Use Mastery", fontWeight = FontWeight.Bold) },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("1. Import: Go to the Library tab and tap the + button to import CSV, APKG, or EPUB files.", fontSize = 14.sp)
                    Text("2. Review: Tap 'Study Now' on a deck to begin the focus quiz.", fontSize = 14.sp)
                    Text("3. Spine Metaphor: The colored left edge of the cards represents the 'spine' of a book. Thicker spines mean more mastery.", fontSize = 14.sp)
                    Text("4. Settings: Adjust your focus strategy and toggle Dark Mode for late night study.", fontSize = 14.sp)
                }
            },
            confirmButton = {
                Button(
                    onClick = { showGuideModal = false },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) { Text("Got it", color = Color.White) }
            },
            containerColor = MaterialTheme.colorScheme.surface,
            shape = RoundedCornerShape(24.dp)
        )
    }

    val bgColor = if (isDarkMode) MaterialTheme.colorScheme.background else Color(0xFFF4F7F6)
    val cardColor = if (isDarkMode) MaterialTheme.colorScheme.surfaceVariant else Color.White
    val cardBorderColor = if (isDarkMode) MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f) else Color(0xFFECEFF1)
    val titleTextColor = if (isDarkMode) MaterialTheme.colorScheme.onBackground else Color(0xFF263238)
    val subtextColor = if (isDarkMode) MaterialTheme.colorScheme.onSurfaceVariant else Color(0xFF78909C)
    val primaryTextColor = if (isDarkMode) MaterialTheme.colorScheme.onSurface else Color(0xFF263238)
    val labelTextColor = if (isDarkMode) MaterialTheme.colorScheme.primary else Color(0xFF546E7A)
    val inputBgColor = if (isDarkMode) MaterialTheme.colorScheme.surface else Color(0xFFF5F7F8)
    val dividerColor = if (isDarkMode) MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f) else Color(0xFFECEFF1)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = 600.dp)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Spacer(Modifier.height(16.dp))

            // ── Header ────────────────────────────────────────────────────────
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.15f))
                            .clickable { onNavigateToProfile() },
                        contentAlignment = Alignment.Center
                    ) {
                        if (avatarUri != null) {
                            AsyncImage(
                                model = avatarUri,
                                contentDescription = "Profile",
                                modifier = Modifier.fillMaxSize().clip(CircleShape),
                                contentScale = ContentScale.Crop
                            )
                        } else {
                            Icon(Icons.Filled.Person, contentDescription = "Profile", tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(22.dp))
                        }
                    }
                    Text("AnkiPrep", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                }
                // Streak chip
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .background(Color(0xFFFFF3E0))
                        .padding(horizontal = 10.dp, vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text("🔥", fontSize = 13.sp)
                    Text("12", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFFE65100))
                }
            }

            // ── Title ─────────────────────────────────────────────────────────
            Column {
                Text("Settings", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = titleTextColor)
                Spacer(Modifier.height(4.dp))
                Text("Manage your professional learning environment.", fontSize = 14.sp, color = subtextColor)
            }

            // ── How to Use Guide Card ─────────────────────────────────────────
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("How to Use Guide", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onPrimaryContainer)
                    Text(
                        "Master the \"Spine\" system, daily mastery goals, and active recall triggers for optimal exam preparation.",
                        fontSize = 13.sp, color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f), lineHeight = 19.sp
                    )
                    Spacer(Modifier.height(4.dp))
                    Button(
                        onClick = { showGuideModal = true },
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                        shape = RoundedCornerShape(50),
                        modifier = Modifier.height(40.dp)
                    ) {
                        Text("Open Handbook", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = Color.White)
                        Spacer(Modifier.width(6.dp))
                        Icon(Icons.Outlined.MenuBook, contentDescription = null, modifier = Modifier.size(16.dp), tint = Color.White)
                    }
                }
            }

            // ── TYPOGRAPHY & FONTS ────────────────────────────────────────────
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                SectionLabel("TYPOGRAPHY & FONTS", isDarkMode)
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = cardColor),
                    border = BorderStroke(1.dp, cardBorderColor),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Icon(Icons.Outlined.FontDownload, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                Column {
                                    Text("Active Font", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = primaryTextColor)
                                    Text(
                                        text = if (!customFontPath.isNullOrEmpty()) "Custom Font (Active)" else "Inter (Default System Font)",
                                        fontSize = 12.sp,
                                        color = subtextColor
                                    )
                                }
                            }
                            if (!customFontPath.isNullOrEmpty()) {
                                TextButton(
                                    onClick = {
                                        repository.customFontPath = null
                                        customFontPath = null
                                        onFontFamilyTypeChange("DEFAULT")
                                    }
                                ) {
                                    Text("Reset", color = Color.Red, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                                }
                            } else {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(6.dp))
                                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.15f))
                                        .padding(horizontal = 8.dp, vertical = 2.dp)
                                ) {
                                    Text("Active", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                                }
                            }
                        }


                        val coroutineScope = rememberCoroutineScope()
                        val fontFilePickerLauncher = rememberLauncherForActivityResult(
                            contract = androidx.activity.result.contract.ActivityResultContracts.GetContent()
                        ) { uri: android.net.Uri? ->
                            if (uri != null) {
                                coroutineScope.launch(kotlinx.coroutines.Dispatchers.IO) {
                                    try {
                                        val fontsDir = java.io.File(context.filesDir, "fonts")
                                        if (!fontsDir.exists()) fontsDir.mkdirs()
                                        val originalName = getFileName(context, uri)
                                        val destinationFile = java.io.File(fontsDir, originalName)
                                        context.contentResolver.openInputStream(uri)?.use { input ->
                                            destinationFile.outputStream().use { output ->
                                                input.copyTo(output)
                                            }
                                        }
                                        withContext(kotlinx.coroutines.Dispatchers.Main) {
                                            addedFonts = fontsDir.listFiles()
                                                ?.filter { it.isFile && (it.name.endsWith(".ttf", ignoreCase = true) || it.name.endsWith(".otf", ignoreCase = true)) }
                                                ?: emptyList()
                                            
                                            // Apply newly added font
                                            repository.customFontPath = destinationFile.absolutePath
                                            customFontPath = destinationFile.absolutePath
                                            onFontFamilyTypeChange("CUSTOM_" + destinationFile.name + "_" + System.currentTimeMillis())
                                            android.widget.Toast.makeText(context, "Font loaded successfully", android.widget.Toast.LENGTH_SHORT).show()
                                        }
                                    } catch (e: Exception) {
                                        withContext(kotlinx.coroutines.Dispatchers.Main) {
                                            android.widget.Toast.makeText(context, "Failed to load font file: ${e.message}", android.widget.Toast.LENGTH_LONG).show()
                                        }
                                    }
                                }
                            }
                        }

                        // Local File Picker Row
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                Icon(Icons.Outlined.FolderOpen, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(18.dp))
                                Text("Load Local Font File (.ttf/.otf)", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = primaryTextColor)
                            }
                            Button(
                                onClick = { fontFilePickerLauncher.launch("*/*") },
                                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                                contentPadding = PaddingValues(horizontal = 12.dp),
                                modifier = Modifier.height(28.dp),
                                shape = RoundedCornerShape(6.dp)
                            ) {
                                Text("Choose File", fontSize = 11.sp, color = Color.White, fontWeight = FontWeight.Bold)
                            }
                        }

                        if (addedFonts.isNotEmpty()) {
                            HorizontalDivider(color = dividerColor)
                            Text("Added Fonts", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = primaryTextColor)
                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                addedFonts.forEach { fontFile ->
                                    val isSelected = customFontPath == fontFile.absolutePath
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(10.dp))
                                            .background(if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.12f) else inputBgColor)
                                            .clickable {
                                                repository.customFontPath = fontFile.absolutePath
                                                customFontPath = fontFile.absolutePath
                                                onFontFamilyTypeChange("CUSTOM_" + fontFile.name + "_" + System.currentTimeMillis())
                                            }
                                            .padding(horizontal = 12.dp, vertical = 8.dp)
                                    ) {
                                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.weight(1f)) {
                                            Icon(
                                                imageVector = if (isSelected) Icons.Outlined.CheckCircle else Icons.Outlined.FontDownload,
                                                contentDescription = null,
                                                tint = if (isSelected) MaterialTheme.colorScheme.primary else subtextColor,
                                                modifier = Modifier.size(18.dp)
                                            )
                                            Text(
                                                text = fontFile.name,
                                                fontSize = 13.sp,
                                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                                color = if (isSelected) MaterialTheme.colorScheme.primary else primaryTextColor
                                            )
                                        }
                                        IconButton(
                                            onClick = {
                                                fontFile.delete()
                                                val fontsDir = java.io.File(context.filesDir, "fonts")
                                                addedFonts = fontsDir.listFiles()
                                                    ?.filter { it.isFile && (it.name.endsWith(".ttf", ignoreCase = true) || it.name.endsWith(".otf", ignoreCase = true)) }
                                                    ?: emptyList()
                                                if (isSelected) {
                                                    repository.customFontPath = null
                                                    customFontPath = null
                                                    onFontFamilyTypeChange("DEFAULT")
                                                }
                                            },
                                            modifier = Modifier.size(24.dp)
                                        ) {
                                            Icon(
                                                Icons.Outlined.Delete,
                                                contentDescription = "Delete",
                                                tint = Color.Red.copy(alpha = 0.7f),
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // ── QUIZ & STUDY MODES ────────────────────────────────────────────
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                SectionLabel("QUIZ & STUDY MODES", isDarkMode)

                // Global Study Mode Card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = cardColor),
                    border = BorderStroke(1.dp, cardBorderColor),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Icon(Icons.Outlined.Settings, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                Column {
                                    Text("Global Study Mode", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = primaryTextColor)
                                    Text("Default mode for all study sessions", fontSize = 11.sp, color = subtextColor)
                                }
                            }
                            
                            var globalModeExpanded by remember { mutableStateOf(false) }
                            var activeGlobalMode by remember { mutableStateOf(repository.studyMode) }
                            Box {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(inputBgColor)
                                        .clickable { globalModeExpanded = true }
                                        .padding(horizontal = 12.dp, vertical = 6.dp)
                                ) {
                                    val label = when (activeGlobalMode) {
                                        com.example.flashcardapp.session.McqSessionMode.PRACTICE -> "Practice Mode"
                                        com.example.flashcardapp.session.McqSessionMode.TEST -> "Mock Test"
                                        com.example.flashcardapp.session.McqSessionMode.REVISION -> "Smart Revision"
                                        com.example.flashcardapp.session.McqSessionMode.RATED_PRIORITY -> "Priority Rated"
                                    }
                                    Text(label, fontSize = 13.sp, fontWeight = FontWeight.Medium, color = primaryTextColor)
                                }
                                DropdownMenu(expanded = globalModeExpanded, onDismissRequest = { globalModeExpanded = false }) {
                                    listOf(
                                        com.example.flashcardapp.session.McqSessionMode.PRACTICE to "Practice Mode",
                                        com.example.flashcardapp.session.McqSessionMode.TEST to "Mock Test",
                                        com.example.flashcardapp.session.McqSessionMode.REVISION to "Smart Revision",
                                        com.example.flashcardapp.session.McqSessionMode.RATED_PRIORITY to "Priority Rated"
                                    ).forEach { (mode, label) ->
                                        DropdownMenuItem(
                                            text = { Text(label) },
                                            onClick = {
                                                activeGlobalMode = mode
                                                repository.studyMode = mode
                                                globalModeExpanded = false
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                // Practice Mode Card
                StudyModeCard(
                    title = "PRACTICE MODE",
                    icon = Icons.Outlined.DirectionsRun,
                    headerBg = if (isDarkMode) MaterialTheme.colorScheme.primaryContainer else Color(0xFFE0F2F1),
                    textColor = if (isDarkMode) MaterialTheme.colorScheme.onPrimaryContainer else Color(0xFF004D40),
                    questionLimit = dailyMasteryGoal,
                    onQuestionLimitChange = {
                        dailyMasteryGoal = it
                        repository.questionLimit = it
                    },
                    presets = listOf(20, 30, 50, 80),
                    presetLabels = listOf("20 Qs", "30 Qs", "50 Qs", "80 Qs"),
                    maxCustomValue = 500,
                    customLabel = "Manual (1-500)",
                    timeLimitSeconds = 0,
                    onTimeLimitSecondsChange = {},
                    timePresets = emptyList(),
                    timePresetLabels = emptyList(),
                    selectedAlgorithm = practiceAlgorithm,
                    algoExpanded = practiceAlgoExpanded,
                    onAlgoExpandedChange = { practiceAlgoExpanded = it },
                    onAlgoSelected = { practiceAlgorithm = it },
                    algoOptions = listOf("Spaced Repetition", "FSRS", "Leitner"),
                    isPracticeMode = true,
                    isDarkMode = isDarkMode
                )

                // Mock Test Card
                StudyModeCard(
                    title = "MOCK TEST",
                    icon = Icons.Outlined.Alarm,
                    headerBg = if (isDarkMode) MaterialTheme.colorScheme.surfaceVariant else Color(0xFFECEFF1),
                    textColor = if (isDarkMode) MaterialTheme.colorScheme.onSurfaceVariant else Color(0xFF37474F),
                    questionLimit = mockQuestionLimit,
                    onQuestionLimitChange = {
                        mockQuestionLimit = it
                        repository.questionLimit = it
                    },
                    presets = listOf(20, 30, 50, 80),
                    presetLabels = listOf("20 Qs", "30 Qs", "50 Qs", "80 Qs"),
                    maxCustomValue = 500,
                    customLabel = "Manual (1-500)",
                    timeLimitSeconds = mockTimeLimitSec,
                    onTimeLimitSecondsChange = {
                        mockTimeLimitSec = it
                        repository.timeLimitSeconds = it
                    },
                    timePresets = listOf(15, 30, 60, 90),
                    timePresetLabels = listOf("15s", "30s", "60s", "90s"),
                    timeCustomLabel = "Manual Secs",
                    selectedAlgorithm = mockAlgorithm,
                    algoExpanded = mockAlgoExpanded,
                    onAlgoExpandedChange = { mockAlgoExpanded = it },
                    onAlgoSelected = { mockAlgorithm = it },
                    algoOptions = listOf("Exam Standard", "FSRS", "Random"),
                    isPracticeMode = false,
                    isDarkMode = isDarkMode
                )

                // Smart Revision Card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = cardColor),
                    border = BorderStroke(1.dp, cardBorderColor),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                ) {
                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(if (isDarkMode) MaterialTheme.colorScheme.surfaceVariant else Color(0xFFECEFF1))
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(Icons.Outlined.AutoAwesome, contentDescription = null, tint = if (isDarkMode) MaterialTheme.colorScheme.onSurfaceVariant else Color(0xFF455A64), modifier = Modifier.size(18.dp))
                            Text("SMART REVISION", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = if (isDarkMode) MaterialTheme.colorScheme.onSurfaceVariant else Color(0xFF455A64))
                        }

                        Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            // Slider
                            Column {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text("Daily Review Batch", fontSize = 14.sp, color = primaryTextColor)
                                    Text("${revisionBatchSize.toInt()}", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = primaryTextColor)
                                }
                                Slider(
                                    value = revisionBatchSize,
                                    onValueChange = { revisionBatchSize = it },
                                    valueRange = 5f..100f,
                                    colors = SliderDefaults.colors(
                                        thumbColor = MaterialTheme.colorScheme.primary,
                                        activeTrackColor = MaterialTheme.colorScheme.primary,
                                        inactiveTrackColor = MaterialTheme.colorScheme.outlineVariant
                                    )
                                )
                            }

                            // Algorithm Dropdown
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("Algorithm", fontSize = 14.sp, color = primaryTextColor)
                                Box {
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(8.dp))
                                            .background(inputBgColor)
                                            .clickable { revisionAlgoExpanded = true }
                                            .padding(horizontal = 12.dp, vertical = 6.dp)
                                    ) {
                                        Text(revisionAlgorithm, fontSize = 13.sp, fontWeight = FontWeight.Medium, color = primaryTextColor)
                                    }
                                    DropdownMenu(expanded = revisionAlgoExpanded, onDismissRequest = { revisionAlgoExpanded = false }) {
                                        listOf("Focus on Weak Areas", "FSRS", "Leitner").forEach { opt ->
                                            DropdownMenuItem(text = { Text(opt) }, onClick = {
                                                revisionAlgorithm = opt
                                                revisionAlgoExpanded = false
                                            })
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // ── VISUALS & EXPERIENCE ──────────────────────────────────────────
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                SectionLabel("VISUALS & EXPERIENCE", isDarkMode)
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = cardColor),
                    border = BorderStroke(1.dp, cardBorderColor),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        // Appearance
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Icon(Icons.Outlined.Contrast, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                Column {
                                    Text("Appearance", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = primaryTextColor)
                                    Text("Switch between Dark and Light mode", fontSize = 11.sp, color = subtextColor)
                                }
                            }
                            Switch(
                                checked = isDarkMode,
                                onCheckedChange = {
                                    onDarkModeToggle(it)
                                    repository.isDarkMode = it
                                },
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Color.White,
                                    checkedTrackColor = MaterialTheme.colorScheme.primary
                                )
                            )
                        }

                        // Show Explanations
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Icon(Icons.Outlined.LibraryBooks, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                Column {
                                    Text("Show Explanations", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = primaryTextColor)
                                    Text("Auto-reveal logic after answering", fontSize = 11.sp, color = subtextColor)
                                }
                            }
                            Switch(
                                checked = showExplanations,
                                onCheckedChange = {
                                    showExplanations = it
                                    repository.showExplanations = it
                                },
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Color.White,
                                    checkedTrackColor = MaterialTheme.colorScheme.primary
                                )
                            )
                        }

                        // Theme Color Palette Selection
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Icon(Icons.Outlined.Palette, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                Column {
                                    Text("Theme Color", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = primaryTextColor)
                                    Text("Personalize your workspace palette", fontSize = 11.sp, color = subtextColor)
                                }
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                themePresets.forEachIndexed { idx, p ->
                                    val isSelected = activeThemeIndex == idx
                                    Box(
                                        modifier = Modifier
                                            .size(36.dp)
                                            .clip(CircleShape)
                                            .background(p.second)
                                            .border(
                                                width = if (isSelected) 3.dp else 0.dp,
                                                color = if (isSelected) primaryTextColor else Color.Transparent,
                                                shape = CircleShape
                                            )
                                            .clickable {
                                                onThemePresetChange(p.third)
                                            }
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // ── WHITEBOARD SETTINGS ──────────────────────────────────────────
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                SectionLabel("WHITEBOARD SETTINGS", isDarkMode)
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = cardColor),
                    border = BorderStroke(1.dp, cardBorderColor),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                        // Switch 1: Stylus Auto-Switch
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Icon(Icons.Outlined.Gesture, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                Column {
                                    Text("Stylus Auto-Switch", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = primaryTextColor)
                                    Text("Stylus automatically draws, finger scrolls", fontSize = 11.sp, color = subtextColor)
                                }
                            }
                            Switch(
                                checked = whiteboardAutoStylusMode,
                                onCheckedChange = {
                                    whiteboardAutoStylusMode = it
                                    repository.whiteboardAutoStylusMode = it
                                },
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Color.White,
                                    checkedTrackColor = MaterialTheme.colorScheme.primary
                                )
                            )
                        }

                        // Divider
                        HorizontalDivider(color = dividerColor, thickness = 0.5.dp)

                        // Slider 2: Highlighter Opacity (Alpha)
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                    Icon(Icons.Outlined.Brush, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                    Text("Highlighter Opacity", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = primaryTextColor)
                                }
                                Text("${(whiteboardHighlighterAlpha * 100).toInt()}%", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                            }
                            Slider(
                                value = whiteboardHighlighterAlpha,
                                onValueChange = {
                                    whiteboardHighlighterAlpha = it
                                    repository.whiteboardHighlighterAlpha = it
                                },
                                valueRange = 0.15f..0.85f,
                                colors = SliderDefaults.colors(
                                    thumbColor = MaterialTheme.colorScheme.primary,
                                    activeTrackColor = MaterialTheme.colorScheme.primary,
                                    inactiveTrackColor = MaterialTheme.colorScheme.outlineVariant
                                )
                            )
                        }

                        // Divider
                        HorizontalDivider(color = dividerColor, thickness = 0.5.dp)

                        // Selector 3: Default Pen Color
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Icon(Icons.Outlined.ColorLens, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                Column {
                                    Text("Default Pen Color", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = primaryTextColor)
                                    Text("Initial brush color on screen open", fontSize = 11.sp, color = subtextColor)
                                }
                            }
                            
                            val colorPresets = listOf(
                                "DEFAULT" to "Adaptive Contrast",
                                "RED" to "Bright Red",
                                "BLUE" to "Electric Blue",
                                "GREEN" to "Sage Green"
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                colorPresets.forEach { preset ->
                                    val isColorSelected = whiteboardDefaultPenColor == preset.first
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .clip(RoundedCornerShape(8.dp))
                                            .background(if (isColorSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.15f) else inputBgColor)
                                            .border(
                                                width = if (isColorSelected) 1.5.dp else 0.5.dp,
                                                color = if (isColorSelected) MaterialTheme.colorScheme.primary else Color.Transparent,
                                                shape = RoundedCornerShape(8.dp)
                                            )
                                            .clickable {
                                                whiteboardDefaultPenColor = preset.first
                                                repository.whiteboardDefaultPenColor = preset.first
                                            }
                                            .padding(vertical = 8.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = preset.second.split(" ").last(),
                                            fontSize = 11.sp,
                                            fontWeight = if (isColorSelected) FontWeight.Bold else FontWeight.Normal,
                                            color = if (isColorSelected) MaterialTheme.colorScheme.primary else primaryTextColor
                                        )
                                    }
                                }
                            }
                        }

                        // Divider
                        HorizontalDivider(color = dividerColor, thickness = 0.5.dp)

                        // Selector: Toolbar Position
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Icon(Icons.Outlined.OpenWith, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                Column {
                                    Text("Toolbar Position", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = primaryTextColor)
                                    Text("Where the drawing control bar is placed", fontSize = 11.sp, color = subtextColor)
                                }
                            }
                            
                            val positionOptions = listOf(
                                "LEFT" to "Left",
                                "RIGHT" to "Right",
                                "TOP" to "Top",
                                "BOTTOM" to "Bottom",
                                "FLOATING" to "Float"
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                positionOptions.forEach { opt ->
                                    val isSelected = whiteboardToolbarPosition == opt.first
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .clip(RoundedCornerShape(8.dp))
                                            .background(if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.15f) else inputBgColor)
                                            .border(
                                                width = if (isSelected) 1.5.dp else 0.5.dp,
                                                color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent,
                                                shape = RoundedCornerShape(8.dp)
                                            )
                                            .clickable {
                                                whiteboardToolbarPosition = opt.first
                                                repository.whiteboardToolbarPosition = opt.first
                                            }
                                            .padding(vertical = 8.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = opt.second,
                                            fontSize = 10.sp,
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                            color = if (isSelected) MaterialTheme.colorScheme.primary else primaryTextColor
                                        )
                                    }
                                }
                            }
                        }

                        // Divider
                        HorizontalDivider(color = dividerColor, thickness = 0.5.dp)

                        // Selector helper function
                        @Composable
                        fun GestureActionSelector(
                            title: String,
                            description: String,
                            currentAction: String,
                            icon: androidx.compose.ui.graphics.vector.ImageVector,
                            onActionSelected: (String) -> Unit
                        ) {
                            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                    Icon(icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                    Column {
                                        Text(title, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = primaryTextColor)
                                        Text(description, fontSize = 11.sp, color = subtextColor)
                                    }
                                }
                                val options = listOf(
                                    "CLEAR" to "Clear Canvas",
                                    "UNDO" to "Undo Stroke",
                                    "TOGGLE" to "Toggle Canvas",
                                    "NONE" to "Disabled"
                                )
                                Row(
                                    modifier = Modifier.fillMaxWidth().padding(top = 2.dp),
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    options.forEach { opt ->
                                        val isSelected = currentAction == opt.first
                                        Box(
                                            modifier = Modifier
                                                .weight(1f)
                                                .clip(RoundedCornerShape(8.dp))
                                                .background(if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.15f) else inputBgColor)
                                                .border(
                                                    width = if (isSelected) 1.5.dp else 0.5.dp,
                                                    color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent,
                                                    shape = RoundedCornerShape(8.dp)
                                                )
                                                .clickable { onActionSelected(opt.first) }
                                                .padding(vertical = 8.dp),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = opt.second.split(" ").first(),
                                                fontSize = 10.sp,
                                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                                color = if (isSelected) MaterialTheme.colorScheme.primary else primaryTextColor
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        GestureActionSelector(
                            title = "One-Finger Double Tap Action",
                            description = "Action when double-tapping with one finger",
                            currentAction = whiteboardOneFingerDoubleTapAction,
                            icon = Icons.Outlined.Gesture,
                            onActionSelected = {
                                whiteboardOneFingerDoubleTapAction = it
                                repository.whiteboardOneFingerDoubleTapAction = it
                            }
                        )

                        // Divider
                        HorizontalDivider(color = dividerColor, thickness = 0.5.dp)
                        GestureActionSelector(
                            title = "Two-Finger Single Tap Action",
                            description = "Action when single-tapping with two fingers",
                            currentAction = whiteboardTwoFingerSingleTapAction,
                            icon = Icons.Outlined.CleaningServices,
                            onActionSelected = {
                                whiteboardTwoFingerSingleTapAction = it
                                repository.whiteboardTwoFingerSingleTapAction = it
                            }
                        )

                        // Divider
                        HorizontalDivider(color = dividerColor, thickness = 0.5.dp)
                        GestureActionSelector(
                            title = "Two-Finger Double Tap Action",
                            description = "Action when double-tapping with two fingers",
                            currentAction = whiteboardTwoFingerDoubleTapAction,
                            icon = Icons.Outlined.CleaningServices,
                            onActionSelected = {
                                whiteboardTwoFingerDoubleTapAction = it
                                repository.whiteboardTwoFingerDoubleTapAction = it
                            }
                        )

                        // Divider
                        HorizontalDivider(color = dividerColor, thickness = 0.5.dp)
                        GestureActionSelector(
                            title = "Three-Finger Single Tap Action",
                            description = "Action when single-tapping with three fingers",
                            currentAction = whiteboardThreeFingerSingleTapAction,
                            icon = Icons.Outlined.Gesture,
                            onActionSelected = {
                                whiteboardThreeFingerSingleTapAction = it
                                repository.whiteboardThreeFingerSingleTapAction = it
                            }
                        )

                        // Divider
                        HorizontalDivider(color = dividerColor, thickness = 0.5.dp)
                        GestureActionSelector(
                            title = "Three-Finger Double Tap Action",
                            description = "Action when double-tapping with three fingers",
                            currentAction = whiteboardThreeFingerDoubleTapAction,
                            icon = Icons.Outlined.Gesture,
                            onActionSelected = {
                                whiteboardThreeFingerDoubleTapAction = it
                                repository.whiteboardThreeFingerDoubleTapAction = it
                            }
                        )
                    }
                }
            }

            // ── STUDY GOAL & LANGUAGE ──────────────────────────────────────────
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                SectionLabel("STUDY GOAL & LANGUAGE", isDarkMode)
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = cardColor),
                    border = BorderStroke(1.dp, cardBorderColor),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        // Daily Mastery Goal
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Icon(Icons.Outlined.Bolt, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                Text("Daily Mastery Goal", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = primaryTextColor)
                            }
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                BasicTextField(
                                    value = if (dailyMasteryGoal == 0) "" else dailyMasteryGoal.toString(),
                                    onValueChange = { newVal ->
                                        val filtered = newVal.filter { it.isDigit() }
                                        if (filtered.length <= 4) {
                                            val parsed = filtered.toIntOrNull() ?: 0
                                            dailyMasteryGoal = parsed
                                            repository.questionLimit = parsed
                                        }
                                    },
                                    textStyle = androidx.compose.ui.text.TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = primaryTextColor,
                                        textAlign = TextAlign.Center
                                    ),
                                    modifier = Modifier
                                        .width(60.dp)
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(inputBgColor)
                                        .padding(horizontal = 8.dp, vertical = 6.dp),
                                    keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(
                                        keyboardType = androidx.compose.ui.text.input.KeyboardType.Number
                                    )
                                )
                                Text("items", fontSize = 12.sp, color = subtextColor)
                            }
                        }

                        // Language selector
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Icon(Icons.Outlined.Translate, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                Text("Language", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = primaryTextColor)
                            }
                            var langExpanded by remember { mutableStateOf(false) }
                            Box {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(inputBgColor)
                                        .clickable { langExpanded = true }
                                        .padding(horizontal = 12.dp, vertical = 6.dp)
                                ) {
                                    Text(currentLanguage.displayName, fontSize = 13.sp, fontWeight = FontWeight.Medium, color = primaryTextColor)
                                }
                                DropdownMenu(expanded = langExpanded, onDismissRequest = { langExpanded = false }) {
                                    AppLanguage.values().forEach { lang ->
                                        DropdownMenuItem(text = { Text(lang.displayName) }, onClick = {
                                            com.example.flashcardapp.data.TranslationManager.setLanguage(lang)
                                            repository.appLanguage = lang.code
                                            langExpanded = false
                                        })
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // ── BACKUP & SYNCHRONIZATION ──────────────────────────────────────
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                SectionLabel("BACKUP & SYNCHRONIZATION", isDarkMode)
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = cardColor),
                    border = BorderStroke(1.dp, cardBorderColor),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        // Wi-Fi Sync Engine Row
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Icon(Icons.Outlined.Wifi, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                Column {
                                    Text("Local Wi-Fi Sync Engine", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = primaryTextColor)
                                    Text("Secure database mirroring across devices", fontSize = 11.sp, color = subtextColor)
                                }
                            }
                            Button(
                                onClick = { showSyncScreen = true },
                                shape = RoundedCornerShape(8.dp),
                                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f), contentColor = MaterialTheme.colorScheme.primary)
                            ) {
                                Text("Open Engine", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            }
                        }

                        HorizontalDivider(color = dividerColor, thickness = 0.5.dp)

                        // SAF Folder Picker Row
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp),
                                modifier = Modifier.weight(1f)
                            ) {
                                Icon(Icons.Outlined.Folder, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                Column {
                                    Text("Backup Folder (SAF)", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = primaryTextColor)
                                    val folderLabel = if (backupSafUri != null) {
                                        val uriParts = Uri.parse(backupSafUri).lastPathSegment ?: "Configured Directory"
                                        "Saved: $uriParts"
                                    } else {
                                        "No folder selected"
                                    }
                                    Text(folderLabel, fontSize = 11.sp, color = subtextColor)
                                }
                            }
                            Button(
                                onClick = { backupDirPickerLauncher.launch(null) },
                                shape = RoundedCornerShape(8.dp),
                                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f), contentColor = MaterialTheme.colorScheme.primary)
                            ) {
                                Text("Choose Directory", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            }
                        }

                        HorizontalDivider(color = dividerColor, thickness = 0.5.dp)

                        // Auto Daily Backup Row
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Icon(Icons.Outlined.CloudUpload, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                Column {
                                    Text("Auto Daily Backup", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = primaryTextColor)
                                    Text("Backup automatically at midnight daily", fontSize = 11.sp, color = subtextColor)
                                }
                            }
                            Switch(
                                checked = backupInterval == "DAILY",
                                onCheckedChange = { isChecked ->
                                    val newInterval = if (isChecked) "DAILY" else "NONE"
                                    repository.backupInterval = newInterval
                                    backupInterval = newInterval
                                    com.example.flashcardapp.data.backup.BackupScheduler.updateSchedule(context)
                                    if (isChecked && backupSafUri == null) {
                                        android.widget.Toast.makeText(context, "Please configure backup folder first!", android.widget.Toast.LENGTH_LONG).show()
                                    }
                                },
                                colors = SwitchDefaults.colors(checkedThumbColor = MaterialTheme.colorScheme.primary)
                            )
                        }

                        HorizontalDivider(color = dividerColor, thickness = 0.5.dp)

                        // Manual actions (Backup Now, Restore Backup)
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Button(
                                onClick = {
                                    if (backupSafUri == null) {
                                        android.widget.Toast.makeText(context, "Configure backup folder first!", android.widget.Toast.LENGTH_SHORT).show()
                                        return@Button
                                    }
                                    coroutineScope.launch {
                                        isBackingUp = true
                                        val success = withContext(kotlinx.coroutines.Dispatchers.IO) {
                                            try {
                                                val treeUri = Uri.parse(backupSafUri)
                                                val docDir = androidx.documentfile.provider.DocumentFile.fromTreeUri(context, treeUri)
                                                if (docDir == null || !docDir.exists() || !docDir.canWrite()) return@withContext false
                                                
                                                val timestamp = java.text.SimpleDateFormat("yyyyMMdd_HHmmss", java.util.Locale.getDefault()).format(java.util.Date())
                                                val backupFileName = "ankiprep_backup_$timestamp.zip"
                                                val newFile = docDir.createFile("application/zip", backupFileName) ?: return@withContext false
                                                
                                                context.contentResolver.openOutputStream(newFile.uri)?.use { outputStream ->
                                                    com.example.flashcardapp.data.backup.BackupRestoreUtils.exportBackup(context, outputStream)
                                                } ?: false
                                            } catch (e: Exception) {
                                                false
                                            }
                                        }
                                        isBackingUp = false
                                        if (success) {
                                            android.widget.Toast.makeText(context, "Backup created successfully!", android.widget.Toast.LENGTH_SHORT).show()
                                        } else {
                                            android.widget.Toast.makeText(context, "Backup failed", android.widget.Toast.LENGTH_SHORT).show()
                                        }
                                    }
                                },
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(10.dp),
                                enabled = !isBackingUp,
                                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f), contentColor = MaterialTheme.colorScheme.primary)
                            ) {
                                Icon(Icons.Outlined.Save, contentDescription = null, modifier = Modifier.size(16.dp))
                                Spacer(Modifier.width(6.dp))
                                Text(if (isBackingUp) "Backing up..." else "Backup Now", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            }

                            Button(
                                onClick = {
                                    restoreFilePickerLauncher.launch(arrayOf("application/zip"))
                                },
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(10.dp),
                                enabled = !isRestoring,
                                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary.copy(alpha = 0.1f), contentColor = MaterialTheme.colorScheme.secondary)
                            ) {
                                Icon(Icons.Outlined.Restore, contentDescription = null, modifier = Modifier.size(16.dp))
                                Spacer(Modifier.width(6.dp))
                                Text(if (isRestoring) "Restoring..." else "Restore Backup", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }

            Spacer(Modifier.height(8.dp))

            // ── Footer ────────────────────────────────────────────────────────
            var tapCount by remember { mutableStateOf(0) }
            var showPasswordDialog by remember { mutableStateOf(false) }
            val footerInteractionSource = remember { androidx.compose.foundation.interaction.MutableInteractionSource() }

            Text(
                text = "Made with 💖 in INDIA.",
                fontSize = 12.sp,
                color = subtextColor,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        interactionSource = footerInteractionSource,
                        indication = null
                    ) {
                        tapCount++
                        if (tapCount == 5) {
                            android.widget.Toast.makeText(context, "2 more taps", android.widget.Toast.LENGTH_SHORT).show()
                        } else if (tapCount == 6) {
                            android.widget.Toast.makeText(context, "1 more tap", android.widget.Toast.LENGTH_SHORT).show()
                        } else if (tapCount >= 7) {
                            tapCount = 0
                            android.widget.Toast.makeText(context, "enter the secret code", android.widget.Toast.LENGTH_SHORT).show()
                            showPasswordDialog = true
                        }
                    },
                textAlign = TextAlign.Center
            )

            if (showPasswordDialog) {
                var passwordInput by remember { mutableStateOf("") }
                AlertDialog(
                    onDismissRequest = { showPasswordDialog = false },
                    title = { Text("Unlock Premium", fontWeight = FontWeight.Bold) },
                    text = {
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            Text("Enter the password to activate premium features.")
                            OutlinedTextField(
                                value = passwordInput,
                                onValueChange = { passwordInput = it },
                                label = { Text("Password") },
                                singleLine = true,
                                visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation(),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                                    focusedLabelColor = MaterialTheme.colorScheme.primary
                                )
                            )
                        }
                    },
                    confirmButton = {
                        Button(
                            onClick = {
                                val hash = sha256(passwordInput.trim())
                                if (hash == "870dc23d21836b97b58a7753922edc8512764e83c02586f3d8f14c11f760550b" ||
                                    hash == "de5ba444d0d9904310a3bf65fffeca15c520a1eaea937c4c13672551e632ffae") {
                                    sharedPrefs.edit().putBoolean("is_premium", true).apply()
                                    repository.isPremium = true
                                    android.widget.Toast.makeText(context, "Premium Unlocked! 🎉", android.widget.Toast.LENGTH_SHORT).show()
                                    showPasswordDialog = false
                                } else {
                                    android.widget.Toast.makeText(context, "Invalid password", android.widget.Toast.LENGTH_SHORT).show()
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                        ) {
                            Text("Activate")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { showPasswordDialog = false }) {
                            Text("Cancel", color = MaterialTheme.colorScheme.primary)
                        }
                    }
                )
            }

            Spacer(Modifier.height(24.dp))
        }
    }
}

// ── Section Label ─────────────────────────────────────────────────────────────
@Composable
private fun SectionLabel(text: String, isDarkMode: Boolean = false) {
    Text(
        text = text,
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        color = if (isDarkMode) MaterialTheme.colorScheme.primary else Color(0xFF546E7A),
        letterSpacing = 1.2.sp
    )
}

// ── Preset Dropdown with Manual Input helper ─────────────────────────────────
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PresetDropdownWithManualInput(
    label: String,
    value: Int,
    presets: List<Int>,
    presetLabels: List<String>,
    customLabel: String,
    maxCustomValue: Int = 500,
    onValueChange: (Int) -> Unit,
    tintColor: Color,
    isDarkMode: Boolean = false
) {
    var expanded by remember { mutableStateOf(false) }
    val isPreset = value in presets || value == 0
    var customText by remember(value) {
        mutableStateOf(if (!isPreset && value > 0) value.toString() else "")
    }

    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(label, fontSize = 14.sp, color = if (isDarkMode) MaterialTheme.colorScheme.onSurface else Color(0xFF263238))
            Text(
                text = when {
                    value == 0 -> "All / Unlimited"
                    else -> "$value"
                },
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = tintColor
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.weight(1f)) {
                OutlinedButton(
                    onClick = { expanded = true },
                    modifier = Modifier.fillMaxWidth().height(48.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = tintColor),
                    border = BorderStroke(1.dp, if (isDarkMode) MaterialTheme.colorScheme.outlineVariant else Color(0xFFE8E2EC))
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = when {
                                value == 0 -> "All"
                                value in presets -> "$value"
                                else -> "Custom"
                            },
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Icon(Icons.Filled.ArrowDropDown, null, tint = tintColor)
                    }
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    presets.forEachIndexed { index, preset ->
                        DropdownMenuItem(
                            text = { Text(presetLabels[index]) },
                            onClick = {
                                onValueChange(preset)
                                expanded = false
                            }
                        )
                    }
                    DropdownMenuItem(
                        text = { Text("Unlimited / All") },
                        onClick = {
                            onValueChange(0)
                            expanded = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Custom...") },
                        onClick = {
                            expanded = false
                        }
                    )
                }
            }

            OutlinedTextField(
                value = customText,
                onValueChange = { text ->
                    val clean = text.filter { it.isDigit() }
                    customText = clean
                    val num = clean.toIntOrNull() ?: 0
                    val bounded = if (num > maxCustomValue) maxCustomValue else num
                    if (clean.isNotEmpty()) {
                        onValueChange(bounded)
                    } else {
                        onValueChange(presets.firstOrNull() ?: 20)
                    }
                },
                label = { Text(customLabel) },
                keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(keyboardType = androidx.compose.ui.text.input.KeyboardType.Number),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = tintColor,
                    focusedLabelColor = tintColor,
                    unfocusedBorderColor = if (isDarkMode) MaterialTheme.colorScheme.outlineVariant else Color(0xFFE8E2EC),
                    unfocusedLabelColor = if (isDarkMode) MaterialTheme.colorScheme.onSurfaceVariant else Color.Gray,
                    focusedTextColor = if (isDarkMode) MaterialTheme.colorScheme.onSurface else Color.Black,
                    unfocusedTextColor = if (isDarkMode) MaterialTheme.colorScheme.onSurface else Color.Black
                ),
                modifier = Modifier.weight(1f).height(48.dp),
                singleLine = true,
                textStyle = androidx.compose.ui.text.TextStyle(fontSize = 13.sp)
            )
        }
    }
}

// ── Study Mode Card helper component ─────────────────────────────────────────
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun StudyModeCard(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    headerBg: Color,
    textColor: Color,
    questionLimit: Int,
    onQuestionLimitChange: (Int) -> Unit,
    presets: List<Int>,
    presetLabels: List<String>,
    maxCustomValue: Int = 500,
    customLabel: String = "Manual (1-500)",
    timeLimitSeconds: Int,
    onTimeLimitSecondsChange: (Int) -> Unit,
    timePresets: List<Int>,
    timePresetLabels: List<String>,
    timeCustomLabel: String = "Manual Secs",
    selectedAlgorithm: String,
    algoExpanded: Boolean,
    onAlgoExpandedChange: (Boolean) -> Unit,
    onAlgoSelected: (String) -> Unit,
    algoOptions: List<String>,
    isPracticeMode: Boolean,
    isDarkMode: Boolean = false
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = if (isDarkMode) MaterialTheme.colorScheme.surfaceVariant else Color.White),
        border = BorderStroke(1.dp, if (isDarkMode) MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f) else Color(0xFFECEFF1)),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(headerBg)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(icon, contentDescription = null, tint = textColor, modifier = Modifier.size(18.dp))
                Text(title, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = textColor)
            }

            Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                PresetDropdownWithManualInput(
                    label = "Question Count",
                    value = questionLimit,
                    presets = presets,
                    presetLabels = presetLabels,
                    customLabel = customLabel,
                    maxCustomValue = maxCustomValue,
                    onValueChange = onQuestionLimitChange,
                    tintColor = textColor,
                    isDarkMode = isDarkMode
                )

                if (!isPracticeMode) {
                    PresetDropdownWithManualInput(
                        label = "Time Limit per Question",
                        value = timeLimitSeconds,
                        presets = timePresets,
                        presetLabels = timePresetLabels,
                        customLabel = timeCustomLabel,
                        maxCustomValue = 600,
                        onValueChange = onTimeLimitSecondsChange,
                        tintColor = textColor,
                        isDarkMode = isDarkMode
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Learning Algorithm", fontSize = 14.sp, color = if (isDarkMode) MaterialTheme.colorScheme.onSurface else Color(0xFF263238))
                    Box {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(if (isDarkMode) MaterialTheme.colorScheme.surface else Color(0xFFF5F7F8))
                                .clickable { onAlgoExpandedChange(true) }
                                .padding(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Text(selectedAlgorithm, fontSize = 13.sp, fontWeight = FontWeight.Medium, color = if (isDarkMode) MaterialTheme.colorScheme.onSurface else textColor)
                        }
                        DropdownMenu(expanded = algoExpanded, onDismissRequest = { onAlgoExpandedChange(false) }) {
                            algoOptions.forEach { opt ->
                                DropdownMenuItem(text = { Text(opt) }, onClick = {
                                    onAlgoSelected(opt)
                                    onAlgoExpandedChange(false)
                                })
                            }
                        }
                    }
                }
            }
        }
    }
}


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
import coil.compose.AsyncImage
import androidx.compose.ui.layout.ContentScale

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
    var dailyMasteryGoal by remember { mutableStateOf(repository.questionLimit) }
    var defaultAlgorithm by remember { mutableStateOf(repository.defaultAlgorithm) }
    var hapticEnabled by remember { mutableStateOf(repository.vibrationEnabled) }
    var showExplanations by remember { mutableStateOf(repository.showExplanations) }

    var showGuideModal by remember { mutableStateOf(false) }

    // Google font search state
    var googleFontQuery by remember { mutableStateOf("") }

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

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F7F6)), // Light mint-grey background
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = 600.dp)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
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
                            .background(Color(0xFFE0F2F1))
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
                            Icon(Icons.Filled.Person, contentDescription = "Profile", tint = Color(0xFF004D40), modifier = Modifier.size(22.dp))
                        }
                    }
                    Text("AnkiPrep", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF004D40))
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
                Text("Settings", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color(0xFF263238))
                Spacer(Modifier.height(4.dp))
                Text("Manage your professional learning environment.", fontSize = 14.sp, color = Color(0xFF78909C))
            }

            // ── How to Use Guide Card ─────────────────────────────────────────
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F2F1)),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("How to Use Guide", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF004D40))
                    Text(
                        "Master the \"Spine\" system, daily mastery goals, and active recall triggers for optimal exam preparation.",
                        fontSize = 13.sp, color = Color(0xFF004D40).copy(alpha = 0.8f), lineHeight = 19.sp
                    )
                    Spacer(Modifier.height(4.dp))
                    Button(
                        onClick = { showGuideModal = true },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF004D40)),
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
                SectionLabel("TYPOGRAPHY & FONTS")
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = BorderStroke(1.dp, Color(0xFFECEFF1)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Icon(Icons.Outlined.FontDownload, contentDescription = null, tint = Color(0xFF004D40))
                                Column {
                                    Text("Active Font", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color(0xFF263238))
                                    Text(
                                        text = if (!customFontPath.isNullOrEmpty()) "Custom Font (Active)" else "Inter (Default System Font)",
                                        fontSize = 12.sp,
                                        color = Color(0xFF78909C)
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
                                        .background(Color(0xFFE0F2F1))
                                        .padding(horizontal = 8.dp, vertical = 2.dp)
                                ) {
                                    Text("Active", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF004D40))
                                }
                            }
                        }

                        // Monospace preview box
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFFF5F7F8))
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "The quick brown fox jumps over the lazy dog.",
                                fontSize = 14.sp,
                                fontStyle = FontStyle.Italic,
                                color = Color(0xFF455A64),
                                textAlign = TextAlign.Center
                            )
                        }

                        val coroutineScope = rememberCoroutineScope()
                        val fontFilePickerLauncher = rememberLauncherForActivityResult(
                            contract = androidx.activity.result.contract.ActivityResultContracts.GetContent()
                        ) { uri: android.net.Uri? ->
                            if (uri != null) {
                                coroutineScope.launch(kotlinx.coroutines.Dispatchers.IO) {
                                    try {
                                        val file = java.io.File(context.filesDir, "custom_font.ttf")
                                        context.contentResolver.openInputStream(uri)?.use { input ->
                                            file.outputStream().use { output ->
                                                input.copyTo(output)
                                            }
                                        }
                                        repository.customFontPath = file.absolutePath
                                        customFontPath = file.absolutePath
                                        withContext(kotlinx.coroutines.Dispatchers.Main) {
                                            onFontFamilyTypeChange("CUSTOM_" + System.currentTimeMillis())
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
                                Icon(Icons.Outlined.FolderOpen, contentDescription = null, tint = Color(0xFF004D40), modifier = Modifier.size(18.dp))
                                Text("Load Local Font File (.ttf/.otf)", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF004D40))
                            }
                            Button(
                                onClick = { fontFilePickerLauncher.launch("*/*") },
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF004D40)),
                                contentPadding = PaddingValues(horizontal = 12.dp),
                                modifier = Modifier.height(28.dp),
                                shape = RoundedCornerShape(6.dp)
                            ) {
                                Text("Choose File", fontSize = 11.sp, color = Color.White, fontWeight = FontWeight.Bold)
                            }
                        }

                        HorizontalDivider(color = Color(0xFFECEFF1))

                        // Download Label
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(Icons.Outlined.AddCircleOutline, contentDescription = null, tint = Color(0xFF004D40), modifier = Modifier.size(18.dp))
                            Text("Download & Load Custom Font (.ttf)", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF004D40))
                        }

                        // Download Input Row
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFFF5F7F8))
                                .padding(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Icon(Icons.Filled.Search, contentDescription = null, tint = Color(0xFF90A4AE))
                            BasicTextField(
                                value = googleFontQuery,
                                onValueChange = { googleFontQuery = it },
                                modifier = Modifier.weight(1f),
                                decorationBox = { innerTextField ->
                                    if (googleFontQuery.isEmpty()) {
                                        Text("Enter Font URL (e.g. https://domain.com/font.ttf)...", color = Color(0xFF90A4AE), fontSize = 11.sp)
                                    }
                                    innerTextField()
                                }
                            )
                            Button(
                                onClick = {
                                    if (googleFontQuery.isNotEmpty()) {
                                        coroutineScope.launch(kotlinx.coroutines.Dispatchers.IO) {
                                            try {
                                                val url = java.net.URL(googleFontQuery)
                                                val connection = url.openConnection() as java.net.HttpURLConnection
                                                connection.connectTimeout = 15000
                                                connection.readTimeout = 15000
                                                connection.connect()
                                                if (connection.responseCode == 200) {
                                                    val file = java.io.File(context.filesDir, "custom_font.ttf")
                                                    connection.inputStream.use { input ->
                                                        file.outputStream().use { output ->
                                                            input.copyTo(output)
                                                        }
                                                    }
                                                    repository.customFontPath = file.absolutePath
                                                    customFontPath = file.absolutePath
                                                    withContext(kotlinx.coroutines.Dispatchers.Main) {
                                                        onFontFamilyTypeChange("CUSTOM_" + System.currentTimeMillis())
                                                        android.widget.Toast.makeText(context, "Font downloaded successfully", android.widget.Toast.LENGTH_SHORT).show()
                                                    }
                                                } else {
                                                    withContext(kotlinx.coroutines.Dispatchers.Main) {
                                                        android.widget.Toast.makeText(context, "HTTP Error: ${connection.responseCode}", android.widget.Toast.LENGTH_SHORT).show()
                                                    }
                                                }
                                            } catch (e: java.lang.Exception) {
                                                withContext(kotlinx.coroutines.Dispatchers.Main) {
                                                    android.widget.Toast.makeText(context, "Failed to load font: ${e.message}", android.widget.Toast.LENGTH_LONG).show()
                                                }
                                            }
                                        }
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF004D40)),
                                contentPadding = PaddingValues(horizontal = 12.dp),
                                modifier = Modifier.height(28.dp),
                                shape = RoundedCornerShape(6.dp)
                            ) {
                                Text("Download", fontSize = 11.sp, color = Color.White, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }

            // ── QUIZ & STUDY MODES ────────────────────────────────────────────
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                SectionLabel("QUIZ & STUDY MODES")

                // Practice Mode Card
                StudyModeCard(
                    title = "PRACTICE MODE",
                    icon = Icons.Outlined.DirectionsRun,
                    headerBg = Color(0xFFE0F2F1),
                    textColor = Color(0xFF004D40),
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
                    isPracticeMode = true
                )

                // Mock Test Card
                StudyModeCard(
                    title = "MOCK TEST",
                    icon = Icons.Outlined.Alarm,
                    headerBg = Color(0xFFECEFF1),
                    textColor = Color(0xFF37474F),
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
                    isPracticeMode = false
                )

                // Smart Revision Card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = BorderStroke(1.dp, Color(0xFFECEFF1)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                ) {
                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFECEFF1))
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(Icons.Outlined.AutoAwesome, contentDescription = null, tint = Color(0xFF455A64), modifier = Modifier.size(18.dp))
                            Text("SMART REVISION", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF455A64))
                        }

                        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                            // Slider
                            Column {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text("Daily Review Batch", fontSize = 14.sp, color = Color(0xFF263238))
                                    Text("${revisionBatchSize.toInt()}", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF455A64))
                                }
                                Slider(
                                    value = revisionBatchSize,
                                    onValueChange = { revisionBatchSize = it },
                                    valueRange = 5f..100f,
                                    colors = SliderDefaults.colors(
                                        thumbColor = Color(0xFF455A64),
                                        activeTrackColor = Color(0xFF455A64),
                                        inactiveTrackColor = Color(0xFFCFD8DC)
                                    )
                                )
                            }

                            // Algorithm Dropdown
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("Algorithm", fontSize = 14.sp, color = Color(0xFF263238))
                                Box {
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(8.dp))
                                            .background(Color(0xFFECEFF1))
                                            .clickable { revisionAlgoExpanded = true }
                                            .padding(horizontal = 12.dp, vertical = 6.dp)
                                    ) {
                                        Text(revisionAlgorithm, fontSize = 13.sp, fontWeight = FontWeight.Medium, color = Color(0xFF455A64))
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
                SectionLabel("VISUALS & EXPERIENCE")
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = BorderStroke(1.dp, Color(0xFFECEFF1)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        // Appearance
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Icon(Icons.Outlined.Contrast, contentDescription = null, tint = Color(0xFF004D40))
                                Column {
                                    Text("Appearance", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF263238))
                                    Text("Switch between Dark and Light mode", fontSize = 11.sp, color = Color(0xFF78909C))
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
                                    checkedTrackColor = Color(0xFF004D40)
                                )
                            )
                        }

                        // Haptic Feedback
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Icon(Icons.Outlined.Vibration, contentDescription = null, tint = Color(0xFF004D40))
                                Column {
                                    Text("Haptic Feedback", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF263238))
                                    Text("Vibrate on mastery achievements", fontSize = 11.sp, color = Color(0xFF78909C))
                                }
                            }
                            Switch(
                                checked = hapticEnabled,
                                onCheckedChange = {
                                    hapticEnabled = it
                                    repository.vibrationEnabled = it
                                },
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Color.White,
                                    checkedTrackColor = Color(0xFF004D40)
                                )
                            )
                        }

                        // Show Explanations
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Icon(Icons.Outlined.LibraryBooks, contentDescription = null, tint = Color(0xFF004D40))
                                Column {
                                    Text("Show Explanations", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF263238))
                                    Text("Auto-reveal logic after answering", fontSize = 11.sp, color = Color(0xFF78909C))
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
                                    checkedTrackColor = Color(0xFF004D40)
                                )
                            )
                        }

                        // Theme Color Palette Selection
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Icon(Icons.Outlined.Palette, contentDescription = null, tint = Color(0xFF004D40))
                                Column {
                                    Text("Theme Color", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF263238))
                                    Text("Personalize your workspace palette", fontSize = 11.sp, color = Color(0xFF78909C))
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
                                                color = if (isSelected) Color(0xFF263238) else Color.Transparent,
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

            // ── STUDY GOAL & LANGUAGE ──────────────────────────────────────────
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                SectionLabel("STUDY GOAL & LANGUAGE")
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = BorderStroke(1.dp, Color(0xFFECEFF1)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                        // Daily Mastery Goal
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Icon(Icons.Outlined.Bolt, contentDescription = null, tint = Color(0xFF004D40))
                                Text("Daily Mastery Goal", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF263238))
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
                                        color = Color(0xFF263238),
                                        textAlign = TextAlign.Center
                                    ),
                                    modifier = Modifier
                                        .width(60.dp)
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(Color(0xFFF5F7F8))
                                        .padding(horizontal = 8.dp, vertical = 6.dp),
                                    keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(
                                        keyboardType = androidx.compose.ui.text.input.KeyboardType.Number
                                    )
                                )
                                Text("items", fontSize = 12.sp, color = Color(0xFF78909C))
                            }
                        }

                        // Language selector
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Icon(Icons.Outlined.Translate, contentDescription = null, tint = Color(0xFF004D40))
                                Text("Language", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF263238))
                            }
                            var langExpanded by remember { mutableStateOf(false) }
                            Box {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(Color(0xFFF5F7F8))
                                        .clickable { langExpanded = true }
                                        .padding(horizontal = 12.dp, vertical = 6.dp)
                                ) {
                                    Text(currentLanguage.displayName, fontSize = 13.sp, fontWeight = FontWeight.Medium, color = Color(0xFF263238))
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

            Spacer(Modifier.height(8.dp))

            // ── Footer ────────────────────────────────────────────────────────
            Text(
                "Made with 💖 in INDIA.",
                fontSize = 12.sp,
                color = Color(0xFF90A4AE),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(100.dp))
        }
    }
}

// ── Section Label ─────────────────────────────────────────────────────────────
@Composable
private fun SectionLabel(text: String) {
    Text(
        text = text,
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF546E7A),
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
    tintColor: Color
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
            Text(label, fontSize = 14.sp, color = Color(0xFF263238))
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
                    border = BorderStroke(1.dp, Color(0xFFE8E2EC))
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
                    unfocusedBorderColor = Color(0xFFE8E2EC)
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
    isPracticeMode: Boolean
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Color(0xFFECEFF1)),
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

            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                PresetDropdownWithManualInput(
                    label = "Question Count",
                    value = questionLimit,
                    presets = presets,
                    presetLabels = presetLabels,
                    customLabel = customLabel,
                    maxCustomValue = maxCustomValue,
                    onValueChange = onQuestionLimitChange,
                    tintColor = textColor
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
                        tintColor = textColor
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Learning Algorithm", fontSize = 14.sp, color = Color(0xFF263238))
                    Box {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFFF5F7F8))
                                .clickable { onAlgoExpandedChange(true) }
                                .padding(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Text(selectedAlgorithm, fontSize = 13.sp, fontWeight = FontWeight.Medium, color = textColor)
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
                Spacer(Modifier.height(80.dp))
            }
        }
    }
}


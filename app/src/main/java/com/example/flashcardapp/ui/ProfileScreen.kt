package com.example.flashcardapp.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.net.Uri
import android.os.Build
import android.widget.Toast
import com.example.flashcardapp.receiver.ReminderScheduler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.data.SettingsRepository
import com.example.flashcardapp.ui.theme.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileOutputStream
import java.util.Calendar

data class ImportantDate(val label: String, val date: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onBackPressed: () -> Unit
) {
    val context = LocalContext.current
    val settingsRepo = remember { SettingsRepository.getInstance(context) }
    val gson = remember { Gson() }

    // States loaded from settings repository
    var userName by remember { mutableStateOf(settingsRepo.userName) }
    var imagePath by remember { mutableStateOf(settingsRepo.userProfileImageUri) }
    var dateOfBirth by remember { mutableStateOf(settingsRepo.userDateOfBirth) }
    var importantDatesJson by remember { mutableStateOf(settingsRepo.userImportantDatesJson) }

    var reminderEnabled by remember { mutableStateOf(settingsRepo.reminderEnabled) }
    var reminderHour by remember { mutableStateOf(settingsRepo.reminderHour) }
    var reminderMinute by remember { mutableStateOf(settingsRepo.reminderMinute) }
    var reminderDays by remember { mutableStateOf(settingsRepo.reminderDays) }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            ReminderScheduler.scheduleNextReminder(context)
        } else {
            reminderEnabled = false
            settingsRepo.reminderEnabled = false
            Toast.makeText(context, "Notification permission is required for reminders", Toast.LENGTH_SHORT).show()
        }
    }

    // Parse list of important dates
    val importantDatesList = remember(importantDatesJson) {
        try {
            val type = object : TypeToken<List<ImportantDate>>() {}.type
            gson.fromJson<List<ImportantDate>>(importantDatesJson, type) ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    // Temporary input fields for adding a new important date
    var newDateLabel by remember { mutableStateOf("") }
    var newDateValue by remember { mutableStateOf("") }

    // Image Picker Launcher
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            val savedPath = copyUriToInternalStorage(context, it)
            if (savedPath != null) {
                imagePath = savedPath
                settingsRepo.userProfileImageUri = savedPath
            }
        }
    }

    // Helper: decode selected profile picture path
    val bitmap = remember(imagePath) {
        if (imagePath.isNotEmpty()) {
            try {
                val file = File(imagePath)
                if (file.exists()) {
                    android.graphics.BitmapFactory.decodeFile(file.absolutePath)?.asImageBitmap()
                } else {
                    val uri = Uri.parse(imagePath)
                    context.contentResolver.openInputStream(uri)?.use { inputStream ->
                        android.graphics.BitmapFactory.decodeStream(inputStream)?.asImageBitmap()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        } else {
            null
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile Settings", color = TextPrimaryDeep, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = PrimaryPurple)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BackgroundLavender)
            )
        },
        containerColor = BackgroundLavender
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            // ── Profile Photo Section ──
            Box(
                modifier = Modifier
                    .size(130.dp)
                    .clip(CircleShape)
                    .background(Brush.radialGradient(listOf(Color(0xFFEDE7F6), Color(0xFFD1C4E9))))
                    .border(2.dp, PrimaryPurple, CircleShape)
                    .clickable { imagePickerLauncher.launch("image/*") }
            ) {
                if (bitmap != null) {
                    Image(
                        bitmap = bitmap,
                        contentDescription = "Profile Photo",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = "Placeholder",
                        tint = PrimaryPurple,
                        modifier = Modifier
                            .size(72.dp)
                            .align(Alignment.Center)
                    )
                }

                // Small edit badge
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(PrimaryPurple)
                        .align(Alignment.BottomEnd)
                        .border(1.5.dp, Color.White, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Edit,
                        contentDescription = "Edit Profile Pic",
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            // ── Basic Details Form ──
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = CardBackgroundLight),
                border = BorderStroke(1.dp, Color(0xFFE8E2EC))
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Personal Details",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryPurple
                    )

                    OutlinedTextField(
                        value = userName,
                        onValueChange = {
                            userName = it
                            settingsRepo.userName = it
                        },
                        label = { Text("Display Name") },
                        placeholder = { Text("Enter your name") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PrimaryPurple,
                            unfocusedBorderColor = Color(0xFFC7BDD5)
                        )
                    )

                    // DOB Field - Clickable to open DatePickerDialog
                    Box(modifier = Modifier.fillMaxWidth()) {
                        OutlinedTextField(
                            value = dateOfBirth,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Date of Birth") },
                            placeholder = { Text("DD/MM/YYYY") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    showDatePicker(context, dateOfBirth) { selectedDate ->
                                        dateOfBirth = selectedDate
                                        settingsRepo.userDateOfBirth = selectedDate
                                    }
                                },
                            enabled = false, // Disable direct input
                            shape = RoundedCornerShape(16.dp),
                            trailingIcon = {
                                Icon(
                                    imageVector = Icons.Outlined.DateRange,
                                    contentDescription = "Select Date",
                                    tint = PrimaryPurple
                                )
                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                disabledTextColor = TextPrimaryDeep,
                                disabledBorderColor = Color(0xFFC7BDD5),
                                disabledLabelColor = TextSecondaryGray,
                                disabledPlaceholderColor = TextSecondaryGray
                            )
                        )
                        // Layer a fully transparent clickable box on top to guarantee click hits
                        Box(
                            modifier = Modifier
                                .matchParentSize()
                                .clickable {
                                    showDatePicker(context, dateOfBirth) { selectedDate ->
                                        dateOfBirth = selectedDate
                                        settingsRepo.userDateOfBirth = selectedDate
                                    }
                                }
                        )
                    }
                }
            }

            // ── Important Dates & Milestones Section ──
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = CardBackgroundLight),
                border = BorderStroke(1.dp, Color(0xFFE8E2EC))
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Mark Important Dates",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryPurple
                    )

                    // Add Date Sub-Form
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedTextField(
                            value = newDateLabel,
                            onValueChange = { newDateLabel = it },
                            label = { Text("Event Label") },
                            placeholder = { Text("e.g. Exam Date") },
                            modifier = Modifier.weight(1.2f),
                            shape = RoundedCornerShape(12.dp),
                            singleLine = true,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = PrimaryPurple,
                                unfocusedBorderColor = Color(0xFFC7BDD5)
                            )
                        )

                        Box(modifier = Modifier.weight(1f)) {
                            OutlinedTextField(
                                value = newDateValue,
                                onValueChange = {},
                                readOnly = true,
                                label = { Text("Date") },
                                placeholder = { Text("DD/MM/YYYY") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        showDatePicker(context, newDateValue) { selectedDate ->
                                            newDateValue = selectedDate
                                        }
                                    },
                                enabled = false,
                                shape = RoundedCornerShape(12.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    disabledTextColor = TextPrimaryDeep,
                                    disabledBorderColor = Color(0xFFC7BDD5),
                                    disabledLabelColor = TextSecondaryGray,
                                    disabledPlaceholderColor = TextSecondaryGray
                                )
                            )
                            Box(
                                modifier = Modifier
                                    .matchParentSize()
                                    .clickable {
                                        showDatePicker(context, newDateValue) { selectedDate ->
                                            newDateValue = selectedDate
                                        }
                                    }
                            )
                        }

                        IconButton(
                            onClick = {
                                if (newDateLabel.isNotBlank() && newDateValue.isNotBlank()) {
                                    val newList = importantDatesList + ImportantDate(newDateLabel, newDateValue)
                                    val newJson = gson.toJson(newList)
                                    importantDatesJson = newJson
                                    settingsRepo.userImportantDatesJson = newJson
                                    newDateLabel = ""
                                    newDateValue = ""
                                }
                            },
                            modifier = Modifier
                                .size(48.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(PrimaryPurple)
                        ) {
                            Icon(Icons.Outlined.Add, contentDescription = "Add Date", tint = Color.White)
                        }
                    }

                    if (importantDatesList.isNotEmpty()) {
                        HorizontalDivider(color = Color(0xFFEBE3FA), modifier = Modifier.padding(vertical = 4.dp))

                        importantDatesList.forEachIndexed { index, item ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color(0xFFF9F6FC))
                                    .padding(horizontal = 14.dp, vertical = 10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Outlined.DateRange,
                                        contentDescription = "Event icon",
                                        tint = PrimaryPurple,
                                        modifier = Modifier.size(20.dp)
                                    )
                                    Column {
                                        Text(
                                            text = item.label,
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = 14.sp,
                                            color = TextPrimaryDeep
                                        )
                                        Text(
                                            text = item.date,
                                            fontSize = 12.sp,
                                            color = TextSecondaryGray
                                        )
                                    }
                                }

                                IconButton(
                                    onClick = {
                                        val newList = importantDatesList.toMutableList().apply { removeAt(index) }
                                        val newJson = gson.toJson(newList)
                                        importantDatesJson = newJson
                                        settingsRepo.userImportantDatesJson = newJson
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Outlined.Delete,
                                        contentDescription = "Delete Item",
                                        tint = Color(0xFFD81B60),
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // ── Study Reminders Section ──
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = CardBackgroundLight),
                border = BorderStroke(1.dp, Color(0xFFE8E2EC))
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Study Reminders",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryPurple
                            )
                            Text(
                                text = "Receive reminders to review flashcards.",
                                fontSize = 12.sp,
                                color = TextSecondaryGray
                            )
                        }
                        Switch(
                            checked = reminderEnabled,
                            onCheckedChange = { checked ->
                                if (checked) {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                                        val hasPermission = androidx.core.content.ContextCompat.checkSelfPermission(
                                            context,
                                            android.Manifest.permission.POST_NOTIFICATIONS
                                        ) == android.content.pm.PackageManager.PERMISSION_GRANTED

                                        if (!hasPermission) {
                                            permissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
                                            reminderEnabled = true
                                            settingsRepo.reminderEnabled = true
                                        } else {
                                            reminderEnabled = true
                                            settingsRepo.reminderEnabled = true
                                            ReminderScheduler.scheduleNextReminder(context)
                                        }
                                    } else {
                                        reminderEnabled = true
                                        settingsRepo.reminderEnabled = true
                                        ReminderScheduler.scheduleNextReminder(context)
                                    }
                                } else {
                                    reminderEnabled = false
                                    settingsRepo.reminderEnabled = false
                                    ReminderScheduler.scheduleNextReminder(context)
                                }
                            },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                checkedTrackColor = PrimaryPurple,
                                uncheckedThumbColor = Color.Gray,
                                uncheckedTrackColor = Color(0xFFEDE7F6)
                            )
                        )
                    }

                    if (reminderEnabled) {
                        HorizontalDivider(color = Color(0xFFEBE3FA), modifier = Modifier.padding(vertical = 4.dp))

                        // Time Picker Selection Row
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .background(Color(0xFFF9F6FC))
                                .clickable {
                                    showTimePicker(context, reminderHour, reminderMinute) { h, m ->
                                        reminderHour = h
                                        reminderMinute = m
                                        settingsRepo.reminderHour = h
                                        settingsRepo.reminderMinute = m
                                        ReminderScheduler.scheduleNextReminder(context)
                                    }
                                }
                                .padding(horizontal = 16.dp, vertical = 14.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.Notifications,
                                    contentDescription = "Notification Time",
                                    tint = PrimaryPurple,
                                    modifier = Modifier.size(24.dp)
                                )
                                Column {
                                    Text(
                                        text = "Reminder Time",
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 14.sp,
                                        color = TextPrimaryDeep
                                    )
                                    Text(
                                        text = "Select when to get notified",
                                        fontSize = 12.sp,
                                        color = TextSecondaryGray
                                    )
                                }
                            }
                            Text(
                                text = formatTime(reminderHour, reminderMinute),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryPurple
                            )
                        }

                        // Day of week selection chips
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "Repeat on",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = TextPrimaryDeep
                            )
                            val daysOfWeek = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                daysOfWeek.forEach { day ->
                                    val isSelected = reminderDays.contains(day)
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .aspectRatio(1f)
                                            .clip(RoundedCornerShape(10.dp))
                                            .background(if (isSelected) PrimaryPurple else Color(0xFFEDE7F6))
                                            .clickable {
                                                val newDays = if (isSelected) {
                                                    reminderDays - day
                                                } else {
                                                    reminderDays + day
                                                }
                                                reminderDays = newDays
                                                settingsRepo.reminderDays = newDays
                                                ReminderScheduler.scheduleNextReminder(context)
                                            },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = day,
                                            color = if (isSelected) Color.White else PrimaryPurple,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

// Helper: Show standard DatePickerDialog
private fun showDatePicker(context: Context, currentDateStr: String, onDateSelected: (String) -> Unit) {
    val calendar = Calendar.getInstance()
    if (currentDateStr.isNotEmpty()) {
        val parts = currentDateStr.split("/")
        if (parts.size == 3) {
            try {
                val day = parts[0].toInt()
                val month = parts[1].toInt() - 1
                val year = parts[2].toInt()
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, day)
            } catch (e: Exception) {
                // Ignore parsing errors and use default calendar
            }
        }
    }

    DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            onDateSelected("$dayOfMonth/${month + 1}/$year")
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    ).show()
}

// Helper: Show standard TimePickerDialog
private fun showTimePicker(context: Context, initialHour: Int, initialMinute: Int, onTimeSelected: (Int, Int) -> Unit) {
    TimePickerDialog(
        context,
        { _, hour, minute ->
            onTimeSelected(hour, minute)
        },
        initialHour,
        initialMinute,
        false
    ).show()
}

// Helper: Format hour and minute to standard AM/PM format
private fun formatTime(hour: Int, minute: Int): String {
    val amPm = if (hour >= 12) "PM" else "AM"
    val formattedHour = when {
        hour == 0 -> 12
        hour > 12 -> hour - 12
        else -> hour
    }
    return String.format("%02d:%02d %s", formattedHour, minute, amPm)
}

// Helper: Copy chosen Uri to app's private files directory to avoid permission expires
private fun copyUriToInternalStorage(context: Context, uri: Uri): String? {
    return try {
        val inputStream = context.contentResolver.openInputStream(uri) ?: return null
        val fileName = "profile_pic_${System.currentTimeMillis()}.jpg"
        val file = File(context.filesDir, fileName)
        val outputStream = FileOutputStream(file)
        inputStream.use { input ->
            outputStream.use { output ->
                input.copyTo(output)
            }
        }
        file.absolutePath
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

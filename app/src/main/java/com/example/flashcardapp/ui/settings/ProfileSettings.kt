package com.example.flashcardapp.ui.settings

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.flashcardapp.data.SettingsRepository

@Composable
fun ProfileCategoryScreen(
    onNavigateToSubCategory: (SettingsSubCategory) -> Unit
) {
    val context = LocalContext.current
    val repository = remember { SettingsRepository.getInstance(context) }
    val profilePrefs = remember { context.getSharedPreferences("AnkiPrepProfile", Context.MODE_PRIVATE) }
    val goalText = profilePrefs.getString("profile_goal", "Civil Services") ?: "Civil Services"
    val displayName = profilePrefs.getString("profile_name", repository.userName.ifEmpty { "Aaryan Sharma" }) ?: "User"

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        SettingSubheadingCard(
            subCategory = SettingsSubCategory.PROFILE_DETAILS,
            badgeText = displayName,
            onClick = { onNavigateToSubCategory(SettingsSubCategory.PROFILE_DETAILS) }
        )

        SettingSubheadingCard(
            subCategory = SettingsSubCategory.STUDY_TARGETS,
            badgeText = goalText,
            onClick = { onNavigateToSubCategory(SettingsSubCategory.STUDY_TARGETS) }
        )

        SettingSubheadingCard(
            subCategory = SettingsSubCategory.DAILY_REMINDER,
            badgeText = if (repository.reminderEnabled) "${repository.reminderHour}:${String.format("%02d", repository.reminderMinute)}" else "Off",
            onClick = { onNavigateToSubCategory(SettingsSubCategory.DAILY_REMINDER) }
        )
    }
}

@Composable
fun ProfileSubCategoryScreen(
    subCategory: SettingsSubCategory
) {
    val context = LocalContext.current
    val repository = remember { SettingsRepository.getInstance(context) }
    val profilePrefs = remember { context.getSharedPreferences("AnkiPrepProfile", Context.MODE_PRIVATE) }

    when (subCategory) {
        SettingsSubCategory.PROFILE_DETAILS -> {
            var userName by remember { mutableStateOf(profilePrefs.getString("profile_name", repository.userName.ifEmpty { "Aaryan Sharma" }) ?: "") }
            var userBio by remember { mutableStateOf(profilePrefs.getString("profile_bio", "") ?: "") }
            var avatarUriStr by remember { mutableStateOf(profilePrefs.getString("avatar_uri", null)) }

            val avatarPickerLauncher = rememberLauncherForActivityResult(
                ActivityResultContracts.OpenDocument()
            ) { uri ->
                uri?.let {
                    try {
                        context.contentResolver.takePersistableUriPermission(
                            it,
                            android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION
                        )
                    } catch (e: Exception) {}
                    profilePrefs.edit().putString("avatar_uri", it.toString()).apply()
                    repository.userProfileImageUri = it.toString()
                    avatarUriStr = it.toString()
                    Toast.makeText(context, "Avatar updated!", Toast.LENGTH_SHORT).show()
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(88.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primaryContainer)
                                .clickable { avatarPickerLauncher.launch(arrayOf("image/*")) },
                            contentAlignment = Alignment.Center
                        ) {
                            if (!avatarUriStr.isNullOrEmpty()) {
                                AsyncImage(
                                    model = Uri.parse(avatarUriStr),
                                    contentDescription = "Avatar",
                                    modifier = Modifier.fillMaxSize().clip(CircleShape),
                                    contentScale = ContentScale.Crop
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = "Avatar",
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(44.dp)
                                )
                            }
                        }

                        TextButton(onClick = { avatarPickerLauncher.launch(arrayOf("image/*")) }) {
                            Icon(Icons.Outlined.PhotoCamera, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(Modifier.width(6.dp))
                            Text("Change Avatar Photo")
                        }

                        OutlinedTextField(
                            value = userName,
                            onValueChange = {
                                userName = it
                                profilePrefs.edit().putString("profile_name", it).apply()
                                repository.userName = it
                            },
                            label = { Text("Display Name") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        )

                        OutlinedTextField(
                            value = userBio,
                            onValueChange = {
                                userBio = it
                                profilePrefs.edit().putString("profile_bio", it).apply()
                            },
                            label = { Text("Study Bio / Objective") },
                            modifier = Modifier.fillMaxWidth(),
                            maxLines = 3,
                            shape = RoundedCornerShape(12.dp)
                        )
                    }
                }
            }
        }

        SettingsSubCategory.STUDY_TARGETS -> {
            var profileGoal by remember { mutableStateOf(profilePrefs.getString("profile_goal", "Civil Services") ?: "Civil Services") }
            var profileDegree by remember { mutableStateOf(profilePrefs.getString("profile_degree", "Graduate") ?: "Graduate") }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Text(
                            text = "Target Competitive Exam Goal",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        val popularGoals = listOf("Civil Services", "SSC CGL", "Banking", "State PCS", "Other")
                        SegmentedSelector(
                            options = popularGoals,
                            selectedOption = if (profileGoal in popularGoals) profileGoal else "Other",
                            onOptionSelected = {
                                if (it != "Other") {
                                    profileGoal = it
                                    profilePrefs.edit().putString("profile_goal", it).apply()
                                }
                            },
                            labelProvider = { it }
                        )

                        OutlinedTextField(
                            value = profileGoal,
                            onValueChange = {
                                profileGoal = it
                                profilePrefs.edit().putString("profile_goal", it).apply()
                            },
                            label = { Text("Custom Goal Name") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        )

                        OutlinedTextField(
                            value = profileDegree,
                            onValueChange = {
                                profileDegree = it
                                profilePrefs.edit().putString("profile_degree", it).apply()
                            },
                            label = { Text("Academic Qualification / Degree") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        )
                    }
                }
            }
        }

        SettingsSubCategory.DAILY_REMINDER -> {
            var reminderEnabled by remember { mutableStateOf(repository.reminderEnabled) }
            var reminderHour by remember { mutableStateOf(repository.reminderHour) }
            var reminderMinute by remember { mutableStateOf(repository.reminderMinute) }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "Study Reminders & Notifications",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        SettingToggleItem(
                            title = "Daily Push Notification",
                            description = "Receive a reminder to complete your spaced repetition reviews",
                            checked = reminderEnabled,
                            onCheckedChange = {
                                reminderEnabled = it
                                repository.reminderEnabled = it
                            },
                            icon = Icons.Outlined.Notifications
                        )

                        if (reminderEnabled) {
                            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                OutlinedTextField(
                                    value = reminderHour.toString(),
                                    onValueChange = { text ->
                                        val num = text.filter { it.isDigit() }.toIntOrNull() ?: 0
                                        val bounded = num.coerceIn(0, 23)
                                        reminderHour = bounded
                                        repository.reminderHour = bounded
                                    },
                                    label = { Text("Hour (0-23)") },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                    modifier = Modifier.weight(1f),
                                    shape = RoundedCornerShape(12.dp)
                                )

                                OutlinedTextField(
                                    value = String.format("%02d", reminderMinute),
                                    onValueChange = { text ->
                                        val num = text.filter { it.isDigit() }.toIntOrNull() ?: 0
                                        val bounded = num.coerceIn(0, 59)
                                        reminderMinute = bounded
                                        repository.reminderMinute = bounded
                                    },
                                    label = { Text("Minute (0-59)") },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                    modifier = Modifier.weight(1f),
                                    shape = RoundedCornerShape(12.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        else -> {}
    }
}

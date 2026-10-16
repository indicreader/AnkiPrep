package com.example.flashcardapp.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.utils.AmbientSoundSynthesizer
import com.example.flashcardapp.utils.AmbientSoundType
import kotlinx.coroutines.delay

@Composable
fun PomodoroBar(
    modifier: Modifier = Modifier,
    initialFocusMinutes: Int = 25,
    initialBreakMinutes: Int = 5
) {
    var isRunning by remember { mutableStateOf(false) }
    var isBreakMode by remember { mutableStateOf(false) }
    var remainingSeconds by remember { mutableIntStateOf(initialFocusMinutes * 60) }
    var selectedSound by remember { mutableStateOf(AmbientSoundType.OFF) }
    var showSoundPicker by remember { mutableStateOf(false) }

    // Countdown loop
    LaunchedEffect(isRunning, isBreakMode) {
        while (isRunning && remainingSeconds > 0) {
            delay(1000L)
            remainingSeconds--
            if (remainingSeconds == 0) {
                // Switch mode
                isBreakMode = !isBreakMode
                remainingSeconds = if (isBreakMode) initialBreakMinutes * 60 else initialFocusMinutes * 60
            }
        }
    }

    // Stop sound when composable leaves composition
    DisposableEffect(Unit) {
        onDispose {
            AmbientSoundSynthesizer.stop()
        }
    }

    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)),
        shadowElevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 14.dp, vertical = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Mode Indicator & Time
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(if (isBreakMode) Color(0xFF2A9D8F) else MaterialTheme.colorScheme.primary)
                )
                Spacer(Modifier.width(8.dp))
                Column {
                    Text(
                        text = if (isBreakMode) "Break Time" else "Focus Interval",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    val m = remainingSeconds / 60
                    val s = remainingSeconds % 60
                    Text(
                        text = String.format("%02d:%02d", m, s),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            // Controls
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Play / Pause
                IconButton(
                    onClick = { isRunning = !isRunning },
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        imageVector = if (isRunning) Icons.Default.Pause else Icons.Default.PlayArrow,
                        contentDescription = if (isRunning) "Pause" else "Start",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }

                // Reset
                IconButton(
                    onClick = {
                        isRunning = false
                        isBreakMode = false
                        remainingSeconds = initialFocusMinutes * 60
                    },
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Reset Timer",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                // Sound picker toggle
                Box {
                    IconButton(
                        onClick = { showSoundPicker = !showSoundPicker },
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(
                            imageVector = if (selectedSound == AmbientSoundType.OFF) Icons.Default.VolumeOff else Icons.Default.VolumeUp,
                            contentDescription = "Ambient Sound",
                            tint = if (selectedSound != AmbientSoundType.OFF) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    DropdownMenu(
                        expanded = showSoundPicker,
                        onDismissRequest = { showSoundPicker = false }
                    ) {
                        Text(
                            text = "Focus Soundscape",
                            style = MaterialTheme.typography.labelSmall,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                            color = MaterialTheme.colorScheme.primary
                        )
                        AmbientSoundType.values().forEach { sound ->
                            DropdownMenuItem(
                                text = { Text(sound.displayName, fontSize = 13.sp) },
                                leadingIcon = {
                                    if (selectedSound == sound) {
                                        Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp))
                                    }
                                },
                                onClick = {
                                    selectedSound = sound
                                    AmbientSoundSynthesizer.play(sound)
                                    showSoundPicker = false
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

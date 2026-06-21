package com.example.flashcardapp.ui

import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Grade
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.FindInPage
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.foundation.clickable
import com.example.flashcardapp.session.AnswerRecord
import com.example.flashcardapp.ui.theme.*

@Composable
fun ResultsScreen(
    score: Int,
    totalQuestions: Int,
    timeTakenSeconds: Long,
    answeredQuestions: List<AnswerRecord> = emptyList(),
    positiveMarks: Float = 1.0f,
    negativeMarks: Float = 0.0f,
    onRestart: () -> Unit,
    onHome: () -> Unit,
    onReviewMistakes: () -> Unit = {},
    onOverrideRating: (Long) -> Unit = {}
) {
    val currentLanguage by com.example.flashcardapp.data.TranslationManager.currentLanguage.collectAsState()
    val colorScheme = MaterialTheme.colorScheme
    val accuracy = if (totalQuestions > 0) (score.toFloat() / totalQuestions * 100).toInt() else 0
    val wrongCount = answeredQuestions.count { !it.isCorrect }
    val weightedScore = (score * positiveMarks) + ((totalQuestions - score) * negativeMarks)

    // Performance tier
    data class PerformanceTier(val text: String, val color: Color)
    val tier = when {
        accuracy >= 90 -> PerformanceTier(com.example.flashcardapp.data.TranslationManager.getString("outstanding"), CorrectColor)
        accuracy >= 75 -> PerformanceTier(com.example.flashcardapp.data.TranslationManager.getString("great_job"), colorScheme.primary)
        accuracy >= 50 -> PerformanceTier(com.example.flashcardapp.data.TranslationManager.getString("keep_going"), Color(0xFFF57C00))
        else -> PerformanceTier(com.example.flashcardapp.data.TranslationManager.getString("keep_practicing"), colorScheme.error)
    }

    // ── Animated score ring ────────────────────────────────────
    val animatedAccuracy by animateFloatAsState(
        targetValue = accuracy / 100f,
        animationSpec = tween(durationMillis = 900, easing = FastOutSlowInEasing),
        label = "scoreRing"
    )

    Scaffold(containerColor = colorScheme.background) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(Modifier.height(8.dp))

            // ── Title ──────────────────────────────────────────
            Text(
                text = com.example.flashcardapp.data.TranslationManager.getString("quiz_complete"),
                style = MaterialTheme.typography.headlineMedium,
                color = colorScheme.onBackground,
                textAlign = TextAlign.Center
            )

            // ── Score Ring Card ───────────────────────────────
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.extraLarge,
                colors = CardDefaults.cardColors(containerColor = colorScheme.surface),
                border = BorderStroke(1.dp, colorScheme.outlineVariant),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    // Score ring
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.size(140.dp)
                    ) {
                        // Track
                        CircularProgressIndicator(
                            progress = { 1f },
                            modifier = Modifier.size(140.dp),
                            color = colorScheme.surfaceVariant,
                            strokeWidth = 12.dp,
                            strokeCap = StrokeCap.Round
                        )
                        // Fill
                        CircularProgressIndicator(
                            progress = { animatedAccuracy },
                            modifier = Modifier.size(140.dp),
                            color = tier.color,
                            strokeWidth = 12.dp,
                            strokeCap = StrokeCap.Round
                        )
                        // Center content
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "$accuracy%",
                                style = MaterialTheme.typography.headlineLarge,
                                fontWeight = FontWeight.ExtraBold,
                                color = tier.color
                            )
                            Text(
                                text = com.example.flashcardapp.data.TranslationManager.getString("accuracy"),
                                style = MaterialTheme.typography.labelSmall,
                                color = colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    // Performance label
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = tier.text,
                            style = MaterialTheme.typography.titleLarge,
                            color = tier.color,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    HorizontalDivider(color = colorScheme.outlineVariant)

                    // Stat row
                    val showWeightedScore = positiveMarks != 1.0f || negativeMarks != 0.0f
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        ResultStatItem(
                            label = com.example.flashcardapp.data.TranslationManager.getString("correct_answers"),
                            value = "$score",
                            icon = Icons.Outlined.CheckCircle,
                            color = CorrectColor
                        )
                        ResultStatItem(
                            label = com.example.flashcardapp.data.TranslationManager.getString("wrong"),
                            value = "${totalQuestions - score}",
                            icon = Icons.Outlined.Error,
                            color = colorScheme.error
                        )
                        if (showWeightedScore) {
                            val formattedScore = String.format("%.1f", weightedScore)
                            ResultStatItem(
                                label = com.example.flashcardapp.data.TranslationManager.getString("points"),
                                value = formattedScore,
                                icon = Icons.Outlined.Grade,
                                color = colorScheme.primary
                            )
                        }
                        ResultStatItem(
                            label = com.example.flashcardapp.data.TranslationManager.getString("time"),
                            value = formatTime(timeTakenSeconds),
                            icon = Icons.Outlined.Timer,
                            color = colorScheme.secondary
                        )
                    }
                }
            }

            // ── Personalized message card ─────────────────────
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.large,
                colors = CardDefaults.cardColors(
                    containerColor = tier.color.copy(alpha = 0.1f)
                ),
                border = BorderStroke(1.dp, tier.color.copy(alpha = 0.25f))
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(tier.color.copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.Star, contentDescription = null, tint = tier.color, modifier = Modifier.size(22.dp))
                    }
                    Text(
                        text = when {
                            accuracy >= 90 -> com.example.flashcardapp.data.TranslationManager.getString("excellent_work_desc")
                            accuracy >= 75 -> com.example.flashcardapp.data.TranslationManager.getString("strong_performance_desc")
                            accuracy >= 50 -> com.example.flashcardapp.data.TranslationManager.getString("good_effort_desc")
                            else -> com.example.flashcardapp.data.TranslationManager.getString("dont_give_up_desc")
                        },
                        style = MaterialTheme.typography.bodyMedium,
                        color = colorScheme.onBackground,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            if (answeredQuestions.isNotEmpty()) {
                val guessedCardIds = remember { mutableStateMapOf<Long, Boolean>() }
                
                Spacer(Modifier.height(8.dp))
                Text(
                    text = com.example.flashcardapp.data.TranslationManager.getString("review_your_answers"),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = colorScheme.onBackground,
                    modifier = Modifier.align(Alignment.Start)
                )

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.large,
                    colors = CardDefaults.cardColors(containerColor = colorScheme.surface),
                    border = BorderStroke(1.dp, colorScheme.outlineVariant)
                ) {
                    Column(
                        modifier = Modifier.padding(8.dp)
                    ) {
                        answeredQuestions.forEachIndexed { index, record ->
                            val isGuessed = guessedCardIds[record.question.sourceCardId] ?: false
                            ListItem(
                                headlineContent = {
                                    Text(
                                        text = record.question.question,
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                },
                                supportingContent = {
                                    Text(
                                        text = com.example.flashcardapp.data.TranslationManager.getString("time") + ": ${formatTime(record.timeTakenMs / 1000)}",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = colorScheme.onSurfaceVariant
                                    )
                                },
                                leadingContent = {
                                    Icon(
                                        imageVector = if (record.isCorrect) Icons.Outlined.CheckCircle else Icons.Outlined.Cancel,
                                        contentDescription = null,
                                        tint = if (record.isCorrect) CorrectColor else colorScheme.error
                                    )
                                },
                                trailingContent = {
                                    if (record.isCorrect) {
                                        val chipBg = if (isGuessed) colorScheme.tertiaryContainer else colorScheme.surfaceVariant.copy(alpha = 0.5f)
                                        val chipText = if (isGuessed) com.example.flashcardapp.data.TranslationManager.getString("guessed") else com.example.flashcardapp.data.TranslationManager.getString("i_guessed")
                                        val chipTextColor = if (isGuessed) colorScheme.onTertiaryContainer else colorScheme.onSurfaceVariant

                                        Surface(
                                            shape = CircleShape,
                                            color = chipBg,
                                            border = if (isGuessed) null else BorderStroke(1.dp, colorScheme.outline),
                                            modifier = Modifier
                                                .clip(CircleShape)
                                                .clickable(enabled = !isGuessed) {
                                                    guessedCardIds[record.question.sourceCardId] = true
                                                    onOverrideRating(record.question.sourceCardId)
                                                }
                                        ) {
                                            Text(
                                                text = chipText,
                                                color = chipTextColor,
                                                style = MaterialTheme.typography.labelSmall,
                                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                                            )
                                        }
                                    }
                                },
                                colors = ListItemDefaults.colors(containerColor = Color.Transparent)
                            )
                            if (index < answeredQuestions.lastIndex) {
                                HorizontalDivider(color = colorScheme.outlineVariant.copy(alpha = 0.5f))
                            }
                        }
                    }
                }
            }

            // ── Action buttons ────────────────────────────────
            if (wrongCount > 0 && answeredQuestions.isNotEmpty()) {
                Button(
                    onClick = onReviewMistakes,
                    modifier = Modifier.fillMaxWidth().height(52.dp),
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorScheme.errorContainer,
                        contentColor = colorScheme.error
                    )
                ) {
                    Icon(Icons.Default.FindInPage, contentDescription = null, modifier = Modifier.size(20.dp))
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = com.example.flashcardapp.data.TranslationManager.getString("review_n_mistakes").format(wrongCount),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }

            Button(
                onClick = onRestart,
                modifier = Modifier.fillMaxWidth().height(52.dp),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorScheme.primary,
                    contentColor = colorScheme.onPrimary
                )
            ) {
                Icon(Icons.Outlined.Refresh, contentDescription = null, modifier = Modifier.size(20.dp))
                Spacer(Modifier.width(8.dp))
                Text(com.example.flashcardapp.data.TranslationManager.getString("study_again"), style = MaterialTheme.typography.labelLarge)
            }

            OutlinedButton(
                onClick = onHome,
                modifier = Modifier.fillMaxWidth().height(52.dp),
                shape = MaterialTheme.shapes.medium,
                border = BorderStroke(1.dp, colorScheme.primary),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = colorScheme.primary)
            ) {
                Icon(Icons.Outlined.Home, contentDescription = null, modifier = Modifier.size(20.dp))
                Spacer(Modifier.width(8.dp))
                Text(com.example.flashcardapp.data.TranslationManager.getString("back_to_decks"), style = MaterialTheme.typography.labelLarge)
            }

            Spacer(Modifier.height(8.dp))
        }
    }
}

// ── Stat item component ───────────────────────────────────────

@Composable
private fun ResultStatItem(label: String, value: String, icon: ImageVector, color: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Icon(icon, contentDescription = null, tint = color, modifier = Modifier.size(22.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = color
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun StatBox(label: String, value: String, color: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = label, color = TextSecondaryGray, fontSize = 12.sp, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = value, color = color, fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
}

private fun formatTime(seconds: Long): String {
    val mins = seconds / 60
    val secs = seconds % 60
    return String.format("%02d:%02d", mins, secs)
}

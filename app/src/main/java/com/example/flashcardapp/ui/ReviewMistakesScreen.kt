package com.example.flashcardapp.ui

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.session.AnswerRecord
import com.example.flashcardapp.ui.theme.*
import androidx.compose.ui.platform.LocalContext
import android.widget.Toast
import kotlinx.coroutines.launch
import com.example.flashcardapp.data.AnkiDataRepository
import com.example.flashcardapp.data.entities.CardOverrideEntity
import androidx.compose.material.icons.filled.Edit

/**
 * Full-screen review of all answered questions from the last quiz session.
 * Shows each question with the user's answer and the correct answer,
 * plus the explanation if available.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReviewMistakesScreen(
    deckName: String,
    answeredQuestions: List<AnswerRecord>,
    onBack: () -> Unit
) {
    val wrongAnswers = answeredQuestions.filter { !it.isCorrect }
    val correctAnswers = answeredQuestions.filter { it.isCorrect }

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val repo = remember { AnkiDataRepository.getInstance(context) }
    var editingRecord by remember { mutableStateOf<AnswerRecord?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            "Review Mistakes",
                            color = TextPrimaryDeep,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            deckName,
                            color = TextSecondaryGray,
                            fontSize = 12.sp
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = PrimaryPurple
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BackgroundLavender)
            )
        },
        containerColor = BackgroundLavender
    ) { paddingValues ->

        if (answeredQuestions.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "No answers to review.",
                    color = TextSecondaryGray,
                    fontSize = 16.sp
                )
            }
            return@Scaffold
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            // Summary header
            item {
                ReviewSummaryHeader(
                    total = answeredQuestions.size,
                    wrong = wrongAnswers.size,
                    correct = correctAnswers.size
                )
            }

            // Wrong answers first
            if (wrongAnswers.isNotEmpty()) {
                item {
                    Text(
                        text = "❌  Incorrect Answers  (${wrongAnswers.size})",
                        color = IncorrectColor,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                itemsIndexed(wrongAnswers) { idx, record ->
                    AnswerReviewCard(
                        questionNumber = idx + 1,
                        record = record,
                        isWrong = true,
                        onEditCard = { editingRecord = it }
                    )
                }
            }

            // Correct answers section
            if (correctAnswers.isNotEmpty()) {
                item {
                    Text(
                        text = "✅  Correct Answers  (${correctAnswers.size})",
                        color = CorrectColor,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                itemsIndexed(correctAnswers) { idx, record ->
                    AnswerReviewCard(
                        questionNumber = idx + 1,
                        record = record,
                        isWrong = false,
                        onEditCard = { editingRecord = it }
                    )
                }
            }
        }
        
        val selectedRecord = editingRecord
        if (selectedRecord != null) {
            var initialTags by remember(selectedRecord.question.sourceCardId) { mutableStateOf("") }
            var initialFrontImage by remember(selectedRecord.question.sourceCardId) { mutableStateOf<String?>(null) }
            var initialBackImage by remember(selectedRecord.question.sourceCardId) { mutableStateOf<String?>(null) }
            var initialExplanationImage by remember(selectedRecord.question.sourceCardId) { mutableStateOf<String?>(null) }
            var initialOptionImagesJson by remember(selectedRecord.question.sourceCardId) { mutableStateOf<String?>(null) }

            LaunchedEffect(selectedRecord.question.sourceCardId) {
                val card = repo.getCardById(selectedRecord.question.sourceCardId)
                if (card != null) {
                    initialTags = repo.parseTags(card.tags).joinToString(", ")
                    initialFrontImage = card.frontImage
                    initialBackImage = card.backImage
                    initialExplanationImage = card.explanationImage
                    initialOptionImagesJson = card.optionImagesJson
                }
            }

            McqEditorDialog(
                initialQuestion = selectedRecord.question.question,
                initialCorrectAnswer = selectedRecord.question.correctAnswer,
                initialOptions = selectedRecord.question.options,
                initialExplanation = selectedRecord.question.explanation,
                initialTags = initialTags,
                initialFrontImage = initialFrontImage,
                initialBackImage = initialBackImage,
                initialExplanationImage = initialExplanationImage,
                initialOptionImagesJson = initialOptionImagesJson,
                title = "Edit Card",
                onDismiss = { editingRecord = null },
                onSave = { newFront, newBack, newTags, frontImg, backImg, explImg, optImgs ->
                    coroutineScope.launch {
                        repo.upsertOverride(
                            CardOverrideEntity(
                                cardId = selectedRecord.question.sourceCardId,
                                frontOverride = newFront,
                                backOverride = newBack,
                                tagsOverride = newTags,
                                timestamp = System.currentTimeMillis(),
                                frontImageOverride = frontImg,
                                backImageOverride = backImg,
                                explanationImageOverride = explImg,
                                optionImagesOverrideJson = optImgs
                            )
                        )
                        Toast.makeText(context, "Card updated!", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
    }
}

@Composable
private fun ReviewSummaryHeader(
    total: Int,
    wrong: Int,
    correct: Int
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(PrimaryPurple.copy(alpha = 0.08f), Color(0xFFE8E2FF))
                    ),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                SummaryPill(label = "Total", value = total.toString(), color = PrimaryPurple)
                SummaryPill(label = "Correct", value = correct.toString(), color = CorrectColor)
                SummaryPill(label = "Wrong", value = wrong.toString(), color = IncorrectColor)
                val pct = if (total > 0) (correct * 100 / total) else 0
                SummaryPill(label = "Accuracy", value = "$pct%", color = if (pct >= 75) CorrectColor else IncorrectColor)
            }
        }
    }
}

@Composable
private fun SummaryPill(label: String, value: String, color: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value, color = color, fontWeight = FontWeight.Black, fontSize = 22.sp)
        Text(text = label, color = TextSecondaryGray, fontSize = 11.sp, fontWeight = FontWeight.Medium)
    }
}

@Composable
private fun AnswerReviewCard(
    questionNumber: Int,
    record: AnswerRecord,
    isWrong: Boolean,
    onEditCard: (AnswerRecord) -> Unit
) {
    var expanded by remember { mutableStateOf(isWrong) } // wrong answers expand by default

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isWrong) Color(0xFFFFF5F5) else Color(0xFFF4FBF4)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Question header row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .background(
                                color = if (isWrong) IncorrectColor else CorrectColor,
                                shape = RoundedCornerShape(8.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "$questionNumber",
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Text(
                        text = record.question.question,
                        color = TextPrimaryDeep,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        modifier = Modifier.weight(1f)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    IconButton(
                        onClick = { onEditCard(record) },
                        modifier = Modifier.size(28.dp)
                    ) {
                        Icon(
                            Icons.Outlined.Edit,
                            contentDescription = "Edit",
                            tint = PrimaryPurple,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                    IconButton(
                        onClick = { expanded = !expanded },
                        modifier = Modifier.size(28.dp)
                    ) {
                        Icon(
                            if (expanded) Icons.Outlined.Close else Icons.Outlined.CheckCircle,
                            contentDescription = if (expanded) "Collapse" else "Expand",
                            tint = TextSecondaryGray,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }

            AnimatedVisibility(
                visible = expanded,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                Column(modifier = Modifier.padding(top = 12.dp)) {
                    HorizontalDivider(color = Color(0xFFEBE3FA), thickness = 1.dp)
                    Spacer(modifier = Modifier.height(10.dp))

                    // All options with correct/wrong indication
                    record.question.options.forEachIndexed { idx, option ->
                        val isCorrectOption = idx == record.question.correctIndex
                        val isUserChoice = idx == record.selectedOptionIndex
                        val optionBg = when {
                            isCorrectOption -> CorrectBg
                            isUserChoice && !isCorrectOption -> IncorrectBg
                            else -> Color.Transparent
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(optionBg, RoundedCornerShape(8.dp))
                                .padding(horizontal = 10.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            val optLabel = listOf("A", "B", "C", "D", "E").getOrElse(idx) { "$idx" }
                            Text(
                                text = optLabel,
                                color = when {
                                    isCorrectOption -> CorrectColor
                                    isUserChoice -> IncorrectColor
                                    else -> TextSecondaryGray
                                },
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp
                            )
                            Text(
                                text = option,
                                color = when {
                                    isCorrectOption -> CorrectColor
                                    isUserChoice -> IncorrectColor
                                    else -> TextSecondaryGray
                                },
                                fontSize = 13.sp,
                                modifier = Modifier.weight(1f)
                            )
                            if (isCorrectOption) {
                                Icon(
                                    Icons.Outlined.CheckCircle,
                                    contentDescription = "Correct",
                                    tint = CorrectColor,
                                    modifier = Modifier.size(16.dp)
                                )
                            } else if (isUserChoice) {
                                Icon(
                                    Icons.Outlined.Close,
                                    contentDescription = "Wrong",
                                    tint = IncorrectColor,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                    }

                    // Explanation
                    if (record.question.explanation.isNotBlank()) {
                        Spacer(modifier = Modifier.height(8.dp))
                        HorizontalDivider(color = Color(0xFFEBE3FA), thickness = 1.dp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "Explanation",
                            color = PrimaryPurple,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = record.question.explanation,
                            color = TextSecondaryGray,
                            fontSize = 13.sp,
                            lineHeight = 18.sp
                        )
                    }

                    // Time taken
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Time taken: ${record.timeTakenMs / 1000}s",
                        color = TextSecondaryGray.copy(alpha = 0.7f),
                        fontSize = 11.sp,
                        textAlign = TextAlign.End,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

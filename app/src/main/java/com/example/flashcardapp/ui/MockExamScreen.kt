package com.example.flashcardapp.ui

import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.mcq.Mcq
import com.example.flashcardapp.mock.*
import com.example.flashcardapp.ui.theme.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Competitive Mock Exam Simulator Screen.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MockExamScreen(
    deckName: String,
    questions: List<Mcq>,
    preset: ExamPreset = ExamPreset.SSC_CGL,
    onFinish: (MockExamScorecard) -> Unit,
    onBackPressed: () -> Unit
) {
    if (questions.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("No questions available in this deck to start a mock exam.", color = MaterialTheme.colorScheme.onSurface)
        }
        return
    }

    val context = LocalContext.current
    var currentIndex by remember { mutableIntStateOf(0) }
    val totalQuestions = questions.size

    // Attempts map: index -> QuestionAttemptState
    val attempts = remember {
        mutableStateMapOf<Int, QuestionAttemptState>().apply {
            for (i in 0 until totalQuestions) {
                this[i] = QuestionAttemptState(
                    questionIndex = i,
                    status = if (i == 0) QuestionStatus.NOT_ANSWERED else QuestionStatus.NOT_VISITED
                )
            }
        }
    }

    // Time Tracking
    var remainingSeconds by remember { mutableLongStateOf(preset.durationMinutes * 60L) }
    var elapsedSeconds by remember { mutableLongStateOf(0L) }
    var isSubmitting by remember { mutableStateOf(false) }
    var scorecard by remember { mutableStateOf<MockExamScorecard?>(null) }
    var showPaletteDrawer by remember { mutableStateOf(false) }
    var showSubmitConfirmation by remember { mutableStateOf(false) }

    // Countdown Timer Loop
    LaunchedEffect(key1 = isSubmitting, key2 = scorecard) {
        while (!isSubmitting && scorecard == null && remainingSeconds > 0) {
            delay(1000L)
            remainingSeconds--
            elapsedSeconds++
            // Increment time spent on current question
            attempts[currentIndex]?.let { it.timeSpentSeconds++ }

            if (remainingSeconds == 0L) {
                Toast.makeText(context, "Time is up! Submitting exam automatically...", Toast.LENGTH_LONG).show()
                scorecard = MockExamEvaluator.evaluate(
                    examTitle = preset.title,
                    questions = questions,
                    attempts = attempts,
                    positiveMark = preset.positiveMarks,
                    negativePenalty = preset.negativePenalty,
                    totalTimeSeconds = elapsedSeconds
                )
            }
        }
    }

    // When exam is finished, display the comprehensive scorecard
    if (scorecard != null) {
        MockExamScorecardView(
            scorecard = scorecard!!,
            deckName = deckName,
            onClose = { onFinish(scorecard!!) }
        )
        return
    }

    val currentMcq = questions[currentIndex]
    val currentAttempt = attempts[currentIndex] ?: QuestionAttemptState(currentIndex)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "${preset.title} Mock",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Q ${currentIndex + 1} of $totalQuestions  •  +$preset.positiveMarks / -$preset.negativePenalty",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { showSubmitConfirmation = true }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Exit Exam")
                    }
                },
                actions = {
                    // Timer Badge
                    val minutes = remainingSeconds / 60
                    val seconds = remainingSeconds % 60
                    val timerColor = if (remainingSeconds < 300) Color(0xFFE63946) else MaterialTheme.colorScheme.primary

                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = timerColor.copy(alpha = 0.15f),
                        border = BorderStroke(1.dp, timerColor),
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        ) {
                            Icon(Icons.Default.Timer, contentDescription = null, tint = timerColor, modifier = Modifier.size(16.dp))
                            Spacer(Modifier.width(4.dp))
                            Text(
                                text = String.format("%02d:%02d", minutes, seconds),
                                fontWeight = FontWeight.Bold,
                                color = timerColor,
                                fontSize = 13.sp
                            )
                        }
                    }

                    // Question Palette Toggle Button
                    IconButton(onClick = { showPaletteDrawer = true }) {
                        Icon(Icons.Default.GridView, contentDescription = "Question Palette", tint = MaterialTheme.colorScheme.primary)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        bottomBar = {
            // Action navigation controls
            Surface(
                tonalElevation = 8.dp,
                shadowElevation = 8.dp,
                color = MaterialTheme.colorScheme.surface
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Clear Selection
                    TextButton(
                        onClick = {
                            currentAttempt.selectedOptionIndex = null
                            currentAttempt.status = QuestionStatus.NOT_ANSWERED
                            attempts[currentIndex] = currentAttempt
                        },
                        enabled = currentAttempt.selectedOptionIndex != null
                    ) {
                        Text("Clear", color = MaterialTheme.colorScheme.error)
                    }

                    // Mark for Review & Next
                    OutlinedButton(
                        onClick = {
                            val isSelected = currentAttempt.selectedOptionIndex != null
                            currentAttempt.status = if (isSelected) QuestionStatus.ANSWERED_AND_MARKED else QuestionStatus.MARKED_FOR_REVIEW
                            attempts[currentIndex] = currentAttempt

                            if (currentIndex < totalQuestions - 1) {
                                currentIndex++
                                if (attempts[currentIndex]?.status == QuestionStatus.NOT_VISITED) {
                                    attempts[currentIndex]?.status = QuestionStatus.NOT_ANSWERED
                                }
                            }
                        },
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Review & Next", fontSize = 12.sp)
                    }

                    // Save & Next
                    Button(
                        onClick = {
                            if (currentAttempt.selectedOptionIndex != null) {
                                currentAttempt.status = QuestionStatus.ANSWERED
                            } else {
                                currentAttempt.status = QuestionStatus.NOT_ANSWERED
                            }
                            attempts[currentIndex] = currentAttempt

                            if (currentIndex < totalQuestions - 1) {
                                currentIndex++
                                if (attempts[currentIndex]?.status == QuestionStatus.NOT_VISITED) {
                                    attempts[currentIndex]?.status = QuestionStatus.NOT_ANSWERED
                                }
                            } else {
                                showSubmitConfirmation = true
                            }
                        },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                    ) {
                        Text(if (currentIndex == totalQuestions - 1) "Submit Test" else "Save & Next", fontSize = 13.sp)
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Status Tag
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(currentAttempt.status.colorHex).copy(alpha = 0.2f),
                    border = BorderStroke(1.dp, Color(currentAttempt.status.colorHex))
                ) {
                    Text(
                        text = currentAttempt.status.label,
                        color = Color(currentAttempt.status.colorHex),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }

                if (currentMcq.tags.isNotEmpty()) {
                    Text(
                        text = currentMcq.tags.first(),
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(Modifier.height(12.dp))

            // Question Statement
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
            ) {
                Box(modifier = Modifier.padding(16.dp)) {
                    com.example.flashcardapp.ui.components.MathView(
                        text = currentMcq.question,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Medium,
                            lineHeight = 24.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            // Options List (Interactive Radio Buttons)
            currentMcq.options.forEachIndexed { optIndex, optionText ->
                val isSelected = currentAttempt.selectedOptionIndex == optIndex
                val optionLetter = ('A' + optIndex).toString()

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .clickable {
                            currentAttempt.selectedOptionIndex = optIndex
                            currentAttempt.status = QuestionStatus.ANSWERED
                            attempts[currentIndex] = currentAttempt
                        },
                    shape = RoundedCornerShape(10.dp),
                    color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface,
                    border = BorderStroke(
                        width = if (isSelected) 2.dp else 1.dp,
                        color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier.size(28.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = optionLetter,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        Spacer(Modifier.width(12.dp))

                        Box(modifier = Modifier.weight(1f)) {
                            com.example.flashcardapp.ui.components.MathView(
                                text = optionText,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface
                                )
                            )
                        }
                    }
                }
            }
        }
    }

    // Question Palette Bottom Sheet / Modal
    if (showPaletteDrawer) {
        ModalBottomSheet(onDismissRequest = { showPaletteDrawer = false }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Question Palette",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(8.dp))

                // Legend
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    QuestionStatus.values().forEach { st ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(10.dp)
                                    .clip(CircleShape)
                                    .background(Color(st.colorHex))
                            )
                            Spacer(Modifier.width(4.dp))
                            Text(st.label, fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                }

                Spacer(Modifier.height(16.dp))

                // 1..N Question Grid
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 44.dp),
                    modifier = Modifier.heightIn(max = 300.dp)
                ) {
                    items((0 until totalQuestions).toList()) { idx ->
                        val st = attempts[idx]?.status ?: QuestionStatus.NOT_VISITED
                        val isCurr = idx == currentIndex

                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .padding(4.dp)
                                .size(40.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(st.colorHex))
                                .border(
                                    width = if (isCurr) 2.dp else 0.dp,
                                    color = if (isCurr) MaterialTheme.colorScheme.onSurface else Color.Transparent,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .clickable {
                                    currentIndex = idx
                                    if (attempts[currentIndex]?.status == QuestionStatus.NOT_VISITED) {
                                        attempts[currentIndex]?.status = QuestionStatus.NOT_ANSWERED
                                    }
                                    showPaletteDrawer = false
                                }
                        ) {
                            Text(
                                text = "${idx + 1}",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp
                            )
                        }
                    }
                }

                Spacer(Modifier.height(16.dp))

                Button(
                    onClick = {
                        showPaletteDrawer = false
                        showSubmitConfirmation = true
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text("Submit Examination")
                }
            }
        }
    }

    // Submit Confirmation Dialog
    if (showSubmitConfirmation) {
        val answeredCount = attempts.values.count { it.status == QuestionStatus.ANSWERED || it.status == QuestionStatus.ANSWERED_AND_MARKED }
        val remainingCount = totalQuestions - answeredCount

        AlertDialog(
            onDismissRequest = { showSubmitConfirmation = false },
            title = { Text("Submit Mock Examination?") },
            text = {
                Text(
                    "You have answered $answeredCount questions.\n$remainingCount questions remain unanswered.\n\nAre you sure you want to finish and generate your official scorecard?"
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        showSubmitConfirmation = false
                        isSubmitting = true
                        scorecard = MockExamEvaluator.evaluate(
                            examTitle = preset.title,
                            questions = questions,
                            attempts = attempts,
                            positiveMark = preset.positiveMarks,
                            negativePenalty = preset.negativePenalty,
                            totalTimeSeconds = elapsedSeconds
                        )
                    }
                ) {
                    Text("Submit Test")
                }
            },
            dismissButton = {
                TextButton(onClick = { showSubmitConfirmation = false }) {
                    Text("Resume Test")
                }
            }
        )
    }
}

/**
 * Scorecard Screen showing net score, negative marks deduction, accuracy %, and review.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MockExamScorecardView(
    scorecard: MockExamScorecard,
    deckName: String,
    onClose: () -> Unit
) {
    var filterMistakesOnly by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Official Scorecard: ${scorecard.examTitle}") },
                navigationIcon = {
                    IconButton(onClick = onClose) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Net Score Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("NET SCORE", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.primary)
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = String.format("%.2f / %.2f", scorecard.netScore, scorecard.maxScore),
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Accuracy", fontSize = 11.sp, color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f))
                            Text(String.format("%.1f%%", scorecard.accuracyPercentage), fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Correct (+)", fontSize = 11.sp, color = Color(0xFF2A9D8F))
                            Text("+${scorecard.positiveMarks}", fontWeight = FontWeight.Bold, color = Color(0xFF2A9D8F), fontSize = 16.sp)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Negative (-)", fontSize = 11.sp, color = Color(0xFFE63946))
                            Text("-${scorecard.negativeMarks}", fontWeight = FontWeight.Bold, color = Color(0xFFE63946), fontSize = 16.sp)
                        }
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            // Attempt Stats Row
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                StatPill(modifier = Modifier.weight(1f), label = "Correct", count = scorecard.correct, color = Color(0xFF2A9D8F))
                StatPill(modifier = Modifier.weight(1f), label = "Wrong", count = scorecard.incorrect, color = Color(0xFFE63946))
                StatPill(modifier = Modifier.weight(1f), label = "Skipped", count = scorecard.skipped, color = Color(0xFF6C757D))
            }

            Spacer(Modifier.height(20.dp))

            // Question Breakdown Review
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Question Audit", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Mistakes Only", fontSize = 12.sp)
                    Switch(checked = filterMistakesOnly, onCheckedChange = { filterMistakesOnly = it }, modifier = Modifier.scale(0.8f))
                }
            }

            Spacer(Modifier.height(8.dp))

            val displayedList = if (filterMistakesOnly) {
                scorecard.details.filter { !it.isCorrect && it.isAttempted }
            } else {
                scorecard.details
            }

            displayedList.forEach { detail ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(
                        1.dp,
                        if (detail.isCorrect) Color(0xFF2A9D8F) else if (detail.isAttempted) Color(0xFFE63946) else Color.Gray
                    )
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                "Q${detail.questionIndex + 1}",
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = if (detail.isCorrect) "+${scorecard.details[0].marksAwarded}" else if (detail.isAttempted) "${detail.marksAwarded}" else "0 (Skipped)",
                                fontWeight = FontWeight.Bold,
                                color = if (detail.isCorrect) Color(0xFF2A9D8F) else if (detail.isAttempted) Color(0xFFE63946) else Color.Gray,
                                fontSize = 12.sp
                            )
                        }

                        Spacer(Modifier.height(4.dp))
                        Text(detail.mcq.question, fontSize = 13.sp, fontWeight = FontWeight.Medium)

                        Spacer(Modifier.height(6.dp))
                        Text(
                            text = "Correct Answer: ${detail.mcq.correctAnswer}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF2A9D8F)
                        )

                        if (!detail.isCorrect && detail.isAttempted && detail.selectedOptionIndex != null) {
                            Text(
                                text = "Your Answer: ${detail.mcq.options[detail.selectedOptionIndex]}",
                                fontSize = 12.sp,
                                color = Color(0xFFE63946)
                            )
                        }

                        if (detail.mcq.explanation.isNotBlank() && detail.mcq.explanation != "NA") {
                            Spacer(Modifier.height(4.dp))
                            Text(
                                text = "Expl: ${detail.mcq.explanation}",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = onClose,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Return to Decks")
            }
        }
    }
}

@Composable
fun StatPill(modifier: Modifier = Modifier, label: String, count: Int, color: Color) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        color = color.copy(alpha = 0.12f),
        border = BorderStroke(1.dp, color)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("$count", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = color)
            Text(label, fontSize = 11.sp, color = color)
        }
    }
}

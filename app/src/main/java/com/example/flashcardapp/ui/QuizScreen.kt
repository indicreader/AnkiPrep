package com.example.flashcardapp.ui

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.*
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.session.McqSessionManager
import com.example.flashcardapp.session.McqSessionMode
import com.example.flashcardapp.session.McqSessionState
import com.example.flashcardapp.ui.theme.*
import com.example.flashcardapp.data.TranslationManager
import com.example.flashcardapp.data.AnkiDataRepository
import com.example.flashcardapp.data.ImageStorageManager
import com.example.flashcardapp.data.entities.CardOverrideEntity
import com.example.flashcardapp.data.entities.CardEntity
import com.example.flashcardapp.mcq.Mcq
import androidx.compose.ui.platform.LocalContext
import android.widget.Toast
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(
    deckId: Long,
    deckName: String,
    sessionManager: McqSessionManager,
    vibrationEnabled: Boolean,
    showExplanations: Boolean,
    showTags: Boolean,
    timeLimitSeconds: Int,
    onBackPressed: () -> Unit
) {
    val hapticFeedback = LocalHapticFeedback.current
    val colorScheme = MaterialTheme.colorScheme

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val repo = remember { AnkiDataRepository.getInstance(context) }
    
    var showEditDialog by remember { mutableStateOf(false) }
    var showSubmitConfirm by remember { mutableStateOf(false) }
    var showEditSelectionDialog by remember { mutableStateOf(false) }
    var showWholePackScreen by remember { mutableStateOf(false) }
    var cardToEditFromPack by remember { mutableStateOf<CardEntity?>(null) }

    val cardsFlow = remember(deckId) { repo.observeCardsForDeck(deckId) }
    val cards by cardsFlow.collectAsState(initial = emptyList())

    // ── Whole Pack Editor Screen ──────────────────────────────
    if (showWholePackScreen) {
        EditWholePackScreen(
            deckName = deckName,
            cards = cards,
            onCardClick = { card -> cardToEditFromPack = card },
            onBackPressed = { showWholePackScreen = false }
        )

        val selectedPackCard = cardToEditFromPack
        if (selectedPackCard != null) {
            val parsed = remember(selectedPackCard.front, selectedPackCard.back) {
                com.example.flashcardapp.data.core.StructuredParser.parseCard(selectedPackCard.front, selectedPackCard.back)
            }
            val initialTags = remember(selectedPackCard.tags) {
                repo.parseTags(selectedPackCard.tags).joinToString(", ")
            }
            McqEditorDialog(
                initialQuestion = parsed.question.ifEmpty { selectedPackCard.front.trim() },
                initialCorrectAnswer = parsed.answer,
                initialOptions = parsed.options,
                initialExplanation = parsed.explanation,
                initialTags = initialTags,
                initialFrontImage = selectedPackCard.frontImage,
                initialBackImage = selectedPackCard.backImage,
                initialExplanationImage = selectedPackCard.explanationImage,
                initialOptionImagesJson = selectedPackCard.optionImagesJson,
                title = "Edit Card",
                onDismiss = { cardToEditFromPack = null },
                onSave = { newFront, newBack, newTags, frontImg, backImg, explImg, optImgs ->
                    coroutineScope.launch {
                        repo.upsertOverride(
                            CardOverrideEntity(
                                cardId = selectedPackCard.id,
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
        return
    }

    // ── Session state ─────────────────────────────────────────
    var sessionState by remember { mutableStateOf(sessionManager.getCurrentState()) }
    DisposableEffect(sessionManager) {
        val listener: (McqSessionState) -> Unit = { state -> sessionState = state }
        sessionManager.addListener(listener)
        onDispose { sessionManager.removeListener(listener) }
    }

    // ── Simulated Loading State ───────────────────────────────
    var isLoading by remember { mutableStateOf(true) }
    LaunchedEffect(sessionState.questions) {
        if (sessionState.questions.isNotEmpty()) {
            isLoading = false
        } else {
            delay(800) // If empty after 800ms, assume it's truly empty
            isLoading = false
        }
    }

    val currentQuestion = sessionState.currentQuestion
    if (isLoading) {
        // Skeleton Loading Screen
        Box(
            modifier = Modifier.fillMaxSize().background(colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val infiniteTransition = rememberInfiniteTransition(label = "skeleton")
                val alpha by infiniteTransition.animateFloat(
                    initialValue = 0.3f,
                    targetValue = 0.7f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(800, easing = LinearEasing),
                        repeatMode = RepeatMode.Reverse
                    ),
                    label = "alpha"
                )
                Box(modifier = Modifier.fillMaxWidth(0.8f).height(120.dp).clip(RoundedCornerShape(16.dp)).background(colorScheme.surfaceVariant.copy(alpha = alpha)))
                Box(modifier = Modifier.fillMaxWidth().height(60.dp).clip(RoundedCornerShape(12.dp)).background(colorScheme.surfaceVariant.copy(alpha = alpha)))
                Box(modifier = Modifier.fillMaxWidth().height(60.dp).clip(RoundedCornerShape(12.dp)).background(colorScheme.surfaceVariant.copy(alpha = alpha)))
                Box(modifier = Modifier.fillMaxWidth().height(60.dp).clip(RoundedCornerShape(12.dp)).background(colorScheme.surfaceVariant.copy(alpha = alpha)))
            }
        }
        return
    }

    if (currentQuestion == null) {
        // Empty state
        Box(
            modifier = Modifier.fillMaxSize().background(colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Icon(Icons.Outlined.Info, contentDescription = null, tint = colorScheme.primary, modifier = Modifier.size(48.dp))
                Text(
                    TranslationManager.getString("no_questions_found"),
                    style = MaterialTheme.typography.titleMedium,
                    color = colorScheme.onBackground
                )
                Button(
                    onClick = onBackPressed,
                    colors = ButtonDefaults.buttonColors(containerColor = colorScheme.primary),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(TranslationManager.getString("back"), style = MaterialTheme.typography.labelLarge)
                }
            }
        }
        return
    }

    val currentSelection = sessionState.getSelectionForIndex(sessionState.currentQuestionIndex)
    val isQuestionAnswered = sessionState.isQuestionAnswered(sessionState.currentQuestionIndex)

    // ── Per-question timer ────────────────────────────────────
    var questionTimeMs by remember(sessionState.currentQuestionIndex) { mutableStateOf(0L) }
    LaunchedEffect(sessionState.currentQuestionIndex, sessionState.isFinished, isQuestionAnswered) {
        if (!sessionState.isFinished && !isQuestionAnswered) {
            questionTimeMs = 0L
            while (true) {
                delay(100)
                questionTimeMs += 100
                if (timeLimitSeconds > 0 && questionTimeMs >= timeLimitSeconds * 1000L) {
                    sessionManager.selectOption(-1, questionTimeMs)
                    if (sessionState.mode == McqSessionMode.TEST) {
                        val isLast = sessionState.currentQuestionIndex >= sessionState.questions.size - 1
                        if (isLast) sessionManager.finishSession() else sessionManager.nextQuestion()
                    }
                    break
                }
            }
        }
    }

    // ── Wrong answer flash + haptic ───────────────────────────
    var flashColor by remember { mutableStateOf(Color.Transparent) }
    LaunchedEffect(sessionState.answeredQuestions.size) {
        if (sessionState.answeredQuestions.isNotEmpty()) {
            val lastAnswer = sessionState.answeredQuestions.lastOrNull()
            if (lastAnswer != null && !lastAnswer.isCorrect && sessionState.mode != McqSessionMode.TEST) {
                flashColor = colorScheme.errorContainer.copy(alpha = 0.4f)
                if (vibrationEnabled) {
                    try { hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress) } catch (_: Exception) {}
                }
                delay(200)
                flashColor = Color.Transparent
            }
        }
    }

    var showAddDialog by remember { mutableStateOf(false) }
    var showDeleteConfirm by remember { mutableStateOf(false) }
    var optionsMenuExpanded by remember { mutableStateOf(false) }

    // ── Overall session timer ──────────────────────────────────
    var elapsedSeconds by remember { mutableStateOf(0L) }
    LaunchedEffect(sessionState.isFinished) {
        if (!sessionState.isFinished) {
            while (!sessionState.isFinished) { delay(1000); elapsedSeconds++ }
        }
    }

    // ── Animated progress fraction ────────────────────────────
    val progressTarget = (sessionState.currentQuestionIndex + 1).toFloat() / sessionState.questions.size
    val animatedProgress by animateFloatAsState(
        targetValue = progressTarget,
        animationSpec = tween(durationMillis = 600, easing = FastOutSlowInEasing),
        label = "progress"
    )

    // ── Timer chip urgency color ───────────────────────────────
    val timeLimitMs = timeLimitSeconds * 1000L
    val remainingSecs = if (timeLimitSeconds > 0) maxOf(0L, (timeLimitMs - questionTimeMs + 999) / 1000) else 0L
    val isUrgent = timeLimitSeconds > 0 && !isQuestionAnswered && remainingSecs <= 10

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "AnkiPrep",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = androidx.compose.ui.text.font.FontWeight.Bold),
                            color = colorScheme.onSurface
                        )
                    },
                    navigationIcon = {
                        TextButton(onClick = onBackPressed) {
                            Icon(
                                Icons.Outlined.Close,
                                contentDescription = "Close",
                                tint = colorScheme.onSurface,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(Modifier.width(4.dp))
                            Text("close", style = MaterialTheme.typography.bodyMedium, color = colorScheme.onSurface)
                        }
                    },
                    actions = {
                        // Timer pill
                        if (timeLimitSeconds > 0 && !isQuestionAnswered) {
                            TimerChip(remainingSecs = remainingSecs, isUrgent = isUrgent)
                        } else {
                            Surface(
                                shape = RoundedCornerShape(50),
                                color = colorScheme.surfaceVariant,
                                modifier = Modifier.padding(end = 12.dp)
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Icon(Icons.Outlined.Timer, contentDescription = null, modifier = Modifier.size(14.dp), tint = colorScheme.onSurfaceVariant)
                                    Text(formatTime(elapsedSeconds), style = MaterialTheme.typography.labelMedium, color = colorScheme.onSurfaceVariant)
                                }
                            }
                        }
                        Box {
                            IconButton(onClick = { optionsMenuExpanded = true }) {
                                Icon(Icons.Outlined.MoreVert, contentDescription = "More", tint = colorScheme.onSurfaceVariant)
                            }
                            DropdownMenu(expanded = optionsMenuExpanded, onDismissRequest = { optionsMenuExpanded = false }) {
                                DropdownMenuItem(text = { Text("Add Card") }, leadingIcon = { Icon(Icons.Outlined.Add, null, tint = colorScheme.secondary) }, onClick = { optionsMenuExpanded = false; showAddDialog = true })
                                DropdownMenuItem(text = { Text("Edit Card") }, leadingIcon = { Icon(Icons.Outlined.Edit, null, tint = colorScheme.secondary) }, onClick = { optionsMenuExpanded = false; showEditSelectionDialog = true })
                                HorizontalDivider()
                                DropdownMenuItem(text = { Text("Delete Card", color = colorScheme.error) }, leadingIcon = { Icon(Icons.Outlined.Delete, null, tint = colorScheme.error) }, onClick = { optionsMenuExpanded = false; showDeleteConfirm = true })
                            }
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = colorScheme.background,
                        scrolledContainerColor = colorScheme.background
                    )
                )
            },
            bottomBar = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorScheme.background)
                        .padding(horizontal = 20.dp, vertical = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    if (sessionState.mode != McqSessionMode.PRACTICE) {
                        AdBanner(modifier = Modifier.fillMaxWidth(), text = "Quiz Ad")
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedButton(
                            onClick = { sessionManager.previousQuestion() },
                            enabled = sessionState.currentQuestionIndex > 0,
                            modifier = Modifier.weight(1f).height(48.dp),
                            shape = RoundedCornerShape(50),
                            border = BorderStroke(1.dp, if (sessionState.currentQuestionIndex > 0) colorScheme.outline else colorScheme.outlineVariant),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = colorScheme.onSurface),
                            contentPadding = PaddingValues(horizontal = 8.dp)
                        ) {
                            Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(Modifier.width(2.dp))
                            Text("Prev", style = MaterialTheme.typography.labelMedium)
                        }

                        Button(
                            onClick = { showSubmitConfirm = true },
                            modifier = Modifier.weight(1f).height(48.dp),
                            shape = RoundedCornerShape(50),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorScheme.primary,
                                contentColor = colorScheme.onPrimary
                            )
                        ) {
                            Text("Submit", style = MaterialTheme.typography.labelLarge)
                        }
                        
                        val isLastQ = sessionState.currentQuestionIndex >= sessionState.questions.size - 1
                        OutlinedButton(
                            onClick = { sessionManager.nextQuestion() },
                            enabled = !isLastQ,
                            modifier = Modifier.weight(1f).height(48.dp),
                            shape = RoundedCornerShape(50),
                            border = BorderStroke(1.dp, if (!isLastQ) colorScheme.outline else colorScheme.outlineVariant),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = colorScheme.onSurface),
                            contentPadding = PaddingValues(horizontal = 8.dp)
                        ) {
                            Text("Next", style = MaterialTheme.typography.labelMedium)
                            Spacer(Modifier.width(2.dp))
                            Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null, modifier = Modifier.size(16.dp))
                        }
                    }

                    if (sessionState.mode != com.example.flashcardapp.session.McqSessionMode.TEST && isQuestionAnswered && currentQuestion.explanation.isNotEmpty()) {
                        Button(
                            onClick = { /* scroll to explanation */ },
                            modifier = Modifier.fillMaxWidth().height(48.dp),
                            shape = RoundedCornerShape(50),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF00897B),
                                contentColor = Color.White
                            )
                        ) {
                            Icon(Icons.Outlined.Info, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(Modifier.width(8.dp))
                            Text("Explain Answer", style = MaterialTheme.typography.labelLarge)
                        }
                    }
                }
            },
            containerColor = colorScheme.background
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .pointerInput(Unit) {
                        var accumulatedDrag = 0f
                        detectHorizontalDragGestures(
                            onDragEnd = {
                                if (accumulatedDrag > 50) {
                                    if (sessionState.currentQuestionIndex > 0) {
                                        sessionManager.previousQuestion()
                                    }
                                } else if (accumulatedDrag < -50) {
                                    val isLastQ = sessionState.currentQuestionIndex >= sessionState.questions.size - 1
                                    if (!isLastQ) {
                                        sessionManager.nextQuestion()
                                    }
                                }
                                accumulatedDrag = 0f
                            }
                        ) { change, dragAmount ->
                            change.consume()
                            accumulatedDrag += dragAmount
                        }
                    },
                verticalArrangement = Arrangement.Top
            ) {
                // ── Progress label row ──
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "QUESTION ${sessionState.currentQuestionIndex + 1} OF ${sessionState.questions.size}",
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                        color = colorScheme.primary,
                        letterSpacing = 1.sp
                    )
                    Text(
                        text = "${(animatedProgress * 100).toInt()}% Completed",
                        style = MaterialTheme.typography.labelSmall,
                        color = colorScheme.onSurfaceVariant
                    )
                }
                // ── Progress bar ──
                LinearProgressIndicator(
                    progress = { animatedProgress },
                    modifier = Modifier.fillMaxWidth().height(4.dp),
                    color = colorScheme.primary,
                    trackColor = colorScheme.surfaceVariant
                )
                if (timeLimitSeconds > 0 && !isQuestionAnswered) {
                    val countdownFraction = maxOf(0f, 1f - (questionTimeMs.toFloat() / (timeLimitSeconds * 1000f)))
                    LinearProgressIndicator(
                        progress = { countdownFraction },
                        modifier = Modifier.fillMaxWidth().height(3.dp),
                        color = if (isUrgent) colorScheme.error else colorScheme.tertiary,
                        trackColor = Color.Transparent
                    )
                }

                // ── Question + Options + Explanation ──
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 20.dp, vertical = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    // ── Question text and Tags ──
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = currentQuestion.question,
                            style = MaterialTheme.typography.headlineSmall.copy(
                                fontWeight = FontWeight.Bold,
                                lineHeight = 34.sp
                            ),
                            color = colorScheme.onBackground
                        )

                        if (currentQuestion.tags.isNotEmpty()) {
                            Row(
                                horizontalArrangement = Arrangement.End,
                                modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                currentQuestion.tags.forEach { tag ->
                                    Surface(
                                        shape = RoundedCornerShape(4.dp),
                                        color = colorScheme.surfaceVariant.copy(alpha = 0.5f),
                                        border = BorderStroke(1.dp, colorScheme.outlineVariant.copy(alpha = 0.5f)),
                                        modifier = Modifier.padding(start = 4.dp)
                                    ) {
                                        Text(
                                            text = tag,
                                            style = MaterialTheme.typography.labelSmall,
                                            color = colorScheme.onSurfaceVariant,
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }

                    // ── Dynamic UI Media Sandbox Canvas ──
                    if (currentQuestion.frontImage != null) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .heightIn(max = 250.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            AsyncImage(
                                model = ImageStorageManager.getFullFile(context, currentQuestion.frontImage),
                                contentDescription = "Card Media",
                                modifier = Modifier.fillMaxWidth().heightIn(max = 250.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                    }

                    // ── Answer option cards ───────────────────
                    val optionLabels = listOf("A", "B", "C", "D", "E", "F")
                    currentQuestion.options.forEachIndexed { idx, option ->
                        val isSelected = currentSelection == idx
                        val isCorrectChoice = idx == currentQuestion.correctIndex
                        val showFeedback = sessionState.mode != McqSessionMode.TEST && isQuestionAnswered

                        QuizOptionCard(
                            label = optionLabels.getOrElse(idx) { (idx + 1).toString() },
                            text = option,
                            isSelected = isSelected,
                            isCorrect = showFeedback && isCorrectChoice,
                            isWrong = showFeedback && isSelected && !isCorrectChoice,
                            isEnabled = !isQuestionAnswered || sessionState.mode == McqSessionMode.TEST,
                            onClick = { sessionManager.selectOption(idx, questionTimeMs) },
                            vibrationEnabled = vibrationEnabled
                        )
                    }

                    // ── Explanation panel ─────────────────────
                    val showExplanation = showExplanations
                        && sessionState.mode != McqSessionMode.TEST
                        && isQuestionAnswered
                        && currentQuestion.explanation.isNotEmpty()

                    AnimatedVisibility(
                        visible = showExplanation,
                        enter = expandVertically(animationSpec = tween(300)) + fadeIn(animationSpec = tween(300)),
                        exit = shrinkVertically(animationSpec = tween(200)) + fadeOut(animationSpec = tween(200))
                    ) {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = MaterialTheme.shapes.medium,
                            colors = CardDefaults.cardColors(containerColor = colorScheme.tertiaryContainer),
                            border = BorderStroke(1.dp, colorScheme.tertiary.copy(alpha = 0.3f))
                        ) {
                            Row(
                                modifier = Modifier.padding(16.dp),
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                Icon(
                                    Icons.Outlined.Info,
                                    contentDescription = null,
                                    tint = colorScheme.tertiary,
                                    modifier = Modifier.size(20.dp).padding(top = 2.dp)
                                )
                                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                    Text(
                                        text = TranslationManager.getString("explanation"),
                                        style = MaterialTheme.typography.labelLarge,
                                        color = colorScheme.onTertiaryContainer
                                    )
                                    Text(
                                        text = currentQuestion.explanation,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = colorScheme.onTertiaryContainer.copy(alpha = 0.85f),
                                        lineHeight = 20.sp
                                    )
                                    if (currentQuestion.backImage != null) {
                                        AsyncImage(
                                            model = ImageStorageManager.getFullFile(context, currentQuestion.backImage),
                                            contentDescription = "Back Image",
                                            modifier = Modifier.fillMaxWidth().heightIn(max = 200.dp).padding(top = 8.dp),
                                            contentScale = ContentScale.Inside
                                        )
                                    }
                                    if (currentQuestion.explanationImage != null) {
                                        AsyncImage(
                                            model = ImageStorageManager.getFullFile(context, currentQuestion.explanationImage),
                                            contentDescription = "Explanation Image",
                                            modifier = Modifier.fillMaxWidth().heightIn(max = 200.dp).padding(top = 8.dp),
                                            contentScale = ContentScale.Inside
                                        )
                                    }
                                }
                            }
                        }
                    }
                    
                    // Explanation panel moved to bottom of scroll area
                }
            }
        }

        // Flash overlay
        if (flashColor != Color.Transparent) {
            Box(modifier = Modifier.fillMaxSize().background(flashColor))
        }

        if (showEditSelectionDialog) {
            EditModeSelectionDialog(
                onDismiss = { showEditSelectionDialog = false },
                onEditCurrent = { showEditDialog = true },
                onEditWholePack = { showWholePackScreen = true }
            )
        }
        
        if (showEditDialog) {
            val originalCard = cards.find { it.id == currentQuestion.sourceCardId }
            val initialTags = originalCard?.let { repo.parseTags(it.tags).joinToString(", ") } ?: ""
            McqEditorDialog(
                initialQuestion = currentQuestion.question,
                initialCorrectAnswer = currentQuestion.correctAnswer,
                initialOptions = currentQuestion.options,
                initialExplanation = currentQuestion.explanation,
                initialTags = initialTags,
                initialFrontImage = originalCard?.frontImage,
                initialBackImage = originalCard?.backImage,
                initialExplanationImage = originalCard?.explanationImage,
                initialOptionImagesJson = originalCard?.optionImagesJson,
                title = "Edit Card",
                onDismiss = { showEditDialog = false },
                onSave = { newFront, newBack, newTags, frontImg, backImg, explImg, optImgs ->
                    coroutineScope.launch {
                        repo.upsertOverride(
                            CardOverrideEntity(
                                cardId = currentQuestion.sourceCardId,
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
                        val parsed = com.example.flashcardapp.data.core.StructuredParser.parseCard(newFront, newBack)
                        val parsedTagsList = repo.parseTags(newTags)
                        val newCorrectAnswer = parsed.answer.ifEmpty { newBack.substringBefore("|").substringBefore(";").trim() }
                        val newOptions = currentQuestion.options.toMutableList()
                        if (currentQuestion.correctIndex in newOptions.indices) {
                            newOptions[currentQuestion.correctIndex] = newCorrectAnswer
                        }
                        val updatedMcq = currentQuestion.copy(
                            question = parsed.question.ifEmpty { newFront.trim() },
                            options = newOptions,
                            explanation = parsed.explanation,
                            tags = parsedTagsList,
                            frontImage = frontImg,
                            backImage = backImg,
                            explanationImage = explImg,
                            optionImagesJson = optImgs
                        )
                        sessionManager.updateCurrentQuestion(updatedMcq)
                        Toast.makeText(context, "Card updated!", Toast.LENGTH_SHORT).show()
                    }
                },
                onPrevious = { sessionManager.previousQuestion() },
                onNext = { sessionManager.nextQuestion() },
                hasPrevious = sessionState.currentQuestionIndex > 0,
                hasNext = sessionState.currentQuestionIndex < sessionState.questions.size - 1
            )
        }
        
        if (showAddDialog) {
            McqEditorDialog(
                initialQuestion = "",
                initialCorrectAnswer = "",
                initialOptions = emptyList(),
                initialExplanation = "",
                title = "Add Card",
                onDismiss = { showAddDialog = false },
                onSave = { front, back, newTags, frontImg, backImg, explImg, optImgs ->
                    coroutineScope.launch {
                        currentQuestion?.let {
                            val newCardId = repo.addCard(
                                deckHierarchy = it.deckHierarchy,
                                front = front,
                                back = back,
                                tagsJson = newTags,
                                frontImage = frontImg,
                                backImage = backImg,
                                explanationImage = explImg,
                                optionImagesJson = optImgs
                            )
                            val newCard = repo.getCardById(newCardId)
                            if (newCard != null) {
                                val engine = com.example.flashcardapp.mcq.McqEngine()
                                val allCards = repo.getAllCards()
                                val generated = engine.generate(allCards, listOf(newCard)).firstOrNull()
                                if (generated != null) {
                                    sessionManager.insertNextQuestion(generated)
                                }
                            }
                            Toast.makeText(context, "Card added!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            )
        }
        
        if (showDeleteConfirm) {
            AlertDialog(
                onDismissRequest = { showDeleteConfirm = false },
                title = { Text("Delete Card") },
                text = { Text("Are you sure you want to delete this card? This action cannot be undone.") },
                confirmButton = {
                    TextButton(onClick = {
                        showDeleteConfirm = false
                        coroutineScope.launch {
                            currentQuestion?.let {
                                repo.deleteCard(it.sourceCardId)
                                Toast.makeText(context, "Card deleted!", Toast.LENGTH_SHORT).show()
                                sessionManager.deleteCurrentQuestion()
                            }
                        }
                    }) {
                        Text("Delete", color = colorScheme.error)
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDeleteConfirm = false }) {
                        Text("Cancel")
                    }
                }
            )
        }

        if (showSubmitConfirm) {
            AlertDialog(
                onDismissRequest = { showSubmitConfirm = false },
                title = { Text(TranslationManager.getString("submit_quiz")) },
                text = { Text(TranslationManager.getString("submit_quiz_desc")) },
                confirmButton = {
                    TextButton(onClick = {
                        showSubmitConfirm = false
                        sessionManager.finishSession()
                    }) {
                        Text(TranslationManager.getString("finish_quiz"), color = colorScheme.primary)
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showSubmitConfirm = false }) {
                        Text(TranslationManager.getString("keep_studying"))
                    }
                }
            )
        }
    }
}

// ═══════════════════════════════════════════════════════════════
//  QUIZ OPTION CARD — M3 Claymorphic with letter badge
// ═══════════════════════════════════════════════════════════════

@Composable
private fun QuizOptionCard(
    label: String,
    text: String,
    isSelected: Boolean,
    isCorrect: Boolean,
    isWrong: Boolean,
    isEnabled: Boolean,
    onClick: () -> Unit,
    vibrationEnabled: Boolean
) {
    val colorScheme = MaterialTheme.colorScheme
    val hapticFeedback = LocalHapticFeedback.current

    // Animated scale for press feedback
    val interactionSource = remember { MutableInteractionSource() }

    // Scale spring on correct answer
    val scale by animateFloatAsState(
        targetValue = if (isCorrect) 1.0f else 1.0f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow),
        label = "optionScale"
    )

    // Colors based on state
    val containerColor = when {
        isCorrect -> CorrectBg
        isWrong -> IncorrectBg
        isSelected -> colorScheme.primaryContainer
        else -> colorScheme.surface
    }
    val borderColor = when {
        isCorrect -> CorrectColor
        isWrong -> IncorrectColor
        isSelected -> colorScheme.primary
        else -> colorScheme.outlineVariant
    }
    val borderWidth = if (isCorrect || isWrong || isSelected) 2.dp else 1.dp
    val badgeBg = when {
        isCorrect -> CorrectColor
        isWrong -> IncorrectColor
        isSelected -> colorScheme.primary
        else -> colorScheme.surfaceVariant
    }
    val badgeText = when {
        isCorrect -> CorrectColor.copy(alpha = 0f) // icon replaces label
        isWrong -> IncorrectColor.copy(alpha = 0f)
        isSelected -> colorScheme.onPrimary
        else -> colorScheme.onSurfaceVariant
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .scale(scale)
            .clickable(
                enabled = isEnabled,
                interactionSource = interactionSource,
                indication = null
            ) {
                if (vibrationEnabled) {
                    try { hapticFeedback.performHapticFeedback(HapticFeedbackType.TextHandleMove) } catch (_: Exception) {}
                }
                onClick()
            },
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = containerColor),
        border = BorderStroke(borderWidth, borderColor),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isSelected || isCorrect || isWrong) 0.dp else 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 64.dp)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Letter badge — rounded square (matches mockup)
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(badgeBg),
                contentAlignment = Alignment.Center
            ) {
                when {
                    isCorrect -> Icon(Icons.Outlined.CheckCircle, contentDescription = "Correct", tint = Color.White, modifier = Modifier.size(20.dp))
                    isWrong -> Icon(Icons.Outlined.Close, contentDescription = "Incorrect", tint = Color.White, modifier = Modifier.size(20.dp))
                    else -> Text(
                        text = label,
                        style = MaterialTheme.typography.labelLarge,
                        color = if (isSelected) colorScheme.onPrimary else colorScheme.onSurfaceVariant,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Option text
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                color = when {
                    isCorrect -> CorrectColor
                    isWrong -> IncorrectColor
                    isSelected -> colorScheme.onPrimaryContainer
                    else -> colorScheme.onSurface
                },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

// ═══════════════════════════════════════════════════════════════
//  QUIZ NAVIGATION ROW
// ═══════════════════════════════════════════════════════════════

@Composable
private fun QuizNavRow(
    sessionState: McqSessionState,
    isQuestionAnswered: Boolean,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    onEdit: () -> Unit = {}
) {
    val colorScheme = MaterialTheme.colorScheme
    val isLastQuestion = sessionState.currentQuestionIndex >= sessionState.questions.size - 1
    val nextEnabled = when {
        sessionState.mode == McqSessionMode.TEST -> true
        else -> isQuestionAnswered
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Previous button
        OutlinedButton(
            onClick = onPrevious,
            enabled = sessionState.currentQuestionIndex > 0,
            shape = MaterialTheme.shapes.medium,
            border = BorderStroke(
                1.dp,
                if (sessionState.currentQuestionIndex > 0) colorScheme.primary else colorScheme.outline.copy(alpha = 0.4f)
            ),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = colorScheme.primary),
            modifier = Modifier.height(48.dp)
        ) {
            Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "Previous", modifier = Modifier.size(20.dp))
            Spacer(Modifier.width(4.dp))
            Text(TranslationManager.getString("back"), style = MaterialTheme.typography.labelLarge)
        }

        if (sessionState.mode == McqSessionMode.PRACTICE && isQuestionAnswered) {
            OutlinedButton(
                onClick = onEdit,
                shape = MaterialTheme.shapes.medium,
                border = BorderStroke(1.dp, colorScheme.primary),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = colorScheme.primary),
                modifier = Modifier.height(48.dp).padding(horizontal = 4.dp),
                contentPadding = PaddingValues(horizontal = 12.dp)
            ) {
                Icon(Icons.Outlined.Edit, contentDescription = "Edit", modifier = Modifier.size(20.dp))
            }
        }

        // Next / Finish button (flex-fill)
        Button(
            onClick = onNext,
            enabled = nextEnabled,
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(
                containerColor = colorScheme.primary,
                contentColor = colorScheme.onPrimary,
                disabledContainerColor = colorScheme.surfaceVariant,
                disabledContentColor = colorScheme.onSurfaceVariant
            ),
            modifier = Modifier.weight(1f).height(48.dp)
        ) {
            Text(
                text = if (isLastQuestion) TranslationManager.getString("finish_quiz")
                       else TranslationManager.getString("next_question"),
                style = MaterialTheme.typography.labelLarge
            )
            Spacer(Modifier.width(4.dp))
            Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null, modifier = Modifier.size(20.dp))
        }
    }
}

// ═══════════════════════════════════════════════════════════════
//  TIMER CHIP — Pulses red when urgent
// ═══════════════════════════════════════════════════════════════

@Composable
private fun TimerChip(remainingSecs: Long, isUrgent: Boolean) {
    val colorScheme = MaterialTheme.colorScheme

    val pulseAlpha by rememberInfiniteTransition(label = "pulse").animateFloat(
        initialValue = 1f,
        targetValue = if (isUrgent) 0.5f else 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "timerPulse"
    )

    SuggestionChip(
        onClick = {},
        label = {
            Text(
                text = TranslationManager.getString("time_limit_sec_short", remainingSecs),
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold
            )
        },
        icon = {
            Icon(Icons.Outlined.Timer, contentDescription = null, modifier = Modifier.size(16.dp))
        },
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor = if (isUrgent) colorScheme.errorContainer else colorScheme.surfaceVariant,
            labelColor = if (isUrgent) colorScheme.error else colorScheme.onSurfaceVariant,
            iconContentColor = if (isUrgent) colorScheme.error else colorScheme.onSurfaceVariant
        ),
        border = BorderStroke(
            if (isUrgent) 1.dp else 0.dp,
            if (isUrgent) colorScheme.error.copy(alpha = pulseAlpha) else Color.Transparent
        ),
        modifier = Modifier
            .padding(end = 8.dp)
    )
}

private fun formatTime(seconds: Long): String {
    val mins = seconds / 60
    val secs = seconds % 60
    return String.format("%02d:%02d", mins, secs)
}

@Composable
fun EditModeSelectionDialog(
    onDismiss: () -> Unit,
    onEditCurrent: () -> Unit,
    onEditWholePack: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                "Edit Card",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSurface
            )
        },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        onEditCurrent()
                        onDismiss()
                    },
                    modifier = Modifier.fillMaxWidth().height(48.dp),
                    shape = RoundedCornerShape(50)
                ) {
                    Text("Edit this question", style = MaterialTheme.typography.labelLarge)
                }
                OutlinedButton(
                    onClick = {
                        onEditWholePack()
                        onDismiss()
                    },
                    modifier = Modifier.fillMaxWidth().height(48.dp),
                    shape = RoundedCornerShape(50),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
                ) {
                    Text("Open the whole pack", style = MaterialTheme.typography.labelLarge)
                }
            }
        },
        confirmButton = {},
        dismissButton = null,
        shape = MaterialTheme.shapes.large,
        containerColor = MaterialTheme.colorScheme.surface
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditWholePackScreen(
    deckName: String,
    cards: List<CardEntity>,
    onCardClick: (CardEntity) -> Unit,
    onBackPressed: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    var searchQuery by remember { mutableStateOf("") }

    val filteredCards = remember(cards, searchQuery) {
        if (searchQuery.isBlank()) {
            cards
        } else {
            cards.filter { card ->
                val parsed = com.example.flashcardapp.data.core.StructuredParser.parseCard(card.front, card.back)
                val question = parsed.question.ifEmpty { card.front }
                val answer = parsed.answer
                val explanation = parsed.explanation
                val tags = try {
                    val type = object : com.google.gson.reflect.TypeToken<List<String>>() {}.type
                    com.google.gson.Gson().fromJson<List<String>>(card.tags, type) ?: emptyList()
                } catch (_: Exception) {
                    emptyList()
                }

                question.contains(searchQuery, ignoreCase = true) ||
                        answer.contains(searchQuery, ignoreCase = true) ||
                        explanation.contains(searchQuery, ignoreCase = true) ||
                        tags.any { it.contains(searchQuery, ignoreCase = true) }
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Edit Pack: $deckName",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = colorScheme.onSurface
                        )
                        Text(
                            text = "All the questions in this pack",
                            style = MaterialTheme.typography.labelSmall,
                            color = colorScheme.onSurfaceVariant
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = colorScheme.background)
            )
        },
        containerColor = colorScheme.background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            // Search field
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Search by tag, subtopic, question, answer, etc.") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
                singleLine = true,
                leadingIcon = { Icon(Icons.Outlined.Search, contentDescription = "Search") },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = colorScheme.primary,
                    focusedLabelColor = colorScheme.primary
                )
            )

            // Table Header Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorScheme.surfaceVariant)
                    .padding(vertical = 12.dp, horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Question",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorScheme.onSurfaceVariant,
                    modifier = Modifier.weight(0.3f)
                )
                Text(
                    text = "Answer",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorScheme.onSurfaceVariant,
                    modifier = Modifier.weight(0.25f)
                )
                Text(
                    text = "Explanation",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorScheme.onSurfaceVariant,
                    modifier = Modifier.weight(0.25f)
                )
                Text(
                    text = "Tags",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorScheme.onSurfaceVariant,
                    modifier = Modifier.weight(0.2f)
                )
            }

            // Scrollable List of Cards (Rows)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                if (filteredCards.isEmpty()) {
                    Box(
                        modifier = Modifier.fillMaxWidth().padding(48.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "No questions found in this pack.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = colorScheme.onSurfaceVariant
                        )
                    }
                } else {
                    filteredCards.forEachIndexed { index, card ->
                        val parsed = remember(card.front, card.back) {
                            com.example.flashcardapp.data.core.StructuredParser.parseCard(card.front, card.back)
                        }
                        val questionDisplay = parsed.question.ifEmpty { card.front.trim() }
                        val answerDisplay = parsed.answer
                        val explanationDisplay = parsed.explanation
                        val tagsList = remember(card.tags) {
                            try {
                                val type = object : com.google.gson.reflect.TypeToken<List<String>>() {}.type
                                com.google.gson.Gson().fromJson<List<String>>(card.tags, type) ?: emptyList()
                            } catch (_: Exception) {
                                emptyList()
                            }
                        }

                        val rowBg = if (index % 2 == 0) colorScheme.surface else colorScheme.surface.copy(alpha = 0.6f)

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(rowBg)
                                .clickable { onCardClick(card) }
                                .padding(vertical = 12.dp, horizontal = 8.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = questionDisplay,
                                style = MaterialTheme.typography.bodyMedium,
                                color = colorScheme.onSurface,
                                maxLines = 2,
                                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                                modifier = Modifier.weight(0.3f)
                            )
                            Text(
                                text = answerDisplay,
                                style = MaterialTheme.typography.bodyMedium,
                                color = colorScheme.onSurface,
                                maxLines = 2,
                                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                                modifier = Modifier.weight(0.25f)
                            )
                            Text(
                                text = explanationDisplay.ifEmpty { "None" },
                                style = MaterialTheme.typography.bodyMedium,
                                color = colorScheme.onSurfaceVariant,
                                maxLines = 2,
                                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                                modifier = Modifier.weight(0.25f)
                            )
                            Text(
                                text = tagsList.joinToString(", ").ifEmpty { "None" },
                                style = MaterialTheme.typography.bodyMedium,
                                color = colorScheme.onSurfaceVariant,
                                maxLines = 2,
                                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                                modifier = Modifier.weight(0.2f)
                            )
                        }
                        HorizontalDivider(color = colorScheme.outlineVariant.copy(alpha = 0.3f))
                    }
                }
            }
        }
    }
}


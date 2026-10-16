package com.example.flashcardapp.ui

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.changedToDown
import kotlin.math.roundToInt
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
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
    isDarkMode: Boolean,
    onDarkModeToggle: (Boolean) -> Unit,
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

    // Whiteboard state variables
    var isWhiteBoardActive by remember { mutableStateOf(false) }
    val whiteboardStrokes = remember { mutableStateListOf<DrawingStroke>() }
    var currentStrokePoints by remember { mutableStateOf<List<Offset>>(emptyList()) }
    var isEraserMode by remember { mutableStateOf(false) }
    var eraserIndicatorPosition by remember { mutableStateOf<Offset?>(null) }
    var penType by remember { mutableStateOf("Pen") } // Pen, Highlighter
    var shapeType by remember { mutableStateOf("Freeform") } // Freeform, Rectangle, Circle
    var isToolbarExpanded by remember { mutableStateOf(true) }
    var toolbarOffset by remember { mutableStateOf(Offset.Zero) }

    val settingsRepo = remember { com.example.flashcardapp.data.SettingsRepository.getInstance(context) }
    val activity = context as? android.app.Activity
    DisposableEffect(settingsRepo.keepScreenAwakeDuringQuiz) {
        if (settingsRepo.keepScreenAwakeDuringQuiz) {
            activity?.window?.addFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        }
        onDispose {
            activity?.window?.clearFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        }
    }
    val defaultPenColorStr = remember { settingsRepo.whiteboardDefaultPenColor }
    val autoStylusMode = remember { settingsRepo.whiteboardAutoStylusMode }
    val highlighterAlpha = remember { settingsRepo.whiteboardHighlighterAlpha }
    val whiteboardToolbarPosition = remember { settingsRepo.whiteboardToolbarPosition }
    val whiteboardOneFingerDoubleTapAction = remember { settingsRepo.whiteboardOneFingerDoubleTapAction }
    val whiteboardTwoFingerSingleTapAction = remember { settingsRepo.whiteboardTwoFingerSingleTapAction }
    val whiteboardTwoFingerDoubleTapAction = remember { settingsRepo.whiteboardTwoFingerDoubleTapAction }
    val whiteboardThreeFingerSingleTapAction = remember { settingsRepo.whiteboardThreeFingerSingleTapAction }
    val whiteboardThreeFingerDoubleTapAction = remember { settingsRepo.whiteboardThreeFingerDoubleTapAction }

    val triggerWhiteboardAction: (String) -> Unit = { action ->
        when (action) {
            "CLEAR" -> whiteboardStrokes.clear()
            "UNDO" -> {
                if (whiteboardStrokes.isNotEmpty()) {
                    whiteboardStrokes.removeAt(whiteboardStrokes.size - 1)
                }
            }
            "TOGGLE" -> isWhiteBoardActive = !isWhiteBoardActive
        }
    }

    var isQuestionTranslated by remember { mutableStateOf(false) }

    val initialPenColor = remember(defaultPenColorStr, isDarkMode) {
        when (defaultPenColorStr) {
            "RED" -> Color.Red
            "BLUE" -> Color(0xFF2196F3)
            "GREEN" -> Color(0xFF4CAF50)
            else -> if (isDarkMode) Color.White else Color.Black
        }
    }
    var activePenColor by remember(initialPenColor) { mutableStateOf(initialPenColor) }
    var activePenSize by remember { mutableFloatStateOf(6f) }

    val erasePointsNear: (Offset, Float) -> Unit = { pos, radius ->
        val radiusSq = radius * radius
        whiteboardStrokes.removeAll { stroke ->
            stroke.points.any { p ->
                val dx = p.x - pos.x
                val dy = p.y - pos.y
                (dx * dx + dy * dy) <= radiusSq
            }
        }
    }

    var userRating by remember { mutableStateOf(0) }

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
            val parsed = remember(selectedPackCard.front, selectedPackCard.back, selectedPackCard.tags) {
                com.example.flashcardapp.data.core.StructuredParser.parseCard(selectedPackCard.front, selectedPackCard.back, selectedPackCard.tags)
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

    LaunchedEffect(currentQuestion) {
        if (currentQuestion != null) {
            val metadata = repo.getCardUserMetadata(currentQuestion.sourceCardId)
            userRating = metadata.rating
        } else {
            userRating = 0
        }
        if (settingsRepo.whiteboardAutoClearOnNext) {
            whiteboardStrokes.clear()
        }
    }
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

    val hasTranslation = remember(currentQuestion) {
        !currentQuestion.translationQuestion.isNullOrBlank() ||
        currentQuestion.question.contains(" ||| ") ||
        !currentQuestion.translationExplanation.isNullOrBlank()
    }

    val rawQuestionToDisplay = if (isQuestionTranslated) {
        if (!currentQuestion.translationQuestion.isNullOrBlank()) {
            currentQuestion.translationQuestion
        } else if (currentQuestion.question.contains(" ||| ")) {
            val parts = currentQuestion.question.split(" ||| ", limit = 2)
            if (parts.size > 1) parts[1].trim() else parts[0].trim()
        } else {
            currentQuestion.question
        }
    } else {
        if (currentQuestion.question.contains(" ||| ")) {
            val parts = currentQuestion.question.split(" ||| ", limit = 2)
            parts[0].trim()
        } else {
            currentQuestion.question
        }
    }

    val displayOptions = if (isQuestionTranslated && !currentQuestion.translationOptions.isNullOrEmpty()) {
        currentQuestion.translationOptions
    } else {
        currentQuestion.options
    }

    val explanationToDisplay = if (isQuestionTranslated && !currentQuestion.translationExplanation.isNullOrBlank()) {
        currentQuestion.translationExplanation
    } else {
        currentQuestion.explanation
    }

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

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(
                isWhiteBoardActive,
                whiteboardOneFingerDoubleTapAction,
                whiteboardTwoFingerSingleTapAction,
                whiteboardTwoFingerDoubleTapAction,
                whiteboardThreeFingerSingleTapAction,
                whiteboardThreeFingerDoubleTapAction
            ) {
                awaitPointerEventScope {
                    var lastTapTime = 0L
                    var lastTapFingerCount = 0
                    while (true) {
                        val downEvent = awaitPointerEvent(androidx.compose.ui.input.pointer.PointerEventPass.Initial)
                        if (downEvent.changes.any { it.changedToDown() }) {
                            var maxPointers = downEvent.changes.count { it.pressed }
                            val startTime = System.currentTimeMillis()
                            while (System.currentTimeMillis() - startTime < 40) {
                                val nextEvent = awaitPointerEvent(androidx.compose.ui.input.pointer.PointerEventPass.Initial)
                                maxPointers = maxOf(maxPointers, nextEvent.changes.count { it.pressed })
                            }
                            var releasedAll = false
                            while (!releasedAll) {
                                val upEvent = awaitPointerEvent(androidx.compose.ui.input.pointer.PointerEventPass.Initial)
                                if (upEvent.changes.none { it.pressed }) {
                                    releasedAll = true
                                }
                            }
                            val now = System.currentTimeMillis()
                            if (now - lastTapTime < 300 && lastTapFingerCount == maxPointers) {
                                when (maxPointers) {
                                    1 -> if (whiteboardOneFingerDoubleTapAction != "NONE") {
                                        triggerWhiteboardAction(whiteboardOneFingerDoubleTapAction)
                                    }
                                    2 -> if (whiteboardTwoFingerDoubleTapAction != "NONE") {
                                        triggerWhiteboardAction(whiteboardTwoFingerDoubleTapAction)
                                    }
                                    3 -> if (whiteboardThreeFingerDoubleTapAction != "NONE") {
                                        triggerWhiteboardAction(whiteboardThreeFingerDoubleTapAction)
                                    }
                                }
                                lastTapTime = 0L
                                lastTapFingerCount = 0
                            } else {
                                when (maxPointers) {
                                    2 -> if (whiteboardTwoFingerSingleTapAction != "NONE") {
                                        triggerWhiteboardAction(whiteboardTwoFingerSingleTapAction)
                                    }
                                    3 -> if (whiteboardThreeFingerSingleTapAction != "NONE") {
                                        triggerWhiteboardAction(whiteboardThreeFingerSingleTapAction)
                                    }
                                }
                                lastTapTime = now
                                lastTapFingerCount = maxPointers
                            }
                        }
                    }
                }
            }
    ) {
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
                        // Whiteboard toggle button
                        IconButton(onClick = { isWhiteBoardActive = !isWhiteBoardActive }) {
                            Icon(
                                imageVector = Icons.Outlined.Gesture,
                                contentDescription = "Whiteboard",
                                tint = if (isWhiteBoardActive) colorScheme.primary else colorScheme.onSurfaceVariant
                            )
                        }

                        // Dark mode toggle button
                        IconButton(onClick = { onDarkModeToggle(!isDarkMode) }) {
                            Icon(
                                imageVector = if (isDarkMode) Icons.Outlined.WbSunny else Icons.Outlined.DarkMode,
                                contentDescription = "Toggle Dark Mode",
                                tint = colorScheme.onSurfaceVariant
                            )
                        }

                        // Mid-test Translate icon button
                        if (hasTranslation) {
                            IconButton(onClick = { isQuestionTranslated = !isQuestionTranslated }) {
                                Icon(
                                    imageVector = Icons.Outlined.Translate,
                                    contentDescription = "Toggle Translation",
                                    tint = if (isQuestionTranslated) colorScheme.primary else colorScheme.onSurfaceVariant
                                )
                            }
                        }

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

                    if (sessionState.mode != com.example.flashcardapp.session.McqSessionMode.TEST && isQuestionAnswered && explanationToDisplay.isNotEmpty()) {
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
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    // ── Active Tag Filter Banner ──
                    if (!sessionState.activeTagFilter.isNullOrBlank()) {
                        Surface(
                            shape = RoundedCornerShape(50),
                            color = colorScheme.primaryContainer,
                            border = BorderStroke(1.dp, colorScheme.primary),
                            modifier = Modifier.padding(bottom = 8.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp),
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                            ) {
                                Icon(
                                    Icons.Outlined.FilterList,
                                    contentDescription = null,
                                    tint = colorScheme.primary,
                                    modifier = Modifier.size(16.dp)
                                )
                                Text(
                                    text = "Tag: #${sessionState.activeTagFilter}",
                                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                                    color = colorScheme.onPrimaryContainer
                                )
                                IconButton(
                                    onClick = { sessionManager.filterByTag(null) },
                                    modifier = Modifier.size(18.dp)
                                ) {
                                    Icon(
                                        Icons.Default.Close,
                                        contentDescription = "Clear tag filter",
                                        tint = colorScheme.primary,
                                        modifier = Modifier.size(14.dp)
                                    )
                                }
                            }
                        }
                    }

                    // ── Question Card Container ──
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = colorScheme.surfaceVariant.copy(alpha = 0.35f)
                        ),
                        border = BorderStroke(1.dp, colorScheme.outlineVariant.copy(alpha = 0.6f))
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            // Top Row: Question number and top-right Translate toggle
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Question ${sessionState.currentQuestionIndex + 1}/${sessionState.questions.size}",
                                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
                                    color = colorScheme.primary
                                )

                                if (hasTranslation) {
                                    Surface(
                                        shape = RoundedCornerShape(20.dp),
                                        color = if (isQuestionTranslated) colorScheme.primary else colorScheme.primaryContainer.copy(alpha = 0.7f),
                                        border = BorderStroke(1.dp, if (isQuestionTranslated) colorScheme.primary else colorScheme.outline.copy(alpha = 0.4f)),
                                        modifier = Modifier.clickable {
                                            isQuestionTranslated = !isQuestionTranslated
                                        }
                                    ) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                        ) {
                                            Icon(
                                                Icons.Outlined.Translate,
                                                contentDescription = "Translate question",
                                                tint = if (isQuestionTranslated) colorScheme.onPrimary else colorScheme.primary,
                                                modifier = Modifier.size(16.dp)
                                            )
                                            Text(
                                                text = if (isQuestionTranslated) "Original" else "हिन्दी / Translate",
                                                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                                                color = if (isQuestionTranslated) colorScheme.onPrimary else colorScheme.primary
                                            )
                                        }
                                    }
                                }
                            }

                            val cleanQuestionText = remember(rawQuestionToDisplay) {
                                val unstripped = ImageStorageManager.cleanImageTagsFromText(rawQuestionToDisplay)
                                if (unstripped.contains("|") && !unstripped.contains(" ||| ")) {
                                    val parts = unstripped.split("|").map { it.trim() }
                                    parts.lastOrNull { it.length > 15 || it.endsWith("?") }
                                        ?: parts.firstOrNull { it.isNotEmpty() }
                                        ?: unstripped
                                } else {
                                    unstripped
                                }
                            }
                            Text(
                                text = cleanQuestionText,
                                style = MaterialTheme.typography.titleLarge.copy(
                                    fontWeight = FontWeight.Bold,
                                    lineHeight = 28.sp
                                ),
                                color = colorScheme.onSurface
                            )

                            if (currentQuestion.tags.isNotEmpty()) {
                                Row(
                                    horizontalArrangement = Arrangement.Start,
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Tags: ",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
                                        modifier = Modifier.padding(end = 4.dp)
                                    )
                                    currentQuestion.tags.forEach { tag ->
                                        val isTagActive = sessionState.activeTagFilter.equals(tag, ignoreCase = true)
                                        Surface(
                                            shape = RoundedCornerShape(10.dp),
                                            color = if (isTagActive) colorScheme.primary else colorScheme.surface.copy(alpha = 0.8f),
                                            border = BorderStroke(
                                                1.dp,
                                                if (isTagActive) colorScheme.primary else colorScheme.outlineVariant.copy(alpha = 0.5f)
                                            ),
                                            modifier = Modifier
                                                .padding(end = 6.dp)
                                                .clickable {
                                                    if (isTagActive) sessionManager.filterByTag(null)
                                                    else sessionManager.filterByTag(tag)
                                                }
                                        ) {
                                            Text(
                                                text = "#$tag",
                                                style = MaterialTheme.typography.labelSmall.copy(
                                                    fontWeight = if (isTagActive) FontWeight.Bold else FontWeight.Normal
                                                ),
                                                color = if (isTagActive) colorScheme.onPrimary else colorScheme.onSurfaceVariant,
                                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                            )
                                        }
                                    }
                                }
                            }

                            val questionImages = remember(currentQuestion.frontImage, currentQuestion.question) {
                                val list = mutableListOf<String>()
                                currentQuestion.frontImage?.let { if (it.isNotBlank()) list.add(it) }
                                val embedded = ImageStorageManager.extractEmbeddedImageSources(currentQuestion.question)
                                embedded.forEach { if (it !in list) list.add(it) }
                                list
                            }

                            questionImages.forEach { imgPath ->
                                val resolvedModel = ImageStorageManager.resolveImageModel(context, imgPath)
                                if (resolvedModel != null) {
                                    AsyncImage(
                                        model = resolvedModel,
                                        contentDescription = "Question Media",
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 6.dp)
                                            .heightIn(max = 280.dp)
                                            .clip(RoundedCornerShape(12.dp)),
                                        contentScale = ContentScale.Fit
                                    )
                                }
                            }
                        }
                    }

                    // ── Answer option cards ───────────────────
                    val optionLabels = listOf("A", "B", "C", "D", "E", "F")
                    val optionImages = remember(currentQuestion.optionImagesJson) {
                        if (currentQuestion.optionImagesJson.isNullOrBlank()) emptyList<String>()
                        else {
                            try {
                                com.google.gson.Gson().fromJson<List<String>>(
                                    currentQuestion.optionImagesJson,
                                    object : com.google.gson.reflect.TypeToken<List<String>>() {}.type
                                ) ?: emptyList<String>()
                            } catch (_: Exception) {
                                emptyList<String>()
                            }
                        }
                    }

                    displayOptions.forEachIndexed { idx, option ->
                        val isSelected = currentSelection == idx
                        val isCorrectChoice = idx == currentQuestion.correctIndex
                        val showFeedback = sessionState.mode != McqSessionMode.TEST && isQuestionAnswered

                        var imageUrl = optionImages.getOrNull(idx)
                        if (imageUrl.isNullOrBlank()) {
                            val embedded = ImageStorageManager.extractEmbeddedImageSources(option)
                            if (embedded.isNotEmpty()) {
                                imageUrl = embedded.first()
                            }
                        }

                        QuizOptionCard(
                            label = optionLabels.getOrElse(idx) { (idx + 1).toString() },
                            text = option,
                            imageUrl = imageUrl,
                            isSelected = isSelected,
                            isCorrect = showFeedback && isCorrectChoice,
                            isWrong = showFeedback && isSelected && !isCorrectChoice,
                            isEnabled = !isQuestionAnswered || sessionState.mode == McqSessionMode.TEST,
                            onClick = { sessionManager.selectOption(idx, questionTimeMs) },
                            vibrationEnabled = vibrationEnabled
                        )
                    }

                    // ── 5-Star Rating Bar ─────────────────────
                    if (isQuestionAnswered) {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = MaterialTheme.shapes.medium,
                            colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceVariant.copy(alpha = 0.3f)),
                            border = BorderStroke(1.dp, colorScheme.outlineVariant)
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text(
                                    text = "Rate this question's difficulty/relevance:",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = colorScheme.onSurface
                                )
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    for (i in 1..5) {
                                        val isHighlighted = i <= userRating
                                        Icon(
                                            imageVector = if (isHighlighted) Icons.Filled.Star else Icons.Outlined.StarBorder,
                                            contentDescription = "Rate $i stars",
                                            tint = if (isHighlighted) Color(0xFFFFD700) else colorScheme.onSurfaceVariant.copy(alpha = 0.4f),
                                            modifier = Modifier
                                                .size(36.dp)
                                                .clickable {
                                                    userRating = i
                                                    coroutineScope.launch {
                                                        repo.setCardRating(currentQuestion.sourceCardId, i)
                                                    }
                                                }
                                        )
                                    }
                                }
                            }
                        }
                    }

                    // ── Explanation panel ─────────────────────
                    val showExplanation = showExplanations
                        && sessionState.mode != McqSessionMode.TEST
                        && isQuestionAnswered
                        && explanationToDisplay.isNotEmpty()

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
                                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                    Text(
                                        text = TranslationManager.getString("explanation"),
                                        style = MaterialTheme.typography.labelLarge,
                                        color = colorScheme.onTertiaryContainer
                                    )
                                    
                                    val cleanExplanation = remember(explanationToDisplay) {
                                        ImageStorageManager.cleanImageTagsFromText(explanationToDisplay)
                                    }
                                    if (cleanExplanation.isNotEmpty()) {
                                        Text(
                                            text = cleanExplanation,
                                            style = MaterialTheme.typography.bodyMedium,
                                            color = colorScheme.onTertiaryContainer.copy(alpha = 0.85f),
                                            lineHeight = 20.sp
                                        )
                                    }

                                    val explanationImages = remember(
                                        currentQuestion.backImage,
                                        currentQuestion.explanationImage,
                                        currentQuestion.explanation
                                    ) {
                                        val list = mutableListOf<String>()
                                        currentQuestion.backImage?.let { if (it.isNotBlank()) list.add(it) }
                                        currentQuestion.explanationImage?.let { if (it.isNotBlank() && it !in list) list.add(it) }
                                        val embedded = ImageStorageManager.extractEmbeddedImageSources(currentQuestion.explanation)
                                        embedded.forEach { if (it !in list) list.add(it) }
                                        list
                                    }

                                    explanationImages.forEach { imgPath ->
                                        val resolvedModel = ImageStorageManager.resolveImageModel(context, imgPath)
                                        if (resolvedModel != null) {
                                            Box(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(top = 6.dp)
                                                    .clip(RoundedCornerShape(12.dp))
                                                    .background(colorScheme.surface.copy(alpha = 0.5f)),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                AsyncImage(
                                                    model = resolvedModel,
                                                    contentDescription = "Full Explanation Image",
                                                    modifier = Modifier.fillMaxWidth(),
                                                    contentScale = ContentScale.FillWidth
                                                )
                                            }
                                        }
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
                        val parsed = com.example.flashcardapp.data.core.StructuredParser.parseCard(newFront, newBack, newTags)
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

        // ── Whiteboard Canvas Overlay ─────────────────────────
        if (isWhiteBoardActive) {
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(isEraserMode, activePenSize, activePenColor, penType, shapeType) {
                        detectDragGestures(
                            onDragStart = { pos ->
                                if (!isEraserMode) {
                                    currentStrokePoints = listOf(pos)
                                } else {
                                    eraserIndicatorPosition = pos
                                    erasePointsNear(pos, activePenSize * 1.5f)
                                }
                            },
                            onDrag = { change, dragAmount ->
                                change.consume()
                                val pos = change.position
                                if (!isEraserMode) {
                                    if (shapeType == "Freeform") {
                                        currentStrokePoints = currentStrokePoints + pos
                                    } else {
                                        currentStrokePoints = if (currentStrokePoints.isEmpty()) listOf(pos) else listOf(currentStrokePoints.first(), pos)
                                    }
                                } else {
                                    eraserIndicatorPosition = pos
                                    erasePointsNear(pos, activePenSize * 1.5f)
                                }
                            },
                            onDragEnd = {
                                eraserIndicatorPosition = null
                                if (!isEraserMode && currentStrokePoints.size >= 2) {
                                    val alpha = if (penType == "Highlighter") highlighterAlpha else 1f
                                    val strokeT = when (shapeType) {
                                        "Circle" -> StrokeType.CIRCLE
                                        "Rectangle" -> StrokeType.RECTANGLE
                                        else -> StrokeType.FREEFORM
                                    }
                                    whiteboardStrokes.add(
                                        DrawingStroke(
                                            points = currentStrokePoints,
                                            color = activePenColor.copy(alpha = alpha),
                                            strokeWidth = activePenSize,
                                            type = strokeT
                                        )
                                    )
                                    currentStrokePoints = emptyList()
                                } else {
                                    currentStrokePoints = emptyList()
                                }
                            }
                        )
                    }
            ) {
                // Draw completed strokes
                whiteboardStrokes.forEach { stroke ->
                    drawPath(
                        path = stroke.path,
                        color = stroke.color,
                        style = Stroke(
                            width = stroke.strokeWidth,
                            cap = StrokeCap.Round,
                            join = StrokeJoin.Round
                        )
                    )
                }
                // Draw current stroke
                if (currentStrokePoints.size >= 2) {
                    val alpha = if (penType == "Highlighter") highlighterAlpha else 1f
                    val strokeT = when (shapeType) {
                        "Circle" -> StrokeType.CIRCLE
                        "Rectangle" -> StrokeType.RECTANGLE
                        else -> StrokeType.FREEFORM
                    }
                    val tempStroke = DrawingStroke(
                        points = currentStrokePoints,
                        color = activePenColor.copy(alpha = alpha),
                        strokeWidth = activePenSize,
                        type = strokeT
                    )
                    drawPath(
                        path = tempStroke.path,
                        color = tempStroke.color,
                        style = Stroke(
                            width = tempStroke.strokeWidth,
                            cap = StrokeCap.Round,
                            join = StrokeJoin.Round
                        )
                    )
                }
                // Draw eraser indicator
                eraserIndicatorPosition?.let { pos ->
                    drawCircle(
                        color = Color.Gray.copy(alpha = 0.5f),
                        radius = activePenSize * 1.5f,
                        center = pos
                    )
                }
            }

            // ── Floating Draggable Toolbar ──
            val defaultAlignment = when (whiteboardToolbarPosition) {
                "LEFT" -> Alignment.CenterStart
                "RIGHT" -> Alignment.CenterEnd
                "TOP" -> Alignment.TopCenter
                "BOTTOM" -> Alignment.BottomCenter
                else -> Alignment.BottomEnd
            }

            val defaultPadding = when (whiteboardToolbarPosition) {
                "LEFT" -> Modifier.padding(start = 16.dp)
                "RIGHT" -> Modifier.padding(end = 16.dp)
                "TOP" -> Modifier.padding(top = 80.dp)
                "BOTTOM" -> Modifier.padding(bottom = 90.dp)
                else -> Modifier.padding(end = 24.dp, bottom = 100.dp)
            }

            val activeToolIcon = when {
                isEraserMode -> Icons.Outlined.CleaningServices
                shapeType == "Circle" -> Icons.Outlined.Circle
                shapeType == "Rectangle" -> Icons.Outlined.CropSquare
                penType == "Highlighter" -> Icons.Outlined.Brush
                else -> Icons.Outlined.Gesture
            }

            val isVertical = whiteboardToolbarPosition == "LEFT" || 
                             whiteboardToolbarPosition == "RIGHT" || 
                             whiteboardToolbarPosition == "FLOATING"

            Surface(
                modifier = Modifier
                    .align(defaultAlignment)
                    .then(defaultPadding)
                    .offset {
                        androidx.compose.ui.unit.IntOffset(
                            toolbarOffset.x.roundToInt(),
                            toolbarOffset.y.roundToInt()
                        )
                    }
                    .wrapContentSize(),
                shape = RoundedCornerShape(24.dp),
                color = colorScheme.surfaceVariant,
                border = BorderStroke(1.dp, colorScheme.outlineVariant),
                shadowElevation = 10.dp
            ) {
                val contentBlock = @Composable {
                    // Button 1: Main tool indicator (Toggle Expand/Collapse)
                    IconButton(
                        onClick = { isToolbarExpanded = !isToolbarExpanded },
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = colorScheme.primary.copy(alpha = 0.1f)
                        )
                    ) {
                        Icon(
                            imageVector = activeToolIcon,
                            contentDescription = "Active Tool",
                            tint = colorScheme.primary
                        )
                    }

                    if (isToolbarExpanded) {
                        // Divider
                        if (isVertical) {
                            HorizontalDivider(modifier = Modifier.width(24.dp), color = colorScheme.outlineVariant)
                        } else {
                            VerticalDivider(modifier = Modifier.height(24.dp), color = colorScheme.outlineVariant)
                        }

                        // Pen Button
                        IconButton(
                            onClick = { isEraserMode = false; penType = "Pen"; shapeType = "Freeform" },
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = if (!isEraserMode && penType == "Pen" && shapeType == "Freeform") colorScheme.primaryContainer else Color.Transparent
                            )
                        ) {
                            Icon(
                                Icons.Outlined.Gesture,
                                contentDescription = "Standard Pen",
                                tint = if (!isEraserMode && penType == "Pen" && shapeType == "Freeform") colorScheme.onPrimaryContainer else colorScheme.onSurface
                            )
                        }

                        // Highlighter Button
                        IconButton(
                            onClick = { isEraserMode = false; penType = "Highlighter"; shapeType = "Freeform" },
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = if (!isEraserMode && penType == "Highlighter" && shapeType == "Freeform") colorScheme.primaryContainer else Color.Transparent
                            )
                        ) {
                            Icon(
                                Icons.Outlined.Brush,
                                contentDescription = "Highlighter",
                                tint = if (!isEraserMode && penType == "Highlighter" && shapeType == "Freeform") colorScheme.onPrimaryContainer else colorScheme.onSurface
                            )
                        }

                        // Eraser Button
                        IconButton(
                            onClick = { isEraserMode = true },
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = if (isEraserMode) colorScheme.primaryContainer else Color.Transparent
                            )
                        ) {
                            Icon(
                                Icons.Outlined.CleaningServices,
                                contentDescription = "Eraser",
                                tint = if (isEraserMode) colorScheme.onPrimaryContainer else colorScheme.onSurface
                            )
                        }

                        // Circle Button
                        IconButton(
                            onClick = { isEraserMode = false; penType = "Pen"; shapeType = "Circle" },
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = if (!isEraserMode && shapeType == "Circle") colorScheme.primaryContainer else Color.Transparent
                            )
                        ) {
                            Icon(
                                Icons.Outlined.Circle,
                                contentDescription = "Draw Circle",
                                tint = if (!isEraserMode && shapeType == "Circle") colorScheme.onPrimaryContainer else colorScheme.onSurface
                            )
                        }

                        // Square/Rectangle Button
                        IconButton(
                            onClick = { isEraserMode = false; penType = "Pen"; shapeType = "Rectangle" },
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = if (!isEraserMode && shapeType == "Rectangle") colorScheme.primaryContainer else Color.Transparent
                            )
                        ) {
                            Icon(
                                Icons.Outlined.CropSquare,
                                contentDescription = "Draw Rectangle",
                                tint = if (!isEraserMode && shapeType == "Rectangle") colorScheme.onPrimaryContainer else colorScheme.onSurface
                            )
                        }

                        // Divider
                        if (isVertical) {
                            HorizontalDivider(modifier = Modifier.width(24.dp), color = colorScheme.outlineVariant)
                        } else {
                            VerticalDivider(modifier = Modifier.height(24.dp), color = colorScheme.outlineVariant)
                        }

                        // Color presets selection
                        val colors = listOf(
                            if (isDarkMode) Color.White else Color.Black,
                            Color.Red,
                            Color(0xFF2196F3),
                            Color(0xFF4CAF50)
                        )
                        colors.forEach { color ->
                            val isColorSelected = activePenColor == color && !isEraserMode
                            Box(
                                modifier = Modifier
                                    .size(24.dp)
                                    .clip(CircleShape)
                                    .background(color)
                                    .border(
                                        width = if (isColorSelected) 2.dp else 1.dp,
                                        color = if (isColorSelected) colorScheme.primary else Color.Gray.copy(alpha = 0.5f),
                                        shape = CircleShape
                                    )
                                    .clickable {
                                        isEraserMode = false
                                        activePenColor = color
                                    }
                            )
                        }

                        // Divider
                        if (isVertical) {
                            HorizontalDivider(modifier = Modifier.width(24.dp), color = colorScheme.outlineVariant)
                        } else {
                            VerticalDivider(modifier = Modifier.height(24.dp), color = colorScheme.outlineVariant)
                        }

                        // Brush thickness preset toggle
                        val sizes = listOf(4f, 8f, 16f)
                        sizes.forEach { size ->
                            val isSizeSelected = activePenSize == size && !isEraserMode
                            Box(
                                modifier = Modifier
                                    .size(24.dp)
                                    .clip(CircleShape)
                                    .background(if (isSizeSelected) colorScheme.primaryContainer else Color.Transparent)
                                    .clickable {
                                        activePenSize = size
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size((size / 2f + 4f).dp)
                                        .clip(CircleShape)
                                        .background(if (isSizeSelected) colorScheme.onPrimaryContainer else colorScheme.onSurface)
                                )
                            }
                        }

                        // Divider
                        if (isVertical) {
                            HorizontalDivider(modifier = Modifier.width(24.dp), color = colorScheme.outlineVariant)
                        } else {
                            VerticalDivider(modifier = Modifier.height(24.dp), color = colorScheme.outlineVariant)
                        }

                        // Clear button
                        IconButton(onClick = { whiteboardStrokes.clear() }) {
                            Icon(Icons.Outlined.Delete, contentDescription = "Clear All", tint = colorScheme.error)
                        }

                        // Exit button
                        IconButton(onClick = { isWhiteBoardActive = false }) {
                            Icon(Icons.Outlined.Close, contentDescription = "Exit Whiteboard", tint = colorScheme.error)
                        }
                    }
                }

                if (isVertical) {
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .pointerInput(Unit) {
                                detectDragGestures { change, dragAmount ->
                                    change.consume()
                                    toolbarOffset = toolbarOffset + dragAmount
                                }
                            },
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        contentBlock()
                    }
                } else {
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                            .pointerInput(Unit) {
                                detectDragGestures { change, dragAmount ->
                                    change.consume()
                                    toolbarOffset = toolbarOffset + dragAmount
                                }
                            },
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        contentBlock()
                    }
                }
            }
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
    imageUrl: String? = null,
    isSelected: Boolean,
    isCorrect: Boolean,
    isWrong: Boolean,
    isEnabled: Boolean,
    onClick: () -> Unit,
    vibrationEnabled: Boolean
) {
    val colorScheme = MaterialTheme.colorScheme
    val context = LocalContext.current
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
        Column(modifier = Modifier.fillMaxWidth()) {
            // Render Option Banner if imageUrl is present
            if (!imageUrl.isNullOrBlank()) {
                val resolvedModel = remember(imageUrl) { ImageStorageManager.resolveImageModel(context, imageUrl) }
                if (resolvedModel != null) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(110.dp)
                            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    ) {
                        AsyncImage(
                            model = resolvedModel,
                            contentDescription = "Option Banner Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(110.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 56.dp)
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

                // Clean option text (strip embedded HTML/Markdown tags)
                val cleanOptionText = remember(text) { ImageStorageManager.cleanImageTagsFromText(text) }
                val displayText = cleanOptionText.ifEmpty {
                    if (!imageUrl.isNullOrBlank()) "Option Image" else text
                }

                Text(
                    text = displayText,
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
                val parsed = com.example.flashcardapp.data.core.StructuredParser.parseCard(card.front, card.back, card.tags)
                val question = parsed.question.ifEmpty { card.front }
                val answer = parsed.answer
                val explanation = parsed.explanation
                val tags = if (parsed.tags.isNotEmpty()) parsed.tags else {
                    try {
                        val type = object : com.google.gson.reflect.TypeToken<List<String>>() {}.type
                        com.google.gson.Gson().fromJson<List<String>>(card.tags, type) ?: emptyList()
                    } catch (_: Exception) {
                        emptyList()
                    }
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
                        val parsed = remember(card.front, card.back, card.tags) {
                            com.example.flashcardapp.data.core.StructuredParser.parseCard(card.front, card.back, card.tags)
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

// ═══════════════════════════════════════════════════════════════
//  DRAWING STROKE DATA MODEL
// ═══════════════════════════════════════════════════════════════
enum class StrokeType { FREEFORM, RECTANGLE, CIRCLE }

data class DrawingStroke(
    val points: List<Offset>,
    val color: Color,
    val strokeWidth: Float = 6f,
    val type: StrokeType = StrokeType.FREEFORM
) {
    val path: Path by lazy {
        val p = Path()
        when (type) {
            StrokeType.FREEFORM -> {
                if (points.size >= 2) {
                    p.moveTo(points.first().x, points.first().y)
                    for (i in 1 until points.size) {
                        p.lineTo(points[i].x, points[i].y)
                    }
                }
            }
            StrokeType.RECTANGLE -> {
                if (points.size >= 2) {
                    val start = points.first()
                    val end = points.last()
                    val left = minOf(start.x, end.x)
                    val top = minOf(start.y, end.y)
                    val right = maxOf(start.x, end.x)
                    val bottom = maxOf(start.y, end.y)
                    p.addRect(androidx.compose.ui.geometry.Rect(left, top, right, bottom))
                }
            }
            StrokeType.CIRCLE -> {
                if (points.size >= 2) {
                    val start = points.first()
                    val end = points.last()
                    val dx = end.x - start.x
                    val dy = end.y - start.y
                    val radius = kotlin.math.sqrt(dx * dx + dy * dy)
                    p.addOval(androidx.compose.ui.geometry.Rect(start.x - radius, start.y - radius, start.x + radius, start.y + radius))
                }
            }
        }
        p
    }
}


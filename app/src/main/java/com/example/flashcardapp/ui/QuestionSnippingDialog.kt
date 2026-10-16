package com.example.flashcardapp.ui

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.flashcardapp.data.AnkiDataRepository
import com.example.flashcardapp.data.PdfImporter
import com.example.flashcardapp.data.core.PyqTextNormalizer
import com.example.flashcardapp.data.entities.CardEntity
import com.google.android.gms.tasks.Tasks
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionSnippingDialog(
    initialDeckId: Long,
    initialDeckName: String,
    onDismiss: () -> Unit,
    onCardCreated: (CardEntity) -> Unit
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val repo = remember { AnkiDataRepository.getInstance(context) }

    var selectedBitmap by remember { mutableStateOf<Bitmap?>(null) }
    var isExtracting by remember { mutableStateOf(false) }

    // Extracted Card Form
    var extractedQuestion by remember { mutableStateOf("") }
    var extractedOptA by remember { mutableStateOf("") }
    var extractedOptB by remember { mutableStateOf("") }
    var extractedOptC by remember { mutableStateOf("") }
    var extractedOptD by remember { mutableStateOf("") }
    var extractedAnswer by remember { mutableStateOf("A") }
    var extractedExplanation by remember { mutableStateOf("") }
    var showReviewSheet by remember { mutableStateOf(false) }

    // Gallery Picker Launcher
    val galleryPicker = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        if (uri != null) {
            coroutineScope.launch(Dispatchers.IO) {
                try {
                    context.contentResolver.openInputStream(uri)?.use { stream ->
                        val bmp = BitmapFactory.decodeStream(stream)
                        withContext(Dispatchers.Main) {
                            selectedBitmap = bmp
                        }
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(context, "Failed to load image: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colorScheme.surface
        ) {
            if (showReviewSheet) {
                // Card Review & Edit Form
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text("Review Extracted MCQ Card", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Text("Deck: $initialDeckName", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)
                    Spacer(Modifier.height(12.dp))

                    OutlinedTextField(
                        value = extractedQuestion,
                        onValueChange = { extractedQuestion = it },
                        label = { Text("Question Statement") },
                        modifier = Modifier.fillMaxWidth(),
                        minLines = 3
                    )
                    Spacer(Modifier.height(8.dp))

                    OutlinedTextField(
                        value = extractedOptA,
                        onValueChange = { extractedOptA = it },
                        label = { Text("Option A") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(6.dp))

                    OutlinedTextField(
                        value = extractedOptB,
                        onValueChange = { extractedOptB = it },
                        label = { Text("Option B") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(6.dp))

                    OutlinedTextField(
                        value = extractedOptC,
                        onValueChange = { extractedOptC = it },
                        label = { Text("Option C") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(6.dp))

                    OutlinedTextField(
                        value = extractedOptD,
                        onValueChange = { extractedOptD = it },
                        label = { Text("Option D") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(8.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("Correct Option: ", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        listOf("A", "B", "C", "D").forEach { opt ->
                            FilterChip(
                                selected = extractedAnswer == opt,
                                onClick = { extractedAnswer = opt },
                                label = { Text(opt) },
                                modifier = Modifier.padding(horizontal = 4.dp)
                            )
                        }
                    }

                    Spacer(Modifier.height(8.dp))
                    OutlinedTextField(
                        value = extractedExplanation,
                        onValueChange = { extractedExplanation = it },
                        label = { Text("Explanation (Optional)") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(onClick = { showReviewSheet = false }) {
                            Text("Re-Crop")
                        }
                        Spacer(Modifier.width(8.dp))
                        Button(
                            onClick = {
                                coroutineScope.launch {
                                    val targetAns = when (extractedAnswer) {
                                        "A" -> extractedOptA
                                        "B" -> extractedOptB
                                        "C" -> extractedOptC
                                        "D" -> extractedOptD
                                        else -> extractedOptA
                                    }
                                    val distractors = listOf(extractedOptA, extractedOptB, extractedOptC, extractedOptD)
                                        .filter { it != targetAns }
                                    val back = buildString {
                                        append(targetAns)
                                        append(" | ")
                                        append(distractors.joinToString(" | "))
                                        if (extractedExplanation.isNotBlank()) {
                                            append(" {explain} ")
                                            append(extractedExplanation)
                                        }
                                    }
                                    val cardId = repo.addCard(
                                        deckHierarchy = initialDeckName,
                                        front = extractedQuestion.trim(),
                                        back = back,
                                        tagsJson = "[\"$initialDeckName\"]"
                                    )
                                    val newCard = CardEntity(
                                        id = cardId,
                                        noteId = cardId,
                                        deckId = initialDeckId,
                                        front = extractedQuestion.trim(),
                                        back = back,
                                        tags = initialDeckName,
                                        deckHierarchy = initialDeckName
                                    )
                                    Toast.makeText(context, "Card saved to $initialDeckName!", Toast.LENGTH_SHORT).show()
                                    onCardCreated(newCard)
                                    onDismiss()
                                }
                            },
                            enabled = extractedQuestion.isNotBlank() && extractedOptA.isNotBlank()
                        ) {
                            Text("Save to Deck")
                        }
                    }
                }
            } else if (selectedBitmap == null) {
                // Select Image View
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        Icons.Default.CropFree,
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(Modifier.height(16.dp))
                    Text(
                        "Offline Question Snipper",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Select a photo of an exam paper or textbook. Crop the question to instantly extract an MCQ card with on-device OCR.",
                        textAlign = TextAlign.Center,
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.height(24.dp))

                    Button(
                        onClick = { galleryPicker.launch("image/*") },
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Icon(Icons.Default.PhotoLibrary, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text("Pick Image from Gallery")
                    }
                    Spacer(Modifier.height(12.dp))
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }
                }
            } else {
                // Interactive Crop View
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Adjust Crop Rectangle", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        IconButton(onClick = { selectedBitmap = null }) {
                            Icon(Icons.Default.Close, contentDescription = "Close")
                        }
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .background(Color.Black, RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        InteractiveCropCanvas(
                            bitmap = selectedBitmap!!,
                            onExtract = { cropped ->
                                isExtracting = true
                                coroutineScope.launch(Dispatchers.IO) {
                                    try {
                                        val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
                                        val inputImage = InputImage.fromBitmap(cropped, 0)
                                        val visionText = Tasks.await(recognizer.process(inputImage), 20, TimeUnit.SECONDS)
                                        val rawText = visionText.text
                                        recognizer.close()

                                        val normalized = PyqTextNormalizer.normalizeText(rawText)
                                        val cards = PdfImporter.parseExtractedQuestions(normalized, initialDeckName, initialDeckId)

                                        withContext(Dispatchers.Main) {
                                            isExtracting = false
                                            if (cards.isNotEmpty()) {
                                                val c = cards.first()
                                                extractedQuestion = c.front
                                                val parts = c.back.split(" {explain} ")
                                                val optionsParts = parts[0].split(" | ")
                                                extractedOptA = optionsParts.getOrElse(0) { "" }
                                                extractedOptB = optionsParts.getOrElse(1) { "" }
                                                extractedOptC = optionsParts.getOrElse(2) { "" }
                                                extractedOptD = optionsParts.getOrElse(3) { "" }
                                                extractedExplanation = if (parts.size > 1) parts[1] else ""
                                                showReviewSheet = true
                                            } else {
                                                extractedQuestion = normalized
                                                showReviewSheet = true
                                            }
                                        }
                                    } catch (e: Exception) {
                                        withContext(Dispatchers.Main) {
                                            isExtracting = false
                                            Toast.makeText(context, "OCR Extraction error: ${e.message}", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                                }
                            }
                        )

                        if (isExtracting) {
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f),
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Row(
                                    modifier = Modifier.padding(16.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    CircularProgressIndicator(modifier = Modifier.size(24.dp))
                                    Spacer(Modifier.width(12.dp))
                                    Text("Running bundled offline OCR...", fontSize = 13.sp)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * Interactive canvas displaying bitmap with an adjustable crop box.
 */
@Composable
fun InteractiveCropCanvas(
    bitmap: Bitmap,
    onExtract: (Bitmap) -> Unit
) {
    var cropTopLeft by remember { mutableStateOf(Offset(50f, 50f)) }
    var cropSize by remember { mutableStateOf(Size(300f, 200f)) }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        cropTopLeft += dragAmount
                    }
                }
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val imgBmp = bitmap.asImageBitmap()
                // Draw scaled bitmap
                drawImage(imgBmp)

                // Draw crop rectangle
                drawRect(
                    color = Color.Yellow,
                    topLeft = cropTopLeft,
                    size = cropSize,
                    style = Stroke(width = 3.dp.toPx())
                )
            }
        }

        Surface(
            color = MaterialTheme.colorScheme.surface,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Drag box over question", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                Button(
                    onClick = {
                        val x = cropTopLeft.x.toInt().coerceIn(0, bitmap.width - 1)
                        val y = cropTopLeft.y.toInt().coerceIn(0, bitmap.height - 1)
                        val w = cropSize.width.toInt().coerceAtMost(bitmap.width - x).coerceAtLeast(10)
                        val h = cropSize.height.toInt().coerceAtMost(bitmap.height - y).coerceAtLeast(10)

                        val cropped = Bitmap.createBitmap(bitmap, x, y, w, h)
                        onExtract(cropped)
                    },
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Icon(Icons.Default.Check, contentDescription = null)
                    Spacer(Modifier.width(6.dp))
                    Text("Extract Question")
                }
            }
        }
    }
}

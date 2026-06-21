package com.example.flashcardapp.ui

import android.graphics.BitmapFactory
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.flashcardapp.data.ImageStorageManager
import com.example.flashcardapp.data.TranslationManager
import java.io.File

@Composable
fun LocalImagePreview(
    relativePath: String,
    modifier: Modifier = Modifier
) {
    val context = androidx.compose.ui.platform.LocalContext.current
    val imageBitmap = remember(relativePath) {
        try {
            val file = ImageStorageManager.getFullFile(context, relativePath)
            if (file.exists() && file.isFile) {
                val bitmap = BitmapFactory.decodeFile(file.absolutePath)
                bitmap?.asImageBitmap()
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }

    if (imageBitmap != null) {
        Image(
            bitmap = imageBitmap,
            contentDescription = "Image preview",
            modifier = modifier,
            contentScale = ContentScale.Crop
        )
    } else {
        Box(
            modifier = modifier.background(MaterialTheme.colorScheme.surfaceVariant),
            contentAlignment = Alignment.Center
        ) {
            Text("No Image", style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun ImageFieldPicker(
    label: String,
    currentImagePath: String?,
    onImagePicked: (String) -> Unit,
    onImageRemoved: () -> Unit
) {
    val context = androidx.compose.ui.platform.LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let {
            val path = ImageStorageManager.copyImageToLocalStorage(context, it)
            if (path != null) {
                onImagePicked(path)
            }
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (currentImagePath != null) {
            LocalImagePreview(
                relativePath = currentImagePath,
                modifier = Modifier.size(64.dp).clip(RoundedCornerShape(8.dp))
            )
            OutlinedButton(
                onClick = onImageRemoved,
                colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.error)
            ) {
                Text("Remove $label Image")
            }
        } else {
            OutlinedButton(
                onClick = { launcher.launch("image/*") }
            ) {
                Text("+ Add $label Image")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun McqEditorDialog(
    initialQuestion: String = "",
    initialCorrectAnswer: String = "",
    initialOptions: List<String> = emptyList(),
    initialExplanation: String = "",
    initialTags: String = "",
    initialFrontImage: String? = null,
    initialBackImage: String? = null,
    initialExplanationImage: String? = null,
    initialOptionImagesJson: String? = null,
    title: String = "Edit Card",
    onDismiss: () -> Unit,
    onSave: (
        front: String,
        back: String,
        tagsJson: String,
        frontImage: String?,
        backImage: String?,
        explanationImage: String?,
        optionImagesJson: String?
    ) -> Unit,
    onPrevious: (() -> Unit)? = null,
    onNext: (() -> Unit)? = null,
    hasPrevious: Boolean = false,
    hasNext: Boolean = false
) {
    var questionText by remember(initialQuestion) { mutableStateOf(initialQuestion) }
    var correctAnswer by remember(initialCorrectAnswer) { mutableStateOf(initialCorrectAnswer) }
    
    val initialDistractors = remember(initialOptions, initialCorrectAnswer) {
        initialOptions.filter { it != initialCorrectAnswer }.joinToString("\n")
    }
    var distractorsText by remember(initialDistractors) { mutableStateOf(initialDistractors) }
    
    var explanationText by remember(initialExplanation) { mutableStateOf(initialExplanation) }
    var tagsText by remember(initialTags) { mutableStateOf(initialTags) }
    var isMcqType by remember(initialOptions) { mutableStateOf(initialOptions.isNotEmpty()) }

    var frontImage by remember(initialFrontImage) { mutableStateOf(initialFrontImage) }
    var backImage by remember(initialBackImage) { mutableStateOf(initialBackImage) }
    var explanationImage by remember(initialExplanationImage) { mutableStateOf(initialExplanationImage) }

    val initialOptionImages = remember(initialOptionImagesJson) {
        if (initialOptionImagesJson.isNullOrBlank()) {
            emptyList<String>()
        } else {
            try {
                val tokenType = object : com.google.gson.reflect.TypeToken<List<String>>() {}.type
                com.google.gson.Gson().fromJson<List<String>>(initialOptionImagesJson, tokenType) ?: emptyList()
            } catch (e: Exception) {
                emptyList()
            }
        }
    }
    var optionImagesList by remember(initialOptionImages) { mutableStateOf(initialOptionImages) }

    var addMoreMode by remember { mutableStateOf(false) }
    val context = androidx.compose.ui.platform.LocalContext.current

    fun saveCurrent() {
        val opts = if (isMcqType) {
            distractorsText.split("\n").map { it.trim() }.filter { it.isNotEmpty() }
        } else {
            emptyList()
        }
        val optsString = if (opts.isNotEmpty()) "|" + opts.joinToString("|") else ""
        val explString = if (explanationText.isNotBlank()) "; ${explanationText.trim()}" else ""
        
        val newBack = "${correctAnswer.trim()}$optsString$explString"
        
        val tagsList = tagsText.split(",").map { it.trim() }.filter { it.isNotEmpty() }
        val tagsJson = com.google.gson.Gson().toJson(tagsList)
        
        val optionImagesJson = if (isMcqType && optionImagesList.isNotEmpty()) {
            com.google.gson.Gson().toJson(optionImagesList)
        } else {
            null
        }
        
        onSave(
            questionText.trim(),
            newBack,
            tagsJson,
            frontImage,
            backImage,
            explanationImage,
            optionImagesJson
        )

        if (addMoreMode) {
            // Reset fields but keep tags and dialog open
            questionText = ""
            correctAnswer = ""
            distractorsText = ""
            explanationText = ""
            frontImage = null
            backImage = null
            explanationImage = null
            optionImagesList = emptyList()
        }
    }

    androidx.compose.ui.window.Dialog(
        onDismissRequest = onDismiss
    ) {
        Surface(
            shape = MaterialTheme.shapes.extraLarge,
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 6.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(title, style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.onSurface)

                // Card Type Selector
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { isMcqType = false },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (!isMcqType) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
                            contentColor = if (!isMcqType) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("One-Liner")
                    }
                    Button(
                        onClick = { isMcqType = true },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isMcqType) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
                            contentColor = if (isMcqType) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("MCQ")
                    }
                }
 
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, fill = false)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedTextField(
                        value = tagsText,
                        onValueChange = { tagsText = it },
                        label = { Text("Tags (comma-separated)") },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("e.g. geography, capitals") }
                    )
                    
                    OutlinedTextField(
                        value = questionText,
                        onValueChange = { questionText = it },
                        label = { Text("Question") },
                        modifier = Modifier.fillMaxWidth(),
                        minLines = 2
                    )

                    ImageFieldPicker(
                        label = "Question",
                        currentImagePath = frontImage,
                        onImagePicked = { frontImage = it },
                        onImageRemoved = { frontImage = null }
                    )

                    OutlinedTextField(
                        value = correctAnswer,
                        onValueChange = { correctAnswer = it },
                        label = { Text("Correct Answer") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    ImageFieldPicker(
                        label = "Answer",
                        currentImagePath = backImage,
                        onImagePicked = { backImage = it },
                        onImageRemoved = { backImage = null }
                    )

                    if (isMcqType) {
                        OutlinedTextField(
                            value = distractorsText,
                            onValueChange = { distractorsText = it },
                            label = { Text("Distractors (one per line)") },
                            modifier = Modifier.fillMaxWidth(),
                            minLines = 3
                        )

                        Text("Distractor Images", style = MaterialTheme.typography.bodyMedium, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
                        optionImagesList.forEachIndexed { index, imgPath ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                LocalImagePreview(relativePath = imgPath, modifier = Modifier.size(48.dp).clip(RoundedCornerShape(8.dp)))
                                Text("Image ${index + 1}", modifier = Modifier.weight(1f))
                                IconButton(onClick = { optionImagesList = optionImagesList.toMutableList().apply { removeAt(index) } }) {
                                    Icon(Icons.Outlined.Delete, contentDescription = "Delete", tint = MaterialTheme.colorScheme.error)
                                }
                            }
                        }
                        if (optionImagesList.size < 4) {
                            val optionImageLauncher = rememberLauncherForActivityResult(
                                contract = ActivityResultContracts.GetContent()
                            ) { uri ->
                                uri?.let {
                                    val path = ImageStorageManager.copyImageToLocalStorage(context, it)
                                    if (path != null) {
                                        optionImagesList = optionImagesList.toMutableList().apply { add(path) }
                                    }
                                }
                            }
                            OutlinedButton(onClick = { optionImageLauncher.launch("image/*") }) {
                                Text("+ Add Distractor Image")
                            }
                        }
                    }

                    OutlinedTextField(
                        value = explanationText,
                        onValueChange = { explanationText = it },
                        label = { Text("Explanation (optional)") },
                        modifier = Modifier.fillMaxWidth(),
                        minLines = 2
                    )

                    ImageFieldPicker(
                        label = "Explanation",
                        currentImagePath = explanationImage,
                        onImagePicked = { explanationImage = it },
                        onImageRemoved = { explanationImage = null }
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Navigation or Add More checkbox
                    if (onPrevious != null || onNext != null) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            if (onPrevious != null) {
                                OutlinedButton(
                                    onClick = { saveCurrent(); onPrevious() },
                                    enabled = hasPrevious,
                                    modifier = Modifier.weight(1f),
                                    contentPadding = PaddingValues(horizontal = 8.dp)
                                ) {
                                    Text("Previous", maxLines = 1)
                                }
                            }
                            if (onNext != null) {
                                OutlinedButton(
                                    onClick = { saveCurrent(); onNext() },
                                    enabled = hasNext,
                                    modifier = Modifier.weight(1f),
                                    contentPadding = PaddingValues(horizontal = 8.dp)
                                ) {
                                    Text("Next", maxLines = 1)
                                }
                            }
                        }
                    } else {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            Checkbox(
                                checked = addMoreMode,
                                onCheckedChange = { addMoreMode = it }
                            )
                            Text("Add More", style = MaterialTheme.typography.bodyMedium)
                        }
                    }

                    // Cancel and Save on the right
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedButton(
                            onClick = onDismiss,
                            contentPadding = PaddingValues(horizontal = 12.dp)
                        ) {
                            Text("Cancel", maxLines = 1)
                        }
                        Button(
                            onClick = {
                                saveCurrent()
                                if (!addMoreMode) {
                                    onDismiss()
                                }
                            },
                            contentPadding = PaddingValues(horizontal = 16.dp)
                        ) {
                            Text(
                                text = TranslationManager.getString("save").takeIf { it.isNotEmpty() } ?: "Save",
                                maxLines = 1
                            )
                        }
                    }
                }
            }
        }
    }
}

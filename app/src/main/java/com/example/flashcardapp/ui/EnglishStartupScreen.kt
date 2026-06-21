package com.example.flashcardapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flashcardapp.mcq.EnglishEngine
import com.example.flashcardapp.mcq.Mcq
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun EnglishStartupScreen(
    engine: EnglishEngine,
    onQuizCompleted: () -> Unit
) {
    var selectedLimit by remember { mutableStateOf<Int?>(null) }
    var mcqs by remember { mutableStateOf<List<Mcq>?>(null) }
    var currentIndex by remember { mutableStateOf(0) }
    var showExplanation by remember { mutableStateOf(false) }
    var selectedAnswerIndex by remember { mutableStateOf<Int?>(null) }
    val scope = rememberCoroutineScope()
    var isLoading by remember { mutableStateOf(false) }

    if (selectedLimit == null) {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Daily English Checkpoint", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Complete this warm-up to access your decks.", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(32.dp))
            Text("Select number of questions:", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(16.dp))
            listOf(10, 20, 40, 50).forEach { limit ->
                Button(
                    onClick = {
                        isLoading = true
                        selectedLimit = limit
                        scope.launch(Dispatchers.IO) {
                            val quiz = engine.generateQuiz(limit)
                            withContext(Dispatchers.Main) {
                                mcqs = quiz
                                isLoading = false
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth().height(56.dp).padding(vertical = 4.dp)
                ) {
                    Text("$limit Questions")
                }
            }
        }
    } else if (isLoading || mcqs == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        val quizList = mcqs!!
        if (currentIndex >= quizList.size) {
            Column(
                modifier = Modifier.fillMaxSize().padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Checkpoint Completed!", style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = onQuizCompleted,
                    modifier = Modifier.fillMaxWidth().height(56.dp)
                ) {
                    Text("Continue to App")
                }
            }
        } else {
            val currentMcq = quizList[currentIndex]
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LinearProgressIndicator(
                    progress = { currentIndex.toFloat() / quizList.size.toFloat() },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
                )
                Text("Question ${currentIndex + 1} of ${quizList.size}", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(24.dp))
                Text(currentMcq.question, style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(32.dp))
                
                currentMcq.options.forEachIndexed { idx, option ->
                    val containerColor = if (showExplanation) {
                        if (idx == currentMcq.correctIndex) MaterialTheme.colorScheme.primary
                        else if (idx == selectedAnswerIndex) MaterialTheme.colorScheme.error
                        else MaterialTheme.colorScheme.surfaceVariant
                    } else {
                        MaterialTheme.colorScheme.surfaceVariant
                    }

                    val contentColor = if (showExplanation && (idx == currentMcq.correctIndex || idx == selectedAnswerIndex)) {
                        MaterialTheme.colorScheme.onPrimary
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    }
                    
                    Button(
                        onClick = {
                            if (!showExplanation) {
                                selectedAnswerIndex = idx
                                showExplanation = true
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = containerColor,
                            contentColor = contentColor
                        ),
                        modifier = Modifier.fillMaxWidth().height(56.dp).padding(vertical = 4.dp)
                    ) {
                        Text(option)
                    }
                }

                if (showExplanation) {
                    Spacer(modifier = Modifier.height(24.dp))
                    Text("Explanation", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(currentMcq.explanation, style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        onClick = {
                            currentIndex++
                            showExplanation = false
                            selectedAnswerIndex = null
                        },
                        modifier = Modifier.fillMaxWidth().height(56.dp)
                    ) {
                        Text("Next Question")
                    }
                }
            }
        }
    }
}

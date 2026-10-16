package com.example.flashcardapp.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.RssFeed
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.data.AppDatabase
import com.example.flashcardapp.data.ca.CurrentAffairsDeckAppender
import com.example.flashcardapp.data.ca.CurrentAffairsEngine
import com.example.flashcardapp.data.ca.DailyCurrentAffairsWorker
import com.example.flashcardapp.data.entities.CurrentAffairsSourceEntity
import com.example.flashcardapp.ui.theme.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.util.Calendar
import java.util.UUID

data class FeedPreset(
    val title: String,
    val feedUrl: String
)

val PRESET_FEEDS = listOf(
    FeedPreset("The Hindu National", "https://www.thehindu.com/news/national/feeder/default.rss"),
    FeedPreset("PIB Press Releases", "https://pib.gov.in/RssFeeds.aspx?id=1"),
    FeedPreset("Indian Express India", "https://indianexpress.com/section/india/feed/")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrentAffairsSettingsScreen(
    onBackClicked: () -> Unit
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val db = remember { AppDatabase.getInstance(context) }
    val dao = db.currentAffairsSourceDao()

    val sourcesFlow = dao.observeAllSources()
    val sources by sourcesFlow.collectAsState(initial = emptyList())

    var showAddDialog by remember { mutableStateOf(false) }
    var isSyncing by remember { mutableStateOf(false) }
    var syncStatusText by remember { mutableStateOf<String?>(null) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val currentYear = Calendar.getInstance().get(Calendar.YEAR)
    val deckFileName = "current_affairs_$currentYear.csv"
    val deckFile = File(context.filesDir, deckFileName)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Daily Current Affairs",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClicked) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        bottomBar = {
            Surface(
                tonalElevation = 8.dp,
                shadowElevation = 8.dp,
                color = MaterialTheme.colorScheme.surface
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (isSyncing) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(bottom = 12.dp)
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(20.dp),
                                strokeWidth = 2.5.dp,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                syncStatusText ?: "Syncing current affairs RSS feeds...",
                                fontSize = 13.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Button(
                        onClick = {
                            if (sources.none { it.isActive }) {
                                Toast.makeText(context, "Please enable at least 1 feed source to sync", Toast.LENGTH_SHORT).show()
                                return@Button
                            }
                            coroutineScope.launch {
                                isSyncing = true
                                syncStatusText = "Fetching RSS feeds offline..."
                                try {
                                    val activeSources = dao.getActiveSourcesSync()
                                    val existingKeys = CurrentAffairsDeckAppender.getExistingQuestionKeys(context).toMutableSet()
                                    val newQuestions = mutableListOf<com.example.flashcardapp.data.entities.QuestionEntity>()

                                    for (src in activeSources) {
                                        syncStatusText = "Parsing ${src.title}..."
                                        val result = CurrentAffairsEngine.fetchAndSynthesizeMCQs(src, existingKeys)
                                        result.getOrNull()?.let { list ->
                                            newQuestions.addAll(list)
                                            list.forEach { q ->
                                                val extractTitle = q.questionText.substringAfter("headline: '").substringBefore("'. Which")
                                                val normKey = extractTitle.lowercase().replace(Regex("[^a-z0-9]"), "")
                                                if (normKey.isNotBlank()) existingKeys.add(normKey)
                                            }
                                        }
                                    }

                                    if (newQuestions.isNotEmpty()) {
                                        CurrentAffairsDeckAppender.appendQuestionsAndSyncDb(context, newQuestions)
                                        Toast.makeText(context, "Synced ${newQuestions.size} new MCQs to $deckFileName!", Toast.LENGTH_LONG).show()
                                    } else {
                                        Toast.makeText(context, "No new articles found. Deck is up to date!", Toast.LENGTH_SHORT).show()
                                    }
                                    DailyCurrentAffairsWorker.schedulePeriodicSync(context)
                                } catch (e: Exception) {
                                    Toast.makeText(context, "Sync Error: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
                                } finally {
                                    isSyncing = false
                                    syncStatusText = null
                                }
                            }
                        },
                        enabled = !isSyncing,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(Icons.Default.Sync, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Sync Now", fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Target Deck: ${deckFile.name} (${if (deckFile.exists()) "${deckFile.length() / 1024} KB" else "0 KB"})",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(top = 16.dp, bottom = 24.dp)
        ) {
            // Header Info Card with Counter Badge
            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.RssFeed,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    "Feed Sources Limit",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                            }
                            // Counter Badge
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = if (sources.size >= 5) MaterialTheme.colorScheme.errorContainer else MaterialTheme.colorScheme.primary
                            ) {
                                Text(
                                    text = "${sources.size} / 5 used",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (sources.size >= 5) MaterialTheme.colorScheme.onErrorContainer else MaterialTheme.colorScheme.onPrimary,
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            "The engine fetches RSS headlines offline daily, synthesizes exam-oriented MCQs, and appends them to $deckFileName.",
                            fontSize = 13.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            lineHeight = 18.sp
                        )
                    }
                }
            }

            // Error Banner if present
            errorMessage?.let { msg ->
                item {
                    Surface(
                        color = MaterialTheme.colorScheme.errorContainer,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(12.dp)
                        ) {
                            Text(
                                text = msg,
                                color = MaterialTheme.colorScheme.onErrorContainer,
                                fontSize = 13.sp,
                                modifier = Modifier.weight(1f)
                            )
                            IconButton(onClick = { errorMessage = null }, modifier = Modifier.size(24.dp)) {
                                Text("✕", color = MaterialTheme.colorScheme.onErrorContainer, fontSize = 12.sp)
                            }
                        }
                    }
                }
            }

            // Presets Section
            item {
                Text(
                    "Quick Add Presets",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    PRESET_FEEDS.forEach { preset ->
                        val isAlreadyAdded = sources.any { it.feedUrl.equals(preset.feedUrl, ignoreCase = true) }
                        AssistChip(
                            onClick = {
                                if (isAlreadyAdded) return@AssistChip
                                coroutineScope.launch {
                                    val count = dao.getSourceCount()
                                    if (count >= 5) {
                                        errorMessage = "Maximum limit of 5 feed sources reached"
                                        return@launch
                                    }
                                    dao.safeInsertSource(
                                        CurrentAffairsSourceEntity(
                                            id = UUID.randomUUID().toString(),
                                            title = preset.title,
                                            feedUrl = preset.feedUrl,
                                            isActive = true
                                        )
                                    )
                                    errorMessage = null
                                }
                            },
                            label = { Text(preset.title, fontSize = 12.sp) },
                            leadingIcon = {
                                Icon(
                                    if (isAlreadyAdded) Icons.Default.RssFeed else Icons.Default.Add,
                                    contentDescription = null,
                                    modifier = Modifier.size(14.dp)
                                )
                            },
                            enabled = !isAlreadyAdded && sources.size < 5
                        )
                    }
                }
            }

            // Configured Feeds Section Header
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        "Configured Feed Sources",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Button(
                        onClick = {
                            if (sources.size >= 5) {
                                errorMessage = "Maximum limit of 5 feed sources reached"
                            } else {
                                errorMessage = null
                                showAddDialog = true
                            }
                        },
                        enabled = sources.size < 5,
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Add Source", fontSize = 12.sp)
                    }
                }
            }

            if (sources.isEmpty()) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 32.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "No RSS feed sources added yet.\nClick a preset above or add a custom RSS/Atom URL.",
                            fontSize = 13.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                    }
                }
            } else {
                items(sources, key = { it.id }) { source ->
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(14.dp)
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    source.title,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    source.feedUrl,
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    maxLines = 1
                                )
                            }

                            Switch(
                                checked = source.isActive,
                                onCheckedChange = { active ->
                                    coroutineScope.launch {
                                        dao.updateActiveStatus(source.id, active)
                                    }
                                },
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )

                            IconButton(
                                onClick = {
                                    coroutineScope.launch {
                                        dao.deleteSourceById(source.id)
                                    }
                                }
                            ) {
                                Icon(
                                    Icons.Default.Delete,
                                    contentDescription = "Delete Feed",
                                    tint = MaterialTheme.colorScheme.error
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    if (showAddDialog) {
        AddSourceDialog(
            onDismiss = { showAddDialog = false },
            onAddSource = { title, url ->
                coroutineScope.launch {
                    val count = dao.getSourceCount()
                    if (count >= 5) {
                        errorMessage = "Maximum limit of 5 feed sources reached"
                        showAddDialog = false
                        return@launch
                    }
                    try {
                        dao.safeInsertSource(
                            CurrentAffairsSourceEntity(
                                id = UUID.randomUUID().toString(),
                                title = title.ifBlank { "Custom RSS Feed" },
                                feedUrl = url.trim(),
                                isActive = true
                            )
                        )
                        errorMessage = null
                    } catch (e: Exception) {
                        errorMessage = e.message ?: "Maximum limit of 5 feed sources reached"
                    }
                    showAddDialog = false
                }
            }
        )
    }
}

@Composable
fun AddSourceDialog(
    onDismiss: () -> Unit,
    onAddSource: (title: String, url: String) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var url by remember { mutableStateOf("") }
    var urlError by remember { mutableStateOf<String?>(null) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Add Feed Source", fontWeight = FontWeight.Bold) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Feed Name") },
                    placeholder = { Text("e.g., The Hindu National") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = url,
                    onValueChange = {
                        url = it
                        urlError = if (it.isNotBlank() && !it.startsWith("http://") && !it.startsWith("https://")) {
                            "URL must start with http:// or https://"
                        } else null
                    },
                    label = { Text("RSS / Atom Feed URL") },
                    placeholder = { Text("https://example.com/rss.xml") },
                    isError = urlError != null,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                urlError?.let {
                    Text(it, color = MaterialTheme.colorScheme.error, fontSize = 11.sp)
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (url.isBlank() || urlError != null) return@Button
                    onAddSource(title, url)
                },
                enabled = url.isNotBlank() && urlError == null
            ) {
                Text("Add Source")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}

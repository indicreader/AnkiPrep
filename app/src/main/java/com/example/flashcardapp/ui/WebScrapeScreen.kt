package com.example.flashcardapp.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.flashcardapp.data.AnkiDataRepository
import com.example.flashcardapp.data.AnkiDeck
import com.example.flashcardapp.data.ImageStorageManager
import com.example.flashcardapp.data.core.CsvQuoteUtils
import com.example.flashcardapp.data.scraper.CustomScraperManager
import com.example.flashcardapp.data.scraper.CustomScraperRule
import com.example.flashcardapp.data.scraper.ScrapedCard
import com.example.flashcardapp.data.scraper.WebScraperEngine
import com.example.flashcardapp.ui.theme.BackgroundLavender
import com.example.flashcardapp.ui.theme.CardBackgroundLight
import com.example.flashcardapp.ui.theme.PrimaryPurple
import com.example.flashcardapp.ui.theme.TextPrimaryDeep
import com.example.flashcardapp.ui.theme.TextSecondaryGray
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

data class PresetCategory(
    val title: String,
    val url: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)

val INDIABIX_PRESETS = listOf(
    PresetCategory("IndiaBIX Aptitude", "https://www.indiabix.com/aptitude/questions-and-answers/", Icons.Outlined.Calculate),
    PresetCategory("IndiaBIX GK", "https://www.indiabix.com/general-knowledge/basic-general-knowledge/", Icons.Outlined.Public),
    PresetCategory("IndiaBIX CS", "https://www.indiabix.com/computer-science/questions-and-answers/", Icons.Outlined.Computer),
    PresetCategory("Sanfoundry CS", "https://www.sanfoundry.com/1000-java-questions-answers/", Icons.Outlined.Code),
    PresetCategory("Examveda GK", "https://www.examveda.com/general-knowledge/practice-online-test/", Icons.Outlined.Quiz)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WebScrapeScreen(
    decks: List<AnkiDeck>,
    onBack: () -> Unit,
    onDeckImported: (String) -> Unit
) {
    val context = LocalContext.current
    val repo = remember { AnkiDataRepository.getInstance(context) }
    val coroutineScope = rememberCoroutineScope()

    var urlInput by remember { mutableStateOf("https://www.indiabix.com/aptitude/questions-and-answers/") }
    var selectedDeckName by remember { mutableStateOf(decks.firstOrNull()?.name ?: "Web Scraping Deck") }
    var maxPagesToScrape by remember { mutableStateOf(2) }

    var isScraping by remember { mutableStateOf(false) }
    var scrapingProgressText by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    var scrapedCards by remember { mutableStateOf<List<ScrapedCard>>(emptyList()) }
    var detectedTopicTitle by remember { mutableStateOf("IndiaBIX Aptitude") }

    var customRules by remember { mutableStateOf(CustomScraperManager.getRules(context)) }
    var showAddCustomRuleDialog by remember { mutableStateOf(false) }

    val exportCsvLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.CreateDocument("text/csv")
    ) { uri ->
        uri?.let { targetUri ->
            coroutineScope.launch(Dispatchers.IO) {
                try {
                    context.contentResolver.openOutputStream(targetUri)?.use { out ->
                        CsvQuoteUtils.writeScrapedCardsToStream(scrapedCards, out)
                    }
                    withContext(Dispatchers.Main) {
                        android.widget.Toast.makeText(
                            context,
                            "Exported ${scrapedCards.size} MCQs to CSV successfully!",
                            android.widget.Toast.LENGTH_LONG
                        ).show()
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        android.widget.Toast.makeText(
                            context,
                            "Failed to export CSV: ${e.localizedMessage}",
                            android.widget.Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }

    fun startScraping() {
        if (urlInput.isBlank()) {
            errorMessage = "Please enter a valid website URL"
            return
        }

        isScraping = true
        errorMessage = null
        scrapedCards = emptyList()

        coroutineScope.launch {
            val allCards = mutableListOf<ScrapedCard>()
            var currentUrl: String? = urlInput.trim()
            var pageCount = 0

            while (currentUrl != null && pageCount < maxPagesToScrape && isScraping) {
                pageCount++
                scrapingProgressText = "Scraping page $pageCount of $maxPagesToScrape..."

                val result = WebScraperEngine.scrapeUrl(context, currentUrl)
                if (result.error != null && pageCount == 1) {
                    errorMessage = result.error
                    isScraping = false
                    return@launch
                }

                if (result.cards.isNotEmpty()) {
                    allCards.addAll(result.cards)
                    detectedTopicTitle = result.topicTitle
                    scrapedCards = allCards.toList()
                }

                currentUrl = result.nextPageUrl
                if (currentUrl != null) {
                    kotlinx.coroutines.delay(500)
                }
            }

            isScraping = false
            if (allCards.isEmpty()) {
                errorMessage = "No MCQs found on the provided page"
            } else {
                scrapingProgressText = "Scraped ${allCards.size} MCQs across $pageCount page(s)!"
            }
        }
    }

    fun importScrapedCards() {
        if (scrapedCards.isEmpty()) return
        coroutineScope.launch {
            val deckName = selectedDeckName.ifBlank { detectedTopicTitle }
            repo.createDeck(deckName)

            scrapedCards.forEach { card ->
                val optsString = if (card.options.isNotEmpty()) "|" + card.options.joinToString("|") else ""
                val explString = if (card.explanation.isNotBlank()) "; ${card.explanation.trim()}" else ""
                val backContent = "${card.answer.trim()}$optsString$explString"

                val tagsJson = com.google.gson.Gson().toJson(card.tags + listOf("web_scraped"))

                repo.addCard(
                    deckHierarchy = deckName,
                    front = card.question,
                    back = backContent,
                    tagsJson = tagsJson,
                    frontImage = card.frontImage,
                    backImage = null,
                    explanationImage = card.explanationImage,
                    optionImagesJson = card.optionImagesJson
                )
            }

            android.widget.Toast.makeText(context, "Successfully imported ${scrapedCards.size} MCQs into '$deckName'!", android.widget.Toast.LENGTH_LONG).show()
            onDeckImported(deckName)
        }
    }

    if (showAddCustomRuleDialog) {
        AddCustomScraperRuleDialog(
            onDismiss = { showAddCustomRuleDialog = false },
            onSave = { rule ->
                CustomScraperManager.saveRule(context, rule)
                customRules = CustomScraperManager.getRules(context)
                urlInput = "https://${rule.domain}/"
                showAddCustomRuleDialog = false
            }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Web Quiz Scraper", color = TextPrimaryDeep, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = PrimaryPurple)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BackgroundLavender)
            )
        },
        containerColor = BackgroundLavender
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Preset Quick Launch & Custom Site Chips Row
            Text(
                text = "Preset & Custom Scraper Sources",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                color = TextSecondaryGray
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(INDIABIX_PRESETS) { preset ->
                    FilterChip(
                        selected = urlInput == preset.url,
                        onClick = {
                            urlInput = preset.url
                            startScraping()
                        },
                        label = { Text(preset.title) },
                        leadingIcon = { Icon(preset.icon, contentDescription = null, modifier = Modifier.size(16.dp)) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = PrimaryPurple,
                            selectedLabelColor = Color.White
                        )
                    )
                }

                items(customRules) { rule ->
                    FilterChip(
                        selected = urlInput.contains(rule.domain, ignoreCase = true),
                        onClick = {
                            urlInput = "https://${rule.domain}/"
                            startScraping()
                        },
                        label = { Text(rule.name) },
                        leadingIcon = { Icon(Icons.Outlined.Language, contentDescription = null, modifier = Modifier.size(16.dp)) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = PrimaryPurple,
                            selectedLabelColor = Color.White
                        )
                    )
                }

                item {
                    AssistChip(
                        onClick = { showAddCustomRuleDialog = true },
                        label = { Text("+ Add Custom Site") },
                        leadingIcon = { Icon(Icons.Outlined.Add, contentDescription = null, modifier = Modifier.size(16.dp)) }
                    )
                }
            }

            // URL Input Row
            OutlinedTextField(
                value = urlInput,
                onValueChange = { urlInput = it },
                label = { Text("Website URL (IndiaBIX / Educational Quiz)") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                trailingIcon = {
                    IconButton(onClick = { startScraping() }, enabled = !isScraping) {
                        Icon(Icons.Outlined.PlayArrow, contentDescription = "Scrape", tint = PrimaryPurple)
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = PrimaryPurple,
                    focusedLabelColor = PrimaryPurple
                )
            )

            // Config Row: Target Deck & Max Pages
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = selectedDeckName,
                    onValueChange = { selectedDeckName = it },
                    label = { Text("Import Deck Name") },
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )

                Button(
                    onClick = { startScraping() },
                    enabled = !isScraping,
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryPurple)
                ) {
                    if (isScraping) {
                        CircularProgressIndicator(modifier = Modifier.size(18.dp), color = Color.White, strokeWidth = 2.dp)
                    } else {
                        Icon(Icons.Outlined.CloudDownload, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(Modifier.width(4.dp))
                        Text("Scrape")
                    }
                }
            }

            // Progress / Status
            if (isScraping || scrapingProgressText.isNotEmpty()) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = PrimaryPurple.copy(alpha = 0.1f))
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        if (isScraping) {
                            CircularProgressIndicator(modifier = Modifier.size(16.dp), color = PrimaryPurple)
                        } else {
                            Icon(Icons.Outlined.CheckCircle, contentDescription = null, tint = PrimaryPurple, modifier = Modifier.size(18.dp))
                        }
                        Text(
                            text = scrapingProgressText,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryPurple
                        )
                    }
                }
            }

            if (errorMessage != null) {
                Text(
                    text = errorMessage!!,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            // Scraped Cards Live Preview List
            if (scrapedCards.isNotEmpty()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Scraped Preview (${scrapedCards.size} Qs)",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimaryDeep,
                        modifier = Modifier.weight(1f, fill = false)
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedButton(
                            onClick = {
                                val cleanDeckName = (if (selectedDeckName.isNotBlank()) selectedDeckName else detectedTopicTitle)
                                    .replace(Regex("[^a-zA-Z0-9_]"), "_")
                                    .trim('_')
                                    .ifEmpty { "scraped_quiz" }
                                exportCsvLauncher.launch("$cleanDeckName.csv")
                            },
                            shape = RoundedCornerShape(12.dp),
                            border = BorderStroke(1.5.dp, PrimaryPurple),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = PrimaryPurple),
                            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
                        ) {
                            Icon(Icons.Outlined.Download, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(Modifier.width(4.dp))
                            Text("Export as CSV", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        }

                        Button(
                            onClick = { importScrapedCards() },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32)),
                            shape = RoundedCornerShape(12.dp),
                            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
                        ) {
                            Icon(Icons.Outlined.SaveAlt, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(Modifier.width(4.dp))
                            Text("Import Deck", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        }
                    }
                }

                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    itemsIndexed(scrapedCards) { index, card ->
                        ScrapedCardItem(
                            index = index + 1,
                            card = card,
                            onDelete = {
                                scrapedCards = scrapedCards.toMutableList().apply { removeAt(index) }
                            }
                        )
                    }
                }
            } else if (!isScraping) {
                Box(
                    modifier = Modifier.fillMaxSize().weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(Icons.Outlined.TravelExplore, contentDescription = null, tint = TextSecondaryGray, modifier = Modifier.size(48.dp))
                        Text("Paste a URL or tap a preset above to scrape MCQs", color = TextSecondaryGray, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}

@Composable
private fun AddCustomScraperRuleDialog(
    onDismiss: () -> Unit,
    onSave: (CustomScraperRule) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var domain by remember { mutableStateOf("") }
    var qSelector by remember { mutableStateOf(".question, h3, h4") }
    var optSelector by remember { mutableStateOf(".option, li") }
    var ansSelector by remember { mutableStateOf(".answer, .correct") }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = MaterialTheme.shapes.extraLarge,
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 6.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("Add Custom Quiz Site Rule", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Site Name (e.g. GregMat)") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = domain, onValueChange = { domain = it }, label = { Text("Domain (e.g. gregmat.com)") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = qSelector, onValueChange = { qSelector = it }, label = { Text("Question CSS Selector") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = optSelector, onValueChange = { optSelector = it }, label = { Text("Option CSS Selector") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = ansSelector, onValueChange = { ansSelector = it }, label = { Text("Answer CSS Selector") }, modifier = Modifier.fillMaxWidth())

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically) {
                    TextButton(onClick = onDismiss) { Text("Cancel") }
                    Spacer(Modifier.width(8.dp))
                    Button(
                        onClick = {
                            if (name.isNotBlank() && domain.isNotBlank()) {
                                onSave(
                                    CustomScraperRule(
                                        name = name.trim(),
                                        domain = domain.trim().removePrefix("https://").removePrefix("http://").removePrefix("www."),
                                        questionSelector = qSelector.ifBlank { ".question, h3, h4" },
                                        optionSelector = optSelector.ifBlank { ".option, li" },
                                        answerSelector = ansSelector.ifBlank { ".answer, .correct" }
                                    )
                                )
                            }
                        }
                    ) {
                        Text("Save Site Rule")
                    }
                }
            }
        }
    }
}

@Composable
private fun ScrapedCardItem(
    index: Int,
    card: ScrapedCard,
    onDelete: () -> Unit
) {
    val context = LocalContext.current
    val colorScheme = MaterialTheme.colorScheme

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = CardBackgroundLight),
        border = BorderStroke(1.dp, Color(0xFFE8E2EC))
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Q$index. ${card.question}",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimaryDeep,
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = onDelete, modifier = Modifier.size(28.dp)) {
                    Icon(Icons.Outlined.Delete, contentDescription = "Delete", tint = colorScheme.error)
                }
            }

            if (card.frontImage != null) {
                val resolved = ImageStorageManager.resolveImageModel(context, card.frontImage)
                if (resolved != null) {
                    coil.compose.AsyncImage(
                        model = resolved,
                        contentDescription = "Front Image",
                        modifier = Modifier.fillMaxWidth().heightIn(max = 160.dp).clip(RoundedCornerShape(8.dp)),
                        contentScale = androidx.compose.ui.layout.ContentScale.Fit
                    )
                }
            }

            // Options list
            val optionLabels = listOf("A", "B", "C", "D", "E")
            card.options.forEachIndexed { optIdx, optionText ->
                val isCorrect = optionText.equals(card.answer, ignoreCase = true)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (isCorrect) Color(0xFFE8F5E9) else colorScheme.surfaceVariant.copy(alpha = 0.4f))
                        .padding(horizontal = 10.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = if (isCorrect) Color(0xFF2E7D32) else colorScheme.surfaceVariant
                    ) {
                        Text(
                            text = optionLabels.getOrElse(optIdx) { "${optIdx + 1}" },
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = if (isCorrect) Color.White else colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                    Text(
                        text = optionText,
                        style = MaterialTheme.typography.bodyMedium,
                        color = if (isCorrect) Color(0xFF1B5E20) else TextPrimaryDeep,
                        fontWeight = if (isCorrect) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }

            if (card.explanation.isNotBlank()) {
                Text(
                    text = "Explanation: ${card.explanation}",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondaryGray
                )
            }
        }
    }
}

package com.example.flashcardapp

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.animation.core.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.BorderStroke
import com.example.flashcardapp.data.AnkiDeck
import com.example.flashcardapp.data.AnkiDataRepository
import com.example.flashcardapp.data.AnkiDroidBridge
import com.example.flashcardapp.data.DataLayerDiagnostics
import com.example.flashcardapp.data.SettingsRepository
import com.example.flashcardapp.data.entities.SessionRecordEntity
import com.example.flashcardapp.mcq.Mcq
import com.example.flashcardapp.mcq.McqDiagnostics
import com.example.flashcardapp.mcq.McqEngine
import com.example.flashcardapp.session.AnswerRecord
import com.example.flashcardapp.session.McqSessionManager
import com.example.flashcardapp.session.McqSessionMode
import com.example.flashcardapp.session.McqSessionState
import com.example.flashcardapp.session.WeakCardSelector
import com.example.flashcardapp.ui.DeckSelectionScreen
import com.example.flashcardapp.ui.ImportDeckDialog
import com.example.flashcardapp.ui.QuizScreen
import com.example.flashcardapp.ui.ResultsScreen
import com.example.flashcardapp.ui.ReviewMistakesScreen
import com.example.flashcardapp.ui.SettingsScreen
import com.example.flashcardapp.ui.ProfileScreen
import com.example.flashcardapp.ui.theme.AnkiQuizTheme
import com.example.flashcardapp.ui.theme.PrimaryPurple
import com.example.flashcardapp.ui.theme.TextPrimaryDeep
import com.example.flashcardapp.ui.theme.TextSecondaryGray
import com.example.flashcardapp.ui.theme.IncorrectColor
import com.example.flashcardapp.ui.theme.BackgroundLavender
import com.example.flashcardapp.data.TranslationManager
import com.example.flashcardapp.data.AppLanguage
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

import androidx.lifecycle.lifecycleScope
import android.net.Uri
import android.content.Intent
import android.widget.Toast
import android.app.Activity
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback

sealed class Screen {
    object DeckSelection : Screen()
    object Settings : Screen()
    object Profile : Screen()
    object AliasEditor : Screen()
    data class Quiz(val deck: AnkiDeck, val mode: McqSessionMode) : Screen()
    data class Results(
        val deck: AnkiDeck,
        val score: Int,
        val timeTakenSeconds: Long,
        val totalQuestions: Int,
        val answeredQuestions: List<AnswerRecord> = emptyList(),
        val positiveMarks: Float = 1.0f,
        val negativeMarks: Float = 0.0f
    ) : Screen()
    data class ReviewMistakes(
        val deck: AnkiDeck,
        val answeredQuestions: List<AnswerRecord>
    ) : Screen()
}

// =========================================================================
// GOOGLE ADMOB CONFIGURATION
// Replace with your actual Ad Unit ID when ready for production.
// Test Interstitial ID is: "ca-app-pub-3940256099942544/1033173712"
// =========================================================================
const val ADMOB_INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-6846875306917122/8090484835"
// =========================================================================

class MainActivity : ComponentActivity() {

    private var mInterstitialAd: RewardedInterstitialAd? = null
    private var isAdLoading = false

    fun loadInterstitialAd() {
        if (com.example.flashcardapp.data.SettingsRepository.getInstance(this).isPremium) return
        if (mInterstitialAd != null || isAdLoading) return
        isAdLoading = true
        val adRequest = AdRequest.Builder().build()
        RewardedInterstitialAd.load(
            this,
            ADMOB_INTERSTITIAL_AD_UNIT_ID,
            adRequest,
            object : RewardedInterstitialAdLoadCallback() {
                override fun onAdLoaded(rewardedInterstitialAd: RewardedInterstitialAd) {
                    mInterstitialAd = rewardedInterstitialAd
                    isAdLoading = false
                    Log.d("AdMob", "Rewarded Interstitial Ad loaded successfully.")
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    Log.e("AdMob", "Rewarded Interstitial Ad failed to load: ${loadAdError.message}")
                    mInterstitialAd = null
                    isAdLoading = false
                }
            }
        )
    }

    fun getInterstitialAd(): RewardedInterstitialAd? = mInterstitialAd

    fun clearInterstitialAd() {
        mInterstitialAd = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MobileAds.initialize(this) {
            loadInterstitialAd()
        }
        handleIntent(intent)
        setContent {
            val context = LocalContext.current
            val settingsRepo = remember { SettingsRepository.getInstance(context) }
            
            var themePreset by remember { mutableStateOf(settingsRepo.themePreset) }
            var useDynamicWallpaper by remember { mutableStateOf(settingsRepo.useDynamicWallpaperTheme) }
            var isDarkMode by remember { mutableStateOf(settingsRepo.isDarkMode) }
            var fontFamilyType by remember { mutableStateOf(settingsRepo.fontFamilyType) }

            AnkiQuizTheme(
                themePreset = themePreset,
                isDarkMode = isDarkMode,
                useDynamicWallpaper = useDynamicWallpaper,
                fontFamilyType = fontFamilyType
            ) {
                MainLayout(
                    themePreset = themePreset,
                    onThemePresetChange = {
                        themePreset = it
                        settingsRepo.themePreset = it
                    },
                    isDarkMode = isDarkMode,
                    onDarkModeToggle = {
                        isDarkMode = it
                        settingsRepo.isDarkMode = it
                    },
                    useDynamicWallpaper = useDynamicWallpaper,
                    onUseDynamicWallpaperToggle = {
                        useDynamicWallpaper = it
                        settingsRepo.useDynamicWallpaperTheme = it
                    },
                    fontFamilyType = fontFamilyType,
                    onFontFamilyTypeChange = {
                        fontFamilyType = it
                        settingsRepo.fontFamilyType = it
                    }
                )
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.let { handleIntent(it) }
    }

    private fun handleIntent(intent: Intent) {
        val action = intent.action
        val uri = when (action) {
            Intent.ACTION_VIEW -> intent.data
            Intent.ACTION_SEND -> intent.getParcelableExtra<Uri>(Intent.EXTRA_STREAM)
            else -> null
        } ?: return

        // Determine file type from URI path or MIME type
        val path = uri.path?.lowercase() ?: ""
        val mimeType = intent.type?.lowercase() ?: ""
        val isCsv = path.endsWith(".csv") || mimeType.contains("csv") ||
            mimeType == "text/plain" || mimeType == "text/comma-separated-values"

        lifecycleScope.launch {
            val repo = AnkiDataRepository.getInstance(applicationContext)
            if (isCsv) {
                Toast.makeText(applicationContext, "Importing CSV deck...", Toast.LENGTH_SHORT).show()
                val result = repo.importCsv(uri)
                if (result.success) {
                    Toast.makeText(
                        applicationContext,
                        "Imported CSV: ${result.fileName}\nCards: ${result.totalCards}",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "CSV import failed: ${result.error}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } else {
                Toast.makeText(applicationContext, "Importing APKG deck...", Toast.LENGTH_SHORT).show()
                val result = repo.importApkg(uri)
                if (result.success) {
                    Toast.makeText(
                        applicationContext,
                        "Imported ${result.fileName}\nDecks: ${result.totalDecks}, Cards: ${result.totalCards}",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Import failed: ${result.error}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}

@Composable
fun shimmerBrush(
    showShimmer: Boolean = true,
    targetValue: Float = 1000f
): Brush {
    return if (showShimmer) {
        val shimmerColors = listOf(
            MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
            MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.2f),
            MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
        )

        val transition = rememberInfiniteTransition(label = "shimmer")
        val translateAnimation = transition.animateFloat(
            initialValue = 0f,
            targetValue = targetValue,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 1000,
                    easing = FastOutLinearInEasing
                ),
                repeatMode = RepeatMode.Restart
            ),
            label = "shimmerTranslation"
        )

        Brush.linearGradient(
            colors = shimmerColors,
            start = Offset.Zero,
            end = Offset(x = translateAnimation.value, y = translateAnimation.value)
        )
    } else {
        Brush.linearGradient(
            colors = listOf(Color.Transparent, Color.Transparent),
            start = Offset.Zero,
            end = Offset.Zero
        )
    }
}

// ── Rotating mock ads shown when no preloaded real ad is available ────────────
private data class MockAdContent(
    val emoji: String,
    val title: String,
    val subtitle: String,
    val benefits: List<String>,
    val ctaLabel: String,
    val gradientStart: Color,
    val gradientEnd: Color,
    val accentColor: Color
)

private val MOCK_ADS = listOf(
    MockAdContent(
        emoji = "🎮",
        title = "WordQuest: Daily Puzzle",
        subtitle = "Train your brain & expand your vocabulary",
        benefits = listOf(
            "★ Over 5,000 Challenging Levels",
            "★ Learn New Words & Meanings Daily",
            "★ Fun Minigames & Brain Teasers",
            "★ Play Offline Anytime, Anywhere",
            "★ Over 10 Million Players Globally"
        ),
        ctaLabel = "PLAY FREE NOW",
        gradientStart = Color(0xFF0F172A), gradientEnd = Color(0xFF1E3A8A),
        accentColor = Color(0xFF3B82F6)
    ),
    MockAdContent(
        emoji = "📚",
        title = "ReadFast: Speed Reading",
        subtitle = "Read 3× faster with proven RSVP technique",
        benefits = listOf(
            "★ Personalized reading speed goals",
            "★ 1,000+ curated book summaries",
            "★ Daily streak & comprehension tests",
            "★ Offline mode for commuters",
            "★ Trusted by 2M+ students"
        ),
        ctaLabel = "START READING FREE",
        gradientStart = Color(0xFF064E3B), gradientEnd = Color(0xFF065F46),
        accentColor = Color(0xFF10B981)
    ),
    MockAdContent(
        emoji = "🧠",
        title = "BrainBoost: Memory Trainer",
        subtitle = "Sharpen memory with science-backed exercises",
        benefits = listOf(
            "★ 20-minute daily brain workout",
            "★ Memory, focus & processing speed",
            "★ Gamified challenges & leaderboards",
            "★ Neuroscientist-designed curriculum",
            "★ 4.8 ★ on Play Store (500K reviews)"
        ),
        ctaLabel = "TRAIN YOUR BRAIN",
        gradientStart = Color(0xFF4C1D95), gradientEnd = Color(0xFF5B21B6),
        accentColor = Color(0xFF7C3AED)
    ),
    MockAdContent(
        emoji = "✈️",
        title = "LinguaLeap: Language Fast",
        subtitle = "Learn Spanish, French & 12 more languages",
        benefits = listOf(
            "★ Conversational fluency in 90 days",
            "★ AI pronunciation feedback",
            "★ Native-speaker audio lessons",
            "★ 5-min bite-sized daily lessons",
            "★ Certificates recognized worldwide"
        ),
        ctaLabel = "LEARN FOR FREE",
        gradientStart = Color(0xFF7C2D12), gradientEnd = Color(0xFF9A3412),
        accentColor = Color(0xFFF97316)
    )
)

@Composable
fun FullscreenMockAd(
    onAdDismissed: () -> Unit,
    isQuizReady: Boolean,
    adIndex: Int = 0  // caller passes session-based index for rotation
) {
    val ad = MOCK_ADS[adIndex % MOCK_ADS.size]
    var countdown by remember { mutableStateOf(3) }
    LaunchedEffect(Unit) {
        while (countdown > 0) {
            kotlinx.coroutines.delay(1000)
            countdown--
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(ad.gradientStart, ad.gradientEnd)
                )
            )
            .padding(24.dp)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .background(Color.White.copy(alpha = 0.15f), RoundedCornerShape(4.dp))
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Text(
                text = "Sponsored",
                color = Color.White.copy(alpha = 0.8f),
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold
            )
        }

        if (countdown > 0) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .background(Color.Black.copy(alpha = 0.4f), CircleShape)
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "Skip in $countdown",
                    color = Color.White,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        } else {
            IconButton(
                onClick = onAdDismissed,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .background(Color.White.copy(alpha = 0.2f), CircleShape)
                    .size(36.dp)
            ) {
                Text(
                    text = "✕",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(
                        Brush.linearGradient(
                            colors = listOf(ad.accentColor, ad.accentColor.copy(alpha = 0.7f))
                        ),
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = ad.emoji,
                    color = Color.White,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = ad.title,
                    color = Color.White,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = ad.subtitle,
                    color = Color.White.copy(alpha = 0.7f),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.08f)),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    ad.benefits.forEach { benefit ->
                        Text(
                            text = benefit,
                            color = Color.White.copy(alpha = 0.9f),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

            Button(
                onClick = { /* App Store CTA */ },
                colors = ButtonDefaults.buttonColors(containerColor = ad.accentColor),
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 12.dp),
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text(
                    text = ad.ctaLabel,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        ) {
            Text(
                text = if (isQuizReady) "Quiz loaded and ready!" else "Generating quiz questions...",
                color = Color.White.copy(alpha = 0.5f),
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}


@Composable
fun RealAdmobInterstitialAd(
    onAdDismissed: () -> Unit,
    isQuizReady: Boolean,
    adSessionKey: Long,   // unique per quiz launch — forces LaunchedEffect to re-fire
    adIndex: Int = 0      // rotation index for fallback mock ads
) {
    val context = LocalContext.current
    val activity = context as? MainActivity
    val preloadedAd = activity?.getInterstitialAd()

    if (preloadedAd != null) {
        // KEY = adSessionKey ensures show() fires for every new quiz session,
        // even if the same InterstitialAd object is still in memory.
        LaunchedEffect(adSessionKey) {
            preloadedAd.fullScreenContentCallback = object : com.google.android.gms.ads.FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    activity.clearInterstitialAd()
                    activity.loadInterstitialAd() // Preload next
                    onAdDismissed()
                }
                override fun onAdFailedToShowFullScreenContent(error: com.google.android.gms.ads.AdError) {
                    activity.clearInterstitialAd()
                    activity.loadInterstitialAd() // Preload next
                    onAdDismissed()
                }
            }
            if (activity != null) {
                preloadedAd.show(activity) { _ -> }
            }
        }

        // Black screen placeholder while the ad activity takes over
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = Color(0xFFFFD700))
        }
    } else {
        // Fallback to rotating mock ad when real ad isn't ready
        FullscreenMockAd(
            onAdDismissed = {
                activity?.loadInterstitialAd()
                onAdDismissed()
            },
            isQuizReady = isQuizReady,
            adIndex = adIndex
        )
    }
}

@Composable
fun MainLayout(
    themePreset: String,
    onThemePresetChange: (String) -> Unit,
    isDarkMode: Boolean,
    onDarkModeToggle: (Boolean) -> Unit,
    useDynamicWallpaper: Boolean,
    onUseDynamicWallpaperToggle: (Boolean) -> Unit,
    fontFamilyType: String,
    onFontFamilyTypeChange: (String) -> Unit
) {
    val context = LocalContext.current
    var currentScreen by remember { mutableStateOf<Screen>(Screen.DeckSelection) }
    var userMode by remember { mutableStateOf("offline") }
    var hasPermission by remember { mutableStateOf(false) }

    // Observe cached decks from Room database reactive stream
    val cachedDecks by remember { AnkiDataRepository.getInstance(context).observeDecks() }
        .collectAsState(initial = emptyList())

    val decksList = remember(cachedDecks) {
        cachedDecks.map { AnkiDeck(it.id, it.fullPath) }
    }

    // Settings State and Persistent Storage
    val settingsRepo = remember { SettingsRepository.getInstance(context) }
    var currentMode by remember { mutableStateOf(settingsRepo.studyMode) }
    var vibrationEnabled by remember { mutableStateOf(settingsRepo.vibrationEnabled) }
    var numberOfOptions by remember { mutableStateOf(settingsRepo.numberOfOptions) }
    var questionLimit by remember { mutableStateOf(settingsRepo.questionLimit) }
    var shuffleQuestions by remember { mutableStateOf(settingsRepo.shuffleQuestions) }
    var showExplanations by remember { mutableStateOf(settingsRepo.showExplanations) }
    var showTags by remember { mutableStateOf(settingsRepo.showTags) }
    var timeLimitSeconds by remember { mutableStateOf(settingsRepo.timeLimitSeconds) }
    var deleteImagesOnCardDelete by remember { mutableStateOf(settingsRepo.deleteImagesOnCardDelete) }
    val currentLanguage by TranslationManager.currentLanguage.collectAsState()

    // Database cache status stats
    var deckCount by remember { mutableStateOf(0) }
    var cardCount by remember { mutableStateOf(0) }

    val coroutineScope = rememberCoroutineScope()
    val repo = remember { AnkiDataRepository.getInstance(context) }

    // Observe session records from Room database reactively
    val sessionRecords by repo.observeSessionRecords().collectAsState(initial = emptyList())

    fun reloadDbStats() {
        coroutineScope.launch {
            deckCount = repo.getDeckCount()
            cardCount = repo.getCardCount()
        }
    }

    fun refreshState() {
        // isAnkiInstalled = AnkiDroidBridge.isAnkiDroidInstalled(context)
        hasPermission = AnkiDroidBridge.hasPermission(context)
        coroutineScope.launch {
            if (hasPermission) {
                repo.syncFromAnkiDroid()
            }
            reloadDbStats()
        }
    }

    // ── Startup initialization ─────────────────────────────────────────────
    // Phase 1: mark AnkiDroid state (memory-only, instant)
    // Phase 2: yield to let the first frame render
    // Phase 3: run diagnostics on IO thread in background
    LaunchedEffect(Unit) {
        // Fast: no I/O, just local checks
        // isAnkiInstalled = AnkiDroidBridge.isAnkiDroidInstalled(context)
        hasPermission   = AnkiDroidBridge.hasPermission(context)

        // Yield compositor so the first frame paints before any heavy work
        kotlinx.coroutines.yield()

        // Load Room stats (fast read from already-open DB) — safe after yield
        reloadDbStats()

        coroutineScope.launch(Dispatchers.IO) {
            try {
                repo.loadDefaultAliasesIfNeeded()
                Log.d("MainActivity", "Background sync + diagnostics starting…")
                val isCachePopulated = repo.isCachePopulated()
                val shouldSync = !isCachePopulated && hasPermission
                val report = DataLayerDiagnostics.runFullDiagnostics(context, syncFirst = shouldSync)
                Log.d("MainActivity", "Diagnostics done: ${report.totalDecks} decks, ${report.totalCards} cards")
                // Refresh UI counts after background sync completes
                withContext(Dispatchers.Main) { reloadDbStats() }
            } catch (e: Exception) {
                Log.e("MainActivity", "Background diagnostics failed: ${e.message}")
            }
        }
    }

    // Permission launcher
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { granted ->
        hasPermission = granted
        if (granted) {
            refreshState()
        }
    }

     // Unified import states for CSV, APKG, and EPUB
     var pendingImportUri by remember { mutableStateOf<android.net.Uri?>(null) }
     var pendingImportType by remember { mutableStateOf<String?>(null) } // "CSV", "APKG", or "EPUB"
     var showImportDialog by remember { mutableStateOf(false) }

     // APKG document picker launcher
     val importPickerLauncher = rememberLauncherForActivityResult(
         contract = ActivityResultContracts.OpenDocument()
     ) { uri ->
         uri?.let {
             pendingImportUri = it
             pendingImportType = "APKG"
             showImportDialog = true
         }
     }

     // CSV document picker launcher
     val importCsvPickerLauncher = rememberLauncherForActivityResult(
         contract = ActivityResultContracts.OpenDocument()
     ) { uri ->
         uri?.let {
             pendingImportUri = it
             pendingImportType = "CSV"
             showImportDialog = true
         }
     }

     // EPUB document picker launcher
     val importEpubPickerLauncher = rememberLauncherForActivityResult(
         contract = ActivityResultContracts.OpenDocument()
     ) { uri ->
         uri?.let {
             pendingImportUri = it
             pendingImportType = "EPUB"
             showImportDialog = true
         }
     }

     // APKG document exporter launcher
     var deckToExport by remember { mutableStateOf<AnkiDeck?>(null) }
     val exportApkgLauncher = rememberLauncherForActivityResult(
         contract = ActivityResultContracts.CreateDocument("application/octet-stream")
     ) { uri ->
         uri?.let { fileUri ->
             val deck = deckToExport ?: return@rememberLauncherForActivityResult
             coroutineScope.launch {
                 Toast.makeText(context, "Exporting deck...", Toast.LENGTH_SHORT).show()
                 val success = repo.exportApkg(deck.id, deck.name, fileUri)
                 if (success) {
                     Toast.makeText(context, "Exported successfully", Toast.LENGTH_SHORT).show()
                 } else {
                     Toast.makeText(context, "Export failed", Toast.LENGTH_SHORT).show()
                 }
             }
         }
     }

     // Show Import dialog whenever a CSV or APKG URI is pending
     if (showImportDialog && pendingImportUri != null && pendingImportType != null) {
         val fileType = pendingImportType!!
         ImportDeckDialog(
             fileType = fileType,
             decks = decksList,
             onDismiss = {
                 showImportDialog = false
                 pendingImportUri = null
                 pendingImportType = null
             },
             onNewDeck = { customName, duplicateStrategy ->
                 showImportDialog = false
                 val fileUri = pendingImportUri ?: return@ImportDeckDialog
                 pendingImportUri = null
                 pendingImportType = null
                 coroutineScope.launch {
                     Toast.makeText(context, "Importing $fileType as new deck...", Toast.LENGTH_SHORT).show()
                     val result = if (fileType == "APKG") {
                         if (customName.isNotEmpty()) {
                             repo.importApkg(fileUri, targetDeckName = customName)
                         } else {
                             repo.importApkg(fileUri)
                         }
                     } else if (fileType == "EPUB") {
                         if (customName.isNotEmpty()) {
                             repo.importEpub(fileUri, targetDeckName = customName)
                         } else {
                             repo.importEpub(fileUri)
                         }
                     } else {
                         if (customName.isNotEmpty()) {
                             val tempResult = repo.importCsv(fileUri, duplicateStrategy)
                             if (tempResult.success) {
                                 // Rename target deck to custom name
                                 val createdDeck = repo.getAllDecks().find { it.name == tempResult.fileName.removeSuffix(".csv") || it.name == tempResult.fileName }
                                 if (createdDeck != null) {
                                     repo.renameDeck(createdDeck.id, customName)
                                 }
                             }
                             tempResult
                         } else {
                             repo.importCsv(fileUri, duplicateStrategy)
                         }
                     }
                     if (result.success) {
                         Toast.makeText(
                             context,
                             "Successfully imported: ${result.fileName}\nDecks/Cards: ${result.totalCards}",
                             Toast.LENGTH_LONG
                         ).show()
                         reloadDbStats()
                     } else {
                         Toast.makeText(
                             context,
                             "Import failed: ${result.error}",
                             Toast.LENGTH_LONG
                         ).show()
                     }
                 }
             },
             onMergeIntoDeck = { targetId, targetName, duplicateStrategy ->
                 showImportDialog = false
                 val fileUri = pendingImportUri ?: return@ImportDeckDialog
                 pendingImportUri = null
                 pendingImportType = null
                 coroutineScope.launch {
                     Toast.makeText(context, "Merging $fileType into '$targetName'...", Toast.LENGTH_SHORT).show()
                     val result = if (fileType == "APKG") {
                         repo.importApkg(fileUri, targetDeckId = targetId, targetDeckName = targetName)
                     } else if (fileType == "EPUB") {
                         repo.importEpub(fileUri, targetDeckId = targetId, targetDeckName = targetName)
                     } else {
                         repo.importCsvIntoExistingDeck(fileUri, targetId, targetName, duplicateStrategy)
                     }
                     if (result.success) {
                         Toast.makeText(
                             context,
                             "Merged ${result.totalCards} cards into '$targetName'",
                             Toast.LENGTH_LONG
                         ).show()
                         reloadDbStats()
                     } else {
                         Toast.makeText(
                             context,
                             "Merge failed: ${result.error}",
                             Toast.LENGTH_LONG
                         ).show()
                     }
                 }
             }
         )
     }

    when (val screen = currentScreen) {
        Screen.DeckSelection -> {
             DeckSelectionScreen(
                 isAnkiInstalled = AnkiDroidBridge.isAnkiDroidInstalled(context),
                 hasPermission = hasPermission,
                 decks = decksList,
                 currentMode = currentMode,
                 cardCount = cardCount,
                 sessionRecords = sessionRecords,
                 isDarkMode = isDarkMode,
                 onDarkModeToggle = onDarkModeToggle,
                 themePreset = themePreset,
                 onThemePresetChange = onThemePresetChange,
                 fontFamilyType = fontFamilyType,
                 onFontFamilyTypeChange = onFontFamilyTypeChange,
                 onRequestPermission = {
                     permissionLauncher.launch(AnkiDroidBridge.PERMISSION)
                 },
                 onRefresh = { refreshState() },
                 onSettingsClicked = {
                     reloadDbStats()
                     currentScreen = Screen.Settings
                 },
                 onImportApkgClicked = {
                     importPickerLauncher.launch(
                         arrayOf("application/octet-stream", "application/zip", "*/*")
                     )
                 },
                 onImportCsvClicked = {
                     // Use */* to ensure all CSV files are selectable
                     importCsvPickerLauncher.launch(
                         arrayOf("*/*")
                     )
                 },
                 onImportEpubClicked = {
                     importEpubPickerLauncher.launch(
                         arrayOf("application/epub+zip", "*/*")
                     )
                 },
                 onSelectDeck = { deck ->
                     val deckMode = settingsRepo.getPreferredModeForDeck(deck.id) ?: currentMode
                     currentScreen = Screen.Quiz(deck, deckMode)
                 },
                 onProfileClicked = {
                     currentScreen = Screen.Profile
                 },
                 onDeleteDeck = { deck ->
                     coroutineScope.launch {
                         repo.deleteDeck(deck.id)
                         reloadDbStats()
                         withContext(Dispatchers.Main) {
                             Toast.makeText(context, "Deck deleted", Toast.LENGTH_SHORT).show()
                         }
                     }
                 },
                 onRenameDeck = { deck, newName ->
                     coroutineScope.launch {
                         repo.renameDeck(deck.id, newName)
                         reloadDbStats()
                         withContext(Dispatchers.Main) {
                             Toast.makeText(context, "Deck renamed to \"$newName\"", Toast.LENGTH_SHORT).show()
                         }
                     }
                 },
                 onMergeDecks = { source, target ->
                     coroutineScope.launch {
                         repo.mergeDecks(source.id, target.id)
                         reloadDbStats()
                         withContext(Dispatchers.Main) {
                             Toast.makeText(context, "Merged \"${source.name}\" into \"${target.name}\"", Toast.LENGTH_SHORT).show()
                         }
                     }
                 },
                 onClearDeckProgress = { deck ->
                     coroutineScope.launch {
                         repo.clearDeckProgress(deck.id)
                         withContext(Dispatchers.Main) {
                             Toast.makeText(context, "Progress cleared", Toast.LENGTH_SHORT).show()
                         }
                     }
                 },
                 onCreateDeck = { deckName ->
                     coroutineScope.launch {
                         repo.createDeck(deckName)
                         reloadDbStats()
                         withContext(Dispatchers.Main) {
                             Toast.makeText(context, "Deck \"$deckName\" created", Toast.LENGTH_SHORT).show()
                         }
                     }
                 },
                 onAddCardToDeck = { deck, front, back, tags, frontImg, backImg, explImg, optImgs ->
                      coroutineScope.launch {
                          repo.addCard(deck.name, front, back, tags, frontImg, backImg, explImg, optImgs)
                          reloadDbStats()
                          withContext(Dispatchers.Main) {
                              Toast.makeText(context, "Card added to ${deck.name}", Toast.LENGTH_SHORT).show()
                          }
                      }
                  },
                 onExportDeck = { deck ->
                     deckToExport = deck
                     val defaultFilename = "${deck.name.replace("::", "_")}.apkg"
                     exportApkgLauncher.launch(defaultFilename)
                 }
             )
         }
        is Screen.Profile -> {
            BackHandler {
                currentScreen = Screen.DeckSelection
            }
            com.example.flashcardapp.ui.ProfileTab(
                sessionRecords = sessionRecords,
                cardCount = cardCount,
                onBackPressed = {
                    currentScreen = Screen.DeckSelection
                }
            )
        }
        is Screen.AliasEditor -> {
            BackHandler {
                currentScreen = Screen.Settings
            }
            val aliases by repo.aliasDao.getAllAliasesFlow().collectAsState(initial = emptyList())
            com.example.flashcardapp.ui.AliasEditorScreen(
                aliases = aliases,
                onBack = { currentScreen = Screen.Settings },
                onAddAlias = { name, alias ->
                    coroutineScope.launch {
                        repo.aliasDao.insertAlias(com.example.flashcardapp.data.entities.AliasEntity(name, alias))
                    }
                },
                onDeleteAlias = { entity ->
                    coroutineScope.launch {
                        repo.aliasDao.deleteAlias(entity)
                    }
                },
                onModifyAlias = { old, newName, newAlias ->
                    coroutineScope.launch {
                        repo.aliasDao.deleteAlias(old)
                        repo.aliasDao.insertAlias(com.example.flashcardapp.data.entities.AliasEntity(newName, newAlias))
                    }
                }
            )
        }
        is Screen.Settings -> {
            BackHandler {
                currentScreen = Screen.DeckSelection
            }
            SettingsScreen(
                currentMode = currentMode,
                onModeChange = {
                    currentMode = it
                    settingsRepo.studyMode = it
                },
                vibrationEnabled = vibrationEnabled,
                onVibrationToggle = {
                    vibrationEnabled = it
                    settingsRepo.vibrationEnabled = it
                },
                numberOfOptions = numberOfOptions,
                onNumberOfOptionsChange = {
                    numberOfOptions = it
                    settingsRepo.numberOfOptions = it
                },
                questionLimit = questionLimit,
                onQuestionLimitChange = {
                    questionLimit = it
                    settingsRepo.questionLimit = it
                },
                shuffleQuestions = shuffleQuestions,
                onShuffleQuestionsToggle = {
                    shuffleQuestions = it
                    settingsRepo.shuffleQuestions = it
                },
                showExplanations = showExplanations,
                onShowExplanationsToggle = {
                    showExplanations = it
                    settingsRepo.showExplanations = it
                },
                timeLimitSeconds = timeLimitSeconds,
                onTimeLimitSecondsChange = {
                    timeLimitSeconds = it
                    settingsRepo.timeLimitSeconds = it
                },
                themePreset = themePreset,
                onThemePresetChange = onThemePresetChange,
                isDarkMode = isDarkMode,
                onDarkModeToggle = onDarkModeToggle,
                useDynamicWallpaper = useDynamicWallpaper,
                onUseDynamicWallpaperToggle = onUseDynamicWallpaperToggle,
                fontFamilyType = fontFamilyType,
                onFontFamilyTypeChange = onFontFamilyTypeChange,
                currentLanguage = currentLanguage,
                onLanguageChange = {
                    TranslationManager.setLanguage(it)
                    settingsRepo.appLanguage = it.code
                },
                deckCount = deckCount,
                cardCount = cardCount,
                onSyncNow = {
                    coroutineScope.launch {
                        repo.syncFromAnkiDroid()
                        reloadDbStats()
                    }
                },
                onClearCache = {
                    coroutineScope.launch {
                        repo.clearCache()
                        reloadDbStats()
                    }
                },
                onBackPressed = {
                    currentScreen = Screen.DeckSelection
                }
            )
        }
        is Screen.Quiz -> {
            var mcqsState by remember(screen.deck, screen.mode, numberOfOptions, questionLimit, shuffleQuestions) {
                mutableStateOf<List<Mcq>?>(null)
            }
            var showAbandonDialog by remember { mutableStateOf(false) }
            var adDismissed by remember(screen.deck, screen.mode) {
                mutableStateOf(screen.mode == McqSessionMode.PRACTICE)
            }

            BackHandler {
                if (!adDismissed) {
                    currentScreen = Screen.DeckSelection
                } else if (mcqsState == null) {
                    currentScreen = Screen.DeckSelection
                } else {
                    showAbandonDialog = true
                }
            }
            
            LaunchedEffect(screen.deck, screen.mode, numberOfOptions, questionLimit, shuffleQuestions) {
                val questions = kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.Default) {
                    val allCards = repo.getCardsForHierarchy(screen.deck.name)
                    val allAliases = repo.getAllAliases()
                    
                    // 1. targetCards is just allCards since we queried exactly the hierarchy
                    var targetCards = allCards
                    
                    // 2. Select the final cards based on mode and settings
                    if (screen.mode == McqSessionMode.REVISION) {
                        val maxForRevision = if (questionLimit > 0) questionLimit else Int.MAX_VALUE
                        targetCards = WeakCardSelector.selectWeakCards(
                            cards = targetCards,
                            cardAttempts = repo.getAllCardAttempts(),
                            maxCards = maxForRevision
                        )
                        // If shuffle is enabled, we shuffle the weak cards so they aren't always in the exact same FSRS order
                        if (shuffleQuestions) {
                            targetCards = targetCards.shuffled()
                        }
                    } else {
                        if (shuffleQuestions) {
                            targetCards = targetCards.shuffled()
                        }
                        if (questionLimit > 0) {
                            targetCards = targetCards.take(questionLimit)
                        }
                    }

                    // 3. Generate MCQs ONLY for the selected cards
                    val engine = McqEngine(optionsCount = numberOfOptions)
                    engine.generate(
                        allCards = allCards,
                        targetCards = targetCards,
                        aliases = allAliases
                    )
                }
                mcqsState = questions
            }

            // adSessionKey: unique timestamp when this quiz session was created.
            // This ensures RealAdmobInterstitialAd's LaunchedEffect re-fires every
            // new quiz — even if the same InterstitialAd object is reused.
            val adSessionKey = remember(screen.deck, screen.mode) { System.currentTimeMillis() }
            // adIndex rotates through mock ads so the fallback never shows the same ad twice
            val adIndex = remember(screen.deck, screen.mode) {
                (System.currentTimeMillis() / 1000).toInt()
            }

            if (!adDismissed) {
                RealAdmobInterstitialAd(
                    onAdDismissed = { adDismissed = true },
                    isQuizReady = (mcqsState != null),
                    adSessionKey = adSessionKey,
                    adIndex = adIndex
                )
            } else if (mcqsState == null) {
                // Skeleton loading screen mimicking QuizScreen
                Box(
                    modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize().padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        // Top bar skeleton
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                            Box(modifier = Modifier.width(40.dp).height(40.dp).clip(CircleShape).background(shimmerBrush()))
                            Box(modifier = Modifier.width(120.dp).height(24.dp).clip(RoundedCornerShape(4.dp)).background(shimmerBrush()))
                            Box(modifier = Modifier.width(60.dp).height(32.dp).clip(RoundedCornerShape(16.dp)).background(shimmerBrush()))
                        }
                        
                        // Progress bar skeleton
                        Box(modifier = Modifier.fillMaxWidth().height(6.dp).clip(RoundedCornerShape(3.dp)).background(shimmerBrush()))
                        
                        // Question card skeleton
                        Box(modifier = Modifier.fillMaxWidth().height(140.dp).clip(RoundedCornerShape(16.dp)).background(shimmerBrush()))
                        
                        // Options skeletons
                        for (i in 0 until 4) {
                            Row(
                                modifier = Modifier.fillMaxWidth().height(64.dp).clip(RoundedCornerShape(16.dp)).background(shimmerBrush()).padding(horizontal = 16.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                Box(modifier = Modifier.size(36.dp).clip(CircleShape).background(MaterialTheme.colorScheme.background))
                                Box(modifier = Modifier.fillMaxWidth().height(16.dp).clip(RoundedCornerShape(4.dp)).background(MaterialTheme.colorScheme.background))
                            }
                        }
                    }
                }
            } else {
                val questions = mcqsState!!
                if (questions.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(BackgroundLavender),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Text(TranslationManager.getString("no_questions_found"), color = TextPrimaryDeep, fontWeight = FontWeight.Bold)
                            Button(
                                onClick = { currentScreen = Screen.DeckSelection },
                                colors = ButtonDefaults.buttonColors(containerColor = PrimaryPurple)
                            ) {
                                Text(TranslationManager.getString("back"), color = Color.White)
                            }
                        }
                    }
                } else {
                    val sessionManager = remember(questions, screen.mode) {
                        Log.i("MainActivity", "=== MCQ SESSION START CONFIRMATION ===")
                        Log.i("MainActivity", "Total Decks Loaded: ${decksList.size}")
                        Log.i("MainActivity", "Selected Deck ID: ${screen.deck.id}")
                        Log.i("MainActivity", "Number of MCQs Generated: ${questions.size}")
                        Log.i("MainActivity", "Session Mode: ${screen.mode}")
                        
                        val previewSize = minOf(3, questions.size)
                        Log.i("MainActivity", "First $previewSize MCQs Preview:")
                        for (i in 0 until previewSize) {
                            val q = questions[i]
                            Log.i("MainActivity", "  MCQ #$i: Q='${q.question}' | Options=${q.options} | Correct=${q.correctIndex}")
                        }
                        Log.i("MainActivity", "========================================")

                        McqSessionManager(screen.mode, questions)
                    }

                     // Abandon-quiz dialog state
                     if (showAbandonDialog) {
                         AlertDialog(
                             onDismissRequest = { showAbandonDialog = false },
                             title = null,
                             text = {
                                 Column(
                                     modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                                     horizontalAlignment = Alignment.CenterHorizontally
                                 ) {
                                     Text(
                                         text = "Are you sure you want to exit the test?",
                                         fontWeight = FontWeight.Bold,
                                         fontSize = 18.sp,
                                         color = MaterialTheme.colorScheme.onSurface,
                                         textAlign = TextAlign.Center,
                                         modifier = Modifier.padding(bottom = 20.dp)
                                     )
                                     Row(
                                         modifier = Modifier.fillMaxWidth(),
                                         horizontalArrangement = Arrangement.spacedBy(12.dp)
                                     ) {
                                         Button(
                                             onClick = { showAbandonDialog = false },
                                             colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                                             shape = RoundedCornerShape(10.dp),
                                             modifier = Modifier.weight(1f)
                                         ) {
                                             Text("Continue", color = Color.White)
                                         }
                                         OutlinedButton(
                                             onClick = {
                                                 showAbandonDialog = false
                                                 currentScreen = Screen.DeckSelection
                                             },
                                             border = BorderStroke(1.dp, MaterialTheme.colorScheme.error),
                                             shape = RoundedCornerShape(10.dp),
                                             colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.error),
                                             modifier = Modifier.weight(1f)
                                         ) {
                                             Text("Exit", color = MaterialTheme.colorScheme.error)
                                         }
                                     }
                                 }
                             },
                             confirmButton = {},
                             dismissButton = null,
                             shape = RoundedCornerShape(16.dp),
                             containerColor = MaterialTheme.colorScheme.surface
                         )
                     }

                    QuizScreen(
                        deckId = screen.deck.id,
                        deckName = screen.deck.name,
                        sessionManager = sessionManager,
                        vibrationEnabled = vibrationEnabled,
                        showExplanations = showExplanations,
                        showTags = showTags,
                        timeLimitSeconds = timeLimitSeconds,
                        onBackPressed = { showAbandonDialog = true }
                    )

                    var sessionState by remember { mutableStateOf(sessionManager.getCurrentState()) }
                    DisposableEffect(sessionManager) {
                        val listener: (McqSessionState) -> Unit = { state ->
                            sessionState = state
                        }
                        sessionManager.addListener(listener)
                        onDispose {
                            sessionManager.removeListener(listener)
                        }
                    }

                    LaunchedEffect(sessionState.isFinished) {
                        if (sessionState.isFinished) {
                            // Save session record synchronously inside this coroutine BEFORE navigating
                            // so the Room Flow update is guaranteed to propagate to the Analytics tab.
                            try {
                                repo.saveSessionRecord(
                                    SessionRecordEntity(
                                        deckId = screen.deck.id,
                                        deckName = screen.deck.name,
                                        mode = screen.mode.name,
                                        score = sessionState.score,
                                        totalQuestions = sessionState.questions.size,
                                        timeTakenSeconds = sessionState.totalTimeTakenMs / 1000,
                                        timestamp = System.currentTimeMillis()
                                    )
                                )
                                val attempts = mutableListOf<com.example.flashcardapp.data.entities.CardAttemptEntity>()
                                for (record in sessionState.answeredQuestions) {
                                    val rating = repo.fsrsScheduler.processAnswer(
                                        cardId = record.question.sourceCardId,
                                        isCorrect = record.isCorrect,
                                        timeTakenMs = record.timeTakenMs
                                    )
                                    attempts.add(
                                        com.example.flashcardapp.data.entities.CardAttemptEntity(
                                            cardId = record.question.sourceCardId,
                                            deckId = screen.deck.id,
                                            isCorrect = record.isCorrect,
                                            timeTakenMs = record.timeTakenMs,
                                            fsrsRating = rating.value,
                                            timestamp = System.currentTimeMillis()
                                        )
                                    )
                                }
                                if (attempts.isNotEmpty()) {
                                    repo.saveCardAttempts(attempts)
                                }
                            } catch (e: Exception) {
                                Log.e("MainActivity", "Failed to save session record: ${e.message}", e)
                            }
                            currentScreen = Screen.Results(
                                deck = screen.deck,
                                score = sessionState.score,
                                timeTakenSeconds = sessionState.totalTimeTakenMs / 1000,
                                totalQuestions = sessionState.questions.size,
                                answeredQuestions = sessionState.answeredQuestions
                            )
                        }
                    }
                }
            }
        }
        is Screen.Results -> {
            BackHandler {
                refreshState()
                currentScreen = Screen.DeckSelection
            }
            ResultsScreen(
                score = screen.score,
                totalQuestions = screen.totalQuestions,
                timeTakenSeconds = screen.timeTakenSeconds,
                answeredQuestions = screen.answeredQuestions,
                onRestart = {
                    currentScreen = Screen.Quiz(screen.deck, currentMode)
                },
                onHome = {
                    refreshState()
                    currentScreen = Screen.DeckSelection
                },
                onReviewMistakes = {
                    currentScreen = Screen.ReviewMistakes(
                        deck = screen.deck,
                        answeredQuestions = screen.answeredQuestions
                    )
                },
                onOverrideRating = { cardId ->
                    coroutineScope.launch {
                        repo.fsrsScheduler.overrideRating(cardId, com.example.flashcardapp.fsrs.Rating.Hard)
                    }
                }
            )
        }
        is Screen.ReviewMistakes -> {
            BackHandler {
                currentScreen = Screen.DeckSelection
            }
            ReviewMistakesScreen(
                deckName = screen.deck.name,
                answeredQuestions = screen.answeredQuestions,
                onBack = {
                    // Go back to results
                    currentScreen = Screen.DeckSelection
                }
            )
        }
    }
}

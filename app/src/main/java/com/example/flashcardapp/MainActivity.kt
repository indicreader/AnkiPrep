package com.example.flashcardapp

import android.content.pm.PackageManager
import android.content.ContextWrapper
import android.content.res.Configuration
import java.util.Locale
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
import android.content.Context
import com.example.flashcardapp.ui.showExamNotification
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
import com.example.flashcardapp.data.entities.CardEntity
import com.example.flashcardapp.ui.components.ImportProgressDialog
import com.example.flashcardapp.ui.DeckSelectionScreen
import com.example.flashcardapp.ui.ImportDeckDialog
import com.example.flashcardapp.ui.PdfSegmentConfigDialog
import com.example.flashcardapp.ui.CsvMappingDialog
import com.example.flashcardapp.ui.QuizScreen
import com.example.flashcardapp.ui.ResultsScreen
import com.example.flashcardapp.ui.ReviewMistakesScreen
import com.example.flashcardapp.ui.SettingsScreen
import com.example.flashcardapp.ui.ProfileScreen
import com.example.flashcardapp.ui.PluginManagementScreen
import com.example.flashcardapp.data.plugin.PluginRepository
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
    object Plugins : Screen()
    object CurrentAffairs : Screen()
    object Profile : Screen()
    object AliasEditor : Screen()
    data class Quiz(
        val deck: AnkiDeck,
        val mode: McqSessionMode,
        val customDeckIds: List<Long>? = null,
        val customDeckPaths: List<String>? = null,
        val customTags: List<String>? = null,
        val isStarredOnly: Boolean = false,
        val sessionKey: Long = System.currentTimeMillis()
    ) : Screen()
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
    data class MockExam(
        val deck: AnkiDeck,
        val preset: com.example.flashcardapp.mock.ExamPreset
    ) : Screen()
}

// =========================================================================
// GOOGLE ADMOB CONFIGURATION
// Replace with your actual Ad Unit ID when ready for production.
// Test Interstitial ID is: "ca-app-pub-3940256099942544/1033173712"
// =========================================================================
const val ADMOB_INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-6846875306917122/8090484835"
// =========================================================================

class LocaleContextWrapper(base: Context) : ContextWrapper(base) {
    companion object {
        fun wrap(context: Context, savedLanguageCode: String): ContextWrapper {
            val locale = Locale(savedLanguageCode)
            Locale.setDefault(locale)
            val config = Configuration(context.resources.configuration)
            config.setLocale(locale)
            val newContext = context.createConfigurationContext(config)
            return LocaleContextWrapper(newContext)
        }
    }
}

class MainActivity : ComponentActivity() {

    override fun attachBaseContext(newBase: Context) {
        val settingsRepo = SettingsRepository.getInstance(newBase)
        val savedLanguageCode = settingsRepo.appLanguage
        val wrappedContext = LocaleContextWrapper.wrap(newBase, savedLanguageCode)
        super.attachBaseContext(wrappedContext)
    }

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
        // Ad module disabled until app is fully functional
        // MobileAds.initialize(this) { loadInterstitialAd() }
        handleIntent(intent)
        setContent {
            val context = LocalContext.current
            val settingsRepo = remember { SettingsRepository.getInstance(context) }
            
            var themePreset by remember { mutableStateOf(settingsRepo.themePreset) }
            var useDynamicWallpaper by remember { mutableStateOf(settingsRepo.useDynamicWallpaperTheme) }
            var isDarkMode by remember { mutableStateOf(settingsRepo.isDarkMode) }
            var useOledBlack by remember { mutableStateOf(settingsRepo.useOledBlack) }
            var fontScaleFactor by remember { mutableStateOf(settingsRepo.fontScaleFactor) }
            var fontFamilyType by remember { mutableStateOf(settingsRepo.fontFamilyType) }
            var customPrimaryColor by remember { mutableStateOf(settingsRepo.customPrimaryColor) }
            var customAccentColor by remember { mutableStateOf(settingsRepo.customAccentColor) }
            var morphismElevationFactor by remember { mutableStateOf(settingsRepo.morphismElevationFactor) }

            DisposableEffect(settingsRepo) {
                val listener = android.content.SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
                    when (key) {
                        "custom_primary_color" -> customPrimaryColor = settingsRepo.customPrimaryColor
                        "custom_accent_color" -> customAccentColor = settingsRepo.customAccentColor
                        "morphism_elevation_factor" -> morphismElevationFactor = settingsRepo.morphismElevationFactor
                        "theme_preset" -> themePreset = settingsRepo.themePreset
                        "use_dynamic_wallpaper_theme" -> useDynamicWallpaper = settingsRepo.useDynamicWallpaperTheme
                    }
                }
                settingsRepo.registerOnSharedPreferenceChangeListener(listener)
                onDispose {
                    settingsRepo.unregisterOnSharedPreferenceChangeListener(listener)
                }
            }

            // Restore saved language on every app launch
            remember(settingsRepo.appLanguage) {
                TranslationManager.setLanguageByCode(settingsRepo.appLanguage)
            }

            key(TranslationManager.currentLanguageState) {
                AnkiQuizTheme(
                    themePreset = themePreset,
                    isDarkMode = isDarkMode,
                    useOledBlack = useOledBlack,
                    fontScaleFactor = fontScaleFactor,
                    useDynamicWallpaper = useDynamicWallpaper,
                    fontFamilyType = fontFamilyType,
                    customPrimaryColor = customPrimaryColor,
                    customAccentColor = customAccentColor,
                    morphismElevationFactor = morphismElevationFactor
                ) {
                    MainLayout(
                        themePreset = themePreset,
                        onThemePresetChange = {
                            themePreset = it
                            settingsRepo.themePreset = it
                            // Selecting a morphism preset automatically turns off dynamic wallpaper override so preset applies instantly
                            if (useDynamicWallpaper) {
                                useDynamicWallpaper = false
                                settingsRepo.useDynamicWallpaperTheme = false
                            }
                        },
                        isDarkMode = isDarkMode,
                        onDarkModeToggle = {
                            isDarkMode = it
                            settingsRepo.isDarkMode = it
                        },
                        useOledBlack = useOledBlack,
                        onUseOledBlackToggle = {
                            useOledBlack = it
                            settingsRepo.useOledBlack = it
                        },
                        fontScaleFactor = fontScaleFactor,
                        onFontScaleFactorChange = {
                            fontScaleFactor = it
                            settingsRepo.fontScaleFactor = it
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
    useOledBlack: Boolean = false,
    onUseOledBlackToggle: (Boolean) -> Unit = {},
    fontScaleFactor: Float = 1.0f,
    onFontScaleFactorChange: (Float) -> Unit = {},
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

    val settingsRepo = remember { SettingsRepository.getInstance(context) }
    val pluginRepository = remember {
        PluginRepository(com.example.flashcardapp.data.AppDatabase.getInstance(context).pluginDao())
    }
    var isPremium by remember { mutableStateOf(settingsRepo.isPremium) }
    DisposableEffect(settingsRepo) {
        val listener = android.content.SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            if (key == "is_premium") {
                isPremium = settingsRepo.isPremium
            }
        }
        settingsRepo.registerOnSharedPreferenceChangeListener(listener)
        onDispose {
            settingsRepo.unregisterOnSharedPreferenceChangeListener(listener)
        }
    }
    var deckOrderTrigger by remember { mutableStateOf(0) }

    val decksList = remember(cachedDecks, deckOrderTrigger) {
        val customOrder = settingsRepo.getDeckOrderList()
        val orderMap = customOrder.withIndex().associate { it.value to it.index }
        cachedDecks
            .sortedWith { d1, d2 ->
                val pos1 = orderMap[d1.id] ?: (100000 + d1.sortOrder)
                val pos2 = orderMap[d2.id] ?: (100000 + d2.sortOrder)
                if (pos1 != pos2) pos1.compareTo(pos2) else d1.fullPath.compareTo(d2.fullPath)
            }
            .map { AnkiDeck(it.id, it.fullPath, it.cardCount) }
    }

    // Settings State and Persistent Storage
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

    // Observe attempts since today's midnight to count practiced cards per deck today
    val todayMidnight = remember {
        java.util.Calendar.getInstance().apply {
            set(java.util.Calendar.HOUR_OF_DAY, 0)
            set(java.util.Calendar.MINUTE, 0)
            set(java.util.Calendar.SECOND, 0)
            set(java.util.Calendar.MILLISECOND, 0)
        }.timeInMillis
    }
    val attemptsToday by repo.observeAttemptsSince(todayMidnight).collectAsState(initial = emptyList())

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

        // Schedule periodic Daily Current Affairs background sync worker (24-hour cycle)
        com.example.flashcardapp.data.ca.DailyCurrentAffairsWorker.schedulePeriodicSync(context)

        // Load Room stats (fast read from already-open DB) — safe after yield
        reloadDbStats()

        coroutineScope.launch(Dispatchers.IO) {
            try {
                repo.loadDefaultAliasesIfNeeded()
                val normalizedCards = repo.normalizeExistingCardsAndTags()
                if (normalizedCards > 0) {
                    Log.d("MainActivity", "Successfully normalized $normalizedCards existing cards across decks.")
                }
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

        // Periodic background worker for Exam Tracker web change detection
        coroutineScope.launch(Dispatchers.IO) {
            while (true) {
                val profilePrefs = context.getSharedPreferences("AnkiPrepProfile", Context.MODE_PRIVATE)
                val examsJson = profilePrefs.getString("saved_exams", null)
                if (examsJson != null) {
                    try {
                        val array = org.json.JSONArray(examsJson)
                        for (i in 0 until array.length()) {
                            val obj = array.getJSONObject(i)
                            val name = obj.getString("name")
                            val url = obj.getString("url")
                            
                            val urlConnection = java.net.URL(url).openConnection() as java.net.HttpURLConnection
                            urlConnection.connectTimeout = 5000
                            urlConnection.readTimeout = 5000
                            val html = urlConnection.inputStream.bufferedReader().use { it.readText() }
                            val newHash = html.hashCode().toString()
                            val cachedHash = profilePrefs.getString("exam_hash_$url", null)
                            
                            if (cachedHash != null && cachedHash != newHash) {
                                profilePrefs.edit()
                                    .putString("exam_hash_$url", newHash)
                                    .putBoolean("exam_has_delta_$url", true)
                                    .apply()
                                
                                // Show native notification
                                showExamNotification(context, name)
                            } else if (cachedHash == null) {
                                profilePrefs.edit()
                                    .putString("exam_hash_$url", newHash)
                                    .apply()
                            }
                        }
                    } catch (e: Exception) {
                        // ignore network errors
                    }
                }
                // Poll every 15 minutes
                kotlinx.coroutines.delay(15 * 60 * 1000L)
            }
        }
    }

    LaunchedEffect(currentScreen) {
        if (currentScreen is Screen.Quiz || currentScreen is Screen.Settings) {
            currentMode = settingsRepo.studyMode
            vibrationEnabled = settingsRepo.vibrationEnabled
            numberOfOptions = settingsRepo.numberOfOptions
            questionLimit = settingsRepo.questionLimit
            shuffleQuestions = settingsRepo.shuffleQuestions
            showExplanations = settingsRepo.showExplanations
            showTags = settingsRepo.showTags
            timeLimitSeconds = settingsRepo.timeLimitSeconds
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

     // Unified import states for CSV, JSON, APKG, and EPUB
     var pendingImportUri by remember { mutableStateOf<android.net.Uri?>(null) }
     var pendingImportType by remember { mutableStateOf<String?>(null) } // "CSV", "JSON", "APKG", or "EPUB"
     var showImportDialog by remember { mutableStateOf(false) }
     var showMappingDialog by remember { mutableStateOf(false) }
     var mappingTargetDeckId by remember { mutableStateOf<Long?>(null) }
     var mappingTargetDeckName by remember { mutableStateOf<String?>(null) }
     var mappingCustomName by remember { mutableStateOf("") }
     var mappingDuplicateStrategy by remember { mutableStateOf("UPDATE") }

     // Streaming Import Progress Dialog states
     var isImportingStreaming by remember { mutableStateOf(false) }
     var importProgressTitle by remember { mutableStateOf("Importing Questions") }
     var importProgressStatus by remember { mutableStateOf("Processing...") }
     var importProgressCount by remember { mutableStateOf(0) }
     var importProgressTotal by remember { mutableStateOf(-1) }

     fun safelyCacheImportUri(rawUri: android.net.Uri): android.net.Uri {
         return try {
             try {
                 context.contentResolver.takePersistableUriPermission(
                     rawUri,
                     android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION
                 )
             } catch (_: Exception) {}
             val cached = com.example.flashcardapp.data.core.FileImportUtils.copyUriToCacheFile(context, rawUri)
             android.net.Uri.fromFile(cached)
         } catch (e: Exception) {
             rawUri
         }
     }

     // APKG document picker launcher
     val importPickerLauncher = rememberLauncherForActivityResult(
         contract = ActivityResultContracts.OpenDocument()
     ) { uri ->
         uri?.let {
             pendingImportUri = safelyCacheImportUri(it)
             pendingImportType = "APKG"
             showImportDialog = true
         }
     }

     // CSV / JSON / ZIP document picker launcher
     val importCsvPickerLauncher = rememberLauncherForActivityResult(
         contract = ActivityResultContracts.OpenDocument()
     ) { uri ->
         uri?.let {
             val cachedUri = safelyCacheImportUri(it)
             pendingImportUri = cachedUri
             val name = repo.getFileName(it).lowercase()
             pendingImportType = when {
                 name.endsWith(".zip") -> "ZIP"
                 name.endsWith(".json") -> "JSON"
                 else -> "CSV"
             }
             showImportDialog = true
         }
     }

     // EPUB document picker launcher
     val importEpubPickerLauncher = rememberLauncherForActivityResult(
         contract = ActivityResultContracts.OpenDocument()
     ) { uri ->
         uri?.let {
             val cachedUri = safelyCacheImportUri(it)
             pendingImportUri = cachedUri
             val name = repo.getFileName(it).lowercase()
             pendingImportType = if (name.endsWith(".zip")) "ZIP" else "EPUB"
             showImportDialog = true
         }
     }

     // PDF document picker launcher (Multi-Column Question Booklet)
     val importPdfPickerLauncher = rememberLauncherForActivityResult(
         contract = ActivityResultContracts.OpenDocument()
     ) { uri ->
         uri?.let {
             val cachedUri = safelyCacheImportUri(it)
             pendingImportUri = cachedUri
             pendingImportType = "PDF"
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

     // Show Import dialog whenever a CSV, PDF, or APKG URI is pending
     if (showImportDialog && pendingImportUri != null && pendingImportType != null) {
         val fileType = pendingImportType!!
         if (fileType == "PDF") {
             PdfSegmentConfigDialog(
                 uri = pendingImportUri!!,
                 decks = decksList,
                 onDismiss = {
                     showImportDialog = false
                     pendingImportUri = null
                     pendingImportType = null
                 },
                 onSuccess = { deckName, cardCount ->
                     showImportDialog = false
                     pendingImportUri = null
                     pendingImportType = null
                     reloadDbStats()
                 }
             )
         } else {
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
                 if (fileType == "CSV") {
                     mappingCustomName = customName
                     mappingDuplicateStrategy = duplicateStrategy
                     mappingTargetDeckId = null
                     mappingTargetDeckName = null
                     showMappingDialog = true
                 } else if (fileType == "JSON") {
                     pendingImportUri = null
                     pendingImportType = null
                     importProgressTitle = "Importing JSON Deck"
                     importProgressStatus = "Preparing JSON records..."
                     importProgressCount = 0
                     importProgressTotal = -1
                     isImportingStreaming = true
                     coroutineScope.launch {
                         val result = repo.importJson(
                             uri = fileUri,
                             duplicateStrategy = duplicateStrategy,
                             targetDeckName = customName.ifEmpty { null },
                             onProgress = { count, total ->
                                 importProgressCount = count
                                 importProgressTotal = total
                                 importProgressStatus = if (total > 0) "Importing $count of $total items..." else "Imported $count items..."
                             }
                         )
                         isImportingStreaming = false
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
                 } else {
                     pendingImportUri = null
                     pendingImportType = null
                     coroutineScope.launch {
                         Toast.makeText(context, "Importing $fileType as new deck...", Toast.LENGTH_SHORT).show()
                         val result = when (fileType) {
                             "ZIP" -> if (customName.isNotEmpty()) repo.importZip(fileUri, duplicateStrategy, targetDeckName = customName) else repo.importZip(fileUri, duplicateStrategy)
                             "APKG" -> if (customName.isNotEmpty()) repo.importApkg(fileUri, targetDeckName = customName) else repo.importApkg(fileUri)
                             "PDF" -> repo.importPdf(fileUri, duplicateStrategy = duplicateStrategy, targetDeckName = customName.ifEmpty { null })
                             else -> if (customName.isNotEmpty()) repo.importEpub(fileUri, targetDeckName = customName) else repo.importEpub(fileUri)
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
                 }
             },
             onMergeIntoDeck = { targetId, targetName, duplicateStrategy ->
                 showImportDialog = false
                 val fileUri = pendingImportUri ?: return@ImportDeckDialog
                 if (fileType == "CSV") {
                     mappingTargetDeckId = targetId
                     mappingTargetDeckName = targetName
                     mappingDuplicateStrategy = duplicateStrategy
                     mappingCustomName = ""
                     showMappingDialog = true
                 } else if (fileType == "JSON") {
                     pendingImportUri = null
                     pendingImportType = null
                     importProgressTitle = "Merging JSON into '$targetName'"
                     importProgressStatus = "Preparing JSON records..."
                     importProgressCount = 0
                     importProgressTotal = -1
                     isImportingStreaming = true
                     coroutineScope.launch {
                         val result = repo.importJsonIntoExistingDeck(
                             uri = fileUri,
                             targetDeckId = targetId,
                             targetDeckName = targetName,
                             duplicateStrategy = duplicateStrategy,
                             onProgress = { count, total ->
                                 importProgressCount = count
                                 importProgressTotal = total
                                 importProgressStatus = if (total > 0) "Merging $count of $total items..." else "Merged $count items..."
                             }
                         )
                         isImportingStreaming = false
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
                 } else {
                     pendingImportUri = null
                     pendingImportType = null
                     coroutineScope.launch {
                         Toast.makeText(context, "Merging $fileType into '$targetName'...", Toast.LENGTH_SHORT).show()
                         val result = when (fileType) {
                             "ZIP" -> repo.importZipIntoExistingDeck(fileUri, targetId, targetName, duplicateStrategy)
                             "APKG" -> repo.importApkg(fileUri, targetDeckId = targetId, targetDeckName = targetName)
                             "PDF" -> repo.importPdf(fileUri, duplicateStrategy = duplicateStrategy, targetDeckId = targetId, targetDeckName = targetName)
                             else -> repo.importEpub(fileUri, targetDeckId = targetId, targetDeckName = targetName)
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
             }
         )
     }
 }

     if (showMappingDialog && pendingImportUri != null) {
         CsvMappingDialog(
             uri = pendingImportUri!!,
             onDismiss = {
                 showMappingDialog = false
                 pendingImportUri = null
                 pendingImportType = null
             },
             onConfirm = { mapping ->
                 showMappingDialog = false
                 val fileUri = pendingImportUri ?: return@CsvMappingDialog
                 pendingImportUri = null
                 pendingImportType = null
                 val targetId = mappingTargetDeckId
                 val targetName = mappingTargetDeckName
                 val customName = mappingCustomName
                 val duplicateStrategy = mappingDuplicateStrategy

                 importProgressTitle = if (targetId != null && targetName != null) "Merging CSV into '$targetName'" else "Importing CSV Deck"
                 importProgressStatus = "Parsing and validating rows..."
                 importProgressCount = 0
                 importProgressTotal = -1
                 isImportingStreaming = true

                 coroutineScope.launch {
                     val result = if (targetId != null && targetName != null) {
                         repo.importCsvIntoExistingDeck(
                             uri = fileUri,
                             targetDeckId = targetId,
                             targetDeckName = targetName,
                             duplicateStrategy = duplicateStrategy,
                             columnMapping = mapping,
                             onProgress = { count, total ->
                                 importProgressCount = count
                                 importProgressTotal = total
                                 importProgressStatus = if (total > 0) "Importing $count of $total rows..." else "Imported $count rows..."
                             }
                         )
                     } else {
                         if (customName.isNotEmpty()) {
                             val tempResult = repo.importCsv(
                                 uri = fileUri,
                                 duplicateStrategy = duplicateStrategy,
                                 columnMapping = mapping,
                                 onProgress = { count, total ->
                                     importProgressCount = count
                                     importProgressTotal = total
                                     importProgressStatus = if (total > 0) "Importing $count of $total rows..." else "Imported $count rows..."
                                 }
                             )
                             if (tempResult.success) {
                                 val createdDeck = repo.getAllDecks().find { it.name == tempResult.fileName.removeSuffix(".csv") || it.name == tempResult.fileName }
                                 if (createdDeck != null) {
                                     repo.renameDeck(createdDeck.id, customName)
                                 }
                             }
                             tempResult
                         } else {
                             repo.importCsv(
                                 uri = fileUri,
                                 duplicateStrategy = duplicateStrategy,
                                 columnMapping = mapping,
                                 onProgress = { count, total ->
                                     importProgressCount = count
                                     importProgressTotal = total
                                     importProgressStatus = if (total > 0) "Importing $count of $total rows..." else "Imported $count rows..."
                                 }
                             )
                         }
                     }
                     isImportingStreaming = false
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
             }
         )
     }

     if (isImportingStreaming) {
         ImportProgressDialog(
             title = importProgressTitle,
             statusMessage = importProgressStatus,
             currentCount = importProgressCount,
             totalEstimate = importProgressTotal
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
                 attemptsToday = attemptsToday,
                 isDarkMode = isDarkMode,
                 onDarkModeToggle = onDarkModeToggle,
                 useOledBlack = useOledBlack,
                 onUseOledBlackToggle = onUseOledBlackToggle,
                 fontScaleFactor = fontScaleFactor,
                 onFontScaleFactorChange = onFontScaleFactorChange,
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
                 onImportPdfClicked = {
                     importPdfPickerLauncher.launch(
                         arrayOf("application/pdf", "*/*")
                     )
                 },
                 onSelectDeck = { deck ->
                     val deckMode = settingsRepo.getPreferredModeForDeck(deck.id) ?: currentMode
                     currentScreen = Screen.Quiz(deck, deckMode)
                 },
                 onProfileClicked = {
                     currentScreen = Screen.Profile
                 },
                 onDeleteDeck = { deckPath ->
                     coroutineScope.launch {
                         repo.deleteDeckByPath(deckPath)
                         reloadDbStats()
                         withContext(Dispatchers.Main) {
                             Toast.makeText(context, "Deck deleted", Toast.LENGTH_SHORT).show()
                         }
                     }
                 },
                 onRenameDeck = { deck, newName ->
                     coroutineScope.launch {
                         if (deck.id != -1L) {
                             repo.renameDeck(deck.id, newName)
                         } else {
                             repo.renameDeckByPath(deck.name, newName)
                         }
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
                 },
                 onDeckOrderChanged = { newOrderIds ->
                     coroutineScope.launch {
                         repo.reorderDecks(newOrderIds)
                         settingsRepo.setDeckOrderList(newOrderIds)
                         deckOrderTrigger++
                     }
                 },
                 repo = repo,
                 onStartRevisionSession = { deckIds, isStarredOnly, sessionMode ->
                     val dummyDeck = if (isStarredOnly) {
                         AnkiDeck(id = -200L, name = "Starred Questions")
                     } else if (deckIds.size == 1) {
                         val matchingDeck = decksList.find { it.id == deckIds.first() }
                         matchingDeck ?: AnkiDeck(id = deckIds.first(), name = "Selected Deck")
                     } else {
                         AnkiDeck(id = -100L, name = "Selected Decks")
                     }
                     currentScreen = Screen.Quiz(
                         deck = dummyDeck,
                         mode = sessionMode,
                         customDeckIds = deckIds.takeIf { !isStarredOnly && it.size > 1 },
                         isStarredOnly = isStarredOnly
                     )
                 },
                 onStartCombinedTest = { selectedPaths, selectedTags ->
                     val dummyDeck = AnkiDeck(id = -300L, name = "Index Combined Test")
                     currentScreen = Screen.Quiz(
                         deck = dummyDeck,
                         mode = currentMode,
                         customDeckPaths = selectedPaths.ifEmpty { null },
                         customTags = selectedTags.ifEmpty { null }
                     )
                 },
                 onOpenPlugins = { currentScreen = Screen.Plugins },
                 onOpenCurrentAffairs = { currentScreen = Screen.CurrentAffairs },
                 onStartMockExam = { deck, preset ->
                     currentScreen = Screen.MockExam(deck, preset)
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
                    reloadDbStats()
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
                },
                decks = decksList,
                onImportApkgClicked = {
                    importPickerLauncher.launch(
                        arrayOf("application/octet-stream", "application/zip", "*/*")
                    )
                },
                onImportCsvClicked = {
                    importCsvPickerLauncher.launch(
                        arrayOf("*/*")
                    )
                },
                onImportEpubClicked = {
                    importEpubPickerLauncher.launch(
                        arrayOf("application/epub+zip", "*/*")
                    )
                },
                onImportPdfClicked = {
                    importPdfPickerLauncher.launch(
                        arrayOf("application/pdf", "*/*")
                    )
                },
                onExportDeck = { deck ->
                    deckToExport = deck
                    val defaultFilename = "${deck.name.replace("::", "_")}.apkg"
                    exportApkgLauncher.launch(defaultFilename)
                },
                onOpenPlugins = { currentScreen = Screen.Plugins },
                onOpenCurrentAffairs = { currentScreen = Screen.CurrentAffairs }
            )
        }
        is Screen.Plugins -> {
            BackHandler {
                currentScreen = Screen.Settings
            }
            PluginManagementScreen(
                pluginRepository = pluginRepository,
                onNavigateBack = { currentScreen = Screen.Settings }
            )
        }
        is Screen.CurrentAffairs -> {
            BackHandler {
                currentScreen = Screen.Settings
            }
            com.example.flashcardapp.ui.CurrentAffairsSettingsScreen(
                onBackClicked = { currentScreen = Screen.Settings }
            )
        }
        is Screen.Quiz -> {
            var mcqsState by remember(screen.deck, screen.mode, numberOfOptions, questionLimit, shuffleQuestions, screen.sessionKey) {
                mutableStateOf<List<Mcq>?>(null)
            }
             var showAbandonDialog by remember { mutableStateOf(false) }
             var showCapacityAlert by remember(screen.deck, screen.mode, screen.sessionKey) { mutableStateOf(false) }
             var adDismissed by remember(screen.deck, screen.mode, screen.sessionKey, isPremium) {
                 mutableStateOf(true) // Ads disabled
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
            
            LaunchedEffect(screen.deck, screen.mode, numberOfOptions, questionLimit, shuffleQuestions, screen.sessionKey) {
                val questions = kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.Default) {
                    val progressManager = com.example.flashcardapp.data.PersistentProgressManager(context)
                    val generationEngine = com.example.flashcardapp.session.SessionGenerationEngine(context)

                    val resolvedDeckName = if (screen.deck.id > 0) {
                        repo.getDeckById(screen.deck.id)?.fullPath ?: screen.deck.name
                    } else {
                        screen.deck.name
                    }

                    val remainingUnique = generationEngine.getRemainingUniqueCards(
                        deckHierarchy = resolvedDeckName,
                        deckId = screen.deck.id,
                        isStarredOnly = screen.isStarredOnly,
                        customDeckIds = screen.customDeckIds
                    )
                    if (remainingUnique.isEmpty() && screen.mode != McqSessionMode.REVISION) {
                        showCapacityAlert = true
                        return@withContext emptyList<Mcq>()
                    }

                    val allCards: List<CardEntity>
                    var targetCards: List<CardEntity>

                    if (screen.isStarredOnly) {
                        val starredIds = repo.getAllUserMetadataOnce().filter { it.isStarred }.map { it.cardId }.toSet()
                        allCards = repo.getAllCards()
                        targetCards = allCards.filter { starredIds.contains(it.id) }
                    } else if (screen.customDeckIds != null) {
                        allCards = repo.getAllCards()
                        targetCards = allCards.filter { screen.customDeckIds.contains(it.deckId) }
                    } else if (!screen.customDeckPaths.isNullOrEmpty() || !screen.customTags.isNullOrEmpty()) {
                        allCards = repo.getAllCards()
                        val gson = com.google.gson.Gson()
                        val tagType = object : com.google.gson.reflect.TypeToken<List<String>>() {}.type
                        targetCards = allCards.filter { card ->
                            val pathMatch = if (screen.customDeckPaths.isNullOrEmpty()) true else {
                                screen.customDeckPaths.any { path ->
                                    card.deckHierarchy == path || card.deckHierarchy.startsWith("$path::")
                                }
                            }
                            val tagMatch = if (screen.customTags.isNullOrEmpty()) true else {
                                val cardTagsList: List<String> = try {
                                    gson.fromJson(card.tags, tagType) ?: emptyList()
                                } catch (e: Exception) { emptyList() }
                                cardTagsList.any { cTag -> screen.customTags.any { tTag -> cTag.equals(tTag, ignoreCase = true) } }
                            }
                            pathMatch && tagMatch
                        }
                    } else {
                        allCards = repo.getCardsForHierarchy(resolvedDeckName)
                        targetCards = allCards
                    }

                    // Exclude any attempted cards for non-revision mode
                    if (screen.mode != McqSessionMode.REVISION) {
                        val attemptedIds = when {
                            screen.isStarredOnly -> progressManager.getAllAttemptedCardIds().toSet()
                            screen.customDeckIds != null -> screen.customDeckIds.flatMap { progressManager.getAttemptedCardIds(it) }.toSet()
                            else -> progressManager.getAttemptedCardIds(screen.deck.id).toSet()
                        }
                        targetCards = targetCards.filter { !attemptedIds.contains(it.id) }
                    }

                    val allAliases = repo.getAllAliases()

                    // Select the final cards based on mode and settings
                    if (screen.mode == McqSessionMode.RATED_PRIORITY) {
                        val ratingMap = repo.getAllUserMetadataOnce().associate { it.cardId to it.rating }
                        val ratedCards = targetCards.filter { (ratingMap[it.id] ?: 0) >= 1 }
                        if (ratedCards.isNotEmpty()) {
                            val sampled = mutableListOf<CardEntity>()
                            val remaining = ratedCards.toMutableList()
                            val limit = if (questionLimit > 0) minOf(questionLimit, remaining.size) else remaining.size
                            val random = java.util.Random()
                            for (step in 0 until limit) {
                                val totalWeight = remaining.sumOf { ratingMap[it.id] ?: 1 }
                                if (totalWeight <= 0) break
                                val target = random.nextInt(totalWeight)
                                var currentSum = 0
                                var chosenIndex = -1
                                for (i in remaining.indices) {
                                    currentSum += ratingMap[remaining[i].id] ?: 1
                                    if (currentSum > target) {
                                        chosenIndex = i
                                        break
                                    }
                                }
                                if (chosenIndex != -1) {
                                    val card = remaining.removeAt(chosenIndex)
                                    sampled.add(card)
                                } else {
                                    break
                                }
                            }
                            targetCards = sampled.sortedByDescending { ratingMap[it.id] ?: 0 }
                        } else {
                            targetCards = emptyList()
                        }
                    } else if (screen.mode == McqSessionMode.REVISION) {
                        val maxForRevision = if (questionLimit > 0) questionLimit else Int.MAX_VALUE
                        targetCards = WeakCardSelector.selectWeakCards(
                            cards = targetCards,
                            cardAttempts = repo.getAllCardAttempts(),
                            maxCards = maxForRevision
                        )
                        if (shuffleQuestions) {
                            targetCards = targetCards.shuffled()
                        }
                    } else {
                        // Prioritize unattempted / least-attempted questions
                        val shuffledPool = targetCards.shuffled()
                        
                        // Group card attempts to get attempt count per card
                        val attemptsCountMap = repo.getAllCardAttempts().groupBy { it.cardId }.mapValues { it.value.size }
                        
                        // Sort pool stably by attempt count (least attempted first)
                        val prioritizedPool = shuffledPool.sortedBy { attemptsCountMap[it.id] ?: 0 }
                        
                        // Take the requested count limit
                        val selectedCards = if (questionLimit > 0) prioritizedPool.take(questionLimit) else prioritizedPool
                        
                        // Shuffle the selected questions again so they appear in a random order in the session
                        targetCards = selectedCards.shuffled()
                    }

                    // Generate MCQs ONLY for the selected cards
                    val engine = McqEngine(optionsCount = numberOfOptions)
                    engine.generate(
                        allCards = allCards,
                        targetCards = targetCards,
                        aliases = allAliases
                    )
                }
                if (showCapacityAlert) {
                    mcqsState = emptyList()
                } else {
                    mcqsState = questions
                }
            }

            // adSessionKey: unique timestamp when this quiz session was created.
            // This ensures RealAdmobInterstitialAd's LaunchedEffect re-fires every
            // new quiz — even if the same InterstitialAd object is reused.
            val adSessionKey = remember(screen.deck, screen.mode, screen.sessionKey) { System.currentTimeMillis() }
            // adIndex rotates through mock ads so the fallback never shows the same ad twice
            val adIndex = remember(screen.deck, screen.mode, screen.sessionKey) {
                (System.currentTimeMillis() / 1000).toInt()
            }

            if (mcqsState == null) {
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
                    if (showCapacityAlert) {
                        AlertDialog(
                            onDismissRequest = {
                                showCapacityAlert = false
                                currentScreen = Screen.DeckSelection
                            },
                            title = { Text("Practice Complete") },
                            text = { Text("You have successfully attempted all questions in this deck once! To continue practicing, please increase your maximum session question threshold or reset your deck progress.") },
                            confirmButton = {
                                TextButton(onClick = {
                                    coroutineScope.launch {
                                        val progressManager = com.example.flashcardapp.data.PersistentProgressManager(context)
                                        progressManager.clearProgress(screen.deck.id)
                                        showCapacityAlert = false
                                        currentScreen = Screen.Quiz(
                                            deck = screen.deck,
                                            mode = screen.mode,
                                            customDeckIds = screen.customDeckIds,
                                            isStarredOnly = screen.isStarredOnly,
                                            sessionKey = System.currentTimeMillis()
                                        )
                                    }
                                }) {
                                    Text("Reset Progress")
                                }
                            },
                            dismissButton = {
                                TextButton(onClick = {
                                    showCapacityAlert = false
                                    currentScreen = Screen.DeckSelection
                                }) {
                                    Text("Cancel")
                                }
                            },
                            shape = RoundedCornerShape(16.dp),
                            containerColor = MaterialTheme.colorScheme.surface
                        )
                    } else {
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
                        isDarkMode = isDarkMode,
                        onDarkModeToggle = onDarkModeToggle,
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
        is Screen.MockExam -> {
            var mockQuestionsState by remember(screen.deck, screen.preset) {
                mutableStateOf<List<Mcq>?>(null)
            }
            BackHandler {
                currentScreen = Screen.DeckSelection
            }

            LaunchedEffect(screen.deck, screen.preset) {
                val questions = kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.Default) {
                    val resolvedDeckName = if (screen.deck.id > 0) {
                        repo.getDeckById(screen.deck.id)?.fullPath ?: screen.deck.name
                    } else {
                        screen.deck.name
                    }
                    val allCards = repo.getAllCards()
                    val targetCards = if (screen.deck.id == 999999L || screen.deck.id < 0) {
                        allCards
                    } else {
                        repo.getCardsForHierarchy(resolvedDeckName)
                    }
                    val allAliases = repo.getAllAliases()
                    val engine = McqEngine(optionsCount = 4)
                    engine.generate(
                        allCards = allCards,
                        targetCards = targetCards.shuffled(),
                        aliases = allAliases
                    )
                }
                mockQuestionsState = questions
            }

            if (mockQuestionsState == null) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else {
                com.example.flashcardapp.ui.MockExamScreen(
                    deckName = screen.deck.name,
                    questions = mockQuestionsState!!,
                    preset = screen.preset,
                    onFinish = { scorecard ->
                        currentScreen = Screen.DeckSelection
                    },
                    onBackPressed = {
                        currentScreen = Screen.DeckSelection
                    }
                )
            }
        }
    }
}

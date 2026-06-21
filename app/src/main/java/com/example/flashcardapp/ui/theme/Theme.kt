package com.example.flashcardapp.ui.theme

import android.os.Build
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.R

// Atkinson Hyperlegible Next Font Family
val AtkinsonHyperlegible = FontFamily(
    Font(R.font.atkinson_hyperlegible_regular, FontWeight.Normal),
    Font(R.font.atkinson_hyperlegible_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.atkinson_hyperlegible_bold, FontWeight.Bold),
    Font(R.font.atkinson_hyperlegible_bold_italic, FontWeight.Bold, FontStyle.Italic)
)

// ═══════════════════════════════════════════════════════════════
//  ANKIPREP DESIGN SYSTEM — v2.0
//  Light Palette: Claymorphism + Soft Purple (ui_rules.md §1)
//  Dark Palette:  Cyber / Deep Space (ui_rules.md §1 dark variant)
// ═══════════════════════════════════════════════════════════════

// ── Global mutable surface tokens (hot-swapped per theme) ───────
var PrimaryPurple      by mutableStateOf(Color(0xFF4B308C))
var LightPurple        by mutableStateOf(Color(0xFFE6E0F8))
var BackgroundLavender by mutableStateOf(Color(0xFFF7F2F9))
var CardBackgroundLight by mutableStateOf(Color(0xFFFFFFFF))
var TextPrimaryDeep    by mutableStateOf(Color(0xFF1E1035))
var TextSecondaryGray  by mutableStateOf(Color(0xFF7A6F8B))

// ── Semantic accent tokens (stable across themes) ───────────────
val LightPurpleAccent  = Color(0xFFEBE3FA)
val LightPinkAccent    = Color(0xFFFFE9F0)
val LightCyanAccent    = Color(0xFFE1F5FE)
val PrimarySage        = Color(0xFF4CAF50)
val PrimaryContainerMint = Color(0xFFE8F5E9)
val neonBorderPrimary  = BorderStroke(1.dp, PrimaryPurple.copy(alpha = 0.5f))
val neonBorderSecondary= BorderStroke(1.dp, PrimarySage.copy(alpha = 0.5f))

// Quiz feedback tokens
val CorrectColor   = Color(0xFF2E7D32)
val IncorrectColor = Color(0xFFC62828)
val CorrectBg      = Color(0xFFE8F5E9)
val IncorrectBg    = Color(0xFFFFEBEE)

// ── M3 Surface container tokens ─────────────────────────────────
val SurfaceContainerHigh    = Color(0xFFF3EDF7)
val SurfaceContainerHighest = Color(0xFFEDE7F6)
val ErrorContainer          = Color(0xFFFFEBEE)
val TertiaryContainer       = Color(0xFFFFD6FF)

// ── M3 Shape system (Apple-inspired soft rounded) ───────────────
val AnkiShapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),
    small      = RoundedCornerShape(8.dp),
    medium     = RoundedCornerShape(12.dp),
    large      = RoundedCornerShape(16.dp),
    extraLarge = RoundedCornerShape(24.dp)
)

// ── M3 Typography scale ─────────────────────────────────────────
fun buildTypography(fontFamily: FontFamily): Typography = Typography(
    displayLarge  = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Bold,     fontSize = 45.sp, lineHeight = 52.sp, letterSpacing = (-0.9).sp),
    displayMedium = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Bold,     fontSize = 36.sp, lineHeight = 44.sp),
    displaySmall  = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Bold,     fontSize = 28.sp, lineHeight = 36.sp),
    headlineLarge  = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.SemiBold, fontSize = 32.sp, lineHeight = 40.sp),
    headlineMedium = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.SemiBold, fontSize = 28.sp, lineHeight = 36.sp),
    headlineSmall  = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.SemiBold, fontSize = 24.sp, lineHeight = 32.sp),
    titleLarge   = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Medium,   fontSize = 22.sp, lineHeight = 28.sp),
    titleMedium  = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Medium,   fontSize = 16.sp, lineHeight = 24.sp, letterSpacing = 0.15.sp),
    titleSmall   = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Medium,   fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.1.sp),
    bodyLarge    = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Normal,   fontSize = 18.sp, lineHeight = 32.sp, letterSpacing = 0.18.sp),
    bodyMedium   = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Normal,   fontSize = 16.sp, lineHeight = 28.sp),
    bodySmall    = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Normal,   fontSize = 12.sp, lineHeight = 16.sp, letterSpacing = 0.4.sp),
    labelLarge   = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.SemiBold, fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 1.4.sp),
    labelMedium  = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Medium,   fontSize = 12.sp, lineHeight = 16.sp, letterSpacing = 0.5.sp),
    labelSmall   = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Medium,   fontSize = 11.sp, lineHeight = 16.sp, letterSpacing = 0.5.sp)
)

// ════════════════════════════════════════════════════════════════
//  LIGHT SCHEMES
// ════════════════════════════════════════════════════════════════

private fun lavenderScheme() = lightColorScheme(
    primary             = Color(0xFF1E00A9),
    onPrimary           = Color(0xFFFFFFFF),
    primaryContainer    = Color(0xFF3525CD),
    onPrimaryContainer  = Color(0xFFB1AFFF),
    secondary           = Color(0xFF712AE2),
    onSecondary         = Color(0xFFFFFFFF),
    secondaryContainer  = Color(0xFF8B4BFC),
    onSecondaryContainer= Color(0xFFFFFBFB),
    tertiary            = Color(0xFF2E3336),
    onTertiary          = Color(0xFFFFFFFF),
    tertiaryContainer   = Color(0xFF44494D),
    onTertiaryContainer = Color(0xFFB3B8BD),
    background          = Color(0xFFF9F9FF),
    onBackground        = Color(0xFF111C2D),
    surface             = Color(0xFFF9F9FF),
    onSurface           = Color(0xFF111C2D),
    surfaceVariant      = Color(0xFFD8E3FB),
    onSurfaceVariant    = Color(0xFF464555),
    outline             = Color(0xFF777587),
    outlineVariant      = Color(0xFFC7C4D8),
    error               = Color(0xFFBA1A1A),
    onError             = Color(0xFFFFFFFF),
    errorContainer      = Color(0xFFFFDAD6),
    onErrorContainer    = Color(0xFF93000A)
)

private fun emeraldScheme() = lightColorScheme(
    primary             = Color(0xFF1B6B3A),
    onPrimary           = Color.White,
    primaryContainer    = Color(0xFFB7F1C8),
    onPrimaryContainer  = Color(0xFF002110),
    secondary           = Color(0xFF4F6354),
    onSecondary         = Color.White,
    secondaryContainer  = Color(0xFFD2E8D4),
    onSecondaryContainer = Color(0xFF0C1F13),
    tertiary            = Color(0xFF3C5F78),
    onTertiary          = Color.White,
    tertiaryContainer   = Color(0xFFC0E4FF),
    onTertiaryContainer = Color(0xFF001E31),
    background          = Color(0xFFF1F8F5),
    onBackground        = Color(0xFF1A1C1A),
    surface             = Color(0xFFFFFFFF),
    onSurface           = Color(0xFF1A1C1A),
    surfaceVariant      = Color(0xFFDCE5DA),
    onSurfaceVariant    = Color(0xFF414941),
    outline             = Color(0xFF717971),
    error               = Color(0xFFC62828),
    onError             = Color.White,
    errorContainer      = Color(0xFFFFEBEE),
    onErrorContainer    = Color(0xFF410E0B)
)

private fun oceanScheme() = lightColorScheme(
    primary             = Color(0xFF1565C0),
    onPrimary           = Color.White,
    primaryContainer    = Color(0xFFD6E4FF),
    onPrimaryContainer  = Color(0xFF001A41),
    secondary           = Color(0xFF1976D2),
    onSecondary         = Color.White,
    secondaryContainer  = Color(0xFFCFE2FF),
    onSecondaryContainer = Color(0xFF001B3E),
    tertiary            = Color(0xFF006876),
    onTertiary          = Color.White,
    tertiaryContainer   = Color(0xFF9EEFFF),
    onTertiaryContainer = Color(0xFF001F25),
    background          = Color(0xFFF0F4F8),
    onBackground        = Color(0xFF001B3E),
    surface             = Color(0xFFFFFFFF),
    onSurface           = Color(0xFF001B3E),
    surfaceVariant      = Color(0xFFDFE2EB),
    onSurfaceVariant    = Color(0xFF42474E),
    outline             = Color(0xFF72777F),
    error               = Color(0xFFC62828),
    onError             = Color.White,
    errorContainer      = Color(0xFFFFEBEE),
    onErrorContainer    = Color(0xFF410E0B)
)

private fun sunsetScheme() = lightColorScheme(
    primary             = Color(0xFFBF360C),
    onPrimary           = Color.White,
    primaryContainer    = Color(0xFFFFDBCF),
    onPrimaryContainer  = Color(0xFF3D0800),
    secondary           = Color(0xFF77574B),
    onSecondary         = Color.White,
    secondaryContainer  = Color(0xFFFFDBCF),
    onSecondaryContainer = Color(0xFF2C160C),
    tertiary            = Color(0xFF695E2E),
    onTertiary          = Color.White,
    tertiaryContainer   = Color(0xFFF1E2A8),
    onTertiaryContainer = Color(0xFF221B00),
    background          = Color(0xFFFAF2F0),
    onBackground        = Color(0xFF221918),
    surface             = Color(0xFFFFFFFF),
    onSurface           = Color(0xFF221918),
    surfaceVariant      = Color(0xFFF5DDD6),
    onSurfaceVariant    = Color(0xFF53433E),
    outline             = Color(0xFF85736D),
    error               = Color(0xFFC62828),
    onError             = Color.White,
    errorContainer      = Color(0xFFFFEBEE),
    onErrorContainer    = Color(0xFF410E0B)
)

// ════════════════════════════════════════════════════════════════
//  DARK SCHEMES  (Deep Space Cyber — ui_rules.md)
//  Primary Bg:   #0A0E1A  Surface:   #121829
//  Accent Cyan:  #00E5FF  Accent Purple: #9D4EDD
//  Danger:       #FF2E93  Text Primary: #F8F9FA
//  Text Muted:   #A0AEC0
// ════════════════════════════════════════════════════════════════

private fun cyberDarkScheme() = darkColorScheme(
    primary             = Color(0xFFC3C0FF),      // Inverse Primary
    onPrimary           = Color(0xFF1E00A9),
    primaryContainer    = Color(0xFF3525CD),
    onPrimaryContainer  = Color(0xFFE2DFFF),
    secondary           = Color(0xFFD2BBFF),
    onSecondary         = Color(0xFF25005A),
    secondaryContainer  = Color(0xFF5A00C6),
    onSecondaryContainer= Color(0xFFEADDFF),
    tertiary            = Color(0xFFC2C7CC),
    onTertiary          = Color(0xFF171C20),
    tertiaryContainer   = Color(0xFF2E3336),
    onTertiaryContainer = Color(0xFFDFE3E8),
    background          = Color(0xFF111C2D),      // Dark Background
    onBackground        = Color(0xFFF9F9FF),
    surface             = Color(0xFF263143),      // Inverse Surface
    onSurface           = Color(0xFFECF1FF),
    surfaceVariant      = Color(0xFF464555),
    onSurfaceVariant    = Color(0xFFD8E3FB),
    outline             = Color(0xFFC7C4D8),
    outlineVariant      = Color(0xFF777587),
    error               = Color(0xFFFFB4AB),
    onError             = Color(0xFF690005),
    errorContainer      = Color(0xFF93000A),
    onErrorContainer    = Color(0xFFFFDAD6),
    scrim               = Color(0xFF000000)
)

private fun cyberLavenderDarkScheme() = darkColorScheme(
    primary             = Color(0xFFCEBDFF),      // Soft Purple / Tertiary as Primary for lavender preset
    onPrimary           = Color(0xFF381385),
    primaryContainer    = Color(0xFFB39AFF),
    onPrimaryContainer  = Color(0xFF462793),
    secondary           = Color(0xFF81D4D4),      // Muted Teal / Secondary
    onSecondary         = Color(0xFF003737),
    secondaryContainer  = Color(0xFF006F6F),
    onSecondaryContainer = Color(0xFF9AEFEE),
    tertiary            = Color(0xFFACC7FB),      // Soft Indigo / Primary
    onTertiary          = Color(0xFF10305B),
    tertiaryContainer   = Color(0xFF8FAADC),
    onTertiaryContainer = Color(0xFF213E69),
    background          = Color(0xFF0F1113),      // Obsidian Base (Level 0)
    onBackground        = Color(0xFFE2E2E5),
    surface             = Color(0xFF1A1C1E),      // Surface Charcoal (Level 1)
    onSurface           = Color(0xFFE2E2E5),
    surfaceVariant      = Color(0xFF282A2D),      // Surface Elevated (Level 2)
    onSurfaceVariant    = Color(0xFFC4C6D0),
    outline             = Color(0xFF35373A),      // Stroke Color
    outlineVariant      = Color(0xFF43474F),
    error               = Color(0xFFFFB4AB),
    onError             = Color(0xFF690005),
    errorContainer      = Color(0xFF93000A),
    onErrorContainer    = Color(0xFFFFDAD6),
    scrim               = Color(0xFF000000)
)

private fun cyberEmeraldDarkScheme() = darkColorScheme(
    primary             = Color(0xFF80D49C),      // Soft Green
    onPrimary           = Color(0xFF00391A),
    primaryContainer    = Color(0xFF005224),
    onPrimaryContainer  = Color(0xFFB7F1C8),
    secondary           = Color(0xFFA6D0B4),      // Muted Green
    onSecondary         = Color(0xFF133621),
    secondaryContainer  = Color(0xFF2A4D36),
    onSecondaryContainer= Color(0xFFC2ECDF),
    tertiary            = Color(0xFF88D2D2),      // Teal accent
    onTertiary          = Color(0xFF003737),
    tertiaryContainer   = Color(0xFF004F4F),
    onTertiaryContainer = Color(0xFFA4EFEF),
    background          = Color(0xFF0F1411),      // Very dark green/gray
    onBackground        = Color(0xFFE2E3E2),
    surface             = Color(0xFF181C1A),      // Surface
    onSurface           = Color(0xFFE2E3E2),
    surfaceVariant      = Color(0xFF3B4A40),      // Surface Elevated
    onSurfaceVariant    = Color(0xFFC1C9C1),
    outline             = Color(0xFF717971),      // Stroke Color
    outlineVariant      = Color(0xFF414941),
    error               = Color(0xFFFFB4AB),
    onError             = Color(0xFF690005),
    errorContainer      = Color(0xFF93000A),
    onErrorContainer    = Color(0xFFFFDAD6),
    scrim               = Color(0xFF000000)
)

// ════════════════════════════════════════════════════════════════
//  AnkiQuizTheme — Master Theme Compositor
// ════════════════════════════════════════════════════════════════

@Composable
fun AnkiQuizTheme(
    themePreset: String = "EMERALD",
    isDarkMode: Boolean = false,
    useDynamicWallpaper: Boolean = false,
    fontFamilyType: String = "DEFAULT",
    content: @Composable () -> Unit
) {
    val context = LocalContext.current

    val colorScheme = when {
        // Dynamic Material You (Android 12+) — respects system dark/light
        useDynamicWallpaper && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S ->
            if (isDarkMode) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)

        // Dark mode: choose cyber variant based on preset
        isDarkMode -> when (themePreset) {
            "LAVENDER" -> cyberLavenderDarkScheme()
            "EMERALD"  -> cyberEmeraldDarkScheme()
            else       -> cyberDarkScheme()
        }

        // Light mode: original palette presets
        else -> when (themePreset) {
            "EMERALD" -> emeraldScheme()
            "OCEAN"   -> oceanScheme()
            "SUNSET"  -> sunsetScheme()
            else      -> lavenderScheme()
        }
    }

    // Hot-swap global surface vars (zero-frame-flicker pattern)
    PrimaryPurple       = colorScheme.primary
    LightPurple         = colorScheme.secondaryContainer
    BackgroundLavender  = colorScheme.background
    CardBackgroundLight = colorScheme.surface
    TextPrimaryDeep     = colorScheme.onBackground
    TextSecondaryGray   = colorScheme.onSurfaceVariant

    val customFontPath = remember(fontFamilyType) {
        val path = com.example.flashcardapp.data.SettingsRepository.getInstance(context).customFontPath
        if (!path.isNullOrEmpty() && java.io.File(path).exists()) path else null
    }

    val fontFamily = if (customFontPath != null) {
        try {
            FontFamily(Font(java.io.File(customFontPath)))
        } catch (e: Exception) {
            e.printStackTrace()
            when (fontFamilyType) {
                "SERIF"      -> FontFamily.Serif
                "SAN_SERIF"  -> FontFamily.SansSerif
                "MONOSPACE"  -> FontFamily.Monospace
                else         -> FontFamily.Default
            }
        }
    } else {
        when (fontFamilyType) {
            "SERIF"      -> FontFamily.Serif
            "SAN_SERIF"  -> FontFamily.SansSerif
            "MONOSPACE"  -> FontFamily.Monospace
            else         -> FontFamily.Default
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography  = buildTypography(fontFamily),
        shapes      = AnkiShapes,
        content     = content
    )
}


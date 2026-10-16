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
var BackgroundLavender by mutableStateOf(Color(0xFFEDE8F5))
var CardBackgroundLight by mutableStateOf(Color(0xFFEDE8F5))
var TextPrimaryDeep    by mutableStateOf(Color(0xFF1E1035))
var TextSecondaryGray  by mutableStateOf(Color(0xFF675B7D))
var NeumorphicHighlight by mutableStateOf(Color(0xFFFFFFFF))
var NeumorphicShadow   by mutableStateOf(Color(0x244B308C))

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
val SurfaceContainerHigh    = Color(0xFFE2DCEF)
val SurfaceContainerHighest = Color(0xFFDDD6EC)
val ErrorContainer          = Color(0xFFFFEBEE)
val TertiaryContainer       = Color(0xFFFFD6FF)

// ── M3 Shape system (Apple-inspired soft rounded) ───────────────
val AnkiShapes = Shapes(
    extraSmall = RoundedCornerShape(6.dp),
    small      = RoundedCornerShape(10.dp),
    medium     = RoundedCornerShape(16.dp),
    large      = RoundedCornerShape(20.dp),
    extraLarge = RoundedCornerShape(26.dp)
)

// ── M3 Typography scale ─────────────────────────────────────────
fun buildTypography(fontFamily: FontFamily, fontScaleFactor: Float = 1.0f): Typography {
    val scale = fontScaleFactor.coerceIn(0.75f, 1.5f)
    return Typography(
        displayLarge  = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Bold,     fontSize = (45 * scale).sp, lineHeight = (52 * scale).sp, letterSpacing = (-0.9).sp),
        displayMedium = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Bold,     fontSize = (36 * scale).sp, lineHeight = (44 * scale).sp),
        displaySmall  = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Bold,     fontSize = (28 * scale).sp, lineHeight = (36 * scale).sp),
        headlineLarge  = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.SemiBold, fontSize = (32 * scale).sp, lineHeight = (40 * scale).sp),
        headlineMedium = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.SemiBold, fontSize = (28 * scale).sp, lineHeight = (36 * scale).sp),
        headlineSmall  = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.SemiBold, fontSize = (24 * scale).sp, lineHeight = (32 * scale).sp),
        titleLarge   = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Medium,   fontSize = (22 * scale).sp, lineHeight = (28 * scale).sp),
        titleMedium  = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Medium,   fontSize = (16 * scale).sp, lineHeight = (24 * scale).sp, letterSpacing = 0.15.sp),
        titleSmall   = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Medium,   fontSize = (14 * scale).sp, lineHeight = (20 * scale).sp, letterSpacing = 0.1.sp),
        bodyLarge    = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Normal,   fontSize = (18 * scale).sp, lineHeight = (32 * scale).sp, letterSpacing = 0.18.sp),
        bodyMedium   = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Normal,   fontSize = (16 * scale).sp, lineHeight = (28 * scale).sp),
        bodySmall    = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Normal,   fontSize = (12 * scale).sp, lineHeight = (16 * scale).sp, letterSpacing = 0.4.sp),
        labelLarge   = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.SemiBold, fontSize = (14 * scale).sp, lineHeight = (20 * scale).sp, letterSpacing = 1.4.sp),
        labelMedium  = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Medium,   fontSize = (12 * scale).sp, lineHeight = (16 * scale).sp, letterSpacing = 0.5.sp),
        labelSmall   = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Medium,   fontSize = (11 * scale).sp, lineHeight = (16 * scale).sp, letterSpacing = 0.5.sp)
    )
}

// ════════════════════════════════════════════════════════════════
//  LIGHT SCHEMES (Calibrated Neumorphic Soft Surfaces)
// ════════════════════════════════════════════════════════════════

private fun lavenderScheme() = lightColorScheme(
    primary             = Color(0xFF4B308C),      // Preserved Signature Deep Purple
    onPrimary           = Color(0xFFFFFFFF),
    primaryContainer    = Color(0xFFDCD2F5),
    onPrimaryContainer  = Color(0xFF1E1035),
    secondary           = Color(0xFF6C5CE7),
    onSecondary         = Color(0xFFFFFFFF),
    secondaryContainer  = Color(0xFFE2D9F8),
    onSecondaryContainer= Color(0xFF231849),
    tertiary            = Color(0xFF4CAF50),      // Mint Accent
    onTertiary          = Color(0xFFFFFFFF),
    tertiaryContainer   = Color(0xFFE0F2E9),
    onTertiaryContainer = Color(0xFF1B5E20),
    background          = Color(0xFFEDE8F5),      // Neumorphic Soft Lavender Base
    onBackground        = Color(0xFF1E1035),
    surface             = Color(0xFFEDE8F5),      // Seamless Extrusion Canvas
    onSurface           = Color(0xFF1E1035),
    surfaceVariant      = Color(0xFFE2DCEF),
    onSurfaceVariant    = Color(0xFF5A4E70),
    outline             = Color(0xFFC7BED8),
    outlineVariant      = Color(0xFFDED7ED),
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
    background          = Color(0xFFE7EFEA),      // Neumorphic Soft Emerald
    onBackground        = Color(0xFF1A1C1A),
    surface             = Color(0xFFE7EFEA),
    onSurface           = Color(0xFF1A1C1A),
    surfaceVariant      = Color(0xFFDBE6DF),
    onSurfaceVariant    = Color(0xFF414941),
    outline             = Color(0xFFBDCBC2),
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

private fun oledDarkScheme() = darkColorScheme(
    primary             = Color(0xFF00E5FF),      // Cyber Cyan
    onPrimary           = Color(0xFF000000),
    primaryContainer    = Color(0xFF004D5A),
    onPrimaryContainer  = Color(0xFFB4F8FF),
    secondary           = Color(0xFF9D4EDD),      // Vibrant Purple
    onSecondary         = Color(0xFF000000),
    secondaryContainer  = Color(0xFF4A1273),
    onSecondaryContainer= Color(0xFFF3E8FF),
    tertiary            = Color(0xFF4ADE80),      // Mint Green
    onTertiary          = Color(0xFF000000),
    tertiaryContainer   = Color(0xFF064E3B),
    onTertiaryContainer = Color(0xFFDCFCE7),
    background          = Color(0xFF000000),      // True OLED Pitch Black
    onBackground        = Color(0xFFFFFFFF),
    surface             = Color(0xFF0B0E14),      // Obsidian Base Surface
    onSurface           = Color(0xFFFFFFFF),
    surfaceVariant      = Color(0xFF161B26),      // Elevated Card Surface
    onSurfaceVariant    = Color(0xFFCBD5E1),      // Crisp Slate Text
    outline             = Color(0xFF334155),      // Crisp Divider Stroke
    outlineVariant      = Color(0xFF1E293B),
    error               = Color(0xFFFF5252),
    onError             = Color(0xFF000000),
    errorContainer      = Color(0xFF7F1D1D),
    onErrorContainer    = Color(0xFFFEE2E2),
    scrim               = Color(0xFF000000)
)

// ════════════════════════════════════════════════════════════════
//  MORPHISM SCHEMES (Glassmorphism, Claymorphism, Skeuomorphism)
// ════════════════════════════════════════════════════════════════

private fun neumorphicDarkScheme() = darkColorScheme(
    primary             = Color(0xFFA78BFA),      // Electric Iris
    onPrimary           = Color(0xFF1E1035),
    primaryContainer    = Color(0xFF3B2D54),
    onPrimaryContainer  = Color(0xFFEADDFF),
    secondary           = Color(0xFF93C5FD),
    onSecondary         = Color(0xFF0F172A),
    secondaryContainer  = Color(0xFF1E293B),
    onSecondaryContainer= Color(0xFFDBEAFE),
    tertiary            = Color(0xFF34D399),
    onTertiary          = Color(0xFF064E3B),
    tertiaryContainer   = Color(0xFF065F46),
    onTertiaryContainer = Color(0xFFA7F3D0),
    background          = Color(0xFF141419),      // Matte Charcoal Obsidian
    onBackground        = Color(0xFFF1F1F4),
    surface             = Color(0xFF1C1C24),      // Extruded Neumorphic Dark Surface
    onSurface           = Color(0xFFF1F1F4),
    surfaceVariant      = Color(0xFF282834),
    onSurfaceVariant    = Color(0xFFB0B0C0),
    outline             = Color(0xFF323242),
    outlineVariant      = Color(0xFF20202A),
    error               = Color(0xFFFFB4AB),
    onError             = Color(0xFF690005)
)

private fun neumorphicGraphiteScheme() = lightColorScheme(
    primary             = Color(0xFF4338CA),
    onPrimary           = Color.White,
    primaryContainer    = Color(0xFFE0E7FF),
    onPrimaryContainer  = Color(0xFF1E1B4B),
    secondary           = Color(0xFF475569),
    onSecondary         = Color.White,
    secondaryContainer  = Color(0xFFE2E8F0),
    onSecondaryContainer= Color(0xFF0F172A),
    tertiary            = Color(0xFF0D9488),
    background          = Color(0xFFE4E6EA),      // Soft Silver Graphite Canvas
    onBackground        = Color(0xFF1E293B),
    surface             = Color(0xFFE4E6EA),      // Extruded Graphite Canvas
    onSurface           = Color(0xFF1E293B),
    surfaceVariant      = Color(0xFFD6D9E0),
    onSurfaceVariant    = Color(0xFF475569),
    outline             = Color(0xFFBCC1CD),
    error               = Color(0xFFBA1A1A),
    onError             = Color.White
)

private fun oceanDarkScheme() = darkColorScheme(
    primary             = Color(0xFF7DD3FC),      // Sky Ice Cyan
    onPrimary           = Color(0xFF00354E),
    primaryContainer    = Color(0xFF004D6F),
    onPrimaryContainer  = Color(0xFFBAE6FD),
    secondary           = Color(0xFF38BDF8),
    onSecondary         = Color(0xFF0C4A6E),
    secondaryContainer  = Color(0xFF075985),
    onSecondaryContainer= Color(0xFFE0F2FE),
    tertiary            = Color(0xFF2DD4BF),
    background          = Color(0xFF0B141E),      // Marine Abyss Base
    onBackground        = Color(0xFFF0F9FF),
    surface             = Color(0xFF132030),      // Extruded Ocean Surface
    onSurface           = Color(0xFFF0F9FF),
    surfaceVariant      = Color(0xFF1E324A),
    onSurfaceVariant    = Color(0xFF94A3B8),
    outline             = Color(0xFF274363),
    error               = Color(0xFFFFB4AB),
    onError             = Color(0xFF690005)
)

private fun glassFrostScheme() = lightColorScheme(
    primary             = Color(0xFF2563EB),      // Vivid Royal Blue
    onPrimary           = Color.White,
    primaryContainer    = Color(0xFFDBEAFE),
    onPrimaryContainer  = Color(0xFF1E3A8A),
    secondary           = Color(0xFF06B6D4),      // Frosted Cyan
    onSecondary         = Color.White,
    secondaryContainer  = Color(0xFFCFFAFE),
    onSecondaryContainer= Color(0xFF164E63),
    tertiary            = Color(0xFF3B82F6),
    background          = Color(0xFFEEF4FB),      // Frosted Ice Canvas
    onBackground        = Color(0xFF0F172A),
    surface             = Color(0xFFF7FAFD),      // Crystalline Translucent Surface
    onSurface           = Color(0xFF0F172A),
    surfaceVariant      = Color(0xFFE0EDFB),
    onSurfaceVariant    = Color(0xFF334155),
    outline             = Color(0xFFBAE6FD),      // Crystal Specular Stroke
    error               = Color(0xFFBA1A1A),
    onError             = Color.White
)

private fun glassFrostDarkScheme() = darkColorScheme(
    primary             = Color(0xFF60A5FA),      // Electric Ice Blue
    onPrimary           = Color(0xFF00224D),
    primaryContainer    = Color(0xFF1D4ED8),
    onPrimaryContainer  = Color(0xFFDBEAFE),
    secondary           = Color(0xFF22D3EE),
    onSecondary         = Color(0xFF00363D),
    secondaryContainer  = Color(0xFF0E7490),
    onSecondaryContainer= Color(0xFFCFFAFE),
    tertiary            = Color(0xFF38BDF8),
    background          = Color(0xFF0B132B),      // Smoked Midnight Glass Void
    onBackground        = Color(0xFFF1F5F9),
    surface             = Color(0xFF131D38),      // Smoked Crystal Card
    onSurface           = Color(0xFFF1F5F9),
    surfaceVariant      = Color(0xFF1C2A4F),
    onSurfaceVariant    = Color(0xFF94A3B8),
    outline             = Color(0xFF2E4575),      // Frosted Specular Edge
    error               = Color(0xFFFFB4AB),
    onError             = Color(0xFF690005)
)

private fun glassCyberScheme() = darkColorScheme(
    primary             = Color(0xFF00F0FF),      // Cyber Neon Cyan
    onPrimary           = Color(0xFF001B22),
    primaryContainer    = Color(0xFF004D5A),
    onPrimaryContainer  = Color(0xFF70F8FF),
    secondary           = Color(0xFFFF007F),      // Cyber Neon Pink
    onSecondary         = Color(0xFF3A0019),
    secondaryContainer  = Color(0xFF700035),
    onSecondaryContainer= Color(0xFFFFD9E4),
    tertiary            = Color(0xFFA855F7),      // Violet Glow
    background          = Color(0xFF090D16),      // Smoked Obsidian Glass Void
    onBackground        = Color(0xFFF8FAFC),
    surface             = Color(0xFF111726),      // Translucent Smoked Glass Card
    onSurface           = Color(0xFFF8FAFC),
    surfaceVariant      = Color(0xFF1D263B),
    onSurfaceVariant    = Color(0xFF94A3B8),
    outline             = Color(0xFF00E5FF),      // Glowing Cyan Rim
    error               = Color(0xFFFF5252),
    onError             = Color(0xFF000000)
)

private fun glassCyberLightScheme() = lightColorScheme(
    primary             = Color(0xFF0891B2),
    onPrimary           = Color.White,
    primaryContainer    = Color(0xFFCCFBF1),
    onPrimaryContainer  = Color(0xFF115E59),
    secondary           = Color(0xFFD946EF),
    background          = Color(0xFFF0FDF4),
    onBackground        = Color(0xFF0F172A),
    surface             = Color(0xFFFFFFFF),
    onSurface           = Color(0xFF0F172A),
    surfaceVariant      = Color(0xFFE2E8F0),
    onSurfaceVariant    = Color(0xFF334155),
    outline             = Color(0xFF5EEAD4),
    error               = Color(0xFFBA1A1A),
    onError             = Color.White
)

private fun clayPastelScheme() = lightColorScheme(
    primary             = Color(0xFF7C3AED),      // Puffy Royal Violet
    onPrimary           = Color.White,
    primaryContainer    = Color(0xFFEDE9FE),
    onPrimaryContainer  = Color(0xFF3B0764),
    secondary           = Color(0xFFEC4899),      // Bubblegum Pastel Pink
    onSecondary         = Color.White,
    secondaryContainer  = Color(0xFFFCE7F3),
    onSecondaryContainer= Color(0xFF831843),
    tertiary            = Color(0xFF10B981),      // Soft Mint
    background          = Color(0xFFFAF2F8),      // Marshmallow Cotton Base
    onBackground        = Color(0xFF2E1065),
    surface             = Color(0xFFFFF7FC),      // Fluffy 3D Clay Surface
    onSurface           = Color(0xFF2E1065),
    surfaceVariant      = Color(0xFFF3E5F5),
    onSurfaceVariant    = Color(0xFF6B4E71),
    outline             = Color(0xFFE9D5FF),      // Gentle Clay Ridge
    error               = Color(0xFFE11D48),
    onError             = Color.White
)

private fun clayPastelDarkScheme() = darkColorScheme(
    primary             = Color(0xFFC084FC),
    onPrimary           = Color(0xFF38105E),
    primaryContainer    = Color(0xFF6B21A8),
    onPrimaryContainer  = Color(0xFFF3E8FF),
    secondary           = Color(0xFFF472B6),
    onSecondary         = Color(0xFF500724),
    secondaryContainer  = Color(0xFF831843),
    onSecondaryContainer= Color(0xFFFCE7F3),
    background          = Color(0xFF191022),      // Deep Plum Clay Void
    onBackground        = Color(0xFFFAF5FF),
    surface             = Color(0xFF251833),      // Fluffy Dark Clay Card
    onSurface           = Color(0xFFFAF5FF),
    surfaceVariant      = Color(0xFF362447),
    onSurfaceVariant    = Color(0xFFD8B4E2),
    outline             = Color(0xFF4A3166),
    error               = Color(0xFFFFB4AB),
    onError             = Color(0xFF690005)
)

private fun skeuomorphicScheme() = lightColorScheme(
    primary             = Color(0xFF92400E),      // Warm Antique Brass
    onPrimary           = Color.White,
    primaryContainer    = Color(0xFFFEF3C7),
    onPrimaryContainer  = Color(0xFF451A03),
    secondary           = Color(0xFF78350F),      // Walnut Accent
    onSecondary         = Color.White,
    secondaryContainer  = Color(0xFFFDE68A),
    onSecondaryContainer= Color(0xFF78350F),
    tertiary            = Color(0xFF4B5563),      // Heavy Slate
    background          = Color(0xFFEAE7E1),      // Heavy Tactile Paper / Warm Stone
    onBackground        = Color(0xFF1C1917),
    surface             = Color(0xFFF2EFE9),      // Embossed Slate Card
    onSurface           = Color(0xFF1C1917),
    surfaceVariant      = Color(0xFFE2DDD5),
    onSurfaceVariant    = Color(0xFF57534E),
    outline             = Color(0xFFB8B0A2),      // Physical Beveled Border
    error               = Color(0xFFB91C1C),
    onError             = Color.White
)

private fun skeuomorphicDarkScheme() = darkColorScheme(
    primary             = Color(0xFFF59E0B),      // Amber Glow
    onPrimary           = Color(0xFF451A03),
    primaryContainer    = Color(0xFF78350F),
    onPrimaryContainer  = Color(0xFFFEF3C7),
    secondary           = Color(0xFFD97706),
    background          = Color(0xFF191816),      // Aged Dark Charcoal
    onBackground        = Color(0xFFF5F5F4),
    surface             = Color(0xFF22201D),      // Tactile Dark Slate
    onSurface           = Color(0xFFF5F5F4),
    surfaceVariant      = Color(0xFF302C26),
    onSurfaceVariant    = Color(0xFFA8A29E),
    outline             = Color(0xFF44403C),      // Beveled Dark Stroke
    error               = Color(0xFFFFB4AB),
    onError             = Color(0xFF690005)
)

private fun sunsetDarkScheme() = darkColorScheme(
    primary             = Color(0xFFFF8A65),
    onPrimary           = Color(0xFF3E1206),
    primaryContainer    = Color(0xFF8A2E12),
    onPrimaryContainer  = Color(0xFFFFCCBC),
    secondary           = Color(0xFFFFAB91),
    background          = Color(0xFF18100E),
    onBackground        = Color(0xFFFBE9E7),
    surface             = Color(0xFF251815),
    onSurface           = Color(0xFFFBE9E7),
    surfaceVariant      = Color(0xFF3B2823),
    onSurfaceVariant    = Color(0xFFD7CCC8),
    outline             = Color(0xFF4A3029),
    error               = Color(0xFFFFB4AB),
    onError             = Color(0xFF690005)
)

// ════════════════════════════════════════════════════════════════
//  AnkiQuizTheme — Master Theme Compositor
// ════════════════════════════════════════════════════════════════

@Composable
fun AnkiQuizTheme(
    themePreset: String = "EMERALD",
    isDarkMode: Boolean = false,
    useOledBlack: Boolean = false,
    fontScaleFactor: Float = 1.0f,
    useDynamicWallpaper: Boolean = false,
    fontFamilyType: String = "DEFAULT",
    customPrimaryColor: Long = 0L,
    customAccentColor: Long = 0L,
    morphismElevationFactor: Float = 1.0f,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current

    val baseColorScheme = when {
        // Dynamic Material You (Android 12+) — respects system dark/light
        useDynamicWallpaper && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S ->
            if (isDarkMode) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)

        // OLED Pitch Black Mode override
        isDarkMode && useOledBlack -> oledDarkScheme()

        // Dark mode: comprehensive morphism schemes
        isDarkMode -> when (themePreset) {
            "LAVENDER", "NEUMORPHIC_LAVENDER" -> cyberLavenderDarkScheme()
            "NEUMORPHIC_DARK"                 -> neumorphicDarkScheme()
            "EMERALD", "NEUMORPHIC_EMERALD"   -> cyberEmeraldDarkScheme()
            "OCEAN", "NEUMORPHIC_OCEAN"       -> oceanDarkScheme()
            "GLASS_FROST"                     -> glassFrostDarkScheme()
            "GLASS_CYBER"                     -> glassCyberScheme()
            "CLAY_PASTEL"                     -> clayPastelDarkScheme()
            "SKEUOMORPHIC"                    -> skeuomorphicDarkScheme()
            "SUNSET"                          -> sunsetDarkScheme()
            else                              -> cyberLavenderDarkScheme()
        }

        // Light mode: comprehensive morphism schemes
        else -> when (themePreset) {
            "LAVENDER", "NEUMORPHIC_LAVENDER" -> lavenderScheme()
            "NEUMORPHIC_DARK"                 -> neumorphicGraphiteScheme()
            "EMERALD", "NEUMORPHIC_EMERALD"   -> emeraldScheme()
            "OCEAN", "NEUMORPHIC_OCEAN"       -> oceanScheme()
            "GLASS_FROST"                     -> glassFrostScheme()
            "GLASS_CYBER"                     -> glassCyberLightScheme()
            "CLAY_PASTEL"                     -> clayPastelScheme()
            "SKEUOMORPHIC"                    -> skeuomorphicScheme()
            "SUNSET"                          -> sunsetScheme()
            else                              -> lavenderScheme()
        }
    }

    // Apply custom color overrides if specified by the user
    val colorScheme = baseColorScheme.copy(
        primary = if (customPrimaryColor != 0L) Color(customPrimaryColor) else baseColorScheme.primary,
        secondary = if (customAccentColor != 0L) Color(customAccentColor) else baseColorScheme.secondary,
        primaryContainer = if (customPrimaryColor != 0L) Color(customPrimaryColor).copy(alpha = 0.15f) else baseColorScheme.primaryContainer
    )

    // Sync morphism elevation factor
    MorphismElevationFactor = morphismElevationFactor

    // Hot-swap global surface vars (zero-frame-flicker pattern)
    PrimaryPurple       = colorScheme.primary
    LightPurple         = colorScheme.secondaryContainer
    BackgroundLavender  = colorScheme.background
    CardBackgroundLight = colorScheme.surface
    TextPrimaryDeep     = colorScheme.onBackground
    TextSecondaryGray   = colorScheme.onSurfaceVariant

    // Configure Morphism-specific dual lighting & depth
    val (activeHighlight, activeShadow) = when (themePreset) {
        "GLASS_FROST" -> if (isDarkMode) {
            Pair(Color(0x5560A5FA), Color(0x66000000))
        } else {
            Pair(Color.White.copy(alpha = 0.98f), Color(0x222563EB))
        }
        "GLASS_CYBER" -> if (isDarkMode) {
            Pair(Color(0x8000E5FF), Color(0x88000000))
        } else {
            Pair(Color.White.copy(alpha = 0.95f), Color(0x280891B2))
        }
        "CLAY_PASTEL" -> if (isDarkMode) {
            Pair(Color(0x55C084FC), Color(0x661A0A2E))
        } else {
            Pair(Color.White.copy(alpha = 0.98f), Color(0x357C3AED))
        }
        "SKEUOMORPHIC" -> if (isDarkMode) {
            Pair(Color(0x40F59E0B), Color(0x80000000))
        } else {
            Pair(Color(0x90FFFDF2), Color(0x38000000))
        }
        "NEUMORPHIC_DARK" -> Pair(Color(0xFF323242).copy(alpha = 0.65f), Color(0xFF08080C).copy(alpha = 0.85f))
        "EMERALD", "NEUMORPHIC_EMERALD" -> if (isDarkMode) {
            Pair(Color(0xFF22382A).copy(alpha = 0.55f), Color(0xFF07140B).copy(alpha = 0.75f))
        } else {
            Pair(Color.White.copy(alpha = 0.95f), Color(0xFF1E3F28).copy(alpha = 0.14f))
        }
        "OCEAN", "NEUMORPHIC_OCEAN" -> if (isDarkMode) {
            Pair(Color(0xFF1C2E42).copy(alpha = 0.55f), Color(0xFF070F18).copy(alpha = 0.75f))
        } else {
            Pair(Color.White.copy(alpha = 0.95f), Color(0xFF183B55).copy(alpha = 0.14f))
        }
        "SUNSET" -> if (isDarkMode) {
            Pair(Color(0x44FF8A65), Color(0x77000000))
        } else {
            Pair(Color.White.copy(alpha = 0.95f), Color(0xFF5A1E0E).copy(alpha = 0.15f))
        }
        else -> if (isDarkMode) {
            Pair(Color(0xFF2E293E).copy(alpha = 0.55f), Color(0xFF0A0910).copy(alpha = 0.75f))
        } else {
            Pair(Color.White.copy(alpha = 0.95f), Color(0xFF3B2761).copy(alpha = 0.14f))
        }
    }
    NeumorphicHighlight = activeHighlight
    NeumorphicShadow    = activeShadow

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
        typography  = buildTypography(fontFamily, fontScaleFactor),
        shapes      = AnkiShapes,
        content     = content
    )
}


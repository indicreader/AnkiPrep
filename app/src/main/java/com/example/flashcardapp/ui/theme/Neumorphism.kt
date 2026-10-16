package com.example.flashcardapp.ui.theme

import android.graphics.BlurMaskFilter
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * ANKIPREP NEUMORPHISM (SOFT UI) DESIGN SYSTEM
 *
 * Characteristics:
 * - Tactile, extruded surfaces emerging seamlessly from canvas backgrounds.
 * - Dual-directional lighting: Top-Left Specular Highlight + Bottom-Right Ambient Soft Shadow.
 * - Inset/concave responsive feedback on press/active states.
 * - Preserves app's signature Lavender/Primary Purple and Preset Color Schemes.
 */

enum class MorphismCategory(val displayName: String, val badge: String, val description: String) {
    NEUMORPHISM("Neumorphism", "SOFT UI", "Soft tactile extruded surfaces with dual specular & ambient lighting"),
    GLASSMORPHISM("Glassmorphism", "FROSTED GLASS", "Translucent frosted surfaces with glowing specular crystal rims"),
    CLAYMORPHISM("Claymorphism", "3D CLAY", "Puffy marshmallow 3D clay with colorful deep soft shadows"),
    SKEUOMORPHISM("Skeuomorphism", "TACTILE SLATE", "Realistic physical stone & leather with warm antique brass bevels"),
    CLASSIC("Classic", "MATERIAL", "Clean high-contrast palette with vibrant accents")
}

data class ThemePresetInfo(
    val id: String,
    val name: String,
    val category: MorphismCategory,
    val previewPrimary: Color,
    val previewSurface: Color,
    val previewAccent: Color,
    val description: String
)

object MorphismThemeRegistry {
    val ALL_PRESETS = listOf(
        ThemePresetInfo(
            id = "LAVENDER",
            name = "Neumorphic Lavender",
            category = MorphismCategory.NEUMORPHISM,
            previewPrimary = Color(0xFF4B308C),
            previewSurface = Color(0xFFEDE8F5),
            previewAccent = Color(0xFF6C5CE7),
            description = "Signature soft lavender tactile UI with specular highlight and ambient depth."
        ),
        ThemePresetInfo(
            id = "NEUMORPHIC_DARK",
            name = "Neumorphic Obsidian",
            category = MorphismCategory.NEUMORPHISM,
            previewPrimary = Color(0xFFA78BFA),
            previewSurface = Color(0xFF1D1A27),
            previewAccent = Color(0xFF818CF8),
            description = "Matte graphite charcoal extruded dark surfaces with specular edges."
        ),
        ThemePresetInfo(
            id = "EMERALD",
            name = "Neumorphic Sage",
            category = MorphismCategory.NEUMORPHISM,
            previewPrimary = Color(0xFF1B6B3A),
            previewSurface = Color(0xFFE7EFEA),
            previewAccent = Color(0xFF4CAF50),
            description = "Organic calming sage green with soft extruded dual shadow elevation."
        ),
        ThemePresetInfo(
            id = "OCEAN",
            name = "Neumorphic Ocean",
            category = MorphismCategory.NEUMORPHISM,
            previewPrimary = Color(0xFF0F638F),
            previewSurface = Color(0xFFE8F1F5),
            previewAccent = Color(0xFF0284C7),
            description = "Crisp arctic sky and ocean frost with bi-directional tactile depth."
        ),
        ThemePresetInfo(
            id = "GLASS_FROST",
            name = "Glass Frost",
            category = MorphismCategory.GLASSMORPHISM,
            previewPrimary = Color(0xFF2563EB),
            previewSurface = Color(0xFFF7FAFD),
            previewAccent = Color(0xFF06B6D4),
            description = "Translucent frosted crystal glass with vivid royal blue and specular rim."
        ),
        ThemePresetInfo(
            id = "GLASS_CYBER",
            name = "Glass Cyberpunk",
            category = MorphismCategory.GLASSMORPHISM,
            previewPrimary = Color(0xFF00E5FF),
            previewSurface = Color(0xFF111726),
            previewAccent = Color(0xFFFF007F),
            description = "Smoked obsidian glass with luminous neon cyan and magenta glowing edges."
        ),
        ThemePresetInfo(
            id = "CLAY_PASTEL",
            name = "Clay Marshmallow",
            category = MorphismCategory.CLAYMORPHISM,
            previewPrimary = Color(0xFF7C3AED),
            previewSurface = Color(0xFFFFF7FC),
            previewAccent = Color(0xFFEC4899),
            description = "Puffy 3D marshmallow clay, high pill elevation and playful pastel shadows."
        ),
        ThemePresetInfo(
            id = "SKEUOMORPHIC",
            name = "Skeuomorphic Slate",
            category = MorphismCategory.SKEUOMORPHISM,
            previewPrimary = Color(0xFF92400E),
            previewSurface = Color(0xFFF2EFE9),
            previewAccent = Color(0xFFD97706),
            description = "Tactile physical paper and slate stone with warm antique brass bevels."
        ),
        ThemePresetInfo(
            id = "SUNSET",
            name = "Sunset Amber",
            category = MorphismCategory.CLASSIC,
            previewPrimary = Color(0xFFBF360C),
            previewSurface = Color(0xFFFAF2F0),
            previewAccent = Color(0xFFF59E0B),
            description = "Warm terracotta and glowing amber twilight palette."
        )
    )

    fun findById(id: String): ThemePresetInfo {
        return ALL_PRESETS.firstOrNull { it.id.equals(id, ignoreCase = true) }
            ?: ALL_PRESETS.first()
    }
}

var MorphismElevationFactor by mutableStateOf(1.0f)

object NeumorphicDefaults {
    val CornerRadius: Dp = 18.dp
    val PillRadius: Dp = 26.dp
    val ElevationDefault: Dp = 5.dp
    val ElevationPressed: Dp = 1.dp
}

@Composable
fun rememberNeumorphicColors(isDarkMode: Boolean): Pair<Color, Color> {
    return remember(isDarkMode, NeumorphicHighlight, NeumorphicShadow) {
        val lightHighlight = if (NeumorphicHighlight != Color.Unspecified) NeumorphicHighlight
            else if (isDarkMode) Color(0xFF2E293E).copy(alpha = 0.55f) else Color.White.copy(alpha = 0.95f)
        val darkShadow = if (NeumorphicShadow != Color.Unspecified) NeumorphicShadow
            else if (isDarkMode) Color(0xFF0A0910).copy(alpha = 0.75f) else Color(0xFF3B2761).copy(alpha = 0.12f)
        Pair(lightHighlight, darkShadow)
    }
}

/**
 * Modifier for drawing a soft Neumorphic dual shadow around rounded rectangles.
 */
fun Modifier.neumorphicShadow(
    isDarkMode: Boolean = false,
    cornerRadius: Dp = 18.dp,
    elevation: Dp = 5.dp,
    isPressed: Boolean = false,
    lightShadowColor: Color? = null,
    darkShadowColor: Color? = null
): Modifier = this.drawBehind {
    val scaledElevation = (elevation.value * MorphismElevationFactor).dp
    val ePx = scaledElevation.toPx()
    if (ePx <= 0f) return@drawBehind

    val rPx = cornerRadius.toPx()
    val light = lightShadowColor ?: NeumorphicHighlight
    val dark = darkShadowColor ?: NeumorphicShadow

    if (!isPressed) {
        // Draw top-left specular highlight
        drawIntoCanvas { canvas ->
            try {
                val lightPaint = android.graphics.Paint().apply {
                    color = light.toArgb()
                    isAntiAlias = true
                    maskFilter = BlurMaskFilter(ePx * 1.2f, BlurMaskFilter.Blur.NORMAL)
                }
                canvas.nativeCanvas.drawRoundRect(
                    -ePx * 0.7f, -ePx * 0.7f,
                    size.width - ePx * 0.2f, size.height - ePx * 0.2f,
                    rPx, rPx, lightPaint
                )
            } catch (_: Exception) {}
        }

        // Draw bottom-right drop shadow
        drawIntoCanvas { canvas ->
            try {
                val darkPaint = android.graphics.Paint().apply {
                    color = dark.toArgb()
                    isAntiAlias = true
                    maskFilter = BlurMaskFilter(ePx * 1.2f, BlurMaskFilter.Blur.NORMAL)
                }
                canvas.nativeCanvas.drawRoundRect(
                    ePx * 0.7f, ePx * 0.7f,
                    size.width + ePx * 0.7f, size.height + ePx * 0.7f,
                    rPx, rPx, darkPaint
                )
            } catch (_: Exception) {}
        }
    }
}

/**
 * Extruded Neumorphic Card container.
 */
@Composable
fun NeumorphicCard(
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(18.dp),
    cornerRadius: Dp = 18.dp,
    elevation: Dp = NeumorphicDefaults.ElevationDefault,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    isDarkMode: Boolean = false,
    border: BorderStroke? = null,
    content: @Composable BoxScope.() -> Unit
) {
    val (light, dark) = rememberNeumorphicColors(isDarkMode)
    val defaultBorder = border ?: BorderStroke(
        1.dp,
        Brush.linearGradient(
            colors = listOf(
                light.copy(alpha = if (isDarkMode) 0.35f else 0.75f),
                dark.copy(alpha = if (isDarkMode) 0.5f else 0.25f)
            ),
            start = Offset(0f, 0f),
            end = Offset(400f, 400f)
        )
    )

    Box(
        modifier = modifier
            .neumorphicShadow(
                isDarkMode = isDarkMode,
                cornerRadius = cornerRadius,
                elevation = elevation,
                lightShadowColor = light,
                darkShadowColor = dark
            )
            .clip(shape)
            .background(containerColor)
            .border(defaultBorder, shape)
    ) {
        content()
    }
}

/**
 * Tactile Neumorphic Button with responsive extrusion/depression on touch.
 */
@Composable
fun NeumorphicButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    cornerRadius: Dp = 20.dp,
    shape: RoundedCornerShape = RoundedCornerShape(cornerRadius),
    containerColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = MaterialTheme.colorScheme.primary,
    elevation: Dp = NeumorphicDefaults.ElevationDefault,
    isDarkMode: Boolean = false,
    content: @Composable RowScope.() -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val currentElevation by animateDpAsState(
        targetValue = if (isPressed) NeumorphicDefaults.ElevationPressed else elevation,
        animationSpec = tween(durationMillis = 150),
        label = "neumorphicBtnElevation"
    )

    val (light, dark) = rememberNeumorphicColors(isDarkMode)
    val animatedBg by animateColorAsState(
        targetValue = if (isPressed) {
            if (isDarkMode) containerColor.copy(alpha = 0.85f) else containerColor.copy(alpha = 0.95f)
        } else containerColor,
        animationSpec = tween(durationMillis = 150),
        label = "neumorphicBtnBg"
    )

    Box(
        modifier = modifier
            .neumorphicShadow(
                isDarkMode = isDarkMode,
                cornerRadius = cornerRadius,
                elevation = currentElevation,
                isPressed = isPressed,
                lightShadowColor = light,
                darkShadowColor = dark
            )
            .clip(shape)
            .background(animatedBg)
            .border(
                BorderStroke(
                    1.dp,
                    Brush.linearGradient(
                        colors = listOf(
                            light.copy(alpha = if (isDarkMode) 0.35f else 0.8f),
                            dark.copy(alpha = if (isDarkMode) 0.6f else 0.3f)
                        ),
                        start = Offset(0f, 0f),
                        end = Offset(300f, 300f)
                    )
                ),
                shape
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = enabled,
                onClick = onClick
            )
            .padding(horizontal = 16.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        CompositionLocalProvider(LocalContentColor provides contentColor) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                content = content
            )
        }
    }
}

/**
 * Tactile Neumorphic Pill Tab for Bottom Navigation or Segmented Filters.
 */
@Composable
fun NeumorphicPill(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = NeumorphicDefaults.PillRadius,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    activeColor: Color = MaterialTheme.colorScheme.primary,
    isDarkMode: Boolean = false,
    content: @Composable RowScope.() -> Unit
) {
    val (light, dark) = rememberNeumorphicColors(isDarkMode)
    val shape = RoundedCornerShape(cornerRadius)

    val elevation by animateDpAsState(
        targetValue = if (selected) 0.dp else 4.dp,
        label = "pillElevation"
    )

    val bgColor by animateColorAsState(
        targetValue = if (selected) {
            activeColor.copy(alpha = if (isDarkMode) 0.22f else 0.12f)
        } else containerColor,
        label = "pillBg"
    )

    val borderColor = if (selected) {
        activeColor.copy(alpha = 0.5f)
    } else {
        light.copy(alpha = if (isDarkMode) 0.25f else 0.6f)
    }

    Box(
        modifier = modifier
            .then(
                if (!selected) {
                    Modifier.neumorphicShadow(
                        isDarkMode = isDarkMode,
                        cornerRadius = cornerRadius,
                        elevation = elevation,
                        lightShadowColor = light,
                        darkShadowColor = dark
                    )
                } else Modifier
            )
            .clip(shape)
            .background(bgColor)
            .border(BorderStroke(1.dp, borderColor), shape)
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            content = content
        )
    }
}

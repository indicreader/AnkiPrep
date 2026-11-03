package com.example.flashcardapp.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Immutable token model defining chrome, surface geometry, and official exam question states.
 * Supports zero-reinflation dynamic theming and custom Theme Studio configurations.
 */
@Immutable
data class ExamThemeTokens(
    val key: String,
    val displayName: String,
    val isCustom: Boolean = false,
    val isDark: Boolean = true,

    // Window Chrome & Surfaces (32-bit ARGB Ints for serialization and performance)
    val windowBackground: Int,
    val surfaceColor: Int,
    val borderColor: Int,
    val primaryText: Int,
    val secondaryText: Int,

    // Exam Question State Colors (Standard TCS iON & NTA palette indicators)
    val colorAnswered: Int,          // Selected response (e.g., TCS Green)
    val colorNotAnswered: Int,       // Skipped / Unanswered (e.g., TCS Orange/Red)
    val colorMarkedForReview: Int,   // Flagged for Review (e.g., TCS Violet)
    val colorAnsweredAndReview: Int, // Flagged + Answered
    val colorNotVisited: Int,        // Default inactive button/palette state

    // Geometry & Tactility
    val buttonCornerRadiusDp: Int = 8,
    val buttonElevationDp: Int = 2
) {
    // Convenient Compose Color accessors
    val composeWindowBackground: Color get() = Color(windowBackground)
    val composeSurfaceColor: Color get() = Color(surfaceColor)
    val composeBorderColor: Color get() = Color(borderColor)
    val composePrimaryText: Color get() = Color(primaryText)
    val composeSecondaryText: Color get() = Color(secondaryText)

    val composeColorAnswered: Color get() = Color(colorAnswered)
    val composeColorNotAnswered: Color get() = Color(colorNotAnswered)
    val composeColorMarkedForReview: Color get() = Color(colorMarkedForReview)
    val composeColorAnsweredAndReview: Color get() = Color(colorAnsweredAndReview)
    val composeColorNotVisited: Color get() = Color(colorNotVisited)
}


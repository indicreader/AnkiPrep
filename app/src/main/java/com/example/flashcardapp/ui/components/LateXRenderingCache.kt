package com.example.flashcardapp.ui.components

import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.LruCache
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import ru.noties.jlatexmath.JLatexMathDrawable

/**
 * High-performance In-Memory LRU Cache for rendered native LaTeX equations.
 * Completely eliminates layout jitter, recomposition lag, and TeX parsing re-runs.
 */
object LateXRenderingCache {
    private const val MAX_CACHE_ENTRIES = 150

    // Cache key combining formula string, text color, and target pixel text size
    data class CacheKey(
        val latex: String,
        val colorArgb: Int,
        val textSizePx: Float
    )

    private val cache = object : LruCache<CacheKey, ImageBitmap>(MAX_CACHE_ENTRIES) {
        override fun sizeOf(key: CacheKey, value: ImageBitmap): Int {
            // Memory footprint approximation in units of 1
            return 1
        }
    }

    /**
     * Renders LaTeX to a cached ImageBitmap.
     * Returns null if the TeX string is malformed or cannot be parsed.
     */
    fun render(latex: String, colorArgb: Int, textSizePx: Float): ImageBitmap? {
        val trimmed = latex.trim()
        if (trimmed.isEmpty()) return null

        val key = CacheKey(trimmed, colorArgb, textSizePx)
        val cached = cache.get(key)
        if (cached != null) return cached

        return try {
            val drawable = JLatexMathDrawable.builder(trimmed)
                .textSize(textSizePx)
                .color(colorArgb)
                .align(JLatexMathDrawable.ALIGN_LEFT)
                .build()

            val width = drawable.intrinsicWidth
            val height = drawable.intrinsicHeight

            if (width <= 0 || height <= 0) return null

            val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            drawable.setBounds(0, 0, width, height)
            drawable.draw(canvas)

            val imageBitmap = bitmap.asImageBitmap()
            cache.put(key, imageBitmap)
            imageBitmap
        } catch (e: Throwable) {
            null
        }
    }

    /** Clears in-memory rendering cache. */
    fun clear() {
        cache.evictAll()
    }
}


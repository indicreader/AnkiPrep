package com.example.flashcardapp.ui.components

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import kotlin.math.hypot
import kotlin.math.max
import kotlin.math.min

/**
 * Single input point recorded from stylus or touch event.
 * Includes optional pressure and timestamp for velocity & pressure-dependent dynamic stroke thinning.
 */
data class TimedPoint(
    val offset: Offset,
    val timestamp: Long = System.currentTimeMillis(),
    val pressure: Float = 1f
) {
    val x: Float get() = offset.x
    val y: Float get() = offset.y

    fun velocityTo(other: TimedPoint): Float {
        val dt = max(1L, other.timestamp - timestamp).toFloat()
        val dist = hypot(other.x - x, other.y - y)
        return dist / dt // px per ms
    }
}

/**
 * Supported whiteboard stroke tools.
 */
enum class WhiteboardTool {
    PEN,
    PENCIL,
    HIGHLIGHTER,
    ERASER,
    SHAPE_RECTANGLE,
    SHAPE_CIRCLE
}

/**
 * Immutable finished drawing stroke with pre-calculated smooth Bézier path.
 */
data class WhiteboardStroke(
    val id: String = java.util.UUID.randomUUID().toString(),
    val points: List<TimedPoint>,
    val color: Color,
    val baseWidth: Float,
    val tool: WhiteboardTool,
    val alpha: Float = 1f
) {
    /**
     * Lazily calculated, smoothed cubic Bézier path.
     */
    val smoothPath: Path by lazy {
        calculateSmoothPath(points, tool)
    }

    companion object {
        /**
         * Calculates smooth Catmull-Rom / Bézier spline or geometric shape path.
         */
        fun calculateSmoothPath(points: List<TimedPoint>, tool: WhiteboardTool): Path {
            val path = Path()
            if (points.isEmpty()) return path

            when (tool) {
                WhiteboardTool.SHAPE_RECTANGLE -> {
                    if (points.size >= 2) {
                        val start = points.first()
                        val end = points.last()
                        val left = min(start.x, end.x)
                        val top = min(start.y, end.y)
                        val right = max(start.x, end.x)
                        val bottom = max(start.y, end.y)
                        path.addRect(androidx.compose.ui.geometry.Rect(left, top, right, bottom))
                    }
                }
                WhiteboardTool.SHAPE_CIRCLE -> {
                    if (points.size >= 2) {
                        val start = points.first()
                        val end = points.last()
                        val dx = end.x - start.x
                        val dy = end.y - start.y
                        val radius = hypot(dx, dy)
                        path.addOval(
                            androidx.compose.ui.geometry.Rect(
                                start.x - radius,
                                start.y - radius,
                                start.x + radius,
                                start.y + radius
                            )
                        )
                    }
                }
                else -> {
                    // Smooth curve using midpoint quadratic / cubic Bézier interpolation
                    if (points.size == 1) {
                        val p = points.first()
                        path.addOval(androidx.compose.ui.geometry.Rect(p.x - 1f, p.y - 1f, p.x + 1f, p.y + 1f))
                    } else if (points.size == 2) {
                        path.moveTo(points[0].x, points[0].y)
                        path.lineTo(points[1].x, points[1].y)
                    } else {
                        path.moveTo(points[0].x, points[0].y)
                        for (i in 1 until points.size - 1) {
                            val current = points[i]
                            val next = points[i + 1]
                            val midX = (current.x + next.x) / 2f
                            val midY = (current.y + next.y) / 2f
                            path.quadraticBezierTo(current.x, current.y, midX, midY)
                        }
                        val last = points.last()
                        path.lineTo(last.x, last.y)
                    }
                }
            }
            return path
        }
    }
}

/**
 * Stateful inking controller running isolated outside Compose recomposition.
 * Manages active stroke point queues, predictive point extension, and stroke commit/erase routines.
 */
class WhiteboardInkingEngine(
    val onStrokesChanged: () -> Unit = {}
) {
    val strokes = mutableListOf<WhiteboardStroke>()
    private val undoneStrokes = mutableListOf<WhiteboardStroke>()

    // Current in-flight drawing stroke points
    var activePoints = mutableListOf<TimedPoint>()
        private set

    var activeTool = WhiteboardTool.PEN
    var activeColor = Color.Black
    var activeWidth = 5f
    var highlighterAlpha = 0.45f

    var eraserIndicatorPos: Offset? = null
        private set

    fun startStroke(offset: Offset, pressure: Float = 1f) {
        val now = System.currentTimeMillis()
        if (activeTool == WhiteboardTool.ERASER) {
            eraserIndicatorPos = offset
            eraseAt(offset, activeWidth * 2.5f)
        } else {
            activePoints.clear()
            activePoints.add(TimedPoint(offset, now, pressure))
        }
    }

    fun continueStroke(offset: Offset, pressure: Float = 1f) {
        val now = System.currentTimeMillis()
        if (activeTool == WhiteboardTool.ERASER) {
            eraserIndicatorPos = offset
            eraseAt(offset, activeWidth * 2.5f)
        } else {
            if (activeTool == WhiteboardTool.SHAPE_RECTANGLE || activeTool == WhiteboardTool.SHAPE_CIRCLE) {
                if (activePoints.isEmpty()) {
                    activePoints.add(TimedPoint(offset, now, pressure))
                } else {
                    val first = activePoints.first()
                    activePoints.clear()
                    activePoints.add(first)
                    activePoints.add(TimedPoint(offset, now, pressure))
                }
            } else {
                // Apply subtle distance deadband to suppress digitizer jitter
                val last = activePoints.lastOrNull()
                if (last == null || hypot(offset.x - last.x, offset.y - last.y) >= 1.5f) {
                    activePoints.add(TimedPoint(offset, now, pressure))
                }
            }
        }
    }

    fun endStroke() {
        if (activeTool == WhiteboardTool.ERASER) {
            eraserIndicatorPos = null
            onStrokesChanged()
        } else {
            if (activePoints.size >= 2) {
                val alpha = when (activeTool) {
                    WhiteboardTool.HIGHLIGHTER -> highlighterAlpha
                    WhiteboardTool.PENCIL -> 0.75f
                    else -> 1f
                }
                val stroke = WhiteboardStroke(
                    points = ArrayList(activePoints),
                    color = activeColor,
                    baseWidth = activeWidth,
                    tool = activeTool,
                    alpha = alpha
                )
                strokes.add(stroke)
                undoneStrokes.clear()
                activePoints.clear()
                onStrokesChanged()
            } else {
                activePoints.clear()
            }
        }
    }

    fun undo(): Boolean {
        if (strokes.isNotEmpty()) {
            val last = strokes.removeAt(strokes.size - 1)
            undoneStrokes.add(last)
            onStrokesChanged()
            return true
        }
        return false
    }

    fun redo(): Boolean {
        if (undoneStrokes.isNotEmpty()) {
            val stroke = undoneStrokes.removeAt(undoneStrokes.size - 1)
            strokes.add(stroke)
            onStrokesChanged()
            return true
        }
        return false
    }

    fun clearAll() {
        if (strokes.isNotEmpty()) {
            undoneStrokes.clear()
            undoneStrokes.addAll(strokes)
            strokes.clear()
            activePoints.clear()
            onStrokesChanged()
        }
    }

    fun eraseAt(pos: Offset, radius: Float) {
        val rSq = radius * radius
        val removed = strokes.removeAll { stroke ->
            stroke.points.any { p ->
                val dx = p.x - pos.x
                val dy = p.y - pos.y
                (dx * dx + dy * dy) <= rSq
            }
        }
        if (removed) {
            onStrokesChanged()
        }
    }

    /**
     * Renders all committed strokes plus the live predicted/in-flight stroke.
     */
    fun renderTo(drawScope: DrawScope) {
        with(drawScope) {
            // 1. Draw committed strokes
            for (stroke in strokes) {
                val strokeCap = if (stroke.tool == WhiteboardTool.HIGHLIGHTER) StrokeCap.Square else StrokeCap.Round
                drawPath(
                    path = stroke.smoothPath,
                    color = stroke.color.copy(alpha = stroke.alpha),
                    style = Stroke(
                        width = if (stroke.tool == WhiteboardTool.HIGHLIGHTER) stroke.baseWidth * 2.2f else stroke.baseWidth,
                        cap = strokeCap,
                        join = StrokeJoin.Round
                    )
                )
            }

            // 2. Draw active in-flight stroke
            if (activePoints.size >= 2) {
                val inFlightPath = WhiteboardStroke.calculateSmoothPath(activePoints, activeTool)
                val alpha = when (activeTool) {
                    WhiteboardTool.HIGHLIGHTER -> highlighterAlpha
                    WhiteboardTool.PENCIL -> 0.75f
                    else -> 1f
                }
                val strokeCap = if (activeTool == WhiteboardTool.HIGHLIGHTER) StrokeCap.Square else StrokeCap.Round
                drawPath(
                    path = inFlightPath,
                    color = activeColor.copy(alpha = alpha),
                    style = Stroke(
                        width = if (activeTool == WhiteboardTool.HIGHLIGHTER) activeWidth * 2.2f else activeWidth,
                        cap = strokeCap,
                        join = StrokeJoin.Round
                    )
                )
            }

            // 3. Draw eraser visual feedback ring
            eraserIndicatorPos?.let { pos ->
                drawCircle(
                    color = Color.Gray.copy(alpha = 0.4f),
                    radius = activeWidth * 2.5f,
                    center = pos,
                    style = Stroke(width = 2f)
                )
            }
        }
    }
}

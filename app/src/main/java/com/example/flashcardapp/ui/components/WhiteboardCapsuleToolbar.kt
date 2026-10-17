package com.example.flashcardapp.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import kotlin.math.roundToInt

/**
 * Modern floating capsule toolbar for the whiteboard and stylus engine.
 *
 * Benchmark: Flexcil / Goodnotes ergonomics
 * - Frosted glass pill container with blur and subtle specular rim.
 * - Draggable grip handle with edge boundary clamping & snap-to-edge docking.
 * - Horizontally scrollable tool rail with modern vector icons and elevated active states.
 * - Popover sheet for active tool adjustments (width, opacity, color presets).
 * - Dedicated utility controls (Undo, Redo, Clear, Close).
 */
@Composable
fun WhiteboardCapsuleToolbar(
    modifier: Modifier = Modifier,
    activeTool: WhiteboardTool,
    onToolSelected: (WhiteboardTool) -> Unit,
    activeColor: Color,
    onColorSelected: (Color) -> Unit,
    activeWidth: Float,
    onWidthSelected: (Float) -> Unit,
    highlighterAlpha: Float,
    onAlphaChanged: (Float) -> Unit,
    onUndo: () -> Unit,
    onRedo: () -> Unit,
    onClearAll: () -> Unit,
    onClose: () -> Unit,
    isDarkMode: Boolean,
    initialDockPosition: String = "BOTTOM"
) {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current

    val screenWidthPx = with(density) { configuration.screenWidthDp.dp.toPx() }
    val screenHeightPx = with(density) { configuration.screenHeightDp.dp.toPx() }

    val edgePaddingPx = with(density) { 16.dp.toPx() }
    val toolbarEstimatedWidthPx = with(density) { 360.dp.toPx() }
    val toolbarEstimatedHeightPx = with(density) { 64.dp.toPx() }

    // Initial position calculated cleanly based on preference
    val defaultX = (screenWidthPx - toolbarEstimatedWidthPx) / 2f
    val defaultY = when (initialDockPosition) {
        "TOP" -> edgePaddingPx + with(density) { 64.dp.toPx() }
        "LEFT" -> edgePaddingPx
        "RIGHT" -> screenWidthPx - toolbarEstimatedWidthPx - edgePaddingPx
        else -> screenHeightPx - toolbarEstimatedHeightPx - with(density) { 80.dp.toPx() }
    }

    var toolbarOffset by remember { mutableStateOf(Offset(defaultX, defaultY)) }
    var showToolPopover by remember { mutableStateOf(false) }

    // Clamp coordinates within screen boundaries
    fun clampOffset(candidate: Offset): Offset {
        val minX = edgePaddingPx
        val maxX = maxOf(minX, screenWidthPx - toolbarEstimatedWidthPx - edgePaddingPx)
        val minY = edgePaddingPx + with(density) { 48.dp.toPx() } // Avoid system status bar
        val maxY = maxOf(minY, screenHeightPx - toolbarEstimatedHeightPx - edgePaddingPx)
        return Offset(
            x = candidate.x.coerceIn(minX, maxX),
            y = candidate.y.coerceIn(minY, maxY)
        )
    }

    // Frosted glass background brush with subtle specular border
    val glassBgColor = if (isDarkMode) {
        Color(0xDF1C1B1F) // Deep translucent dark surface
    } else {
        Color(0xEEFFFFFF) // Frosted bright porcelain
    }

    val rimBorderBrush = Brush.linearGradient(
        colors = if (isDarkMode) {
            listOf(Color(0x40FFFFFF), Color(0x15FFFFFF), Color(0x30FFFFFF))
        } else {
            listOf(Color(0x99FFFFFF), Color(0x33000000), Color(0x66FFFFFF))
        }
    )

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        // Floating pill capsule
        Surface(
            modifier = Modifier
                .offset {
                    IntOffset(
                        toolbarOffset.x.roundToInt(),
                        toolbarOffset.y.roundToInt()
                    )
                }
                .shadow(
                    elevation = 16.dp,
                    shape = RoundedCornerShape(32.dp),
                    spotColor = if (isDarkMode) Color.Black.copy(alpha = 0.6f) else Color(0x40000000)
                )
                .clip(RoundedCornerShape(32.dp))
                .background(glassBgColor)
                .border(BorderStroke(1.2.dp, rimBorderBrush), RoundedCornerShape(32.dp)),
            color = Color.Transparent,
            shape = RoundedCornerShape(32.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 1. Draggable Grip Handle
                Box(
                    modifier = Modifier
                        .size(width = 24.dp, height = 44.dp)
                        .pointerInput(Unit) {
                            detectDragGestures(
                                onDrag = { change, dragAmount ->
                                    change.consume()
                                    toolbarOffset = clampOffset(toolbarOffset + dragAmount)
                                },
                                onDragEnd = {
                                    // Optional snap-to-edge docking when dropped near borders
                                    val snapThreshold = 48f
                                    var targetX = toolbarOffset.x
                                    val minX = edgePaddingPx
                                    val maxX = maxOf(minX, screenWidthPx - toolbarEstimatedWidthPx - edgePaddingPx)
                                    if (toolbarOffset.x - minX < snapThreshold) targetX = minX
                                    if (maxX - toolbarOffset.x < snapThreshold) targetX = maxX
                                    toolbarOffset = Offset(targetX, toolbarOffset.y)
                                }
                            )
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(3.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        repeat(3) {
                            Box(
                                modifier = Modifier
                                    .size(width = 10.dp, height = 3.dp)
                                    .clip(RoundedCornerShape(2.dp))
                                    .background(
                                        if (isDarkMode) Color.White.copy(alpha = 0.35f) else Color.Black.copy(alpha = 0.25f)
                                    )
                            )
                        }
                    }
                }

                Spacer(Modifier.width(4.dp))

                // Vertical divider
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(28.dp)
                        .background(
                            if (isDarkMode) Color.White.copy(alpha = 0.15f) else Color.Black.copy(alpha = 0.1f)
                        )
                )

                Spacer(Modifier.width(4.dp))

                // 2. Horizontally scrollable Tool Rail (Flexcil / Goodnotes layout)
                Row(
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Tool: Pen
                    CapsuleToolItem(
                        icon = Icons.Outlined.Edit,
                        label = "Pen",
                        isSelected = activeTool == WhiteboardTool.PEN,
                        activeColor = activeColor,
                        onClick = {
                            if (activeTool == WhiteboardTool.PEN) {
                                showToolPopover = !showToolPopover
                            } else {
                                onToolSelected(WhiteboardTool.PEN)
                                showToolPopover = false
                            }
                        }
                    )

                    // Tool: Pencil
                    CapsuleToolItem(
                        icon = Icons.Outlined.Create,
                        label = "Pencil",
                        isSelected = activeTool == WhiteboardTool.PENCIL,
                        activeColor = activeColor,
                        onClick = {
                            if (activeTool == WhiteboardTool.PENCIL) {
                                showToolPopover = !showToolPopover
                            } else {
                                onToolSelected(WhiteboardTool.PENCIL)
                                showToolPopover = false
                            }
                        }
                    )

                    // Tool: Highlighter
                    CapsuleToolItem(
                        icon = Icons.Outlined.Highlight,
                        label = "Highlighter",
                        isSelected = activeTool == WhiteboardTool.HIGHLIGHTER,
                        activeColor = activeColor.copy(alpha = highlighterAlpha),
                        onClick = {
                            if (activeTool == WhiteboardTool.HIGHLIGHTER) {
                                showToolPopover = !showToolPopover
                            } else {
                                onToolSelected(WhiteboardTool.HIGHLIGHTER)
                                showToolPopover = false
                            }
                        }
                    )

                    // Tool: Eraser
                    CapsuleToolItem(
                        icon = Icons.Outlined.AutoFixNormal,
                        label = "Eraser",
                        isSelected = activeTool == WhiteboardTool.ERASER,
                        activeColor = MaterialTheme.colorScheme.error,
                        onClick = {
                            onToolSelected(WhiteboardTool.ERASER)
                            showToolPopover = false
                        }
                    )

                    // Tool: Rectangle Shape
                    CapsuleToolItem(
                        icon = Icons.Outlined.CropSquare,
                        label = "Rectangle",
                        isSelected = activeTool == WhiteboardTool.SHAPE_RECTANGLE,
                        activeColor = activeColor,
                        onClick = {
                            onToolSelected(WhiteboardTool.SHAPE_RECTANGLE)
                            showToolPopover = false
                        }
                    )

                    // Tool: Circle Shape
                    CapsuleToolItem(
                        icon = Icons.Outlined.Circle,
                        label = "Circle",
                        isSelected = activeTool == WhiteboardTool.SHAPE_CIRCLE,
                        activeColor = activeColor,
                        onClick = {
                            onToolSelected(WhiteboardTool.SHAPE_CIRCLE)
                            showToolPopover = false
                        }
                    )
                }

                Spacer(Modifier.width(6.dp))

                // Vertical divider
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(28.dp)
                        .background(
                            if (isDarkMode) Color.White.copy(alpha = 0.15f) else Color.Black.copy(alpha = 0.1f)
                        )
                )

                Spacer(Modifier.width(4.dp))

                // 3. Utility Controls: Undo, Redo, Clear, Close
                Row(
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = onUndo,
                        modifier = Modifier.size(34.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Undo,
                            contentDescription = "Undo",
                            modifier = Modifier.size(19.dp),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    IconButton(
                        onClick = onRedo,
                        modifier = Modifier.size(34.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Redo,
                            contentDescription = "Redo",
                            modifier = Modifier.size(19.dp),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    IconButton(
                        onClick = onClearAll,
                        modifier = Modifier.size(34.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.DeleteSweep,
                            contentDescription = "Clear Canvas",
                            modifier = Modifier.size(20.dp),
                            tint = MaterialTheme.colorScheme.error
                        )
                    }

                    IconButton(
                        onClick = onClose,
                        modifier = Modifier.size(34.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = "Close Whiteboard",
                            modifier = Modifier.size(19.dp),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        // 4. Uncluttered Popover for active tool adjustments (Width, Opacity, Colors)
        if (showToolPopover && activeTool != WhiteboardTool.ERASER) {
            Popup(
                alignment = Alignment.TopStart,
                offset = IntOffset(
                    toolbarOffset.x.roundToInt() + with(density) { 32.dp.toPx().roundToInt() },
                    (toolbarOffset.y - with(density) { 150.dp.toPx() }).coerceAtLeast(edgePaddingPx).roundToInt()
                ),
                onDismissRequest = { showToolPopover = false },
                properties = PopupProperties(focusable = true)
            ) {
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = if (isDarkMode) Color(0xF025242A) else Color(0xF6FFFFFF),
                    border = BorderStroke(1.dp, rimBorderBrush),
                    shadowElevation = 18.dp,
                    modifier = Modifier.width(280.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(14.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        // Title
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "${activeTool.name.replace("SHAPE_", "")} Settings",
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "${activeWidth.toInt()}px",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }

                        // Width presets
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val presetWidths = listOf(3f, 6f, 10f, 16f, 24f)
                            presetWidths.forEach { w ->
                                val isSelected = activeWidth == w
                                Box(
                                    modifier = Modifier
                                        .size(34.dp)
                                        .clip(CircleShape)
                                        .background(
                                            if (isSelected) MaterialTheme.colorScheme.primaryContainer else Color.Transparent
                                        )
                                        .clickable { onWidthSelected(w) },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size((w / 2.2f + 4f).dp)
                                            .clip(CircleShape)
                                            .background(
                                                if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                    )
                                }
                            }
                        }

                        // Color Presets
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val palette = listOf(
                                if (isDarkMode) Color.White else Color.Black,
                                Color(0xFFE53935), // Red
                                Color(0xFF1E88E5), // Blue
                                Color(0xFF43A047), // Green
                                Color(0xFFFB8C00), // Orange
                                Color(0xFF8E24AA)  // Purple
                            )
                            palette.forEach { c ->
                                val isSelected = activeColor == c
                                Box(
                                    modifier = Modifier
                                        .size(28.dp)
                                        .clip(CircleShape)
                                        .background(c)
                                        .border(
                                            width = if (isSelected) 2.5.dp else 1.dp,
                                            color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray.copy(alpha = 0.4f),
                                            shape = CircleShape
                                        )
                                        .clickable { onColorSelected(c) }
                                )
                            }
                        }

                        // If Highlighter, show opacity slider
                        if (activeTool == WhiteboardTool.HIGHLIGHTER) {
                            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                Text(
                                    text = "Opacity: ${(highlighterAlpha * 100).toInt()}%",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Slider(
                                    value = highlighterAlpha,
                                    onValueChange = onAlphaChanged,
                                    valueRange = 0.15f..0.85f,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * Modern vector icon tool button with elevated active state (-4px shift) and color dot indicator underneath.
 */
@Composable
private fun CapsuleToolItem(
    icon: ImageVector,
    label: String,
    isSelected: Boolean,
    activeColor: Color,
    onClick: () -> Unit
) {
    val offsetY by animateDpAsState(
        targetValue = if (isSelected) (-4).dp else 0.dp,
        label = "toolLift"
    )

    Column(
        modifier = Modifier
            .offset(y = offsetY)
            .clickable(onClick = onClick)
            .padding(horizontal = 6.dp, vertical = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(38.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(
                    if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.12f) else Color.Transparent
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                modifier = Modifier.size(22.dp),
                tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Spacer(Modifier.height(3.dp))

        // Small indicator dot underneath (no enclosing box clutter)
        Box(
            modifier = Modifier
                .size(width = 12.dp, height = 3.dp)
                .clip(RoundedCornerShape(1.5.dp))
                .background(
                    if (isSelected) activeColor else Color.Transparent
                )
        )
    }
}

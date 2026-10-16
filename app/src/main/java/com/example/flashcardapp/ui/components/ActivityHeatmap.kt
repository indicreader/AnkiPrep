package com.example.flashcardapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.*

/**
 * 365-Day Activity Heatmap Contribution Grid (GitHub-style).
 */
@Composable
fun ActivityHeatmap(
    modifier: Modifier = Modifier,
    activityData: Map<String, Int> = emptyMap(), // "YYYY-MM-DD" -> count
    primaryColor: Color = MaterialTheme.colorScheme.primary
) {
    val scrollState = rememberScrollState()
    var selectedDayInfo by remember { mutableStateOf<Pair<String, Int>?>(null) }

    // Prepare 52 weeks of dates (364 days ending today)
    val calendar = Calendar.getInstance()
    val sdf = remember { SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()) }
    val displayFormat = remember { SimpleDateFormat("MMM d, yyyy", Locale.getDefault()) }

    val daysList = remember(activityData) {
        val list = mutableListOf<Triple<String, String, Int>>() // yyyy-MM-dd, displayDate, count
        val cal = Calendar.getInstance()
        cal.add(Calendar.DAY_OF_YEAR, -363)

        for (i in 0 until 364) {
            val dateStr = sdf.format(cal.time)
            val dispStr = displayFormat.format(cal.time)
            val count = activityData[dateStr] ?: 0
            list.add(Triple(dateStr, dispStr, count))
            cal.add(Calendar.DAY_OF_YEAR, 1)
        }
        list
    }

    // Total activity
    val totalReviewsThisYear = remember(daysList) { daysList.sumOf { it.third } }
    val activeDays = remember(daysList) { daysList.count { it.third > 0 } }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Header stats
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Annual Study Heatmap",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "$totalReviewsThisYear cards reviewed across $activeDays active days",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                // Legend
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Less", fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Spacer(Modifier.width(4.dp))
                    listOf(0, 10, 25, 45, 60).forEach { lvl ->
                        Box(
                            modifier = Modifier
                                .size(9.dp)
                                .clip(RoundedCornerShape(2.dp))
                                .background(getHeatmapColor(lvl, primaryColor))
                        )
                        Spacer(Modifier.width(2.dp))
                    }
                    Spacer(Modifier.width(2.dp))
                    Text("More", fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }

            Spacer(Modifier.height(12.dp))

            // Horizontally scrollable 52-column grid
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(scrollState)
            ) {
                // Days of week indicators
                Column(
                    modifier = Modifier.padding(end = 6.dp),
                    verticalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat").forEachIndexed { index, day ->
                        Text(
                            text = if (index % 2 == 1) day else "",
                            fontSize = 9.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.height(11.dp)
                        )
                    }
                }

                // 52 columns x 7 days
                val columns = remember(daysList) { daysList.chunked(7) }

                Row(horizontalArrangement = Arrangement.spacedBy(3.dp)) {
                    columns.forEach { week ->
                        Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
                            week.forEach { (_, dispDate, count) ->
                                Box(
                                    modifier = Modifier
                                        .size(11.dp)
                                        .clip(RoundedCornerShape(2.dp))
                                        .background(getHeatmapColor(count, primaryColor))
                                        .clickable {
                                            selectedDayInfo = dispDate to count
                                        }
                                )
                            }
                        }
                    }
                }
            }

            // Interactive Day Tap Info Banner
            if (selectedDayInfo != null) {
                Spacer(Modifier.height(10.dp))
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${selectedDayInfo!!.first}: ${selectedDayInfo!!.second} cards reviewed",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        TextButton(
                            onClick = { selectedDayInfo = null },
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text("Dismiss", fontSize = 11.sp)
                        }
                    }
                }
            }
        }
    }
}

/**
 * Calculates color shade based on card count.
 */
@Composable
private fun getHeatmapColor(count: Int, primaryColor: Color): Color {
    val emptyColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f)
    return when {
        count == 0 -> emptyColor
        count in 1..10 -> primaryColor.copy(alpha = 0.25f)
        count in 11..25 -> primaryColor.copy(alpha = 0.50f)
        count in 26..50 -> primaryColor.copy(alpha = 0.75f)
        else -> primaryColor
    }
}

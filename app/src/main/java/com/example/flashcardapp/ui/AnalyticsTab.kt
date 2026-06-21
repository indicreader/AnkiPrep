package com.example.flashcardapp.ui

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.flashcardapp.data.entities.SessionRecordEntity
import com.example.flashcardapp.session.StreakCalculator
import com.example.flashcardapp.ui.theme.*
import java.util.Calendar
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnalyticsTab(
    cardCount: Int,
    sessionRecords: List<SessionRecordEntity>,
    onMenuClicked: () -> Unit
) {
    val currentLanguage by com.example.flashcardapp.data.TranslationManager.currentLanguage.collectAsState()
    val context = LocalContext.current
    val sharedPrefs = remember { context.getSharedPreferences("AnkiPrepProfile", Context.MODE_PRIVATE) }

    var profileName by remember { mutableStateOf(sharedPrefs.getString("profile_name", "Aaryan Sharma") ?: "Aaryan Sharma") }
    var profileGoal by remember { mutableStateOf(sharedPrefs.getString("profile_goal", "Civil Services") ?: "Civil Services") }
    var profileRank by remember { mutableStateOf(sharedPrefs.getString("profile_rank", "Master Rank") ?: "Master Rank") }
    var profileBio by remember { mutableStateOf(sharedPrefs.getString("profile_bio", "Mastering Indian Polity & Ethics for the upcoming UPSC cycle. Focused on high-density information retrieval and consistent mock performance.") ?: "Mastering Indian Polity & Ethics for the upcoming UPSC cycle. Focused on high-density information retrieval and consistent mock performance.") }
    var avatarUriStr by remember { mutableStateOf(sharedPrefs.getString("avatar_uri", null)) }

    DisposableEffect(sharedPrefs) {
        val listener = android.content.SharedPreferences.OnSharedPreferenceChangeListener { prefs, key ->
            when (key) {
                "profile_name" -> profileName = prefs.getString("profile_name", "Aaryan Sharma") ?: "Aaryan Sharma"
                "profile_goal" -> profileGoal = prefs.getString("profile_goal", "Civil Services") ?: "Civil Services"
                "profile_rank" -> profileRank = prefs.getString("profile_rank", "Master Rank") ?: "Master Rank"
                "profile_bio" -> profileBio = prefs.getString("profile_bio", "Mastering Indian Polity & Ethics for the upcoming UPSC cycle. Focused on high-density information retrieval and consistent mock performance.") ?: "Mastering Indian Polity & Ethics for the upcoming UPSC cycle. Focused on high-density information retrieval and consistent mock performance."
                "avatar_uri" -> avatarUriStr = prefs.getString("avatar_uri", null)
            }
        }
        sharedPrefs.registerOnSharedPreferenceChangeListener(listener)
        onDispose {
            sharedPrefs.unregisterOnSharedPreferenceChangeListener(listener)
        }
    }
    val avatarUri = remember(avatarUriStr) { avatarUriStr?.let { Uri.parse(it) } }

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            if (uri != null) {
                avatarUriStr = uri.toString()
                sharedPrefs.edit().putString("avatar_uri", uri.toString()).apply()
            }
        }
    )

    val scrollState = rememberScrollState()
    val streakInfo = remember(sessionRecords) { StreakCalculator.calculate(sessionRecords) }

    val mastery = remember(sessionRecords) {
        val total = sessionRecords.sumOf { it.totalQuestions }
        val correct = sessionRecords.sumOf { it.score }
        if (total > 0) (correct.toFloat() / total * 100) else 0f
    }

    val totalSolved = remember(sessionRecords) { sessionRecords.sumOf { it.totalQuestions } }
    val totalTimeHours = remember(sessionRecords) { sessionRecords.sumOf { it.timeTakenSeconds } / 3600f }
    val level = remember(totalSolved) { (totalSolved / 50).coerceIn(1, 99) }

    val rankLabel = when {
        sessionRecords.isEmpty() -> profileRank
        mastery >= 85f -> "Master Rank"
        mastery >= 65f -> "Gold Rank"
        mastery >= 45f -> "Silver Rank"
        else           -> "Bronze Rank"
    }

    val retentionData = remember(sessionRecords) {
        val result = FloatArray(5) { 0f }
        val cal = Calendar.getInstance()
        val todayMs = System.currentTimeMillis()
        val weekData = mutableMapOf<Int, Pair<Int, Int>>()
        sessionRecords.forEach { r ->
            val diff = ((todayMs - r.timestamp) / 86_400_000L).toInt()
            if (diff in 0..4) {
                val existing = weekData.getOrDefault(diff, 0 to 0)
                weekData[diff] = (existing.first + r.score) to (existing.second + r.totalQuestions)
            }
        }
        var hasAnyData = false
        for (i in 0..4) {
            val (c, t) = weekData.getOrDefault(i, 0 to 0)
            if (t > 0) {
                result[4 - i] = (c.toFloat() / t * 100f)
                hasAnyData = true
            }
        }
        if (!hasAnyData) {
            listOf(60f, 65f, 70f, 75f, 80f)
        } else {
            result.toList()
        }
    }

    val subjectStrengths = remember(sessionRecords) {
        if (sessionRecords.isEmpty()) {
            listOf("Polity" to 0.75f, "Geography" to 0.65f, "History" to 0.55f, "Economy" to 0.45f, "Ethics" to 0.80f, "Aptitude" to 0.60f)
        } else {
            val deckCorrect = mutableMapOf<String, Int>()
            val deckTotal = mutableMapOf<String, Int>()
            sessionRecords.forEach { record ->
                deckCorrect[record.deckName] = (deckCorrect[record.deckName] ?: 0) + record.score
                deckTotal[record.deckName] = (deckTotal[record.deckName] ?: 0) + record.totalQuestions
            }
            val list = mutableListOf<Pair<String, Float>>()
            deckTotal.forEach { (name, total) ->
                if (total > 0) {
                    val correct = deckCorrect[name] ?: 0
                    val acc = correct.toFloat() / total.toFloat()
                    list.add(name.split("::").last() to acc)
                }
            }
            if (list.size < 3) {
                val defaultPadding = listOf("Polity", "Geography", "History", "Economy", "Ethics", "Aptitude")
                var padIdx = 0
                while (list.size < 5) {
                    val padName = defaultPadding[padIdx % defaultPadding.size]
                    if (list.none { it.first == padName }) {
                        list.add(padName to 0.5f)
                    }
                    padIdx++
                }
            }
            list.take(6)
        }
    }

    val accomplishments = remember(sessionRecords, streakInfo.currentStreak) {
        val list = mutableListOf<Triple<androidx.compose.ui.graphics.vector.ImageVector, String, String>>()
        if (streakInfo.currentStreak > 0) {
            list.add(Triple(Icons.Outlined.LocalFireDepartment, "Streak Master", "Maintained a ${streakInfo.currentStreak}-day learning streak!"))
        }
        if (sessionRecords.isNotEmpty()) {
            val maxScoreRecord = sessionRecords.maxByOrNull { it.score }
            if (maxScoreRecord != null) {
                list.add(Triple(Icons.Outlined.EmojiEvents, "Top Quiz Score", "Scored ${maxScoreRecord.score}/${maxScoreRecord.totalQuestions} on ${maxScoreRecord.deckName.split("::").last()}"))
            }
            val totalQuestions = sessionRecords.sumOf { it.totalQuestions }
            if (totalQuestions >= 100) {
                list.add(Triple(Icons.Outlined.Bolt, "Century Solver", "Answered more than 100 custom deck questions."))
            }
        }
        if (list.size < 2) {
            list.add(Triple(Icons.Outlined.EmojiEvents, "Getting Started", "Practice your first quiz to unlock accomplishments."))
            list.add(Triple(Icons.Outlined.Bolt, "Quick Learner", "Complete a session in under 10 minutes to earn Speed Demon."))
        }
        list.take(2)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = 600.dp)
                .verticalScroll(scrollState)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Spacer(Modifier.height(16.dp))

            // ── Header ────────────────────────────────────────────────────────
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.15f))
                            .clickable { photoPickerLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)) },
                        contentAlignment = Alignment.Center
                    ) {
                        if (avatarUri != null) {
                            AsyncImage(model = avatarUri, contentDescription = "Avatar", modifier = Modifier.fillMaxSize().clip(CircleShape), contentScale = ContentScale.Crop)
                        } else {
                            Icon(Icons.Filled.Person, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(22.dp))
                        }
                    }
                    Text("AnkiPrep", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                }
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50))
                            .background(Color(0xFFE8F5EE))
                            .padding(horizontal = 10.dp, vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text("🔥", fontSize = 13.sp)
                        Text("${streakInfo.currentStreak}", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                    }
                    Icon(Icons.Outlined.Notifications, contentDescription = "Notifications", tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(22.dp))
                }
            }

            // ── Profile Hero ──────────────────────────────────────────────────
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(contentAlignment = Alignment.BottomCenter) {
                    Box(
                        modifier = Modifier
                            .size(90.dp)
                            .clip(CircleShape)
                            .background(Brush.linearGradient(listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.secondary ?: MaterialTheme.colorScheme.primary)))
                            .border(3.dp, MaterialTheme.colorScheme.primary, CircleShape)
                            .clickable { photoPickerLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)) },
                        contentAlignment = Alignment.Center
                    ) {
                        if (avatarUri != null) {
                            AsyncImage(model = avatarUri, contentDescription = "Avatar", modifier = Modifier.fillMaxSize().clip(CircleShape), contentScale = ContentScale.Crop)
                        } else {
                            Text(profileName.take(1).uppercase(), color = Color.White, fontSize = 36.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                    Box(
                        modifier = Modifier
                            .offset(y = 8.dp)
                            .clip(RoundedCornerShape(50))
                            .background(MaterialTheme.colorScheme.primary)
                            .padding(horizontal = 8.dp, vertical = 3.dp)
                    ) {
                        Text("LVL $level", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    }
                }

                Spacer(Modifier.height(8.dp))

                Text(profileName, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    ProfileBadge(text = rankLabel, primary = true)
                    ProfileBadge(text = profileGoal, primary = false)
                }

                Text(
                    text = "\"$profileBio\"",
                    fontSize = 13.sp,
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center,
                    lineHeight = 19.sp,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }

            // ── Stats 2×2 Grid ────────────────────────────────────────────────
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    ProfileStatCard(
                        modifier = Modifier.weight(1f),
                        icon = Icons.Outlined.LibraryBooks,
                        value = String.format("%,d", totalSolved),
                        label = com.example.flashcardapp.data.TranslationManager.getString("cards_studied").uppercase(),
                        iconTint = MaterialTheme.colorScheme.primary
                    )
                    ProfileStatCard(
                        modifier = Modifier.weight(1f),
                        icon = Icons.Outlined.TrackChanges,
                        value = String.format("%.1f%%", mastery),
                        label = com.example.flashcardapp.data.TranslationManager.getString("accuracy").uppercase(),
                        iconTint = Color(0xFF2196F3)
                    )
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    ProfileStatCard(
                        modifier = Modifier.weight(1f),
                        icon = Icons.Outlined.LocalFireDepartment,
                        value = "${streakInfo.currentStreak} Days",
                        label = com.example.flashcardapp.data.TranslationManager.getString("streak").uppercase(),
                        iconTint = Color(0xFFFF9800)
                    )
                    ProfileStatCard(
                        modifier = Modifier.weight(1f),
                        icon = Icons.Outlined.Schedule,
                        value = String.format("%.1fh", totalTimeHours),
                        label = com.example.flashcardapp.data.TranslationManager.getString("time_taken").uppercase(),
                        iconTint = Color(0xFF9C27B0)
                    )
                }
            }

            // ── Retention Mastery line chart ──────────────────────────────────
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Column {
                            Text("Retention Mastery", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                            Text("Knowledge decay over the last 30 days", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                        Box(
                            modifier = Modifier
                                .size(28.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("••", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                        }
                    }
                    Spacer(Modifier.height(16.dp))
                    RetentionLineChart(data = retentionData, color = MaterialTheme.colorScheme.primary)
                    Spacer(Modifier.height(8.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        listOf("Week 1", "Week 2", "Week 3", "Week 4", "Today").forEach { lbl ->
                            Text(lbl, fontSize = 9.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                }
            }

            // ── Subject Strengths radar chart ─────────────────────────────────
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Column {
                            Text("Subject Strengths", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                            Text("Expertise distribution", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                    Spacer(Modifier.height(16.dp))
                    SubjectRadarChart(data = subjectStrengths, color = MaterialTheme.colorScheme.primary)
                }
            }

            // ── Recent Accomplishments ────────────────────────────────────────
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Box(modifier = Modifier.width(4.dp).height(20.dp).background(MaterialTheme.colorScheme.primary, RoundedCornerShape(2.dp)))
                    Text("Recent Accomplishments", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
                }
                
                accomplishments.forEach { item ->
                    AccomplishmentCard(
                        icon = item.first,
                        title = item.second,
                        desc = item.third,
                        time = "ACTIVE",
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(Modifier.height(100.dp))
        }
    }
}

@Composable
private fun ProfileBadge(text: String, primary: Boolean) {
    val bg = if (primary) MaterialTheme.colorScheme.primary.copy(alpha = 0.12f) else MaterialTheme.colorScheme.surfaceVariant
    val textColor = if (primary) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(bg)
            .padding(horizontal = 10.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        if (primary) Icon(Icons.Outlined.Verified, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(12.dp))
        Text(text, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = textColor)
    }
}

@Composable
private fun ProfileStatCard(
    modifier: Modifier,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    value: String,
    label: String,
    iconTint: Color
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Icon(icon, contentDescription = null, tint = iconTint, modifier = Modifier.size(22.dp))
            Text(value, fontSize = 28.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
            Text(label, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurfaceVariant, letterSpacing = 1.sp)
        }
    }
}

@Composable
private fun AccomplishmentCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    desc: String,
    time: String,
    color: Color
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(color.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(icon, contentDescription = null, tint = color, modifier = Modifier.size(22.dp))
            }
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(title, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                Text(desc, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 16.sp)
            }
            Text(time, fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant, fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
private fun RetentionLineChart(data: List<Float>, color: Color) {
    val fillColor = color.copy(alpha = 0.08f)
    Canvas(modifier = Modifier.fillMaxWidth().height(140.dp)) {
        if (data.isEmpty()) return@Canvas
        
        val numYLines = 6
        for (i in 0 until numYLines) {
            val y = size.height - (i.toFloat() / (numYLines - 1)) * size.height
            drawLine(
                color = Color.LightGray.copy(alpha = 0.15f),
                start = Offset(0f, y),
                end = Offset(size.width, y),
                strokeWidth = 1f
            )
        }

        val pts = data.mapIndexed { i, v ->
            val x = i.toFloat() / (data.size - 1) * size.width
            val y = size.height - (v / 100f) * size.height
            Offset(x, y)
        }

        if (pts.size >= 2) {
            val fillPath = Path().apply {
                moveTo(pts.first().x, size.height)
                pts.forEach { lineTo(it.x, it.y) }
                lineTo(pts.last().x, size.height)
                close()
            }
            drawPath(fillPath, color = fillColor)

            val linePath = Path().apply {
                moveTo(pts.first().x, pts.first().y)
                for (i in 1 until pts.size) {
                    val cx = (pts[i - 1].x + pts[i].x) / 2
                    quadraticBezierTo(cx, pts[i - 1].y, pts[i].x, pts[i].y)
                }
            }
            drawPath(linePath, color = color, style = Stroke(width = 4f, cap = StrokeCap.Round))

            pts.forEach { pt ->
                drawCircle(Color.White, radius = 7f, center = pt)
                drawCircle(color, radius = 5f, center = pt, style = Stroke(width = 3f))
            }
        }
    }
}

@Composable
private fun SubjectRadarChart(data: List<Pair<String, Float>>, color: Color) {
    val subjects = data.map { it.first }
    val values = data.map { it.second.coerceIn(0.1f, 1.0f) }

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.size(200.dp)) {
            val center = Offset(size.width / 2, size.height / 2)
            val maxRadius = size.width * 0.38f
            val n = subjects.size
            val angleStep = (2 * PI / n).toFloat()

            for (ring in 1..4) {
                val r = maxRadius * ring / 4f
                val ringPath = Path()
                for (i in 0 until n) {
                    val angle = i * angleStep - PI.toFloat() / 2
                    val x = center.x + r * cos(angle)
                    val y = center.y + r * sin(angle)
                    if (i == 0) ringPath.moveTo(x, y) else ringPath.lineTo(x, y)
                }
                ringPath.close()
                drawPath(ringPath, color = Color.LightGray.copy(alpha = 0.15f), style = Stroke(width = 1.5f))
            }

            for (i in 0 until n) {
                val angle = i * angleStep - PI.toFloat() / 2
                drawLine(Color.LightGray.copy(alpha = 0.2f), center, Offset(center.x + maxRadius * cos(angle), center.y + maxRadius * sin(angle)), strokeWidth = 1f)
            }

            val dataPath = Path()
            values.forEachIndexed { i, v ->
                val angle = i * angleStep - PI.toFloat() / 2
                val r = maxRadius * v
                val x = center.x + r * cos(angle)
                val y = center.y + r * sin(angle)
                if (i == 0) dataPath.moveTo(x, y) else dataPath.lineTo(x, y)
            }
            dataPath.close()
            drawPath(dataPath, color = color.copy(alpha = 0.15f))
            drawPath(dataPath, color = color, style = Stroke(width = 2.5f))

            values.forEachIndexed { i, v ->
                val angle = i * angleStep - PI.toFloat() / 2
                val r = maxRadius * v
                drawCircle(color, radius = 5f, center = Offset(center.x + r * cos(angle), center.y + r * sin(angle)))
            }
        }

        Box(modifier = Modifier.size(240.dp)) {
            val labelRadius = 0.52f
            subjects.forEachIndexed { i, subject ->
                val n = subjects.size
                val angleStep = (2 * PI / n).toFloat()
                val angle = i * angleStep - PI.toFloat() / 2
                val x = (0.5f + labelRadius * cos(angle))
                val y = (0.5f + labelRadius * sin(angle))
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.TopStart)
                        .offset(
                            x = (x * 240).dp - 20.dp,
                            y = (y * 240).dp - 8.dp
                        )
                ) {
                    Text(subject, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                }
            }
        }
    }
}

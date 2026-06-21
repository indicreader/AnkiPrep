package com.example.flashcardapp.ui

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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import java.util.Calendar
import com.example.flashcardapp.data.AnkiDeck
import com.example.flashcardapp.data.entities.SessionRecordEntity
import com.example.flashcardapp.session.StreakCalculator
import com.example.flashcardapp.ui.theme.*

// ─── Badge auto-assignment by card count ──────────────────────────────────────
private fun deckBadge(totalCards: Int): Pair<String, Color> = when {
    totalCards >= 1500 -> "MASTER DECK"  to Color(0xFF1B4332)
    totalCards >= 700  -> "PREP CORE"    to Color(0xFF2D6A4F)
    totalCards >= 200  -> "ELITE SERIES" to Color(0xFF40916C)
    else               -> "STARTER"      to Color(0xFF74C69D)
}

@Composable
fun DashboardTab(
    decks: List<AnkiDeck>,
    cardCount: Int,
    sessionRecords: List<SessionRecordEntity>,
    onSelectDeck: (AnkiDeck) -> Unit,
    onManageDeckClicked: () -> Unit,
    onSettingsClicked: () -> Unit,
    onProfileClicked: () -> Unit
) {
    val currentLanguage by com.example.flashcardapp.data.TranslationManager.currentLanguage.collectAsState()
    val context = androidx.compose.ui.platform.LocalContext.current
    val sharedPrefs = remember { context.getSharedPreferences("AnkiPrepProfile", android.content.Context.MODE_PRIVATE) }
    var avatarUriStr by remember { mutableStateOf(sharedPrefs.getString("avatar_uri", null)) }
    DisposableEffect(sharedPrefs) {
        val listener = android.content.SharedPreferences.OnSharedPreferenceChangeListener { prefs, key ->
            if (key == "avatar_uri") {
                avatarUriStr = prefs.getString("avatar_uri", null)
            }
        }
        sharedPrefs.registerOnSharedPreferenceChangeListener(listener)
        onDispose {
            sharedPrefs.unregisterOnSharedPreferenceChangeListener(listener)
        }
    }
    val avatarUri = remember(avatarUriStr) { avatarUriStr?.let { android.net.Uri.parse(it) } }

    val settingsRepo = remember { com.example.flashcardapp.data.SettingsRepository.getInstance(context) }
    val customOrder = remember { settingsRepo.getDeckOrderList() }
    val sortedDecks = remember(decks, customOrder) {
        val orderMap = customOrder.withIndex().associate { it.value to it.index }
        decks.sortedWith { d1, d2 ->
            val pos1 = orderMap[d1.id] ?: Int.MAX_VALUE
            val pos2 = orderMap[d2.id] ?: Int.MAX_VALUE
            if (pos1 != pos2) pos1.compareTo(pos2) else d1.name.compareTo(d2.name)
        }
    }
    val decks = sortedDecks

    val scrollState = rememberScrollState()

    val streakInfo = remember(sessionRecords) { StreakCalculator.calculate(sessionRecords) }

    val mastery = remember(sessionRecords) {
        val total = sessionRecords.sumOf { it.totalQuestions }
        val correct = sessionRecords.sumOf { it.score }
        if (total > 0) (correct.toFloat() / total * 100) else 0f
    }

    // Weekly bar chart data: sessions per day for last 7 days (index 0 = Mon offset)
    val weeklyData = remember(sessionRecords) {
        val result = IntArray(7) { 0 }
        val cal = Calendar.getInstance()
        val todayMs = System.currentTimeMillis()
        sessionRecords.forEach { r ->
            val diff = ((todayMs - r.timestamp) / 86_400_000L).toInt()
            if (diff in 0..6) {
                // Map to day-of-week index 0=Mon..6=Sun
                cal.timeInMillis = r.timestamp
                val dow = (cal.get(Calendar.DAY_OF_WEEK) + 5) % 7 // Sun=0 → Mon=0
                result[dow] += r.totalQuestions
            }
        }
        result.toList()
    }

    // Next session deck = the deck most recently studied (or first)
    val nextDeck = remember(decks, sessionRecords) {
        if (decks.isEmpty()) null
        else {
            val lastDeckId = sessionRecords.maxByOrNull { it.timestamp }?.deckId
            decks.find { it.id == lastDeckId } ?: decks.first()
        }
    }

    // Per-deck card counts — approximate using total / deck count
    val deckCardCount = remember(cardCount, decks) {
        if (decks.isEmpty()) 0 else (cardCount / decks.size).coerceAtLeast(1)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(scrollState)
                .padding(horizontal = 20.dp)
                .padding(bottom = 70.dp),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            Spacer(Modifier.height(16.dp))

            // ── Header ───────────────────────────────────────────────────────────
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
                            .clickable { onProfileClicked() },
                        contentAlignment = Alignment.Center
                    ) {
                        if (avatarUri != null) {
                            AsyncImage(
                                model = avatarUri,
                                contentDescription = "Profile",
                                modifier = Modifier.fillMaxSize().clip(CircleShape),
                                contentScale = ContentScale.Crop
                            )
                        } else {
                            Icon(Icons.Filled.Person, contentDescription = "Profile", tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(22.dp))
                        }
                    }
                    Text(
                        text = "AnkiPrep",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    // Streak chip
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50))
                            .background(Color(0xFFE8F5EE))
                            .padding(horizontal = 10.dp, vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text("🌿", fontSize = 14.sp)
                        Text(
                            text = "${streakInfo.currentStreak}",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    IconButton(onClick = onSettingsClicked, modifier = Modifier.size(36.dp)) {
                        Icon(Icons.Outlined.Settings, contentDescription = "Settings", tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(20.dp))
                    }
                }
            }

            Spacer(Modifier.height(24.dp))

            // ── Greeting ─────────────────────────────────────────────────────────
            Text(
                text = com.example.flashcardapp.data.TranslationManager.getString("welcome_back"),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = if (streakInfo.currentStreak > 0)
                    com.example.flashcardapp.data.TranslationManager.getString("days_streak").format(streakInfo.currentStreak) + ". " + com.example.flashcardapp.data.TranslationManager.getString("study_today_streak")
                else
                    com.example.flashcardapp.data.TranslationManager.getString("study_today_streak"),
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 20.sp
            )

            Spacer(Modifier.height(24.dp))

            // ── Deck List ─────────────────────────────────────────────────────────
            if (decks.isEmpty()) {
                // Empty state — nudge to import
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp).fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(Icons.Outlined.LibraryBooks, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(32.dp))
                        Text(com.example.flashcardapp.data.TranslationManager.getString("no_decks_yet"), fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                        Text(com.example.flashcardapp.data.TranslationManager.getString("no_decks_yet_desc"), fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            } else {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    nextDeck?.let { deck ->
                        val displayName = deck.name.split("::").last()
                        val perDeckCount = deckCardCount
                        val (badge, badgeColor) = deckBadge(perDeckCount)
                        // Session accuracy for this deck
                        val deckSessions = sessionRecords.filter { it.deckId == deck.id }
                        val deckCorrect = deckSessions.sumOf { it.score }
                        val deckTotal = deckSessions.sumOf { it.totalQuestions }
                        val deckProgress = if (deckTotal > 0) (deckCorrect.toFloat() / deckTotal) else 0f

                        Text(com.example.flashcardapp.data.TranslationManager.getString("last_studied_deck"), fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurfaceVariant, letterSpacing = 1.sp)
                        DeckListCard(
                            name = displayName,
                            badge = badge,
                            badgeColor = badgeColor,
                            progress = deckProgress,
                            cardCount = perDeckCount,
                            onClick = { onSelectDeck(deck) }
                        )
                    }
                }
            }

            Spacer(Modifier.height(28.dp))

            // ── Weekly Progress ───────────────────────────────────────────────────
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(com.example.flashcardapp.data.TranslationManager.getString("weekly_progress"), fontSize = 18.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
                TextButton(onClick = { /* navigate to analytics */ }) {
                    Text(com.example.flashcardapp.data.TranslationManager.getString("stats") + " >", fontSize = 13.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.SemiBold)
                }
            }

            Spacer(Modifier.height(8.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)) {
                    WeeklyBarChart(data = weeklyData)
                }
            }

            Spacer(Modifier.height(20.dp))

            // ── Next Session dark card ────────────────────────────────────────────
            if (nextDeck != null) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(20.dp)
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(
                            com.example.flashcardapp.data.TranslationManager.getString("next_session").uppercase(),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.5.sp,
                            color = Color.White.copy(alpha = 0.7f)
                        )
                        Text(
                            text = nextDeck.name.split("::").last(),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        val dueSessions = sessionRecords.filter { it.deckId == nextDeck.id }
                        val dueCount = (deckCardCount - dueSessions.sumOf { it.totalQuestions }).coerceAtLeast(0)
                        Text(
                            text = com.example.flashcardapp.data.TranslationManager.getString("cards_due_for_review").format(dueCount),
                            fontSize = 13.sp,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                        Spacer(Modifier.height(8.dp))
                        Button(
                            onClick = { onSelectDeck(nextDeck) },
                            shape = RoundedCornerShape(50),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                                contentColor = MaterialTheme.colorScheme.primary
                            ),
                            modifier = Modifier.height(40.dp)
                        ) {
                            Text(com.example.flashcardapp.data.TranslationManager.getString("resume_study"), fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        }
                    }
                }
            }

            Spacer(Modifier.height(100.dp))
        }

        // Anchored Bottom Adaptive AdMob Banner with content divider
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
        ) {
            HorizontalDivider(
                color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.6f),
                thickness = 1.dp
            )
            AdBanner(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )
        }
    }
}

// ─── Deck List Card ───────────────────────────────────────────────────────────
@Composable
private fun DeckListCard(
    name: String,
    badge: String,
    badgeColor: Color,
    progress: Float,
    cardCount: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Left icon
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Outlined.LibraryBooks,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(22.dp)
                )
            }

            // Middle: name + badge + progress
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(
                        text = name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f, fill = false)
                    )
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(badgeColor)
                            .padding(horizontal = 5.dp, vertical = 2.dp)
                    ) {
                        Text(badge, fontSize = 8.sp, fontWeight = FontWeight.Bold, color = Color.White, letterSpacing = 0.5.sp)
                    }
                }
                // Progress bar + percentage
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    LinearProgressIndicator(
                        progress = { progress },
                        modifier = Modifier.weight(1f).height(5.dp).clip(RoundedCornerShape(3.dp)),
                        color = MaterialTheme.colorScheme.primary,
                        trackColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
                    )
                    Text(
                        text = "${(progress * 100).toInt()}%",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            // Right: card count
            Text(
                text = "$cardCount\nCards",
                fontSize = 11.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontWeight = FontWeight.Medium,
                lineHeight = 14.sp
            )
        }
    }
}

// ─── Weekly Bar Chart ─────────────────────────────────────────────────────────
@Composable
private fun WeeklyBarChart(data: List<Int>) {
    val primary = MaterialTheme.colorScheme.primary
    val primaryLight = primary.copy(alpha = 0.3f)
    val maxVal = (data.maxOrNull() ?: 1).coerceAtLeast(1)
    val labels = listOf("M", "T", "W", "T", "F", "S", "S")

    // Today index
    val cal = Calendar.getInstance()
    val todayDow = (cal.get(Calendar.DAY_OF_WEEK) + 5) % 7 // 0=Mon..6=Sun

    Column {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        ) {
            val barCount = data.size
            val barWidth = size.width / (barCount * 1.8f)
            val spacing = (size.width - barWidth * barCount) / (barCount + 1)

            data.forEachIndexed { idx, value ->
                val fraction = value.toFloat() / maxVal
                val barHeight = size.height * fraction.coerceIn(0.05f, 1f)
                val x = spacing + idx * (barWidth + spacing)
                val isToday = idx == todayDow
                val color = if (isToday || value > 0) primary else primaryLight

                drawRoundRect(
                    color = color,
                    topLeft = Offset(x, size.height - barHeight),
                    size = androidx.compose.ui.geometry.Size(barWidth, barHeight),
                    cornerRadius = androidx.compose.ui.geometry.CornerRadius(barWidth / 3)
                )
            }
        }
        Spacer(Modifier.height(6.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            labels.forEachIndexed { idx, label ->
                val cal2 = Calendar.getInstance()
                val isToday2 = idx == ((cal2.get(Calendar.DAY_OF_WEEK) + 5) % 7)
                Text(
                    text = label,
                    fontSize = 11.sp,
                    color = if (isToday2) primary else MaterialTheme.colorScheme.onSurfaceVariant,
                    fontWeight = if (isToday2) FontWeight.Bold else FontWeight.Normal
                )
            }
        }
    }
}

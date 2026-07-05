package com.example.flashcardapp.ui

import android.content.Context
// Removed duplicate import
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.content.Intent
import android.net.Uri
import org.json.JSONArray
import org.json.JSONObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import coil.compose.AsyncImage
import com.example.flashcardapp.data.entities.SessionRecordEntity
import com.example.flashcardapp.session.StreakCalculator
import com.example.flashcardapp.ui.theme.*

// Helper modifier to rotate text vertically without clipping issues
fun Modifier.rotateVertically(clockwise: Boolean = false): Modifier = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    layout(placeable.height, placeable.width) {
        placeable.placeWithLayer(
            x = if (clockwise) placeable.height else 0,
            y = if (clockwise) 0 else placeable.width,
            layerBlock = {
                rotationZ = if (clockwise) 90f else -90f
            }
        )
    }
}

data class ExamItem(val name: String, val url: String)

 data class Opportunity(
    val title: String,
    val matchPercentage: Int,
    val labelText: String, // PRIMARY TARGET, ELIGIBLE, BACKUP, TOP CHOICE
    val labelColor: Color,
    val subtitle: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val buttonText: String? = null,
    val showProgress: Boolean = false,
    val progress: Float = 0f
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTab(
    sessionRecords: List<SessionRecordEntity>,
    cardCount: Int,
    onBackPressed: () -> Unit
) {
    val context = LocalContext.current
    val sharedPrefs = remember { context.getSharedPreferences("AnkiPrepProfile", Context.MODE_PRIVATE) }

    var profileName by remember { mutableStateOf(sharedPrefs.getString("profile_name", "Aaryan Sharma") ?: "Aaryan Sharma") }
    var profileGoal by remember { mutableStateOf(sharedPrefs.getString("profile_goal", "Civil Services") ?: "Civil Services") }
    var profileDegree by remember { mutableStateOf(sharedPrefs.getString("profile_degree", "B.Com Graduate") ?: "B.Com Graduate") }
    var profileRank by remember { mutableStateOf(sharedPrefs.getString("profile_rank", "Master Rank") ?: "Master Rank") }
    var profileAge by remember { mutableStateOf(sharedPrefs.getInt("profile_age", 21)) }
    var profileBio by remember { mutableStateOf(sharedPrefs.getString("profile_bio", "Mastering Indian Polity & Ethics for the upcoming UPSC cycle. Focused on high-density information retrieval and consistent mock performance.") ?: "Mastering Indian Polity & Ethics for the upcoming UPSC cycle. Focused on high-density information retrieval and consistent mock performance.") }
    
    val streakInfo = remember(sessionRecords) { com.example.flashcardapp.session.StreakCalculator.calculate(sessionRecords) }
    val currentStreak = streakInfo.currentStreak

    var exams by remember {
        mutableStateOf<List<ExamItem>>(
            sharedPrefs.getString("saved_exams", null)?.let { json ->
                val list = mutableListOf<ExamItem>()
                val array = JSONArray(json)
                for (i in 0 until array.length()) {
                    val obj = array.getJSONObject(i)
                    list.add(ExamItem(obj.getString("name"), obj.getString("url")))
                }
                list.ifEmpty { null }
            } ?: listOf(
                ExamItem("UPSC CSE", "https://www.upsc.gov.in/whats-new"),
                ExamItem("State PSC", "https://www.upsc.gov.in/whats-new")
            ).also { defaultList ->
                val jsonArray = JSONArray()
                defaultList.forEach { jsonArray.put(JSONObject().put("name", it.name).put("url", it.url)) }
                sharedPrefs.edit().putString("saved_exams", jsonArray.toString()).apply()
            }
        )
    }

    val specialistInfo = remember(sessionRecords) {
        if (sessionRecords.isEmpty()) {
            "Polity Specialist" to "Practice more quizzes to determine your specialty."
        } else {
            val deckCorrect = mutableMapOf<String, Int>()
            val deckTotal = mutableMapOf<String, Int>()
            sessionRecords.forEach { record ->
                deckCorrect[record.deckName] = (deckCorrect[record.deckName] ?: 0) + record.score
                deckTotal[record.deckName] = (deckTotal[record.deckName] ?: 0) + record.totalQuestions
            }
            var bestDeck = ""
            var bestAccuracy = 0f
            deckTotal.forEach { (deckName, total) ->
                if (total > 0) {
                    val correct = deckCorrect[deckName] ?: 0
                    val acc = correct.toFloat() / total.toFloat()
                    if (acc > bestAccuracy) {
                        bestAccuracy = acc
                        bestDeck = deckName
                    }
                }
            }
            if (bestDeck.isNotEmpty()) {
                "$bestDeck Specialist" to "Your highest accuracy is ${(bestAccuracy * 100).toInt()}% in this area."
            } else {
                "Aspirant Specialist" to "High performance in mock tests."
            }
        }
    }

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
    val avatarUri = remember(avatarUriStr) { avatarUriStr?.let { Uri.parse(it) } }

    var showEditDialog by remember { mutableStateOf(false) }
    var showAddExamDialog by remember { mutableStateOf(false) }
    var editingOpp by remember { mutableStateOf<Opportunity?>(null) }
    var recommendationsVersion by remember { mutableStateOf(0) }
    var examsVersion by remember { mutableStateOf(0) }

    LaunchedEffect(exams) {
        withContext(Dispatchers.IO) {
            for (exam in exams) {
                try {
                    val urlConnection = java.net.URL(exam.url).openConnection() as java.net.HttpURLConnection
                    urlConnection.connectTimeout = 5000
                    urlConnection.readTimeout = 5000
                    val html = urlConnection.inputStream.bufferedReader().use { it.readText() }
                    val newHash = html.hashCode().toString()
                    val cachedHash = sharedPrefs.getString("exam_hash_${exam.url}", null)
                    if (cachedHash != null && cachedHash != newHash) {
                        sharedPrefs.edit()
                            .putString("exam_hash_${exam.url}", newHash)
                            .putBoolean("exam_has_delta_${exam.url}", true)
                            .apply()
                        
                        // Trigger native push notification
                        showExamNotification(context, exam.name)
                    } else if (cachedHash == null) {
                        sharedPrefs.edit()
                            .putString("exam_hash_${exam.url}", newHash)
                            .apply()
                    }
                } catch (e: Exception) {
                    // Ignore background network/connection failures gracefully
                }
            }
        }
        examsVersion++
    }

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

    // Dynamic suggestions based on user criteria inputs
    val recommendations = remember(profileAge, profileDegree, profileGoal, recommendationsVersion) {
        val defaultList = when (profileGoal) {
            "Civil Services" -> listOf(
                Opportunity("UPSC Civil Services", 99, "PRIMARY TARGET", Color(0xFF1A237E), "Administrative, Police, and Foreign services.", Icons.Outlined.CheckCircle, showProgress = true, progress = 0.42f),
                Opportunity("SSC CGL", if (profileDegree.contains("Graduate")) 85 else 45, "ELIGIBLE", Color(0xFF6A1B9A), if (profileDegree.contains("Graduate")) "Group B & C posts. Graduation requirement met." else "Requires Graduation degree.", Icons.Outlined.School, "Apply Now"),
                Opportunity("IBPS PO", if (profileDegree == "B.Com Graduate") 72 else 60, "BACKUP", Color(0xFF37474F), if (profileDegree == "B.Com Graduate") "Probationary Officer. Suits Commerce background." else "Probationary Officer in public sector banks.", Icons.Outlined.AccountBalance, "View Details"),
                Opportunity("State PCS", 94, "TOP CHOICE", Color(0xFF3F51B5), "State level administrative services. Highly compatible.", Icons.Outlined.Star, "Explore State S&T")
            )
            "Banking" -> listOf(
                Opportunity("IBPS PO", if (profileDegree == "B.Com Graduate") 95 else 80, "PRIMARY TARGET", Color(0xFF1A237E), "Suits Commerce background. Officer scale recruitments.", Icons.Outlined.AccountBalance, "Apply Now"),
                Opportunity("SBI PO", if (profileDegree.contains("Graduate")) 92 else 70, "TOP CHOICE", Color(0xFF3F51B5), "State Bank of India probationary officer role.", Icons.Outlined.CheckCircle, "View Details"),
                Opportunity("SSC CGL", 75, "ELIGIBLE", Color(0xFF6A1B9A), "Graduate level posts in govt departments.", Icons.Outlined.School, "Explore Posts")
            )
            else -> listOf(
                Opportunity("SSC CGL", if (profileDegree.contains("Graduate")) 96 else 50, "PRIMARY TARGET", Color(0xFF1A237E), "Staff Selection Commission Combined Graduate Level.", Icons.Outlined.School, "Apply Now"),
                Opportunity("SSC CHSL", 90, "ELIGIBLE", Color(0xFF6A1B9A), "12th Pass requirement. Highly compatible.", Icons.Outlined.CheckCircle, "Apply Now"),
                Opportunity("Railway RRB NTPC", 82, "TOP CHOICE", Color(0xFF3F51B5), "Non-Technical Popular Categories recruitment.", Icons.Outlined.Star, "View Openings")
            )
        }

        defaultList.mapNotNull { opp ->
            val isDeleted = sharedPrefs.getBoolean("opportunity_deleted_${profileGoal}_${opp.title}", false)
            if (isDeleted) return@mapNotNull null
            
            val customTitle = sharedPrefs.getString("opportunity_title_override_${profileGoal}_${opp.title}", opp.title) ?: opp.title
            val customSubtitle = sharedPrefs.getString("opportunity_subtitle_override_${profileGoal}_${opp.title}", opp.subtitle) ?: opp.subtitle
            val customMatch = sharedPrefs.getInt("opportunity_match_override_${profileGoal}_${opp.title}", opp.matchPercentage)
            val customProgress = sharedPrefs.getFloat("opportunity_progress_override_${profileGoal}_${opp.title}", opp.progress)
            val customLabel = sharedPrefs.getString("opportunity_label_override_${profileGoal}_${opp.title}", opp.labelText) ?: opp.labelText
            val customShowProgress = sharedPrefs.getBoolean("opportunity_show_progress_override_${profileGoal}_${opp.title}", opp.showProgress)
            val customColorHex = sharedPrefs.getString("opportunity_color_override_${profileGoal}_${opp.title}", null)
            val customColor = if (customColorHex != null) {
                try { Color(android.graphics.Color.parseColor(customColorHex)) } catch (e: Exception) { opp.labelColor }
            } else opp.labelColor

            opp.copy(
                title = customTitle,
                subtitle = customSubtitle,
                matchPercentage = customMatch,
                progress = customProgress,
                labelText = customLabel,
                showProgress = customShowProgress,
                labelColor = customColor
            )
        }
    }

    if (showAddExamDialog) {
        var examName by remember { mutableStateOf("") }
        var examUrl by remember { mutableStateOf("") }
        AlertDialog(
            onDismissRequest = { showAddExamDialog = false },
            title = { Text("Add Exam Link") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(value = examName, onValueChange = { examName = it }, label = { Text("Exam Name") })
                    OutlinedTextField(value = examUrl, onValueChange = { examUrl = it }, label = { Text("URL") })
                }
            },
            confirmButton = {
                Button(onClick = {
                    val newExams = exams + ExamItem(examName, examUrl)
                    exams = newExams
                    val jsonArray = JSONArray()
                    newExams.forEach { jsonArray.put(JSONObject().put("name", it.name).put("url", it.url)) }
                    sharedPrefs.edit().putString("saved_exams", jsonArray.toString()).apply()
                    showAddExamDialog = false
                }) { Text("Save") }
            }
        )
    }

    if (showEditDialog) {
        var tempName by remember { mutableStateOf(profileName) }
        var tempAge by remember { mutableStateOf(profileAge.toString()) }
        var tempDegree by remember { mutableStateOf(profileDegree) }
        var tempGoal by remember { mutableStateOf(profileGoal) }
        var tempRank by remember { mutableStateOf(profileRank) }
        var tempBio by remember { mutableStateOf(profileBio) }

        var degreeExpanded by remember { mutableStateOf(false) }
        var goalExpanded by remember { mutableStateOf(false) }

        AlertDialog(
            onDismissRequest = { showEditDialog = false },
            title = { Text("Edit Profile & Career Criteria", fontWeight = FontWeight.Bold) },
            text = {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedTextField(
                        value = tempName,
                        onValueChange = { tempName = it },
                        label = { Text("Name") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = tempAge,
                        onValueChange = { tempAge = it },
                        label = { Text("Age") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = tempRank,
                        onValueChange = { tempRank = it },
                        label = { Text("Rank") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    
                    Box(modifier = Modifier.fillMaxWidth()) {
                        OutlinedButton(
                            onClick = { degreeExpanded = true },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                                Text("Degree: $tempDegree", color = MaterialTheme.colorScheme.onSurface)
                                Icon(Icons.Filled.ArrowDropDown, null)
                            }
                        }
                        DropdownMenu(expanded = degreeExpanded, onDismissRequest = { degreeExpanded = false }) {
                            listOf("B.Com Graduate", "B.Sc Graduate", "B.Tech Graduate", "12th Pass", "Post Graduate").forEach { deg ->
                                DropdownMenuItem(text = { Text(deg) }, onClick = {
                                    tempDegree = deg
                                    degreeExpanded = false
                                })
                            }
                        }
                    }

                    Box(modifier = Modifier.fillMaxWidth()) {
                        OutlinedButton(
                            onClick = { goalExpanded = true },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                                Text("Target: $tempGoal", color = MaterialTheme.colorScheme.onSurface)
                                Icon(Icons.Filled.ArrowDropDown, null)
                            }
                        }
                        DropdownMenu(expanded = goalExpanded, onDismissRequest = { goalExpanded = false }) {
                            listOf("Civil Services", "Banking", "SSC").forEach { target ->
                                DropdownMenuItem(text = { Text(target) }, onClick = {
                                    tempGoal = target
                                    goalExpanded = false
                                })
                            }
                        }
                    }

                    OutlinedTextField(
                        value = tempBio,
                        onValueChange = { tempBio = it },
                        label = { Text("Bio / Goal Statement") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        profileName = tempName
                        profileAge = tempAge.toIntOrNull() ?: profileAge
                        profileDegree = tempDegree
                        profileGoal = tempGoal
                        profileRank = tempRank
                        profileBio = tempBio
                        
                        sharedPrefs.edit()
                            .putString("profile_name", tempName)
                            .putInt("profile_age", tempAge.toIntOrNull() ?: profileAge)
                            .putString("profile_degree", tempDegree)
                            .putString("profile_goal", tempGoal)
                            .putString("profile_rank", tempRank)
                            .putString("profile_bio", tempBio)
                            .apply()

                        showEditDialog = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text("Save", color = Color.White)
                }
            },
            dismissButton = {
                TextButton(onClick = { showEditDialog = false }) {
                    Text("Cancel")
                }
            }
        )
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
                IconButton(onClick = onBackPressed) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = MaterialTheme.colorScheme.primary)
                }
                Text(
                    "Profile & Career",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                IconButton(onClick = { showEditDialog = true }) {
                    Icon(Icons.Filled.Settings, contentDescription = "Settings", tint = MaterialTheme.colorScheme.primary)
                }
            }

            // ── Top Card (User details) ───────────────────────────────────────
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.BottomEnd,
                        modifier = Modifier.clickable { photoPickerLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)) }
                    ) {
                        Box(
                            modifier = Modifier
                                .size(96.dp)
                                .clip(CircleShape)
                                .border(3.dp, MaterialTheme.colorScheme.primary, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            if (avatarUri != null) {
                                AsyncImage(model = avatarUri, contentDescription = "Avatar", modifier = Modifier.fillMaxSize().clip(CircleShape), contentScale = ContentScale.Crop)
                            } else {
                                Icon(Icons.Filled.Person, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(48.dp))
                            }
                        }
                        Box(
                            modifier = Modifier
                                .size(28.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary)
                                .border(2.dp, Color.White, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Filled.Edit, contentDescription = "Edit", tint = Color.White, modifier = Modifier.size(14.dp))
                        }
                    }

                    Text(profileName, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.clickable { showEditDialog = true }
                    ) {
                        CriteriaTag(text = "Age: $profileAge")
                        CriteriaTag(text = profileDegree)
                        CriteriaTag(text = "Rank: $profileRank")
                    }
                    Box(modifier = Modifier.clickable { showEditDialog = true }) {
                        TargetTag(text = "Target: $profileGoal")
                    }

                    Text(
                        text = profileBio,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center,
                        lineHeight = 20.sp,
                        modifier = Modifier.padding(horizontal = 4.dp)
                    )
                }
            }

            // ── Exam Journey Progress ─────────────────────────────────────────
            Text("Exam Journey Progress", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.15f)),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Row(
                    modifier = Modifier.padding(20.dp).fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Box(
                            modifier = Modifier.size(36.dp).clip(CircleShape).background(MaterialTheme.colorScheme.primary),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Filled.Check, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
                        }
                        Text("Graduation", fontSize = 13.sp, fontWeight = FontWeight.Bold)
                        Text("COMPLETED", fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                    Box(modifier = Modifier.width(60.dp).height(2.dp).background(MaterialTheme.colorScheme.primary))
                    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Box(
                            modifier = Modifier.size(36.dp).clip(CircleShape).background(MaterialTheme.colorScheme.primary),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Filled.OutlinedFlag, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
                        }
                        Text("Foundation", fontSize = 13.sp, fontWeight = FontWeight.Bold)
                        Text("CURRENT PHASE", fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }

            // ── Recommended for You ───────────────────────────────────────────
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Recommended for You", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable { showEditDialog = true }
                ) {
                    Text("View All Opportunities", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.width(4.dp))
                    Icon(Icons.Outlined.ArrowForward, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(14.dp))
                }
            }

            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                recommendations.forEach { opt ->
                    OpportunityCard(opp = opt, onClick = { editingOpp = opt })
                }
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F0FE)),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                    Box(modifier = Modifier.size(44.dp).clip(CircleShape).background(Color(0xFFD2E3FC)), contentAlignment = Alignment.Center) {
                        Icon(Icons.Outlined.LocalFireDepartment, contentDescription = null, tint = Color(0xFF1A73E8), modifier = Modifier.size(22.dp))
                    }
                    Column {
                        Text("${currentStreak} Day Streak", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1A73E8))
                        Text("Active days: ${streakInfo.activeDaysLast30} of the last 30 days.", fontSize = 12.sp, color = Color(0xFF5F6368))
                    }
                }
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF3E5F5)),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                    Box(modifier = Modifier.size(44.dp).clip(CircleShape).background(Color(0xFFE1BEE7)), contentAlignment = Alignment.Center) {
                        Icon(Icons.Outlined.Psychology, contentDescription = null, tint = Color(0xFF8E24AA), modifier = Modifier.size(22.dp))
                    }
                    Column {
                        Text(specialistInfo.first, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF8E24AA))
                        Text(specialistInfo.second, fontSize = 12.sp, color = Color(0xFF7B1FA2))
                    }
                }
            }

            Spacer(Modifier.height(24.dp))
            // Manual Exam Links Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Official Exam Trackers", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
                OutlinedButton(onClick = { showAddExamDialog = true }) {
                    Text("Add Exam")
                }
            }
            Column(
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val triggerRecompose = examsVersion // Read to recompose dynamically on state change
                exams.forEach { exam ->
                    val hasDelta = sharedPrefs.getBoolean("exam_has_delta_${exam.url}", false)
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextButton(
                            onClick = {
                                sharedPrefs.edit().putBoolean("exam_has_delta_${exam.url}", false).apply()
                                examsVersion++
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(exam.url))
                                context.startActivity(intent)
                            }
                        ) {
                            Text(exam.name, color = MaterialTheme.colorScheme.primary)
                        }
                        if (hasDelta) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .clip(CircleShape)
                                    .background(Color.Red)
                            )
                        }
                    }
                }
            }
            Spacer(Modifier.height(100.dp))
        }
    }

    if (editingOpp != null) {
        val opp = editingOpp!!
        var title by remember { mutableStateOf(opp.title) }
        var subtitle by remember { mutableStateOf(opp.subtitle) }
        var matchPercentage by remember { mutableStateOf(opp.matchPercentage) }
        var labelText by remember { mutableStateOf(opp.labelText) }
        var progressPercent by remember { mutableStateOf((opp.progress * 100).toInt()) }
        var showProgress by remember { mutableStateOf(opp.showProgress) }
        var selectedColorHex by remember { 
            mutableStateOf(String.format("#%06X", 0xFFFFFF and opp.labelColor.toArgb())) 
        }

        val colorsList = listOf(
            "#1A237E" to "Indigo",
            "#6A1B9A" to "Purple",
            "#004D40" to "Teal",
            "#C62828" to "Red",
            "#2E7D32" to "Green",
            "#EF6C00" to "Orange",
            "#37474F" to "Slate",
            "#3F51B5" to "Blue"
        )

        AlertDialog(
            onDismissRequest = { editingOpp = null },
            title = { Text("Edit Opportunity") },
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedTextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text("Title") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = subtitle,
                        onValueChange = { subtitle = it },
                        label = { Text("Subtitle") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = labelText,
                        onValueChange = { labelText = it },
                        label = { Text("Status Label") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Match: $matchPercentage%", style = MaterialTheme.typography.bodyMedium)
                        Slider(
                            value = matchPercentage.toFloat(),
                            onValueChange = { matchPercentage = it.toInt() },
                            valueRange = 0f..100f,
                            modifier = Modifier.weight(1f).padding(start = 16.dp)
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Show Progress Bar", style = MaterialTheme.typography.bodyMedium)
                        Switch(
                            checked = showProgress,
                            onCheckedChange = { showProgress = it }
                        )
                    }

                    if (showProgress) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Progress: $progressPercent%", style = MaterialTheme.typography.bodyMedium)
                            Slider(
                                value = progressPercent.toFloat(),
                                onValueChange = { progressPercent = it.toInt() },
                                valueRange = 0f..100f,
                                modifier = Modifier.weight(1f).padding(start = 16.dp)
                            )
                        }
                    }

                    Text("Theme Color", style = MaterialTheme.typography.titleSmall)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        colorsList.forEach { (hex, name) ->
                            val color = Color(android.graphics.Color.parseColor(hex))
                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(CircleShape)
                                    .background(color)
                                    .border(
                                        width = if (selectedColorHex.equals(hex, ignoreCase = true)) 3.dp else 1.dp,
                                        color = if (selectedColorHex.equals(hex, ignoreCase = true)) MaterialTheme.colorScheme.primary else Color.LightGray,
                                        shape = CircleShape
                                    )
                                    .clickable { selectedColorHex = hex }
                            )
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        sharedPrefs.edit().apply {
                            putString("opportunity_title_override_${profileGoal}_${opp.title}", title)
                            putString("opportunity_subtitle_override_${profileGoal}_${opp.title}", subtitle)
                            putInt("opportunity_match_override_${profileGoal}_${opp.title}", matchPercentage)
                            putFloat("opportunity_progress_override_${profileGoal}_${opp.title}", progressPercent / 100f)
                            putString("opportunity_label_override_${profileGoal}_${opp.title}", labelText)
                            putBoolean("opportunity_show_progress_override_${profileGoal}_${opp.title}", showProgress)
                            putString("opportunity_color_override_${profileGoal}_${opp.title}", selectedColorHex)
                            apply()
                        }
                        recommendationsVersion++
                        editingOpp = null
                    }
                ) {
                    Text("Save")
                }
            },
            dismissButton = {
                Row {
                    TextButton(
                        onClick = {
                            sharedPrefs.edit().apply {
                                putBoolean("opportunity_deleted_${profileGoal}_${opp.title}", true)
                                apply()
                            }
                            recommendationsVersion++
                            editingOpp = null
                        }
                    ) {
                        Text("Delete", color = MaterialTheme.colorScheme.error)
                    }
                    Spacer(Modifier.width(8.dp))
                    TextButton(onClick = { editingOpp = null }) {
                        Text("Cancel")
                    }
                }
            }
        )
    }
}

@Composable
private fun CriteriaTag(text: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFEDE7F6))
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(text, fontSize = 12.sp, color = Color(0xFF5E35B1), fontWeight = FontWeight.Medium)
    }
}

@Composable
private fun TargetTag(text: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFE8EAF6))
            .padding(horizontal = 16.dp, vertical = 6.dp)
    ) {
        Text(text, fontSize = 12.sp, color = Color(0xFF1A237E), fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun OpportunityCard(opp: Opportunity, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(32.dp)
                    .fillMaxHeight()
                    .background(opp.labelColor),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = opp.labelText,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .rotateVertically(clockwise = false)
                        .padding(vertical = 4.dp),
                    textAlign = TextAlign.Center,
                    maxLines = 1
                )
            }

            Column(
                modifier = Modifier.padding(16.dp).weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(opp.labelColor.copy(alpha = 0.1f))
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text("MATCH ${opp.matchPercentage}%", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = opp.labelColor)
                        }
                        Text(opp.title, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                    }
                    Icon(opp.icon, contentDescription = null, tint = opp.labelColor, modifier = Modifier.size(18.dp))
                }

                Text(opp.subtitle, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)

                if (opp.showProgress) {
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text("Syllabus Mastery", fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            Text("${(opp.progress * 100).toInt()}%", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = opp.labelColor)
                        }
                        LinearProgressIndicator(
                            progress = { opp.progress },
                            modifier = Modifier.fillMaxWidth().height(6.dp).clip(RoundedCornerShape(50)),
                            color = opp.labelColor,
                            trackColor = opp.labelColor.copy(alpha = 0.1f)
                        )
                    }
                }

                if (opp.buttonText != null) {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.fillMaxWidth().height(38.dp)
                    ) {
                        Text(opp.buttonText, color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

fun showExamNotification(context: Context, examName: String) {
    val channelId = "exam_updates_channel"
    val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as android.app.NotificationManager
    
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
        val channel = android.app.NotificationChannel(
            channelId,
            "Exam Tracker Updates",
            android.app.NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = "Channel for exam update alerts"
        }
        notificationManager.createNotificationChannel(channel)
    }
    
    val builder = androidx.core.app.NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_dialog_info)
        .setContentTitle("Official Exam Tracker Alert")
        .setContentText("New announcement detected on: $examName")
        .setPriority(androidx.core.app.NotificationCompat.PRIORITY_DEFAULT)
        .setAutoCancel(true)
        
    notificationManager.notify(examName.hashCode(), builder.build())
}


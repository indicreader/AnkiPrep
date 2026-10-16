package com.example.flashcardapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

// =========================================================================
// GOOGLE ADMOB BANNER CONFIGURATION
// Replace with your actual Banner Ad Unit ID when ready for production.
// Test Banner ID is: "ca-app-pub-3940256099942544/6300978111"
// =========================================================================
const val ADMOB_BANNER_AD_UNIT_ID = "ca-app-pub-6846875306917122/8983203604"

@Composable
fun AdBanner(modifier: Modifier = Modifier, text: String = "Advertisement") {
    // Advertisement module disabled until app is fully functional
    Spacer(modifier = modifier.height(0.dp))
}


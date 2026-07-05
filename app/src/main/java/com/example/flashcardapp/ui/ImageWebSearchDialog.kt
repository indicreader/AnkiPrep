package com.example.flashcardapp.ui

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.webkit.JavascriptInterface
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.AsyncImage
import com.example.flashcardapp.data.ImageStorageManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URLEncoder

// ─── Stages ──────────────────────────────────────────────────────────────────
private enum class SearchStage { SEARCH, PREVIEW, SAVING }

// ─── JS Bridge ───────────────────────────────────────────────────────────────
/** Receives the captured image URL from JavaScript running inside the WebView. */
class ImageCaptureBridge(private val onImageCaptured: (String) -> Unit) {
    @JavascriptInterface
    fun onImageSelected(url: String) {
        if (url.isNotBlank()) onImageCaptured(url)
    }
}

// ─── Main Dialog ─────────────────────────────────────────────────────────────
/**
 * Full-screen dialog that:
 * 1. Shows a search bar pre-filled with [initialQuery]
 * 2. Loads Google Images in a WebView; JS injection intercepts long-press to capture the image URL
 * 3. Shows a preview of the captured image for confirmation
 * 4. Downloads & saves the image locally, then calls [onImageSelected] with the relative path
 */
@SuppressLint("SetJavaScriptEnabled")
@Composable
fun ImageWebSearchDialog(
    initialQuery: String = "",
    onDismiss: () -> Unit,
    onImageSelected: (relativePath: String) -> Unit
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    var stage by remember { mutableStateOf(SearchStage.SEARCH) }
    var queryText by remember { mutableStateOf(initialQuery) }
    var capturedUrl by remember { mutableStateOf<String?>(null) }
    var saveError by remember { mutableStateOf<String?>(null) }

    // Holds a reference to the WebView so we can control it from Compose
    var webViewRef by remember { mutableStateOf<WebView?>(null) }

    // JS that injects a long-press listener on every <img> element
    val jsInjection = """
        (function() {
            function attachListeners() {
                document.querySelectorAll('img').forEach(function(img) {
                    if (img.dataset.ankiprepAttached) return;
                    img.dataset.ankiprepAttached = 'true';
                    img.addEventListener('contextmenu', function(e) {
                        e.preventDefault();
                        var src = img.src || img.getAttribute('data-src') || img.getAttribute('data-iurl') || '';
                        if (src && src.startsWith('http')) {
                            Android.onImageSelected(src);
                        }
                    });
                    // Also handle touchstart + hold (500ms) for mobile long-press
                    var timer;
                    img.addEventListener('touchstart', function(e) {
                        timer = setTimeout(function() {
                            var src = img.src || img.getAttribute('data-src') || img.getAttribute('data-iurl') || '';
                            if (src && src.startsWith('http')) {
                                Android.onImageSelected(src);
                            }
                        }, 600);
                    });
                    img.addEventListener('touchend', function() { clearTimeout(timer); });
                    img.addEventListener('touchmove', function() { clearTimeout(timer); });
                });
            }
            attachListeners();
            // Re-attach when new images are lazily loaded
            var observer = new MutationObserver(function() { attachListeners(); });
            observer.observe(document.body, { childList: true, subtree: true });
        })();
    """.trimIndent()

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            dismissOnBackPress = true,
            dismissOnClickOutside = false
        )
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(modifier = Modifier.fillMaxSize()) {

                // ── Top Bar ──────────────────────────────────────────────────
                Surface(
                    tonalElevation = 3.dp,
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        IconButton(onClick = {
                            when (stage) {
                                SearchStage.PREVIEW -> { stage = SearchStage.SEARCH; capturedUrl = null }
                                SearchStage.SAVING -> { /* block back while saving */ }
                                SearchStage.SEARCH -> onDismiss()
                            }
                        }) {
                            Icon(Icons.Outlined.ArrowBack, contentDescription = "Back")
                        }

                        if (stage == SearchStage.SEARCH) {
                            OutlinedTextField(
                                value = queryText,
                                onValueChange = { queryText = it },
                                modifier = Modifier.weight(1f),
                                placeholder = { Text("Search for an image…") },
                                singleLine = true,
                                trailingIcon = {
                                    IconButton(onClick = {
                                        val encoded = URLEncoder.encode(queryText, "UTF-8")
                                        val url = "https://www.google.com/search?tbm=isch&safe=active&q=$encoded"
                                        webViewRef?.loadUrl(url)
                                    }) {
                                        Icon(Icons.Outlined.Search, contentDescription = "Search")
                                    }
                                }
                            )
                        } else {
                            Text(
                                text = if (stage == SearchStage.PREVIEW) "Preview — long-press or hold to select"
                                       else "Saving image…",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }

                // ── Body ─────────────────────────────────────────────────────
                Box(modifier = Modifier.weight(1f)) {

                    // Always keep the WebView mounted (just hidden in preview/saving stages)
                    // so the user can go back without reloading.
                    AndroidView(
                        modifier = Modifier
                            .fillMaxSize()
                            .then(if (stage != SearchStage.SEARCH) Modifier.size(0.dp) else Modifier),
                        factory = { ctx ->
                            WebView(ctx).apply {
                                settings.apply {
                                    javaScriptEnabled = true
                                    domStorageEnabled = true
                                    loadWithOverviewMode = true
                                    useWideViewPort = true
                                    builtInZoomControls = true
                                    displayZoomControls = false
                                    mixedContentMode = WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE
                                }
                                webViewClient = object : WebViewClient() {
                                    override fun shouldOverrideUrlLoading(
                                        view: WebView, request: WebResourceRequest
                                    ): Boolean {
                                        // Stay within the WebView — don't open external browser
                                        view.loadUrl(request.url.toString())
                                        return true
                                    }

                                    override fun onPageFinished(view: WebView, url: String?) {
                                        view.evaluateJavascript(jsInjection, null)
                                    }
                                }
                                addJavascriptInterface(
                                    ImageCaptureBridge { url ->
                                        // Called on a background thread from JS bridge
                                        capturedUrl = url
                                        stage = SearchStage.PREVIEW
                                    },
                                    "Android"
                                )
                                val encoded = URLEncoder.encode(initialQuery.ifBlank { "educational diagram" }, "UTF-8")
                                loadUrl("https://www.google.com/search?tbm=isch&safe=active&q=$encoded")
                                webViewRef = this
                            }
                        },
                        update = { webViewRef = it }
                    )

                    // ── Preview Stage ─────────────────────────────────────────
                    if (stage == SearchStage.PREVIEW || stage == SearchStage.SAVING) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colorScheme.background)
                                .padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Spacer(Modifier.height(8.dp))

                            Text(
                                "Selected Image",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold
                            )

                            if (capturedUrl != null) {
                                AsyncImage(
                                    model = capturedUrl,
                                    contentDescription = "Selected image preview",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .weight(1f)
                                        .clip(RoundedCornerShape(16.dp)),
                                    contentScale = ContentScale.Fit
                                )
                            }

                            saveError?.let { err ->
                                Text(
                                    err,
                                    color = MaterialTheme.colorScheme.error,
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                OutlinedButton(
                                    onClick = { stage = SearchStage.SEARCH; capturedUrl = null; saveError = null },
                                    modifier = Modifier.weight(1f),
                                    enabled = stage != SearchStage.SAVING
                                ) {
                                    Text("Back to Search")
                                }
                                Button(
                                    onClick = {
                                        val url = capturedUrl ?: return@Button
                                        stage = SearchStage.SAVING
                                        saveError = null
                                        scope.launch {
                                            val path = withContext(Dispatchers.IO) {
                                                ImageStorageManager.downloadImageFromUrl(context, url)
                                            }
                                            if (path != null) {
                                                onImageSelected(path)
                                                onDismiss()
                                            } else {
                                                saveError = "Failed to download image. Try another."
                                                stage = SearchStage.PREVIEW
                                            }
                                        }
                                    },
                                    modifier = Modifier.weight(1f),
                                    enabled = stage != SearchStage.SAVING
                                ) {
                                    if (stage == SearchStage.SAVING) {
                                        CircularProgressIndicator(
                                            modifier = Modifier.size(18.dp),
                                            strokeWidth = 2.dp,
                                            color = MaterialTheme.colorScheme.onPrimary
                                        )
                                    } else {
                                        Text("Use This Image")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

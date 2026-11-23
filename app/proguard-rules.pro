# ==============================================================================
# AnkiPrep R8 Full Mode & ProGuard Rules
# ==============================================================================

# ── General Optimization Directives ──────────────────────────────────────────
-repackageclasses ''
-allowaccessmodification
-dontusemixedcaseclassnames
-keepattributes *Annotation*,Signature,InnerClasses,EnclosingMethod,SourceFile,LineNumberTable

# ── JLaTeXMath (Offline Math & Equation Rendering Engine) ─────────────────────
-keep class org.scilab.forge.jlatexmath.** { *; }
-dontwarn org.scilab.forge.jlatexmath.**

# ── Room Database & SQLite Entities ──────────────────────────────────────────
-keep class androidx.room.** { *; }
-dontwarn androidx.room.**
-keep class * extends androidx.room.RoomDatabase { *; }
-keep class com.example.flashcardapp.data.entities.** { *; }
-keep class com.example.flashcardapp.data.dao.** { *; }
-keep class com.example.flashcardapp.data.AppDatabase { *; }

# ── Gson Serialization & Data Models ─────────────────────────────────────────
-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}
-keep class com.example.flashcardapp.data.AnkiDeck { *; }
-keep class com.example.flashcardapp.data.AnkiDroidFieldMapping { *; }
-keep class com.example.flashcardapp.ui.theme.ExamThemeTokens { *; }
-keep class com.example.flashcardapp.mock.** { *; }
-keep class com.example.flashcardapp.session.** { *; }

# ── QuickJS (Native JavaScript Plugin Engine) ─────────────────────────────────
-keep class com.whl.quickjs.** { *; }
-dontwarn com.whl.quickjs.**
-keepclasseswithmembernames class * {
    native <methods>;
}

# ── Google ML Kit (Offline Camera OCR Engine) ────────────────────────────────
-keep class com.google.mlkit.** { *; }
-dontwarn com.google.mlkit.**
-keep class com.google.android.gms.internal.mlkit_vision_text_common.** { *; }

# ── WorkManager Workers ──────────────────────────────────────────────────────
-keep class * extends androidx.work.Worker { *; }
-keep class * extends androidx.work.CoroutineWorker { *; }
-keep class * extends androidx.work.ListenableWorker { *; }

# ── Coil Image Loading ───────────────────────────────────────────────────────
-keep class coil.** { *; }
-dontwarn coil.**

# ── JSoup HTML Parser ────────────────────────────────────────────────────────
-keep class org.jsoup.** { *; }
-dontwarn org.jsoup.**

# ── OkHttp & Kotlin Coroutines ───────────────────────────────────────────────
-dontwarn okhttp3.**
-dontwarn okio.**
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.flashcardapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.indicreader.AnkiPrep"
        minSdk = 26
        targetSdk = 34
        // Version scheme: 0.10 -> 0.20 -> 0.30 ...
        versionCode = 175
        versionName = "5.11"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables { useSupportLibrary = true }
    }

    signingConfigs {
        create("release") {
            val keyFile = rootProject.file("my-release-key.jks")
            if (keyFile.exists() && keyFile.length() > 0) {
                storeFile = keyFile
                storePassword = System.getenv("KEYSTORE_PASSWORD") ?: "password"
                keyAlias = System.getenv("KEY_ALIAS") ?: "key0"
                keyPassword = System.getenv("KEY_PASSWORD") ?: "password"
            }
        }
    }


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
            val releaseKey = rootProject.file("my-release-key.jks")
            signingConfig = if (releaseKey.exists() && releaseKey.length() > 0) {
                signingConfigs.getByName("release")
            } else {
                signingConfigs.getByName("debug")
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions { jvmTarget = "17" }
    buildFeatures { compose = true }
    composeOptions { kotlinCompilerExtensionVersion = "1.5.8" }
    packaging { resources { excludes += "/META-INF/{AL2.0,LGPL2.1}" } }



    // Standard application configuration
}


dependencies {
    implementation(libs.material)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material.icons.extended)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.play.services.ads)

    // Room Database
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    // Coroutines
    implementation(libs.kotlinx.coroutines.android)

    // Gson for JSON serialization of tags
    implementation(libs.gson)

    // Testing
    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.room.testing)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // Image loading
    implementation(libs.coil.compose)

    // HTML parsing for EPUB import
    implementation(libs.jsoup)

    // Google ML Kit Bundled Text Recognition (100% offline, zero network / Play Services download required)
    implementation(libs.mlkit.text.recognition)

    // DocumentFile & WorkManager
    implementation(libs.androidx.documentfile)
    implementation(libs.androidx.work.runtime.ktx)

    // OkHttp for downloading remote JS plugins and network feeds
    implementation(libs.okhttp)

    // Native QuickJS Engine wrapper
    implementation(libs.quickjs.android)
}

// ── Fixed APK release folder ─────────────────────────────────────────────────
afterEvaluate {
    listOf("debug", "release").forEach { variant ->
        val capVariant = variant.replaceFirstChar { it.uppercase() }
        tasks.findByName("assemble$capVariant")?.doLast {
            val ver = android.defaultConfig.versionName ?: "0"
            val releasesDir = rootProject.file("release")
            releasesDir.mkdirs()
            val apkDir = file("${layout.buildDirectory.asFile.get()}/outputs/apk/$variant")
            apkDir.listFiles()?.filter { it.extension == "apk" }?.forEach { src ->
                val dest1 = File(releasesDir, "ankiprep-$ver.apk")
                val dest2 = File(releasesDir, "ankiprep-$variant-v$ver.apk")
                src.copyTo(dest1, overwrite = true)
                src.copyTo(dest2, overwrite = true)
                println("✅ APK copied to: ${dest1.absolutePath}")
            }
        }
    }
}


ksp { arg("room.generateKotlin", "true") }

tasks.withType<JavaCompile>().configureEach { exclude("**/byRounds/**") }


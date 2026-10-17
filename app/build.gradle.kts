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
        versionCode = 173
        versionName = "5.9"

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
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2024.02.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("com.google.android.gms:play-services-ads:23.0.0")

    // Room Database
    val roomVersion = "2.6.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Gson for JSON serialization of tags
    implementation("com.google.code.gson:gson:2.10.1")

    // Testing
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.02.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    androidTestImplementation("androidx.room:room-testing:$roomVersion")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Image loading
    implementation("io.coil-kt:coil-compose:2.6.0")

    // HTML parsing for EPUB import
    implementation("org.jsoup:jsoup:1.17.2")

    // Google ML Kit Bundled Text Recognition (100% offline, zero network / Play Services download required)
    implementation("com.google.mlkit:text-recognition:16.0.0")

    // DocumentFile & WorkManager
    implementation("androidx.documentfile:documentfile:1.0.1")
    implementation("androidx.work:work-runtime-ktx:2.9.0")

    // OkHttp for downloading remote JS plugins and network feeds
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    // Native QuickJS Engine wrapper
    implementation("app.cash.quickjs:quickjs-android:0.9.2")
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


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
        versionCode = 89
        versionName = "4.25"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables { useSupportLibrary = true }
    }

    signingConfigs {
        create("release") {
            storeFile = file("../my-release-key.jks")
            storePassword = System.getenv("KEYSTORE_PASSWORD") ?: "password"
            keyAlias = System.getenv("KEY_ALIAS") ?: "key0"
            keyPassword = System.getenv("KEY_PASSWORD") ?: "password"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
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

    applicationVariants.all {
        val variantName = name // "debug" / "release"
        val ver = defaultConfig.versionName ?: "0"

        outputs.all {
            val out = this as com.android.build.gradle.internal.api.ApkVariantOutputImpl
            out.outputFileName = "ankiprep-${variantName}-v${ver}.apk"
        }
    }
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
}

// ── Fixed APK release folder ─────────────────────────────────────────────────
// Runs after assembleDebug / assembleRelease and copies the output APK into
//   <project-root>/release/
// Uses only resolved paths, so it is fully configuration-cache compatible.
afterEvaluate {
    listOf("debug", "release").forEach { variant ->
        val capVariant = variant.replaceFirstChar { it.uppercase() }
        tasks.findByName("assemble$capVariant")?.doLast {
            val ver = android.defaultConfig.versionName ?: "0"
            val apkName = "ankiprep-${variant}-v${ver}.apk"
            val src = file("${buildDir}/outputs/apk/${variant}/${apkName}")
            val releasesDir = rootProject.file("release")
            releasesDir.mkdirs()
            if (src.exists()) {
                val dest = File(releasesDir, apkName)
                src.copyTo(dest, overwrite = true)
                println("✅  APK saved → ${dest.absolutePath}")
            }
        }
    }
}

ksp { arg("room.generateKotlin", "true") }

tasks.withType<JavaCompile>().configureEach { exclude("**/byRounds/**") }


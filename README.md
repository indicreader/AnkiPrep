# AnkiPrep

AnkiPrep is a premium, offline-first smart flashcard application designed for high-density exam-style multiple-choice question (MCQ) preparation. Built natively using Jetpack Compose and modern Android design principles, AnkiPrep allows users to import standard flashcard decks and practice them through an active recall framework.

---

## Key Features

*   🎯 **Offline MCQ Engine**: Automatically generates multiple-choice questions offline from imported Anki `.apkg` and `.csv` flashcard databases.
*   📈 **Adaptive Spaced Repetition**: Study with adaptive learning algorithms including Leitner systems, traditional Spaced Repetition, and FSRS (Free Spaced Repetition Scheduler).
*   🌿 **Claymorphic Spine Metaphor**: Visually tracks and displays deck mastery through a thickness and color-coded left edge spine indicator on cards.
*   🎨 **Adaptive Color Theming**: Features a dynamic wallpaper-aware color palette system alongside custom light themes (Emerald, Ocean, Sunset) and a deep-space Cyber-Mint Dark Mode.
*   🔤 **Dynamic Typography System**: Load and apply custom `.ttf` or `.otf` font files dynamically all over the application.
*   🌐 **Multilingual Interface**: Fully supports localization across English, Hindi (हिन्दी), Tamil (தமிழ்), Telugu (తెలుగు), Kannada (ಕನ್ನಡ), and Marathi (मराठी).
*   🛡️ **Privacy & Offline First**: Zero server connections or data collection. All statistics, sessions, and profile customizations remain on the local device SQLite (Room) database.

---

## Getting Started

### Prerequisites

*   Android Studio Ladybug (or newer)
*   JDK 17
*   Android SDK 34+

### Build & Run

To build and compile the application locally:

```bash
# Clone the repository
git clone https://github.com/indicreader/AnkiPrep.git
cd AnkiPrep

# Build the debug assembly
./gradlew assembleDebug
```

To build a clean release APK:

```bash
./build-apk.bat
```

The compiled release binaries will be saved in the `release/` directory.

---

## Project Directory Structure

```text
├── app/                  # Main Android Application module
│   ├── src/
│   │   ├── main/
│   │   │   ├── assets/   # Embedded offline databases & mockups
│   │   │   ├── java/     # Kotlin package source files
│   │   │   └── res/      # Static vectors, resources, XML configuration
│   └── build.gradle.kts  # Module configuration
├── release/              # Compiled APK binaries & app store assets
└── build.gradle.kts      # Project root configuration
```

---

## How to Use AnkiPrep

1. **Import Flashcards**: Navigate to the **Library** (Review) tab and tap the float menu (`+`) to import `.apkg` or `.csv` files.
2. **Select Decks**: Tap on any deck to view subdeck hierarchies or modify settings for that specific deck.
3. **Customize Practice**: Go to the **Settings** tab to choose your active learning algorithm, adjust question presets (20, 30, 50, 80, or custom up to 500 questions), set time limits, or upload a custom font.
4. **Study & Review**: Click **Study Now** to launch an active recall quiz. Incorrect answers will vibrate (optional) and show instant explanations.
5. **Track Analytics**: Use the **Analytics** tab to view your weekly solved questions, streak charts, and custom specialty badges based on accuracy.

---

## Download & Availability

AnkiPrep is live and available for download on app stores including:
*   **Indus Appstore** (Search for "AnkiPrep")
*   **GitHub Releases** (Download pre-compiled `.apk` packages directly from the `release/` directory)


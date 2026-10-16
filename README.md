# AnkiPrep

[![Build & Release APK](https://github.com/indicreader/AnkiPrep/actions/workflows/release.yml/badge.svg)](https://github.com/indicreader/AnkiPrep/actions/workflows/release.yml)
[![Latest Release](https://img.shields.io/github/v/release/indicreader/AnkiPrep?color=00B4D8&label=Latest%20Release)](https://github.com/indicreader/AnkiPrep/releases)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

**AnkiPrep** is a high-performance, offline-first smart flashcard application engineered for high-density multiple-choice question (MCQ) preparation, competitive exam practice, and active recall. Built natively using **Jetpack Compose**, **Kotlin Coroutines**, and **Room Database**, AnkiPrep allows aspirants and students to import comprehensive study materials from standard flashcards (`.apkg`), spreadsheets (`.csv`), data dumps (`.json`), digital books (`.epub`), and exam papers (`.pdf`) into a structured study environment.

<p align="center">
  <img src="release/mockups/dashboard_mockup.png" width="31%" alt="Dashboard Screen" />
  <img src="release/mockups/quiz_mockup.png" width="31%" alt="Active Recall Quiz" />
  <img src="release/mockups/analytics_mockup.png" width="31%" alt="Analytics & Progress" />
</p>

---

## ⚡ Key Features

- **🚀 High-Performance Streaming Ingestion**: Parses large files (1,000+ questions) seamlessly using streaming `BufferedReader` (for CSV) and native `JsonReader` (for JSON) on `Dispatchers.IO` with chunked atomic database transactions and real-time progress indicators.
- **🎯 Offline MCQ Engine**: Generates multiple-choice options, distractors, and randomized order offline from source cards or semantically similar deck questions.
- **📈 Adaptive Spaced Repetition**: Study with adaptive algorithms including **FSRS (Free Spaced Repetition Scheduler)**, 5-box Leitner progression, and traditional SRS interval scheduling.
- **📚 Multi-Format Ingestion**: Supports `.csv`, `.json`, Anki `.apkg`, chapter-segmented `.epub` books, multi-column exam `.pdf` files, and `.zip` archives.
- **🌿 Claymorphic Spine Metaphor**: Visually tracks and displays deck mastery via color-coded, dynamic spine depth indicators.
- **🎨 Custom Theming & Typography**: Light palettes (Emerald, Ocean, Sunset), pure AMOLED Black mode, Cyber-Mint Dark mode, dynamic typography scaling, and custom `.ttf`/`.otf` font uploads.
- **🌐 Multilingual Localization**: Built-in support for English, Hindi (हिन्दी), Tamil (தமிழ்), Telugu (తెలుగు), Kannada (ಕನ್ನಡ), and Marathi (मराठी).
- **🔒 Complete Privacy & Offline Operation**: Zero data tracking or third-party cloud requirements. All learning analytics, streaks, and quiz sessions remain stored locally in SQLite/Room.

---

## 📥 Sample Ingestion Files & Formats

AnkiPrep supports diverse, flexible question formats out of the box. Verified sample files are included in the [`sample_import_files/`](sample_import_files/) directory:

### 1. Standard Multiple-Choice CSV (`sample_import_files/sample_mcq.csv`)
Columns: `Tags / Topic`, `Question`, `Answer | Option 1 | Option 2 | Option 3`, `Explanation`

```csv
"Quant, Number Systems", "What is the remainder when 2^31 is divided by 5?", "3 | 1 | 2 | 4", "Cycle of powers of 2 mod 5 is 2, 4, 3, 1 (period 4). 31 mod 4 = 3, so 2^3 = 8 = 3 mod 5."
"English, Vocabulary", "Choose the closest synonym for the word: 'Ephemeral'", "Transitory | Eternal | Monotonous | Gigantic", "Ephemeral means lasting for a very short time; fleeting or transitory."
"Polity, Fundamental Rights", "Which Article guarantees the Right to Constitutional Remedies?", "Article 32 | Article 21 | Article 19 | Article 14", "Dr. B.R. Ambedkar hailed Article 32 as the heart and soul of the Indian Constitution."
```

### 2. Five-Column Hierarchical CSV (`sample_import_files/sample_5col_history.csv`)
Columns: `topic`, `subtopic`, `question`, `answer`, `explaination`

```csv
topic, subtopic, question, answer, explaination
History, Ancient, Which river was known as Parushni in the Rigveda?, Ravi, Parushni is the Vedic name for modern river Ravi where the Battle of Ten Kings took place.
History, Ancient, Capital of the Maurya Empire under Ashoka, Pataliputra, Modern day Patna served as the seat of the Mauryan emperor.
History, Medieval, Battle of Khanwa took place in which year, 1527, Fought between the Mughal forces under Babur and the Rajput army under Rana Sanga.
```

### 3. One-Liner / Fact Sheet CSV (`sample_import_files/sample_oneliner.csv`)
Columns: `question`, `answer`, `explaination`

```csv
question, answer, explaination
Who wrote the National Anthem of India?, Rabindranath Tagore, Jana Gana Mana was originally composed in Bengali as Bharoto Bhagyo Bidhata.
What is the SI unit of electric current?, Ampere, Named after Andre-Marie Ampere who discovered electro-magnetism.
Which layer of the atmosphere contains the ozone layer?, Stratosphere, Located roughly between 15 to 35 km altitude above Earth surface.
```

### 4. Structured Question JSON (`sample_import_files/sample_questions.json`)
Supports both top-level arrays and `{"questions": [...]}` wrapped payloads:

```json
[
  {
    "question": "Which gas is most abundant in the Earth's atmosphere?",
    "options": ["Nitrogen", "Oxygen", "Argon", "Carbon Dioxide"],
    "answer": "Nitrogen",
    "explanation": "Nitrogen makes up roughly 78.08% of Earth's atmosphere by volume.",
    "topic": "General Science",
    "subtopic": "Atmosphere"
  },
  {
    "question": "What is the capital city of Australia?",
    "options": ["Canberra", "Sydney", "Melbourne", "Brisbane"],
    "answer": "Canberra",
    "explanation": "Canberra was chosen as the capital in 1908 as a compromise between Sydney and Melbourne.",
    "topic": "Geography",
    "subtopic": "World Capitals"
  }
]
```

### 5. Other Supported Test Assets in Repository:
- **`sample_import_files/sample_book.epub`**: Universal EPUB structure parsed into Chapter decks and subdecks.
- **`sample_import_files/sample_book.zip`**: Bundled ZIP containing chapters and embedded media.
- **`sample_import_files/sample_exam.pdf`**: Multi-column past year question paper with automatic column flow detection.

---

## 🛠️ Project Structure

```text
AnkiPrep/
├── .github/workflows/
│   └── release.yml             # Automated GitHub Actions release APK builder
├── app/
│   ├── src/main/java/com/example/flashcardapp/
│   │   ├── data/               # Room database, DAO, entities, and importers
│   │   │   ├── core/           # Streaming parsers (CsvQuoteUtils, FileImportUtils)
│   │   │   ├── CsvImporter.kt  # Streaming 250-chunk CSV parser & batch transactions
│   │   │   └── JsonImporter.kt # Streaming JsonReader importer
│   │   ├── mcq/                # Offline MCQ generation engine
│   │   ├── session/            # Active recall quiz state machine
│   │   └── ui/                 # Jetpack Compose UI (Screens, Settings, Components)
│   │       ├── components/     # ImportProgressDialog, heatmaps, pomodoro timers
│   │       └── settings/       # 3-tier hierarchical settings navigation
│   └── build.gradle.kts        # Application dependencies & signing configuration
├── sample_import_files/        # Ready-to-import sample CSV, JSON, EPUB, and PDF files
├── build.gradle.kts            # Root project build script
└── README.md                   # Project documentation
```

---

## 🚀 Building & Releasing

### Prerequisites
- **JDK 17** (Zulu or OpenJDK recommended)
- **Android SDK 34+**
- **Android Studio Ladybug** (or command line tools)

### Build Debug Assembly Locally
```bash
./gradlew assembleDebug
```

### Build Release APK Locally
Windows batch script for clean release builds:
```bat
build-apk.bat
```
The compiled output is saved to the `release/` directory.

### Automated Cloud Builds via GitHub Actions
A complete automated build workflow is configured in [`.github/workflows/release.yml`](.github/workflows/release.yml):
1. **Pushing a Tag**: Pushing any tag starting with `v` (e.g., `git tag v5.8 && git push origin v5.8`) triggers the workflow to compile a signed release APK and automatically create a GitHub Release with the APK attached.
2. **Manual Dispatch**: Go to **Actions → Build & Release APK → Run workflow** on GitHub to trigger an on-demand release build.

---

## 📲 Download & Installation

Pre-compiled release binaries are available under the GitHub [Releases](https://github.com/indicreader/AnkiPrep/releases) tab.

1. Download **`AnkiPrep-v*.apk`** from the latest release.
2. Enable installation of unknown apps on your device (**Settings → Apps → Special app access → Install unknown apps**).
3. Open the downloaded file to install.

---

## 📄 License

This project is licensed under the GNU General Public License v3.0 — see the [LICENSE](LICENSE) file for details.

# Changelog

All notable changes to AnkiPrep are documented in this file.
The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/), and this project adheres to semantic versioning milestones.

---

## [5.18] - 2026-11-03

### Added
- **Key-Driven Dynamic Exam Theme Engine (FEAT-13-15):**
  - Immutable `ExamThemeTokens` model controlling surface colors, borders, chrome, typography, and question status states (`Answered`, `Not Answered`, `Marked for Review`, `Answered & Review`, `Not Visited`).
  - Pre-configured authentic exam simulation presets:
    - **TCS iON Console:** Matches official SSC CGL/CHSL, Railway RRB, and Banking interfaces (TCS Green, Dark Orange, Violet flags, 4dp crisp radius).
    - **NTA Console:** Matches official NEET, JEE, and CUET exam software (distinctive green/red/purple status chips, 6dp corner radius).
    - **Tactical Dark:** High-contrast OLED dark styling for minimal night-time eye fatigue.
    - **Cyber Mint:** Refined emerald-mint night palette.
- **Theme Studio UI:**
  - Dedicated interactive studio under **Settings → Appearance → Theme Studio**.
  - Live interactive question card preview showing sample question, LaTeX math, and status tags in real-time.
  - Corner radius and elevation sliders for custom button geometry.
  - Custom user theme builder with local persistence and deletion support.
- **Reactive Compose Integration:**
  - Token injection through `LocalExamThemeTokens` via `CompositionLocalProvider`.
  - Dynamically bound `MockExamScreen` question palette drawer, question grid, and status indicators without activity restart or layout re-inflation.

---

## [5.17] - 2026-11-03

### Added
- **Native LaTeX & Math Equation Engine (FEAT-15):**
  - Integrated high-performance native Android Canvas math engine (`ru.noties:jlatexmath-android:0.2.0`), completely eliminating WebView overhead, white flashes, and memory bloat.
  - High-speed tokenizer supporting inline (`$...$`, `\(...\)`) and display block (`$$...$$`, `\[...\]`) math formulas.
- **In-Memory LRU Cache (`LateXRenderingCache`):**
  - Pre-rendered equation bitmaps cached in an LRU memory pool keyed by formula, color ARGB, and text size for instantaneous sub-millisecond retrieval during card reviews.
- **Theme-Aware Dynamic Math Coloring:**
  - Math equations adapt stroke and text color automatically across AMOLED Dark, Cyber-Mint, and Light modes without re-parsing from scratch.
- **WhatsNewBottomSheet:**
  - Added first-launch modal sheet highlighting major engine updates and features.

---

## [5.16] - 2026-11-02

### Added
- **"Tukke" / Educated Guess Mode (FEAT-14):**
  - In-quiz guess toggle chip allowing students to tag guesses during practice and mock exams.
  - FSRS scheduler retention penalty applied to correct guesses (treated as Hard / 0.5x interval) to prevent false memory confidence.
  - Session scorecard breakdown of lucky guesses versus true conceptual accuracy.
- **Deck-Wise Accuracy Analytics (FEAT-14):**
  - Foreign-key bound Room aggregation query (`observeDeckAccuracyStats`) grouped by immutable `deckId`.
  - Renaming decks triggers real-time updates across analytics with zero stale titles.
  - Visual color-coded performance tiers: Strong ($\ge 85\%$), Moderate ($60\% - 84\%$), Focus Needed ($< 60\%$).
- **Database Migration 16 → 17:**
  - Added `isGuess: Boolean` column to `card_attempts` table.

---

## [5.15] - 2026-11-02

### Changed
- **Streamlined Manage Decks Header Bar (FEAT-13):**
  - Removed obsolete top-bar Add Deck (`+`) and broken Import icons from the `Manage Decks` toolbar.
  - Preserved strictly two primary top-right actions: Dark/Light mode toggle and Pomodoro study timer.
  - Enforced minimum 48dp touch targets for accessibility and ergonomics.

---

## [5.14] - 2026-11-02

### Added
- **Ergonomic Long-Press Multi-Select (FEAT-12):**
  - Replaced persistent checkboxes with haptic long-press multi-select for deck items.
  - Bottom action bar for batch operations: Nest under master, Club/Merge questions, Combined Mock Test, and Batch Delete.
  - Drag handle for smooth sibling reordering with cyclic dependency protection.

---

## [5.11] - 2026-10-31

### Added
- **Offline ML Kit OCR Scanner:**
  - On-device text recognition to snap textbook pages and extract questions, options (A-D), and explanations into draft cards.
- **Floating Stylus Canvas Toolbar:**
  - Low-latency inking canvas with pen, pencil, and highlighter for rough work during quizzes.


package com.example.flashcardapp.data

data class ReleaseHighlightItem(
    val title: String,
    val description: String,
    val tag: String = "NEW"
)

data class AppVersionRelease(
    val versionName: String,
    val versionCode: Int,
    val releaseDate: String,
    val title: String,
    val highlights: List<ReleaseHighlightItem>
)

object ChangelogProvider {
    val releases: List<AppVersionRelease> = listOf(
        AppVersionRelease(
            versionName = "5.18",
            versionCode = 182,
            releaseDate = "November 2026",
            title = "Key-Driven Exam Theme Engine & Theme Studio",
            highlights = listOf(
                ReleaseHighlightItem(
                    title = "TCS iON & NTA Console Exam Presets",
                    description = "Authentic exam simulation styling replicating real-world SSC/Banking (TCS iON) and NEET/JEE (NTA) interfaces with green, orange, and purple question status chips."
                ),
                ReleaseHighlightItem(
                    title = "Interactive Theme Studio",
                    description = "Live visual studio under Settings → Appearance → Theme Studio to tweak button corner radius, test live question cards, and create custom themes."
                ),
                ReleaseHighlightItem(
                    title = "Reactive Dynamic Styling",
                    description = "Dynamic token styling applied directly to MockExam palette drawers, question cards, and status badges without screen reloading."
                )
            )
        ),
        AppVersionRelease(
            versionName = "5.17",
            versionCode = 181,
            releaseDate = "November 2026",
            title = "Native LaTeX Math Engine & Equation Cache",
            highlights = listOf(
                ReleaseHighlightItem(
                    title = "Native Offline LaTeX Engine",
                    description = "High-performance Canvas math rendering using jlatexmath-android with zero WebView lag, battery drain, or layout jitter."
                ),
                ReleaseHighlightItem(
                    title = "In-Memory LRU Cache",
                    description = "Instantaneous sub-millisecond retrieval of pre-rendered math equations and fractions during high-speed card reviews."
                ),
                ReleaseHighlightItem(
                    title = "Mixed Inline & Block Formulas",
                    description = "Automatic recognition of $...$, \\(...\\), $$...$$, and \\[...\\] with theme-aware dynamic color adaptation across dark and light modes."
                )
            )
        ),
        AppVersionRelease(
            versionName = "5.16",
            versionCode = 180,
            releaseDate = "November 2026",
            title = "Tukke Guess Mode & Deck Accuracy Diagnostics",
            highlights = listOf(
                ReleaseHighlightItem(
                    title = "Tukke / Educated Guess Mode",
                    description = "Tag questions as educated guesses during review. Correct guesses receive an FSRS retention penalty to prevent false memory confidence."
                ),
                ReleaseHighlightItem(
                    title = "Deck-Wise Accuracy Analytics",
                    description = "Track review performance with live Room database queries grouped by immutable deck IDs and 3-tier color badges (Strong, Moderate, Focus Needed)."
                )
            )
        ),
        AppVersionRelease(
            versionName = "5.15",
            versionCode = 179,
            releaseDate = "November 2026",
            title = "Streamlined Deck Management TopBar",
            highlights = listOf(
                ReleaseHighlightItem(
                    title = "48dp Accessible Touch Targets",
                    description = "Cleaned up top action buttons on Manage Decks screen with one-tap night mode toggle and Pomodoro study timer."
                )
            )
        ),
        AppVersionRelease(
            versionName = "5.14",
            versionCode = 178,
            releaseDate = "November 2026",
            title = "Ergonomic Long-Press Multi-Select",
            highlights = listOf(
                ReleaseHighlightItem(
                    title = "Long-Press Selection Mode",
                    description = "Replaced persistent checkboxes with tactile long-press multi-select for batch nesting, moving, combining, and deleting decks."
                )
            )
        )
    )

    fun getReleaseForVersion(versionName: String): AppVersionRelease {
        val clean = versionName.trim().removePrefix("v")
        return releases.firstOrNull { it.versionName == clean } ?: releases.first()
    }

    fun getLatestRelease(): AppVersionRelease = releases.first()
}


package com.example.flashcardapp.ui.settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ExtensionsCategoryScreen(
    onNavigateToSubCategory: (SettingsSubCategory) -> Unit,
    onOpenPlugins: () -> Unit,
    onOpenCurrentAffairs: () -> Unit,
    onOpenWebScraper: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        SettingSubheadingCard(
            subCategory = SettingsSubCategory.WEB_SCRAPING,
            badgeText = "Live Extraction",
            onClick = onOpenWebScraper
        )

        SettingSubheadingCard(
            subCategory = SettingsSubCategory.PLUGINS,
            badgeText = "QuickJS",
            onClick = onOpenPlugins
        )

        SettingSubheadingCard(
            subCategory = SettingsSubCategory.CURRENT_AFFAIRS,
            badgeText = "RSS & MCQs",
            onClick = onOpenCurrentAffairs
        )
    }
}

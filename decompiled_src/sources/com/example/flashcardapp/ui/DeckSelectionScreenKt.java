package com.example.flashcardapp.ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AnalyticsKt;
import androidx.compose.material.icons.filled.HomeKt;
import androidx.compose.material.icons.filled.QuizKt;
import androidx.compose.material.icons.filled.SettingsKt;
import androidx.compose.material.icons.filled.StarKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.AnkiDataRepository;
import com.example.flashcardapp.data.AnkiDeck;
import com.example.flashcardapp.data.TranslationManager;
import com.example.flashcardapp.data.entities.CardAttemptEntity;
import com.example.flashcardapp.data.entities.SessionRecordEntity;
import com.example.flashcardapp.session.McqSessionMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeckSelectionScreen.kt */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001aÉ\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\t2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u00072\u001a\b\u0002\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010#2\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u00072\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u00072\u001a\b\u0002\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010#2F\b\u0002\u0010'\u001a@\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00010(2\u0014\b\u0002\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u00072\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\u0006\u0010+\u001a\u00020,2&\b\u0002\u0010-\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010.H\u0007¢\u0006\u0002\u00100¨\u00061²\u0006\n\u00102\u001a\u000203X\u008a\u0084\u0002²\u0006\n\u00104\u001a\u00020\tX\u008a\u008e\u0002"}, d2 = {"DeckSelectionScreen", "", "isAnkiInstalled", "", "hasPermission", "isDarkMode", "onDarkModeToggle", "Lkotlin/Function1;", "themePreset", "", "onThemePresetChange", "fontFamilyType", "onFontFamilyTypeChange", "decks", "", "Lcom/example/flashcardapp/data/AnkiDeck;", "currentMode", "Lcom/example/flashcardapp/session/McqSessionMode;", "cardCount", "", "sessionRecords", "Lcom/example/flashcardapp/data/entities/SessionRecordEntity;", "attemptsToday", "Lcom/example/flashcardapp/data/entities/CardAttemptEntity;", "onRequestPermission", "Lkotlin/Function0;", "onRefresh", "onSettingsClicked", "onImportApkgClicked", "onImportCsvClicked", "onImportEpubClicked", "onSelectDeck", "onProfileClicked", "onDeleteDeck", "onRenameDeck", "Lkotlin/Function2;", "onClearDeckProgress", "onCreateDeck", "onMergeDecks", "onAddCardToDeck", "Lkotlin/Function8;", "onExportDeck", "onDeckOrderChanged", "repo", "Lcom/example/flashcardapp/data/AnkiDataRepository;", "onStartRevisionSession", "Lkotlin/Function3;", "", "(ZZZLkotlin/jvm/functions/Function1;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/util/List;Lcom/example/flashcardapp/session/McqSessionMode;ILjava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function8;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lcom/example/flashcardapp/data/AnkiDataRepository;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;IIIII)V", "app_release", "currentLanguage", "Lcom/example/flashcardapp/data/AppLanguage;", "activeTab"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class DeckSelectionScreenKt {
    public static final void DeckSelectionScreen(final boolean z, final boolean z2, boolean z3, Function1<? super Boolean, Unit> function1, String str, Function1<? super String, Unit> function12, String str2, Function1<? super String, Unit> function13, final List<AnkiDeck> decks, final McqSessionMode currentMode, final int i, final List<SessionRecordEntity> sessionRecords, List<CardAttemptEntity> list, final Function0<Unit> onRequestPermission, final Function0<Unit> onRefresh, final Function0<Unit> onSettingsClicked, final Function0<Unit> onImportApkgClicked, final Function0<Unit> onImportCsvClicked, Function0<Unit> function0, final Function1<? super AnkiDeck, Unit> onSelectDeck, final Function0<Unit> onProfileClicked, Function1<? super AnkiDeck, Unit> function14, Function2<? super AnkiDeck, ? super String, Unit> function2, Function1<? super AnkiDeck, Unit> function15, Function1<? super String, Unit> function16, Function2<? super AnkiDeck, ? super AnkiDeck, Unit> function22, Function8<? super AnkiDeck, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, Unit> function8, Function1<? super AnkiDeck, Unit> function17, Function0<Unit> function02, final AnkiDataRepository repo, Function3<? super List<Long>, ? super Boolean, ? super McqSessionMode, Unit> function3, Composer composer, final int i2, final int i3, final int i4, final int i5, final int i6) {
        Intrinsics.checkNotNullParameter(decks, "decks");
        Intrinsics.checkNotNullParameter(currentMode, "currentMode");
        Intrinsics.checkNotNullParameter(sessionRecords, "sessionRecords");
        Intrinsics.checkNotNullParameter(onRequestPermission, "onRequestPermission");
        Intrinsics.checkNotNullParameter(onRefresh, "onRefresh");
        Intrinsics.checkNotNullParameter(onSettingsClicked, "onSettingsClicked");
        Intrinsics.checkNotNullParameter(onImportApkgClicked, "onImportApkgClicked");
        Intrinsics.checkNotNullParameter(onImportCsvClicked, "onImportCsvClicked");
        Intrinsics.checkNotNullParameter(onSelectDeck, "onSelectDeck");
        Intrinsics.checkNotNullParameter(onProfileClicked, "onProfileClicked");
        Intrinsics.checkNotNullParameter(repo, "repo");
        Composer startRestartGroup = composer.startRestartGroup(826355831);
        final boolean z4 = (i6 & 4) != 0 ? false : z3;
        Function1<? super Boolean, Unit> function18 = (i6 & 8) != 0 ? new Function1<Boolean, Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$1
            public final void invoke(boolean z5) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        } : function1;
        String str3 = (i6 & 16) != 0 ? "EMERALD" : str;
        Function1<? super String, Unit> function19 = (i6 & 32) != 0 ? new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str4) {
                invoke2(str4);
                return Unit.INSTANCE;
            }
        } : function12;
        String str4 = (i6 & 64) != 0 ? "DEFAULT" : str2;
        Function1<? super String, Unit> function110 = (i6 & 128) != 0 ? new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$3
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str5) {
                invoke2(str5);
                return Unit.INSTANCE;
            }
        } : function13;
        List<CardAttemptEntity> emptyList = (i6 & 4096) != 0 ? CollectionsKt.emptyList() : list;
        Function0<Unit> function03 = (262144 & i6) != 0 ? new Function0<Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$4
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : function0;
        Function1<? super AnkiDeck, Unit> function111 = (2097152 & i6) != 0 ? new Function1<AnkiDeck, Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$5
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AnkiDeck it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AnkiDeck ankiDeck) {
                invoke2(ankiDeck);
                return Unit.INSTANCE;
            }
        } : function14;
        Function2<? super AnkiDeck, ? super String, Unit> function23 = (4194304 & i6) != 0 ? new Function2<AnkiDeck, String, Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$6
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AnkiDeck ankiDeck, String str5) {
                Intrinsics.checkNotNullParameter(ankiDeck, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(str5, "<anonymous parameter 1>");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(AnkiDeck ankiDeck, String str5) {
                invoke2(ankiDeck, str5);
                return Unit.INSTANCE;
            }
        } : function2;
        Function1<? super AnkiDeck, Unit> function112 = (8388608 & i6) != 0 ? new Function1<AnkiDeck, Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$7
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AnkiDeck it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AnkiDeck ankiDeck) {
                invoke2(ankiDeck);
                return Unit.INSTANCE;
            }
        } : function15;
        Function1<? super String, Unit> function113 = (16777216 & i6) != 0 ? new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$8
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str5) {
                invoke2(str5);
                return Unit.INSTANCE;
            }
        } : function16;
        Function2<? super AnkiDeck, ? super AnkiDeck, Unit> function24 = (33554432 & i6) != 0 ? new Function2<AnkiDeck, AnkiDeck, Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$9
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AnkiDeck ankiDeck, AnkiDeck ankiDeck2) {
                Intrinsics.checkNotNullParameter(ankiDeck, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(ankiDeck2, "<anonymous parameter 1>");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(AnkiDeck ankiDeck, AnkiDeck ankiDeck2) {
                invoke2(ankiDeck, ankiDeck2);
                return Unit.INSTANCE;
            }
        } : function22;
        Function8<? super AnkiDeck, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, Unit> function82 = (67108864 & i6) != 0 ? new Function8<AnkiDeck, String, String, String, String, String, String, String, Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$10
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AnkiDeck ankiDeck, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
                Intrinsics.checkNotNullParameter(ankiDeck, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(str5, "<anonymous parameter 1>");
                Intrinsics.checkNotNullParameter(str6, "<anonymous parameter 2>");
                Intrinsics.checkNotNullParameter(str7, "<anonymous parameter 3>");
            }

            @Override // kotlin.jvm.functions.Function8
            public /* bridge */ /* synthetic */ Unit invoke(AnkiDeck ankiDeck, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
                invoke2(ankiDeck, str5, str6, str7, str8, str9, str10, str11);
                return Unit.INSTANCE;
            }
        } : function8;
        Function1<? super AnkiDeck, Unit> function114 = (134217728 & i6) != 0 ? new Function1<AnkiDeck, Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$11
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AnkiDeck it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AnkiDeck ankiDeck) {
                invoke2(ankiDeck);
                return Unit.INSTANCE;
            }
        } : function17;
        Function0<Unit> function04 = (268435456 & i6) != 0 ? new Function0<Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$12
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : function02;
        Function3<? super List<Long>, ? super Boolean, ? super McqSessionMode, Unit> function32 = (1073741824 & i6) != 0 ? new Function3<List<? extends Long>, Boolean, McqSessionMode, Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$13
            public final void invoke(List<Long> list2, boolean z5, McqSessionMode mcqSessionMode) {
                Intrinsics.checkNotNullParameter(list2, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(mcqSessionMode, "<anonymous parameter 2>");
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Long> list2, Boolean bool, McqSessionMode mcqSessionMode) {
                invoke((List<Long>) list2, bool.booleanValue(), mcqSessionMode);
                return Unit.INSTANCE;
            }
        } : function3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(826355831, i2, i3, "com.example.flashcardapp.ui.DeckSelectionScreen (DeckSelectionScreen.kt:60)");
        }
        SnapshotStateKt.collectAsState(TranslationManager.INSTANCE.getCurrentLanguage(), null, startRestartGroup, 8, 1);
        startRestartGroup.startReplaceableGroup(932624339);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("Dashboard", null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        final boolean z5 = z4;
        final Function1<? super Boolean, Unit> function115 = function18;
        final List<CardAttemptEntity> list2 = emptyList;
        final Function0<Unit> function05 = function03;
        final Function1<? super AnkiDeck, Unit> function116 = function111;
        final Function2<? super AnkiDeck, ? super String, Unit> function25 = function23;
        final Function1<? super AnkiDeck, Unit> function117 = function112;
        final Function1<? super String, Unit> function118 = function113;
        final Function8<? super AnkiDeck, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, Unit> function83 = function82;
        final Function1<? super AnkiDeck, Unit> function119 = function114;
        final Function0<Unit> function06 = function04;
        final Function3<? super List<Long>, ? super Boolean, ? super McqSessionMode, Unit> function33 = function32;
        final String str5 = str3;
        final Function1<? super String, Unit> function120 = function19;
        final String str6 = str4;
        final Function1<? super String, Unit> function121 = function110;
        ScaffoldKt.m1788ScaffoldTvnljyQ(null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -976721156, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$14
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i7) {
                String DeckSelectionScreen$lambda$2;
                long m3452getTransparent0d7_KjU;
                String str7;
                String str8;
                List list3;
                MutableState<String> mutableState2;
                int i8;
                float f;
                Composer composer3 = composer2;
                if ((i7 & 11) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-976721156, i7, -1, "com.example.flashcardapp.ui.DeckSelectionScreen.<anonymous> (DeckSelectionScreen.kt:67)");
                    }
                    float f2 = 0.0f;
                    int i9 = 1;
                    Modifier m570paddingVpY3zN4 = PaddingKt.m570paddingVpY3zN4(WindowInsetsPadding_androidKt.navigationBarsPadding(BackgroundKt.m216backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m3452getTransparent0d7_KjU(), null, 2, null)), Dp.m5738constructorimpl(16), Dp.m5738constructorimpl(6));
                    Alignment bottomCenter = Alignment.INSTANCE.getBottomCenter();
                    final MutableState<String> mutableState3 = mutableState;
                    composer3.startReplaceableGroup(733328855);
                    String str9 = "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo";
                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(bottomCenter, false, composer3, 6);
                    composer3.startReplaceableGroup(-1323940314);
                    String str10 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m570paddingVpY3zN4);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer m2947constructorimpl = Updater.m2947constructorimpl(composer2);
                    Updater.m2954setimpl(m2947constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl.getInserting() || !Intrinsics.areEqual(m2947constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m2947constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m2947constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    String str11 = "C73@3426L9:Box.kt#2w3rfo";
                    ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    float f3 = 26;
                    Modifier m228borderxT4_qwU = BorderKt.m228borderxT4_qwU(BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(SizeKt.m604height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(52)), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f3))), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getSurface(), null, 2, null), Dp.m5738constructorimpl((float) 0.5d), Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOutlineVariant(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f3)));
                    Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    composer3.startReplaceableGroup(693286680);
                    String str12 = "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo";
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceEvenly, centerVertically, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m228borderxT4_qwU);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer3.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    Composer m2947constructorimpl2 = Updater.m2947constructorimpl(composer2);
                    Updater.m2954setimpl(m2947constructorimpl2, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl2.getInserting() || !Intrinsics.areEqual(m2947constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m2947constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m2947constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    modifierMaterializerOf2.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    String str13 = "C92@4661L9:Row.kt#2w3rfo";
                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    List listOf = CollectionsKt.listOf((Object[]) new Triple[]{new Triple("Dashboard", HomeKt.getHome(Icons.Filled.INSTANCE), androidx.compose.material.icons.outlined.HomeKt.getHome(Icons.Outlined.INSTANCE)), new Triple("Review", QuizKt.getQuiz(Icons.Filled.INSTANCE), androidx.compose.material.icons.outlined.QuizKt.getQuiz(Icons.Outlined.INSTANCE)), new Triple("Revise", StarKt.getStar(Icons.Filled.INSTANCE), androidx.compose.material.icons.outlined.StarKt.getStar(Icons.Outlined.INSTANCE)), new Triple("Analytics", AnalyticsKt.getAnalytics(Icons.Filled.INSTANCE), androidx.compose.material.icons.outlined.AnalyticsKt.getAnalytics(Icons.Outlined.INSTANCE)), new Triple("Settings", SettingsKt.getSettings(Icons.Filled.INSTANCE), androidx.compose.material.icons.outlined.SettingsKt.getSettings(Icons.Outlined.INSTANCE))});
                    List listOf2 = CollectionsKt.listOf((Object[]) new String[]{TranslationManager.INSTANCE.getString("tab_home"), TranslationManager.INSTANCE.getString("tab_library"), TranslationManager.INSTANCE.getString("tab_revise"), TranslationManager.INSTANCE.getString("tab_analytics"), TranslationManager.INSTANCE.getString("tab_settings")});
                    composer3.startReplaceableGroup(-957350430);
                    int i10 = 0;
                    for (Object obj : listOf) {
                        int i11 = i10 + 1;
                        if (i10 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        Triple triple = (Triple) obj;
                        final String str14 = (String) triple.component1();
                        ImageVector imageVector = (ImageVector) triple.component2();
                        ImageVector imageVector2 = (ImageVector) triple.component3();
                        DeckSelectionScreen$lambda$2 = DeckSelectionScreenKt.DeckSelectionScreen$lambda$2(mutableState3);
                        boolean areEqual = Intrinsics.areEqual(DeckSelectionScreen$lambda$2, str14);
                        Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), f2, i9, null);
                        float f4 = 4;
                        Modifier clip = ClipKt.clip(PaddingKt.m569padding3ABfNKs(fillMaxHeight$default, Dp.m5738constructorimpl(f4)), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(24)));
                        composer3.startReplaceableGroup(2138226782);
                        if (areEqual) {
                            m3452getTransparent0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary();
                        } else {
                            m3452getTransparent0d7_KjU = Color.INSTANCE.m3452getTransparent0d7_KjU();
                        }
                        composer2.endReplaceableGroup();
                        Modifier m216backgroundbw27NRU$default = BackgroundKt.m216backgroundbw27NRU$default(clip, m3452getTransparent0d7_KjU, null, 2, null);
                        composer3.startReplaceableGroup(-901998535);
                        boolean changed = composer3.changed(str14);
                        Object rememberedValue2 = composer2.rememberedValue();
                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$14$1$1$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    mutableState3.setValue(str14);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer2.endReplaceableGroup();
                        Modifier m251clickableXHw0xAI$default = ClickableKt.m251clickableXHw0xAI$default(m216backgroundbw27NRU$default, false, null, null, (Function0) rememberedValue2, 7, null);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, str9);
                        MutableState<String> mutableState4 = mutableState3;
                        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, false, composer3, 6);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, str10);
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m251clickableXHw0xAI$default);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer3.createNode(constructor3);
                        } else {
                            composer2.useNode();
                        }
                        Composer m2947constructorimpl3 = Updater.m2947constructorimpl(composer2);
                        Updater.m2954setimpl(m2947constructorimpl3, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, str11);
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                        Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f4));
                        Modifier m571paddingVpY3zN4$default = PaddingKt.m571paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m5738constructorimpl(8), 0.0f, 2, null);
                        composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer3, str12);
                        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m478spacedBy0680j_4, centerVertically2, composer3, 54);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, str10);
                        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(m571paddingVpY3zN4$default);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer3.createNode(constructor4);
                        } else {
                            composer2.useNode();
                        }
                        Composer m2947constructorimpl4 = Updater.m2947constructorimpl(composer2);
                        Updater.m2954setimpl(m2947constructorimpl4, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                            m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                            m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                        }
                        modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -326681643, str13);
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        ImageVector imageVector3 = areEqual ? imageVector : imageVector2;
                        String str15 = (String) listOf2.get(i10);
                        composer3.startReplaceableGroup(1401851031);
                        long m3454getWhite0d7_KjU = areEqual ? Color.INSTANCE.m3454getWhite0d7_KjU() : MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurfaceVariant();
                        composer2.endReplaceableGroup();
                        String str16 = str10;
                        long j = m3454getWhite0d7_KjU;
                        String str17 = str9;
                        String str18 = str11;
                        IconKt.m1605Iconww6aTOc(imageVector3, str15, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(22)), j, composer2, 384, 0);
                        composer3.startReplaceableGroup(-119551673);
                        if (areEqual) {
                            mutableState2 = mutableState4;
                            str7 = str13;
                            str8 = str12;
                            i8 = 1;
                            list3 = listOf2;
                            f = 0.0f;
                            TextKt.m2133Text4IGK_g((String) listOf2.get(i10), (Modifier) null, Color.INSTANCE.m3454getWhite0d7_KjU(), TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 200064, 0, 131026);
                        } else {
                            str7 = str13;
                            str8 = str12;
                            list3 = listOf2;
                            mutableState2 = mutableState4;
                            i8 = 1;
                            f = 0.0f;
                        }
                        composer2.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer3 = composer2;
                        str10 = str16;
                        mutableState3 = mutableState2;
                        str11 = str18;
                        str9 = str17;
                        str13 = str7;
                        i10 = i11;
                        str12 = str8;
                        i9 = i8;
                        listOf2 = list3;
                        f2 = f;
                    }
                    composer2.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), null, null, 0, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getBackground(), 0L, null, ComposableLambdaKt.composableLambda(startRestartGroup, 873732934, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$15
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer2, Integer num) {
                invoke(paddingValues, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            public final void invoke(PaddingValues paddingValues, Composer composer2, int i7) {
                int i8;
                String DeckSelectionScreen$lambda$2;
                Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                if ((i7 & 14) == 0) {
                    i8 = i7 | (composer2.changed(paddingValues) ? 4 : 2);
                } else {
                    i8 = i7;
                }
                if ((i8 & 91) == 18 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(873732934, i8, -1, "com.example.flashcardapp.ui.DeckSelectionScreen.<anonymous> (DeckSelectionScreen.kt:141)");
                }
                Modifier padding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues);
                List<AnkiDeck> list3 = decks;
                int i9 = i;
                List<SessionRecordEntity> list4 = sessionRecords;
                Function1<AnkiDeck, Unit> function122 = onSelectDeck;
                Function0<Unit> function07 = onProfileClicked;
                final boolean z6 = z5;
                final Function1<Boolean, Unit> function123 = function115;
                boolean z7 = z;
                boolean z8 = z2;
                List<CardAttemptEntity> list5 = list2;
                McqSessionMode mcqSessionMode = currentMode;
                Function0<Unit> function08 = onRequestPermission;
                Function0<Unit> function09 = onRefresh;
                Function0<Unit> function010 = onImportApkgClicked;
                Function0<Unit> function011 = onImportCsvClicked;
                Function0<Unit> function012 = function05;
                Function1<AnkiDeck, Unit> function124 = function116;
                Function2<AnkiDeck, String, Unit> function26 = function25;
                Function1<AnkiDeck, Unit> function125 = function117;
                Function1<String, Unit> function126 = function118;
                Function8<AnkiDeck, String, String, String, String, String, String, String, Unit> function84 = function83;
                Function1<AnkiDeck, Unit> function127 = function119;
                Function0<Unit> function013 = function06;
                AnkiDataRepository ankiDataRepository = repo;
                Function3<List<Long>, Boolean, McqSessionMode, Unit> function34 = function33;
                String str7 = str5;
                Function1<String, Unit> function128 = function120;
                String str8 = str6;
                Function1<String, Unit> function129 = function121;
                final MutableState<String> mutableState2 = mutableState;
                composer2.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer m2947constructorimpl = Updater.m2947constructorimpl(composer2);
                Updater.m2954setimpl(m2947constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2954setimpl(m2947constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m2947constructorimpl.getInserting() || !Intrinsics.areEqual(m2947constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m2947constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m2947constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                modifierMaterializerOf.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                DeckSelectionScreen$lambda$2 = DeckSelectionScreenKt.DeckSelectionScreen$lambda$2(mutableState2);
                switch (DeckSelectionScreen$lambda$2.hashCode()) {
                    case -1850481800:
                        if (DeckSelectionScreen$lambda$2.equals("Review")) {
                            composer2.startReplaceableGroup(-957347509);
                            ReviewTabKt.ReviewTab(z7, z8, list3, list5, mcqSessionMode, z6, function123, function08, function09, function010, function011, function012, null, function122, function124, function26, function125, function126, function84, function127, new Function0<Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$15$1$4
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }
                            }, function013, composer2, 4608, 0, 6, 4096);
                            composer2.endReplaceableGroup();
                            break;
                        }
                        composer2.startReplaceableGroup(-957345449);
                        composer2.endReplaceableGroup();
                        break;
                    case -1850481384:
                        if (DeckSelectionScreen$lambda$2.equals("Revise")) {
                            composer2.startReplaceableGroup(-957346355);
                            composer2.startReplaceableGroup(-957346166);
                            boolean changedInstance = composer2.changedInstance(function123) | composer2.changed(z6);
                            Object rememberedValue2 = composer2.rememberedValue();
                            if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$15$1$5$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        function123.invoke(Boolean.valueOf(!z6));
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue2);
                            }
                            composer2.endReplaceableGroup();
                            ReviseTabKt.ReviseTab(ankiDataRepository, function34, z6, (Function0) rememberedValue2, composer2, 8);
                            composer2.endReplaceableGroup();
                            break;
                        }
                        composer2.startReplaceableGroup(-957345449);
                        composer2.endReplaceableGroup();
                        break;
                    case 310950758:
                        if (DeckSelectionScreen$lambda$2.equals("Analytics")) {
                            composer2.startReplaceableGroup(-957346083);
                            AnalyticsTabKt.AnalyticsTab(i9, list4, new Function0<Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$15$1$6
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }
                            }, composer2, 448);
                            composer2.endReplaceableGroup();
                            break;
                        }
                        composer2.startReplaceableGroup(-957345449);
                        composer2.endReplaceableGroup();
                        break;
                    case 956107380:
                        if (DeckSelectionScreen$lambda$2.equals("Dashboard")) {
                            composer2.startReplaceableGroup(-957348113);
                            composer2.startReplaceableGroup(-957347877);
                            Object rememberedValue3 = composer2.rememberedValue();
                            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$15$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        mutableState2.setValue("Review");
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue3);
                            }
                            Function0 function014 = (Function0) rememberedValue3;
                            composer2.endReplaceableGroup();
                            composer2.startReplaceableGroup(-957347811);
                            Object rememberedValue4 = composer2.rememberedValue();
                            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$15$1$2$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        mutableState2.setValue("Settings");
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue4);
                            }
                            Function0 function015 = (Function0) rememberedValue4;
                            composer2.endReplaceableGroup();
                            composer2.startReplaceableGroup(-957347685);
                            Object rememberedValue5 = composer2.rememberedValue();
                            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue5 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$15$1$3$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        mutableState2.setValue("Analytics");
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue5);
                            }
                            composer2.endReplaceableGroup();
                            DashboardTabKt.DashboardTab(list3, i9, list4, function122, function014, function015, function07, (Function0) rememberedValue5, z6, function123, composer2, 12804616, 0);
                            composer2.endReplaceableGroup();
                            break;
                        }
                        composer2.startReplaceableGroup(-957345449);
                        composer2.endReplaceableGroup();
                        break;
                    case 1499275331:
                        if (DeckSelectionScreen$lambda$2.equals("Settings")) {
                            composer2.startReplaceableGroup(-957345886);
                            SettingsTabKt.SettingsTab(z6, function123, str7, function128, str8, function129, function07, composer2, 0);
                            composer2.endReplaceableGroup();
                            break;
                        }
                        composer2.startReplaceableGroup(-957345449);
                        composer2.endReplaceableGroup();
                        break;
                    default:
                        composer2.startReplaceableGroup(-957345449);
                        composer2.endReplaceableGroup();
                        break;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), startRestartGroup, 805306752, 443);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Function1<? super Boolean, Unit> function122 = function18;
            final String str7 = str3;
            final Function1<? super String, Unit> function123 = function19;
            final String str8 = str4;
            final Function1<? super String, Unit> function124 = function110;
            final List<CardAttemptEntity> list3 = emptyList;
            final Function0<Unit> function07 = function03;
            final Function1<? super AnkiDeck, Unit> function125 = function111;
            final Function2<? super AnkiDeck, ? super String, Unit> function26 = function23;
            final Function1<? super AnkiDeck, Unit> function126 = function112;
            final Function1<? super String, Unit> function127 = function113;
            final Function2<? super AnkiDeck, ? super AnkiDeck, Unit> function27 = function24;
            final Function8<? super AnkiDeck, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, Unit> function84 = function82;
            final Function1<? super AnkiDeck, Unit> function128 = function114;
            final Function0<Unit> function08 = function04;
            final Function3<? super List<Long>, ? super Boolean, ? super McqSessionMode, Unit> function34 = function32;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.DeckSelectionScreenKt$DeckSelectionScreen$16
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    DeckSelectionScreenKt.DeckSelectionScreen(z, z2, z4, function122, str7, function123, str8, function124, decks, currentMode, i, sessionRecords, list3, onRequestPermission, onRefresh, onSettingsClicked, onImportApkgClicked, onImportCsvClicked, function07, onSelectDeck, onProfileClicked, function125, function26, function126, function127, function27, function84, function128, function08, repo, function34, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), RecomposeScopeImplKt.updateChangedFlags(i4), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String DeckSelectionScreen$lambda$2(MutableState<String> mutableState) {
        return mutableState.getValue();
    }
}

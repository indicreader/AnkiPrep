package com.example.flashcardapp.ui;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextFieldColors;
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
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.location.LocationRequestCompat;
import com.example.flashcardapp.data.AnkiDeck;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ImportDeckDialog.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\u001a¶\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b26\u0010\t\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00010\n2K\u0010\u000f\u001aG\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015²\u0006\n\u0010\u0016\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\f\u0010\u0018\u001a\u0004\u0018\u00010\u0006X\u008a\u008e\u0002²\u0006\n\u0010\u000e\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u001aX\u008a\u008e\u0002"}, d2 = {"ImportDeckDialog", "", "fileType", "", "decks", "", "Lcom/example/flashcardapp/data/AnkiDeck;", "onDismiss", "Lkotlin/Function0;", "onNewDeck", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "customName", "duplicateStrategy", "onMergeIntoDeck", "Lkotlin/Function3;", "", "targetId", "targetName", "(Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "app_release", "importMode", "customDeckName", "selectedDeck", "deckDropdownExpanded", "", "dupDropdownExpanded"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ImportDeckDialogKt {
    public static final void ImportDeckDialog(final String fileType, final List<AnkiDeck> decks, final Function0<Unit> onDismiss, final Function2<? super String, ? super String, Unit> onNewDeck, final Function3<? super Long, ? super String, ? super String, Unit> onMergeIntoDeck, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(fileType, "fileType");
        Intrinsics.checkNotNullParameter(decks, "decks");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onNewDeck, "onNewDeck");
        Intrinsics.checkNotNullParameter(onMergeIntoDeck, "onMergeIntoDeck");
        Composer startRestartGroup = composer.startRestartGroup(-1373699408);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1373699408, i, -1, "com.example.flashcardapp.ui.ImportDeckDialog (ImportDeckDialog.kt:26)");
        }
        startRestartGroup.startReplaceableGroup(1436171770);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("NEW", null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(1436171851);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        final MutableState mutableState2 = (MutableState) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(1436171907);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.firstOrNull((List) decks), null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        final MutableState mutableState3 = (MutableState) rememberedValue3;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(1436171996);
        Object rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("UPDATE", null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue4);
        }
        final MutableState mutableState4 = (MutableState) rememberedValue4;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(1436172096);
        Object rememberedValue5 = startRestartGroup.rememberedValue();
        if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
            rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue5);
        }
        final MutableState mutableState5 = (MutableState) rememberedValue5;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(1436172162);
        Object rememberedValue6 = startRestartGroup.rememberedValue();
        if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
            rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue6);
        }
        final MutableState mutableState6 = (MutableState) rememberedValue6;
        startRestartGroup.endReplaceableGroup();
        AndroidDialog_androidKt.Dialog(onDismiss, null, ComposableLambdaKt.composableLambda(startRestartGroup, 2099428665, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ImportDeckDialogKt$ImportDeckDialog$1
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

            public final void invoke(Composer composer2, int i2) {
                if ((i2 & 11) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2099428665, i2, -1, "com.example.flashcardapp.ui.ImportDeckDialog.<anonymous> (ImportDeckDialog.kt:35)");
                    }
                    RoundedCornerShape m839RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(28));
                    long surface = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getSurface();
                    float m5738constructorimpl = Dp.m5738constructorimpl(6);
                    final String str = fileType;
                    final List<AnkiDeck> list = decks;
                    final MutableState<String> mutableState7 = mutableState;
                    final MutableState<String> mutableState8 = mutableState2;
                    final MutableState<Boolean> mutableState9 = mutableState5;
                    final MutableState<AnkiDeck> mutableState10 = mutableState3;
                    final MutableState<Boolean> mutableState11 = mutableState6;
                    final MutableState<String> mutableState12 = mutableState4;
                    final Function0<Unit> function0 = onDismiss;
                    final Function2<String, String, Unit> function2 = onNewDeck;
                    final Function3<Long, String, String, Unit> function3 = onMergeIntoDeck;
                    SurfaceKt.m1985SurfaceT9BRK9s(PaddingKt.m569padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(16)), m839RoundedCornerShape0680j_4, surface, 0L, m5738constructorimpl, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, 549264702, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ImportDeckDialogKt$ImportDeckDialog$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i3) {
                            String ImportDeckDialog$lambda$1;
                            final MutableState<String> mutableState13;
                            String ImportDeckDialog$lambda$12;
                            final MutableState<String> mutableState14;
                            String ImportDeckDialog$lambda$13;
                            final MutableState<Boolean> mutableState15;
                            final MutableState<AnkiDeck> mutableState16;
                            String str2;
                            String str3;
                            String str4;
                            boolean ImportDeckDialog$lambda$132;
                            final MutableState<Boolean> mutableState17;
                            final MutableState<Boolean> mutableState18;
                            boolean ImportDeckDialog$lambda$16;
                            final MutableState<Boolean> mutableState19;
                            String ImportDeckDialog$lambda$4;
                            final MutableState<String> mutableState20;
                            if ((i3 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(549264702, i3, -1, "com.example.flashcardapp.ui.ImportDeckDialog.<anonymous>.<anonymous> (ImportDeckDialog.kt:41)");
                                }
                                Modifier verticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(24)), ScrollKt.rememberScrollState(0, composer3, 0, 1), false, null, false, 14, null);
                                Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(16));
                                String str5 = str;
                                final List<AnkiDeck> list2 = list;
                                MutableState<String> mutableState21 = mutableState7;
                                MutableState<String> mutableState22 = mutableState8;
                                MutableState<Boolean> mutableState23 = mutableState9;
                                MutableState<AnkiDeck> mutableState24 = mutableState10;
                                MutableState<Boolean> mutableState25 = mutableState11;
                                final MutableState<String> mutableState26 = mutableState12;
                                Function0<Unit> function02 = function0;
                                final Function2<String, String, Unit> function22 = function2;
                                final Function3<Long, String, String, Unit> function32 = function3;
                                composer3.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer3, 6);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(verticalScroll$default);
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m2947constructorimpl = Updater.m2947constructorimpl(composer3);
                                Updater.m2954setimpl(m2947constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m2954setimpl(m2947constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m2947constructorimpl.getInserting() || !Intrinsics.areEqual(m2947constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m2947constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m2947constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                MutableState<String> mutableState27 = mutableState22;
                                TextKt.m2133Text4IGK_g("Import " + str5, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getHeadlineSmall(), composer3, 0, 0, 65530);
                                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                float f = 8;
                                Arrangement.HorizontalOrVertical m478spacedBy0680j_42 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f));
                                composer3.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m478spacedBy0680j_42, Alignment.INSTANCE.getTop(), composer3, 6);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor2);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m2947constructorimpl2 = Updater.m2947constructorimpl(composer3);
                                Updater.m2954setimpl(m2947constructorimpl2, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m2954setimpl(m2947constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m2947constructorimpl2.getInserting() || !Intrinsics.areEqual(m2947constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m2947constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m2947constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                modifierMaterializerOf2.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                ImportDeckDialog$lambda$1 = ImportDeckDialogKt.ImportDeckDialog$lambda$1(mutableState21);
                                boolean areEqual = Intrinsics.areEqual(ImportDeckDialog$lambda$1, "NEW");
                                composer3.startReplaceableGroup(-1129821366);
                                Object rememberedValue7 = composer3.rememberedValue();
                                if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                    mutableState13 = mutableState21;
                                    rememberedValue7 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ImportDeckDialogKt$ImportDeckDialog$1$1$1$1$1$1
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
                                            mutableState13.setValue("NEW");
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue7);
                                } else {
                                    mutableState13 = mutableState21;
                                }
                                composer3.endReplaceableGroup();
                                MutableState<String> mutableState28 = mutableState13;
                                ChipKt.FilterChip(areEqual, (Function0) rememberedValue7, ComposableSingletons$ImportDeckDialogKt.INSTANCE.m6150getLambda1$app_release(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, null, null, null, null, null, null, composer3, 432, 0, 4080);
                                ImportDeckDialog$lambda$12 = ImportDeckDialogKt.ImportDeckDialog$lambda$1(mutableState28);
                                boolean areEqual2 = Intrinsics.areEqual(ImportDeckDialog$lambda$12, "MERGE");
                                composer3.startReplaceableGroup(-1129821080);
                                Object rememberedValue8 = composer3.rememberedValue();
                                if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                    mutableState14 = mutableState28;
                                    rememberedValue8 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ImportDeckDialogKt$ImportDeckDialog$1$1$1$1$2$1
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
                                            mutableState14.setValue("MERGE");
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue8);
                                } else {
                                    mutableState14 = mutableState28;
                                }
                                composer3.endReplaceableGroup();
                                final MutableState<String> mutableState29 = mutableState14;
                                ChipKt.FilterChip(areEqual2, (Function0) rememberedValue8, ComposableSingletons$ImportDeckDialogKt.INSTANCE.m6151getLambda2$app_release(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), !list2.isEmpty(), null, null, null, null, null, null, null, composer3, 432, 0, 4064);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                ImportDeckDialog$lambda$13 = ImportDeckDialogKt.ImportDeckDialog$lambda$1(mutableState29);
                                if (Intrinsics.areEqual(ImportDeckDialog$lambda$13, "NEW")) {
                                    composer3.startReplaceableGroup(2022869473);
                                    ImportDeckDialog$lambda$4 = ImportDeckDialogKt.ImportDeckDialog$lambda$4(mutableState27);
                                    Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    composer3.startReplaceableGroup(2022869602);
                                    Object rememberedValue9 = composer3.rememberedValue();
                                    if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                        mutableState20 = mutableState27;
                                        rememberedValue9 = (Function1) new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.ImportDeckDialogKt$ImportDeckDialog$1$1$1$2$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(String str6) {
                                                invoke2(str6);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(String it) {
                                                Intrinsics.checkNotNullParameter(it, "it");
                                                mutableState20.setValue(it);
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue9);
                                    } else {
                                        mutableState20 = mutableState27;
                                    }
                                    composer3.endReplaceableGroup();
                                    mutableState27 = mutableState20;
                                    OutlinedTextFieldKt.OutlinedTextField(ImportDeckDialog$lambda$4, (Function1<? super String, Unit>) rememberedValue9, fillMaxWidth$default2, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$ImportDeckDialogKt.INSTANCE.m6152getLambda3$app_release(), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$ImportDeckDialogKt.INSTANCE.m6153getLambda4$app_release(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer3, 14156208, 12582912, 0, 8257336);
                                    composer3.endReplaceableGroup();
                                    mutableState16 = mutableState24;
                                    str3 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
                                    str4 = "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo";
                                    str2 = "C73@3426L9:Box.kt#2w3rfo";
                                } else {
                                    composer3.startReplaceableGroup(2022869917);
                                    Modifier fillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    composer3.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default3);
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor3);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m2947constructorimpl3 = Updater.m2947constructorimpl(composer3);
                                    Updater.m2954setimpl(m2947constructorimpl3, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                        m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                        m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                    }
                                    modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    composer3.startReplaceableGroup(-1129820156);
                                    Object rememberedValue10 = composer3.rememberedValue();
                                    if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                        mutableState15 = mutableState23;
                                        rememberedValue10 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ImportDeckDialogKt$ImportDeckDialog$1$1$1$3$1$1
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
                                                ImportDeckDialogKt.ImportDeckDialog$lambda$14(mutableState15, true);
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue10);
                                    } else {
                                        mutableState15 = mutableState23;
                                    }
                                    composer3.endReplaceableGroup();
                                    mutableState16 = mutableState24;
                                    MutableState<Boolean> mutableState30 = mutableState15;
                                    str2 = "C73@3426L9:Box.kt#2w3rfo";
                                    str3 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
                                    str4 = "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo";
                                    ButtonKt.OutlinedButton((Function0) rememberedValue10, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f)), null, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, -1011895472, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ImportDeckDialogKt$ImportDeckDialog$1$1$1$3$2
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                                            invoke(rowScope, composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(RowScope OutlinedButton, Composer composer4, int i4) {
                                            AnkiDeck ImportDeckDialog$lambda$7;
                                            String str6;
                                            Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
                                            if ((i4 & 81) != 16 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1011895472, i4, -1, "com.example.flashcardapp.ui.ImportDeckDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ImportDeckDialog.kt:90)");
                                                }
                                                Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                Modifier fillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                MutableState<AnkiDeck> mutableState31 = mutableState16;
                                                composer4.startReplaceableGroup(693286680);
                                                ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer4, 54);
                                                composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                CompositionLocalMap currentCompositionLocalMap4 = composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default4);
                                                if (!(composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer4.startReusableNode();
                                                if (composer4.getInserting()) {
                                                    composer4.createNode(constructor4);
                                                } else {
                                                    composer4.useNode();
                                                }
                                                Composer m2947constructorimpl4 = Updater.m2947constructorimpl(composer4);
                                                Updater.m2954setimpl(m2947constructorimpl4, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                                    m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                                    m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                                }
                                                modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                                composer4.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                                ImportDeckDialog$lambda$7 = ImportDeckDialogKt.ImportDeckDialog$lambda$7(mutableState31);
                                                if (ImportDeckDialog$lambda$7 == null || (str6 = ImportDeckDialog$lambda$7.getName()) == null) {
                                                    str6 = "Select Deck";
                                                }
                                                TextKt.m2133Text4IGK_g(str6, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 0, 0, 131066);
                                                IconKt.m1605Iconww6aTOc(ArrowDropDownKt.getArrowDropDown(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, composer4, 48, 12);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                composer4.endReplaceableGroup();
                                                composer4.endNode();
                                                composer4.endReplaceableGroup();
                                                composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }), composer3, 805306422, 500);
                                    ImportDeckDialog$lambda$132 = ImportDeckDialogKt.ImportDeckDialog$lambda$13(mutableState30);
                                    composer3.startReplaceableGroup(-1129819149);
                                    Object rememberedValue11 = composer3.rememberedValue();
                                    if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                        mutableState17 = mutableState30;
                                        rememberedValue11 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ImportDeckDialogKt$ImportDeckDialog$1$1$1$3$3$1
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
                                                ImportDeckDialogKt.ImportDeckDialog$lambda$14(mutableState17, false);
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue11);
                                    } else {
                                        mutableState17 = mutableState30;
                                    }
                                    composer3.endReplaceableGroup();
                                    AndroidMenu_androidKt.m1233DropdownMenu4kj_NE(ImportDeckDialog$lambda$132, (Function0) rememberedValue11, null, 0L, null, null, ComposableLambdaKt.composableLambda(composer3, 117693201, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ImportDeckDialogKt$ImportDeckDialog$1$1$1$3$4
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer4, Integer num) {
                                            invoke(columnScope, composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(ColumnScope DropdownMenu, Composer composer4, int i4) {
                                            Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
                                            if ((i4 & 81) != 16 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(117693201, i4, -1, "com.example.flashcardapp.ui.ImportDeckDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ImportDeckDialog.kt:106)");
                                                }
                                                List<AnkiDeck> list3 = list2;
                                                final MutableState<AnkiDeck> mutableState31 = mutableState16;
                                                final MutableState<Boolean> mutableState32 = mutableState17;
                                                for (final AnkiDeck ankiDeck : list3) {
                                                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer4, 2067697812, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ImportDeckDialogKt$ImportDeckDialog$1$1$1$3$4$1$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                            invoke(composer5, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer5, int i5) {
                                                            if ((i5 & 11) == 2 && composer5.getSkipping()) {
                                                                composer5.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(2067697812, i5, -1, "com.example.flashcardapp.ui.ImportDeckDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ImportDeckDialog.kt:108)");
                                                            }
                                                            TextKt.m2133Text4IGK_g(AnkiDeck.this.getName(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer5, 0, 0, 131070);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    });
                                                    composer4.startReplaceableGroup(-642392128);
                                                    boolean changed = composer4.changed(ankiDeck);
                                                    Object rememberedValue12 = composer4.rememberedValue();
                                                    if (changed || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue12 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ImportDeckDialogKt$ImportDeckDialog$1$1$1$3$4$1$2$1
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
                                                                mutableState31.setValue(AnkiDeck.this);
                                                                ImportDeckDialogKt.ImportDeckDialog$lambda$14(mutableState32, false);
                                                            }
                                                        };
                                                        composer4.updateRememberedValue(rememberedValue12);
                                                    }
                                                    composer4.endReplaceableGroup();
                                                    AndroidMenu_androidKt.DropdownMenuItem(composableLambda, (Function0) rememberedValue12, null, null, null, false, null, null, null, composer4, 6, 508);
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }), composer3, 1572912, 60);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                }
                                final MutableState<AnkiDeck> mutableState31 = mutableState16;
                                TextKt.m2133Text4IGK_g("Duplicate Handling", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getTitleMedium(), composer3, 6, 0, 65530);
                                Modifier fillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                composer3.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer3, str4);
                                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                composer3.startReplaceableGroup(-1323940314);
                                String str6 = str3;
                                ComposerKt.sourceInformation(composer3, str6);
                                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default4);
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor4);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m2947constructorimpl4 = Updater.m2947constructorimpl(composer3);
                                Updater.m2954setimpl(m2947constructorimpl4, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                    m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                    m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                }
                                modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, str2);
                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                composer3.startReplaceableGroup(-1129818180);
                                Object rememberedValue12 = composer3.rememberedValue();
                                if (rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                    mutableState18 = mutableState25;
                                    rememberedValue12 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ImportDeckDialogKt$ImportDeckDialog$1$1$1$4$1$1
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
                                            ImportDeckDialogKt.ImportDeckDialog$lambda$17(mutableState18, true);
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue12);
                                } else {
                                    mutableState18 = mutableState25;
                                }
                                composer3.endReplaceableGroup();
                                MutableState<Boolean> mutableState32 = mutableState18;
                                ButtonKt.OutlinedButton((Function0) rememberedValue12, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f)), null, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, -1019720532, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ImportDeckDialogKt$ImportDeckDialog$1$1$1$4$2
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                                        invoke(rowScope, composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(RowScope OutlinedButton, Composer composer4, int i4) {
                                        String ImportDeckDialog$lambda$10;
                                        String str7;
                                        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
                                        if ((i4 & 81) != 16 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1019720532, i4, -1, "com.example.flashcardapp.ui.ImportDeckDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ImportDeckDialog.kt:132)");
                                            }
                                            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Modifier fillMaxWidth$default5 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            MutableState<String> mutableState33 = mutableState26;
                                            composer4.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer4, 54);
                                            composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap5 = composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default5);
                                            if (!(composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer4.startReusableNode();
                                            if (composer4.getInserting()) {
                                                composer4.createNode(constructor5);
                                            } else {
                                                composer4.useNode();
                                            }
                                            Composer m2947constructorimpl5 = Updater.m2947constructorimpl(composer4);
                                            Updater.m2954setimpl(m2947constructorimpl5, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m2954setimpl(m2947constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m2947constructorimpl5.getInserting() || !Intrinsics.areEqual(m2947constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                                                m2947constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                                                m2947constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                                            }
                                            modifierMaterializerOf5.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                            composer4.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                            ImportDeckDialog$lambda$10 = ImportDeckDialogKt.ImportDeckDialog$lambda$10(mutableState33);
                                            if (Intrinsics.areEqual(ImportDeckDialog$lambda$10, "SKIP")) {
                                                str7 = "Skip Duplicates";
                                            } else {
                                                str7 = Intrinsics.areEqual(ImportDeckDialog$lambda$10, "IMPORT") ? "Import Duplicates" : "Update Existing (Overwrite)";
                                            }
                                            TextKt.m2133Text4IGK_g(str7, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 0, 0, 131066);
                                            IconKt.m1605Iconww6aTOc(ArrowDropDownKt.getArrowDropDown(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, composer4, 48, 12);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            composer4.endReplaceableGroup();
                                            composer4.endNode();
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 805306422, 500);
                                ImportDeckDialog$lambda$16 = ImportDeckDialogKt.ImportDeckDialog$lambda$16(mutableState32);
                                composer3.startReplaceableGroup(-1129817064);
                                Object rememberedValue13 = composer3.rememberedValue();
                                if (rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                                    mutableState19 = mutableState32;
                                    rememberedValue13 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ImportDeckDialogKt$ImportDeckDialog$1$1$1$4$3$1
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
                                            ImportDeckDialogKt.ImportDeckDialog$lambda$17(mutableState19, false);
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue13);
                                } else {
                                    mutableState19 = mutableState32;
                                }
                                composer3.endReplaceableGroup();
                                AndroidMenu_androidKt.m1233DropdownMenu4kj_NE(ImportDeckDialog$lambda$16, (Function0) rememberedValue13, null, 0L, null, null, ComposableLambdaKt.composableLambda(composer3, 518833517, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ImportDeckDialogKt$ImportDeckDialog$1$1$1$4$4
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer4, Integer num) {
                                        invoke(columnScope, composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ColumnScope DropdownMenu, Composer composer4, int i4) {
                                        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
                                        if ((i4 & 81) != 16 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(518833517, i4, -1, "com.example.flashcardapp.ui.ImportDeckDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ImportDeckDialog.kt:150)");
                                            }
                                            List<Pair> listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("UPDATE", "Update Existing (Overwrite)"), TuplesKt.to("SKIP", "Skip Duplicates"), TuplesKt.to("IMPORT", "Import Duplicates")});
                                            final MutableState<String> mutableState33 = mutableState26;
                                            final MutableState<Boolean> mutableState34 = mutableState19;
                                            for (Pair pair : listOf) {
                                                final String str7 = (String) pair.component1();
                                                final String str8 = (String) pair.component2();
                                                ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer4, -1682903242, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ImportDeckDialogKt$ImportDeckDialog$1$1$1$4$4$1$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                        invoke(composer5, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer5, int i5) {
                                                        if ((i5 & 11) == 2 && composer5.getSkipping()) {
                                                            composer5.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1682903242, i5, -1, "com.example.flashcardapp.ui.ImportDeckDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ImportDeckDialog.kt:156)");
                                                        }
                                                        TextKt.m2133Text4IGK_g(str8, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer5, 0, 0, 131070);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                });
                                                composer4.startReplaceableGroup(-642389836);
                                                boolean changed = composer4.changed(str7);
                                                Object rememberedValue14 = composer4.rememberedValue();
                                                if (changed || rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue14 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ImportDeckDialogKt$ImportDeckDialog$1$1$1$4$4$1$2$1
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
                                                            mutableState33.setValue(str7);
                                                            ImportDeckDialogKt.ImportDeckDialog$lambda$17(mutableState34, false);
                                                        }
                                                    };
                                                    composer4.updateRememberedValue(rememberedValue14);
                                                }
                                                composer4.endReplaceableGroup();
                                                AndroidMenu_androidKt.DropdownMenuItem(composableLambda, (Function0) rememberedValue14, null, null, null, false, null, null, null, composer4, 6, 508);
                                                mutableState34 = mutableState34;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 1572912, 60);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f)), composer3, 6);
                                Modifier fillMaxWidth$default5 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                composer3.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(end, centerVertically, composer3, 54);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, str6);
                                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap5 = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default5);
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor5);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m2947constructorimpl5 = Updater.m2947constructorimpl(composer3);
                                Updater.m2954setimpl(m2947constructorimpl5, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m2954setimpl(m2947constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m2947constructorimpl5.getInserting() || !Intrinsics.areEqual(m2947constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                                    m2947constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                                    m2947constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                                }
                                modifierMaterializerOf5.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                ButtonKt.TextButton(function02, null, false, null, null, null, null, null, null, ComposableSingletons$ImportDeckDialogKt.INSTANCE.m6154getLambda5$app_release(), composer3, 805306368, 510);
                                SpacerKt.Spacer(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f)), composer3, 6);
                                composer3.startReplaceableGroup(-1129815784);
                                boolean changedInstance = composer3.changedInstance(function22) | composer3.changedInstance(function32);
                                Object rememberedValue14 = composer3.rememberedValue();
                                if (changedInstance || rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                                    final MutableState<String> mutableState33 = mutableState27;
                                    rememberedValue14 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ImportDeckDialogKt$ImportDeckDialog$1$1$1$5$1$1
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
                                            String ImportDeckDialog$lambda$14;
                                            AnkiDeck ImportDeckDialog$lambda$7;
                                            String ImportDeckDialog$lambda$10;
                                            String ImportDeckDialog$lambda$42;
                                            String ImportDeckDialog$lambda$102;
                                            ImportDeckDialog$lambda$14 = ImportDeckDialogKt.ImportDeckDialog$lambda$1(mutableState29);
                                            if (Intrinsics.areEqual(ImportDeckDialog$lambda$14, "NEW")) {
                                                Function2<String, String, Unit> function23 = function22;
                                                ImportDeckDialog$lambda$42 = ImportDeckDialogKt.ImportDeckDialog$lambda$4(mutableState33);
                                                String obj = StringsKt.trim((CharSequence) ImportDeckDialog$lambda$42).toString();
                                                ImportDeckDialog$lambda$102 = ImportDeckDialogKt.ImportDeckDialog$lambda$10(mutableState26);
                                                function23.invoke(obj, ImportDeckDialog$lambda$102);
                                                return;
                                            }
                                            ImportDeckDialog$lambda$7 = ImportDeckDialogKt.ImportDeckDialog$lambda$7(mutableState31);
                                            if (ImportDeckDialog$lambda$7 != null) {
                                                Function3<Long, String, String, Unit> function33 = function32;
                                                MutableState<String> mutableState34 = mutableState26;
                                                Long valueOf = Long.valueOf(ImportDeckDialog$lambda$7.getId());
                                                String name = ImportDeckDialog$lambda$7.getName();
                                                ImportDeckDialog$lambda$10 = ImportDeckDialogKt.ImportDeckDialog$lambda$10(mutableState34);
                                                function33.invoke(valueOf, name, ImportDeckDialog$lambda$10);
                                            }
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue14);
                                }
                                composer3.endReplaceableGroup();
                                ButtonKt.Button((Function0) rememberedValue14, null, false, null, null, null, null, null, null, ComposableSingletons$ImportDeckDialogKt.INSTANCE.m6155getLambda6$app_release(), composer3, 805306368, 510);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, 12607494, LocationRequestCompat.QUALITY_LOW_POWER);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, ((i >> 6) & 14) | 384, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ImportDeckDialogKt$ImportDeckDialog$2
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

                public final void invoke(Composer composer2, int i2) {
                    ImportDeckDialogKt.ImportDeckDialog(fileType, decks, onDismiss, onNewDeck, onMergeIntoDeck, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ImportDeckDialog$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ImportDeckDialog$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnkiDeck ImportDeckDialog$lambda$7(MutableState<AnkiDeck> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ImportDeckDialog$lambda$10(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ImportDeckDialog$lambda$13(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ImportDeckDialog$lambda$14(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ImportDeckDialog$lambda$16(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ImportDeckDialog$lambda$17(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }
}

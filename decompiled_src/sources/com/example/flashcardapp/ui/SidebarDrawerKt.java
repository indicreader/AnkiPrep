package com.example.flashcardapp.ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRightKt;
import androidx.compose.material.icons.automirrored.filled.ListKt;
import androidx.compose.material.icons.outlined.KeyboardArrowDownKt;
import androidx.compose.material.icons.outlined.MenuKt;
import androidx.compose.material.icons.outlined.PlayArrowKt;
import androidx.compose.material.icons.outlined.SettingsKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
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
import androidx.profileinstaller.ProfileVerifier;
import com.example.flashcardapp.data.AnkiDeck;
import com.example.flashcardapp.ui.theme.ThemeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SidebarDrawer.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\u001a[\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bH\u0003¢\u0006\u0002\u0010\u000e\u001am\u0010\u000f\u001a\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"SidebarDeckRow", "", "node", "Lcom/example/flashcardapp/ui/DeckNode;", "depth", "", "isExpanded", "", "onToggleExpand", "Lkotlin/Function0;", "onPlay", "Lkotlin/Function1;", "Lcom/example/flashcardapp/data/AnkiDeck;", "onSettings", "(Lcom/example/flashcardapp/ui/DeckNode;IZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SidebarDrawerContent", "decks", "", "onSelectDeck", "onDeckSettings", "onGlobalSettings", "onProfileClicked", "onClose", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class SidebarDrawerKt {
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0e88, code lost:
    
        if (r14.changedInstance(r1) == false) goto L239;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0166, code lost:
    
        if (r9 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0f23  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0f2f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x1006  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x100f  */
    /* JADX WARN: Removed duplicated region for block: B:193:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0f33  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SidebarDrawerContent(final java.util.List<com.example.flashcardapp.data.AnkiDeck> r57, final kotlin.jvm.functions.Function1<? super com.example.flashcardapp.data.AnkiDeck, kotlin.Unit> r58, final kotlin.jvm.functions.Function1<? super com.example.flashcardapp.data.AnkiDeck, kotlin.Unit> r59, final kotlin.jvm.functions.Function0<kotlin.Unit> r60, final kotlin.jvm.functions.Function0<kotlin.Unit> r61, final kotlin.jvm.functions.Function0<kotlin.Unit> r62, androidx.compose.runtime.Composer r63, final int r64) {
        /*
            Method dump skipped, instructions count: 4137
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.ui.SidebarDrawerKt.SidebarDrawerContent(java.util.List, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    private static final void SidebarDrawerContent$lambda$5$traverse(List<Pair<DeckNode, Integer>> list, SnapshotStateMap<String, Boolean> snapshotStateMap, List<DeckNode> list2, int i) {
        for (DeckNode deckNode : list2) {
            list.add(TuplesKt.to(deckNode, Integer.valueOf(i)));
            if (Intrinsics.areEqual((Object) snapshotStateMap.get(deckNode.getFullPath()), (Object) true) && (!deckNode.getChildren().isEmpty())) {
                SidebarDrawerContent$lambda$5$traverse(list, snapshotStateMap, deckNode.getChildren(), i + 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean, int] */
    public static final void SidebarDeckRow(final DeckNode deckNode, final int i, final boolean z, final Function0<Unit> function0, final Function1<? super AnkiDeck, Unit> function1, final Function1<? super AnkiDeck, Unit> function12, Composer composer, final int i2) {
        String str;
        float f;
        float f2;
        ?? r4;
        int i3;
        int i4;
        boolean z2;
        Composer startRestartGroup = composer.startRestartGroup(2109333124);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2109333124, i2, -1, "com.example.flashcardapp.ui.SidebarDeckRow (SidebarDrawer.kt:297)");
        }
        boolean z3 = !deckNode.getChildren().isEmpty();
        final AnkiDeck deck = deckNode.getDeck();
        if (deck == null) {
            deck = new AnkiDeck(-1L, deckNode.getFullPath(), 0, 4, null);
        }
        float f3 = 12;
        float f4 = 8;
        float f5 = 10;
        Modifier m570paddingVpY3zN4 = PaddingKt.m570paddingVpY3zN4(BorderKt.m228borderxT4_qwU(BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m573paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(i * 14), 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f3))), i == 0 ? ColorKt.Color(4294571774L) : Color.INSTANCE.m3452getTransparent0d7_KjU(), null, 2, null), Dp.m5738constructorimpl(i == 0 ? 1 : 0), ColorKt.Color(4293649402L), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f3))), Dp.m5738constructorimpl(f5), Dp.m5738constructorimpl(f4));
        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
        startRestartGroup.startReplaceableGroup(693286680);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m570paddingVpY3zN4);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        Composer m2947constructorimpl = Updater.m2947constructorimpl(startRestartGroup);
        Updater.m2954setimpl(m2947constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2954setimpl(m2947constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2947constructorimpl.getInserting() || !Intrinsics.areEqual(m2947constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m2947constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m2947constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        modifierMaterializerOf.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        if (z3) {
            startRestartGroup.startReplaceableGroup(277340662);
            ImageVector keyboardArrowDown = z ? KeyboardArrowDownKt.getKeyboardArrowDown(Icons.Outlined.INSTANCE) : KeyboardArrowRightKt.getKeyboardArrowRight(Icons.AutoMirrored.Filled.INSTANCE);
            long primaryPurple = ThemeKt.getPrimaryPurple();
            Modifier m618size3ABfNKs = SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(20));
            startRestartGroup.startReplaceableGroup(277340997);
            boolean z4 = (((i2 & 7168) ^ 3072) > 2048 && startRestartGroup.changedInstance(function0)) || (i2 & 3072) == 2048;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SidebarDrawerKt$SidebarDeckRow$1$1$1
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
                        function0.invoke();
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            str = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
            f = f5;
            i3 = 10;
            f2 = f4;
            r4 = 0;
            IconKt.m1605Iconww6aTOc(keyboardArrowDown, "Toggle", ClickableKt.m251clickableXHw0xAI$default(m618size3ABfNKs, false, null, null, (Function0) rememberedValue, 7, null), primaryPurple, startRestartGroup, 48, 0);
            i4 = 6;
            SpacerKt.Spacer(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(4)), startRestartGroup, 6);
            startRestartGroup.endReplaceableGroup();
        } else {
            str = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
            f = f5;
            f2 = f4;
            r4 = 0;
            i3 = 10;
            i4 = 6;
            startRestartGroup.startReplaceableGroup(277341099);
            SpacerKt.Spacer(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(24)), startRestartGroup, 6);
            startRestartGroup.endReplaceableGroup();
        }
        Modifier m216backgroundbw27NRU$default = BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(32)), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f2))), z3 ? ThemeKt.getLightPurpleAccent() : ColorKt.Color(4293128957L), null, 2, null);
        Alignment center = Alignment.INSTANCE.getCenter();
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, r4, startRestartGroup, i4);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, str);
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, r4);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m216backgroundbw27NRU$default);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor2);
        } else {
            startRestartGroup.useNode();
        }
        Composer m2947constructorimpl2 = Updater.m2947constructorimpl(startRestartGroup);
        Updater.m2954setimpl(m2947constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2954setimpl(m2947constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2947constructorimpl2.getInserting() || !Intrinsics.areEqual(m2947constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            m2947constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m2947constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        modifierMaterializerOf2.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((int) r4));
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        float f6 = 16;
        int i5 = i4;
        IconKt.m1605Iconww6aTOc(z3 ? MenuKt.getMenu(Icons.Outlined.INSTANCE) : ListKt.getList(Icons.AutoMirrored.Filled.INSTANCE), (String) null, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f6)), z3 ? ThemeKt.getPrimaryPurple() : ColorKt.Color(4279592384L), startRestartGroup, 432, 0);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        SpacerKt.Spacer(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f)), startRestartGroup, i5);
        Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
        startRestartGroup.startReplaceableGroup(-483455358);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, str);
        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(weight$default);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor3);
        } else {
            startRestartGroup.useNode();
        }
        Composer m2947constructorimpl3 = Updater.m2947constructorimpl(startRestartGroup);
        Updater.m2954setimpl(m2947constructorimpl3, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
            m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
        }
        modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        String shortName = deckNode.getShortName();
        long sp = TextUnitKt.getSp(13);
        FontWeight.Companion companion = FontWeight.INSTANCE;
        TextKt.m2133Text4IGK_g(shortName, (Modifier) null, ThemeKt.getTextPrimaryDeep(), sp, (FontStyle) null, i == 0 ? companion.getBold() : companion.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, 3072, 3072, 122834);
        startRestartGroup.startReplaceableGroup(277342169);
        if (z3) {
            z2 = true;
            TextKt.m2133Text4IGK_g(deckNode.getChildren().size() + " subdeck" + (deckNode.getChildren().size() != 1 ? "s" : ""), (Modifier) null, ThemeKt.getTextSecondaryGray(), TextUnitKt.getSp(i3), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, 3072, 0, 131058);
        } else {
            z2 = true;
        }
        startRestartGroup.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        float f7 = 28;
        Modifier m216backgroundbw27NRU$default2 = BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f7)), RoundedCornerShapeKt.getCircleShape()), ThemeKt.getPrimaryPurple(), null, 2, null);
        startRestartGroup.startReplaceableGroup(277342644);
        boolean changed = (((((57344 & i2) ^ 24576) <= 16384 || !startRestartGroup.changedInstance(function1)) && (i2 & 24576) != 16384) ? false : z2) | startRestartGroup.changed(deck);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SidebarDrawerKt$SidebarDeckRow$1$4$1
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
                    function1.invoke(deck);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        Modifier m251clickableXHw0xAI$default = ClickableKt.m251clickableXHw0xAI$default(m216backgroundbw27NRU$default2, false, null, null, (Function0) rememberedValue2, 7, null);
        Alignment center2 = Alignment.INSTANCE.getCenter();
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, startRestartGroup, i5);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, str);
        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(m251clickableXHw0xAI$default);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor4);
        } else {
            startRestartGroup.useNode();
        }
        Composer m2947constructorimpl4 = Updater.m2947constructorimpl(startRestartGroup);
        Updater.m2954setimpl(m2947constructorimpl4, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
            m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
            m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
        }
        modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
        IconKt.m1605Iconww6aTOc(PlayArrowKt.getPlayArrow(Icons.Outlined.INSTANCE), "Play", SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f6)), Color.INSTANCE.m3454getWhite0d7_KjU(), startRestartGroup, 3504, 0);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        SpacerKt.Spacer(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(i5)), startRestartGroup, i5);
        Modifier m216backgroundbw27NRU$default3 = BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f7)), RoundedCornerShapeKt.getCircleShape()), ThemeKt.getLightPurpleAccent(), null, 2, null);
        startRestartGroup.startReplaceableGroup(277343203);
        if ((((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) <= 131072 || !startRestartGroup.changedInstance(function12)) && (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 131072) {
            z2 = false;
        }
        boolean changed2 = z2 | startRestartGroup.changed(deck);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SidebarDrawerKt$SidebarDeckRow$1$6$1
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
                    function12.invoke(deck);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        startRestartGroup.endReplaceableGroup();
        Modifier m251clickableXHw0xAI$default2 = ClickableKt.m251clickableXHw0xAI$default(m216backgroundbw27NRU$default3, false, null, null, (Function0) rememberedValue3, 7, null);
        Alignment center3 = Alignment.INSTANCE.getCenter();
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(center3, false, startRestartGroup, i5);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, str);
        int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(m251clickableXHw0xAI$default2);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor5);
        } else {
            startRestartGroup.useNode();
        }
        Composer m2947constructorimpl5 = Updater.m2947constructorimpl(startRestartGroup);
        Updater.m2954setimpl(m2947constructorimpl5, rememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2954setimpl(m2947constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2947constructorimpl5.getInserting() || !Intrinsics.areEqual(m2947constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
            m2947constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
            m2947constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
        }
        modifierMaterializerOf5.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
        IconKt.m1605Iconww6aTOc(SettingsKt.getSettings(Icons.Outlined.INSTANCE), "Deck Settings", SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(14)), ThemeKt.getPrimaryPurple(), startRestartGroup, 432, 0);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SidebarDrawerKt$SidebarDeckRow$2
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

                public final void invoke(Composer composer2, int i6) {
                    SidebarDrawerKt.SidebarDeckRow(DeckNode.this, i, z, function0, function1, function12, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }
}

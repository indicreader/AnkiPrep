package com.example.flashcardapp.ui;

import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.material.icons.filled.CheckKt;
import androidx.compose.material.icons.filled.StarKt;
import androidx.compose.material.icons.outlined.LibraryBooksKt;
import androidx.compose.material.icons.outlined.QuizKt;
import androidx.compose.material.icons.outlined.StarBorderKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.RadioButtonKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
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
import androidx.profileinstaller.ProfileVerifier;
import com.example.flashcardapp.data.AnkiDataRepository;
import com.example.flashcardapp.data.entities.CardUserMetadataEntity;
import com.example.flashcardapp.data.entities.DeckEntity;
import com.example.flashcardapp.session.McqSessionMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ReviseTab.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032Q\u0010\u0004\u001aM\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013²\u0006\u0010\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006X\u008a\u0084\u0002²\u0006\u0010\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0006X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\f\u0010\u001a\u001a\u0004\u0018\u00010\u0015X\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010\u001c\u001a\u00020\rX\u008a\u008e\u0002"}, d2 = {"ReviseTab", "", "repo", "Lcom/example/flashcardapp/data/AnkiDataRepository;", "onStartSession", "Lkotlin/Function3;", "", "", "Lkotlin/ParameterName;", "name", "deckIds", "", "isStarredOnly", "Lcom/example/flashcardapp/session/McqSessionMode;", "sessionMode", "isDarkMode", "onDarkModeToggle", "Lkotlin/Function0;", "(Lcom/example/flashcardapp/data/AnkiDataRepository;Lkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release", "decks", "Lcom/example/flashcardapp/data/entities/DeckEntity;", "userMetadata", "Lcom/example/flashcardapp/data/entities/CardUserMetadataEntity;", "selectionMode", "", "selectedDeck", "singleDeckDropdownExpanded", "studyMode"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ReviseTabKt {
    public static final void ReviseTab(final AnkiDataRepository repo, final Function3<? super List<Long>, ? super Boolean, ? super McqSessionMode, Unit> onStartSession, final boolean z, final Function0<Unit> onDarkModeToggle, Composer composer, final int i) {
        int i2;
        DeckEntity ReviseTab$lambda$6;
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(onStartSession, "onStartSession");
        Intrinsics.checkNotNullParameter(onDarkModeToggle, "onDarkModeToggle");
        Composer startRestartGroup = composer.startRestartGroup(981679962);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(981679962, i, -1, "com.example.flashcardapp.ui.ReviseTab (ReviseTab.kt:40)");
        }
        final ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable);
        startRestartGroup.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
            startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        startRestartGroup.endReplaceableGroup();
        ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        startRestartGroup.endReplaceableGroup();
        final State collectAsState = SnapshotStateKt.collectAsState(repo.observeDecks(), CollectionsKt.emptyList(), null, startRestartGroup, 56, 2);
        State collectAsState2 = SnapshotStateKt.collectAsState(repo.observeAllUserMetadata(), CollectionsKt.emptyList(), null, startRestartGroup, 56, 2);
        startRestartGroup.startReplaceableGroup(-285498688);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("single", null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        final MutableState mutableState = (MutableState) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-285498590);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        final MutableState mutableState2 = (MutableState) rememberedValue3;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-285498505);
        Object rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue4);
        }
        final MutableState mutableState3 = (MutableState) rememberedValue4;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-285498409);
        Object rememberedValue5 = startRestartGroup.rememberedValue();
        if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
            rememberedValue5 = SnapshotStateKt.mutableStateListOf();
            startRestartGroup.updateRememberedValue(rememberedValue5);
        }
        final SnapshotStateList snapshotStateList = (SnapshotStateList) rememberedValue5;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-285498279);
        Object rememberedValue6 = startRestartGroup.rememberedValue();
        if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
            rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(McqSessionMode.PRACTICE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue6);
        }
        final MutableState mutableState4 = (MutableState) rememberedValue6;
        startRestartGroup.endReplaceableGroup();
        List<DeckEntity> ReviseTab$lambda$0 = ReviseTab$lambda$0(collectAsState);
        startRestartGroup.startReplaceableGroup(-285498152);
        boolean changed = startRestartGroup.changed(collectAsState);
        ReviseTabKt$ReviseTab$1$1 rememberedValue7 = startRestartGroup.rememberedValue();
        if (changed || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
            rememberedValue7 = new ReviseTabKt$ReviseTab$1$1(mutableState2, collectAsState, null);
            startRestartGroup.updateRememberedValue(rememberedValue7);
        }
        startRestartGroup.endReplaceableGroup();
        EffectsKt.LaunchedEffect(ReviseTab$lambda$0, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue7, startRestartGroup, 72);
        String ReviseTab$lambda$3 = ReviseTab$lambda$3(mutableState);
        DeckEntity ReviseTab$lambda$62 = ReviseTab$lambda$6(mutableState2);
        List<DeckEntity> ReviseTab$lambda$02 = ReviseTab$lambda$0(collectAsState);
        List<CardUserMetadataEntity> ReviseTab$lambda$1 = ReviseTab$lambda$1(collectAsState2);
        startRestartGroup.startReplaceableGroup(-285497967);
        boolean changed2 = startRestartGroup.changed(ReviseTab$lambda$1) | startRestartGroup.changed(ReviseTab$lambda$3) | startRestartGroup.changed(ReviseTab$lambda$62) | startRestartGroup.changed(ReviseTab$lambda$02);
        Object rememberedValue8 = startRestartGroup.rememberedValue();
        if (changed2 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
            String ReviseTab$lambda$32 = ReviseTab$lambda$3(mutableState);
            int hashCode = ReviseTab$lambda$32.hashCode();
            if (hashCode == -1897187073) {
                if (ReviseTab$lambda$32.equals("starred")) {
                    List<CardUserMetadataEntity> ReviseTab$lambda$12 = ReviseTab$lambda$1(collectAsState2);
                    if (!(ReviseTab$lambda$12 instanceof Collection) || !ReviseTab$lambda$12.isEmpty()) {
                        Iterator<T> it = ReviseTab$lambda$12.iterator();
                        i2 = 0;
                        while (it.hasNext()) {
                            if (((CardUserMetadataEntity) it.next()).isStarred() && (i2 = i2 + 1) < 0) {
                                CollectionsKt.throwCountOverflow();
                            }
                        }
                        rememberedValue8 = Integer.valueOf(i2);
                        startRestartGroup.updateRememberedValue(rememberedValue8);
                    }
                }
                i2 = 0;
                rememberedValue8 = Integer.valueOf(i2);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            } else if (hashCode != -902265784) {
                if (hashCode == 104256825 && ReviseTab$lambda$32.equals("multi")) {
                    List<DeckEntity> ReviseTab$lambda$03 = ReviseTab$lambda$0(collectAsState);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : ReviseTab$lambda$03) {
                        if (snapshotStateList.contains(Long.valueOf(((DeckEntity) obj).getId()))) {
                            arrayList.add(obj);
                        }
                    }
                    Iterator it2 = arrayList.iterator();
                    i2 = 0;
                    while (it2.hasNext()) {
                        i2 += ((DeckEntity) it2.next()).getCardCount();
                    }
                    rememberedValue8 = Integer.valueOf(i2);
                    startRestartGroup.updateRememberedValue(rememberedValue8);
                }
                i2 = 0;
                rememberedValue8 = Integer.valueOf(i2);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            } else {
                if (ReviseTab$lambda$32.equals("single") && (ReviseTab$lambda$6 = ReviseTab$lambda$6(mutableState2)) != null) {
                    i2 = ReviseTab$lambda$6.getCardCount();
                    rememberedValue8 = Integer.valueOf(i2);
                    startRestartGroup.updateRememberedValue(rememberedValue8);
                }
                i2 = 0;
                rememberedValue8 = Integer.valueOf(i2);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
        }
        final int intValue = ((Number) rememberedValue8).intValue();
        startRestartGroup.endReplaceableGroup();
        ScaffoldKt.m1788ScaffoldTvnljyQ(null, ComposableLambdaKt.composableLambda(startRestartGroup, -1875674338, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$2
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

            public final void invoke(Composer composer2, int i3) {
                if ((i3 & 11) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1875674338, i3, -1, "com.example.flashcardapp.ui.ReviseTab.<anonymous> (ReviseTab.kt:82)");
                    }
                    final ColorScheme colorScheme2 = ColorScheme.this;
                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, 1020895706, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$2.1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i4) {
                            TextStyle m5264copyp1EtxEg;
                            if ((i4 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1020895706, i4, -1, "com.example.flashcardapp.ui.ReviseTab.<anonymous>.<anonymous> (ReviseTab.kt:84)");
                                }
                                m5264copyp1EtxEg = r16.m5264copyp1EtxEg((r48 & 1) != 0 ? r16.spanStyle.m5197getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r16.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r16.spanStyle.getFontWeight() : FontWeight.INSTANCE.getBold(), (r48 & 8) != 0 ? r16.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r16.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r16.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r16.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r16.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r16.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r16.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r16.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r16.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r16.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r16.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r16.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r16.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r16.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r16.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r16.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r16.platformStyle : null, (r48 & 1048576) != 0 ? r16.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r16.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r16.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getTitleLarge().paragraphStyle.getTextMotion() : null);
                                TextKt.m2133Text4IGK_g("Revise & Review", (Modifier) null, ColorScheme.this.getOnBackground(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m5264copyp1EtxEg, composer3, 6, 0, 65530);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    });
                    final Function0<Unit> function0 = onDarkModeToggle;
                    final boolean z2 = z;
                    final ColorScheme colorScheme3 = ColorScheme.this;
                    AppBarKt.TopAppBar(composableLambda, null, null, ComposableLambdaKt.composableLambda(composer2, -908029937, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                            invoke(rowScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope TopAppBar, Composer composer3, int i4) {
                            Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
                            if ((i4 & 81) != 16 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-908029937, i4, -1, "com.example.flashcardapp.ui.ReviseTab.<anonymous>.<anonymous> (ReviseTab.kt:91)");
                                }
                                Function0<Unit> function02 = function0;
                                final boolean z3 = z2;
                                final ColorScheme colorScheme4 = colorScheme3;
                                IconButtonKt.IconButton(function02, null, false, null, null, ComposableLambdaKt.composableLambda(composer3, -202557844, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt.ReviseTab.2.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i5) {
                                        if ((i5 & 11) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-202557844, i5, -1, "com.example.flashcardapp.ui.ReviseTab.<anonymous>.<anonymous>.<anonymous> (ReviseTab.kt:92)");
                                            }
                                            IconKt.m1605Iconww6aTOc(z3 ? StarKt.getStar(Icons.INSTANCE.getDefault()) : StarBorderKt.getStarBorder(Icons.Outlined.INSTANCE), "Toggle Theme", (Modifier) null, colorScheme4.getOnSurfaceVariant(), composer4, 48, 4);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), null, TopAppBarDefaults.INSTANCE.m2292topAppBarColorszjMxDiM(ColorScheme.this.getBackground(), 0L, 0L, 0L, 0L, composer2, TopAppBarDefaults.$stable << 15, 30), null, composer2, 3078, 86);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), null, null, null, 0, colorScheme.getBackground(), 0L, null, ComposableLambdaKt.composableLambda(startRestartGroup, -812562135, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3
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

            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(PaddingValues paddingValues, Composer composer2, int i3) {
                TextStyle m5264copyp1EtxEg;
                final MutableState<String> mutableState5;
                String ReviseTab$lambda$33;
                String ReviseTab$lambda$34;
                char c;
                float f;
                String ReviseTab$lambda$35;
                String ReviseTab$lambda$36;
                String ReviseTab$lambda$37;
                String ReviseTab$lambda$38;
                String ReviseTab$lambda$39;
                String ReviseTab$lambda$310;
                String ReviseTab$lambda$311;
                String ReviseTab$lambda$312;
                float f2;
                MutableState<String> mutableState6;
                String str;
                String ReviseTab$lambda$313;
                String str2;
                Composer composer3;
                int i4;
                MutableState<DeckEntity> mutableState7;
                final ColorScheme colorScheme2;
                final SnapshotStateList<Long> snapshotStateList2;
                TextStyle m5264copyp1EtxEg2;
                TextStyle m5264copyp1EtxEg3;
                McqSessionMode ReviseTab$lambda$13;
                final MutableState<McqSessionMode> mutableState8;
                TextStyle m5264copyp1EtxEg4;
                final MutableState<Boolean> mutableState9;
                boolean ReviseTab$lambda$9;
                final MutableState<Boolean> mutableState10;
                Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                int i5 = (i3 & 14) == 0 ? i3 | (composer2.changed(paddingValues) ? 4 : 2) : i3;
                if ((i5 & 91) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-812562135, i5, -1, "com.example.flashcardapp.ui.ReviseTab.<anonymous> (ReviseTab.kt:104)");
                    }
                    Modifier verticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m571paddingVpY3zN4$default(PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues), Dp.m5738constructorimpl(20), 0.0f, 2, null), ScrollKt.rememberScrollState(0, composer2, 0, 1), false, null, false, 14, null);
                    float f3 = 16;
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f3));
                    final ColorScheme colorScheme3 = ColorScheme.this;
                    MutableState<String> mutableState11 = mutableState;
                    MutableState<Boolean> mutableState12 = mutableState3;
                    final MutableState<DeckEntity> mutableState13 = mutableState2;
                    final State<List<DeckEntity>> state = collectAsState;
                    SnapshotStateList<Long> snapshotStateList3 = snapshotStateList;
                    MutableState<McqSessionMode> mutableState14 = mutableState4;
                    final Function3<List<Long>, Boolean, McqSessionMode, Unit> function3 = onStartSession;
                    final int i6 = intValue;
                    composer2.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(verticalScroll$default);
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
                    Updater.m2954setimpl(m2947constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl.getInserting() || !Intrinsics.areEqual(m2947constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m2947constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m2947constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    m5264copyp1EtxEg = r27.m5264copyp1EtxEg((r48 & 1) != 0 ? r27.spanStyle.m5197getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r27.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r27.spanStyle.getFontWeight() : FontWeight.INSTANCE.getBold(), (r48 & 8) != 0 ? r27.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r27.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r27.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r27.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r27.spanStyle.getLetterSpacing() : TextUnitKt.getSp(1), (r48 & 256) != 0 ? r27.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r27.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r27.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r27.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r27.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r27.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r27.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r27.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r27.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r27.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r27.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r27.platformStyle : null, (r48 & 1048576) != 0 ? r27.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r27.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r27.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelMedium().paragraphStyle.getTextMotion() : null);
                    MutableState<McqSessionMode> mutableState15 = mutableState14;
                    TextKt.m2133Text4IGK_g("1. SELECT REVISION SCOPE", (Modifier) null, colorScheme3.getPrimary(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m5264copyp1EtxEg, composer2, 6, 0, 65530);
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_42 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(10));
                    composer2.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_42, Alignment.INSTANCE.getStart(), composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    Composer m2947constructorimpl2 = Updater.m2947constructorimpl(composer2);
                    Updater.m2954setimpl(m2947constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl2.getInserting() || !Intrinsics.areEqual(m2947constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m2947constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m2947constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    modifierMaterializerOf2.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    composer2.startReplaceableGroup(-1602774108);
                    Object rememberedValue9 = composer2.rememberedValue();
                    if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                        mutableState5 = mutableState11;
                        rememberedValue9 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3$1$1$1$1
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
                                mutableState5.setValue("single");
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue9);
                    } else {
                        mutableState5 = mutableState11;
                    }
                    Function0 function0 = (Function0) rememberedValue9;
                    composer2.endReplaceableGroup();
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    RoundedCornerShape m839RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f3));
                    CardDefaults cardDefaults = CardDefaults.INSTANCE;
                    ReviseTab$lambda$33 = ReviseTabKt.ReviseTab$lambda$3(mutableState5);
                    final MutableState<String> mutableState16 = mutableState5;
                    CardColors m1295cardColorsro_MJ88 = cardDefaults.m1295cardColorsro_MJ88(Intrinsics.areEqual(ReviseTab$lambda$33, "single") ? colorScheme3.getPrimaryContainer() : colorScheme3.getSurface(), 0L, 0L, 0L, composer2, CardDefaults.$stable << 12, 14);
                    ReviseTab$lambda$34 = ReviseTabKt.ReviseTab$lambda$3(mutableState16);
                    if (Intrinsics.areEqual(ReviseTab$lambda$34, "single")) {
                        c = 2;
                        f = 2;
                    } else {
                        c = 2;
                        f = 1;
                    }
                    float m5738constructorimpl = Dp.m5738constructorimpl(f);
                    ReviseTab$lambda$35 = ReviseTabKt.ReviseTab$lambda$3(mutableState16);
                    CardKt.Card(function0, fillMaxWidth$default, false, m839RoundedCornerShape0680j_4, m1295cardColorsro_MJ88, null, BorderStrokeKt.m244BorderStrokecXLIe8U(m5738constructorimpl, Intrinsics.areEqual(ReviseTab$lambda$35, "single") ? colorScheme3.getPrimary() : colorScheme3.getOutlineVariant()), null, ComposableLambdaKt.composableLambda(composer2, 1656223336, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3$1$1$2
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

                        public final void invoke(ColumnScope Card, Composer composer4, int i7) {
                            String ReviseTab$lambda$314;
                            String ReviseTab$lambda$315;
                            String ReviseTab$lambda$316;
                            Intrinsics.checkNotNullParameter(Card, "$this$Card");
                            if ((i7 & 81) != 16 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1656223336, i7, -1, "com.example.flashcardapp.ui.ReviseTab.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ReviseTab.kt:137)");
                                }
                                Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(16));
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Arrangement.HorizontalOrVertical m478spacedBy0680j_43 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(12));
                                final MutableState<String> mutableState17 = mutableState16;
                                ColorScheme colorScheme4 = colorScheme3;
                                composer4.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m478spacedBy0680j_43, centerVertically, composer4, 54);
                                composer4.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor3);
                                } else {
                                    composer4.useNode();
                                }
                                Composer m2947constructorimpl3 = Updater.m2947constructorimpl(composer4);
                                Updater.m2954setimpl(m2947constructorimpl3, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                    m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                    m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                }
                                modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                composer4.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                ReviseTab$lambda$314 = ReviseTabKt.ReviseTab$lambda$3(mutableState17);
                                boolean areEqual = Intrinsics.areEqual(ReviseTab$lambda$314, "single");
                                composer4.startReplaceableGroup(-1788055965);
                                Object rememberedValue10 = composer4.rememberedValue();
                                if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue10 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3$1$1$2$1$1$1
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
                                            mutableState17.setValue("single");
                                        }
                                    };
                                    composer4.updateRememberedValue(rememberedValue10);
                                }
                                composer4.endReplaceableGroup();
                                RadioButtonKt.RadioButton(areEqual, (Function0) rememberedValue10, null, false, null, null, composer4, 48, 60);
                                Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                composer4.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                composer4.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap4 = composer4.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(weight$default);
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
                                Updater.m2954setimpl(m2947constructorimpl4, columnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                    m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                    m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                }
                                modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                composer4.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                                FontWeight bold = FontWeight.INSTANCE.getBold();
                                TextStyle bodyLarge = MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodyLarge();
                                ReviseTab$lambda$315 = ReviseTabKt.ReviseTab$lambda$3(mutableState17);
                                TextKt.m2133Text4IGK_g("Single Deck", (Modifier) null, Intrinsics.areEqual(ReviseTab$lambda$315, "single") ? colorScheme4.getOnPrimaryContainer() : colorScheme4.getOnSurface(), 0L, (FontStyle) null, bold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, bodyLarge, composer4, 196614, 0, 65498);
                                TextStyle bodySmall = MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodySmall();
                                ReviseTab$lambda$316 = ReviseTabKt.ReviseTab$lambda$3(mutableState17);
                                TextKt.m2133Text4IGK_g("Revise cards from one chosen deck", (Modifier) null, Intrinsics.areEqual(ReviseTab$lambda$316, "single") ? Color.m3416copywmQWz5c$default(colorScheme4.getOnPrimaryContainer(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null) : colorScheme4.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, bodySmall, composer4, 6, 0, 65530);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endReplaceableGroup();
                                composer4.endNode();
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
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
                    }), composer2, 100663350, 164);
                    composer2.startReplaceableGroup(-1602772048);
                    Object rememberedValue10 = composer2.rememberedValue();
                    if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue10 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3$1$1$3$1
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
                                mutableState16.setValue("multi");
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue10);
                    }
                    Function0 function02 = (Function0) rememberedValue10;
                    composer2.endReplaceableGroup();
                    Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    RoundedCornerShape m839RoundedCornerShape0680j_42 = RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f3));
                    CardDefaults cardDefaults2 = CardDefaults.INSTANCE;
                    ReviseTab$lambda$36 = ReviseTabKt.ReviseTab$lambda$3(mutableState16);
                    CardColors m1295cardColorsro_MJ882 = cardDefaults2.m1295cardColorsro_MJ88(Intrinsics.areEqual(ReviseTab$lambda$36, "multi") ? colorScheme3.getPrimaryContainer() : colorScheme3.getSurface(), 0L, 0L, 0L, composer2, CardDefaults.$stable << 12, 14);
                    ReviseTab$lambda$37 = ReviseTabKt.ReviseTab$lambda$3(mutableState16);
                    float m5738constructorimpl2 = Dp.m5738constructorimpl(Intrinsics.areEqual(ReviseTab$lambda$37, "multi") ? 2 : 1);
                    ReviseTab$lambda$38 = ReviseTabKt.ReviseTab$lambda$3(mutableState16);
                    CardKt.Card(function02, fillMaxWidth$default2, false, m839RoundedCornerShape0680j_42, m1295cardColorsro_MJ882, null, BorderStrokeKt.m244BorderStrokecXLIe8U(m5738constructorimpl2, Intrinsics.areEqual(ReviseTab$lambda$38, "multi") ? colorScheme3.getPrimary() : colorScheme3.getOutlineVariant()), null, ComposableLambdaKt.composableLambda(composer2, 1762467537, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3$1$1$4
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

                        public final void invoke(ColumnScope Card, Composer composer4, int i7) {
                            String ReviseTab$lambda$314;
                            String ReviseTab$lambda$315;
                            String ReviseTab$lambda$316;
                            Intrinsics.checkNotNullParameter(Card, "$this$Card");
                            if ((i7 & 81) != 16 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1762467537, i7, -1, "com.example.flashcardapp.ui.ReviseTab.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ReviseTab.kt:175)");
                                }
                                Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(16));
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Arrangement.HorizontalOrVertical m478spacedBy0680j_43 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(12));
                                final MutableState<String> mutableState17 = mutableState16;
                                ColorScheme colorScheme4 = colorScheme3;
                                composer4.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m478spacedBy0680j_43, centerVertically, composer4, 54);
                                composer4.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor3);
                                } else {
                                    composer4.useNode();
                                }
                                Composer m2947constructorimpl3 = Updater.m2947constructorimpl(composer4);
                                Updater.m2954setimpl(m2947constructorimpl3, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                    m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                    m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                }
                                modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                composer4.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                ReviseTab$lambda$314 = ReviseTabKt.ReviseTab$lambda$3(mutableState17);
                                boolean areEqual = Intrinsics.areEqual(ReviseTab$lambda$314, "multi");
                                composer4.startReplaceableGroup(-1788053910);
                                Object rememberedValue11 = composer4.rememberedValue();
                                if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue11 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3$1$1$4$1$1$1
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
                                            mutableState17.setValue("multi");
                                        }
                                    };
                                    composer4.updateRememberedValue(rememberedValue11);
                                }
                                composer4.endReplaceableGroup();
                                RadioButtonKt.RadioButton(areEqual, (Function0) rememberedValue11, null, false, null, null, composer4, 48, 60);
                                Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                composer4.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                composer4.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap4 = composer4.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(weight$default);
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
                                Updater.m2954setimpl(m2947constructorimpl4, columnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                    m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                    m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                }
                                modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                composer4.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                                FontWeight bold = FontWeight.INSTANCE.getBold();
                                TextStyle bodyLarge = MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodyLarge();
                                ReviseTab$lambda$315 = ReviseTabKt.ReviseTab$lambda$3(mutableState17);
                                TextKt.m2133Text4IGK_g("Selected Decks", (Modifier) null, Intrinsics.areEqual(ReviseTab$lambda$315, "multi") ? colorScheme4.getOnPrimaryContainer() : colorScheme4.getOnSurface(), 0L, (FontStyle) null, bold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, bodyLarge, composer4, 196614, 0, 65498);
                                TextStyle bodySmall = MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodySmall();
                                ReviseTab$lambda$316 = ReviseTabKt.ReviseTab$lambda$3(mutableState17);
                                TextKt.m2133Text4IGK_g("Pick multiple decks to merge into a single session", (Modifier) null, Intrinsics.areEqual(ReviseTab$lambda$316, "multi") ? Color.m3416copywmQWz5c$default(colorScheme4.getOnPrimaryContainer(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null) : colorScheme4.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, bodySmall, composer4, 6, 0, 65530);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endReplaceableGroup();
                                composer4.endNode();
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
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
                    }), composer2, 100663350, 164);
                    composer2.startReplaceableGroup(-1602769973);
                    Object rememberedValue11 = composer2.rememberedValue();
                    if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue11 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3$1$1$5$1
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
                                mutableState16.setValue("starred");
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue11);
                    }
                    Function0 function03 = (Function0) rememberedValue11;
                    composer2.endReplaceableGroup();
                    Modifier fillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    RoundedCornerShape m839RoundedCornerShape0680j_43 = RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f3));
                    CardDefaults cardDefaults3 = CardDefaults.INSTANCE;
                    ReviseTab$lambda$39 = ReviseTabKt.ReviseTab$lambda$3(mutableState16);
                    CardColors m1295cardColorsro_MJ883 = cardDefaults3.m1295cardColorsro_MJ88(Intrinsics.areEqual(ReviseTab$lambda$39, "starred") ? colorScheme3.getPrimaryContainer() : colorScheme3.getSurface(), 0L, 0L, 0L, composer2, CardDefaults.$stable << 12, 14);
                    ReviseTab$lambda$310 = ReviseTabKt.ReviseTab$lambda$3(mutableState16);
                    float m5738constructorimpl3 = Dp.m5738constructorimpl(Intrinsics.areEqual(ReviseTab$lambda$310, "starred") ? 2 : 1);
                    ReviseTab$lambda$311 = ReviseTabKt.ReviseTab$lambda$3(mutableState16);
                    CardKt.Card(function03, fillMaxWidth$default3, false, m839RoundedCornerShape0680j_43, m1295cardColorsro_MJ883, null, BorderStrokeKt.m244BorderStrokecXLIe8U(m5738constructorimpl3, Intrinsics.areEqual(ReviseTab$lambda$311, "starred") ? colorScheme3.getPrimary() : colorScheme3.getOutlineVariant()), null, ComposableLambdaKt.composableLambda(composer2, -1331358416, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3$1$1$6
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

                        public final void invoke(ColumnScope Card, Composer composer4, int i7) {
                            String ReviseTab$lambda$314;
                            String ReviseTab$lambda$315;
                            String ReviseTab$lambda$316;
                            Intrinsics.checkNotNullParameter(Card, "$this$Card");
                            if ((i7 & 81) != 16 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1331358416, i7, -1, "com.example.flashcardapp.ui.ReviseTab.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ReviseTab.kt:213)");
                                }
                                Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(16));
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Arrangement.HorizontalOrVertical m478spacedBy0680j_43 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(12));
                                final MutableState<String> mutableState17 = mutableState16;
                                ColorScheme colorScheme4 = colorScheme3;
                                composer4.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m478spacedBy0680j_43, centerVertically, composer4, 54);
                                composer4.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor3);
                                } else {
                                    composer4.useNode();
                                }
                                Composer m2947constructorimpl3 = Updater.m2947constructorimpl(composer4);
                                Updater.m2954setimpl(m2947constructorimpl3, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                    m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                    m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                }
                                modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                composer4.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                ReviseTab$lambda$314 = ReviseTabKt.ReviseTab$lambda$3(mutableState17);
                                boolean areEqual = Intrinsics.areEqual(ReviseTab$lambda$314, "starred");
                                composer4.startReplaceableGroup(-1788051825);
                                Object rememberedValue12 = composer4.rememberedValue();
                                if (rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue12 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3$1$1$6$1$1$1
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
                                            mutableState17.setValue("starred");
                                        }
                                    };
                                    composer4.updateRememberedValue(rememberedValue12);
                                }
                                composer4.endReplaceableGroup();
                                RadioButtonKt.RadioButton(areEqual, (Function0) rememberedValue12, null, false, null, null, composer4, 48, 60);
                                Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                composer4.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                composer4.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap4 = composer4.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(weight$default);
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
                                Updater.m2954setimpl(m2947constructorimpl4, columnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                    m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                    m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                }
                                modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                composer4.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                                FontWeight bold = FontWeight.INSTANCE.getBold();
                                TextStyle bodyLarge = MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodyLarge();
                                ReviseTab$lambda$315 = ReviseTabKt.ReviseTab$lambda$3(mutableState17);
                                TextKt.m2133Text4IGK_g("Starred Questions", (Modifier) null, Intrinsics.areEqual(ReviseTab$lambda$315, "starred") ? colorScheme4.getOnPrimaryContainer() : colorScheme4.getOnSurface(), 0L, (FontStyle) null, bold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, bodyLarge, composer4, 196614, 0, 65498);
                                TextStyle bodySmall = MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodySmall();
                                ReviseTab$lambda$316 = ReviseTabKt.ReviseTab$lambda$3(mutableState17);
                                TextKt.m2133Text4IGK_g("Review bookmarked items across all decks", (Modifier) null, Intrinsics.areEqual(ReviseTab$lambda$316, "starred") ? Color.m3416copywmQWz5c$default(colorScheme4.getOnPrimaryContainer(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null) : colorScheme4.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, bodySmall, composer4, 6, 0, 65530);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endReplaceableGroup();
                                composer4.endNode();
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
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
                    }), composer2, 100663350, 164);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    float f4 = 4;
                    SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f4)), composer2, 6);
                    ReviseTab$lambda$312 = ReviseTabKt.ReviseTab$lambda$3(mutableState16);
                    if (!Intrinsics.areEqual(ReviseTab$lambda$312, "single")) {
                        f2 = f4;
                        mutableState6 = mutableState16;
                        str = "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo";
                        ReviseTab$lambda$313 = ReviseTabKt.ReviseTab$lambda$3(mutableState6);
                        if (!Intrinsics.areEqual(ReviseTab$lambda$313, "multi")) {
                            str2 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
                            composer3 = composer2;
                            i4 = 1;
                            mutableState7 = mutableState13;
                            colorScheme2 = colorScheme3;
                            snapshotStateList2 = snapshotStateList3;
                            composer3.startReplaceableGroup(251257797);
                            composer2.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(251254490);
                            m5264copyp1EtxEg2 = r31.m5264copyp1EtxEg((r48 & 1) != 0 ? r31.spanStyle.m5197getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r31.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r31.spanStyle.getFontWeight() : FontWeight.INSTANCE.getBold(), (r48 & 8) != 0 ? r31.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r31.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r31.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r31.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r31.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r31.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r31.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r31.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r31.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r31.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r31.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r31.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r31.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r31.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r31.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r31.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r31.platformStyle : null, (r48 & 1048576) != 0 ? r31.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r31.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r31.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelMedium().paragraphStyle.getTextMotion() : null);
                            str2 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
                            mutableState7 = mutableState13;
                            TextKt.m2133Text4IGK_g("SELECT DECK CHECKLIST", (Modifier) null, colorScheme3.getPrimary(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m5264copyp1EtxEg2, composer2, 6, 0, 65530);
                            i4 = 1;
                            colorScheme2 = colorScheme3;
                            snapshotStateList2 = snapshotStateList3;
                            composer3 = composer2;
                            CardKt.Card(SizeKt.m606heightInVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m5738constructorimpl(240), 1, null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f3)), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(colorScheme3.getSurface(), 0L, 0L, 0L, composer2, CardDefaults.$stable << 12, 14), null, BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(1), colorScheme3.getOutlineVariant()), ComposableLambdaKt.composableLambda(composer3, -1426631619, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3$1$3
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer4, Integer num) {
                                    invoke(columnScope, composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ColumnScope Card, Composer composer4, int i7) {
                                    List ReviseTab$lambda$04;
                                    List<DeckEntity> ReviseTab$lambda$05;
                                    Intrinsics.checkNotNullParameter(Card, "$this$Card");
                                    if ((i7 & 81) != 16 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1426631619, i7, -1, "com.example.flashcardapp.ui.ReviseTab.<anonymous>.<anonymous>.<anonymous> (ReviseTab.kt:296)");
                                        }
                                        float f5 = 0.0f;
                                        int i8 = 1;
                                        int i9 = 0;
                                        Modifier verticalScroll$default2 = ScrollKt.verticalScroll$default(PaddingKt.m569padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(8)), ScrollKt.rememberScrollState(0, composer4, 0, 1), false, null, false, 14, null);
                                        State<List<DeckEntity>> state2 = state;
                                        final SnapshotStateList<Long> snapshotStateList4 = snapshotStateList2;
                                        ColorScheme colorScheme4 = colorScheme2;
                                        composer4.startReplaceableGroup(-483455358);
                                        String str3 = "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo";
                                        ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                        MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                        composer4.startReplaceableGroup(-1323940314);
                                        String str4 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(verticalScroll$default2);
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor3);
                                        } else {
                                            composer4.useNode();
                                        }
                                        Composer m2947constructorimpl3 = Updater.m2947constructorimpl(composer4);
                                        Updater.m2954setimpl(m2947constructorimpl3, columnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                            m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                            m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                        }
                                        modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                        composer4.startReplaceableGroup(2058660585);
                                        String str5 = "C79@3979L9:Column.kt#2w3rfo";
                                        ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                        ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                                        ReviseTab$lambda$04 = ReviseTabKt.ReviseTab$lambda$0(state2);
                                        if (ReviseTab$lambda$04.isEmpty()) {
                                            composer4.startReplaceableGroup(330120206);
                                            TextKt.m2133Text4IGK_g("No decks available.", PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(16)), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodyMedium(), composer4, 54, 0, 65532);
                                            composer4.endReplaceableGroup();
                                        } else {
                                            Composer composer5 = composer4;
                                            composer5.startReplaceableGroup(330120502);
                                            ReviseTab$lambda$05 = ReviseTabKt.ReviseTab$lambda$0(state2);
                                            for (final DeckEntity deckEntity : ReviseTab$lambda$05) {
                                                final boolean contains = snapshotStateList4.contains(Long.valueOf(deckEntity.getId()));
                                                Modifier fillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, f5, i8, null);
                                                composer5.startReplaceableGroup(-1788047065);
                                                boolean changed3 = composer5.changed(contains) | composer5.changed(deckEntity);
                                                Object rememberedValue12 = composer4.rememberedValue();
                                                if (changed3 || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue12 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3$1$3$1$1$1$1
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
                                                            if (contains) {
                                                                snapshotStateList4.remove(Long.valueOf(deckEntity.getId()));
                                                            } else {
                                                                snapshotStateList4.add(Long.valueOf(deckEntity.getId()));
                                                            }
                                                        }
                                                    };
                                                    composer5.updateRememberedValue(rememberedValue12);
                                                }
                                                composer4.endReplaceableGroup();
                                                float f6 = 10;
                                                Modifier m570paddingVpY3zN4 = PaddingKt.m570paddingVpY3zN4(ClickableKt.m251clickableXHw0xAI$default(fillMaxWidth$default4, false, null, null, (Function0) rememberedValue12, 7, null), Dp.m5738constructorimpl(12), Dp.m5738constructorimpl(f6));
                                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                Arrangement.HorizontalOrVertical m478spacedBy0680j_43 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f6));
                                                composer5.startReplaceableGroup(693286680);
                                                ComposerKt.sourceInformation(composer5, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m478spacedBy0680j_43, centerVertically, composer5, 54);
                                                composer5.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer5, str4);
                                                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer5, i9);
                                                CompositionLocalMap currentCompositionLocalMap4 = composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(m570paddingVpY3zN4);
                                                if (!(composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer4.startReusableNode();
                                                if (composer4.getInserting()) {
                                                    composer5.createNode(constructor4);
                                                } else {
                                                    composer4.useNode();
                                                }
                                                Composer m2947constructorimpl4 = Updater.m2947constructorimpl(composer4);
                                                Updater.m2954setimpl(m2947constructorimpl4, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                                    m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                                    m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                                }
                                                modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer5, Integer.valueOf(i9));
                                                composer5.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer5, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                                composer5.startReplaceableGroup(1764228478);
                                                boolean changed4 = composer5.changed(deckEntity);
                                                Object rememberedValue13 = composer4.rememberedValue();
                                                if (changed4 || rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue13 = (Function1) new Function1<Boolean, Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3$1$3$1$1$2$1$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                                            invoke(bool.booleanValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(boolean z2) {
                                                            if (z2) {
                                                                if (snapshotStateList4.contains(Long.valueOf(deckEntity.getId()))) {
                                                                    return;
                                                                }
                                                                snapshotStateList4.add(Long.valueOf(deckEntity.getId()));
                                                                return;
                                                            }
                                                            snapshotStateList4.remove(Long.valueOf(deckEntity.getId()));
                                                        }
                                                    };
                                                    composer5.updateRememberedValue(rememberedValue13);
                                                }
                                                composer4.endReplaceableGroup();
                                                String str6 = str4;
                                                String str7 = str5;
                                                SnapshotStateList<Long> snapshotStateList5 = snapshotStateList4;
                                                String str8 = str3;
                                                ColorScheme colorScheme5 = colorScheme4;
                                                CheckboxKt.Checkbox(contains, (Function1) rememberedValue13, null, false, null, null, composer4, 0, 60);
                                                composer5.startReplaceableGroup(-483455358);
                                                ComposerKt.sourceInformation(composer5, str8);
                                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                                MeasurePolicy columnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer5, i9);
                                                composer5.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer5, str6);
                                                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer5, i9);
                                                CompositionLocalMap currentCompositionLocalMap5 = composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(companion2);
                                                if (!(composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer4.startReusableNode();
                                                if (composer4.getInserting()) {
                                                    composer5.createNode(constructor5);
                                                } else {
                                                    composer4.useNode();
                                                }
                                                Composer m2947constructorimpl5 = Updater.m2947constructorimpl(composer4);
                                                Updater.m2954setimpl(m2947constructorimpl5, columnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m2954setimpl(m2947constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m2947constructorimpl5.getInserting() || !Intrinsics.areEqual(m2947constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                                                    m2947constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                                                    m2947constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                                                }
                                                modifierMaterializerOf5.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer5, Integer.valueOf(i9));
                                                composer5.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer5, 276693656, str7);
                                                ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                                                Composer composer6 = composer5;
                                                TextKt.m2133Text4IGK_g(deckEntity.getName(), (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer6, MaterialTheme.$stable).getBodyMedium(), composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65502);
                                                TextKt.m2133Text4IGK_g(deckEntity.getCardCount() + " cards", (Modifier) null, colorScheme5.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer6, MaterialTheme.$stable).getBodySmall(), composer4, 0, 0, 65530);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                composer4.endReplaceableGroup();
                                                composer4.endNode();
                                                composer4.endReplaceableGroup();
                                                composer4.endReplaceableGroup();
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                composer4.endReplaceableGroup();
                                                composer4.endNode();
                                                composer4.endReplaceableGroup();
                                                composer4.endReplaceableGroup();
                                                composer5 = composer6;
                                                str4 = str6;
                                                colorScheme4 = colorScheme5;
                                                snapshotStateList4 = snapshotStateList5;
                                                i9 = i9;
                                                str5 = str7;
                                                str3 = str8;
                                                i8 = 1;
                                                f5 = 0.0f;
                                            }
                                            composer4.endReplaceableGroup();
                                        }
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
                            }), composer2, 196614, 8);
                            composer2.endReplaceableGroup();
                        }
                    } else {
                        composer2.startReplaceableGroup(251252357);
                        m5264copyp1EtxEg4 = r70.m5264copyp1EtxEg((r48 & 1) != 0 ? r70.spanStyle.m5197getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r70.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r70.spanStyle.getFontWeight() : FontWeight.INSTANCE.getBold(), (r48 & 8) != 0 ? r70.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r70.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r70.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r70.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r70.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r70.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r70.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r70.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r70.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r70.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r70.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r70.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r70.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r70.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r70.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r70.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r70.platformStyle : null, (r48 & 1048576) != 0 ? r70.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r70.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r70.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelMedium().paragraphStyle.getTextMotion() : null);
                        f2 = f4;
                        mutableState6 = mutableState16;
                        str = "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo";
                        TextKt.m2133Text4IGK_g("SELECT DECK", (Modifier) null, colorScheme3.getPrimary(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m5264copyp1EtxEg4, composer2, 6, 0, 65530);
                        Modifier fillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default4);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor3);
                        } else {
                            composer2.useNode();
                        }
                        Composer m2947constructorimpl3 = Updater.m2947constructorimpl(composer2);
                        Updater.m2954setimpl(m2947constructorimpl3, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        composer2.startReplaceableGroup(-1602767473);
                        Object rememberedValue12 = composer2.rememberedValue();
                        if (rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                            mutableState9 = mutableState12;
                            rememberedValue12 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3$1$2$1$1
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
                                    ReviseTabKt.ReviseTab$lambda$10(mutableState9, true);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue12);
                        } else {
                            mutableState9 = mutableState12;
                        }
                        composer2.endReplaceableGroup();
                        MutableState<Boolean> mutableState17 = mutableState9;
                        str2 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
                        ButtonKt.OutlinedButton((Function0) rememberedValue12, SizeKt.m604height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(56)), false, RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(12)), null, null, BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(1), colorScheme3.getOutline()), null, null, ComposableLambdaKt.composableLambda(composer2, -1863550848, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3$1$2$2
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

                            public final void invoke(RowScope OutlinedButton, Composer composer4, int i7) {
                                DeckEntity ReviseTab$lambda$63;
                                String str3;
                                Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
                                if ((i7 & 81) != 16 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1863550848, i7, -1, "com.example.flashcardapp.ui.ReviseTab.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ReviseTab.kt:255)");
                                    }
                                    Modifier fillMaxWidth$default5 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    ColorScheme colorScheme4 = ColorScheme.this;
                                    MutableState<DeckEntity> mutableState18 = mutableState13;
                                    composer4.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer4, 54);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap4 = composer4.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default5);
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
                                    Updater.m2954setimpl(m2947constructorimpl4, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                        m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                        m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                    }
                                    modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                    composer4.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    ReviseTab$lambda$63 = ReviseTabKt.ReviseTab$lambda$6(mutableState18);
                                    if (ReviseTab$lambda$63 == null || (str3 = ReviseTab$lambda$63.getName()) == null) {
                                        str3 = "No Deck Selected";
                                    }
                                    TextKt.m2133Text4IGK_g(str3, (Modifier) null, colorScheme4.getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodyMedium(), composer4, 0, 0, 65530);
                                    IconKt.m1605Iconww6aTOc(ArrowDropDownKt.getArrowDropDown(Icons.INSTANCE.getDefault()), "Dropdown", (Modifier) null, 0L, composer4, 48, 12);
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
                        }), composer2, 805306422, 436);
                        ReviseTab$lambda$9 = ReviseTabKt.ReviseTab$lambda$9(mutableState17);
                        composer2.startReplaceableGroup(-1602766363);
                        Object rememberedValue13 = composer2.rememberedValue();
                        if (rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                            mutableState10 = mutableState17;
                            rememberedValue13 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3$1$2$3$1
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
                                    ReviseTabKt.ReviseTab$lambda$10(mutableState10, false);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue13);
                        } else {
                            mutableState10 = mutableState17;
                        }
                        composer2.endReplaceableGroup();
                        AndroidMenu_androidKt.m1233DropdownMenu4kj_NE(ReviseTab$lambda$9, (Function0) rememberedValue13, SizeKt.fillMaxWidth(Modifier.INSTANCE, 0.9f), 0L, null, null, ComposableLambdaKt.composableLambda(composer2, 130289823, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3$1$2$4
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer4, Integer num) {
                                invoke(columnScope, composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ColumnScope DropdownMenu, Composer composer4, int i7) {
                                List<DeckEntity> ReviseTab$lambda$04;
                                Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
                                if ((i7 & 81) != 16 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(130289823, i7, -1, "com.example.flashcardapp.ui.ReviseTab.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ReviseTab.kt:273)");
                                    }
                                    ReviseTab$lambda$04 = ReviseTabKt.ReviseTab$lambda$0(state);
                                    final MutableState<DeckEntity> mutableState18 = mutableState13;
                                    final MutableState<Boolean> mutableState19 = mutableState10;
                                    for (final DeckEntity deckEntity : ReviseTab$lambda$04) {
                                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer4, 1461729316, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3$1$2$4$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                invoke(composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer5, int i8) {
                                                if ((i8 & 11) == 2 && composer5.getSkipping()) {
                                                    composer5.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1461729316, i8, -1, "com.example.flashcardapp.ui.ReviseTab.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ReviseTab.kt:275)");
                                                }
                                                TextKt.m2133Text4IGK_g(DeckEntity.this.getName() + " (" + DeckEntity.this.getCardCount() + " cards)", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer5, 0, 0, 131070);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        });
                                        composer4.startReplaceableGroup(-1788048887);
                                        boolean changed3 = composer4.changed(deckEntity);
                                        Object rememberedValue14 = composer4.rememberedValue();
                                        if (changed3 || rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue14 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3$1$2$4$1$2$1
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
                                                    mutableState18.setValue(DeckEntity.this);
                                                    ReviseTabKt.ReviseTab$lambda$10(mutableState19, false);
                                                }
                                            };
                                            composer4.updateRememberedValue(rememberedValue14);
                                        }
                                        composer4.endReplaceableGroup();
                                        AndroidMenu_androidKt.DropdownMenuItem(composableLambda, (Function0) rememberedValue14, null, null, null, false, null, null, null, composer4, 6, 508);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), composer2, 1573296, 56);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer3 = composer2;
                        i4 = 1;
                        mutableState7 = mutableState13;
                        colorScheme2 = colorScheme3;
                        snapshotStateList2 = snapshotStateList3;
                    }
                    SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f2)), composer3, 6);
                    m5264copyp1EtxEg3 = r32.m5264copyp1EtxEg((r48 & 1) != 0 ? r32.spanStyle.m5197getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r32.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r32.spanStyle.getFontWeight() : FontWeight.INSTANCE.getBold(), (r48 & 8) != 0 ? r32.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r32.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r32.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r32.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r32.spanStyle.getLetterSpacing() : TextUnitKt.getSp(i4), (r48 & 256) != 0 ? r32.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r32.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r32.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r32.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r32.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r32.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r32.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r32.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r32.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r32.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r32.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r32.platformStyle : null, (r48 & 1048576) != 0 ? r32.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r32.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r32.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getLabelMedium().paragraphStyle.getTextMotion() : null);
                    final SnapshotStateList<Long> snapshotStateList4 = snapshotStateList2;
                    final ColorScheme colorScheme4 = colorScheme2;
                    TextKt.m2133Text4IGK_g("2. CHOOSE STUDY MODE", (Modifier) null, colorScheme2.getPrimary(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m5264copyp1EtxEg3, composer2, 6, 0, 65530);
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_43 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(8));
                    composer2.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer2, str);
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_43, Alignment.INSTANCE.getStart(), composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, str2);
                    boolean z2 = false;
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(companion2);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor4);
                    } else {
                        composer2.useNode();
                    }
                    Composer m2947constructorimpl4 = Updater.m2947constructorimpl(composer2);
                    Updater.m2954setimpl(m2947constructorimpl4, columnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                    composer2.startReplaceableGroup(251258927);
                    int i7 = 1;
                    for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(McqSessionMode.PRACTICE, new Triple("Practice Mode", "Instant answer reviews with star ratings enabled", QuizKt.getQuiz(Icons.Outlined.INSTANCE))), TuplesKt.to(McqSessionMode.RATED_PRIORITY, new Triple("Priority Rated Mode", "Study only rated items (higher priority ratings first)", StarKt.getStar(Icons.Filled.INSTANCE))), TuplesKt.to(McqSessionMode.TEST, new Triple("Mock Test Mode", "Timed exam simulation, reviews provided at session end", LibraryBooksKt.getLibraryBooks(Icons.Outlined.INSTANCE))), TuplesKt.to(McqSessionMode.REVISION, new Triple("Smart Revision (FSRS)", "Follow Spaced Repetition scheduling algorithm", LibraryBooksKt.getLibraryBooks(Icons.Outlined.INSTANCE)))})) {
                        final McqSessionMode mcqSessionMode = (McqSessionMode) pair.component1();
                        Triple triple = (Triple) pair.component2();
                        final String str3 = (String) triple.component1();
                        final String str4 = (String) triple.component2();
                        final ImageVector imageVector = (ImageVector) triple.component3();
                        ReviseTab$lambda$13 = ReviseTabKt.ReviseTab$lambda$13(mutableState15);
                        final boolean z3 = ReviseTab$lambda$13 == mcqSessionMode ? i7 : z2;
                        composer2.startReplaceableGroup(330123953);
                        boolean changed3 = composer2.changed(mcqSessionMode);
                        Object rememberedValue14 = composer2.rememberedValue();
                        if (changed3 || rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                            mutableState8 = mutableState15;
                            rememberedValue14 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3$1$4$1$1$1
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
                                    mutableState8.setValue(McqSessionMode.this);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue14);
                        } else {
                            mutableState8 = mutableState15;
                        }
                        Function0 function04 = (Function0) rememberedValue14;
                        composer2.endReplaceableGroup();
                        MutableState<McqSessionMode> mutableState18 = mutableState8;
                        CardKt.Card(function04, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, i7, null), false, RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(12)), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(z3 != 0 ? colorScheme4.getSecondaryContainer() : Color.m3416copywmQWz5c$default(colorScheme4.getSurfaceVariant(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0L, composer2, CardDefaults.$stable << 12, 14), null, BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(z3 != 0 ? (float) 1.5d : (float) 0.5d), z3 != 0 ? colorScheme4.getSecondary() : Color.m3416copywmQWz5c$default(colorScheme4.getOutlineVariant(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null)), null, ComposableLambdaKt.composableLambda(composer2, 440828322, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3$1$4$1$2
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

                            public final void invoke(ColumnScope Card, Composer composer4, int i8) {
                                Intrinsics.checkNotNullParameter(Card, "$this$Card");
                                if ((i8 & 81) != 16 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(440828322, i8, -1, "com.example.flashcardapp.ui.ReviseTab.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ReviseTab.kt:379)");
                                    }
                                    Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(12));
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Arrangement.HorizontalOrVertical m478spacedBy0680j_44 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(10));
                                    boolean z4 = z3;
                                    ColorScheme colorScheme5 = colorScheme4;
                                    ImageVector imageVector2 = imageVector;
                                    String str5 = str3;
                                    String str6 = str4;
                                    composer4.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m478spacedBy0680j_44, centerVertically, composer4, 54);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap5 = composer4.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
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
                                    Updater.m2954setimpl(m2947constructorimpl5, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m2954setimpl(m2947constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m2947constructorimpl5.getInserting() || !Intrinsics.areEqual(m2947constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                                        m2947constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                                        m2947constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                                    }
                                    modifierMaterializerOf5.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                    composer4.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    IconKt.m1605Iconww6aTOc(imageVector2, str5, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(20)), z4 ? colorScheme5.getSecondary() : colorScheme5.getOnSurfaceVariant(), composer4, 384, 0);
                                    Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                    composer4.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap6 = composer4.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(weight$default);
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor6);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m2947constructorimpl6 = Updater.m2947constructorimpl(composer4);
                                    Updater.m2954setimpl(m2947constructorimpl6, columnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m2954setimpl(m2947constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m2947constructorimpl6.getInserting() || !Intrinsics.areEqual(m2947constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                                        m2947constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                                        m2947constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
                                    }
                                    modifierMaterializerOf6.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                    composer4.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                                    TextKt.m2133Text4IGK_g(str5, (Modifier) null, colorScheme5.getOnSurface(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodyMedium(), composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65498);
                                    TextKt.m2133Text4IGK_g(str6, (Modifier) null, colorScheme5.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getLabelSmall(), composer4, 0, 0, 65530);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endReplaceableGroup();
                                    composer4.endNode();
                                    composer4.endReplaceableGroup();
                                    composer4.endReplaceableGroup();
                                    composer4.startReplaceableGroup(-1788042427);
                                    if (z4) {
                                        IconKt.m1605Iconww6aTOc(CheckKt.getCheck(Icons.INSTANCE.getDefault()), "Active", SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(16)), colorScheme5.getSecondary(), composer4, 432, 0);
                                    }
                                    composer4.endReplaceableGroup();
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
                        }), composer2, 100663344, 164);
                        mutableState15 = mutableState18;
                        z2 = false;
                        i7 = 1;
                    }
                    final MutableState<McqSessionMode> mutableState19 = mutableState15;
                    composer2.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f3)), composer2, 6);
                    final MutableState<String> mutableState20 = mutableState6;
                    final MutableState<DeckEntity> mutableState21 = mutableState7;
                    CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f3)), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(colorScheme4.getPrimaryContainer(), 0L, 0L, 0L, composer2, CardDefaults.$stable << 12, 14), null, BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl((float) 0.5d), Color.m3416copywmQWz5c$default(colorScheme4.getPrimary(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null)), ComposableLambdaKt.composableLambda(composer2, 1889201729, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3$1$5
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer4, Integer num) {
                            invoke(columnScope, composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ColumnScope Card, Composer composer4, int i8) {
                            Intrinsics.checkNotNullParameter(Card, "$this$Card");
                            if ((i8 & 81) != 16 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1889201729, i8, -1, "com.example.flashcardapp.ui.ReviseTab.<anonymous>.<anonymous>.<anonymous> (ReviseTab.kt:406)");
                                }
                                Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(14));
                                Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                final Function3<List<Long>, Boolean, McqSessionMode, Unit> function32 = function3;
                                int i9 = i6;
                                ColorScheme colorScheme5 = colorScheme4;
                                final SnapshotStateList<Long> snapshotStateList5 = snapshotStateList4;
                                final MutableState<String> mutableState22 = mutableState20;
                                final MutableState<DeckEntity> mutableState23 = mutableState21;
                                final MutableState<McqSessionMode> mutableState24 = mutableState19;
                                composer4.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer4, 54);
                                composer4.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap5 = composer4.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
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
                                Updater.m2954setimpl(m2947constructorimpl5, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m2954setimpl(m2947constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m2947constructorimpl5.getInserting() || !Intrinsics.areEqual(m2947constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                                    m2947constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                                    m2947constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                                }
                                modifierMaterializerOf5.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                composer4.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                composer4.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                MeasurePolicy columnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                composer4.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap6 = composer4.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(companion3);
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor6);
                                } else {
                                    composer4.useNode();
                                }
                                Composer m2947constructorimpl6 = Updater.m2947constructorimpl(composer4);
                                Updater.m2954setimpl(m2947constructorimpl6, columnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m2954setimpl(m2947constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m2947constructorimpl6.getInserting() || !Intrinsics.areEqual(m2947constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                                    m2947constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                                    m2947constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
                                }
                                modifierMaterializerOf6.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer4)), composer4, 0);
                                composer4.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                                boolean z4 = false;
                                TextKt.m2133Text4IGK_g("Selected Target Size", (Modifier) null, Color.m3416copywmQWz5c$default(colorScheme5.getOnPrimaryContainer(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getLabelSmall(), composer4, 6, 0, 65530);
                                TextKt.m2133Text4IGK_g(i9 + " Cards", (Modifier) null, colorScheme5.getOnPrimaryContainer(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getTitleMedium(), composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65498);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endReplaceableGroup();
                                composer4.endNode();
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
                                composer4.startReplaceableGroup(330126843);
                                boolean changedInstance = composer4.changedInstance(function32);
                                Object rememberedValue15 = composer4.rememberedValue();
                                if (changedInstance || rememberedValue15 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue15 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$3$1$5$1$2$1
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
                                            String ReviseTab$lambda$314;
                                            List<Long> list;
                                            String ReviseTab$lambda$315;
                                            McqSessionMode ReviseTab$lambda$132;
                                            DeckEntity ReviseTab$lambda$63;
                                            ReviseTab$lambda$314 = ReviseTabKt.ReviseTab$lambda$3(mutableState22);
                                            if (Intrinsics.areEqual(ReviseTab$lambda$314, "single")) {
                                                ReviseTab$lambda$63 = ReviseTabKt.ReviseTab$lambda$6(mutableState23);
                                                list = CollectionsKt.listOfNotNull(ReviseTab$lambda$63 != null ? Long.valueOf(ReviseTab$lambda$63.getId()) : null);
                                            } else {
                                                list = Intrinsics.areEqual(ReviseTab$lambda$314, "multi") ? snapshotStateList5.toList() : CollectionsKt.emptyList();
                                            }
                                            Function3<List<Long>, Boolean, McqSessionMode, Unit> function33 = function32;
                                            ReviseTab$lambda$315 = ReviseTabKt.ReviseTab$lambda$3(mutableState22);
                                            Boolean valueOf = Boolean.valueOf(Intrinsics.areEqual(ReviseTab$lambda$315, "starred"));
                                            ReviseTab$lambda$132 = ReviseTabKt.ReviseTab$lambda$13(mutableState24);
                                            function33.invoke(list, valueOf, ReviseTab$lambda$132);
                                        }
                                    };
                                    composer4.updateRememberedValue(rememberedValue15);
                                }
                                Function0 function05 = (Function0) rememberedValue15;
                                composer4.endReplaceableGroup();
                                if (i9 > 0) {
                                    z4 = true;
                                }
                                ButtonKt.Button(function05, null, z4, RoundedCornerShapeKt.RoundedCornerShape(50), ButtonDefaults.INSTANCE.m1274buttonColorsro_MJ88(colorScheme5.getPrimary(), Color.INSTANCE.m3454getWhite0d7_KjU(), 0L, 0L, composer4, (ButtonDefaults.$stable << 12) | 48, 12), null, null, null, null, ComposableSingletons$ReviseTabKt.INSTANCE.m6299getLambda1$app_release(), composer4, 805306368, 482);
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
                    }), composer2, 196614, 8);
                    SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(24)), composer2, 6);
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
        }), startRestartGroup, 805306416, 445);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$4
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

                public final void invoke(Composer composer2, int i3) {
                    ReviseTabKt.ReviseTab(AnkiDataRepository.this, onStartSession, z, onDarkModeToggle, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ReviseTab$lambda$3(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeckEntity ReviseTab$lambda$6(MutableState<DeckEntity> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ReviseTab$lambda$10(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ReviseTab$lambda$9(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final McqSessionMode ReviseTab$lambda$13(MutableState<McqSessionMode> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<DeckEntity> ReviseTab$lambda$0(State<? extends List<DeckEntity>> state) {
        return state.getValue();
    }

    private static final List<CardUserMetadataEntity> ReviseTab$lambda$1(State<? extends List<CardUserMetadataEntity>> state) {
        return state.getValue();
    }
}

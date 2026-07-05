package com.example.flashcardapp.ui;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRightKt;
import androidx.compose.material.icons.automirrored.filled.ListKt;
import androidx.compose.material.icons.filled.DragHandleKt;
import androidx.compose.material.icons.filled.MenuKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import com.example.flashcardapp.data.AnkiDeck;
import com.example.flashcardapp.data.SettingsRepository;
import com.example.flashcardapp.data.entities.CardAttemptEntity;
import com.example.flashcardapp.session.McqSessionMode;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReviewTab.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/lazy/LazyListScope;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ReviewTabKt$ReviewTab$20$1$4 extends Lambda implements Function1<LazyListScope, Unit> {
    final /* synthetic */ MutableState<DeckNode> $addCardNode$delegate;
    final /* synthetic */ List<CardAttemptEntity> $attemptsToday;
    final /* synthetic */ MutableState<DeckNode> $clearNode$delegate;
    final /* synthetic */ MutableState<Map<Long, McqSessionMode>> $deckModes$delegate;
    final /* synthetic */ List<AnkiDeck> $decks;
    final /* synthetic */ MutableState<DeckNode> $deleteNode$delegate;
    final /* synthetic */ MutableIntState $draggingIndex$delegate;
    final /* synthetic */ MutableState<Long> $draggingNodeId$delegate;
    final /* synthetic */ MutableFloatState $draggingOffset$delegate;
    final /* synthetic */ MutableState<Set<String>> $expandedNodes$delegate;
    final /* synthetic */ Function0<Unit> $onDeckOrderChanged;
    final /* synthetic */ Function1<AnkiDeck, Unit> $onExportDeck;
    final /* synthetic */ Function1<AnkiDeck, Unit> $onSelectDeck;
    final /* synthetic */ MutableState<DeckNode> $renameNode$delegate;
    final /* synthetic */ MutableState<String> $searchQuery$delegate;
    final /* synthetic */ MutableState<DeckNode> $settingsNode$delegate;
    final /* synthetic */ SettingsRepository $settingsRepo;
    final /* synthetic */ State<List<Pair<DeckNode, Integer>>> $visibleNodes$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ReviewTabKt$ReviewTab$20$1$4(State<? extends List<Pair<DeckNode, Integer>>> state, MutableState<String> mutableState, MutableState<Set<String>> mutableState2, MutableState<Map<Long, McqSessionMode>> mutableState3, MutableState<Long> mutableState4, MutableFloatState mutableFloatState, MutableIntState mutableIntState, List<AnkiDeck> list, SettingsRepository settingsRepository, Function0<Unit> function0, List<CardAttemptEntity> list2, Function1<? super AnkiDeck, Unit> function1, MutableState<DeckNode> mutableState5, Function1<? super AnkiDeck, Unit> function12, MutableState<DeckNode> mutableState6, MutableState<DeckNode> mutableState7, MutableState<DeckNode> mutableState8, MutableState<DeckNode> mutableState9) {
        super(1);
        this.$visibleNodes$delegate = state;
        this.$searchQuery$delegate = mutableState;
        this.$expandedNodes$delegate = mutableState2;
        this.$deckModes$delegate = mutableState3;
        this.$draggingNodeId$delegate = mutableState4;
        this.$draggingOffset$delegate = mutableFloatState;
        this.$draggingIndex$delegate = mutableIntState;
        this.$decks = list;
        this.$settingsRepo = settingsRepository;
        this.$onDeckOrderChanged = function0;
        this.$attemptsToday = list2;
        this.$onSelectDeck = function1;
        this.$settingsNode$delegate = mutableState5;
        this.$onExportDeck = function12;
        this.$addCardNode$delegate = mutableState6;
        this.$renameNode$delegate = mutableState7;
        this.$clearNode$delegate = mutableState8;
        this.$deleteNode$delegate = mutableState9;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
        invoke2(lazyListScope);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LazyListScope LazyColumn) {
        final List ReviewTab$lambda$77;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        ReviewTab$lambda$77 = ReviewTabKt.ReviewTab$lambda$77(this.$visibleNodes$delegate);
        final AnonymousClass1 anonymousClass1 = new Function1<Pair<? extends DeckNode, ? extends Integer>, Object>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Pair<? extends DeckNode, ? extends Integer> pair) {
                return invoke2((Pair<DeckNode, Integer>) pair);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Pair<DeckNode, Integer> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getFirst().getFullPath();
            }
        };
        final MutableState<String> mutableState = this.$searchQuery$delegate;
        final MutableState<Set<String>> mutableState2 = this.$expandedNodes$delegate;
        final MutableState<Map<Long, McqSessionMode>> mutableState3 = this.$deckModes$delegate;
        final MutableState<Long> mutableState4 = this.$draggingNodeId$delegate;
        final MutableFloatState mutableFloatState = this.$draggingOffset$delegate;
        final State<List<Pair<DeckNode, Integer>>> state = this.$visibleNodes$delegate;
        final MutableIntState mutableIntState = this.$draggingIndex$delegate;
        final List<AnkiDeck> list = this.$decks;
        final SettingsRepository settingsRepository = this.$settingsRepo;
        final Function0<Unit> function0 = this.$onDeckOrderChanged;
        final List<CardAttemptEntity> list2 = this.$attemptsToday;
        final Function1<AnkiDeck, Unit> function1 = this.$onSelectDeck;
        final MutableState<DeckNode> mutableState5 = this.$settingsNode$delegate;
        final Function1<AnkiDeck, Unit> function12 = this.$onExportDeck;
        final MutableState<DeckNode> mutableState6 = this.$addCardNode$delegate;
        final MutableState<DeckNode> mutableState7 = this.$renameNode$delegate;
        final MutableState<DeckNode> mutableState8 = this.$clearNode$delegate;
        final MutableState<DeckNode> mutableState9 = this.$deleteNode$delegate;
        final ReviewTabKt$ReviewTab$20$1$4$invoke$$inlined$items$default$1 reviewTabKt$ReviewTab$20$1$4$invoke$$inlined$items$default$1 = new Function1() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$invoke$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Pair<? extends DeckNode, ? extends Integer> pair) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((Pair<? extends DeckNode, ? extends Integer>) obj);
            }
        };
        LazyColumn.items(ReviewTab$lambda$77.size(), anonymousClass1 != null ? new Function1<Integer, Object>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$invoke$$inlined$items$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(ReviewTab$lambda$77.get(i));
            }
        } : null, new Function1<Integer, Object>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$invoke$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(ReviewTab$lambda$77.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$invoke$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                String ReviewTab$lambda$23;
                Set ReviewTab$lambda$42;
                final boolean contains;
                Map ReviewTab$lambda$65;
                long surface;
                Long ReviewTab$lambda$68;
                float invoke$lambda$8$lambda$5;
                float invoke$lambda$8$lambda$6;
                long outlineVariant;
                ComposerKt.sourceInformation(composer, "C148@6730L22:LazyDsl.kt#428nma");
                if ((i2 & 14) == 0) {
                    i3 = i2 | (composer.changed(lazyItemScope) ? 4 : 2);
                } else {
                    i3 = i2;
                }
                if ((i2 & 112) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if ((i3 & 731) == 146 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:148)");
                }
                Pair pair = (Pair) ReviewTab$lambda$77.get(i);
                final DeckNode deckNode = (DeckNode) pair.component1();
                final int intValue = ((Number) pair.component2()).intValue();
                ReviewTab$lambda$23 = ReviewTabKt.ReviewTab$lambda$23(mutableState);
                if (!StringsKt.isBlank(ReviewTab$lambda$23)) {
                    contains = true;
                } else {
                    ReviewTab$lambda$42 = ReviewTabKt.ReviewTab$lambda$42(mutableState2);
                    contains = ReviewTab$lambda$42.contains(deckNode.getFullPath());
                }
                final boolean z = !deckNode.getChildren().isEmpty();
                composer.startReplaceableGroup(-1806882823);
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composer.updateRememberedValue(rememberedValue);
                }
                final MutableState mutableState10 = (MutableState) rememberedValue;
                composer.endReplaceableGroup();
                AnkiDeck deck = deckNode.getDeck();
                if (deck == null) {
                    deck = new AnkiDeck(-1L, deckNode.getFullPath(), 0, 4, null);
                }
                final AnkiDeck ankiDeck = deck;
                final State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(contains ? 90.0f : 0.0f, null, 0.0f, "arrowRotation", null, composer, 3072, 22);
                ReviewTab$lambda$65 = ReviewTabKt.ReviewTab$lambda$65(mutableState3);
                final McqSessionMode mcqSessionMode = (McqSessionMode) ReviewTab$lambda$65.get(Long.valueOf(ankiDeck.getId()));
                if (mcqSessionMode == McqSessionMode.PRACTICE) {
                    composer.startReplaceableGroup(-1806882146);
                    surface = Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimaryContainer(), intValue > 0 ? 0.5f : 0.8f, 0.0f, 0.0f, 0.0f, 14, null);
                    composer.endReplaceableGroup();
                } else if (mcqSessionMode == McqSessionMode.REVISION) {
                    composer.startReplaceableGroup(-1806881983);
                    surface = Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSecondaryContainer(), intValue > 0 ? 0.5f : 0.8f, 0.0f, 0.0f, 0.0f, 14, null);
                    composer.endReplaceableGroup();
                } else if (mcqSessionMode == McqSessionMode.TEST) {
                    composer.startReplaceableGroup(-1806881825);
                    surface = Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getTertiaryContainer(), intValue > 0 ? 0.5f : 0.8f, 0.0f, 0.0f, 0.0f, 14, null);
                    composer.endReplaceableGroup();
                } else if (intValue > 0) {
                    composer.startReplaceableGroup(-1806881699);
                    surface = Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSurfaceVariant(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null);
                    composer.endReplaceableGroup();
                } else {
                    composer.startReplaceableGroup(-1806881618);
                    surface = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSurface();
                    composer.endReplaceableGroup();
                }
                long j = surface;
                ReviewTab$lambda$68 = ReviewTabKt.ReviewTab$lambda$68(mutableState4);
                boolean z2 = ReviewTab$lambda$68 != null && ReviewTab$lambda$68.longValue() == ankiDeck.getId();
                State<Float> animateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(z2 ? 1.03f : 1.0f, null, 0.0f, "scale", null, composer, 3072, 22);
                State<Dp> m120animateDpAsStateAjpBEmI = AnimateAsStateKt.m120animateDpAsStateAjpBEmI(Dp.m5738constructorimpl(z2 ? 6 : 2), null, "elevation", null, composer, 384, 10);
                final float ReviewTab$lambda$71 = z2 ? ReviewTabKt.ReviewTab$lambda$71(mutableFloatState) : 0.0f;
                Modifier m573paddingqDBjuR0$default = PaddingKt.m573paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(intValue * 16), 0.0f, 0.0f, 0.0f, 14, null);
                invoke$lambda$8$lambda$5 = ReviewTabKt$ReviewTab$20$1$4.invoke$lambda$8$lambda$5(animateFloatAsState2);
                Modifier scale = ScaleKt.scale(m573paddingqDBjuR0$default, invoke$lambda$8$lambda$5);
                invoke$lambda$8$lambda$6 = ReviewTabKt$ReviewTab$20$1$4.invoke$lambda$8$lambda$6(m120animateDpAsStateAjpBEmI);
                Modifier m3089shadows4CzXII$default = ShadowKt.m3089shadows4CzXII$default(scale, invoke$lambda$8$lambda$6, MaterialTheme.INSTANCE.getShapes(composer, MaterialTheme.$stable).getMedium(), false, 0L, 0L, 28, null);
                composer.startReplaceableGroup(-1806880834);
                boolean changed = composer.changed(ReviewTab$lambda$71);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$2$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                            invoke2(graphicsLayerScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GraphicsLayerScope graphicsLayer) {
                            Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                            graphicsLayer.setTranslationY(ReviewTab$lambda$71);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceableGroup();
                Modifier animateItemPlacement$default = LazyItemScope.animateItemPlacement$default(lazyItemScope, GraphicsLayerModifierKt.graphicsLayer(m3089shadows4CzXII$default, (Function1) rememberedValue2), null, 1, null);
                CornerBasedShape medium = MaterialTheme.INSTANCE.getShapes(composer, MaterialTheme.$stable).getMedium();
                CardColors m1295cardColorsro_MJ88 = CardDefaults.INSTANCE.m1295cardColorsro_MJ88(j, 0L, 0L, 0L, composer, CardDefaults.$stable << 12, 14);
                float m5738constructorimpl = Dp.m5738constructorimpl(1);
                if (intValue > 0) {
                    composer.startReplaceableGroup(-1806880268);
                    outlineVariant = Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOutlineVariant(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null);
                    composer.endReplaceableGroup();
                } else {
                    composer.startReplaceableGroup(-1806880185);
                    outlineVariant = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOutlineVariant();
                    composer.endReplaceableGroup();
                }
                BorderStroke m244BorderStrokecXLIe8U = BorderStrokeKt.m244BorderStrokecXLIe8U(m5738constructorimpl, outlineVariant);
                final MutableState mutableState11 = mutableState4;
                final MutableFloatState mutableFloatState2 = mutableFloatState;
                final State state2 = state;
                final MutableIntState mutableIntState2 = mutableIntState;
                final List list3 = list;
                final SettingsRepository settingsRepository2 = settingsRepository;
                final Function0 function02 = function0;
                final MutableState mutableState12 = mutableState;
                final MutableState mutableState13 = mutableState2;
                final List list4 = list2;
                final Function1 function13 = function1;
                final MutableState mutableState14 = mutableState5;
                final Function1 function14 = function12;
                final MutableState mutableState15 = mutableState6;
                final MutableState mutableState16 = mutableState7;
                final MutableState mutableState17 = mutableState8;
                final MutableState mutableState18 = mutableState9;
                CardKt.Card(animateItemPlacement$default, medium, m1295cardColorsro_MJ88, null, m244BorderStrokecXLIe8U, ComposableLambdaKt.composableLambda(composer, -13459830, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$2$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                        invoke(columnScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Type inference failed for: r13v1 */
                    /* JADX WARN: Type inference failed for: r13v2, types: [boolean, int] */
                    /* JADX WARN: Type inference failed for: r13v7 */
                    public final void invoke(ColumnScope Card, Composer composer2, int i4) {
                        String str;
                        String str2;
                        int i5;
                        boolean z3;
                        boolean z4;
                        String str3;
                        int i6;
                        float m5738constructorimpl2;
                        int i7;
                        String str4;
                        AnkiDeck ankiDeck2;
                        ?? r13;
                        long secondaryContainer;
                        long onSecondaryContainer;
                        Modifier.Companion companion;
                        final MutableState<Boolean> mutableState19;
                        boolean invoke$lambda$8$lambda$1;
                        float invoke$lambda$8$lambda$3;
                        long tertiary;
                        Intrinsics.checkNotNullParameter(Card, "$this$Card");
                        if ((i4 & 81) != 16 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-13459830, i4, -1, "com.example.flashcardapp.ui.ReviewTab.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ReviewTab.kt:816)");
                            }
                            Modifier height = IntrinsicKt.height(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), IntrinsicSize.Min);
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            int i8 = intValue;
                            boolean z5 = z;
                            AnkiDeck ankiDeck3 = ankiDeck;
                            MutableState<Long> mutableState20 = mutableState11;
                            MutableFloatState mutableFloatState3 = mutableFloatState2;
                            State<List<Pair<DeckNode, Integer>>> state3 = state2;
                            MutableIntState mutableIntState3 = mutableIntState2;
                            List<AnkiDeck> list5 = list3;
                            SettingsRepository settingsRepository3 = settingsRepository2;
                            Function0<Unit> function03 = function02;
                            boolean z6 = contains;
                            final DeckNode deckNode2 = deckNode;
                            final MutableState<String> mutableState21 = mutableState12;
                            final MutableState<Set<String>> mutableState22 = mutableState13;
                            McqSessionMode mcqSessionMode2 = mcqSessionMode;
                            List<CardAttemptEntity> list6 = list4;
                            State<Float> state4 = animateFloatAsState;
                            final Function1<AnkiDeck, Unit> function15 = function13;
                            final MutableState<DeckNode> mutableState23 = mutableState14;
                            final Function1<AnkiDeck, Unit> function16 = function14;
                            MutableState<Boolean> mutableState24 = mutableState10;
                            final MutableState<DeckNode> mutableState25 = mutableState15;
                            final MutableState<DeckNode> mutableState26 = mutableState16;
                            final MutableState<DeckNode> mutableState27 = mutableState17;
                            final MutableState<DeckNode> mutableState28 = mutableState18;
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(height);
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
                            Updater.m2954setimpl(m2947constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m2954setimpl(m2947constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m2947constructorimpl.getInserting() || !Intrinsics.areEqual(m2947constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m2947constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m2947constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(429576173);
                            if (i8 > 0) {
                                Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(4)), 0.0f, 1, null);
                                if (z5) {
                                    composer2.startReplaceableGroup(429576557);
                                    tertiary = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getSecondary();
                                    composer2.endReplaceableGroup();
                                } else {
                                    composer2.startReplaceableGroup(429576646);
                                    tertiary = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getTertiary();
                                    composer2.endReplaceableGroup();
                                }
                                BoxKt.Box(BackgroundKt.m216backgroundbw27NRU$default(fillMaxHeight$default, tertiary, null, 2, null), composer2, 0);
                            }
                            composer2.endReplaceableGroup();
                            composer2.startReplaceableGroup(429576806);
                            if (ankiDeck3.getId() != -1) {
                                z3 = z5;
                                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(PaddingKt.m573paddingqDBjuR0$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null), Long.valueOf(ankiDeck3.getId()), new ReviewTabKt$ReviewTab$20$1$4$2$2$1$1(ankiDeck3, mutableState20, mutableFloatState3, state3, mutableIntState3, list5, settingsRepository3, function03, null));
                                Alignment center = Alignment.INSTANCE.getCenter();
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                                composer2.startReplaceableGroup(-1323940314);
                                str3 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
                                ComposerKt.sourceInformation(composer2, str3);
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(pointerInput);
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
                                Updater.m2954setimpl(m2947constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m2954setimpl(m2947constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m2947constructorimpl2.getInserting() || !Intrinsics.areEqual(m2947constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m2947constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m2947constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                modifierMaterializerOf2.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                str = "C73@3426L9:Box.kt#2w3rfo";
                                z4 = z6;
                                i5 = 12;
                                str2 = "C92@4661L9:Row.kt#2w3rfo";
                                IconKt.m1605Iconww6aTOc(DragHandleKt.getDragHandle(Icons.INSTANCE.getDefault()), "Drag to Rearrange", SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(18)), Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), composer2, 432, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                            } else {
                                str = "C73@3426L9:Box.kt#2w3rfo";
                                str2 = "C92@4661L9:Row.kt#2w3rfo";
                                i5 = 12;
                                z3 = z5;
                                z4 = z6;
                                str3 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
                            }
                            composer2.endReplaceableGroup();
                            Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                            if (ankiDeck3.getId() != -1) {
                                m5738constructorimpl2 = Dp.m5738constructorimpl(4);
                                i6 = 16;
                            } else {
                                i6 = 16;
                                m5738constructorimpl2 = Dp.m5738constructorimpl(16);
                            }
                            float f = i5;
                            Modifier m572paddingqDBjuR0 = PaddingKt.m572paddingqDBjuR0(weight$default, m5738constructorimpl2, Dp.m5738constructorimpl(f), Dp.m5738constructorimpl(i6), Dp.m5738constructorimpl(f));
                            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceBetween, centerVertically2, composer2, 54);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, str3);
                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m572paddingqDBjuR0);
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
                            Updater.m2954setimpl(m2947constructorimpl3, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                            }
                            modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -326681643, str2);
                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                            Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                            final boolean z7 = z3;
                            final boolean z8 = z4;
                            Modifier m251clickableXHw0xAI$default = ClickableKt.m251clickableXHw0xAI$default(RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, null, new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$2$2$1$3$1
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
                                    String ReviewTab$lambda$232;
                                    Set ReviewTab$lambda$422;
                                    Set plus;
                                    Set ReviewTab$lambda$423;
                                    if (z7) {
                                        ReviewTab$lambda$232 = ReviewTabKt.ReviewTab$lambda$23(mutableState21);
                                        if (StringsKt.isBlank(ReviewTab$lambda$232)) {
                                            MutableState<Set<String>> mutableState29 = mutableState22;
                                            if (z8) {
                                                ReviewTab$lambda$423 = ReviewTabKt.ReviewTab$lambda$42(mutableState29);
                                                plus = SetsKt.minus((Set<? extends String>) ReviewTab$lambda$423, deckNode2.getFullPath());
                                            } else {
                                                ReviewTab$lambda$422 = ReviewTabKt.ReviewTab$lambda$42(mutableState29);
                                                plus = SetsKt.plus((Set<? extends String>) ReviewTab$lambda$422, deckNode2.getFullPath());
                                            }
                                            mutableState29.setValue(plus);
                                        }
                                    }
                                }
                            }, 7, null);
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, composer2, 48);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, str3);
                            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(m251clickableXHw0xAI$default);
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
                            Updater.m2954setimpl(m2947constructorimpl4, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                            }
                            modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -326681643, str2);
                            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                            if (z3) {
                                composer2.startReplaceableGroup(857858850);
                                ImageVector keyboardArrowRight = KeyboardArrowRightKt.getKeyboardArrowRight(Icons.AutoMirrored.Filled.INSTANCE);
                                long primary = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary();
                                Modifier m618size3ABfNKs = SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(24));
                                invoke$lambda$8$lambda$3 = ReviewTabKt$ReviewTab$20$1$4.invoke$lambda$8$lambda$3(state4);
                                ankiDeck2 = ankiDeck3;
                                r13 = 0;
                                i7 = -1323940314;
                                str4 = "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo";
                                IconKt.m1605Iconww6aTOc(keyboardArrowRight, "Toggle", RotateKt.rotate(m618size3ABfNKs, invoke$lambda$8$lambda$3), primary, composer2, 48, 0);
                                SpacerKt.Spacer(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(4)), composer2, 6);
                                composer2.endReplaceableGroup();
                            } else {
                                i7 = -1323940314;
                                str4 = "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo";
                                ankiDeck2 = ankiDeck3;
                                r13 = 0;
                                composer2.startReplaceableGroup(857859555);
                                SpacerKt.Spacer(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(28)), composer2, 6);
                                composer2.endReplaceableGroup();
                            }
                            composer2.startReplaceableGroup(857859731);
                            if (mcqSessionMode2 == McqSessionMode.PRACTICE) {
                                secondaryContainer = Color.INSTANCE.m3454getWhite0d7_KjU();
                            } else if (mcqSessionMode2 == McqSessionMode.REVISION) {
                                secondaryContainer = ColorKt.Color(4294940672L);
                            } else if (mcqSessionMode2 == McqSessionMode.TEST) {
                                secondaryContainer = ColorKt.Color(4280391411L);
                            } else if (z3) {
                                composer2.startReplaceableGroup(857860176);
                                secondaryContainer = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimaryContainer();
                                composer2.endReplaceableGroup();
                            } else {
                                composer2.startReplaceableGroup(857860273);
                                secondaryContainer = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getSecondaryContainer();
                                composer2.endReplaceableGroup();
                            }
                            long j2 = secondaryContainer;
                            composer2.endReplaceableGroup();
                            composer2.startReplaceableGroup(857860440);
                            if (mcqSessionMode2 == McqSessionMode.PRACTICE) {
                                onSecondaryContainer = ColorKt.Color(4280160309L);
                            } else if (mcqSessionMode2 == McqSessionMode.REVISION) {
                                onSecondaryContainer = Color.INSTANCE.m3454getWhite0d7_KjU();
                            } else if (mcqSessionMode2 == McqSessionMode.TEST) {
                                onSecondaryContainer = Color.INSTANCE.m3454getWhite0d7_KjU();
                            } else if (z3) {
                                composer2.startReplaceableGroup(857860875);
                                onSecondaryContainer = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnPrimaryContainer();
                                composer2.endReplaceableGroup();
                            } else {
                                composer2.startReplaceableGroup(857860974);
                                onSecondaryContainer = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSecondaryContainer();
                                composer2.endReplaceableGroup();
                            }
                            long j3 = onSecondaryContainer;
                            composer2.endReplaceableGroup();
                            Modifier m216backgroundbw27NRU$default = BackgroundKt.m216backgroundbw27NRU$default(ClipKt.clip(SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(36)), MaterialTheme.INSTANCE.getShapes(composer2, MaterialTheme.$stable).getSmall()), j2, null, 2, null);
                            composer2.startReplaceableGroup(857861515);
                            if (mcqSessionMode2 == McqSessionMode.PRACTICE) {
                                companion = BorderKt.m228borderxT4_qwU(Modifier.INSTANCE, Dp.m5738constructorimpl(1), Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOutlineVariant(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getShapes(composer2, MaterialTheme.$stable).getSmall());
                            } else {
                                companion = Modifier.INSTANCE;
                            }
                            composer2.endReplaceableGroup();
                            Modifier then = m216backgroundbw27NRU$default.then(companion);
                            Alignment center2 = Alignment.INSTANCE.getCenter();
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, r13, composer2, 6);
                            composer2.startReplaceableGroup(i7);
                            ComposerKt.sourceInformation(composer2, str3);
                            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer2, r13);
                            CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(then);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor5);
                            } else {
                                composer2.useNode();
                            }
                            Composer m2947constructorimpl5 = Updater.m2947constructorimpl(composer2);
                            Updater.m2954setimpl(m2947constructorimpl5, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m2954setimpl(m2947constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m2947constructorimpl5.getInserting() || !Intrinsics.areEqual(m2947constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                                m2947constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                                m2947constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                            }
                            modifierMaterializerOf5.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, Integer.valueOf((int) r13));
                            composer2.startReplaceableGroup(2058660585);
                            String str5 = str;
                            ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, str5);
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            IconKt.m1605Iconww6aTOc(z3 ? MenuKt.getMenu(Icons.INSTANCE.getDefault()) : ListKt.getList(Icons.AutoMirrored.Filled.INSTANCE), (String) null, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(18)), j3, composer2, 432, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            SpacerKt.Spacer(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f)), composer2, 6);
                            Modifier weight$default2 = RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null);
                            composer2.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, r13);
                            composer2.startReplaceableGroup(i7);
                            ComposerKt.sourceInformation(composer2, str3);
                            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer2, r13);
                            CompositionLocalMap currentCompositionLocalMap6 = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(weight$default2);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor6);
                            } else {
                                composer2.useNode();
                            }
                            Composer m2947constructorimpl6 = Updater.m2947constructorimpl(composer2);
                            Updater.m2954setimpl(m2947constructorimpl6, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m2954setimpl(m2947constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m2947constructorimpl6.getInserting() || !Intrinsics.areEqual(m2947constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                                m2947constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                                m2947constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
                            }
                            modifierMaterializerOf6.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, Integer.valueOf((int) r13));
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            String str6 = str2;
                            String str7 = str3;
                            final AnkiDeck ankiDeck4 = ankiDeck2;
                            String str8 = str4;
                            TextKt.m2133Text4IGK_g(deckNode2.getShortName(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getTitleMedium(), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65498);
                            TextKt.m2133Text4IGK_g(deckNode2.getDeck() != null ? "Leaf Deck • ID: " + deckNode2.getDeck().getId() : deckNode2.getChildren().size() + " sub-decks", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelSmall(), composer2, 0, 0, 65530);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            int recursiveCardCount = ReviewTabKt.getRecursiveCardCount(deckNode2);
                            int practicedCount = ReviewTabKt.getPracticedCount(deckNode2, list6);
                            final String sb = (practicedCount > 0 ? new StringBuilder().append(practicedCount).append("/") : new StringBuilder()).append(recursiveCardCount).append(" Qs").toString();
                            SurfaceKt.m1985SurfaceT9BRK9s(PaddingKt.m573paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m5738constructorimpl(8), 0.0f, 11, null), RoundedCornerShapeKt.RoundedCornerShape(50), Color.m3416copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimaryContainer(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, 215522467, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$2$2$1$3$2$3
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i9) {
                                    TextStyle m5264copyp1EtxEg;
                                    if ((i9 & 11) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(215522467, i9, -1, "com.example.flashcardapp.ui.ReviewTab.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ReviewTab.kt:996)");
                                        }
                                        m5264copyp1EtxEg = r16.m5264copyp1EtxEg((r48 & 1) != 0 ? r16.spanStyle.m5197getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r16.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r16.spanStyle.getFontWeight() : FontWeight.INSTANCE.getBold(), (r48 & 8) != 0 ? r16.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r16.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r16.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r16.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r16.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r16.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r16.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r16.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r16.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r16.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r16.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r16.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r16.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r16.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r16.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r16.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r16.platformStyle : null, (r48 & 1048576) != 0 ? r16.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r16.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r16.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getLabelMedium().paragraphStyle.getTextMotion() : null);
                                        TextKt.m2133Text4IGK_g(sb, PaddingKt.m570paddingVpY3zN4(Modifier.INSTANCE, Dp.m5738constructorimpl(8), Dp.m5738constructorimpl(4)), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m5264copyp1EtxEg, composer3, 48, 0, 65528);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, 12582918, androidx.compose.material3.MenuKt.InTransitionDuration);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                            Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(4));
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, str8);
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            MeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(m478spacedBy0680j_4, centerVertically4, composer2, 54);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, str7);
                            int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap7 = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf7 = LayoutKt.modifierMaterializerOf(companion2);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor7);
                            } else {
                                composer2.useNode();
                            }
                            Composer m2947constructorimpl7 = Updater.m2947constructorimpl(composer2);
                            Updater.m2954setimpl(m2947constructorimpl7, rowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m2954setimpl(m2947constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m2947constructorimpl7.getInserting() || !Intrinsics.areEqual(m2947constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                                m2947constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                                m2947constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
                            }
                            modifierMaterializerOf7.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -326681643, str6);
                            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(857865008);
                            boolean changedInstance = composer2.changedInstance(function15) | composer2.changed(ankiDeck4);
                            Object rememberedValue3 = composer2.rememberedValue();
                            if (changedInstance || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$2$2$1$3$3$1$1
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
                                        function15.invoke(ankiDeck4);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue3);
                            }
                            composer2.endReplaceableGroup();
                            float f2 = 32;
                            IconButtonKt.IconButton((Function0) rememberedValue3, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f2)), false, null, null, ComposableSingletons$ReviewTabKt.INSTANCE.m6274getLambda35$app_release(), composer2, 196656, 28);
                            IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$2$2$1$3$3$2
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
                                    mutableState23.setValue(DeckNode.this);
                                }
                            }, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f2)), false, null, null, ComposableSingletons$ReviewTabKt.INSTANCE.m6275getLambda36$app_release(), composer2, 196656, 28);
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            Modifier.Companion companion3 = Modifier.INSTANCE;
                            MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, str7);
                            int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap8 = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor8 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf8 = LayoutKt.modifierMaterializerOf(companion3);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor8);
                            } else {
                                composer2.useNode();
                            }
                            Composer m2947constructorimpl8 = Updater.m2947constructorimpl(composer2);
                            Updater.m2954setimpl(m2947constructorimpl8, rememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m2954setimpl(m2947constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m2947constructorimpl8.getInserting() || !Intrinsics.areEqual(m2947constructorimpl8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash8))) {
                                m2947constructorimpl8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
                                m2947constructorimpl8.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
                            }
                            modifierMaterializerOf8.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, str5);
                            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(1901894552);
                            Object rememberedValue4 = composer2.rememberedValue();
                            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                mutableState19 = mutableState24;
                                rememberedValue4 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$2$2$1$3$3$3$1$1
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
                                        ReviewTabKt$ReviewTab$20$1$4.invoke$lambda$8$lambda$2(mutableState19, true);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue4);
                            } else {
                                mutableState19 = mutableState24;
                            }
                            composer2.endReplaceableGroup();
                            IconButtonKt.IconButton((Function0) rememberedValue4, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f2)), false, null, null, ComposableSingletons$ReviewTabKt.INSTANCE.m6276getLambda37$app_release(), composer2, 196662, 28);
                            invoke$lambda$8$lambda$1 = ReviewTabKt$ReviewTab$20$1$4.invoke$lambda$8$lambda$1(mutableState19);
                            composer2.startReplaceableGroup(1901895130);
                            Object rememberedValue5 = composer2.rememberedValue();
                            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue5 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$2$2$1$3$3$3$2$1
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
                                        ReviewTabKt$ReviewTab$20$1$4.invoke$lambda$8$lambda$2(mutableState19, false);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue5);
                            }
                            Function0 function04 = (Function0) rememberedValue5;
                            composer2.endReplaceableGroup();
                            composer2.startReplaceableGroup(1901895214);
                            boolean changedInstance2 = composer2.changedInstance(function15) | composer2.changed(ankiDeck4);
                            Object rememberedValue6 = composer2.rememberedValue();
                            if (changedInstance2 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue6 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$2$2$1$3$3$3$3$1
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
                                        function15.invoke(ankiDeck4);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue6);
                            }
                            Function0 function05 = (Function0) rememberedValue6;
                            composer2.endReplaceableGroup();
                            Function0<Unit> function06 = new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$2$2$1$3$3$3$4
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
                                    mutableState25.setValue(DeckNode.this);
                                }
                            };
                            composer2.startReplaceableGroup(1901895392);
                            boolean changedInstance3 = composer2.changedInstance(function15) | composer2.changed(ankiDeck4);
                            Object rememberedValue7 = composer2.rememberedValue();
                            if (changedInstance3 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue7 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$2$2$1$3$3$3$5$1
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
                                        function15.invoke(ankiDeck4);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue7);
                            }
                            Function0 function07 = (Function0) rememberedValue7;
                            composer2.endReplaceableGroup();
                            Function0<Unit> function08 = new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$2$2$1$3$3$3$6
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
                                    mutableState26.setValue(DeckNode.this);
                                }
                            };
                            Function0<Unit> function09 = new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$2$2$1$3$3$3$7
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
                                    mutableState27.setValue(DeckNode.this);
                                }
                            };
                            Function0<Unit> function010 = new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$2$2$1$3$3$3$8
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
                                    mutableState28.setValue(DeckNode.this);
                                }
                            };
                            composer2.startReplaceableGroup(1901895735);
                            boolean changedInstance4 = composer2.changedInstance(function16) | composer2.changed(ankiDeck4);
                            Object rememberedValue8 = composer2.rememberedValue();
                            if (changedInstance4 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue8 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$2$2$1$3$3$3$9$1
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
                                        function16.invoke(ankiDeck4);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue8);
                            }
                            composer2.endReplaceableGroup();
                            ReviewTabKt.DeckOptionsMenu(deckNode2, invoke$lambda$8$lambda$1, function04, function05, function06, function07, function08, function09, function010, (Function0) rememberedValue8, composer2, 392);
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
                }), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$8$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$8$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$lambda$8$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$lambda$8$lambda$5(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$lambda$8$lambda$6(State<Dp> state) {
        return state.getValue().m5752unboximpl();
    }
}

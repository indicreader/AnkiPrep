package com.example.flashcardapp.ui;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
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
import com.example.flashcardapp.mcq.EnglishEngine;
import com.example.flashcardapp.mcq.Mcq;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: EnglishStartupScreen.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\f\u0010\b\u001a\u0004\u0018\u00010\tX\u008a\u008e\u0002²\u0006\u0012\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u008a\u008e\u0002²\u0006\n\u0010\r\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\f\u0010\u0010\u001a\u0004\u0018\u00010\tX\u008a\u008e\u0002²\u0006\n\u0010\u0011\u001a\u00020\u000fX\u008a\u008e\u0002"}, d2 = {"EnglishStartupScreen", "", "engine", "Lcom/example/flashcardapp/mcq/EnglishEngine;", "onQuizCompleted", "Lkotlin/Function0;", "(Lcom/example/flashcardapp/mcq/EnglishEngine;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release", "selectedLimit", "", "mcqs", "", "Lcom/example/flashcardapp/mcq/Mcq;", "currentIndex", "showExplanation", "", "selectedAnswerIndex", "isLoading"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class EnglishStartupScreenKt {
    public static final void EnglishStartupScreen(final EnglishEngine engine, Function0<Unit> onQuizCompleted, Composer composer, final int i) {
        Composer composer2;
        final Function0<Unit> function0;
        long surfaceVariant;
        long onSurfaceVariant;
        Integer EnglishStartupScreen$lambda$13;
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(onQuizCompleted, "onQuizCompleted");
        Composer startRestartGroup = composer.startRestartGroup(-468622196);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-468622196, i, -1, "com.example.flashcardapp.ui.EnglishStartupScreen (EnglishStartupScreen.kt:18)");
        }
        startRestartGroup.startReplaceableGroup(-1804941390);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1804941334);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        final MutableState mutableState2 = (MutableState) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1804941264);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        final MutableState mutableState3 = (MutableState) rememberedValue3;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1804941206);
        Object rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue4);
        }
        final MutableState mutableState4 = (MutableState) rememberedValue4;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1804941140);
        Object rememberedValue5 = startRestartGroup.rememberedValue();
        if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
            rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue5);
        }
        final MutableState mutableState5 = (MutableState) rememberedValue5;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue6 = startRestartGroup.rememberedValue();
        if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
            startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue6 = compositionScopedCoroutineScopeCanceller;
        }
        startRestartGroup.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue6).getCoroutineScope();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1804941038);
        Object rememberedValue7 = startRestartGroup.rememberedValue();
        if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
            rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue7);
        }
        final MutableState mutableState6 = (MutableState) rememberedValue7;
        startRestartGroup.endReplaceableGroup();
        if (EnglishStartupScreen$lambda$1(mutableState) == null) {
            startRestartGroup.startReplaceableGroup(-1804940971);
            float f = 32;
            Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(f));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, startRestartGroup, 54);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
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
            Updater.m2954setimpl(m2947constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2954setimpl(m2947constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m2947constructorimpl.getInserting() || !Intrinsics.areEqual(m2947constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m2947constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m2947constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            TextKt.m2133Text4IGK_g("Daily English Checkpoint", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getHeadlineMedium(), startRestartGroup, 6, 0, 65534);
            SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(8)), startRestartGroup, 6);
            TextKt.m2133Text4IGK_g("Complete this warm-up to access your decks.", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodyMedium(), startRestartGroup, 6, 0, 65534);
            SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f)), startRestartGroup, 6);
            TextKt.m2133Text4IGK_g("Select number of questions:", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getTitleMedium(), startRestartGroup, 6, 0, 65534);
            SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(16)), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1804940269);
            int i2 = 4;
            Iterator it = CollectionsKt.listOf((Object[]) new Integer[]{10, 20, 40, 50}).iterator();
            while (it.hasNext()) {
                final int intValue = ((Number) it.next()).intValue();
                final CoroutineScope coroutineScope2 = coroutineScope;
                CoroutineScope coroutineScope3 = coroutineScope;
                int i3 = i2;
                ButtonKt.Button(new Function0<Unit>() { // from class: com.example.flashcardapp.ui.EnglishStartupScreenKt$EnglishStartupScreen$1$1$1
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
                        EnglishStartupScreenKt.EnglishStartupScreen$lambda$17(mutableState6, true);
                        mutableState.setValue(Integer.valueOf(intValue));
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, Dispatchers.getIO(), null, new AnonymousClass1(engine, intValue, mutableState2, mutableState6, null), 2, null);
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: EnglishStartupScreen.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(c = "com.example.flashcardapp.ui.EnglishStartupScreenKt$EnglishStartupScreen$1$1$1$1", f = "EnglishStartupScreen.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: com.example.flashcardapp.ui.EnglishStartupScreenKt$EnglishStartupScreen$1$1$1$1, reason: invalid class name */
                    /* loaded from: classes2.dex */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ EnglishEngine $engine;
                        final /* synthetic */ MutableState<Boolean> $isLoading$delegate;
                        final /* synthetic */ int $limit;
                        final /* synthetic */ MutableState<List<Mcq>> $mcqs$delegate;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(EnglishEngine englishEngine, int i, MutableState<List<Mcq>> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$engine = englishEngine;
                            this.$limit = i;
                            this.$mcqs$delegate = mutableState;
                            this.$isLoading$delegate = mutableState2;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$engine, this.$limit, this.$mcqs$delegate, this.$isLoading$delegate, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                List<Mcq> generateQuiz = this.$engine.generateQuiz(this.$limit);
                                this.label = 1;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new C00721(generateQuiz, this.$mcqs$delegate, this.$isLoading$delegate, null), this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: EnglishStartupScreen.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        @DebugMetadata(c = "com.example.flashcardapp.ui.EnglishStartupScreenKt$EnglishStartupScreen$1$1$1$1$1", f = "EnglishStartupScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: com.example.flashcardapp.ui.EnglishStartupScreenKt$EnglishStartupScreen$1$1$1$1$1, reason: invalid class name and collision with other inner class name */
                        /* loaded from: classes2.dex */
                        public static final class C00721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ MutableState<Boolean> $isLoading$delegate;
                            final /* synthetic */ MutableState<List<Mcq>> $mcqs$delegate;
                            final /* synthetic */ List<Mcq> $quiz;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C00721(List<Mcq> list, MutableState<List<Mcq>> mutableState, MutableState<Boolean> mutableState2, Continuation<? super C00721> continuation) {
                                super(2, continuation);
                                this.$quiz = list;
                                this.$mcqs$delegate = mutableState;
                                this.$isLoading$delegate = mutableState2;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new C00721(this.$quiz, this.$mcqs$delegate, this.$isLoading$delegate, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((C00721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                if (this.label == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.$mcqs$delegate.setValue(this.$quiz);
                                    EnglishStartupScreenKt.EnglishStartupScreen$lambda$17(this.$isLoading$delegate, false);
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }
                }, PaddingKt.m571paddingVpY3zN4$default(SizeKt.m604height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(56)), 0.0f, Dp.m5738constructorimpl(i3), 1, null), false, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -894559021, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.EnglishStartupScreenKt$EnglishStartupScreen$1$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                        invoke(rowScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope Button, Composer composer3, int i4) {
                        Intrinsics.checkNotNullParameter(Button, "$this$Button");
                        if ((i4 & 81) == 16 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-894559021, i4, -1, "com.example.flashcardapp.ui.EnglishStartupScreen.<anonymous>.<anonymous>.<anonymous> (EnglishStartupScreen.kt:54)");
                        }
                        TextKt.m2133Text4IGK_g(intValue + " Questions", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131070);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), startRestartGroup, 805306416, 508);
                it = it;
                i2 = i3;
                coroutineScope = coroutineScope3;
            }
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            function0 = onQuizCompleted;
        } else if (EnglishStartupScreen$lambda$16(mutableState6) || EnglishStartupScreen$lambda$4(mutableState2) == null) {
            composer2 = startRestartGroup;
            function0 = onQuizCompleted;
            composer2.startReplaceableGroup(-1804939510);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment center2 = Alignment.INSTANCE.getCenter();
            composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center2, false, composer2, 6);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
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
            ProgressIndicatorKt.m1752CircularProgressIndicatorLxG7B9w(null, 0L, 0.0f, 0L, 0, composer2, 0, 31);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(-1804939361);
            final List<Mcq> EnglishStartupScreen$lambda$4 = EnglishStartupScreen$lambda$4(mutableState2);
            Intrinsics.checkNotNull(EnglishStartupScreen$lambda$4);
            if (EnglishStartupScreen$lambda$7(mutableState3) >= EnglishStartupScreen$lambda$4.size()) {
                startRestartGroup.startReplaceableGroup(-1804939286);
                Modifier m569padding3ABfNKs2 = PaddingKt.m569padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(32));
                Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
                Arrangement.HorizontalOrVertical center3 = Arrangement.INSTANCE.getCenter();
                startRestartGroup.startReplaceableGroup(-483455358);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(center3, centerHorizontally2, startRestartGroup, 54);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs2);
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
                Updater.m2954setimpl(m2947constructorimpl3, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                TextKt.m2133Text4IGK_g("Checkpoint Completed!", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getHeadlineMedium(), startRestartGroup, 6, 0, 65534);
                SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(16)), startRestartGroup, 6);
                ButtonKt.Button(onQuizCompleted, SizeKt.m604height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(56)), false, null, null, null, null, null, null, ComposableSingletons$EnglishStartupScreenKt.INSTANCE.m6144getLambda1$app_release(), startRestartGroup, ((i >> 3) & 14) | 805306416, 508);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                composer2 = startRestartGroup;
                function0 = onQuizCompleted;
            } else {
                startRestartGroup.startReplaceableGroup(-1804938653);
                Mcq mcq = EnglishStartupScreen$lambda$4.get(EnglishStartupScreen$lambda$7(mutableState3));
                float f2 = 16;
                Modifier m569padding3ABfNKs3 = PaddingKt.m569padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(f2));
                Alignment.Horizontal centerHorizontally3 = Alignment.INSTANCE.getCenterHorizontally();
                startRestartGroup.startReplaceableGroup(-483455358);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally3, startRestartGroup, 48);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs3);
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
                Updater.m2954setimpl(m2947constructorimpl4, columnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                function0 = onQuizCompleted;
                ProgressIndicatorKt.m1758LinearProgressIndicator_5eSRE(new Function0<Float>() { // from class: com.example.flashcardapp.ui.EnglishStartupScreenKt$EnglishStartupScreen$4$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        int EnglishStartupScreen$lambda$7;
                        EnglishStartupScreen$lambda$7 = EnglishStartupScreenKt.EnglishStartupScreen$lambda$7(mutableState3);
                        return Float.valueOf(EnglishStartupScreen$lambda$7 / EnglishStartupScreen$lambda$4.size());
                    }
                }, PaddingKt.m571paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m5738constructorimpl(f2), 1, null), 0L, 0L, 0, startRestartGroup, 48, 28);
                composer2 = startRestartGroup;
                TextKt.m2133Text4IGK_g("Question " + (EnglishStartupScreen$lambda$7(mutableState3) + 1) + " of " + EnglishStartupScreen$lambda$4.size(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getTitleMedium(), startRestartGroup, 0, 0, 65534);
                float f3 = 24;
                SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f3)), composer2, 6);
                TextKt.m2133Text4IGK_g(mcq.getQuestion(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getHeadlineSmall(), composer2, 0, 0, 65534);
                SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(32)), composer2, 6);
                composer2.startReplaceableGroup(-1507851715);
                Iterator it2 = mcq.getOptions().iterator();
                int i4 = 0;
                while (it2.hasNext()) {
                    Object next = it2.next();
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    final String str = (String) next;
                    if (EnglishStartupScreen$lambda$10(mutableState4)) {
                        composer2.startReplaceableGroup(1440368060);
                        if (i4 == mcq.getCorrectIndex()) {
                            composer2.startReplaceableGroup(1440368148);
                            surfaceVariant = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary();
                            composer2.endReplaceableGroup();
                        } else {
                            Integer EnglishStartupScreen$lambda$132 = EnglishStartupScreen$lambda$13(mutableState5);
                            if (EnglishStartupScreen$lambda$132 != null && i4 == EnglishStartupScreen$lambda$132.intValue()) {
                                composer2.startReplaceableGroup(1440368243);
                                surfaceVariant = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getError();
                                composer2.endReplaceableGroup();
                            } else {
                                composer2.startReplaceableGroup(1440368304);
                                surfaceVariant = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getSurfaceVariant();
                                composer2.endReplaceableGroup();
                            }
                        }
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(1440368346);
                        surfaceVariant = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getSurfaceVariant();
                        composer2.endReplaceableGroup();
                    }
                    long j = surfaceVariant;
                    if (EnglishStartupScreen$lambda$10(mutableState4) && (i4 == mcq.getCorrectIndex() || ((EnglishStartupScreen$lambda$13 = EnglishStartupScreen$lambda$13(mutableState5)) != null && i4 == EnglishStartupScreen$lambda$13.intValue()))) {
                        composer2.startReplaceableGroup(1440368562);
                        onSurfaceVariant = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnPrimary();
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(1440368651);
                        onSurfaceVariant = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant();
                        composer2.endReplaceableGroup();
                    }
                    Iterator it3 = it2;
                    final int i6 = i4;
                    ButtonColors m1274buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1274buttonColorsro_MJ88(j, onSurfaceVariant, 0L, 0L, composer2, ButtonDefaults.$stable << 12, 12);
                    Modifier m571paddingVpY3zN4$default = PaddingKt.m571paddingVpY3zN4$default(SizeKt.m604height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(56)), 0.0f, Dp.m5738constructorimpl(4), 1, null);
                    composer2.startReplaceableGroup(1440368825);
                    boolean changed = composer2.changed(i6);
                    Object rememberedValue8 = composer2.rememberedValue();
                    if (changed || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue8 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.EnglishStartupScreenKt$EnglishStartupScreen$4$2$1$1
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
                                boolean EnglishStartupScreen$lambda$10;
                                EnglishStartupScreen$lambda$10 = EnglishStartupScreenKt.EnglishStartupScreen$lambda$10(mutableState4);
                                if (EnglishStartupScreen$lambda$10) {
                                    return;
                                }
                                mutableState5.setValue(Integer.valueOf(i6));
                                EnglishStartupScreenKt.EnglishStartupScreen$lambda$11(mutableState4, true);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue8);
                    }
                    composer2.endReplaceableGroup();
                    ButtonKt.Button((Function0) rememberedValue8, m571paddingVpY3zN4$default, false, null, m1274buttonColorsro_MJ88, null, null, null, null, ComposableLambdaKt.composableLambda(composer2, 1476889080, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.EnglishStartupScreenKt$EnglishStartupScreen$4$2$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                            invoke(rowScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope Button, Composer composer3, int i7) {
                            Intrinsics.checkNotNullParameter(Button, "$this$Button");
                            if ((i7 & 81) == 16 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1476889080, i7, -1, "com.example.flashcardapp.ui.EnglishStartupScreen.<anonymous>.<anonymous>.<anonymous> (EnglishStartupScreen.kt:122)");
                            }
                            TextKt.m2133Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131070);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 805306416, 492);
                    it2 = it3;
                    i4 = i5;
                }
                composer2.endReplaceableGroup();
                composer2.startReplaceableGroup(-1804936323);
                if (EnglishStartupScreen$lambda$10(mutableState4)) {
                    SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f3)), composer2, 6);
                    TextKt.m2133Text4IGK_g("Explanation", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getTitleMedium(), composer2, 6, 0, 65534);
                    SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(8)), composer2, 6);
                    TextKt.m2133Text4IGK_g(mcq.getExplanation(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 0, 0, 65534);
                    SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), composer2, 0);
                    composer2.startReplaceableGroup(-1507849763);
                    Object rememberedValue9 = composer2.rememberedValue();
                    if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue9 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.EnglishStartupScreenKt$EnglishStartupScreen$4$3$1
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
                                int EnglishStartupScreen$lambda$7;
                                EnglishStartupScreen$lambda$7 = EnglishStartupScreenKt.EnglishStartupScreen$lambda$7(mutableState3);
                                EnglishStartupScreenKt.EnglishStartupScreen$lambda$8(mutableState3, EnglishStartupScreen$lambda$7 + 1);
                                EnglishStartupScreenKt.EnglishStartupScreen$lambda$11(mutableState4, false);
                                mutableState5.setValue(null);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue9);
                    }
                    composer2.endReplaceableGroup();
                    ButtonKt.Button((Function0) rememberedValue9, SizeKt.m604height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(56)), false, null, null, null, null, null, null, ComposableSingletons$EnglishStartupScreenKt.INSTANCE.m6145getLambda2$app_release(), composer2, 805306422, 508);
                }
                composer2.endReplaceableGroup();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
            }
            composer2.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.EnglishStartupScreenKt$EnglishStartupScreen$5
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

                public final void invoke(Composer composer3, int i7) {
                    EnglishStartupScreenKt.EnglishStartupScreen(EnglishEngine.this, function0, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final Integer EnglishStartupScreen$lambda$1(MutableState<Integer> mutableState) {
        return mutableState.getValue();
    }

    private static final List<Mcq> EnglishStartupScreen$lambda$4(MutableState<List<Mcq>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int EnglishStartupScreen$lambda$7(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EnglishStartupScreen$lambda$8(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean EnglishStartupScreen$lambda$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EnglishStartupScreen$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Integer EnglishStartupScreen$lambda$13(MutableState<Integer> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean EnglishStartupScreen$lambda$16(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EnglishStartupScreen$lambda$17(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }
}

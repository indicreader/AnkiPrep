package com.example.flashcardapp.ui;

import android.content.Context;
import android.widget.Toast;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CheckCircleKt;
import androidx.compose.material.icons.outlined.CloseKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
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
import androidx.exifinterface.media.ExifInterface;
import androidx.profileinstaller.ProfileVerifier;
import com.example.flashcardapp.data.AnkiDataRepository;
import com.example.flashcardapp.data.entities.CardEntity;
import com.example.flashcardapp.data.entities.CardOverrideEntity;
import com.example.flashcardapp.session.AnswerRecord;
import com.example.flashcardapp.ui.theme.ThemeKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
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
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ReviewMistakesScreen.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\u001a9\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010\n\u001a1\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a%\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0017\u001a*\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f²\u0006\f\u0010 \u001a\u0004\u0018\u00010\u0005X\u008a\u008e\u0002²\u0006\n\u0010!\u001a\u00020\rX\u008a\u008e\u0002²\u0006\f\u0010\"\u001a\u0004\u0018\u00010\rX\u008a\u008e\u0002²\u0006\f\u0010#\u001a\u0004\u0018\u00010\rX\u008a\u008e\u0002²\u0006\f\u0010$\u001a\u0004\u0018\u00010\rX\u008a\u008e\u0002²\u0006\f\u0010%\u001a\u0004\u0018\u00010\rX\u008a\u008e\u0002²\u0006\n\u0010&\u001a\u00020\u0007X\u008a\u008e\u0002"}, d2 = {"AnswerReviewCard", "", "questionNumber", "", "record", "Lcom/example/flashcardapp/session/AnswerRecord;", "isWrong", "", "onEditCard", "Lkotlin/Function1;", "(ILcom/example/flashcardapp/session/AnswerRecord;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ReviewMistakesScreen", "deckName", "", "answeredQuestions", "", "onBack", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ReviewSummaryHeader", "total", "wrong", "correct", "(IIILandroidx/compose/runtime/Composer;I)V", "SummaryPill", "label", AppMeasurementSdk.ConditionalUserProperty.VALUE, "color", "Landroidx/compose/ui/graphics/Color;", "SummaryPill-XO-JAsU", "(Ljava/lang/String;Ljava/lang/String;JLandroidx/compose/runtime/Composer;I)V", "app_release", "editingRecord", "initialTags", "initialFrontImage", "initialBackImage", "initialExplanationImage", "initialOptionImagesJson", "expanded"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ReviewMistakesScreenKt {
    public static final void ReviewMistakesScreen(final String deckName, final List<AnswerRecord> answeredQuestions, final Function0<Unit> onBack, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(deckName, "deckName");
        Intrinsics.checkNotNullParameter(answeredQuestions, "answeredQuestions");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Composer startRestartGroup = composer.startRestartGroup(1426587251);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1426587251, i, -1, "com.example.flashcardapp.ui.ReviewMistakesScreen (ReviewMistakesScreen.kt:43)");
        }
        List<AnswerRecord> list = answeredQuestions;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!((AnswerRecord) obj).isCorrect()) {
                arrayList.add(obj);
            }
        }
        final ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            if (((AnswerRecord) obj2).isCorrect()) {
                arrayList3.add(obj2);
            }
        }
        final ArrayList arrayList4 = arrayList3;
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final Context context = (Context) consume;
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
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(580119230);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = AnkiDataRepository.INSTANCE.getInstance(context);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        final AnkiDataRepository ankiDataRepository = (AnkiDataRepository) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(580119308);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        final MutableState mutableState = (MutableState) rememberedValue3;
        startRestartGroup.endReplaceableGroup();
        ScaffoldKt.m1788ScaffoldTvnljyQ(null, ComposableLambdaKt.composableLambda(startRestartGroup, -49088209, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$ReviewMistakesScreen$1
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

            public final void invoke(Composer composer2, int i2) {
                if ((i2 & 11) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-49088209, i2, -1, "com.example.flashcardapp.ui.ReviewMistakesScreen.<anonymous> (ReviewMistakesScreen.kt:54)");
                    }
                    final String str = deckName;
                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, 345025523, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$ReviewMistakesScreen$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i3) {
                            if ((i3 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(345025523, i3, -1, "com.example.flashcardapp.ui.ReviewMistakesScreen.<anonymous>.<anonymous> (ReviewMistakesScreen.kt:56)");
                                }
                                String str2 = str;
                                composer3.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                Modifier.Companion companion = Modifier.INSTANCE;
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                                TextKt.m2133Text4IGK_g("Review Mistakes", (Modifier) null, ThemeKt.getTextPrimaryDeep(), TextUnitKt.getSp(18), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199686, 0, 131026);
                                TextKt.m2133Text4IGK_g(str2, (Modifier) null, ThemeKt.getTextSecondaryGray(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3072, 0, 131058);
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
                    });
                    final Function0<Unit> function0 = onBack;
                    AppBarKt.TopAppBar(composableLambda, null, ComposableLambdaKt.composableLambda(composer2, 993618293, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$ReviewMistakesScreen$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i3) {
                            if ((i3 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(993618293, i3, -1, "com.example.flashcardapp.ui.ReviewMistakesScreen.<anonymous>.<anonymous> (ReviewMistakesScreen.kt:71)");
                                }
                                IconButtonKt.IconButton(function0, null, false, null, null, ComposableSingletons$ReviewMistakesScreenKt.INSTANCE.m6244getLambda1$app_release(), composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), null, null, TopAppBarDefaults.INSTANCE.m2292topAppBarColorszjMxDiM(ThemeKt.getBackgroundLavender(), 0L, 0L, 0L, 0L, composer2, TopAppBarDefaults.$stable << 15, 30), null, composer2, 390, 90);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), null, null, null, 0, ThemeKt.getBackgroundLavender(), 0L, null, ComposableLambdaKt.composableLambda(startRestartGroup, 816832260, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$ReviewMistakesScreen$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer2, Integer num) {
                invoke(paddingValues, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PaddingValues paddingValues, Composer composer2, int i2) {
                int i3;
                final AnswerRecord ReviewMistakesScreen$lambda$4;
                Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                if ((i2 & 14) == 0) {
                    i3 = i2 | (composer2.changed(paddingValues) ? 4 : 2);
                } else {
                    i3 = i2;
                }
                if ((i3 & 91) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(816832260, i3, -1, "com.example.flashcardapp.ui.ReviewMistakesScreen.<anonymous> (ReviewMistakesScreen.kt:85)");
                    }
                    composer2.startReplaceableGroup(678014053);
                    if (answeredQuestions.isEmpty()) {
                        Modifier padding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
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
                        TextKt.m2133Text4IGK_g("No answers to review.", (Modifier) null, ThemeKt.getTextSecondaryGray(), TextUnitKt.getSp(16), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 3078, 0, 131058);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2.endReplaceableGroup();
                        return;
                    }
                    composer2.endReplaceableGroup();
                    float f = 16;
                    Modifier m571paddingVpY3zN4$default = PaddingKt.m571paddingVpY3zN4$default(PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues), Dp.m5738constructorimpl(f), 0.0f, 2, null);
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(14));
                    final List<AnswerRecord> list2 = arrayList2;
                    final List<AnswerRecord> list3 = arrayList4;
                    final List<AnswerRecord> list4 = answeredQuestions;
                    final MutableState<AnswerRecord> mutableState2 = mutableState;
                    LazyDslKt.LazyColumn(m571paddingVpY3zN4$default, null, PaddingKt.m564PaddingValuesYgX7TsA$default(0.0f, Dp.m5738constructorimpl(f), 1, null), false, m478spacedBy0680j_4, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$ReviewMistakesScreen$2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                            invoke2(lazyListScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LazyListScope LazyColumn) {
                            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                            final List<AnswerRecord> list5 = list4;
                            final List<AnswerRecord> list6 = list2;
                            final List<AnswerRecord> list7 = list3;
                            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1017525400, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt.ReviewMistakesScreen.2.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer3, Integer num) {
                                    invoke(lazyItemScope, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer composer3, int i4) {
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    if ((i4 & 81) != 16 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1017525400, i4, -1, "com.example.flashcardapp.ui.ReviewMistakesScreen.<anonymous>.<anonymous>.<anonymous> (ReviewMistakesScreen.kt:111)");
                                        }
                                        ReviewMistakesScreenKt.ReviewSummaryHeader(list5.size(), list6.size(), list7.size(), composer3, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), 3, null);
                            if (!list2.isEmpty()) {
                                final List<AnswerRecord> list8 = list2;
                                LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-57418957, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt.ReviewMistakesScreen.2.2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer3, Integer num) {
                                        invoke(lazyItemScope, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer composer3, int i4) {
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        if ((i4 & 81) != 16 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-57418957, i4, -1, "com.example.flashcardapp.ui.ReviewMistakesScreen.<anonymous>.<anonymous>.<anonymous> (ReviewMistakesScreen.kt:121)");
                                            }
                                            TextKt.m2133Text4IGK_g("❌  Incorrect Answers  (" + list8.size() + ")", PaddingKt.m573paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m5738constructorimpl(8), 0.0f, 0.0f, 13, null), ThemeKt.getIncorrectColor(), TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 200112, 0, 131024);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), 3, null);
                                final List<AnswerRecord> list9 = list2;
                                final MutableState<AnswerRecord> mutableState3 = mutableState2;
                                LazyColumn.items(list9.size(), null, new Function1<Integer, Object>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$ReviewMistakesScreen$2$2$invoke$$inlined$itemsIndexed$default$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                        return invoke(num.intValue());
                                    }

                                    public final Object invoke(int i4) {
                                        list9.get(i4);
                                        return null;
                                    }
                                }, ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$ReviewMistakesScreen$2$2$invoke$$inlined$itemsIndexed$default$3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer3, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer3, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope lazyItemScope, int i4, Composer composer3, int i5) {
                                        int i6;
                                        ComposerKt.sourceInformation(composer3, "C183@8439L26:LazyDsl.kt#428nma");
                                        if ((i5 & 14) == 0) {
                                            i6 = (composer3.changed(lazyItemScope) ? 4 : 2) | i5;
                                        } else {
                                            i6 = i5;
                                        }
                                        if ((i5 & 112) == 0) {
                                            i6 |= composer3.changed(i4) ? 32 : 16;
                                        }
                                        if ((i6 & 731) == 146 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1091073711, i6, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:183)");
                                        }
                                        AnswerRecord answerRecord = (AnswerRecord) list9.get(i4);
                                        int i7 = i4 + 1;
                                        composer3.startReplaceableGroup(28225536);
                                        Object rememberedValue4 = composer3.rememberedValue();
                                        if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                            final MutableState mutableState4 = mutableState3;
                                            rememberedValue4 = (Function1) new Function1<AnswerRecord, Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$ReviewMistakesScreen$2$2$3$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(AnswerRecord answerRecord2) {
                                                    invoke2(answerRecord2);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(AnswerRecord it) {
                                                    Intrinsics.checkNotNullParameter(it, "it");
                                                    mutableState4.setValue(it);
                                                }
                                            };
                                            composer3.updateRememberedValue(rememberedValue4);
                                        }
                                        composer3.endReplaceableGroup();
                                        ReviewMistakesScreenKt.AnswerReviewCard(i7, answerRecord, true, (Function1) rememberedValue4, composer3, 3520);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }));
                            }
                            if (!list3.isEmpty()) {
                                final List<AnswerRecord> list10 = list3;
                                LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1315306006, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt.ReviewMistakesScreen.2.2.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer3, Integer num) {
                                        invoke(lazyItemScope, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer composer3, int i4) {
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        if ((i4 & 81) != 16 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1315306006, i4, -1, "com.example.flashcardapp.ui.ReviewMistakesScreen.<anonymous>.<anonymous>.<anonymous> (ReviewMistakesScreen.kt:142)");
                                            }
                                            TextKt.m2133Text4IGK_g("✅  Correct Answers  (" + list10.size() + ")", PaddingKt.m573paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m5738constructorimpl(8), 0.0f, 0.0f, 13, null), ThemeKt.getCorrectColor(), TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 200112, 0, 131024);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), 3, null);
                                final List<AnswerRecord> list11 = list3;
                                final MutableState<AnswerRecord> mutableState4 = mutableState2;
                                LazyColumn.items(list11.size(), null, new Function1<Integer, Object>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$ReviewMistakesScreen$2$2$invoke$$inlined$itemsIndexed$default$5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                        return invoke(num.intValue());
                                    }

                                    public final Object invoke(int i4) {
                                        list11.get(i4);
                                        return null;
                                    }
                                }, ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$ReviewMistakesScreen$2$2$invoke$$inlined$itemsIndexed$default$6
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer3, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer3, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope lazyItemScope, int i4, Composer composer3, int i5) {
                                        int i6;
                                        ComposerKt.sourceInformation(composer3, "C183@8439L26:LazyDsl.kt#428nma");
                                        if ((i5 & 14) == 0) {
                                            i6 = (composer3.changed(lazyItemScope) ? 4 : 2) | i5;
                                        } else {
                                            i6 = i5;
                                        }
                                        if ((i5 & 112) == 0) {
                                            i6 |= composer3.changed(i4) ? 32 : 16;
                                        }
                                        if ((i6 & 731) == 146 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1091073711, i6, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:183)");
                                        }
                                        AnswerRecord answerRecord = (AnswerRecord) list11.get(i4);
                                        int i7 = i4 + 1;
                                        composer3.startReplaceableGroup(28226343);
                                        Object rememberedValue4 = composer3.rememberedValue();
                                        if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                            final MutableState mutableState5 = mutableState4;
                                            rememberedValue4 = (Function1) new Function1<AnswerRecord, Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$ReviewMistakesScreen$2$2$5$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(AnswerRecord answerRecord2) {
                                                    invoke2(answerRecord2);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(AnswerRecord it) {
                                                    Intrinsics.checkNotNullParameter(it, "it");
                                                    mutableState5.setValue(it);
                                                }
                                            };
                                            composer3.updateRememberedValue(rememberedValue4);
                                        }
                                        composer3.endReplaceableGroup();
                                        ReviewMistakesScreenKt.AnswerReviewCard(i7, answerRecord, false, (Function1) rememberedValue4, composer3, 3520);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }));
                            }
                        }
                    }, composer2, 24960, 234);
                    ReviewMistakesScreen$lambda$4 = ReviewMistakesScreenKt.ReviewMistakesScreen$lambda$4(mutableState);
                    if (ReviewMistakesScreen$lambda$4 != null) {
                        long sourceCardId = ReviewMistakesScreen$lambda$4.getQuestion().getSourceCardId();
                        composer2.startReplaceableGroup(678016821);
                        boolean changed = composer2.changed(sourceCardId);
                        Object rememberedValue4 = composer2.rememberedValue();
                        if (changed || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                            composer2.updateRememberedValue(rememberedValue4);
                        }
                        MutableState mutableState3 = (MutableState) rememberedValue4;
                        composer2.endReplaceableGroup();
                        long sourceCardId2 = ReviewMistakesScreen$lambda$4.getQuestion().getSourceCardId();
                        composer2.startReplaceableGroup(678016928);
                        boolean changed2 = composer2.changed(sourceCardId2);
                        Object rememberedValue5 = composer2.rememberedValue();
                        if (changed2 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composer2.updateRememberedValue(rememberedValue5);
                        }
                        MutableState mutableState4 = (MutableState) rememberedValue5;
                        composer2.endReplaceableGroup();
                        long sourceCardId3 = ReviewMistakesScreen$lambda$4.getQuestion().getSourceCardId();
                        composer2.startReplaceableGroup(678017045);
                        boolean changed3 = composer2.changed(sourceCardId3);
                        Object rememberedValue6 = composer2.rememberedValue();
                        if (changed3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composer2.updateRememberedValue(rememberedValue6);
                        }
                        MutableState mutableState5 = (MutableState) rememberedValue6;
                        composer2.endReplaceableGroup();
                        long sourceCardId4 = ReviewMistakesScreen$lambda$4.getQuestion().getSourceCardId();
                        composer2.startReplaceableGroup(678017169);
                        boolean changed4 = composer2.changed(sourceCardId4);
                        Object rememberedValue7 = composer2.rememberedValue();
                        if (changed4 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composer2.updateRememberedValue(rememberedValue7);
                        }
                        MutableState mutableState6 = (MutableState) rememberedValue7;
                        composer2.endReplaceableGroup();
                        long sourceCardId5 = ReviewMistakesScreen$lambda$4.getQuestion().getSourceCardId();
                        composer2.startReplaceableGroup(678017293);
                        boolean changed5 = composer2.changed(sourceCardId5);
                        Object rememberedValue8 = composer2.rememberedValue();
                        if (changed5 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composer2.updateRememberedValue(rememberedValue8);
                        }
                        MutableState mutableState7 = (MutableState) rememberedValue8;
                        composer2.endReplaceableGroup();
                        EffectsKt.LaunchedEffect(Long.valueOf(ReviewMistakesScreen$lambda$4.getQuestion().getSourceCardId()), new AnonymousClass3(ankiDataRepository, ReviewMistakesScreen$lambda$4, mutableState3, mutableState4, mutableState5, mutableState6, mutableState7, null), composer2, 64);
                        String question = ReviewMistakesScreen$lambda$4.getQuestion().getQuestion();
                        String correctAnswer = ReviewMistakesScreen$lambda$4.getQuestion().getCorrectAnswer();
                        List<String> options = ReviewMistakesScreen$lambda$4.getQuestion().getOptions();
                        String explanation = ReviewMistakesScreen$lambda$4.getQuestion().getExplanation();
                        String invoke$lambda$2 = invoke$lambda$2(mutableState3);
                        String invoke$lambda$5 = invoke$lambda$5(mutableState4);
                        String invoke$lambda$8 = invoke$lambda$8(mutableState5);
                        String invoke$lambda$11 = invoke$lambda$11(mutableState6);
                        String invoke$lambda$14 = invoke$lambda$14(mutableState7);
                        composer2.startReplaceableGroup(678018583);
                        final MutableState<AnswerRecord> mutableState8 = mutableState;
                        Object rememberedValue9 = composer2.rememberedValue();
                        if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue9 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$ReviewMistakesScreen$2$4$1
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
                                    mutableState8.setValue(null);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue9);
                        }
                        composer2.endReplaceableGroup();
                        final CoroutineScope coroutineScope2 = coroutineScope;
                        final AnkiDataRepository ankiDataRepository2 = ankiDataRepository;
                        final Context context2 = context;
                        McqEditorDialogKt.McqEditorDialog(question, correctAnswer, options, explanation, invoke$lambda$2, invoke$lambda$5, invoke$lambda$8, invoke$lambda$11, invoke$lambda$14, "Edit Card", (Function0) rememberedValue9, new Function7<String, String, String, String, String, String, String, Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$ReviewMistakesScreen$2.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(7);
                            }

                            @Override // kotlin.jvm.functions.Function7
                            public /* bridge */ /* synthetic */ Unit invoke(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
                                invoke2(str, str2, str3, str4, str5, str6, str7);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* compiled from: ReviewMistakesScreen.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                            @DebugMetadata(c = "com.example.flashcardapp.ui.ReviewMistakesScreenKt$ReviewMistakesScreen$2$5$1", f = "ReviewMistakesScreen.kt", i = {}, l = {195}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: com.example.flashcardapp.ui.ReviewMistakesScreenKt$ReviewMistakesScreen$2$5$1, reason: invalid class name */
                            /* loaded from: classes2.dex */
                            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ String $backImg;
                                final /* synthetic */ Context $context;
                                final /* synthetic */ String $explImg;
                                final /* synthetic */ String $frontImg;
                                final /* synthetic */ String $newBack;
                                final /* synthetic */ String $newFront;
                                final /* synthetic */ String $newTags;
                                final /* synthetic */ String $optImgs;
                                final /* synthetic */ AnkiDataRepository $repo;
                                final /* synthetic */ AnswerRecord $selectedRecord;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(AnkiDataRepository ankiDataRepository, AnswerRecord answerRecord, String str, String str2, String str3, String str4, String str5, String str6, String str7, Context context, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$repo = ankiDataRepository;
                                    this.$selectedRecord = answerRecord;
                                    this.$newFront = str;
                                    this.$newBack = str2;
                                    this.$newTags = str3;
                                    this.$frontImg = str4;
                                    this.$backImg = str5;
                                    this.$explImg = str6;
                                    this.$optImgs = str7;
                                    this.$context = context;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$repo, this.$selectedRecord, this.$newFront, this.$newBack, this.$newTags, this.$frontImg, this.$backImg, this.$explImg, this.$optImgs, this.$context, continuation);
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
                                        this.label = 1;
                                        if (this.$repo.upsertOverride(new CardOverrideEntity(this.$selectedRecord.getQuestion().getSourceCardId(), this.$newFront, this.$newBack, this.$newTags, System.currentTimeMillis(), this.$frontImg, this.$backImg, this.$explImg, this.$optImgs), this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    Toast.makeText(this.$context, "Card updated!", 0).show();
                                    return Unit.INSTANCE;
                                }
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String newFront, String newBack, String newTags, String str, String str2, String str3, String str4) {
                                Intrinsics.checkNotNullParameter(newFront, "newFront");
                                Intrinsics.checkNotNullParameter(newBack, "newBack");
                                Intrinsics.checkNotNullParameter(newTags, "newTags");
                                BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(ankiDataRepository2, ReviewMistakesScreen$lambda$4, newFront, newBack, newTags, str, str2, str3, str4, context2, null), 3, null);
                            }
                        }, null, null, false, false, composer2, 805306880, 6, 61440);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }

            private static final String invoke$lambda$2(MutableState<String> mutableState2) {
                return mutableState2.getValue();
            }

            private static final String invoke$lambda$5(MutableState<String> mutableState2) {
                return mutableState2.getValue();
            }

            private static final String invoke$lambda$8(MutableState<String> mutableState2) {
                return mutableState2.getValue();
            }

            private static final String invoke$lambda$11(MutableState<String> mutableState2) {
                return mutableState2.getValue();
            }

            private static final String invoke$lambda$14(MutableState<String> mutableState2) {
                return mutableState2.getValue();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: ReviewMistakesScreen.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "com.example.flashcardapp.ui.ReviewMistakesScreenKt$ReviewMistakesScreen$2$3", f = "ReviewMistakesScreen.kt", i = {}, l = {171}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.example.flashcardapp.ui.ReviewMistakesScreenKt$ReviewMistakesScreen$2$3, reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ MutableState<String> $initialBackImage$delegate;
                final /* synthetic */ MutableState<String> $initialExplanationImage$delegate;
                final /* synthetic */ MutableState<String> $initialFrontImage$delegate;
                final /* synthetic */ MutableState<String> $initialOptionImagesJson$delegate;
                final /* synthetic */ MutableState<String> $initialTags$delegate;
                final /* synthetic */ AnkiDataRepository $repo;
                final /* synthetic */ AnswerRecord $selectedRecord;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass3(AnkiDataRepository ankiDataRepository, AnswerRecord answerRecord, MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<String> mutableState4, MutableState<String> mutableState5, Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                    this.$repo = ankiDataRepository;
                    this.$selectedRecord = answerRecord;
                    this.$initialTags$delegate = mutableState;
                    this.$initialFrontImage$delegate = mutableState2;
                    this.$initialBackImage$delegate = mutableState3;
                    this.$initialExplanationImage$delegate = mutableState4;
                    this.$initialOptionImagesJson$delegate = mutableState5;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass3(this.$repo, this.$selectedRecord, this.$initialTags$delegate, this.$initialFrontImage$delegate, this.$initialBackImage$delegate, this.$initialExplanationImage$delegate, this.$initialOptionImagesJson$delegate, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        obj = this.$repo.getCardById(this.$selectedRecord.getQuestion().getSourceCardId(), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    CardEntity cardEntity = (CardEntity) obj;
                    if (cardEntity != null) {
                        ReviewMistakesScreenKt$ReviewMistakesScreen$2.invoke$lambda$3(this.$initialTags$delegate, CollectionsKt.joinToString$default(this.$repo.parseTags(cardEntity.getTags()), ", ", null, null, 0, null, null, 62, null));
                        ReviewMistakesScreenKt$ReviewMistakesScreen$2.invoke$lambda$6(this.$initialFrontImage$delegate, cardEntity.getFrontImage());
                        ReviewMistakesScreenKt$ReviewMistakesScreen$2.invoke$lambda$9(this.$initialBackImage$delegate, cardEntity.getBackImage());
                        ReviewMistakesScreenKt$ReviewMistakesScreen$2.invoke$lambda$12(this.$initialExplanationImage$delegate, cardEntity.getExplanationImage());
                        ReviewMistakesScreenKt$ReviewMistakesScreen$2.invoke$lambda$15(this.$initialOptionImagesJson$delegate, cardEntity.getOptionImagesJson());
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void invoke$lambda$3(MutableState<String> mutableState2, String str) {
                mutableState2.setValue(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void invoke$lambda$6(MutableState<String> mutableState2, String str) {
                mutableState2.setValue(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void invoke$lambda$9(MutableState<String> mutableState2, String str) {
                mutableState2.setValue(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void invoke$lambda$12(MutableState<String> mutableState2, String str) {
                mutableState2.setValue(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void invoke$lambda$15(MutableState<String> mutableState2, String str) {
                mutableState2.setValue(str);
            }
        }), startRestartGroup, 805306416, 445);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$ReviewMistakesScreen$3
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

                public final void invoke(Composer composer2, int i2) {
                    ReviewMistakesScreenKt.ReviewMistakesScreen(deckName, answeredQuestions, onBack, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnswerRecord ReviewMistakesScreen$lambda$4(MutableState<AnswerRecord> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ReviewSummaryHeader(final int i, final int i2, final int i3, Composer composer, final int i4) {
        int i5;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-500203319);
        if ((i4 & 14) == 0) {
            i5 = (startRestartGroup.changed(i) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 112) == 0) {
            i5 |= startRestartGroup.changed(i2) ? 32 : 16;
        }
        if ((i4 & 896) == 0) {
            i5 |= startRestartGroup.changed(i3) ? 256 : 128;
        }
        if ((i5 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-500203319, i5, -1, "com.example.flashcardapp.ui.ReviewSummaryHeader (ReviewMistakesScreen.kt:220)");
            }
            composer2 = startRestartGroup;
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(20)), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(Color.INSTANCE.m3454getWhite0d7_KjU(), 0L, 0L, 0L, startRestartGroup, (CardDefaults.$stable << 12) | 6, 14), CardDefaults.INSTANCE.m1296cardElevationaqJV_2Y(Dp.m5738constructorimpl(0), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, (CardDefaults.$stable << 18) | 6, 62), null, ComposableLambdaKt.composableLambda(composer2, 848836923, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$ReviewSummaryHeader$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope Card, Composer composer3, int i6) {
                    Intrinsics.checkNotNullParameter(Card, "$this$Card");
                    if ((i6 & 81) != 16 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(848836923, i6, -1, "com.example.flashcardapp.ui.ReviewSummaryHeader.<anonymous> (ReviewMistakesScreen.kt:227)");
                        }
                        float f = 20;
                        Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(BackgroundKt.background$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Brush.Companion.m3366horizontalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m3407boximpl(Color.m3416copywmQWz5c$default(ThemeKt.getPrimaryPurple(), 0.08f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m3407boximpl(ColorKt.Color(4293452543L))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f)), 0.0f, 4, null), Dp.m5738constructorimpl(f));
                        int i7 = i;
                        int i8 = i3;
                        int i9 = i2;
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
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
                        Updater.m2954setimpl(m2947constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2954setimpl(m2947constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2947constructorimpl.getInserting() || !Intrinsics.areEqual(m2947constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m2947constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m2947constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical spaceAround = Arrangement.INSTANCE.getSpaceAround();
                        composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceAround, Alignment.INSTANCE.getTop(), composer3, 6);
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
                        ReviewMistakesScreenKt.m6341SummaryPillXOJAsU("Total", String.valueOf(i7), ThemeKt.getPrimaryPurple(), composer3, 6);
                        ReviewMistakesScreenKt.m6341SummaryPillXOJAsU("Correct", String.valueOf(i8), ThemeKt.getCorrectColor(), composer3, 390);
                        ReviewMistakesScreenKt.m6341SummaryPillXOJAsU("Wrong", String.valueOf(i9), ThemeKt.getIncorrectColor(), composer3, 390);
                        int i10 = i7 > 0 ? (i8 * 100) / i7 : 0;
                        ReviewMistakesScreenKt.m6341SummaryPillXOJAsU("Accuracy", i10 + "%", i10 >= 75 ? ThemeKt.getCorrectColor() : ThemeKt.getIncorrectColor(), composer3, 6);
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
            }), composer2, 196614, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$ReviewSummaryHeader$2
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

                public final void invoke(Composer composer3, int i6) {
                    ReviewMistakesScreenKt.ReviewSummaryHeader(i, i2, i3, composer3, RecomposeScopeImplKt.updateChangedFlags(i4 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: SummaryPill-XO-JAsU, reason: not valid java name */
    public static final void m6341SummaryPillXOJAsU(final String str, final String str2, final long j, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-605736965);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-605736965, i2, -1, "com.example.flashcardapp.ui.SummaryPill (ReviewMistakesScreen.kt:253)");
            }
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
            TextKt.m2133Text4IGK_g(str2, (Modifier) null, j, TextUnitKt.getSp(22), (FontStyle) null, FontWeight.INSTANCE.getBlack(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, ((i2 >> 3) & 14) | 199680 | (i2 & 896), 0, 131026);
            TextKt.m2133Text4IGK_g(str, (Modifier) null, ThemeKt.getTextSecondaryGray(), TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, (i2 & 14) | 199680, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$SummaryPill$2
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
                    ReviewMistakesScreenKt.m6341SummaryPillXOJAsU(str, str2, j, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AnswerReviewCard(final int i, final AnswerRecord answerRecord, final boolean z, final Function1<? super AnswerRecord, Unit> function1, Composer composer, final int i2) {
        Composer startRestartGroup = composer.startRestartGroup(-1852587592);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1852587592, i2, -1, "com.example.flashcardapp.ui.AnswerReviewCard (ReviewMistakesScreen.kt:266)");
        }
        startRestartGroup.startReplaceableGroup(-536039954);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(16)), CardDefaults.INSTANCE.m1295cardColorsro_MJ88(ColorKt.Color(z ? 4294964725L : 4294245364L), 0L, 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 14), CardDefaults.INSTANCE.m1296cardElevationaqJV_2Y(Dp.m5738constructorimpl(0), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, (CardDefaults.$stable << 18) | 6, 62), null, ComposableLambdaKt.composableLambda(startRestartGroup, 713936170, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$AnswerReviewCard$1
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

            public final void invoke(ColumnScope Card, Composer composer2, int i3) {
                final MutableState<Boolean> mutableState2;
                boolean AnswerReviewCard$lambda$8;
                Intrinsics.checkNotNullParameter(Card, "$this$Card");
                if ((i3 & 81) != 16 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(713936170, i3, -1, "com.example.flashcardapp.ui.AnswerReviewCard.<anonymous> (ReviewMistakesScreen.kt:277)");
                    }
                    Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(16));
                    boolean z2 = z;
                    final AnswerRecord answerRecord2 = answerRecord;
                    int i4 = i;
                    final Function1<AnswerRecord, Unit> function12 = function1;
                    MutableState<Boolean> mutableState3 = mutableState;
                    composer2.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
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
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                    Alignment.Vertical top = Alignment.INSTANCE.getTop();
                    composer2.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, top, composer2, 54);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
                    Updater.m2954setimpl(m2947constructorimpl2, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl2.getInserting() || !Intrinsics.areEqual(m2947constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m2947constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m2947constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    modifierMaterializerOf2.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    float f = 8;
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f));
                    Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                    composer2.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m478spacedBy0680j_4, centerVertically, composer2, 54);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(weight$default);
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
                    ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    float f2 = 28;
                    Modifier m215backgroundbw27NRU = BackgroundKt.m215backgroundbw27NRU(SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f2)), z2 ? ThemeKt.getIncorrectColor() : ThemeKt.getCorrectColor(), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f)));
                    Alignment center = Alignment.INSTANCE.getCenter();
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(m215backgroundbw27NRU);
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
                    Updater.m2954setimpl(m2947constructorimpl4, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    TextKt.m2133Text4IGK_g(String.valueOf(i4), (Modifier) null, Color.INSTANCE.m3454getWhite0d7_KjU(), TextUnitKt.getSp(12), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 200064, 0, 131026);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    TextKt.m2133Text4IGK_g(answerRecord2.getQuestion().getQuestion(), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), ThemeKt.getTextPrimaryDeep(), TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(20), 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 199680, 6, 130000);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_42 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(4));
                    composer2.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m478spacedBy0680j_42, centerVertically2, composer2, 54);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(companion);
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
                    Updater.m2954setimpl(m2947constructorimpl5, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2954setimpl(m2947constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2947constructorimpl5.getInserting() || !Intrinsics.areEqual(m2947constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                        m2947constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                        m2947constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                    }
                    modifierMaterializerOf5.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                    IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$AnswerReviewCard$1$1$1$2$1
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
                            function12.invoke(answerRecord2);
                        }
                    }, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f2)), false, null, null, ComposableSingletons$ReviewMistakesScreenKt.INSTANCE.m6245getLambda2$app_release(), composer2, 196656, 28);
                    composer2.startReplaceableGroup(-1459281861);
                    Object rememberedValue2 = composer2.rememberedValue();
                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        mutableState2 = mutableState3;
                        rememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$AnswerReviewCard$1$1$1$2$2$1
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
                                boolean AnswerReviewCard$lambda$82;
                                MutableState<Boolean> mutableState4 = mutableState2;
                                AnswerReviewCard$lambda$82 = ReviewMistakesScreenKt.AnswerReviewCard$lambda$8(mutableState4);
                                ReviewMistakesScreenKt.AnswerReviewCard$lambda$9(mutableState4, !AnswerReviewCard$lambda$82);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue2);
                    } else {
                        mutableState2 = mutableState3;
                    }
                    composer2.endReplaceableGroup();
                    IconButtonKt.IconButton((Function0) rememberedValue2, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f2)), false, null, null, ComposableLambdaKt.composableLambda(composer2, -679987213, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$AnswerReviewCard$1$1$1$2$3
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

                        public final void invoke(Composer composer3, int i5) {
                            boolean AnswerReviewCard$lambda$82;
                            boolean AnswerReviewCard$lambda$83;
                            if ((i5 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-679987213, i5, -1, "com.example.flashcardapp.ui.AnswerReviewCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ReviewMistakesScreen.kt:337)");
                                }
                                AnswerReviewCard$lambda$82 = ReviewMistakesScreenKt.AnswerReviewCard$lambda$8(mutableState2);
                                ImageVector close = AnswerReviewCard$lambda$82 ? CloseKt.getClose(Icons.Outlined.INSTANCE) : CheckCircleKt.getCheckCircle(Icons.Outlined.INSTANCE);
                                AnswerReviewCard$lambda$83 = ReviewMistakesScreenKt.AnswerReviewCard$lambda$8(mutableState2);
                                IconKt.m1605Iconww6aTOc(close, AnswerReviewCard$lambda$83 ? "Collapse" : "Expand", SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(18)), ThemeKt.getTextSecondaryGray(), composer3, 384, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, 196662, 28);
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
                    AnswerReviewCard$lambda$8 = ReviewMistakesScreenKt.AnswerReviewCard$lambda$8(mutableState2);
                    AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, AnswerReviewCard$lambda$8, (Modifier) null, EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null)), EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)), (String) null, ComposableLambdaKt.composableLambda(composer2, 182833144, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$AnswerReviewCard$1$1$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                            invoke(animatedVisibilityScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer3, int i5) {
                            long m3452getTransparent0d7_KjU;
                            long textSecondaryGray;
                            long textSecondaryGray2;
                            Composer composer4 = composer3;
                            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(182833144, i5, -1, "com.example.flashcardapp.ui.AnswerReviewCard.<anonymous>.<anonymous>.<anonymous> (ReviewMistakesScreen.kt:352)");
                            }
                            int i6 = 12;
                            Modifier m573paddingqDBjuR0$default = PaddingKt.m573paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m5738constructorimpl(12), 0.0f, 0.0f, 13, null);
                            AnswerRecord answerRecord3 = AnswerRecord.this;
                            composer4.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            int i7 = 0;
                            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                            int i8 = -1323940314;
                            composer4.startReplaceableGroup(-1323940314);
                            String str = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh";
                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                            CompositionLocalMap currentCompositionLocalMap6 = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(m573paddingqDBjuR0$default);
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer4.createNode(constructor6);
                            } else {
                                composer3.useNode();
                            }
                            Composer m2947constructorimpl6 = Updater.m2947constructorimpl(composer3);
                            Updater.m2954setimpl(m2947constructorimpl6, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m2954setimpl(m2947constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m2947constructorimpl6.getInserting() || !Intrinsics.areEqual(m2947constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                                m2947constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                                m2947constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
                            }
                            modifierMaterializerOf6.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer4, 0);
                            int i9 = 2058660585;
                            composer4.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                            int i10 = 1;
                            float f3 = 1;
                            DividerKt.m1532HorizontalDivider9IZ8Weo(null, Dp.m5738constructorimpl(f3), ColorKt.Color(4293649402L), composer3, 432, 1);
                            float f4 = 10;
                            int i11 = 6;
                            SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f4)), composer4, 6);
                            composer4.startReplaceableGroup(-1459280830);
                            int i12 = 0;
                            for (Object obj : answerRecord3.getQuestion().getOptions()) {
                                int i13 = i12 + 1;
                                if (i12 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                String str2 = (String) obj;
                                int i14 = i12 == answerRecord3.getQuestion().getCorrectIndex() ? i10 : i7;
                                int i15 = i12 == answerRecord3.getSelectedOptionIndex() ? i10 : i7;
                                if (i14 != 0) {
                                    m3452getTransparent0d7_KjU = ThemeKt.getCorrectBg();
                                } else if (i15 != 0 && i14 == 0) {
                                    m3452getTransparent0d7_KjU = ThemeKt.getIncorrectBg();
                                } else {
                                    m3452getTransparent0d7_KjU = Color.INSTANCE.m3452getTransparent0d7_KjU();
                                }
                                AnswerRecord answerRecord4 = answerRecord3;
                                float f5 = 8;
                                Modifier m570paddingVpY3zN4 = PaddingKt.m570paddingVpY3zN4(BackgroundKt.m215backgroundbw27NRU(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, i10, null), m3452getTransparent0d7_KjU, RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f5))), Dp.m5738constructorimpl(f4), Dp.m5738constructorimpl(i11));
                                Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                Arrangement.HorizontalOrVertical m478spacedBy0680j_43 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f5));
                                composer4.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(m478spacedBy0680j_43, centerVertically3, composer4, 54);
                                composer4.startReplaceableGroup(i8);
                                ComposerKt.sourceInformation(composer4, str);
                                int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap7 = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf7 = LayoutKt.modifierMaterializerOf(m570paddingVpY3zN4);
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer4.createNode(constructor7);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m2947constructorimpl7 = Updater.m2947constructorimpl(composer3);
                                Updater.m2954setimpl(m2947constructorimpl7, rowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m2954setimpl(m2947constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m2947constructorimpl7.getInserting() || !Intrinsics.areEqual(m2947constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                                    m2947constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                                    m2947constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
                                }
                                modifierMaterializerOf7.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer3)), composer4, 0);
                                composer4.startReplaceableGroup(i9);
                                ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                                List listOf = CollectionsKt.listOf((Object[]) new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST});
                                String str3 = (String) ((i12 < 0 || i12 > CollectionsKt.getLastIndex(listOf)) ? String.valueOf(i12) : listOf.get(i12));
                                if (i14 != 0) {
                                    textSecondaryGray = ThemeKt.getCorrectColor();
                                } else if (i15 != 0) {
                                    textSecondaryGray = ThemeKt.getIncorrectColor();
                                } else {
                                    textSecondaryGray = ThemeKt.getTextSecondaryGray();
                                }
                                int i16 = i9;
                                int i17 = i8;
                                String str4 = str;
                                int i18 = i6;
                                float f6 = f4;
                                TextKt.m2133Text4IGK_g(str3, (Modifier) null, textSecondaryGray, TextUnitKt.getSp(i6), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199680, 0, 131026);
                                if (i14 != 0) {
                                    textSecondaryGray2 = ThemeKt.getCorrectColor();
                                } else if (i15 != 0) {
                                    textSecondaryGray2 = ThemeKt.getIncorrectColor();
                                } else {
                                    textSecondaryGray2 = ThemeKt.getTextSecondaryGray();
                                }
                                TextKt.m2133Text4IGK_g(str2, RowScope.weight$default(rowScopeInstance4, Modifier.INSTANCE, 1.0f, false, 2, null), textSecondaryGray2, TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3072, 0, 131056);
                                if (i14 != 0) {
                                    composer4 = composer3;
                                    composer4.startReplaceableGroup(1110435613);
                                    IconKt.m1605Iconww6aTOc(CheckCircleKt.getCheckCircle(Icons.Outlined.INSTANCE), "Correct", SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(16)), ThemeKt.getCorrectColor(), composer3, 3504, 0);
                                    composer3.endReplaceableGroup();
                                } else {
                                    composer4 = composer3;
                                    if (i15 != 0) {
                                        composer4.startReplaceableGroup(1110435997);
                                        IconKt.m1605Iconww6aTOc(CloseKt.getClose(Icons.Outlined.INSTANCE), "Wrong", SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(16)), ThemeKt.getIncorrectColor(), composer3, 3504, 0);
                                        composer3.endReplaceableGroup();
                                    } else {
                                        composer4.startReplaceableGroup(1110436351);
                                        composer3.endReplaceableGroup();
                                    }
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(4)), composer4, 6);
                                i11 = 6;
                                i12 = i13;
                                i9 = i16;
                                str = str4;
                                i8 = i17;
                                i7 = 0;
                                answerRecord3 = answerRecord4;
                                i6 = i18;
                                f4 = f6;
                                i10 = 1;
                            }
                            AnswerRecord answerRecord5 = answerRecord3;
                            int i19 = i6;
                            int i20 = i11;
                            composer3.endReplaceableGroup();
                            composer4.startReplaceableGroup(-1459277849);
                            if (!StringsKt.isBlank(answerRecord5.getQuestion().getExplanation())) {
                                float f7 = 8;
                                SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f7)), composer4, i20);
                                DividerKt.m1532HorizontalDivider9IZ8Weo(null, Dp.m5738constructorimpl(f3), ColorKt.Color(4293649402L), composer3, 432, 1);
                                SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(f7)), composer4, i20);
                                TextKt.m2133Text4IGK_g("Explanation", (Modifier) null, ThemeKt.getPrimaryPurple(), TextUnitKt.getSp(i19), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199686, 0, 131026);
                                SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(4)), composer3, 6);
                                TextKt.m2133Text4IGK_g(answerRecord5.getQuestion().getExplanation(), (Modifier) null, ThemeKt.getTextSecondaryGray(), TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(18), 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3072, 6, 130034);
                            }
                            composer3.endReplaceableGroup();
                            SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(8)), composer3, 6);
                            TextKt.m2133Text4IGK_g("Time taken: " + (answerRecord5.getTimeTakenMs() / 1000) + "s", SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Color.m3416copywmQWz5c$default(ThemeKt.getTextSecondaryGray(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m5623boximpl(TextAlign.INSTANCE.m5631getEnde0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3120, 0, 130544);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 1600518, 18);
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
        }), startRestartGroup, 196614, 16);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.ReviewMistakesScreenKt$AnswerReviewCard$2
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
                    ReviewMistakesScreenKt.AnswerReviewCard(i, answerRecord, z, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AnswerReviewCard$lambda$8(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AnswerReviewCard$lambda$9(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }
}

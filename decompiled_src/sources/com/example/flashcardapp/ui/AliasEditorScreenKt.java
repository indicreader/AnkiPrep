package com.example.flashcardapp.ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import com.example.flashcardapp.data.entities.AliasEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: AliasEditorScreen.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u001aÂ\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u000626\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00010\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u000e2K\u0010\u000f\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015²\u0006\n\u0010\u0016\u001a\u00020\u0017X\u008a\u008e\u0002²\u0006\f\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u008a\u008e\u0002²\u0006\n\u0010\u0019\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u0010\u001a\u001a\u00020\tX\u008a\u008e\u0002"}, d2 = {"AliasEditorScreen", "", "aliases", "", "Lcom/example/flashcardapp/data/entities/AliasEntity;", "onBack", "Lkotlin/Function0;", "onAddAlias", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "alias", "onDeleteAlias", "Lkotlin/Function1;", "onModifyAlias", "Lkotlin/Function3;", "oldAlias", "newName", "newAlias", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "app_release", "showAddDialog", "", "editAlias", "nameInput", "aliasInput"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class AliasEditorScreenKt {
    public static final void AliasEditorScreen(final List<AliasEntity> aliases, final Function0<Unit> onBack, final Function2<? super String, ? super String, Unit> onAddAlias, final Function1<? super AliasEntity, Unit> onDeleteAlias, final Function3<? super AliasEntity, ? super String, ? super String, Unit> onModifyAlias, Composer composer, final int i) {
        Composer composer2;
        String alias;
        String str;
        Intrinsics.checkNotNullParameter(aliases, "aliases");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Intrinsics.checkNotNullParameter(onAddAlias, "onAddAlias");
        Intrinsics.checkNotNullParameter(onDeleteAlias, "onDeleteAlias");
        Intrinsics.checkNotNullParameter(onModifyAlias, "onModifyAlias");
        Composer startRestartGroup = composer.startRestartGroup(780541244);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(780541244, i, -1, "com.example.flashcardapp.ui.AliasEditorScreen (AliasEditorScreen.kt:31)");
        }
        startRestartGroup.startReplaceableGroup(-513329207);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-513329151);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        final MutableState mutableState2 = (MutableState) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        ScaffoldKt.m1788ScaffoldTvnljyQ(null, ComposableLambdaKt.composableLambda(startRestartGroup, 766538240, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AliasEditorScreenKt$AliasEditorScreen$1
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

            public final void invoke(Composer composer3, int i2) {
                if ((i2 & 11) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(766538240, i2, -1, "com.example.flashcardapp.ui.AliasEditorScreen.<anonymous> (AliasEditorScreen.kt:37)");
                    }
                    Function2<Composer, Integer, Unit> m6123getLambda1$app_release = ComposableSingletons$AliasEditorScreenKt.INSTANCE.m6123getLambda1$app_release();
                    final Function0<Unit> function0 = onBack;
                    AppBarKt.TopAppBar(m6123getLambda1$app_release, null, ComposableLambdaKt.composableLambda(composer3, -753150342, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AliasEditorScreenKt$AliasEditorScreen$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                            invoke(composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i3) {
                            if ((i3 & 11) != 2 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-753150342, i3, -1, "com.example.flashcardapp.ui.AliasEditorScreen.<anonymous>.<anonymous> (AliasEditorScreen.kt:40)");
                                }
                                IconButtonKt.IconButton(function0, null, false, null, null, ComposableSingletons$AliasEditorScreenKt.INSTANCE.m6124getLambda2$app_release(), composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer4.skipToGroupEnd();
                        }
                    }), null, null, TopAppBarDefaults.INSTANCE.m2292topAppBarColorszjMxDiM(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), 0L, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnPrimary(), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnPrimary(), 0L, composer3, TopAppBarDefaults.$stable << 15, 18), null, composer3, 390, 90);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -682959869, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AliasEditorScreenKt$AliasEditorScreen$2
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

            public final void invoke(Composer composer3, int i2) {
                if ((i2 & 11) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-682959869, i2, -1, "com.example.flashcardapp.ui.AliasEditorScreen.<anonymous> (AliasEditorScreen.kt:52)");
                }
                composer3.startReplaceableGroup(-238627395);
                final MutableState<Boolean> mutableState3 = mutableState;
                Object rememberedValue3 = composer3.rememberedValue();
                if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.AliasEditorScreenKt$AliasEditorScreen$2$1$1
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
                            AliasEditorScreenKt.AliasEditorScreen$lambda$2(mutableState3, true);
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue3);
                }
                composer3.endReplaceableGroup();
                FloatingActionButtonKt.m1584FloatingActionButtonXz6DiA((Function0) rememberedValue3, null, null, 0L, 0L, null, null, ComposableSingletons$AliasEditorScreenKt.INSTANCE.m6125getLambda3$app_release(), composer3, 12582918, WebSocketProtocol.PAYLOAD_SHORT);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 0, 0L, 0L, null, ComposableLambdaKt.composableLambda(startRestartGroup, 842748107, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AliasEditorScreenKt$AliasEditorScreen$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer3, Integer num) {
                invoke(paddingValues, composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PaddingValues innerPadding, Composer composer3, int i2) {
                int i3;
                Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
                if ((i2 & 14) == 0) {
                    i3 = i2 | (composer3.changed(innerPadding) ? 4 : 2);
                } else {
                    i3 = i2;
                }
                if ((i3 & 91) != 18 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(842748107, i3, -1, "com.example.flashcardapp.ui.AliasEditorScreen.<anonymous> (AliasEditorScreen.kt:57)");
                    }
                    float f = 16;
                    Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), innerPadding), Dp.m5738constructorimpl(f));
                    Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f));
                    final List<AliasEntity> list = aliases;
                    final Function1<AliasEntity, Unit> function1 = onDeleteAlias;
                    final MutableState<AliasEntity> mutableState3 = mutableState2;
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer3, 6);
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
                    float f2 = 8;
                    Modifier m569padding3ABfNKs2 = PaddingKt.m569padding3ABfNKs(BackgroundKt.m215backgroundbw27NRU(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getSurfaceVariant(), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(f2))), Dp.m5738constructorimpl(12));
                    Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs2);
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
                    TextKt.m2133Text4IGK_g("Target Word", RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 196614, 0, 131036);
                    TextKt.m2133Text4IGK_g("Alias Configurations", RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.5f, false, 2, null), 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 196614, 0, 131036);
                    TextKt.m2133Text4IGK_g("Actions", SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(100)), 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 196662, 0, 131036);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    LazyDslKt.LazyColumn(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, false, Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f2)), null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.example.flashcardapp.ui.AliasEditorScreenKt$AliasEditorScreen$3$1$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
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
                            final List<AliasEntity> list2 = list;
                            final Function1<AliasEntity, Unit> function12 = function1;
                            final MutableState<AliasEntity> mutableState4 = mutableState3;
                            final AliasEditorScreenKt$AliasEditorScreen$3$1$2$invoke$$inlined$items$default$1 aliasEditorScreenKt$AliasEditorScreen$3$1$2$invoke$$inlined$items$default$1 = new Function1() { // from class: com.example.flashcardapp.ui.AliasEditorScreenKt$AliasEditorScreen$3$1$2$invoke$$inlined$items$default$1
                                @Override // kotlin.jvm.functions.Function1
                                public final Void invoke(AliasEntity aliasEntity) {
                                    return null;
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    return invoke((AliasEntity) obj);
                                }
                            };
                            LazyColumn.items(list2.size(), null, new Function1<Integer, Object>() { // from class: com.example.flashcardapp.ui.AliasEditorScreenKt$AliasEditorScreen$3$1$2$invoke$$inlined$items$default$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                    return invoke(num.intValue());
                                }

                                public final Object invoke(int i4) {
                                    return Function1.this.invoke(list2.get(i4));
                                }
                            }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AliasEditorScreenKt$AliasEditorScreen$3$1$2$invoke$$inlined$items$default$4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer4, Integer num2) {
                                    invoke(lazyItemScope, num.intValue(), composer4, num2.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope lazyItemScope, int i4, Composer composer4, int i5) {
                                    int i6;
                                    ComposerKt.sourceInformation(composer4, "C148@6730L22:LazyDsl.kt#428nma");
                                    if ((i5 & 14) == 0) {
                                        i6 = i5 | (composer4.changed(lazyItemScope) ? 4 : 2);
                                    } else {
                                        i6 = i5;
                                    }
                                    if ((i5 & 112) == 0) {
                                        i6 |= composer4.changed(i4) ? 32 : 16;
                                    }
                                    if ((i6 & 731) == 146 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-632812321, i6, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:148)");
                                    }
                                    final AliasEntity aliasEntity = (AliasEntity) list2.get(i4);
                                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    RoundedCornerShape m839RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(8));
                                    BorderStroke m244BorderStrokecXLIe8U = BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(1), MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getOutlineVariant());
                                    CardColors m1295cardColorsro_MJ88 = CardDefaults.INSTANCE.m1295cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getSurface(), 0L, 0L, 0L, composer4, CardDefaults.$stable << 12, 14);
                                    final Function1 function13 = function12;
                                    final MutableState mutableState5 = mutableState4;
                                    CardKt.Card(fillMaxWidth$default, m839RoundedCornerShape0680j_4, m1295cardColorsro_MJ88, null, m244BorderStrokecXLIe8U, ComposableLambdaKt.composableLambda(composer4, -1553294078, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AliasEditorScreenKt$AliasEditorScreen$3$1$2$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer5, Integer num) {
                                            invoke(columnScope, composer5, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(ColumnScope Card, Composer composer5, int i7) {
                                            Intrinsics.checkNotNullParameter(Card, "$this$Card");
                                            if ((i7 & 81) != 16 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1553294078, i7, -1, "com.example.flashcardapp.ui.AliasEditorScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AliasEditorScreen.kt:102)");
                                                }
                                                Modifier m569padding3ABfNKs3 = PaddingKt.m569padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5738constructorimpl(12));
                                                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                                final AliasEntity aliasEntity2 = AliasEntity.this;
                                                final Function1<AliasEntity, Unit> function14 = function13;
                                                final MutableState<AliasEntity> mutableState6 = mutableState5;
                                                composer5.startReplaceableGroup(693286680);
                                                ComposerKt.sourceInformation(composer5, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer5, 48);
                                                composer5.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                CompositionLocalMap currentCompositionLocalMap3 = composer5.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs3);
                                                if (!(composer5.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer5.startReusableNode();
                                                if (composer5.getInserting()) {
                                                    composer5.createNode(constructor3);
                                                } else {
                                                    composer5.useNode();
                                                }
                                                Composer m2947constructorimpl3 = Updater.m2947constructorimpl(composer5);
                                                Updater.m2954setimpl(m2947constructorimpl3, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m2954setimpl(m2947constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m2947constructorimpl3.getInserting() || !Intrinsics.areEqual(m2947constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                    m2947constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                    m2947constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                                }
                                                modifierMaterializerOf3.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer5)), composer5, 0);
                                                composer5.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer5, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                                TextKt.m2133Text4IGK_g(aliasEntity2.getName(), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer5, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 131036);
                                                TextKt.m2133Text4IGK_g(aliasEntity2.getAlias(), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.5f, false, 2, null), MaterialTheme.INSTANCE.getColorScheme(composer5, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer5, 0, 0, 131064);
                                                Modifier m623width3ABfNKs = SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(100));
                                                Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                                composer5.startReplaceableGroup(693286680);
                                                ComposerKt.sourceInformation(composer5, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(end, Alignment.INSTANCE.getTop(), composer5, 6);
                                                composer5.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                CompositionLocalMap currentCompositionLocalMap4 = composer5.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(m623width3ABfNKs);
                                                if (!(composer5.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer5.startReusableNode();
                                                if (composer5.getInserting()) {
                                                    composer5.createNode(constructor4);
                                                } else {
                                                    composer5.useNode();
                                                }
                                                Composer m2947constructorimpl4 = Updater.m2947constructorimpl(composer5);
                                                Updater.m2954setimpl(m2947constructorimpl4, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m2954setimpl(m2947constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m2947constructorimpl4.getInserting() || !Intrinsics.areEqual(m2947constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                                    m2947constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                                    m2947constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                                }
                                                modifierMaterializerOf4.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer5)), composer5, 0);
                                                composer5.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer5, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                                                composer5.startReplaceableGroup(1786059185);
                                                boolean changed = composer5.changed(aliasEntity2);
                                                Object rememberedValue3 = composer5.rememberedValue();
                                                if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.AliasEditorScreenKt$AliasEditorScreen$3$1$2$1$1$1$1$1$1
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
                                                            mutableState6.setValue(AliasEntity.this);
                                                        }
                                                    };
                                                    composer5.updateRememberedValue(rememberedValue3);
                                                }
                                                composer5.endReplaceableGroup();
                                                IconButtonKt.IconButton((Function0) rememberedValue3, null, false, null, null, ComposableSingletons$AliasEditorScreenKt.INSTANCE.m6126getLambda4$app_release(), composer5, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                                                composer5.startReplaceableGroup(1786059415);
                                                boolean changedInstance = composer5.changedInstance(function14) | composer5.changed(aliasEntity2);
                                                Object rememberedValue4 = composer5.rememberedValue();
                                                if (changedInstance || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue4 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.AliasEditorScreenKt$AliasEditorScreen$3$1$2$1$1$1$1$2$1
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
                                                            function14.invoke(aliasEntity2);
                                                        }
                                                    };
                                                    composer5.updateRememberedValue(rememberedValue4);
                                                }
                                                composer5.endReplaceableGroup();
                                                IconButtonKt.IconButton((Function0) rememberedValue4, null, false, null, null, ComposableSingletons$AliasEditorScreenKt.INSTANCE.m6127getLambda5$app_release(), composer5, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                composer5.endReplaceableGroup();
                                                composer5.endNode();
                                                composer5.endReplaceableGroup();
                                                composer5.endReplaceableGroup();
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                composer5.endReplaceableGroup();
                                                composer5.endNode();
                                                composer5.endReplaceableGroup();
                                                composer5.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer5.skipToGroupEnd();
                                        }
                                    }), composer4, 196614, 8);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }));
                        }
                    }, composer3, 24582, 238);
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
        }), startRestartGroup, 805330992, 493);
        if (AliasEditorScreen$lambda$1(mutableState) || AliasEditorScreen$lambda$4(mutableState2) != null) {
            boolean z = AliasEditorScreen$lambda$4(mutableState2) != null;
            startRestartGroup.startReplaceableGroup(-513324717);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            String str2 = "";
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                AliasEntity AliasEditorScreen$lambda$4 = AliasEditorScreen$lambda$4(mutableState2);
                if (AliasEditorScreen$lambda$4 == null || (str = AliasEditorScreen$lambda$4.getName()) == null) {
                    str = "";
                }
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-513324640);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                AliasEntity AliasEditorScreen$lambda$42 = AliasEditorScreen$lambda$4(mutableState2);
                if (AliasEditorScreen$lambda$42 != null && (alias = AliasEditorScreen$lambda$42.getAlias()) != null) {
                    str2 = alias;
                }
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str2, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue4;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-513324535);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.AliasEditorScreenKt$AliasEditorScreen$4$1
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
                        AliasEditorScreenKt.AliasEditorScreen$lambda$2(mutableState, false);
                        mutableState2.setValue(null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceableGroup();
            final boolean z2 = z;
            composer2 = startRestartGroup;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, 1048339407, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AliasEditorScreenKt$AliasEditorScreen$5
                /* JADX INFO: Access modifiers changed from: package-private */
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

                public final void invoke(Composer composer3, int i2) {
                    if ((i2 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1048339407, i2, -1, "com.example.flashcardapp.ui.AliasEditorScreen.<anonymous> (AliasEditorScreen.kt:164)");
                        }
                        composer3.startReplaceableGroup(-238622622);
                        boolean changed = composer3.changed(z2) | composer3.changedInstance(onModifyAlias) | composer3.changedInstance(onAddAlias);
                        final boolean z3 = z2;
                        final Function3<AliasEntity, String, String, Unit> function3 = onModifyAlias;
                        final Function2<String, String, Unit> function2 = onAddAlias;
                        final MutableState<String> mutableState5 = mutableState3;
                        final MutableState<String> mutableState6 = mutableState4;
                        final MutableState<AliasEntity> mutableState7 = mutableState2;
                        final MutableState<Boolean> mutableState8 = mutableState;
                        Object rememberedValue6 = composer3.rememberedValue();
                        if (changed || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue6 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.AliasEditorScreenKt$AliasEditorScreen$5$1$1
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
                                    String AliasEditorScreen$lambda$7;
                                    String AliasEditorScreen$lambda$10;
                                    String AliasEditorScreen$lambda$72;
                                    String AliasEditorScreen$lambda$102;
                                    AliasEntity AliasEditorScreen$lambda$43;
                                    String AliasEditorScreen$lambda$73;
                                    String AliasEditorScreen$lambda$103;
                                    AliasEditorScreen$lambda$7 = AliasEditorScreenKt.AliasEditorScreen$lambda$7(mutableState5);
                                    if (!StringsKt.isBlank(AliasEditorScreen$lambda$7)) {
                                        AliasEditorScreen$lambda$10 = AliasEditorScreenKt.AliasEditorScreen$lambda$10(mutableState6);
                                        if (!StringsKt.isBlank(AliasEditorScreen$lambda$10)) {
                                            if (z3) {
                                                Function3<AliasEntity, String, String, Unit> function32 = function3;
                                                AliasEditorScreen$lambda$43 = AliasEditorScreenKt.AliasEditorScreen$lambda$4(mutableState7);
                                                Intrinsics.checkNotNull(AliasEditorScreen$lambda$43);
                                                AliasEditorScreen$lambda$73 = AliasEditorScreenKt.AliasEditorScreen$lambda$7(mutableState5);
                                                AliasEditorScreen$lambda$103 = AliasEditorScreenKt.AliasEditorScreen$lambda$10(mutableState6);
                                                function32.invoke(AliasEditorScreen$lambda$43, AliasEditorScreen$lambda$73, AliasEditorScreen$lambda$103);
                                            } else {
                                                Function2<String, String, Unit> function22 = function2;
                                                AliasEditorScreen$lambda$72 = AliasEditorScreenKt.AliasEditorScreen$lambda$7(mutableState5);
                                                AliasEditorScreen$lambda$102 = AliasEditorScreenKt.AliasEditorScreen$lambda$10(mutableState6);
                                                function22.invoke(AliasEditorScreen$lambda$72, AliasEditorScreen$lambda$102);
                                            }
                                            AliasEditorScreenKt.AliasEditorScreen$lambda$2(mutableState8, false);
                                            mutableState7.setValue(null);
                                        }
                                    }
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue6);
                        }
                        composer3.endReplaceableGroup();
                        ButtonKt.Button((Function0) rememberedValue6, null, false, null, null, null, null, null, null, ComposableSingletons$AliasEditorScreenKt.INSTANCE.m6128getLambda6$app_release(), composer3, 805306368, 510);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            });
            final boolean z3 = z;
            AndroidAlertDialog_androidKt.m1232AlertDialogOix01E0((Function0) rememberedValue5, composableLambda, null, ComposableLambdaKt.composableLambda(composer2, -1146889459, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AliasEditorScreenKt$AliasEditorScreen$6
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

                public final void invoke(Composer composer3, int i2) {
                    if ((i2 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1146889459, i2, -1, "com.example.flashcardapp.ui.AliasEditorScreen.<anonymous> (AliasEditorScreen.kt:181)");
                        }
                        composer3.startReplaceableGroup(-238621965);
                        final MutableState<Boolean> mutableState5 = mutableState;
                        final MutableState<AliasEntity> mutableState6 = mutableState2;
                        Object rememberedValue6 = composer3.rememberedValue();
                        if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue6 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.AliasEditorScreenKt$AliasEditorScreen$6$1$1
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
                                    AliasEditorScreenKt.AliasEditorScreen$lambda$2(mutableState5, false);
                                    mutableState6.setValue(null);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue6);
                        }
                        composer3.endReplaceableGroup();
                        ButtonKt.TextButton((Function0) rememberedValue6, null, false, null, null, null, null, null, null, ComposableSingletons$AliasEditorScreenKt.INSTANCE.m6129getLambda7$app_release(), composer3, 805306374, 510);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), null, ComposableLambdaKt.composableLambda(composer2, 952848971, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AliasEditorScreenKt$AliasEditorScreen$7
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

                public final void invoke(Composer composer3, int i2) {
                    if ((i2 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(952848971, i2, -1, "com.example.flashcardapp.ui.AliasEditorScreen.<anonymous> (AliasEditorScreen.kt:146)");
                    }
                    TextKt.m2133Text4IGK_g(z3 ? "Modify Alias" : "Add New Alias", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), ComposableLambdaKt.composableLambda(composer2, 2002718186, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AliasEditorScreenKt$AliasEditorScreen$8
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

                public final void invoke(Composer composer3, int i2) {
                    String AliasEditorScreen$lambda$7;
                    String AliasEditorScreen$lambda$10;
                    if ((i2 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2002718186, i2, -1, "com.example.flashcardapp.ui.AliasEditorScreen.<anonymous> (AliasEditorScreen.kt:148)");
                        }
                        Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(8));
                        final MutableState<String> mutableState5 = mutableState3;
                        final MutableState<String> mutableState6 = mutableState4;
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer3, 6);
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
                        AliasEditorScreen$lambda$7 = AliasEditorScreenKt.AliasEditorScreen$lambda$7(mutableState5);
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        composer3.startReplaceableGroup(1039570765);
                        Object rememberedValue6 = composer3.rememberedValue();
                        if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue6 = (Function1) new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.AliasEditorScreenKt$AliasEditorScreen$8$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                                    invoke2(str3);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(String it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    mutableState5.setValue(it);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue6);
                        }
                        composer3.endReplaceableGroup();
                        OutlinedTextFieldKt.OutlinedTextField(AliasEditorScreen$lambda$7, (Function1<? super String, Unit>) rememberedValue6, fillMaxWidth$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AliasEditorScreenKt.INSTANCE.m6130getLambda8$app_release(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer3, 1573296, 0, 0, 8388536);
                        AliasEditorScreen$lambda$10 = AliasEditorScreenKt.AliasEditorScreen$lambda$10(mutableState6);
                        Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        composer3.startReplaceableGroup(1039571046);
                        Object rememberedValue7 = composer3.rememberedValue();
                        if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue7 = (Function1) new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.AliasEditorScreenKt$AliasEditorScreen$8$1$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                                    invoke2(str3);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(String it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    mutableState6.setValue(it);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue7);
                        }
                        composer3.endReplaceableGroup();
                        OutlinedTextFieldKt.OutlinedTextField(AliasEditorScreen$lambda$10, (Function1<? super String, Unit>) rememberedValue7, fillMaxWidth$default2, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AliasEditorScreenKt.INSTANCE.m6131getLambda9$app_release(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer3, 1573296, 0, 0, 8388536);
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
            }), null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, 1772598, 0, 16276);
        } else {
            composer2 = startRestartGroup;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.AliasEditorScreenKt$AliasEditorScreen$9
                /* JADX INFO: Access modifiers changed from: package-private */
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

                public final void invoke(Composer composer3, int i2) {
                    AliasEditorScreenKt.AliasEditorScreen(aliases, onBack, onAddAlias, onDeleteAlias, onModifyAlias, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final boolean AliasEditorScreen$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AliasEditorScreen$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AliasEntity AliasEditorScreen$lambda$4(MutableState<AliasEntity> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AliasEditorScreen$lambda$7(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AliasEditorScreen$lambda$10(MutableState<String> mutableState) {
        return mutableState.getValue();
    }
}

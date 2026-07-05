package com.example.flashcardapp.ui;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.ExposedDropdownMenuBoxScope;
import androidx.compose.material3.ExposedDropdownMenuDefaults;
import androidx.compose.material3.ExposedDropdownMenu_androidKt;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.AppLanguage;
import com.example.flashcardapp.data.TranslationManager;
import com.example.flashcardapp.ui.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: SettingsScreen.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/ColumnScope;", "invoke", "(Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
final class SettingsScreenKt$SettingsScreen$3$1$5 extends Lambda implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ AppLanguage $currentLanguage;
    final /* synthetic */ Function1<AppLanguage, Unit> $onLanguageChange;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SettingsScreenKt$SettingsScreen$3$1$5(AppLanguage appLanguage, Function1<? super AppLanguage, Unit> function1) {
        super(3);
        this.$currentLanguage = appLanguage;
        this.$onLanguageChange = function1;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope Card, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        if ((i & 81) != 16 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1604746677, i, -1, "com.example.flashcardapp.ui.SettingsScreen.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:605)");
            }
            Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(Modifier.INSTANCE, Dp.m5738constructorimpl(20));
            float f = 8;
            Arrangement.HorizontalOrVertical m478spacedBy0680j_4 = Arrangement.INSTANCE.m478spacedBy0680j_4(Dp.m5738constructorimpl(f));
            final AppLanguage appLanguage = this.$currentLanguage;
            final Function1<AppLanguage, Unit> function1 = this.$onLanguageChange;
            composer.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composer, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m478spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer, 6);
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m2947constructorimpl = Updater.m2947constructorimpl(composer);
            Updater.m2954setimpl(m2947constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2954setimpl(m2947constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m2947constructorimpl.getInserting() || !Intrinsics.areEqual(m2947constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m2947constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m2947constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m2938boximpl(SkippableUpdater.m2939constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composer, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            TextKt.m2133Text4IGK_g(TranslationManager.INSTANCE.getString("select_language"), (Modifier) null, ThemeKt.getTextPrimaryDeep(), TextUnitKt.getSp(15), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 199680, 0, 131026);
            TextKt.m2133Text4IGK_g(TranslationManager.INSTANCE.getString("select_language_desc"), PaddingKt.m573paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m5738constructorimpl(f), 7, null), ThemeKt.getTextSecondaryGray(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 3120, 0, 131056);
            composer.startReplaceableGroup(89096132);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composer.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            composer.endReplaceableGroup();
            boolean invoke$lambda$4$lambda$1 = invoke$lambda$4$lambda$1(mutableState);
            composer.startReplaceableGroup(89096300);
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = (Function1) new Function1<Boolean, Unit>() { // from class: com.example.flashcardapp.ui.SettingsScreenKt$SettingsScreen$3$1$5$1$1$1
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

                    public final void invoke(boolean z) {
                        boolean invoke$lambda$4$lambda$12;
                        MutableState<Boolean> mutableState2 = mutableState;
                        invoke$lambda$4$lambda$12 = SettingsScreenKt$SettingsScreen$3$1$5.invoke$lambda$4$lambda$1(mutableState2);
                        SettingsScreenKt$SettingsScreen$3$1$5.invoke$lambda$4$lambda$2(mutableState2, !invoke$lambda$4$lambda$12);
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceableGroup();
            ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(invoke$lambda$4$lambda$1, (Function1) rememberedValue2, null, ComposableLambdaKt.composableLambda(composer, 1941592895, true, new Function3<ExposedDropdownMenuBoxScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsScreenKt$SettingsScreen$3$1$5$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Composer composer2, Integer num) {
                    invoke(exposedDropdownMenuBoxScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ExposedDropdownMenuBoxScope ExposedDropdownMenuBox, Composer composer2, int i2) {
                    int i3;
                    boolean invoke$lambda$4$lambda$12;
                    Intrinsics.checkNotNullParameter(ExposedDropdownMenuBox, "$this$ExposedDropdownMenuBox");
                    if ((i2 & 14) == 0) {
                        i3 = i2 | (composer2.changed(ExposedDropdownMenuBox) ? 4 : 2);
                    } else {
                        i3 = i2;
                    }
                    if ((i3 & 91) == 18 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1941592895, i3, -1, "com.example.flashcardapp.ui.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:627)");
                    }
                    String displayName = AppLanguage.this.getDisplayName();
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(ExposedDropdownMenuBox.menuAnchor(Modifier.INSTANCE), 0.0f, 1, null);
                    int i4 = i3;
                    TextFieldColors m1549outlinedTextFieldColorsFD9MK7s = ExposedDropdownMenuDefaults.INSTANCE.m1549outlinedTextFieldColorsFD9MK7s(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, ThemeKt.getPrimaryPurple(), 0L, null, ThemeKt.getPrimaryPurple(), ColorKt.Color(4293452524L), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, ThemeKt.getPrimaryPurple(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, 384, 0, ExposedDropdownMenuDefaults.$stable << 27, 2139088639, 255);
                    AnonymousClass1 anonymousClass1 = new Function1<String, Unit>() { // from class: com.example.flashcardapp.ui.SettingsScreenKt$SettingsScreen$3$1$5$1$2.1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str) {
                            invoke2(str);
                            return Unit.INSTANCE;
                        }
                    };
                    final MutableState<Boolean> mutableState2 = mutableState;
                    OutlinedTextFieldKt.OutlinedTextField(displayName, (Function1<? super String, Unit>) anonymousClass1, fillMaxWidth$default, false, true, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, 1113669864, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsScreenKt$SettingsScreen$3$1$5$1$2.2
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
                            boolean invoke$lambda$4$lambda$13;
                            if ((i5 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1113669864, i5, -1, "com.example.flashcardapp.ui.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:631)");
                            }
                            ExposedDropdownMenuDefaults exposedDropdownMenuDefaults = ExposedDropdownMenuDefaults.INSTANCE;
                            invoke$lambda$4$lambda$13 = SettingsScreenKt$SettingsScreen$3$1$5.invoke$lambda$4$lambda$1(mutableState2);
                            exposedDropdownMenuDefaults.TrailingIcon(invoke$lambda$4$lambda$13, composer3, ExposedDropdownMenuDefaults.$stable << 3);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, m1549outlinedTextFieldColorsFD9MK7s, composer2, 805330992, 0, 0, 4193768);
                    invoke$lambda$4$lambda$12 = SettingsScreenKt$SettingsScreen$3$1$5.invoke$lambda$4$lambda$1(mutableState);
                    composer2.startReplaceableGroup(-1175909327);
                    final MutableState<Boolean> mutableState3 = mutableState;
                    Object rememberedValue3 = composer2.rememberedValue();
                    if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsScreenKt$SettingsScreen$3$1$5$1$2$3$1
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
                                SettingsScreenKt$SettingsScreen$3$1$5.invoke$lambda$4$lambda$2(mutableState3, false);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue3);
                    }
                    composer2.endReplaceableGroup();
                    final Function1<AppLanguage, Unit> function12 = function1;
                    final MutableState<Boolean> mutableState4 = mutableState;
                    ExposedDropdownMenuBox.ExposedDropdownMenu(invoke$lambda$4$lambda$12, (Function0) rememberedValue3, null, null, ComposableLambdaKt.composableLambda(composer2, -2046030002, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsScreenKt$SettingsScreen$3$1$5$1$2.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                            invoke(columnScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ColumnScope ExposedDropdownMenu, Composer composer3, int i5) {
                            Intrinsics.checkNotNullParameter(ExposedDropdownMenu, "$this$ExposedDropdownMenu");
                            if ((i5 & 81) != 16 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2046030002, i5, -1, "com.example.flashcardapp.ui.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:647)");
                                }
                                AppLanguage[] values = AppLanguage.values();
                                final Function1<AppLanguage, Unit> function13 = function12;
                                final MutableState<Boolean> mutableState5 = mutableState4;
                                int i6 = 0;
                                for (int length = values.length; i6 < length; length = length) {
                                    final AppLanguage appLanguage2 = values[i6];
                                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 1390234976, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ui.SettingsScreenKt$SettingsScreen$3$1$5$1$2$4$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i7) {
                                            if ((i7 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1390234976, i7, -1, "com.example.flashcardapp.ui.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:649)");
                                            }
                                            TextKt.m2133Text4IGK_g(AppLanguage.this.getDisplayName(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 0, 0, 131070);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                    composer3.startReplaceableGroup(-1100210147);
                                    boolean changedInstance = composer3.changedInstance(function13) | composer3.changed(appLanguage2);
                                    Object rememberedValue4 = composer3.rememberedValue();
                                    if (changedInstance || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue4 = (Function0) new Function0<Unit>() { // from class: com.example.flashcardapp.ui.SettingsScreenKt$SettingsScreen$3$1$5$1$2$4$1$2$1
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
                                                function13.invoke(appLanguage2);
                                                SettingsScreenKt$SettingsScreen$3$1$5.invoke$lambda$4$lambda$2(mutableState5, false);
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue4);
                                    }
                                    composer3.endReplaceableGroup();
                                    AndroidMenu_androidKt.DropdownMenuItem(composableLambda, (Function0) rememberedValue4, null, null, null, false, null, ExposedDropdownMenuDefaults.INSTANCE.getItemContentPadding(), null, composer3, 6, 380);
                                    i6++;
                                    mutableState5 = mutableState5;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, (458752 & (i4 << 15)) | (ExposedDropdownMenuBoxScope.$stable << 15) | 24624, 12);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer, 3120, 4);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$4$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$4$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }
}

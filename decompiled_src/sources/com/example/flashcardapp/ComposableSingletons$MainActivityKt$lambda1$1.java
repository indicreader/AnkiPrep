package com.example.flashcardapp;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.SettingsRepository;
import com.example.flashcardapp.data.TranslationManager;
import com.example.flashcardapp.ui.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: com.example.flashcardapp.ComposableSingletons$MainActivityKt$lambda-1$1, reason: invalid class name */
/* loaded from: classes2.dex */
public final class ComposableSingletons$MainActivityKt$lambda1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$MainActivityKt$lambda1$1 INSTANCE = new ComposableSingletons$MainActivityKt$lambda1$1();

    ComposableSingletons$MainActivityKt$lambda1$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(47317424, i, -1, "com.example.flashcardapp.ComposableSingletons$MainActivityKt.lambda-1.<anonymous> (MainActivity.kt:178)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Context context = (Context) consume;
            composer.startReplaceableGroup(267874201);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SettingsRepository.INSTANCE.getInstance(context);
                composer.updateRememberedValue(rememberedValue);
            }
            final SettingsRepository settingsRepository = (SettingsRepository) rememberedValue;
            composer.endReplaceableGroup();
            composer.startReplaceableGroup(267874298);
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(settingsRepository.getThemePreset(), null, 2, null);
                composer.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState = (MutableState) rememberedValue2;
            composer.endReplaceableGroup();
            composer.startReplaceableGroup(267874391);
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(settingsRepository.getUseDynamicWallpaperTheme()), null, 2, null);
                composer.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue3;
            composer.endReplaceableGroup();
            composer.startReplaceableGroup(267874488);
            Object rememberedValue4 = composer.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(settingsRepository.isDarkMode()), null, 2, null);
                composer.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue4;
            composer.endReplaceableGroup();
            composer.startReplaceableGroup(267874575);
            Object rememberedValue5 = composer.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(settingsRepository.getFontFamilyType(), null, 2, null);
                composer.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue5;
            composer.endReplaceableGroup();
            String appLanguage = settingsRepository.getAppLanguage();
            composer.startReplaceableGroup(267874703);
            boolean changed = composer.changed(appLanguage);
            Object rememberedValue6 = composer.rememberedValue();
            if (changed || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                TranslationManager.INSTANCE.setLanguageByCode(settingsRepository.getAppLanguage());
                composer.updateRememberedValue(Unit.INSTANCE);
            }
            composer.endReplaceableGroup();
            composer.startMovableGroup(267874846, TranslationManager.INSTANCE.getCurrentLanguageState());
            ThemeKt.AnkiQuizTheme(invoke$lambda$2(mutableState), invoke$lambda$8(mutableState3), invoke$lambda$5(mutableState2), invoke$lambda$11(mutableState4), ComposableLambdaKt.composableLambda(composer, 1143595881, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.flashcardapp.ComposableSingletons$MainActivityKt$lambda-1$1.2
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
                    if ((i2 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1143595881, i2, -1, "com.example.flashcardapp.ComposableSingletons$MainActivityKt.lambda-1.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:198)");
                    }
                    String invoke$lambda$2 = ComposableSingletons$MainActivityKt$lambda1$1.invoke$lambda$2(mutableState);
                    final SettingsRepository settingsRepository2 = settingsRepository;
                    final MutableState<String> mutableState5 = mutableState;
                    Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.example.flashcardapp.ComposableSingletons.MainActivityKt.lambda-1.1.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str) {
                            invoke2(str);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            ComposableSingletons$MainActivityKt$lambda1$1.invoke$lambda$3(mutableState5, it);
                            SettingsRepository.this.setThemePreset(it);
                        }
                    };
                    boolean invoke$lambda$8 = ComposableSingletons$MainActivityKt$lambda1$1.invoke$lambda$8(mutableState3);
                    final SettingsRepository settingsRepository3 = settingsRepository;
                    final MutableState<Boolean> mutableState6 = mutableState3;
                    Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.example.flashcardapp.ComposableSingletons.MainActivityKt.lambda-1.1.2.2
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
                            ComposableSingletons$MainActivityKt$lambda1$1.invoke$lambda$9(mutableState6, z);
                            SettingsRepository.this.setDarkMode(z);
                        }
                    };
                    boolean invoke$lambda$5 = ComposableSingletons$MainActivityKt$lambda1$1.invoke$lambda$5(mutableState2);
                    final SettingsRepository settingsRepository4 = settingsRepository;
                    final MutableState<Boolean> mutableState7 = mutableState2;
                    Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.example.flashcardapp.ComposableSingletons.MainActivityKt.lambda-1.1.2.3
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
                            ComposableSingletons$MainActivityKt$lambda1$1.invoke$lambda$6(mutableState7, z);
                            SettingsRepository.this.setUseDynamicWallpaperTheme(z);
                        }
                    };
                    String invoke$lambda$11 = ComposableSingletons$MainActivityKt$lambda1$1.invoke$lambda$11(mutableState4);
                    final SettingsRepository settingsRepository5 = settingsRepository;
                    final MutableState<String> mutableState8 = mutableState4;
                    MainActivityKt.MainLayout(invoke$lambda$2, function1, invoke$lambda$8, function12, invoke$lambda$5, function13, invoke$lambda$11, new Function1<String, Unit>() { // from class: com.example.flashcardapp.ComposableSingletons.MainActivityKt.lambda-1.1.2.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str) {
                            invoke2(str);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            ComposableSingletons$MainActivityKt$lambda1$1.invoke$lambda$12(mutableState8, it);
                            SettingsRepository.this.setFontFamilyType(it);
                        }
                    }, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer, 24576, 0);
            composer.endMovableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invoke$lambda$2(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$8(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$9(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invoke$lambda$11(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$3(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$12(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }
}

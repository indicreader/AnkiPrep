package com.example.flashcardapp;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.SettingsRepository;
import com.example.flashcardapp.session.McqSessionMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.MainActivityKt$MainLayout$2", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class MainActivityKt$MainLayout$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<McqSessionMode> $currentMode$delegate;
    final /* synthetic */ MutableState<Screen> $currentScreen$delegate;
    final /* synthetic */ MutableState<Integer> $numberOfOptions$delegate;
    final /* synthetic */ MutableState<Integer> $questionLimit$delegate;
    final /* synthetic */ SettingsRepository $settingsRepo;
    final /* synthetic */ MutableState<Boolean> $showExplanations$delegate;
    final /* synthetic */ MutableState<Boolean> $showTags$delegate;
    final /* synthetic */ MutableState<Boolean> $shuffleQuestions$delegate;
    final /* synthetic */ MutableState<Integer> $timeLimitSeconds$delegate;
    final /* synthetic */ MutableState<Boolean> $vibrationEnabled$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivityKt$MainLayout$2(SettingsRepository settingsRepository, MutableState<Screen> mutableState, MutableState<McqSessionMode> mutableState2, MutableState<Boolean> mutableState3, MutableState<Integer> mutableState4, MutableState<Integer> mutableState5, MutableState<Boolean> mutableState6, MutableState<Boolean> mutableState7, MutableState<Boolean> mutableState8, MutableState<Integer> mutableState9, Continuation<? super MainActivityKt$MainLayout$2> continuation) {
        super(2, continuation);
        this.$settingsRepo = settingsRepository;
        this.$currentScreen$delegate = mutableState;
        this.$currentMode$delegate = mutableState2;
        this.$vibrationEnabled$delegate = mutableState3;
        this.$numberOfOptions$delegate = mutableState4;
        this.$questionLimit$delegate = mutableState5;
        this.$shuffleQuestions$delegate = mutableState6;
        this.$showExplanations$delegate = mutableState7;
        this.$showTags$delegate = mutableState8;
        this.$timeLimitSeconds$delegate = mutableState9;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivityKt$MainLayout$2(this.$settingsRepo, this.$currentScreen$delegate, this.$currentMode$delegate, this.$vibrationEnabled$delegate, this.$numberOfOptions$delegate, this.$questionLimit$delegate, this.$shuffleQuestions$delegate, this.$showExplanations$delegate, this.$showTags$delegate, this.$timeLimitSeconds$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivityKt$MainLayout$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001c, code lost:
    
        if ((r2 instanceof com.example.flashcardapp.Screen.Settings) != false) goto L8;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r2) {
        /*
            r1 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r1.label
            if (r0 != 0) goto L79
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.runtime.MutableState<com.example.flashcardapp.Screen> r2 = r1.$currentScreen$delegate
            com.example.flashcardapp.Screen r2 = com.example.flashcardapp.MainActivityKt.access$MainLayout$lambda$13(r2)
            boolean r2 = r2 instanceof com.example.flashcardapp.Screen.Quiz
            if (r2 != 0) goto L1e
            androidx.compose.runtime.MutableState<com.example.flashcardapp.Screen> r2 = r1.$currentScreen$delegate
            com.example.flashcardapp.Screen r2 = com.example.flashcardapp.MainActivityKt.access$MainLayout$lambda$13(r2)
            boolean r2 = r2 instanceof com.example.flashcardapp.Screen.Settings
            if (r2 == 0) goto L76
        L1e:
            androidx.compose.runtime.MutableState<com.example.flashcardapp.session.McqSessionMode> r2 = r1.$currentMode$delegate
            com.example.flashcardapp.data.SettingsRepository r0 = r1.$settingsRepo
            com.example.flashcardapp.session.McqSessionMode r0 = r0.getStudyMode()
            com.example.flashcardapp.MainActivityKt.access$MainLayout$lambda$33(r2, r0)
            androidx.compose.runtime.MutableState<java.lang.Boolean> r2 = r1.$vibrationEnabled$delegate
            com.example.flashcardapp.data.SettingsRepository r0 = r1.$settingsRepo
            boolean r0 = r0.getVibrationEnabled()
            com.example.flashcardapp.MainActivityKt.access$MainLayout$lambda$36(r2, r0)
            androidx.compose.runtime.MutableState<java.lang.Integer> r2 = r1.$numberOfOptions$delegate
            com.example.flashcardapp.data.SettingsRepository r0 = r1.$settingsRepo
            int r0 = r0.getNumberOfOptions()
            com.example.flashcardapp.MainActivityKt.access$MainLayout$lambda$39(r2, r0)
            androidx.compose.runtime.MutableState<java.lang.Integer> r2 = r1.$questionLimit$delegate
            com.example.flashcardapp.data.SettingsRepository r0 = r1.$settingsRepo
            int r0 = r0.getQuestionLimit()
            com.example.flashcardapp.MainActivityKt.access$MainLayout$lambda$42(r2, r0)
            androidx.compose.runtime.MutableState<java.lang.Boolean> r2 = r1.$shuffleQuestions$delegate
            com.example.flashcardapp.data.SettingsRepository r0 = r1.$settingsRepo
            boolean r0 = r0.getShuffleQuestions()
            com.example.flashcardapp.MainActivityKt.access$MainLayout$lambda$45(r2, r0)
            androidx.compose.runtime.MutableState<java.lang.Boolean> r2 = r1.$showExplanations$delegate
            com.example.flashcardapp.data.SettingsRepository r0 = r1.$settingsRepo
            boolean r0 = r0.getShowExplanations()
            com.example.flashcardapp.MainActivityKt.access$MainLayout$lambda$48(r2, r0)
            androidx.compose.runtime.MutableState<java.lang.Boolean> r2 = r1.$showTags$delegate
            com.example.flashcardapp.data.SettingsRepository r0 = r1.$settingsRepo
            boolean r0 = r0.getShowTags()
            com.example.flashcardapp.MainActivityKt.access$MainLayout$lambda$51(r2, r0)
            androidx.compose.runtime.MutableState<java.lang.Integer> r2 = r1.$timeLimitSeconds$delegate
            com.example.flashcardapp.data.SettingsRepository r0 = r1.$settingsRepo
            int r0 = r0.getTimeLimitSeconds()
            com.example.flashcardapp.MainActivityKt.access$MainLayout$lambda$54(r2, r0)
        L76:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            return r2
        L79:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.MainActivityKt$MainLayout$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

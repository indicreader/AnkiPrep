package com.example.flashcardapp.ui;

import androidx.compose.material3.ColorScheme;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.session.AnswerRecord;
import com.example.flashcardapp.session.McqSessionMode;
import com.example.flashcardapp.session.McqSessionState;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QuizScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$17", f = "QuizScreen.kt", i = {}, l = {329}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class QuizScreenKt$QuizScreen$17 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ColorScheme $colorScheme;
    final /* synthetic */ MutableState<Color> $flashColor$delegate;
    final /* synthetic */ HapticFeedback $hapticFeedback;
    final /* synthetic */ MutableState<McqSessionState> $sessionState$delegate;
    final /* synthetic */ boolean $vibrationEnabled;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuizScreenKt$QuizScreen$17(ColorScheme colorScheme, boolean z, HapticFeedback hapticFeedback, MutableState<McqSessionState> mutableState, MutableState<Color> mutableState2, Continuation<? super QuizScreenKt$QuizScreen$17> continuation) {
        super(2, continuation);
        this.$colorScheme = colorScheme;
        this.$vibrationEnabled = z;
        this.$hapticFeedback = hapticFeedback;
        this.$sessionState$delegate = mutableState;
        this.$flashColor$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QuizScreenKt$QuizScreen$17(this.$colorScheme, this.$vibrationEnabled, this.$hapticFeedback, this.$sessionState$delegate, this.$flashColor$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QuizScreenKt$QuizScreen$17) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        McqSessionState QuizScreen$lambda$49;
        McqSessionState QuizScreen$lambda$492;
        McqSessionState QuizScreen$lambda$493;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            QuizScreen$lambda$49 = QuizScreenKt.QuizScreen$lambda$49(this.$sessionState$delegate);
            if (!QuizScreen$lambda$49.getAnsweredQuestions().isEmpty()) {
                QuizScreen$lambda$492 = QuizScreenKt.QuizScreen$lambda$49(this.$sessionState$delegate);
                AnswerRecord answerRecord = (AnswerRecord) CollectionsKt.lastOrNull((List) QuizScreen$lambda$492.getAnsweredQuestions());
                if (answerRecord != null && !answerRecord.isCorrect()) {
                    QuizScreen$lambda$493 = QuizScreenKt.QuizScreen$lambda$49(this.$sessionState$delegate);
                    if (QuizScreen$lambda$493.getMode() != McqSessionMode.TEST) {
                        QuizScreenKt.QuizScreen$lambda$71(this.$flashColor$delegate, Color.m3416copywmQWz5c$default(this.$colorScheme.getErrorContainer(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null));
                        if (this.$vibrationEnabled) {
                            try {
                                this.$hapticFeedback.mo4088performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4096getLongPress5zf0vsI());
                            } catch (Exception unused) {
                            }
                        }
                        this.label = 1;
                        if (DelayKt.delay(200L, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        QuizScreenKt.QuizScreen$lambda$71(this.$flashColor$delegate, Color.INSTANCE.m3452getTransparent0d7_KjU());
        return Unit.INSTANCE;
    }
}

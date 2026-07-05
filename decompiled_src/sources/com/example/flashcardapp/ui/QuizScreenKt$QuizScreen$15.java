package com.example.flashcardapp.ui;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.session.McqSessionManager;
import com.example.flashcardapp.session.McqSessionState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QuizScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$15", f = "QuizScreen.kt", i = {}, l = {291}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class QuizScreenKt$QuizScreen$15 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isQuestionAnswered;
    final /* synthetic */ MutableState<Long> $questionTimeMs$delegate;
    final /* synthetic */ McqSessionManager $sessionManager;
    final /* synthetic */ MutableState<McqSessionState> $sessionState$delegate;
    final /* synthetic */ int $timeLimitSeconds;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuizScreenKt$QuizScreen$15(boolean z, int i, McqSessionManager mcqSessionManager, MutableState<McqSessionState> mutableState, MutableState<Long> mutableState2, Continuation<? super QuizScreenKt$QuizScreen$15> continuation) {
        super(2, continuation);
        this.$isQuestionAnswered = z;
        this.$timeLimitSeconds = i;
        this.$sessionManager = mcqSessionManager;
        this.$sessionState$delegate = mutableState;
        this.$questionTimeMs$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QuizScreenKt$QuizScreen$15(this.$isQuestionAnswered, this.$timeLimitSeconds, this.$sessionManager, this.$sessionState$delegate, this.$questionTimeMs$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QuizScreenKt$QuizScreen$15) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0040 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x003e -> B:5:0x0041). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 1
            if (r1 == 0) goto L18
            if (r1 != r2) goto L10
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            goto L41
        L10:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L18:
            kotlin.ResultKt.throwOnFailure(r10)
            androidx.compose.runtime.MutableState<com.example.flashcardapp.session.McqSessionState> r10 = r9.$sessionState$delegate
            com.example.flashcardapp.session.McqSessionState r10 = com.example.flashcardapp.ui.QuizScreenKt.access$QuizScreen$lambda$49(r10)
            boolean r10 = r10.isFinished()
            if (r10 != 0) goto La2
            boolean r10 = r9.$isQuestionAnswered
            if (r10 != 0) goto La2
            androidx.compose.runtime.MutableState<java.lang.Long> r10 = r9.$questionTimeMs$delegate
            r3 = 0
            com.example.flashcardapp.ui.QuizScreenKt.access$QuizScreen$lambda$68(r10, r3)
            r10 = r9
        L33:
            r1 = r10
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r10.label = r2
            r3 = 100
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r3, r1)
            if (r1 != r0) goto L41
            return r0
        L41:
            androidx.compose.runtime.MutableState<java.lang.Long> r1 = r10.$questionTimeMs$delegate
            long r3 = com.example.flashcardapp.ui.QuizScreenKt.access$QuizScreen$lambda$67(r1)
            r5 = 100
            long r5 = (long) r5
            long r3 = r3 + r5
            com.example.flashcardapp.ui.QuizScreenKt.access$QuizScreen$lambda$68(r1, r3)
            int r1 = r10.$timeLimitSeconds
            if (r1 <= 0) goto L33
            androidx.compose.runtime.MutableState<java.lang.Long> r1 = r10.$questionTimeMs$delegate
            long r3 = com.example.flashcardapp.ui.QuizScreenKt.access$QuizScreen$lambda$67(r1)
            int r1 = r10.$timeLimitSeconds
            long r5 = (long) r1
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 * r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L33
            com.example.flashcardapp.session.McqSessionManager r0 = r10.$sessionManager
            androidx.compose.runtime.MutableState<java.lang.Long> r1 = r10.$questionTimeMs$delegate
            long r3 = com.example.flashcardapp.ui.QuizScreenKt.access$QuizScreen$lambda$67(r1)
            r1 = -1
            r0.selectOption(r1, r3)
            androidx.compose.runtime.MutableState<com.example.flashcardapp.session.McqSessionState> r0 = r10.$sessionState$delegate
            com.example.flashcardapp.session.McqSessionState r0 = com.example.flashcardapp.ui.QuizScreenKt.access$QuizScreen$lambda$49(r0)
            com.example.flashcardapp.session.McqSessionMode r0 = r0.getMode()
            com.example.flashcardapp.session.McqSessionMode r1 = com.example.flashcardapp.session.McqSessionMode.TEST
            if (r0 != r1) goto La2
            androidx.compose.runtime.MutableState<com.example.flashcardapp.session.McqSessionState> r0 = r10.$sessionState$delegate
            com.example.flashcardapp.session.McqSessionState r0 = com.example.flashcardapp.ui.QuizScreenKt.access$QuizScreen$lambda$49(r0)
            int r0 = r0.getCurrentQuestionIndex()
            androidx.compose.runtime.MutableState<com.example.flashcardapp.session.McqSessionState> r1 = r10.$sessionState$delegate
            com.example.flashcardapp.session.McqSessionState r1 = com.example.flashcardapp.ui.QuizScreenKt.access$QuizScreen$lambda$49(r1)
            java.util.List r1 = r1.getQuestions()
            int r1 = r1.size()
            int r1 = r1 - r2
            if (r0 < r1) goto L9d
            com.example.flashcardapp.session.McqSessionManager r10 = r10.$sessionManager
            r10.finishSession()
            goto La2
        L9d:
            com.example.flashcardapp.session.McqSessionManager r10 = r10.$sessionManager
            r10.nextQuestion()
        La2:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$15.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

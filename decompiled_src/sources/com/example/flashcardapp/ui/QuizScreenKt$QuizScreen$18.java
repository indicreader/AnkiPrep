package com.example.flashcardapp.ui;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.PersistentProgressManager;
import com.example.flashcardapp.mcq.Mcq;
import com.example.flashcardapp.session.McqSessionState;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QuizScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$18", f = "QuizScreen.kt", i = {}, l = {343}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class QuizScreenKt$QuizScreen$18 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ long $deckId;
    final /* synthetic */ MutableState<Long> $elapsedSeconds$delegate;
    final /* synthetic */ MutableState<McqSessionState> $sessionState$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuizScreenKt$QuizScreen$18(CoroutineScope coroutineScope, MutableState<McqSessionState> mutableState, MutableState<Long> mutableState2, Context context, long j, Continuation<? super QuizScreenKt$QuizScreen$18> continuation) {
        super(2, continuation);
        this.$coroutineScope = coroutineScope;
        this.$sessionState$delegate = mutableState;
        this.$elapsedSeconds$delegate = mutableState2;
        this.$context = context;
        this.$deckId = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QuizScreenKt$QuizScreen$18(this.$coroutineScope, this.$sessionState$delegate, this.$elapsedSeconds$delegate, this.$context, this.$deckId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QuizScreenKt$QuizScreen$18) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0034  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x003f -> B:5:0x0042). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 1
            if (r1 == 0) goto L18
            if (r1 != r2) goto L10
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = r14
            goto L42
        L10:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L18:
            kotlin.ResultKt.throwOnFailure(r15)
            androidx.compose.runtime.MutableState<com.example.flashcardapp.session.McqSessionState> r15 = r14.$sessionState$delegate
            com.example.flashcardapp.session.McqSessionState r15 = com.example.flashcardapp.ui.QuizScreenKt.access$QuizScreen$lambda$49(r15)
            boolean r15 = r15.isFinished()
            if (r15 != 0) goto L51
            r15 = r14
        L28:
            androidx.compose.runtime.MutableState<com.example.flashcardapp.session.McqSessionState> r1 = r15.$sessionState$delegate
            com.example.flashcardapp.session.McqSessionState r1 = com.example.flashcardapp.ui.QuizScreenKt.access$QuizScreen$lambda$49(r1)
            boolean r1 = r1.isFinished()
            if (r1 != 0) goto L70
            r1 = r15
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r15.label = r2
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r3, r1)
            if (r1 != r0) goto L42
            return r0
        L42:
            androidx.compose.runtime.MutableState<java.lang.Long> r1 = r15.$elapsedSeconds$delegate
            long r3 = com.example.flashcardapp.ui.QuizScreenKt.access$QuizScreen$lambda$82(r1)
            androidx.compose.runtime.MutableState<java.lang.Long> r1 = r15.$elapsedSeconds$delegate
            r5 = 1
            long r3 = r3 + r5
            com.example.flashcardapp.ui.QuizScreenKt.access$QuizScreen$lambda$83(r1, r3)
            goto L28
        L51:
            kotlinx.coroutines.CoroutineScope r5 = r14.$coroutineScope
            kotlinx.coroutines.CoroutineDispatcher r15 = kotlinx.coroutines.Dispatchers.getIO()
            r6 = r15
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
            r7 = 0
            com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$18$1 r15 = new com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$18$1
            android.content.Context r9 = r14.$context
            androidx.compose.runtime.MutableState<com.example.flashcardapp.session.McqSessionState> r10 = r14.$sessionState$delegate
            long r11 = r14.$deckId
            r13 = 0
            r8 = r15
            r8.<init>(r9, r10, r11, r13)
            r8 = r15
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r9 = 2
            r10 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r5, r6, r7, r8, r9, r10)
        L70:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$18.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QuizScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$18$1", f = "QuizScreen.kt", i = {0}, l = {348}, m = "invokeSuspend", n = {"progressManager"}, s = {"L$0"})
    /* renamed from: com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$18$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ long $deckId;
        final /* synthetic */ MutableState<McqSessionState> $sessionState$delegate;
        long J$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, MutableState<McqSessionState> mutableState, long j, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$sessionState$delegate = mutableState;
            this.$deckId = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$context, this.$sessionState$delegate, this.$deckId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PersistentProgressManager persistentProgressManager;
            McqSessionState QuizScreen$lambda$49;
            Iterator it;
            AnonymousClass1 anonymousClass1;
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                persistentProgressManager = new PersistentProgressManager(this.$context);
                QuizScreen$lambda$49 = QuizScreenKt.QuizScreen$lambda$49(this.$sessionState$delegate);
                List<Mcq> questions = QuizScreen$lambda$49.getQuestions();
                long j2 = this.$deckId;
                it = questions.iterator();
                anonymousClass1 = this;
                j = j2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                long j3 = this.J$0;
                it = (Iterator) this.L$1;
                PersistentProgressManager persistentProgressManager2 = (PersistentProgressManager) this.L$0;
                ResultKt.throwOnFailure(obj);
                anonymousClass1 = this;
                j = j3;
                persistentProgressManager = persistentProgressManager2;
            }
            while (it.hasNext()) {
                long sourceCardId = ((Mcq) it.next()).getSourceCardId();
                anonymousClass1.L$0 = persistentProgressManager;
                anonymousClass1.L$1 = it;
                anonymousClass1.J$0 = j;
                anonymousClass1.label = 1;
                if (persistentProgressManager.logAttempt(sourceCardId, j, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }
}

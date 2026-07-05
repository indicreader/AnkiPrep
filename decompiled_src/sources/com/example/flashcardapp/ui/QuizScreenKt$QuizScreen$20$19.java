package com.example.flashcardapp.ui;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.session.McqSessionManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QuizScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$20$19", f = "QuizScreen.kt", i = {}, l = {1059}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class QuizScreenKt$QuizScreen$20$19 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SnapshotStateMap<Integer, LayoutCoordinates> $optionBounds;
    final /* synthetic */ MutableState<Long> $questionTimeMs$delegate;
    final /* synthetic */ McqSessionManager $sessionManager;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuizScreenKt$QuizScreen$20$19(SnapshotStateMap<Integer, LayoutCoordinates> snapshotStateMap, McqSessionManager mcqSessionManager, MutableState<Long> mutableState, Continuation<? super QuizScreenKt$QuizScreen$20$19> continuation) {
        super(2, continuation);
        this.$optionBounds = snapshotStateMap;
        this.$sessionManager = mcqSessionManager;
        this.$questionTimeMs$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        QuizScreenKt$QuizScreen$20$19 quizScreenKt$QuizScreen$20$19 = new QuizScreenKt$QuizScreen$20$19(this.$optionBounds, this.$sessionManager, this.$questionTimeMs$delegate, continuation);
        quizScreenKt$QuizScreen$20$19.L$0 = obj;
        return quizScreenKt$QuizScreen$20$19;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((QuizScreenKt$QuizScreen$20$19) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QuizScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$20$19$1", f = "QuizScreen.kt", i = {0}, l = {1061}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
    /* renamed from: com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$20$19$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SnapshotStateMap<Integer, LayoutCoordinates> $optionBounds;
        final /* synthetic */ MutableState<Long> $questionTimeMs$delegate;
        final /* synthetic */ McqSessionManager $sessionManager;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SnapshotStateMap<Integer, LayoutCoordinates> snapshotStateMap, McqSessionManager mcqSessionManager, MutableState<Long> mutableState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$optionBounds = snapshotStateMap;
            this.$sessionManager = mcqSessionManager;
            this.$questionTimeMs$delegate = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$optionBounds, this.$sessionManager, this.$questionTimeMs$delegate, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00ae A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0036 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0037  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0037 -> B:5:0x003c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r12.label
                r2 = 1
                if (r1 == 0) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r1 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r13)
                r3 = r1
                r1 = r0
                r0 = r12
                goto L3c
            L16:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1e:
                kotlin.ResultKt.throwOnFailure(r13)
                java.lang.Object r13 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
                r1 = r13
                r13 = r12
            L27:
                androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                r4 = r13
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r13.L$0 = r1
                r13.label = r2
                java.lang.Object r3 = r1.awaitPointerEvent(r3, r4)
                if (r3 != r0) goto L37
                return r0
            L37:
                r11 = r0
                r0 = r13
                r13 = r3
                r3 = r1
                r1 = r11
            L3c:
                androidx.compose.ui.input.pointer.PointerEvent r13 = (androidx.compose.ui.input.pointer.PointerEvent) r13
                java.util.List r13 = r13.getChanges()
                java.lang.Object r13 = kotlin.collections.CollectionsKt.firstOrNull(r13)
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                if (r13 == 0) goto Lbf
                boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDown(r13)
                if (r4 == 0) goto Lbf
                int r4 = r13.getType()
                androidx.compose.ui.input.pointer.PointerType$Companion r5 = androidx.compose.ui.input.pointer.PointerType.INSTANCE
                int r5 = r5.m4639getStylusT8wyACA()
                boolean r4 = androidx.compose.ui.input.pointer.PointerType.m4633equalsimpl0(r4, r5)
                if (r4 != 0) goto L70
                int r4 = r13.getType()
                androidx.compose.ui.input.pointer.PointerType$Companion r5 = androidx.compose.ui.input.pointer.PointerType.INSTANCE
                int r5 = r5.m4640getTouchT8wyACA()
                boolean r4 = androidx.compose.ui.input.pointer.PointerType.m4633equalsimpl0(r4, r5)
                if (r4 == 0) goto Lbf
            L70:
                long r4 = r13.getPosition()
                androidx.compose.runtime.snapshots.SnapshotStateMap<java.lang.Integer, androidx.compose.ui.layout.LayoutCoordinates> r6 = r0.$optionBounds
                java.util.Map r6 = (java.util.Map) r6
                java.util.Set r6 = r6.entrySet()
                java.util.Iterator r6 = r6.iterator()
            L80:
                boolean r7 = r6.hasNext()
                r8 = -1
                if (r7 == 0) goto Lae
                java.lang.Object r7 = r6.next()
                java.util.Map$Entry r7 = (java.util.Map.Entry) r7
                java.lang.Object r9 = r7.getKey()
                java.lang.Number r9 = (java.lang.Number) r9
                int r9 = r9.intValue()
                java.lang.Object r7 = r7.getValue()
                androidx.compose.ui.layout.LayoutCoordinates r7 = (androidx.compose.ui.layout.LayoutCoordinates) r7
                boolean r10 = r7.isAttached()
                if (r10 == 0) goto L80
                androidx.compose.ui.geometry.Rect r7 = androidx.compose.ui.layout.LayoutCoordinatesKt.boundsInRoot(r7)
                boolean r7 = r7.m3202containsk4lQ0M(r4)
                if (r7 == 0) goto L80
                goto Laf
            Lae:
                r9 = r8
            Laf:
                if (r9 == r8) goto Lbf
                com.example.flashcardapp.session.McqSessionManager r4 = r0.$sessionManager
                androidx.compose.runtime.MutableState<java.lang.Long> r5 = r0.$questionTimeMs$delegate
                long r5 = com.example.flashcardapp.ui.QuizScreenKt.access$QuizScreen$lambda$67(r5)
                r4.selectOption(r9, r5)
                r13.consume()
            Lbf:
                r13 = r0
                r0 = r1
                r1 = r3
                goto L27
            */
            throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$20$19.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (((PointerInputScope) this.L$0).awaitPointerEventScope(new AnonymousClass1(this.$optionBounds, this.$sessionManager, this.$questionTimeMs$delegate, null), this) == coroutine_suspended) {
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
}

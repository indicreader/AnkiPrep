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
@DebugMetadata(c = "com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$19", f = "QuizScreen.kt", i = {}, l = {373}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class QuizScreenKt$QuizScreen$19 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $isEraserMode$delegate;
    final /* synthetic */ MutableState<Boolean> $isWhiteboardPenMode$delegate;
    final /* synthetic */ SnapshotStateMap<Integer, LayoutCoordinates> $optionBounds;
    final /* synthetic */ MutableState<Long> $questionTimeMs$delegate;
    final /* synthetic */ McqSessionManager $sessionManager;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuizScreenKt$QuizScreen$19(SnapshotStateMap<Integer, LayoutCoordinates> snapshotStateMap, McqSessionManager mcqSessionManager, MutableState<Long> mutableState, MutableState<Boolean> mutableState2, MutableState<Boolean> mutableState3, Continuation<? super QuizScreenKt$QuizScreen$19> continuation) {
        super(2, continuation);
        this.$optionBounds = snapshotStateMap;
        this.$sessionManager = mcqSessionManager;
        this.$questionTimeMs$delegate = mutableState;
        this.$isWhiteboardPenMode$delegate = mutableState2;
        this.$isEraserMode$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        QuizScreenKt$QuizScreen$19 quizScreenKt$QuizScreen$19 = new QuizScreenKt$QuizScreen$19(this.$optionBounds, this.$sessionManager, this.$questionTimeMs$delegate, this.$isWhiteboardPenMode$delegate, this.$isEraserMode$delegate, continuation);
        quizScreenKt$QuizScreen$19.L$0 = obj;
        return quizScreenKt$QuizScreen$19;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((QuizScreenKt$QuizScreen$19) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QuizScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$19$1", f = "QuizScreen.kt", i = {0}, l = {375}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
    /* renamed from: com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$19$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<Boolean> $isEraserMode$delegate;
        final /* synthetic */ MutableState<Boolean> $isWhiteboardPenMode$delegate;
        final /* synthetic */ SnapshotStateMap<Integer, LayoutCoordinates> $optionBounds;
        final /* synthetic */ MutableState<Long> $questionTimeMs$delegate;
        final /* synthetic */ McqSessionManager $sessionManager;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SnapshotStateMap<Integer, LayoutCoordinates> snapshotStateMap, McqSessionManager mcqSessionManager, MutableState<Long> mutableState, MutableState<Boolean> mutableState2, MutableState<Boolean> mutableState3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$optionBounds = snapshotStateMap;
            this.$sessionManager = mcqSessionManager;
            this.$questionTimeMs$delegate = mutableState;
            this.$isWhiteboardPenMode$delegate = mutableState2;
            this.$isEraserMode$delegate = mutableState3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$optionBounds, this.$sessionManager, this.$questionTimeMs$delegate, this.$isWhiteboardPenMode$delegate, this.$isEraserMode$delegate, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00a4  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00dd  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00cb A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0036 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0037  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0037 -> B:5:0x003c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 253
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$19.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (((PointerInputScope) this.L$0).awaitPointerEventScope(new AnonymousClass1(this.$optionBounds, this.$sessionManager, this.$questionTimeMs$delegate, this.$isWhiteboardPenMode$delegate, this.$isEraserMode$delegate, null), this) == coroutine_suspended) {
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

package com.example.flashcardapp.ui;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QuizScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$20$23$1", f = "QuizScreen.kt", i = {}, l = {1194}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class QuizScreenKt$QuizScreen$20$23$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Offset> $whiteboardToolbarOffset$delegate;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuizScreenKt$QuizScreen$20$23$1(MutableState<Offset> mutableState, Continuation<? super QuizScreenKt$QuizScreen$20$23$1> continuation) {
        super(2, continuation);
        this.$whiteboardToolbarOffset$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        QuizScreenKt$QuizScreen$20$23$1 quizScreenKt$QuizScreen$20$23$1 = new QuizScreenKt$QuizScreen$20$23$1(this.$whiteboardToolbarOffset$delegate, continuation);
        quizScreenKt$QuizScreen$20$23$1.L$0 = obj;
        return quizScreenKt$QuizScreen$20$23$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((QuizScreenKt$QuizScreen$20$23$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            final MutableState<Offset> mutableState = this.$whiteboardToolbarOffset$delegate;
            this.label = 1;
            if (DragGestureDetectorKt.detectDragGestures$default(pointerInputScope, null, null, null, new Function2<PointerInputChange, Offset, Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$20$23$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                    m6336invokeUv8p0NA(pointerInputChange, offset.getPackedValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
                public final void m6336invokeUv8p0NA(PointerInputChange change, long j) {
                    long QuizScreen$lambda$129$lambda$112;
                    Intrinsics.checkNotNullParameter(change, "change");
                    change.consume();
                    MutableState<Offset> mutableState2 = mutableState;
                    QuizScreen$lambda$129$lambda$112 = QuizScreenKt.QuizScreen$lambda$129$lambda$112(mutableState2);
                    QuizScreenKt.QuizScreen$lambda$129$lambda$113(mutableState2, Offset.m3181plusMKHz9U(QuizScreen$lambda$129$lambda$112, j));
                }
            }, this, 7, null) == coroutine_suspended) {
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

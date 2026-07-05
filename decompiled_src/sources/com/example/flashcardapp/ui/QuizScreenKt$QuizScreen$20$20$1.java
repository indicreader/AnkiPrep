package com.example.flashcardapp.ui;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QuizScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$20$20$1", f = "QuizScreen.kt", i = {}, l = {1086}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class QuizScreenKt$QuizScreen$20$20$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Color> $activePenColor$delegate;
    final /* synthetic */ MutableFloatState $activePenSize$delegate;
    final /* synthetic */ MutableState<List<Offset>> $currentStrokePoints$delegate;
    final /* synthetic */ Function2<Offset, Float, Unit> $erasePointsNear;
    final /* synthetic */ MutableState<Offset> $eraserIndicatorPosition$delegate;
    final /* synthetic */ float $highlighterAlpha;
    final /* synthetic */ MutableState<Boolean> $isEraserMode$delegate;
    final /* synthetic */ MutableState<String> $penType$delegate;
    final /* synthetic */ SnapshotStateList<DrawingStroke> $whiteboardStrokes;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QuizScreenKt$QuizScreen$20$20$1(Function2<? super Offset, ? super Float, Unit> function2, MutableState<Boolean> mutableState, MutableState<Offset> mutableState2, MutableFloatState mutableFloatState, MutableState<List<Offset>> mutableState3, float f, SnapshotStateList<DrawingStroke> snapshotStateList, MutableState<String> mutableState4, MutableState<Color> mutableState5, Continuation<? super QuizScreenKt$QuizScreen$20$20$1> continuation) {
        super(2, continuation);
        this.$erasePointsNear = function2;
        this.$isEraserMode$delegate = mutableState;
        this.$eraserIndicatorPosition$delegate = mutableState2;
        this.$activePenSize$delegate = mutableFloatState;
        this.$currentStrokePoints$delegate = mutableState3;
        this.$highlighterAlpha = f;
        this.$whiteboardStrokes = snapshotStateList;
        this.$penType$delegate = mutableState4;
        this.$activePenColor$delegate = mutableState5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        QuizScreenKt$QuizScreen$20$20$1 quizScreenKt$QuizScreen$20$20$1 = new QuizScreenKt$QuizScreen$20$20$1(this.$erasePointsNear, this.$isEraserMode$delegate, this.$eraserIndicatorPosition$delegate, this.$activePenSize$delegate, this.$currentStrokePoints$delegate, this.$highlighterAlpha, this.$whiteboardStrokes, this.$penType$delegate, this.$activePenColor$delegate, continuation);
        quizScreenKt$QuizScreen$20$20$1.L$0 = obj;
        return quizScreenKt$QuizScreen$20$20$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((QuizScreenKt$QuizScreen$20$20$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            final Function2<Offset, Float, Unit> function2 = this.$erasePointsNear;
            final MutableState<Boolean> mutableState = this.$isEraserMode$delegate;
            final MutableState<Offset> mutableState2 = this.$eraserIndicatorPosition$delegate;
            final MutableFloatState mutableFloatState = this.$activePenSize$delegate;
            final MutableState<List<Offset>> mutableState3 = this.$currentStrokePoints$delegate;
            Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$20$20$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m6333invokek4lQ0M(offset.getPackedValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m6333invokek4lQ0M(long j) {
                    boolean QuizScreen$lambda$15;
                    float QuizScreen$lambda$129$lambda$99;
                    QuizScreen$lambda$15 = QuizScreenKt.QuizScreen$lambda$15(mutableState);
                    if (!QuizScreen$lambda$15) {
                        mutableState3.setValue(CollectionsKt.listOf(Offset.m3165boximpl(j)));
                        return;
                    }
                    mutableState2.setValue(Offset.m3165boximpl(j));
                    Function2<Offset, Float, Unit> function22 = function2;
                    Offset m3165boximpl = Offset.m3165boximpl(j);
                    QuizScreen$lambda$129$lambda$99 = QuizScreenKt.QuizScreen$lambda$129$lambda$99(mutableFloatState);
                    function22.invoke(m3165boximpl, Float.valueOf(QuizScreen$lambda$129$lambda$99 * 1.5f));
                }
            };
            final float f = this.$highlighterAlpha;
            final SnapshotStateList<DrawingStroke> snapshotStateList = this.$whiteboardStrokes;
            final MutableState<Offset> mutableState4 = this.$eraserIndicatorPosition$delegate;
            final MutableState<Boolean> mutableState5 = this.$isEraserMode$delegate;
            final MutableState<List<Offset>> mutableState6 = this.$currentStrokePoints$delegate;
            final MutableState<String> mutableState7 = this.$penType$delegate;
            final MutableState<Color> mutableState8 = this.$activePenColor$delegate;
            final MutableFloatState mutableFloatState2 = this.$activePenSize$delegate;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$20$20$1.2
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
                    boolean QuizScreen$lambda$15;
                    List QuizScreen$lambda$9;
                    String QuizScreen$lambda$129$lambda$105;
                    List QuizScreen$lambda$92;
                    long QuizScreen$lambda$129$lambda$96;
                    float QuizScreen$lambda$129$lambda$99;
                    mutableState4.setValue(null);
                    QuizScreen$lambda$15 = QuizScreenKt.QuizScreen$lambda$15(mutableState5);
                    if (QuizScreen$lambda$15) {
                        return;
                    }
                    QuizScreen$lambda$9 = QuizScreenKt.QuizScreen$lambda$9(mutableState6);
                    if (!QuizScreen$lambda$9.isEmpty()) {
                        QuizScreen$lambda$129$lambda$105 = QuizScreenKt.QuizScreen$lambda$129$lambda$105(mutableState7);
                        float f2 = Intrinsics.areEqual(QuizScreen$lambda$129$lambda$105, "Highlighter") ? f : 1.0f;
                        SnapshotStateList<DrawingStroke> snapshotStateList2 = snapshotStateList;
                        QuizScreen$lambda$92 = QuizScreenKt.QuizScreen$lambda$9(mutableState6);
                        QuizScreen$lambda$129$lambda$96 = QuizScreenKt.QuizScreen$lambda$129$lambda$96(mutableState8);
                        long m3416copywmQWz5c$default = Color.m3416copywmQWz5c$default(QuizScreen$lambda$129$lambda$96, f2, 0.0f, 0.0f, 0.0f, 14, null);
                        QuizScreen$lambda$129$lambda$99 = QuizScreenKt.QuizScreen$lambda$129$lambda$99(mutableFloatState2);
                        snapshotStateList2.add(new DrawingStroke(QuizScreen$lambda$92, m3416copywmQWz5c$default, QuizScreen$lambda$129$lambda$99, null));
                        mutableState6.setValue(CollectionsKt.emptyList());
                    }
                }
            };
            final Function2<Offset, Float, Unit> function22 = this.$erasePointsNear;
            final MutableState<Boolean> mutableState9 = this.$isEraserMode$delegate;
            final MutableState<Offset> mutableState10 = this.$eraserIndicatorPosition$delegate;
            final MutableFloatState mutableFloatState3 = this.$activePenSize$delegate;
            final MutableState<List<Offset>> mutableState11 = this.$currentStrokePoints$delegate;
            this.label = 1;
            if (DragGestureDetectorKt.detectDragGestures$default(pointerInputScope, function1, function0, null, new Function2<PointerInputChange, Offset, Unit>() { // from class: com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$20$20$1.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                    m6334invokeUv8p0NA(pointerInputChange, offset.getPackedValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
                public final void m6334invokeUv8p0NA(PointerInputChange change, long j) {
                    boolean QuizScreen$lambda$15;
                    List QuizScreen$lambda$9;
                    float QuizScreen$lambda$129$lambda$99;
                    Intrinsics.checkNotNullParameter(change, "change");
                    change.consume();
                    QuizScreen$lambda$15 = QuizScreenKt.QuizScreen$lambda$15(mutableState9);
                    if (!QuizScreen$lambda$15) {
                        MutableState<List<Offset>> mutableState12 = mutableState11;
                        QuizScreen$lambda$9 = QuizScreenKt.QuizScreen$lambda$9(mutableState12);
                        mutableState12.setValue(CollectionsKt.plus((Collection<? extends Offset>) QuizScreen$lambda$9, Offset.m3165boximpl(change.getPosition())));
                    } else {
                        mutableState10.setValue(Offset.m3165boximpl(change.getPosition()));
                        Function2<Offset, Float, Unit> function23 = function22;
                        Offset m3165boximpl = Offset.m3165boximpl(change.getPosition());
                        QuizScreen$lambda$129$lambda$99 = QuizScreenKt.QuizScreen$lambda$129$lambda$99(mutableFloatState3);
                        function23.invoke(m3165boximpl, Float.valueOf(QuizScreen$lambda$129$lambda$99 * 1.5f));
                    }
                }
            }, this, 4, null) == coroutine_suspended) {
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

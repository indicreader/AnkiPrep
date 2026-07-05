package androidx.compose.animation.core;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

/* compiled from: Transition.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0016\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0019H\u0086@¢\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0019H\u0086@¢\u0006\u0002\u0010\u001aJ\b\u0010\u001c\u001a\u00020\u0017H\u0002J\u0018\u0010\u001d\u001a\u00020\u00172\b\b\u0001\u0010\u000e\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\u001eJ\u001b\u0010\u001f\u001a\u00020\u00172\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0010¢\u0006\u0002\b R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u000e\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0013\u0010\fR\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/compose/animation/core/SeekableTransitionState;", ExifInterface.LATITUDE_SOUTH, "Landroidx/compose/animation/core/TransitionState;", "initialState", "targetState", "(Ljava/lang/Object;Ljava/lang/Object;)V", "animatedFraction", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "currentState", "getCurrentState", "()Ljava/lang/Object;", "Ljava/lang/Object;", "fraction", "getFraction", "()F", "observer", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "getTargetState", "transition", "Landroidx/compose/animation/core/Transition;", "animateToCurrentState", "", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToTargetState", "seekToFraction", "snapToFraction", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transitionConfigured", "transitionConfigured$animation_core_release", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SeekableTransitionState<S> extends TransitionState<S> {
    public static final int $stable = 8;
    private final Animatable<Float, AnimationVector1D> animatedFraction;
    private final S currentState;
    private final SnapshotStateObserver observer;
    private final S targetState;
    private Transition<S> transition;

    @Override // androidx.compose.animation.core.TransitionState
    public S getCurrentState() {
        return this.currentState;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public S getTargetState() {
        return this.targetState;
    }

    public SeekableTransitionState(S s, S s2) {
        super(null);
        this.targetState = s2;
        Animatable<Float, AnimationVector1D> Animatable$default = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        Animatable$default.updateBounds(Float.valueOf(0.0f), Float.valueOf(1.0f));
        this.animatedFraction = Animatable$default;
        this.observer = new SnapshotStateObserver(new Function1<Function0<? extends Unit>, Unit>() { // from class: androidx.compose.animation.core.SeekableTransitionState$observer$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
                invoke2((Function0<Unit>) function0);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function0<Unit> function0) {
                function0.invoke();
            }
        });
        this.currentState = s;
    }

    public final float getFraction() {
        return this.animatedFraction.getValue().floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object snapToFraction(float r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.compose.animation.core.SeekableTransitionState$snapToFraction$1
            if (r0 == 0) goto L14
            r0 = r6
            androidx.compose.animation.core.SeekableTransitionState$snapToFraction$1 r0 = (androidx.compose.animation.core.SeekableTransitionState$snapToFraction$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            androidx.compose.animation.core.SeekableTransitionState$snapToFraction$1 r0 = new androidx.compose.animation.core.SeekableTransitionState$snapToFraction$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            androidx.compose.animation.core.SeekableTransitionState r5 = (androidx.compose.animation.core.SeekableTransitionState) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L68
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = 0
            int r6 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r6 > 0) goto L6e
            r6 = 1065353216(0x3f800000, float:1.0)
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 > 0) goto L6e
            java.lang.Object r6 = r4.getCurrentState()
            java.lang.Object r2 = r4.getTargetState()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r2)
            if (r6 == 0) goto L56
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L56:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r6 = r4.animatedFraction
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r6.snapTo(r5, r0)
            if (r5 != r1) goto L67
            return r1
        L67:
            r5 = r4
        L68:
            r5.seekToFraction()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L6e:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "Expecting fraction between 0 and 1. Got "
            r6.<init>(r0)
            java.lang.StringBuilder r5 = r6.append(r5)
            java.lang.String r5 = r5.toString()
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r5.toString()
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SeekableTransitionState.snapToFraction(float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateToTargetState$default(SeekableTransitionState seekableTransitionState, FiniteAnimationSpec finiteAnimationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = seekableTransitionState.animatedFraction.getDefaultSpringSpec$animation_core_release();
        }
        return seekableTransitionState.animateToTargetState(finiteAnimationSpec, continuation);
    }

    public final Object animateToTargetState(FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super Unit> continuation) {
        if (this.transition == null || Intrinsics.areEqual(getCurrentState(), getTargetState())) {
            return Unit.INSTANCE;
        }
        Object animateTo$default = Animatable.animateTo$default(this.animatedFraction, Boxing.boxFloat(1.0f), finiteAnimationSpec, null, new Function1<Animatable<Float, AnimationVector1D>, Unit>(this) { // from class: androidx.compose.animation.core.SeekableTransitionState$animateToTargetState$2
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Animatable<Float, AnimationVector1D> animatable) {
                invoke2(animatable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Animatable<Float, AnimationVector1D> animatable) {
                this.this$0.seekToFraction();
            }
        }, continuation, 4, null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateToCurrentState$default(SeekableTransitionState seekableTransitionState, FiniteAnimationSpec finiteAnimationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = seekableTransitionState.animatedFraction.getDefaultSpringSpec$animation_core_release();
        }
        return seekableTransitionState.animateToCurrentState(finiteAnimationSpec, continuation);
    }

    public final Object animateToCurrentState(FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super Unit> continuation) {
        if (this.transition == null || Intrinsics.areEqual(getCurrentState(), getTargetState())) {
            return Unit.INSTANCE;
        }
        Object animateTo$default = Animatable.animateTo$default(this.animatedFraction, Boxing.boxFloat(0.0f), finiteAnimationSpec, null, new Function1<Animatable<Float, AnimationVector1D>, Unit>(this) { // from class: androidx.compose.animation.core.SeekableTransitionState$animateToCurrentState$2
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Animatable<Float, AnimationVector1D> animatable) {
                invoke2(animatable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Animatable<Float, AnimationVector1D> animatable) {
                this.this$0.seekToFraction();
            }
        }, continuation, 4, null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void transitionConfigured$animation_core_release(Transition<S> transition) {
        Transition<S> transition2 = this.transition;
        if (transition2 != null && !Intrinsics.areEqual(transition, transition2)) {
            throw new IllegalStateException(("An instance of SeekableTransitionState has been used in different Transitions. Previous instance: " + this.transition + ", new instance: " + transition).toString());
        }
        this.transition = transition;
        seekToFraction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void seekToFraction() {
        final Transition<S> transition = this.transition;
        if (transition == null) {
            return;
        }
        final Ref.LongRef longRef = new Ref.LongRef();
        this.observer.observeReads(Unit.INSTANCE, new Function1<Unit, Unit>(this) { // from class: androidx.compose.animation.core.SeekableTransitionState$seekToFraction$1
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                this.this$0.seekToFraction();
            }
        }, new Function0<Unit>() { // from class: androidx.compose.animation.core.SeekableTransitionState$seekToFraction$2
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
                Ref.LongRef.this.element = transition.getTotalDurationNanos();
            }
        });
        transition.seek(getCurrentState(), getTargetState(), MathKt.roundToLong(this.animatedFraction.getValue().floatValue() * ((float) longRef.element)));
    }
}

package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DragGestureDetector.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {667, 693}, m = "awaitPointerSlopOrCancellation-pn7EDYM", n = {"$this$awaitPointerSlopOrCancellation_u2dpn7EDYM", "pointerDirectionConfig", "onPointerSlopReached", "pointer", "touchSlop", "totalPositionChange", "$this$awaitPointerSlopOrCancellation_u2dpn7EDYM", "pointerDirectionConfig", "onPointerSlopReached", "pointer", "dragEvent", "touchSlop", "totalPositionChange"}, s = {"L$0", "L$1", "L$2", "L$3", "F$0", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "F$0", "J$0"})
/* loaded from: classes.dex */
public final class DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 extends ContinuationImpl {
    float F$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DragGestureDetectorKt$awaitPointerSlopOrCancellation$1(Continuation<? super DragGestureDetectorKt$awaitPointerSlopOrCancellation$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m347awaitPointerSlopOrCancellationpn7EDYM(null, 0L, 0, null, null, this);
    }
}

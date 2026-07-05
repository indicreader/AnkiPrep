package com.example.flashcardapp.fsrs;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FsrsScheduler.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.fsrs.FsrsScheduler", f = "FsrsScheduler.kt", i = {0, 0, 0, 0}, l = {92, WebSocketProtocol.PAYLOAD_SHORT}, m = "applyRating", n = {"this", "rating", "cardId", "isCorrect"}, s = {"L$0", "L$1", "J$0", "Z$0"})
/* loaded from: classes2.dex */
public final class FsrsScheduler$applyRating$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FsrsScheduler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FsrsScheduler$applyRating$1(FsrsScheduler fsrsScheduler, Continuation<? super FsrsScheduler$applyRating$1> continuation) {
        super(continuation);
        this.this$0 = fsrsScheduler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object applyRating;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        applyRating = this.this$0.applyRating(0L, null, false, this);
        return applyRating;
    }
}

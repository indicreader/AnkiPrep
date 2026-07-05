package com.example.flashcardapp.fsrs;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FsrsScheduler.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.fsrs.FsrsScheduler", f = "FsrsScheduler.kt", i = {}, l = {64}, m = "getNewCardIds", n = {}, s = {})
/* loaded from: classes2.dex */
public final class FsrsScheduler$getNewCardIds$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FsrsScheduler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FsrsScheduler$getNewCardIds$1(FsrsScheduler fsrsScheduler, Continuation<? super FsrsScheduler$getNewCardIds$1> continuation) {
        super(continuation);
        this.this$0 = fsrsScheduler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getNewCardIds(0L, 0, this);
    }
}

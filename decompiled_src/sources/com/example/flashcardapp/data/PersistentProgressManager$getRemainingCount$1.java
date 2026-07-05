package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PersistentProgressManager.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.data.PersistentProgressManager", f = "PersistentProgressManager.kt", i = {0}, l = {28}, m = "getRemainingCount", n = {"totalCardCount"}, s = {"I$0"})
/* loaded from: classes2.dex */
public final class PersistentProgressManager$getRemainingCount$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PersistentProgressManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentProgressManager$getRemainingCount$1(PersistentProgressManager persistentProgressManager, Continuation<? super PersistentProgressManager$getRemainingCount$1> continuation) {
        super(continuation);
        this.this$0 = persistentProgressManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getRemainingCount(0L, 0, this);
    }
}

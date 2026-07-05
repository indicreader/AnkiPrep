package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PersistentProgressManager.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.data.PersistentProgressManager", f = "PersistentProgressManager.kt", i = {0, 0, 0}, l = {12, 16}, m = "logAttempt", n = {"this", "cardId", "deckId"}, s = {"L$0", "J$0", "J$1"})
/* loaded from: classes2.dex */
public final class PersistentProgressManager$logAttempt$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PersistentProgressManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentProgressManager$logAttempt$1(PersistentProgressManager persistentProgressManager, Continuation<? super PersistentProgressManager$logAttempt$1> continuation) {
        super(continuation);
        this.this$0 = persistentProgressManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.logAttempt(0L, 0L, this);
    }
}

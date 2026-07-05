package com.example.flashcardapp.session;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SessionGenerationEngine.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.session.SessionGenerationEngine", f = "SessionGenerationEngine.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 5, 5, 5, 6}, l = {19, 20, 22, 24, 28, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS, 30}, m = "getRemainingUniqueCards", n = {"this", "customDeckIds", "deckId", "isStarredOnly", "this", "customDeckIds", "starredIds", "deckId", "isStarredOnly", "this", "customDeckIds", "deckId", "isStarredOnly", "this", "customDeckIds", "deckId", "isStarredOnly", "basePool", "this", "basePool", "destination$iv$iv", "basePool"}, s = {"L$0", "L$1", "J$0", "Z$0", "L$0", "L$1", "L$2", "J$0", "Z$0", "L$0", "L$1", "J$0", "Z$0", "L$0", "L$1", "J$0", "Z$0", "L$0", "L$0", "L$1", "L$2", "L$0"})
/* loaded from: classes2.dex */
public final class SessionGenerationEngine$getRemainingUniqueCards$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SessionGenerationEngine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionGenerationEngine$getRemainingUniqueCards$1(SessionGenerationEngine sessionGenerationEngine, Continuation<? super SessionGenerationEngine$getRemainingUniqueCards$1> continuation) {
        super(continuation);
        this.this$0 = sessionGenerationEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getRemainingUniqueCards(null, 0L, false, null, this);
    }
}

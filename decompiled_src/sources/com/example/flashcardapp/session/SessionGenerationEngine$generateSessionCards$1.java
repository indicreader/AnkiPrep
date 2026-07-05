package com.example.flashcardapp.session;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SessionGenerationEngine.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.session.SessionGenerationEngine", f = "SessionGenerationEngine.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4}, l = {44, 45, 47, ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, 52}, m = "generateSessionCards", n = {"this", "deckId", "questionLimit", "this", "starredIds", "deckId", "questionLimit", "this", "customDeckIds", "deckId", "questionLimit", "this", "deckId", "questionLimit", "basePool", "questionLimit"}, s = {"L$0", "J$0", "I$0", "L$0", "L$1", "J$0", "I$0", "L$0", "L$1", "J$0", "I$0", "L$0", "J$0", "I$0", "L$0", "I$0"})
/* loaded from: classes2.dex */
public final class SessionGenerationEngine$generateSessionCards$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SessionGenerationEngine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionGenerationEngine$generateSessionCards$1(SessionGenerationEngine sessionGenerationEngine, Continuation<? super SessionGenerationEngine$generateSessionCards$1> continuation) {
        super(continuation);
        this.this$0 = sessionGenerationEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.generateSessionCards(null, 0L, 0, false, null, this);
    }
}

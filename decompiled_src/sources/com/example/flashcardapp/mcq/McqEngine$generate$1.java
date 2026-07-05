package com.example.flashcardapp.mcq;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: McqEngine.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.mcq.McqEngine", f = "McqEngine.kt", i = {0, 0, 0, 0}, l = {71}, m = "generate", n = {"this", "aliases", "targetDifficulty", "filteredCards"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes2.dex */
public final class McqEngine$generate$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ McqEngine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public McqEngine$generate$1(McqEngine mcqEngine, Continuation<? super McqEngine$generate$1> continuation) {
        super(continuation);
        this.this$0 = mcqEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.generate(null, null, null, null, null, null, this);
    }
}

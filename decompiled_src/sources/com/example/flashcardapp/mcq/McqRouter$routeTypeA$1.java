package com.example.flashcardapp.mcq;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: McqRouter.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.mcq.McqRouter", f = "McqRouter.kt", i = {0, 0, 0}, l = {204}, m = "routeTypeA", n = {"this", "card", "pool"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes2.dex */
public final class McqRouter$routeTypeA$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ McqRouter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public McqRouter$routeTypeA$1(McqRouter mcqRouter, Continuation<? super McqRouter$routeTypeA$1> continuation) {
        super(continuation);
        this.this$0 = mcqRouter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object routeTypeA;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        routeTypeA = this.this$0.routeTypeA(null, null, null, this);
        return routeTypeA;
    }
}

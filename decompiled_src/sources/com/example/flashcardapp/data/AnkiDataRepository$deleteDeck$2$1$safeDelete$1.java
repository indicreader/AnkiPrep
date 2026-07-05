package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnkiDataRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.data.AnkiDataRepository$deleteDeck$2", f = "AnkiDataRepository.kt", i = {0, 0}, l = {579}, m = "invokeSuspend$lambda$5$safeDelete", n = {"this$0", "path"}, s = {"L$0", "L$1"})
/* loaded from: classes2.dex */
public final class AnkiDataRepository$deleteDeck$2$1$safeDelete$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnkiDataRepository$deleteDeck$2$1$safeDelete$1(Continuation<? super AnkiDataRepository$deleteDeck$2$1$safeDelete$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object invokeSuspend$lambda$5$safeDelete;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        invokeSuspend$lambda$5$safeDelete = AnkiDataRepository$deleteDeck$2.invokeSuspend$lambda$5$safeDelete(null, null, null, this);
        return invokeSuspend$lambda$5$safeDelete;
    }
}

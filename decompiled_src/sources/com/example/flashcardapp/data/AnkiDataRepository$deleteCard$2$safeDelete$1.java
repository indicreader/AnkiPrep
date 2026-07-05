package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnkiDataRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.data.AnkiDataRepository$deleteCard$2", f = "AnkiDataRepository.kt", i = {0, 0}, l = {655}, m = "invokeSuspend$safeDelete", n = {"this$0", "path"}, s = {"L$0", "L$1"})
/* loaded from: classes2.dex */
public final class AnkiDataRepository$deleteCard$2$safeDelete$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnkiDataRepository$deleteCard$2$safeDelete$1(Continuation<? super AnkiDataRepository$deleteCard$2$safeDelete$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object invokeSuspend$safeDelete;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        invokeSuspend$safeDelete = AnkiDataRepository$deleteCard$2.invokeSuspend$safeDelete(null, null, null, this);
        return invokeSuspend$safeDelete;
    }
}

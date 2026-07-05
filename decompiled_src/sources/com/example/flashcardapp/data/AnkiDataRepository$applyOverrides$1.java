package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnkiDataRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.data.AnkiDataRepository", f = "AnkiDataRepository.kt", i = {0}, l = {306}, m = "applyOverrides", n = {"cards"}, s = {"L$0"})
/* loaded from: classes2.dex */
public final class AnkiDataRepository$applyOverrides$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AnkiDataRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnkiDataRepository$applyOverrides$1(AnkiDataRepository ankiDataRepository, Continuation<? super AnkiDataRepository$applyOverrides$1> continuation) {
        super(continuation);
        this.this$0 = ankiDataRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object applyOverrides;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        applyOverrides = this.this$0.applyOverrides(null, this);
        return applyOverrides;
    }
}

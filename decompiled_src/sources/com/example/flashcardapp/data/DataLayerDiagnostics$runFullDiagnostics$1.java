package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataLayerDiagnostics.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.data.DataLayerDiagnostics", f = "DataLayerDiagnostics.kt", i = {0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4}, l = {54, 66, 79, 86, 107}, m = "runFullDiagnostics", n = {"repo", "repo", "syncResult", "repo", "syncResult", "allDecks", "deckCount", "repo", "syncResult", "allDecks", "deckCount", "cardCount", "syncResult", "allDecks", "sampleCards", "deckCount", "cardCount"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
/* loaded from: classes2.dex */
public final class DataLayerDiagnostics$runFullDiagnostics$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataLayerDiagnostics this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataLayerDiagnostics$runFullDiagnostics$1(DataLayerDiagnostics dataLayerDiagnostics, Continuation<? super DataLayerDiagnostics$runFullDiagnostics$1> continuation) {
        super(continuation);
        this.this$0 = dataLayerDiagnostics;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.runFullDiagnostics(null, false, this);
    }
}

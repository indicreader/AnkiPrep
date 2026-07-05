package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnkiDataRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.data.AnkiDataRepository$clearDeckProgress$2", f = "AnkiDataRepository.kt", i = {}, l = {721, 723, 725, 726}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class AnkiDataRepository$clearDeckProgress$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $deckId;
    Object L$0;
    int label;
    final /* synthetic */ AnkiDataRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnkiDataRepository$clearDeckProgress$2(long j, AnkiDataRepository ankiDataRepository, Continuation<? super AnkiDataRepository$clearDeckProgress$2> continuation) {
        super(2, continuation);
        this.$deckId = j;
        this.this$0 = ankiDataRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnkiDataRepository$clearDeckProgress$2(this.$deckId, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnkiDataRepository$clearDeckProgress$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00b8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a4 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L33
            if (r1 == r5) goto L2f
            if (r1 == r4) goto L27
            if (r1 == r3) goto L21
            if (r1 != r2) goto L19
            kotlin.ResultKt.throwOnFailure(r10)
            goto Lb9
        L19:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L21:
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            goto La5
        L27:
            java.lang.Object r1 = r9.L$0
            java.util.Iterator r1 = (java.util.Iterator) r1
            kotlin.ResultKt.throwOnFailure(r10)
            goto L6d
        L2f:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L66
        L33:
            kotlin.ResultKt.throwOnFailure(r10)
            long r6 = r9.$deckId
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r1 = "Clearing progress for deck with ID "
            r10.<init>(r1)
            java.lang.StringBuilder r10 = r10.append(r6)
            java.lang.String r1 = " and its subdecks"
            java.lang.StringBuilder r10 = r10.append(r1)
            java.lang.String r10 = r10.toString()
            java.lang.String r1 = "AnkiDataRepository"
            android.util.Log.d(r1, r10)
            com.example.flashcardapp.data.AnkiDataRepository r10 = r9.this$0
            com.example.flashcardapp.data.dao.DeckDao r10 = com.example.flashcardapp.data.AnkiDataRepository.access$getDeckDao$p(r10)
            long r6 = r9.$deckId
            r1 = r9
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r9.label = r5
            java.lang.Object r10 = r10.getSubDecks(r6, r1)
            if (r10 != r0) goto L66
            return r0
        L66:
            java.util.List r10 = (java.util.List) r10
            java.util.Iterator r10 = r10.iterator()
            r1 = r10
        L6d:
            r10 = r9
        L6e:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L8e
            java.lang.Object r5 = r1.next()
            com.example.flashcardapp.data.entities.DeckEntity r5 = (com.example.flashcardapp.data.entities.DeckEntity) r5
            com.example.flashcardapp.data.AnkiDataRepository r6 = r10.this$0
            long r7 = r5.getId()
            r5 = r10
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r10.L$0 = r1
            r10.label = r4
            java.lang.Object r5 = r6.clearDeckProgress(r7, r5)
            if (r5 != r0) goto L6e
            return r0
        L8e:
            com.example.flashcardapp.data.AnkiDataRepository r1 = r10.this$0
            com.example.flashcardapp.data.dao.CardAttemptDao r1 = com.example.flashcardapp.data.AnkiDataRepository.access$getCardAttemptDao$p(r1)
            long r4 = r10.$deckId
            r6 = r10
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r7 = 0
            r10.L$0 = r7
            r10.label = r3
            java.lang.Object r1 = r1.deleteAttemptsForDeck(r4, r6)
            if (r1 != r0) goto La5
            return r0
        La5:
            com.example.flashcardapp.data.AnkiDataRepository r1 = r10.this$0
            com.example.flashcardapp.data.dao.SessionRecordDao r1 = com.example.flashcardapp.data.AnkiDataRepository.access$getSessionRecordDao$p(r1)
            long r3 = r10.$deckId
            r5 = r10
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r10.label = r2
            java.lang.Object r10 = r1.deleteRecordsForDeck(r3, r5)
            if (r10 != r0) goto Lb9
            return r0
        Lb9:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.AnkiDataRepository$clearDeckProgress$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

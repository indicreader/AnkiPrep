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
@DebugMetadata(c = "com.example.flashcardapp.data.AnkiDataRepository$clearCache$2", f = "AnkiDataRepository.kt", i = {}, l = {763, 764, 765, 766}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class AnkiDataRepository$clearCache$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AnkiDataRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnkiDataRepository$clearCache$2(AnkiDataRepository ankiDataRepository, Continuation<? super AnkiDataRepository$clearCache$2> continuation) {
        super(2, continuation);
        this.this$0 = ankiDataRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnkiDataRepository$clearCache$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnkiDataRepository$clearCache$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L2c
            if (r1 == r5) goto L28
            if (r1 == r4) goto L24
            if (r1 == r3) goto L20
            if (r1 != r2) goto L18
            kotlin.ResultKt.throwOnFailure(r7)
            goto L7e
        L18:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L20:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6c
        L24:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5a
        L28:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L48
        L2c:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.String r7 = "AnkiDataRepository"
            java.lang.String r1 = "Clearing all cached data"
            android.util.Log.d(r7, r1)
            com.example.flashcardapp.data.AnkiDataRepository r7 = r6.this$0
            com.example.flashcardapp.data.dao.CardDao r7 = com.example.flashcardapp.data.AnkiDataRepository.access$getCardDao$p(r7)
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r6.label = r5
            java.lang.Object r7 = r7.deleteAllCards(r1)
            if (r7 != r0) goto L48
            return r0
        L48:
            com.example.flashcardapp.data.AnkiDataRepository r7 = r6.this$0
            com.example.flashcardapp.data.dao.DeckDao r7 = com.example.flashcardapp.data.AnkiDataRepository.access$getDeckDao$p(r7)
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r6.label = r4
            java.lang.Object r7 = r7.deleteAllDecks(r1)
            if (r7 != r0) goto L5a
            return r0
        L5a:
            com.example.flashcardapp.data.AnkiDataRepository r7 = r6.this$0
            com.example.flashcardapp.data.dao.SessionRecordDao r7 = com.example.flashcardapp.data.AnkiDataRepository.access$getSessionRecordDao$p(r7)
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r6.label = r3
            java.lang.Object r7 = r7.deleteAllRecords(r1)
            if (r7 != r0) goto L6c
            return r0
        L6c:
            com.example.flashcardapp.data.AnkiDataRepository r7 = r6.this$0
            com.example.flashcardapp.data.dao.CardAttemptDao r7 = com.example.flashcardapp.data.AnkiDataRepository.access$getCardAttemptDao$p(r7)
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r6.label = r2
            java.lang.Object r7 = r7.deleteAllAttempts(r1)
            if (r7 != r0) goto L7e
            return r0
        L7e:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.AnkiDataRepository$clearCache$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

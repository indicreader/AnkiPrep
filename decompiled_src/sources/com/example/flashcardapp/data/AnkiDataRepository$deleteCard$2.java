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
@DebugMetadata(c = "com.example.flashcardapp.data.AnkiDataRepository$deleteCard$2", f = "AnkiDataRepository.kt", i = {1, 1, 2, 2, 3, 3, 4, 4, 5, 6}, l = {648, 659, 660, 661, 666, 673, 674, 678, 680}, m = "invokeSuspend", n = {"card", "deckId", "card", "deckId", "card", "deckId", "card", "deckId", "deckId", "deckId"}, s = {"L$0", "J$0", "L$0", "J$0", "L$0", "J$0", "L$0", "J$0", "J$0", "J$0"})
/* loaded from: classes2.dex */
public final class AnkiDataRepository$deleteCard$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $cardId;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AnkiDataRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnkiDataRepository$deleteCard$2(AnkiDataRepository ankiDataRepository, long j, Continuation<? super AnkiDataRepository$deleteCard$2> continuation) {
        super(2, continuation);
        this.this$0 = ankiDataRepository;
        this.$cardId = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnkiDataRepository$deleteCard$2(this.this$0, this.$cardId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnkiDataRepository$deleteCard$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0177 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x011a A[Catch: Exception -> 0x0135, TryCatch #1 {Exception -> 0x0135, blocks: (B:29:0x0114, B:31:0x011a, B:37:0x0132), top: B:28:0x0114 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0160 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x008e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            Method dump skipped, instructions count: 506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.AnkiDataRepository$deleteCard$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object invokeSuspend$safeDelete(com.example.flashcardapp.data.AnkiDataRepository r6, com.example.flashcardapp.data.entities.CardEntity r7, java.lang.String r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            boolean r0 = r9 instanceof com.example.flashcardapp.data.AnkiDataRepository$deleteCard$2$safeDelete$1
            if (r0 == 0) goto L14
            r0 = r9
            com.example.flashcardapp.data.AnkiDataRepository$deleteCard$2$safeDelete$1 r0 = (com.example.flashcardapp.data.AnkiDataRepository$deleteCard$2$safeDelete$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.example.flashcardapp.data.AnkiDataRepository$deleteCard$2$safeDelete$1 r0 = new com.example.flashcardapp.data.AnkiDataRepository$deleteCard$2$safeDelete$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.L$1
            r8 = r6
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r6 = r0.L$0
            com.example.flashcardapp.data.AnkiDataRepository r6 = (com.example.flashcardapp.data.AnkiDataRepository) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L53
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            kotlin.ResultKt.throwOnFailure(r9)
            com.example.flashcardapp.data.dao.CardDao r9 = com.example.flashcardapp.data.AnkiDataRepository.access$getCardDao$p(r6)
            long r4 = r7.getId()
            r0.L$0 = r6
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r9 = r9.countImageReferences(r8, r4, r0)
            if (r9 != r1) goto L53
            return r1
        L53:
            java.lang.Number r9 = (java.lang.Number) r9
            int r7 = r9.intValue()
            if (r7 != 0) goto L64
            com.example.flashcardapp.data.ImageStorageManager r7 = com.example.flashcardapp.data.ImageStorageManager.INSTANCE
            android.content.Context r6 = com.example.flashcardapp.data.AnkiDataRepository.access$getContext$p(r6)
            r7.deleteImageFromLocalStorage(r6, r8)
        L64:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.AnkiDataRepository$deleteCard$2.invokeSuspend$safeDelete(com.example.flashcardapp.data.AnkiDataRepository, com.example.flashcardapp.data.entities.CardEntity, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

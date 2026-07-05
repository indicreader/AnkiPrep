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
@DebugMetadata(c = "com.example.flashcardapp.data.AnkiDataRepository$deleteDeck$2", f = "AnkiDataRepository.kt", i = {3, 4, 5, 6}, l = {568, 570, 576, 583, 584, 585, 590, 598, 599, 600, 601}, m = "invokeSuspend", n = {"card", "card", "card", "card"}, s = {"L$2", "L$2", "L$2", "L$2"})
/* loaded from: classes2.dex */
public final class AnkiDataRepository$deleteDeck$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $deckId;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ AnkiDataRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnkiDataRepository$deleteDeck$2(long j, AnkiDataRepository ankiDataRepository, Continuation<? super AnkiDataRepository$deleteDeck$2> continuation) {
        super(2, continuation);
        this.$deckId = j;
        this.this$0 = ankiDataRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnkiDataRepository$deleteDeck$2(this.$deckId, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnkiDataRepository$deleteDeck$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x01a3, code lost:
    
        r4 = r4.iterator();
        r4 = r1;
        r1 = r4;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0009. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0232 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x021c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0206 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0181 A[Catch: Exception -> 0x01c1, TRY_ENTER, TryCatch #0 {Exception -> 0x01c1, blocks: (B:26:0x01a3, B:29:0x01a9, B:57:0x0181, B:59:0x0196, B:60:0x019a), top: B:28:0x01a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01f0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fc  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x017f -> B:27:0x01cf). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 594
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.AnkiDataRepository$deleteDeck$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object invokeSuspend$lambda$5$safeDelete(com.example.flashcardapp.data.AnkiDataRepository r6, com.example.flashcardapp.data.entities.CardEntity r7, java.lang.String r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            boolean r0 = r9 instanceof com.example.flashcardapp.data.AnkiDataRepository$deleteDeck$2$1$safeDelete$1
            if (r0 == 0) goto L14
            r0 = r9
            com.example.flashcardapp.data.AnkiDataRepository$deleteDeck$2$1$safeDelete$1 r0 = (com.example.flashcardapp.data.AnkiDataRepository$deleteDeck$2$1$safeDelete$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.example.flashcardapp.data.AnkiDataRepository$deleteDeck$2$1$safeDelete$1 r0 = new com.example.flashcardapp.data.AnkiDataRepository$deleteDeck$2$1$safeDelete$1
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
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.AnkiDataRepository$deleteDeck$2.invokeSuspend$lambda$5$safeDelete(com.example.flashcardapp.data.AnkiDataRepository, com.example.flashcardapp.data.entities.CardEntity, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

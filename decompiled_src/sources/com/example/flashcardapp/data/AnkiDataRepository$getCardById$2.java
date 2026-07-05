package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.CardEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnkiDataRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/example/flashcardapp/data/entities/CardEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.data.AnkiDataRepository$getCardById$2", f = "AnkiDataRepository.kt", i = {1}, l = {335, 336}, m = "invokeSuspend", n = {"card"}, s = {"L$0"})
/* loaded from: classes2.dex */
public final class AnkiDataRepository$getCardById$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CardEntity>, Object> {
    final /* synthetic */ long $cardId;
    Object L$0;
    int label;
    final /* synthetic */ AnkiDataRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnkiDataRepository$getCardById$2(AnkiDataRepository ankiDataRepository, long j, Continuation<? super AnkiDataRepository$getCardById$2> continuation) {
        super(2, continuation);
        this.this$0 = ankiDataRepository;
        this.$cardId = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnkiDataRepository$getCardById$2(this.this$0, this.$cardId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CardEntity> continuation) {
        return ((AnkiDataRepository$getCardById$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0061  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            r24 = this;
            r0 = r24
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L29
            if (r2 == r4) goto L23
            if (r2 != r3) goto L1b
            java.lang.Object r1 = r0.L$0
            com.example.flashcardapp.data.entities.CardEntity r1 = (com.example.flashcardapp.data.entities.CardEntity) r1
            kotlin.ResultKt.throwOnFailure(r25)
            r3 = r25
            r4 = r1
            goto L5d
        L1b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L23:
            kotlin.ResultKt.throwOnFailure(r25)
            r2 = r25
            goto L40
        L29:
            kotlin.ResultKt.throwOnFailure(r25)
            com.example.flashcardapp.data.AnkiDataRepository r2 = r0.this$0
            com.example.flashcardapp.data.dao.CardDao r2 = com.example.flashcardapp.data.AnkiDataRepository.access$getCardDao$p(r2)
            long r5 = r0.$cardId
            r7 = r0
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r0.label = r4
            java.lang.Object r2 = r2.getCardById(r5, r7)
            if (r2 != r1) goto L40
            return r1
        L40:
            com.example.flashcardapp.data.entities.CardEntity r2 = (com.example.flashcardapp.data.entities.CardEntity) r2
            if (r2 != 0) goto L46
            r1 = 0
            return r1
        L46:
            com.example.flashcardapp.data.AnkiDataRepository r4 = r0.this$0
            com.example.flashcardapp.data.dao.CardOverrideDao r4 = com.example.flashcardapp.data.AnkiDataRepository.access$getCardOverrideDao$p(r4)
            long r5 = r0.$cardId
            r7 = r0
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r3 = r4.getOverrideForCard(r5, r7)
            if (r3 != r1) goto L5c
            return r1
        L5c:
            r4 = r2
        L5d:
            com.example.flashcardapp.data.entities.CardOverrideEntity r3 = (com.example.flashcardapp.data.entities.CardOverrideEntity) r3
            if (r3 == 0) goto Lb6
            r5 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            java.lang.String r12 = r3.getFrontOverride()
            java.lang.String r13 = r3.getBackOverride()
            java.lang.String r1 = r3.getTagsOverride()
            if (r1 != 0) goto L7a
            java.lang.String r1 = r4.getTags()
        L7a:
            r14 = r1
            r15 = 0
            r16 = 0
            java.lang.String r1 = r3.getFrontImageOverride()
            if (r1 != 0) goto L88
            java.lang.String r1 = r4.getFrontImage()
        L88:
            r18 = r1
            java.lang.String r1 = r3.getBackImageOverride()
            if (r1 != 0) goto L94
            java.lang.String r1 = r4.getBackImage()
        L94:
            r19 = r1
            java.lang.String r1 = r3.getExplanationImageOverride()
            if (r1 != 0) goto La0
            java.lang.String r1 = r4.getExplanationImage()
        La0:
            r20 = r1
            java.lang.String r1 = r3.getOptionImagesOverrideJson()
            if (r1 != 0) goto Lac
            java.lang.String r1 = r4.getOptionImagesJson()
        Lac:
            r21 = r1
            r22 = 399(0x18f, float:5.59E-43)
            r23 = 0
            com.example.flashcardapp.data.entities.CardEntity r4 = com.example.flashcardapp.data.entities.CardEntity.copy$default(r4, r5, r7, r9, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21, r22, r23)
        Lb6:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.AnkiDataRepository$getCardById$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

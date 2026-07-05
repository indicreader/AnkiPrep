package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.CardOverrideEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnkiDataRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.data.AnkiDataRepository$upsertOverride$2", f = "AnkiDataRepository.kt", i = {}, l = {357, 358, 370}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class AnkiDataRepository$upsertOverride$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ CardOverrideEntity $override;
    int label;
    final /* synthetic */ AnkiDataRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnkiDataRepository$upsertOverride$2(AnkiDataRepository ankiDataRepository, CardOverrideEntity cardOverrideEntity, Continuation<? super AnkiDataRepository$upsertOverride$2> continuation) {
        super(2, continuation);
        this.this$0 = ankiDataRepository;
        this.$override = cardOverrideEntity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnkiDataRepository$upsertOverride$2(this.this$0, this.$override, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return ((AnkiDataRepository$upsertOverride$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005e  */
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
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L2a
            if (r2 == r5) goto L26
            if (r2 == r4) goto L20
            if (r2 != r3) goto L18
            kotlin.ResultKt.throwOnFailure(r25)
            goto Lb5
        L18:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L20:
            kotlin.ResultKt.throwOnFailure(r25)
            r2 = r25
            goto L59
        L26:
            kotlin.ResultKt.throwOnFailure(r25)
            goto L41
        L2a:
            kotlin.ResultKt.throwOnFailure(r25)
            com.example.flashcardapp.data.AnkiDataRepository r2 = r0.this$0
            com.example.flashcardapp.data.dao.CardOverrideDao r2 = com.example.flashcardapp.data.AnkiDataRepository.access$getCardOverrideDao$p(r2)
            com.example.flashcardapp.data.entities.CardOverrideEntity r6 = r0.$override
            r7 = r0
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r0.label = r5
            java.lang.Object r2 = r2.upsertOverride(r6, r7)
            if (r2 != r1) goto L41
            return r1
        L41:
            com.example.flashcardapp.data.AnkiDataRepository r2 = r0.this$0
            com.example.flashcardapp.data.dao.CardDao r2 = com.example.flashcardapp.data.AnkiDataRepository.access$getCardDao$p(r2)
            com.example.flashcardapp.data.entities.CardOverrideEntity r5 = r0.$override
            long r5 = r5.getCardId()
            r7 = r0
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r0.label = r4
            java.lang.Object r2 = r2.getCardById(r5, r7)
            if (r2 != r1) goto L59
            return r1
        L59:
            r4 = r2
            com.example.flashcardapp.data.entities.CardEntity r4 = (com.example.flashcardapp.data.entities.CardEntity) r4
            if (r4 == 0) goto Lb5
            r5 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            com.example.flashcardapp.data.entities.CardOverrideEntity r2 = r0.$override
            java.lang.String r12 = r2.getFrontOverride()
            com.example.flashcardapp.data.entities.CardOverrideEntity r2 = r0.$override
            java.lang.String r13 = r2.getBackOverride()
            com.example.flashcardapp.data.entities.CardOverrideEntity r2 = r0.$override
            java.lang.String r2 = r2.getTagsOverride()
            if (r2 != 0) goto L7d
            java.lang.String r2 = r4.getTags()
        L7d:
            r14 = r2
            r15 = 0
            long r16 = java.lang.System.currentTimeMillis()
            com.example.flashcardapp.data.entities.CardOverrideEntity r2 = r0.$override
            java.lang.String r18 = r2.getFrontImageOverride()
            com.example.flashcardapp.data.entities.CardOverrideEntity r2 = r0.$override
            java.lang.String r19 = r2.getBackImageOverride()
            com.example.flashcardapp.data.entities.CardOverrideEntity r2 = r0.$override
            java.lang.String r20 = r2.getExplanationImageOverride()
            com.example.flashcardapp.data.entities.CardOverrideEntity r2 = r0.$override
            java.lang.String r21 = r2.getOptionImagesOverrideJson()
            r22 = 143(0x8f, float:2.0E-43)
            r23 = 0
            com.example.flashcardapp.data.entities.CardEntity r2 = com.example.flashcardapp.data.entities.CardEntity.copy$default(r4, r5, r7, r9, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21, r22, r23)
            com.example.flashcardapp.data.AnkiDataRepository r4 = r0.this$0
            com.example.flashcardapp.data.dao.CardDao r4 = com.example.flashcardapp.data.AnkiDataRepository.access$getCardDao$p(r4)
            r5 = r0
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r0.label = r3
            java.lang.Object r2 = r4.insertCard(r2, r5)
            if (r2 != r1) goto Lb5
            return r1
        Lb5:
            com.example.flashcardapp.data.entities.CardOverrideEntity r1 = r0.$override
            long r1 = r1.getCardId()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Upserted card override and updated card ID: "
            r3.<init>(r4)
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "AnkiDataRepository"
            int r1 = android.util.Log.d(r2, r1)
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.AnkiDataRepository$upsertOverride$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

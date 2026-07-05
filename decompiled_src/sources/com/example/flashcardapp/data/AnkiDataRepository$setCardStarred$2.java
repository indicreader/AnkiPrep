package com.example.flashcardapp.data;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.CardUserMetadataEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnkiDataRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.data.AnkiDataRepository$setCardStarred$2", f = "AnkiDataRepository.kt", i = {}, l = {927, 929}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class AnkiDataRepository$setCardStarred$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ long $cardId;
    final /* synthetic */ boolean $isStarred;
    int label;
    final /* synthetic */ AnkiDataRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnkiDataRepository$setCardStarred$2(AnkiDataRepository ankiDataRepository, long j, boolean z, Continuation<? super AnkiDataRepository$setCardStarred$2> continuation) {
        super(2, continuation);
        this.this$0 = ankiDataRepository;
        this.$cardId = j;
        this.$isStarred = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnkiDataRepository$setCardStarred$2(this.this$0, this.$cardId, this.$isStarred, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return ((AnkiDataRepository$setCardStarred$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CardUserMetadataEntity cardUserMetadataEntity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getCardUserMetadataDao().getMetadataForCard(this.$cardId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Boxing.boxInt(Log.d("AnkiDataRepository", "Updated starred status for card " + this.$cardId + " to " + this.$isStarred));
            }
            ResultKt.throwOnFailure(obj);
        }
        CardUserMetadataEntity cardUserMetadataEntity2 = (CardUserMetadataEntity) obj;
        if (cardUserMetadataEntity2 == null || (cardUserMetadataEntity = CardUserMetadataEntity.copy$default(cardUserMetadataEntity2, 0L, this.$isStarred, 0, 5, null)) == null) {
            cardUserMetadataEntity = new CardUserMetadataEntity(this.$cardId, this.$isStarred, 0, 4, null);
        }
        this.label = 2;
        if (this.this$0.getCardUserMetadataDao().upsertMetadata(cardUserMetadataEntity, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Boxing.boxInt(Log.d("AnkiDataRepository", "Updated starred status for card " + this.$cardId + " to " + this.$isStarred));
    }
}

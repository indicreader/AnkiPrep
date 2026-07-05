package com.example.flashcardapp.data.dao;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.CardStateEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: CardStateDao.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000bJ&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\rH§@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0012\u001a\u00020\u0013H§@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0017J\u001c\u0010\u0018\u001a\u00020\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\bH§@¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/example/flashcardapp/data/dao/CardStateDao;", "", "getCardState", "Lcom/example/flashcardapp/data/entities/CardStateEntity;", "cardId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDueCards", "", "deckId", "nowMillis", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDueCount", "", "getNewCards", "limit", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTotalDueCount", "initializeNewCards", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertState", "state", "(Lcom/example/flashcardapp/data/entities/CardStateEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertStates", "states", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public interface CardStateDao {
    Object getCardState(long j, Continuation<? super CardStateEntity> continuation);

    Object getDueCards(long j, long j2, Continuation<? super List<CardStateEntity>> continuation);

    Object getDueCount(long j, long j2, Continuation<? super Integer> continuation);

    Object getNewCards(long j, int i, Continuation<? super List<CardStateEntity>> continuation);

    Object getTotalDueCount(long j, Continuation<? super Integer> continuation);

    Object initializeNewCards(Continuation<? super Unit> continuation);

    Object upsertState(CardStateEntity cardStateEntity, Continuation<? super Unit> continuation);

    Object upsertStates(List<CardStateEntity> list, Continuation<? super Unit> continuation);

    /* compiled from: CardStateDao.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getNewCards$default(CardStateDao cardStateDao, long j, int i, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNewCards");
            }
            if ((i2 & 2) != 0) {
                i = 20;
            }
            return cardStateDao.getNewCards(j, i, continuation);
        }
    }
}

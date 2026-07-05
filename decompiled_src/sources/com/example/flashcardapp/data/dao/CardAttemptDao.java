package com.example.flashcardapp.data.dao;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.CardAttemptEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: CardAttemptDao.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH§@¢\u0006\u0002\u0010\u0004J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\r\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH§@¢\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00152\u0006\u0010\u0016\u001a\u00020\u0007H'¨\u0006\u0017"}, d2 = {"Lcom/example/flashcardapp/data/dao/CardAttemptDao;", "", "deleteAllAttempts", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAttemptsForDeck", "deckId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAttempts", "", "Lcom/example/flashcardapp/data/entities/CardAttemptEntity;", "getAttemptsForCard", "cardId", "insertAttempt", "attempt", "(Lcom/example/flashcardapp/data/entities/CardAttemptEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAttempts", "attempts", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeAttemptsSince", "Lkotlinx/coroutines/flow/Flow;", "sinceTimestamp", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public interface CardAttemptDao {
    Object deleteAllAttempts(Continuation<? super Unit> continuation);

    Object deleteAttemptsForDeck(long j, Continuation<? super Unit> continuation);

    Object getAllAttempts(Continuation<? super List<CardAttemptEntity>> continuation);

    Object getAttemptsForCard(long j, Continuation<? super List<CardAttemptEntity>> continuation);

    Object insertAttempt(CardAttemptEntity cardAttemptEntity, Continuation<? super Long> continuation);

    Object insertAttempts(List<CardAttemptEntity> list, Continuation<? super Unit> continuation);

    Flow<List<CardAttemptEntity>> observeAttemptsSince(long sinceTimestamp);
}

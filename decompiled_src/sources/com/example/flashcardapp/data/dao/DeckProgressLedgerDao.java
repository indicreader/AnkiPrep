package com.example.flashcardapp.data.dao;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.DeckProgressLedger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: DeckProgressLedgerDao.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH§@¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/example/flashcardapp/data/dao/DeckProgressLedgerDao;", "", "clearProgressForDeck", "", "deckId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAttemptedCardIds", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAttemptedCardIdsForDeck", "getAttemptedCountForDeck", "", "insert", "ledger", "Lcom/example/flashcardapp/data/entities/DeckProgressLedger;", "(Lcom/example/flashcardapp/data/entities/DeckProgressLedger;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public interface DeckProgressLedgerDao {
    Object clearProgressForDeck(long j, Continuation<? super Unit> continuation);

    Object getAllAttemptedCardIds(Continuation<? super List<Long>> continuation);

    Object getAttemptedCardIdsForDeck(long j, Continuation<? super List<Long>> continuation);

    Object getAttemptedCountForDeck(long j, Continuation<? super Integer> continuation);

    Object insert(DeckProgressLedger deckProgressLedger, Continuation<? super Unit> continuation);
}

package com.example.flashcardapp.data.dao;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.DeckEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: DeckDao.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH'J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH§@¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u0010H§@¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH§@¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0013\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ\u0016\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\fH§@¢\u0006\u0002\u0010\u0016J\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH§@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\fH§@¢\u0006\u0002\u0010\u0016J\u001c\u0010\u001b\u001a\u00020\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH§@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\fH§@¢\u0006\u0002\u0010\u0016J\u001c\u0010\u001d\u001a\u00020\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH§@¢\u0006\u0002\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/example/flashcardapp/data/dao/DeckDao;", "", "deleteAllDecks", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDeck", "deckId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllDecks", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/flashcardapp/data/entities/DeckEntity;", "getAllDecksOnce", "getDeckById", "getDeckCount", "", "getRootDecks", "getSubDecks", "parentId", "insertDeckIgnore", "deck", "(Lcom/example/flashcardapp/data/entities/DeckEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertDecksIgnore", "decks", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDeck", "updateDecks", "upsertDeck", "upsertDecks", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public interface DeckDao {
    Object deleteAllDecks(Continuation<? super Unit> continuation);

    Object deleteDeck(long j, Continuation<? super Unit> continuation);

    Flow<List<DeckEntity>> getAllDecks();

    Object getAllDecksOnce(Continuation<? super List<DeckEntity>> continuation);

    Object getDeckById(long j, Continuation<? super DeckEntity> continuation);

    Object getDeckCount(Continuation<? super Integer> continuation);

    Object getRootDecks(Continuation<? super List<DeckEntity>> continuation);

    Object getSubDecks(long j, Continuation<? super List<DeckEntity>> continuation);

    Object insertDeckIgnore(DeckEntity deckEntity, Continuation<? super Long> continuation);

    Object insertDecksIgnore(List<DeckEntity> list, Continuation<? super List<Long>> continuation);

    Object updateDeck(DeckEntity deckEntity, Continuation<? super Unit> continuation);

    Object updateDecks(List<DeckEntity> list, Continuation<? super Unit> continuation);

    Object upsertDeck(DeckEntity deckEntity, Continuation<? super Unit> continuation);

    Object upsertDecks(List<DeckEntity> list, Continuation<? super Unit> continuation);
}

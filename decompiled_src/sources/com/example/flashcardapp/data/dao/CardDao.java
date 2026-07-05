package com.example.flashcardapp.data.dao;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.CardEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: CardDao.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H§@¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0015\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00182\u0006\u0010\u0010\u001a\u00020\u0007H'J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0010\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u000eJ$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u001f\u001a\u00020\u0003H§@¢\u0006\u0002\u0010 J&\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\"J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u0003H§@¢\u0006\u0002\u0010 J\u0016\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0013H§@¢\u0006\u0002\u0010&J\"\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H§@¢\u0006\u0002\u0010)J\u0016\u0010*\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0013H§@¢\u0006\u0002\u0010&J\u001c\u0010+\u001a\u00020\n2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H§@¢\u0006\u0002\u0010)J&\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0005H§@¢\u0006\u0002\u00100J\u001e\u00101\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0005H§@¢\u0006\u0002\u00102J\u001c\u00103\u001a\u00020\n2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H§@¢\u0006\u0002\u0010)¨\u00064"}, d2 = {"Lcom/example/flashcardapp/data/dao/CardDao;", "", "countImageReferences", "", "imagePath", "", "excludeCardId", "", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllCards", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCard", "cardId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCardsForDeck", "deckId", "getAllCardsOnce", "", "Lcom/example/flashcardapp/data/entities/CardEntity;", "getCardById", "getCardCount", "getCardCountForDeck", "getCardsForDeck", "Lkotlinx/coroutines/flow/Flow;", "getCardsForDeckOnce", "getCardsForRootHierarchyOnce", "rootPath", "rootPathPrefix", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRandomCardsOnce", "limit", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSampleCards", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSampleCardsGlobal", "insertCard", "card", "(Lcom/example/flashcardapp/data/entities/CardEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertCardsIgnore", "cards", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCard", "updateCards", "updateCardsDeckAndHierarchy", "oldDeckId", "newDeckId", "newHierarchy", "(JJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCardsHierarchyForDeck", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertCards", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public interface CardDao {
    Object countImageReferences(String str, long j, Continuation<? super Integer> continuation);

    Object deleteAllCards(Continuation<? super Unit> continuation);

    Object deleteCard(long j, Continuation<? super Unit> continuation);

    Object deleteCardsForDeck(long j, Continuation<? super Unit> continuation);

    Object getAllCardsOnce(Continuation<? super List<CardEntity>> continuation);

    Object getCardById(long j, Continuation<? super CardEntity> continuation);

    Object getCardCount(Continuation<? super Integer> continuation);

    Object getCardCountForDeck(long j, Continuation<? super Integer> continuation);

    Flow<List<CardEntity>> getCardsForDeck(long deckId);

    Object getCardsForDeckOnce(long j, Continuation<? super List<CardEntity>> continuation);

    Object getCardsForRootHierarchyOnce(String str, String str2, Continuation<? super List<CardEntity>> continuation);

    Object getRandomCardsOnce(int i, Continuation<? super List<CardEntity>> continuation);

    Object getSampleCards(long j, int i, Continuation<? super List<CardEntity>> continuation);

    Object getSampleCardsGlobal(int i, Continuation<? super List<CardEntity>> continuation);

    Object insertCard(CardEntity cardEntity, Continuation<? super Long> continuation);

    Object insertCardsIgnore(List<CardEntity> list, Continuation<? super List<Long>> continuation);

    Object updateCard(CardEntity cardEntity, Continuation<? super Unit> continuation);

    Object updateCards(List<CardEntity> list, Continuation<? super Unit> continuation);

    Object updateCardsDeckAndHierarchy(long j, long j2, String str, Continuation<? super Unit> continuation);

    Object updateCardsHierarchyForDeck(long j, String str, Continuation<? super Unit> continuation);

    Object upsertCards(List<CardEntity> list, Continuation<? super Unit> continuation);

    /* compiled from: CardDao.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getSampleCards$default(CardDao cardDao, long j, int i, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSampleCards");
            }
            if ((i2 & 2) != 0) {
                i = 5;
            }
            return cardDao.getSampleCards(j, i, continuation);
        }

        public static /* synthetic */ Object getSampleCardsGlobal$default(CardDao cardDao, int i, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSampleCardsGlobal");
            }
            if ((i2 & 1) != 0) {
                i = 5;
            }
            return cardDao.getSampleCardsGlobal(i, continuation);
        }
    }
}

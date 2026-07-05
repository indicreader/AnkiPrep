package com.example.flashcardapp.data.dao;

import android.database.Cursor;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.flashcardapp.data.entities.CardEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: CardDao_Impl.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001BB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u001dJ\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070!H\u0096@¢\u0006\u0002\u0010\u001aJ\u0018\u0010\"\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u001dJ\u000e\u0010#\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u001aJ\u0016\u0010$\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u001dJ\u001c\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070!0&2\u0006\u0010\u001f\u001a\u00020\u0016H\u0016J\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070!2\u0006\u0010\u001f\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u001dJ$\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070!2\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010+J\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070!2\u0006\u0010-\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010.J$\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070!2\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u00100J\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\u00070!2\u0006\u0010-\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010.J\u0016\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u00104J\"\u00105\u001a\b\u0012\u0004\u0012\u00020\u00160!2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00070!H\u0096@¢\u0006\u0002\u00107J\u0016\u00108\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u00104J\u001c\u00109\u001a\u00020\u00192\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00070!H\u0096@¢\u0006\u0002\u00107J&\u0010:\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u00162\u0006\u0010<\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010>J\u001e\u0010?\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010@J\u001c\u0010A\u001a\u00020\u00192\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00070!H\u0096@¢\u0006\u0002\u00107R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/example/flashcardapp/data/dao/CardDao_Impl;", "Lcom/example/flashcardapp/data/dao/CardDao;", "__db", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;)V", "__insertionAdapterOfCardEntity", "Landroidx/room/EntityInsertionAdapter;", "Lcom/example/flashcardapp/data/entities/CardEntity;", "__insertionAdapterOfCardEntity_1", "__preparedStmtOfDeleteAllCards", "Landroidx/room/SharedSQLiteStatement;", "__preparedStmtOfDeleteCard", "__preparedStmtOfDeleteCardsForDeck", "__preparedStmtOfUpdateCardsDeckAndHierarchy", "__preparedStmtOfUpdateCardsHierarchyForDeck", "__updateAdapterOfCardEntity", "Landroidx/room/EntityDeletionOrUpdateAdapter;", "countImageReferences", "", "imagePath", "", "excludeCardId", "", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllCards", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCard", "cardId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCardsForDeck", "deckId", "getAllCardsOnce", "", "getCardById", "getCardCount", "getCardCountForDeck", "getCardsForDeck", "Lkotlinx/coroutines/flow/Flow;", "getCardsForDeckOnce", "getCardsForRootHierarchyOnce", "rootPath", "rootPathPrefix", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRandomCardsOnce", "limit", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSampleCards", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSampleCardsGlobal", "insertCard", "card", "(Lcom/example/flashcardapp/data/entities/CardEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertCardsIgnore", "cards", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCard", "updateCards", "updateCardsDeckAndHierarchy", "oldDeckId", "newDeckId", "newHierarchy", "(JJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCardsHierarchyForDeck", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertCards", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class CardDao_Impl implements CardDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<CardEntity> __insertionAdapterOfCardEntity;
    private final EntityInsertionAdapter<CardEntity> __insertionAdapterOfCardEntity_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllCards;
    private final SharedSQLiteStatement __preparedStmtOfDeleteCard;
    private final SharedSQLiteStatement __preparedStmtOfDeleteCardsForDeck;
    private final SharedSQLiteStatement __preparedStmtOfUpdateCardsDeckAndHierarchy;
    private final SharedSQLiteStatement __preparedStmtOfUpdateCardsHierarchyForDeck;
    private final EntityDeletionOrUpdateAdapter<CardEntity> __updateAdapterOfCardEntity;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final List<Class<?>> getRequiredConverters() {
        return INSTANCE.getRequiredConverters();
    }

    public CardDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertionAdapterOfCardEntity = new EntityInsertionAdapter<CardEntity>(__db) { // from class: com.example.flashcardapp.data.dao.CardDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `cards` (`id`,`noteId`,`deckId`,`subDeckId`,`front`,`back`,`tags`,`deckHierarchy`,`lastSyncTimestamp`,`frontImage`,`backImage`,`explanationImage`,`optionImagesJson`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement statement, CardEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getId());
                statement.bindLong(2, entity.getNoteId());
                statement.bindLong(3, entity.getDeckId());
                Long subDeckId = entity.getSubDeckId();
                if (subDeckId == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindLong(4, subDeckId.longValue());
                }
                statement.bindString(5, entity.getFront());
                statement.bindString(6, entity.getBack());
                statement.bindString(7, entity.getTags());
                statement.bindString(8, entity.getDeckHierarchy());
                statement.bindLong(9, entity.getLastSyncTimestamp());
                String frontImage = entity.getFrontImage();
                if (frontImage == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, frontImage);
                }
                String backImage = entity.getBackImage();
                if (backImage == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, backImage);
                }
                String explanationImage = entity.getExplanationImage();
                if (explanationImage == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, explanationImage);
                }
                String optionImagesJson = entity.getOptionImagesJson();
                if (optionImagesJson == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, optionImagesJson);
                }
            }
        };
        this.__insertionAdapterOfCardEntity_1 = new EntityInsertionAdapter<CardEntity>(__db) { // from class: com.example.flashcardapp.data.dao.CardDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR IGNORE INTO `cards` (`id`,`noteId`,`deckId`,`subDeckId`,`front`,`back`,`tags`,`deckHierarchy`,`lastSyncTimestamp`,`frontImage`,`backImage`,`explanationImage`,`optionImagesJson`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement statement, CardEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getId());
                statement.bindLong(2, entity.getNoteId());
                statement.bindLong(3, entity.getDeckId());
                Long subDeckId = entity.getSubDeckId();
                if (subDeckId == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindLong(4, subDeckId.longValue());
                }
                statement.bindString(5, entity.getFront());
                statement.bindString(6, entity.getBack());
                statement.bindString(7, entity.getTags());
                statement.bindString(8, entity.getDeckHierarchy());
                statement.bindLong(9, entity.getLastSyncTimestamp());
                String frontImage = entity.getFrontImage();
                if (frontImage == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, frontImage);
                }
                String backImage = entity.getBackImage();
                if (backImage == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, backImage);
                }
                String explanationImage = entity.getExplanationImage();
                if (explanationImage == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, explanationImage);
                }
                String optionImagesJson = entity.getOptionImagesJson();
                if (optionImagesJson == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, optionImagesJson);
                }
            }
        };
        this.__updateAdapterOfCardEntity = new EntityDeletionOrUpdateAdapter<CardEntity>(__db) { // from class: com.example.flashcardapp.data.dao.CardDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `cards` SET `id` = ?,`noteId` = ?,`deckId` = ?,`subDeckId` = ?,`front` = ?,`back` = ?,`tags` = ?,`deckHierarchy` = ?,`lastSyncTimestamp` = ?,`frontImage` = ?,`backImage` = ?,`explanationImage` = ?,`optionImagesJson` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement statement, CardEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getId());
                statement.bindLong(2, entity.getNoteId());
                statement.bindLong(3, entity.getDeckId());
                Long subDeckId = entity.getSubDeckId();
                if (subDeckId == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindLong(4, subDeckId.longValue());
                }
                statement.bindString(5, entity.getFront());
                statement.bindString(6, entity.getBack());
                statement.bindString(7, entity.getTags());
                statement.bindString(8, entity.getDeckHierarchy());
                statement.bindLong(9, entity.getLastSyncTimestamp());
                String frontImage = entity.getFrontImage();
                if (frontImage == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, frontImage);
                }
                String backImage = entity.getBackImage();
                if (backImage == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, backImage);
                }
                String explanationImage = entity.getExplanationImage();
                if (explanationImage == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, explanationImage);
                }
                String optionImagesJson = entity.getOptionImagesJson();
                if (optionImagesJson == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, optionImagesJson);
                }
                statement.bindLong(14, entity.getId());
            }
        };
        this.__preparedStmtOfUpdateCardsDeckAndHierarchy = new SharedSQLiteStatement(__db) { // from class: com.example.flashcardapp.data.dao.CardDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE cards SET deckId = ?, deckHierarchy = ? WHERE deckId = ?";
            }
        };
        this.__preparedStmtOfUpdateCardsHierarchyForDeck = new SharedSQLiteStatement(__db) { // from class: com.example.flashcardapp.data.dao.CardDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE cards SET deckHierarchy = ? WHERE deckId = ?";
            }
        };
        this.__preparedStmtOfDeleteCard = new SharedSQLiteStatement(__db) { // from class: com.example.flashcardapp.data.dao.CardDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM cards WHERE id = ?";
            }
        };
        this.__preparedStmtOfDeleteCardsForDeck = new SharedSQLiteStatement(__db) { // from class: com.example.flashcardapp.data.dao.CardDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM cards WHERE deckId = ?";
            }
        };
        this.__preparedStmtOfDeleteAllCards = new SharedSQLiteStatement(__db) { // from class: com.example.flashcardapp.data.dao.CardDao_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM cards";
            }
        };
    }

    @Override // com.example.flashcardapp.data.dao.CardDao
    public Object upsertCards(final List<CardEntity> list, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.CardDao_Impl$upsertCards$2
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Unit call() {
                call2();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: call, reason: avoid collision after fix types in other method */
            public void call2() {
                RoomDatabase roomDatabase;
                RoomDatabase roomDatabase2;
                EntityInsertionAdapter entityInsertionAdapter;
                RoomDatabase roomDatabase3;
                roomDatabase = CardDao_Impl.this.__db;
                roomDatabase.beginTransaction();
                try {
                    entityInsertionAdapter = CardDao_Impl.this.__insertionAdapterOfCardEntity;
                    entityInsertionAdapter.insert((Iterable) list);
                    roomDatabase3 = CardDao_Impl.this.__db;
                    roomDatabase3.setTransactionSuccessful();
                } finally {
                    roomDatabase2 = CardDao_Impl.this.__db;
                    roomDatabase2.endTransaction();
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.CardDao
    public Object insertCardsIgnore(final List<CardEntity> list, Continuation<? super List<Long>> continuation) {
        return CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<List<? extends Long>>() { // from class: com.example.flashcardapp.data.dao.CardDao_Impl$insertCardsIgnore$2
            @Override // java.util.concurrent.Callable
            public List<? extends Long> call() {
                RoomDatabase roomDatabase;
                RoomDatabase roomDatabase2;
                EntityInsertionAdapter entityInsertionAdapter;
                RoomDatabase roomDatabase3;
                roomDatabase = CardDao_Impl.this.__db;
                roomDatabase.beginTransaction();
                try {
                    entityInsertionAdapter = CardDao_Impl.this.__insertionAdapterOfCardEntity_1;
                    List<Long> insertAndReturnIdsList = entityInsertionAdapter.insertAndReturnIdsList(list);
                    roomDatabase3 = CardDao_Impl.this.__db;
                    roomDatabase3.setTransactionSuccessful();
                    return insertAndReturnIdsList;
                } finally {
                    roomDatabase2 = CardDao_Impl.this.__db;
                    roomDatabase2.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.CardDao
    public Object insertCard(final CardEntity cardEntity, Continuation<? super Long> continuation) {
        return CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Long>() { // from class: com.example.flashcardapp.data.dao.CardDao_Impl$insertCard$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Long call() {
                RoomDatabase roomDatabase;
                RoomDatabase roomDatabase2;
                EntityInsertionAdapter entityInsertionAdapter;
                RoomDatabase roomDatabase3;
                roomDatabase = CardDao_Impl.this.__db;
                roomDatabase.beginTransaction();
                try {
                    entityInsertionAdapter = CardDao_Impl.this.__insertionAdapterOfCardEntity;
                    long insertAndReturnId = entityInsertionAdapter.insertAndReturnId(cardEntity);
                    roomDatabase3 = CardDao_Impl.this.__db;
                    roomDatabase3.setTransactionSuccessful();
                    return Long.valueOf(insertAndReturnId);
                } finally {
                    roomDatabase2 = CardDao_Impl.this.__db;
                    roomDatabase2.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.CardDao
    public Object updateCards(final List<CardEntity> list, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.CardDao_Impl$updateCards$2
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Unit call() {
                call2();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: call, reason: avoid collision after fix types in other method */
            public void call2() {
                RoomDatabase roomDatabase;
                RoomDatabase roomDatabase2;
                EntityDeletionOrUpdateAdapter entityDeletionOrUpdateAdapter;
                RoomDatabase roomDatabase3;
                roomDatabase = CardDao_Impl.this.__db;
                roomDatabase.beginTransaction();
                try {
                    entityDeletionOrUpdateAdapter = CardDao_Impl.this.__updateAdapterOfCardEntity;
                    entityDeletionOrUpdateAdapter.handleMultiple(list);
                    roomDatabase3 = CardDao_Impl.this.__db;
                    roomDatabase3.setTransactionSuccessful();
                } finally {
                    roomDatabase2 = CardDao_Impl.this.__db;
                    roomDatabase2.endTransaction();
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.CardDao
    public Object updateCard(final CardEntity cardEntity, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.CardDao_Impl$updateCard$2
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Unit call() {
                call2();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: call, reason: avoid collision after fix types in other method */
            public void call2() {
                RoomDatabase roomDatabase;
                RoomDatabase roomDatabase2;
                EntityDeletionOrUpdateAdapter entityDeletionOrUpdateAdapter;
                RoomDatabase roomDatabase3;
                roomDatabase = CardDao_Impl.this.__db;
                roomDatabase.beginTransaction();
                try {
                    entityDeletionOrUpdateAdapter = CardDao_Impl.this.__updateAdapterOfCardEntity;
                    entityDeletionOrUpdateAdapter.handle(cardEntity);
                    roomDatabase3 = CardDao_Impl.this.__db;
                    roomDatabase3.setTransactionSuccessful();
                } finally {
                    roomDatabase2 = CardDao_Impl.this.__db;
                    roomDatabase2.endTransaction();
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.CardDao
    public Object updateCardsDeckAndHierarchy(final long j, final long j2, final String str, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.CardDao_Impl$updateCardsDeckAndHierarchy$2
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Unit call() {
                call2();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: call, reason: avoid collision after fix types in other method */
            public void call2() {
                SharedSQLiteStatement sharedSQLiteStatement;
                SharedSQLiteStatement sharedSQLiteStatement2;
                RoomDatabase roomDatabase;
                RoomDatabase roomDatabase2;
                RoomDatabase roomDatabase3;
                sharedSQLiteStatement = CardDao_Impl.this.__preparedStmtOfUpdateCardsDeckAndHierarchy;
                SupportSQLiteStatement acquire = sharedSQLiteStatement.acquire();
                acquire.bindLong(1, j2);
                acquire.bindString(2, str);
                acquire.bindLong(3, j);
                try {
                    roomDatabase = CardDao_Impl.this.__db;
                    roomDatabase.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        roomDatabase3 = CardDao_Impl.this.__db;
                        roomDatabase3.setTransactionSuccessful();
                    } finally {
                        roomDatabase2 = CardDao_Impl.this.__db;
                        roomDatabase2.endTransaction();
                    }
                } finally {
                    sharedSQLiteStatement2 = CardDao_Impl.this.__preparedStmtOfUpdateCardsDeckAndHierarchy;
                    sharedSQLiteStatement2.release(acquire);
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.CardDao
    public Object updateCardsHierarchyForDeck(final long j, final String str, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.CardDao_Impl$updateCardsHierarchyForDeck$2
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Unit call() {
                call2();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: call, reason: avoid collision after fix types in other method */
            public void call2() {
                SharedSQLiteStatement sharedSQLiteStatement;
                SharedSQLiteStatement sharedSQLiteStatement2;
                RoomDatabase roomDatabase;
                RoomDatabase roomDatabase2;
                RoomDatabase roomDatabase3;
                sharedSQLiteStatement = CardDao_Impl.this.__preparedStmtOfUpdateCardsHierarchyForDeck;
                SupportSQLiteStatement acquire = sharedSQLiteStatement.acquire();
                acquire.bindString(1, str);
                acquire.bindLong(2, j);
                try {
                    roomDatabase = CardDao_Impl.this.__db;
                    roomDatabase.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        roomDatabase3 = CardDao_Impl.this.__db;
                        roomDatabase3.setTransactionSuccessful();
                    } finally {
                        roomDatabase2 = CardDao_Impl.this.__db;
                        roomDatabase2.endTransaction();
                    }
                } finally {
                    sharedSQLiteStatement2 = CardDao_Impl.this.__preparedStmtOfUpdateCardsHierarchyForDeck;
                    sharedSQLiteStatement2.release(acquire);
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.CardDao
    public Object deleteCard(final long j, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.CardDao_Impl$deleteCard$2
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Unit call() {
                call2();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: call, reason: avoid collision after fix types in other method */
            public void call2() {
                SharedSQLiteStatement sharedSQLiteStatement;
                SharedSQLiteStatement sharedSQLiteStatement2;
                RoomDatabase roomDatabase;
                RoomDatabase roomDatabase2;
                RoomDatabase roomDatabase3;
                sharedSQLiteStatement = CardDao_Impl.this.__preparedStmtOfDeleteCard;
                SupportSQLiteStatement acquire = sharedSQLiteStatement.acquire();
                acquire.bindLong(1, j);
                try {
                    roomDatabase = CardDao_Impl.this.__db;
                    roomDatabase.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        roomDatabase3 = CardDao_Impl.this.__db;
                        roomDatabase3.setTransactionSuccessful();
                    } finally {
                        roomDatabase2 = CardDao_Impl.this.__db;
                        roomDatabase2.endTransaction();
                    }
                } finally {
                    sharedSQLiteStatement2 = CardDao_Impl.this.__preparedStmtOfDeleteCard;
                    sharedSQLiteStatement2.release(acquire);
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.CardDao
    public Object deleteCardsForDeck(final long j, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.CardDao_Impl$deleteCardsForDeck$2
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Unit call() {
                call2();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: call, reason: avoid collision after fix types in other method */
            public void call2() {
                SharedSQLiteStatement sharedSQLiteStatement;
                SharedSQLiteStatement sharedSQLiteStatement2;
                RoomDatabase roomDatabase;
                RoomDatabase roomDatabase2;
                RoomDatabase roomDatabase3;
                sharedSQLiteStatement = CardDao_Impl.this.__preparedStmtOfDeleteCardsForDeck;
                SupportSQLiteStatement acquire = sharedSQLiteStatement.acquire();
                acquire.bindLong(1, j);
                try {
                    roomDatabase = CardDao_Impl.this.__db;
                    roomDatabase.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        roomDatabase3 = CardDao_Impl.this.__db;
                        roomDatabase3.setTransactionSuccessful();
                    } finally {
                        roomDatabase2 = CardDao_Impl.this.__db;
                        roomDatabase2.endTransaction();
                    }
                } finally {
                    sharedSQLiteStatement2 = CardDao_Impl.this.__preparedStmtOfDeleteCardsForDeck;
                    sharedSQLiteStatement2.release(acquire);
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.CardDao
    public Object deleteAllCards(Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.CardDao_Impl$deleteAllCards$2
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Unit call() {
                call2();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: call, reason: avoid collision after fix types in other method */
            public void call2() {
                SharedSQLiteStatement sharedSQLiteStatement;
                SharedSQLiteStatement sharedSQLiteStatement2;
                RoomDatabase roomDatabase;
                RoomDatabase roomDatabase2;
                RoomDatabase roomDatabase3;
                sharedSQLiteStatement = CardDao_Impl.this.__preparedStmtOfDeleteAllCards;
                SupportSQLiteStatement acquire = sharedSQLiteStatement.acquire();
                try {
                    roomDatabase = CardDao_Impl.this.__db;
                    roomDatabase.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        roomDatabase3 = CardDao_Impl.this.__db;
                        roomDatabase3.setTransactionSuccessful();
                    } finally {
                        roomDatabase2 = CardDao_Impl.this.__db;
                        roomDatabase2.endTransaction();
                    }
                } finally {
                    sharedSQLiteStatement2 = CardDao_Impl.this.__preparedStmtOfDeleteAllCards;
                    sharedSQLiteStatement2.release(acquire);
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.CardDao
    public Flow<List<CardEntity>> getCardsForDeck(long deckId) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM cards WHERE deckId = ? ORDER BY id ASC", 1);
        acquire.bindLong(1, deckId);
        return CoroutinesRoom.INSTANCE.createFlow(this.__db, false, new String[]{"cards"}, new Callable<List<? extends CardEntity>>() { // from class: com.example.flashcardapp.data.dao.CardDao_Impl$getCardsForDeck$1
            @Override // java.util.concurrent.Callable
            public List<? extends CardEntity> call() {
                RoomDatabase roomDatabase;
                int i;
                String string;
                String str = "getString(...)";
                roomDatabase = CardDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "noteId");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "deckId");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "subDeckId");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "front");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "back");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "tags");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "deckHierarchy");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "lastSyncTimestamp");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "frontImage");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backImage");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "explanationImage");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "optionImagesJson");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j = query.getLong(columnIndexOrThrow);
                        long j2 = query.getLong(columnIndexOrThrow2);
                        long j3 = query.getLong(columnIndexOrThrow3);
                        Long valueOf = query.isNull(columnIndexOrThrow4) ? null : Long.valueOf(query.getLong(columnIndexOrThrow4));
                        String string2 = query.getString(columnIndexOrThrow5);
                        Intrinsics.checkNotNullExpressionValue(string2, str);
                        int i2 = columnIndexOrThrow;
                        String string3 = query.getString(columnIndexOrThrow6);
                        Intrinsics.checkNotNullExpressionValue(string3, str);
                        int i3 = columnIndexOrThrow2;
                        String string4 = query.getString(columnIndexOrThrow7);
                        Intrinsics.checkNotNullExpressionValue(string4, str);
                        int i4 = columnIndexOrThrow3;
                        String string5 = query.getString(columnIndexOrThrow8);
                        Intrinsics.checkNotNullExpressionValue(string5, str);
                        long j4 = query.getLong(columnIndexOrThrow9);
                        String string6 = query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10);
                        String string7 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                        String string8 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                        int i5 = columnIndexOrThrow13;
                        String str2 = str;
                        if (query.isNull(i5)) {
                            i = i5;
                            string = null;
                        } else {
                            i = i5;
                            string = query.getString(i5);
                        }
                        arrayList.add(new CardEntity(j, j2, j3, valueOf, string2, string3, string4, string5, j4, string6, string7, string8, string));
                        str = str2;
                        columnIndexOrThrow = i2;
                        columnIndexOrThrow2 = i3;
                        columnIndexOrThrow3 = i4;
                        columnIndexOrThrow13 = i;
                    }
                    return arrayList;
                } finally {
                    query.close();
                }
            }

            protected final void finalize() {
                acquire.release();
            }
        });
    }

    @Override // com.example.flashcardapp.data.dao.CardDao
    public Object getCardsForDeckOnce(long j, Continuation<? super List<CardEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM cards WHERE deckId = ? ORDER BY id ASC", 1);
        acquire.bindLong(1, j);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends CardEntity>>() { // from class: com.example.flashcardapp.data.dao.CardDao_Impl$getCardsForDeckOnce$2
            @Override // java.util.concurrent.Callable
            public List<? extends CardEntity> call() {
                RoomDatabase roomDatabase;
                CardDao_Impl$getCardsForDeckOnce$2 cardDao_Impl$getCardsForDeckOnce$2;
                int columnIndexOrThrow;
                int columnIndexOrThrow2;
                int columnIndexOrThrow3;
                int columnIndexOrThrow4;
                int columnIndexOrThrow5;
                int columnIndexOrThrow6;
                int columnIndexOrThrow7;
                int columnIndexOrThrow8;
                int columnIndexOrThrow9;
                int columnIndexOrThrow10;
                int columnIndexOrThrow11;
                int columnIndexOrThrow12;
                int i;
                String string;
                String str = "getString(...)";
                roomDatabase = CardDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "noteId");
                    columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "deckId");
                    columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "subDeckId");
                    columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "front");
                    columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "back");
                    columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "tags");
                    columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "deckHierarchy");
                    columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "lastSyncTimestamp");
                    columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "frontImage");
                    columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backImage");
                    columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "explanationImage");
                } catch (Throwable th) {
                    th = th;
                    cardDao_Impl$getCardsForDeckOnce$2 = this;
                }
                try {
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "optionImagesJson");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j2 = query.getLong(columnIndexOrThrow);
                        long j3 = query.getLong(columnIndexOrThrow2);
                        long j4 = query.getLong(columnIndexOrThrow3);
                        Long valueOf = query.isNull(columnIndexOrThrow4) ? null : Long.valueOf(query.getLong(columnIndexOrThrow4));
                        String string2 = query.getString(columnIndexOrThrow5);
                        Intrinsics.checkNotNullExpressionValue(string2, str);
                        int i2 = columnIndexOrThrow;
                        String string3 = query.getString(columnIndexOrThrow6);
                        Intrinsics.checkNotNullExpressionValue(string3, str);
                        int i3 = columnIndexOrThrow2;
                        String string4 = query.getString(columnIndexOrThrow7);
                        Intrinsics.checkNotNullExpressionValue(string4, str);
                        int i4 = columnIndexOrThrow3;
                        String string5 = query.getString(columnIndexOrThrow8);
                        Intrinsics.checkNotNullExpressionValue(string5, str);
                        long j5 = query.getLong(columnIndexOrThrow9);
                        String string6 = query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10);
                        String string7 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                        String string8 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                        int i5 = columnIndexOrThrow13;
                        String str2 = str;
                        if (query.isNull(i5)) {
                            i = i5;
                            string = null;
                        } else {
                            i = i5;
                            string = query.getString(i5);
                        }
                        arrayList.add(new CardEntity(j2, j3, j4, valueOf, string2, string3, string4, string5, j5, string6, string7, string8, string));
                        str = str2;
                        columnIndexOrThrow = i2;
                        columnIndexOrThrow2 = i3;
                        columnIndexOrThrow3 = i4;
                        columnIndexOrThrow13 = i;
                    }
                    query.close();
                    acquire.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    cardDao_Impl$getCardsForDeckOnce$2 = this;
                    query.close();
                    acquire.release();
                    throw th;
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.CardDao
    public Object getCardsForRootHierarchyOnce(String str, String str2, Continuation<? super List<CardEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM cards WHERE deckHierarchy = ? OR deckHierarchy LIKE ?", 2);
        acquire.bindString(1, str);
        acquire.bindString(2, str2);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends CardEntity>>() { // from class: com.example.flashcardapp.data.dao.CardDao_Impl$getCardsForRootHierarchyOnce$2
            @Override // java.util.concurrent.Callable
            public List<? extends CardEntity> call() {
                RoomDatabase roomDatabase;
                CardDao_Impl$getCardsForRootHierarchyOnce$2 cardDao_Impl$getCardsForRootHierarchyOnce$2;
                int columnIndexOrThrow;
                int columnIndexOrThrow2;
                int columnIndexOrThrow3;
                int columnIndexOrThrow4;
                int columnIndexOrThrow5;
                int columnIndexOrThrow6;
                int columnIndexOrThrow7;
                int columnIndexOrThrow8;
                int columnIndexOrThrow9;
                int columnIndexOrThrow10;
                int columnIndexOrThrow11;
                int columnIndexOrThrow12;
                int i;
                String string;
                String str3 = "getString(...)";
                roomDatabase = CardDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "noteId");
                    columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "deckId");
                    columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "subDeckId");
                    columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "front");
                    columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "back");
                    columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "tags");
                    columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "deckHierarchy");
                    columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "lastSyncTimestamp");
                    columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "frontImage");
                    columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backImage");
                    columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "explanationImage");
                } catch (Throwable th) {
                    th = th;
                    cardDao_Impl$getCardsForRootHierarchyOnce$2 = this;
                }
                try {
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "optionImagesJson");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j = query.getLong(columnIndexOrThrow);
                        long j2 = query.getLong(columnIndexOrThrow2);
                        long j3 = query.getLong(columnIndexOrThrow3);
                        Long valueOf = query.isNull(columnIndexOrThrow4) ? null : Long.valueOf(query.getLong(columnIndexOrThrow4));
                        String string2 = query.getString(columnIndexOrThrow5);
                        Intrinsics.checkNotNullExpressionValue(string2, str3);
                        int i2 = columnIndexOrThrow;
                        String string3 = query.getString(columnIndexOrThrow6);
                        Intrinsics.checkNotNullExpressionValue(string3, str3);
                        int i3 = columnIndexOrThrow2;
                        String string4 = query.getString(columnIndexOrThrow7);
                        Intrinsics.checkNotNullExpressionValue(string4, str3);
                        int i4 = columnIndexOrThrow3;
                        String string5 = query.getString(columnIndexOrThrow8);
                        Intrinsics.checkNotNullExpressionValue(string5, str3);
                        long j4 = query.getLong(columnIndexOrThrow9);
                        String string6 = query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10);
                        String string7 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                        String string8 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                        int i5 = columnIndexOrThrow13;
                        String str4 = str3;
                        if (query.isNull(i5)) {
                            i = i5;
                            string = null;
                        } else {
                            i = i5;
                            string = query.getString(i5);
                        }
                        arrayList.add(new CardEntity(j, j2, j3, valueOf, string2, string3, string4, string5, j4, string6, string7, string8, string));
                        str3 = str4;
                        columnIndexOrThrow = i2;
                        columnIndexOrThrow2 = i3;
                        columnIndexOrThrow3 = i4;
                        columnIndexOrThrow13 = i;
                    }
                    query.close();
                    acquire.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    cardDao_Impl$getCardsForRootHierarchyOnce$2 = this;
                    query.close();
                    acquire.release();
                    throw th;
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.CardDao
    public Object getRandomCardsOnce(int i, Continuation<? super List<CardEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM cards ORDER BY RANDOM() LIMIT ?", 1);
        acquire.bindLong(1, i);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends CardEntity>>() { // from class: com.example.flashcardapp.data.dao.CardDao_Impl$getRandomCardsOnce$2
            @Override // java.util.concurrent.Callable
            public List<? extends CardEntity> call() {
                RoomDatabase roomDatabase;
                CardDao_Impl$getRandomCardsOnce$2 cardDao_Impl$getRandomCardsOnce$2;
                int columnIndexOrThrow;
                int columnIndexOrThrow2;
                int columnIndexOrThrow3;
                int columnIndexOrThrow4;
                int columnIndexOrThrow5;
                int columnIndexOrThrow6;
                int columnIndexOrThrow7;
                int columnIndexOrThrow8;
                int columnIndexOrThrow9;
                int columnIndexOrThrow10;
                int columnIndexOrThrow11;
                int columnIndexOrThrow12;
                int i2;
                String string;
                String str = "getString(...)";
                roomDatabase = CardDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "noteId");
                    columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "deckId");
                    columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "subDeckId");
                    columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "front");
                    columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "back");
                    columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "tags");
                    columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "deckHierarchy");
                    columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "lastSyncTimestamp");
                    columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "frontImage");
                    columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backImage");
                    columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "explanationImage");
                } catch (Throwable th) {
                    th = th;
                    cardDao_Impl$getRandomCardsOnce$2 = this;
                }
                try {
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "optionImagesJson");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j = query.getLong(columnIndexOrThrow);
                        long j2 = query.getLong(columnIndexOrThrow2);
                        long j3 = query.getLong(columnIndexOrThrow3);
                        Long valueOf = query.isNull(columnIndexOrThrow4) ? null : Long.valueOf(query.getLong(columnIndexOrThrow4));
                        String string2 = query.getString(columnIndexOrThrow5);
                        Intrinsics.checkNotNullExpressionValue(string2, str);
                        int i3 = columnIndexOrThrow;
                        String string3 = query.getString(columnIndexOrThrow6);
                        Intrinsics.checkNotNullExpressionValue(string3, str);
                        int i4 = columnIndexOrThrow2;
                        String string4 = query.getString(columnIndexOrThrow7);
                        Intrinsics.checkNotNullExpressionValue(string4, str);
                        int i5 = columnIndexOrThrow3;
                        String string5 = query.getString(columnIndexOrThrow8);
                        Intrinsics.checkNotNullExpressionValue(string5, str);
                        long j4 = query.getLong(columnIndexOrThrow9);
                        String string6 = query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10);
                        String string7 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                        String string8 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                        int i6 = columnIndexOrThrow13;
                        String str2 = str;
                        if (query.isNull(i6)) {
                            i2 = i6;
                            string = null;
                        } else {
                            i2 = i6;
                            string = query.getString(i6);
                        }
                        arrayList.add(new CardEntity(j, j2, j3, valueOf, string2, string3, string4, string5, j4, string6, string7, string8, string));
                        str = str2;
                        columnIndexOrThrow = i3;
                        columnIndexOrThrow2 = i4;
                        columnIndexOrThrow3 = i5;
                        columnIndexOrThrow13 = i2;
                    }
                    query.close();
                    acquire.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    cardDao_Impl$getRandomCardsOnce$2 = this;
                    query.close();
                    acquire.release();
                    throw th;
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.CardDao
    public Object getAllCardsOnce(Continuation<? super List<CardEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM cards ORDER BY id ASC", 0);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends CardEntity>>() { // from class: com.example.flashcardapp.data.dao.CardDao_Impl$getAllCardsOnce$2
            @Override // java.util.concurrent.Callable
            public List<? extends CardEntity> call() {
                RoomDatabase roomDatabase;
                CardDao_Impl$getAllCardsOnce$2 cardDao_Impl$getAllCardsOnce$2;
                int columnIndexOrThrow;
                int columnIndexOrThrow2;
                int columnIndexOrThrow3;
                int columnIndexOrThrow4;
                int columnIndexOrThrow5;
                int columnIndexOrThrow6;
                int columnIndexOrThrow7;
                int columnIndexOrThrow8;
                int columnIndexOrThrow9;
                int columnIndexOrThrow10;
                int columnIndexOrThrow11;
                int columnIndexOrThrow12;
                int i;
                String string;
                String str = "getString(...)";
                roomDatabase = CardDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "noteId");
                    columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "deckId");
                    columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "subDeckId");
                    columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "front");
                    columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "back");
                    columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "tags");
                    columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "deckHierarchy");
                    columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "lastSyncTimestamp");
                    columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "frontImage");
                    columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backImage");
                    columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "explanationImage");
                } catch (Throwable th) {
                    th = th;
                    cardDao_Impl$getAllCardsOnce$2 = this;
                }
                try {
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "optionImagesJson");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j = query.getLong(columnIndexOrThrow);
                        long j2 = query.getLong(columnIndexOrThrow2);
                        long j3 = query.getLong(columnIndexOrThrow3);
                        Long valueOf = query.isNull(columnIndexOrThrow4) ? null : Long.valueOf(query.getLong(columnIndexOrThrow4));
                        String string2 = query.getString(columnIndexOrThrow5);
                        Intrinsics.checkNotNullExpressionValue(string2, str);
                        int i2 = columnIndexOrThrow;
                        String string3 = query.getString(columnIndexOrThrow6);
                        Intrinsics.checkNotNullExpressionValue(string3, str);
                        int i3 = columnIndexOrThrow2;
                        String string4 = query.getString(columnIndexOrThrow7);
                        Intrinsics.checkNotNullExpressionValue(string4, str);
                        int i4 = columnIndexOrThrow3;
                        String string5 = query.getString(columnIndexOrThrow8);
                        Intrinsics.checkNotNullExpressionValue(string5, str);
                        long j4 = query.getLong(columnIndexOrThrow9);
                        String string6 = query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10);
                        String string7 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                        String string8 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                        int i5 = columnIndexOrThrow13;
                        String str2 = str;
                        if (query.isNull(i5)) {
                            i = i5;
                            string = null;
                        } else {
                            i = i5;
                            string = query.getString(i5);
                        }
                        arrayList.add(new CardEntity(j, j2, j3, valueOf, string2, string3, string4, string5, j4, string6, string7, string8, string));
                        str = str2;
                        columnIndexOrThrow = i2;
                        columnIndexOrThrow2 = i3;
                        columnIndexOrThrow3 = i4;
                        columnIndexOrThrow13 = i;
                    }
                    query.close();
                    acquire.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    cardDao_Impl$getAllCardsOnce$2 = this;
                    query.close();
                    acquire.release();
                    throw th;
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.CardDao
    public Object getCardById(long j, Continuation<? super CardEntity> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM cards WHERE id = ?", 1);
        acquire.bindLong(1, j);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<CardEntity>() { // from class: com.example.flashcardapp.data.dao.CardDao_Impl$getCardById$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public CardEntity call() {
                RoomDatabase roomDatabase;
                CardEntity cardEntity;
                roomDatabase = CardDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "noteId");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "deckId");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "subDeckId");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "front");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "back");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "tags");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "deckHierarchy");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "lastSyncTimestamp");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "frontImage");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backImage");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "explanationImage");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "optionImagesJson");
                    if (query.moveToFirst()) {
                        long j2 = query.getLong(columnIndexOrThrow);
                        long j3 = query.getLong(columnIndexOrThrow2);
                        long j4 = query.getLong(columnIndexOrThrow3);
                        Long valueOf = query.isNull(columnIndexOrThrow4) ? null : Long.valueOf(query.getLong(columnIndexOrThrow4));
                        String string = query.getString(columnIndexOrThrow5);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        String string2 = query.getString(columnIndexOrThrow6);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        String string3 = query.getString(columnIndexOrThrow7);
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                        String string4 = query.getString(columnIndexOrThrow8);
                        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                        cardEntity = new CardEntity(j2, j3, j4, valueOf, string, string2, string3, string4, query.getLong(columnIndexOrThrow9), query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10), query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11), query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12), query.isNull(columnIndexOrThrow13) ? null : query.getString(columnIndexOrThrow13));
                    } else {
                        cardEntity = null;
                    }
                    return cardEntity;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.CardDao
    public Object getSampleCards(long j, int i, Continuation<? super List<CardEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM cards WHERE deckId = ? LIMIT ?", 2);
        acquire.bindLong(1, j);
        acquire.bindLong(2, i);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends CardEntity>>() { // from class: com.example.flashcardapp.data.dao.CardDao_Impl$getSampleCards$2
            @Override // java.util.concurrent.Callable
            public List<? extends CardEntity> call() {
                RoomDatabase roomDatabase;
                CardDao_Impl$getSampleCards$2 cardDao_Impl$getSampleCards$2;
                int columnIndexOrThrow;
                int columnIndexOrThrow2;
                int columnIndexOrThrow3;
                int columnIndexOrThrow4;
                int columnIndexOrThrow5;
                int columnIndexOrThrow6;
                int columnIndexOrThrow7;
                int columnIndexOrThrow8;
                int columnIndexOrThrow9;
                int columnIndexOrThrow10;
                int columnIndexOrThrow11;
                int columnIndexOrThrow12;
                int i2;
                String string;
                String str = "getString(...)";
                roomDatabase = CardDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "noteId");
                    columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "deckId");
                    columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "subDeckId");
                    columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "front");
                    columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "back");
                    columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "tags");
                    columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "deckHierarchy");
                    columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "lastSyncTimestamp");
                    columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "frontImage");
                    columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backImage");
                    columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "explanationImage");
                } catch (Throwable th) {
                    th = th;
                    cardDao_Impl$getSampleCards$2 = this;
                }
                try {
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "optionImagesJson");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j2 = query.getLong(columnIndexOrThrow);
                        long j3 = query.getLong(columnIndexOrThrow2);
                        long j4 = query.getLong(columnIndexOrThrow3);
                        Long valueOf = query.isNull(columnIndexOrThrow4) ? null : Long.valueOf(query.getLong(columnIndexOrThrow4));
                        String string2 = query.getString(columnIndexOrThrow5);
                        Intrinsics.checkNotNullExpressionValue(string2, str);
                        int i3 = columnIndexOrThrow;
                        String string3 = query.getString(columnIndexOrThrow6);
                        Intrinsics.checkNotNullExpressionValue(string3, str);
                        int i4 = columnIndexOrThrow2;
                        String string4 = query.getString(columnIndexOrThrow7);
                        Intrinsics.checkNotNullExpressionValue(string4, str);
                        int i5 = columnIndexOrThrow3;
                        String string5 = query.getString(columnIndexOrThrow8);
                        Intrinsics.checkNotNullExpressionValue(string5, str);
                        long j5 = query.getLong(columnIndexOrThrow9);
                        String string6 = query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10);
                        String string7 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                        String string8 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                        int i6 = columnIndexOrThrow13;
                        String str2 = str;
                        if (query.isNull(i6)) {
                            i2 = i6;
                            string = null;
                        } else {
                            i2 = i6;
                            string = query.getString(i6);
                        }
                        arrayList.add(new CardEntity(j2, j3, j4, valueOf, string2, string3, string4, string5, j5, string6, string7, string8, string));
                        str = str2;
                        columnIndexOrThrow = i3;
                        columnIndexOrThrow2 = i4;
                        columnIndexOrThrow3 = i5;
                        columnIndexOrThrow13 = i2;
                    }
                    query.close();
                    acquire.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    cardDao_Impl$getSampleCards$2 = this;
                    query.close();
                    acquire.release();
                    throw th;
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.CardDao
    public Object getSampleCardsGlobal(int i, Continuation<? super List<CardEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM cards LIMIT ?", 1);
        acquire.bindLong(1, i);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends CardEntity>>() { // from class: com.example.flashcardapp.data.dao.CardDao_Impl$getSampleCardsGlobal$2
            @Override // java.util.concurrent.Callable
            public List<? extends CardEntity> call() {
                RoomDatabase roomDatabase;
                CardDao_Impl$getSampleCardsGlobal$2 cardDao_Impl$getSampleCardsGlobal$2;
                int columnIndexOrThrow;
                int columnIndexOrThrow2;
                int columnIndexOrThrow3;
                int columnIndexOrThrow4;
                int columnIndexOrThrow5;
                int columnIndexOrThrow6;
                int columnIndexOrThrow7;
                int columnIndexOrThrow8;
                int columnIndexOrThrow9;
                int columnIndexOrThrow10;
                int columnIndexOrThrow11;
                int columnIndexOrThrow12;
                int i2;
                String string;
                String str = "getString(...)";
                roomDatabase = CardDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "noteId");
                    columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "deckId");
                    columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "subDeckId");
                    columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "front");
                    columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "back");
                    columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "tags");
                    columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "deckHierarchy");
                    columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "lastSyncTimestamp");
                    columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "frontImage");
                    columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backImage");
                    columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "explanationImage");
                } catch (Throwable th) {
                    th = th;
                    cardDao_Impl$getSampleCardsGlobal$2 = this;
                }
                try {
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "optionImagesJson");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j = query.getLong(columnIndexOrThrow);
                        long j2 = query.getLong(columnIndexOrThrow2);
                        long j3 = query.getLong(columnIndexOrThrow3);
                        Long valueOf = query.isNull(columnIndexOrThrow4) ? null : Long.valueOf(query.getLong(columnIndexOrThrow4));
                        String string2 = query.getString(columnIndexOrThrow5);
                        Intrinsics.checkNotNullExpressionValue(string2, str);
                        int i3 = columnIndexOrThrow;
                        String string3 = query.getString(columnIndexOrThrow6);
                        Intrinsics.checkNotNullExpressionValue(string3, str);
                        int i4 = columnIndexOrThrow2;
                        String string4 = query.getString(columnIndexOrThrow7);
                        Intrinsics.checkNotNullExpressionValue(string4, str);
                        int i5 = columnIndexOrThrow3;
                        String string5 = query.getString(columnIndexOrThrow8);
                        Intrinsics.checkNotNullExpressionValue(string5, str);
                        long j4 = query.getLong(columnIndexOrThrow9);
                        String string6 = query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10);
                        String string7 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                        String string8 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                        int i6 = columnIndexOrThrow13;
                        String str2 = str;
                        if (query.isNull(i6)) {
                            i2 = i6;
                            string = null;
                        } else {
                            i2 = i6;
                            string = query.getString(i6);
                        }
                        arrayList.add(new CardEntity(j, j2, j3, valueOf, string2, string3, string4, string5, j4, string6, string7, string8, string));
                        str = str2;
                        columnIndexOrThrow = i3;
                        columnIndexOrThrow2 = i4;
                        columnIndexOrThrow3 = i5;
                        columnIndexOrThrow13 = i2;
                    }
                    query.close();
                    acquire.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    cardDao_Impl$getSampleCardsGlobal$2 = this;
                    query.close();
                    acquire.release();
                    throw th;
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.CardDao
    public Object getCardCount(Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT COUNT(*) FROM cards", 0);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<Integer>() { // from class: com.example.flashcardapp.data.dao.CardDao_Impl$getCardCount$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() {
                RoomDatabase roomDatabase;
                roomDatabase = CardDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    return Integer.valueOf(query.moveToFirst() ? query.getInt(0) : 0);
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.CardDao
    public Object getCardCountForDeck(long j, Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT COUNT(*) FROM cards WHERE deckId = ?", 1);
        acquire.bindLong(1, j);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<Integer>() { // from class: com.example.flashcardapp.data.dao.CardDao_Impl$getCardCountForDeck$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() {
                RoomDatabase roomDatabase;
                roomDatabase = CardDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    return Integer.valueOf(query.moveToFirst() ? query.getInt(0) : 0);
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.CardDao
    public Object countImageReferences(String str, long j, Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT COUNT(*) FROM cards WHERE (frontImage = ? OR backImage = ? OR explanationImage = ? OR optionImagesJson LIKE '%' || ? || '%') AND id != ?", 5);
        acquire.bindString(1, str);
        acquire.bindString(2, str);
        acquire.bindString(3, str);
        acquire.bindString(4, str);
        acquire.bindLong(5, j);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<Integer>() { // from class: com.example.flashcardapp.data.dao.CardDao_Impl$countImageReferences$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() {
                RoomDatabase roomDatabase;
                roomDatabase = CardDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    return Integer.valueOf(query.moveToFirst() ? query.getInt(0) : 0);
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    /* compiled from: CardDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/example/flashcardapp/data/dao/CardDao_Impl$Companion;", "", "()V", "getRequiredConverters", "", "Ljava/lang/Class;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final List<Class<?>> getRequiredConverters() {
            return CollectionsKt.emptyList();
        }
    }
}

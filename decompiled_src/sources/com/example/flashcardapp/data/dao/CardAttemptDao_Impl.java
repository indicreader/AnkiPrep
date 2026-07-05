package com.example.flashcardapp.data.dao;

import android.database.Cursor;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.flashcardapp.data.entities.CardAttemptEntity;
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

/* compiled from: CardAttemptDao_Impl.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0096@¢\u0006\u0002\u0010\rJ\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00132\u0006\u0010\u0015\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u0018J\u001c\u0010\u0019\u001a\u00020\f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0096@¢\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00130\u001d2\u0006\u0010\u001e\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/example/flashcardapp/data/dao/CardAttemptDao_Impl;", "Lcom/example/flashcardapp/data/dao/CardAttemptDao;", "__db", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;)V", "__insertionAdapterOfCardAttemptEntity", "Landroidx/room/EntityInsertionAdapter;", "Lcom/example/flashcardapp/data/entities/CardAttemptEntity;", "__preparedStmtOfDeleteAllAttempts", "Landroidx/room/SharedSQLiteStatement;", "__preparedStmtOfDeleteAttemptsForDeck", "deleteAllAttempts", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAttemptsForDeck", "deckId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAttempts", "", "getAttemptsForCard", "cardId", "insertAttempt", "attempt", "(Lcom/example/flashcardapp/data/entities/CardAttemptEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAttempts", "attempts", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeAttemptsSince", "Lkotlinx/coroutines/flow/Flow;", "sinceTimestamp", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class CardAttemptDao_Impl implements CardAttemptDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<CardAttemptEntity> __insertionAdapterOfCardAttemptEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllAttempts;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAttemptsForDeck;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final List<Class<?>> getRequiredConverters() {
        return INSTANCE.getRequiredConverters();
    }

    public CardAttemptDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertionAdapterOfCardAttemptEntity = new EntityInsertionAdapter<CardAttemptEntity>(__db) { // from class: com.example.flashcardapp.data.dao.CardAttemptDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `card_attempts` (`id`,`cardId`,`deckId`,`isCorrect`,`timeTakenMs`,`fsrsRating`,`timestamp`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement statement, CardAttemptEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getId());
                statement.bindLong(2, entity.getCardId());
                statement.bindLong(3, entity.getDeckId());
                statement.bindLong(4, entity.isCorrect() ? 1L : 0L);
                statement.bindLong(5, entity.getTimeTakenMs());
                statement.bindLong(6, entity.getFsrsRating());
                statement.bindLong(7, entity.getTimestamp());
            }
        };
        this.__preparedStmtOfDeleteAttemptsForDeck = new SharedSQLiteStatement(__db) { // from class: com.example.flashcardapp.data.dao.CardAttemptDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM card_attempts WHERE cardId IN (SELECT id FROM cards WHERE deckId = ?)";
            }
        };
        this.__preparedStmtOfDeleteAllAttempts = new SharedSQLiteStatement(__db) { // from class: com.example.flashcardapp.data.dao.CardAttemptDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM card_attempts";
            }
        };
    }

    @Override // com.example.flashcardapp.data.dao.CardAttemptDao
    public Object insertAttempt(final CardAttemptEntity cardAttemptEntity, Continuation<? super Long> continuation) {
        return CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Long>() { // from class: com.example.flashcardapp.data.dao.CardAttemptDao_Impl$insertAttempt$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Long call() {
                RoomDatabase roomDatabase;
                RoomDatabase roomDatabase2;
                EntityInsertionAdapter entityInsertionAdapter;
                RoomDatabase roomDatabase3;
                roomDatabase = CardAttemptDao_Impl.this.__db;
                roomDatabase.beginTransaction();
                try {
                    entityInsertionAdapter = CardAttemptDao_Impl.this.__insertionAdapterOfCardAttemptEntity;
                    long insertAndReturnId = entityInsertionAdapter.insertAndReturnId(cardAttemptEntity);
                    roomDatabase3 = CardAttemptDao_Impl.this.__db;
                    roomDatabase3.setTransactionSuccessful();
                    return Long.valueOf(insertAndReturnId);
                } finally {
                    roomDatabase2 = CardAttemptDao_Impl.this.__db;
                    roomDatabase2.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.CardAttemptDao
    public Object insertAttempts(final List<CardAttemptEntity> list, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.CardAttemptDao_Impl$insertAttempts$2
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
                roomDatabase = CardAttemptDao_Impl.this.__db;
                roomDatabase.beginTransaction();
                try {
                    entityInsertionAdapter = CardAttemptDao_Impl.this.__insertionAdapterOfCardAttemptEntity;
                    entityInsertionAdapter.insert((Iterable) list);
                    roomDatabase3 = CardAttemptDao_Impl.this.__db;
                    roomDatabase3.setTransactionSuccessful();
                } finally {
                    roomDatabase2 = CardAttemptDao_Impl.this.__db;
                    roomDatabase2.endTransaction();
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.CardAttemptDao
    public Object deleteAttemptsForDeck(final long j, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.CardAttemptDao_Impl$deleteAttemptsForDeck$2
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
                sharedSQLiteStatement = CardAttemptDao_Impl.this.__preparedStmtOfDeleteAttemptsForDeck;
                SupportSQLiteStatement acquire = sharedSQLiteStatement.acquire();
                acquire.bindLong(1, j);
                try {
                    roomDatabase = CardAttemptDao_Impl.this.__db;
                    roomDatabase.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        roomDatabase3 = CardAttemptDao_Impl.this.__db;
                        roomDatabase3.setTransactionSuccessful();
                    } finally {
                        roomDatabase2 = CardAttemptDao_Impl.this.__db;
                        roomDatabase2.endTransaction();
                    }
                } finally {
                    sharedSQLiteStatement2 = CardAttemptDao_Impl.this.__preparedStmtOfDeleteAttemptsForDeck;
                    sharedSQLiteStatement2.release(acquire);
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.CardAttemptDao
    public Object deleteAllAttempts(Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.CardAttemptDao_Impl$deleteAllAttempts$2
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
                sharedSQLiteStatement = CardAttemptDao_Impl.this.__preparedStmtOfDeleteAllAttempts;
                SupportSQLiteStatement acquire = sharedSQLiteStatement.acquire();
                try {
                    roomDatabase = CardAttemptDao_Impl.this.__db;
                    roomDatabase.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        roomDatabase3 = CardAttemptDao_Impl.this.__db;
                        roomDatabase3.setTransactionSuccessful();
                    } finally {
                        roomDatabase2 = CardAttemptDao_Impl.this.__db;
                        roomDatabase2.endTransaction();
                    }
                } finally {
                    sharedSQLiteStatement2 = CardAttemptDao_Impl.this.__preparedStmtOfDeleteAllAttempts;
                    sharedSQLiteStatement2.release(acquire);
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.CardAttemptDao
    public Object getAttemptsForCard(long j, Continuation<? super List<CardAttemptEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM card_attempts WHERE cardId = ? ORDER BY timestamp DESC", 1);
        acquire.bindLong(1, j);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends CardAttemptEntity>>() { // from class: com.example.flashcardapp.data.dao.CardAttemptDao_Impl$getAttemptsForCard$2
            @Override // java.util.concurrent.Callable
            public List<? extends CardAttemptEntity> call() {
                RoomDatabase roomDatabase;
                roomDatabase = CardAttemptDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "cardId");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "deckId");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "isCorrect");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "timeTakenMs");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "fsrsRating");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new CardAttemptEntity(query.getLong(columnIndexOrThrow), query.getLong(columnIndexOrThrow2), query.getLong(columnIndexOrThrow3), query.getInt(columnIndexOrThrow4) != 0, query.getLong(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6), query.getLong(columnIndexOrThrow7)));
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.CardAttemptDao
    public Object getAllAttempts(Continuation<? super List<CardAttemptEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM card_attempts ORDER BY timestamp DESC", 0);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends CardAttemptEntity>>() { // from class: com.example.flashcardapp.data.dao.CardAttemptDao_Impl$getAllAttempts$2
            @Override // java.util.concurrent.Callable
            public List<? extends CardAttemptEntity> call() {
                RoomDatabase roomDatabase;
                roomDatabase = CardAttemptDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "cardId");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "deckId");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "isCorrect");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "timeTakenMs");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "fsrsRating");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new CardAttemptEntity(query.getLong(columnIndexOrThrow), query.getLong(columnIndexOrThrow2), query.getLong(columnIndexOrThrow3), query.getInt(columnIndexOrThrow4) != 0, query.getLong(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6), query.getLong(columnIndexOrThrow7)));
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.CardAttemptDao
    public Flow<List<CardAttemptEntity>> observeAttemptsSince(long sinceTimestamp) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM card_attempts WHERE timestamp >= ? ORDER BY timestamp DESC", 1);
        acquire.bindLong(1, sinceTimestamp);
        return CoroutinesRoom.INSTANCE.createFlow(this.__db, false, new String[]{"card_attempts"}, new Callable<List<? extends CardAttemptEntity>>() { // from class: com.example.flashcardapp.data.dao.CardAttemptDao_Impl$observeAttemptsSince$1
            @Override // java.util.concurrent.Callable
            public List<? extends CardAttemptEntity> call() {
                RoomDatabase roomDatabase;
                roomDatabase = CardAttemptDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "cardId");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "deckId");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "isCorrect");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "timeTakenMs");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "fsrsRating");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new CardAttemptEntity(query.getLong(columnIndexOrThrow), query.getLong(columnIndexOrThrow2), query.getLong(columnIndexOrThrow3), query.getInt(columnIndexOrThrow4) != 0, query.getLong(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6), query.getLong(columnIndexOrThrow7)));
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

    /* compiled from: CardAttemptDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/example/flashcardapp/data/dao/CardAttemptDao_Impl$Companion;", "", "()V", "getRequiredConverters", "", "Ljava/lang/Class;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
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

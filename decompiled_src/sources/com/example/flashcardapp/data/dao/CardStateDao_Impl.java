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
import com.example.flashcardapp.data.entities.CardStateEntity;
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

/* compiled from: CardStateDao_Impl.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u0012J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ\u000e\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u001eJ\u001c\u0010\u001f\u001a\u00020\u001a2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0096@¢\u0006\u0002\u0010!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/example/flashcardapp/data/dao/CardStateDao_Impl;", "Lcom/example/flashcardapp/data/dao/CardStateDao;", "__db", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;)V", "__insertionAdapterOfCardStateEntity", "Landroidx/room/EntityInsertionAdapter;", "Lcom/example/flashcardapp/data/entities/CardStateEntity;", "__preparedStmtOfInitializeNewCards", "Landroidx/room/SharedSQLiteStatement;", "getCardState", "cardId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDueCards", "", "deckId", "nowMillis", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDueCount", "", "getNewCards", "limit", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTotalDueCount", "initializeNewCards", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertState", "state", "(Lcom/example/flashcardapp/data/entities/CardStateEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertStates", "states", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class CardStateDao_Impl implements CardStateDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<CardStateEntity> __insertionAdapterOfCardStateEntity;
    private final SharedSQLiteStatement __preparedStmtOfInitializeNewCards;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final List<Class<?>> getRequiredConverters() {
        return INSTANCE.getRequiredConverters();
    }

    public CardStateDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertionAdapterOfCardStateEntity = new EntityInsertionAdapter<CardStateEntity>(__db) { // from class: com.example.flashcardapp.data.dao.CardStateDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `card_states` (`cardId`,`stability`,`difficulty`,`interval`,`dueDate`,`lastReview`,`reviewCount`,`lapses`,`state`,`retrievability`,`retrievabilityTimestamp`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement statement, CardStateEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getCardId());
                statement.bindDouble(2, entity.getStability());
                statement.bindDouble(3, entity.getDifficulty());
                statement.bindLong(4, entity.getInterval());
                statement.bindLong(5, entity.getDueDate());
                statement.bindLong(6, entity.getLastReview());
                statement.bindLong(7, entity.getReviewCount());
                statement.bindLong(8, entity.getLapses());
                statement.bindLong(9, entity.getState());
                statement.bindDouble(10, entity.getRetrievability());
                statement.bindLong(11, entity.getRetrievabilityTimestamp());
            }
        };
        this.__preparedStmtOfInitializeNewCards = new SharedSQLiteStatement(__db) { // from class: com.example.flashcardapp.data.dao.CardStateDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "\n        INSERT OR IGNORE INTO card_states (cardId, stability, difficulty, interval, dueDate, lastReview, reviewCount, lapses, state)\n        SELECT id, 2.5, 5.0, 0, 0, 0, 0, 0, 0 FROM cards\n        WHERE id NOT IN (SELECT cardId FROM card_states)\n    ";
            }
        };
    }

    @Override // com.example.flashcardapp.data.dao.CardStateDao
    public Object upsertState(final CardStateEntity cardStateEntity, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.CardStateDao_Impl$upsertState$2
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
                roomDatabase = CardStateDao_Impl.this.__db;
                roomDatabase.beginTransaction();
                try {
                    entityInsertionAdapter = CardStateDao_Impl.this.__insertionAdapterOfCardStateEntity;
                    entityInsertionAdapter.insert((EntityInsertionAdapter) cardStateEntity);
                    roomDatabase3 = CardStateDao_Impl.this.__db;
                    roomDatabase3.setTransactionSuccessful();
                } finally {
                    roomDatabase2 = CardStateDao_Impl.this.__db;
                    roomDatabase2.endTransaction();
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.CardStateDao
    public Object upsertStates(final List<CardStateEntity> list, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.CardStateDao_Impl$upsertStates$2
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
                roomDatabase = CardStateDao_Impl.this.__db;
                roomDatabase.beginTransaction();
                try {
                    entityInsertionAdapter = CardStateDao_Impl.this.__insertionAdapterOfCardStateEntity;
                    entityInsertionAdapter.insert((Iterable) list);
                    roomDatabase3 = CardStateDao_Impl.this.__db;
                    roomDatabase3.setTransactionSuccessful();
                } finally {
                    roomDatabase2 = CardStateDao_Impl.this.__db;
                    roomDatabase2.endTransaction();
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.CardStateDao
    public Object initializeNewCards(Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.CardStateDao_Impl$initializeNewCards$2
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
                sharedSQLiteStatement = CardStateDao_Impl.this.__preparedStmtOfInitializeNewCards;
                SupportSQLiteStatement acquire = sharedSQLiteStatement.acquire();
                try {
                    roomDatabase = CardStateDao_Impl.this.__db;
                    roomDatabase.beginTransaction();
                    try {
                        acquire.executeInsert();
                        roomDatabase3 = CardStateDao_Impl.this.__db;
                        roomDatabase3.setTransactionSuccessful();
                    } finally {
                        roomDatabase2 = CardStateDao_Impl.this.__db;
                        roomDatabase2.endTransaction();
                    }
                } finally {
                    sharedSQLiteStatement2 = CardStateDao_Impl.this.__preparedStmtOfInitializeNewCards;
                    sharedSQLiteStatement2.release(acquire);
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.CardStateDao
    public Object getDueCards(long j, long j2, Continuation<? super List<CardStateEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("\n        SELECT cs.* FROM card_states cs\n        INNER JOIN cards c ON cs.cardId = c.id\n        WHERE c.deckId = ? AND cs.dueDate <= ? AND cs.state > 0\n        ORDER BY cs.dueDate ASC\n    ", 2);
        acquire.bindLong(1, j);
        acquire.bindLong(2, j2);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends CardStateEntity>>() { // from class: com.example.flashcardapp.data.dao.CardStateDao_Impl$getDueCards$2
            @Override // java.util.concurrent.Callable
            public List<? extends CardStateEntity> call() {
                RoomDatabase roomDatabase;
                roomDatabase = CardStateDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "cardId");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "stability");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "difficulty");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "interval");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "dueDate");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "lastReview");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "reviewCount");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "lapses");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "state");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "retrievability");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "retrievabilityTimestamp");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new CardStateEntity(query.getLong(columnIndexOrThrow), query.getDouble(columnIndexOrThrow2), query.getDouble(columnIndexOrThrow3), query.getInt(columnIndexOrThrow4), query.getLong(columnIndexOrThrow5), query.getLong(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7), query.getInt(columnIndexOrThrow8), query.getInt(columnIndexOrThrow9), query.getDouble(columnIndexOrThrow10), query.getLong(columnIndexOrThrow11)));
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.CardStateDao
    public Object getNewCards(long j, int i, Continuation<? super List<CardStateEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("\n        SELECT cs.* FROM card_states cs\n        INNER JOIN cards c ON cs.cardId = c.id\n        WHERE c.deckId = ? AND cs.state = 0\n        ORDER BY cs.cardId ASC\n        LIMIT ?\n    ", 2);
        acquire.bindLong(1, j);
        acquire.bindLong(2, i);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends CardStateEntity>>() { // from class: com.example.flashcardapp.data.dao.CardStateDao_Impl$getNewCards$2
            @Override // java.util.concurrent.Callable
            public List<? extends CardStateEntity> call() {
                RoomDatabase roomDatabase;
                roomDatabase = CardStateDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "cardId");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "stability");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "difficulty");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "interval");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "dueDate");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "lastReview");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "reviewCount");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "lapses");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "state");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "retrievability");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "retrievabilityTimestamp");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new CardStateEntity(query.getLong(columnIndexOrThrow), query.getDouble(columnIndexOrThrow2), query.getDouble(columnIndexOrThrow3), query.getInt(columnIndexOrThrow4), query.getLong(columnIndexOrThrow5), query.getLong(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7), query.getInt(columnIndexOrThrow8), query.getInt(columnIndexOrThrow9), query.getDouble(columnIndexOrThrow10), query.getLong(columnIndexOrThrow11)));
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.CardStateDao
    public Object getDueCount(long j, long j2, Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("\n        SELECT COUNT(*) FROM card_states cs\n        INNER JOIN cards c ON cs.cardId = c.id\n        WHERE c.deckId = ? AND cs.dueDate <= ? AND cs.state > 0\n    ", 2);
        acquire.bindLong(1, j);
        acquire.bindLong(2, j2);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<Integer>() { // from class: com.example.flashcardapp.data.dao.CardStateDao_Impl$getDueCount$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() {
                RoomDatabase roomDatabase;
                roomDatabase = CardStateDao_Impl.this.__db;
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

    @Override // com.example.flashcardapp.data.dao.CardStateDao
    public Object getTotalDueCount(long j, Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT COUNT(*) FROM card_states WHERE dueDate <= ? AND state > 0", 1);
        acquire.bindLong(1, j);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<Integer>() { // from class: com.example.flashcardapp.data.dao.CardStateDao_Impl$getTotalDueCount$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() {
                RoomDatabase roomDatabase;
                roomDatabase = CardStateDao_Impl.this.__db;
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

    @Override // com.example.flashcardapp.data.dao.CardStateDao
    public Object getCardState(long j, Continuation<? super CardStateEntity> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM card_states WHERE cardId = ?", 1);
        acquire.bindLong(1, j);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<CardStateEntity>() { // from class: com.example.flashcardapp.data.dao.CardStateDao_Impl$getCardState$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public CardStateEntity call() {
                RoomDatabase roomDatabase;
                roomDatabase = CardStateDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    return query.moveToFirst() ? new CardStateEntity(query.getLong(CursorUtil.getColumnIndexOrThrow(query, "cardId")), query.getDouble(CursorUtil.getColumnIndexOrThrow(query, "stability")), query.getDouble(CursorUtil.getColumnIndexOrThrow(query, "difficulty")), query.getInt(CursorUtil.getColumnIndexOrThrow(query, "interval")), query.getLong(CursorUtil.getColumnIndexOrThrow(query, "dueDate")), query.getLong(CursorUtil.getColumnIndexOrThrow(query, "lastReview")), query.getInt(CursorUtil.getColumnIndexOrThrow(query, "reviewCount")), query.getInt(CursorUtil.getColumnIndexOrThrow(query, "lapses")), query.getInt(CursorUtil.getColumnIndexOrThrow(query, "state")), query.getDouble(CursorUtil.getColumnIndexOrThrow(query, "retrievability")), query.getLong(CursorUtil.getColumnIndexOrThrow(query, "retrievabilityTimestamp"))) : null;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    /* compiled from: CardStateDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/example/flashcardapp/data/dao/CardStateDao_Impl$Companion;", "", "()V", "getRequiredConverters", "", "Ljava/lang/Class;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
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

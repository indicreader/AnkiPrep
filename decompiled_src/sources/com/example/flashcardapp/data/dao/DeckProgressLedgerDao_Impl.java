package com.example.flashcardapp.data.dao;

import android.database.Cursor;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.flashcardapp.data.entities.DeckProgressLedger;
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

/* compiled from: DeckProgressLedgerDao_Impl.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00102\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/example/flashcardapp/data/dao/DeckProgressLedgerDao_Impl;", "Lcom/example/flashcardapp/data/dao/DeckProgressLedgerDao;", "__db", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;)V", "__insertionAdapterOfDeckProgressLedger", "Landroidx/room/EntityInsertionAdapter;", "Lcom/example/flashcardapp/data/entities/DeckProgressLedger;", "__preparedStmtOfClearProgressForDeck", "Landroidx/room/SharedSQLiteStatement;", "clearProgressForDeck", "", "deckId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAttemptedCardIds", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAttemptedCardIdsForDeck", "getAttemptedCountForDeck", "", "insert", "ledger", "(Lcom/example/flashcardapp/data/entities/DeckProgressLedger;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class DeckProgressLedgerDao_Impl implements DeckProgressLedgerDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<DeckProgressLedger> __insertionAdapterOfDeckProgressLedger;
    private final SharedSQLiteStatement __preparedStmtOfClearProgressForDeck;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final List<Class<?>> getRequiredConverters() {
        return INSTANCE.getRequiredConverters();
    }

    public DeckProgressLedgerDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertionAdapterOfDeckProgressLedger = new EntityInsertionAdapter<DeckProgressLedger>(__db) { // from class: com.example.flashcardapp.data.dao.DeckProgressLedgerDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `DeckProgressLedger` (`cardId`,`deckId`) VALUES (?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement statement, DeckProgressLedger entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getCardId());
                statement.bindLong(2, entity.getDeckId());
            }
        };
        this.__preparedStmtOfClearProgressForDeck = new SharedSQLiteStatement(__db) { // from class: com.example.flashcardapp.data.dao.DeckProgressLedgerDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM DeckProgressLedger WHERE deckId = ?";
            }
        };
    }

    @Override // com.example.flashcardapp.data.dao.DeckProgressLedgerDao
    public Object insert(final DeckProgressLedger deckProgressLedger, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.DeckProgressLedgerDao_Impl$insert$2
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
                roomDatabase = DeckProgressLedgerDao_Impl.this.__db;
                roomDatabase.beginTransaction();
                try {
                    entityInsertionAdapter = DeckProgressLedgerDao_Impl.this.__insertionAdapterOfDeckProgressLedger;
                    entityInsertionAdapter.insert((EntityInsertionAdapter) deckProgressLedger);
                    roomDatabase3 = DeckProgressLedgerDao_Impl.this.__db;
                    roomDatabase3.setTransactionSuccessful();
                } finally {
                    roomDatabase2 = DeckProgressLedgerDao_Impl.this.__db;
                    roomDatabase2.endTransaction();
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.DeckProgressLedgerDao
    public Object clearProgressForDeck(final long j, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.DeckProgressLedgerDao_Impl$clearProgressForDeck$2
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
                sharedSQLiteStatement = DeckProgressLedgerDao_Impl.this.__preparedStmtOfClearProgressForDeck;
                SupportSQLiteStatement acquire = sharedSQLiteStatement.acquire();
                acquire.bindLong(1, j);
                try {
                    roomDatabase = DeckProgressLedgerDao_Impl.this.__db;
                    roomDatabase.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        roomDatabase3 = DeckProgressLedgerDao_Impl.this.__db;
                        roomDatabase3.setTransactionSuccessful();
                    } finally {
                        roomDatabase2 = DeckProgressLedgerDao_Impl.this.__db;
                        roomDatabase2.endTransaction();
                    }
                } finally {
                    sharedSQLiteStatement2 = DeckProgressLedgerDao_Impl.this.__preparedStmtOfClearProgressForDeck;
                    sharedSQLiteStatement2.release(acquire);
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.DeckProgressLedgerDao
    public Object getAttemptedCardIdsForDeck(long j, Continuation<? super List<Long>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT cardId FROM DeckProgressLedger WHERE deckId = ?", 1);
        acquire.bindLong(1, j);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends Long>>() { // from class: com.example.flashcardapp.data.dao.DeckProgressLedgerDao_Impl$getAttemptedCardIdsForDeck$2
            @Override // java.util.concurrent.Callable
            public List<? extends Long> call() {
                RoomDatabase roomDatabase;
                roomDatabase = DeckProgressLedgerDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(Long.valueOf(query.getLong(0)));
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.DeckProgressLedgerDao
    public Object getAllAttemptedCardIds(Continuation<? super List<Long>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT cardId FROM DeckProgressLedger", 0);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends Long>>() { // from class: com.example.flashcardapp.data.dao.DeckProgressLedgerDao_Impl$getAllAttemptedCardIds$2
            @Override // java.util.concurrent.Callable
            public List<? extends Long> call() {
                RoomDatabase roomDatabase;
                roomDatabase = DeckProgressLedgerDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(Long.valueOf(query.getLong(0)));
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.DeckProgressLedgerDao
    public Object getAttemptedCountForDeck(long j, Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT COUNT(cardId) FROM DeckProgressLedger WHERE deckId = ?", 1);
        acquire.bindLong(1, j);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<Integer>() { // from class: com.example.flashcardapp.data.dao.DeckProgressLedgerDao_Impl$getAttemptedCountForDeck$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() {
                RoomDatabase roomDatabase;
                roomDatabase = DeckProgressLedgerDao_Impl.this.__db;
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

    /* compiled from: DeckProgressLedgerDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/example/flashcardapp/data/dao/DeckProgressLedgerDao_Impl$Companion;", "", "()V", "getRequiredConverters", "", "Ljava/lang/Class;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
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

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
import com.example.flashcardapp.data.entities.SessionRecordEntity;
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

/* compiled from: SessionRecordDao_Impl.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0096@¢\u0006\u0002\u0010\rJ\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00130\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\rJ\u000e\u0010\u0018\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\rJ\u000e\u0010\u0019\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\rJ\u000e\u0010\u001a\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\rJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0096@¢\u0006\u0002\u0010\rJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0096@¢\u0006\u0002\u0010\rJ\u0016\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/example/flashcardapp/data/dao/SessionRecordDao_Impl;", "Lcom/example/flashcardapp/data/dao/SessionRecordDao;", "__db", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;)V", "__insertionAdapterOfSessionRecordEntity", "Landroidx/room/EntityInsertionAdapter;", "Lcom/example/flashcardapp/data/entities/SessionRecordEntity;", "__preparedStmtOfDeleteAllRecords", "Landroidx/room/SharedSQLiteStatement;", "__preparedStmtOfDeleteRecordsForDeck", "deleteAllRecords", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecordsForDeck", "deckId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllRecords", "", "getAllRecordsFlow", "Lkotlinx/coroutines/flow/Flow;", "getPracticeSessionCount", "", "getRevisionSessionCount", "getSessionCount", "getTestSessionCount", "getTotalCorrectAnswers", "getTotalQuestionsAnswered", "insertRecord", "record", "(Lcom/example/flashcardapp/data/entities/SessionRecordEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class SessionRecordDao_Impl implements SessionRecordDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<SessionRecordEntity> __insertionAdapterOfSessionRecordEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllRecords;
    private final SharedSQLiteStatement __preparedStmtOfDeleteRecordsForDeck;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final List<Class<?>> getRequiredConverters() {
        return INSTANCE.getRequiredConverters();
    }

    public SessionRecordDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertionAdapterOfSessionRecordEntity = new EntityInsertionAdapter<SessionRecordEntity>(__db) { // from class: com.example.flashcardapp.data.dao.SessionRecordDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `session_records` (`id`,`deckId`,`deckName`,`mode`,`score`,`totalQuestions`,`timeTakenSeconds`,`timestamp`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement statement, SessionRecordEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getId());
                statement.bindLong(2, entity.getDeckId());
                statement.bindString(3, entity.getDeckName());
                statement.bindString(4, entity.getMode());
                statement.bindLong(5, entity.getScore());
                statement.bindLong(6, entity.getTotalQuestions());
                statement.bindLong(7, entity.getTimeTakenSeconds());
                statement.bindLong(8, entity.getTimestamp());
            }
        };
        this.__preparedStmtOfDeleteRecordsForDeck = new SharedSQLiteStatement(__db) { // from class: com.example.flashcardapp.data.dao.SessionRecordDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM session_records WHERE deckId = ?";
            }
        };
        this.__preparedStmtOfDeleteAllRecords = new SharedSQLiteStatement(__db) { // from class: com.example.flashcardapp.data.dao.SessionRecordDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM session_records";
            }
        };
    }

    @Override // com.example.flashcardapp.data.dao.SessionRecordDao
    public Object insertRecord(final SessionRecordEntity sessionRecordEntity, Continuation<? super Long> continuation) {
        return CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Long>() { // from class: com.example.flashcardapp.data.dao.SessionRecordDao_Impl$insertRecord$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Long call() {
                RoomDatabase roomDatabase;
                RoomDatabase roomDatabase2;
                EntityInsertionAdapter entityInsertionAdapter;
                RoomDatabase roomDatabase3;
                roomDatabase = SessionRecordDao_Impl.this.__db;
                roomDatabase.beginTransaction();
                try {
                    entityInsertionAdapter = SessionRecordDao_Impl.this.__insertionAdapterOfSessionRecordEntity;
                    long insertAndReturnId = entityInsertionAdapter.insertAndReturnId(sessionRecordEntity);
                    roomDatabase3 = SessionRecordDao_Impl.this.__db;
                    roomDatabase3.setTransactionSuccessful();
                    return Long.valueOf(insertAndReturnId);
                } finally {
                    roomDatabase2 = SessionRecordDao_Impl.this.__db;
                    roomDatabase2.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.SessionRecordDao
    public Object deleteRecordsForDeck(final long j, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.SessionRecordDao_Impl$deleteRecordsForDeck$2
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
                sharedSQLiteStatement = SessionRecordDao_Impl.this.__preparedStmtOfDeleteRecordsForDeck;
                SupportSQLiteStatement acquire = sharedSQLiteStatement.acquire();
                acquire.bindLong(1, j);
                try {
                    roomDatabase = SessionRecordDao_Impl.this.__db;
                    roomDatabase.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        roomDatabase3 = SessionRecordDao_Impl.this.__db;
                        roomDatabase3.setTransactionSuccessful();
                    } finally {
                        roomDatabase2 = SessionRecordDao_Impl.this.__db;
                        roomDatabase2.endTransaction();
                    }
                } finally {
                    sharedSQLiteStatement2 = SessionRecordDao_Impl.this.__preparedStmtOfDeleteRecordsForDeck;
                    sharedSQLiteStatement2.release(acquire);
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.SessionRecordDao
    public Object deleteAllRecords(Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.SessionRecordDao_Impl$deleteAllRecords$2
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
                sharedSQLiteStatement = SessionRecordDao_Impl.this.__preparedStmtOfDeleteAllRecords;
                SupportSQLiteStatement acquire = sharedSQLiteStatement.acquire();
                try {
                    roomDatabase = SessionRecordDao_Impl.this.__db;
                    roomDatabase.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        roomDatabase3 = SessionRecordDao_Impl.this.__db;
                        roomDatabase3.setTransactionSuccessful();
                    } finally {
                        roomDatabase2 = SessionRecordDao_Impl.this.__db;
                        roomDatabase2.endTransaction();
                    }
                } finally {
                    sharedSQLiteStatement2 = SessionRecordDao_Impl.this.__preparedStmtOfDeleteAllRecords;
                    sharedSQLiteStatement2.release(acquire);
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.SessionRecordDao
    public Flow<List<SessionRecordEntity>> getAllRecordsFlow() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM session_records ORDER BY timestamp DESC", 0);
        return CoroutinesRoom.INSTANCE.createFlow(this.__db, false, new String[]{"session_records"}, new Callable<List<? extends SessionRecordEntity>>() { // from class: com.example.flashcardapp.data.dao.SessionRecordDao_Impl$getAllRecordsFlow$1
            @Override // java.util.concurrent.Callable
            public List<? extends SessionRecordEntity> call() {
                RoomDatabase roomDatabase;
                String str = "getString(...)";
                roomDatabase = SessionRecordDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "deckId");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "deckName");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mode");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "score");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "totalQuestions");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "timeTakenSeconds");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j = query.getLong(columnIndexOrThrow);
                        long j2 = query.getLong(columnIndexOrThrow2);
                        String string = query.getString(columnIndexOrThrow3);
                        Intrinsics.checkNotNullExpressionValue(string, str);
                        String string2 = query.getString(columnIndexOrThrow4);
                        Intrinsics.checkNotNullExpressionValue(string2, str);
                        String str2 = str;
                        arrayList.add(new SessionRecordEntity(j, j2, string, string2, query.getInt(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6), query.getLong(columnIndexOrThrow7), query.getLong(columnIndexOrThrow8)));
                        str = str2;
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

    @Override // com.example.flashcardapp.data.dao.SessionRecordDao
    public Object getAllRecords(Continuation<? super List<SessionRecordEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM session_records ORDER BY timestamp DESC", 0);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends SessionRecordEntity>>() { // from class: com.example.flashcardapp.data.dao.SessionRecordDao_Impl$getAllRecords$2
            @Override // java.util.concurrent.Callable
            public List<? extends SessionRecordEntity> call() {
                RoomDatabase roomDatabase;
                String str = "getString(...)";
                roomDatabase = SessionRecordDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "deckId");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "deckName");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mode");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "score");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "totalQuestions");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "timeTakenSeconds");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j = query.getLong(columnIndexOrThrow);
                        long j2 = query.getLong(columnIndexOrThrow2);
                        String string = query.getString(columnIndexOrThrow3);
                        Intrinsics.checkNotNullExpressionValue(string, str);
                        String string2 = query.getString(columnIndexOrThrow4);
                        Intrinsics.checkNotNullExpressionValue(string2, str);
                        String str2 = str;
                        arrayList.add(new SessionRecordEntity(j, j2, string, string2, query.getInt(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6), query.getLong(columnIndexOrThrow7), query.getLong(columnIndexOrThrow8)));
                        str = str2;
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.SessionRecordDao
    public Object getSessionCount(Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT COUNT(*) FROM session_records", 0);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<Integer>() { // from class: com.example.flashcardapp.data.dao.SessionRecordDao_Impl$getSessionCount$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() {
                RoomDatabase roomDatabase;
                roomDatabase = SessionRecordDao_Impl.this.__db;
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

    @Override // com.example.flashcardapp.data.dao.SessionRecordDao
    public Object getTotalQuestionsAnswered(Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT SUM(totalQuestions) FROM session_records", 0);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<Integer>() { // from class: com.example.flashcardapp.data.dao.SessionRecordDao_Impl$getTotalQuestionsAnswered$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() {
                RoomDatabase roomDatabase;
                roomDatabase = SessionRecordDao_Impl.this.__db;
                Integer num = null;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    if (query.moveToFirst() && !query.isNull(0)) {
                        num = Integer.valueOf(query.getInt(0));
                    }
                    return num;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.SessionRecordDao
    public Object getTotalCorrectAnswers(Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT SUM(score) FROM session_records", 0);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<Integer>() { // from class: com.example.flashcardapp.data.dao.SessionRecordDao_Impl$getTotalCorrectAnswers$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() {
                RoomDatabase roomDatabase;
                roomDatabase = SessionRecordDao_Impl.this.__db;
                Integer num = null;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    if (query.moveToFirst() && !query.isNull(0)) {
                        num = Integer.valueOf(query.getInt(0));
                    }
                    return num;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.SessionRecordDao
    public Object getPracticeSessionCount(Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT COUNT(*) FROM session_records WHERE mode = 'PRACTICE'", 0);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<Integer>() { // from class: com.example.flashcardapp.data.dao.SessionRecordDao_Impl$getPracticeSessionCount$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() {
                RoomDatabase roomDatabase;
                roomDatabase = SessionRecordDao_Impl.this.__db;
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

    @Override // com.example.flashcardapp.data.dao.SessionRecordDao
    public Object getRevisionSessionCount(Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT COUNT(*) FROM session_records WHERE mode = 'REVISION'", 0);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<Integer>() { // from class: com.example.flashcardapp.data.dao.SessionRecordDao_Impl$getRevisionSessionCount$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() {
                RoomDatabase roomDatabase;
                roomDatabase = SessionRecordDao_Impl.this.__db;
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

    @Override // com.example.flashcardapp.data.dao.SessionRecordDao
    public Object getTestSessionCount(Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT COUNT(*) FROM session_records WHERE mode = 'TEST'", 0);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<Integer>() { // from class: com.example.flashcardapp.data.dao.SessionRecordDao_Impl$getTestSessionCount$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() {
                RoomDatabase roomDatabase;
                roomDatabase = SessionRecordDao_Impl.this.__db;
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

    /* compiled from: SessionRecordDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/example/flashcardapp/data/dao/SessionRecordDao_Impl$Companion;", "", "()V", "getRequiredConverters", "", "Ljava/lang/Class;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
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

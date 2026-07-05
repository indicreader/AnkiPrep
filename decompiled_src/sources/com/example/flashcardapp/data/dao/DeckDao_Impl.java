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
import com.example.flashcardapp.data.entities.DeckEntity;
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

/* compiled from: DeckDao_Impl.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00170\u0016H\u0016J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H\u0096@¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u0010J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H\u0096@¢\u0006\u0002\u0010\u0010J\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\u0006\u0010\u001e\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010!J\"\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130\u00172\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H\u0096@¢\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010!J\u001c\u0010&\u001a\u00020\u000f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H\u0096@¢\u0006\u0002\u0010$J\u0016\u0010'\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010!J\u001c\u0010(\u001a\u00020\u000f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H\u0096@¢\u0006\u0002\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/example/flashcardapp/data/dao/DeckDao_Impl;", "Lcom/example/flashcardapp/data/dao/DeckDao;", "__db", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;)V", "__insertionAdapterOfDeckEntity", "Landroidx/room/EntityInsertionAdapter;", "Lcom/example/flashcardapp/data/entities/DeckEntity;", "__insertionAdapterOfDeckEntity_1", "__preparedStmtOfDeleteAllDecks", "Landroidx/room/SharedSQLiteStatement;", "__preparedStmtOfDeleteDeck", "__updateAdapterOfDeckEntity", "Landroidx/room/EntityDeletionOrUpdateAdapter;", "deleteAllDecks", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDeck", "deckId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllDecks", "Lkotlinx/coroutines/flow/Flow;", "", "getAllDecksOnce", "getDeckById", "getDeckCount", "", "getRootDecks", "getSubDecks", "parentId", "insertDeckIgnore", "deck", "(Lcom/example/flashcardapp/data/entities/DeckEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertDecksIgnore", "decks", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDeck", "updateDecks", "upsertDeck", "upsertDecks", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class DeckDao_Impl implements DeckDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<DeckEntity> __insertionAdapterOfDeckEntity;
    private final EntityInsertionAdapter<DeckEntity> __insertionAdapterOfDeckEntity_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllDecks;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDeck;
    private final EntityDeletionOrUpdateAdapter<DeckEntity> __updateAdapterOfDeckEntity;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final List<Class<?>> getRequiredConverters() {
        return INSTANCE.getRequiredConverters();
    }

    public DeckDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertionAdapterOfDeckEntity = new EntityInsertionAdapter<DeckEntity>(__db) { // from class: com.example.flashcardapp.data.dao.DeckDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `decks` (`id`,`name`,`fullPath`,`parentDeckId`,`cardCount`,`description`,`lastSyncTimestamp`) VALUES (?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement statement, DeckEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getName());
                statement.bindString(3, entity.getFullPath());
                Long parentDeckId = entity.getParentDeckId();
                if (parentDeckId == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindLong(4, parentDeckId.longValue());
                }
                statement.bindLong(5, entity.getCardCount());
                statement.bindString(6, entity.getDescription());
                statement.bindLong(7, entity.getLastSyncTimestamp());
            }
        };
        this.__insertionAdapterOfDeckEntity_1 = new EntityInsertionAdapter<DeckEntity>(__db) { // from class: com.example.flashcardapp.data.dao.DeckDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR IGNORE INTO `decks` (`id`,`name`,`fullPath`,`parentDeckId`,`cardCount`,`description`,`lastSyncTimestamp`) VALUES (?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement statement, DeckEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getName());
                statement.bindString(3, entity.getFullPath());
                Long parentDeckId = entity.getParentDeckId();
                if (parentDeckId == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindLong(4, parentDeckId.longValue());
                }
                statement.bindLong(5, entity.getCardCount());
                statement.bindString(6, entity.getDescription());
                statement.bindLong(7, entity.getLastSyncTimestamp());
            }
        };
        this.__updateAdapterOfDeckEntity = new EntityDeletionOrUpdateAdapter<DeckEntity>(__db) { // from class: com.example.flashcardapp.data.dao.DeckDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `decks` SET `id` = ?,`name` = ?,`fullPath` = ?,`parentDeckId` = ?,`cardCount` = ?,`description` = ?,`lastSyncTimestamp` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement statement, DeckEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getName());
                statement.bindString(3, entity.getFullPath());
                Long parentDeckId = entity.getParentDeckId();
                if (parentDeckId == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindLong(4, parentDeckId.longValue());
                }
                statement.bindLong(5, entity.getCardCount());
                statement.bindString(6, entity.getDescription());
                statement.bindLong(7, entity.getLastSyncTimestamp());
                statement.bindLong(8, entity.getId());
            }
        };
        this.__preparedStmtOfDeleteDeck = new SharedSQLiteStatement(__db) { // from class: com.example.flashcardapp.data.dao.DeckDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM decks WHERE id = ?";
            }
        };
        this.__preparedStmtOfDeleteAllDecks = new SharedSQLiteStatement(__db) { // from class: com.example.flashcardapp.data.dao.DeckDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM decks";
            }
        };
    }

    @Override // com.example.flashcardapp.data.dao.DeckDao
    public Object upsertDecks(final List<DeckEntity> list, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.DeckDao_Impl$upsertDecks$2
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
                roomDatabase = DeckDao_Impl.this.__db;
                roomDatabase.beginTransaction();
                try {
                    entityInsertionAdapter = DeckDao_Impl.this.__insertionAdapterOfDeckEntity;
                    entityInsertionAdapter.insert((Iterable) list);
                    roomDatabase3 = DeckDao_Impl.this.__db;
                    roomDatabase3.setTransactionSuccessful();
                } finally {
                    roomDatabase2 = DeckDao_Impl.this.__db;
                    roomDatabase2.endTransaction();
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.DeckDao
    public Object upsertDeck(final DeckEntity deckEntity, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.DeckDao_Impl$upsertDeck$2
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
                roomDatabase = DeckDao_Impl.this.__db;
                roomDatabase.beginTransaction();
                try {
                    entityInsertionAdapter = DeckDao_Impl.this.__insertionAdapterOfDeckEntity;
                    entityInsertionAdapter.insert((EntityInsertionAdapter) deckEntity);
                    roomDatabase3 = DeckDao_Impl.this.__db;
                    roomDatabase3.setTransactionSuccessful();
                } finally {
                    roomDatabase2 = DeckDao_Impl.this.__db;
                    roomDatabase2.endTransaction();
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.DeckDao
    public Object insertDecksIgnore(final List<DeckEntity> list, Continuation<? super List<Long>> continuation) {
        return CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<List<? extends Long>>() { // from class: com.example.flashcardapp.data.dao.DeckDao_Impl$insertDecksIgnore$2
            @Override // java.util.concurrent.Callable
            public List<? extends Long> call() {
                RoomDatabase roomDatabase;
                RoomDatabase roomDatabase2;
                EntityInsertionAdapter entityInsertionAdapter;
                RoomDatabase roomDatabase3;
                roomDatabase = DeckDao_Impl.this.__db;
                roomDatabase.beginTransaction();
                try {
                    entityInsertionAdapter = DeckDao_Impl.this.__insertionAdapterOfDeckEntity_1;
                    List<Long> insertAndReturnIdsList = entityInsertionAdapter.insertAndReturnIdsList(list);
                    roomDatabase3 = DeckDao_Impl.this.__db;
                    roomDatabase3.setTransactionSuccessful();
                    return insertAndReturnIdsList;
                } finally {
                    roomDatabase2 = DeckDao_Impl.this.__db;
                    roomDatabase2.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.DeckDao
    public Object insertDeckIgnore(final DeckEntity deckEntity, Continuation<? super Long> continuation) {
        return CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Long>() { // from class: com.example.flashcardapp.data.dao.DeckDao_Impl$insertDeckIgnore$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Long call() {
                RoomDatabase roomDatabase;
                RoomDatabase roomDatabase2;
                EntityInsertionAdapter entityInsertionAdapter;
                RoomDatabase roomDatabase3;
                roomDatabase = DeckDao_Impl.this.__db;
                roomDatabase.beginTransaction();
                try {
                    entityInsertionAdapter = DeckDao_Impl.this.__insertionAdapterOfDeckEntity_1;
                    long insertAndReturnId = entityInsertionAdapter.insertAndReturnId(deckEntity);
                    roomDatabase3 = DeckDao_Impl.this.__db;
                    roomDatabase3.setTransactionSuccessful();
                    return Long.valueOf(insertAndReturnId);
                } finally {
                    roomDatabase2 = DeckDao_Impl.this.__db;
                    roomDatabase2.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.DeckDao
    public Object updateDeck(final DeckEntity deckEntity, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.DeckDao_Impl$updateDeck$2
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
                roomDatabase = DeckDao_Impl.this.__db;
                roomDatabase.beginTransaction();
                try {
                    entityDeletionOrUpdateAdapter = DeckDao_Impl.this.__updateAdapterOfDeckEntity;
                    entityDeletionOrUpdateAdapter.handle(deckEntity);
                    roomDatabase3 = DeckDao_Impl.this.__db;
                    roomDatabase3.setTransactionSuccessful();
                } finally {
                    roomDatabase2 = DeckDao_Impl.this.__db;
                    roomDatabase2.endTransaction();
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.DeckDao
    public Object updateDecks(final List<DeckEntity> list, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.DeckDao_Impl$updateDecks$2
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
                roomDatabase = DeckDao_Impl.this.__db;
                roomDatabase.beginTransaction();
                try {
                    entityDeletionOrUpdateAdapter = DeckDao_Impl.this.__updateAdapterOfDeckEntity;
                    entityDeletionOrUpdateAdapter.handleMultiple(list);
                    roomDatabase3 = DeckDao_Impl.this.__db;
                    roomDatabase3.setTransactionSuccessful();
                } finally {
                    roomDatabase2 = DeckDao_Impl.this.__db;
                    roomDatabase2.endTransaction();
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.DeckDao
    public Object deleteDeck(final long j, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.DeckDao_Impl$deleteDeck$2
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
                sharedSQLiteStatement = DeckDao_Impl.this.__preparedStmtOfDeleteDeck;
                SupportSQLiteStatement acquire = sharedSQLiteStatement.acquire();
                acquire.bindLong(1, j);
                try {
                    roomDatabase = DeckDao_Impl.this.__db;
                    roomDatabase.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        roomDatabase3 = DeckDao_Impl.this.__db;
                        roomDatabase3.setTransactionSuccessful();
                    } finally {
                        roomDatabase2 = DeckDao_Impl.this.__db;
                        roomDatabase2.endTransaction();
                    }
                } finally {
                    sharedSQLiteStatement2 = DeckDao_Impl.this.__preparedStmtOfDeleteDeck;
                    sharedSQLiteStatement2.release(acquire);
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.DeckDao
    public Object deleteAllDecks(Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.DeckDao_Impl$deleteAllDecks$2
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
                sharedSQLiteStatement = DeckDao_Impl.this.__preparedStmtOfDeleteAllDecks;
                SupportSQLiteStatement acquire = sharedSQLiteStatement.acquire();
                try {
                    roomDatabase = DeckDao_Impl.this.__db;
                    roomDatabase.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        roomDatabase3 = DeckDao_Impl.this.__db;
                        roomDatabase3.setTransactionSuccessful();
                    } finally {
                        roomDatabase2 = DeckDao_Impl.this.__db;
                        roomDatabase2.endTransaction();
                    }
                } finally {
                    sharedSQLiteStatement2 = DeckDao_Impl.this.__preparedStmtOfDeleteAllDecks;
                    sharedSQLiteStatement2.release(acquire);
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.DeckDao
    public Flow<List<DeckEntity>> getAllDecks() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM decks ORDER BY fullPath ASC", 0);
        return CoroutinesRoom.INSTANCE.createFlow(this.__db, false, new String[]{"decks"}, new Callable<List<? extends DeckEntity>>() { // from class: com.example.flashcardapp.data.dao.DeckDao_Impl$getAllDecks$1
            @Override // java.util.concurrent.Callable
            public List<? extends DeckEntity> call() {
                RoomDatabase roomDatabase;
                String str = "getString(...)";
                roomDatabase = DeckDao_Impl.this.__db;
                Long l = null;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "fullPath");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "parentDeckId");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "cardCount");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "description");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "lastSyncTimestamp");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j = query.getLong(columnIndexOrThrow);
                        String string = query.getString(columnIndexOrThrow2);
                        Intrinsics.checkNotNullExpressionValue(string, str);
                        String string2 = query.getString(columnIndexOrThrow3);
                        Intrinsics.checkNotNullExpressionValue(string2, str);
                        Long valueOf = query.isNull(columnIndexOrThrow4) ? l : Long.valueOf(query.getLong(columnIndexOrThrow4));
                        int i = query.getInt(columnIndexOrThrow5);
                        String string3 = query.getString(columnIndexOrThrow6);
                        Intrinsics.checkNotNullExpressionValue(string3, str);
                        String str2 = str;
                        arrayList.add(new DeckEntity(j, string, string2, valueOf, i, string3, query.getLong(columnIndexOrThrow7)));
                        str = str2;
                        l = null;
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

    @Override // com.example.flashcardapp.data.dao.DeckDao
    public Object getAllDecksOnce(Continuation<? super List<DeckEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM decks ORDER BY fullPath ASC", 0);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends DeckEntity>>() { // from class: com.example.flashcardapp.data.dao.DeckDao_Impl$getAllDecksOnce$2
            @Override // java.util.concurrent.Callable
            public List<? extends DeckEntity> call() {
                RoomDatabase roomDatabase;
                String str = "getString(...)";
                roomDatabase = DeckDao_Impl.this.__db;
                Long l = null;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "fullPath");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "parentDeckId");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "cardCount");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "description");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "lastSyncTimestamp");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j = query.getLong(columnIndexOrThrow);
                        String string = query.getString(columnIndexOrThrow2);
                        Intrinsics.checkNotNullExpressionValue(string, str);
                        String string2 = query.getString(columnIndexOrThrow3);
                        Intrinsics.checkNotNullExpressionValue(string2, str);
                        Long valueOf = query.isNull(columnIndexOrThrow4) ? l : Long.valueOf(query.getLong(columnIndexOrThrow4));
                        int i = query.getInt(columnIndexOrThrow5);
                        String string3 = query.getString(columnIndexOrThrow6);
                        Intrinsics.checkNotNullExpressionValue(string3, str);
                        String str2 = str;
                        arrayList.add(new DeckEntity(j, string, string2, valueOf, i, string3, query.getLong(columnIndexOrThrow7)));
                        str = str2;
                        l = null;
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.DeckDao
    public Object getDeckById(long j, Continuation<? super DeckEntity> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM decks WHERE id = ?", 1);
        acquire.bindLong(1, j);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<DeckEntity>() { // from class: com.example.flashcardapp.data.dao.DeckDao_Impl$getDeckById$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public DeckEntity call() {
                RoomDatabase roomDatabase;
                roomDatabase = DeckDao_Impl.this.__db;
                DeckEntity deckEntity = null;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "fullPath");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "parentDeckId");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "cardCount");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "description");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "lastSyncTimestamp");
                    if (query.moveToFirst()) {
                        long j2 = query.getLong(columnIndexOrThrow);
                        String string = query.getString(columnIndexOrThrow2);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        String string2 = query.getString(columnIndexOrThrow3);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        Long valueOf = query.isNull(columnIndexOrThrow4) ? null : Long.valueOf(query.getLong(columnIndexOrThrow4));
                        int i = query.getInt(columnIndexOrThrow5);
                        String string3 = query.getString(columnIndexOrThrow6);
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                        deckEntity = new DeckEntity(j2, string, string2, valueOf, i, string3, query.getLong(columnIndexOrThrow7));
                    }
                    return deckEntity;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.DeckDao
    public Object getSubDecks(long j, Continuation<? super List<DeckEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM decks WHERE parentDeckId = ? ORDER BY name ASC", 1);
        acquire.bindLong(1, j);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends DeckEntity>>() { // from class: com.example.flashcardapp.data.dao.DeckDao_Impl$getSubDecks$2
            @Override // java.util.concurrent.Callable
            public List<? extends DeckEntity> call() {
                RoomDatabase roomDatabase;
                String str = "getString(...)";
                roomDatabase = DeckDao_Impl.this.__db;
                Long l = null;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "fullPath");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "parentDeckId");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "cardCount");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "description");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "lastSyncTimestamp");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j2 = query.getLong(columnIndexOrThrow);
                        String string = query.getString(columnIndexOrThrow2);
                        Intrinsics.checkNotNullExpressionValue(string, str);
                        String string2 = query.getString(columnIndexOrThrow3);
                        Intrinsics.checkNotNullExpressionValue(string2, str);
                        Long valueOf = query.isNull(columnIndexOrThrow4) ? l : Long.valueOf(query.getLong(columnIndexOrThrow4));
                        int i = query.getInt(columnIndexOrThrow5);
                        String string3 = query.getString(columnIndexOrThrow6);
                        Intrinsics.checkNotNullExpressionValue(string3, str);
                        String str2 = str;
                        arrayList.add(new DeckEntity(j2, string, string2, valueOf, i, string3, query.getLong(columnIndexOrThrow7)));
                        str = str2;
                        l = null;
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.DeckDao
    public Object getRootDecks(Continuation<? super List<DeckEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM decks WHERE parentDeckId IS NULL ORDER BY name ASC", 0);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends DeckEntity>>() { // from class: com.example.flashcardapp.data.dao.DeckDao_Impl$getRootDecks$2
            @Override // java.util.concurrent.Callable
            public List<? extends DeckEntity> call() {
                RoomDatabase roomDatabase;
                String str = "getString(...)";
                roomDatabase = DeckDao_Impl.this.__db;
                Long l = null;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "fullPath");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "parentDeckId");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "cardCount");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "description");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "lastSyncTimestamp");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j = query.getLong(columnIndexOrThrow);
                        String string = query.getString(columnIndexOrThrow2);
                        Intrinsics.checkNotNullExpressionValue(string, str);
                        String string2 = query.getString(columnIndexOrThrow3);
                        Intrinsics.checkNotNullExpressionValue(string2, str);
                        Long valueOf = query.isNull(columnIndexOrThrow4) ? l : Long.valueOf(query.getLong(columnIndexOrThrow4));
                        int i = query.getInt(columnIndexOrThrow5);
                        String string3 = query.getString(columnIndexOrThrow6);
                        Intrinsics.checkNotNullExpressionValue(string3, str);
                        String str2 = str;
                        arrayList.add(new DeckEntity(j, string, string2, valueOf, i, string3, query.getLong(columnIndexOrThrow7)));
                        str = str2;
                        l = null;
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.DeckDao
    public Object getDeckCount(Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT COUNT(*) FROM decks", 0);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<Integer>() { // from class: com.example.flashcardapp.data.dao.DeckDao_Impl$getDeckCount$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() {
                RoomDatabase roomDatabase;
                roomDatabase = DeckDao_Impl.this.__db;
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

    /* compiled from: DeckDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/example/flashcardapp/data/dao/DeckDao_Impl$Companion;", "", "()V", "getRequiredConverters", "", "Ljava/lang/Class;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
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

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
import com.example.flashcardapp.data.entities.CardUserMetadataEntity;
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

/* compiled from: CardUserMetadataDao_Impl.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u0010H\u0016J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0096@¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/example/flashcardapp/data/dao/CardUserMetadataDao_Impl;", "Lcom/example/flashcardapp/data/dao/CardUserMetadataDao;", "__db", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;)V", "__insertionAdapterOfCardUserMetadataEntity", "Landroidx/room/EntityInsertionAdapter;", "Lcom/example/flashcardapp/data/entities/CardUserMetadataEntity;", "__preparedStmtOfDeleteMetadata", "Landroidx/room/SharedSQLiteStatement;", "deleteMetadata", "", "cardId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllMetadataFlow", "Lkotlinx/coroutines/flow/Flow;", "", "getAllMetadataOnce", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMetadataForCard", "upsertMetadata", "metadata", "(Lcom/example/flashcardapp/data/entities/CardUserMetadataEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class CardUserMetadataDao_Impl implements CardUserMetadataDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<CardUserMetadataEntity> __insertionAdapterOfCardUserMetadataEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteMetadata;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final List<Class<?>> getRequiredConverters() {
        return INSTANCE.getRequiredConverters();
    }

    public CardUserMetadataDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertionAdapterOfCardUserMetadataEntity = new EntityInsertionAdapter<CardUserMetadataEntity>(__db) { // from class: com.example.flashcardapp.data.dao.CardUserMetadataDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `card_user_metadata` (`cardId`,`isStarred`,`rating`) VALUES (?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement statement, CardUserMetadataEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getCardId());
                statement.bindLong(2, entity.isStarred() ? 1L : 0L);
                statement.bindLong(3, entity.getRating());
            }
        };
        this.__preparedStmtOfDeleteMetadata = new SharedSQLiteStatement(__db) { // from class: com.example.flashcardapp.data.dao.CardUserMetadataDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM card_user_metadata WHERE cardId = ?";
            }
        };
    }

    @Override // com.example.flashcardapp.data.dao.CardUserMetadataDao
    public Object upsertMetadata(final CardUserMetadataEntity cardUserMetadataEntity, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.CardUserMetadataDao_Impl$upsertMetadata$2
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
                roomDatabase = CardUserMetadataDao_Impl.this.__db;
                roomDatabase.beginTransaction();
                try {
                    entityInsertionAdapter = CardUserMetadataDao_Impl.this.__insertionAdapterOfCardUserMetadataEntity;
                    entityInsertionAdapter.insert((EntityInsertionAdapter) cardUserMetadataEntity);
                    roomDatabase3 = CardUserMetadataDao_Impl.this.__db;
                    roomDatabase3.setTransactionSuccessful();
                } finally {
                    roomDatabase2 = CardUserMetadataDao_Impl.this.__db;
                    roomDatabase2.endTransaction();
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.CardUserMetadataDao
    public Object deleteMetadata(final long j, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.CardUserMetadataDao_Impl$deleteMetadata$2
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
                sharedSQLiteStatement = CardUserMetadataDao_Impl.this.__preparedStmtOfDeleteMetadata;
                SupportSQLiteStatement acquire = sharedSQLiteStatement.acquire();
                acquire.bindLong(1, j);
                try {
                    roomDatabase = CardUserMetadataDao_Impl.this.__db;
                    roomDatabase.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        roomDatabase3 = CardUserMetadataDao_Impl.this.__db;
                        roomDatabase3.setTransactionSuccessful();
                    } finally {
                        roomDatabase2 = CardUserMetadataDao_Impl.this.__db;
                        roomDatabase2.endTransaction();
                    }
                } finally {
                    sharedSQLiteStatement2 = CardUserMetadataDao_Impl.this.__preparedStmtOfDeleteMetadata;
                    sharedSQLiteStatement2.release(acquire);
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.CardUserMetadataDao
    public Object getMetadataForCard(long j, Continuation<? super CardUserMetadataEntity> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM card_user_metadata WHERE cardId = ?", 1);
        acquire.bindLong(1, j);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<CardUserMetadataEntity>() { // from class: com.example.flashcardapp.data.dao.CardUserMetadataDao_Impl$getMetadataForCard$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public CardUserMetadataEntity call() {
                RoomDatabase roomDatabase;
                roomDatabase = CardUserMetadataDao_Impl.this.__db;
                CardUserMetadataEntity cardUserMetadataEntity = null;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "cardId");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "isStarred");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "rating");
                    if (query.moveToFirst()) {
                        cardUserMetadataEntity = new CardUserMetadataEntity(query.getLong(columnIndexOrThrow), query.getInt(columnIndexOrThrow2) != 0, query.getInt(columnIndexOrThrow3));
                    }
                    return cardUserMetadataEntity;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.CardUserMetadataDao
    public Flow<List<CardUserMetadataEntity>> getAllMetadataFlow() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM card_user_metadata", 0);
        return CoroutinesRoom.INSTANCE.createFlow(this.__db, false, new String[]{"card_user_metadata"}, new Callable<List<? extends CardUserMetadataEntity>>() { // from class: com.example.flashcardapp.data.dao.CardUserMetadataDao_Impl$getAllMetadataFlow$1
            @Override // java.util.concurrent.Callable
            public List<? extends CardUserMetadataEntity> call() {
                RoomDatabase roomDatabase;
                roomDatabase = CardUserMetadataDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "cardId");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "isStarred");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "rating");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new CardUserMetadataEntity(query.getLong(columnIndexOrThrow), query.getInt(columnIndexOrThrow2) != 0, query.getInt(columnIndexOrThrow3)));
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

    @Override // com.example.flashcardapp.data.dao.CardUserMetadataDao
    public Object getAllMetadataOnce(Continuation<? super List<CardUserMetadataEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM card_user_metadata", 0);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends CardUserMetadataEntity>>() { // from class: com.example.flashcardapp.data.dao.CardUserMetadataDao_Impl$getAllMetadataOnce$2
            @Override // java.util.concurrent.Callable
            public List<? extends CardUserMetadataEntity> call() {
                RoomDatabase roomDatabase;
                roomDatabase = CardUserMetadataDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "cardId");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "isStarred");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "rating");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new CardUserMetadataEntity(query.getLong(columnIndexOrThrow), query.getInt(columnIndexOrThrow2) != 0, query.getInt(columnIndexOrThrow3)));
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    /* compiled from: CardUserMetadataDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/example/flashcardapp/data/dao/CardUserMetadataDao_Impl$Companion;", "", "()V", "getRequiredConverters", "", "Ljava/lang/Class;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
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

package com.example.flashcardapp.data.dao;

import android.database.Cursor;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.flashcardapp.data.entities.AliasEntity;
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

/* compiled from: AliasDao_Impl.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00140\u0017H\u0016J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/example/flashcardapp/data/dao/AliasDao_Impl;", "Lcom/example/flashcardapp/data/dao/AliasDao;", "__db", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;)V", "__deletionAdapterOfAliasEntity", "Landroidx/room/EntityDeletionOrUpdateAdapter;", "Lcom/example/flashcardapp/data/entities/AliasEntity;", "__insertionAdapterOfAliasEntity", "Landroidx/room/EntityInsertionAdapter;", "deleteAlias", "", "alias", "(Lcom/example/flashcardapp/data/entities/AliasEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exists", "", "name", "", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAliases", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAliasesFlow", "Lkotlinx/coroutines/flow/Flow;", "insertAlias", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class AliasDao_Impl implements AliasDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<AliasEntity> __deletionAdapterOfAliasEntity;
    private final EntityInsertionAdapter<AliasEntity> __insertionAdapterOfAliasEntity;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final List<Class<?>> getRequiredConverters() {
        return INSTANCE.getRequiredConverters();
    }

    public AliasDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertionAdapterOfAliasEntity = new EntityInsertionAdapter<AliasEntity>(__db) { // from class: com.example.flashcardapp.data.dao.AliasDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR IGNORE INTO `aliases` (`name`,`alias`) VALUES (?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement statement, AliasEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindString(1, entity.getName());
                statement.bindString(2, entity.getAlias());
            }
        };
        this.__deletionAdapterOfAliasEntity = new EntityDeletionOrUpdateAdapter<AliasEntity>(__db) { // from class: com.example.flashcardapp.data.dao.AliasDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `aliases` WHERE `name` = ? AND `alias` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement statement, AliasEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindString(1, entity.getName());
                statement.bindString(2, entity.getAlias());
            }
        };
    }

    @Override // com.example.flashcardapp.data.dao.AliasDao
    public Object insertAlias(final AliasEntity aliasEntity, Continuation<? super Long> continuation) {
        return CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Long>() { // from class: com.example.flashcardapp.data.dao.AliasDao_Impl$insertAlias$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Long call() {
                RoomDatabase roomDatabase;
                RoomDatabase roomDatabase2;
                EntityInsertionAdapter entityInsertionAdapter;
                RoomDatabase roomDatabase3;
                roomDatabase = AliasDao_Impl.this.__db;
                roomDatabase.beginTransaction();
                try {
                    entityInsertionAdapter = AliasDao_Impl.this.__insertionAdapterOfAliasEntity;
                    long insertAndReturnId = entityInsertionAdapter.insertAndReturnId(aliasEntity);
                    roomDatabase3 = AliasDao_Impl.this.__db;
                    roomDatabase3.setTransactionSuccessful();
                    return Long.valueOf(insertAndReturnId);
                } finally {
                    roomDatabase2 = AliasDao_Impl.this.__db;
                    roomDatabase2.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.AliasDao
    public Object deleteAlias(final AliasEntity aliasEntity, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.AliasDao_Impl$deleteAlias$2
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
                roomDatabase = AliasDao_Impl.this.__db;
                roomDatabase.beginTransaction();
                try {
                    entityDeletionOrUpdateAdapter = AliasDao_Impl.this.__deletionAdapterOfAliasEntity;
                    entityDeletionOrUpdateAdapter.handle(aliasEntity);
                    roomDatabase3 = AliasDao_Impl.this.__db;
                    roomDatabase3.setTransactionSuccessful();
                } finally {
                    roomDatabase2 = AliasDao_Impl.this.__db;
                    roomDatabase2.endTransaction();
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.AliasDao
    public Flow<List<AliasEntity>> getAllAliasesFlow() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM aliases", 0);
        return CoroutinesRoom.INSTANCE.createFlow(this.__db, false, new String[]{"aliases"}, new Callable<List<? extends AliasEntity>>() { // from class: com.example.flashcardapp.data.dao.AliasDao_Impl$getAllAliasesFlow$1
            @Override // java.util.concurrent.Callable
            public List<? extends AliasEntity> call() {
                RoomDatabase roomDatabase;
                roomDatabase = AliasDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "name");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "alias");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        String string = query.getString(columnIndexOrThrow);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        String string2 = query.getString(columnIndexOrThrow2);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        arrayList.add(new AliasEntity(string, string2));
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

    @Override // com.example.flashcardapp.data.dao.AliasDao
    public Object getAllAliases(Continuation<? super List<AliasEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM aliases", 0);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends AliasEntity>>() { // from class: com.example.flashcardapp.data.dao.AliasDao_Impl$getAllAliases$2
            @Override // java.util.concurrent.Callable
            public List<? extends AliasEntity> call() {
                RoomDatabase roomDatabase;
                roomDatabase = AliasDao_Impl.this.__db;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "name");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "alias");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        String string = query.getString(columnIndexOrThrow);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        String string2 = query.getString(columnIndexOrThrow2);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        arrayList.add(new AliasEntity(string, string2));
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.AliasDao
    public Object exists(String str, String str2, Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT COUNT(*) FROM aliases WHERE (name = ? AND alias = ?) OR (name = ? AND alias = ?)", 4);
        acquire.bindString(1, str);
        acquire.bindString(2, str2);
        acquire.bindString(3, str2);
        acquire.bindString(4, str);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<Integer>() { // from class: com.example.flashcardapp.data.dao.AliasDao_Impl$exists$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() {
                RoomDatabase roomDatabase;
                roomDatabase = AliasDao_Impl.this.__db;
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

    /* compiled from: AliasDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/example/flashcardapp/data/dao/AliasDao_Impl$Companion;", "", "()V", "getRequiredConverters", "", "Ljava/lang/Class;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
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

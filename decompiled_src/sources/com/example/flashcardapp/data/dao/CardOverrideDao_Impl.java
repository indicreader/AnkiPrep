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
import com.example.flashcardapp.data.entities.CardOverrideEntity;
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

/* compiled from: CardOverrideDao_Impl.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0096@¢\u0006\u0002\u0010\rJ\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00130\u0016H\u0016J\u0018\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/example/flashcardapp/data/dao/CardOverrideDao_Impl;", "Lcom/example/flashcardapp/data/dao/CardOverrideDao;", "__db", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;)V", "__insertionAdapterOfCardOverrideEntity", "Landroidx/room/EntityInsertionAdapter;", "Lcom/example/flashcardapp/data/entities/CardOverrideEntity;", "__preparedStmtOfDeleteAllOverrides", "Landroidx/room/SharedSQLiteStatement;", "__preparedStmtOfDeleteOverride", "deleteAllOverrides", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOverride", "cardId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllOverridesOnce", "", "getOverrideForCard", "observeAllOverrides", "Lkotlinx/coroutines/flow/Flow;", "observeOverrideForCard", "upsertOverride", "override", "(Lcom/example/flashcardapp/data/entities/CardOverrideEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class CardOverrideDao_Impl implements CardOverrideDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<CardOverrideEntity> __insertionAdapterOfCardOverrideEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllOverrides;
    private final SharedSQLiteStatement __preparedStmtOfDeleteOverride;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final List<Class<?>> getRequiredConverters() {
        return INSTANCE.getRequiredConverters();
    }

    public CardOverrideDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertionAdapterOfCardOverrideEntity = new EntityInsertionAdapter<CardOverrideEntity>(__db) { // from class: com.example.flashcardapp.data.dao.CardOverrideDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `card_overrides` (`cardId`,`frontOverride`,`backOverride`,`tagsOverride`,`timestamp`,`frontImageOverride`,`backImageOverride`,`explanationImageOverride`,`optionImagesOverrideJson`) VALUES (?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement statement, CardOverrideEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getCardId());
                statement.bindString(2, entity.getFrontOverride());
                statement.bindString(3, entity.getBackOverride());
                String tagsOverride = entity.getTagsOverride();
                if (tagsOverride == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, tagsOverride);
                }
                statement.bindLong(5, entity.getTimestamp());
                String frontImageOverride = entity.getFrontImageOverride();
                if (frontImageOverride == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, frontImageOverride);
                }
                String backImageOverride = entity.getBackImageOverride();
                if (backImageOverride == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, backImageOverride);
                }
                String explanationImageOverride = entity.getExplanationImageOverride();
                if (explanationImageOverride == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, explanationImageOverride);
                }
                String optionImagesOverrideJson = entity.getOptionImagesOverrideJson();
                if (optionImagesOverrideJson == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, optionImagesOverrideJson);
                }
            }
        };
        this.__preparedStmtOfDeleteOverride = new SharedSQLiteStatement(__db) { // from class: com.example.flashcardapp.data.dao.CardOverrideDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM card_overrides WHERE cardId = ?";
            }
        };
        this.__preparedStmtOfDeleteAllOverrides = new SharedSQLiteStatement(__db) { // from class: com.example.flashcardapp.data.dao.CardOverrideDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM card_overrides";
            }
        };
    }

    @Override // com.example.flashcardapp.data.dao.CardOverrideDao
    public Object upsertOverride(final CardOverrideEntity cardOverrideEntity, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.CardOverrideDao_Impl$upsertOverride$2
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
                roomDatabase = CardOverrideDao_Impl.this.__db;
                roomDatabase.beginTransaction();
                try {
                    entityInsertionAdapter = CardOverrideDao_Impl.this.__insertionAdapterOfCardOverrideEntity;
                    entityInsertionAdapter.insert((EntityInsertionAdapter) cardOverrideEntity);
                    roomDatabase3 = CardOverrideDao_Impl.this.__db;
                    roomDatabase3.setTransactionSuccessful();
                } finally {
                    roomDatabase2 = CardOverrideDao_Impl.this.__db;
                    roomDatabase2.endTransaction();
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.CardOverrideDao
    public Object deleteOverride(final long j, Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.CardOverrideDao_Impl$deleteOverride$2
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
                sharedSQLiteStatement = CardOverrideDao_Impl.this.__preparedStmtOfDeleteOverride;
                SupportSQLiteStatement acquire = sharedSQLiteStatement.acquire();
                acquire.bindLong(1, j);
                try {
                    roomDatabase = CardOverrideDao_Impl.this.__db;
                    roomDatabase.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        roomDatabase3 = CardOverrideDao_Impl.this.__db;
                        roomDatabase3.setTransactionSuccessful();
                    } finally {
                        roomDatabase2 = CardOverrideDao_Impl.this.__db;
                        roomDatabase2.endTransaction();
                    }
                } finally {
                    sharedSQLiteStatement2 = CardOverrideDao_Impl.this.__preparedStmtOfDeleteOverride;
                    sharedSQLiteStatement2.release(acquire);
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.CardOverrideDao
    public Object deleteAllOverrides(Continuation<? super Unit> continuation) {
        Object execute = CoroutinesRoom.INSTANCE.execute(this.__db, true, new Callable<Unit>() { // from class: com.example.flashcardapp.data.dao.CardOverrideDao_Impl$deleteAllOverrides$2
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
                sharedSQLiteStatement = CardOverrideDao_Impl.this.__preparedStmtOfDeleteAllOverrides;
                SupportSQLiteStatement acquire = sharedSQLiteStatement.acquire();
                try {
                    roomDatabase = CardOverrideDao_Impl.this.__db;
                    roomDatabase.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        roomDatabase3 = CardOverrideDao_Impl.this.__db;
                        roomDatabase3.setTransactionSuccessful();
                    } finally {
                        roomDatabase2 = CardOverrideDao_Impl.this.__db;
                        roomDatabase2.endTransaction();
                    }
                } finally {
                    sharedSQLiteStatement2 = CardOverrideDao_Impl.this.__preparedStmtOfDeleteAllOverrides;
                    sharedSQLiteStatement2.release(acquire);
                }
            }
        }, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    @Override // com.example.flashcardapp.data.dao.CardOverrideDao
    public Object getOverrideForCard(long j, Continuation<? super CardOverrideEntity> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM card_overrides WHERE cardId = ?", 1);
        acquire.bindLong(1, j);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<CardOverrideEntity>() { // from class: com.example.flashcardapp.data.dao.CardOverrideDao_Impl$getOverrideForCard$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public CardOverrideEntity call() {
                RoomDatabase roomDatabase;
                roomDatabase = CardOverrideDao_Impl.this.__db;
                CardOverrideEntity cardOverrideEntity = null;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "cardId");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "frontOverride");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "backOverride");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "tagsOverride");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "frontImageOverride");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "backImageOverride");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "explanationImageOverride");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "optionImagesOverrideJson");
                    if (query.moveToFirst()) {
                        long j2 = query.getLong(columnIndexOrThrow);
                        String string = query.getString(columnIndexOrThrow2);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        String string2 = query.getString(columnIndexOrThrow3);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        cardOverrideEntity = new CardOverrideEntity(j2, string, string2, query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.getLong(columnIndexOrThrow5), query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6), query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7), query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8), query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9));
                    }
                    return cardOverrideEntity;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.CardOverrideDao
    public Flow<CardOverrideEntity> observeOverrideForCard(long cardId) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM card_overrides WHERE cardId = ?", 1);
        acquire.bindLong(1, cardId);
        return CoroutinesRoom.INSTANCE.createFlow(this.__db, false, new String[]{"card_overrides"}, new Callable<CardOverrideEntity>() { // from class: com.example.flashcardapp.data.dao.CardOverrideDao_Impl$observeOverrideForCard$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public CardOverrideEntity call() {
                RoomDatabase roomDatabase;
                roomDatabase = CardOverrideDao_Impl.this.__db;
                CardOverrideEntity cardOverrideEntity = null;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "cardId");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "frontOverride");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "backOverride");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "tagsOverride");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "frontImageOverride");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "backImageOverride");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "explanationImageOverride");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "optionImagesOverrideJson");
                    if (query.moveToFirst()) {
                        long j = query.getLong(columnIndexOrThrow);
                        String string = query.getString(columnIndexOrThrow2);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        String string2 = query.getString(columnIndexOrThrow3);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        cardOverrideEntity = new CardOverrideEntity(j, string, string2, query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.getLong(columnIndexOrThrow5), query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6), query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7), query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8), query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9));
                    }
                    return cardOverrideEntity;
                } finally {
                    query.close();
                }
            }

            protected final void finalize() {
                acquire.release();
            }
        });
    }

    @Override // com.example.flashcardapp.data.dao.CardOverrideDao
    public Object getAllOverridesOnce(Continuation<? super List<CardOverrideEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM card_overrides", 0);
        return CoroutinesRoom.INSTANCE.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends CardOverrideEntity>>() { // from class: com.example.flashcardapp.data.dao.CardOverrideDao_Impl$getAllOverridesOnce$2
            @Override // java.util.concurrent.Callable
            public List<? extends CardOverrideEntity> call() {
                RoomDatabase roomDatabase;
                roomDatabase = CardOverrideDao_Impl.this.__db;
                String str = null;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "cardId");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "frontOverride");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "backOverride");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "tagsOverride");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "frontImageOverride");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "backImageOverride");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "explanationImageOverride");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "optionImagesOverrideJson");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j = query.getLong(columnIndexOrThrow);
                        String string = query.getString(columnIndexOrThrow2);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        String string2 = query.getString(columnIndexOrThrow3);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        arrayList.add(new CardOverrideEntity(j, string, string2, query.isNull(columnIndexOrThrow4) ? str : query.getString(columnIndexOrThrow4), query.getLong(columnIndexOrThrow5), query.isNull(columnIndexOrThrow6) ? str : query.getString(columnIndexOrThrow6), query.isNull(columnIndexOrThrow7) ? str : query.getString(columnIndexOrThrow7), query.isNull(columnIndexOrThrow8) ? str : query.getString(columnIndexOrThrow8), query.isNull(columnIndexOrThrow9) ? str : query.getString(columnIndexOrThrow9)));
                        str = null;
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.example.flashcardapp.data.dao.CardOverrideDao
    public Flow<List<CardOverrideEntity>> observeAllOverrides() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM card_overrides", 0);
        return CoroutinesRoom.INSTANCE.createFlow(this.__db, false, new String[]{"card_overrides"}, new Callable<List<? extends CardOverrideEntity>>() { // from class: com.example.flashcardapp.data.dao.CardOverrideDao_Impl$observeAllOverrides$1
            @Override // java.util.concurrent.Callable
            public List<? extends CardOverrideEntity> call() {
                RoomDatabase roomDatabase;
                roomDatabase = CardOverrideDao_Impl.this.__db;
                String str = null;
                Cursor query = DBUtil.query(roomDatabase, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "cardId");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "frontOverride");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "backOverride");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "tagsOverride");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "frontImageOverride");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "backImageOverride");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "explanationImageOverride");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "optionImagesOverrideJson");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j = query.getLong(columnIndexOrThrow);
                        String string = query.getString(columnIndexOrThrow2);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        String string2 = query.getString(columnIndexOrThrow3);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        arrayList.add(new CardOverrideEntity(j, string, string2, query.isNull(columnIndexOrThrow4) ? str : query.getString(columnIndexOrThrow4), query.getLong(columnIndexOrThrow5), query.isNull(columnIndexOrThrow6) ? str : query.getString(columnIndexOrThrow6), query.isNull(columnIndexOrThrow7) ? str : query.getString(columnIndexOrThrow7), query.isNull(columnIndexOrThrow8) ? str : query.getString(columnIndexOrThrow8), query.isNull(columnIndexOrThrow9) ? str : query.getString(columnIndexOrThrow9)));
                        str = null;
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

    /* compiled from: CardOverrideDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/example/flashcardapp/data/dao/CardOverrideDao_Impl$Companion;", "", "()V", "getRequiredConverters", "", "Ljava/lang/Class;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
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

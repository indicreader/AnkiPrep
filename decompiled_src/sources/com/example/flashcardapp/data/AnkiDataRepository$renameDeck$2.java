package com.example.flashcardapp.data;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.RoomDatabaseKt;
import com.example.flashcardapp.data.AppDatabase;
import com.example.flashcardapp.data.dao.DeckDao;
import com.example.flashcardapp.data.entities.DeckEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnkiDataRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.data.AnkiDataRepository$renameDeck$2", f = "AnkiDataRepository.kt", i = {}, l = {685, 691}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class AnkiDataRepository$renameDeck$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $deckId;
    final /* synthetic */ String $newLeafName;
    int label;
    final /* synthetic */ AnkiDataRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnkiDataRepository$renameDeck$2(AnkiDataRepository ankiDataRepository, long j, String str, Continuation<? super AnkiDataRepository$renameDeck$2> continuation) {
        super(2, continuation);
        this.this$0 = ankiDataRepository;
        this.$deckId = j;
        this.$newLeafName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnkiDataRepository$renameDeck$2(this.this$0, this.$deckId, this.$newLeafName, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnkiDataRepository$renameDeck$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DeckDao deckDao;
        String str;
        Context context;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            deckDao = this.this$0.deckDao;
            this.label = 1;
            obj = deckDao.getDeckById(this.$deckId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        DeckEntity deckEntity = (DeckEntity) obj;
        if (deckEntity == null) {
            return Unit.INSTANCE;
        }
        String fullPath = deckEntity.getFullPath();
        String parentDeckPath = AnkiDroidBridge.INSTANCE.getParentDeckPath(fullPath);
        if (parentDeckPath != null) {
            str = parentDeckPath + "::" + this.$newLeafName;
        } else {
            str = this.$newLeafName;
        }
        String str2 = str;
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        context = this.this$0.context;
        this.label = 2;
        if (RoomDatabaseKt.withTransaction(companion.getInstance(context), new AnonymousClass1(this.this$0, fullPath, this.$newLeafName, str2, null), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnkiDataRepository.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.example.flashcardapp.data.AnkiDataRepository$renameDeck$2$1", f = "AnkiDataRepository.kt", i = {1, 3, 3}, l = {692, 700, 702, 710, 712}, m = "invokeSuspend", n = {"deck", "deck", "updatedFullPath"}, s = {"L$1", "L$1", "L$2"})
    /* renamed from: com.example.flashcardapp.data.AnkiDataRepository$renameDeck$2$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $newFullPath;
        final /* synthetic */ String $newLeafName;
        final /* synthetic */ String $oldFullPath;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ AnkiDataRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AnkiDataRepository ankiDataRepository, String str, String str2, String str3, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.this$0 = ankiDataRepository;
            this.$oldFullPath = str;
            this.$newLeafName = str2;
            this.$newFullPath = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$oldFullPath, this.$newLeafName, this.$newFullPath, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x017e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x017f  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00de A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00df  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00df -> B:10:0x0077). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x017f -> B:9:0x0180). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) {
            /*
                Method dump skipped, instructions count: 390
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.AnkiDataRepository$renameDeck$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}

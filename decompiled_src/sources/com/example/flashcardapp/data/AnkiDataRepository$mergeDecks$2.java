package com.example.flashcardapp.data;

import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.RoomDatabaseKt;
import com.example.flashcardapp.data.AppDatabase;
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
@DebugMetadata(c = "com.example.flashcardapp.data.AnkiDataRepository$mergeDecks$2", f = "AnkiDataRepository.kt", i = {}, l = {861}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class AnkiDataRepository$mergeDecks$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $sourceDeckId;
    final /* synthetic */ long $targetDeckId;
    int label;
    final /* synthetic */ AnkiDataRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnkiDataRepository$mergeDecks$2(long j, long j2, AnkiDataRepository ankiDataRepository, Continuation<? super AnkiDataRepository$mergeDecks$2> continuation) {
        super(2, continuation);
        this.$sourceDeckId = j;
        this.$targetDeckId = j2;
        this.this$0 = ankiDataRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnkiDataRepository$mergeDecks$2(this.$sourceDeckId, this.$targetDeckId, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnkiDataRepository$mergeDecks$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Context context;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Log.d("AnkiDataRepository", "Merging deck " + this.$sourceDeckId + " into deck " + this.$targetDeckId);
            AppDatabase.Companion companion = AppDatabase.INSTANCE;
            context = this.this$0.context;
            this.label = 1;
            if (RoomDatabaseKt.withTransaction(companion.getInstance(context), new AnonymousClass1(this.this$0, this.$sourceDeckId, this.$targetDeckId, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnkiDataRepository.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.example.flashcardapp.data.AnkiDataRepository$mergeDecks$2$1", f = "AnkiDataRepository.kt", i = {1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 6, 6, 7, 7}, l = {862, 863, 866, 869, 871, 874, 884, 887, 904}, m = "invokeSuspend", n = {"sourceDeck", "sourceDeck", "targetDeck", "sourceDeck", "targetDeck", "sourceDeck", "targetDeck", "sourceDeck", "targetDeck", "sourceDeck", "targetDeck", "deck", "newFullPath", "sourceDeck", "targetDeck"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$3", "L$4", "L$0", "L$1"})
    /* renamed from: com.example.flashcardapp.data.AnkiDataRepository$mergeDecks$2$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ long $sourceDeckId;
        final /* synthetic */ long $targetDeckId;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ AnkiDataRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AnkiDataRepository ankiDataRepository, long j, long j2, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.this$0 = ankiDataRepository;
            this.$sourceDeckId = j;
            this.$targetDeckId = j2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$sourceDeckId, this.$targetDeckId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000e. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:14:0x017b  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0243 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0244  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x02d4 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0167 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0150 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0116 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x00d7  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x00ba  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x00bd  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0244 -> B:10:0x0248). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r28) {
            /*
                Method dump skipped, instructions count: 784
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.AnkiDataRepository$mergeDecks$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}

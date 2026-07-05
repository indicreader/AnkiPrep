package com.example.flashcardapp.data;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.dao.DeckProgressLedgerDao;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PersistentProgressManager.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH\u0086@¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rJ\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/example/flashcardapp/data/PersistentProgressManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "db", "Lcom/example/flashcardapp/data/AppDatabase;", "ledgerDao", "Lcom/example/flashcardapp/data/dao/DeckProgressLedgerDao;", "clearProgress", "", "deckId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAttemptedCardIds", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAttemptedCardIds", "getRemainingCount", "", "totalCardCount", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logAttempt", "cardId", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class PersistentProgressManager {
    public static final int $stable = 8;
    private final AppDatabase db;
    private final DeckProgressLedgerDao ledgerDao;

    public PersistentProgressManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppDatabase companion = AppDatabase.INSTANCE.getInstance(context);
        this.db = companion;
        this.ledgerDao = companion.deckProgressLedgerDao();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object logAttempt(long r8, long r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof com.example.flashcardapp.data.PersistentProgressManager$logAttempt$1
            if (r0 == 0) goto L14
            r0 = r12
            com.example.flashcardapp.data.PersistentProgressManager$logAttempt$1 r0 = (com.example.flashcardapp.data.PersistentProgressManager$logAttempt$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            com.example.flashcardapp.data.PersistentProgressManager$logAttempt$1 r0 = new com.example.flashcardapp.data.PersistentProgressManager$logAttempt$1
            r0.<init>(r7, r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r12)
            goto L7d
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            long r10 = r0.J$1
            long r8 = r0.J$0
            java.lang.Object r2 = r0.L$0
            com.example.flashcardapp.data.PersistentProgressManager r2 = (com.example.flashcardapp.data.PersistentProgressManager) r2
            kotlin.ResultKt.throwOnFailure(r12)
            goto L60
        L41:
            kotlin.ResultKt.throwOnFailure(r12)
            r5 = 0
            int r12 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r12 >= 0) goto L69
            com.example.flashcardapp.data.AppDatabase r12 = r7.db
            com.example.flashcardapp.data.dao.CardDao r12 = r12.cardDao()
            r0.L$0 = r7
            r0.J$0 = r8
            r0.J$1 = r10
            r0.label = r4
            java.lang.Object r12 = r12.getCardById(r8, r0)
            if (r12 != r1) goto L5f
            return r1
        L5f:
            r2 = r7
        L60:
            com.example.flashcardapp.data.entities.CardEntity r12 = (com.example.flashcardapp.data.entities.CardEntity) r12
            if (r12 == 0) goto L6a
            long r10 = r12.getDeckId()
            goto L6a
        L69:
            r2 = r7
        L6a:
            com.example.flashcardapp.data.dao.DeckProgressLedgerDao r12 = r2.ledgerDao
            com.example.flashcardapp.data.entities.DeckProgressLedger r2 = new com.example.flashcardapp.data.entities.DeckProgressLedger
            r2.<init>(r8, r10)
            r8 = 0
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r8 = r12.insert(r2, r0)
            if (r8 != r1) goto L7d
            return r1
        L7d:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.PersistentProgressManager.logAttempt(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object getAttemptedCardIds(long j, Continuation<? super List<Long>> continuation) {
        return this.ledgerDao.getAttemptedCardIdsForDeck(j, continuation);
    }

    public final Object getAllAttemptedCardIds(Continuation<? super List<Long>> continuation) {
        return this.ledgerDao.getAllAttemptedCardIds(continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getRemainingCount(long r5, int r7, kotlin.coroutines.Continuation<? super java.lang.Integer> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.example.flashcardapp.data.PersistentProgressManager$getRemainingCount$1
            if (r0 == 0) goto L14
            r0 = r8
            com.example.flashcardapp.data.PersistentProgressManager$getRemainingCount$1 r0 = (com.example.flashcardapp.data.PersistentProgressManager$getRemainingCount$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.example.flashcardapp.data.PersistentProgressManager$getRemainingCount$1 r0 = new com.example.flashcardapp.data.PersistentProgressManager$getRemainingCount$1
            r0.<init>(r4, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            int r7 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L44
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r8)
            com.example.flashcardapp.data.dao.DeckProgressLedgerDao r8 = r4.ledgerDao
            r0.I$0 = r7
            r0.label = r3
            java.lang.Object r8 = r8.getAttemptedCountForDeck(r5, r0)
            if (r8 != r1) goto L44
            return r1
        L44:
            java.lang.Number r8 = (java.lang.Number) r8
            int r5 = r8.intValue()
            int r7 = r7 - r5
            r5 = 0
            int r5 = kotlin.ranges.RangesKt.coerceAtLeast(r7, r5)
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.PersistentProgressManager.getRemainingCount(long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object clearProgress(long j, Continuation<? super Unit> continuation) {
        Object clearProgressForDeck = this.ledgerDao.clearProgressForDeck(j, continuation);
        return clearProgressForDeck == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? clearProgressForDeck : Unit.INSTANCE;
    }
}

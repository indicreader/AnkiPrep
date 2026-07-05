package com.example.flashcardapp.fsrs;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.dao.CardStateDao;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FsrsScheduler.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u0013J&\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u00112\u0006\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\u001aJ\u001e\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u001eJ&\u0010\u001f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\nH\u0086@¢\u0006\u0002\u0010!R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/example/flashcardapp/fsrs/FsrsScheduler;", "", "cardStateDao", "Lcom/example/flashcardapp/data/dao/CardStateDao;", "(Lcom/example/flashcardapp/data/dao/CardStateDao;)V", "algorithm", "Lcom/example/flashcardapp/fsrs/FsrsAlgorithm;", "applyRating", "", "cardId", "", "rating", "Lcom/example/flashcardapp/fsrs/Rating;", "isCorrect", "", "(JLcom/example/flashcardapp/fsrs/Rating;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDueCardIds", "", "deckId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDueCount", "", "getNewCardIds", "limit", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTotalDueCount", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initializeNewCards", "overrideRating", "newRating", "(JLcom/example/flashcardapp/fsrs/Rating;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processAnswer", "timeTakenMs", "(JZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class FsrsScheduler {
    public static final int $stable = 8;
    private final FsrsAlgorithm algorithm;
    private final CardStateDao cardStateDao;

    public FsrsScheduler(CardStateDao cardStateDao) {
        Intrinsics.checkNotNullParameter(cardStateDao, "cardStateDao");
        this.cardStateDao = cardStateDao;
        this.algorithm = new FsrsAlgorithm(0.0d, null, 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processAnswer(long r8, boolean r10, long r11, kotlin.coroutines.Continuation<? super com.example.flashcardapp.fsrs.Rating> r13) {
        /*
            r7 = this;
            boolean r0 = r13 instanceof com.example.flashcardapp.fsrs.FsrsScheduler$processAnswer$1
            if (r0 == 0) goto L14
            r0 = r13
            com.example.flashcardapp.fsrs.FsrsScheduler$processAnswer$1 r0 = (com.example.flashcardapp.fsrs.FsrsScheduler$processAnswer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            com.example.flashcardapp.fsrs.FsrsScheduler$processAnswer$1 r0 = new com.example.flashcardapp.fsrs.FsrsScheduler$processAnswer$1
            r0.<init>(r7, r13)
        L19:
            r6 = r0
            java.lang.Object r13 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r8 = r6.L$0
            com.example.flashcardapp.fsrs.Rating r8 = (com.example.flashcardapp.fsrs.Rating) r8
            kotlin.ResultKt.throwOnFailure(r13)
            goto L50
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.throwOnFailure(r13)
            com.example.flashcardapp.fsrs.StealthRatingMapper r13 = com.example.flashcardapp.fsrs.StealthRatingMapper.INSTANCE
            com.example.flashcardapp.fsrs.Rating r11 = r13.mapToRating(r10, r11)
            r6.L$0 = r11
            r6.label = r2
            r1 = r7
            r2 = r8
            r4 = r11
            r5 = r10
            java.lang.Object r8 = r1.applyRating(r2, r4, r5, r6)
            if (r8 != r0) goto L4f
            return r0
        L4f:
            r8 = r11
        L50:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.fsrs.FsrsScheduler.processAnswer(long, boolean, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object overrideRating(long j, Rating rating, Continuation<? super Unit> continuation) {
        Object applyRating = applyRating(j, rating, rating != Rating.Again, continuation);
        return applyRating == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? applyRating : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005f A[LOOP:0: B:11:0x0059->B:13:0x005f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getDueCardIds(long r8, kotlin.coroutines.Continuation<? super java.util.List<java.lang.Long>> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.example.flashcardapp.fsrs.FsrsScheduler$getDueCardIds$1
            if (r0 == 0) goto L14
            r0 = r10
            com.example.flashcardapp.fsrs.FsrsScheduler$getDueCardIds$1 r0 = (com.example.flashcardapp.fsrs.FsrsScheduler$getDueCardIds$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.example.flashcardapp.fsrs.FsrsScheduler$getDueCardIds$1 r0 = new com.example.flashcardapp.fsrs.FsrsScheduler$getDueCardIds$1
            r0.<init>(r7, r10)
        L19:
            r6 = r0
            java.lang.Object r10 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            kotlin.ResultKt.throwOnFailure(r10)
            goto L46
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L33:
            kotlin.ResultKt.throwOnFailure(r10)
            long r4 = java.lang.System.currentTimeMillis()
            com.example.flashcardapp.data.dao.CardStateDao r1 = r7.cardStateDao
            r6.label = r2
            r2 = r8
            java.lang.Object r10 = r1.getDueCards(r2, r4, r6)
            if (r10 != r0) goto L46
            return r0
        L46:
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r8 = new java.util.ArrayList
            r9 = 10
            int r9 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r10, r9)
            r8.<init>(r9)
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r9 = r10.iterator()
        L59:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L71
            java.lang.Object r10 = r9.next()
            com.example.flashcardapp.data.entities.CardStateEntity r10 = (com.example.flashcardapp.data.entities.CardStateEntity) r10
            long r0 = r10.getCardId()
            java.lang.Long r10 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r0)
            r8.add(r10)
            goto L59
        L71:
            java.util.List r8 = (java.util.List) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.fsrs.FsrsScheduler.getDueCardIds(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object getNewCardIds$default(FsrsScheduler fsrsScheduler, long j, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 20;
        }
        return fsrsScheduler.getNewCardIds(j, i, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0059 A[LOOP:0: B:11:0x0053->B:13:0x0059, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getNewCardIds(long r5, int r7, kotlin.coroutines.Continuation<? super java.util.List<java.lang.Long>> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.example.flashcardapp.fsrs.FsrsScheduler$getNewCardIds$1
            if (r0 == 0) goto L14
            r0 = r8
            com.example.flashcardapp.fsrs.FsrsScheduler$getNewCardIds$1 r0 = (com.example.flashcardapp.fsrs.FsrsScheduler$getNewCardIds$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.example.flashcardapp.fsrs.FsrsScheduler$getNewCardIds$1 r0 = new com.example.flashcardapp.fsrs.FsrsScheduler$getNewCardIds$1
            r0.<init>(r4, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L40
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r8)
            com.example.flashcardapp.data.dao.CardStateDao r8 = r4.cardStateDao
            r0.label = r3
            java.lang.Object r8 = r8.getNewCards(r5, r7, r0)
            if (r8 != r1) goto L40
            return r1
        L40:
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r5 = new java.util.ArrayList
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r6)
            r5.<init>(r6)
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r6 = r8.iterator()
        L53:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L6b
            java.lang.Object r7 = r6.next()
            com.example.flashcardapp.data.entities.CardStateEntity r7 = (com.example.flashcardapp.data.entities.CardStateEntity) r7
            long r7 = r7.getCardId()
            java.lang.Long r7 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r7)
            r5.add(r7)
            goto L53
        L6b:
            java.util.List r5 = (java.util.List) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.fsrs.FsrsScheduler.getNewCardIds(long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object getTotalDueCount(Continuation<? super Integer> continuation) {
        return this.cardStateDao.getTotalDueCount(System.currentTimeMillis(), continuation);
    }

    public final Object getDueCount(long j, Continuation<? super Integer> continuation) {
        return this.cardStateDao.getDueCount(j, System.currentTimeMillis(), continuation);
    }

    public final Object initializeNewCards(Continuation<? super Unit> continuation) {
        Object initializeNewCards = this.cardStateDao.initializeNewCards(continuation);
        return initializeNewCards == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? initializeNewCards : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object applyRating(long r52, com.example.flashcardapp.fsrs.Rating r54, boolean r55, kotlin.coroutines.Continuation<? super kotlin.Unit> r56) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.fsrs.FsrsScheduler.applyRating(long, com.example.flashcardapp.fsrs.Rating, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

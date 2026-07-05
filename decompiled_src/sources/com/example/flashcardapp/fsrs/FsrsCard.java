package com.example.flashcardapp.fsrs;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.time.LocalDateTime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FsrsAlgorithm.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003JO\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/example/flashcardapp/fsrs/FsrsCard;", "", "stability", "", "difficulty", "interval", "", "dueDate", "Ljava/time/LocalDateTime;", "reviewCount", "lastReview", "state", "Lcom/example/flashcardapp/fsrs/CardState;", "(DDILjava/time/LocalDateTime;ILjava/time/LocalDateTime;Lcom/example/flashcardapp/fsrs/CardState;)V", "getDifficulty", "()D", "getDueDate", "()Ljava/time/LocalDateTime;", "getInterval", "()I", "getLastReview", "getReviewCount", "getStability", "getState", "()Lcom/example/flashcardapp/fsrs/CardState;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class FsrsCard {
    public static final int $stable = 8;
    private final double difficulty;
    private final LocalDateTime dueDate;
    private final int interval;
    private final LocalDateTime lastReview;
    private final int reviewCount;
    private final double stability;
    private final CardState state;

    public FsrsCard() {
        this(0.0d, 0.0d, 0, null, 0, null, null, 127, null);
    }

    /* renamed from: component1, reason: from getter */
    public final double getStability() {
        return this.stability;
    }

    /* renamed from: component2, reason: from getter */
    public final double getDifficulty() {
        return this.difficulty;
    }

    /* renamed from: component3, reason: from getter */
    public final int getInterval() {
        return this.interval;
    }

    /* renamed from: component4, reason: from getter */
    public final LocalDateTime getDueDate() {
        return this.dueDate;
    }

    /* renamed from: component5, reason: from getter */
    public final int getReviewCount() {
        return this.reviewCount;
    }

    /* renamed from: component6, reason: from getter */
    public final LocalDateTime getLastReview() {
        return this.lastReview;
    }

    /* renamed from: component7, reason: from getter */
    public final CardState getState() {
        return this.state;
    }

    public final FsrsCard copy(double stability, double difficulty, int interval, LocalDateTime dueDate, int reviewCount, LocalDateTime lastReview, CardState state) {
        Intrinsics.checkNotNullParameter(dueDate, "dueDate");
        Intrinsics.checkNotNullParameter(lastReview, "lastReview");
        Intrinsics.checkNotNullParameter(state, "state");
        return new FsrsCard(stability, difficulty, interval, dueDate, reviewCount, lastReview, state);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FsrsCard)) {
            return false;
        }
        FsrsCard fsrsCard = (FsrsCard) other;
        return Double.compare(this.stability, fsrsCard.stability) == 0 && Double.compare(this.difficulty, fsrsCard.difficulty) == 0 && this.interval == fsrsCard.interval && Intrinsics.areEqual(this.dueDate, fsrsCard.dueDate) && this.reviewCount == fsrsCard.reviewCount && Intrinsics.areEqual(this.lastReview, fsrsCard.lastReview) && this.state == fsrsCard.state;
    }

    public final double getDifficulty() {
        return this.difficulty;
    }

    public final LocalDateTime getDueDate() {
        return this.dueDate;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final LocalDateTime getLastReview() {
        return this.lastReview;
    }

    public final int getReviewCount() {
        return this.reviewCount;
    }

    public final double getStability() {
        return this.stability;
    }

    public final CardState getState() {
        return this.state;
    }

    public int hashCode() {
        return (((((((((((Double.hashCode(this.stability) * 31) + Double.hashCode(this.difficulty)) * 31) + Integer.hashCode(this.interval)) * 31) + this.dueDate.hashCode()) * 31) + Integer.hashCode(this.reviewCount)) * 31) + this.lastReview.hashCode()) * 31) + this.state.hashCode();
    }

    public String toString() {
        return "FsrsCard(stability=" + this.stability + ", difficulty=" + this.difficulty + ", interval=" + this.interval + ", dueDate=" + this.dueDate + ", reviewCount=" + this.reviewCount + ", lastReview=" + this.lastReview + ", state=" + this.state + ")";
    }

    public FsrsCard(double d, double d2, int i, LocalDateTime dueDate, int i2, LocalDateTime lastReview, CardState state) {
        Intrinsics.checkNotNullParameter(dueDate, "dueDate");
        Intrinsics.checkNotNullParameter(lastReview, "lastReview");
        Intrinsics.checkNotNullParameter(state, "state");
        this.stability = d;
        this.difficulty = d2;
        this.interval = i;
        this.dueDate = dueDate;
        this.reviewCount = i2;
        this.lastReview = lastReview;
        this.state = state;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ FsrsCard(double r10, double r12, int r14, java.time.LocalDateTime r15, int r16, java.time.LocalDateTime r17, com.example.flashcardapp.fsrs.CardState r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r9 = this;
            r0 = r19 & 1
            if (r0 == 0) goto L7
            r0 = 4612811918334230528(0x4004000000000000, double:2.5)
            goto L8
        L7:
            r0 = r10
        L8:
            r2 = r19 & 2
            if (r2 == 0) goto Lf
            r2 = 4617315517961601024(0x4014000000000000, double:5.0)
            goto L10
        Lf:
            r2 = r12
        L10:
            r4 = r19 & 4
            r5 = 0
            if (r4 == 0) goto L17
            r4 = r5
            goto L18
        L17:
            r4 = r14
        L18:
            r6 = r19 & 8
            java.lang.String r7 = "now(...)"
            if (r6 == 0) goto L26
            java.time.LocalDateTime r6 = java.time.LocalDateTime.now()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            goto L27
        L26:
            r6 = r15
        L27:
            r8 = r19 & 16
            if (r8 == 0) goto L2c
            goto L2e
        L2c:
            r5 = r16
        L2e:
            r8 = r19 & 32
            if (r8 == 0) goto L3a
            java.time.LocalDateTime r8 = java.time.LocalDateTime.now()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r7)
            goto L3c
        L3a:
            r8 = r17
        L3c:
            r7 = r19 & 64
            if (r7 == 0) goto L43
            com.example.flashcardapp.fsrs.CardState r7 = com.example.flashcardapp.fsrs.CardState.New
            goto L45
        L43:
            r7 = r18
        L45:
            r10 = r9
            r11 = r0
            r13 = r2
            r15 = r4
            r16 = r6
            r17 = r5
            r18 = r8
            r19 = r7
            r10.<init>(r11, r13, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.fsrs.FsrsCard.<init>(double, double, int, java.time.LocalDateTime, int, java.time.LocalDateTime, com.example.flashcardapp.fsrs.CardState, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}

package com.example.flashcardapp.session;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StatsHeatmap.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/example/flashcardapp/session/LearningStats;", "", "masteredCards", "", "revisionDue", "untouchedCards", "totalAttempts", "accuracy", "", "(IIIIF)V", "getAccuracy", "()F", "getMasteredCards", "()I", "getRevisionDue", "getTotalAttempts", "getUntouchedCards", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class LearningStats {
    public static final int $stable = 0;
    private final float accuracy;
    private final int masteredCards;
    private final int revisionDue;
    private final int totalAttempts;
    private final int untouchedCards;

    public LearningStats() {
        this(0, 0, 0, 0, 0.0f, 31, null);
    }

    public static /* synthetic */ LearningStats copy$default(LearningStats learningStats, int i, int i2, int i3, int i4, float f, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = learningStats.masteredCards;
        }
        if ((i5 & 2) != 0) {
            i2 = learningStats.revisionDue;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            i3 = learningStats.untouchedCards;
        }
        int i7 = i3;
        if ((i5 & 8) != 0) {
            i4 = learningStats.totalAttempts;
        }
        int i8 = i4;
        if ((i5 & 16) != 0) {
            f = learningStats.accuracy;
        }
        return learningStats.copy(i, i6, i7, i8, f);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMasteredCards() {
        return this.masteredCards;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRevisionDue() {
        return this.revisionDue;
    }

    /* renamed from: component3, reason: from getter */
    public final int getUntouchedCards() {
        return this.untouchedCards;
    }

    /* renamed from: component4, reason: from getter */
    public final int getTotalAttempts() {
        return this.totalAttempts;
    }

    /* renamed from: component5, reason: from getter */
    public final float getAccuracy() {
        return this.accuracy;
    }

    public final LearningStats copy(int masteredCards, int revisionDue, int untouchedCards, int totalAttempts, float accuracy) {
        return new LearningStats(masteredCards, revisionDue, untouchedCards, totalAttempts, accuracy);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LearningStats)) {
            return false;
        }
        LearningStats learningStats = (LearningStats) other;
        return this.masteredCards == learningStats.masteredCards && this.revisionDue == learningStats.revisionDue && this.untouchedCards == learningStats.untouchedCards && this.totalAttempts == learningStats.totalAttempts && Float.compare(this.accuracy, learningStats.accuracy) == 0;
    }

    public final float getAccuracy() {
        return this.accuracy;
    }

    public final int getMasteredCards() {
        return this.masteredCards;
    }

    public final int getRevisionDue() {
        return this.revisionDue;
    }

    public final int getTotalAttempts() {
        return this.totalAttempts;
    }

    public final int getUntouchedCards() {
        return this.untouchedCards;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.masteredCards) * 31) + Integer.hashCode(this.revisionDue)) * 31) + Integer.hashCode(this.untouchedCards)) * 31) + Integer.hashCode(this.totalAttempts)) * 31) + Float.hashCode(this.accuracy);
    }

    public String toString() {
        return "LearningStats(masteredCards=" + this.masteredCards + ", revisionDue=" + this.revisionDue + ", untouchedCards=" + this.untouchedCards + ", totalAttempts=" + this.totalAttempts + ", accuracy=" + this.accuracy + ")";
    }

    public LearningStats(int i, int i2, int i3, int i4, float f) {
        this.masteredCards = i;
        this.revisionDue = i2;
        this.untouchedCards = i3;
        this.totalAttempts = i4;
        this.accuracy = f;
    }

    public /* synthetic */ LearningStats(int i, int i2, int i3, int i4, float f, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) == 0 ? i4 : 0, (i5 & 16) != 0 ? 0.0f : f);
    }
}

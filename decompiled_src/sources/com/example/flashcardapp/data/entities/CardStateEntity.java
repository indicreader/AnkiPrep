package com.example.flashcardapp.data.entities;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CardStateEntity.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003Jw\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\bHÖ\u0001J\t\u0010/\u001a\u000200HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017¨\u00061"}, d2 = {"Lcom/example/flashcardapp/data/entities/CardStateEntity;", "", "cardId", "", "stability", "", "difficulty", "interval", "", "dueDate", "lastReview", "reviewCount", "lapses", "state", "retrievability", "retrievabilityTimestamp", "(JDDIJJIIIDJ)V", "getCardId", "()J", "getDifficulty", "()D", "getDueDate", "getInterval", "()I", "getLapses", "getLastReview", "getRetrievability", "getRetrievabilityTimestamp", "getReviewCount", "getStability", "getState", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class CardStateEntity {
    public static final int $stable = 0;
    private final long cardId;
    private final double difficulty;
    private final long dueDate;
    private final int interval;
    private final int lapses;
    private final long lastReview;
    private final double retrievability;
    private final long retrievabilityTimestamp;
    private final int reviewCount;
    private final double stability;
    private final int state;

    /* renamed from: component1, reason: from getter */
    public final long getCardId() {
        return this.cardId;
    }

    /* renamed from: component10, reason: from getter */
    public final double getRetrievability() {
        return this.retrievability;
    }

    /* renamed from: component11, reason: from getter */
    public final long getRetrievabilityTimestamp() {
        return this.retrievabilityTimestamp;
    }

    /* renamed from: component2, reason: from getter */
    public final double getStability() {
        return this.stability;
    }

    /* renamed from: component3, reason: from getter */
    public final double getDifficulty() {
        return this.difficulty;
    }

    /* renamed from: component4, reason: from getter */
    public final int getInterval() {
        return this.interval;
    }

    /* renamed from: component5, reason: from getter */
    public final long getDueDate() {
        return this.dueDate;
    }

    /* renamed from: component6, reason: from getter */
    public final long getLastReview() {
        return this.lastReview;
    }

    /* renamed from: component7, reason: from getter */
    public final int getReviewCount() {
        return this.reviewCount;
    }

    /* renamed from: component8, reason: from getter */
    public final int getLapses() {
        return this.lapses;
    }

    /* renamed from: component9, reason: from getter */
    public final int getState() {
        return this.state;
    }

    public final CardStateEntity copy(long cardId, double stability, double difficulty, int interval, long dueDate, long lastReview, int reviewCount, int lapses, int state, double retrievability, long retrievabilityTimestamp) {
        return new CardStateEntity(cardId, stability, difficulty, interval, dueDate, lastReview, reviewCount, lapses, state, retrievability, retrievabilityTimestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardStateEntity)) {
            return false;
        }
        CardStateEntity cardStateEntity = (CardStateEntity) other;
        return this.cardId == cardStateEntity.cardId && Double.compare(this.stability, cardStateEntity.stability) == 0 && Double.compare(this.difficulty, cardStateEntity.difficulty) == 0 && this.interval == cardStateEntity.interval && this.dueDate == cardStateEntity.dueDate && this.lastReview == cardStateEntity.lastReview && this.reviewCount == cardStateEntity.reviewCount && this.lapses == cardStateEntity.lapses && this.state == cardStateEntity.state && Double.compare(this.retrievability, cardStateEntity.retrievability) == 0 && this.retrievabilityTimestamp == cardStateEntity.retrievabilityTimestamp;
    }

    public final long getCardId() {
        return this.cardId;
    }

    public final double getDifficulty() {
        return this.difficulty;
    }

    public final long getDueDate() {
        return this.dueDate;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final int getLapses() {
        return this.lapses;
    }

    public final long getLastReview() {
        return this.lastReview;
    }

    public final double getRetrievability() {
        return this.retrievability;
    }

    public final long getRetrievabilityTimestamp() {
        return this.retrievabilityTimestamp;
    }

    public final int getReviewCount() {
        return this.reviewCount;
    }

    public final double getStability() {
        return this.stability;
    }

    public final int getState() {
        return this.state;
    }

    public int hashCode() {
        return (((((((((((((((((((Long.hashCode(this.cardId) * 31) + Double.hashCode(this.stability)) * 31) + Double.hashCode(this.difficulty)) * 31) + Integer.hashCode(this.interval)) * 31) + Long.hashCode(this.dueDate)) * 31) + Long.hashCode(this.lastReview)) * 31) + Integer.hashCode(this.reviewCount)) * 31) + Integer.hashCode(this.lapses)) * 31) + Integer.hashCode(this.state)) * 31) + Double.hashCode(this.retrievability)) * 31) + Long.hashCode(this.retrievabilityTimestamp);
    }

    public String toString() {
        return "CardStateEntity(cardId=" + this.cardId + ", stability=" + this.stability + ", difficulty=" + this.difficulty + ", interval=" + this.interval + ", dueDate=" + this.dueDate + ", lastReview=" + this.lastReview + ", reviewCount=" + this.reviewCount + ", lapses=" + this.lapses + ", state=" + this.state + ", retrievability=" + this.retrievability + ", retrievabilityTimestamp=" + this.retrievabilityTimestamp + ")";
    }

    public CardStateEntity(long j, double d, double d2, int i, long j2, long j3, int i2, int i3, int i4, double d3, long j4) {
        this.cardId = j;
        this.stability = d;
        this.difficulty = d2;
        this.interval = i;
        this.dueDate = j2;
        this.lastReview = j3;
        this.reviewCount = i2;
        this.lapses = i3;
        this.state = i4;
        this.retrievability = d3;
        this.retrievabilityTimestamp = j4;
    }

    public /* synthetic */ CardStateEntity(long j, double d, double d2, int i, long j2, long j3, int i2, int i3, int i4, double d3, long j4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i5 & 2) != 0 ? 2.5d : d, (i5 & 4) != 0 ? 5.0d : d2, (i5 & 8) != 0 ? 0 : i, (i5 & 16) != 0 ? 0L : j2, (i5 & 32) != 0 ? 0L : j3, (i5 & 64) != 0 ? 0 : i2, (i5 & 128) != 0 ? 0 : i3, (i5 & 256) != 0 ? 0 : i4, (i5 & 512) != 0 ? 0.0d : d3, (i5 & 1024) != 0 ? 0L : j4);
    }
}

package com.example.flashcardapp.fsrs;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FsrsAlgorithm.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003J\t\u0010#\u001a\u00020\u000eHÆ\u0003JO\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0006HÖ\u0001J\t\u0010)\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006*"}, d2 = {"Lcom/example/flashcardapp/fsrs/SchedulingResult;", "", "stability", "", "difficulty", "interval", "", "durationMillis", "", "displayText", "", "rating", "Lcom/example/flashcardapp/fsrs/Rating;", "newState", "Lcom/example/flashcardapp/fsrs/CardState;", "(DDIJLjava/lang/String;Lcom/example/flashcardapp/fsrs/Rating;Lcom/example/flashcardapp/fsrs/CardState;)V", "getDifficulty", "()D", "getDisplayText", "()Ljava/lang/String;", "getDurationMillis", "()J", "getInterval", "()I", "getNewState", "()Lcom/example/flashcardapp/fsrs/CardState;", "getRating", "()Lcom/example/flashcardapp/fsrs/Rating;", "getStability", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class SchedulingResult {
    public static final int $stable = 0;
    private final double difficulty;
    private final String displayText;
    private final long durationMillis;
    private final int interval;
    private final CardState newState;
    private final Rating rating;
    private final double stability;

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
    public final long getDurationMillis() {
        return this.durationMillis;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDisplayText() {
        return this.displayText;
    }

    /* renamed from: component6, reason: from getter */
    public final Rating getRating() {
        return this.rating;
    }

    /* renamed from: component7, reason: from getter */
    public final CardState getNewState() {
        return this.newState;
    }

    public final SchedulingResult copy(double stability, double difficulty, int interval, long durationMillis, String displayText, Rating rating, CardState newState) {
        Intrinsics.checkNotNullParameter(displayText, "displayText");
        Intrinsics.checkNotNullParameter(rating, "rating");
        Intrinsics.checkNotNullParameter(newState, "newState");
        return new SchedulingResult(stability, difficulty, interval, durationMillis, displayText, rating, newState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SchedulingResult)) {
            return false;
        }
        SchedulingResult schedulingResult = (SchedulingResult) other;
        return Double.compare(this.stability, schedulingResult.stability) == 0 && Double.compare(this.difficulty, schedulingResult.difficulty) == 0 && this.interval == schedulingResult.interval && this.durationMillis == schedulingResult.durationMillis && Intrinsics.areEqual(this.displayText, schedulingResult.displayText) && this.rating == schedulingResult.rating && this.newState == schedulingResult.newState;
    }

    public final double getDifficulty() {
        return this.difficulty;
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final long getDurationMillis() {
        return this.durationMillis;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final CardState getNewState() {
        return this.newState;
    }

    public final Rating getRating() {
        return this.rating;
    }

    public final double getStability() {
        return this.stability;
    }

    public int hashCode() {
        return (((((((((((Double.hashCode(this.stability) * 31) + Double.hashCode(this.difficulty)) * 31) + Integer.hashCode(this.interval)) * 31) + Long.hashCode(this.durationMillis)) * 31) + this.displayText.hashCode()) * 31) + this.rating.hashCode()) * 31) + this.newState.hashCode();
    }

    public String toString() {
        return "SchedulingResult(stability=" + this.stability + ", difficulty=" + this.difficulty + ", interval=" + this.interval + ", durationMillis=" + this.durationMillis + ", displayText=" + this.displayText + ", rating=" + this.rating + ", newState=" + this.newState + ")";
    }

    public SchedulingResult(double d, double d2, int i, long j, String displayText, Rating rating, CardState newState) {
        Intrinsics.checkNotNullParameter(displayText, "displayText");
        Intrinsics.checkNotNullParameter(rating, "rating");
        Intrinsics.checkNotNullParameter(newState, "newState");
        this.stability = d;
        this.difficulty = d2;
        this.interval = i;
        this.durationMillis = j;
        this.displayText = displayText;
        this.rating = rating;
        this.newState = newState;
    }
}

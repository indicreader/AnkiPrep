package com.example.flashcardapp.session;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StatsHeatmap.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/example/flashcardapp/session/DailyModeStats;", "", "date", "", "practiceCount", "", "revisionCount", "testCount", "(JIII)V", "getDate", "()J", "getPracticeCount", "()I", "getRevisionCount", "getTestCount", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class DailyModeStats {
    public static final int $stable = 0;
    private final long date;
    private final int practiceCount;
    private final int revisionCount;
    private final int testCount;

    public static /* synthetic */ DailyModeStats copy$default(DailyModeStats dailyModeStats, long j, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j = dailyModeStats.date;
        }
        long j2 = j;
        if ((i4 & 2) != 0) {
            i = dailyModeStats.practiceCount;
        }
        int i5 = i;
        if ((i4 & 4) != 0) {
            i2 = dailyModeStats.revisionCount;
        }
        int i6 = i2;
        if ((i4 & 8) != 0) {
            i3 = dailyModeStats.testCount;
        }
        return dailyModeStats.copy(j2, i5, i6, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final long getDate() {
        return this.date;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPracticeCount() {
        return this.practiceCount;
    }

    /* renamed from: component3, reason: from getter */
    public final int getRevisionCount() {
        return this.revisionCount;
    }

    /* renamed from: component4, reason: from getter */
    public final int getTestCount() {
        return this.testCount;
    }

    public final DailyModeStats copy(long date, int practiceCount, int revisionCount, int testCount) {
        return new DailyModeStats(date, practiceCount, revisionCount, testCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DailyModeStats)) {
            return false;
        }
        DailyModeStats dailyModeStats = (DailyModeStats) other;
        return this.date == dailyModeStats.date && this.practiceCount == dailyModeStats.practiceCount && this.revisionCount == dailyModeStats.revisionCount && this.testCount == dailyModeStats.testCount;
    }

    public final long getDate() {
        return this.date;
    }

    public final int getPracticeCount() {
        return this.practiceCount;
    }

    public final int getRevisionCount() {
        return this.revisionCount;
    }

    public final int getTestCount() {
        return this.testCount;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.date) * 31) + Integer.hashCode(this.practiceCount)) * 31) + Integer.hashCode(this.revisionCount)) * 31) + Integer.hashCode(this.testCount);
    }

    public String toString() {
        return "DailyModeStats(date=" + this.date + ", practiceCount=" + this.practiceCount + ", revisionCount=" + this.revisionCount + ", testCount=" + this.testCount + ")";
    }

    public DailyModeStats(long j, int i, int i2, int i3) {
        this.date = j;
        this.practiceCount = i;
        this.revisionCount = i2;
        this.testCount = i3;
    }

    public /* synthetic */ DailyModeStats(long j, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }
}

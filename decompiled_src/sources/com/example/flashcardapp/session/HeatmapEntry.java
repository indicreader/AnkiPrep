package com.example.flashcardapp.session;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StatsHeatmap.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\t\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/example/flashcardapp/session/HeatmapEntry;", "", "date", "", "practiceCompleted", "", "revisionCompleted", "testCompleted", "(JZZZ)V", "allModesCompleted", "getAllModesCompleted", "()Z", "getDate", "()J", "getPracticeCompleted", "getRevisionCompleted", "getTestCompleted", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class HeatmapEntry {
    public static final int $stable = 0;
    private final long date;
    private final boolean practiceCompleted;
    private final boolean revisionCompleted;
    private final boolean testCompleted;

    public static /* synthetic */ HeatmapEntry copy$default(HeatmapEntry heatmapEntry, long j, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = heatmapEntry.date;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            z = heatmapEntry.practiceCompleted;
        }
        boolean z4 = z;
        if ((i & 4) != 0) {
            z2 = heatmapEntry.revisionCompleted;
        }
        boolean z5 = z2;
        if ((i & 8) != 0) {
            z3 = heatmapEntry.testCompleted;
        }
        return heatmapEntry.copy(j2, z4, z5, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final long getDate() {
        return this.date;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getPracticeCompleted() {
        return this.practiceCompleted;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getRevisionCompleted() {
        return this.revisionCompleted;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getTestCompleted() {
        return this.testCompleted;
    }

    public final HeatmapEntry copy(long date, boolean practiceCompleted, boolean revisionCompleted, boolean testCompleted) {
        return new HeatmapEntry(date, practiceCompleted, revisionCompleted, testCompleted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HeatmapEntry)) {
            return false;
        }
        HeatmapEntry heatmapEntry = (HeatmapEntry) other;
        return this.date == heatmapEntry.date && this.practiceCompleted == heatmapEntry.practiceCompleted && this.revisionCompleted == heatmapEntry.revisionCompleted && this.testCompleted == heatmapEntry.testCompleted;
    }

    public final boolean getAllModesCompleted() {
        return this.practiceCompleted && this.revisionCompleted && this.testCompleted;
    }

    public final long getDate() {
        return this.date;
    }

    public final boolean getPracticeCompleted() {
        return this.practiceCompleted;
    }

    public final boolean getRevisionCompleted() {
        return this.revisionCompleted;
    }

    public final boolean getTestCompleted() {
        return this.testCompleted;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.date) * 31) + Boolean.hashCode(this.practiceCompleted)) * 31) + Boolean.hashCode(this.revisionCompleted)) * 31) + Boolean.hashCode(this.testCompleted);
    }

    public String toString() {
        return "HeatmapEntry(date=" + this.date + ", practiceCompleted=" + this.practiceCompleted + ", revisionCompleted=" + this.revisionCompleted + ", testCompleted=" + this.testCompleted + ")";
    }

    public HeatmapEntry(long j, boolean z, boolean z2, boolean z3) {
        this.date = j;
        this.practiceCompleted = z;
        this.revisionCompleted = z2;
        this.testCompleted = z3;
    }

    public /* synthetic */ HeatmapEntry(long j, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3);
    }
}

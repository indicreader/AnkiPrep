package com.example.flashcardapp.ui;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.session.StreakCalculator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HomeScreenState.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JK\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006%"}, d2 = {"Lcom/example/flashcardapp/ui/HomeStats;", "", "pendingCount", "", "mastery", "", "velocity", "last7DaysCompletion", "streakInfo", "Lcom/example/flashcardapp/session/StreakCalculator$StreakInfo;", "studiedDayTimestamps", "", "", "(IFFILcom/example/flashcardapp/session/StreakCalculator$StreakInfo;Ljava/util/Set;)V", "getLast7DaysCompletion", "()I", "getMastery", "()F", "getPendingCount", "getStreakInfo", "()Lcom/example/flashcardapp/session/StreakCalculator$StreakInfo;", "getStudiedDayTimestamps", "()Ljava/util/Set;", "getVelocity", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class HomeStats {
    public static final int $stable = 8;
    private final int last7DaysCompletion;
    private final float mastery;
    private final int pendingCount;
    private final StreakCalculator.StreakInfo streakInfo;
    private final Set<Long> studiedDayTimestamps;
    private final float velocity;

    public static /* synthetic */ HomeStats copy$default(HomeStats homeStats, int i, float f, float f2, int i2, StreakCalculator.StreakInfo streakInfo, Set set, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = homeStats.pendingCount;
        }
        if ((i3 & 2) != 0) {
            f = homeStats.mastery;
        }
        float f3 = f;
        if ((i3 & 4) != 0) {
            f2 = homeStats.velocity;
        }
        float f4 = f2;
        if ((i3 & 8) != 0) {
            i2 = homeStats.last7DaysCompletion;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            streakInfo = homeStats.streakInfo;
        }
        StreakCalculator.StreakInfo streakInfo2 = streakInfo;
        if ((i3 & 32) != 0) {
            set = homeStats.studiedDayTimestamps;
        }
        return homeStats.copy(i, f3, f4, i4, streakInfo2, set);
    }

    /* renamed from: component1, reason: from getter */
    public final int getPendingCount() {
        return this.pendingCount;
    }

    /* renamed from: component2, reason: from getter */
    public final float getMastery() {
        return this.mastery;
    }

    /* renamed from: component3, reason: from getter */
    public final float getVelocity() {
        return this.velocity;
    }

    /* renamed from: component4, reason: from getter */
    public final int getLast7DaysCompletion() {
        return this.last7DaysCompletion;
    }

    /* renamed from: component5, reason: from getter */
    public final StreakCalculator.StreakInfo getStreakInfo() {
        return this.streakInfo;
    }

    public final Set<Long> component6() {
        return this.studiedDayTimestamps;
    }

    public final HomeStats copy(int pendingCount, float mastery, float velocity, int last7DaysCompletion, StreakCalculator.StreakInfo streakInfo, Set<Long> studiedDayTimestamps) {
        Intrinsics.checkNotNullParameter(streakInfo, "streakInfo");
        Intrinsics.checkNotNullParameter(studiedDayTimestamps, "studiedDayTimestamps");
        return new HomeStats(pendingCount, mastery, velocity, last7DaysCompletion, streakInfo, studiedDayTimestamps);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeStats)) {
            return false;
        }
        HomeStats homeStats = (HomeStats) other;
        return this.pendingCount == homeStats.pendingCount && Float.compare(this.mastery, homeStats.mastery) == 0 && Float.compare(this.velocity, homeStats.velocity) == 0 && this.last7DaysCompletion == homeStats.last7DaysCompletion && Intrinsics.areEqual(this.streakInfo, homeStats.streakInfo) && Intrinsics.areEqual(this.studiedDayTimestamps, homeStats.studiedDayTimestamps);
    }

    public final int getLast7DaysCompletion() {
        return this.last7DaysCompletion;
    }

    public final float getMastery() {
        return this.mastery;
    }

    public final int getPendingCount() {
        return this.pendingCount;
    }

    public final StreakCalculator.StreakInfo getStreakInfo() {
        return this.streakInfo;
    }

    public final Set<Long> getStudiedDayTimestamps() {
        return this.studiedDayTimestamps;
    }

    public final float getVelocity() {
        return this.velocity;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.pendingCount) * 31) + Float.hashCode(this.mastery)) * 31) + Float.hashCode(this.velocity)) * 31) + Integer.hashCode(this.last7DaysCompletion)) * 31) + this.streakInfo.hashCode()) * 31) + this.studiedDayTimestamps.hashCode();
    }

    public String toString() {
        return "HomeStats(pendingCount=" + this.pendingCount + ", mastery=" + this.mastery + ", velocity=" + this.velocity + ", last7DaysCompletion=" + this.last7DaysCompletion + ", streakInfo=" + this.streakInfo + ", studiedDayTimestamps=" + this.studiedDayTimestamps + ")";
    }

    public HomeStats(int i, float f, float f2, int i2, StreakCalculator.StreakInfo streakInfo, Set<Long> studiedDayTimestamps) {
        Intrinsics.checkNotNullParameter(streakInfo, "streakInfo");
        Intrinsics.checkNotNullParameter(studiedDayTimestamps, "studiedDayTimestamps");
        this.pendingCount = i;
        this.mastery = f;
        this.velocity = f2;
        this.last7DaysCompletion = i2;
        this.streakInfo = streakInfo;
        this.studiedDayTimestamps = studiedDayTimestamps;
    }
}

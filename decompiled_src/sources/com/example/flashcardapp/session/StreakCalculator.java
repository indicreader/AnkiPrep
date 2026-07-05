package com.example.flashcardapp.session;

import androidx.compose.material3.CalendarModelKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.SessionRecordEntity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StreakCalculator.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\r"}, d2 = {"Lcom/example/flashcardapp/session/StreakCalculator;", "", "()V", "calculate", "Lcom/example/flashcardapp/session/StreakCalculator$StreakInfo;", "records", "", "Lcom/example/flashcardapp/data/entities/SessionRecordEntity;", "epochDayOf", "", "timestampMs", "", "StreakInfo", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class StreakCalculator {
    public static final int $stable = 0;
    public static final StreakCalculator INSTANCE = new StreakCalculator();

    private StreakCalculator() {
    }

    /* compiled from: StreakCalculator.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/example/flashcardapp/session/StreakCalculator$StreakInfo;", "", "currentStreak", "", "longestStreak", "studiedToday", "", "activeDaysLast30", "(IIZI)V", "getActiveDaysLast30", "()I", "getCurrentStreak", "getLongestStreak", "getStudiedToday", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final /* data */ class StreakInfo {
        public static final int $stable = 0;
        private final int activeDaysLast30;
        private final int currentStreak;
        private final int longestStreak;
        private final boolean studiedToday;

        public static /* synthetic */ StreakInfo copy$default(StreakInfo streakInfo, int i, int i2, boolean z, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = streakInfo.currentStreak;
            }
            if ((i4 & 2) != 0) {
                i2 = streakInfo.longestStreak;
            }
            if ((i4 & 4) != 0) {
                z = streakInfo.studiedToday;
            }
            if ((i4 & 8) != 0) {
                i3 = streakInfo.activeDaysLast30;
            }
            return streakInfo.copy(i, i2, z, i3);
        }

        /* renamed from: component1, reason: from getter */
        public final int getCurrentStreak() {
            return this.currentStreak;
        }

        /* renamed from: component2, reason: from getter */
        public final int getLongestStreak() {
            return this.longestStreak;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getStudiedToday() {
            return this.studiedToday;
        }

        /* renamed from: component4, reason: from getter */
        public final int getActiveDaysLast30() {
            return this.activeDaysLast30;
        }

        public final StreakInfo copy(int currentStreak, int longestStreak, boolean studiedToday, int activeDaysLast30) {
            return new StreakInfo(currentStreak, longestStreak, studiedToday, activeDaysLast30);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StreakInfo)) {
                return false;
            }
            StreakInfo streakInfo = (StreakInfo) other;
            return this.currentStreak == streakInfo.currentStreak && this.longestStreak == streakInfo.longestStreak && this.studiedToday == streakInfo.studiedToday && this.activeDaysLast30 == streakInfo.activeDaysLast30;
        }

        public final int getActiveDaysLast30() {
            return this.activeDaysLast30;
        }

        public final int getCurrentStreak() {
            return this.currentStreak;
        }

        public final int getLongestStreak() {
            return this.longestStreak;
        }

        public final boolean getStudiedToday() {
            return this.studiedToday;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.currentStreak) * 31) + Integer.hashCode(this.longestStreak)) * 31) + Boolean.hashCode(this.studiedToday)) * 31) + Integer.hashCode(this.activeDaysLast30);
        }

        public String toString() {
            return "StreakInfo(currentStreak=" + this.currentStreak + ", longestStreak=" + this.longestStreak + ", studiedToday=" + this.studiedToday + ", activeDaysLast30=" + this.activeDaysLast30 + ")";
        }

        public StreakInfo(int i, int i2, boolean z, int i3) {
            this.currentStreak = i;
            this.longestStreak = i2;
            this.studiedToday = z;
            this.activeDaysLast30 = i3;
        }
    }

    public final StreakInfo calculate(List<SessionRecordEntity> records) {
        Intrinsics.checkNotNullParameter(records, "records");
        int i = 0;
        if (records.isEmpty()) {
            return new StreakInfo(0, 0, false, 0);
        }
        List<SessionRecordEntity> list = records;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(INSTANCE.epochDayOf(((SessionRecordEntity) it.next()).getTimestamp())));
        }
        SortedSet sortedSet = CollectionsKt.toSortedSet(arrayList);
        int epochDayOf = epochDayOf(System.currentTimeMillis());
        boolean contains = sortedSet.contains(Integer.valueOf(epochDayOf));
        int i2 = 0;
        for (int i3 = epochDayOf; sortedSet.contains(Integer.valueOf(i3)); i3--) {
            i2++;
        }
        if (!contains) {
            i2 = 0;
            for (int i4 = epochDayOf - 1; sortedSet.contains(Integer.valueOf(i4)); i4--) {
                i2++;
            }
        }
        SortedSet<Integer> sortedSet2 = sortedSet;
        List list2 = CollectionsKt.toList(sortedSet2);
        int size = list2.size();
        int i5 = 0;
        int i6 = 1;
        for (int i7 = 1; i7 < size; i7++) {
            Integer num = (Integer) list2.get(i7);
            int intValue = ((Number) list2.get(i7 - 1)).intValue() + 1;
            if (num != null && num.intValue() == intValue) {
                i6++;
            } else {
                i5 = Math.max(i5, i6);
                i6 = 1;
            }
        }
        int max = Math.max(i5, i6);
        int i8 = epochDayOf - 29;
        if (!(sortedSet2 instanceof Collection) || !sortedSet2.isEmpty()) {
            for (Integer num2 : sortedSet2) {
                Intrinsics.checkNotNull(num2);
                int intValue2 = num2.intValue();
                if (i8 <= intValue2 && intValue2 <= epochDayOf && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return new StreakInfo(i2, max, contains, i);
    }

    private final int epochDayOf(long timestampMs) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestampMs);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return (int) (calendar.getTimeInMillis() / CalendarModelKt.MillisecondsIn24Hours);
    }
}

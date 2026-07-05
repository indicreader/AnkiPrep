package com.example.flashcardapp.session;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.SessionRecordEntity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StatsHeatmap.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004J\u001c\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004J\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002¨\u0006\u0012"}, d2 = {"Lcom/example/flashcardapp/session/StatsHeatmapProcessor;", "", "()V", "computeHeatmapData", "", "Lcom/example/flashcardapp/session/HeatmapEntry;", "records", "Lcom/example/flashcardapp/data/entities/SessionRecordEntity;", "computeLearningStats", "Lcom/example/flashcardapp/session/LearningStats;", "totalCards", "", "sessionRecords", "datesWithAllModesCompleted", "", "", "truncateToDay", "timestamp", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class StatsHeatmapProcessor {
    public static final int $stable = 0;
    public static final StatsHeatmapProcessor INSTANCE = new StatsHeatmapProcessor();

    private StatsHeatmapProcessor() {
    }

    public final List<HeatmapEntry> computeHeatmapData(List<SessionRecordEntity> records) {
        Intrinsics.checkNotNullParameter(records, "records");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (SessionRecordEntity sessionRecordEntity : records) {
            long truncateToDay = INSTANCE.truncateToDay(sessionRecordEntity.getTimestamp());
            DailyModeStats dailyModeStats = (DailyModeStats) linkedHashMap.get(Long.valueOf(truncateToDay));
            if (dailyModeStats == null) {
                dailyModeStats = new DailyModeStats(truncateToDay, 0, 0, 0, 14, null);
            }
            DailyModeStats dailyModeStats2 = dailyModeStats;
            String mode = sessionRecordEntity.getMode();
            int hashCode = mode.hashCode();
            if (hashCode != -622890693) {
                if (hashCode != 2571410) {
                    if (hashCode == 521840603 && mode.equals("REVISION")) {
                        dailyModeStats2 = DailyModeStats.copy$default(dailyModeStats2, 0L, 0, dailyModeStats2.getRevisionCount() + 1, 0, 11, null);
                    }
                } else if (mode.equals("TEST")) {
                    dailyModeStats2 = DailyModeStats.copy$default(dailyModeStats2, 0L, 0, 0, dailyModeStats2.getTestCount() + 1, 7, null);
                }
            } else if (mode.equals("PRACTICE")) {
                dailyModeStats2 = DailyModeStats.copy$default(dailyModeStats2, 0L, dailyModeStats2.getPracticeCount() + 1, 0, 0, 13, null);
            }
            linkedHashMap.put(Long.valueOf(truncateToDay), dailyModeStats2);
        }
        Collection<DailyModeStats> values = linkedHashMap.values();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(values, 10));
        for (DailyModeStats dailyModeStats3 : values) {
            arrayList.add(new HeatmapEntry(dailyModeStats3.getDate(), dailyModeStats3.getPracticeCount() > 0, dailyModeStats3.getRevisionCount() > 0, dailyModeStats3.getTestCount() > 0));
        }
        return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.example.flashcardapp.session.StatsHeatmapProcessor$computeHeatmapData$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((HeatmapEntry) t).getDate()), Long.valueOf(((HeatmapEntry) t2).getDate()));
            }
        });
    }

    public final LearningStats computeLearningStats(int totalCards, List<SessionRecordEntity> sessionRecords) {
        Intrinsics.checkNotNullParameter(sessionRecords, "sessionRecords");
        List<SessionRecordEntity> list = sessionRecords;
        Iterator<T> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((SessionRecordEntity) it.next()).getTotalQuestions();
        }
        Iterator<T> it2 = list.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            i2 += ((SessionRecordEntity) it2.next()).getScore();
        }
        float f = i > 0 ? (i2 / i) * 100.0f : 0.0f;
        Iterator<T> it3 = list.iterator();
        int i3 = 0;
        while (it3.hasNext()) {
            i3 += ((SessionRecordEntity) it3.next()).getTotalQuestions();
        }
        int max = Math.max(0, totalCards - i3);
        ArrayList<SessionRecordEntity> arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics.areEqual(((SessionRecordEntity) obj).getMode(), "REVISION")) {
                arrayList.add(obj);
            }
        }
        int i4 = 0;
        for (SessionRecordEntity sessionRecordEntity : arrayList) {
            i4 += sessionRecordEntity.getTotalQuestions() - sessionRecordEntity.getScore();
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list) {
            SessionRecordEntity sessionRecordEntity2 = (SessionRecordEntity) obj2;
            if (Intrinsics.areEqual(sessionRecordEntity2.getMode(), "PRACTICE") || Intrinsics.areEqual(sessionRecordEntity2.getMode(), "TEST")) {
                arrayList2.add(obj2);
            }
        }
        Iterator it4 = arrayList2.iterator();
        int i5 = 0;
        while (it4.hasNext()) {
            i5 += ((SessionRecordEntity) it4.next()).getScore();
        }
        return new LearningStats(i5, i4, max, i, f);
    }

    public final Set<Long> datesWithAllModesCompleted(List<SessionRecordEntity> records) {
        Intrinsics.checkNotNullParameter(records, "records");
        List<HeatmapEntry> computeHeatmapData = computeHeatmapData(records);
        ArrayList arrayList = new ArrayList();
        for (Object obj : computeHeatmapData) {
            if (((HeatmapEntry) obj).getAllModesCompleted()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(Long.valueOf(((HeatmapEntry) it.next()).getDate()));
        }
        return CollectionsKt.toSet(arrayList3);
    }

    private final long truncateToDay(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }
}

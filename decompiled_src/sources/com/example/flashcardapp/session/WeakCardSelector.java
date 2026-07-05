package com.example.flashcardapp.session;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.CardAttemptEntity;
import com.example.flashcardapp.data.entities.CardEntity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WeakCardSelector.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J0\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/example/flashcardapp/session/WeakCardSelector;", "", "()V", "MASTERY_THRESHOLD", "", "buildCardAccuracyMap", "", "", "records", "", "Lcom/example/flashcardapp/data/entities/CardAttemptEntity;", "selectWeakCards", "Lcom/example/flashcardapp/data/entities/CardEntity;", "cards", "cardAttempts", "maxCards", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class WeakCardSelector {
    public static final int $stable = 0;
    public static final WeakCardSelector INSTANCE = new WeakCardSelector();
    private static final float MASTERY_THRESHOLD = 1.0f;

    private WeakCardSelector() {
    }

    public final List<CardEntity> selectWeakCards(List<CardEntity> cards, List<CardAttemptEntity> cardAttempts, int maxCards) {
        Intrinsics.checkNotNullParameter(cards, "cards");
        Intrinsics.checkNotNullParameter(cardAttempts, "cardAttempts");
        if (cardAttempts.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        Map<Long, Float> buildCardAccuracyMap = buildCardAccuracyMap(cardAttempts);
        ArrayList arrayList = new ArrayList();
        for (CardEntity cardEntity : cards) {
            Float f = buildCardAccuracyMap.get(Long.valueOf(cardEntity.getId()));
            Pair pair = (f == null || f.floatValue() >= 1.0f) ? null : new Pair(cardEntity, f);
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        List sortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.example.flashcardapp.session.WeakCardSelector$selectWeakCards$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Float.valueOf(((Number) ((Pair) t).component2()).floatValue()), Float.valueOf(((Number) ((Pair) t2).component2()).floatValue()));
            }
        });
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith, 10));
        Iterator it = sortedWith.iterator();
        while (it.hasNext()) {
            arrayList3.add((CardEntity) ((Pair) it.next()).component1());
        }
        return CollectionsKt.take(arrayList3, maxCards);
    }

    private final Map<Long, Float> buildCardAccuracyMap(List<CardAttemptEntity> records) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (CardAttemptEntity cardAttemptEntity : records) {
            Pair pair = (Pair) linkedHashMap.get(Long.valueOf(cardAttemptEntity.getCardId()));
            if (pair == null) {
                pair = new Pair(0, 0);
            }
            linkedHashMap.put(Long.valueOf(cardAttemptEntity.getCardId()), new Pair(Integer.valueOf(((Number) pair.getFirst()).intValue() + (cardAttemptEntity.isCorrect() ? 1 : 0)), Integer.valueOf(((Number) pair.getSecond()).intValue() + 1)));
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Pair pair2 = (Pair) entry.getValue();
            int intValue = ((Number) pair2.component1()).intValue();
            int intValue2 = ((Number) pair2.component2()).intValue();
            linkedHashMap2.put(key, Float.valueOf(intValue2 > 0 ? intValue / intValue2 : 0.0f));
        }
        return linkedHashMap2;
    }
}

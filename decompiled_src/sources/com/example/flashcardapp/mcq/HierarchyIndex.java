package com.example.flashcardapp.mcq;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.CardEntity;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: McqEngine.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0083\u0002\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u0006\u0012$\u0010\f\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006\u0012$\u0010\u000e\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006\u0012$\u0010\u000f\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006\u0012\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0015\u001a\u00020\u0007J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\tJ\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0019\u001a\u00020\tJ\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tJ\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u001c\u001a\u00020\tJ\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tJ\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0017\u001a\u00020\tJ\u000e\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\f\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u000e\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u000f\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/example/flashcardapp/mcq/HierarchyIndex;", "", "allCards", "", "Lcom/example/flashcardapp/data/entities/CardEntity;", "byDeckId", "", "", "byParentPath", "", "byRootSegment", "cardTypes", "byDeckIdAndType", "Lkotlin/Pair;", "byParentPathAndType", "byRootSegmentAndType", "byType", "(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getAllCards", "()Ljava/util/List;", "getByDeckId", "deckId", "getByDeckIdAndType", "type", "getByParentPath", "parentPath", "getByParentPathAndType", "getByRootSegment", "root", "getByRootSegmentAndType", "getByType", "getType", "cardId", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class HierarchyIndex {
    private final List<CardEntity> allCards;
    private final Map<Long, List<CardEntity>> byDeckId;
    private final Map<Pair<Long, String>, List<CardEntity>> byDeckIdAndType;
    private final Map<String, List<CardEntity>> byParentPath;
    private final Map<Pair<String, String>, List<CardEntity>> byParentPathAndType;
    private final Map<String, List<CardEntity>> byRootSegment;
    private final Map<Pair<String, String>, List<CardEntity>> byRootSegmentAndType;
    private final Map<String, List<CardEntity>> byType;
    private final Map<Long, String> cardTypes;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ HierarchyIndex(List list, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Map map7, Map map8, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, map, map2, map3, map4, map5, map6, map7, map8);
    }

    public final List<CardEntity> getAllCards() {
        return this.allCards;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private HierarchyIndex(List<CardEntity> list, Map<Long, ? extends List<CardEntity>> map, Map<String, ? extends List<CardEntity>> map2, Map<String, ? extends List<CardEntity>> map3, Map<Long, String> map4, Map<Pair<Long, String>, ? extends List<CardEntity>> map5, Map<Pair<String, String>, ? extends List<CardEntity>> map6, Map<Pair<String, String>, ? extends List<CardEntity>> map7, Map<String, ? extends List<CardEntity>> map8) {
        this.allCards = list;
        this.byDeckId = map;
        this.byParentPath = map2;
        this.byRootSegment = map3;
        this.cardTypes = map4;
        this.byDeckIdAndType = map5;
        this.byParentPathAndType = map6;
        this.byRootSegmentAndType = map7;
        this.byType = map8;
    }

    /* compiled from: McqEngine.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/example/flashcardapp/mcq/HierarchyIndex$Companion;", "", "()V", "buildAsync", "Lcom/example/flashcardapp/mcq/HierarchyIndex;", "cards", "", "Lcom/example/flashcardapp/data/entities/CardEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Object buildAsync(List<CardEntity> list, Continuation<? super HierarchyIndex> continuation) {
            return BuildersKt.withContext(Dispatchers.getDefault(), new HierarchyIndex$Companion$buildAsync$2(list, null), continuation);
        }
    }

    public final List<CardEntity> getByDeckId(long deckId) {
        List<CardEntity> list = this.byDeckId.get(Long.valueOf(deckId));
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final List<CardEntity> getByParentPath(String parentPath) {
        Intrinsics.checkNotNullParameter(parentPath, "parentPath");
        List<CardEntity> list = this.byParentPath.get(parentPath);
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final List<CardEntity> getByRootSegment(String root) {
        Intrinsics.checkNotNullParameter(root, "root");
        List<CardEntity> list = this.byRootSegment.get(root);
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final String getType(long cardId) {
        String str = this.cardTypes.get(Long.valueOf(cardId));
        return str == null ? "concept" : str;
    }

    public final List<CardEntity> getByDeckIdAndType(long deckId, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        List<CardEntity> list = this.byDeckIdAndType.get(TuplesKt.to(Long.valueOf(deckId), type));
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final List<CardEntity> getByParentPathAndType(String parentPath, String type) {
        Intrinsics.checkNotNullParameter(parentPath, "parentPath");
        Intrinsics.checkNotNullParameter(type, "type");
        List<CardEntity> list = this.byParentPathAndType.get(TuplesKt.to(parentPath, type));
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final List<CardEntity> getByRootSegmentAndType(String root, String type) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(type, "type");
        List<CardEntity> list = this.byRootSegmentAndType.get(TuplesKt.to(root, type));
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final List<CardEntity> getByType(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        List<CardEntity> list = this.byType.get(type);
        return list == null ? CollectionsKt.emptyList() : list;
    }
}

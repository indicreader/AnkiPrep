package com.example.flashcardapp.mcq;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.DeckHierarchyUtils;
import com.example.flashcardapp.data.entities.CardEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: McqEngine.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/example/flashcardapp/mcq/HierarchyIndex;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.mcq.HierarchyIndex$Companion$buildAsync$2", f = "McqEngine.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {518}, m = "invokeSuspend", n = {"byDeckId", "byParentPath", "byRootSegment", "byDeckIdAndType", "byParentPathAndType", "byRootSegmentAndType", "byType"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
/* loaded from: classes2.dex */
public final class HierarchyIndex$Companion$buildAsync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HierarchyIndex>, Object> {
    final /* synthetic */ List<CardEntity> $cards;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HierarchyIndex$Companion$buildAsync$2(List<CardEntity> list, Continuation<? super HierarchyIndex$Companion$buildAsync$2> continuation) {
        super(2, continuation);
        this.$cards = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HierarchyIndex$Companion$buildAsync$2 hierarchyIndex$Companion$buildAsync$2 = new HierarchyIndex$Companion$buildAsync$2(this.$cards, continuation);
        hierarchyIndex$Companion$buildAsync$2.L$0 = obj;
        return hierarchyIndex$Companion$buildAsync$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HierarchyIndex> continuation) {
        return ((HierarchyIndex$Companion$buildAsync$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v20, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v16, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.util.Map] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object awaitAll;
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2;
        Map map;
        LinkedHashMap linkedHashMap3;
        LinkedHashMap linkedHashMap4;
        LinkedHashMap linkedHashMap5;
        LinkedHashMap linkedHashMap6;
        Deferred async$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ?? r1 = (Map) this.L$6;
            ?? r2 = (Map) this.L$5;
            ?? r5 = (Map) this.L$4;
            ?? r6 = (Map) this.L$3;
            map = (Map) this.L$2;
            ?? r8 = (Map) this.L$1;
            ?? r9 = (Map) this.L$0;
            ResultKt.throwOnFailure(obj);
            linkedHashMap5 = r1;
            linkedHashMap6 = r2;
            linkedHashMap4 = r5;
            linkedHashMap = r9;
            awaitAll = obj;
            linkedHashMap3 = r6;
            linkedHashMap2 = r8;
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            List<CardEntity> list = this.$cards;
            LinkedHashMap linkedHashMap7 = new LinkedHashMap();
            for (Object obj2 : list) {
                Long boxLong = Boxing.boxLong(((CardEntity) obj2).getDeckId());
                Object obj3 = linkedHashMap7.get(boxLong);
                if (obj3 == null) {
                    obj3 = (List) new ArrayList();
                    linkedHashMap7.put(boxLong, obj3);
                }
                ((List) obj3).add(obj2);
            }
            LinkedHashMap linkedHashMap8 = new LinkedHashMap();
            LinkedHashMap linkedHashMap9 = new LinkedHashMap();
            LinkedHashMap linkedHashMap10 = new LinkedHashMap();
            LinkedHashMap linkedHashMap11 = new LinkedHashMap();
            LinkedHashMap linkedHashMap12 = new LinkedHashMap();
            LinkedHashMap linkedHashMap13 = new LinkedHashMap();
            List<CardEntity> list2 = this.$cards;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                ArrayList arrayList2 = arrayList;
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new HierarchyIndex$Companion$buildAsync$2$deferreds$1$1((CardEntity) it.next(), null), 3, null);
                arrayList2.add(async$default);
                linkedHashMap13 = linkedHashMap13;
                linkedHashMap12 = linkedHashMap12;
                arrayList = arrayList2;
            }
            LinkedHashMap linkedHashMap14 = linkedHashMap13;
            LinkedHashMap linkedHashMap15 = linkedHashMap12;
            this.L$0 = linkedHashMap7;
            this.L$1 = linkedHashMap8;
            this.L$2 = linkedHashMap9;
            this.L$3 = linkedHashMap10;
            this.L$4 = linkedHashMap11;
            this.L$5 = linkedHashMap15;
            this.L$6 = linkedHashMap14;
            this.label = 1;
            awaitAll = AwaitKt.awaitAll(arrayList, this);
            if (awaitAll == coroutine_suspended) {
                return coroutine_suspended;
            }
            linkedHashMap = linkedHashMap7;
            linkedHashMap2 = linkedHashMap8;
            map = linkedHashMap9;
            linkedHashMap3 = linkedHashMap10;
            linkedHashMap4 = linkedHashMap11;
            linkedHashMap5 = linkedHashMap14;
            linkedHashMap6 = linkedHashMap15;
        }
        List<Pair> list3 = (List) awaitAll;
        List<Pair> list4 = list3;
        LinkedHashMap linkedHashMap16 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list4, 10)), 16));
        for (Pair pair : list4) {
            Pair pair2 = TuplesKt.to(Boxing.boxLong(((CardEntity) pair.getFirst()).getId()), pair.getSecond());
            linkedHashMap16.put(pair2.getFirst(), pair2.getSecond());
        }
        for (Pair pair3 : list3) {
            CardEntity cardEntity = (CardEntity) pair3.component1();
            String str = (String) pair3.component2();
            List<String> parseDeckHierarchy = DeckHierarchyUtils.INSTANCE.parseDeckHierarchy(cardEntity.getDeckHierarchy());
            Object obj4 = linkedHashMap5.get(str);
            if (obj4 == null) {
                obj4 = (List) new ArrayList();
                linkedHashMap5.put(str, obj4);
            }
            ((List) obj4).add(cardEntity);
            Pair pair4 = TuplesKt.to(Boxing.boxLong(cardEntity.getDeckId()), str);
            Object obj5 = linkedHashMap3.get(pair4);
            if (obj5 == null) {
                obj5 = (List) new ArrayList();
                linkedHashMap3.put(pair4, obj5);
            }
            ((List) obj5).add(cardEntity);
            if (parseDeckHierarchy.size() > 1) {
                String joinToString$default = CollectionsKt.joinToString$default(CollectionsKt.dropLast(parseDeckHierarchy, 1), "::", null, null, 0, null, null, 62, null);
                Object obj6 = linkedHashMap2.get(joinToString$default);
                if (obj6 == null) {
                    obj6 = (List) new ArrayList();
                    linkedHashMap2.put(joinToString$default, obj6);
                }
                ((List) obj6).add(cardEntity);
                Pair pair5 = TuplesKt.to(joinToString$default, str);
                Object obj7 = linkedHashMap4.get(pair5);
                if (obj7 == null) {
                    obj7 = (List) new ArrayList();
                    linkedHashMap4.put(pair5, obj7);
                }
                ((List) obj7).add(cardEntity);
            }
            String str2 = (String) CollectionsKt.firstOrNull((List) parseDeckHierarchy);
            if (str2 != null) {
                Object obj8 = map.get(str2);
                if (obj8 == null) {
                    obj8 = (List) new ArrayList();
                    map.put(str2, obj8);
                }
                ((List) obj8).add(cardEntity);
                Pair pair6 = TuplesKt.to(str2, str);
                Object obj9 = linkedHashMap6.get(pair6);
                if (obj9 == null) {
                    obj9 = (List) new ArrayList();
                    linkedHashMap6.put(pair6, obj9);
                }
                ((List) obj9).add(cardEntity);
            }
        }
        return new HierarchyIndex(this.$cards, linkedHashMap, linkedHashMap2, map, linkedHashMap16, linkedHashMap3, linkedHashMap4, linkedHashMap6, linkedHashMap5, null);
    }
}

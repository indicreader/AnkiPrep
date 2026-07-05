package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyStaggeredGridItemPlacementAnimator.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0004J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\tH\u0002JL\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020\u001bJ\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006,"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemPlacementAnimator;", "", "()V", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/lazy/staggeredgrid/ItemInfo;", "movingAwayKeys", "Landroidx/collection/MutableScatterSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;)Z", "getAnimation", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "key", "placeableIndex", "initializeAnimation", "", "item", "mainAxisOffset", "itemInfo", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "isVertical", "laneCount", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "reset", "startAnimationsIfNeeded", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyStaggeredGridItemPlacementAnimator {
    public static final int $stable = 8;
    private int firstVisibleIndex;
    private final MutableScatterMap<Object, ItemInfo> keyToItemInfoMap = ScatterMapKt.mutableScatterMapOf();
    private LazyLayoutKeyIndexMap keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
    private final MutableScatterSet<Object> movingAwayKeys = ScatterSetKt.mutableScatterSetOf();
    private final List<LazyStaggeredGridMeasuredItem> movingInFromStartBound = new ArrayList();
    private final List<LazyStaggeredGridMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyStaggeredGridMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyStaggeredGridMeasuredItem> movingAwayToEndBound = new ArrayList();

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
        this.firstVisibleIndex = -1;
    }

    static /* synthetic */ void initializeAnimation$default(LazyStaggeredGridItemPlacementAnimator lazyStaggeredGridItemPlacementAnimator, LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem, int i, ItemInfo itemInfo, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            ItemInfo itemInfo2 = lazyStaggeredGridItemPlacementAnimator.keyToItemInfoMap.get(lazyStaggeredGridMeasuredItem.getKey());
            Intrinsics.checkNotNull(itemInfo2);
            itemInfo = itemInfo2;
        }
        lazyStaggeredGridItemPlacementAnimator.initializeAnimation(lazyStaggeredGridMeasuredItem, i, itemInfo);
    }

    private final void initializeAnimation(LazyStaggeredGridMeasuredItem item, int mainAxisOffset, ItemInfo itemInfo) {
        long m5862copyiSbpLlY$default;
        long offset = item.getOffset();
        if (item.getIsVertical()) {
            m5862copyiSbpLlY$default = IntOffset.m5862copyiSbpLlY$default(offset, 0, mainAxisOffset, 1, null);
        } else {
            m5862copyiSbpLlY$default = IntOffset.m5862copyiSbpLlY$default(offset, mainAxisOffset, 0, 2, null);
        }
        for (LazyLayoutAnimation lazyLayoutAnimation : itemInfo.getAnimations()) {
            if (lazyLayoutAnimation != null) {
                long offset2 = item.getOffset();
                long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5866getXimpl(offset2) - IntOffset.m5866getXimpl(offset), IntOffset.m5867getYimpl(offset2) - IntOffset.m5867getYimpl(offset));
                lazyLayoutAnimation.m722setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m5866getXimpl(m5862copyiSbpLlY$default) + IntOffset.m5866getXimpl(IntOffset), IntOffset.m5867getYimpl(m5862copyiSbpLlY$default) + IntOffset.m5867getYimpl(IntOffset)));
            }
        }
    }

    private final void startAnimationsIfNeeded(LazyStaggeredGridMeasuredItem item) {
        ItemInfo itemInfo = this.keyToItemInfoMap.get(item.getKey());
        Intrinsics.checkNotNull(itemInfo);
        for (LazyLayoutAnimation lazyLayoutAnimation : itemInfo.getAnimations()) {
            if (lazyLayoutAnimation != null) {
                long offset = item.getOffset();
                long rawOffset = lazyLayoutAnimation.getRawOffset();
                if (!IntOffset.m5865equalsimpl0(rawOffset, LazyLayoutAnimation.INSTANCE.m723getNotInitializednOccac()) && !IntOffset.m5865equalsimpl0(rawOffset, offset)) {
                    lazyLayoutAnimation.m717animatePlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m5866getXimpl(offset) - IntOffset.m5866getXimpl(rawOffset), IntOffset.m5867getYimpl(offset) - IntOffset.m5867getYimpl(rawOffset)));
                }
                lazyLayoutAnimation.m722setRawOffsetgyyYBs(offset);
            }
        }
    }

    public final LazyLayoutAnimation getAnimation(Object key, int placeableIndex) {
        ItemInfo itemInfo;
        LazyLayoutAnimation[] animations;
        if (this.keyToItemInfoMap.isEmpty() || (itemInfo = this.keyToItemInfoMap.get(key)) == null || (animations = itemInfo.getAnimations()) == null) {
            return null;
        }
        return animations[placeableIndex];
    }

    private final boolean getHasAnimations(LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem) {
        int placeablesCount = lazyStaggeredGridMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            if (LazyStaggeredGridItemPlacementAnimatorKt.access$getSpecs(lazyStaggeredGridMeasuredItem.getParentData(i)) != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x02b1, code lost:
    
        if (r2 < 0) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x02b3, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02b4, code lost:
    
        r4 = r0[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02be, code lost:
    
        if (((((~r4) << 7) & r4) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02c0, code lost:
    
        r12 = 8 - ((~(r3 - r2)) >>> 31);
        r13 = r4;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02cb, code lost:
    
        if (r4 >= r12) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02d5, code lost:
    
        if ((r13 & 255) >= 128) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02d7, code lost:
    
        r5 = r1[(r3 << 3) + r4];
        r15 = r30.keyToItemInfoMap.get(r5);
        kotlin.jvm.internal.Intrinsics.checkNotNull(r15);
        r15 = r15;
        r9 = r30.keyIndexMap.getIndex(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02ed, code lost:
    
        if (r9 != r8) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x003c, code lost:
    
        r30.firstVisibleIndex = r3;
        r9 = r30.keyIndexMap;
        r30.keyIndexMap = r35.getKeyIndexMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02ef, code lost:
    
        r30.keyToItemInfoMap.remove(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x02f5, code lost:
    
        r21 = r0;
        r22 = r1;
        r0 = r35.m774getAndMeasurejy6DScQ(r9, androidx.compose.foundation.lazy.staggeredgrid.SpanRange.m779constructorimpl(r15.getLane(), r15.getSpan()));
        r0.setNonScrollableItem(true);
        r15 = r15.getAnimations();
        r1 = r15.length;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0315, code lost:
    
        if (r8 >= r1) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0317, code lost:
    
        r25 = r15[r8];
        r26 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x031b, code lost:
    
        if (r25 == null) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x031d, code lost:
    
        r36 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0324, code lost:
    
        if (r25.isPlacementAnimationInProgress() != true) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x033e, code lost:
    
        if (r9 >= r30.firstVisibleIndex) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0046, code lost:
    
        if (r36 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0340, code lost:
    
        r30.movingAwayToStartBound.add(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0350, code lost:
    
        r13 = r13 >> 8;
        r4 = r4 + 1;
        r0 = r21;
        r1 = r22;
        r8 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0346, code lost:
    
        r30.movingAwayToEndBound.add(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0329, code lost:
    
        r8 = r8 + 1;
        r15 = r36;
        r1 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0327, code lost:
    
        r36 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0048, code lost:
    
        r10 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0334, code lost:
    
        if (r9 != r11.getIndex(r5)) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0336, code lost:
    
        r30.keyToItemInfoMap.remove(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x034c, code lost:
    
        r21 = r0;
        r22 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x035d, code lost:
    
        r21 = r0;
        r22 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0367, code lost:
    
        if (r12 != 8) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0374, code lost:
    
        if (r3 == r2) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004d, code lost:
    
        if (r36 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0376, code lost:
    
        r3 = r3 + 1;
        r0 = r21;
        r1 = r22;
        r8 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x036a, code lost:
    
        r21 = r0;
        r22 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x038a, code lost:
    
        if ((!r30.movingAwayToStartBound.isEmpty()) == false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x038c, code lost:
    
        r0 = r30.movingAwayToStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0392, code lost:
    
        if (r0.size() <= 1) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0394, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r0, new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2(r30));
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x039e, code lost:
    
        r0 = r30.movingAwayToStartBound;
        r1 = r0.size();
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:
    
        r3 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(0, r31);
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x03a5, code lost:
    
        if (r2 >= r1) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x03a7, code lost:
    
        r3 = r0.get(r2);
        r4 = r3.getLane();
        r7[r4] = r7[r4] + r3.getMainAxisSize();
        r8 = 0 - r7[r3.getLane()];
        r4 = r30.keyToItemInfoMap.get(r3.getKey());
        kotlin.jvm.internal.Intrinsics.checkNotNull(r4);
        r3.position(r8, r4.getCrossAxisOffset(), r10);
        r34.add(r3);
        startAnimationsIfNeeded(r3);
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x03e4, code lost:
    
        r4 = r34;
        r5 = 0;
        kotlin.collections.ArraysKt.fill$default(r7, 0, 0, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0404, code lost:
    
        if ((!r30.movingAwayToEndBound.isEmpty()) == false) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0406, code lost:
    
        r0 = r30.movingAwayToEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x040c, code lost:
    
        if (r0.size() <= 1) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x040e, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r0, new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortBy$2(r30));
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0418, code lost:
    
        r0 = r30.movingAwayToEndBound;
        r1 = r0.size();
        r8 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
    
        r0 = r30.keyToItemInfoMap;
        r5 = r0.keys;
        r0 = r0.metadata;
        r11 = r0.length - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x041f, code lost:
    
        if (r8 >= r1) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0421, code lost:
    
        r2 = r0.get(r8);
        r3 = r7[r2.getLane()] + r10;
        r5 = r2.getLane();
        r7[r5] = r7[r5] + r2.getMainAxisSize();
        r5 = r30.keyToItemInfoMap.get(r2.getKey());
        kotlin.jvm.internal.Intrinsics.checkNotNull(r5);
        r2.position(r3, r5.getCrossAxisOffset(), r10);
        r4.add(r2);
        startAnimationsIfNeeded(r2);
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x045a, code lost:
    
        r30.movingInFromStartBound.clear();
        r30.movingInFromEndBound.clear();
        r30.movingAwayToStartBound.clear();
        r30.movingAwayToEndBound.clear();
        r30.movingAwayKeys.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0473, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x03f7, code lost:
    
        r4 = r34;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x01fd, code lost:
    
        r11 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0244, code lost:
    
        r11 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
    
        if (r11 < 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x00b7, code lost:
    
        r22 = r0;
        r21 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x00c5, code lost:
    
        r13 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0054, code lost:
    
        r3 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r31, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x004b, code lost:
    
        r10 = r32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x003b, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006c, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006d, code lost:
    
        r14 = r0[r12];
        r13 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0078, code lost:
    
        if (((((~r14) << 7) & r14) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007a, code lost:
    
        r8 = 8 - ((~(r12 - r11)) >>> 31);
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0084, code lost:
    
        if (r9 >= r8) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008e, code lost:
    
        if ((r14 & 255) >= 128) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
    
        r22 = r0;
        r21 = r5;
        r30.movingAwayKeys.add(r5[(r12 << 3) + r9]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a4, code lost:
    
        r14 = r14 >> 8;
        r9 = r9 + 1;
        r5 = r21;
        r0 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a0, code lost:
    
        r22 = r0;
        r21 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ae, code lost:
    
        r22 = r0;
        r21 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b4, code lost:
    
        if (r8 != 8) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00bb, code lost:
    
        if (r12 == r11) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bd, code lost:
    
        r12 = r12 + 1;
        r9 = r13;
        r5 = r21;
        r0 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c6, code lost:
    
        r0 = r34.size();
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00cb, code lost:
    
        r8 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00cc, code lost:
    
        if (r5 >= r0) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ce, code lost:
    
        r9 = r7.get(r5);
        r30.movingAwayKeys.remove(r9.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e1, code lost:
    
        if (getHasAnimations(r9) == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e3, code lost:
    
        r11 = r30.keyToItemInfoMap.get(r9.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ef, code lost:
    
        if (r11 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f1, code lost:
    
        r11 = new androidx.compose.foundation.lazy.staggeredgrid.ItemInfo(r9.getLane(), r9.getSpan(), r9.getCrossAxisOffset());
        r11.updateAnimation(r9, r38);
        r30.keyToItemInfoMap.set(r9.getKey(), r11);
        r14 = r13.getIndex(r9.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0118, code lost:
    
        if (r14 == (-1)) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x011e, code lost:
    
        if (r9.getIndex() == r14) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0120, code lost:
    
        if (r14 >= r2) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0122, code lost:
    
        r30.movingInFromStartBound.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0144, code lost:
    
        r36 = r0;
        r23 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01c5, code lost:
    
        r5 = r5 + 1;
        r7 = r34;
        r0 = r36;
        r13 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0128, code lost:
    
        r30.movingInFromEndBound.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012e, code lost:
    
        r14 = r9.mo759getOffsetnOccac();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0136, code lost:
    
        if (r9.isVertical() == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0138, code lost:
    
        r8 = androidx.compose.ui.unit.IntOffset.m5867getYimpl(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0141, code lost:
    
        initializeAnimation(r9, r8, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x013d, code lost:
    
        r8 = androidx.compose.ui.unit.IntOffset.m5866getXimpl(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x014a, code lost:
    
        r8 = r11.getAnimations();
        r14 = r8.length;
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0152, code lost:
    
        if (r15 >= r14) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0154, code lost:
    
        r36 = r0;
        r0 = r8[r15];
        r21 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x015a, code lost:
    
        if (r0 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x015c, code lost:
    
        r23 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x016c, code lost:
    
        if (androidx.compose.ui.unit.IntOffset.m5865equalsimpl0(r0.getRawOffset(), androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.INSTANCE.m723getNotInitializednOccac()) != false) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x016e, code lost:
    
        r7 = r0.getRawOffset();
        r0.m722setRawOffsetgyyYBs(androidx.compose.ui.unit.IntOffsetKt.IntOffset(androidx.compose.ui.unit.IntOffset.m5866getXimpl(r7) + androidx.compose.ui.unit.IntOffset.m5866getXimpl(r3), androidx.compose.ui.unit.IntOffset.m5867getYimpl(r7) + androidx.compose.ui.unit.IntOffset.m5867getYimpl(r3)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x018e, code lost:
    
        r15 = r15 + 1;
        r0 = r36;
        r8 = r21;
        r13 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x018c, code lost:
    
        r23 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x019b, code lost:
    
        r36 = r0;
        r23 = r13;
        r11.setLane(r9.getLane());
        r11.setSpan(r9.getSpan());
        r11.setCrossAxisOffset(r9.getCrossAxisOffset());
        startAnimationsIfNeeded(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01b8, code lost:
    
        r36 = r0;
        r23 = r13;
        r30.keyToItemInfoMap.remove(r9.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01cf, code lost:
    
        r23 = r13;
        r7 = new int[r37];
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01d4, code lost:
    
        if (r0 >= r37) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01d6, code lost:
    
        r7[r0] = 0;
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
    
        r2 = r30.firstVisibleIndex;
        r3 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) kotlin.collections.CollectionsKt.firstOrNull((java.util.List) r34);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01e6, code lost:
    
        if ((!r30.movingInFromStartBound.isEmpty()) == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01e8, code lost:
    
        r0 = r30.movingInFromStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01ee, code lost:
    
        if (r0.size() <= 1) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01f0, code lost:
    
        r11 = r23;
        kotlin.collections.CollectionsKt.sortWith(r0, new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01ff, code lost:
    
        r12 = r30.movingInFromStartBound;
        r13 = r12.size();
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0206, code lost:
    
        if (r14 >= r13) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0208, code lost:
    
        r15 = r12.get(r14);
        r0 = r15.getLane();
        r7[r0] = r7[r0] + r15.getMainAxisSize();
        initializeAnimation$default(r30, r15, 0 - r7[r15.getLane()], null, 4, null);
        startAnimationsIfNeeded(r15);
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0234, code lost:
    
        kotlin.collections.ArraysKt.fill$default(r7, 0, 0, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0034, code lost:
    
        if (r3 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x024f, code lost:
    
        if ((!r30.movingInFromEndBound.isEmpty()) == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0251, code lost:
    
        r0 = r30.movingInFromEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0257, code lost:
    
        if (r0.size() <= 1) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0259, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r0, new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortBy$1(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0263, code lost:
    
        r12 = r30.movingInFromEndBound;
        r13 = r12.size();
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x026a, code lost:
    
        if (r14 >= r13) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x026c, code lost:
    
        r15 = r12.get(r14);
        r2 = r10 + r7[r15.getLane()];
        r0 = r15.getLane();
        r7[r0] = r7[r0] + r15.getMainAxisSize();
        initializeAnimation$default(r30, r15, r2, null, 4, null);
        startAnimationsIfNeeded(r15);
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0297, code lost:
    
        kotlin.collections.ArraysKt.fill$default(r7, 0, 0, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x02a6, code lost:
    
        r0 = r30.movingAwayKeys;
        r1 = r0.elements;
        r0 = r0.metadata;
        r2 = r0.length - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
    
        r3 = r3.getIndex();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasured(int r31, int r32, int r33, java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r34, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider r35, boolean r36, int r37, kotlinx.coroutines.CoroutineScope r38) {
        /*
            Method dump skipped, instructions count: 1140
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator.onMeasured(int, int, int, java.util.List, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider, boolean, int, kotlinx.coroutines.CoroutineScope):void");
    }
}

package androidx.compose.foundation.lazy.grid;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimationSpecsNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyGridItemPlacementAnimator.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0004J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\tH\u0002JL\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020\u001bJ\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006-"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "", "()V", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/lazy/grid/ItemInfo;", "movingAwayKeys", "Landroidx/collection/MutableScatterSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;)Z", "getAnimation", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "key", "placeableIndex", "initializeAnimation", "", "item", "mainAxisOffset", "itemInfo", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "isVertical", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "reset", "startAnimationsIfNeeded", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyGridItemPlacementAnimator {
    public static final int $stable = 8;
    private int firstVisibleIndex;
    private final MutableScatterMap<Object, ItemInfo> keyToItemInfoMap = ScatterMapKt.mutableScatterMapOf();
    private LazyLayoutKeyIndexMap keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
    private final MutableScatterSet<Object> movingAwayKeys = ScatterSetKt.mutableScatterSetOf();
    private final List<LazyGridMeasuredItem> movingInFromStartBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingAwayToEndBound = new ArrayList();

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
        this.firstVisibleIndex = -1;
    }

    static /* synthetic */ void initializeAnimation$default(LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, LazyGridMeasuredItem lazyGridMeasuredItem, int i, ItemInfo itemInfo, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            ItemInfo itemInfo2 = lazyGridItemPlacementAnimator.keyToItemInfoMap.get(lazyGridMeasuredItem.getKey());
            Intrinsics.checkNotNull(itemInfo2);
            itemInfo = itemInfo2;
        }
        lazyGridItemPlacementAnimator.initializeAnimation(lazyGridMeasuredItem, i, itemInfo);
    }

    private final void initializeAnimation(LazyGridMeasuredItem item, int mainAxisOffset, ItemInfo itemInfo) {
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

    private final void startAnimationsIfNeeded(LazyGridMeasuredItem item) {
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

    private final boolean getHasAnimations(LazyGridMeasuredItem lazyGridMeasuredItem) {
        LazyLayoutAnimationSpecsNode specs;
        int placeablesCount = lazyGridMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            specs = LazyGridItemPlacementAnimatorKt.getSpecs(lazyGridMeasuredItem.getParentData(i));
            if (specs != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x025c, code lost:
    
        if (r3 == (-1)) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x025e, code lost:
    
        if (r3 != r0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0260, code lost:
    
        r14 = r0;
        r15 = java.lang.Math.max(r1, r12.getMainAxisSize());
        r24 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0276, code lost:
    
        initializeAnimation$default(r34, r12, r26 + r24, null, 4, null);
        startAnimationsIfNeeded(r12);
        r11 = r11 + 1;
        r0 = r14;
        r1 = r15;
        r2 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x026d, code lost:
    
        r15 = r12.getMainAxisSize();
        r24 = r2 + r1;
        r14 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0258, code lost:
    
        r3 = r12.getColumn();
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x028b, code lost:
    
        r0 = r34.movingAwayKeys;
        r1 = r0.elements;
        r0 = r0.metadata;
        r2 = r0.length - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x003c, code lost:
    
        r34.firstVisibleIndex = r2;
        r10 = r34.keyIndexMap;
        r34.keyIndexMap = r39.getKeyIndexMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0296, code lost:
    
        if (r2 < 0) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0298, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0299, code lost:
    
        r4 = r0[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x02a3, code lost:
    
        if (((((~r4) << 7) & r4) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02a5, code lost:
    
        r8 = 8 - ((~(r3 - r2)) >>> 31);
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02af, code lost:
    
        if (r10 >= r8) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02b9, code lost:
    
        if ((r4 & 255) >= 128) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x02bb, code lost:
    
        r14 = r1[(r3 << 3) + r10];
        r15 = r34.keyToItemInfoMap.get(r14);
        kotlin.jvm.internal.Intrinsics.checkNotNull(r15);
        r15 = r15;
        r11 = r34.keyIndexMap.getIndex(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02d1, code lost:
    
        if (r11 != r9) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0046, code lost:
    
        if (r41 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x02d3, code lost:
    
        r34.keyToItemInfoMap.remove(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02dc, code lost:
    
        if (r41 == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02de, code lost:
    
        r27 = androidx.compose.ui.unit.Constraints.INSTANCE.m5704fixedWidthOenEA2s(r15.getCrossAxisSize());
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02f3, code lost:
    
        r9 = androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider.m710getAndMeasure3p2s80s$default(r39, r11, 0, r27, 2, null);
        r9.setNonScrollableItem(r7);
        r12 = r15.getAnimations();
        r15 = r12.length;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x030a, code lost:
    
        if (r7 >= r15) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x030c, code lost:
    
        r25 = r12[r7];
        r27 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0310, code lost:
    
        if (r25 == null) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0312, code lost:
    
        r0 = r25.isPlacementAnimationInProgress();
        r25 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0319, code lost:
    
        if (r0 != true) goto L197;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0048, code lost:
    
        r11 = r37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0337, code lost:
    
        if (r11 >= r34.firstVisibleIndex) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0339, code lost:
    
        r34.movingAwayToStartBound.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0349, code lost:
    
        r4 = r4 >> 8;
        r10 = r10 + 1;
        r1 = r25;
        r0 = r27;
        r7 = true;
        r9 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x033f, code lost:
    
        r34.movingAwayToEndBound.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x031e, code lost:
    
        r7 = r7 + 1;
        r1 = r25;
        r0 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004d, code lost:
    
        if (r41 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x031c, code lost:
    
        r25 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0325, code lost:
    
        r27 = r0;
        r25 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x032d, code lost:
    
        if (r11 != r13.getIndex(r14)) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x032f, code lost:
    
        r34.keyToItemInfoMap.remove(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x02e9, code lost:
    
        r27 = androidx.compose.ui.unit.Constraints.INSTANCE.m5703fixedHeightOenEA2s(r15.getCrossAxisSize());
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0345, code lost:
    
        r27 = r0;
        r25 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:
    
        r2 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(0, r35);
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0356, code lost:
    
        r27 = r0;
        r25 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x035e, code lost:
    
        if (r8 != 8) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0369, code lost:
    
        if (r3 == r2) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x036b, code lost:
    
        r3 = r3 + 1;
        r1 = r25;
        r0 = r27;
        r7 = true;
        r9 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0361, code lost:
    
        r27 = r0;
        r25 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0375, code lost:
    
        r0 = r34.movingAwayToStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x037c, code lost:
    
        if (r0.size() <= 1) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
    
        r0 = r34.keyToItemInfoMap;
        r4 = r0.keys;
        r0 = r0.metadata;
        r5 = r0.length - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x037e, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r0, new androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2(r34));
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0388, code lost:
    
        r0 = r34.movingAwayToStartBound;
        r1 = r0.size();
        r2 = 0;
        r3 = -1;
        r4 = 0;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0392, code lost:
    
        if (r2 >= r1) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0394, code lost:
    
        r7 = r0.get(r2);
        r8 = r40.getLineIndexOfItem(r7.getIndex());
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x03a5, code lost:
    
        if (r8 == (-1)) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x03a7, code lost:
    
        if (r8 != r3) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x03a9, code lost:
    
        r4 = java.lang.Math.max(r4, r7.getMainAxisSize());
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x03b9, code lost:
    
        r9 = (0 - r5) - r7.getMainAxisSize();
        r8 = r34.keyToItemInfoMap.get(r7.getKey());
        kotlin.jvm.internal.Intrinsics.checkNotNull(r8);
        r7.position(r9, r8.getCrossAxisOffset(), r36, r37, (r16 & 16) != 0 ? -1 : 0, (r16 & 32) != 0 ? -1 : 0);
        r38.add(r7);
        startAnimationsIfNeeded(r7);
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x03b2, code lost:
    
        r5 = r5 + r4;
        r4 = r7.getMainAxisSize();
        r3 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
    
        if (r5 < 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x03f1, code lost:
    
        r0 = r34.movingAwayToEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x03fa, code lost:
    
        if (r0.size() <= 1) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x03fc, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r0, new androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$2(r34));
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0406, code lost:
    
        r0 = r34.movingAwayToEndBound;
        r1 = r0.size();
        r2 = -1;
        r3 = 0;
        r9 = 0;
        r19 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0411, code lost:
    
        if (r9 >= r1) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0413, code lost:
    
        r4 = r0.get(r9);
        r5 = r40.getLineIndexOfItem(r4.getIndex());
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0424, code lost:
    
        if (r5 == (-1)) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0426, code lost:
    
        if (r5 != r2) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006c, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0428, code lost:
    
        r3 = java.lang.Math.max(r3, r4.getMainAxisSize());
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0439, code lost:
    
        r5 = r34.keyToItemInfoMap.get(r4.getKey());
        kotlin.jvm.internal.Intrinsics.checkNotNull(r5);
        r4.position(r26 + r19, r5.getCrossAxisOffset(), r36, r37, (r16 & 16) != 0 ? -1 : 0, (r16 & 32) != 0 ? -1 : 0);
        r38.add(r4);
        startAnimationsIfNeeded(r4);
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0431, code lost:
    
        r19 = r19 + r3;
        r3 = r4.getMainAxisSize();
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0469, code lost:
    
        r34.movingInFromStartBound.clear();
        r34.movingInFromEndBound.clear();
        r34.movingAwayToStartBound.clear();
        r34.movingAwayToEndBound.clear();
        r34.movingAwayKeys.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0482, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006d, code lost:
    
        r14 = r0[r12];
        r13 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x00b7, code lost:
    
        r25 = r0;
        r24 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x00c5, code lost:
    
        r13 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0054, code lost:
    
        r2 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r35, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x004b, code lost:
    
        r11 = r36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x003b, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0078, code lost:
    
        if (((((~r14) << 7) & r14) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007a, code lost:
    
        r9 = 8 - ((~(r12 - r5)) >>> 31);
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0084, code lost:
    
        if (r10 >= r9) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008e, code lost:
    
        if ((r14 & 255) >= 128) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
    
        r25 = r0;
        r24 = r4;
        r34.movingAwayKeys.add(r4[(r12 << 3) + r10]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a4, code lost:
    
        r14 = r14 >> 8;
        r10 = r10 + 1;
        r4 = r24;
        r0 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a0, code lost:
    
        r25 = r0;
        r24 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ae, code lost:
    
        r25 = r0;
        r24 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b4, code lost:
    
        if (r9 != 8) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00bb, code lost:
    
        if (r12 == r5) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bd, code lost:
    
        r12 = r12 + 1;
        r10 = r13;
        r4 = r24;
        r0 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c6, code lost:
    
        r0 = r38.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00cb, code lost:
    
        r9 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00cc, code lost:
    
        if (r4 >= r0) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ce, code lost:
    
        r5 = r7.get(r4);
        r34.movingAwayKeys.remove(r5.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e1, code lost:
    
        if (getHasAnimations(r5) == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e3, code lost:
    
        r10 = r34.keyToItemInfoMap.get(r5.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ef, code lost:
    
        if (r10 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f1, code lost:
    
        r10 = new androidx.compose.foundation.lazy.grid.ItemInfo(r5.getCrossAxisSize(), r5.getCrossAxisOffset());
        r10.updateAnimation(r5, r42);
        r34.keyToItemInfoMap.set(r5.getKey(), r10);
        r14 = r13.getIndex(r5.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0114, code lost:
    
        if (r14 == (-1)) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x011a, code lost:
    
        if (r5.getIndex() == r14) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x011c, code lost:
    
        if (r14 >= r1) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x011e, code lost:
    
        r34.movingInFromStartBound.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0140, code lost:
    
        r24 = r0;
        r26 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01b8, code lost:
    
        r4 = r4 + 1;
        r7 = r38;
        r0 = r24;
        r11 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0124, code lost:
    
        r34.movingInFromEndBound.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012a, code lost:
    
        r14 = r5.getOffset();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0132, code lost:
    
        if (r5.getIsVertical() == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0134, code lost:
    
        r9 = androidx.compose.ui.unit.IntOffset.m5867getYimpl(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x013d, code lost:
    
        initializeAnimation(r5, r9, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0139, code lost:
    
        r9 = androidx.compose.ui.unit.IntOffset.m5866getXimpl(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0146, code lost:
    
        r9 = r10.getAnimations();
        r14 = r9.length;
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x014e, code lost:
    
        if (r15 >= r14) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0150, code lost:
    
        r24 = r0;
        r0 = r9[r15];
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0154, code lost:
    
        if (r0 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0156, code lost:
    
        r26 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0166, code lost:
    
        if (androidx.compose.ui.unit.IntOffset.m5865equalsimpl0(r0.getRawOffset(), androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.INSTANCE.m723getNotInitializednOccac()) != false) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0168, code lost:
    
        r7 = r0.getRawOffset();
        r0.m722setRawOffsetgyyYBs(androidx.compose.ui.unit.IntOffsetKt.IntOffset(androidx.compose.ui.unit.IntOffset.m5866getXimpl(r7) + androidx.compose.ui.unit.IntOffset.m5866getXimpl(r2), androidx.compose.ui.unit.IntOffset.m5867getYimpl(r7) + androidx.compose.ui.unit.IntOffset.m5867getYimpl(r2)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0188, code lost:
    
        r15 = r15 + 1;
        r0 = r24;
        r11 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0186, code lost:
    
        r26 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0195, code lost:
    
        r24 = r0;
        r26 = r11;
        r10.setCrossAxisSize(r5.getCrossAxisSize());
        r10.setCrossAxisOffset(r5.getCrossAxisOffset());
        startAnimationsIfNeeded(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01ab, code lost:
    
        r24 = r0;
        r26 = r11;
        r34.keyToItemInfoMap.remove(r5.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01c4, code lost:
    
        r26 = r11;
        r0 = r34.movingInFromStartBound;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01cd, code lost:
    
        if (r0.size() <= 1) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01cf, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r0, new androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1(r13));
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01d9, code lost:
    
        r8 = r34.movingInFromStartBound;
        r10 = r8.size();
        r0 = -1;
        r1 = 0;
        r2 = 0;
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01e3, code lost:
    
        if (r11 >= r10) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
    
        r1 = r34.firstVisibleIndex;
        r2 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) kotlin.collections.CollectionsKt.firstOrNull((java.util.List) r38);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01e5, code lost:
    
        r12 = r8.get(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01ec, code lost:
    
        if (r41 == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01ee, code lost:
    
        r3 = r12.getRow();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01f7, code lost:
    
        if (r3 == (-1)) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01f9, code lost:
    
        if (r3 != r0) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01fb, code lost:
    
        r14 = r0;
        r15 = java.lang.Math.max(r1, r12.getMainAxisSize());
        r24 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0211, code lost:
    
        initializeAnimation$default(r34, r12, (0 - r24) - r12.getMainAxisSize(), null, 4, null);
        startAnimationsIfNeeded(r12);
        r11 = r11 + 1;
        r0 = r14;
        r1 = r15;
        r2 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0208, code lost:
    
        r15 = r12.getMainAxisSize();
        r24 = r2 + r1;
        r14 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0034, code lost:
    
        if (r2 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01f3, code lost:
    
        r3 = r12.getColumn();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x022c, code lost:
    
        r0 = r34.movingInFromEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0232, code lost:
    
        if (r0.size() <= 1) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0234, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r0, new androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$1(r13));
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x023e, code lost:
    
        r8 = r34.movingInFromEndBound;
        r10 = r8.size();
        r0 = -1;
        r1 = 0;
        r2 = 0;
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0248, code lost:
    
        if (r11 >= r10) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x024a, code lost:
    
        r12 = r8.get(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0251, code lost:
    
        if (r41 == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0253, code lost:
    
        r3 = r12.getRow();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
    
        r2 = r2.getIndex();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasured(int r35, int r36, int r37, java.util.List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> r38, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider r39, androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider r40, boolean r41, kotlinx.coroutines.CoroutineScope r42) {
        /*
            Method dump skipped, instructions count: 1155
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator.onMeasured(int, int, int, java.util.List, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider, androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider, boolean, kotlinx.coroutines.CoroutineScope):void");
    }
}

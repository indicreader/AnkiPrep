package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimationSpecsNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyListItemAnimator.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0004J\"\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\tH\u0002JT\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020\u001cJ\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u000bj\b\u0012\u0004\u0012\u00020\u0001`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\u00020\u0014*\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006/"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListItemAnimator;", "", "()V", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/LazyListItemAnimator$ItemInfo;", "movingAwayKeys", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/LazyListMeasuredItem;)Z", "getAnimation", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "key", "placeableIndex", "initializeAnimation", "", "item", "mainAxisOffset", "itemInfo", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "isVertical", "isLookingAhead", "hasLookaheadOccurred", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "reset", "startPlacementAnimationsIfNeeded", "ItemInfo", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyListItemAnimator {
    public static final int $stable = 8;
    private int firstVisibleIndex;
    private LazyLayoutKeyIndexMap keyIndexMap;
    private final Map<Object, ItemInfo> keyToItemInfoMap = new LinkedHashMap();
    private final LinkedHashSet<Object> movingAwayKeys = new LinkedHashSet<>();
    private final List<LazyListMeasuredItem> movingInFromStartBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingAwayToEndBound = new ArrayList();

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0242, code lost:
    
        if (r12.isPlacementAnimationInProgress() != r8) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0259, code lost:
    
        if (r2 >= r19.firstVisibleIndex) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0261, code lost:
    
        r19.movingAwayToEndBound.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0048, code lost:
    
        r19.firstVisibleIndex = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x025b, code lost:
    
        r19.movingAwayToStartBound.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0245, code lost:
    
        r14 = r14 + 1;
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0249, code lost:
    
        if (r7 == null) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x024f, code lost:
    
        if (r2 != r7.getIndex(r1)) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004a, code lost:
    
        if (r25 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0251, code lost:
    
        r19.keyToItemInfoMap.remove(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0218, code lost:
    
        r19.keyToItemInfoMap.remove(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0267, code lost:
    
        r0 = r19.movingAwayToStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x026e, code lost:
    
        if (r0.size() <= 1) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x004c, code lost:
    
        r13 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0270, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r0, new androidx.compose.foundation.lazy.LazyListItemAnimator$onMeasured$$inlined$sortByDescending$2(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x027a, code lost:
    
        r0 = r19.movingAwayToStartBound;
        r1 = r0.size();
        r2 = 0;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0282, code lost:
    
        if (r14 >= r1) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0284, code lost:
    
        r3 = r0.get(r14);
        r2 = r2 + r3.getSizeWithSpacings();
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x028f, code lost:
    
        if (r26 == false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0291, code lost:
    
        r4 = ((androidx.compose.foundation.lazy.LazyListMeasuredItem) kotlin.collections.CollectionsKt.first((java.util.List) r23)).getOffset() - r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x029f, code lost:
    
        r3.position(r4, r21, r22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02a6, code lost:
    
        if (r15 == false) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02a8, code lost:
    
        startPlacementAnimationsIfNeeded(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004f, code lost:
    
        if (r25 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x02ab, code lost:
    
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x029d, code lost:
    
        r4 = 0 - r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x02ae, code lost:
    
        r0 = r19.movingAwayToEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02b9, code lost:
    
        if (r0.size() <= 1) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02bb, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r0, new androidx.compose.foundation.lazy.LazyListItemAnimator$onMeasured$$inlined$sortBy$2(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x02c5, code lost:
    
        r0 = r19.movingAwayToEndBound;
        r1 = r0.size();
        r2 = 0;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02cd, code lost:
    
        if (r14 >= r1) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02cf, code lost:
    
        r3 = r0.get(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0051, code lost:
    
        r3 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(0, r20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x02d5, code lost:
    
        if (r26 == false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02d7, code lost:
    
        r4 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) kotlin.collections.CollectionsKt.last((java.util.List) r23);
        r8 = (r4.getOffset() + r4.getSizeWithSpacings()) + r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x02ea, code lost:
    
        r2 = r2 + r3.getSizeWithSpacings();
        r3.position(r8, r21, r22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x02f2, code lost:
    
        if (r15 == false) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02f4, code lost:
    
        startPlacementAnimationsIfNeeded(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x02f7, code lost:
    
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x02e8, code lost:
    
        r8 = r13 + r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005a, code lost:
    
        if (r26 != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x02fa, code lost:
    
        r0 = r19.movingAwayToStartBound;
        kotlin.collections.CollectionsKt.reverse(r0);
        r1 = kotlin.Unit.INSTANCE;
        r23.addAll(0, r0);
        r23.addAll(r19.movingAwayToEndBound);
        r19.movingInFromStartBound.clear();
        r19.movingInFromEndBound.clear();
        r19.movingAwayToStartBound.clear();
        r19.movingAwayToEndBound.clear();
        r19.movingAwayKeys.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0329, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0196, code lost:
    
        r7 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x01fd, code lost:
    
        r7 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0061, code lost:
    
        r15 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0056, code lost:
    
        r3 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r20, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x004e, code lost:
    
        r13 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0047, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005c, code lost:
    
        if (r27 != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        r15 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0062, code lost:
    
        r19.movingAwayKeys.addAll(r19.keyToItemInfoMap.keySet());
        r0 = r23.size();
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0074, code lost:
    
        if (r5 >= r0) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0076, code lost:
    
        r12 = r9.get(r5);
        r27 = r0;
        r19.movingAwayKeys.remove(r12.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008d, code lost:
    
        if (getHasAnimations(r12) == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008f, code lost:
    
        r0 = r19.keyToItemInfoMap.get(r12.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009b, code lost:
    
        if (r0 != null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009d, code lost:
    
        r0 = new androidx.compose.foundation.lazy.LazyListItemAnimator.ItemInfo();
        r0.updateAnimation(r12, r1);
        r19.keyToItemInfoMap.put(r12.getKey(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ae, code lost:
    
        if (r10 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b0, code lost:
    
        r9 = r10.getIndex(r12.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00be, code lost:
    
        if (r12.getIndex() == r9) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c1, code lost:
    
        if (r9 == (-1)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c3, code lost:
    
        if (r9 >= r2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c5, code lost:
    
        r19.movingInFromStartBound.add(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x015b, code lost:
    
        r17 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0169, code lost:
    
        r5 = r5 + 1;
        r9 = r23;
        r0 = r27;
        r1 = r28;
        r10 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00cc, code lost:
    
        r19.movingInFromEndBound.add(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d3, code lost:
    
        r17 = r12.m681getOffsetBjo55l4(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00dc, code lost:
    
        if (r12.getIsVertical() == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00de, code lost:
    
        r14 = androidx.compose.ui.unit.IntOffset.m5867getYimpl(r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e7, code lost:
    
        initializeAnimation(r12, r14, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00eb, code lost:
    
        if (r9 != (-1)) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ed, code lost:
    
        if (r10 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ef, code lost:
    
        r0 = r0.getAnimations();
        r9 = r0.length;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f5, code lost:
    
        if (r14 >= r9) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f7, code lost:
    
        r12 = r0[r14];
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f9, code lost:
    
        if (r12 == null) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00fb, code lost:
    
        r12.animateAppearance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00fe, code lost:
    
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e3, code lost:
    
        r14 = androidx.compose.ui.unit.IntOffset.m5866getXimpl(r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b9, code lost:
    
        r9 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0101, code lost:
    
        if (r15 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0103, code lost:
    
        r0.updateAnimation(r12, r1);
        r0 = r0.getAnimations();
        r9 = r0.length;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x010c, code lost:
    
        if (r14 >= r9) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x010e, code lost:
    
        r1 = r0[r14];
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0110, code lost:
    
        if (r1 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0112, code lost:
    
        r18 = r9;
        r17 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0124, code lost:
    
        if (androidx.compose.ui.unit.IntOffset.m5865equalsimpl0(r1.getRawOffset(), androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.INSTANCE.m723getNotInitializednOccac()) != false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0126, code lost:
    
        r7 = r1.getRawOffset();
        r1.m722setRawOffsetgyyYBs(androidx.compose.ui.unit.IntOffsetKt.IntOffset(androidx.compose.ui.unit.IntOffset.m5866getXimpl(r7) + androidx.compose.ui.unit.IntOffset.m5866getXimpl(r3), androidx.compose.ui.unit.IntOffset.m5867getYimpl(r7) + androidx.compose.ui.unit.IntOffset.m5867getYimpl(r3)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0148, code lost:
    
        r14 = r14 + 1;
        r10 = r17;
        r9 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0144, code lost:
    
        r18 = r9;
        r17 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0155, code lost:
    
        r17 = r10;
        startPlacementAnimationsIfNeeded(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x015e, code lost:
    
        r17 = r10;
        r19.keyToItemInfoMap.remove(r12.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x017a, code lost:
    
        r17 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x017c, code lost:
    
        if (r15 == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x017e, code lost:
    
        if (r17 == null) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0180, code lost:
    
        r0 = r19.movingInFromStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0187, code lost:
    
        if (r0.size() <= 1) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0189, code lost:
    
        r7 = r17;
        kotlin.collections.CollectionsKt.sortWith(r0, new androidx.compose.foundation.lazy.LazyListItemAnimator$onMeasured$$inlined$sortByDescending$1(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0198, code lost:
    
        r8 = r19.movingInFromStartBound;
        r9 = r8.size();
        r0 = 0;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0038, code lost:
    
        r2 = r19.firstVisibleIndex;
        r3 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) kotlin.collections.CollectionsKt.firstOrNull((java.util.List) r23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a0, code lost:
    
        if (r14 >= r9) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01a2, code lost:
    
        r10 = r8.get(r14);
        r12 = r0 + r10.getSizeWithSpacings();
        initializeAnimation$default(r19, r10, 0 - r12, null, 4, null);
        startPlacementAnimationsIfNeeded(r10);
        r14 = r14 + 1;
        r0 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01c1, code lost:
    
        r0 = r19.movingInFromEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01c8, code lost:
    
        if (r0.size() <= 1) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01ca, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r0, new androidx.compose.foundation.lazy.LazyListItemAnimator$onMeasured$$inlined$sortBy$1(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01d4, code lost:
    
        r8 = r19.movingInFromEndBound;
        r9 = r8.size();
        r0 = 0;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01dc, code lost:
    
        if (r14 >= r9) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01de, code lost:
    
        r10 = r8.get(r14);
        r12 = r0 + r10.getSizeWithSpacings();
        initializeAnimation$default(r19, r10, r13 + r0, null, 4, null);
        startPlacementAnimationsIfNeeded(r10);
        r14 = r14 + 1;
        r0 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0040, code lost:
    
        if (r3 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01ff, code lost:
    
        r0 = r19.movingAwayKeys.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x020b, code lost:
    
        if (r0.hasNext() == false) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x020d, code lost:
    
        r1 = r0.next();
        r2 = r11.getIndex(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0216, code lost:
    
        if (r2 != (-1)) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0220, code lost:
    
        r5 = r24.getAndMeasure(r2);
        r8 = true;
        r5.setNonScrollableItem(true);
        r9 = ((androidx.compose.foundation.lazy.LazyListItemAnimator.ItemInfo) kotlin.collections.MapsKt.getValue(r19.keyToItemInfoMap, r1)).getAnimations();
        r10 = r9.length;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0238, code lost:
    
        if (r14 >= r10) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x023a, code lost:
    
        r12 = r9[r14];
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x023c, code lost:
    
        if (r12 == null) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0042, code lost:
    
        r3 = r3.getIndex();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasured(int r20, int r21, int r22, java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r23, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider r24, boolean r25, boolean r26, boolean r27, kotlinx.coroutines.CoroutineScope r28) {
        /*
            Method dump skipped, instructions count: 810
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListItemAnimator.onMeasured(int, int, int, java.util.List, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider, boolean, boolean, boolean, kotlinx.coroutines.CoroutineScope):void");
    }

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
        this.firstVisibleIndex = -1;
    }

    static /* synthetic */ void initializeAnimation$default(LazyListItemAnimator lazyListItemAnimator, LazyListMeasuredItem lazyListMeasuredItem, int i, ItemInfo itemInfo, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            itemInfo = (ItemInfo) MapsKt.getValue(lazyListItemAnimator.keyToItemInfoMap, lazyListMeasuredItem.getKey());
        }
        lazyListItemAnimator.initializeAnimation(lazyListMeasuredItem, i, itemInfo);
    }

    private final void initializeAnimation(LazyListMeasuredItem item, int mainAxisOffset, ItemInfo itemInfo) {
        long m5862copyiSbpLlY$default;
        int i = 0;
        long m681getOffsetBjo55l4 = item.m681getOffsetBjo55l4(0);
        if (item.getIsVertical()) {
            m5862copyiSbpLlY$default = IntOffset.m5862copyiSbpLlY$default(m681getOffsetBjo55l4, 0, mainAxisOffset, 1, null);
        } else {
            m5862copyiSbpLlY$default = IntOffset.m5862copyiSbpLlY$default(m681getOffsetBjo55l4, mainAxisOffset, 0, 2, null);
        }
        LazyLayoutAnimation[] animations = itemInfo.getAnimations();
        int length = animations.length;
        int i2 = 0;
        while (i < length) {
            LazyLayoutAnimation lazyLayoutAnimation = animations[i];
            int i3 = i2 + 1;
            if (lazyLayoutAnimation != null) {
                long m681getOffsetBjo55l42 = item.m681getOffsetBjo55l4(i2);
                long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5866getXimpl(m681getOffsetBjo55l42) - IntOffset.m5866getXimpl(m681getOffsetBjo55l4), IntOffset.m5867getYimpl(m681getOffsetBjo55l42) - IntOffset.m5867getYimpl(m681getOffsetBjo55l4));
                lazyLayoutAnimation.m722setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m5866getXimpl(m5862copyiSbpLlY$default) + IntOffset.m5866getXimpl(IntOffset), IntOffset.m5867getYimpl(m5862copyiSbpLlY$default) + IntOffset.m5867getYimpl(IntOffset)));
            }
            i++;
            i2 = i3;
        }
    }

    private final void startPlacementAnimationsIfNeeded(LazyListMeasuredItem item) {
        LazyLayoutAnimation[] animations = ((ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, item.getKey())).getAnimations();
        int length = animations.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            LazyLayoutAnimation lazyLayoutAnimation = animations[i];
            int i3 = i2 + 1;
            if (lazyLayoutAnimation != null) {
                long m681getOffsetBjo55l4 = item.m681getOffsetBjo55l4(i2);
                long rawOffset = lazyLayoutAnimation.getRawOffset();
                if (!IntOffset.m5865equalsimpl0(rawOffset, LazyLayoutAnimation.INSTANCE.m723getNotInitializednOccac()) && !IntOffset.m5865equalsimpl0(rawOffset, m681getOffsetBjo55l4)) {
                    lazyLayoutAnimation.m717animatePlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m5866getXimpl(m681getOffsetBjo55l4) - IntOffset.m5866getXimpl(rawOffset), IntOffset.m5867getYimpl(m681getOffsetBjo55l4) - IntOffset.m5867getYimpl(rawOffset)));
                }
                lazyLayoutAnimation.m722setRawOffsetgyyYBs(m681getOffsetBjo55l4);
            }
            i++;
            i2 = i3;
        }
    }

    public final LazyLayoutAnimation getAnimation(Object key, int placeableIndex) {
        LazyLayoutAnimation[] animations;
        ItemInfo itemInfo = this.keyToItemInfoMap.get(key);
        if (itemInfo == null || (animations = itemInfo.getAnimations()) == null) {
            return null;
        }
        return animations[placeableIndex];
    }

    private final boolean getHasAnimations(LazyListMeasuredItem lazyListMeasuredItem) {
        LazyLayoutAnimationSpecsNode specs;
        int placeablesCount = lazyListMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            specs = LazyListItemAnimatorKt.getSpecs(lazyListMeasuredItem.getParentData(i));
            if (specs != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LazyListItemAnimator.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR0\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListItemAnimator$ItemInfo;", "", "()V", "<set-?>", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "animations", "getAnimations", "()[Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "[Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "updateAnimation", "", "positionedItem", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class ItemInfo {
        private LazyLayoutAnimation[] animations;

        public final LazyLayoutAnimation[] getAnimations() {
            return this.animations;
        }

        public ItemInfo() {
            LazyLayoutAnimation[] lazyLayoutAnimationArr;
            lazyLayoutAnimationArr = LazyListItemAnimatorKt.EmptyArray;
            this.animations = lazyLayoutAnimationArr;
        }

        public final void updateAnimation(LazyListMeasuredItem positionedItem, CoroutineScope coroutineScope) {
            LazyLayoutAnimationSpecsNode specs;
            int length = this.animations.length;
            for (int placeablesCount = positionedItem.getPlaceablesCount(); placeablesCount < length; placeablesCount++) {
                LazyLayoutAnimation lazyLayoutAnimation = this.animations[placeablesCount];
                if (lazyLayoutAnimation != null) {
                    lazyLayoutAnimation.stopAnimations();
                }
            }
            if (this.animations.length != positionedItem.getPlaceablesCount()) {
                Object[] copyOf = Arrays.copyOf(this.animations, positionedItem.getPlaceablesCount());
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                this.animations = (LazyLayoutAnimation[]) copyOf;
            }
            int placeablesCount2 = positionedItem.getPlaceablesCount();
            for (int i = 0; i < placeablesCount2; i++) {
                specs = LazyListItemAnimatorKt.getSpecs(positionedItem.getParentData(i));
                if (specs == null) {
                    LazyLayoutAnimation lazyLayoutAnimation2 = this.animations[i];
                    if (lazyLayoutAnimation2 != null) {
                        lazyLayoutAnimation2.stopAnimations();
                    }
                    this.animations[i] = null;
                } else {
                    LazyLayoutAnimation lazyLayoutAnimation3 = this.animations[i];
                    if (lazyLayoutAnimation3 == null) {
                        lazyLayoutAnimation3 = new LazyLayoutAnimation(coroutineScope);
                        this.animations[i] = lazyLayoutAnimation3;
                    }
                    lazyLayoutAnimation3.setAppearanceSpec(specs.getAppearanceSpec());
                    lazyLayoutAnimation3.setPlacementSpec(specs.getPlacementSpec());
                }
            }
        }
    }
}

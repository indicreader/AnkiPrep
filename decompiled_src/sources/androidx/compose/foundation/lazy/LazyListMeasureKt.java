package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyListMeasure.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u008c\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a\\\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002\u001a4\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010#\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0002\u001a\u0095\u0002\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00100\u001a\u0002012\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u00102\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\b\u00103\u001a\u0004\u0018\u00010!2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072/\u00108\u001a+\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0:¢\u0006\u0002\b=\u0012\u0004\u0012\u00020>09H\u0000ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006A"}, d2 = {"calculateItemsOffsets", "", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "items", "", "extraItemsBefore", "extraItemsAfter", "layoutWidth", "", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "createItemsAfterList", "visibleItems", "measuredItemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "itemsCount", "beyondBoundsItemCount", "pinnedItems", "consumedScroll", "", "isLookingAhead", "lastPostLookaheadLayoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "createItemsBeforeList", "currentFirstItemIndex", "measureLazyList", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenItems", "firstVisibleItemIndex", "firstVisibleItemScrollOffset", "scrollToBeConsumed", "constraints", "Landroidx/compose/ui/unit/Constraints;", "headerIndexes", "itemAnimator", "Landroidx/compose/foundation/lazy/LazyListItemAnimator;", "hasLookaheadPassOccurred", "postLookaheadLayoutInfo", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyList-5IMabDg", "(ILandroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;IIIIIIFJZLjava/util/List;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/LazyListItemAnimator;ILjava/util/List;ZZLandroidx/compose/foundation/lazy/LazyListLayoutInfo;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyListMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* renamed from: measureLazyList-5IMabDg, reason: not valid java name */
    public static final LazyListMeasureResult m678measureLazyList5IMabDg(int i, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, boolean z, List<Integer> list, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density, LazyListItemAnimator lazyListItemAnimator, int i8, List<Integer> list2, boolean z3, final boolean z4, LazyListLayoutInfo lazyListLayoutInfo, CoroutineScope coroutineScope, final MutableState<Unit> mutableState, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        LazyListMeasuredItem lazyListMeasuredItem;
        int i17;
        List<Integer> list3;
        int i18;
        List<LazyListMeasuredItem> list4;
        int i19;
        int i20;
        if (i3 < 0) {
            throw new IllegalArgumentException("invalid beforeContentPadding".toString());
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("invalid afterContentPadding".toString());
        }
        if (i <= 0) {
            int m5696getMinWidthimpl = Constraints.m5696getMinWidthimpl(j);
            int m5695getMinHeightimpl = Constraints.m5695getMinHeightimpl(j);
            lazyListItemAnimator.onMeasured(0, m5696getMinWidthimpl, m5695getMinHeightimpl, new ArrayList(), lazyListMeasuredItemProvider, z, z4, z3, coroutineScope);
            return new LazyListMeasureResult(null, 0, false, 0.0f, function3.invoke(Integer.valueOf(m5696getMinWidthimpl), Integer.valueOf(m5695getMinHeightimpl), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }), 0.0f, false, CollectionsKt.emptyList(), -i3, i2 + i4, 0, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
        }
        int i21 = 0;
        int i22 = i6;
        if (i22 >= i) {
            i22 = i - 1;
            i9 = 0;
        } else {
            i9 = i7;
        }
        int roundToInt = MathKt.roundToInt(f);
        int i23 = i9 - roundToInt;
        if (i22 == 0 && i23 < 0) {
            roundToInt += i23;
            i23 = 0;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i24 = -i3;
        int i25 = (i5 < 0 ? i5 : 0) + i24;
        int i26 = i23 + i25;
        int i27 = 0;
        while (i26 < 0 && i22 > 0) {
            i22--;
            int i28 = i24;
            LazyListMeasuredItem andMeasure = lazyListMeasuredItemProvider.getAndMeasure(i22);
            arrayDeque.add(i21, andMeasure);
            i27 = Math.max(i27, andMeasure.getCrossAxisSize());
            i26 += andMeasure.getSizeWithSpacings();
            i24 = i28;
            i21 = 0;
        }
        int i29 = i24;
        if (i26 < i25) {
            roundToInt += i26;
            i26 = i25;
        }
        int i30 = i26 - i25;
        int i31 = i2 + i4;
        int i32 = i22;
        int coerceAtLeast = RangesKt.coerceAtLeast(i31, 0);
        int i33 = i32;
        int i34 = i27;
        int i35 = -i30;
        int i36 = 0;
        boolean z5 = false;
        while (i36 < arrayDeque.size()) {
            if (i35 >= coerceAtLeast) {
                arrayDeque.remove(i36);
                z5 = true;
            } else {
                i33++;
                i35 += ((LazyListMeasuredItem) arrayDeque.get(i36)).getSizeWithSpacings();
                i36++;
            }
        }
        int i37 = i30;
        int i38 = i35;
        boolean z6 = z5;
        int i39 = i33;
        int i40 = i34;
        while (i39 < i && (i38 < coerceAtLeast || i38 <= 0 || arrayDeque.isEmpty())) {
            int i41 = coerceAtLeast;
            LazyListMeasuredItem andMeasure2 = lazyListMeasuredItemProvider.getAndMeasure(i39);
            i38 += andMeasure2.getSizeWithSpacings();
            if (i38 <= i25) {
                i19 = i25;
                if (i39 != i - 1) {
                    i20 = i39 + 1;
                    i37 -= andMeasure2.getSizeWithSpacings();
                    z6 = true;
                    i39++;
                    coerceAtLeast = i41;
                    i32 = i20;
                    i25 = i19;
                }
            } else {
                i19 = i25;
            }
            i40 = Math.max(i40, andMeasure2.getCrossAxisSize());
            arrayDeque.add(andMeasure2);
            i20 = i32;
            i39++;
            coerceAtLeast = i41;
            i32 = i20;
            i25 = i19;
        }
        if (i38 < i2) {
            int i42 = i2 - i38;
            i37 -= i42;
            int i43 = i38 + i42;
            i12 = i40;
            i15 = i32;
            while (i37 < i3 && i15 > 0) {
                i15--;
                int i44 = i31;
                LazyListMeasuredItem andMeasure3 = lazyListMeasuredItemProvider.getAndMeasure(i15);
                arrayDeque.add(0, andMeasure3);
                i12 = Math.max(i12, andMeasure3.getCrossAxisSize());
                i37 += andMeasure3.getSizeWithSpacings();
                i31 = i44;
                i39 = i39;
            }
            i10 = i31;
            i11 = i39;
            i13 = i42 + roundToInt;
            if (i37 < 0) {
                i13 += i37;
                i14 = i43 + i37;
                i37 = 0;
            } else {
                i14 = i43;
            }
        } else {
            i10 = i31;
            i11 = i39;
            i12 = i40;
            i13 = roundToInt;
            i14 = i38;
            i15 = i32;
        }
        float f2 = (MathKt.getSign(MathKt.roundToInt(f)) != MathKt.getSign(i13) || Math.abs(MathKt.roundToInt(f)) < Math.abs(i13)) ? f : i13;
        float f3 = f - f2;
        float f4 = (!z4 || i13 <= roundToInt || f3 > 0.0f) ? 0.0f : (i13 - roundToInt) + f3;
        if (i37 < 0) {
            throw new IllegalArgumentException("negative currentFirstItemScrollOffset".toString());
        }
        int i45 = -i37;
        LazyListMeasuredItem lazyListMeasuredItem2 = (LazyListMeasuredItem) arrayDeque.first();
        if (i3 > 0 || i5 < 0) {
            int size = arrayDeque.size();
            LazyListMeasuredItem lazyListMeasuredItem3 = lazyListMeasuredItem2;
            int i46 = i37;
            int i47 = 0;
            while (i47 < size) {
                int i48 = size;
                int sizeWithSpacings = ((LazyListMeasuredItem) arrayDeque.get(i47)).getSizeWithSpacings();
                if (i46 == 0 || sizeWithSpacings > i46) {
                    break;
                }
                i16 = i12;
                if (i47 == CollectionsKt.getLastIndex(arrayDeque)) {
                    break;
                }
                i46 -= sizeWithSpacings;
                i47++;
                lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque.get(i47);
                i12 = i16;
                size = i48;
            }
            i16 = i12;
            lazyListMeasuredItem = lazyListMeasuredItem3;
            i17 = i8;
            list3 = list2;
            i18 = i46;
        } else {
            list3 = list2;
            i16 = i12;
            i18 = i37;
            i17 = i8;
            lazyListMeasuredItem = lazyListMeasuredItem2;
        }
        List<LazyListMeasuredItem> createItemsBeforeList = createItemsBeforeList(i15, lazyListMeasuredItemProvider, i17, list3);
        int i49 = i16;
        int i50 = 0;
        for (int size2 = createItemsBeforeList.size(); i50 < size2; size2 = size2) {
            i49 = Math.max(i49, createItemsBeforeList.get(i50).getCrossAxisSize());
            i50++;
        }
        ArrayDeque arrayDeque2 = arrayDeque;
        int i51 = i49;
        LazyListMeasuredItem lazyListMeasuredItem4 = lazyListMeasuredItem;
        int i52 = i10;
        float f5 = f2;
        List<LazyListMeasuredItem> createItemsAfterList = createItemsAfterList(arrayDeque2, lazyListMeasuredItemProvider, i, i8, list2, f2, z4, lazyListLayoutInfo);
        int size3 = createItemsAfterList.size();
        int i53 = i51;
        for (int i54 = 0; i54 < size3; i54++) {
            i53 = Math.max(i53, createItemsAfterList.get(i54).getCrossAxisSize());
        }
        boolean z7 = Intrinsics.areEqual(lazyListMeasuredItem4, arrayDeque.first()) && createItemsBeforeList.isEmpty() && createItemsAfterList.isEmpty();
        int m5708constrainWidthK40F9xA = ConstraintsKt.m5708constrainWidthK40F9xA(j, z ? i53 : i14);
        if (z) {
            i53 = i14;
        }
        int m5707constrainHeightK40F9xA = ConstraintsKt.m5707constrainHeightK40F9xA(j, i53);
        int i55 = i14;
        int i56 = i11;
        final List<LazyListMeasuredItem> calculateItemsOffsets = calculateItemsOffsets(arrayDeque2, createItemsBeforeList, createItemsAfterList, m5708constrainWidthK40F9xA, m5707constrainHeightK40F9xA, i55, i2, i45, z, vertical, horizontal, z2, density);
        lazyListItemAnimator.onMeasured((int) f5, m5708constrainWidthK40F9xA, m5707constrainHeightK40F9xA, calculateItemsOffsets, lazyListMeasuredItemProvider, z, z4, z3, coroutineScope);
        final LazyListMeasuredItem findOrComposeLazyListHeader = list.isEmpty() ^ true ? LazyListHeadersKt.findOrComposeLazyListHeader(calculateItemsOffsets, lazyListMeasuredItemProvider, list, i3, m5708constrainWidthK40F9xA, m5707constrainHeightK40F9xA) : null;
        boolean z8 = i56 < i || i55 > i2;
        MeasureResult invoke = function3.invoke(Integer.valueOf(m5708constrainWidthK40F9xA), Integer.valueOf(m5707constrainHeightK40F9xA), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$7
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                List<LazyListMeasuredItem> list5 = calculateItemsOffsets;
                LazyListMeasuredItem lazyListMeasuredItem5 = findOrComposeLazyListHeader;
                boolean z9 = z4;
                int size4 = list5.size();
                for (int i57 = 0; i57 < size4; i57++) {
                    LazyListMeasuredItem lazyListMeasuredItem6 = list5.get(i57);
                    if (lazyListMeasuredItem6 != lazyListMeasuredItem5) {
                        lazyListMeasuredItem6.place(placementScope, z9);
                    }
                }
                LazyListMeasuredItem lazyListMeasuredItem7 = findOrComposeLazyListHeader;
                if (lazyListMeasuredItem7 != null) {
                    lazyListMeasuredItem7.place(placementScope, z4);
                }
                ObservableScopeInvalidator.m737attachToScopeimpl(mutableState);
            }
        });
        if (z7) {
            list4 = calculateItemsOffsets;
        } else {
            ArrayList arrayList = new ArrayList(calculateItemsOffsets.size());
            int size4 = calculateItemsOffsets.size();
            for (int i57 = 0; i57 < size4; i57++) {
                LazyListMeasuredItem lazyListMeasuredItem5 = calculateItemsOffsets.get(i57);
                LazyListMeasuredItem lazyListMeasuredItem6 = lazyListMeasuredItem5;
                if ((lazyListMeasuredItem6.getIndex() >= ((LazyListMeasuredItem) arrayDeque.first()).getIndex() && lazyListMeasuredItem6.getIndex() <= ((LazyListMeasuredItem) arrayDeque.last()).getIndex()) || lazyListMeasuredItem6 == findOrComposeLazyListHeader) {
                    arrayList.add(lazyListMeasuredItem5);
                }
            }
            list4 = arrayList;
        }
        return new LazyListMeasureResult(lazyListMeasuredItem4, i18, z8, f5, invoke, f4, z6, list4, i29, i52, i, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0076, code lost:
    
        r7 = r7.get(r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> createItemsAfterList(java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r14, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider r15, int r16, int r17, java.util.List<java.lang.Integer> r18, float r19, boolean r20, androidx.compose.foundation.lazy.LazyListLayoutInfo r21) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListMeasureKt.createItemsAfterList(java.util.List, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider, int, int, java.util.List, float, boolean, androidx.compose.foundation.lazy.LazyListLayoutInfo):java.util.List");
    }

    private static final List<LazyListMeasuredItem> createItemsBeforeList(int i, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i2, List<Integer> list) {
        int max = Math.max(0, i - i2);
        int i3 = i - 1;
        ArrayList arrayList = null;
        if (max <= i3) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(lazyListMeasuredItemProvider.getAndMeasure(i3));
                if (i3 == max) {
                    break;
                }
                i3--;
            }
        }
        int size = list.size() - 1;
        if (size >= 0) {
            while (true) {
                int i4 = size - 1;
                int intValue = list.get(size).intValue();
                if (intValue < max) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(lazyListMeasuredItemProvider.getAndMeasure(intValue));
                }
                if (i4 < 0) {
                    break;
                }
                size = i4;
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyListMeasuredItem> calculateItemsOffsets(List<LazyListMeasuredItem> list, List<LazyListMeasuredItem> list2, List<LazyListMeasuredItem> list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        int i6 = z ? i2 : i;
        boolean z3 = i3 < Math.min(i6, i4);
        if (z3 && i5 != 0) {
            throw new IllegalStateException("non-zero itemsScrollOffset".toString());
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (z3) {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("no extra items".toString());
            }
            int size = list.size();
            int[] iArr = new int[size];
            for (int i7 = 0; i7 < size; i7++) {
                iArr[i7] = list.get(calculateItemsOffsets$reverseAware(i7, z2, size)).getSize();
            }
            int[] iArr2 = new int[size];
            for (int i8 = 0; i8 < size; i8++) {
                iArr2[i8] = 0;
            }
            if (z) {
                if (vertical == null) {
                    throw new IllegalArgumentException("null verticalArrangement when isVertical == true".toString());
                }
                vertical.arrange(density, i6, iArr, iArr2);
            } else {
                if (horizontal == null) {
                    throw new IllegalArgumentException("null horizontalArrangement when isVertical == false".toString());
                }
                horizontal.arrange(density, i6, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntRange indices = ArraysKt.getIndices(iArr2);
            if (z2) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int i9 = iArr2[first];
                    LazyListMeasuredItem lazyListMeasuredItem = list.get(calculateItemsOffsets$reverseAware(first, z2, size));
                    if (z2) {
                        i9 = (i6 - i9) - lazyListMeasuredItem.getSize();
                    }
                    lazyListMeasuredItem.position(i9, i, i2);
                    arrayList.add(lazyListMeasuredItem);
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size2 = list2.size();
            int i10 = i5;
            for (int i11 = 0; i11 < size2; i11++) {
                LazyListMeasuredItem lazyListMeasuredItem2 = list2.get(i11);
                i10 -= lazyListMeasuredItem2.getSizeWithSpacings();
                lazyListMeasuredItem2.position(i10, i, i2);
                arrayList.add(lazyListMeasuredItem2);
            }
            int size3 = list.size();
            int i12 = i5;
            for (int i13 = 0; i13 < size3; i13++) {
                LazyListMeasuredItem lazyListMeasuredItem3 = list.get(i13);
                lazyListMeasuredItem3.position(i12, i, i2);
                arrayList.add(lazyListMeasuredItem3);
                i12 += lazyListMeasuredItem3.getSizeWithSpacings();
            }
            int size4 = list3.size();
            for (int i14 = 0; i14 < size4; i14++) {
                LazyListMeasuredItem lazyListMeasuredItem4 = list3.get(i14);
                lazyListMeasuredItem4.position(i12, i, i2);
                arrayList.add(lazyListMeasuredItem4);
                i12 += lazyListMeasuredItem4.getSizeWithSpacings();
            }
        }
        return arrayList;
    }
}

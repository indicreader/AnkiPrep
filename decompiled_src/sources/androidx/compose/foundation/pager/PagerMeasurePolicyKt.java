package androidx.compose.foundation.pager;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPositionInLayout;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;

/* compiled from: PagerMeasurePolicy.kt */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0082\b\u001a\u0099\u0001\u0010\u0007\u001a\u0019\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0002\b\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00170\u0005H\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u0014\u0010%\u001a\u00020\u0017*\u00020\u00102\u0006\u0010&\u001a\u00020\u0017H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"DEBUG", "", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "rememberPagerMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "itemProviderLambda", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "beyondBoundsPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "snapPositionInLayout", "Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;", "pageCount", "rememberPagerMeasurePolicy-121YqSk", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;IFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "calculateCurrentPageLayoutOffset", "pageSizeWithSpacing", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PagerMeasurePolicyKt {
    private static final boolean DEBUG = false;

    private static final void debugLog(Function0<String> function0) {
    }

    /* renamed from: rememberPagerMeasurePolicy-121YqSk, reason: not valid java name */
    public static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> m802rememberPagerMeasurePolicy121YqSk(final Function0<PagerLazyLayoutItemProvider> function0, final PagerState pagerState, final PaddingValues paddingValues, final boolean z, final Orientation orientation, final int i, final float f, final PageSize pageSize, final Alignment.Horizontal horizontal, final Alignment.Vertical vertical, final SnapPositionInLayout snapPositionInLayout, final Function0<Integer> function02, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(-1615726010);
        ComposerKt.sourceInformation(composer, "C(rememberPagerMeasurePolicy)P(3,10,1,8,4!1,7:c#ui.unit.Dp,6!1,11,9)56@2324L5682:PagerMeasurePolicy.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1615726010, i2, i3, "androidx.compose.foundation.pager.rememberPagerMeasurePolicy (PagerMeasurePolicy.kt:56)");
        }
        Object[] objArr = {pagerState, paddingValues, Boolean.valueOf(z), orientation, horizontal, vertical, Dp.m5736boximpl(f), pageSize, snapPositionInLayout, function02};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean z2 = false;
        for (int i4 = 0; i4 < 10; i4++) {
            z2 |= composer.changed(objArr[i4]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ PagerMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m803invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final PagerMeasureResult m803invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                    int i5;
                    int i6;
                    int m5694getMaxWidthimpl;
                    long IntOffset;
                    boolean z3 = Orientation.this == Orientation.Vertical;
                    CheckScrollableContainerConstraintsKt.m245checkScrollableContainerConstraintsK40F9xA(j, z3 ? Orientation.Vertical : Orientation.Horizontal);
                    if (z3) {
                        i5 = lazyLayoutMeasureScope.mo314roundToPx0680j_4(paddingValues.mo520calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i5 = lazyLayoutMeasureScope.mo314roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    if (z3) {
                        i6 = lazyLayoutMeasureScope.mo314roundToPx0680j_4(paddingValues.mo521calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i6 = lazyLayoutMeasureScope.mo314roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    int i7 = lazyLayoutMeasureScope.mo314roundToPx0680j_4(paddingValues.getTop());
                    int i8 = lazyLayoutMeasureScope.mo314roundToPx0680j_4(paddingValues.getBottom());
                    final int i9 = i7 + i8;
                    final int i10 = i5 + i6;
                    int i11 = z3 ? i9 : i10;
                    int i12 = (!z3 || z) ? (z3 && z) ? i8 : (z3 || z) ? i6 : i5 : i7;
                    int i13 = i11 - i12;
                    long m5710offsetNN6EwU = ConstraintsKt.m5710offsetNN6EwU(j, -i10, -i9);
                    LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                    pagerState.setDensity$foundation_release(lazyLayoutMeasureScope2);
                    int i14 = lazyLayoutMeasureScope.mo314roundToPx0680j_4(f);
                    if (z3) {
                        m5694getMaxWidthimpl = Constraints.m5693getMaxHeightimpl(j) - i9;
                    } else {
                        m5694getMaxWidthimpl = Constraints.m5694getMaxWidthimpl(j) - i10;
                    }
                    if (!z || m5694getMaxWidthimpl > 0) {
                        IntOffset = IntOffsetKt.IntOffset(i5, i7);
                    } else {
                        if (!z3) {
                            i5 += m5694getMaxWidthimpl;
                        }
                        if (z3) {
                            i7 += m5694getMaxWidthimpl;
                        }
                        IntOffset = IntOffsetKt.IntOffset(i5, i7);
                    }
                    long j2 = IntOffset;
                    int calculateMainAxisPageSize = pageSize.calculateMainAxisPageSize(lazyLayoutMeasureScope2, m5694getMaxWidthimpl, i14);
                    pagerState.m807setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, Orientation.this == Orientation.Vertical ? Constraints.m5694getMaxWidthimpl(m5710offsetNN6EwU) : calculateMainAxisPageSize, 0, Orientation.this != Orientation.Vertical ? Constraints.m5693getMaxHeightimpl(m5710offsetNN6EwU) : calculateMainAxisPageSize, 5, null));
                    PagerLazyLayoutItemProvider invoke = function0.invoke();
                    int i15 = calculateMainAxisPageSize + i14;
                    Snapshot.Companion companion = Snapshot.INSTANCE;
                    PagerState pagerState2 = pagerState;
                    Snapshot createNonObservableSnapshot = companion.createNonObservableSnapshot();
                    try {
                        Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
                        try {
                            int matchScrollPositionWithKey$foundation_release = pagerState2.matchScrollPositionWithKey$foundation_release(invoke, pagerState2.getCurrentPage());
                            int calculateCurrentPageLayoutOffset = PagerMeasurePolicyKt.calculateCurrentPageLayoutOffset(pagerState2, i15);
                            Unit unit = Unit.INSTANCE;
                            createNonObservableSnapshot.dispose();
                            PagerMeasureResult m801measurePager_JDW0YA = PagerMeasureKt.m801measurePager_JDW0YA(lazyLayoutMeasureScope, function02.invoke().intValue(), invoke, m5694getMaxWidthimpl, i12, i13, i14, matchScrollPositionWithKey$foundation_release, calculateCurrentPageLayoutOffset, m5710offsetNN6EwU, Orientation.this, vertical, horizontal, z, j2, calculateMainAxisPageSize, i, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, pagerState.getPinnedPages(), pagerState.getBeyondBoundsInfo()), snapPositionInLayout, pagerState.m804getPlacementScopeInvalidatorzYiylxw$foundation_release(), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                    return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                }

                                public final MeasureResult invoke(int i16, int i17, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                    return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m5708constrainWidthK40F9xA(j, i16 + i10), ConstraintsKt.m5707constrainHeightK40F9xA(j, i17 + i9), MapsKt.emptyMap(), function1);
                                }
                            });
                            PagerState.applyMeasureResult$foundation_release$default(pagerState, m801measurePager_JDW0YA, false, 2, null);
                            return m801measurePager_JDW0YA;
                        } finally {
                            createNonObservableSnapshot.restoreCurrent(makeCurrent);
                        }
                    } catch (Throwable th) {
                        createNonObservableSnapshot.dispose();
                        throw th;
                    }
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2 = (Function2) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function2;
    }

    public static final int calculateCurrentPageLayoutOffset(PagerState pagerState, int i) {
        PageInfo pageInfo;
        List<PageInfo> visiblePagesInfo = pagerState.getLayoutInfo().getVisiblePagesInfo();
        int size = visiblePagesInfo.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                pageInfo = null;
                break;
            }
            pageInfo = visiblePagesInfo.get(i2);
            if (pageInfo.getIndex() == pagerState.getCurrentPage()) {
                break;
            }
            i2++;
        }
        PageInfo pageInfo2 = pageInfo;
        int offset = pageInfo2 != null ? pageInfo2.getOffset() : 0;
        return -MathKt.roundToInt(((pagerState.getCurrentPageOffsetFraction() - (i == 0 ? pagerState.getCurrentPageOffsetFraction() : (-offset) / i)) * i) - offset);
    }
}

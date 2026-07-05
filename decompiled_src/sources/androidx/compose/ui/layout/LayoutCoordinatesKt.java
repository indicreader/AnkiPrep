package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.ranges.RangesKt;

/* compiled from: LayoutCoordinates.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0002\u001a\u000f\u0010\u0006\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b\u001a\u000f\u0010\t\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b\u001a\u000f\u0010\n\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b¨\u0006\u000b"}, d2 = {"boundsInParent", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "boundsInRoot", "boundsInWindow", "findRootCoordinates", "positionInParent", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "positionInRoot", "positionInWindow", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class LayoutCoordinatesKt {
    public static final long positionInRoot(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.mo4696localToRootMKHz9U(Offset.INSTANCE.m3192getZeroF1C5BW0());
    }

    public static final long positionInWindow(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.mo4697localToWindowMKHz9U(Offset.INSTANCE.m3192getZeroF1C5BW0());
    }

    public static final Rect boundsInRoot(LayoutCoordinates layoutCoordinates) {
        return LayoutCoordinates.localBoundingBoxOf$default(findRootCoordinates(layoutCoordinates), layoutCoordinates, false, 2, null);
    }

    public static final Rect boundsInWindow(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates findRootCoordinates = findRootCoordinates(layoutCoordinates);
        Rect boundsInRoot = boundsInRoot(layoutCoordinates);
        float m5908getWidthimpl = IntSize.m5908getWidthimpl(findRootCoordinates.mo4694getSizeYbymL2g());
        float m5907getHeightimpl = IntSize.m5907getHeightimpl(findRootCoordinates.mo4694getSizeYbymL2g());
        float coerceIn = RangesKt.coerceIn(boundsInRoot.getLeft(), 0.0f, m5908getWidthimpl);
        float coerceIn2 = RangesKt.coerceIn(boundsInRoot.getTop(), 0.0f, m5907getHeightimpl);
        float coerceIn3 = RangesKt.coerceIn(boundsInRoot.getRight(), 0.0f, m5908getWidthimpl);
        float coerceIn4 = RangesKt.coerceIn(boundsInRoot.getBottom(), 0.0f, m5907getHeightimpl);
        if (coerceIn == coerceIn3 || coerceIn2 == coerceIn4) {
            return Rect.INSTANCE.getZero();
        }
        long mo4697localToWindowMKHz9U = findRootCoordinates.mo4697localToWindowMKHz9U(OffsetKt.Offset(coerceIn, coerceIn2));
        long mo4697localToWindowMKHz9U2 = findRootCoordinates.mo4697localToWindowMKHz9U(OffsetKt.Offset(coerceIn3, coerceIn2));
        long mo4697localToWindowMKHz9U3 = findRootCoordinates.mo4697localToWindowMKHz9U(OffsetKt.Offset(coerceIn3, coerceIn4));
        long mo4697localToWindowMKHz9U4 = findRootCoordinates.mo4697localToWindowMKHz9U(OffsetKt.Offset(coerceIn, coerceIn4));
        return new Rect(ComparisonsKt.minOf(Offset.m3176getXimpl(mo4697localToWindowMKHz9U), Offset.m3176getXimpl(mo4697localToWindowMKHz9U2), Offset.m3176getXimpl(mo4697localToWindowMKHz9U4), Offset.m3176getXimpl(mo4697localToWindowMKHz9U3)), ComparisonsKt.minOf(Offset.m3177getYimpl(mo4697localToWindowMKHz9U), Offset.m3177getYimpl(mo4697localToWindowMKHz9U2), Offset.m3177getYimpl(mo4697localToWindowMKHz9U4), Offset.m3177getYimpl(mo4697localToWindowMKHz9U3)), ComparisonsKt.maxOf(Offset.m3176getXimpl(mo4697localToWindowMKHz9U), Offset.m3176getXimpl(mo4697localToWindowMKHz9U2), Offset.m3176getXimpl(mo4697localToWindowMKHz9U4), Offset.m3176getXimpl(mo4697localToWindowMKHz9U3)), ComparisonsKt.maxOf(Offset.m3177getYimpl(mo4697localToWindowMKHz9U), Offset.m3177getYimpl(mo4697localToWindowMKHz9U2), Offset.m3177getYimpl(mo4697localToWindowMKHz9U4), Offset.m3177getYimpl(mo4697localToWindowMKHz9U3)));
    }

    public static final long positionInParent(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return parentLayoutCoordinates != null ? parentLayoutCoordinates.mo4695localPositionOfR5De75A(layoutCoordinates, Offset.INSTANCE.m3192getZeroF1C5BW0()) : Offset.INSTANCE.m3192getZeroF1C5BW0();
    }

    public static final Rect boundsInParent(LayoutCoordinates layoutCoordinates) {
        Rect localBoundingBoxOf$default;
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return (parentLayoutCoordinates == null || (localBoundingBoxOf$default = LayoutCoordinates.localBoundingBoxOf$default(parentLayoutCoordinates, layoutCoordinates, false, 2, null)) == null) ? new Rect(0.0f, 0.0f, IntSize.m5908getWidthimpl(layoutCoordinates.mo4694getSizeYbymL2g()), IntSize.m5907getHeightimpl(layoutCoordinates.mo4694getSizeYbymL2g())) : localBoundingBoxOf$default;
    }

    public static final LayoutCoordinates findRootCoordinates(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinates2;
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates3 = parentLayoutCoordinates;
            layoutCoordinates2 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates3;
            if (layoutCoordinates == null) {
                break;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
        NodeCoordinator nodeCoordinator = layoutCoordinates2 instanceof NodeCoordinator ? (NodeCoordinator) layoutCoordinates2 : null;
        if (nodeCoordinator == null) {
            return layoutCoordinates2;
        }
        NodeCoordinator wrappedBy = nodeCoordinator.getWrappedBy();
        while (true) {
            NodeCoordinator nodeCoordinator2 = wrappedBy;
            NodeCoordinator nodeCoordinator3 = nodeCoordinator;
            nodeCoordinator = nodeCoordinator2;
            if (nodeCoordinator != null) {
                wrappedBy = nodeCoordinator.getWrappedBy();
            } else {
                return nodeCoordinator3;
            }
        }
    }
}

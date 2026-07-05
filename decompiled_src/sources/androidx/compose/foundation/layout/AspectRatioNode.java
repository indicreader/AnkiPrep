package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* compiled from: AspectRatio.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010\u001b\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J&\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010\u0018\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u001c\u0010$\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010%\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J \u0010&\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010)J \u0010*\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010)J \u0010,\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010)J \u0010.\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u0010)R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"Landroidx/compose/foundation/layout/AspectRatioNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "aspectRatio", "", "matchHeightConstraintsFirst", "", "(FZ)V", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "getMatchHeightConstraintsFirst", "()Z", "setMatchHeightConstraintsFirst", "(Z)V", "findSize", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/Constraints;", "findSize-ToXhtMw", "(J)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "tryMaxHeight", "enforceConstraints", "tryMaxHeight-JN-0ABg", "(JZ)J", "tryMaxWidth", "tryMaxWidth-JN-0ABg", "tryMinHeight", "tryMinHeight-JN-0ABg", "tryMinWidth", "tryMinWidth-JN-0ABg", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class AspectRatioNode extends Modifier.Node implements LayoutModifierNode {
    private float aspectRatio;
    private boolean matchHeightConstraintsFirst;

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    public final void setAspectRatio(float f) {
        this.aspectRatio = f;
    }

    public final void setMatchHeightConstraintsFirst(boolean z) {
        this.matchHeightConstraintsFirst = z;
    }

    public AspectRatioNode(float f, boolean z) {
        this.aspectRatio = f;
        this.matchHeightConstraintsFirst = z;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo94measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long m495findSizeToXhtMw = m495findSizeToXhtMw(j);
        if (!IntSize.m5906equalsimpl0(m495findSizeToXhtMw, IntSize.INSTANCE.m5913getZeroYbymL2g())) {
            j = Constraints.INSTANCE.m5702fixedJhjzzOo(IntSize.m5908getWidthimpl(m495findSizeToXhtMw), IntSize.m5907getHeightimpl(m495findSizeToXhtMw));
        }
        final Placeable mo4687measureBRTryo0 = measurable.mo4687measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, mo4687measureBRTryo0.getWidth(), mo4687measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AspectRatioNode$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(i * this.aspectRatio);
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(i * this.aspectRatio);
        }
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(i / this.aspectRatio);
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(i / this.aspectRatio);
        }
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    /* renamed from: findSize-ToXhtMw, reason: not valid java name */
    private final long m495findSizeToXhtMw(long j) {
        if (!this.matchHeightConstraintsFirst) {
            long m499tryMaxWidthJN0ABg$default = m499tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5906equalsimpl0(m499tryMaxWidthJN0ABg$default, IntSize.INSTANCE.m5913getZeroYbymL2g())) {
                return m499tryMaxWidthJN0ABg$default;
            }
            long m497tryMaxHeightJN0ABg$default = m497tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5906equalsimpl0(m497tryMaxHeightJN0ABg$default, IntSize.INSTANCE.m5913getZeroYbymL2g())) {
                return m497tryMaxHeightJN0ABg$default;
            }
            long m503tryMinWidthJN0ABg$default = m503tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5906equalsimpl0(m503tryMinWidthJN0ABg$default, IntSize.INSTANCE.m5913getZeroYbymL2g())) {
                return m503tryMinWidthJN0ABg$default;
            }
            long m501tryMinHeightJN0ABg$default = m501tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5906equalsimpl0(m501tryMinHeightJN0ABg$default, IntSize.INSTANCE.m5913getZeroYbymL2g())) {
                return m501tryMinHeightJN0ABg$default;
            }
            long m498tryMaxWidthJN0ABg = m498tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m5906equalsimpl0(m498tryMaxWidthJN0ABg, IntSize.INSTANCE.m5913getZeroYbymL2g())) {
                return m498tryMaxWidthJN0ABg;
            }
            long m496tryMaxHeightJN0ABg = m496tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m5906equalsimpl0(m496tryMaxHeightJN0ABg, IntSize.INSTANCE.m5913getZeroYbymL2g())) {
                return m496tryMaxHeightJN0ABg;
            }
            long m502tryMinWidthJN0ABg = m502tryMinWidthJN0ABg(j, false);
            if (!IntSize.m5906equalsimpl0(m502tryMinWidthJN0ABg, IntSize.INSTANCE.m5913getZeroYbymL2g())) {
                return m502tryMinWidthJN0ABg;
            }
            long m500tryMinHeightJN0ABg = m500tryMinHeightJN0ABg(j, false);
            if (!IntSize.m5906equalsimpl0(m500tryMinHeightJN0ABg, IntSize.INSTANCE.m5913getZeroYbymL2g())) {
                return m500tryMinHeightJN0ABg;
            }
        } else {
            long m497tryMaxHeightJN0ABg$default2 = m497tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5906equalsimpl0(m497tryMaxHeightJN0ABg$default2, IntSize.INSTANCE.m5913getZeroYbymL2g())) {
                return m497tryMaxHeightJN0ABg$default2;
            }
            long m499tryMaxWidthJN0ABg$default2 = m499tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5906equalsimpl0(m499tryMaxWidthJN0ABg$default2, IntSize.INSTANCE.m5913getZeroYbymL2g())) {
                return m499tryMaxWidthJN0ABg$default2;
            }
            long m501tryMinHeightJN0ABg$default2 = m501tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5906equalsimpl0(m501tryMinHeightJN0ABg$default2, IntSize.INSTANCE.m5913getZeroYbymL2g())) {
                return m501tryMinHeightJN0ABg$default2;
            }
            long m503tryMinWidthJN0ABg$default2 = m503tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5906equalsimpl0(m503tryMinWidthJN0ABg$default2, IntSize.INSTANCE.m5913getZeroYbymL2g())) {
                return m503tryMinWidthJN0ABg$default2;
            }
            long m496tryMaxHeightJN0ABg2 = m496tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m5906equalsimpl0(m496tryMaxHeightJN0ABg2, IntSize.INSTANCE.m5913getZeroYbymL2g())) {
                return m496tryMaxHeightJN0ABg2;
            }
            long m498tryMaxWidthJN0ABg2 = m498tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m5906equalsimpl0(m498tryMaxWidthJN0ABg2, IntSize.INSTANCE.m5913getZeroYbymL2g())) {
                return m498tryMaxWidthJN0ABg2;
            }
            long m500tryMinHeightJN0ABg2 = m500tryMinHeightJN0ABg(j, false);
            if (!IntSize.m5906equalsimpl0(m500tryMinHeightJN0ABg2, IntSize.INSTANCE.m5913getZeroYbymL2g())) {
                return m500tryMinHeightJN0ABg2;
            }
            long m502tryMinWidthJN0ABg2 = m502tryMinWidthJN0ABg(j, false);
            if (!IntSize.m5906equalsimpl0(m502tryMinWidthJN0ABg2, IntSize.INSTANCE.m5913getZeroYbymL2g())) {
                return m502tryMinWidthJN0ABg2;
            }
        }
        return IntSize.INSTANCE.m5913getZeroYbymL2g();
    }

    /* renamed from: tryMaxWidth-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m499tryMaxWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m498tryMaxWidthJN0ABg(j, z);
    }

    /* renamed from: tryMaxWidth-JN-0ABg, reason: not valid java name */
    private final long m498tryMaxWidthJN0ABg(long j, boolean z) {
        int roundToInt;
        int m5694getMaxWidthimpl = Constraints.m5694getMaxWidthimpl(j);
        if (m5694getMaxWidthimpl != Integer.MAX_VALUE && (roundToInt = MathKt.roundToInt(m5694getMaxWidthimpl / this.aspectRatio)) > 0) {
            long IntSize = IntSizeKt.IntSize(m5694getMaxWidthimpl, roundToInt);
            if (!z || ConstraintsKt.m5709isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.INSTANCE.m5913getZeroYbymL2g();
    }

    /* renamed from: tryMaxHeight-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m497tryMaxHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m496tryMaxHeightJN0ABg(j, z);
    }

    /* renamed from: tryMaxHeight-JN-0ABg, reason: not valid java name */
    private final long m496tryMaxHeightJN0ABg(long j, boolean z) {
        int roundToInt;
        int m5693getMaxHeightimpl = Constraints.m5693getMaxHeightimpl(j);
        if (m5693getMaxHeightimpl != Integer.MAX_VALUE && (roundToInt = MathKt.roundToInt(m5693getMaxHeightimpl * this.aspectRatio)) > 0) {
            long IntSize = IntSizeKt.IntSize(roundToInt, m5693getMaxHeightimpl);
            if (!z || ConstraintsKt.m5709isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.INSTANCE.m5913getZeroYbymL2g();
    }

    /* renamed from: tryMinWidth-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m503tryMinWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m502tryMinWidthJN0ABg(j, z);
    }

    /* renamed from: tryMinWidth-JN-0ABg, reason: not valid java name */
    private final long m502tryMinWidthJN0ABg(long j, boolean z) {
        int m5696getMinWidthimpl = Constraints.m5696getMinWidthimpl(j);
        int roundToInt = MathKt.roundToInt(m5696getMinWidthimpl / this.aspectRatio);
        if (roundToInt > 0) {
            long IntSize = IntSizeKt.IntSize(m5696getMinWidthimpl, roundToInt);
            if (!z || ConstraintsKt.m5709isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.INSTANCE.m5913getZeroYbymL2g();
    }

    /* renamed from: tryMinHeight-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m501tryMinHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m500tryMinHeightJN0ABg(j, z);
    }

    /* renamed from: tryMinHeight-JN-0ABg, reason: not valid java name */
    private final long m500tryMinHeightJN0ABg(long j, boolean z) {
        int m5695getMinHeightimpl = Constraints.m5695getMinHeightimpl(j);
        int roundToInt = MathKt.roundToInt(m5695getMinHeightimpl * this.aspectRatio);
        if (roundToInt > 0) {
            long IntSize = IntSizeKt.IntSize(roundToInt, m5695getMinHeightimpl);
            if (!z || ConstraintsKt.m5709isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.INSTANCE.m5913getZeroYbymL2g();
    }
}

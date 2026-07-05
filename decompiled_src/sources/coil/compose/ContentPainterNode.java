package coil.compose;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactor;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* compiled from: ContentPainterModifier.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u001a\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0002ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u001a\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u0010+J\f\u00100\u001a\u000201*\u000202H\u0016J\u001c\u00103\u001a\u000204*\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000204H\u0016J\u001c\u00109\u001a\u000204*\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010:\u001a\u000204H\u0016J&\u0010;\u001a\u00020<*\u00020=2\u0006\u00106\u001a\u00020>2\u0006\u0010.\u001a\u00020-H\u0016ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u001c\u0010A\u001a\u000204*\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000204H\u0016J\u001c\u0010B\u001a\u000204*\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010:\u001a\u000204H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006C"}, d2 = {"Lcoil/compose/ContentPainterNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "coil-compose-base_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ContentPainterNode extends Modifier.Node implements DrawModifierNode, LayoutModifierNode {
    public static final int $stable = 8;
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final Painter getPainter() {
        return this.painter;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
    }

    public final void setContentScale(ContentScale contentScale) {
        this.contentScale = contentScale;
    }

    public final void setPainter(Painter painter) {
        this.painter = painter;
    }

    public ContentPainterNode(Painter painter, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        this.painter = painter;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo94measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable mo4687measureBRTryo0 = measurable.mo4687measureBRTryo0(m6064modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measureScope, mo4687measureBRTryo0.getWidth(), mo4687measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: coil.compose.ContentPainterNode$measure$1
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
        if (this.painter.getIntrinsicSize() != Size.INSTANCE.m3253getUnspecifiedNHjbRc()) {
            int minIntrinsicWidth = intrinsicMeasurable.minIntrinsicWidth(Constraints.m5693getMaxHeightimpl(m6064modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null))));
            return Math.max(MathKt.roundToInt(Size.m3245getWidthimpl(m6063calculateScaledSizeE7KxVPU(SizeKt.Size(minIntrinsicWidth, i)))), minIntrinsicWidth);
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.getIntrinsicSize() != Size.INSTANCE.m3253getUnspecifiedNHjbRc()) {
            int maxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(Constraints.m5693getMaxHeightimpl(m6064modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null))));
            return Math.max(MathKt.roundToInt(Size.m3245getWidthimpl(m6063calculateScaledSizeE7KxVPU(SizeKt.Size(maxIntrinsicWidth, i)))), maxIntrinsicWidth);
        }
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.getIntrinsicSize() != Size.INSTANCE.m3253getUnspecifiedNHjbRc()) {
            int minIntrinsicHeight = intrinsicMeasurable.minIntrinsicHeight(Constraints.m5694getMaxWidthimpl(m6064modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null))));
            return Math.max(MathKt.roundToInt(Size.m3242getHeightimpl(m6063calculateScaledSizeE7KxVPU(SizeKt.Size(i, minIntrinsicHeight)))), minIntrinsicHeight);
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.getIntrinsicSize() != Size.INSTANCE.m3253getUnspecifiedNHjbRc()) {
            int maxIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(Constraints.m5694getMaxWidthimpl(m6064modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null))));
            return Math.max(MathKt.roundToInt(Size.m3242getHeightimpl(m6063calculateScaledSizeE7KxVPU(SizeKt.Size(i, maxIntrinsicHeight)))), maxIntrinsicHeight);
        }
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    /* renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m6063calculateScaledSizeE7KxVPU(long dstSize) {
        if (Size.m3247isEmptyimpl(dstSize)) {
            return Size.INSTANCE.m3254getZeroNHjbRc();
        }
        long intrinsicSize = this.painter.getIntrinsicSize();
        if (intrinsicSize == Size.INSTANCE.m3253getUnspecifiedNHjbRc()) {
            return dstSize;
        }
        float m3245getWidthimpl = Size.m3245getWidthimpl(intrinsicSize);
        if (Float.isInfinite(m3245getWidthimpl) || Float.isNaN(m3245getWidthimpl)) {
            m3245getWidthimpl = Size.m3245getWidthimpl(dstSize);
        }
        float m3242getHeightimpl = Size.m3242getHeightimpl(intrinsicSize);
        if (Float.isInfinite(m3242getHeightimpl) || Float.isNaN(m3242getHeightimpl)) {
            m3242getHeightimpl = Size.m3242getHeightimpl(dstSize);
        }
        long Size = SizeKt.Size(m3245getWidthimpl, m3242getHeightimpl);
        long mo4678computeScaleFactorH7hwNQA = this.contentScale.mo4678computeScaleFactorH7hwNQA(Size, dstSize);
        float m4757getScaleXimpl = ScaleFactor.m4757getScaleXimpl(mo4678computeScaleFactorH7hwNQA);
        if (Float.isInfinite(m4757getScaleXimpl) || Float.isNaN(m4757getScaleXimpl)) {
            return dstSize;
        }
        float m4758getScaleYimpl = ScaleFactor.m4758getScaleYimpl(mo4678computeScaleFactorH7hwNQA);
        return (Float.isInfinite(m4758getScaleYimpl) || Float.isNaN(m4758getScaleYimpl)) ? dstSize : ScaleFactorKt.m4773timesmw2e94(mo4678computeScaleFactorH7hwNQA, Size);
    }

    /* renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m6064modifyConstraintsZezNO4M(long constraints) {
        float m5696getMinWidthimpl;
        int m5695getMinHeightimpl;
        float m6094constrainHeightK40F9xA;
        boolean m5692getHasFixedWidthimpl = Constraints.m5692getHasFixedWidthimpl(constraints);
        boolean m5691getHasFixedHeightimpl = Constraints.m5691getHasFixedHeightimpl(constraints);
        if (m5692getHasFixedWidthimpl && m5691getHasFixedHeightimpl) {
            return constraints;
        }
        boolean z = Constraints.m5690getHasBoundedWidthimpl(constraints) && Constraints.m5689getHasBoundedHeightimpl(constraints);
        long intrinsicSize = this.painter.getIntrinsicSize();
        if (intrinsicSize == Size.INSTANCE.m3253getUnspecifiedNHjbRc()) {
            return z ? Constraints.m5685copyZbe2FdA$default(constraints, Constraints.m5694getMaxWidthimpl(constraints), 0, Constraints.m5693getMaxHeightimpl(constraints), 0, 10, null) : constraints;
        }
        if (z && (m5692getHasFixedWidthimpl || m5691getHasFixedHeightimpl)) {
            m5696getMinWidthimpl = Constraints.m5694getMaxWidthimpl(constraints);
            m5695getMinHeightimpl = Constraints.m5693getMaxHeightimpl(constraints);
        } else {
            float m3245getWidthimpl = Size.m3245getWidthimpl(intrinsicSize);
            float m3242getHeightimpl = Size.m3242getHeightimpl(intrinsicSize);
            m5696getMinWidthimpl = (Float.isInfinite(m3245getWidthimpl) || Float.isNaN(m3245getWidthimpl)) ? Constraints.m5696getMinWidthimpl(constraints) : UtilsKt.m6095constrainWidthK40F9xA(constraints, m3245getWidthimpl);
            if (Float.isInfinite(m3242getHeightimpl) || Float.isNaN(m3242getHeightimpl)) {
                m5695getMinHeightimpl = Constraints.m5695getMinHeightimpl(constraints);
            } else {
                m6094constrainHeightK40F9xA = UtilsKt.m6094constrainHeightK40F9xA(constraints, m3242getHeightimpl);
                long m6063calculateScaledSizeE7KxVPU = m6063calculateScaledSizeE7KxVPU(SizeKt.Size(m5696getMinWidthimpl, m6094constrainHeightK40F9xA));
                return Constraints.m5685copyZbe2FdA$default(constraints, ConstraintsKt.m5708constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.m3245getWidthimpl(m6063calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m5707constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.m3242getHeightimpl(m6063calculateScaledSizeE7KxVPU))), 0, 10, null);
            }
        }
        m6094constrainHeightK40F9xA = m5695getMinHeightimpl;
        long m6063calculateScaledSizeE7KxVPU2 = m6063calculateScaledSizeE7KxVPU(SizeKt.Size(m5696getMinWidthimpl, m6094constrainHeightK40F9xA));
        return Constraints.m5685copyZbe2FdA$default(constraints, ConstraintsKt.m5708constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.m3245getWidthimpl(m6063calculateScaledSizeE7KxVPU2))), 0, ConstraintsKt.m5707constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.m3242getHeightimpl(m6063calculateScaledSizeE7KxVPU2))), 0, 10, null);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        long m6063calculateScaledSizeE7KxVPU = m6063calculateScaledSizeE7KxVPU(contentDrawScope.mo3966getSizeNHjbRc());
        long mo3053alignKFBX0sM = this.alignment.mo3053alignKFBX0sM(UtilsKt.m6097toIntSizeuvyYCjk(m6063calculateScaledSizeE7KxVPU), UtilsKt.m6097toIntSizeuvyYCjk(contentDrawScope.mo3966getSizeNHjbRc()), contentDrawScope.getLayoutDirection());
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        float m5858component1impl = IntOffset.m5858component1impl(mo3053alignKFBX0sM);
        float m5859component2impl = IntOffset.m5859component2impl(mo3053alignKFBX0sM);
        contentDrawScope2.getDrawContext().getTransform().translate(m5858component1impl, m5859component2impl);
        this.painter.m4042drawx_KDEd0(contentDrawScope2, m6063calculateScaledSizeE7KxVPU, this.alpha, this.colorFilter);
        contentDrawScope2.getDrawContext().getTransform().translate(-m5858component1impl, -m5859component2impl);
        contentDrawScope.drawContent();
    }
}

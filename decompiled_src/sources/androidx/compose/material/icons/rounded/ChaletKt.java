package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Chalet.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_chalet", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Chalet", "Landroidx/compose/material/icons/Icons$Rounded;", "getChalet", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ChaletKt {
    private static ImageVector _chalet;

    public static final ImageVector getChalet(Icons.Rounded rounded) {
        ImageVector.Builder m4051addPathoIyEayM;
        ImageVector imageVector = _chalet;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.Chalet", Dp.m5738constructorimpl(24.0f), Dp.m5738constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m3443getBlack0d7_KjU(), null);
        int m3769getButtKaPHkGw = StrokeCap.INSTANCE.m3769getButtKaPHkGw();
        int m3779getBevelLxFBmk8 = StrokeJoin.INSTANCE.m3779getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(10.0f, 15.0f);
        pathBuilder.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
        pathBuilder.verticalLineToRelative(4.0f);
        pathBuilder.horizontalLineTo(6.0f);
        pathBuilder.curveToRelative(-0.55f, 0.0f, -1.0f, -0.45f, -1.0f, -1.0f);
        pathBuilder.verticalLineToRelative(-3.67f);
        pathBuilder.lineToRelative(-0.38f, 0.38f);
        pathBuilder.curveToRelative(-0.39f, 0.39f, -1.02f, 0.39f, -1.41f, 0.0f);
        pathBuilder.lineToRelative(0.0f, 0.0f);
        pathBuilder.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0.0f, -1.41f);
        pathBuilder.lineToRelative(6.09f, -6.09f);
        pathBuilder.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0.0f);
        pathBuilder.lineToRelative(6.09f, 6.09f);
        pathBuilder.curveToRelative(0.39f, 0.39f, 0.39f, 1.02f, 0.0f, 1.41f);
        pathBuilder.verticalLineToRelative(0.0f);
        pathBuilder.curveToRelative(-0.39f, 0.39f, -1.02f, 0.39f, -1.41f, 0.0f);
        pathBuilder.lineTo(15.0f, 15.33f);
        pathBuilder.verticalLineTo(19.0f);
        pathBuilder.curveToRelative(0.0f, 0.55f, -0.45f, 1.0f, -1.0f, 1.0f);
        pathBuilder.horizontalLineToRelative(-3.0f);
        pathBuilder.verticalLineToRelative(-4.0f);
        pathBuilder.curveTo(11.0f, 15.45f, 10.55f, 15.0f, 10.0f, 15.0f);
        pathBuilder.close();
        pathBuilder.moveTo(17.5f, 7.5f);
        pathBuilder.verticalLineToRelative(0.89f);
        pathBuilder.lineToRelative(-1.08f, 1.08f);
        pathBuilder.curveToRelative(-0.18f, 0.18f, -0.21f, 0.48f, -0.05f, 0.69f);
        pathBuilder.curveToRelative(0.19f, 0.23f, 0.53f, 0.24f, 0.74f, 0.04f);
        pathBuilder.lineToRelative(0.39f, -0.39f);
        pathBuilder.verticalLineToRelative(0.69f);
        pathBuilder.curveToRelative(0.0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f);
        pathBuilder.horizontalLineToRelative(0.0f);
        pathBuilder.curveToRelative(0.28f, 0.0f, 0.5f, -0.22f, 0.5f, -0.5f);
        pathBuilder.verticalLineTo(9.81f);
        pathBuilder.lineToRelative(0.39f, 0.39f);
        pathBuilder.curveToRelative(0.21f, 0.21f, 0.55f, 0.19f, 0.74f, -0.04f);
        pathBuilder.curveToRelative(0.17f, -0.2f, 0.14f, -0.5f, -0.05f, -0.69f);
        pathBuilder.lineTo(18.5f, 8.39f);
        pathBuilder.curveToRelative(0.0f, 0.0f, 0.0f, -0.89f, 0.0f, -0.89f);
        pathBuilder.horizontalLineToRelative(0.89f);
        pathBuilder.lineToRelative(1.08f, 1.08f);
        pathBuilder.curveToRelative(0.18f, 0.18f, 0.48f, 0.21f, 0.69f, 0.05f);
        pathBuilder.curveToRelative(0.23f, -0.19f, 0.24f, -0.53f, 0.04f, -0.74f);
        pathBuilder.lineTo(20.81f, 7.5f);
        pathBuilder.horizontalLineToRelative(0.69f);
        pathBuilder.curveTo(21.78f, 7.5f, 22.0f, 7.28f, 22.0f, 7.0f);
        pathBuilder.verticalLineToRelative(0.0f);
        pathBuilder.curveToRelative(0.0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f);
        pathBuilder.lineToRelative(-0.69f, 0.0f);
        pathBuilder.lineToRelative(0.39f, -0.39f);
        pathBuilder.curveToRelative(0.21f, -0.21f, 0.19f, -0.55f, -0.04f, -0.74f);
        pathBuilder.curveToRelative(-0.2f, -0.17f, -0.5f, -0.14f, -0.69f, 0.05f);
        pathBuilder.lineTo(19.39f, 6.5f);
        pathBuilder.curveToRelative(0.0f, 0.0f, -0.89f, 0.0f, -0.89f, 0.0f);
        pathBuilder.verticalLineTo(5.61f);
        pathBuilder.lineToRelative(1.08f, -1.08f);
        pathBuilder.curveToRelative(0.18f, -0.18f, 0.21f, -0.48f, 0.05f, -0.69f);
        pathBuilder.curveToRelative(-0.19f, -0.23f, -0.53f, -0.24f, -0.74f, -0.04f);
        pathBuilder.lineTo(18.5f, 4.19f);
        pathBuilder.verticalLineTo(3.5f);
        pathBuilder.curveTo(18.5f, 3.22f, 18.28f, 3.0f, 18.0f, 3.0f);
        pathBuilder.horizontalLineToRelative(0.0f);
        pathBuilder.curveToRelative(-0.28f, 0.0f, -0.5f, 0.22f, -0.5f, 0.5f);
        pathBuilder.verticalLineToRelative(0.69f);
        pathBuilder.lineTo(17.11f, 3.8f);
        pathBuilder.curveToRelative(-0.21f, -0.21f, -0.55f, -0.19f, -0.74f, 0.04f);
        pathBuilder.curveToRelative(-0.17f, 0.2f, -0.14f, 0.5f, 0.05f, 0.69f);
        pathBuilder.lineToRelative(1.08f, 1.08f);
        pathBuilder.curveToRelative(0.0f, 0.0f, 0.0f, 0.89f, 0.0f, 0.89f);
        pathBuilder.horizontalLineToRelative(-0.89f);
        pathBuilder.lineToRelative(-1.08f, -1.08f);
        pathBuilder.curveToRelative(-0.18f, -0.18f, -0.48f, -0.21f, -0.69f, -0.05f);
        pathBuilder.curveToRelative(-0.23f, 0.19f, -0.24f, 0.53f, -0.04f, 0.74f);
        pathBuilder.lineToRelative(0.39f, 0.39f);
        pathBuilder.horizontalLineTo(14.5f);
        pathBuilder.curveTo(14.22f, 6.5f, 14.0f, 6.72f, 14.0f, 7.0f);
        pathBuilder.verticalLineToRelative(0.0f);
        pathBuilder.curveToRelative(0.0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f);
        pathBuilder.lineToRelative(0.69f, 0.0f);
        pathBuilder.lineTo(14.8f, 7.89f);
        pathBuilder.curveToRelative(-0.21f, 0.21f, -0.19f, 0.55f, 0.04f, 0.74f);
        pathBuilder.curveToRelative(0.2f, 0.17f, 0.5f, 0.14f, 0.69f, -0.05f);
        pathBuilder.lineToRelative(1.08f, -1.08f);
        pathBuilder.curveTo(16.61f, 7.5f, 17.5f, 7.5f, 17.5f, 7.5f);
        pathBuilder.close();
        m4051addPathoIyEayM = builder.m4051addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3769getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3779getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        ImageVector build = m4051addPathoIyEayM.build();
        _chalet = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}

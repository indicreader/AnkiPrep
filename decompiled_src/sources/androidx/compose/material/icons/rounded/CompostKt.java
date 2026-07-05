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

/* compiled from: Compost.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_compost", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Compost", "Landroidx/compose/material/icons/Icons$Rounded;", "getCompost", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CompostKt {
    private static ImageVector _compost;

    public static final ImageVector getCompost(Icons.Rounded rounded) {
        ImageVector.Builder m4051addPathoIyEayM;
        ImageVector imageVector = _compost;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.Compost", Dp.m5738constructorimpl(24.0f), Dp.m5738constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m3443getBlack0d7_KjU(), null);
        int m3769getButtKaPHkGw = StrokeCap.INSTANCE.m3769getButtKaPHkGw();
        int m3779getBevelLxFBmk8 = StrokeJoin.INSTANCE.m3779getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(11.73f, 21.5f);
        pathBuilder.curveToRelative(-4.95f, -0.14f, -9.08f, -4.27f, -9.22f, -9.22f);
        pathBuilder.curveTo(2.35f, 6.91f, 6.67f, 2.5f, 12.0f, 2.5f);
        pathBuilder.verticalLineTo(1.21f);
        pathBuilder.curveToRelative(0.0f, -0.45f, 0.54f, -0.67f, 0.85f, -0.35f);
        pathBuilder.lineToRelative(2.79f, 2.79f);
        pathBuilder.curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0.0f, 0.71f);
        pathBuilder.lineToRelative(-2.79f, 2.79f);
        pathBuilder.curveTo(12.54f, 7.46f, 12.0f, 7.24f, 12.0f, 6.79f);
        pathBuilder.verticalLineTo(5.5f);
        pathBuilder.curveToRelative(-3.58f, 0.0f, -6.5f, 2.92f, -6.5f, 6.5f);
        pathBuilder.curveToRelative(0.0f, 2.21f, 1.11f, 4.17f, 2.81f, 5.35f);
        pathBuilder.curveToRelative(0.51f, -0.92f, 1.63f, -1.62f, 2.98f, -1.8f);
        pathBuilder.curveToRelative(-0.09f, -0.69f, -0.26f, -1.42f, -0.49f, -2.03f);
        pathBuilder.curveToRelative(-0.33f, 0.28f, -0.75f, 0.46f, -1.22f, 0.48f);
        pathBuilder.curveToRelative(-1.14f, 0.05f, -2.08f, -0.99f, -2.08f, -2.13f);
        pathBuilder.lineToRelative(0.0f, -0.86f);
        pathBuilder.curveToRelative(0.0f, -0.29f, -0.05f, -0.57f, -0.14f, -0.83f);
        pathBuilder.curveTo(7.24f, 9.84f, 7.5f, 9.49f, 7.86f, 9.52f);
        pathBuilder.curveToRelative(1.3f, 0.09f, 3.6f, 0.52f, 3.64f, 2.48f);
        pathBuilder.curveToRelative(0.0f, 0.29f, -0.06f, 0.56f, -0.17f, 0.8f);
        pathBuilder.curveTo(10.91f, 12.48f, 10.47f, 12.2f, 10.0f, 12.0f);
        pathBuilder.curveToRelative(0.58f, 0.43f, 1.37f, 1.37f, 2.0f, 2.6f);
        pathBuilder.curveToRelative(0.67f, -1.62f, 1.68f, -3.27f, 3.0f, -4.6f);
        pathBuilder.curveToRelative(-0.76f, 0.52f, -1.47f, 1.12f, -2.13f, 1.81f);
        pathBuilder.curveToRelative(-0.26f, -0.42f, -0.4f, -0.93f, -0.36f, -1.47f);
        pathBuilder.curveTo(12.59f, 9.0f, 13.79f, 8.0f, 15.13f, 8.0f);
        pathBuilder.lineTo(16.0f, 8.0f);
        pathBuilder.curveToRelative(0.56f, 0.0f, 0.97f, -0.14f, 1.28f, -0.31f);
        pathBuilder.curveToRelative(0.34f, -0.19f, 0.76f, 0.05f, 0.75f, 0.44f);
        pathBuilder.curveTo(17.99f, 9.87f, 17.56f, 13.0f, 15.0f, 13.0f);
        pathBuilder.curveToRelative(-0.49f, 0.0f, -0.94f, -0.14f, -1.32f, -0.38f);
        pathBuilder.curveToRelative(-0.24f, 0.64f, -0.59f, 1.76f, -0.76f, 2.96f);
        pathBuilder.curveToRelative(1.26f, 0.22f, 2.28f, 0.89f, 2.77f, 1.77f);
        pathBuilder.curveToRelative(1.57f, -1.09f, 2.64f, -2.85f, 2.79f, -4.87f);
        pathBuilder.curveTo(18.5f, 12.22f, 18.71f, 12.0f, 18.98f, 12.0f);
        pathBuilder.lineToRelative(1.82f, 0.0f);
        pathBuilder.curveToRelative(0.47f, 0.0f, 0.71f, 0.24f, 0.69f, 0.52f);
        pathBuilder.curveTo(21.21f, 17.61f, 16.91f, 21.64f, 11.73f, 21.5f);
        pathBuilder.close();
        m4051addPathoIyEayM = builder.m4051addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3769getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3779getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        ImageVector build = m4051addPathoIyEayM.build();
        _compost = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}

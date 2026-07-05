package androidx.compose.material.icons.twotone;

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

/* compiled from: VisibilityOff.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_visibilityOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "VisibilityOff", "Landroidx/compose/material/icons/Icons$TwoTone;", "getVisibilityOff", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class VisibilityOffKt {
    private static ImageVector _visibilityOff;

    public static final ImageVector getVisibilityOff(Icons.TwoTone twoTone) {
        ImageVector.Builder m4051addPathoIyEayM;
        ImageVector imageVector = _visibilityOff;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("TwoTone.VisibilityOff", Dp.m5738constructorimpl(24.0f), Dp.m5738constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m3443getBlack0d7_KjU(), null);
        int m3769getButtKaPHkGw = StrokeCap.INSTANCE.m3769getButtKaPHkGw();
        int m3779getBevelLxFBmk8 = StrokeJoin.INSTANCE.m3779getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(12.0f, 14.0f);
        pathBuilder.curveToRelative(0.04f, 0.0f, 0.08f, -0.01f, 0.12f, -0.01f);
        pathBuilder.lineToRelative(-2.61f, -2.61f);
        pathBuilder.curveToRelative(0.0f, 0.04f, -0.01f, 0.08f, -0.01f, 0.12f);
        pathBuilder.curveToRelative(0.0f, 1.38f, 1.12f, 2.5f, 2.5f, 2.5f);
        pathBuilder.close();
        pathBuilder.moveTo(13.01f, 9.21f);
        pathBuilder.lineToRelative(1.28f, 1.28f);
        pathBuilder.curveToRelative(-0.26f, -0.57f, -0.71f, -1.03f, -1.28f, -1.28f);
        pathBuilder.close();
        pathBuilder.moveTo(20.82f, 11.5f);
        pathBuilder.curveTo(19.17f, 8.13f, 15.79f, 6.0f, 12.0f, 6.0f);
        pathBuilder.curveToRelative(-0.68f, 0.0f, -1.34f, 0.09f, -1.99f, 0.22f);
        pathBuilder.lineToRelative(0.92f, 0.92f);
        pathBuilder.curveToRelative(0.35f, -0.09f, 0.7f, -0.14f, 1.07f, -0.14f);
        pathBuilder.curveToRelative(2.48f, 0.0f, 4.5f, 2.02f, 4.5f, 4.5f);
        pathBuilder.curveToRelative(0.0f, 0.37f, -0.06f, 0.72f, -0.14f, 1.07f);
        pathBuilder.lineToRelative(2.05f, 2.05f);
        pathBuilder.curveToRelative(0.98f, -0.86f, 1.81f, -1.91f, 2.41f, -3.12f);
        pathBuilder.close();
        pathBuilder.moveTo(12.0f, 17.0f);
        pathBuilder.curveToRelative(0.95f, 0.0f, 1.87f, -0.13f, 2.75f, -0.39f);
        pathBuilder.lineToRelative(-0.98f, -0.98f);
        pathBuilder.curveToRelative(-0.54f, 0.24f, -1.14f, 0.37f, -1.77f, 0.37f);
        pathBuilder.curveToRelative(-2.48f, 0.0f, -4.5f, -2.02f, -4.5f, -4.5f);
        pathBuilder.curveToRelative(0.0f, -0.63f, 0.13f, -1.23f, 0.36f, -1.77f);
        pathBuilder.lineTo(6.11f, 7.97f);
        pathBuilder.curveToRelative(-1.22f, 0.91f, -2.23f, 2.1f, -2.93f, 3.52f);
        pathBuilder.curveTo(4.83f, 14.86f, 8.21f, 17.0f, 12.0f, 17.0f);
        pathBuilder.close();
        builder.m4051addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3769getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3779getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(Color.INSTANCE.m3443getBlack0d7_KjU(), null);
        int m3769getButtKaPHkGw2 = StrokeCap.INSTANCE.m3769getButtKaPHkGw();
        int m3779getBevelLxFBmk82 = StrokeJoin.INSTANCE.m3779getBevelLxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(12.0f, 6.0f);
        pathBuilder2.curveToRelative(3.79f, 0.0f, 7.17f, 2.13f, 8.82f, 5.5f);
        pathBuilder2.curveToRelative(-0.59f, 1.22f, -1.42f, 2.27f, -2.41f, 3.12f);
        pathBuilder2.lineToRelative(1.41f, 1.41f);
        pathBuilder2.curveToRelative(1.39f, -1.23f, 2.49f, -2.77f, 3.18f, -4.53f);
        pathBuilder2.curveTo(21.27f, 7.11f, 17.0f, 4.0f, 12.0f, 4.0f);
        pathBuilder2.curveToRelative(-1.27f, 0.0f, -2.49f, 0.2f, -3.64f, 0.57f);
        pathBuilder2.lineToRelative(1.65f, 1.65f);
        pathBuilder2.curveTo(10.66f, 6.09f, 11.32f, 6.0f, 12.0f, 6.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(14.28f, 10.49f);
        pathBuilder2.lineToRelative(2.07f, 2.07f);
        pathBuilder2.curveToRelative(0.08f, -0.34f, 0.14f, -0.7f, 0.14f, -1.07f);
        pathBuilder2.curveTo(16.5f, 9.01f, 14.48f, 7.0f, 12.0f, 7.0f);
        pathBuilder2.curveToRelative(-0.37f, 0.0f, -0.72f, 0.06f, -1.07f, 0.14f);
        pathBuilder2.lineTo(13.0f, 9.21f);
        pathBuilder2.curveToRelative(0.58f, 0.25f, 1.03f, 0.71f, 1.28f, 1.28f);
        pathBuilder2.close();
        pathBuilder2.moveTo(2.01f, 3.87f);
        pathBuilder2.lineToRelative(2.68f, 2.68f);
        pathBuilder2.curveTo(3.06f, 7.83f, 1.77f, 9.53f, 1.0f, 11.5f);
        pathBuilder2.curveTo(2.73f, 15.89f, 7.0f, 19.0f, 12.0f, 19.0f);
        pathBuilder2.curveToRelative(1.52f, 0.0f, 2.98f, -0.29f, 4.32f, -0.82f);
        pathBuilder2.lineToRelative(3.42f, 3.42f);
        pathBuilder2.lineToRelative(1.41f, -1.41f);
        pathBuilder2.lineTo(3.42f, 2.45f);
        pathBuilder2.lineTo(2.01f, 3.87f);
        pathBuilder2.close();
        pathBuilder2.moveTo(9.51f, 11.37f);
        pathBuilder2.lineToRelative(2.61f, 2.61f);
        pathBuilder2.curveToRelative(-0.04f, 0.01f, -0.08f, 0.02f, -0.12f, 0.02f);
        pathBuilder2.curveToRelative(-1.38f, 0.0f, -2.5f, -1.12f, -2.5f, -2.5f);
        pathBuilder2.curveToRelative(0.0f, -0.05f, 0.01f, -0.08f, 0.01f, -0.13f);
        pathBuilder2.close();
        pathBuilder2.moveTo(6.11f, 7.97f);
        pathBuilder2.lineToRelative(1.75f, 1.75f);
        pathBuilder2.curveToRelative(-0.23f, 0.55f, -0.36f, 1.15f, -0.36f, 1.78f);
        pathBuilder2.curveToRelative(0.0f, 2.48f, 2.02f, 4.5f, 4.5f, 4.5f);
        pathBuilder2.curveToRelative(0.63f, 0.0f, 1.23f, -0.13f, 1.77f, -0.36f);
        pathBuilder2.lineToRelative(0.98f, 0.98f);
        pathBuilder2.curveToRelative(-0.88f, 0.24f, -1.8f, 0.38f, -2.75f, 0.38f);
        pathBuilder2.curveToRelative(-3.79f, 0.0f, -7.17f, -2.13f, -8.82f, -5.5f);
        pathBuilder2.curveToRelative(0.7f, -1.43f, 1.72f, -2.61f, 2.93f, -3.53f);
        pathBuilder2.close();
        m4051addPathoIyEayM = builder.m4051addPathoIyEayM(pathBuilder2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3769getButtKaPHkGw2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3779getBevelLxFBmk82, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        ImageVector build = m4051addPathoIyEayM.build();
        _visibilityOff = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}

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

/* compiled from: LogoDev.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_logoDev", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LogoDev", "Landroidx/compose/material/icons/Icons$Rounded;", "getLogoDev", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LogoDevKt {
    private static ImageVector _logoDev;

    public static final ImageVector getLogoDev(Icons.Rounded rounded) {
        ImageVector.Builder m4051addPathoIyEayM;
        ImageVector imageVector = _logoDev;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.LogoDev", Dp.m5738constructorimpl(24.0f), Dp.m5738constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m3443getBlack0d7_KjU(), null);
        int m3769getButtKaPHkGw = StrokeCap.INSTANCE.m3769getButtKaPHkGw();
        int m3779getBevelLxFBmk8 = StrokeJoin.INSTANCE.m3779getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(19.0f, 3.0f);
        pathBuilder.horizontalLineTo(5.0f);
        pathBuilder.curveTo(3.9f, 3.0f, 3.0f, 3.9f, 3.0f, 5.0f);
        pathBuilder.verticalLineToRelative(14.0f);
        pathBuilder.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        pathBuilder.horizontalLineToRelative(14.0f);
        pathBuilder.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        pathBuilder.verticalLineTo(5.0f);
        pathBuilder.curveTo(21.0f, 3.9f, 20.1f, 3.0f, 19.0f, 3.0f);
        pathBuilder.close();
        pathBuilder.moveTo(7.68f, 14.98f);
        pathBuilder.horizontalLineTo(6.0f);
        pathBuilder.verticalLineTo(9.0f);
        pathBuilder.horizontalLineToRelative(1.71f);
        pathBuilder.curveToRelative(1.28f, 0.0f, 1.71f, 1.03f, 1.71f, 1.71f);
        pathBuilder.lineToRelative(0.0f, 2.56f);
        pathBuilder.curveTo(9.42f, 13.95f, 9.0f, 14.98f, 7.68f, 14.98f);
        pathBuilder.close();
        pathBuilder.moveTo(12.38f, 11.46f);
        pathBuilder.verticalLineToRelative(1.07f);
        pathBuilder.horizontalLineToRelative(-1.18f);
        pathBuilder.verticalLineToRelative(1.39f);
        pathBuilder.horizontalLineToRelative(1.93f);
        pathBuilder.verticalLineToRelative(1.07f);
        pathBuilder.horizontalLineToRelative(-2.25f);
        pathBuilder.curveToRelative(-0.4f, 0.01f, -0.74f, -0.31f, -0.75f, -0.71f);
        pathBuilder.verticalLineTo(9.75f);
        pathBuilder.curveToRelative(-0.01f, -0.4f, 0.31f, -0.74f, 0.71f, -0.75f);
        pathBuilder.horizontalLineToRelative(2.28f);
        pathBuilder.lineToRelative(0.0f, 1.07f);
        pathBuilder.horizontalLineToRelative(-1.92f);
        pathBuilder.verticalLineToRelative(1.39f);
        pathBuilder.horizontalLineTo(12.38f);
        pathBuilder.close();
        pathBuilder.moveTo(16.88f, 14.23f);
        pathBuilder.curveToRelative(-0.48f, 1.11f, -1.33f, 0.89f, -1.71f, 0.0f);
        pathBuilder.lineTo(13.77f, 9.0f);
        pathBuilder.horizontalLineToRelative(1.18f);
        pathBuilder.lineToRelative(1.07f, 4.11f);
        pathBuilder.lineTo(17.09f, 9.0f);
        pathBuilder.horizontalLineToRelative(1.18f);
        pathBuilder.lineTo(16.88f, 14.23f);
        pathBuilder.close();
        builder.m4051addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3769getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3779getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(Color.INSTANCE.m3443getBlack0d7_KjU(), null);
        int m3769getButtKaPHkGw2 = StrokeCap.INSTANCE.m3769getButtKaPHkGw();
        int m3779getBevelLxFBmk82 = StrokeJoin.INSTANCE.m3779getBevelLxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(7.77f, 10.12f);
        pathBuilder2.horizontalLineTo(7.14f);
        pathBuilder2.verticalLineToRelative(3.77f);
        pathBuilder2.horizontalLineToRelative(0.63f);
        pathBuilder2.curveToRelative(0.14f, 0.0f, 0.28f, -0.05f, 0.42f, -0.16f);
        pathBuilder2.curveToRelative(0.14f, -0.1f, 0.21f, -0.26f, 0.21f, -0.47f);
        pathBuilder2.verticalLineToRelative(-2.52f);
        pathBuilder2.curveToRelative(0.0f, -0.21f, -0.07f, -0.37f, -0.21f, -0.47f);
        pathBuilder2.curveTo(8.05f, 10.17f, 7.91f, 10.12f, 7.77f, 10.12f);
        pathBuilder2.close();
        m4051addPathoIyEayM = builder.m4051addPathoIyEayM(pathBuilder2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3769getButtKaPHkGw2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3779getBevelLxFBmk82, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        ImageVector build = m4051addPathoIyEayM.build();
        _logoDev = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}

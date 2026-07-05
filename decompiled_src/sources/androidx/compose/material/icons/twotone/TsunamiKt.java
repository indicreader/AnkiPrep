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

/* compiled from: Tsunami.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_tsunami", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Tsunami", "Landroidx/compose/material/icons/Icons$TwoTone;", "getTsunami", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TsunamiKt {
    private static ImageVector _tsunami;

    public static final ImageVector getTsunami(Icons.TwoTone twoTone) {
        ImageVector.Builder m4051addPathoIyEayM;
        ImageVector imageVector = _tsunami;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("TwoTone.Tsunami", Dp.m5738constructorimpl(24.0f), Dp.m5738constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m3443getBlack0d7_KjU(), null);
        int m3769getButtKaPHkGw = StrokeCap.INSTANCE.m3769getButtKaPHkGw();
        int m3779getBevelLxFBmk8 = StrokeJoin.INSTANCE.m3779getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(4.04f, 14.0f);
        pathBuilder.curveToRelative(0.47f, -0.24f, 0.68f, -0.41f, 1.3f, -0.87f);
        pathBuilder.curveToRelative(2.0f, 1.48f, 3.07f, 1.39f, 3.79f, 1.32f);
        pathBuilder.curveTo(8.4f, 13.27f, 8.0f, 11.92f, 8.0f, 10.5f);
        pathBuilder.curveToRelative(0.0f, -1.67f, 0.54f, -3.21f, 1.47f, -4.46f);
        pathBuilder.curveTo(6.41f, 7.52f, 4.3f, 10.46f, 4.04f, 14.0f);
        pathBuilder.close();
        builder.m4051addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3769getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3779getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(Color.INSTANCE.m3443getBlack0d7_KjU(), null);
        int m3769getButtKaPHkGw2 = StrokeCap.INSTANCE.m3769getButtKaPHkGw();
        int m3779getBevelLxFBmk82 = StrokeJoin.INSTANCE.m3779getBevelLxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(12.0f, 17.63f);
        pathBuilder2.curveToRelative(-0.66f, 0.49f, -2.92f, 2.76f, -6.67f, 0.0f);
        pathBuilder2.curveTo(3.43f, 19.03f, 2.65f, 19.0f, 2.0f, 19.0f);
        pathBuilder2.verticalLineToRelative(2.0f);
        pathBuilder2.curveToRelative(1.16f, 0.0f, 2.3f, -0.32f, 3.33f, -0.93f);
        pathBuilder2.curveToRelative(2.06f, 1.22f, 4.61f, 1.22f, 6.67f, 0.0f);
        pathBuilder2.curveToRelative(2.06f, 1.22f, 4.61f, 1.22f, 6.67f, 0.0f);
        pathBuilder2.curveTo(19.7f, 20.68f, 20.84f, 21.0f, 22.0f, 21.0f);
        pathBuilder2.verticalLineToRelative(-2.0f);
        pathBuilder2.curveToRelative(-0.66f, 0.0f, -1.5f, -0.02f, -3.33f, -1.37f);
        pathBuilder2.curveTo(14.87f, 20.43f, 12.54f, 18.03f, 12.0f, 17.63f);
        pathBuilder2.close();
        builder.m4051addPathoIyEayM(pathBuilder2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3769getButtKaPHkGw2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3779getBevelLxFBmk82, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int defaultFillType3 = VectorKt.getDefaultFillType();
        SolidColor solidColor3 = new SolidColor(Color.INSTANCE.m3443getBlack0d7_KjU(), null);
        int m3769getButtKaPHkGw3 = StrokeCap.INSTANCE.m3769getButtKaPHkGw();
        int m3779getBevelLxFBmk83 = StrokeJoin.INSTANCE.m3779getBevelLxFBmk8();
        PathBuilder pathBuilder3 = new PathBuilder();
        pathBuilder3.moveTo(19.33f, 12.0f);
        pathBuilder3.horizontalLineTo(22.0f);
        pathBuilder3.verticalLineToRelative(-2.0f);
        pathBuilder3.horizontalLineToRelative(-2.67f);
        pathBuilder3.curveTo(17.5f, 10.0f, 16.0f, 8.5f, 16.0f, 6.67f);
        pathBuilder3.curveToRelative(0.0f, -1.02f, 0.38f, -1.74f, 1.09f, -3.34f);
        pathBuilder3.curveTo(15.72f, 3.12f, 15.09f, 3.0f, 14.0f, 3.0f);
        pathBuilder3.curveTo(7.36f, 3.0f, 2.15f, 8.03f, 2.01f, 14.5f);
        pathBuilder3.curveToRelative(0.0f, 0.0f, -0.01f, 2.0f, -0.01f, 2.0f);
        pathBuilder3.curveToRelative(1.16f, 0.0f, 2.3f, -0.32f, 3.33f, -0.93f);
        pathBuilder3.curveToRelative(2.06f, 1.22f, 4.61f, 1.22f, 6.67f, 0.0f);
        pathBuilder3.curveToRelative(2.06f, 1.22f, 4.61f, 1.22f, 6.67f, 0.0f);
        pathBuilder3.curveToRelative(1.03f, 0.61f, 2.17f, 0.93f, 3.33f, 0.93f);
        pathBuilder3.verticalLineToRelative(-2.0f);
        pathBuilder3.curveToRelative(-0.66f, 0.0f, -1.5f, -0.02f, -3.33f, -1.37f);
        pathBuilder3.curveToRelative(-3.8f, 2.8f, -6.12f, 0.4f, -6.67f, 0.0f);
        pathBuilder3.curveToRelative(-0.9f, 0.67f, -0.54f, 0.41f, -0.91f, 0.63f);
        pathBuilder3.curveTo(10.39f, 12.82f, 10.0f, 11.7f, 10.0f, 10.5f);
        pathBuilder3.curveToRelative(0.0f, -2.58f, 1.77f, -4.74f, 4.21f, -5.33f);
        pathBuilder3.curveTo(14.08f, 5.68f, 14.0f, 6.19f, 14.0f, 6.67f);
        pathBuilder3.curveTo(14.0f, 9.61f, 16.39f, 12.0f, 19.33f, 12.0f);
        pathBuilder3.close();
        pathBuilder3.moveTo(9.13f, 14.45f);
        pathBuilder3.curveToRelative(-0.72f, 0.07f, -1.79f, 0.16f, -3.79f, -1.32f);
        pathBuilder3.curveToRelative(-0.62f, 0.46f, -0.82f, 0.63f, -1.3f, 0.87f);
        pathBuilder3.curveToRelative(0.27f, -3.53f, 2.38f, -6.48f, 5.43f, -7.96f);
        pathBuilder3.curveTo(8.54f, 7.29f, 8.0f, 8.83f, 8.0f, 10.5f);
        pathBuilder3.curveTo(8.0f, 11.92f, 8.4f, 13.27f, 9.13f, 14.45f);
        pathBuilder3.close();
        m4051addPathoIyEayM = builder.m4051addPathoIyEayM(pathBuilder3.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType3, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor3, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3769getButtKaPHkGw3, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3779getBevelLxFBmk83, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        ImageVector build = m4051addPathoIyEayM.build();
        _tsunami = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}

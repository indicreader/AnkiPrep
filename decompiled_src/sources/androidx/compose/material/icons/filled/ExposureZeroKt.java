package androidx.compose.material.icons.filled;

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

/* compiled from: ExposureZero.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_exposureZero", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ExposureZero", "Landroidx/compose/material/icons/Icons$Filled;", "getExposureZero", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ExposureZeroKt {
    private static ImageVector _exposureZero;

    public static final ImageVector getExposureZero(Icons.Filled filled) {
        ImageVector.Builder m4051addPathoIyEayM;
        ImageVector imageVector = _exposureZero;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.ExposureZero", Dp.m5738constructorimpl(24.0f), Dp.m5738constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m3443getBlack0d7_KjU(), null);
        int m3769getButtKaPHkGw = StrokeCap.INSTANCE.m3769getButtKaPHkGw();
        int m3779getBevelLxFBmk8 = StrokeJoin.INSTANCE.m3779getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(16.14f, 12.5f);
        pathBuilder.curveToRelative(0.0f, 1.0f, -0.1f, 1.85f, -0.3f, 2.55f);
        pathBuilder.curveToRelative(-0.2f, 0.7f, -0.48f, 1.27f, -0.83f, 1.7f);
        pathBuilder.curveToRelative(-0.36f, 0.44f, -0.79f, 0.75f, -1.3f, 0.95f);
        pathBuilder.curveToRelative(-0.51f, 0.2f, -1.07f, 0.3f, -1.7f, 0.3f);
        pathBuilder.curveToRelative(-0.62f, 0.0f, -1.18f, -0.1f, -1.69f, -0.3f);
        pathBuilder.curveToRelative(-0.51f, -0.2f, -0.95f, -0.51f, -1.31f, -0.95f);
        pathBuilder.curveToRelative(-0.36f, -0.44f, -0.65f, -1.01f, -0.85f, -1.7f);
        pathBuilder.curveToRelative(-0.2f, -0.7f, -0.3f, -1.55f, -0.3f, -2.55f);
        pathBuilder.verticalLineToRelative(-2.04f);
        pathBuilder.curveToRelative(0.0f, -1.0f, 0.1f, -1.85f, 0.3f, -2.55f);
        pathBuilder.curveToRelative(0.2f, -0.7f, 0.48f, -1.26f, 0.84f, -1.69f);
        pathBuilder.curveToRelative(0.36f, -0.43f, 0.8f, -0.74f, 1.31f, -0.93f);
        pathBuilder.curveTo(10.81f, 5.1f, 11.38f, 5.0f, 12.0f, 5.0f);
        pathBuilder.curveToRelative(0.63f, 0.0f, 1.19f, 0.1f, 1.7f, 0.29f);
        pathBuilder.curveToRelative(0.51f, 0.19f, 0.95f, 0.5f, 1.31f, 0.93f);
        pathBuilder.curveToRelative(0.36f, 0.43f, 0.64f, 0.99f, 0.84f, 1.69f);
        pathBuilder.curveToRelative(0.2f, 0.7f, 0.3f, 1.54f, 0.3f, 2.55f);
        pathBuilder.verticalLineToRelative(2.04f);
        pathBuilder.close();
        pathBuilder.moveTo(14.03f, 10.14f);
        pathBuilder.curveToRelative(0.0f, -0.64f, -0.05f, -1.18f, -0.13f, -1.62f);
        pathBuilder.curveToRelative(-0.09f, -0.44f, -0.22f, -0.79f, -0.4f, -1.06f);
        pathBuilder.curveToRelative(-0.17f, -0.27f, -0.39f, -0.46f, -0.64f, -0.58f);
        pathBuilder.curveToRelative(-0.25f, -0.13f, -0.54f, -0.19f, -0.86f, -0.19f);
        pathBuilder.curveToRelative(-0.32f, 0.0f, -0.61f, 0.06f, -0.86f, 0.18f);
        pathBuilder.reflectiveCurveToRelative(-0.47f, 0.31f, -0.64f, 0.58f);
        pathBuilder.curveToRelative(-0.17f, 0.27f, -0.31f, 0.62f, -0.4f, 1.06f);
        pathBuilder.reflectiveCurveToRelative(-0.13f, 0.98f, -0.13f, 1.62f);
        pathBuilder.verticalLineToRelative(2.67f);
        pathBuilder.curveToRelative(0.0f, 0.64f, 0.05f, 1.18f, 0.14f, 1.62f);
        pathBuilder.curveToRelative(0.09f, 0.45f, 0.23f, 0.81f, 0.4f, 1.09f);
        pathBuilder.reflectiveCurveToRelative(0.39f, 0.48f, 0.64f, 0.61f);
        pathBuilder.reflectiveCurveToRelative(0.54f, 0.19f, 0.87f, 0.19f);
        pathBuilder.curveToRelative(0.33f, 0.0f, 0.62f, -0.06f, 0.87f, -0.19f);
        pathBuilder.reflectiveCurveToRelative(0.46f, -0.33f, 0.63f, -0.61f);
        pathBuilder.curveToRelative(0.17f, -0.28f, 0.3f, -0.64f, 0.39f, -1.09f);
        pathBuilder.curveToRelative(0.09f, -0.45f, 0.13f, -0.99f, 0.13f, -1.62f);
        pathBuilder.verticalLineToRelative(-2.66f);
        pathBuilder.close();
        m4051addPathoIyEayM = builder.m4051addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3769getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3779getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        ImageVector build = m4051addPathoIyEayM.build();
        _exposureZero = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}

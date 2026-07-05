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

/* compiled from: Attractions.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_attractions", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Attractions", "Landroidx/compose/material/icons/Icons$Rounded;", "getAttractions", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AttractionsKt {
    private static ImageVector _attractions;

    public static final ImageVector getAttractions(Icons.Rounded rounded) {
        ImageVector.Builder m4051addPathoIyEayM;
        ImageVector imageVector = _attractions;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.Attractions", Dp.m5738constructorimpl(24.0f), Dp.m5738constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m3443getBlack0d7_KjU(), null);
        int m3769getButtKaPHkGw = StrokeCap.INSTANCE.m3769getButtKaPHkGw();
        int m3779getBevelLxFBmk8 = StrokeJoin.INSTANCE.m3779getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(10.44f, 18.75f);
        pathBuilder.curveToRelative(0.37f, -0.46f, 0.94f, -0.75f, 1.57f, -0.75f);
        pathBuilder.reflectiveCurveToRelative(1.19f, 0.29f, 1.56f, 0.75f);
        pathBuilder.curveToRelative(0.39f, -0.09f, 0.76f, -0.21f, 1.12f, -0.36f);
        pathBuilder.lineToRelative(-1.42f, -3.18f);
        pathBuilder.curveToRelative(-0.39f, 0.15f, -0.82f, 0.23f, -1.26f, 0.23f);
        pathBuilder.curveToRelative(-0.46f, 0.0f, -0.9f, -0.09f, -1.3f, -0.25f);
        pathBuilder.lineToRelative(-1.43f, 3.19f);
        pathBuilder.curveTo(9.65f, 18.54f, 10.03f, 18.67f, 10.44f, 18.75f);
        pathBuilder.close();
        pathBuilder.moveTo(5.16f, 10.0f);
        pathBuilder.curveTo(5.0f, 10.59f, 4.91f, 11.21f, 4.91f, 11.85f);
        pathBuilder.curveToRelative(0.0f, 0.75f, 0.12f, 1.47f, 0.33f, 2.15f);
        pathBuilder.curveToRelative(0.63f, 0.05f, 1.22f, 0.4f, 1.56f, 0.99f);
        pathBuilder.curveToRelative(0.33f, 0.57f, 0.35f, 1.23f, 0.11f, 1.79f);
        pathBuilder.curveToRelative(0.27f, 0.27f, 0.56f, 0.53f, 0.87f, 0.76f);
        pathBuilder.lineToRelative(1.52f, -3.39f);
        pathBuilder.lineToRelative(0.0f, 0.0f);
        pathBuilder.curveToRelative(-0.47f, -0.58f, -0.75f, -1.32f, -0.75f, -2.13f);
        pathBuilder.curveToRelative(0.0f, -1.89f, 1.55f, -3.41f, 3.46f, -3.41f);
        pathBuilder.reflectiveCurveToRelative(3.46f, 1.53f, 3.46f, 3.41f);
        pathBuilder.curveToRelative(0.0f, 0.82f, -0.29f, 1.57f, -0.78f, 2.16f);
        pathBuilder.lineToRelative(1.5f, 3.35f);
        pathBuilder.curveToRelative(0.32f, -0.24f, 0.62f, -0.5f, 0.9f, -0.79f);
        pathBuilder.curveToRelative(-0.22f, -0.55f, -0.2f, -1.2f, 0.12f, -1.75f);
        pathBuilder.curveToRelative(0.33f, -0.57f, 0.9f, -0.92f, 1.52f, -0.99f);
        pathBuilder.curveToRelative(0.22f, -0.68f, 0.34f, -1.41f, 0.34f, -2.16f);
        pathBuilder.curveToRelative(0.0f, -0.64f, -0.09f, -1.27f, -0.25f, -1.86f);
        pathBuilder.curveToRelative(-0.64f, -0.04f, -1.26f, -0.39f, -1.6f, -1.0f);
        pathBuilder.curveToRelative(-0.36f, -0.62f, -0.35f, -1.36f, -0.03f, -1.95f);
        pathBuilder.curveToRelative(-0.91f, -0.98f, -2.1f, -1.71f, -3.44f, -2.05f);
        pathBuilder.curveTo(13.4f, 5.6f, 12.74f, 6.0f, 12.01f, 6.0f);
        pathBuilder.reflectiveCurveToRelative(-1.39f, -0.41f, -1.74f, -1.01f);
        pathBuilder.curveTo(8.93f, 5.33f, 7.74f, 6.04f, 6.83f, 7.02f);
        pathBuilder.curveTo(7.16f, 7.62f, 7.18f, 8.37f, 6.81f, 9.0f);
        pathBuilder.curveTo(6.45f, 9.62f, 5.82f, 9.97f, 5.16f, 10.0f);
        pathBuilder.close();
        pathBuilder.moveTo(3.86f, 9.58f);
        pathBuilder.curveTo(3.08f, 8.98f, 2.84f, 7.88f, 3.35f, 7.0f);
        pathBuilder.reflectiveCurveToRelative(1.58f, -1.23f, 2.49f, -0.85f);
        pathBuilder.curveToRelative(1.11f, -1.17f, 2.56f, -2.03f, 4.18f, -2.42f);
        pathBuilder.curveTo(10.15f, 2.75f, 10.99f, 2.0f, 12.01f, 2.0f);
        pathBuilder.reflectiveCurveToRelative(1.85f, 0.75f, 1.98f, 1.73f);
        pathBuilder.curveToRelative(1.63f, 0.39f, 3.07f, 1.24f, 4.18f, 2.42f);
        pathBuilder.curveToRelative(0.91f, -0.38f, 1.99f, -0.03f, 2.49f, 0.85f);
        pathBuilder.curveToRelative(0.51f, 0.88f, 0.27f, 1.98f, -0.51f, 2.58f);
        pathBuilder.curveToRelative(0.23f, 0.77f, 0.35f, 1.58f, 0.35f, 2.42f);
        pathBuilder.reflectiveCurveToRelative(-0.12f, 1.65f, -0.35f, 2.42f);
        pathBuilder.curveToRelative(0.78f, 0.6f, 1.02f, 1.7f, 0.51f, 2.58f);
        pathBuilder.reflectiveCurveToRelative(-1.58f, 1.23f, -2.49f, 0.85f);
        pathBuilder.curveToRelative(-0.4f, 0.43f, -0.85f, 0.81f, -1.34f, 1.15f);
        pathBuilder.lineToRelative(0.81f, 1.8f);
        pathBuilder.curveToRelative(0.25f, 0.56f, -0.16f, 1.2f, -0.78f, 1.2f);
        pathBuilder.horizontalLineToRelative(0.0f);
        pathBuilder.curveToRelative(-0.33f, 0.0f, -0.64f, -0.2f, -0.78f, -0.5f);
        pathBuilder.lineToRelative(-0.75f, -1.67f);
        pathBuilder.curveToRelative(-0.43f, 0.18f, -0.88f, 0.33f, -1.34f, 0.44f);
        pathBuilder.curveTo(13.86f, 21.25f, 13.02f, 22.0f, 12.01f, 22.0f);
        pathBuilder.reflectiveCurveToRelative(-1.85f, -0.75f, -1.98f, -1.73f);
        pathBuilder.curveTo(9.55f, 20.15f, 9.09f, 20.0f, 8.65f, 19.81f);
        pathBuilder.lineTo(7.89f, 21.5f);
        pathBuilder.curveTo(7.75f, 21.8f, 7.45f, 22.0f, 7.11f, 22.0f);
        pathBuilder.horizontalLineTo(7.1f);
        pathBuilder.curveToRelative(-0.62f, 0.0f, -1.03f, -0.64f, -0.77f, -1.2f);
        pathBuilder.lineToRelative(0.82f, -1.83f);
        pathBuilder.curveToRelative(-0.47f, -0.33f, -0.91f, -0.71f, -1.3f, -1.12f);
        pathBuilder.curveToRelative(-0.92f, 0.38f, -1.99f, 0.03f, -2.5f, -0.85f);
        pathBuilder.reflectiveCurveToRelative(-0.27f, -1.98f, 0.51f, -2.58f);
        pathBuilder.curveTo(3.62f, 13.65f, 3.51f, 12.84f, 3.51f, 12.0f);
        pathBuilder.reflectiveCurveTo(3.62f, 10.35f, 3.86f, 9.58f);
        pathBuilder.close();
        m4051addPathoIyEayM = builder.m4051addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3769getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3779getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        ImageVector build = m4051addPathoIyEayM.build();
        _attractions = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}

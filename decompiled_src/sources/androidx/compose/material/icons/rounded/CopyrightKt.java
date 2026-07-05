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
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Copyright.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_copyright", "Landroidx/compose/ui/graphics/vector/ImageVector;", ExifInterface.TAG_COPYRIGHT, "Landroidx/compose/material/icons/Icons$Rounded;", "getCopyright", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CopyrightKt {
    private static ImageVector _copyright;

    public static final ImageVector getCopyright(Icons.Rounded rounded) {
        ImageVector.Builder m4051addPathoIyEayM;
        ImageVector imageVector = _copyright;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.Copyright", Dp.m5738constructorimpl(24.0f), Dp.m5738constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m3443getBlack0d7_KjU(), null);
        int m3769getButtKaPHkGw = StrokeCap.INSTANCE.m3769getButtKaPHkGw();
        int m3779getBevelLxFBmk8 = StrokeJoin.INSTANCE.m3779getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(10.08f, 10.86f);
        pathBuilder.curveToRelative(0.05f, -0.33f, 0.16f, -0.62f, 0.3f, -0.87f);
        pathBuilder.reflectiveCurveToRelative(0.34f, -0.46f, 0.59f, -0.62f);
        pathBuilder.curveToRelative(0.24f, -0.15f, 0.54f, -0.22f, 0.91f, -0.23f);
        pathBuilder.curveToRelative(0.23f, 0.01f, 0.44f, 0.05f, 0.63f, 0.13f);
        pathBuilder.curveToRelative(0.2f, 0.09f, 0.38f, 0.21f, 0.52f, 0.36f);
        pathBuilder.reflectiveCurveToRelative(0.25f, 0.33f, 0.34f, 0.53f);
        pathBuilder.reflectiveCurveToRelative(0.13f, 0.42f, 0.14f, 0.64f);
        pathBuilder.horizontalLineToRelative(1.79f);
        pathBuilder.curveToRelative(-0.02f, -0.47f, -0.11f, -0.9f, -0.28f, -1.29f);
        pathBuilder.reflectiveCurveToRelative(-0.4f, -0.73f, -0.7f, -1.01f);
        pathBuilder.reflectiveCurveToRelative(-0.66f, -0.5f, -1.08f, -0.66f);
        pathBuilder.reflectiveCurveToRelative(-0.88f, -0.23f, -1.39f, -0.23f);
        pathBuilder.curveToRelative(-0.65f, 0.0f, -1.22f, 0.11f, -1.7f, 0.34f);
        pathBuilder.reflectiveCurveToRelative(-0.88f, 0.53f, -1.2f, 0.92f);
        pathBuilder.reflectiveCurveToRelative(-0.56f, 0.84f, -0.71f, 1.36f);
        pathBuilder.reflectiveCurveTo(8.0f, 11.29f, 8.0f, 11.87f);
        pathBuilder.verticalLineToRelative(0.27f);
        pathBuilder.curveToRelative(0.0f, 0.58f, 0.08f, 1.12f, 0.23f, 1.64f);
        pathBuilder.reflectiveCurveToRelative(0.39f, 0.97f, 0.71f, 1.35f);
        pathBuilder.reflectiveCurveToRelative(0.72f, 0.69f, 1.2f, 0.91f);
        pathBuilder.curveToRelative(0.48f, 0.22f, 1.05f, 0.34f, 1.7f, 0.34f);
        pathBuilder.curveToRelative(0.47f, 0.0f, 0.91f, -0.08f, 1.32f, -0.23f);
        pathBuilder.reflectiveCurveToRelative(0.77f, -0.36f, 1.08f, -0.63f);
        pathBuilder.reflectiveCurveToRelative(0.56f, -0.58f, 0.74f, -0.94f);
        pathBuilder.reflectiveCurveToRelative(0.29f, -0.74f, 0.3f, -1.15f);
        pathBuilder.horizontalLineToRelative(-1.79f);
        pathBuilder.curveToRelative(-0.01f, 0.21f, -0.06f, 0.4f, -0.15f, 0.58f);
        pathBuilder.reflectiveCurveToRelative(-0.21f, 0.33f, -0.36f, 0.46f);
        pathBuilder.reflectiveCurveToRelative(-0.32f, 0.23f, -0.52f, 0.3f);
        pathBuilder.curveToRelative(-0.19f, 0.07f, -0.39f, 0.09f, -0.6f, 0.1f);
        pathBuilder.curveToRelative(-0.36f, -0.01f, -0.66f, -0.08f, -0.89f, -0.23f);
        pathBuilder.curveToRelative(-0.25f, -0.16f, -0.45f, -0.37f, -0.59f, -0.62f);
        pathBuilder.reflectiveCurveToRelative(-0.25f, -0.55f, -0.3f, -0.88f);
        pathBuilder.reflectiveCurveToRelative(-0.08f, -0.67f, -0.08f, -1.0f);
        pathBuilder.verticalLineToRelative(-0.27f);
        pathBuilder.curveToRelative(0.0f, -0.35f, 0.03f, -0.68f, 0.08f, -1.01f);
        pathBuilder.close();
        pathBuilder.moveTo(12.0f, 2.0f);
        pathBuilder.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        pathBuilder.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
        pathBuilder.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
        pathBuilder.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
        pathBuilder.close();
        pathBuilder.moveTo(12.0f, 20.0f);
        pathBuilder.curveToRelative(-4.41f, 0.0f, -8.0f, -3.59f, -8.0f, -8.0f);
        pathBuilder.reflectiveCurveToRelative(3.59f, -8.0f, 8.0f, -8.0f);
        pathBuilder.reflectiveCurveToRelative(8.0f, 3.59f, 8.0f, 8.0f);
        pathBuilder.reflectiveCurveToRelative(-3.59f, 8.0f, -8.0f, 8.0f);
        pathBuilder.close();
        m4051addPathoIyEayM = builder.m4051addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3769getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3779getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        ImageVector build = m4051addPathoIyEayM.build();
        _copyright = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}

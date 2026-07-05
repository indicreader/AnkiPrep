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

/* compiled from: MotionPhotosOn.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_motionPhotosOn", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MotionPhotosOn", "Landroidx/compose/material/icons/Icons$Rounded;", "getMotionPhotosOn", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MotionPhotosOnKt {
    private static ImageVector _motionPhotosOn;

    public static final ImageVector getMotionPhotosOn(Icons.Rounded rounded) {
        ImageVector.Builder m4051addPathoIyEayM;
        ImageVector imageVector = _motionPhotosOn;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.MotionPhotosOn", Dp.m5738constructorimpl(24.0f), Dp.m5738constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m3443getBlack0d7_KjU(), null);
        int m3769getButtKaPHkGw = StrokeCap.INSTANCE.m3769getButtKaPHkGw();
        int m3779getBevelLxFBmk8 = StrokeJoin.INSTANCE.m3779getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(4.0f, 9.0f);
        pathBuilder.lineTo(4.0f, 9.0f);
        pathBuilder.curveToRelative(0.26f, 0.26f, 0.34f, 0.63f, 0.25f, 0.98f);
        pathBuilder.curveToRelative(-0.35f, 1.36f, -0.36f, 2.87f, 0.1f, 4.38f);
        pathBuilder.curveToRelative(0.88f, 2.91f, 3.44f, 5.1f, 6.44f, 5.55f);
        pathBuilder.curveToRelative(5.52f, 0.81f, 10.19f, -4.06f, 9.03f, -9.62f);
        pathBuilder.curveToRelative(-0.65f, -3.13f, -3.23f, -5.61f, -6.37f, -6.16f);
        pathBuilder.curveToRelative(-1.21f, -0.21f, -2.38f, -0.15f, -3.46f, 0.13f);
        pathBuilder.curveTo(9.64f, 4.35f, 9.26f, 4.26f, 9.01f, 4.01f);
        pathBuilder.lineToRelative(0.0f, 0.0f);
        pathBuilder.curveTo(8.45f, 3.45f, 8.73f, 2.52f, 9.48f, 2.32f);
        pathBuilder.curveToRelative(1.47f, -0.38f, 3.06f, -0.44f, 4.7f, -0.09f);
        pathBuilder.curveToRelative(3.98f, 0.86f, 7.09f, 4.18f, 7.7f, 8.2f);
        pathBuilder.curveToRelative(1.04f, 6.81f, -4.82f, 12.58f, -11.64f, 11.42f);
        pathBuilder.curveTo(6.23f, 21.16f, 2.98f, 17.99f, 2.2f, 14.0f);
        pathBuilder.curveToRelative(-0.31f, -1.59f, -0.24f, -3.12f, 0.12f, -4.53f);
        pathBuilder.curveTo(2.52f, 8.72f, 3.45f, 8.45f, 4.0f, 9.0f);
        pathBuilder.close();
        pathBuilder.moveTo(6.0f, 12.0f);
        pathBuilder.curveToRelative(0.0f, -3.31f, 2.69f, -6.0f, 6.0f, -6.0f);
        pathBuilder.reflectiveCurveToRelative(6.0f, 2.69f, 6.0f, 6.0f);
        pathBuilder.reflectiveCurveToRelative(-2.69f, 6.0f, -6.0f, 6.0f);
        pathBuilder.reflectiveCurveTo(6.0f, 15.31f, 6.0f, 12.0f);
        pathBuilder.close();
        pathBuilder.moveTo(7.0f, 5.5f);
        pathBuilder.curveTo(7.0f, 6.33f, 6.33f, 7.0f, 5.5f, 7.0f);
        pathBuilder.reflectiveCurveTo(4.0f, 6.33f, 4.0f, 5.5f);
        pathBuilder.reflectiveCurveTo(4.67f, 4.0f, 5.5f, 4.0f);
        pathBuilder.reflectiveCurveTo(7.0f, 4.67f, 7.0f, 5.5f);
        pathBuilder.close();
        m4051addPathoIyEayM = builder.m4051addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3769getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3779getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        ImageVector build = m4051addPathoIyEayM.build();
        _motionPhotosOn = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}

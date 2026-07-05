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

/* compiled from: Camera.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_camera", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Camera", "Landroidx/compose/material/icons/Icons$Rounded;", "getCamera", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CameraKt {
    private static ImageVector _camera;

    public static final ImageVector getCamera(Icons.Rounded rounded) {
        ImageVector.Builder m4051addPathoIyEayM;
        ImageVector imageVector = _camera;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.Camera", Dp.m5738constructorimpl(24.0f), Dp.m5738constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m3443getBlack0d7_KjU(), null);
        int m3769getButtKaPHkGw = StrokeCap.INSTANCE.m3769getButtKaPHkGw();
        int m3779getBevelLxFBmk8 = StrokeJoin.INSTANCE.m3779getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(13.81f, 2.86f);
        pathBuilder.curveToRelative(0.17f, -0.3f, 0.0f, -0.7f, -0.35f, -0.74f);
        pathBuilder.curveToRelative(-2.62f, -0.37f, -5.3f, 0.28f, -7.44f, 1.86f);
        pathBuilder.curveToRelative(-0.19f, 0.15f, -0.25f, 0.43f, -0.12f, 0.65f);
        pathBuilder.lineToRelative(3.01f, 5.22f);
        pathBuilder.curveToRelative(0.19f, 0.33f, 0.67f, 0.33f, 0.87f, 0.0f);
        pathBuilder.lineToRelative(4.03f, -6.99f);
        pathBuilder.close();
        pathBuilder.moveTo(21.3f, 8.33f);
        pathBuilder.curveToRelative(-0.98f, -2.47f, -2.92f, -4.46f, -5.35f, -5.5f);
        pathBuilder.curveToRelative(-0.23f, -0.1f, -0.5f, 0.0f, -0.63f, 0.22f);
        pathBuilder.lineToRelative(-3.01f, 5.21f);
        pathBuilder.curveToRelative(-0.19f, 0.32f, 0.05f, 0.74f, 0.44f, 0.74f);
        pathBuilder.horizontalLineToRelative(8.08f);
        pathBuilder.curveToRelative(0.35f, 0.0f, 0.6f, -0.35f, 0.47f, -0.67f);
        pathBuilder.close();
        pathBuilder.moveTo(21.37f, 10.0f);
        pathBuilder.horizontalLineToRelative(-6.2f);
        pathBuilder.curveToRelative(-0.38f, 0.0f, -0.63f, 0.42f, -0.43f, 0.75f);
        pathBuilder.lineTo(19.0f, 18.14f);
        pathBuilder.curveToRelative(0.17f, 0.3f, 0.6f, 0.35f, 0.82f, 0.08f);
        pathBuilder.curveToRelative(1.74f, -2.18f, 2.48f, -5.03f, 2.05f, -7.79f);
        pathBuilder.curveToRelative(-0.03f, -0.25f, -0.25f, -0.43f, -0.5f, -0.43f);
        pathBuilder.close();
        pathBuilder.moveTo(4.18f, 5.79f);
        pathBuilder.curveToRelative(-1.73f, 2.19f, -2.48f, 5.02f, -2.05f, 7.79f);
        pathBuilder.curveToRelative(0.03f, 0.24f, 0.25f, 0.42f, 0.5f, 0.42f);
        pathBuilder.horizontalLineToRelative(6.2f);
        pathBuilder.curveToRelative(0.38f, 0.0f, 0.63f, -0.42f, 0.43f, -0.75f);
        pathBuilder.lineTo(5.0f, 5.87f);
        pathBuilder.curveToRelative(-0.18f, -0.3f, -0.61f, -0.35f, -0.82f, -0.08f);
        pathBuilder.close();
        pathBuilder.moveTo(2.7f, 15.67f);
        pathBuilder.curveToRelative(0.98f, 2.47f, 2.92f, 4.46f, 5.35f, 5.5f);
        pathBuilder.curveToRelative(0.23f, 0.1f, 0.5f, 0.0f, 0.63f, -0.22f);
        pathBuilder.lineToRelative(3.01f, -5.21f);
        pathBuilder.curveToRelative(0.19f, -0.33f, -0.05f, -0.75f, -0.43f, -0.75f);
        pathBuilder.lineTo(3.17f, 14.99f);
        pathBuilder.curveToRelative(-0.35f, 0.01f, -0.6f, 0.36f, -0.47f, 0.68f);
        pathBuilder.close();
        pathBuilder.moveTo(10.53f, 21.89f);
        pathBuilder.curveToRelative(2.62f, 0.37f, 5.3f, -0.28f, 7.44f, -1.86f);
        pathBuilder.curveToRelative(0.2f, -0.15f, 0.26f, -0.44f, 0.13f, -0.66f);
        pathBuilder.lineToRelative(-3.01f, -5.22f);
        pathBuilder.curveToRelative(-0.19f, -0.33f, -0.67f, -0.33f, -0.87f, 0.0f);
        pathBuilder.lineToRelative(-4.04f, 6.99f);
        pathBuilder.curveToRelative(-0.17f, 0.3f, 0.01f, 0.7f, 0.35f, 0.75f);
        pathBuilder.close();
        m4051addPathoIyEayM = builder.m4051addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3769getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3779getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        ImageVector build = m4051addPathoIyEayM.build();
        _camera = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}

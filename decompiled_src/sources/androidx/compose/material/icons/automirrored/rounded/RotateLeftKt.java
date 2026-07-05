package androidx.compose.material.icons.automirrored.rounded;

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

/* compiled from: RotateLeft.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_rotateLeft", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RotateLeft", "Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;", "getRotateLeft", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RotateLeftKt {
    private static ImageVector _rotateLeft;

    public static final ImageVector getRotateLeft(Icons.AutoMirrored.Rounded rounded) {
        ImageVector.Builder m4051addPathoIyEayM;
        ImageVector imageVector = _rotateLeft;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("AutoMirrored.Rounded.RotateLeft", Dp.m5738constructorimpl(24.0f), Dp.m5738constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, true, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m3443getBlack0d7_KjU(), null);
        int m3769getButtKaPHkGw = StrokeCap.INSTANCE.m3769getButtKaPHkGw();
        int m3779getBevelLxFBmk8 = StrokeJoin.INSTANCE.m3779getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(6.56f, 7.98f);
        pathBuilder.curveTo(6.1f, 7.52f, 5.31f, 7.6f, 5.0f, 8.17f);
        pathBuilder.curveToRelative(-0.28f, 0.51f, -0.5f, 1.03f, -0.67f, 1.58f);
        pathBuilder.curveToRelative(-0.19f, 0.63f, 0.31f, 1.25f, 0.96f, 1.25f);
        pathBuilder.horizontalLineToRelative(0.01f);
        pathBuilder.curveToRelative(0.43f, 0.0f, 0.82f, -0.28f, 0.94f, -0.7f);
        pathBuilder.curveToRelative(0.12f, -0.4f, 0.28f, -0.79f, 0.48f, -1.17f);
        pathBuilder.curveToRelative(0.22f, -0.37f, 0.15f, -0.84f, -0.16f, -1.15f);
        pathBuilder.close();
        pathBuilder.moveTo(5.31f, 13.0f);
        pathBuilder.horizontalLineToRelative(-0.02f);
        pathBuilder.curveToRelative(-0.65f, 0.0f, -1.15f, 0.62f, -0.96f, 1.25f);
        pathBuilder.curveToRelative(0.16f, 0.54f, 0.38f, 1.07f, 0.66f, 1.58f);
        pathBuilder.curveToRelative(0.31f, 0.57f, 1.11f, 0.66f, 1.57f, 0.2f);
        pathBuilder.curveToRelative(0.3f, -0.31f, 0.38f, -0.77f, 0.17f, -1.15f);
        pathBuilder.curveToRelative(-0.2f, -0.37f, -0.36f, -0.76f, -0.48f, -1.16f);
        pathBuilder.curveToRelative(-0.12f, -0.44f, -0.51f, -0.72f, -0.94f, -0.72f);
        pathBuilder.close();
        pathBuilder.moveTo(8.16f, 19.02f);
        pathBuilder.curveToRelative(0.51f, 0.28f, 1.04f, 0.5f, 1.59f, 0.66f);
        pathBuilder.curveToRelative(0.62f, 0.18f, 1.24f, -0.32f, 1.24f, -0.96f);
        pathBuilder.verticalLineToRelative(-0.03f);
        pathBuilder.curveToRelative(0.0f, -0.43f, -0.28f, -0.82f, -0.7f, -0.94f);
        pathBuilder.curveToRelative(-0.4f, -0.12f, -0.78f, -0.28f, -1.15f, -0.48f);
        pathBuilder.curveToRelative(-0.38f, -0.21f, -0.86f, -0.14f, -1.16f, 0.17f);
        pathBuilder.lineToRelative(-0.03f, 0.03f);
        pathBuilder.curveToRelative(-0.45f, 0.45f, -0.36f, 1.24f, 0.21f, 1.55f);
        pathBuilder.close();
        pathBuilder.moveTo(13.0f, 4.07f);
        pathBuilder.verticalLineToRelative(-0.66f);
        pathBuilder.curveToRelative(0.0f, -0.89f, -1.08f, -1.34f, -1.71f, -0.71f);
        pathBuilder.lineTo(9.17f, 4.83f);
        pathBuilder.curveToRelative(-0.4f, 0.4f, -0.4f, 1.04f, 0.0f, 1.43f);
        pathBuilder.lineToRelative(2.13f, 2.08f);
        pathBuilder.curveToRelative(0.63f, 0.62f, 1.7f, 0.17f, 1.7f, -0.72f);
        pathBuilder.lineTo(13.0f, 6.09f);
        pathBuilder.curveToRelative(2.84f, 0.48f, 5.0f, 2.94f, 5.0f, 5.91f);
        pathBuilder.curveToRelative(0.0f, 2.73f, -1.82f, 5.02f, -4.32f, 5.75f);
        pathBuilder.curveToRelative(-0.41f, 0.12f, -0.68f, 0.51f, -0.68f, 0.94f);
        pathBuilder.verticalLineToRelative(0.02f);
        pathBuilder.curveToRelative(0.0f, 0.65f, 0.61f, 1.14f, 1.23f, 0.96f);
        pathBuilder.curveTo(17.57f, 18.71f, 20.0f, 15.64f, 20.0f, 12.0f);
        pathBuilder.curveToRelative(0.0f, -4.08f, -3.05f, -7.44f, -7.0f, -7.93f);
        pathBuilder.close();
        m4051addPathoIyEayM = builder.m4051addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3769getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3779getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        ImageVector build = m4051addPathoIyEayM.build();
        _rotateLeft = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}

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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AltRoute.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"_altRoute", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AltRoute", "Landroidx/compose/material/icons/Icons$Rounded;", "getAltRoute$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getAltRoute", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AltRouteKt {
    private static ImageVector _altRoute;

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Rounded.AltRoute", replaceWith = @ReplaceWith(expression = "Icons.AutoMirrored.Rounded.AltRoute", imports = {"androidx.compose.material.icons.automirrored.rounded.AltRoute"}))
    public static /* synthetic */ void getAltRoute$annotations(Icons.Rounded rounded) {
    }

    public static final ImageVector getAltRoute(Icons.Rounded rounded) {
        ImageVector.Builder m4051addPathoIyEayM;
        ImageVector imageVector = _altRoute;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.AltRoute", Dp.m5738constructorimpl(24.0f), Dp.m5738constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m3443getBlack0d7_KjU(), null);
        int m3769getButtKaPHkGw = StrokeCap.INSTANCE.m3769getButtKaPHkGw();
        int m3779getBevelLxFBmk8 = StrokeJoin.INSTANCE.m3779getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(9.78f, 11.16f);
        pathBuilder.lineToRelative(-1.42f, 1.42f);
        pathBuilder.curveToRelative(-0.68f, -0.69f, -1.34f, -1.58f, -1.79f, -2.94f);
        pathBuilder.lineToRelative(1.94f, -0.49f);
        pathBuilder.curveTo(8.83f, 10.04f, 9.28f, 10.65f, 9.78f, 11.16f);
        pathBuilder.close();
        pathBuilder.moveTo(10.15f, 5.15f);
        pathBuilder.lineTo(7.35f, 2.35f);
        pathBuilder.curveToRelative(-0.2f, -0.2f, -0.51f, -0.2f, -0.71f, 0.0f);
        pathBuilder.lineTo(3.85f, 5.15f);
        pathBuilder.curveTo(3.54f, 5.46f, 3.76f, 6.0f, 4.21f, 6.0f);
        pathBuilder.horizontalLineToRelative(1.81f);
        pathBuilder.curveTo(6.04f, 6.81f, 6.1f, 7.54f, 6.21f, 8.17f);
        pathBuilder.lineToRelative(1.94f, -0.49f);
        pathBuilder.curveTo(8.08f, 7.2f, 8.03f, 6.63f, 8.02f, 6.0f);
        pathBuilder.horizontalLineToRelative(1.78f);
        pathBuilder.curveTo(10.24f, 6.0f, 10.46f, 5.46f, 10.15f, 5.15f);
        pathBuilder.close();
        pathBuilder.moveTo(20.15f, 5.15f);
        pathBuilder.lineToRelative(-2.79f, -2.79f);
        pathBuilder.curveToRelative(-0.2f, -0.2f, -0.51f, -0.2f, -0.71f, 0.0f);
        pathBuilder.lineToRelative(-2.79f, 2.79f);
        pathBuilder.curveTo(13.54f, 5.46f, 13.76f, 6.0f, 14.21f, 6.0f);
        pathBuilder.horizontalLineToRelative(1.78f);
        pathBuilder.curveToRelative(-0.1f, 3.68f, -1.28f, 4.75f, -2.54f, 5.88f);
        pathBuilder.curveToRelative(-0.5f, 0.44f, -1.01f, 0.92f, -1.45f, 1.55f);
        pathBuilder.curveToRelative(-0.34f, -0.49f, -0.73f, -0.88f, -1.13f, -1.24f);
        pathBuilder.lineTo(9.46f, 13.6f);
        pathBuilder.curveTo(10.39f, 14.45f, 11.0f, 15.14f, 11.0f, 17.0f);
        pathBuilder.curveToRelative(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        pathBuilder.horizontalLineToRelative(0.0f);
        pathBuilder.verticalLineToRelative(4.0f);
        pathBuilder.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
        pathBuilder.horizontalLineToRelative(0.0f);
        pathBuilder.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
        pathBuilder.verticalLineToRelative(-4.0f);
        pathBuilder.curveToRelative(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        pathBuilder.curveToRelative(0.0f, -2.02f, 0.71f, -2.66f, 1.79f, -3.63f);
        pathBuilder.curveToRelative(1.38f, -1.24f, 3.08f, -2.78f, 3.2f, -7.37f);
        pathBuilder.horizontalLineToRelative(1.8f);
        pathBuilder.curveTo(20.24f, 6.0f, 20.46f, 5.46f, 20.15f, 5.15f);
        pathBuilder.close();
        m4051addPathoIyEayM = builder.m4051addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3769getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3779getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        ImageVector build = m4051addPathoIyEayM.build();
        _altRoute = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}

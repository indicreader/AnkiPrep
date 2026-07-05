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

/* compiled from: Fitbit.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_fitbit", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Fitbit", "Landroidx/compose/material/icons/Icons$Filled;", "getFitbit", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FitbitKt {
    private static ImageVector _fitbit;

    public static final ImageVector getFitbit(Icons.Filled filled) {
        ImageVector.Builder m4051addPathoIyEayM;
        ImageVector imageVector = _fitbit;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Fitbit", Dp.m5738constructorimpl(24.0f), Dp.m5738constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m3443getBlack0d7_KjU(), null);
        int m3769getButtKaPHkGw = StrokeCap.INSTANCE.m3769getButtKaPHkGw();
        int m3779getBevelLxFBmk8 = StrokeJoin.INSTANCE.m3779getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(19.89f, 13.89f);
        pathBuilder.curveToRelative(1.04f, 0.0f, 1.89f, -0.85f, 1.89f, -1.89f);
        pathBuilder.reflectiveCurveToRelative(-0.85f, -1.89f, -1.89f, -1.89f);
        pathBuilder.curveTo(18.85f, 10.11f, 18.0f, 10.96f, 18.0f, 12.0f);
        pathBuilder.reflectiveCurveTo(18.85f, 13.89f, 19.89f, 13.89f);
        pathBuilder.close();
        pathBuilder.moveTo(15.65f, 13.68f);
        pathBuilder.curveToRelative(0.93f, 0.0f, 1.68f, -0.75f, 1.68f, -1.68f);
        pathBuilder.reflectiveCurveToRelative(-0.75f, -1.68f, -1.68f, -1.68f);
        pathBuilder.curveToRelative(-0.93f, 0.0f, -1.68f, 0.75f, -1.68f, 1.68f);
        pathBuilder.reflectiveCurveTo(14.72f, 13.68f, 15.65f, 13.68f);
        pathBuilder.close();
        pathBuilder.moveTo(15.65f, 9.42f);
        pathBuilder.curveToRelative(0.93f, 0.0f, 1.68f, -0.75f, 1.68f, -1.68f);
        pathBuilder.curveToRelative(0.0f, -0.93f, -0.75f, -1.68f, -1.68f, -1.68f);
        pathBuilder.curveToRelative(-0.93f, 0.0f, -1.68f, 0.75f, -1.68f, 1.68f);
        pathBuilder.curveTo(13.97f, 8.67f, 14.72f, 9.42f, 15.65f, 9.42f);
        pathBuilder.close();
        pathBuilder.moveTo(15.65f, 17.93f);
        pathBuilder.curveToRelative(0.93f, 0.0f, 1.68f, -0.75f, 1.68f, -1.68f);
        pathBuilder.curveToRelative(0.0f, -0.93f, -0.75f, -1.68f, -1.68f, -1.68f);
        pathBuilder.curveToRelative(-0.93f, 0.0f, -1.68f, 0.75f, -1.68f, 1.68f);
        pathBuilder.curveTo(13.97f, 17.17f, 14.72f, 17.93f, 15.65f, 17.93f);
        pathBuilder.close();
        pathBuilder.moveTo(11.41f, 13.47f);
        pathBuilder.curveToRelative(0.81f, 0.0f, 1.47f, -0.66f, 1.47f, -1.47f);
        pathBuilder.reflectiveCurveToRelative(-0.66f, -1.47f, -1.47f, -1.47f);
        pathBuilder.curveToRelative(-0.81f, 0.0f, -1.47f, 0.66f, -1.47f, 1.47f);
        pathBuilder.reflectiveCurveTo(10.59f, 13.47f, 11.41f, 13.47f);
        pathBuilder.close();
        pathBuilder.moveTo(11.41f, 9.21f);
        pathBuilder.curveToRelative(0.81f, 0.0f, 1.47f, -0.66f, 1.47f, -1.47f);
        pathBuilder.reflectiveCurveToRelative(-0.66f, -1.47f, -1.47f, -1.47f);
        pathBuilder.curveToRelative(-0.81f, 0.0f, -1.47f, 0.66f, -1.47f, 1.47f);
        pathBuilder.reflectiveCurveTo(10.59f, 9.21f, 11.41f, 9.21f);
        pathBuilder.close();
        pathBuilder.moveTo(11.41f, 17.73f);
        pathBuilder.curveToRelative(0.81f, 0.0f, 1.47f, -0.66f, 1.47f, -1.47f);
        pathBuilder.curveToRelative(0.0f, -0.81f, -0.66f, -1.47f, -1.47f, -1.47f);
        pathBuilder.curveToRelative(-0.81f, 0.0f, -1.47f, 0.66f, -1.47f, 1.47f);
        pathBuilder.curveTo(9.93f, 17.07f, 10.59f, 17.73f, 11.41f, 17.73f);
        pathBuilder.close();
        pathBuilder.moveTo(11.41f, 22.0f);
        pathBuilder.curveToRelative(0.81f, 0.0f, 1.47f, -0.66f, 1.47f, -1.47f);
        pathBuilder.curveToRelative(0.0f, -0.81f, -0.66f, -1.47f, -1.47f, -1.47f);
        pathBuilder.curveToRelative(-0.81f, 0.0f, -1.47f, 0.66f, -1.47f, 1.47f);
        pathBuilder.curveTo(9.93f, 21.34f, 10.59f, 22.0f, 11.41f, 22.0f);
        pathBuilder.close();
        pathBuilder.moveTo(11.41f, 4.94f);
        pathBuilder.curveToRelative(0.81f, 0.0f, 1.47f, -0.66f, 1.47f, -1.47f);
        pathBuilder.reflectiveCurveTo(12.22f, 2.0f, 11.41f, 2.0f);
        pathBuilder.curveToRelative(-0.81f, 0.0f, -1.47f, 0.66f, -1.47f, 1.47f);
        pathBuilder.reflectiveCurveTo(10.59f, 4.94f, 11.41f, 4.94f);
        pathBuilder.close();
        pathBuilder.moveTo(7.16f, 13.26f);
        pathBuilder.curveToRelative(0.7f, 0.0f, 1.26f, -0.57f, 1.26f, -1.26f);
        pathBuilder.reflectiveCurveToRelative(-0.57f, -1.26f, -1.26f, -1.26f);
        pathBuilder.curveToRelative(-0.7f, 0.0f, -1.26f, 0.57f, -1.26f, 1.26f);
        pathBuilder.reflectiveCurveTo(6.46f, 13.26f, 7.16f, 13.26f);
        pathBuilder.close();
        pathBuilder.moveTo(7.16f, 17.51f);
        pathBuilder.curveToRelative(0.7f, 0.0f, 1.26f, -0.57f, 1.26f, -1.26f);
        pathBuilder.curveToRelative(0.0f, -0.7f, -0.57f, -1.26f, -1.26f, -1.26f);
        pathBuilder.curveToRelative(-0.7f, 0.0f, -1.26f, 0.57f, -1.26f, 1.26f);
        pathBuilder.curveTo(5.9f, 16.94f, 6.46f, 17.51f, 7.16f, 17.51f);
        pathBuilder.close();
        pathBuilder.moveTo(7.16f, 9.02f);
        pathBuilder.curveToRelative(0.7f, 0.0f, 1.26f, -0.57f, 1.26f, -1.26f);
        pathBuilder.curveToRelative(0.0f, -0.7f, -0.57f, -1.26f, -1.26f, -1.26f);
        pathBuilder.curveToRelative(-0.7f, 0.0f, -1.26f, 0.57f, -1.26f, 1.26f);
        pathBuilder.curveTo(5.9f, 8.45f, 6.46f, 9.02f, 7.16f, 9.02f);
        pathBuilder.close();
        pathBuilder.moveTo(3.29f, 13.05f);
        pathBuilder.curveToRelative(0.58f, 0.0f, 1.05f, -0.47f, 1.05f, -1.05f);
        pathBuilder.reflectiveCurveToRelative(-0.47f, -1.05f, -1.05f, -1.05f);
        pathBuilder.curveToRelative(-0.58f, 0.0f, -1.05f, 0.47f, -1.05f, 1.05f);
        pathBuilder.reflectiveCurveTo(2.71f, 13.05f, 3.29f, 13.05f);
        pathBuilder.close();
        m4051addPathoIyEayM = builder.m4051addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3769getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3779getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        ImageVector build = m4051addPathoIyEayM.build();
        _fitbit = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}

package androidx.compose.material.icons.sharp;

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

/* compiled from: SettingsSuggest.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_settingsSuggest", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SettingsSuggest", "Landroidx/compose/material/icons/Icons$Sharp;", "getSettingsSuggest", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SettingsSuggestKt {
    private static ImageVector _settingsSuggest;

    public static final ImageVector getSettingsSuggest(Icons.Sharp sharp) {
        ImageVector.Builder m4051addPathoIyEayM;
        ImageVector imageVector = _settingsSuggest;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Sharp.SettingsSuggest", Dp.m5738constructorimpl(24.0f), Dp.m5738constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m3443getBlack0d7_KjU(), null);
        int m3769getButtKaPHkGw = StrokeCap.INSTANCE.m3769getButtKaPHkGw();
        int m3779getBevelLxFBmk8 = StrokeJoin.INSTANCE.m3779getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(17.41f, 6.59f);
        pathBuilder.lineTo(15.0f, 5.5f);
        pathBuilder.lineToRelative(2.41f, -1.09f);
        pathBuilder.lineTo(18.5f, 2.0f);
        pathBuilder.lineToRelative(1.09f, 2.41f);
        pathBuilder.lineTo(22.0f, 5.5f);
        pathBuilder.lineToRelative(-2.41f, 1.09f);
        pathBuilder.lineTo(18.5f, 9.0f);
        pathBuilder.lineTo(17.41f, 6.59f);
        pathBuilder.close();
        pathBuilder.moveTo(21.28f, 12.72f);
        pathBuilder.lineTo(20.5f, 11.0f);
        pathBuilder.lineToRelative(-0.78f, 1.72f);
        pathBuilder.lineTo(18.0f, 13.5f);
        pathBuilder.lineToRelative(1.72f, 0.78f);
        pathBuilder.lineTo(20.5f, 16.0f);
        pathBuilder.lineToRelative(0.78f, -1.72f);
        pathBuilder.lineTo(23.0f, 13.5f);
        pathBuilder.lineTo(21.28f, 12.72f);
        pathBuilder.close();
        pathBuilder.moveTo(16.24f, 14.37f);
        pathBuilder.lineToRelative(1.94f, 1.47f);
        pathBuilder.lineToRelative(-2.5f, 4.33f);
        pathBuilder.lineToRelative(-2.24f, -0.94f);
        pathBuilder.curveToRelative(-0.2f, 0.13f, -0.42f, 0.26f, -0.64f, 0.37f);
        pathBuilder.lineTo(12.5f, 22.0f);
        pathBuilder.horizontalLineToRelative(-5.0f);
        pathBuilder.lineToRelative(-0.3f, -2.41f);
        pathBuilder.curveToRelative(-0.22f, -0.11f, -0.43f, -0.23f, -0.64f, -0.37f);
        pathBuilder.lineToRelative(-2.24f, 0.94f);
        pathBuilder.lineToRelative(-2.5f, -4.33f);
        pathBuilder.lineToRelative(1.94f, -1.47f);
        pathBuilder.curveTo(3.75f, 14.25f, 3.75f, 14.12f, 3.75f, 14.0f);
        pathBuilder.reflectiveCurveToRelative(0.0f, -0.25f, 0.01f, -0.37f);
        pathBuilder.lineToRelative(-1.94f, -1.47f);
        pathBuilder.lineToRelative(2.5f, -4.33f);
        pathBuilder.lineToRelative(2.24f, 0.94f);
        pathBuilder.curveToRelative(0.2f, -0.13f, 0.42f, -0.26f, 0.64f, -0.37f);
        pathBuilder.lineTo(7.5f, 6.0f);
        pathBuilder.horizontalLineToRelative(5.0f);
        pathBuilder.lineToRelative(0.3f, 2.41f);
        pathBuilder.curveToRelative(0.22f, 0.11f, 0.43f, 0.23f, 0.64f, 0.37f);
        pathBuilder.lineToRelative(2.24f, -0.94f);
        pathBuilder.lineToRelative(2.5f, 4.33f);
        pathBuilder.lineToRelative(-1.94f, 1.47f);
        pathBuilder.curveToRelative(0.01f, 0.12f, 0.01f, 0.24f, 0.01f, 0.37f);
        pathBuilder.reflectiveCurveTo(16.25f, 14.25f, 16.24f, 14.37f);
        pathBuilder.close();
        pathBuilder.moveTo(13.0f, 14.0f);
        pathBuilder.curveToRelative(0.0f, -1.66f, -1.34f, -3.0f, -3.0f, -3.0f);
        pathBuilder.reflectiveCurveToRelative(-3.0f, 1.34f, -3.0f, 3.0f);
        pathBuilder.reflectiveCurveToRelative(1.34f, 3.0f, 3.0f, 3.0f);
        pathBuilder.reflectiveCurveTo(13.0f, 15.66f, 13.0f, 14.0f);
        pathBuilder.close();
        m4051addPathoIyEayM = builder.m4051addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3769getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3779getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        ImageVector build = m4051addPathoIyEayM.build();
        _settingsSuggest = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}

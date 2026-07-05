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

/* compiled from: Umbrella.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_umbrella", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Umbrella", "Landroidx/compose/material/icons/Icons$TwoTone;", "getUmbrella", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class UmbrellaKt {
    private static ImageVector _umbrella;

    public static final ImageVector getUmbrella(Icons.TwoTone twoTone) {
        ImageVector.Builder m4051addPathoIyEayM;
        ImageVector imageVector = _umbrella;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("TwoTone.Umbrella", Dp.m5738constructorimpl(24.0f), Dp.m5738constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m3443getBlack0d7_KjU(), null);
        int m3769getButtKaPHkGw = StrokeCap.INSTANCE.m3769getButtKaPHkGw();
        int m3779getBevelLxFBmk8 = StrokeJoin.INSTANCE.m3779getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(13.28f, 8.5f);
        pathBuilder.lineToRelative(0.76f, 0.58f);
        pathBuilder.lineToRelative(0.92f, -0.23f);
        pathBuilder.lineTo(13.0f, 14.8f);
        pathBuilder.verticalLineTo(8.29f);
        pathBuilder.lineTo(13.28f, 8.5f);
        pathBuilder.close();
        pathBuilder.moveTo(9.03f, 8.86f);
        pathBuilder.lineTo(11.0f, 14.8f);
        pathBuilder.verticalLineTo(8.29f);
        pathBuilder.lineTo(10.72f, 8.5f);
        pathBuilder.lineTo(9.96f, 9.09f);
        pathBuilder.lineTo(9.03f, 8.86f);
        pathBuilder.close();
        builder.m4051addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3769getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3779getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(Color.INSTANCE.m3443getBlack0d7_KjU(), null);
        int m3769getButtKaPHkGw2 = StrokeCap.INSTANCE.m3769getButtKaPHkGw();
        int m3779getBevelLxFBmk82 = StrokeJoin.INSTANCE.m3779getBevelLxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(14.5f, 6.92f);
        pathBuilder2.lineTo(13.0f, 5.77f);
        pathBuilder2.verticalLineTo(3.88f);
        pathBuilder2.verticalLineTo(3.4f);
        pathBuilder2.curveToRelative(0.0f, -0.26f, 0.22f, -0.48f, 0.5f, -0.48f);
        pathBuilder2.curveToRelative(0.28f, 0.0f, 0.5f, 0.21f, 0.5f, 0.48f);
        pathBuilder2.verticalLineTo(4.0f);
        pathBuilder2.horizontalLineToRelative(2.0f);
        pathBuilder2.verticalLineTo(3.4f);
        pathBuilder2.curveTo(16.0f, 2.07f, 14.88f, 1.0f, 13.5f, 1.0f);
        pathBuilder2.curveTo(12.12f, 1.0f, 11.0f, 2.07f, 11.0f, 3.4f);
        pathBuilder2.verticalLineToRelative(0.48f);
        pathBuilder2.verticalLineToRelative(1.89f);
        pathBuilder2.lineTo(9.5f, 6.92f);
        pathBuilder2.lineTo(6.0f, 6.07f);
        pathBuilder2.lineToRelative(5.05f, 15.25f);
        pathBuilder2.curveTo(11.2f, 21.77f, 11.6f, 22.0f, 12.0f, 22.0f);
        pathBuilder2.reflectiveCurveToRelative(0.8f, -0.23f, 0.95f, -0.69f);
        pathBuilder2.lineTo(18.0f, 6.07f);
        pathBuilder2.lineTo(14.5f, 6.92f);
        pathBuilder2.close();
        pathBuilder2.moveTo(13.28f, 8.5f);
        pathBuilder2.lineToRelative(0.76f, 0.58f);
        pathBuilder2.lineToRelative(0.92f, -0.23f);
        pathBuilder2.lineTo(13.0f, 14.8f);
        pathBuilder2.verticalLineTo(8.29f);
        pathBuilder2.lineTo(13.28f, 8.5f);
        pathBuilder2.close();
        pathBuilder2.moveTo(9.96f, 9.09f);
        pathBuilder2.lineToRelative(0.76f, -0.58f);
        pathBuilder2.lineTo(11.0f, 8.29f);
        pathBuilder2.verticalLineToRelative(6.51f);
        pathBuilder2.lineTo(9.03f, 8.86f);
        pathBuilder2.lineTo(9.96f, 9.09f);
        pathBuilder2.close();
        m4051addPathoIyEayM = builder.m4051addPathoIyEayM(pathBuilder2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3769getButtKaPHkGw2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3779getBevelLxFBmk82, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        ImageVector build = m4051addPathoIyEayM.build();
        _umbrella = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}

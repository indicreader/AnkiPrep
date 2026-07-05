package androidx.compose.material.icons.outlined;

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

/* compiled from: Voicemail.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_voicemail", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Voicemail", "Landroidx/compose/material/icons/Icons$Outlined;", "getVoicemail", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class VoicemailKt {
    private static ImageVector _voicemail;

    public static final ImageVector getVoicemail(Icons.Outlined outlined) {
        ImageVector.Builder m4051addPathoIyEayM;
        ImageVector imageVector = _voicemail;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.Voicemail", Dp.m5738constructorimpl(24.0f), Dp.m5738constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m3443getBlack0d7_KjU(), null);
        int m3769getButtKaPHkGw = StrokeCap.INSTANCE.m3769getButtKaPHkGw();
        int m3779getBevelLxFBmk8 = StrokeJoin.INSTANCE.m3779getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(18.5f, 6.0f);
        pathBuilder.curveTo(15.46f, 6.0f, 13.0f, 8.46f, 13.0f, 11.5f);
        pathBuilder.curveToRelative(0.0f, 1.33f, 0.47f, 2.55f, 1.26f, 3.5f);
        pathBuilder.lineTo(9.74f, 15.0f);
        pathBuilder.curveToRelative(0.79f, -0.95f, 1.26f, -2.17f, 1.26f, -3.5f);
        pathBuilder.curveTo(11.0f, 8.46f, 8.54f, 6.0f, 5.5f, 6.0f);
        pathBuilder.reflectiveCurveTo(0.0f, 8.46f, 0.0f, 11.5f);
        pathBuilder.reflectiveCurveTo(2.46f, 17.0f, 5.5f, 17.0f);
        pathBuilder.horizontalLineToRelative(13.0f);
        pathBuilder.curveToRelative(3.04f, 0.0f, 5.5f, -2.46f, 5.5f, -5.5f);
        pathBuilder.reflectiveCurveTo(21.54f, 6.0f, 18.5f, 6.0f);
        pathBuilder.close();
        pathBuilder.moveTo(5.5f, 15.0f);
        pathBuilder.curveTo(3.57f, 15.0f, 2.0f, 13.43f, 2.0f, 11.5f);
        pathBuilder.reflectiveCurveTo(3.57f, 8.0f, 5.5f, 8.0f);
        pathBuilder.reflectiveCurveTo(9.0f, 9.57f, 9.0f, 11.5f);
        pathBuilder.reflectiveCurveTo(7.43f, 15.0f, 5.5f, 15.0f);
        pathBuilder.close();
        pathBuilder.moveTo(18.5f, 15.0f);
        pathBuilder.curveToRelative(-1.93f, 0.0f, -3.5f, -1.57f, -3.5f, -3.5f);
        pathBuilder.reflectiveCurveTo(16.57f, 8.0f, 18.5f, 8.0f);
        pathBuilder.reflectiveCurveTo(22.0f, 9.57f, 22.0f, 11.5f);
        pathBuilder.reflectiveCurveTo(20.43f, 15.0f, 18.5f, 15.0f);
        pathBuilder.close();
        m4051addPathoIyEayM = builder.m4051addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3769getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3779getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        ImageVector build = m4051addPathoIyEayM.build();
        _voicemail = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}

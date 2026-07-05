package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: Color.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a9\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0017\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015\u001a5\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u00142\b\b\u0001\u0010\r\u001a\u00020\u00142\b\b\u0001\u0010\u000e\u001a\u00020\u00142\b\b\u0003\u0010\u000f\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0016\u001a\u0015\u0010\n\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a1\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0082\b\u001a,\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\b\b\u0001\u0010\"\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\fH\u0002\u001a\u001e\u0010'\u001a\u00020\u0002*\u00020\u00022\u0006\u0010(\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u0016\u0010+\u001a\u00020,*\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u0016\u0010/\u001a\u00020\f*\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a%\u00102\u001a\u00020\u0002*\u00020\u00022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000204H\u0086\bø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a\u0016\u00107\u001a\u00020\u0014*\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006:"}, d2 = {"isSpecified", "", "Landroidx/compose/ui/graphics/Color;", "isSpecified-8_81llA$annotations", "(J)V", "isSpecified-8_81llA", "(J)Z", "isUnspecified", "isUnspecified-8_81llA$annotations", "isUnspecified-8_81llA", "Color", "red", "", "green", "blue", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "color", "", "(I)J", "(IIII)J", "", "(J)J", "compositeComponent", "fgC", "bgC", "fgA", "bgA", "a", "lerp", "start", "stop", "fraction", "lerp-jxsXWHM", "(JJF)J", "saturate", "v", "compositeOver", "background", "compositeOver--OWjLjI", "(JJ)J", "getComponents", "", "getComponents-8_81llA", "(J)[F", "luminance", "luminance-8_81llA", "(J)F", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-DxMtmZc", "(JLkotlin/jvm/functions/Function0;)J", "toArgb", "toArgb-8_81llA", "(J)I", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ColorKt {
    private static final float compositeComponent(float f, float f2, float f3, float f4, float f5) {
        if (f5 == 0.0f) {
            return 0.0f;
        }
        return ((f * f3) + ((f2 * f4) * (1.0f - f3))) / f5;
    }

    /* renamed from: isSpecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m3465isSpecified8_81llA$annotations(long j) {
    }

    /* renamed from: isUnspecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m3467isUnspecified8_81llA$annotations(long j) {
    }

    private static final float saturate(float f) {
        float f2 = 0.0f;
        if (f > 0.0f) {
            f2 = 1.0f;
            if (f < 1.0f) {
                return f;
            }
        }
        return f2;
    }

    public static /* synthetic */ long Color$default(float f, float f2, float f3, float f4, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return Color(f, f2, f3, f4, colorSpace);
    }

    public static final long Color(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        float minValue = colorSpace.getMinValue(0);
        if (f <= colorSpace.getMaxValue(0) && minValue <= f) {
            float minValue2 = colorSpace.getMinValue(1);
            if (f2 <= colorSpace.getMaxValue(1) && minValue2 <= f2) {
                float minValue3 = colorSpace.getMinValue(2);
                if (f3 <= colorSpace.getMaxValue(2) && minValue3 <= f3 && 0.0f <= f4 && f4 <= 1.0f) {
                    if (colorSpace.getIsSrgb()) {
                        return Color.m3413constructorimpl(ULong.m6639constructorimpl(ULong.m6639constructorimpl(ULong.m6639constructorimpl((((((int) ((f * 255.0f) + 0.5f)) << 16) | (((int) ((f4 * 255.0f) + 0.5f)) << 24)) | (((int) ((f2 * 255.0f) + 0.5f)) << 8)) | ((int) ((f3 * 255.0f) + 0.5f))) & 4294967295L) << 32));
                    }
                    if (colorSpace.getComponentCount() != 3) {
                        throw new IllegalArgumentException("Color only works with ColorSpaces with 3 components".toString());
                    }
                    int id = colorSpace.getId();
                    if (id == -1) {
                        throw new IllegalArgumentException("Unknown color space, please use a color space in ColorSpaces".toString());
                    }
                    short m3525constructorimpl = Float16.m3525constructorimpl(f);
                    return Color.m3413constructorimpl(ULong.m6639constructorimpl(ULong.m6639constructorimpl(ULong.m6639constructorimpl(ULong.m6639constructorimpl(ULong.m6639constructorimpl(ULong.m6639constructorimpl(ULong.m6639constructorimpl(Float16.m3525constructorimpl(f2)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ULong.m6639constructorimpl(ULong.m6639constructorimpl(ULong.m6639constructorimpl(m3525constructorimpl) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48)) | ULong.m6639constructorimpl(ULong.m6639constructorimpl(ULong.m6639constructorimpl(Float16.m3525constructorimpl(f3)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16)) | ULong.m6639constructorimpl(ULong.m6639constructorimpl(ULong.m6639constructorimpl((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f)) & 1023) << 6)) | ULong.m6639constructorimpl(ULong.m6639constructorimpl(id) & 63)));
                }
            }
        }
        throw new IllegalArgumentException(("red = " + f + ", green = " + f2 + ", blue = " + f3 + ", alpha = " + f4 + " outside the range for " + colorSpace).toString());
    }

    public static final long Color(int i) {
        return Color.m3413constructorimpl(ULong.m6639constructorimpl(ULong.m6639constructorimpl(i) << 32));
    }

    public static final long Color(long j) {
        return Color.m3413constructorimpl(ULong.m6639constructorimpl(ULong.m6639constructorimpl(ULong.m6639constructorimpl(j) & 4294967295L) << 32));
    }

    public static /* synthetic */ long Color$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 255;
        }
        return Color(i, i2, i3, i4);
    }

    public static final long Color(int i, int i2, int i3, int i4) {
        return Color(((i & 255) << 16) | ((i4 & 255) << 24) | ((i2 & 255) << 8) | (i3 & 255));
    }

    /* renamed from: lerp-jxsXWHM, reason: not valid java name */
    public static final long m3468lerpjxsXWHM(long j, long j2, float f) {
        ColorSpace oklab = ColorSpaces.INSTANCE.getOklab();
        long m3414convertvNxB06k = Color.m3414convertvNxB06k(j, oklab);
        long m3414convertvNxB06k2 = Color.m3414convertvNxB06k(j2, oklab);
        float m3419getAlphaimpl = Color.m3419getAlphaimpl(m3414convertvNxB06k);
        float m3423getRedimpl = Color.m3423getRedimpl(m3414convertvNxB06k);
        float m3422getGreenimpl = Color.m3422getGreenimpl(m3414convertvNxB06k);
        float m3420getBlueimpl = Color.m3420getBlueimpl(m3414convertvNxB06k);
        float m3419getAlphaimpl2 = Color.m3419getAlphaimpl(m3414convertvNxB06k2);
        float m3423getRedimpl2 = Color.m3423getRedimpl(m3414convertvNxB06k2);
        float m3422getGreenimpl2 = Color.m3422getGreenimpl(m3414convertvNxB06k2);
        float m3420getBlueimpl2 = Color.m3420getBlueimpl(m3414convertvNxB06k2);
        return Color.m3414convertvNxB06k(Color(MathHelpersKt.lerp(m3423getRedimpl, m3423getRedimpl2, f), MathHelpersKt.lerp(m3422getGreenimpl, m3422getGreenimpl2, f), MathHelpersKt.lerp(m3420getBlueimpl, m3420getBlueimpl2, f), MathHelpersKt.lerp(m3419getAlphaimpl, m3419getAlphaimpl2, f), oklab), Color.m3421getColorSpaceimpl(j2));
    }

    /* renamed from: compositeOver--OWjLjI, reason: not valid java name */
    public static final long m3462compositeOverOWjLjI(long j, long j2) {
        long m3414convertvNxB06k = Color.m3414convertvNxB06k(j, Color.m3421getColorSpaceimpl(j2));
        float m3419getAlphaimpl = Color.m3419getAlphaimpl(j2);
        float m3419getAlphaimpl2 = Color.m3419getAlphaimpl(m3414convertvNxB06k);
        float f = 1.0f - m3419getAlphaimpl2;
        float f2 = (m3419getAlphaimpl * f) + m3419getAlphaimpl2;
        return Color(f2 == 0.0f ? 0.0f : ((Color.m3423getRedimpl(m3414convertvNxB06k) * m3419getAlphaimpl2) + ((Color.m3423getRedimpl(j2) * m3419getAlphaimpl) * f)) / f2, f2 == 0.0f ? 0.0f : ((Color.m3422getGreenimpl(m3414convertvNxB06k) * m3419getAlphaimpl2) + ((Color.m3422getGreenimpl(j2) * m3419getAlphaimpl) * f)) / f2, f2 != 0.0f ? ((Color.m3420getBlueimpl(m3414convertvNxB06k) * m3419getAlphaimpl2) + ((Color.m3420getBlueimpl(j2) * m3419getAlphaimpl) * f)) / f2 : 0.0f, f2, Color.m3421getColorSpaceimpl(j2));
    }

    /* renamed from: getComponents-8_81llA, reason: not valid java name */
    private static final float[] m3463getComponents8_81llA(long j) {
        return new float[]{Color.m3423getRedimpl(j), Color.m3422getGreenimpl(j), Color.m3420getBlueimpl(j), Color.m3419getAlphaimpl(j)};
    }

    /* renamed from: luminance-8_81llA, reason: not valid java name */
    public static final float m3469luminance8_81llA(long j) {
        ColorSpace m3421getColorSpaceimpl = Color.m3421getColorSpaceimpl(j);
        if (!ColorModel.m3823equalsimpl0(m3421getColorSpaceimpl.getModel(), ColorModel.INSTANCE.m3830getRgbxdoWZVw())) {
            throw new IllegalArgumentException(("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) ColorModel.m3826toStringimpl(m3421getColorSpaceimpl.getModel()))).toString());
        }
        Intrinsics.checkNotNull(m3421getColorSpaceimpl, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        DoubleFunction eotfFunc = ((Rgb) m3421getColorSpaceimpl).getEotfFunc();
        return saturate((float) ((eotfFunc.invoke(Color.m3423getRedimpl(j)) * 0.2126d) + (eotfFunc.invoke(Color.m3422getGreenimpl(j)) * 0.7152d) + (eotfFunc.invoke(Color.m3420getBlueimpl(j)) * 0.0722d)));
    }

    /* renamed from: toArgb-8_81llA, reason: not valid java name */
    public static final int m3471toArgb8_81llA(long j) {
        return (int) ULong.m6639constructorimpl(Color.m3414convertvNxB06k(j, ColorSpaces.INSTANCE.getSrgb()) >>> 32);
    }

    /* renamed from: isSpecified-8_81llA, reason: not valid java name */
    public static final boolean m3464isSpecified8_81llA(long j) {
        return j != Color.INSTANCE.m3453getUnspecified0d7_KjU();
    }

    /* renamed from: isUnspecified-8_81llA, reason: not valid java name */
    public static final boolean m3466isUnspecified8_81llA(long j) {
        return j == Color.INSTANCE.m3453getUnspecified0d7_KjU();
    }

    /* renamed from: takeOrElse-DxMtmZc, reason: not valid java name */
    public static final long m3470takeOrElseDxMtmZc(long j, Function0<Color> function0) {
        return j != Color.INSTANCE.m3453getUnspecified0d7_KjU() ? j : function0.invoke().m3427unboximpl();
    }
}

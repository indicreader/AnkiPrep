package com.example.flashcardapp.ui.theme;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.Shapes;
import androidx.compose.material3.Typography;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Theme.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aH\u0010F\u001a\u00020G2\b\b\u0002\u0010H\u001a\u00020I2\b\b\u0002\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020K2\b\b\u0002\u0010M\u001a\u00020I2\u0011\u0010N\u001a\r\u0012\u0004\u0012\u00020G0O¢\u0006\u0002\bPH\u0007¢\u0006\u0002\u0010Q\u001a\u000e\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u0005\u001a\b\u0010U\u001a\u00020VH\u0002\u001a\b\u0010W\u001a\u00020VH\u0002\u001a\b\u0010X\u001a\u00020VH\u0002\u001a\b\u0010Y\u001a\u00020VH\u0002\u001a\b\u0010Z\u001a\u00020VH\u0002\u001a\b\u0010[\u001a\u00020VH\u0002\u001a\b\u0010\\\u001a\u00020VH\u0002\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"+\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\"+\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000e\"\u0013\u0010\u0015\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0016\u0010\f\"\u0013\u0010\u0018\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\f\"\u0013\u0010\u001a\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001b\u0010\f\"\u0013\u0010\u001c\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001d\u0010\f\"\u0013\u0010\u001e\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001f\u0010\f\"\u0013\u0010 \u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b!\u0010\f\"\u0013\u0010\"\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b#\u0010\f\"+\u0010$\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0010\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000e\"\u0013\u0010(\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b)\u0010\f\"\u0013\u0010*\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b+\u0010\f\"+\u0010,\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010\u0010\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000e\"\u0013\u00100\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b1\u0010\f\"\u0013\u00102\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b3\u0010\f\"\u0013\u00104\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b5\u0010\f\"\u0013\u00106\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b7\u0010\f\"+\u00108\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b;\u0010\u0010\u001a\u0004\b9\u0010\f\"\u0004\b:\u0010\u000e\"+\u0010<\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b?\u0010\u0010\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010\u000e\"\u0011\u0010@\u001a\u00020A¢\u0006\b\n\u0000\u001a\u0004\bB\u0010C\"\u0011\u0010D\u001a\u00020A¢\u0006\b\n\u0000\u001a\u0004\bE\u0010C¨\u0006]"}, d2 = {"AnkiShapes", "Landroidx/compose/material3/Shapes;", "getAnkiShapes", "()Landroidx/compose/material3/Shapes;", "AtkinsonHyperlegible", "Landroidx/compose/ui/text/font/FontFamily;", "getAtkinsonHyperlegible", "()Landroidx/compose/ui/text/font/FontFamily;", "<set-?>", "Landroidx/compose/ui/graphics/Color;", "BackgroundLavender", "getBackgroundLavender", "()J", "setBackgroundLavender-8_81llA", "(J)V", "BackgroundLavender$delegate", "Landroidx/compose/runtime/MutableState;", "CardBackgroundLight", "getCardBackgroundLight", "setCardBackgroundLight-8_81llA", "CardBackgroundLight$delegate", "CorrectBg", "getCorrectBg", "J", "CorrectColor", "getCorrectColor", "ErrorContainer", "getErrorContainer", "IncorrectBg", "getIncorrectBg", "IncorrectColor", "getIncorrectColor", "LightCyanAccent", "getLightCyanAccent", "LightPinkAccent", "getLightPinkAccent", "LightPurple", "getLightPurple", "setLightPurple-8_81llA", "LightPurple$delegate", "LightPurpleAccent", "getLightPurpleAccent", "PrimaryContainerMint", "getPrimaryContainerMint", "PrimaryPurple", "getPrimaryPurple", "setPrimaryPurple-8_81llA", "PrimaryPurple$delegate", "PrimarySage", "getPrimarySage", "SurfaceContainerHigh", "getSurfaceContainerHigh", "SurfaceContainerHighest", "getSurfaceContainerHighest", "TertiaryContainer", "getTertiaryContainer", "TextPrimaryDeep", "getTextPrimaryDeep", "setTextPrimaryDeep-8_81llA", "TextPrimaryDeep$delegate", "TextSecondaryGray", "getTextSecondaryGray", "setTextSecondaryGray-8_81llA", "TextSecondaryGray$delegate", "neonBorderPrimary", "Landroidx/compose/foundation/BorderStroke;", "getNeonBorderPrimary", "()Landroidx/compose/foundation/BorderStroke;", "neonBorderSecondary", "getNeonBorderSecondary", "AnkiQuizTheme", "", "themePreset", "", "isDarkMode", "", "useDynamicWallpaper", "fontFamilyType", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/String;ZZLjava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "buildTypography", "Landroidx/compose/material3/Typography;", "fontFamily", "cyberDarkScheme", "Landroidx/compose/material3/ColorScheme;", "cyberEmeraldDarkScheme", "cyberLavenderDarkScheme", "emeraldScheme", "lavenderScheme", "oceanScheme", "sunsetScheme", "app_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ThemeKt {
    private static final Shapes AnkiShapes;
    private static final FontFamily AtkinsonHyperlegible = FontFamilyKt.FontFamily(FontKt.m5331FontYpTlLL0$default(R.font.atkinson_hyperlegible_regular, FontWeight.INSTANCE.getNormal(), 0, 0, 12, null), FontKt.m5331FontYpTlLL0$default(R.font.atkinson_hyperlegible_italic, FontWeight.INSTANCE.getNormal(), FontStyle.INSTANCE.m5354getItalic_LCdwA(), 0, 8, null), FontKt.m5331FontYpTlLL0$default(R.font.atkinson_hyperlegible_bold, FontWeight.INSTANCE.getBold(), 0, 0, 12, null), FontKt.m5331FontYpTlLL0$default(R.font.atkinson_hyperlegible_bold_italic, FontWeight.INSTANCE.getBold(), FontStyle.INSTANCE.m5354getItalic_LCdwA(), 0, 8, null));
    private static final MutableState BackgroundLavender$delegate;
    private static final MutableState CardBackgroundLight$delegate;
    private static final long CorrectBg;
    private static final long CorrectColor;
    private static final long ErrorContainer;
    private static final long IncorrectBg;
    private static final long IncorrectColor;
    private static final long LightCyanAccent;
    private static final long LightPinkAccent;
    private static final MutableState LightPurple$delegate;
    private static final long LightPurpleAccent;
    private static final long PrimaryContainerMint;
    private static final MutableState PrimaryPurple$delegate;
    private static final long PrimarySage;
    private static final long SurfaceContainerHigh;
    private static final long SurfaceContainerHighest;
    private static final long TertiaryContainer;
    private static final MutableState TextPrimaryDeep$delegate;
    private static final MutableState TextSecondaryGray$delegate;
    private static final BorderStroke neonBorderPrimary;
    private static final BorderStroke neonBorderSecondary;

    public static final Shapes getAnkiShapes() {
        return AnkiShapes;
    }

    public static final FontFamily getAtkinsonHyperlegible() {
        return AtkinsonHyperlegible;
    }

    public static final long getCorrectBg() {
        return CorrectBg;
    }

    public static final long getCorrectColor() {
        return CorrectColor;
    }

    public static final long getErrorContainer() {
        return ErrorContainer;
    }

    public static final long getIncorrectBg() {
        return IncorrectBg;
    }

    public static final long getIncorrectColor() {
        return IncorrectColor;
    }

    public static final long getLightCyanAccent() {
        return LightCyanAccent;
    }

    public static final long getLightPinkAccent() {
        return LightPinkAccent;
    }

    public static final long getLightPurpleAccent() {
        return LightPurpleAccent;
    }

    public static final BorderStroke getNeonBorderPrimary() {
        return neonBorderPrimary;
    }

    public static final BorderStroke getNeonBorderSecondary() {
        return neonBorderSecondary;
    }

    public static final long getPrimaryContainerMint() {
        return PrimaryContainerMint;
    }

    public static final long getPrimarySage() {
        return PrimarySage;
    }

    public static final long getSurfaceContainerHigh() {
        return SurfaceContainerHigh;
    }

    public static final long getSurfaceContainerHighest() {
        return SurfaceContainerHighest;
    }

    public static final long getTertiaryContainer() {
        return TertiaryContainer;
    }

    static {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        MutableState mutableStateOf$default6;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Color.m3407boximpl(ColorKt.Color(4283117708L)), null, 2, null);
        PrimaryPurple$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Color.m3407boximpl(ColorKt.Color(4293320952L)), null, 2, null);
        LightPurple$delegate = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Color.m3407boximpl(ColorKt.Color(4294439673L)), null, 2, null);
        BackgroundLavender$delegate = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Color.m3407boximpl(ColorKt.Color(4294967295L)), null, 2, null);
        CardBackgroundLight$delegate = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Color.m3407boximpl(ColorKt.Color(4280160309L)), null, 2, null);
        TextPrimaryDeep$delegate = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Color.m3407boximpl(ColorKt.Color(4286214027L)), null, 2, null);
        TextSecondaryGray$delegate = mutableStateOf$default6;
        LightPurpleAccent = ColorKt.Color(4293649402L);
        LightPinkAccent = ColorKt.Color(4294961648L);
        LightCyanAccent = ColorKt.Color(4292998654L);
        long Color = ColorKt.Color(4283215696L);
        PrimarySage = Color;
        PrimaryContainerMint = ColorKt.Color(4293457385L);
        float f = 1;
        neonBorderPrimary = BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(f), Color.m3416copywmQWz5c$default(getPrimaryPurple(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null));
        neonBorderSecondary = BorderStrokeKt.m244BorderStrokecXLIe8U(Dp.m5738constructorimpl(f), Color.m3416copywmQWz5c$default(Color, 0.5f, 0.0f, 0.0f, 0.0f, 14, null));
        CorrectColor = ColorKt.Color(4281236786L);
        IncorrectColor = ColorKt.Color(4291176488L);
        CorrectBg = ColorKt.Color(4293457385L);
        IncorrectBg = ColorKt.Color(4294962158L);
        SurfaceContainerHigh = ColorKt.Color(4294176247L);
        SurfaceContainerHighest = ColorKt.Color(4293781494L);
        ErrorContainer = ColorKt.Color(4294962158L);
        TertiaryContainer = ColorKt.Color(4294956799L);
        AnkiShapes = new Shapes(RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(4)), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(8)), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(12)), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(16)), RoundedCornerShapeKt.m839RoundedCornerShape0680j_4(Dp.m5738constructorimpl(24)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final long getPrimaryPurple() {
        return ((Color) PrimaryPurple$delegate.getValue()).m3427unboximpl();
    }

    /* renamed from: setPrimaryPurple-8_81llA, reason: not valid java name */
    public static final void m6352setPrimaryPurple8_81llA(long j) {
        PrimaryPurple$delegate.setValue(Color.m3407boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final long getLightPurple() {
        return ((Color) LightPurple$delegate.getValue()).m3427unboximpl();
    }

    /* renamed from: setLightPurple-8_81llA, reason: not valid java name */
    public static final void m6351setLightPurple8_81llA(long j) {
        LightPurple$delegate.setValue(Color.m3407boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final long getBackgroundLavender() {
        return ((Color) BackgroundLavender$delegate.getValue()).m3427unboximpl();
    }

    /* renamed from: setBackgroundLavender-8_81llA, reason: not valid java name */
    public static final void m6349setBackgroundLavender8_81llA(long j) {
        BackgroundLavender$delegate.setValue(Color.m3407boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final long getCardBackgroundLight() {
        return ((Color) CardBackgroundLight$delegate.getValue()).m3427unboximpl();
    }

    /* renamed from: setCardBackgroundLight-8_81llA, reason: not valid java name */
    public static final void m6350setCardBackgroundLight8_81llA(long j) {
        CardBackgroundLight$delegate.setValue(Color.m3407boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final long getTextPrimaryDeep() {
        return ((Color) TextPrimaryDeep$delegate.getValue()).m3427unboximpl();
    }

    /* renamed from: setTextPrimaryDeep-8_81llA, reason: not valid java name */
    public static final void m6353setTextPrimaryDeep8_81llA(long j) {
        TextPrimaryDeep$delegate.setValue(Color.m3407boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final long getTextSecondaryGray() {
        return ((Color) TextSecondaryGray$delegate.getValue()).m3427unboximpl();
    }

    /* renamed from: setTextSecondaryGray-8_81llA, reason: not valid java name */
    public static final void m6354setTextSecondaryGray8_81llA(long j) {
        TextSecondaryGray$delegate.setValue(Color.m3407boximpl(j));
    }

    public static final Typography buildTypography(FontFamily fontFamily) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        FontWeight bold = FontWeight.INSTANCE.getBold();
        TextStyle textStyle = new TextStyle(0L, TextUnitKt.getSp(45), bold, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, TextUnitKt.getSp(-0.9d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(52), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (DefaultConstructorMarker) null);
        TextStyle textStyle2 = new TextStyle(0L, TextUnitKt.getSp(36), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(44), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646105, (DefaultConstructorMarker) null);
        TextStyle textStyle3 = new TextStyle(0L, TextUnitKt.getSp(28), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(36), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646105, (DefaultConstructorMarker) null);
        TextStyle textStyle4 = new TextStyle(0L, TextUnitKt.getSp(32), FontWeight.INSTANCE.getSemiBold(), (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(40), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646105, (DefaultConstructorMarker) null);
        TextStyle textStyle5 = new TextStyle(0L, TextUnitKt.getSp(28), FontWeight.INSTANCE.getSemiBold(), (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(36), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646105, (DefaultConstructorMarker) null);
        TextStyle textStyle6 = new TextStyle(0L, TextUnitKt.getSp(24), FontWeight.INSTANCE.getSemiBold(), (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(32), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646105, (DefaultConstructorMarker) null);
        TextStyle textStyle7 = new TextStyle(0L, TextUnitKt.getSp(22), FontWeight.INSTANCE.getMedium(), (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(28), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646105, (DefaultConstructorMarker) null);
        FontWeight medium = FontWeight.INSTANCE.getMedium();
        TextStyle textStyle8 = new TextStyle(0L, TextUnitKt.getSp(16), medium, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, TextUnitKt.getSp(0.15d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(24), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (DefaultConstructorMarker) null);
        FontWeight medium2 = FontWeight.INSTANCE.getMedium();
        TextStyle textStyle9 = new TextStyle(0L, TextUnitKt.getSp(14), medium2, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, TextUnitKt.getSp(0.1d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (DefaultConstructorMarker) null);
        FontWeight normal = FontWeight.INSTANCE.getNormal();
        TextStyle textStyle10 = new TextStyle(0L, TextUnitKt.getSp(18), normal, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, TextUnitKt.getSp(0.18d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(32), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (DefaultConstructorMarker) null);
        TextStyle textStyle11 = new TextStyle(0L, TextUnitKt.getSp(16), FontWeight.INSTANCE.getNormal(), (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(28), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646105, (DefaultConstructorMarker) null);
        FontWeight normal2 = FontWeight.INSTANCE.getNormal();
        TextStyle textStyle12 = new TextStyle(0L, TextUnitKt.getSp(12), normal2, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, TextUnitKt.getSp(0.4d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (DefaultConstructorMarker) null);
        FontWeight semiBold = FontWeight.INSTANCE.getSemiBold();
        TextStyle textStyle13 = new TextStyle(0L, TextUnitKt.getSp(14), semiBold, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, TextUnitKt.getSp(1.4d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (DefaultConstructorMarker) null);
        FontWeight medium3 = FontWeight.INSTANCE.getMedium();
        TextStyle textStyle14 = new TextStyle(0L, TextUnitKt.getSp(12), medium3, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (DefaultConstructorMarker) null);
        FontWeight medium4 = FontWeight.INSTANCE.getMedium();
        return new Typography(textStyle, textStyle2, textStyle3, textStyle4, textStyle5, textStyle6, textStyle7, textStyle8, textStyle9, textStyle10, textStyle11, textStyle12, textStyle13, textStyle14, new TextStyle(0L, TextUnitKt.getSp(11), medium4, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (DefaultConstructorMarker) null));
    }

    private static final ColorScheme lavenderScheme() {
        return ColorSchemeKt.m1406lightColorSchemeCXl9yA$default(ColorKt.Color(4280156329L), ColorKt.Color(4294967295L), ColorKt.Color(4281673165L), ColorKt.Color(4289835007L), 0L, ColorKt.Color(4285606626L), ColorKt.Color(4294967295L), ColorKt.Color(4287319036L), ColorKt.Color(4294966267L), ColorKt.Color(4281217846L), ColorKt.Color(4294967295L), ColorKt.Color(4282665293L), ColorKt.Color(4289968317L), ColorKt.Color(4294572543L), ColorKt.Color(4279311405L), ColorKt.Color(4294572543L), ColorKt.Color(4279311405L), ColorKt.Color(4292404219L), ColorKt.Color(4282795349L), 0L, 0L, 0L, ColorKt.Color(4290386458L), ColorKt.Color(4294967295L), ColorKt.Color(4294957782L), ColorKt.Color(4287823882L), ColorKt.Color(4286018951L), ColorKt.Color(4291282136L), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -264765424, 15, null);
    }

    private static final ColorScheme emeraldScheme() {
        return ColorSchemeKt.m1406lightColorSchemeCXl9yA$default(ColorKt.Color(4279987002L), Color.INSTANCE.m3454getWhite0d7_KjU(), ColorKt.Color(4290245064L), ColorKt.Color(4278198544L), 0L, ColorKt.Color(4283392852L), Color.INSTANCE.m3454getWhite0d7_KjU(), ColorKt.Color(4292012244L), ColorKt.Color(4278984467L), ColorKt.Color(4282146680L), Color.INSTANCE.m3454getWhite0d7_KjU(), ColorKt.Color(4290831615L), ColorKt.Color(4278197809L), ColorKt.Color(4294047989L), ColorKt.Color(4279901210L), ColorKt.Color(4294967295L), ColorKt.Color(4279901210L), ColorKt.Color(4292666842L), ColorKt.Color(4282468673L), 0L, 0L, 0L, ColorKt.Color(4291176488L), Color.INSTANCE.m3454getWhite0d7_KjU(), ColorKt.Color(4294962158L), ColorKt.Color(4282453515L), ColorKt.Color(4285626737L), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -130547696, 15, null);
    }

    private static final ColorScheme oceanScheme() {
        return ColorSchemeKt.m1406lightColorSchemeCXl9yA$default(ColorKt.Color(4279592384L), Color.INSTANCE.m3454getWhite0d7_KjU(), ColorKt.Color(4292273407L), ColorKt.Color(4278196801L), 0L, ColorKt.Color(4279858898L), Color.INSTANCE.m3454getWhite0d7_KjU(), ColorKt.Color(4291814143L), ColorKt.Color(4278197054L), ColorKt.Color(4278216822L), Color.INSTANCE.m3454getWhite0d7_KjU(), ColorKt.Color(4288606207L), ColorKt.Color(4278198053L), ColorKt.Color(4293981432L), ColorKt.Color(4278197054L), ColorKt.Color(4294967295L), ColorKt.Color(4278197054L), ColorKt.Color(4292862699L), ColorKt.Color(4282533710L), 0L, 0L, 0L, ColorKt.Color(4291176488L), Color.INSTANCE.m3454getWhite0d7_KjU(), ColorKt.Color(4294962158L), ColorKt.Color(4282453515L), ColorKt.Color(4285691775L), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -130547696, 15, null);
    }

    private static final ColorScheme sunsetScheme() {
        return ColorSchemeKt.m1406lightColorSchemeCXl9yA$default(ColorKt.Color(4290721292L), Color.INSTANCE.m3454getWhite0d7_KjU(), ColorKt.Color(4294958031L), ColorKt.Color(4282189824L), 0L, ColorKt.Color(4286011211L), Color.INSTANCE.m3454getWhite0d7_KjU(), ColorKt.Color(4294958031L), ColorKt.Color(4281079308L), ColorKt.Color(4285095470L), Color.INSTANCE.m3454getWhite0d7_KjU(), ColorKt.Color(4294042280L), ColorKt.Color(4280425216L), ColorKt.Color(4294636272L), ColorKt.Color(4280424728L), ColorKt.Color(4294967295L), ColorKt.Color(4280424728L), ColorKt.Color(4294303190L), ColorKt.Color(4283646782L), 0L, 0L, 0L, ColorKt.Color(4291176488L), Color.INSTANCE.m3454getWhite0d7_KjU(), ColorKt.Color(4294962158L), ColorKt.Color(4282453515L), ColorKt.Color(4286935917L), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -130547696, 15, null);
    }

    private static final ColorScheme cyberDarkScheme() {
        return ColorSchemeKt.m1402darkColorSchemeCXl9yA$default(ColorKt.Color(4291019007L), ColorKt.Color(4280156329L), ColorKt.Color(4281673165L), ColorKt.Color(4293058559L), 0L, ColorKt.Color(4292000767L), ColorKt.Color(4280615002L), ColorKt.Color(4284088518L), ColorKt.Color(4293582335L), ColorKt.Color(4290955212L), ColorKt.Color(4279704608L), ColorKt.Color(4281217846L), ColorKt.Color(4292862952L), ColorKt.Color(4279311405L), ColorKt.Color(4294572543L), ColorKt.Color(4280693059L), ColorKt.Color(4293718527L), ColorKt.Color(4282795349L), ColorKt.Color(4292404219L), 0L, 0L, 0L, ColorKt.Color(4294948011L), ColorKt.Color(4285071365L), ColorKt.Color(4287823882L), ColorKt.Color(4294957782L), ColorKt.Color(4291282136L), ColorKt.Color(4286018951L), ColorKt.Color(4278190080L), 0L, 0L, 0L, 0L, 0L, 0L, 0L, -533200880, 15, null);
    }

    private static final ColorScheme cyberLavenderDarkScheme() {
        return ColorSchemeKt.m1402darkColorSchemeCXl9yA$default(ColorKt.Color(4291739135L), ColorKt.Color(4281865093L), ColorKt.Color(4289960703L), ColorKt.Color(4282787731L), 0L, ColorKt.Color(4286698708L), ColorKt.Color(4278204215L), ColorKt.Color(4278218607L), ColorKt.Color(4288344046L), ColorKt.Color(4289513467L), ColorKt.Color(4279251035L), ColorKt.Color(4287605468L), ColorKt.Color(4280368745L), ColorKt.Color(4279177491L), ColorKt.Color(4293059301L), ColorKt.Color(4279901214L), ColorKt.Color(4293059301L), ColorKt.Color(4280822317L), ColorKt.Color(4291086032L), 0L, 0L, 0L, ColorKt.Color(4294948011L), ColorKt.Color(4285071365L), ColorKt.Color(4287823882L), ColorKt.Color(4294957782L), ColorKt.Color(4281677626L), ColorKt.Color(4282599247L), ColorKt.Color(4278190080L), 0L, 0L, 0L, 0L, 0L, 0L, 0L, -533200880, 15, null);
    }

    private static final ColorScheme cyberEmeraldDarkScheme() {
        return ColorSchemeKt.m1402darkColorSchemeCXl9yA$default(ColorKt.Color(4286633116L), ColorKt.Color(4278204698L), ColorKt.Color(4278211108L), ColorKt.Color(4290245064L), 0L, ColorKt.Color(4289122484L), ColorKt.Color(4279449121L), ColorKt.Color(4280962358L), ColorKt.Color(4290964703L), ColorKt.Color(4287156946L), ColorKt.Color(4278204215L), ColorKt.Color(4278210383L), ColorKt.Color(4288999407L), ColorKt.Color(4279178257L), ColorKt.Color(4293059554L), ColorKt.Color(4279770138L), ColorKt.Color(4293059554L), ColorKt.Color(4282075712L), ColorKt.Color(4290890177L), 0L, 0L, 0L, ColorKt.Color(4294948011L), ColorKt.Color(4285071365L), ColorKt.Color(4287823882L), ColorKt.Color(4294957782L), ColorKt.Color(4285626737L), ColorKt.Color(4282468673L), ColorKt.Color(4278190080L), 0L, 0L, 0L, 0L, 0L, 0L, 0L, -533200880, 15, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void AnkiQuizTheme(java.lang.String r24, boolean r25, boolean r26, java.lang.String r27, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instructions count: 721
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.ui.theme.ThemeKt.AnkiQuizTheme(java.lang.String, boolean, boolean, java.lang.String, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}

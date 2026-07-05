package androidx.compose.material3;

import android.content.Context;
import android.os.Build;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.math.MathUtils;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* compiled from: DynamicTonalPalette.android.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0001\u001a\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0001\u001a\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0002\u001a \u0010\u0012\u001a\u00020\u0013*\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"delinearized", "", "rgbComponent", "", "dynamicDarkColorScheme", "Landroidx/compose/material3/ColorScheme;", "context", "Landroid/content/Context;", "dynamicDarkColorScheme31", "tonalPalette", "Landroidx/compose/material3/TonalPalette;", "dynamicDarkColorScheme34", "dynamicLightColorScheme", "dynamicLightColorScheme31", "dynamicLightColorScheme34", "dynamicTonalPalette", "labInvf", "ft", "setLuminance", "Landroidx/compose/ui/graphics/Color;", "newLuminance", "setLuminance-DxMtmZc", "(JF)J", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DynamicTonalPaletteKt {
    private static final float labInvf(float f) {
        float f2 = f * f * f;
        return f2 > 0.008856452f ? f2 : ((116 * f) - 16) / 903.2963f;
    }

    public static final TonalPalette dynamicTonalPalette(Context context) {
        return new TonalPalette(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Blue_700), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Blue_800), m1546setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Purple_800), 98.0f), m1546setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Purple_800), 96.0f), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.GM2_grey_800), m1546setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Purple_800), 94.0f), m1546setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Purple_800), 92.0f), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Indigo_700), m1546setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Purple_800), 87.0f), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Indigo_800), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Pink_700), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Pink_800), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Purple_700), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Purple_800), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Red_700), m1546setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Purple_800), 24.0f), m1546setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Purple_800), 22.0f), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Red_800), m1546setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Purple_800), 17.0f), m1546setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Purple_800), 12.0f), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Teal_700), m1546setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Purple_800), 6.0f), m1546setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Purple_800), 4.0f), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.Teal_800), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.accent_device_default), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.accent_device_default_50), m1546setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.accessibility_focus_highlight), 98.0f), m1546setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.accessibility_focus_highlight), 96.0f), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.accent_device_default_700), m1546setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.accessibility_focus_highlight), 94.0f), m1546setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.accessibility_focus_highlight), 92.0f), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.accent_device_default_dark), m1546setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.accessibility_focus_highlight), 87.0f), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.accent_device_default_dark_60_percent_opacity), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.accent_device_default_light), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.accent_material_dark), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.accent_material_light), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.accessibility_focus_highlight), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.autofill_background_material_dark), m1546setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.accessibility_focus_highlight), 24.0f), m1546setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.accessibility_focus_highlight), 22.0f), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.autofill_background_material_light), m1546setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.accessibility_focus_highlight), 17.0f), m1546setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.accessibility_focus_highlight), 12.0f), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.autofilled_highlight), m1546setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.accessibility_focus_highlight), 6.0f), m1546setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.accessibility_focus_highlight), 4.0f), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.background_cache_hint_selector_device_default), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.background_cache_hint_selector_holo_dark), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.background_cache_hint_selector_holo_light), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.background_cache_hint_selector_material_dark), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.background_cache_hint_selector_material_light), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.background_device_default_dark), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.background_device_default_light), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.background_floating_device_default_dark), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.background_floating_device_default_light), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.background_floating_material_dark), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.background_floating_material_light), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.background_holo_dark), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.background_holo_light), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.background_leanback_dark), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.background_leanback_light), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.background_material_dark), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.background_material_light), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.bright_foreground_dark), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.bright_foreground_dark_disabled), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.bright_foreground_dark_inverse), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.bright_foreground_disabled_holo_dark), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.bright_foreground_disabled_holo_light), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.bright_foreground_holo_dark), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.bright_foreground_holo_light), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.bright_foreground_inverse_holo_dark), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.bright_foreground_inverse_holo_light), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.bright_foreground_light), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.bright_foreground_light_disabled), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.bright_foreground_light_inverse), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.btn_colored_background_material), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.btn_colored_borderless_text_material), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.btn_colored_text_material), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.btn_default_material_dark), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.btn_default_material_light), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.btn_watch_default_dark), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.button_material_dark), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.button_material_light), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.button_normal_device_default_dark), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_accent), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_accent_dark), null);
    }

    public static final ColorScheme dynamicLightColorScheme(Context context) {
        if (Build.VERSION.SDK_INT >= 34) {
            return dynamicLightColorScheme34(context);
        }
        return dynamicLightColorScheme31(dynamicTonalPalette(context));
    }

    public static final ColorScheme dynamicDarkColorScheme(Context context) {
        if (Build.VERSION.SDK_INT >= 34) {
            return dynamicDarkColorScheme34(context);
        }
        return dynamicDarkColorScheme31(dynamicTonalPalette(context));
    }

    /* renamed from: setLuminance-DxMtmZc, reason: not valid java name */
    public static final long m1546setLuminanceDxMtmZc(long j, float f) {
        double d = f;
        if ((d < 1.0E-4d) | (d > 99.9999d)) {
            int delinearized = delinearized(100 * labInvf((f + 16) / 116));
            return ColorKt.Color$default(delinearized, delinearized, delinearized, 0, 8, null);
        }
        long m3414convertvNxB06k = Color.m3414convertvNxB06k(j, ColorSpaces.INSTANCE.getCieLab());
        return Color.m3414convertvNxB06k(ColorKt.Color$default(f, Color.m3409component2impl(m3414convertvNxB06k), Color.m3410component3impl(m3414convertvNxB06k), 0.0f, ColorSpaces.INSTANCE.getCieLab(), 8, null), ColorSpaces.INSTANCE.getSrgb());
    }

    private static final int delinearized(float f) {
        double d = f / 100;
        return MathUtils.clamp(MathKt.roundToInt((d <= 0.0031308d ? d * 12.92d : (Math.pow(d, 0.4166666666666667d) * 1.055d) - 0.055d) * 255.0d), 0, 255);
    }

    public static final ColorScheme dynamicLightColorScheme31(TonalPalette tonalPalette) {
        long primary40 = tonalPalette.getPrimary40();
        long primary100 = tonalPalette.getPrimary100();
        long primary90 = tonalPalette.getPrimary90();
        long primary10 = tonalPalette.getPrimary10();
        long primary80 = tonalPalette.getPrimary80();
        long secondary40 = tonalPalette.getSecondary40();
        long secondary100 = tonalPalette.getSecondary100();
        long secondary90 = tonalPalette.getSecondary90();
        long secondary10 = tonalPalette.getSecondary10();
        long tertiary40 = tonalPalette.getTertiary40();
        long tertiary100 = tonalPalette.getTertiary100();
        long tertiary90 = tonalPalette.getTertiary90();
        long tertiary10 = tonalPalette.getTertiary10();
        long neutralVariant98 = tonalPalette.getNeutralVariant98();
        long neutralVariant10 = tonalPalette.getNeutralVariant10();
        long neutralVariant982 = tonalPalette.getNeutralVariant98();
        long neutralVariant102 = tonalPalette.getNeutralVariant10();
        long neutralVariant90 = tonalPalette.getNeutralVariant90();
        long neutralVariant30 = tonalPalette.getNeutralVariant30();
        long neutralVariant20 = tonalPalette.getNeutralVariant20();
        long neutralVariant95 = tonalPalette.getNeutralVariant95();
        long neutralVariant50 = tonalPalette.getNeutralVariant50();
        long neutralVariant80 = tonalPalette.getNeutralVariant80();
        long neutralVariant0 = tonalPalette.getNeutralVariant0();
        long neutralVariant983 = tonalPalette.getNeutralVariant98();
        long neutralVariant87 = tonalPalette.getNeutralVariant87();
        return ColorSchemeKt.m1406lightColorSchemeCXl9yA$default(primary40, primary100, primary90, primary10, primary80, secondary40, secondary100, secondary90, secondary10, tertiary40, tertiary100, tertiary90, tertiary10, neutralVariant98, neutralVariant10, neutralVariant982, neutralVariant102, neutralVariant90, neutralVariant30, tonalPalette.getPrimary40(), neutralVariant20, neutralVariant95, 0L, 0L, 0L, 0L, neutralVariant50, neutralVariant80, neutralVariant0, neutralVariant983, tonalPalette.getNeutralVariant94(), tonalPalette.getNeutralVariant92(), tonalPalette.getNeutralVariant90(), tonalPalette.getNeutralVariant96(), tonalPalette.getNeutralVariant100(), neutralVariant87, 62914560, 0, null);
    }

    public static final ColorScheme dynamicLightColorScheme34(Context context) {
        long m1357getColorWaAFU9c = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_action1_dark);
        long m1357getColorWaAFU9c2 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_action1_light);
        long m1357getColorWaAFU9c3 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_accent_light);
        long m1357getColorWaAFU9c4 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_action1);
        long m1357getColorWaAFU9c5 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_cyan_50);
        long m1357getColorWaAFU9c6 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_blue_200);
        long m1357getColorWaAFU9c7 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_blue_300);
        long m1357getColorWaAFU9c8 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_background);
        long m1357getColorWaAFU9c9 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_blue_100);
        long m1357getColorWaAFU9c10 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_blue_500);
        long m1357getColorWaAFU9c11 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_blue_600);
        long m1357getColorWaAFU9c12 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_blue_400);
        long m1357getColorWaAFU9c13 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_blue_50);
        long m1357getColorWaAFU9c14 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_blue_700);
        long m1357getColorWaAFU9c15 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_blue_800);
        long m1357getColorWaAFU9c16 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_blue_900);
        long m1357getColorWaAFU9c17 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_blue_grey_800);
        long m1357getColorWaAFU9c18 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_body3);
        long m1357getColorWaAFU9c19 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_body3_dark);
        long m1357getColorWaAFU9c20 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_green_200);
        long m1357getColorWaAFU9c21 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_green_300);
        long m1357getColorWaAFU9c22 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_body3_light);
        long m1357getColorWaAFU9c23 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_highlight_light);
        long m1357getColorWaAFU9c24 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_body2_dark);
        long m1357getColorWaAFU9c25 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_body2_light);
        return ColorSchemeKt.m1406lightColorSchemeCXl9yA$default(m1357getColorWaAFU9c, m1357getColorWaAFU9c2, m1357getColorWaAFU9c3, m1357getColorWaAFU9c4, m1357getColorWaAFU9c5, m1357getColorWaAFU9c6, m1357getColorWaAFU9c7, m1357getColorWaAFU9c8, m1357getColorWaAFU9c9, m1357getColorWaAFU9c10, m1357getColorWaAFU9c11, m1357getColorWaAFU9c12, m1357getColorWaAFU9c13, m1357getColorWaAFU9c14, m1357getColorWaAFU9c15, m1357getColorWaAFU9c16, m1357getColorWaAFU9c17, m1357getColorWaAFU9c18, m1357getColorWaAFU9c19, ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_action1_dark), m1357getColorWaAFU9c20, m1357getColorWaAFU9c21, 0L, 0L, 0L, 0L, m1357getColorWaAFU9c22, m1357getColorWaAFU9c23, 0L, m1357getColorWaAFU9c24, ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_body1_dark), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_body1_light), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_body2), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_blue_grey_900), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_body1), m1357getColorWaAFU9c25, 331350016, 0, null);
    }

    public static final ColorScheme dynamicDarkColorScheme31(TonalPalette tonalPalette) {
        long primary80 = tonalPalette.getPrimary80();
        long primary20 = tonalPalette.getPrimary20();
        long primary30 = tonalPalette.getPrimary30();
        long primary90 = tonalPalette.getPrimary90();
        long primary40 = tonalPalette.getPrimary40();
        long secondary80 = tonalPalette.getSecondary80();
        long secondary20 = tonalPalette.getSecondary20();
        long secondary30 = tonalPalette.getSecondary30();
        long secondary90 = tonalPalette.getSecondary90();
        long tertiary80 = tonalPalette.getTertiary80();
        long tertiary20 = tonalPalette.getTertiary20();
        long tertiary30 = tonalPalette.getTertiary30();
        long tertiary90 = tonalPalette.getTertiary90();
        long neutralVariant6 = tonalPalette.getNeutralVariant6();
        long neutralVariant90 = tonalPalette.getNeutralVariant90();
        long neutralVariant62 = tonalPalette.getNeutralVariant6();
        long neutralVariant902 = tonalPalette.getNeutralVariant90();
        long neutralVariant30 = tonalPalette.getNeutralVariant30();
        long neutralVariant80 = tonalPalette.getNeutralVariant80();
        long neutralVariant903 = tonalPalette.getNeutralVariant90();
        long neutralVariant20 = tonalPalette.getNeutralVariant20();
        long neutralVariant60 = tonalPalette.getNeutralVariant60();
        long neutralVariant302 = tonalPalette.getNeutralVariant30();
        long neutralVariant0 = tonalPalette.getNeutralVariant0();
        long neutralVariant24 = tonalPalette.getNeutralVariant24();
        long neutralVariant63 = tonalPalette.getNeutralVariant6();
        return ColorSchemeKt.m1402darkColorSchemeCXl9yA$default(primary80, primary20, primary30, primary90, primary40, secondary80, secondary20, secondary30, secondary90, tertiary80, tertiary20, tertiary30, tertiary90, neutralVariant6, neutralVariant90, neutralVariant62, neutralVariant902, neutralVariant30, neutralVariant80, tonalPalette.getPrimary80(), neutralVariant903, neutralVariant20, 0L, 0L, 0L, 0L, neutralVariant60, neutralVariant302, neutralVariant0, neutralVariant24, tonalPalette.getNeutralVariant12(), tonalPalette.getNeutralVariant17(), tonalPalette.getNeutralVariant22(), tonalPalette.getNeutralVariant10(), tonalPalette.getNeutralVariant4(), neutralVariant63, 62914560, 0, null);
    }

    public static final ColorScheme dynamicDarkColorScheme34(Context context) {
        long m1357getColorWaAFU9c = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_cyan_50);
        long m1357getColorWaAFU9c2 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_cyan_500);
        long m1357getColorWaAFU9c3 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_cyan_300);
        long m1357getColorWaAFU9c4 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_cyan_400);
        long m1357getColorWaAFU9c5 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_action1_dark);
        long m1357getColorWaAFU9c6 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_cyan_800);
        long m1357getColorWaAFU9c7 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_cyan_900);
        long m1357getColorWaAFU9c8 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_cyan_600);
        long m1357getColorWaAFU9c9 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_cyan_700);
        long m1357getColorWaAFU9c10 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_dark_blue_grey_700);
        long m1357getColorWaAFU9c11 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_dark_blue_grey_800);
        long m1357getColorWaAFU9c12 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_dark_blue_grey_1000);
        long m1357getColorWaAFU9c13 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_dark_blue_grey_600);
        long m1357getColorWaAFU9c14 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_dark_blue_grey_900);
        long m1357getColorWaAFU9c15 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_green_100);
        long m1357getColorWaAFU9c16 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_green_200);
        long m1357getColorWaAFU9c17 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_green_300);
        long m1357getColorWaAFU9c18 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_grey_100);
        long m1357getColorWaAFU9c19 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_grey_1000);
        long m1357getColorWaAFU9c20 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_blue_900);
        long m1357getColorWaAFU9c21 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_blue_grey_800);
        long m1357getColorWaAFU9c22 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_grey_200);
        long m1357getColorWaAFU9c23 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_keyboard_divider_line);
        long m1357getColorWaAFU9c24 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_green_800);
        long m1357getColorWaAFU9c25 = ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_green_900);
        return ColorSchemeKt.m1402darkColorSchemeCXl9yA$default(m1357getColorWaAFU9c, m1357getColorWaAFU9c2, m1357getColorWaAFU9c3, m1357getColorWaAFU9c4, m1357getColorWaAFU9c5, m1357getColorWaAFU9c6, m1357getColorWaAFU9c7, m1357getColorWaAFU9c8, m1357getColorWaAFU9c9, m1357getColorWaAFU9c10, m1357getColorWaAFU9c11, m1357getColorWaAFU9c12, m1357getColorWaAFU9c13, m1357getColorWaAFU9c14, m1357getColorWaAFU9c15, m1357getColorWaAFU9c16, m1357getColorWaAFU9c17, m1357getColorWaAFU9c18, m1357getColorWaAFU9c19, ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_cyan_50), m1357getColorWaAFU9c20, m1357getColorWaAFU9c21, 0L, 0L, 0L, 0L, m1357getColorWaAFU9c22, m1357getColorWaAFU9c23, 0L, m1357getColorWaAFU9c24, ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_green_500), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_green_600), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_green_700), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_green_400), ColorResourceHelper.INSTANCE.m1357getColorWaAFU9c(context, android.R.color.car_green_50), m1357getColorWaAFU9c25, 331350016, 0, null);
    }
}

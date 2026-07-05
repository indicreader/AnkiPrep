package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.FilledIconButtonTokens;
import androidx.compose.material3.tokens.FilledTonalIconButtonTokens;
import androidx.compose.material3.tokens.IconButtonTokens;
import androidx.compose.material3.tokens.OutlinedIconButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: IconButton.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015JN\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ:\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0015JN\u0010\u001e\u001a\u00020\u00172\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001bJ\r\u0010 \u001a\u00020\nH\u0007¢\u0006\u0002\u0010!J:\u0010 \u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0015JN\u0010#\u001a\u00020\u00172\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010\u001bJ\u0015\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0007¢\u0006\u0002\u0010)J:\u0010*\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010\u0015J\u001f\u0010,\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\u0006\u0010-\u001a\u00020(H\u0007¢\u0006\u0002\u0010.JN\u0010/\u001a\u00020\u00172\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u0010\u001bR\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u00020\n*\u00020\u000b8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"Landroidx/compose/material3/IconButtonDefaults;", "", "()V", "filledShape", "Landroidx/compose/ui/graphics/Shape;", "getFilledShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape", "defaultIconButtonColors", "Landroidx/compose/material3/IconButtonColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultIconButtonColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconButtonColors;", "filledIconButtonColors", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "filledIconButtonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconButtonColors;", "filledIconToggleButtonColors", "Landroidx/compose/material3/IconToggleButtonColors;", "checkedContainerColor", "checkedContentColor", "filledIconToggleButtonColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconToggleButtonColors;", "filledTonalIconButtonColors", "filledTonalIconButtonColors-ro_MJ88", "filledTonalIconToggleButtonColors", "filledTonalIconToggleButtonColors-5tl4gsc", "iconButtonColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconButtonColors;", "iconButtonColors-ro_MJ88", "iconToggleButtonColors", "iconToggleButtonColors-5tl4gsc", "outlinedIconButtonBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconButtonColors", "outlinedIconButtonColors-ro_MJ88", "outlinedIconToggleButtonBorder", "checked", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconToggleButtonColors", "outlinedIconToggleButtonColors-5tl4gsc", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class IconButtonDefaults {
    public static final int $stable = 0;
    public static final IconButtonDefaults INSTANCE = new IconButtonDefaults();

    private IconButtonDefaults() {
    }

    public final Shape getFilledShape(Composer composer, int i) {
        composer.startReplaceableGroup(1265841879);
        ComposerKt.sourceInformation(composer, "C540@26359L5:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1265841879, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-filledShape> (IconButton.kt:540)");
        }
        Shape value = ShapesKt.getValue(FilledIconButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    public final Shape getOutlinedShape(Composer composer, int i) {
        composer.startReplaceableGroup(1327125527);
        ComposerKt.sourceInformation(composer, "C545@26529L5:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1327125527, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-outlinedShape> (IconButton.kt:545)");
        }
        Shape value = ShapesKt.getValue(OutlinedIconButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    public final IconButtonColors iconButtonColors(Composer composer, int i) {
        IconButtonColors m1590copyjRlVdoo;
        composer.startReplaceableGroup(-1519621781);
        ComposerKt.sourceInformation(composer, "C(iconButtonColors)552@26745L11,552@26757L23,553@26826L7:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1519621781, i, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButton.kt:551)");
        }
        IconButtonColors defaultIconButtonColors = getDefaultIconButtonColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i << 3) & 112);
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long m3427unboximpl = ((Color) consume).m3427unboximpl();
        if (Color.m3418equalsimpl0(defaultIconButtonColors.getContentColor(), m3427unboximpl)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return defaultIconButtonColors;
        }
        m1590copyjRlVdoo = defaultIconButtonColors.m1590copyjRlVdoo((r18 & 1) != 0 ? defaultIconButtonColors.containerColor : 0L, (r18 & 2) != 0 ? defaultIconButtonColors.contentColor : m3427unboximpl, (r18 & 4) != 0 ? defaultIconButtonColors.disabledContainerColor : 0L, (r18 & 8) != 0 ? defaultIconButtonColors.disabledContentColor : Color.m3416copywmQWz5c$default(m3427unboximpl, 0.38f, 0.0f, 0.0f, 0.0f, 14, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m1590copyjRlVdoo;
    }

    /* renamed from: iconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m1599iconButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        long j5;
        composer.startReplaceableGroup(999008085);
        ComposerKt.sourceInformation(composer, "C(iconButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)576@27762L7,580@27984L11,580@27996L23:IconButton.kt#uh7d8r");
        long m3453getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m3453getUnspecified0d7_KjU() : j;
        if ((i2 & 2) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            j5 = ((Color) consume).m3427unboximpl();
        } else {
            j5 = j2;
        }
        long m3453getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m3453getUnspecified0d7_KjU() : j3;
        long m3416copywmQWz5c$default = (i2 & 8) != 0 ? Color.m3416copywmQWz5c$default(j5, 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(999008085, i, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButton.kt:580)");
        }
        IconButtonColors m1590copyjRlVdoo = getDefaultIconButtonColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i >> 9) & 112).m1590copyjRlVdoo(m3453getUnspecified0d7_KjU, j5, m3453getUnspecified0d7_KjU2, m3416copywmQWz5c$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m1590copyjRlVdoo;
    }

    public final IconButtonColors getDefaultIconButtonColors(ColorScheme colorScheme, Composer composer, int i) {
        composer.startReplaceableGroup(1437915677);
        ComposerKt.sourceInformation(composer, "C*591@28444L7:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1437915677, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-defaultIconButtonColors> (IconButton.kt:589)");
        }
        IconButtonColors defaultIconButtonColorsCached = colorScheme.getDefaultIconButtonColorsCached();
        if (defaultIconButtonColorsCached == null) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            long m3427unboximpl = ((Color) consume).m3427unboximpl();
            defaultIconButtonColorsCached = new IconButtonColors(Color.INSTANCE.m3452getTransparent0d7_KjU(), m3427unboximpl, Color.INSTANCE.m3452getTransparent0d7_KjU(), Color.m3416copywmQWz5c$default(m3427unboximpl, 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
            colorScheme.setDefaultIconButtonColorsCached$material3_release(defaultIconButtonColorsCached);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultIconButtonColorsCached;
    }

    /* renamed from: iconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m1600iconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        long j7;
        composer.startReplaceableGroup(-2020719549);
        ComposerKt.sourceInformation(composer, "C(iconToggleButtonColors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)618@29723L7,623@30036L5:IconButton.kt#uh7d8r");
        long m3452getTransparent0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m3452getTransparent0d7_KjU() : j;
        if ((i2 & 2) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            j7 = ((Color) consume).m3427unboximpl();
        } else {
            j7 = j2;
        }
        long m3452getTransparent0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m3452getTransparent0d7_KjU() : j3;
        long m3416copywmQWz5c$default = (i2 & 8) != 0 ? Color.m3416copywmQWz5c$default(j7, 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        long m3452getTransparent0d7_KjU3 = (i2 & 16) != 0 ? Color.INSTANCE.m3452getTransparent0d7_KjU() : j5;
        long value = (i2 & 32) != 0 ? ColorSchemeKt.getValue(IconButtonTokens.INSTANCE.getSelectedIconColor(), composer, 6) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2020719549, i, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonColors (IconButton.kt:625)");
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(m3452getTransparent0d7_KjU, j7, m3452getTransparent0d7_KjU2, m3416copywmQWz5c$default, m3452getTransparent0d7_KjU3, value, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconToggleButtonColors;
    }

    /* renamed from: filledIconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m1595filledIconButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-669858473);
        ComposerKt.sourceInformation(composer, "C(filledIconButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)644@31025L5,645@31062L31,646@31181L5,648@31338L5:IconButton.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(FilledIconButtonTokens.INSTANCE.getContainerColor(), composer, 6) : j;
        long m1400contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m1400contentColorForek8zF_U(value, composer, i & 14) : j2;
        long m3416copywmQWz5c$default = (i2 & 4) != 0 ? Color.m3416copywmQWz5c$default(ColorSchemeKt.getValue(FilledIconButtonTokens.INSTANCE.getDisabledContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long m3416copywmQWz5c$default2 = (i2 & 8) != 0 ? Color.m3416copywmQWz5c$default(ColorSchemeKt.getValue(FilledIconButtonTokens.INSTANCE.getDisabledColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-669858473, i, -1, "androidx.compose.material3.IconButtonDefaults.filledIconButtonColors (IconButton.kt:651)");
        }
        IconButtonColors iconButtonColors = new IconButtonColors(value, m1400contentColorForek8zF_U, m3416copywmQWz5c$default, m3416copywmQWz5c$default2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconButtonColors;
    }

    /* renamed from: filledIconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m1596filledIconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1887173701);
        ComposerKt.sourceInformation(composer, "C(filledIconToggleButtonColors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)671@32478L5,674@32693L5,675@32786L5,677@32943L5,679@33101L5,680@33145L38:IconButton.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(FilledIconButtonTokens.INSTANCE.getUnselectedContainerColor(), composer, 6) : j;
        long value2 = (i2 & 2) != 0 ? ColorSchemeKt.getValue(FilledIconButtonTokens.INSTANCE.getToggleUnselectedColor(), composer, 6) : j2;
        long m3416copywmQWz5c$default = (i2 & 4) != 0 ? Color.m3416copywmQWz5c$default(ColorSchemeKt.getValue(FilledIconButtonTokens.INSTANCE.getDisabledContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long m3416copywmQWz5c$default2 = (i2 & 8) != 0 ? Color.m3416copywmQWz5c$default(ColorSchemeKt.getValue(FilledIconButtonTokens.INSTANCE.getDisabledColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        long value3 = (i2 & 16) != 0 ? ColorSchemeKt.getValue(FilledIconButtonTokens.INSTANCE.getSelectedContainerColor(), composer, 6) : j5;
        long m1400contentColorForek8zF_U = (i2 & 32) != 0 ? ColorSchemeKt.m1400contentColorForek8zF_U(value3, composer, (i >> 12) & 14) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1887173701, i, -1, "androidx.compose.material3.IconButtonDefaults.filledIconToggleButtonColors (IconButton.kt:682)");
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(value, value2, m3416copywmQWz5c$default, m3416copywmQWz5c$default2, value3, m1400contentColorForek8zF_U, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconToggleButtonColors;
    }

    /* renamed from: filledTonalIconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m1597filledTonalIconButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-18532843);
        ComposerKt.sourceInformation(composer, "C(filledTonalIconButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)702@34189L5,703@34226L31,704@34350L5,706@34517L5:IconButton.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(FilledTonalIconButtonTokens.INSTANCE.getContainerColor(), composer, 6) : j;
        long m1400contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m1400contentColorForek8zF_U(value, composer, i & 14) : j2;
        long m3416copywmQWz5c$default = (i2 & 4) != 0 ? Color.m3416copywmQWz5c$default(ColorSchemeKt.getValue(FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long m3416copywmQWz5c$default2 = (i2 & 8) != 0 ? Color.m3416copywmQWz5c$default(ColorSchemeKt.getValue(FilledTonalIconButtonTokens.INSTANCE.getDisabledColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-18532843, i, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconButtonColors (IconButton.kt:709)");
        }
        IconButtonColors iconButtonColors = new IconButtonColors(value, m1400contentColorForek8zF_U, m3416copywmQWz5c$default, m3416copywmQWz5c$default2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconButtonColors;
    }

    /* renamed from: filledTonalIconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m1598filledTonalIconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-19426557);
        ComposerKt.sourceInformation(composer, "C(filledTonalIconToggleButtonColors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)729@35677L5,730@35714L31,731@35838L5,733@36005L5,736@36185L5,737@36277L5:IconButton.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(FilledTonalIconButtonTokens.INSTANCE.getUnselectedContainerColor(), composer, 6) : j;
        long m1400contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m1400contentColorForek8zF_U(value, composer, i & 14) : j2;
        long m3416copywmQWz5c$default = (i2 & 4) != 0 ? Color.m3416copywmQWz5c$default(ColorSchemeKt.getValue(FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long m3416copywmQWz5c$default2 = (i2 & 8) != 0 ? Color.m3416copywmQWz5c$default(ColorSchemeKt.getValue(FilledTonalIconButtonTokens.INSTANCE.getDisabledColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        long value2 = (i2 & 16) != 0 ? ColorSchemeKt.getValue(FilledTonalIconButtonTokens.INSTANCE.getSelectedContainerColor(), composer, 6) : j5;
        long value3 = (i2 & 32) != 0 ? ColorSchemeKt.getValue(FilledTonalIconButtonTokens.INSTANCE.getToggleSelectedColor(), composer, 6) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-19426557, i, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconToggleButtonColors (IconButton.kt:739)");
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(value, m1400contentColorForek8zF_U, m3416copywmQWz5c$default, m3416copywmQWz5c$default2, value2, value3, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconToggleButtonColors;
    }

    /* renamed from: outlinedIconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m1601outlinedIconButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        long j5;
        composer.startReplaceableGroup(-1030517545);
        ComposerKt.sourceInformation(composer, "C(outlinedIconButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)760@37306L7:IconButton.kt#uh7d8r");
        long m3452getTransparent0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m3452getTransparent0d7_KjU() : j;
        if ((i2 & 2) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            j5 = ((Color) consume).m3427unboximpl();
        } else {
            j5 = j2;
        }
        long m3452getTransparent0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m3452getTransparent0d7_KjU() : j3;
        long m3416copywmQWz5c$default = (i2 & 8) != 0 ? Color.m3416copywmQWz5c$default(j5, 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1030517545, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonColors (IconButton.kt:765)");
        }
        IconButtonColors iconButtonColors = new IconButtonColors(m3452getTransparent0d7_KjU, j5, m3452getTransparent0d7_KjU2, m3416copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconButtonColors;
    }

    /* renamed from: outlinedIconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m1602outlinedIconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        long j7;
        composer.startReplaceableGroup(2130592709);
        ComposerKt.sourceInformation(composer, "C(outlinedIconToggleButtonColors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)786@38583L7,791@38869L5,792@38913L38:IconButton.kt#uh7d8r");
        long m3452getTransparent0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m3452getTransparent0d7_KjU() : j;
        if ((i2 & 2) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            j7 = ((Color) consume).m3427unboximpl();
        } else {
            j7 = j2;
        }
        long m3452getTransparent0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m3452getTransparent0d7_KjU() : j3;
        long m3416copywmQWz5c$default = (i2 & 8) != 0 ? Color.m3416copywmQWz5c$default(j7, 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        long value = (i2 & 16) != 0 ? ColorSchemeKt.getValue(OutlinedIconButtonTokens.INSTANCE.getSelectedContainerColor(), composer, 6) : j5;
        long m1400contentColorForek8zF_U = (i2 & 32) != 0 ? ColorSchemeKt.m1400contentColorForek8zF_U(value, composer, (i >> 12) & 14) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2130592709, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonColors (IconButton.kt:794)");
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(m3452getTransparent0d7_KjU, j7, m3452getTransparent0d7_KjU2, m3416copywmQWz5c$default, value, m1400contentColorForek8zF_U, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconToggleButtonColors;
    }

    public final BorderStroke outlinedIconToggleButtonBorder(boolean z, boolean z2, Composer composer, int i) {
        composer.startReplaceableGroup(1244729690);
        ComposerKt.sourceInformation(composer, "C(outlinedIconToggleButtonBorder)P(1)815@39783L33:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1244729690, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonBorder (IconButton.kt:811)");
        }
        if (z2) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return null;
        }
        BorderStroke outlinedIconButtonBorder = outlinedIconButtonBorder(z, composer, (i & 14) | ((i >> 3) & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return outlinedIconButtonBorder;
    }

    public final BorderStroke outlinedIconButtonBorder(boolean z, Composer composer, int i) {
        long m3416copywmQWz5c$default;
        composer.startReplaceableGroup(-511461558);
        ComposerKt.sourceInformation(composer, "C(outlinedIconButtonBorder)831@40336L108:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-511461558, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonBorder (IconButton.kt:824)");
        }
        if (z) {
            composer.startReplaceableGroup(1252616568);
            ComposerKt.sourceInformation(composer, "826@40159L7");
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            m3416copywmQWz5c$default = ((Color) consume).m3427unboximpl();
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1252616623);
            ComposerKt.sourceInformation(composer, "828@40214L7");
            ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(localContentColor2);
            ComposerKt.sourceInformationMarkerEnd(composer);
            m3416copywmQWz5c$default = Color.m3416copywmQWz5c$default(((Color) consume2).m3427unboximpl(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
            composer.endReplaceableGroup();
        }
        composer.startReplaceableGroup(1252616777);
        ComposerKt.sourceInformation(composer, "CC(remember):IconButton.kt#9igjgp");
        boolean changed = composer.changed(m3416copywmQWz5c$default);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = BorderStrokeKt.m244BorderStrokecXLIe8U(OutlinedIconButtonTokens.INSTANCE.m2670getUnselectedOutlineWidthD9Ej5fM(), m3416copywmQWz5c$default);
            composer.updateRememberedValue(rememberedValue);
        }
        BorderStroke borderStroke = (BorderStroke) rememberedValue;
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return borderStroke;
    }
}

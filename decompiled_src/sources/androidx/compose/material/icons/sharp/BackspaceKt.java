package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* compiled from: Backspace.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"_backspace", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Backspace", "Landroidx/compose/material/icons/Icons$Sharp;", "getBackspace$annotations", "(Landroidx/compose/material/icons/Icons$Sharp;)V", "getBackspace", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BackspaceKt {
    private static ImageVector _backspace;

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Sharp.Backspace", replaceWith = @ReplaceWith(expression = "Icons.AutoMirrored.Sharp.Backspace", imports = {"androidx.compose.material.icons.automirrored.sharp.Backspace"}))
    public static /* synthetic */ void getBackspace$annotations(Icons.Sharp sharp) {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getBackspace(androidx.compose.material.icons.Icons.Sharp r30) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.sharp.BackspaceKt._backspace
            if (r0 == 0) goto L8
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        L8:
            java.lang.String r2 = "Sharp.Backspace"
            r10 = 0
            androidx.compose.ui.graphics.vector.ImageVector$Builder r1 = new androidx.compose.ui.graphics.vector.ImageVector$Builder
            r13 = r1
            r0 = 1103101952(0x41c00000, float:24.0)
            float r3 = androidx.compose.ui.unit.Dp.m5738constructorimpl(r0)
            float r4 = androidx.compose.ui.unit.Dp.m5738constructorimpl(r0)
            r5 = 1103101952(0x41c00000, float:24.0)
            r6 = 1103101952(0x41c00000, float:24.0)
            r7 = 0
            r9 = 0
            r11 = 96
            r12 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7, r9, r10, r11, r12)
            r18 = 1065353216(0x3f800000, float:1.0)
            r20 = 1065353216(0x3f800000, float:1.0)
            int r15 = androidx.compose.ui.graphics.vector.VectorKt.getDefaultFillType()
            androidx.compose.ui.graphics.SolidColor r1 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.INSTANCE
            long r2 = r2.m3443getBlack0d7_KjU()
            r4 = 0
            r1.<init>(r2, r4)
            r17 = r1
            androidx.compose.ui.graphics.Brush r17 = (androidx.compose.ui.graphics.Brush) r17
            r19 = 0
            r21 = 1065353216(0x3f800000, float:1.0)
            androidx.compose.ui.graphics.StrokeCap$Companion r1 = androidx.compose.ui.graphics.StrokeCap.INSTANCE
            int r22 = r1.m3769getButtKaPHkGw()
            androidx.compose.ui.graphics.StrokeJoin$Companion r1 = androidx.compose.ui.graphics.StrokeJoin.INSTANCE
            int r23 = r1.m3779getBevelLxFBmk8()
            r24 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r16 = ""
            androidx.compose.ui.graphics.vector.PathBuilder r1 = new androidx.compose.ui.graphics.vector.PathBuilder
            r1.<init>()
            r2 = 1077936128(0x40400000, float:3.0)
            r1.moveTo(r0, r2)
            r3 = 1086324736(0x40c00000, float:6.0)
            r1.lineTo(r3, r2)
            r4 = -1061158912(0xffffffffc0c00000, float:-6.0)
            r5 = 1091567616(0x41100000, float:9.0)
            r1.lineToRelative(r4, r5)
            r1.lineToRelative(r3, r5)
            r3 = 1099956224(0x41900000, float:18.0)
            r1.horizontalLineToRelative(r3)
            r1.lineTo(r0, r2)
            r1.close()
            r0 = 1100480512(0x41980000, float:19.0)
            r2 = 1098477732(0x417970a4, float:15.59)
            r1.moveTo(r0, r2)
            r3 = 1099741266(0x418cb852, float:17.59)
            r4 = 1099431936(0x41880000, float:17.0)
            r1.lineTo(r3, r4)
            r6 = 1096191836(0x41568f5c, float:13.41)
            r7 = 1096810496(0x41600000, float:14.0)
            r1.lineTo(r7, r6)
            r6 = 1093046108(0x41268f5c, float:10.41)
            r1.lineTo(r6, r4)
            r1.lineTo(r5, r2)
            r4 = 1095332004(0x414970a4, float:12.59)
            r8 = 1094713344(0x41400000, float:12.0)
            r1.lineTo(r4, r8)
            r4 = 1090948956(0x41068f5c, float:8.41)
            r1.lineTo(r5, r4)
            r5 = 1088421888(0x40e00000, float:7.0)
            r1.lineTo(r6, r5)
            r6 = 1093234852(0x412970a4, float:10.59)
            r1.lineTo(r7, r6)
            r1.lineTo(r3, r5)
            r1.lineTo(r0, r4)
            r3 = 1098288988(0x41768f5c, float:15.41)
            r1.lineTo(r3, r8)
            r1.lineTo(r0, r2)
            r1.close()
            java.util.List r14 = r1.getNodes()
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 14336(0x3800, float:2.0089E-41)
            r29 = 0
            androidx.compose.ui.graphics.vector.ImageVector$Builder r0 = androidx.compose.ui.graphics.vector.ImageVector.Builder.m4050addPathoIyEayM$default(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            androidx.compose.ui.graphics.vector.ImageVector r0 = r0.build()
            androidx.compose.material.icons.sharp.BackspaceKt._backspace = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.sharp.BackspaceKt.getBackspace(androidx.compose.material.icons.Icons$Sharp):androidx.compose.ui.graphics.vector.ImageVector");
    }
}

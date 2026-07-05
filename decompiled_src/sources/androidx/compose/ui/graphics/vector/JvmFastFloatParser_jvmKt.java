package androidx.compose.ui.graphics.vector;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: JvmFastFloatParser.jvm.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0080\b\u001a\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0006H\u0080\b¨\u0006\u0007"}, d2 = {"doubleFromBits", "", "bits", "", "floatFromBits", "", "", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class JvmFastFloatParser_jvmKt {
    public static final float floatFromBits(int i) {
        return Float.intBitsToFloat(i);
    }

    public static final double doubleFromBits(long j) {
        return Double.longBitsToDouble(j);
    }
}

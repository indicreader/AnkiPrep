package androidx.compose.foundation.text2.input.internal;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: OffsetMappingCalculator.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J%\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0011J=\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007R\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/OffsetMappingCalculator;", "", "()V", "ops", "Landroidx/compose/foundation/text2/input/internal/OpArray;", "[I", "opsSize", "", "map", "Landroidx/compose/ui/text/TextRange;", "offset", "fromSource", "", "map-fzxv0v0", "(IZ)J", "mapFromDest", "mapFromDest--jx7JFs", "(I)J", "mapFromSource", "mapFromSource--jx7JFs", "mapStep", "opOffset", "untransformedLen", "transformedLen", "mapStep-C6u-MEY", "(IIIIZ)J", "recordEditOperation", "", "sourceStart", "sourceEnd", "newLength", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class OffsetMappingCalculator {
    public static final int $stable = 8;
    private int[] ops = OpArray.m1120constructorimpl(10);
    private int opsSize;

    public final void recordEditOperation(int sourceStart, int sourceEnd, int newLength) {
        if (newLength < 0) {
            throw new IllegalArgumentException(("Expected newLen to be ≥ 0, was " + newLength).toString());
        }
        int min = Math.min(sourceStart, sourceEnd);
        int max = Math.max(min, sourceEnd) - min;
        if (max >= 2 || max != newLength) {
            int i = this.opsSize + 1;
            if (i > OpArray.m1127getSizeimpl(this.ops)) {
                this.ops = OpArray.m1122copyOfS4kM8k(this.ops, Math.max(i * 2, OpArray.m1127getSizeimpl(this.ops) * 2));
            }
            OpArray.m1129setimpl(this.ops, this.opsSize, min, max, newLength);
            this.opsSize = i;
        }
    }

    /* renamed from: mapFromSource--jx7JFs, reason: not valid java name */
    public final long m1118mapFromSourcejx7JFs(int offset) {
        return m1115mapfzxv0v0(offset, true);
    }

    /* renamed from: mapFromDest--jx7JFs, reason: not valid java name */
    public final long m1117mapFromDestjx7JFs(int offset) {
        return m1115mapfzxv0v0(offset, false);
    }

    /* renamed from: mapStep-C6u-MEY, reason: not valid java name */
    private final long m1116mapStepC6uMEY(int offset, int opOffset, int untransformedLen, int transformedLen, boolean fromSource) {
        int i = fromSource ? untransformedLen : transformedLen;
        if (fromSource) {
            untransformedLen = transformedLen;
        }
        if (offset < opOffset) {
            return TextRangeKt.TextRange(offset);
        }
        if (offset == opOffset) {
            if (i == 0) {
                return TextRangeKt.TextRange(opOffset, untransformedLen + opOffset);
            }
            return TextRangeKt.TextRange(opOffset);
        }
        if (offset >= opOffset + i) {
            return TextRangeKt.TextRange((offset - i) + untransformedLen);
        }
        if (untransformedLen == 0) {
            return TextRangeKt.TextRange(opOffset);
        }
        return TextRangeKt.TextRange(opOffset, untransformedLen + opOffset);
    }

    /* renamed from: map-fzxv0v0, reason: not valid java name */
    private final long m1115mapfzxv0v0(int offset, boolean fromSource) {
        int i;
        int[] iArr = this.ops;
        int i2 = this.opsSize;
        boolean z = !fromSource;
        if (i2 < 0) {
            i = offset;
        } else if (z) {
            int i3 = i2 - 1;
            int i4 = offset;
            while (-1 < i3) {
                int i5 = i3 * 3;
                int i6 = iArr[i5];
                int i7 = iArr[i5 + 1];
                int i8 = iArr[i5 + 2];
                long m1116mapStepC6uMEY = m1116mapStepC6uMEY(i4, i6, i7, i8, fromSource);
                long m1116mapStepC6uMEY2 = m1116mapStepC6uMEY(offset, i6, i7, i8, fromSource);
                i3--;
                i4 = Math.min(TextRange.m5238getStartimpl(m1116mapStepC6uMEY), TextRange.m5238getStartimpl(m1116mapStepC6uMEY2));
                offset = Math.max(TextRange.m5233getEndimpl(m1116mapStepC6uMEY), TextRange.m5233getEndimpl(m1116mapStepC6uMEY2));
            }
            i = offset;
            offset = i4;
        } else {
            int i9 = 0;
            int i10 = offset;
            while (i9 < i2) {
                int i11 = i9 * 3;
                int i12 = iArr[i11];
                int i13 = iArr[i11 + 1];
                int i14 = iArr[i11 + 2];
                long m1116mapStepC6uMEY3 = m1116mapStepC6uMEY(i10, i12, i13, i14, fromSource);
                long m1116mapStepC6uMEY4 = m1116mapStepC6uMEY(offset, i12, i13, i14, fromSource);
                i9++;
                i10 = Math.min(TextRange.m5238getStartimpl(m1116mapStepC6uMEY3), TextRange.m5238getStartimpl(m1116mapStepC6uMEY4));
                offset = Math.max(TextRange.m5233getEndimpl(m1116mapStepC6uMEY3), TextRange.m5233getEndimpl(m1116mapStepC6uMEY4));
            }
            i = offset;
            offset = i10;
        }
        return TextRangeKt.TextRange(offset, i);
    }
}

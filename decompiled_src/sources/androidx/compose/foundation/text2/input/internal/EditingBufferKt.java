package androidx.compose.foundation.text2.input.internal;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: EditingBuffer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", "target", "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m1114updateRangeAfterDeletepWDy79M(long j, long j2) {
        int m5234getLengthimpl;
        int m5236getMinimpl = TextRange.m5236getMinimpl(j);
        int m5235getMaximpl = TextRange.m5235getMaximpl(j);
        if (TextRange.m5240intersects5zctL8(j2, j)) {
            if (TextRange.m5228contains5zctL8(j2, j)) {
                m5236getMinimpl = TextRange.m5236getMinimpl(j2);
                m5235getMaximpl = m5236getMinimpl;
            } else {
                if (TextRange.m5228contains5zctL8(j, j2)) {
                    m5234getLengthimpl = TextRange.m5234getLengthimpl(j2);
                } else if (TextRange.m5229containsimpl(j2, m5236getMinimpl)) {
                    m5236getMinimpl = TextRange.m5236getMinimpl(j2);
                    m5234getLengthimpl = TextRange.m5234getLengthimpl(j2);
                } else {
                    m5235getMaximpl = TextRange.m5236getMinimpl(j2);
                }
                m5235getMaximpl -= m5234getLengthimpl;
            }
        } else if (m5235getMaximpl > TextRange.m5236getMinimpl(j2)) {
            m5236getMinimpl -= TextRange.m5234getLengthimpl(j2);
            m5234getLengthimpl = TextRange.m5234getLengthimpl(j2);
            m5235getMaximpl -= m5234getLengthimpl;
        }
        return TextRangeKt.TextRange(m5236getMinimpl, m5235getMaximpl);
    }
}

package androidx.compose.foundation.text2.input;

import androidx.compose.foundation.text2.input.internal.ToCharArray_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TextFieldCharSequence.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0013\u0010\u0016\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0096\u0002J\b\u0010\u001b\u001a\u00020\fH\u0016J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0016J&\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fJ\b\u0010&\u001a\u00020'H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u0005X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Landroidx/compose/foundation/text2/input/TextFieldCharSequenceWrapper;", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "(Ljava/lang/CharSequence;JLandroidx/compose/ui/text/TextRange;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "compositionInChars", "getCompositionInChars-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "length", "", "getLength", "()I", "selectionInChars", "getSelectionInChars-d9O1mEE", "()J", "J", "contentEquals", "", "other", "equals", "", "get", "", "index", "hashCode", "subSequence", "startIndex", "endIndex", "toCharArray", "", "destination", "", "destinationOffset", "sourceStartIndex", "sourceEndIndex", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class TextFieldCharSequenceWrapper implements TextFieldCharSequence {
    private final TextRange compositionInChars;
    private final long selectionInChars;
    private final CharSequence text;

    public /* synthetic */ TextFieldCharSequenceWrapper(CharSequence charSequence, long j, TextRange textRange, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, j, textRange);
    }

    @Override // androidx.compose.foundation.text2.input.TextFieldCharSequence
    /* renamed from: getCompositionInChars-MzsxiRA, reason: from getter */
    public TextRange getCompositionInChars() {
        return this.compositionInChars;
    }

    @Override // androidx.compose.foundation.text2.input.TextFieldCharSequence
    /* renamed from: getSelectionInChars-d9O1mEE, reason: from getter */
    public long getSelectionInChars() {
        return this.selectionInChars;
    }

    private TextFieldCharSequenceWrapper(CharSequence charSequence, long j, TextRange textRange) {
        this.text = charSequence;
        this.selectionInChars = TextRangeKt.m5244coerceIn8ffj60Q(j, 0, charSequence.length());
        this.compositionInChars = textRange != null ? TextRange.m5226boximpl(TextRangeKt.m5244coerceIn8ffj60Q(textRange.getPackedValue(), 0, charSequence.length())) : null;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    public int getLength() {
        return this.text.length();
    }

    public char get(int index) {
        return this.text.charAt(index);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int startIndex, int endIndex) {
        return this.text.subSequence(startIndex, endIndex);
    }

    @Override // androidx.compose.foundation.text2.input.TextFieldCharSequence, java.lang.CharSequence
    public String toString() {
        return this.text.toString();
    }

    @Override // androidx.compose.foundation.text2.input.TextFieldCharSequence
    public boolean contentEquals(CharSequence other) {
        return StringsKt.contentEquals(this.text, other);
    }

    public final void toCharArray(char[] destination, int destinationOffset, int sourceStartIndex, int sourceEndIndex) {
        ToCharArray_androidKt.toCharArray(this.text, destination, destinationOffset, sourceStartIndex, sourceEndIndex);
    }

    @Override // androidx.compose.foundation.text2.input.TextFieldCharSequence
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        TextFieldCharSequenceWrapper textFieldCharSequenceWrapper = (TextFieldCharSequenceWrapper) other;
        return TextRange.m5231equalsimpl0(getSelectionInChars(), textFieldCharSequenceWrapper.getSelectionInChars()) && Intrinsics.areEqual(getCompositionInChars(), textFieldCharSequenceWrapper.getCompositionInChars()) && contentEquals(textFieldCharSequenceWrapper.text);
    }

    @Override // androidx.compose.foundation.text2.input.TextFieldCharSequence
    public int hashCode() {
        int hashCode = ((this.text.hashCode() * 31) + TextRange.m5239hashCodeimpl(getSelectionInChars())) * 31;
        TextRange compositionInChars = getCompositionInChars();
        return hashCode + (compositionInChars != null ? TextRange.m5239hashCodeimpl(compositionInChars.getPackedValue()) : 0);
    }
}

package androidx.compose.ui.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.style.IndentationFixSpan;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: AndroidParagraph.android.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\n\u001a\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\n\u001a\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\n\u001a\u001a\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\n\u001a\f\u0010\u001b\u001a\u00020\u001c*\u00020\u001cH\u0002\u001a\u0014\u0010\u001d\u001a\u00020\u0006*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"shouldAttachIndentationFixSpan", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "ellipsis", "toLayoutAlign", "", "align", "Landroidx/compose/ui/text/style/TextAlign;", "toLayoutAlign-aXe7zB0", "(I)I", "toLayoutBreakStrategy", "breakStrategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "toLayoutBreakStrategy-xImikfE", "toLayoutHyphenationFrequency", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "toLayoutHyphenationFrequency--3fSNIE", "toLayoutLineBreakStyle", "lineBreakStrictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "toLayoutLineBreakStyle-hpcqdu8", "toLayoutLineBreakWordStyle", "lineBreakWordStyle", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "toLayoutLineBreakWordStyle-wPN0Rpw", "attachIndentationFixSpan", "", "numberOfLinesThatFitMaxHeight", "Landroidx/compose/ui/text/android/TextLayout;", "maxHeight", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class AndroidParagraph_androidKt {
    public static final /* synthetic */ CharSequence access$attachIndentationFixSpan(CharSequence charSequence) {
        return attachIndentationFixSpan(charSequence);
    }

    public static final /* synthetic */ int access$numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i) {
        return numberOfLinesThatFitMaxHeight(textLayout, i);
    }

    public static final /* synthetic */ boolean access$shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z) {
        return shouldAttachIndentationFixSpan(textStyle, z);
    }

    /* renamed from: access$toLayoutAlign-aXe7zB0, reason: not valid java name */
    public static final /* synthetic */ int m5091access$toLayoutAlignaXe7zB0(int i) {
        return m5096toLayoutAlignaXe7zB0(i);
    }

    /* renamed from: access$toLayoutBreakStrategy-xImikfE, reason: not valid java name */
    public static final /* synthetic */ int m5092access$toLayoutBreakStrategyxImikfE(int i) {
        return m5097toLayoutBreakStrategyxImikfE(i);
    }

    /* renamed from: access$toLayoutHyphenationFrequency--3fSNIE, reason: not valid java name */
    public static final /* synthetic */ int m5093access$toLayoutHyphenationFrequency3fSNIE(int i) {
        return m5098toLayoutHyphenationFrequency3fSNIE(i);
    }

    /* renamed from: access$toLayoutLineBreakStyle-hpcqdu8, reason: not valid java name */
    public static final /* synthetic */ int m5094access$toLayoutLineBreakStylehpcqdu8(int i) {
        return m5099toLayoutLineBreakStylehpcqdu8(i);
    }

    /* renamed from: access$toLayoutLineBreakWordStyle-wPN0Rpw, reason: not valid java name */
    public static final /* synthetic */ int m5095access$toLayoutLineBreakWordStylewPN0Rpw(int i) {
        return m5100toLayoutLineBreakWordStylewPN0Rpw(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutAlign-aXe7zB0, reason: not valid java name */
    public static final int m5096toLayoutAlignaXe7zB0(int i) {
        if (TextAlign.m5626equalsimpl0(i, TextAlign.INSTANCE.m5633getLefte0LSkKk())) {
            return 3;
        }
        if (TextAlign.m5626equalsimpl0(i, TextAlign.INSTANCE.m5634getRighte0LSkKk())) {
            return 4;
        }
        if (TextAlign.m5626equalsimpl0(i, TextAlign.INSTANCE.m5630getCentere0LSkKk())) {
            return 2;
        }
        return (!TextAlign.m5626equalsimpl0(i, TextAlign.INSTANCE.m5635getStarte0LSkKk()) && TextAlign.m5626equalsimpl0(i, TextAlign.INSTANCE.m5631getEnde0LSkKk())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutHyphenationFrequency--3fSNIE, reason: not valid java name */
    public static final int m5098toLayoutHyphenationFrequency3fSNIE(int i) {
        if (Hyphens.m5536equalsimpl0(i, Hyphens.INSTANCE.m5540getAutovmbZdU8())) {
            return Build.VERSION.SDK_INT <= 32 ? 2 : 4;
        }
        Hyphens.m5536equalsimpl0(i, Hyphens.INSTANCE.m5541getNonevmbZdU8());
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutBreakStrategy-xImikfE, reason: not valid java name */
    public static final int m5097toLayoutBreakStrategyxImikfE(int i) {
        if (LineBreak.Strategy.m5567equalsimpl0(i, LineBreak.Strategy.INSTANCE.m5573getSimplefcGXIks())) {
            return 0;
        }
        if (LineBreak.Strategy.m5567equalsimpl0(i, LineBreak.Strategy.INSTANCE.m5572getHighQualityfcGXIks())) {
            return 1;
        }
        return LineBreak.Strategy.m5567equalsimpl0(i, LineBreak.Strategy.INSTANCE.m5571getBalancedfcGXIks()) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakStyle-hpcqdu8, reason: not valid java name */
    public static final int m5099toLayoutLineBreakStylehpcqdu8(int i) {
        if (LineBreak.Strictness.m5578equalsimpl0(i, LineBreak.Strictness.INSTANCE.m5582getDefaultusljTpc())) {
            return 0;
        }
        if (LineBreak.Strictness.m5578equalsimpl0(i, LineBreak.Strictness.INSTANCE.m5583getLooseusljTpc())) {
            return 1;
        }
        if (LineBreak.Strictness.m5578equalsimpl0(i, LineBreak.Strictness.INSTANCE.m5584getNormalusljTpc())) {
            return 2;
        }
        return LineBreak.Strictness.m5578equalsimpl0(i, LineBreak.Strictness.INSTANCE.m5585getStrictusljTpc()) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakWordStyle-wPN0Rpw, reason: not valid java name */
    public static final int m5100toLayoutLineBreakWordStylewPN0Rpw(int i) {
        return (!LineBreak.WordBreak.m5590equalsimpl0(i, LineBreak.WordBreak.INSTANCE.m5594getDefaultjp8hJ3c()) && LineBreak.WordBreak.m5590equalsimpl0(i, LineBreak.WordBreak.INSTANCE.m5595getPhrasejp8hJ3c())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i) {
        int lineCount = textLayout.getLineCount();
        for (int i2 = 0; i2 < lineCount; i2++) {
            if (textLayout.getLineBottom(i2) > i) {
                return i2;
            }
        }
        return textLayout.getLineCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z) {
        return (!z || TextUnit.m5926equalsimpl0(textStyle.m5274getLetterSpacingXSAIIZE(), TextUnitKt.getSp(0)) || TextUnit.m5926equalsimpl0(textStyle.m5274getLetterSpacingXSAIIZE(), TextUnit.INSTANCE.m5940getUnspecifiedXSAIIZE()) || TextAlign.m5626equalsimpl0(textStyle.m5279getTextAligne0LSkKk(), TextAlign.INSTANCE.m5636getUnspecifiede0LSkKk()) || TextAlign.m5626equalsimpl0(textStyle.m5279getTextAligne0LSkKk(), TextAlign.INSTANCE.m5635getStarte0LSkKk()) || TextAlign.m5626equalsimpl0(textStyle.m5279getTextAligne0LSkKk(), TextAlign.INSTANCE.m5632getJustifye0LSkKk())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence attachIndentationFixSpan(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return charSequence;
        }
        SpannableString spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
        SpannableExtensions_androidKt.setSpan(spannableString, new IndentationFixSpan(), spannableString.length() - 1, spannableString.length() - 1);
        return spannableString;
    }
}

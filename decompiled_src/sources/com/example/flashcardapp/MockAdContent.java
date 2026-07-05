package com.example.flashcardapp;

import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0016\u0010\u001f\u001a\u00020\nHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u000fJ\u0016\u0010!\u001a\u00020\nHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u000fJ\u0016\u0010#\u001a\u00020\nHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010\u000fJi\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\f\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0019\u0010\u000b\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0016\u0010\u000fR\u0019\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, d2 = {"Lcom/example/flashcardapp/MockAdContent;", "", "emoji", "", "title", "subtitle", "benefits", "", "ctaLabel", "gradientStart", "Landroidx/compose/ui/graphics/Color;", "gradientEnd", "accentColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAccentColor-0d7_KjU", "()J", "J", "getBenefits", "()Ljava/util/List;", "getCtaLabel", "()Ljava/lang/String;", "getEmoji", "getGradientEnd-0d7_KjU", "getGradientStart-0d7_KjU", "getSubtitle", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component6-0d7_KjU", "component7", "component7-0d7_KjU", "component8", "component8-0d7_KjU", "copy", "copy-xKDoepM", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;JJJ)Lcom/example/flashcardapp/MockAdContent;", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
final /* data */ class MockAdContent {
    private final long accentColor;
    private final List<String> benefits;
    private final String ctaLabel;
    private final String emoji;
    private final long gradientEnd;
    private final long gradientStart;
    private final String subtitle;
    private final String title;

    public /* synthetic */ MockAdContent(String str, String str2, String str3, List list, String str4, long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, list, str4, j, j2, j3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEmoji() {
        return this.emoji;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    public final List<String> component4() {
        return this.benefits;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCtaLabel() {
        return this.ctaLabel;
    }

    /* renamed from: component6-0d7_KjU, reason: not valid java name and from getter */
    public final long getGradientStart() {
        return this.gradientStart;
    }

    /* renamed from: component7-0d7_KjU, reason: not valid java name and from getter */
    public final long getGradientEnd() {
        return this.gradientEnd;
    }

    /* renamed from: component8-0d7_KjU, reason: not valid java name and from getter */
    public final long getAccentColor() {
        return this.accentColor;
    }

    /* renamed from: copy-xKDoepM, reason: not valid java name */
    public final MockAdContent m6113copyxKDoepM(String emoji, String title, String subtitle, List<String> benefits, String ctaLabel, long gradientStart, long gradientEnd, long accentColor) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(benefits, "benefits");
        Intrinsics.checkNotNullParameter(ctaLabel, "ctaLabel");
        return new MockAdContent(emoji, title, subtitle, benefits, ctaLabel, gradientStart, gradientEnd, accentColor, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MockAdContent)) {
            return false;
        }
        MockAdContent mockAdContent = (MockAdContent) other;
        return Intrinsics.areEqual(this.emoji, mockAdContent.emoji) && Intrinsics.areEqual(this.title, mockAdContent.title) && Intrinsics.areEqual(this.subtitle, mockAdContent.subtitle) && Intrinsics.areEqual(this.benefits, mockAdContent.benefits) && Intrinsics.areEqual(this.ctaLabel, mockAdContent.ctaLabel) && Color.m3418equalsimpl0(this.gradientStart, mockAdContent.gradientStart) && Color.m3418equalsimpl0(this.gradientEnd, mockAdContent.gradientEnd) && Color.m3418equalsimpl0(this.accentColor, mockAdContent.accentColor);
    }

    /* renamed from: getAccentColor-0d7_KjU, reason: not valid java name */
    public final long m6114getAccentColor0d7_KjU() {
        return this.accentColor;
    }

    public final List<String> getBenefits() {
        return this.benefits;
    }

    public final String getCtaLabel() {
        return this.ctaLabel;
    }

    public final String getEmoji() {
        return this.emoji;
    }

    /* renamed from: getGradientEnd-0d7_KjU, reason: not valid java name */
    public final long m6115getGradientEnd0d7_KjU() {
        return this.gradientEnd;
    }

    /* renamed from: getGradientStart-0d7_KjU, reason: not valid java name */
    public final long m6116getGradientStart0d7_KjU() {
        return this.gradientStart;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((((((this.emoji.hashCode() * 31) + this.title.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + this.benefits.hashCode()) * 31) + this.ctaLabel.hashCode()) * 31) + Color.m3424hashCodeimpl(this.gradientStart)) * 31) + Color.m3424hashCodeimpl(this.gradientEnd)) * 31) + Color.m3424hashCodeimpl(this.accentColor);
    }

    public String toString() {
        return "MockAdContent(emoji=" + this.emoji + ", title=" + this.title + ", subtitle=" + this.subtitle + ", benefits=" + this.benefits + ", ctaLabel=" + this.ctaLabel + ", gradientStart=" + Color.m3425toStringimpl(this.gradientStart) + ", gradientEnd=" + Color.m3425toStringimpl(this.gradientEnd) + ", accentColor=" + Color.m3425toStringimpl(this.accentColor) + ")";
    }

    private MockAdContent(String emoji, String title, String subtitle, List<String> benefits, String ctaLabel, long j, long j2, long j3) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(benefits, "benefits");
        Intrinsics.checkNotNullParameter(ctaLabel, "ctaLabel");
        this.emoji = emoji;
        this.title = title;
        this.subtitle = subtitle;
        this.benefits = benefits;
        this.ctaLabel = ctaLabel;
        this.gradientStart = j;
        this.gradientEnd = j2;
        this.accentColor = j3;
    }
}

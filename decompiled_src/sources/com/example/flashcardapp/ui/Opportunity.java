package com.example.flashcardapp.ui;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileTab.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b#\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u0016\u0010%\u001a\u00020\bHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0017J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u000eHÆ\u0003J\t\u0010+\u001a\u00020\u0010HÆ\u0003Jo\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u0013\u0010/\u001a\u00020\u000e2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0005HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00063"}, d2 = {"Lcom/example/flashcardapp/ui/Opportunity;", "", "title", "", "matchPercentage", "", "labelText", "labelColor", "Landroidx/compose/ui/graphics/Color;", "subtitle", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "buttonText", "showProgress", "", NotificationCompat.CATEGORY_PROGRESS, "", "(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;ZFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getButtonText", "()Ljava/lang/String;", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getLabelColor-0d7_KjU", "()J", "J", "getLabelText", "getMatchPercentage", "()I", "getProgress", "()F", "getShowProgress", "()Z", "getSubtitle", "getTitle", "component1", "component2", "component3", "component4", "component4-0d7_KjU", "component5", "component6", "component7", "component8", "component9", "copy", "copy-fWhpE4E", "(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;ZF)Lcom/example/flashcardapp/ui/Opportunity;", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class Opportunity {
    public static final int $stable = 0;
    private final String buttonText;
    private final ImageVector icon;
    private final long labelColor;
    private final String labelText;
    private final int matchPercentage;
    private final float progress;
    private final boolean showProgress;
    private final String subtitle;
    private final String title;

    public /* synthetic */ Opportunity(String str, int i, String str2, long j, String str3, ImageVector imageVector, String str4, boolean z, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, j, str3, imageVector, str4, z, f);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMatchPercentage() {
        return this.matchPercentage;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLabelText() {
        return this.labelText;
    }

    /* renamed from: component4-0d7_KjU, reason: not valid java name and from getter */
    public final long getLabelColor() {
        return this.labelColor;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    /* renamed from: component6, reason: from getter */
    public final ImageVector getIcon() {
        return this.icon;
    }

    /* renamed from: component7, reason: from getter */
    public final String getButtonText() {
        return this.buttonText;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getShowProgress() {
        return this.showProgress;
    }

    /* renamed from: component9, reason: from getter */
    public final float getProgress() {
        return this.progress;
    }

    /* renamed from: copy-fWhpE4E, reason: not valid java name */
    public final Opportunity m6330copyfWhpE4E(String title, int matchPercentage, String labelText, long labelColor, String subtitle, ImageVector icon, String buttonText, boolean showProgress, float progress) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(labelText, "labelText");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new Opportunity(title, matchPercentage, labelText, labelColor, subtitle, icon, buttonText, showProgress, progress, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Opportunity)) {
            return false;
        }
        Opportunity opportunity = (Opportunity) other;
        return Intrinsics.areEqual(this.title, opportunity.title) && this.matchPercentage == opportunity.matchPercentage && Intrinsics.areEqual(this.labelText, opportunity.labelText) && Color.m3418equalsimpl0(this.labelColor, opportunity.labelColor) && Intrinsics.areEqual(this.subtitle, opportunity.subtitle) && Intrinsics.areEqual(this.icon, opportunity.icon) && Intrinsics.areEqual(this.buttonText, opportunity.buttonText) && this.showProgress == opportunity.showProgress && Float.compare(this.progress, opportunity.progress) == 0;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final ImageVector getIcon() {
        return this.icon;
    }

    /* renamed from: getLabelColor-0d7_KjU, reason: not valid java name */
    public final long m6331getLabelColor0d7_KjU() {
        return this.labelColor;
    }

    public final String getLabelText() {
        return this.labelText;
    }

    public final int getMatchPercentage() {
        return this.matchPercentage;
    }

    public final float getProgress() {
        return this.progress;
    }

    public final boolean getShowProgress() {
        return this.showProgress;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.title.hashCode() * 31) + Integer.hashCode(this.matchPercentage)) * 31) + this.labelText.hashCode()) * 31) + Color.m3424hashCodeimpl(this.labelColor)) * 31) + this.subtitle.hashCode()) * 31) + this.icon.hashCode()) * 31;
        String str = this.buttonText;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.showProgress)) * 31) + Float.hashCode(this.progress);
    }

    public String toString() {
        return "Opportunity(title=" + this.title + ", matchPercentage=" + this.matchPercentage + ", labelText=" + this.labelText + ", labelColor=" + Color.m3425toStringimpl(this.labelColor) + ", subtitle=" + this.subtitle + ", icon=" + this.icon + ", buttonText=" + this.buttonText + ", showProgress=" + this.showProgress + ", progress=" + this.progress + ")";
    }

    private Opportunity(String title, int i, String labelText, long j, String subtitle, ImageVector icon, String str, boolean z, float f) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(labelText, "labelText");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.title = title;
        this.matchPercentage = i;
        this.labelText = labelText;
        this.labelColor = j;
        this.subtitle = subtitle;
        this.icon = icon;
        this.buttonText = str;
        this.showProgress = z;
        this.progress = f;
    }

    public /* synthetic */ Opportunity(String str, int i, String str2, long j, String str3, ImageVector imageVector, String str4, boolean z, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, j, str3, imageVector, (i2 & 64) != 0 ? null : str4, (i2 & 128) != 0 ? false : z, (i2 & 256) != 0 ? 0.0f : f, null);
    }
}

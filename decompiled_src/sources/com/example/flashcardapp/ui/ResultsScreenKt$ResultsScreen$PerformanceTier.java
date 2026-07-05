package com.example.flashcardapp.ui;

import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResultsScreen.kt */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0014\u0010\r\u001a\u00020\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010\bJ%\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"com/example/flashcardapp/ui/ResultsScreenKt$ResultsScreen$PerformanceTier", "", "text", "", "color", "Landroidx/compose/ui/graphics/Color;", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor", "()J", "J", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;J)Lcom/example/flashcardapp/ui/ResultsScreenKt$ResultsScreen$PerformanceTier;", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class ResultsScreenKt$ResultsScreen$PerformanceTier {
    private final long color;
    private final String text;

    public /* synthetic */ ResultsScreenKt$ResultsScreen$PerformanceTier(String str, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j);
    }

    public static /* synthetic */ ResultsScreenKt$ResultsScreen$PerformanceTier copy$default(ResultsScreenKt$ResultsScreen$PerformanceTier resultsScreenKt$ResultsScreen$PerformanceTier, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = resultsScreenKt$ResultsScreen$PerformanceTier.text;
        }
        if ((i & 2) != 0) {
            j = resultsScreenKt$ResultsScreen$PerformanceTier.color;
        }
        return resultsScreenKt$ResultsScreen$PerformanceTier.copy(str, j);
    }

    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component2, reason: from getter */
    public final long getColor() {
        return this.color;
    }

    public final ResultsScreenKt$ResultsScreen$PerformanceTier copy(String text, long color) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new ResultsScreenKt$ResultsScreen$PerformanceTier(text, color, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResultsScreenKt$ResultsScreen$PerformanceTier)) {
            return false;
        }
        ResultsScreenKt$ResultsScreen$PerformanceTier resultsScreenKt$ResultsScreen$PerformanceTier = (ResultsScreenKt$ResultsScreen$PerformanceTier) other;
        return Intrinsics.areEqual(this.text, resultsScreenKt$ResultsScreen$PerformanceTier.text) && Color.m3418equalsimpl0(this.color, resultsScreenKt$ResultsScreen$PerformanceTier.color);
    }

    public final long getColor() {
        return this.color;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + Color.m3424hashCodeimpl(this.color);
    }

    public String toString() {
        return "PerformanceTier(text=" + this.text + ", color=" + Color.m3425toStringimpl(this.color) + ")";
    }

    private ResultsScreenKt$ResultsScreen$PerformanceTier(String text, long j) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.color = j;
    }
}

package com.example.flashcardapp.mcq;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Mcq.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/example/flashcardapp/mcq/DistractorCandidate;", "", "text", "", "sourceCardId", "", "source", "Lcom/example/flashcardapp/mcq/DistractorSource;", "(Ljava/lang/String;JLcom/example/flashcardapp/mcq/DistractorSource;)V", "getSource", "()Lcom/example/flashcardapp/mcq/DistractorSource;", "getSourceCardId", "()J", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class DistractorCandidate {
    public static final int $stable = 0;
    private final DistractorSource source;
    private final long sourceCardId;
    private final String text;

    public static /* synthetic */ DistractorCandidate copy$default(DistractorCandidate distractorCandidate, String str, long j, DistractorSource distractorSource, int i, Object obj) {
        if ((i & 1) != 0) {
            str = distractorCandidate.text;
        }
        if ((i & 2) != 0) {
            j = distractorCandidate.sourceCardId;
        }
        if ((i & 4) != 0) {
            distractorSource = distractorCandidate.source;
        }
        return distractorCandidate.copy(str, j, distractorSource);
    }

    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component2, reason: from getter */
    public final long getSourceCardId() {
        return this.sourceCardId;
    }

    /* renamed from: component3, reason: from getter */
    public final DistractorSource getSource() {
        return this.source;
    }

    public final DistractorCandidate copy(String text, long sourceCardId, DistractorSource source) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(source, "source");
        return new DistractorCandidate(text, sourceCardId, source);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DistractorCandidate)) {
            return false;
        }
        DistractorCandidate distractorCandidate = (DistractorCandidate) other;
        return Intrinsics.areEqual(this.text, distractorCandidate.text) && this.sourceCardId == distractorCandidate.sourceCardId && this.source == distractorCandidate.source;
    }

    public final DistractorSource getSource() {
        return this.source;
    }

    public final long getSourceCardId() {
        return this.sourceCardId;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (((this.text.hashCode() * 31) + Long.hashCode(this.sourceCardId)) * 31) + this.source.hashCode();
    }

    public String toString() {
        return "DistractorCandidate(text=" + this.text + ", sourceCardId=" + this.sourceCardId + ", source=" + this.source + ")";
    }

    public DistractorCandidate(String text, long j, DistractorSource source) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(source, "source");
        this.text = text;
        this.sourceCardId = j;
        this.source = source;
    }
}

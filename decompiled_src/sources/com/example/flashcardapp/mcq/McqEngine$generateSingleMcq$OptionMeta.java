package com.example.flashcardapp.mcq;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: McqEngine.kt */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J,\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"com/example/flashcardapp/mcq/McqEngine$generateSingleMcq$OptionMeta", "", "text", "", "cardId", "", "isCorrect", "", "(Ljava/lang/String;JZ)V", "getCardId", "()J", "()Z", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;JZ)Lcom/example/flashcardapp/mcq/McqEngine$generateSingleMcq$OptionMeta;", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class McqEngine$generateSingleMcq$OptionMeta {
    private final long cardId;
    private final boolean isCorrect;
    private final String text;

    public static /* synthetic */ McqEngine$generateSingleMcq$OptionMeta copy$default(McqEngine$generateSingleMcq$OptionMeta mcqEngine$generateSingleMcq$OptionMeta, String str, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mcqEngine$generateSingleMcq$OptionMeta.text;
        }
        if ((i & 2) != 0) {
            j = mcqEngine$generateSingleMcq$OptionMeta.cardId;
        }
        if ((i & 4) != 0) {
            z = mcqEngine$generateSingleMcq$OptionMeta.isCorrect;
        }
        return mcqEngine$generateSingleMcq$OptionMeta.copy(str, j, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCardId() {
        return this.cardId;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsCorrect() {
        return this.isCorrect;
    }

    public final McqEngine$generateSingleMcq$OptionMeta copy(String text, long cardId, boolean isCorrect) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new McqEngine$generateSingleMcq$OptionMeta(text, cardId, isCorrect);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof McqEngine$generateSingleMcq$OptionMeta)) {
            return false;
        }
        McqEngine$generateSingleMcq$OptionMeta mcqEngine$generateSingleMcq$OptionMeta = (McqEngine$generateSingleMcq$OptionMeta) other;
        return Intrinsics.areEqual(this.text, mcqEngine$generateSingleMcq$OptionMeta.text) && this.cardId == mcqEngine$generateSingleMcq$OptionMeta.cardId && this.isCorrect == mcqEngine$generateSingleMcq$OptionMeta.isCorrect;
    }

    public final long getCardId() {
        return this.cardId;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (((this.text.hashCode() * 31) + Long.hashCode(this.cardId)) * 31) + Boolean.hashCode(this.isCorrect);
    }

    public final boolean isCorrect() {
        return this.isCorrect;
    }

    public String toString() {
        return "OptionMeta(text=" + this.text + ", cardId=" + this.cardId + ", isCorrect=" + this.isCorrect + ")";
    }

    public McqEngine$generateSingleMcq$OptionMeta(String text, long j, boolean z) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.cardId = j;
        this.isCorrect = z;
    }
}

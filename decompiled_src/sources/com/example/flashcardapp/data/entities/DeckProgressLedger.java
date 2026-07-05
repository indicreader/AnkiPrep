package com.example.flashcardapp.data.entities;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: DeckProgressLedger.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/example/flashcardapp/data/entities/DeckProgressLedger;", "", "cardId", "", "deckId", "(JJ)V", "getCardId", "()J", "getDeckId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class DeckProgressLedger {
    public static final int $stable = 0;
    private final long cardId;
    private final long deckId;

    public static /* synthetic */ DeckProgressLedger copy$default(DeckProgressLedger deckProgressLedger, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = deckProgressLedger.cardId;
        }
        if ((i & 2) != 0) {
            j2 = deckProgressLedger.deckId;
        }
        return deckProgressLedger.copy(j, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getCardId() {
        return this.cardId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDeckId() {
        return this.deckId;
    }

    public final DeckProgressLedger copy(long cardId, long deckId) {
        return new DeckProgressLedger(cardId, deckId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeckProgressLedger)) {
            return false;
        }
        DeckProgressLedger deckProgressLedger = (DeckProgressLedger) other;
        return this.cardId == deckProgressLedger.cardId && this.deckId == deckProgressLedger.deckId;
    }

    public final long getCardId() {
        return this.cardId;
    }

    public final long getDeckId() {
        return this.deckId;
    }

    public int hashCode() {
        return (Long.hashCode(this.cardId) * 31) + Long.hashCode(this.deckId);
    }

    public String toString() {
        return "DeckProgressLedger(cardId=" + this.cardId + ", deckId=" + this.deckId + ")";
    }

    public DeckProgressLedger(long j, long j2) {
        this.cardId = j;
        this.deckId = j2;
    }
}

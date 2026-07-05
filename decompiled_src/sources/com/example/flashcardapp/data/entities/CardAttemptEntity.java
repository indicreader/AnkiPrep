package com.example.flashcardapp.data.entities;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CardAttemptEntity.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\nHÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006#"}, d2 = {"Lcom/example/flashcardapp/data/entities/CardAttemptEntity;", "", "id", "", "cardId", "deckId", "isCorrect", "", "timeTakenMs", "fsrsRating", "", "timestamp", "(JJJZJIJ)V", "getCardId", "()J", "getDeckId", "getFsrsRating", "()I", "getId", "()Z", "getTimeTakenMs", "getTimestamp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class CardAttemptEntity {
    public static final int $stable = 0;
    private final long cardId;
    private final long deckId;
    private final int fsrsRating;
    private final long id;
    private final boolean isCorrect;
    private final long timeTakenMs;
    private final long timestamp;

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCardId() {
        return this.cardId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getDeckId() {
        return this.deckId;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsCorrect() {
        return this.isCorrect;
    }

    /* renamed from: component5, reason: from getter */
    public final long getTimeTakenMs() {
        return this.timeTakenMs;
    }

    /* renamed from: component6, reason: from getter */
    public final int getFsrsRating() {
        return this.fsrsRating;
    }

    /* renamed from: component7, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final CardAttemptEntity copy(long id, long cardId, long deckId, boolean isCorrect, long timeTakenMs, int fsrsRating, long timestamp) {
        return new CardAttemptEntity(id, cardId, deckId, isCorrect, timeTakenMs, fsrsRating, timestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardAttemptEntity)) {
            return false;
        }
        CardAttemptEntity cardAttemptEntity = (CardAttemptEntity) other;
        return this.id == cardAttemptEntity.id && this.cardId == cardAttemptEntity.cardId && this.deckId == cardAttemptEntity.deckId && this.isCorrect == cardAttemptEntity.isCorrect && this.timeTakenMs == cardAttemptEntity.timeTakenMs && this.fsrsRating == cardAttemptEntity.fsrsRating && this.timestamp == cardAttemptEntity.timestamp;
    }

    public final long getCardId() {
        return this.cardId;
    }

    public final long getDeckId() {
        return this.deckId;
    }

    public final int getFsrsRating() {
        return this.fsrsRating;
    }

    public final long getId() {
        return this.id;
    }

    public final long getTimeTakenMs() {
        return this.timeTakenMs;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (((((((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.cardId)) * 31) + Long.hashCode(this.deckId)) * 31) + Boolean.hashCode(this.isCorrect)) * 31) + Long.hashCode(this.timeTakenMs)) * 31) + Integer.hashCode(this.fsrsRating)) * 31) + Long.hashCode(this.timestamp);
    }

    public final boolean isCorrect() {
        return this.isCorrect;
    }

    public String toString() {
        return "CardAttemptEntity(id=" + this.id + ", cardId=" + this.cardId + ", deckId=" + this.deckId + ", isCorrect=" + this.isCorrect + ", timeTakenMs=" + this.timeTakenMs + ", fsrsRating=" + this.fsrsRating + ", timestamp=" + this.timestamp + ")";
    }

    public CardAttemptEntity(long j, long j2, long j3, boolean z, long j4, int i, long j5) {
        this.id = j;
        this.cardId = j2;
        this.deckId = j3;
        this.isCorrect = z;
        this.timeTakenMs = j4;
        this.fsrsRating = i;
        this.timestamp = j5;
    }

    public /* synthetic */ CardAttemptEntity(long j, long j2, long j3, boolean z, long j4, int i, long j5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, j2, j3, z, (i2 & 16) != 0 ? 0L : j4, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? System.currentTimeMillis() : j5);
    }
}

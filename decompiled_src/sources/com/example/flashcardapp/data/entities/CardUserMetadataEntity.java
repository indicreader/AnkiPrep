package com.example.flashcardapp.data.entities;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CardUserMetadataEntity.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/example/flashcardapp/data/entities/CardUserMetadataEntity;", "", "cardId", "", "isStarred", "", "rating", "", "(JZI)V", "getCardId", "()J", "()Z", "getRating", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class CardUserMetadataEntity {
    public static final int $stable = 0;
    private final long cardId;
    private final boolean isStarred;
    private final int rating;

    public static /* synthetic */ CardUserMetadataEntity copy$default(CardUserMetadataEntity cardUserMetadataEntity, long j, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = cardUserMetadataEntity.cardId;
        }
        if ((i2 & 2) != 0) {
            z = cardUserMetadataEntity.isStarred;
        }
        if ((i2 & 4) != 0) {
            i = cardUserMetadataEntity.rating;
        }
        return cardUserMetadataEntity.copy(j, z, i);
    }

    /* renamed from: component1, reason: from getter */
    public final long getCardId() {
        return this.cardId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsStarred() {
        return this.isStarred;
    }

    /* renamed from: component3, reason: from getter */
    public final int getRating() {
        return this.rating;
    }

    public final CardUserMetadataEntity copy(long cardId, boolean isStarred, int rating) {
        return new CardUserMetadataEntity(cardId, isStarred, rating);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardUserMetadataEntity)) {
            return false;
        }
        CardUserMetadataEntity cardUserMetadataEntity = (CardUserMetadataEntity) other;
        return this.cardId == cardUserMetadataEntity.cardId && this.isStarred == cardUserMetadataEntity.isStarred && this.rating == cardUserMetadataEntity.rating;
    }

    public final long getCardId() {
        return this.cardId;
    }

    public final int getRating() {
        return this.rating;
    }

    public int hashCode() {
        return (((Long.hashCode(this.cardId) * 31) + Boolean.hashCode(this.isStarred)) * 31) + Integer.hashCode(this.rating);
    }

    public final boolean isStarred() {
        return this.isStarred;
    }

    public String toString() {
        return "CardUserMetadataEntity(cardId=" + this.cardId + ", isStarred=" + this.isStarred + ", rating=" + this.rating + ")";
    }

    public CardUserMetadataEntity(long j, boolean z, int i) {
        this.cardId = j;
        this.isStarred = z;
        this.rating = i;
    }

    public /* synthetic */ CardUserMetadataEntity(long j, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? 0 : i);
    }
}

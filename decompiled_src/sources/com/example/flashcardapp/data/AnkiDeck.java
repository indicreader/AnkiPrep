package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnkiDroidBridge.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/example/flashcardapp/data/AnkiDeck;", "", "id", "", "name", "", "cardCount", "", "(JLjava/lang/String;I)V", "getCardCount", "()I", "getId", "()J", "getName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class AnkiDeck {
    public static final int $stable = 0;
    private final int cardCount;
    private final long id;
    private final String name;

    public static /* synthetic */ AnkiDeck copy$default(AnkiDeck ankiDeck, long j, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = ankiDeck.id;
        }
        if ((i2 & 2) != 0) {
            str = ankiDeck.name;
        }
        if ((i2 & 4) != 0) {
            i = ankiDeck.cardCount;
        }
        return ankiDeck.copy(j, str, i);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCardCount() {
        return this.cardCount;
    }

    public final AnkiDeck copy(long id, String name, int cardCount) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new AnkiDeck(id, name, cardCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnkiDeck)) {
            return false;
        }
        AnkiDeck ankiDeck = (AnkiDeck) other;
        return this.id == ankiDeck.id && Intrinsics.areEqual(this.name, ankiDeck.name) && this.cardCount == ankiDeck.cardCount;
    }

    public final int getCardCount() {
        return this.cardCount;
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((Long.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.cardCount);
    }

    public String toString() {
        return "AnkiDeck(id=" + this.id + ", name=" + this.name + ", cardCount=" + this.cardCount + ")";
    }

    public AnkiDeck(long j, String name, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = j;
        this.name = name;
        this.cardCount = i;
    }

    public /* synthetic */ AnkiDeck(long j, String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, (i2 & 4) != 0 ? 0 : i);
    }
}

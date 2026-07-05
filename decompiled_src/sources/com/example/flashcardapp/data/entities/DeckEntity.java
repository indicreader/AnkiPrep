package com.example.flashcardapp.data.entities;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeckEntity.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003JV\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\tHÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lcom/example/flashcardapp/data/entities/DeckEntity;", "", "id", "", "name", "", "fullPath", "parentDeckId", "cardCount", "", "description", "lastSyncTimestamp", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;ILjava/lang/String;J)V", "getCardCount", "()I", "getDescription", "()Ljava/lang/String;", "getFullPath", "getId", "()J", "getLastSyncTimestamp", "getName", "getParentDeckId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;ILjava/lang/String;J)Lcom/example/flashcardapp/data/entities/DeckEntity;", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class DeckEntity {
    public static final int $stable = 0;
    private final int cardCount;
    private final String description;
    private final String fullPath;
    private final long id;
    private final long lastSyncTimestamp;
    private final String name;
    private final Long parentDeckId;

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFullPath() {
        return this.fullPath;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getParentDeckId() {
        return this.parentDeckId;
    }

    /* renamed from: component5, reason: from getter */
    public final int getCardCount() {
        return this.cardCount;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component7, reason: from getter */
    public final long getLastSyncTimestamp() {
        return this.lastSyncTimestamp;
    }

    public final DeckEntity copy(long id, String name, String fullPath, Long parentDeckId, int cardCount, String description, long lastSyncTimestamp) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fullPath, "fullPath");
        Intrinsics.checkNotNullParameter(description, "description");
        return new DeckEntity(id, name, fullPath, parentDeckId, cardCount, description, lastSyncTimestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeckEntity)) {
            return false;
        }
        DeckEntity deckEntity = (DeckEntity) other;
        return this.id == deckEntity.id && Intrinsics.areEqual(this.name, deckEntity.name) && Intrinsics.areEqual(this.fullPath, deckEntity.fullPath) && Intrinsics.areEqual(this.parentDeckId, deckEntity.parentDeckId) && this.cardCount == deckEntity.cardCount && Intrinsics.areEqual(this.description, deckEntity.description) && this.lastSyncTimestamp == deckEntity.lastSyncTimestamp;
    }

    public final int getCardCount() {
        return this.cardCount;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getFullPath() {
        return this.fullPath;
    }

    public final long getId() {
        return this.id;
    }

    public final long getLastSyncTimestamp() {
        return this.lastSyncTimestamp;
    }

    public final String getName() {
        return this.name;
    }

    public final Long getParentDeckId() {
        return this.parentDeckId;
    }

    public int hashCode() {
        int hashCode = ((((Long.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + this.fullPath.hashCode()) * 31;
        Long l = this.parentDeckId;
        return ((((((hashCode + (l == null ? 0 : l.hashCode())) * 31) + Integer.hashCode(this.cardCount)) * 31) + this.description.hashCode()) * 31) + Long.hashCode(this.lastSyncTimestamp);
    }

    public String toString() {
        return "DeckEntity(id=" + this.id + ", name=" + this.name + ", fullPath=" + this.fullPath + ", parentDeckId=" + this.parentDeckId + ", cardCount=" + this.cardCount + ", description=" + this.description + ", lastSyncTimestamp=" + this.lastSyncTimestamp + ")";
    }

    public DeckEntity(long j, String name, String fullPath, Long l, int i, String description, long j2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fullPath, "fullPath");
        Intrinsics.checkNotNullParameter(description, "description");
        this.id = j;
        this.name = name;
        this.fullPath = fullPath;
        this.parentDeckId = l;
        this.cardCount = i;
        this.description = description;
        this.lastSyncTimestamp = j2;
    }

    public /* synthetic */ DeckEntity(long j, String str, String str2, Long l, int i, String str3, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, str2, (i2 & 8) != 0 ? null : l, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? "" : str3, (i2 & 64) != 0 ? System.currentTimeMillis() : j2);
    }
}

package com.example.flashcardapp.data.entities;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* compiled from: CardEntity.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0011J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u009a\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u00020\bHÖ\u0001R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0013¨\u00068"}, d2 = {"Lcom/example/flashcardapp/data/entities/CardEntity;", "", "id", "", "noteId", "deckId", "subDeckId", "front", "", "back", "tags", "deckHierarchy", "lastSyncTimestamp", "frontImage", "backImage", "explanationImage", "optionImagesJson", "(JJJLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBack", "()Ljava/lang/String;", "getBackImage", "getDeckHierarchy", "getDeckId", "()J", "getExplanationImage", "getFront", "getFrontImage", "getId", "getLastSyncTimestamp", "getNoteId", "getOptionImagesJson", "getSubDeckId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTags", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JJJLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/example/flashcardapp/data/entities/CardEntity;", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class CardEntity {
    public static final int $stable = 0;
    private final String back;
    private final String backImage;
    private final String deckHierarchy;
    private final long deckId;
    private final String explanationImage;
    private final String front;
    private final String frontImage;
    private final long id;
    private final long lastSyncTimestamp;
    private final long noteId;
    private final String optionImagesJson;
    private final Long subDeckId;
    private final String tags;

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getFrontImage() {
        return this.frontImage;
    }

    /* renamed from: component11, reason: from getter */
    public final String getBackImage() {
        return this.backImage;
    }

    /* renamed from: component12, reason: from getter */
    public final String getExplanationImage() {
        return this.explanationImage;
    }

    /* renamed from: component13, reason: from getter */
    public final String getOptionImagesJson() {
        return this.optionImagesJson;
    }

    /* renamed from: component2, reason: from getter */
    public final long getNoteId() {
        return this.noteId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getDeckId() {
        return this.deckId;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getSubDeckId() {
        return this.subDeckId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFront() {
        return this.front;
    }

    /* renamed from: component6, reason: from getter */
    public final String getBack() {
        return this.back;
    }

    /* renamed from: component7, reason: from getter */
    public final String getTags() {
        return this.tags;
    }

    /* renamed from: component8, reason: from getter */
    public final String getDeckHierarchy() {
        return this.deckHierarchy;
    }

    /* renamed from: component9, reason: from getter */
    public final long getLastSyncTimestamp() {
        return this.lastSyncTimestamp;
    }

    public final CardEntity copy(long id, long noteId, long deckId, Long subDeckId, String front, String back, String tags, String deckHierarchy, long lastSyncTimestamp, String frontImage, String backImage, String explanationImage, String optionImagesJson) {
        Intrinsics.checkNotNullParameter(front, "front");
        Intrinsics.checkNotNullParameter(back, "back");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(deckHierarchy, "deckHierarchy");
        return new CardEntity(id, noteId, deckId, subDeckId, front, back, tags, deckHierarchy, lastSyncTimestamp, frontImage, backImage, explanationImage, optionImagesJson);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardEntity)) {
            return false;
        }
        CardEntity cardEntity = (CardEntity) other;
        return this.id == cardEntity.id && this.noteId == cardEntity.noteId && this.deckId == cardEntity.deckId && Intrinsics.areEqual(this.subDeckId, cardEntity.subDeckId) && Intrinsics.areEqual(this.front, cardEntity.front) && Intrinsics.areEqual(this.back, cardEntity.back) && Intrinsics.areEqual(this.tags, cardEntity.tags) && Intrinsics.areEqual(this.deckHierarchy, cardEntity.deckHierarchy) && this.lastSyncTimestamp == cardEntity.lastSyncTimestamp && Intrinsics.areEqual(this.frontImage, cardEntity.frontImage) && Intrinsics.areEqual(this.backImage, cardEntity.backImage) && Intrinsics.areEqual(this.explanationImage, cardEntity.explanationImage) && Intrinsics.areEqual(this.optionImagesJson, cardEntity.optionImagesJson);
    }

    public final String getBack() {
        return this.back;
    }

    public final String getBackImage() {
        return this.backImage;
    }

    public final String getDeckHierarchy() {
        return this.deckHierarchy;
    }

    public final long getDeckId() {
        return this.deckId;
    }

    public final String getExplanationImage() {
        return this.explanationImage;
    }

    public final String getFront() {
        return this.front;
    }

    public final String getFrontImage() {
        return this.frontImage;
    }

    public final long getId() {
        return this.id;
    }

    public final long getLastSyncTimestamp() {
        return this.lastSyncTimestamp;
    }

    public final long getNoteId() {
        return this.noteId;
    }

    public final String getOptionImagesJson() {
        return this.optionImagesJson;
    }

    public final Long getSubDeckId() {
        return this.subDeckId;
    }

    public final String getTags() {
        return this.tags;
    }

    public int hashCode() {
        int hashCode = ((((Long.hashCode(this.id) * 31) + Long.hashCode(this.noteId)) * 31) + Long.hashCode(this.deckId)) * 31;
        Long l = this.subDeckId;
        int hashCode2 = (((((((((((hashCode + (l == null ? 0 : l.hashCode())) * 31) + this.front.hashCode()) * 31) + this.back.hashCode()) * 31) + this.tags.hashCode()) * 31) + this.deckHierarchy.hashCode()) * 31) + Long.hashCode(this.lastSyncTimestamp)) * 31;
        String str = this.frontImage;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.backImage;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.explanationImage;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.optionImagesJson;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "CardEntity(id=" + this.id + ", noteId=" + this.noteId + ", deckId=" + this.deckId + ", subDeckId=" + this.subDeckId + ", front=" + this.front + ", back=" + this.back + ", tags=" + this.tags + ", deckHierarchy=" + this.deckHierarchy + ", lastSyncTimestamp=" + this.lastSyncTimestamp + ", frontImage=" + this.frontImage + ", backImage=" + this.backImage + ", explanationImage=" + this.explanationImage + ", optionImagesJson=" + this.optionImagesJson + ")";
    }

    public CardEntity(long j, long j2, long j3, Long l, String front, String back, String tags, String deckHierarchy, long j4, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(front, "front");
        Intrinsics.checkNotNullParameter(back, "back");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(deckHierarchy, "deckHierarchy");
        this.id = j;
        this.noteId = j2;
        this.deckId = j3;
        this.subDeckId = l;
        this.front = front;
        this.back = back;
        this.tags = tags;
        this.deckHierarchy = deckHierarchy;
        this.lastSyncTimestamp = j4;
        this.frontImage = str;
        this.backImage = str2;
        this.explanationImage = str3;
        this.optionImagesJson = str4;
    }

    public /* synthetic */ CardEntity(long j, long j2, long j3, Long l, String str, String str2, String str3, String str4, long j4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, (i & 8) != 0 ? null : l, str, str2, (i & 64) != 0 ? HttpUrl.PATH_SEGMENT_ENCODE_SET_URI : str3, (i & 128) != 0 ? "" : str4, (i & 256) != 0 ? System.currentTimeMillis() : j4, (i & 512) != 0 ? null : str5, (i & 1024) != 0 ? null : str6, (i & 2048) != 0 ? null : str7, (i & 4096) != 0 ? null : str8);
    }
}

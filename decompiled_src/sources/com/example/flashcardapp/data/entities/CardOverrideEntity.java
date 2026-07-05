package com.example.flashcardapp.data.entities;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CardOverrideEntity.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jm\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u0006)"}, d2 = {"Lcom/example/flashcardapp/data/entities/CardOverrideEntity;", "", "cardId", "", "frontOverride", "", "backOverride", "tagsOverride", "timestamp", "frontImageOverride", "backImageOverride", "explanationImageOverride", "optionImagesOverrideJson", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackImageOverride", "()Ljava/lang/String;", "getBackOverride", "getCardId", "()J", "getExplanationImageOverride", "getFrontImageOverride", "getFrontOverride", "getOptionImagesOverrideJson", "getTagsOverride", "getTimestamp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class CardOverrideEntity {
    public static final int $stable = 0;
    private final String backImageOverride;
    private final String backOverride;
    private final long cardId;
    private final String explanationImageOverride;
    private final String frontImageOverride;
    private final String frontOverride;
    private final String optionImagesOverrideJson;
    private final String tagsOverride;
    private final long timestamp;

    /* renamed from: component1, reason: from getter */
    public final long getCardId() {
        return this.cardId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFrontOverride() {
        return this.frontOverride;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBackOverride() {
        return this.backOverride;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTagsOverride() {
        return this.tagsOverride;
    }

    /* renamed from: component5, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component6, reason: from getter */
    public final String getFrontImageOverride() {
        return this.frontImageOverride;
    }

    /* renamed from: component7, reason: from getter */
    public final String getBackImageOverride() {
        return this.backImageOverride;
    }

    /* renamed from: component8, reason: from getter */
    public final String getExplanationImageOverride() {
        return this.explanationImageOverride;
    }

    /* renamed from: component9, reason: from getter */
    public final String getOptionImagesOverrideJson() {
        return this.optionImagesOverrideJson;
    }

    public final CardOverrideEntity copy(long cardId, String frontOverride, String backOverride, String tagsOverride, long timestamp, String frontImageOverride, String backImageOverride, String explanationImageOverride, String optionImagesOverrideJson) {
        Intrinsics.checkNotNullParameter(frontOverride, "frontOverride");
        Intrinsics.checkNotNullParameter(backOverride, "backOverride");
        return new CardOverrideEntity(cardId, frontOverride, backOverride, tagsOverride, timestamp, frontImageOverride, backImageOverride, explanationImageOverride, optionImagesOverrideJson);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardOverrideEntity)) {
            return false;
        }
        CardOverrideEntity cardOverrideEntity = (CardOverrideEntity) other;
        return this.cardId == cardOverrideEntity.cardId && Intrinsics.areEqual(this.frontOverride, cardOverrideEntity.frontOverride) && Intrinsics.areEqual(this.backOverride, cardOverrideEntity.backOverride) && Intrinsics.areEqual(this.tagsOverride, cardOverrideEntity.tagsOverride) && this.timestamp == cardOverrideEntity.timestamp && Intrinsics.areEqual(this.frontImageOverride, cardOverrideEntity.frontImageOverride) && Intrinsics.areEqual(this.backImageOverride, cardOverrideEntity.backImageOverride) && Intrinsics.areEqual(this.explanationImageOverride, cardOverrideEntity.explanationImageOverride) && Intrinsics.areEqual(this.optionImagesOverrideJson, cardOverrideEntity.optionImagesOverrideJson);
    }

    public final String getBackImageOverride() {
        return this.backImageOverride;
    }

    public final String getBackOverride() {
        return this.backOverride;
    }

    public final long getCardId() {
        return this.cardId;
    }

    public final String getExplanationImageOverride() {
        return this.explanationImageOverride;
    }

    public final String getFrontImageOverride() {
        return this.frontImageOverride;
    }

    public final String getFrontOverride() {
        return this.frontOverride;
    }

    public final String getOptionImagesOverrideJson() {
        return this.optionImagesOverrideJson;
    }

    public final String getTagsOverride() {
        return this.tagsOverride;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int hashCode = ((((Long.hashCode(this.cardId) * 31) + this.frontOverride.hashCode()) * 31) + this.backOverride.hashCode()) * 31;
        String str = this.tagsOverride;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.timestamp)) * 31;
        String str2 = this.frontImageOverride;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.backImageOverride;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.explanationImageOverride;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.optionImagesOverrideJson;
        return hashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "CardOverrideEntity(cardId=" + this.cardId + ", frontOverride=" + this.frontOverride + ", backOverride=" + this.backOverride + ", tagsOverride=" + this.tagsOverride + ", timestamp=" + this.timestamp + ", frontImageOverride=" + this.frontImageOverride + ", backImageOverride=" + this.backImageOverride + ", explanationImageOverride=" + this.explanationImageOverride + ", optionImagesOverrideJson=" + this.optionImagesOverrideJson + ")";
    }

    public CardOverrideEntity(long j, String frontOverride, String backOverride, String str, long j2, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(frontOverride, "frontOverride");
        Intrinsics.checkNotNullParameter(backOverride, "backOverride");
        this.cardId = j;
        this.frontOverride = frontOverride;
        this.backOverride = backOverride;
        this.tagsOverride = str;
        this.timestamp = j2;
        this.frontImageOverride = str2;
        this.backImageOverride = str3;
        this.explanationImageOverride = str4;
        this.optionImagesOverrideJson = str5;
    }

    public /* synthetic */ CardOverrideEntity(long j, String str, String str2, String str3, long j2, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? System.currentTimeMillis() : j2, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7);
    }
}

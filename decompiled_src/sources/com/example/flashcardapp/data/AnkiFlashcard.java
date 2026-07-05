package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnkiDroidBridge.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\tHÆ\u0003JA\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/example/flashcardapp/data/AnkiFlashcard;", "", "cardId", "", "noteId", "front", "", "back", "tags", "", "(JJLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getBack", "()Ljava/lang/String;", "getCardId", "()J", "getFront", "getNoteId", "getTags", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class AnkiFlashcard {
    public static final int $stable = 8;
    private final String back;
    private final long cardId;
    private final String front;
    private final long noteId;
    private final List<String> tags;

    /* renamed from: component1, reason: from getter */
    public final long getCardId() {
        return this.cardId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getNoteId() {
        return this.noteId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFront() {
        return this.front;
    }

    /* renamed from: component4, reason: from getter */
    public final String getBack() {
        return this.back;
    }

    public final List<String> component5() {
        return this.tags;
    }

    public final AnkiFlashcard copy(long cardId, long noteId, String front, String back, List<String> tags) {
        Intrinsics.checkNotNullParameter(front, "front");
        Intrinsics.checkNotNullParameter(back, "back");
        Intrinsics.checkNotNullParameter(tags, "tags");
        return new AnkiFlashcard(cardId, noteId, front, back, tags);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnkiFlashcard)) {
            return false;
        }
        AnkiFlashcard ankiFlashcard = (AnkiFlashcard) other;
        return this.cardId == ankiFlashcard.cardId && this.noteId == ankiFlashcard.noteId && Intrinsics.areEqual(this.front, ankiFlashcard.front) && Intrinsics.areEqual(this.back, ankiFlashcard.back) && Intrinsics.areEqual(this.tags, ankiFlashcard.tags);
    }

    public final String getBack() {
        return this.back;
    }

    public final long getCardId() {
        return this.cardId;
    }

    public final String getFront() {
        return this.front;
    }

    public final long getNoteId() {
        return this.noteId;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.cardId) * 31) + Long.hashCode(this.noteId)) * 31) + this.front.hashCode()) * 31) + this.back.hashCode()) * 31) + this.tags.hashCode();
    }

    public String toString() {
        return "AnkiFlashcard(cardId=" + this.cardId + ", noteId=" + this.noteId + ", front=" + this.front + ", back=" + this.back + ", tags=" + this.tags + ")";
    }

    public AnkiFlashcard(long j, long j2, String front, String back, List<String> tags) {
        Intrinsics.checkNotNullParameter(front, "front");
        Intrinsics.checkNotNullParameter(back, "back");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.cardId = j;
        this.noteId = j2;
        this.front = front;
        this.back = back;
        this.tags = tags;
    }

    public /* synthetic */ AnkiFlashcard(long j, long j2, String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, str, str2, (i & 16) != 0 ? CollectionsKt.emptyList() : list);
    }
}

package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnkiDroidBridge.kt */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\"\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"com/example/flashcardapp/data/AnkiDroidBridge$getCardsAndNotesForDeck$NoteData", "", "fields", "", "tags", "(Ljava/lang/String;Ljava/lang/String;)V", "getFields", "()Ljava/lang/String;", "getTags", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/example/flashcardapp/data/AnkiDroidBridge$getCardsAndNotesForDeck$NoteData;", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class AnkiDroidBridge$getCardsAndNotesForDeck$NoteData {
    private final String fields;
    private final String tags;

    public static /* synthetic */ AnkiDroidBridge$getCardsAndNotesForDeck$NoteData copy$default(AnkiDroidBridge$getCardsAndNotesForDeck$NoteData ankiDroidBridge$getCardsAndNotesForDeck$NoteData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ankiDroidBridge$getCardsAndNotesForDeck$NoteData.fields;
        }
        if ((i & 2) != 0) {
            str2 = ankiDroidBridge$getCardsAndNotesForDeck$NoteData.tags;
        }
        return ankiDroidBridge$getCardsAndNotesForDeck$NoteData.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFields() {
        return this.fields;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTags() {
        return this.tags;
    }

    public final AnkiDroidBridge$getCardsAndNotesForDeck$NoteData copy(String fields, String tags) {
        Intrinsics.checkNotNullParameter(fields, "fields");
        Intrinsics.checkNotNullParameter(tags, "tags");
        return new AnkiDroidBridge$getCardsAndNotesForDeck$NoteData(fields, tags);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnkiDroidBridge$getCardsAndNotesForDeck$NoteData)) {
            return false;
        }
        AnkiDroidBridge$getCardsAndNotesForDeck$NoteData ankiDroidBridge$getCardsAndNotesForDeck$NoteData = (AnkiDroidBridge$getCardsAndNotesForDeck$NoteData) other;
        return Intrinsics.areEqual(this.fields, ankiDroidBridge$getCardsAndNotesForDeck$NoteData.fields) && Intrinsics.areEqual(this.tags, ankiDroidBridge$getCardsAndNotesForDeck$NoteData.tags);
    }

    public final String getFields() {
        return this.fields;
    }

    public final String getTags() {
        return this.tags;
    }

    public int hashCode() {
        return (this.fields.hashCode() * 31) + this.tags.hashCode();
    }

    public String toString() {
        return "NoteData(fields=" + this.fields + ", tags=" + this.tags + ")";
    }

    public AnkiDroidBridge$getCardsAndNotesForDeck$NoteData(String fields, String tags) {
        Intrinsics.checkNotNullParameter(fields, "fields");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.fields = fields;
        this.tags = tags;
    }
}

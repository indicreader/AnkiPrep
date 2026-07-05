package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.CardEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ApkgImporter.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003JW\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0007HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017¨\u0006&"}, d2 = {"Lcom/example/flashcardapp/data/ImportResult;", "", "success", "", "fileName", "", "totalDecks", "", "totalNotes", "totalCards", "sampleCards", "", "Lcom/example/flashcardapp/data/entities/CardEntity;", "error", "(ZLjava/lang/String;IIILjava/util/List;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "getFileName", "getSampleCards", "()Ljava/util/List;", "getSuccess", "()Z", "getTotalCards", "()I", "getTotalDecks", "getTotalNotes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class ImportResult {
    public static final int $stable = 8;
    private final String error;
    private final String fileName;
    private final List<CardEntity> sampleCards;
    private final boolean success;
    private final int totalCards;
    private final int totalDecks;
    private final int totalNotes;

    public static /* synthetic */ ImportResult copy$default(ImportResult importResult, boolean z, String str, int i, int i2, int i3, List list, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = importResult.success;
        }
        if ((i4 & 2) != 0) {
            str = importResult.fileName;
        }
        String str3 = str;
        if ((i4 & 4) != 0) {
            i = importResult.totalDecks;
        }
        int i5 = i;
        if ((i4 & 8) != 0) {
            i2 = importResult.totalNotes;
        }
        int i6 = i2;
        if ((i4 & 16) != 0) {
            i3 = importResult.totalCards;
        }
        int i7 = i3;
        if ((i4 & 32) != 0) {
            list = importResult.sampleCards;
        }
        List list2 = list;
        if ((i4 & 64) != 0) {
            str2 = importResult.error;
        }
        return importResult.copy(z, str3, i5, i6, i7, list2, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTotalDecks() {
        return this.totalDecks;
    }

    /* renamed from: component4, reason: from getter */
    public final int getTotalNotes() {
        return this.totalNotes;
    }

    /* renamed from: component5, reason: from getter */
    public final int getTotalCards() {
        return this.totalCards;
    }

    public final List<CardEntity> component6() {
        return this.sampleCards;
    }

    /* renamed from: component7, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final ImportResult copy(boolean success, String fileName, int totalDecks, int totalNotes, int totalCards, List<CardEntity> sampleCards, String error) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(sampleCards, "sampleCards");
        return new ImportResult(success, fileName, totalDecks, totalNotes, totalCards, sampleCards, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImportResult)) {
            return false;
        }
        ImportResult importResult = (ImportResult) other;
        return this.success == importResult.success && Intrinsics.areEqual(this.fileName, importResult.fileName) && this.totalDecks == importResult.totalDecks && this.totalNotes == importResult.totalNotes && this.totalCards == importResult.totalCards && Intrinsics.areEqual(this.sampleCards, importResult.sampleCards) && Intrinsics.areEqual(this.error, importResult.error);
    }

    public final String getError() {
        return this.error;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final List<CardEntity> getSampleCards() {
        return this.sampleCards;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final int getTotalCards() {
        return this.totalCards;
    }

    public final int getTotalDecks() {
        return this.totalDecks;
    }

    public final int getTotalNotes() {
        return this.totalNotes;
    }

    public int hashCode() {
        int hashCode = ((((((((((Boolean.hashCode(this.success) * 31) + this.fileName.hashCode()) * 31) + Integer.hashCode(this.totalDecks)) * 31) + Integer.hashCode(this.totalNotes)) * 31) + Integer.hashCode(this.totalCards)) * 31) + this.sampleCards.hashCode()) * 31;
        String str = this.error;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ImportResult(success=" + this.success + ", fileName=" + this.fileName + ", totalDecks=" + this.totalDecks + ", totalNotes=" + this.totalNotes + ", totalCards=" + this.totalCards + ", sampleCards=" + this.sampleCards + ", error=" + this.error + ")";
    }

    public ImportResult(boolean z, String fileName, int i, int i2, int i3, List<CardEntity> sampleCards, String str) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(sampleCards, "sampleCards");
        this.success = z;
        this.fileName = fileName;
        this.totalDecks = i;
        this.totalNotes = i2;
        this.totalCards = i3;
        this.sampleCards = sampleCards;
        this.error = str;
    }

    public /* synthetic */ ImportResult(boolean z, String str, int i, int i2, int i3, List list, String str2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str, i, i2, i3, (i4 & 32) != 0 ? CollectionsKt.emptyList() : list, (i4 & 64) != 0 ? null : str2);
    }
}

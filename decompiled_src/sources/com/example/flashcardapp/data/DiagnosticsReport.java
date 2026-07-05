package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.CardEntity;
import com.example.flashcardapp.data.entities.DeckEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataLayerDiagnostics.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\bHÆ\u0003JS\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bHÆ\u0001J\u0013\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u0006%"}, d2 = {"Lcom/example/flashcardapp/data/DiagnosticsReport;", "", "syncResult", "Lcom/example/flashcardapp/data/SyncResult;", "totalDecks", "", "totalCards", "sampleCards", "", "Lcom/example/flashcardapp/data/entities/CardEntity;", "cachePopulated", "", "allDecks", "Lcom/example/flashcardapp/data/entities/DeckEntity;", "(Lcom/example/flashcardapp/data/SyncResult;IILjava/util/List;ZLjava/util/List;)V", "getAllDecks", "()Ljava/util/List;", "getCachePopulated", "()Z", "getSampleCards", "getSyncResult", "()Lcom/example/flashcardapp/data/SyncResult;", "getTotalCards", "()I", "getTotalDecks", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class DiagnosticsReport {
    public static final int $stable = 8;
    private final List<DeckEntity> allDecks;
    private final boolean cachePopulated;
    private final List<CardEntity> sampleCards;
    private final SyncResult syncResult;
    private final int totalCards;
    private final int totalDecks;

    public static /* synthetic */ DiagnosticsReport copy$default(DiagnosticsReport diagnosticsReport, SyncResult syncResult, int i, int i2, List list, boolean z, List list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            syncResult = diagnosticsReport.syncResult;
        }
        if ((i3 & 2) != 0) {
            i = diagnosticsReport.totalDecks;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = diagnosticsReport.totalCards;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            list = diagnosticsReport.sampleCards;
        }
        List list3 = list;
        if ((i3 & 16) != 0) {
            z = diagnosticsReport.cachePopulated;
        }
        boolean z2 = z;
        if ((i3 & 32) != 0) {
            list2 = diagnosticsReport.allDecks;
        }
        return diagnosticsReport.copy(syncResult, i4, i5, list3, z2, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final SyncResult getSyncResult() {
        return this.syncResult;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTotalDecks() {
        return this.totalDecks;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTotalCards() {
        return this.totalCards;
    }

    public final List<CardEntity> component4() {
        return this.sampleCards;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getCachePopulated() {
        return this.cachePopulated;
    }

    public final List<DeckEntity> component6() {
        return this.allDecks;
    }

    public final DiagnosticsReport copy(SyncResult syncResult, int totalDecks, int totalCards, List<CardEntity> sampleCards, boolean cachePopulated, List<DeckEntity> allDecks) {
        Intrinsics.checkNotNullParameter(sampleCards, "sampleCards");
        Intrinsics.checkNotNullParameter(allDecks, "allDecks");
        return new DiagnosticsReport(syncResult, totalDecks, totalCards, sampleCards, cachePopulated, allDecks);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiagnosticsReport)) {
            return false;
        }
        DiagnosticsReport diagnosticsReport = (DiagnosticsReport) other;
        return Intrinsics.areEqual(this.syncResult, diagnosticsReport.syncResult) && this.totalDecks == diagnosticsReport.totalDecks && this.totalCards == diagnosticsReport.totalCards && Intrinsics.areEqual(this.sampleCards, diagnosticsReport.sampleCards) && this.cachePopulated == diagnosticsReport.cachePopulated && Intrinsics.areEqual(this.allDecks, diagnosticsReport.allDecks);
    }

    public final List<DeckEntity> getAllDecks() {
        return this.allDecks;
    }

    public final boolean getCachePopulated() {
        return this.cachePopulated;
    }

    public final List<CardEntity> getSampleCards() {
        return this.sampleCards;
    }

    public final SyncResult getSyncResult() {
        return this.syncResult;
    }

    public final int getTotalCards() {
        return this.totalCards;
    }

    public final int getTotalDecks() {
        return this.totalDecks;
    }

    public int hashCode() {
        SyncResult syncResult = this.syncResult;
        return ((((((((((syncResult == null ? 0 : syncResult.hashCode()) * 31) + Integer.hashCode(this.totalDecks)) * 31) + Integer.hashCode(this.totalCards)) * 31) + this.sampleCards.hashCode()) * 31) + Boolean.hashCode(this.cachePopulated)) * 31) + this.allDecks.hashCode();
    }

    public String toString() {
        return "DiagnosticsReport(syncResult=" + this.syncResult + ", totalDecks=" + this.totalDecks + ", totalCards=" + this.totalCards + ", sampleCards=" + this.sampleCards + ", cachePopulated=" + this.cachePopulated + ", allDecks=" + this.allDecks + ")";
    }

    public DiagnosticsReport(SyncResult syncResult, int i, int i2, List<CardEntity> sampleCards, boolean z, List<DeckEntity> allDecks) {
        Intrinsics.checkNotNullParameter(sampleCards, "sampleCards");
        Intrinsics.checkNotNullParameter(allDecks, "allDecks");
        this.syncResult = syncResult;
        this.totalDecks = i;
        this.totalCards = i2;
        this.sampleCards = sampleCards;
        this.cachePopulated = z;
        this.allDecks = allDecks;
    }
}

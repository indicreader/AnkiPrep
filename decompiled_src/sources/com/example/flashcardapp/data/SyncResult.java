package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnkiDataRepository.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/example/flashcardapp/data/SyncResult;", "", "success", "", "totalDecks", "", "totalCards", "durationMs", "", "error", "", "(ZIIJLjava/lang/String;)V", "getDurationMs", "()J", "getError", "()Ljava/lang/String;", "getSuccess", "()Z", "getTotalCards", "()I", "getTotalDecks", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class SyncResult {
    public static final int $stable = 0;
    private final long durationMs;
    private final String error;
    private final boolean success;
    private final int totalCards;
    private final int totalDecks;

    public static /* synthetic */ SyncResult copy$default(SyncResult syncResult, boolean z, int i, int i2, long j, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = syncResult.success;
        }
        if ((i3 & 2) != 0) {
            i = syncResult.totalDecks;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = syncResult.totalCards;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            j = syncResult.durationMs;
        }
        long j2 = j;
        if ((i3 & 16) != 0) {
            str = syncResult.error;
        }
        return syncResult.copy(z, i4, i5, j2, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTotalDecks() {
        return this.totalDecks;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTotalCards() {
        return this.totalCards;
    }

    /* renamed from: component4, reason: from getter */
    public final long getDurationMs() {
        return this.durationMs;
    }

    /* renamed from: component5, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final SyncResult copy(boolean success, int totalDecks, int totalCards, long durationMs, String error) {
        return new SyncResult(success, totalDecks, totalCards, durationMs, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SyncResult)) {
            return false;
        }
        SyncResult syncResult = (SyncResult) other;
        return this.success == syncResult.success && this.totalDecks == syncResult.totalDecks && this.totalCards == syncResult.totalCards && this.durationMs == syncResult.durationMs && Intrinsics.areEqual(this.error, syncResult.error);
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    public final String getError() {
        return this.error;
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

    public int hashCode() {
        int hashCode = ((((((Boolean.hashCode(this.success) * 31) + Integer.hashCode(this.totalDecks)) * 31) + Integer.hashCode(this.totalCards)) * 31) + Long.hashCode(this.durationMs)) * 31;
        String str = this.error;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SyncResult(success=" + this.success + ", totalDecks=" + this.totalDecks + ", totalCards=" + this.totalCards + ", durationMs=" + this.durationMs + ", error=" + this.error + ")";
    }

    public SyncResult(boolean z, int i, int i2, long j, String str) {
        this.success = z;
        this.totalDecks = i;
        this.totalCards = i2;
        this.durationMs = j;
        this.error = str;
    }

    public /* synthetic */ SyncResult(boolean z, int i, int i2, long j, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, i2, j, (i3 & 16) != 0 ? null : str);
    }
}

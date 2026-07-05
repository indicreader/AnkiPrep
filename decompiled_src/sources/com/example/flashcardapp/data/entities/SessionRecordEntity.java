package com.example.flashcardapp.data.entities;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionRecordEntity.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003JY\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\tHÖ\u0001J\t\u0010&\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u0006'"}, d2 = {"Lcom/example/flashcardapp/data/entities/SessionRecordEntity;", "", "id", "", "deckId", "deckName", "", "mode", "score", "", "totalQuestions", "timeTakenSeconds", "timestamp", "(JJLjava/lang/String;Ljava/lang/String;IIJJ)V", "getDeckId", "()J", "getDeckName", "()Ljava/lang/String;", "getId", "getMode", "getScore", "()I", "getTimeTakenSeconds", "getTimestamp", "getTotalQuestions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class SessionRecordEntity {
    public static final int $stable = 0;
    private final long deckId;
    private final String deckName;
    private final long id;
    private final String mode;
    private final int score;
    private final long timeTakenSeconds;
    private final long timestamp;
    private final int totalQuestions;

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDeckId() {
        return this.deckId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDeckName() {
        return this.deckName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* renamed from: component5, reason: from getter */
    public final int getScore() {
        return this.score;
    }

    /* renamed from: component6, reason: from getter */
    public final int getTotalQuestions() {
        return this.totalQuestions;
    }

    /* renamed from: component7, reason: from getter */
    public final long getTimeTakenSeconds() {
        return this.timeTakenSeconds;
    }

    /* renamed from: component8, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final SessionRecordEntity copy(long id, long deckId, String deckName, String mode, int score, int totalQuestions, long timeTakenSeconds, long timestamp) {
        Intrinsics.checkNotNullParameter(deckName, "deckName");
        Intrinsics.checkNotNullParameter(mode, "mode");
        return new SessionRecordEntity(id, deckId, deckName, mode, score, totalQuestions, timeTakenSeconds, timestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionRecordEntity)) {
            return false;
        }
        SessionRecordEntity sessionRecordEntity = (SessionRecordEntity) other;
        return this.id == sessionRecordEntity.id && this.deckId == sessionRecordEntity.deckId && Intrinsics.areEqual(this.deckName, sessionRecordEntity.deckName) && Intrinsics.areEqual(this.mode, sessionRecordEntity.mode) && this.score == sessionRecordEntity.score && this.totalQuestions == sessionRecordEntity.totalQuestions && this.timeTakenSeconds == sessionRecordEntity.timeTakenSeconds && this.timestamp == sessionRecordEntity.timestamp;
    }

    public final long getDeckId() {
        return this.deckId;
    }

    public final String getDeckName() {
        return this.deckName;
    }

    public final long getId() {
        return this.id;
    }

    public final String getMode() {
        return this.mode;
    }

    public final int getScore() {
        return this.score;
    }

    public final long getTimeTakenSeconds() {
        return this.timeTakenSeconds;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final int getTotalQuestions() {
        return this.totalQuestions;
    }

    public int hashCode() {
        return (((((((((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.deckId)) * 31) + this.deckName.hashCode()) * 31) + this.mode.hashCode()) * 31) + Integer.hashCode(this.score)) * 31) + Integer.hashCode(this.totalQuestions)) * 31) + Long.hashCode(this.timeTakenSeconds)) * 31) + Long.hashCode(this.timestamp);
    }

    public String toString() {
        return "SessionRecordEntity(id=" + this.id + ", deckId=" + this.deckId + ", deckName=" + this.deckName + ", mode=" + this.mode + ", score=" + this.score + ", totalQuestions=" + this.totalQuestions + ", timeTakenSeconds=" + this.timeTakenSeconds + ", timestamp=" + this.timestamp + ")";
    }

    public SessionRecordEntity(long j, long j2, String deckName, String mode, int i, int i2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(deckName, "deckName");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.id = j;
        this.deckId = j2;
        this.deckName = deckName;
        this.mode = mode;
        this.score = i;
        this.totalQuestions = i2;
        this.timeTakenSeconds = j3;
        this.timestamp = j4;
    }

    public /* synthetic */ SessionRecordEntity(long j, long j2, String str, String str2, int i, int i2, long j3, long j4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j, j2, str, str2, i, i2, j3, (i3 & 128) != 0 ? System.currentTimeMillis() : j4);
    }
}

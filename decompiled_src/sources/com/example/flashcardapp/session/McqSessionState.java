package com.example.flashcardapp.session;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.app.NotificationCompat;
import com.example.flashcardapp.mcq.Mcq;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: McqSession.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\r\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005HÆ\u0003J\u0015\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\rHÆ\u0003J\u0015\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\rHÆ\u0003J\t\u00100\u001a\u00020\u000fHÆ\u0003J\t\u00101\u001a\u00020\u0012HÆ\u0003J\u0087\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u00103\u001a\u00020\u00122\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0015\u00105\u001a\u0004\u0018\u00010\b2\u0006\u00106\u001a\u00020\b¢\u0006\u0002\u00107J\t\u00108\u001a\u00020\bHÖ\u0001J\u000e\u00109\u001a\u00020\u00122\u0006\u00106\u001a\u00020\bJ\t\u0010:\u001a\u00020;HÖ\u0001R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006<"}, d2 = {"Lcom/example/flashcardapp/session/McqSessionState;", "", "mode", "Lcom/example/flashcardapp/session/McqSessionMode;", "questions", "", "Lcom/example/flashcardapp/mcq/Mcq;", "currentQuestionIndex", "", "score", "answeredQuestions", "Lcom/example/flashcardapp/session/AnswerRecord;", "selections", "", "questionTimingsMs", "", "totalTimeTakenMs", "isFinished", "", "(Lcom/example/flashcardapp/session/McqSessionMode;Ljava/util/List;IILjava/util/List;Ljava/util/Map;Ljava/util/Map;JZ)V", "getAnsweredQuestions", "()Ljava/util/List;", "currentQuestion", "getCurrentQuestion", "()Lcom/example/flashcardapp/mcq/Mcq;", "getCurrentQuestionIndex", "()I", "()Z", "getMode", "()Lcom/example/flashcardapp/session/McqSessionMode;", NotificationCompat.CATEGORY_PROGRESS, "", "getProgress", "()F", "getQuestionTimingsMs", "()Ljava/util/Map;", "getQuestions", "getScore", "getSelections", "getTotalTimeTakenMs", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getSelectionForIndex", "index", "(I)Ljava/lang/Integer;", "hashCode", "isQuestionAnswered", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class McqSessionState {
    public static final int $stable = 8;
    private final List<AnswerRecord> answeredQuestions;
    private final int currentQuestionIndex;
    private final boolean isFinished;
    private final McqSessionMode mode;
    private final Map<Integer, Long> questionTimingsMs;
    private final List<Mcq> questions;
    private final int score;
    private final Map<Integer, Integer> selections;
    private final long totalTimeTakenMs;

    public McqSessionState() {
        this(null, null, 0, 0, null, null, null, 0L, false, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    /* renamed from: component1, reason: from getter */
    public final McqSessionMode getMode() {
        return this.mode;
    }

    public final List<Mcq> component2() {
        return this.questions;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCurrentQuestionIndex() {
        return this.currentQuestionIndex;
    }

    /* renamed from: component4, reason: from getter */
    public final int getScore() {
        return this.score;
    }

    public final List<AnswerRecord> component5() {
        return this.answeredQuestions;
    }

    public final Map<Integer, Integer> component6() {
        return this.selections;
    }

    public final Map<Integer, Long> component7() {
        return this.questionTimingsMs;
    }

    /* renamed from: component8, reason: from getter */
    public final long getTotalTimeTakenMs() {
        return this.totalTimeTakenMs;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsFinished() {
        return this.isFinished;
    }

    public final McqSessionState copy(McqSessionMode mode, List<Mcq> questions, int currentQuestionIndex, int score, List<AnswerRecord> answeredQuestions, Map<Integer, Integer> selections, Map<Integer, Long> questionTimingsMs, long totalTimeTakenMs, boolean isFinished) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(questions, "questions");
        Intrinsics.checkNotNullParameter(answeredQuestions, "answeredQuestions");
        Intrinsics.checkNotNullParameter(selections, "selections");
        Intrinsics.checkNotNullParameter(questionTimingsMs, "questionTimingsMs");
        return new McqSessionState(mode, questions, currentQuestionIndex, score, answeredQuestions, selections, questionTimingsMs, totalTimeTakenMs, isFinished);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof McqSessionState)) {
            return false;
        }
        McqSessionState mcqSessionState = (McqSessionState) other;
        return this.mode == mcqSessionState.mode && Intrinsics.areEqual(this.questions, mcqSessionState.questions) && this.currentQuestionIndex == mcqSessionState.currentQuestionIndex && this.score == mcqSessionState.score && Intrinsics.areEqual(this.answeredQuestions, mcqSessionState.answeredQuestions) && Intrinsics.areEqual(this.selections, mcqSessionState.selections) && Intrinsics.areEqual(this.questionTimingsMs, mcqSessionState.questionTimingsMs) && this.totalTimeTakenMs == mcqSessionState.totalTimeTakenMs && this.isFinished == mcqSessionState.isFinished;
    }

    public final List<AnswerRecord> getAnsweredQuestions() {
        return this.answeredQuestions;
    }

    public final int getCurrentQuestionIndex() {
        return this.currentQuestionIndex;
    }

    public final McqSessionMode getMode() {
        return this.mode;
    }

    public final Map<Integer, Long> getQuestionTimingsMs() {
        return this.questionTimingsMs;
    }

    public final List<Mcq> getQuestions() {
        return this.questions;
    }

    public final int getScore() {
        return this.score;
    }

    public final Map<Integer, Integer> getSelections() {
        return this.selections;
    }

    public final long getTotalTimeTakenMs() {
        return this.totalTimeTakenMs;
    }

    public int hashCode() {
        return (((((((((((((((this.mode.hashCode() * 31) + this.questions.hashCode()) * 31) + Integer.hashCode(this.currentQuestionIndex)) * 31) + Integer.hashCode(this.score)) * 31) + this.answeredQuestions.hashCode()) * 31) + this.selections.hashCode()) * 31) + this.questionTimingsMs.hashCode()) * 31) + Long.hashCode(this.totalTimeTakenMs)) * 31) + Boolean.hashCode(this.isFinished);
    }

    public final boolean isFinished() {
        return this.isFinished;
    }

    public String toString() {
        return "McqSessionState(mode=" + this.mode + ", questions=" + this.questions + ", currentQuestionIndex=" + this.currentQuestionIndex + ", score=" + this.score + ", answeredQuestions=" + this.answeredQuestions + ", selections=" + this.selections + ", questionTimingsMs=" + this.questionTimingsMs + ", totalTimeTakenMs=" + this.totalTimeTakenMs + ", isFinished=" + this.isFinished + ")";
    }

    public McqSessionState(McqSessionMode mode, List<Mcq> questions, int i, int i2, List<AnswerRecord> answeredQuestions, Map<Integer, Integer> selections, Map<Integer, Long> questionTimingsMs, long j, boolean z) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(questions, "questions");
        Intrinsics.checkNotNullParameter(answeredQuestions, "answeredQuestions");
        Intrinsics.checkNotNullParameter(selections, "selections");
        Intrinsics.checkNotNullParameter(questionTimingsMs, "questionTimingsMs");
        this.mode = mode;
        this.questions = questions;
        this.currentQuestionIndex = i;
        this.score = i2;
        this.answeredQuestions = answeredQuestions;
        this.selections = selections;
        this.questionTimingsMs = questionTimingsMs;
        this.totalTimeTakenMs = j;
        this.isFinished = z;
    }

    public /* synthetic */ McqSessionState(McqSessionMode mcqSessionMode, List list, int i, int i2, List list2, Map map, Map map2, long j, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? McqSessionMode.PRACTICE : mcqSessionMode, (i3 & 2) != 0 ? CollectionsKt.emptyList() : list, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2, (i3 & 16) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 32) != 0 ? MapsKt.emptyMap() : map, (i3 & 64) != 0 ? MapsKt.emptyMap() : map2, (i3 & 128) != 0 ? 0L : j, (i3 & 256) == 0 ? z : false);
    }

    public final Mcq getCurrentQuestion() {
        return (Mcq) CollectionsKt.getOrNull(this.questions, this.currentQuestionIndex);
    }

    public final float getProgress() {
        if (this.questions.isEmpty()) {
            return 0.0f;
        }
        return this.currentQuestionIndex / this.questions.size();
    }

    public final Integer getSelectionForIndex(int index) {
        return this.selections.get(Integer.valueOf(index));
    }

    public final boolean isQuestionAnswered(int index) {
        return this.selections.containsKey(Integer.valueOf(index));
    }
}

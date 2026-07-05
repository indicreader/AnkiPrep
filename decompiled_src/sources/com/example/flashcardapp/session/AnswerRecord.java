package com.example.flashcardapp.session;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.mcq.Mcq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: McqSession.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\tHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/example/flashcardapp/session/AnswerRecord;", "", "question", "Lcom/example/flashcardapp/mcq/Mcq;", "selectedOptionIndex", "", "isCorrect", "", "timeTakenMs", "", "(Lcom/example/flashcardapp/mcq/Mcq;IZJ)V", "()Z", "getQuestion", "()Lcom/example/flashcardapp/mcq/Mcq;", "getSelectedOptionIndex", "()I", "getTimeTakenMs", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class AnswerRecord {
    public static final int $stable = 8;
    private final boolean isCorrect;
    private final Mcq question;
    private final int selectedOptionIndex;
    private final long timeTakenMs;

    public static /* synthetic */ AnswerRecord copy$default(AnswerRecord answerRecord, Mcq mcq, int i, boolean z, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mcq = answerRecord.question;
        }
        if ((i2 & 2) != 0) {
            i = answerRecord.selectedOptionIndex;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            z = answerRecord.isCorrect;
        }
        boolean z2 = z;
        if ((i2 & 8) != 0) {
            j = answerRecord.timeTakenMs;
        }
        return answerRecord.copy(mcq, i3, z2, j);
    }

    /* renamed from: component1, reason: from getter */
    public final Mcq getQuestion() {
        return this.question;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSelectedOptionIndex() {
        return this.selectedOptionIndex;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsCorrect() {
        return this.isCorrect;
    }

    /* renamed from: component4, reason: from getter */
    public final long getTimeTakenMs() {
        return this.timeTakenMs;
    }

    public final AnswerRecord copy(Mcq question, int selectedOptionIndex, boolean isCorrect, long timeTakenMs) {
        Intrinsics.checkNotNullParameter(question, "question");
        return new AnswerRecord(question, selectedOptionIndex, isCorrect, timeTakenMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnswerRecord)) {
            return false;
        }
        AnswerRecord answerRecord = (AnswerRecord) other;
        return Intrinsics.areEqual(this.question, answerRecord.question) && this.selectedOptionIndex == answerRecord.selectedOptionIndex && this.isCorrect == answerRecord.isCorrect && this.timeTakenMs == answerRecord.timeTakenMs;
    }

    public final Mcq getQuestion() {
        return this.question;
    }

    public final int getSelectedOptionIndex() {
        return this.selectedOptionIndex;
    }

    public final long getTimeTakenMs() {
        return this.timeTakenMs;
    }

    public int hashCode() {
        return (((((this.question.hashCode() * 31) + Integer.hashCode(this.selectedOptionIndex)) * 31) + Boolean.hashCode(this.isCorrect)) * 31) + Long.hashCode(this.timeTakenMs);
    }

    public final boolean isCorrect() {
        return this.isCorrect;
    }

    public String toString() {
        return "AnswerRecord(question=" + this.question + ", selectedOptionIndex=" + this.selectedOptionIndex + ", isCorrect=" + this.isCorrect + ", timeTakenMs=" + this.timeTakenMs + ")";
    }

    public AnswerRecord(Mcq question, int i, boolean z, long j) {
        Intrinsics.checkNotNullParameter(question, "question");
        this.question = question;
        this.selectedOptionIndex = i;
        this.isCorrect = z;
        this.timeTakenMs = j;
    }
}

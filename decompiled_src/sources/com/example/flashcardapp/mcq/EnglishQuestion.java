package com.example.flashcardapp.mcq;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnglishEngine.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/example/flashcardapp/mcq/EnglishQuestion;", "", "conceptId", "", "type", "wordOrSentence", "correctAnswer", "meaning", "associatedWords", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAssociatedWords", "()Ljava/lang/String;", "getConceptId", "getCorrectAnswer", "getMeaning", "getType", "getWordOrSentence", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class EnglishQuestion {
    public static final int $stable = 0;
    private final String associatedWords;
    private final String conceptId;
    private final String correctAnswer;
    private final String meaning;
    private final String type;
    private final String wordOrSentence;

    public static /* synthetic */ EnglishQuestion copy$default(EnglishQuestion englishQuestion, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = englishQuestion.conceptId;
        }
        if ((i & 2) != 0) {
            str2 = englishQuestion.type;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = englishQuestion.wordOrSentence;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = englishQuestion.correctAnswer;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = englishQuestion.meaning;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = englishQuestion.associatedWords;
        }
        return englishQuestion.copy(str, str7, str8, str9, str10, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getConceptId() {
        return this.conceptId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getWordOrSentence() {
        return this.wordOrSentence;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCorrectAnswer() {
        return this.correctAnswer;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMeaning() {
        return this.meaning;
    }

    /* renamed from: component6, reason: from getter */
    public final String getAssociatedWords() {
        return this.associatedWords;
    }

    public final EnglishQuestion copy(String conceptId, String type, String wordOrSentence, String correctAnswer, String meaning, String associatedWords) {
        Intrinsics.checkNotNullParameter(conceptId, "conceptId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(wordOrSentence, "wordOrSentence");
        Intrinsics.checkNotNullParameter(correctAnswer, "correctAnswer");
        Intrinsics.checkNotNullParameter(meaning, "meaning");
        Intrinsics.checkNotNullParameter(associatedWords, "associatedWords");
        return new EnglishQuestion(conceptId, type, wordOrSentence, correctAnswer, meaning, associatedWords);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnglishQuestion)) {
            return false;
        }
        EnglishQuestion englishQuestion = (EnglishQuestion) other;
        return Intrinsics.areEqual(this.conceptId, englishQuestion.conceptId) && Intrinsics.areEqual(this.type, englishQuestion.type) && Intrinsics.areEqual(this.wordOrSentence, englishQuestion.wordOrSentence) && Intrinsics.areEqual(this.correctAnswer, englishQuestion.correctAnswer) && Intrinsics.areEqual(this.meaning, englishQuestion.meaning) && Intrinsics.areEqual(this.associatedWords, englishQuestion.associatedWords);
    }

    public final String getAssociatedWords() {
        return this.associatedWords;
    }

    public final String getConceptId() {
        return this.conceptId;
    }

    public final String getCorrectAnswer() {
        return this.correctAnswer;
    }

    public final String getMeaning() {
        return this.meaning;
    }

    public final String getType() {
        return this.type;
    }

    public final String getWordOrSentence() {
        return this.wordOrSentence;
    }

    public int hashCode() {
        return (((((((((this.conceptId.hashCode() * 31) + this.type.hashCode()) * 31) + this.wordOrSentence.hashCode()) * 31) + this.correctAnswer.hashCode()) * 31) + this.meaning.hashCode()) * 31) + this.associatedWords.hashCode();
    }

    public String toString() {
        return "EnglishQuestion(conceptId=" + this.conceptId + ", type=" + this.type + ", wordOrSentence=" + this.wordOrSentence + ", correctAnswer=" + this.correctAnswer + ", meaning=" + this.meaning + ", associatedWords=" + this.associatedWords + ")";
    }

    public EnglishQuestion(String conceptId, String type, String wordOrSentence, String correctAnswer, String meaning, String associatedWords) {
        Intrinsics.checkNotNullParameter(conceptId, "conceptId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(wordOrSentence, "wordOrSentence");
        Intrinsics.checkNotNullParameter(correctAnswer, "correctAnswer");
        Intrinsics.checkNotNullParameter(meaning, "meaning");
        Intrinsics.checkNotNullParameter(associatedWords, "associatedWords");
        this.conceptId = conceptId;
        this.type = type;
        this.wordOrSentence = wordOrSentence;
        this.correctAnswer = correctAnswer;
        this.meaning = meaning;
        this.associatedWords = associatedWords;
    }
}

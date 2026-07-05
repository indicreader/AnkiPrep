package com.example.flashcardapp.mcq;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Mcq.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0014J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J¯\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0007HÖ\u0001J\u0006\u0010<\u001a\u000209J\u0006\u0010=\u001a\u00020\u0003J\t\u0010>\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001f¨\u0006?"}, d2 = {"Lcom/example/flashcardapp/mcq/Mcq;", "", "question", "", "options", "", "correctIndex", "", "sourceCardId", "", "distractorSourceIds", "deckHierarchy", "explanation", "difficulty", "answerType", "tags", "frontImage", "backImage", "explanationImage", "optionImagesJson", "(Ljava/lang/String;Ljava/util/List;IJLjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAnswerType", "()Ljava/lang/String;", "getBackImage", "correctAnswer", "getCorrectAnswer", "getCorrectIndex", "()I", "getDeckHierarchy", "getDifficulty", "getDistractorSourceIds", "()Ljava/util/List;", "getExplanation", "getExplanationImage", "getFrontImage", "getOptionImagesJson", "getOptions", "getQuestion", "getSourceCardId", "()J", "getTags", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "isValid", "toJsonString", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class Mcq {
    public static final int $stable = 8;
    private final String answerType;
    private final String backImage;
    private final int correctIndex;
    private final String deckHierarchy;
    private final String difficulty;
    private final List<Long> distractorSourceIds;
    private final String explanation;
    private final String explanationImage;
    private final String frontImage;
    private final String optionImagesJson;
    private final List<String> options;
    private final String question;
    private final long sourceCardId;
    private final List<String> tags;

    /* renamed from: component1, reason: from getter */
    public final String getQuestion() {
        return this.question;
    }

    public final List<String> component10() {
        return this.tags;
    }

    /* renamed from: component11, reason: from getter */
    public final String getFrontImage() {
        return this.frontImage;
    }

    /* renamed from: component12, reason: from getter */
    public final String getBackImage() {
        return this.backImage;
    }

    /* renamed from: component13, reason: from getter */
    public final String getExplanationImage() {
        return this.explanationImage;
    }

    /* renamed from: component14, reason: from getter */
    public final String getOptionImagesJson() {
        return this.optionImagesJson;
    }

    public final List<String> component2() {
        return this.options;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCorrectIndex() {
        return this.correctIndex;
    }

    /* renamed from: component4, reason: from getter */
    public final long getSourceCardId() {
        return this.sourceCardId;
    }

    public final List<Long> component5() {
        return this.distractorSourceIds;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDeckHierarchy() {
        return this.deckHierarchy;
    }

    /* renamed from: component7, reason: from getter */
    public final String getExplanation() {
        return this.explanation;
    }

    /* renamed from: component8, reason: from getter */
    public final String getDifficulty() {
        return this.difficulty;
    }

    /* renamed from: component9, reason: from getter */
    public final String getAnswerType() {
        return this.answerType;
    }

    public final Mcq copy(String question, List<String> options, int correctIndex, long sourceCardId, List<Long> distractorSourceIds, String deckHierarchy, String explanation, String difficulty, String answerType, List<String> tags, String frontImage, String backImage, String explanationImage, String optionImagesJson) {
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(distractorSourceIds, "distractorSourceIds");
        Intrinsics.checkNotNullParameter(deckHierarchy, "deckHierarchy");
        Intrinsics.checkNotNullParameter(explanation, "explanation");
        Intrinsics.checkNotNullParameter(difficulty, "difficulty");
        Intrinsics.checkNotNullParameter(answerType, "answerType");
        Intrinsics.checkNotNullParameter(tags, "tags");
        return new Mcq(question, options, correctIndex, sourceCardId, distractorSourceIds, deckHierarchy, explanation, difficulty, answerType, tags, frontImage, backImage, explanationImage, optionImagesJson);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Mcq)) {
            return false;
        }
        Mcq mcq = (Mcq) other;
        return Intrinsics.areEqual(this.question, mcq.question) && Intrinsics.areEqual(this.options, mcq.options) && this.correctIndex == mcq.correctIndex && this.sourceCardId == mcq.sourceCardId && Intrinsics.areEqual(this.distractorSourceIds, mcq.distractorSourceIds) && Intrinsics.areEqual(this.deckHierarchy, mcq.deckHierarchy) && Intrinsics.areEqual(this.explanation, mcq.explanation) && Intrinsics.areEqual(this.difficulty, mcq.difficulty) && Intrinsics.areEqual(this.answerType, mcq.answerType) && Intrinsics.areEqual(this.tags, mcq.tags) && Intrinsics.areEqual(this.frontImage, mcq.frontImage) && Intrinsics.areEqual(this.backImage, mcq.backImage) && Intrinsics.areEqual(this.explanationImage, mcq.explanationImage) && Intrinsics.areEqual(this.optionImagesJson, mcq.optionImagesJson);
    }

    public final String getAnswerType() {
        return this.answerType;
    }

    public final String getBackImage() {
        return this.backImage;
    }

    public final int getCorrectIndex() {
        return this.correctIndex;
    }

    public final String getDeckHierarchy() {
        return this.deckHierarchy;
    }

    public final String getDifficulty() {
        return this.difficulty;
    }

    public final List<Long> getDistractorSourceIds() {
        return this.distractorSourceIds;
    }

    public final String getExplanation() {
        return this.explanation;
    }

    public final String getExplanationImage() {
        return this.explanationImage;
    }

    public final String getFrontImage() {
        return this.frontImage;
    }

    public final String getOptionImagesJson() {
        return this.optionImagesJson;
    }

    public final List<String> getOptions() {
        return this.options;
    }

    public final String getQuestion() {
        return this.question;
    }

    public final long getSourceCardId() {
        return this.sourceCardId;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((this.question.hashCode() * 31) + this.options.hashCode()) * 31) + Integer.hashCode(this.correctIndex)) * 31) + Long.hashCode(this.sourceCardId)) * 31) + this.distractorSourceIds.hashCode()) * 31) + this.deckHierarchy.hashCode()) * 31) + this.explanation.hashCode()) * 31) + this.difficulty.hashCode()) * 31) + this.answerType.hashCode()) * 31) + this.tags.hashCode()) * 31;
        String str = this.frontImage;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.backImage;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.explanationImage;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.optionImagesJson;
        return hashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "Mcq(question=" + this.question + ", options=" + this.options + ", correctIndex=" + this.correctIndex + ", sourceCardId=" + this.sourceCardId + ", distractorSourceIds=" + this.distractorSourceIds + ", deckHierarchy=" + this.deckHierarchy + ", explanation=" + this.explanation + ", difficulty=" + this.difficulty + ", answerType=" + this.answerType + ", tags=" + this.tags + ", frontImage=" + this.frontImage + ", backImage=" + this.backImage + ", explanationImage=" + this.explanationImage + ", optionImagesJson=" + this.optionImagesJson + ")";
    }

    public Mcq(String question, List<String> options, int i, long j, List<Long> distractorSourceIds, String deckHierarchy, String explanation, String difficulty, String answerType, List<String> tags, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(distractorSourceIds, "distractorSourceIds");
        Intrinsics.checkNotNullParameter(deckHierarchy, "deckHierarchy");
        Intrinsics.checkNotNullParameter(explanation, "explanation");
        Intrinsics.checkNotNullParameter(difficulty, "difficulty");
        Intrinsics.checkNotNullParameter(answerType, "answerType");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.question = question;
        this.options = options;
        this.correctIndex = i;
        this.sourceCardId = j;
        this.distractorSourceIds = distractorSourceIds;
        this.deckHierarchy = deckHierarchy;
        this.explanation = explanation;
        this.difficulty = difficulty;
        this.answerType = answerType;
        this.tags = tags;
        this.frontImage = str;
        this.backImage = str2;
        this.explanationImage = str3;
        this.optionImagesJson = str4;
    }

    public /* synthetic */ Mcq(String str, List list, int i, long j, List list2, String str2, String str3, String str4, String str5, List list3, String str6, String str7, String str8, String str9, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, i, j, list2, str2, str3, (i2 & 128) != 0 ? "medium" : str4, (i2 & 256) != 0 ? "concept" : str5, (i2 & 512) != 0 ? CollectionsKt.emptyList() : list3, (i2 & 1024) != 0 ? null : str6, (i2 & 2048) != 0 ? null : str7, (i2 & 4096) != 0 ? null : str8, (i2 & 8192) != 0 ? null : str9);
    }

    public final String getCorrectAnswer() {
        return this.options.get(this.correctIndex);
    }

    public final String toJsonString() {
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(MapsKt.mapOf(TuplesKt.to("question", this.question), TuplesKt.to("correct_answer", getCorrectAnswer()), TuplesKt.to("options", this.options), TuplesKt.to("difficulty", this.difficulty), TuplesKt.to("answer_type", this.answerType)));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    public final boolean isValid() {
        int i;
        int size = this.options.size();
        if (size < 2 || (i = this.correctIndex) < 0 || i >= size || this.distractorSourceIds.size() != size - 1) {
            return false;
        }
        List<String> list = this.options;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String lowerCase = StringsKt.trim((CharSequence) it.next()).toString().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            arrayList.add(lowerCase);
        }
        return CollectionsKt.distinct(arrayList).size() == size;
    }
}

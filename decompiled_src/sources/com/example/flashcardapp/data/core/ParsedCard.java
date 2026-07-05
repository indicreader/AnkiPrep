package com.example.flashcardapp.data.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StructuredParser.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\u0015\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003Jg\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006%"}, d2 = {"Lcom/example/flashcardapp/data/core/ParsedCard;", "", "question", "", "answer", "explanation", "hints", "", "metadata", "", "options", "rawContent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Ljava/lang/String;)V", "getAnswer", "()Ljava/lang/String;", "getExplanation", "getHints", "()Ljava/util/List;", "getMetadata", "()Ljava/util/Map;", "getOptions", "getQuestion", "getRawContent", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class ParsedCard {
    public static final int $stable = 8;
    private final String answer;
    private final String explanation;
    private final List<String> hints;
    private final Map<String, String> metadata;
    private final List<String> options;
    private final String question;
    private final String rawContent;

    public static /* synthetic */ ParsedCard copy$default(ParsedCard parsedCard, String str, String str2, String str3, List list, Map map, List list2, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = parsedCard.question;
        }
        if ((i & 2) != 0) {
            str2 = parsedCard.answer;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = parsedCard.explanation;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            list = parsedCard.hints;
        }
        List list3 = list;
        if ((i & 16) != 0) {
            map = parsedCard.metadata;
        }
        Map map2 = map;
        if ((i & 32) != 0) {
            list2 = parsedCard.options;
        }
        List list4 = list2;
        if ((i & 64) != 0) {
            str4 = parsedCard.rawContent;
        }
        return parsedCard.copy(str, str5, str6, list3, map2, list4, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getQuestion() {
        return this.question;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAnswer() {
        return this.answer;
    }

    /* renamed from: component3, reason: from getter */
    public final String getExplanation() {
        return this.explanation;
    }

    public final List<String> component4() {
        return this.hints;
    }

    public final Map<String, String> component5() {
        return this.metadata;
    }

    public final List<String> component6() {
        return this.options;
    }

    /* renamed from: component7, reason: from getter */
    public final String getRawContent() {
        return this.rawContent;
    }

    public final ParsedCard copy(String question, String answer, String explanation, List<String> hints, Map<String, String> metadata, List<String> options, String rawContent) {
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(answer, "answer");
        Intrinsics.checkNotNullParameter(explanation, "explanation");
        Intrinsics.checkNotNullParameter(hints, "hints");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(rawContent, "rawContent");
        return new ParsedCard(question, answer, explanation, hints, metadata, options, rawContent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParsedCard)) {
            return false;
        }
        ParsedCard parsedCard = (ParsedCard) other;
        return Intrinsics.areEqual(this.question, parsedCard.question) && Intrinsics.areEqual(this.answer, parsedCard.answer) && Intrinsics.areEqual(this.explanation, parsedCard.explanation) && Intrinsics.areEqual(this.hints, parsedCard.hints) && Intrinsics.areEqual(this.metadata, parsedCard.metadata) && Intrinsics.areEqual(this.options, parsedCard.options) && Intrinsics.areEqual(this.rawContent, parsedCard.rawContent);
    }

    public final String getAnswer() {
        return this.answer;
    }

    public final String getExplanation() {
        return this.explanation;
    }

    public final List<String> getHints() {
        return this.hints;
    }

    public final Map<String, String> getMetadata() {
        return this.metadata;
    }

    public final List<String> getOptions() {
        return this.options;
    }

    public final String getQuestion() {
        return this.question;
    }

    public final String getRawContent() {
        return this.rawContent;
    }

    public int hashCode() {
        return (((((((((((this.question.hashCode() * 31) + this.answer.hashCode()) * 31) + this.explanation.hashCode()) * 31) + this.hints.hashCode()) * 31) + this.metadata.hashCode()) * 31) + this.options.hashCode()) * 31) + this.rawContent.hashCode();
    }

    public String toString() {
        return "ParsedCard(question=" + this.question + ", answer=" + this.answer + ", explanation=" + this.explanation + ", hints=" + this.hints + ", metadata=" + this.metadata + ", options=" + this.options + ", rawContent=" + this.rawContent + ")";
    }

    public ParsedCard(String question, String answer, String explanation, List<String> hints, Map<String, String> metadata, List<String> options, String rawContent) {
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(answer, "answer");
        Intrinsics.checkNotNullParameter(explanation, "explanation");
        Intrinsics.checkNotNullParameter(hints, "hints");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(rawContent, "rawContent");
        this.question = question;
        this.answer = answer;
        this.explanation = explanation;
        this.hints = hints;
        this.metadata = metadata;
        this.options = options;
        this.rawContent = rawContent;
    }

    public /* synthetic */ ParsedCard(String str, String str2, String str3, List list, Map map, List list2, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, str2, str3, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? MapsKt.emptyMap() : map, (i & 32) != 0 ? CollectionsKt.emptyList() : list2, str4);
    }
}

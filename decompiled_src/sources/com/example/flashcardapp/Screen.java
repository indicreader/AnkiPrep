package com.example.flashcardapp;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.AnkiDeck;
import com.example.flashcardapp.session.AnswerRecord;
import com.example.flashcardapp.session.McqSessionMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/example/flashcardapp/Screen;", "", "()V", "AliasEditor", "DeckSelection", "Profile", "Quiz", "Results", "ReviewMistakes", "Settings", "Lcom/example/flashcardapp/Screen$AliasEditor;", "Lcom/example/flashcardapp/Screen$DeckSelection;", "Lcom/example/flashcardapp/Screen$Profile;", "Lcom/example/flashcardapp/Screen$Quiz;", "Lcom/example/flashcardapp/Screen$Results;", "Lcom/example/flashcardapp/Screen$ReviewMistakes;", "Lcom/example/flashcardapp/Screen$Settings;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public abstract class Screen {
    public static final int $stable = 0;

    public /* synthetic */ Screen(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/example/flashcardapp/Screen$DeckSelection;", "Lcom/example/flashcardapp/Screen;", "()V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final class DeckSelection extends Screen {
        public static final int $stable = 0;
        public static final DeckSelection INSTANCE = new DeckSelection();

        private DeckSelection() {
            super(null);
        }
    }

    private Screen() {
    }

    /* compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/example/flashcardapp/Screen$Settings;", "Lcom/example/flashcardapp/Screen;", "()V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final class Settings extends Screen {
        public static final int $stable = 0;
        public static final Settings INSTANCE = new Settings();

        private Settings() {
            super(null);
        }
    }

    /* compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/example/flashcardapp/Screen$Profile;", "Lcom/example/flashcardapp/Screen;", "()V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final class Profile extends Screen {
        public static final int $stable = 0;
        public static final Profile INSTANCE = new Profile();

        private Profile() {
            super(null);
        }
    }

    /* compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/example/flashcardapp/Screen$AliasEditor;", "Lcom/example/flashcardapp/Screen;", "()V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final class AliasEditor extends Screen {
        public static final int $stable = 0;
        public static final AliasEditor INSTANCE = new AliasEditor();

        private AliasEditor() {
            super(null);
        }
    }

    /* compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003JC\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/example/flashcardapp/Screen$Quiz;", "Lcom/example/flashcardapp/Screen;", "deck", "Lcom/example/flashcardapp/data/AnkiDeck;", "mode", "Lcom/example/flashcardapp/session/McqSessionMode;", "customDeckIds", "", "", "isStarredOnly", "", "sessionKey", "(Lcom/example/flashcardapp/data/AnkiDeck;Lcom/example/flashcardapp/session/McqSessionMode;Ljava/util/List;ZJ)V", "getCustomDeckIds", "()Ljava/util/List;", "getDeck", "()Lcom/example/flashcardapp/data/AnkiDeck;", "()Z", "getMode", "()Lcom/example/flashcardapp/session/McqSessionMode;", "getSessionKey", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final /* data */ class Quiz extends Screen {
        public static final int $stable = 8;
        private final List<Long> customDeckIds;
        private final AnkiDeck deck;
        private final boolean isStarredOnly;
        private final McqSessionMode mode;
        private final long sessionKey;

        public static /* synthetic */ Quiz copy$default(Quiz quiz, AnkiDeck ankiDeck, McqSessionMode mcqSessionMode, List list, boolean z, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                ankiDeck = quiz.deck;
            }
            if ((i & 2) != 0) {
                mcqSessionMode = quiz.mode;
            }
            McqSessionMode mcqSessionMode2 = mcqSessionMode;
            if ((i & 4) != 0) {
                list = quiz.customDeckIds;
            }
            List list2 = list;
            if ((i & 8) != 0) {
                z = quiz.isStarredOnly;
            }
            boolean z2 = z;
            if ((i & 16) != 0) {
                j = quiz.sessionKey;
            }
            return quiz.copy(ankiDeck, mcqSessionMode2, list2, z2, j);
        }

        /* renamed from: component1, reason: from getter */
        public final AnkiDeck getDeck() {
            return this.deck;
        }

        /* renamed from: component2, reason: from getter */
        public final McqSessionMode getMode() {
            return this.mode;
        }

        public final List<Long> component3() {
            return this.customDeckIds;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsStarredOnly() {
            return this.isStarredOnly;
        }

        /* renamed from: component5, reason: from getter */
        public final long getSessionKey() {
            return this.sessionKey;
        }

        public final Quiz copy(AnkiDeck deck, McqSessionMode mode, List<Long> customDeckIds, boolean isStarredOnly, long sessionKey) {
            Intrinsics.checkNotNullParameter(deck, "deck");
            Intrinsics.checkNotNullParameter(mode, "mode");
            return new Quiz(deck, mode, customDeckIds, isStarredOnly, sessionKey);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Quiz)) {
                return false;
            }
            Quiz quiz = (Quiz) other;
            return Intrinsics.areEqual(this.deck, quiz.deck) && this.mode == quiz.mode && Intrinsics.areEqual(this.customDeckIds, quiz.customDeckIds) && this.isStarredOnly == quiz.isStarredOnly && this.sessionKey == quiz.sessionKey;
        }

        public final List<Long> getCustomDeckIds() {
            return this.customDeckIds;
        }

        public final AnkiDeck getDeck() {
            return this.deck;
        }

        public final McqSessionMode getMode() {
            return this.mode;
        }

        public final long getSessionKey() {
            return this.sessionKey;
        }

        public int hashCode() {
            int hashCode = ((this.deck.hashCode() * 31) + this.mode.hashCode()) * 31;
            List<Long> list = this.customDeckIds;
            return ((((hashCode + (list == null ? 0 : list.hashCode())) * 31) + Boolean.hashCode(this.isStarredOnly)) * 31) + Long.hashCode(this.sessionKey);
        }

        public final boolean isStarredOnly() {
            return this.isStarredOnly;
        }

        public String toString() {
            return "Quiz(deck=" + this.deck + ", mode=" + this.mode + ", customDeckIds=" + this.customDeckIds + ", isStarredOnly=" + this.isStarredOnly + ", sessionKey=" + this.sessionKey + ")";
        }

        public /* synthetic */ Quiz(AnkiDeck ankiDeck, McqSessionMode mcqSessionMode, List list, boolean z, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(ankiDeck, mcqSessionMode, (i & 4) != 0 ? null : list, (i & 8) != 0 ? false : z, (i & 16) != 0 ? System.currentTimeMillis() : j);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Quiz(AnkiDeck deck, McqSessionMode mode, List<Long> list, boolean z, long j) {
            super(null);
            Intrinsics.checkNotNullParameter(deck, "deck");
            Intrinsics.checkNotNullParameter(mode, "mode");
            this.deck = deck;
            this.mode = mode;
            this.customDeckIds = list;
            this.isStarredOnly = z;
            this.sessionKey = j;
        }
    }

    /* compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\t\u0010!\u001a\u00020\rHÆ\u0003J\t\u0010\"\u001a\u00020\rHÆ\u0003JU\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0005HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018¨\u0006+"}, d2 = {"Lcom/example/flashcardapp/Screen$Results;", "Lcom/example/flashcardapp/Screen;", "deck", "Lcom/example/flashcardapp/data/AnkiDeck;", "score", "", "timeTakenSeconds", "", "totalQuestions", "answeredQuestions", "", "Lcom/example/flashcardapp/session/AnswerRecord;", "positiveMarks", "", "negativeMarks", "(Lcom/example/flashcardapp/data/AnkiDeck;IJILjava/util/List;FF)V", "getAnsweredQuestions", "()Ljava/util/List;", "getDeck", "()Lcom/example/flashcardapp/data/AnkiDeck;", "getNegativeMarks", "()F", "getPositiveMarks", "getScore", "()I", "getTimeTakenSeconds", "()J", "getTotalQuestions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final /* data */ class Results extends Screen {
        public static final int $stable = 8;
        private final List<AnswerRecord> answeredQuestions;
        private final AnkiDeck deck;
        private final float negativeMarks;
        private final float positiveMarks;
        private final int score;
        private final long timeTakenSeconds;
        private final int totalQuestions;

        /* renamed from: component1, reason: from getter */
        public final AnkiDeck getDeck() {
            return this.deck;
        }

        /* renamed from: component2, reason: from getter */
        public final int getScore() {
            return this.score;
        }

        /* renamed from: component3, reason: from getter */
        public final long getTimeTakenSeconds() {
            return this.timeTakenSeconds;
        }

        /* renamed from: component4, reason: from getter */
        public final int getTotalQuestions() {
            return this.totalQuestions;
        }

        public final List<AnswerRecord> component5() {
            return this.answeredQuestions;
        }

        /* renamed from: component6, reason: from getter */
        public final float getPositiveMarks() {
            return this.positiveMarks;
        }

        /* renamed from: component7, reason: from getter */
        public final float getNegativeMarks() {
            return this.negativeMarks;
        }

        public final Results copy(AnkiDeck deck, int score, long timeTakenSeconds, int totalQuestions, List<AnswerRecord> answeredQuestions, float positiveMarks, float negativeMarks) {
            Intrinsics.checkNotNullParameter(deck, "deck");
            Intrinsics.checkNotNullParameter(answeredQuestions, "answeredQuestions");
            return new Results(deck, score, timeTakenSeconds, totalQuestions, answeredQuestions, positiveMarks, negativeMarks);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Results)) {
                return false;
            }
            Results results = (Results) other;
            return Intrinsics.areEqual(this.deck, results.deck) && this.score == results.score && this.timeTakenSeconds == results.timeTakenSeconds && this.totalQuestions == results.totalQuestions && Intrinsics.areEqual(this.answeredQuestions, results.answeredQuestions) && Float.compare(this.positiveMarks, results.positiveMarks) == 0 && Float.compare(this.negativeMarks, results.negativeMarks) == 0;
        }

        public final List<AnswerRecord> getAnsweredQuestions() {
            return this.answeredQuestions;
        }

        public final AnkiDeck getDeck() {
            return this.deck;
        }

        public final float getNegativeMarks() {
            return this.negativeMarks;
        }

        public final float getPositiveMarks() {
            return this.positiveMarks;
        }

        public final int getScore() {
            return this.score;
        }

        public final long getTimeTakenSeconds() {
            return this.timeTakenSeconds;
        }

        public final int getTotalQuestions() {
            return this.totalQuestions;
        }

        public int hashCode() {
            return (((((((((((this.deck.hashCode() * 31) + Integer.hashCode(this.score)) * 31) + Long.hashCode(this.timeTakenSeconds)) * 31) + Integer.hashCode(this.totalQuestions)) * 31) + this.answeredQuestions.hashCode()) * 31) + Float.hashCode(this.positiveMarks)) * 31) + Float.hashCode(this.negativeMarks);
        }

        public String toString() {
            return "Results(deck=" + this.deck + ", score=" + this.score + ", timeTakenSeconds=" + this.timeTakenSeconds + ", totalQuestions=" + this.totalQuestions + ", answeredQuestions=" + this.answeredQuestions + ", positiveMarks=" + this.positiveMarks + ", negativeMarks=" + this.negativeMarks + ")";
        }

        public /* synthetic */ Results(AnkiDeck ankiDeck, int i, long j, int i2, List list, float f, float f2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(ankiDeck, i, j, i2, (i3 & 16) != 0 ? CollectionsKt.emptyList() : list, (i3 & 32) != 0 ? 1.0f : f, (i3 & 64) != 0 ? 0.0f : f2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Results(AnkiDeck deck, int i, long j, int i2, List<AnswerRecord> answeredQuestions, float f, float f2) {
            super(null);
            Intrinsics.checkNotNullParameter(deck, "deck");
            Intrinsics.checkNotNullParameter(answeredQuestions, "answeredQuestions");
            this.deck = deck;
            this.score = i;
            this.timeTakenSeconds = j;
            this.totalQuestions = i2;
            this.answeredQuestions = answeredQuestions;
            this.positiveMarks = f;
            this.negativeMarks = f2;
        }
    }

    /* compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/example/flashcardapp/Screen$ReviewMistakes;", "Lcom/example/flashcardapp/Screen;", "deck", "Lcom/example/flashcardapp/data/AnkiDeck;", "answeredQuestions", "", "Lcom/example/flashcardapp/session/AnswerRecord;", "(Lcom/example/flashcardapp/data/AnkiDeck;Ljava/util/List;)V", "getAnsweredQuestions", "()Ljava/util/List;", "getDeck", "()Lcom/example/flashcardapp/data/AnkiDeck;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final /* data */ class ReviewMistakes extends Screen {
        public static final int $stable = 8;
        private final List<AnswerRecord> answeredQuestions;
        private final AnkiDeck deck;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ReviewMistakes copy$default(ReviewMistakes reviewMistakes, AnkiDeck ankiDeck, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                ankiDeck = reviewMistakes.deck;
            }
            if ((i & 2) != 0) {
                list = reviewMistakes.answeredQuestions;
            }
            return reviewMistakes.copy(ankiDeck, list);
        }

        /* renamed from: component1, reason: from getter */
        public final AnkiDeck getDeck() {
            return this.deck;
        }

        public final List<AnswerRecord> component2() {
            return this.answeredQuestions;
        }

        public final ReviewMistakes copy(AnkiDeck deck, List<AnswerRecord> answeredQuestions) {
            Intrinsics.checkNotNullParameter(deck, "deck");
            Intrinsics.checkNotNullParameter(answeredQuestions, "answeredQuestions");
            return new ReviewMistakes(deck, answeredQuestions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReviewMistakes)) {
                return false;
            }
            ReviewMistakes reviewMistakes = (ReviewMistakes) other;
            return Intrinsics.areEqual(this.deck, reviewMistakes.deck) && Intrinsics.areEqual(this.answeredQuestions, reviewMistakes.answeredQuestions);
        }

        public final List<AnswerRecord> getAnsweredQuestions() {
            return this.answeredQuestions;
        }

        public final AnkiDeck getDeck() {
            return this.deck;
        }

        public int hashCode() {
            return (this.deck.hashCode() * 31) + this.answeredQuestions.hashCode();
        }

        public String toString() {
            return "ReviewMistakes(deck=" + this.deck + ", answeredQuestions=" + this.answeredQuestions + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReviewMistakes(AnkiDeck deck, List<AnswerRecord> answeredQuestions) {
            super(null);
            Intrinsics.checkNotNullParameter(deck, "deck");
            Intrinsics.checkNotNullParameter(answeredQuestions, "answeredQuestions");
            this.deck = deck;
            this.answeredQuestions = answeredQuestions;
        }
    }
}

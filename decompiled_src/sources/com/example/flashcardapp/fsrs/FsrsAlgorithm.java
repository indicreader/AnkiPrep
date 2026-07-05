package com.example.flashcardapp.fsrs;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.work.PeriodicWorkRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.random.RandomKt;
import kotlin.ranges.RangesKt;

/* compiled from: FsrsAlgorithm.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0007\u0018\u0000 :2\u00020\u0001:\u0002:;B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002J\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0002J\b\u0010\u001a\u001a\u00020\u0003H\u0002J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0002J\u0018\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0002J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J \u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0003H\u0002J\u001a\u0010+\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u0017H\u0002J(\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\u0018\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\u0014\u00103\u001a\u00020\u0003*\u00020\u00032\u0006\u00104\u001a\u00020\u0003H\u0002J\u0016\u00105\u001a\u00020\u0017*\u00020\u00032\b\b\u0002\u00106\u001a\u00020\u0017H\u0002J(\u00107\u001a\u00020\u0003*\u00020\u00032\u0006\u00104\u001a\u00020\u00032\b\b\u0002\u00108\u001a\u00020\u00032\b\b\u0002\u00109\u001a\u00020\u0003H\u0002R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/example/flashcardapp/fsrs/FsrsAlgorithm;", "", "requestRetention", "", "params", "", "(DLjava/util/List;)V", "decay", "enableFuzz", "", "factor", "applyFuzz", "interval", "fuzzFactor", "calculate", "", "Lcom/example/flashcardapp/fsrs/Rating;", "Lcom/example/flashcardapp/fsrs/SchedulingResult;", "card", "Lcom/example/flashcardapp/fsrs/FsrsCard;", "convertDays", "", "days", "", "forgettingCurve", "stability", "generateFuzzFactor", "initDifficulty", "rating", "initStability", "initState", "Lcom/example/flashcardapp/fsrs/FsrsAlgorithm$InitState;", "linearDamping", "delta", "oldD", "meanReversion", "initD", "nextD", "nextDifficulty", "currentD", "nextForgetStability", "difficulty", "retrievability", "nextInterval", "maxInterval", "nextRecallStability", "d", "s", "r", "nextShortTermStability", "currentS", "formatToTwoDecimals", "defaultValue", "safeRoundToInt", "defaultVal", "sanitize", "minVal", "maxVal", "Companion", "InitState", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class FsrsAlgorithm {
    private static final long DAY_MILLIS = 86400000;
    private final double decay;
    private final boolean enableFuzz;
    private final double factor;
    private final List<Double> params;
    private final double requestRetention;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final List<Double> DEFAULT_PARAMS = CollectionsKt.listOf((Object[]) new Double[]{Double.valueOf(0.40255d), Double.valueOf(1.18385d), Double.valueOf(3.173d), Double.valueOf(15.69105d), Double.valueOf(7.1949d), Double.valueOf(0.5345d), Double.valueOf(1.4604d), Double.valueOf(0.0046d), Double.valueOf(1.54575d), Double.valueOf(0.1192d), Double.valueOf(1.01925d), Double.valueOf(1.9395d), Double.valueOf(0.11d), Double.valueOf(0.29605d), Double.valueOf(2.2698d), Double.valueOf(0.2315d), Double.valueOf(2.9898d), Double.valueOf(0.51655d), Double.valueOf(0.6621d)});

    /* compiled from: FsrsAlgorithm.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardState.values().length];
            try {
                iArr[CardState.New.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CardState.Relearning.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CardState.Review.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FsrsAlgorithm() {
        this(0.0d, null, 3, null);
    }

    private final double linearDamping(double delta, double oldD) {
        return (delta * (10.0d - oldD)) / 9.0d;
    }

    public FsrsAlgorithm(double d, List<Double> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.requestRetention = d;
        this.params = params;
        this.decay = -0.5d;
        this.factor = 0.2345679012345679d;
        this.enableFuzz = true;
    }

    public /* synthetic */ FsrsAlgorithm(double d, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.9d : d, (i & 2) != 0 ? DEFAULT_PARAMS : list);
    }

    /* compiled from: FsrsAlgorithm.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/example/flashcardapp/fsrs/FsrsAlgorithm$Companion;", "", "()V", "DAY_MILLIS", "", "DEFAULT_PARAMS", "", "", "getDEFAULT_PARAMS", "()Ljava/util/List;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<Double> getDEFAULT_PARAMS() {
            return FsrsAlgorithm.DEFAULT_PARAMS;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FsrsAlgorithm.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/example/flashcardapp/fsrs/FsrsAlgorithm$InitState;", "", "difficulty", "", "stability", "(DD)V", "getDifficulty", "()D", "setDifficulty", "(D)V", "getStability", "setStability", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final /* data */ class InitState {
        private double difficulty;
        private double stability;

        public InitState() {
            this(0.0d, 0.0d, 3, null);
        }

        public static /* synthetic */ InitState copy$default(InitState initState, double d, double d2, int i, Object obj) {
            if ((i & 1) != 0) {
                d = initState.difficulty;
            }
            if ((i & 2) != 0) {
                d2 = initState.stability;
            }
            return initState.copy(d, d2);
        }

        /* renamed from: component1, reason: from getter */
        public final double getDifficulty() {
            return this.difficulty;
        }

        /* renamed from: component2, reason: from getter */
        public final double getStability() {
            return this.stability;
        }

        public final InitState copy(double difficulty, double stability) {
            return new InitState(difficulty, stability);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InitState)) {
                return false;
            }
            InitState initState = (InitState) other;
            return Double.compare(this.difficulty, initState.difficulty) == 0 && Double.compare(this.stability, initState.stability) == 0;
        }

        public final double getDifficulty() {
            return this.difficulty;
        }

        public final double getStability() {
            return this.stability;
        }

        public int hashCode() {
            return (Double.hashCode(this.difficulty) * 31) + Double.hashCode(this.stability);
        }

        public final void setDifficulty(double d) {
            this.difficulty = d;
        }

        public final void setStability(double d) {
            this.stability = d;
        }

        public String toString() {
            return "InitState(difficulty=" + this.difficulty + ", stability=" + this.stability + ")";
        }

        public InitState(double d, double d2) {
            this.difficulty = d;
            this.stability = d2;
        }

        public /* synthetic */ InitState(double d, double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0.0d : d, (i & 2) != 0 ? 0.0d : d2);
        }
    }

    public final Map<Rating, SchedulingResult> calculate(final FsrsCard card) {
        char c;
        InitState initState;
        InitState initState2;
        InitState initState3;
        int i;
        long j;
        String convertDays;
        String str;
        InitState initState4;
        long j2;
        int i2;
        int i3;
        String str2;
        InitState initState5;
        InitState initState6;
        InitState initState7;
        InitState initState8;
        InitState initState9;
        Intrinsics.checkNotNullParameter(card, "card");
        double sanitize$default = sanitize$default(this, card.getStability(), 2.5d, 0.1d, 0.0d, 4, null);
        double sanitize = sanitize(card.getDifficulty(), 5.0d, 1.0d, 10.0d);
        int i4 = WhenMappings.$EnumSwitchMapping$0[card.getState().ordinal()];
        long j3 = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        if (i4 == 1) {
            c = 1;
            initState = initState(Rating.Again);
            initState2 = initState(Rating.Hard);
            InitState initState10 = initState(Rating.Good);
            initState3 = initState(Rating.Easy);
            int max = Math.max(1, nextInterval$default(this, initState3.getStability(), 0, 2, null));
            i = max;
            j = max * 86400000;
            convertDays = convertDays(max);
            str = "10 Min";
            initState4 = initState10;
            j2 = 600000;
            i2 = 0;
            i3 = 0;
            str2 = "5 Min";
        } else {
            if (i4 != 2) {
                if (i4 == 3) {
                    double forgettingCurve = forgettingCurve(card.getInterval(), sanitize$default);
                    InitState initState11 = new InitState(nextDifficulty(sanitize, Rating.Again), nextForgetStability(sanitize, sanitize$default, forgettingCurve));
                    c = 1;
                    initState2 = new InitState(nextDifficulty(sanitize, Rating.Hard), nextRecallStability(sanitize, sanitize$default, forgettingCurve, Rating.Hard));
                    InitState initState12 = new InitState(nextDifficulty(sanitize, Rating.Good), nextRecallStability(sanitize, sanitize$default, forgettingCurve, Rating.Good));
                    initState3 = new InitState(nextDifficulty(sanitize, Rating.Easy), nextRecallStability(sanitize, sanitize$default, forgettingCurve, Rating.Easy));
                    int nextInterval$default = nextInterval$default(this, initState2.getStability(), 0, 2, null);
                    int nextInterval$default2 = nextInterval$default(this, initState12.getStability(), 0, 2, null);
                    int nextInterval$default3 = nextInterval$default(this, initState3.getStability(), 0, 2, null);
                    int min = Math.min(nextInterval$default, nextInterval$default2);
                    int max2 = Math.max(nextInterval$default2, min + 1);
                    int max3 = Math.max(nextInterval$default3, max2 + 1);
                    String convertDays2 = convertDays(min);
                    j3 = min * 86400000;
                    i2 = min;
                    i = max3;
                    j = max3 * 86400000;
                    str = convertDays(max2);
                    convertDays = convertDays(max3);
                    i3 = max2;
                    initState4 = initState12;
                    j2 = max2 * 86400000;
                    initState5 = initState11;
                    str2 = convertDays2;
                    Function1<Rating, CardState> function1 = new Function1<Rating, CardState>() { // from class: com.example.flashcardapp.fsrs.FsrsAlgorithm$calculate$newStateForRating$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final CardState invoke(Rating rating) {
                            Intrinsics.checkNotNullParameter(rating, "rating");
                            return rating == Rating.Again ? CardState.Relearning : (FsrsCard.this.getState() != CardState.New || rating.compareTo(Rating.Good) < 0) ? FsrsCard.this.getState() == CardState.New ? CardState.Relearning : (FsrsCard.this.getState() != CardState.Relearning || rating.compareTo(Rating.Good) < 0) ? CardState.Review : CardState.Review : CardState.Review;
                        }
                    };
                    Pair[] pairArr = new Pair[4];
                    pairArr[0] = TuplesKt.to(Rating.Easy, new SchedulingResult(initState3.getStability(), initState3.getDifficulty(), i, j, convertDays, Rating.Easy, function1.invoke(Rating.Easy)));
                    pairArr[c] = TuplesKt.to(Rating.Good, new SchedulingResult(initState4.getStability(), initState4.getDifficulty(), i3, j2, str, Rating.Good, function1.invoke(Rating.Good)));
                    pairArr[2] = TuplesKt.to(Rating.Hard, new SchedulingResult(initState2.getStability(), initState2.getDifficulty(), i2, j3, str2, Rating.Hard, function1.invoke(Rating.Hard)));
                    pairArr[3] = TuplesKt.to(Rating.Again, new SchedulingResult(initState5.getStability(), initState5.getDifficulty(), card.getInterval(), 180000L, "< 3 Min", Rating.Again, function1.invoke(Rating.Again)));
                    return MapsKt.mapOf(pairArr);
                }
                throw new NoWhenBranchMatchedException();
            }
            c = 1;
            if (sanitize <= 0.0d || Double.isNaN(sanitize)) {
                initState6 = initState(Rating.Again);
                initState7 = initState(Rating.Hard);
                initState8 = initState(Rating.Good);
                initState9 = initState(Rating.Easy);
            } else {
                initState6 = new InitState(nextDifficulty(sanitize, Rating.Again), nextShortTermStability(sanitize$default, Rating.Again));
                initState7 = new InitState(nextDifficulty(sanitize, Rating.Hard), nextShortTermStability(sanitize$default, Rating.Hard));
                initState8 = new InitState(nextDifficulty(sanitize, Rating.Good), nextShortTermStability(sanitize$default, Rating.Good));
                initState9 = new InitState(nextDifficulty(sanitize, Rating.Easy), nextShortTermStability(sanitize$default, Rating.Easy));
            }
            initState = initState6;
            initState2 = initState7;
            InitState initState13 = initState8;
            initState3 = initState9;
            int nextInterval$default4 = nextInterval$default(this, initState13.getStability(), 0, 2, null);
            int max4 = Math.max(nextInterval$default(this, initState3.getStability(), 0, 2, null), nextInterval$default4 + 1);
            String convertDays3 = convertDays(nextInterval$default4);
            i = max4;
            j = max4 * 86400000;
            convertDays = convertDays(max4);
            str = convertDays3;
            initState4 = initState13;
            i3 = nextInterval$default4;
            i2 = 0;
            j2 = nextInterval$default4 * 86400000;
            str2 = "10 Min";
        }
        initState5 = initState;
        Function1<Rating, CardState> function12 = new Function1<Rating, CardState>() { // from class: com.example.flashcardapp.fsrs.FsrsAlgorithm$calculate$newStateForRating$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CardState invoke(Rating rating) {
                Intrinsics.checkNotNullParameter(rating, "rating");
                return rating == Rating.Again ? CardState.Relearning : (FsrsCard.this.getState() != CardState.New || rating.compareTo(Rating.Good) < 0) ? FsrsCard.this.getState() == CardState.New ? CardState.Relearning : (FsrsCard.this.getState() != CardState.Relearning || rating.compareTo(Rating.Good) < 0) ? CardState.Review : CardState.Review : CardState.Review;
            }
        };
        Pair[] pairArr2 = new Pair[4];
        pairArr2[0] = TuplesKt.to(Rating.Easy, new SchedulingResult(initState3.getStability(), initState3.getDifficulty(), i, j, convertDays, Rating.Easy, function12.invoke(Rating.Easy)));
        pairArr2[c] = TuplesKt.to(Rating.Good, new SchedulingResult(initState4.getStability(), initState4.getDifficulty(), i3, j2, str, Rating.Good, function12.invoke(Rating.Good)));
        pairArr2[2] = TuplesKt.to(Rating.Hard, new SchedulingResult(initState2.getStability(), initState2.getDifficulty(), i2, j3, str2, Rating.Hard, function12.invoke(Rating.Hard)));
        pairArr2[3] = TuplesKt.to(Rating.Again, new SchedulingResult(initState5.getStability(), initState5.getDifficulty(), card.getInterval(), 180000L, "< 3 Min", Rating.Again, function12.invoke(Rating.Again)));
        return MapsKt.mapOf(pairArr2);
    }

    static /* synthetic */ double sanitize$default(FsrsAlgorithm fsrsAlgorithm, double d, double d2, double d3, double d4, int i, Object obj) {
        return fsrsAlgorithm.sanitize(d, d2, (i & 2) != 0 ? Double.NEGATIVE_INFINITY : d3, (i & 4) != 0 ? Double.POSITIVE_INFINITY : d4);
    }

    private final double sanitize(double d, double d2, double d3, double d4) {
        return (Double.isNaN(d) || Double.isInfinite(d)) ? d2 : RangesKt.coerceIn(d, d3, d4);
    }

    private final double formatToTwoDecimals(double d, double d2) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            d = d2;
        }
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return Double.parseDouble(format);
        } catch (Exception unused) {
            return d2;
        }
    }

    private final String convertDays(int days) {
        if (days > 365) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(days / 365.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format + " yr";
        }
        if (days > 30) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(days / 30.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            return format2 + " mo";
        }
        return days + " d";
    }

    static /* synthetic */ int safeRoundToInt$default(FsrsAlgorithm fsrsAlgorithm, double d, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return fsrsAlgorithm.safeRoundToInt(d, i);
    }

    private final int safeRoundToInt(double d, int i) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            return i;
        }
        if (d < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        if (d > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        return MathKt.roundToInt(d);
    }

    private final double applyFuzz(double interval, double fuzzFactor) {
        double sanitize$default = sanitize$default(this, interval, 2.5d, 0.0d, 0.0d, 4, null);
        if (!this.enableFuzz || sanitize$default < 2.5d) {
            return sanitize$default;
        }
        double sanitize = sanitize(fuzzFactor, 0.5d, 0.0d, 1.0d);
        double d = 1;
        return sanitize$default(this, Math.floor((sanitize * ((safeRoundToInt((r3 * 1.05d) + d, 2) - r5) + 1)) + Math.max(2, safeRoundToInt((0.95d * safeRoundToInt(sanitize$default, 2)) - d, 2))), sanitize$default, 0.0d, 0.0d, 6, null);
    }

    private final double forgettingCurve(double interval, double stability) {
        double sanitize$default = sanitize$default(this, stability, 2.5d, 0.1d, 0.0d, 4, null);
        return sanitize(Math.pow((this.factor * (sanitize$default(this, interval, 0.0d, 0.0d, 0.0d, 4, null) / sanitize$default)) + 1.0d, this.decay), 0.9d, 0.0d, 1.0d);
    }

    private final double generateFuzzFactor() {
        return RandomKt.Random(System.currentTimeMillis()).nextDouble();
    }

    private final double initDifficulty(Rating rating) {
        return RangesKt.coerceIn(formatToTwoDecimals(this.params.get(4).doubleValue() - (this.params.get(5).doubleValue() * (rating.getValue() - 3)), 5.0d), 1.0d, 10.0d);
    }

    private final double initStability(Rating rating) {
        int value = rating.getValue() - 1;
        List<Double> list = this.params;
        return RangesKt.coerceAtLeast(formatToTwoDecimals(((value < 0 || value > CollectionsKt.getLastIndex(list)) ? Double.valueOf(0.1d) : list.get(value)).doubleValue(), 0.1d), 0.1d);
    }

    private final InitState initState(Rating rating) {
        return new InitState(initDifficulty(rating), initStability(rating));
    }

    private final double meanReversion(double initD, double nextD) {
        return (this.params.get(7).doubleValue() * initD) + ((1.0d - this.params.get(7).doubleValue()) * nextD);
    }

    static /* synthetic */ int nextInterval$default(FsrsAlgorithm fsrsAlgorithm, double d, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 36500;
        }
        return fsrsAlgorithm.nextInterval(d, i);
    }

    private final int nextInterval(double stability, int maxInterval) {
        return RangesKt.coerceIn(safeRoundToInt(applyFuzz(sanitize$default(this, (sanitize$default(this, stability, 2.5d, 0.1d, 0.0d, 4, null) / this.factor) * (Math.pow(this.requestRetention, 1.0d / this.decay) - 1), 1.0d, 0.0d, 0.0d, 4, null), generateFuzzFactor()), 1), 1, maxInterval);
    }

    private final double nextDifficulty(double currentD, Rating rating) {
        double sanitize = sanitize(currentD, 5.0d, 1.0d, 10.0d);
        return RangesKt.coerceIn(formatToTwoDecimals(meanReversion(initDifficulty(Rating.Good), sanitize + linearDamping((-this.params.get(6).doubleValue()) * (rating.getValue() - 3), sanitize)), 5.0d), 1.0d, 10.0d);
    }

    private final double nextShortTermStability(double currentS, Rating rating) {
        double sanitize$default = sanitize$default(this, currentS, 2.5d, 0.1d, 0.0d, 4, null);
        double exp = Math.exp(this.params.get(17).doubleValue() * ((rating.getValue() - 3) + this.params.get(18).doubleValue()));
        if (rating.getValue() >= 3) {
            exp = Math.max(exp, 1.0d);
        }
        return formatToTwoDecimals(Math.abs(exp * sanitize$default), RangesKt.coerceAtLeast(sanitize$default, 0.1d));
    }

    private final double nextForgetStability(double difficulty, double stability, double retrievability) {
        double sanitize = sanitize(difficulty, 5.0d, 1.0d, 10.0d);
        double sanitize$default = sanitize$default(this, stability, 2.5d, 0.1d, 0.0d, 4, null);
        double sanitize2 = sanitize(retrievability, 0.9d, 0.0d, 1.0d);
        double exp = sanitize$default / Math.exp(this.params.get(17).doubleValue() * this.params.get(18).doubleValue());
        double d = 1;
        return formatToTwoDecimals(Math.min(sanitize$default(this, this.params.get(11).doubleValue() * Math.pow(sanitize, -this.params.get(12).doubleValue()) * (Math.pow(sanitize$default + d, this.params.get(13).doubleValue()) - d) * Math.exp((d - sanitize2) * this.params.get(14).doubleValue()), exp, 0.0d, 0.0d, 6, null), exp), exp);
    }

    private final double nextRecallStability(double d, double s, double r, Rating rating) {
        double sanitize = sanitize(d, 5.0d, 1.0d, 10.0d);
        double sanitize$default = sanitize$default(this, s, 2.5d, 0.1d, 0.0d, 4, null);
        double sanitize2 = sanitize(r, 0.9d, 0.0d, 1.0d);
        double d2 = 1;
        return formatToTwoDecimals((d2 + (Math.exp(this.params.get(8).doubleValue()) * (11 - sanitize) * Math.pow(sanitize$default, -this.params.get(9).doubleValue()) * (Math.exp((d2 - sanitize2) * this.params.get(10).doubleValue()) - d2) * (rating == Rating.Hard ? this.params.get(15).doubleValue() : 1.0d) * (rating == Rating.Easy ? this.params.get(16).doubleValue() : 1.0d))) * sanitize$default, sanitize$default);
    }
}

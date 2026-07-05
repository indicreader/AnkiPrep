package com.example.flashcardapp.mcq;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.DeckHierarchyUtils;
import com.example.flashcardapp.data.core.ParsedCard;
import com.example.flashcardapp.data.core.StructuredParser;
import com.example.flashcardapp.data.entities.AliasEntity;
import com.example.flashcardapp.data.entities.CardEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: McqEngine.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0017\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u000fJd\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00112\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u0086@¢\u0006\u0002\u0010\u001cJ6\u0010\u001d\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00112\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u0002J>\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00112\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u00052\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00112\u0006\u0010&\u001a\u00020'H\u0002J \u0010(\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000bH\u0002J.\u0010*\u001a\u00020'2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0-2\u0006\u0010.\u001a\u00020\u000bH\u0002J\u0018\u0010/\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002JV\u00100\u001a\b\u0012\u0004\u0012\u00020\"0\u00112\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00112\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005H\u0002J\u0018\u00104\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/example/flashcardapp/mcq/McqEngine;", "", "random", "Lkotlin/random/Random;", "optionsCount", "", "(Lkotlin/random/Random;I)V", "requiredDistractors", "calculateSimilarity", "", "s1", "", "s2", "extractYear", "s", "(Ljava/lang/String;)Ljava/lang/Integer;", "generate", "", "Lcom/example/flashcardapp/mcq/Mcq;", "allCards", "Lcom/example/flashcardapp/data/entities/CardEntity;", "targetCards", "aliases", "Lcom/example/flashcardapp/data/entities/AliasEntity;", "targetDeckId", "", "targetDeckPath", "targetDifficulty", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateSingleMcq", "card", "index", "Lcom/example/flashcardapp/mcq/HierarchyIndex;", "generateSyntheticDistractors", "Lcom/example/flashcardapp/mcq/DistractorCandidate;", "correctAnswer", "answerType", "needed", "allowNota", "", "getSimilarity", "type", "isTautologyOrAlias", "cleanCorrect", "wordsCorrect", "", "candidate", "levenshtein", "selectDistractors", "difficulty", "notaCount", "maxNota", "wordOverlapSimilarity", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class McqEngine {
    public static final int $stable = 8;
    private final int optionsCount;
    private final Random random;
    private final int requiredDistractors;

    /* JADX WARN: Multi-variable type inference failed */
    public McqEngine() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public McqEngine(Random random, int i) {
        Intrinsics.checkNotNullParameter(random, "random");
        this.random = random;
        this.optionsCount = i;
        this.requiredDistractors = RangesKt.coerceAtLeast(i - 1, 1);
    }

    public /* synthetic */ McqEngine(Random random, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? RandomKt.Random(System.currentTimeMillis()) : random, (i2 & 2) != 0 ? 4 : i);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object generate(java.util.List<com.example.flashcardapp.data.entities.CardEntity> r15, java.util.List<com.example.flashcardapp.data.entities.CardEntity> r16, java.util.List<com.example.flashcardapp.data.entities.AliasEntity> r17, java.lang.Long r18, java.lang.String r19, java.lang.String r20, kotlin.coroutines.Continuation<? super java.util.List<com.example.flashcardapp.mcq.Mcq>> r21) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.mcq.McqEngine.generate(java.util.List, java.util.List, java.util.List, java.lang.Long, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Mcq generateSingleMcq$default(McqEngine mcqEngine, CardEntity cardEntity, HierarchyIndex hierarchyIndex, List list, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 8) != 0) {
            str = null;
        }
        return mcqEngine.generateSingleMcq(cardEntity, hierarchyIndex, list, str);
    }

    private final Mcq generateSingleMcq(CardEntity card, HierarchyIndex index, List<AliasEntity> aliases, String targetDifficulty) {
        List emptyList;
        String str;
        int i;
        int i2;
        String str2;
        String obj = StringsKt.trim((CharSequence) card.getFront()).toString();
        ParsedCard parse = StructuredParser.INSTANCE.parse(card.getBack());
        String answer = parse.getAnswer();
        try {
            emptyList = (List) new Gson().fromJson(card.getTags(), new TypeToken<List<? extends String>>() { // from class: com.example.flashcardapp.mcq.McqEngine$generateSingleMcq$parsedTags$type$1
            }.getType());
            if (emptyList == null) {
                emptyList = CollectionsKt.emptyList();
            }
        } catch (Exception unused) {
            emptyList = CollectionsKt.emptyList();
        }
        List list = emptyList;
        if (obj.length() == 0 || answer.length() == 0) {
            return null;
        }
        String type = index.getType(card.getId());
        if (targetDifficulty == null) {
            int nextInt = this.random.nextInt(3);
            str = nextInt != 0 ? nextInt != 1 ? "hard" : "medium" : "easy";
        } else {
            str = targetDifficulty;
        }
        ArrayList arrayList = new ArrayList();
        if (!parse.getOptions().isEmpty()) {
            Iterator it = CollectionsKt.take(parse.getOptions(), this.requiredDistractors).iterator();
            while (it.hasNext()) {
                arrayList.add(new DistractorCandidate((String) it.next(), -1L, DistractorSource.GLOBAL_POOL));
            }
        }
        if (arrayList.size() < this.requiredDistractors) {
            arrayList.addAll(CollectionsKt.take(selectDistractors(card, answer, type, str, index, aliases, 0, 0), this.requiredDistractors - arrayList.size()));
        }
        if (arrayList.size() < this.requiredDistractors) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new McqEngine$generateSingleMcq$OptionMeta(answer, card.getId(), true));
        Iterator it2 = arrayList.iterator();
        while (true) {
            i = 0;
            if (!it2.hasNext()) {
                break;
            }
            DistractorCandidate distractorCandidate = (DistractorCandidate) it2.next();
            arrayList2.add(new McqEngine$generateSingleMcq$OptionMeta(distractorCandidate.getText(), distractorCandidate.getSourceCardId(), false));
        }
        List shuffled = CollectionsKt.shuffled(arrayList2, this.random);
        List list2 = shuffled;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it3 = list2.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((McqEngine$generateSingleMcq$OptionMeta) it3.next()).getText());
        }
        ArrayList arrayList4 = arrayList3;
        Iterator it4 = shuffled.iterator();
        int i3 = 0;
        while (true) {
            if (!it4.hasNext()) {
                i2 = -1;
                break;
            }
            if (((McqEngine$generateSingleMcq$OptionMeta) it4.next()).isCorrect()) {
                i2 = i3;
                break;
            }
            i3++;
        }
        ArrayList arrayList5 = new ArrayList();
        for (Object obj2 : list2) {
            int i4 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (i != i2) {
                arrayList5.add(obj2);
            }
            i = i4;
        }
        ArrayList arrayList6 = arrayList5;
        ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
        Iterator it5 = arrayList6.iterator();
        while (it5.hasNext()) {
            arrayList7.add(Long.valueOf(((McqEngine$generateSingleMcq$OptionMeta) it5.next()).getCardId()));
        }
        ArrayList arrayList8 = arrayList7;
        if (parse.getExplanation().length() > 0) {
            str2 = parse.getExplanation();
        } else {
            str2 = "The correct answer is: " + answer;
        }
        Mcq mcq = new Mcq(obj, arrayList4, i2, card.getId(), arrayList8, card.getDeckHierarchy(), str2, str, type, list, card.getFrontImage(), card.getBackImage(), card.getExplanationImage(), card.getOptionImagesJson());
        if (mcq.isValid()) {
            return mcq;
        }
        return null;
    }

    private final int levenshtein(String s1, String s2) {
        int length = s2.length() + 1;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = i;
        }
        int length2 = s1.length();
        if (1 <= length2) {
            int i2 = 1;
            while (true) {
                int i3 = iArr[0];
                iArr[0] = i2;
                int length3 = s2.length();
                if (1 <= length3) {
                    int i4 = 1;
                    while (true) {
                        int i5 = iArr[i4];
                        int i6 = i4 - 1;
                        if (s1.charAt(i2 - 1) == s2.charAt(i6)) {
                            iArr[i4] = i3;
                        } else {
                            iArr[i4] = Math.min(iArr[i6], Math.min(iArr[i4], i3)) + 1;
                        }
                        if (i4 == length3) {
                            break;
                        }
                        i4++;
                        i3 = i5;
                    }
                }
                if (i2 == length2) {
                    break;
                }
                i2++;
            }
        }
        return iArr[s2.length()];
    }

    private final float calculateSimilarity(String s1, String s2) {
        int max = Math.max(s1.length(), s2.length());
        if (max == 0) {
            return 1.0f;
        }
        return 1.0f - (levenshtein(s1, s2) / max);
    }

    private final float wordOverlapSimilarity(String s1, String s2) {
        String lowerCase = s1.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List<String> split = new Regex("\\W+").split(lowerCase, 0);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        Set set = CollectionsKt.toSet(arrayList);
        String lowerCase2 = s2.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        List<String> split2 = new Regex("\\W+").split(lowerCase2, 0);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : split2) {
            if (((String) obj2).length() > 0) {
                arrayList2.add(obj2);
            }
        }
        Set set2 = CollectionsKt.toSet(arrayList2);
        if (set.isEmpty() && set2.isEmpty()) {
            return 1.0f;
        }
        if (set.isEmpty() || set2.isEmpty()) {
            return 0.0f;
        }
        Set set3 = set;
        Set set4 = set2;
        int size = CollectionsKt.intersect(set3, set4).size();
        int size2 = CollectionsKt.union(set3, set4).size();
        if (size2 == 0) {
            return 1.0f;
        }
        return size / size2;
    }

    private final boolean isTautologyOrAlias(String correctAnswer, String cleanCorrect, Set<String> wordsCorrect, String candidate) {
        String lowerCase = candidate.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String obj = StringsKt.trim((CharSequence) new Regex("[^a-z0-9 ]").replace(lowerCase, " ")).toString();
        if (Intrinsics.areEqual(cleanCorrect, obj)) {
            return true;
        }
        float calculateSimilarity = calculateSimilarity(cleanCorrect, obj);
        if (cleanCorrect.length() > 6 && obj.length() > 6 && calculateSimilarity >= 0.85f) {
            return true;
        }
        if (cleanCorrect.length() > 4 && obj.length() > 4) {
            String str = cleanCorrect;
            String str2 = obj;
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) str2, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) str, false, 2, (Object) null)) {
                return true;
            }
        }
        List<String> split = new Regex("\\s+").split(obj, 0);
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : split) {
            String str3 = (String) obj2;
            if (str3.length() <= 2) {
                String str4 = str3;
                for (int i = 0; i < str4.length(); i++) {
                    if (!Character.isDigit(str4.charAt(i))) {
                    }
                }
            }
            arrayList.add(obj2);
        }
        Set set = CollectionsKt.toSet(arrayList);
        if ((!wordsCorrect.isEmpty()) && (!set.isEmpty())) {
            int size = CollectionsKt.intersect(wordsCorrect, set).size();
            int min = Math.min(wordsCorrect.size(), set.size());
            if (min > 0 && size / min >= 0.75f) {
                return true;
            }
        }
        return false;
    }

    private final Integer extractYear(String s) {
        String value;
        MatchResult find$default = Regex.find$default(new Regex("\\b\\d{3,4}\\b"), s, 0, 2, null);
        if (find$default == null || (value = find$default.getValue()) == null) {
            return null;
        }
        return StringsKt.toIntOrNull(value);
    }

    private final float getSimilarity(String s1, String s2, String type) {
        String lowerCase = StringsKt.trim((CharSequence) s1).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String lowerCase2 = StringsKt.trim((CharSequence) s2).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
            return 1.0f;
        }
        if (Intrinsics.areEqual(type, "number") || Intrinsics.areEqual(type, "year/date")) {
            String str = lowerCase;
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (Character.isDigit(charAt) || charAt == '.') {
                    sb.append(charAt);
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            Double doubleOrNull = StringsKt.toDoubleOrNull(sb2);
            String str2 = lowerCase2;
            StringBuilder sb3 = new StringBuilder();
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char charAt2 = str2.charAt(i2);
                if (Character.isDigit(charAt2) || charAt2 == '.') {
                    sb3.append(charAt2);
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "toString(...)");
            Double doubleOrNull2 = StringsKt.toDoubleOrNull(sb4);
            if (doubleOrNull != null && doubleOrNull2 != null) {
                double abs = Math.abs(doubleOrNull.doubleValue() - doubleOrNull2.doubleValue());
                if (abs == 0.0d) {
                    return 1.0f;
                }
                double max = Math.max(Math.abs(doubleOrNull.doubleValue()), Math.abs(doubleOrNull2.doubleValue()));
                if (max > 0.0d) {
                    return RangesKt.coerceIn((float) (1.0d - (abs / max)), 0.0f, 1.0f);
                }
            }
        }
        return (calculateSimilarity(lowerCase, lowerCase2) * 0.5f) + (wordOverlapSimilarity(lowerCase, lowerCase2) * 0.5f);
    }

    static /* synthetic */ List generateSyntheticDistractors$default(McqEngine mcqEngine, String str, String str2, int i, List list, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            list = CollectionsKt.emptyList();
        }
        return mcqEngine.generateSyntheticDistractors(str, str2, i, list, z);
    }

    private final List<DistractorCandidate> generateSyntheticDistractors(String correctAnswer, String answerType, int needed, List<AliasEntity> aliases, boolean allowNota) {
        Double doubleOrNull;
        String format;
        ArrayList arrayList = new ArrayList();
        String str = correctAnswer;
        String lowerCase = StringsKt.trim((CharSequence) str).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        Set mutableSetOf = SetsKt.mutableSetOf(lowerCase);
        if (Intrinsics.areEqual(answerType, "number") || Intrinsics.areEqual(answerType, "year/date")) {
            MatchResult find$default = Regex.find$default(new Regex("[-+]?\\d+(?:\\.\\d+)?"), str, 0, 2, null);
            if (find$default != null && (doubleOrNull = StringsKt.toDoubleOrNull(find$default.getValue())) != null) {
                String substring = correctAnswer.substring(find$default.getRange().getLast() + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                String obj = StringsKt.trim((CharSequence) substring).toString();
                String substring2 = correctAnswer.substring(0, find$default.getRange().getFirst());
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                String obj2 = StringsKt.trim((CharSequence) substring2).toString();
                Iterator it = CollectionsKt.shuffled(CollectionsKt.listOf((Object[]) new Double[]{Double.valueOf(1.0d), Double.valueOf(-1.0d), Double.valueOf(2.0d), Double.valueOf(-2.0d), Double.valueOf(3.0d), Double.valueOf(-3.0d), Double.valueOf(4.0d), Double.valueOf(-4.0d), Double.valueOf(5.0d), Double.valueOf(-5.0d)}), this.random).iterator();
                while (it.hasNext()) {
                    double doubleValue = ((Number) it.next()).doubleValue();
                    String str2 = "";
                    String str3 = obj2.length() > 0 ? obj2 + " " : "";
                    if (doubleOrNull.doubleValue() + doubleValue == Math.floor(doubleOrNull.doubleValue() + doubleValue)) {
                        format = String.valueOf((long) (doubleOrNull.doubleValue() + doubleValue));
                    } else {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        format = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(doubleOrNull.doubleValue() + doubleValue)}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    }
                    if (obj.length() > 0) {
                        str2 = " " + obj;
                    }
                    generateSyntheticDistractors$addIfNew(arrayList, needed, mutableSetOf, str3 + format + str2);
                }
                return arrayList;
            }
        } else if (allowNota || needed > 0) {
            generateSyntheticDistractors$addIfNew(arrayList, needed, mutableSetOf, "None of the above");
            generateSyntheticDistractors$addIfNew(arrayList, needed, mutableSetOf, "All of the above");
            generateSyntheticDistractors$addIfNew(arrayList, needed, mutableSetOf, "Not enough information");
        }
        return arrayList;
    }

    private static final void generateSyntheticDistractors$addIfNew(List<DistractorCandidate> list, int i, Set<String> set, String str) {
        String obj = StringsKt.trim((CharSequence) str).toString();
        if (list.size() < i) {
            String lowerCase = obj.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (set.contains(lowerCase) || !(!StringsKt.isBlank(obj))) {
                return;
            }
            list.add(new DistractorCandidate(obj, -1L, DistractorSource.GLOBAL_POOL));
            String lowerCase2 = obj.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            set.add(lowerCase2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<DistractorCandidate> selectDistractors(CardEntity card, String correctAnswer, String answerType, String difficulty, HierarchyIndex index, List<AliasEntity> aliases, int notaCount, int maxNota) {
        List emptyList;
        String str;
        String str2;
        String str3;
        Set set;
        String str4;
        ArrayList arrayList;
        List emptyList2;
        ArrayList arrayList2 = new ArrayList();
        String lowerCase = StringsKt.trim((CharSequence) correctAnswer).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        Set mutableSetOf = SetsKt.mutableSetOf(lowerCase);
        boolean z = Intrinsics.areEqual(answerType, "number") || Intrinsics.areEqual(answerType, "year/date");
        boolean z2 = !z && notaCount < maxNota;
        boolean z3 = !z2 && notaCount >= maxNota;
        List<String> parseDeckHierarchy = DeckHierarchyUtils.INSTANCE.parseDeckHierarchy(card.getDeckHierarchy());
        String joinToString$default = parseDeckHierarchy.size() > 1 ? CollectionsKt.joinToString$default(CollectionsKt.dropLast(parseDeckHierarchy, 1), "::", null, null, 0, null, null, 62, null) : "";
        String str5 = (String) CollectionsKt.firstOrNull((List) parseDeckHierarchy);
        String str6 = str5 != null ? str5 : "";
        String lowerCase2 = correctAnswer.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        String obj = StringsKt.trim((CharSequence) new Regex("[^a-z0-9 ]").replace(lowerCase2, " ")).toString();
        List<String> split = new Regex("\\s+").split(obj, 0);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : split) {
            String str7 = (String) obj2;
            if (str7.length() <= 2) {
                String str8 = str7;
                for (int i = 0; i < str8.length(); i++) {
                    if (!Character.isDigit(str8.charAt(i))) {
                    }
                }
            }
            arrayList3.add(obj2);
        }
        Set set2 = CollectionsKt.toSet(arrayList3);
        ArrayList<AliasEntity> arrayList4 = new ArrayList();
        for (Object obj3 : aliases) {
            AliasEntity aliasEntity = (AliasEntity) obj3;
            String lowerCase3 = StringsKt.trim((CharSequence) aliasEntity.getName()).toString().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
            if (!Intrinsics.areEqual(lowerCase3, obj)) {
                String lowerCase4 = StringsKt.trim((CharSequence) aliasEntity.getAlias()).toString().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase4, obj)) {
                }
            }
            arrayList4.add(obj3);
        }
        ArrayList arrayList5 = new ArrayList();
        for (AliasEntity aliasEntity2 : arrayList4) {
            String lowerCase5 = StringsKt.trim((CharSequence) aliasEntity2.getName()).toString().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
            String lowerCase6 = StringsKt.trim((CharSequence) aliasEntity2.getAlias()).toString().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase6, "toLowerCase(...)");
            CollectionsKt.addAll(arrayList5, CollectionsKt.listOf((Object[]) new String[]{lowerCase5, lowerCase6}));
        }
        Set set3 = CollectionsKt.toSet(arrayList5);
        Gson gson = new Gson();
        Type type = new TypeToken<List<? extends String>>() { // from class: com.example.flashcardapp.mcq.McqEngine$selectDistractors$type$1
        }.getType();
        try {
            emptyList = (List) gson.fromJson(card.getTags(), type);
            if (emptyList == null) {
                emptyList = CollectionsKt.emptyList();
            }
        } catch (Exception unused) {
            emptyList = CollectionsKt.emptyList();
        }
        if (!emptyList.isEmpty()) {
            List<CardEntity> allCards = index.getAllCards();
            ArrayList arrayList6 = new ArrayList();
            for (Object obj4 : allCards) {
                String str9 = obj;
                try {
                    emptyList2 = (List) gson.fromJson(((CardEntity) obj4).getTags(), type);
                    if (emptyList2 == null) {
                        emptyList2 = CollectionsKt.emptyList();
                    }
                } catch (Exception unused2) {
                    emptyList2 = CollectionsKt.emptyList();
                }
                List list = emptyList2;
                String str10 = joinToString$default;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (emptyList.contains((String) it.next())) {
                            arrayList6.add(obj4);
                            break;
                        }
                    }
                }
                obj = str9;
                joinToString$default = str10;
            }
            str = obj;
            str3 = str6;
            str2 = joinToString$default;
            set = mutableSetOf;
            str4 = "toLowerCase(...)";
            arrayList = arrayList2;
            selectDistractors$addCandidatesFromPool$default(arrayList2, this, card, answerType, mutableSetOf, set3, correctAnswer, str, set2, index, z, z3, arrayList6, DistractorSource.SAME_DECK, false, 16384, null);
        } else {
            str = obj;
            str2 = joinToString$default;
            str3 = str6;
            set = mutableSetOf;
            str4 = "toLowerCase(...)";
            arrayList = arrayList2;
        }
        if (arrayList.size() < this.requiredDistractors) {
            String str11 = str2;
            if (str11.length() > 0) {
                selectDistractors$addCandidatesFromPool$default(arrayList, this, card, answerType, set, set3, correctAnswer, str, set2, index, z, z3, index.getByParentPath(str11), DistractorSource.SAME_DECK, false, 16384, null);
            }
        }
        if (arrayList.size() < this.requiredDistractors) {
            String str12 = str3;
            if (str12.length() > 0) {
                selectDistractors$addCandidatesFromPool$default(arrayList, this, card, answerType, set, set3, correctAnswer, str, set2, index, z, z3, index.getByRootSegment(str12), DistractorSource.SAME_ROOT, false, 16384, null);
            }
        }
        if (arrayList.size() < this.requiredDistractors) {
            selectDistractors$addCandidatesFromPool(arrayList, this, card, answerType, set, set3, correctAnswer, str, set2, index, z, z3, index.getAllCards(), DistractorSource.GLOBAL_POOL, false);
        }
        if (arrayList.size() < this.requiredDistractors) {
            selectDistractors$addCandidatesFromPool(arrayList, this, card, answerType, set, set3, correctAnswer, str, set2, index, z, z3, index.getAllCards(), DistractorSource.GLOBAL_POOL, true);
        }
        int size = arrayList.size();
        int i2 = this.requiredDistractors;
        if (size < i2) {
            for (DistractorCandidate distractorCandidate : generateSyntheticDistractors(correctAnswer, answerType, i2 - arrayList.size(), aliases, z2)) {
                if (arrayList.size() >= this.requiredDistractors) {
                    break;
                }
                String lowerCase7 = distractorCandidate.getText().toLowerCase(Locale.ROOT);
                String str13 = str4;
                Intrinsics.checkNotNullExpressionValue(lowerCase7, str13);
                Set set4 = set;
                if (!set4.contains(lowerCase7)) {
                    arrayList.add(distractorCandidate);
                    String lowerCase8 = distractorCandidate.getText().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase8, str13);
                    set4.add(lowerCase8);
                }
                str4 = str13;
                set = set4;
            }
        }
        return arrayList;
    }

    static /* synthetic */ void selectDistractors$addCandidatesFromPool$default(List list, McqEngine mcqEngine, CardEntity cardEntity, String str, Set set, Set set2, String str2, String str3, Set set3, HierarchyIndex hierarchyIndex, boolean z, boolean z2, List list2, DistractorSource distractorSource, boolean z3, int i, Object obj) {
        selectDistractors$addCandidatesFromPool(list, mcqEngine, cardEntity, str, set, set2, str2, str3, set3, hierarchyIndex, z, z2, list2, distractorSource, (i & 16384) != 0 ? false : z3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0139, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r28.getType(r6.getId()), r1) == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0174, code lost:
    
        if (r3 <= 50) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0193, code lost:
    
        if (r3 <= r13) goto L68;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void selectDistractors$addCandidatesFromPool(java.util.List<com.example.flashcardapp.mcq.DistractorCandidate> r19, com.example.flashcardapp.mcq.McqEngine r20, com.example.flashcardapp.data.entities.CardEntity r21, java.lang.String r22, java.util.Set<java.lang.String> r23, java.util.Set<java.lang.String> r24, java.lang.String r25, java.lang.String r26, java.util.Set<java.lang.String> r27, com.example.flashcardapp.mcq.HierarchyIndex r28, boolean r29, boolean r30, java.util.List<com.example.flashcardapp.data.entities.CardEntity> r31, com.example.flashcardapp.mcq.DistractorSource r32, boolean r33) {
        /*
            Method dump skipped, instructions count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.mcq.McqEngine.selectDistractors$addCandidatesFromPool(java.util.List, com.example.flashcardapp.mcq.McqEngine, com.example.flashcardapp.data.entities.CardEntity, java.lang.String, java.util.Set, java.util.Set, java.lang.String, java.lang.String, java.util.Set, com.example.flashcardapp.mcq.HierarchyIndex, boolean, boolean, java.util.List, com.example.flashcardapp.mcq.DistractorSource, boolean):void");
    }
}

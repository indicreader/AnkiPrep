package com.example.flashcardapp.mcq;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: SemanticClassifier.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J \u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J \u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J \u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J \u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/example/flashcardapp/mcq/SemanticClassifier;", "", "()V", "currencyRegex", "Lkotlin/text/Regex;", "dateRegex", "nameRegex", "nameRegexWithInitials", "numberRegex", "pureYearRegex", "wordNumberRegex", "classify", "", "question", "answer", "isLawOrArticle", "", "q", "a", "aLower", "isNumber", "isPerson", "isPlace", "isYearOrDate", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class SemanticClassifier {
    public static final SemanticClassifier INSTANCE = new SemanticClassifier();
    private static final Regex dateRegex = new Regex("\\b\\d{1,2}[-/. ]([A-Za-z]+|\\d{1,2})[-/. ]\\d{2,4}\\b");
    private static final Regex pureYearRegex = new Regex("\\b(?:1\\d{3}|20\\d{2}|[1-9]\\d{2})\\b(?:\\s*(?:B\\.?C\\.?|A\\.?D\\.?|B\\.?C\\.?E\\.?|C\\.?E\\.?))?");
    private static final Regex numberRegex = new Regex("\\b[-+]?\\s*(?:\\d{1,3}(?:,\\d{3})*|\\d+)(?:\\.\\d+)?\\s*%?\\b");
    private static final Regex currencyRegex = new Regex("[$€£¥]\\s*[-+]?\\s*(?:\\d{1,3}(?:,\\d{3})*|\\d+)(?:\\.\\d+)?\\b");
    private static final Regex wordNumberRegex = new Regex("\\b\\d+\\s*(?:million|billion|trillion|percent|meters|metres|km|miles|kg|lbs|degrees|hours|days|years|old)\\b");
    private static final Regex nameRegex = new Regex("^[A-Z][a-zA-Z]+(?:\\s+[A-Z][a-zA-Z]+){1,2}$");
    private static final Regex nameRegexWithInitials = new Regex("^[A-Z][a-zA-Z]*(?:\\s+[A-Z]\\.)?\\s+[A-Z][a-zA-Z]+$");
    public static final int $stable = 8;

    private SemanticClassifier() {
    }

    public final String classify(String question, String answer) {
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(answer, "answer");
        String lowerCase = StringsKt.trim((CharSequence) question).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String obj = StringsKt.trim((CharSequence) answer).toString();
        String lowerCase2 = obj.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        return isYearOrDate(lowerCase, obj, lowerCase2) ? "year/date" : isLawOrArticle(lowerCase, obj, lowerCase2) ? "law/article" : isNumber(lowerCase, obj, lowerCase2) ? "number" : isPerson(lowerCase, obj, lowerCase2) ? "person" : isPlace(lowerCase, obj, lowerCase2) ? "place" : "concept";
    }

    private final boolean isYearOrDate(String q, String a, String aLower) {
        boolean z;
        boolean z2;
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december", "jan", "feb", "mar", "apr", "jun", "jul", "aug", "sep", "oct", "nov", "dec"});
        if (!(listOf instanceof Collection) || !listOf.isEmpty()) {
            Iterator it = listOf.iterator();
            while (it.hasNext()) {
                if (StringsKt.contains$default((CharSequence) aLower, (CharSequence) it.next(), false, 2, (Object) null)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        String str = aLower;
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                z2 = false;
                break;
            }
            if (Character.isDigit(str.charAt(i))) {
                z2 = true;
                break;
            }
            i++;
        }
        List listOf2 = CollectionsKt.listOf((Object[]) new String[]{"when", "what year", "which year", "what date", "which date", "founded in", "established in", "born in", "died in", "published in"});
        String str2 = a;
        if (dateRegex.containsMatchIn(str2) || pureYearRegex.matches(str2)) {
            return true;
        }
        if ((z && z2) || StringsKt.contains$default((CharSequence) str, (CharSequence) "century", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "decade", false, 2, (Object) null)) {
            return true;
        }
        List list = listOf2;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                if (StringsKt.contains$default((CharSequence) q, (CharSequence) it2.next(), false, 2, (Object) null)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean isLawOrArticle(String q, String a, String aLower) {
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"article", "section", "amendment", "law", "act", "bill", "treaty", "clause", "statute", "code", "doctrine", "theorem", "principle", "postulate"});
        String str = aLower;
        boolean z = StringsKt.contains$default((CharSequence) str, (CharSequence) "=", false, 2, (Object) null) && (StringsKt.contains$default((CharSequence) str, (CharSequence) "v", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "i", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "r", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "f", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "m", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "a", false, 2, (Object) null));
        List list = listOf;
        boolean z2 = list instanceof Collection;
        if (!z2 || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (StringsKt.contains$default((CharSequence) str, (CharSequence) it.next(), false, 2, (Object) null)) {
                    break;
                }
            }
        }
        if (!z2 || !list.isEmpty()) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                if (StringsKt.contains$default((CharSequence) q, (CharSequence) it2.next(), false, 2, (Object) null)) {
                    break;
                }
            }
        }
        if (!z && !StringsKt.contains$default((CharSequence) str, (CharSequence) "amendment", false, 2, (Object) null)) {
            return false;
        }
        return true;
    }

    private final boolean isNumber(String q, String a, String aLower) {
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"how many", "how much", "percentage of", "what percent", "what number", "quantity", "count"});
        String obj = StringsKt.trim((CharSequence) a).toString();
        String str = obj;
        MatchResult find$default = Regex.find$default(numberRegex, str, 0, 2, null);
        boolean z = find$default != null && Intrinsics.areEqual(StringsKt.trim((CharSequence) find$default.getValue()).toString(), obj);
        MatchResult find$default2 = Regex.find$default(currencyRegex, str, 0, 2, null);
        boolean z2 = find$default2 != null && Intrinsics.areEqual(StringsKt.trim((CharSequence) find$default2.getValue()).toString(), obj);
        if (!z && !z2 && !wordNumberRegex.containsMatchIn(aLower)) {
            List list = listOf;
            if ((list instanceof Collection) && list.isEmpty()) {
                return false;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (StringsKt.contains$default((CharSequence) q, (CharSequence) it.next(), false, 2, (Object) null)) {
                }
            }
            return false;
        }
        return true;
    }

    private final boolean isPerson(String q, String a, String aLower) {
        boolean z;
        List<String> listOf = CollectionsKt.listOf((Object[]) new String[]{"mr", "mrs", "ms", "dr", "prof", "sir", "president", "king", "queen", "emperor", "pope", "lord", "lady", "saint", "st"});
        if (!(listOf instanceof Collection) || !listOf.isEmpty()) {
            for (String str : listOf) {
                if (StringsKt.startsWith$default(aLower, str + " ", false, 2, (Object) null) || StringsKt.startsWith$default(aLower, str + ".", false, 2, (Object) null)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        List listOf2 = CollectionsKt.listOf((Object[]) new String[]{"who is", "who was", "whose", "who wrote", "who painted", "who discovered", "who invented", "written by", "discovered by", "invented by", "led by", "ruled by", "founded by", "authored by", "directed by"});
        if (z) {
            return true;
        }
        String str2 = a;
        if (nameRegex.matches(str2) || nameRegexWithInitials.matches(str2)) {
            return true;
        }
        List list = listOf2;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (StringsKt.contains$default((CharSequence) q, (CharSequence) it.next(), false, 2, (Object) null)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean isPlace(String q, String a, String aLower) {
        boolean z;
        boolean z2;
        boolean z3;
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"in ", "at ", "to ", "from "});
        if (!(listOf instanceof Collection) || !listOf.isEmpty()) {
            Iterator it = listOf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (StringsKt.startsWith$default(aLower, (String) it.next(), false, 2, (Object) null)) {
                    Character firstOrNull = StringsKt.firstOrNull(StringsKt.substringAfter$default(a, " ", (String) null, 2, (Object) null));
                    if (firstOrNull != null && Character.isUpperCase(firstOrNull.charValue())) {
                        z = true;
                    }
                }
            }
        }
        z = false;
        List listOf2 = CollectionsKt.listOf((Object[]) new String[]{"city", "state", "country", "capital", "mountain", "ocean", "sea", "lake", "river", "continent", "island", "desert", "valley", "republic", "kingdom", "nation", "location", "headquarters"});
        if (!(listOf2 instanceof Collection) || !listOf2.isEmpty()) {
            Iterator it2 = listOf2.iterator();
            while (it2.hasNext()) {
                if (StringsKt.contains$default((CharSequence) aLower, (CharSequence) it2.next(), false, 2, (Object) null)) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        List listOf3 = CollectionsKt.listOf((Object[]) new String[]{"usa", "uk", "america", "london", "paris", "tokyo", "rome", "india", "china", "japan", "germany", "france", "italy", "spain", "canada", "brazil", "russia", "australia", "africa", "asia", "europe", "antarctica", "egypt", "washington", "new york", "beijing", "moscow", "berlin", "delhi", "mumbai"});
        if (!(listOf3 instanceof Collection) || !listOf3.isEmpty()) {
            Iterator it3 = listOf3.iterator();
            while (it3.hasNext()) {
                if (StringsKt.contains$default((CharSequence) aLower, (CharSequence) it3.next(), false, 2, (Object) null)) {
                    z3 = true;
                    break;
                }
            }
        }
        z3 = false;
        List listOf4 = CollectionsKt.listOf((Object[]) new String[]{"where ", "location of", "located in", "situated in", "capital of", "which country", "which city", "which state"});
        if (z || z2 || z3) {
            return true;
        }
        List list = listOf4;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it4 = list.iterator();
            while (it4.hasNext()) {
                if (StringsKt.contains$default((CharSequence) q, (CharSequence) it4.next(), false, 2, (Object) null)) {
                    return true;
                }
            }
        }
        return false;
    }
}

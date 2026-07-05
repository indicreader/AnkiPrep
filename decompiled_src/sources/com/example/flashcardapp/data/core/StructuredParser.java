package com.example.flashcardapp.data.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: StructuredParser.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/example/flashcardapp/data/core/StructuredParser;", "", "()V", "EXPLANATION_TAGS", "", "", "FUTURE_TAGS", "parse", "Lcom/example/flashcardapp/data/core/ParsedCard;", "content", "parseCard", "front", "back", "parseOneLinerBack", "Lkotlin/Pair;", "splitByCommaOrColon", "", "text", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class StructuredParser {
    public static final StructuredParser INSTANCE = new StructuredParser();
    private static final Set<String> EXPLANATION_TAGS = SetsKt.setOf((Object[]) new String[]{"explain", "explanation", "explaination"});
    private static final Set<String> FUTURE_TAGS = SetsKt.setOf((Object[]) new String[]{"hint", "mnemonic", "warning", "formula", "memorytrap"});
    public static final int $stable = 8;

    private StructuredParser() {
    }

    public final ParsedCard parse(String content) {
        String str;
        int length;
        str = "";
        String str2 = content == null ? "" : content;
        String str3 = str2;
        if (StringsKt.isBlank(str3)) {
            return new ParsedCard("", "", "", CollectionsKt.emptyList(), MapsKt.emptyMap(), CollectionsKt.emptyList(), str2);
        }
        int i = 0;
        List list = SequencesKt.toList(Regex.findAll$default(new Regex("\\{([a-zA-Z0-9_-]+)\\}"), str3, 0, 2, null));
        String substring = str2.substring(0, list.isEmpty() ^ true ? ((MatchResult) CollectionsKt.first(list)).getRange().getFirst() : str2.length());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        String obj = StringsKt.trim((CharSequence) substring).toString();
        List emptyList = CollectionsKt.emptyList();
        String str4 = obj;
        List split$default = StringsKt.split$default((CharSequence) str4, new String[]{"|"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        Iterator it = split$default.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((String) obj2).length() > 0) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.size() > 1) {
            obj = (String) arrayList3.get(0);
            emptyList = CollectionsKt.toMutableList((Collection) CollectionsKt.drop(arrayList3, 1));
            String str5 = (String) CollectionsKt.last(emptyList);
            String str6 = str5;
            int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str6, ';', 0, false, 6, (Object) null);
            if (lastIndexOf$default != -1) {
                String substring2 = str5.substring(0, lastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                String obj3 = StringsKt.trim((CharSequence) substring2).toString();
                String substring3 = str5.substring(lastIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
                String obj4 = StringsKt.trim((CharSequence) substring3).toString();
                str = obj4.length() > 0 ? obj4 : "";
                if (obj3.length() > 0) {
                    emptyList.set(emptyList.size() - 1, obj3);
                } else {
                    emptyList.remove(emptyList.size() - 1);
                }
            } else if (arrayList3.size() >= 5 || (arrayList3.size() >= 3 && StringsKt.contains$default((CharSequence) str6, (CharSequence) " ", false, 2, (Object) null) && str5.length() > 15)) {
                emptyList.remove(emptyList.size() - 1);
                str = str5;
            }
        } else {
            int lastIndexOf$default2 = StringsKt.lastIndexOf$default((CharSequence) str4, ';', 0, false, 6, (Object) null);
            if (lastIndexOf$default2 != -1) {
                String substring4 = obj.substring(lastIndexOf$default2 + 1);
                Intrinsics.checkNotNullExpressionValue(substring4, "substring(...)");
                str = StringsKt.trim((CharSequence) substring4).toString();
                String substring5 = obj.substring(0, lastIndexOf$default2);
                Intrinsics.checkNotNullExpressionValue(substring5, "substring(...)");
                obj = StringsKt.trim((CharSequence) substring5).toString();
            }
        }
        String str7 = obj;
        ArrayList arrayList4 = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = list.size();
        while (i < size) {
            MatchResult matchResult = (MatchResult) list.get(i);
            String str8 = matchResult.getGroupValues().get(1);
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = str8.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            int last = matchResult.getRange().getLast() + 1;
            i++;
            if (i < list.size()) {
                length = ((MatchResult) list.get(i)).getRange().getFirst();
            } else {
                length = str2.length();
            }
            String substring6 = str2.substring(last, length);
            Intrinsics.checkNotNullExpressionValue(substring6, "substring(...)");
            String obj5 = StringsKt.trim((CharSequence) substring6).toString();
            if (EXPLANATION_TAGS.contains(lowerCase)) {
                if (str.length() != 0) {
                    obj5 = str + "\n" + obj5;
                }
                str = obj5;
            } else if (Intrinsics.areEqual(lowerCase, "hint")) {
                if (obj5.length() > 0) {
                    arrayList4.add(obj5);
                }
            } else {
                linkedHashMap.put(lowerCase, obj5);
            }
        }
        return new ParsedCard("", str7, StringsKt.trim((CharSequence) str).toString(), arrayList4, linkedHashMap, emptyList, str2);
    }

    private final List<String> splitByCommaOrColon(String text) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < text.length(); i2++) {
            char charAt = text.charAt(i2);
            if (charAt == '\"') {
                z = !z;
            } else if (charAt == '(' && !z) {
                i++;
            } else if (charAt == ')' && !z) {
                i = RangesKt.coerceAtLeast(i - 1, 0);
            } else if ((charAt == ',' || charAt == ':') && !z && i == 0) {
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                arrayList.add(sb2);
                StringsKt.clear(sb);
            } else {
                sb.append(charAt);
            }
        }
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        arrayList.add(sb3);
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(StringsKt.trim((CharSequence) it.next()).toString());
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : arrayList3) {
            if (((String) obj).length() > 0) {
                arrayList4.add(obj);
            }
        }
        return arrayList4;
    }

    private final Pair<String, String> parseOneLinerBack(String back) {
        List<String> splitByCommaOrColon = splitByCommaOrColon(back);
        if (splitByCommaOrColon.size() >= 2) {
            String str = (String) CollectionsKt.last((List) splitByCommaOrColon);
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) " ", false, 2, (Object) null) || str.length() > 15) {
                return new Pair<>(CollectionsKt.joinToString$default(CollectionsKt.take(splitByCommaOrColon, splitByCommaOrColon.size() - 1), ", ", null, null, 0, null, null, 62, null), str);
            }
        }
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) back, ';', 0, false, 6, (Object) null);
        if (lastIndexOf$default != -1) {
            String substring = back.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            String obj = StringsKt.trim((CharSequence) substring).toString();
            String substring2 = back.substring(lastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            return new Pair<>(obj, StringsKt.trim((CharSequence) substring2).toString());
        }
        return new Pair<>(back, "");
    }

    public final ParsedCard parseCard(String front, String back) {
        String joinToString$default;
        String str;
        String str2;
        String obj;
        Intrinsics.checkNotNullParameter(front, "front");
        Intrinsics.checkNotNullParameter(back, "back");
        String obj2 = StringsKt.trim((CharSequence) front).toString();
        String obj3 = StringsKt.trim((CharSequence) back).toString();
        String str3 = obj2;
        if (StringsKt.contains$default((CharSequence) str3, (CharSequence) "|", false, 2, (Object) null)) {
            int indexOf$default = StringsKt.indexOf$default((CharSequence) str3, '|', 0, false, 6, (Object) null);
            int max = Math.max(StringsKt.lastIndexOf$default((CharSequence) str3, ':', indexOf$default, false, 4, (Object) null), StringsKt.lastIndexOf$default((CharSequence) str3, ',', indexOf$default, false, 4, (Object) null));
            if (max != -1) {
                String substring = obj2.substring(0, max);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                str2 = StringsKt.trim((CharSequence) substring).toString();
                String substring2 = obj2.substring(max + 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                obj = StringsKt.trim((CharSequence) substring2).toString();
            } else {
                String substring3 = obj2.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
                String obj4 = StringsKt.trim((CharSequence) substring3).toString();
                String substring4 = obj2.substring(indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring4, "substring(...)");
                str2 = obj4;
                obj = StringsKt.trim((CharSequence) substring4).toString();
            }
            ParsedCard parse = parse(obj);
            ParsedCard parse2 = parse(obj3);
            List listOf = CollectionsKt.listOf((Object[]) new String[]{parse.getExplanation(), parse2.getAnswer(), parse2.getExplanation()});
            ArrayList arrayList = new ArrayList();
            for (Object obj5 : listOf) {
                if (((String) obj5).length() > 0) {
                    arrayList.add(obj5);
                }
            }
            return new ParsedCard(str2, parse.getAnswer(), CollectionsKt.joinToString$default(CollectionsKt.distinct(arrayList), "\n", null, null, 0, null, null, 62, null), CollectionsKt.distinct(CollectionsKt.plus((Collection) parse.getHints(), (Iterable) parse2.getHints())), MapsKt.plus(parse.getMetadata(), parse2.getMetadata()), parse.getOptions(), front + "\n" + back);
        }
        String str4 = obj3;
        if (StringsKt.contains$default((CharSequence) str4, (CharSequence) "|", false, 2, (Object) null)) {
            ParsedCard parse3 = parse(obj3);
            return new ParsedCard(obj2, parse3.getAnswer(), parse3.getExplanation(), parse3.getHints(), parse3.getMetadata(), parse3.getOptions(), front + "\n" + back);
        }
        if (str4.length() == 0 && (StringsKt.contains$default((CharSequence) str3, (CharSequence) ",", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str3, (CharSequence) ":", false, 2, (Object) null))) {
            List<String> splitByCommaOrColon = splitByCommaOrColon(obj2);
            if (splitByCommaOrColon.size() >= 2) {
                String str5 = (String) CollectionsKt.last((List) splitByCommaOrColon);
                boolean z = StringsKt.contains$default((CharSequence) str5, (CharSequence) " ", false, 2, (Object) null) || str5.length() > 15;
                if (splitByCommaOrColon.size() >= 3 && z) {
                    String str6 = splitByCommaOrColon.get(splitByCommaOrColon.size() - 2);
                    joinToString$default = CollectionsKt.joinToString$default(CollectionsKt.take(splitByCommaOrColon, splitByCommaOrColon.size() - 2), ", ", null, null, 0, null, null, 62, null);
                    str = str5;
                    str5 = str6;
                } else {
                    joinToString$default = CollectionsKt.joinToString$default(CollectionsKt.take(splitByCommaOrColon, splitByCommaOrColon.size() - 1), ", ", null, null, 0, null, null, 62, null);
                    str = "";
                }
                return new ParsedCard(StringsKt.trim((CharSequence) joinToString$default).toString(), StringsKt.trim((CharSequence) str5).toString(), StringsKt.trim((CharSequence) str).toString(), null, null, null, front, 56, null);
            }
        }
        Pair<String, String> parseOneLinerBack = parseOneLinerBack(obj3);
        return new ParsedCard(obj2, parseOneLinerBack.getFirst(), parseOneLinerBack.getSecond(), null, null, null, front + "\n" + back, 56, null);
    }
}

package com.example.flashcardapp.mcq;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: EnglishEngine.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/example/flashcardapp/mcq/EnglishEngine;", "", "dbHelper", "Lcom/example/flashcardapp/mcq/EnglishDatabaseHelper;", "(Lcom/example/flashcardapp/mcq/EnglishDatabaseHelper;)V", "buildDynamicExplanation", "", "", "optionsList", "", "generateMcqOptions", "targetRow", "Lcom/example/flashcardapp/mcq/EnglishQuestion;", "generateQuiz", "Lcom/example/flashcardapp/mcq/Mcq;", "limit", "", "getDailyDoseQuestions", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class EnglishEngine {
    public static final int $stable = 8;
    private final EnglishDatabaseHelper dbHelper;

    public EnglishEngine(EnglishDatabaseHelper dbHelper) {
        Intrinsics.checkNotNullParameter(dbHelper, "dbHelper");
        this.dbHelper = dbHelper;
    }

    private final List<EnglishQuestion> getDailyDoseQuestions(int limit) {
        SQLiteDatabase readableDatabase = this.dbHelper.getReadableDatabase();
        ArrayList arrayList = new ArrayList();
        int i = limit / 3;
        int i2 = limit % 3;
        int i3 = 0;
        for (Object obj : CollectionsKt.listOf((Object[]) new String[]{"synonym", "antonym", "substitute"})) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            int i5 = (i3 < i2 ? 1 : 0) + i;
            if (i5 > 0) {
                Cursor rawQuery = readableDatabase.rawQuery("SELECT * FROM english_dictionary WHERE type = ? ORDER BY RANDOM() LIMIT ?", new String[]{str, String.valueOf(i5)});
                while (rawQuery.moveToNext()) {
                    String string = rawQuery.getString(rawQuery.getColumnIndexOrThrow("concept_id"));
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    String string2 = rawQuery.getString(rawQuery.getColumnIndexOrThrow("type"));
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    String string3 = rawQuery.getString(rawQuery.getColumnIndexOrThrow("word_or_sentence"));
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    String string4 = rawQuery.getString(rawQuery.getColumnIndexOrThrow("correct_answer"));
                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                    String string5 = rawQuery.getString(rawQuery.getColumnIndexOrThrow("meaning"));
                    Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                    String string6 = rawQuery.getString(rawQuery.getColumnIndexOrThrow("associated_words"));
                    if (string6 == null) {
                        string6 = "";
                    } else {
                        Intrinsics.checkNotNull(string6);
                    }
                    arrayList.add(new EnglishQuestion(string, string2, string3, string4, string5, string6));
                }
                rawQuery.close();
            }
            i3 = i4;
        }
        return CollectionsKt.shuffled(arrayList);
    }

    private final List<String> generateMcqOptions(EnglishQuestion targetRow) {
        SQLiteDatabase readableDatabase = this.dbHelper.getReadableDatabase();
        List split$default = StringsKt.split$default((CharSequence) targetRow.getAssociatedWords(), new String[]{"|"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        Iterator it = split$default.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        List mutableList = CollectionsKt.toMutableList((Collection) arrayList2);
        mutableList.add(targetRow.getCorrectAnswer());
        List distinct = CollectionsKt.distinct(mutableList);
        Cursor rawQuery = readableDatabase.rawQuery("SELECT correct_answer FROM english_dictionary WHERE type = ? AND correct_answer NOT IN (" + CollectionsKt.joinToString$default(distinct, ",", null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.example.flashcardapp.mcq.EnglishEngine$generateMcqOptions$placeholders$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(String it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                return "?";
            }
        }, 30, null) + ") ORDER BY RANDOM() LIMIT 3", (String[]) ArraysKt.plus((Object[]) new String[]{targetRow.getType()}, distinct.toArray(new String[0])));
        ArrayList arrayList3 = new ArrayList();
        while (rawQuery.moveToNext()) {
            String string = rawQuery.getString(rawQuery.getColumnIndexOrThrow("correct_answer"));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            arrayList3.add(string);
        }
        rawQuery.close();
        while (arrayList3.size() < 3) {
            arrayList3.add("Fallback Option " + (arrayList3.size() + 1));
        }
        return CollectionsKt.shuffled(CollectionsKt.plus((Collection<? extends String>) arrayList3, targetRow.getCorrectAnswer()));
    }

    private final Map<String, String> buildDynamicExplanation(List<String> optionsList) {
        if (optionsList.isEmpty()) {
            return MapsKt.emptyMap();
        }
        Cursor rawQuery = this.dbHelper.getReadableDatabase().rawQuery("SELECT correct_answer, meaning FROM english_dictionary WHERE correct_answer IN (" + CollectionsKt.joinToString$default(optionsList, ",", null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.example.flashcardapp.mcq.EnglishEngine$buildDynamicExplanation$placeholders$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return "?";
            }
        }, 30, null) + ")", (String[]) optionsList.toArray(new String[0]));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (rawQuery.moveToNext()) {
            String string = rawQuery.getString(rawQuery.getColumnIndexOrThrow("correct_answer"));
            String string2 = rawQuery.getString(rawQuery.getColumnIndexOrThrow("meaning"));
            Intrinsics.checkNotNull(string);
            Intrinsics.checkNotNull(string2);
            linkedHashMap.put(string, string2);
        }
        rawQuery.close();
        for (String str : optionsList) {
            if (!linkedHashMap.containsKey(str)) {
                linkedHashMap.put(str, "Meaning not found in database.");
            }
        }
        return linkedHashMap;
    }

    public final List<Mcq> generateQuiz(int limit) {
        String str;
        List<EnglishQuestion> dailyDoseQuestions = getDailyDoseQuestions(limit);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(dailyDoseQuestions, 10));
        char c = 0;
        int i = 0;
        for (Object obj : dailyDoseQuestions) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            EnglishQuestion englishQuestion = (EnglishQuestion) obj;
            List<String> generateMcqOptions = generateMcqOptions(englishQuestion);
            Map<String, String> buildDynamicExplanation = buildDynamicExplanation(generateMcqOptions);
            StringBuilder sb = new StringBuilder("Meanings:\n");
            for (String str2 : generateMcqOptions) {
                sb.append("• " + str2 + ": " + ((Object) buildDynamicExplanation.get(str2)) + "\n");
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            String type = englishQuestion.getType();
            int hashCode = type.hashCode();
            if (hashCode == -1742128133) {
                if (type.equals("synonym")) {
                    str = "What is a synonym for: ";
                }
                str = "";
            } else if (hashCode != -846704742) {
                if (hashCode == -741038950 && type.equals("substitute")) {
                    str = "What word means: ";
                }
                str = "";
            } else {
                if (type.equals("antonym")) {
                    str = "What is an antonym for: ";
                }
                str = "";
            }
            String str3 = str + englishQuestion.getWordOrSentence();
            int indexOf = generateMcqOptions.indexOf(englishQuestion.getCorrectAnswer());
            long j = i;
            Long[] lArr = new Long[3];
            lArr[c] = -1L;
            lArr[1] = -1L;
            lArr[2] = -1L;
            arrayList.add(new Mcq(str3, generateMcqOptions, indexOf, j, CollectionsKt.listOf((Object[]) lArr), "English Daily Dose", StringsKt.trim((CharSequence) sb2).toString(), "medium", englishQuestion.getType(), null, null, null, null, null, 15872, null));
            i = i2;
            c = 0;
        }
        return arrayList;
    }
}

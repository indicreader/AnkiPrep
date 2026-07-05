package com.example.flashcardapp.data;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: CsvImporter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J@\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\bH\u0002J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\bH\u0002J\f\u0010\u001c\u001a\u00020\u0006*\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/example/flashcardapp/data/CsvImporter;", "", "()V", "BATCH_SIZE", "", "TAG", "", "detectDelimiter", "", "firstLine", "getFileName", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "importCsv", "Lcom/example/flashcardapp/data/ImportResult;", "targetDeckId", "", "targetDeckName", "duplicateStrategy", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "looksLikeHeader", "", "delimiter", "splitCsvLine", "", "line", "trimQuotes", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class CsvImporter {
    public static final int $stable = 0;
    private static final int BATCH_SIZE = 200;
    public static final CsvImporter INSTANCE = new CsvImporter();
    private static final String TAG = "CsvImporter";

    private CsvImporter() {
    }

    public final Object importCsv(Context context, Uri uri, Long l, String str, String str2, Continuation<? super ImportResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new CsvImporter$importCsv$2(context, uri, l, str, str2, null), continuation);
    }

    public final char detectDelimiter(String firstLine) {
        Object next;
        Pair[] pairArr = new Pair[3];
        String str = firstLine;
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == ',') {
                i++;
            }
        }
        pairArr[0] = TuplesKt.to(',', Integer.valueOf(i));
        int i3 = 0;
        for (int i4 = 0; i4 < str.length(); i4++) {
            if (str.charAt(i4) == ';') {
                i3++;
            }
        }
        pairArr[1] = TuplesKt.to(';', Integer.valueOf(i3));
        int i5 = 0;
        for (int i6 = 0; i6 < str.length(); i6++) {
            if (str.charAt(i6) == '\t') {
                i5++;
            }
        }
        pairArr[2] = TuplesKt.to('\t', Integer.valueOf(i5));
        Iterator it = MapsKt.mapOf(pairArr).entrySet().iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int intValue = ((Number) ((Map.Entry) next).getValue()).intValue();
                do {
                    Object next2 = it.next();
                    int intValue2 = ((Number) ((Map.Entry) next2).getValue()).intValue();
                    if (intValue < intValue2) {
                        next = next2;
                        intValue = intValue2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry == null) {
            return ',';
        }
        Map.Entry entry2 = ((Number) entry.getValue()).intValue() > 0 ? entry : null;
        if (entry2 != null) {
            return ((Character) entry2.getKey()).charValue();
        }
        return ',';
    }

    public final boolean looksLikeHeader(String firstLine, char delimiter) {
        String obj;
        String trimQuotes;
        List<String> splitCsvLine = splitCsvLine(firstLine, delimiter);
        Set of = SetsKt.setOf((Object[]) new String[]{"front", "back", "question", "answer", "term", "definition", "q", "a", "tags"});
        String str = (String) CollectionsKt.getOrNull(splitCsvLine, 0);
        if (str != null && (obj = StringsKt.trim((CharSequence) str).toString()) != null && (trimQuotes = trimQuotes(obj)) != null) {
            String lowerCase = trimQuotes.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase != null) {
                return of.contains(lowerCase);
            }
        }
        return false;
    }

    public final List<String> splitCsvLine(String line, char delimiter) {
        int i;
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        boolean z = false;
        while (i2 < line.length()) {
            char charAt = line.charAt(i2);
            if (charAt == '\"' && !z) {
                z = true;
            } else if (charAt == '\"' && z && (i = i2 + 1) < line.length() && line.charAt(i) == '\"') {
                sb.append(Typography.quote);
                i2 = i;
            } else if (charAt == '\"' && z) {
                z = false;
            } else if (charAt == delimiter && !z) {
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                arrayList.add(sb2);
                StringsKt.clear(sb);
            } else {
                sb.append(charAt);
            }
            i2++;
        }
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        arrayList.add(sb3);
        return arrayList;
    }

    public final String trimQuotes(String str) {
        if (str.length() < 2) {
            return str;
        }
        String str2 = str;
        if (!StringsKt.startsWith$default((CharSequence) str2, Typography.quote, false, 2, (Object) null) || !StringsKt.endsWith$default((CharSequence) str2, Typography.quote, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(1, str.length() - 1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public final String getFileName(Context context, Uri uri) {
        String str;
        Cursor query;
        int columnIndex;
        String str2 = null;
        if (!Intrinsics.areEqual(uri.getScheme(), "content") || (query = context.getContentResolver().query(uri, null, null, null, null)) == null) {
            str = null;
        } else {
            Cursor cursor = query;
            try {
                Cursor cursor2 = cursor;
                str = (!cursor2.moveToFirst() || (columnIndex = cursor2.getColumnIndex("_display_name")) < 0) ? null : cursor2.getString(columnIndex);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursor, th);
                    throw th2;
                }
            }
        }
        if (str == null) {
            str = uri.getPath();
            int lastIndexOf$default = str != null ? StringsKt.lastIndexOf$default((CharSequence) str, '/', 0, false, 6, (Object) null) : -1;
            if (lastIndexOf$default != -1) {
                if (str != null) {
                    str2 = str.substring(lastIndexOf$default + 1);
                    Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
                }
                str = str2;
            }
        }
        return str == null ? "import.csv" : str;
    }
}

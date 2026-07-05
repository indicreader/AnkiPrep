package com.example.flashcardapp.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: ApkgImporter.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J6\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0086@¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/example/flashcardapp/data/ApkgImporter;", "", "()V", "BUFFER_SIZE", "", "TAG", "", "getFileName", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "importApkg", "Lcom/example/flashcardapp/data/ImportResult;", "targetDeckId", "", "targetDeckName", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/Long;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseDecks", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ApkgImporter {
    public static final int $stable = 0;
    private static final int BUFFER_SIZE = 8192;
    public static final ApkgImporter INSTANCE = new ApkgImporter();
    private static final String TAG = "ApkgImporter";

    private ApkgImporter() {
    }

    public final Object importApkg(Context context, Uri uri, Long l, String str, Continuation<? super ImportResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ApkgImporter$importApkg$2(context, uri, str, l, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<Long, String> parseDecks(SQLiteDatabase db) {
        Cursor rawQuery;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            rawQuery = db.rawQuery("SELECT id, name FROM decks", null);
            try {
                Cursor cursor = rawQuery;
                int columnIndex = cursor.getColumnIndex("id");
                int columnIndex2 = cursor.getColumnIndex("name");
                if (columnIndex >= 0 && columnIndex2 >= 0) {
                    while (cursor.moveToNext()) {
                        long j = cursor.getLong(columnIndex);
                        String string = cursor.getString(columnIndex2);
                        if (string == null) {
                            string = "";
                        } else {
                            Intrinsics.checkNotNull(string);
                        }
                        linkedHashMap.put(Long.valueOf(j), string);
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(rawQuery, null);
            } finally {
            }
        } catch (Exception e) {
            Log.d(TAG, "Could not query decks table: " + e.getMessage() + ". Trying 'col' table 'decks' JSON mapping...");
        }
        if (linkedHashMap.isEmpty()) {
            try {
                rawQuery = db.rawQuery("SELECT decks FROM col LIMIT 1", null);
                try {
                    Cursor cursor2 = rawQuery;
                    if (cursor2.moveToFirst()) {
                        JSONObject jSONObject = new JSONObject(cursor2.getString(0));
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject(keys.next());
                            long j2 = jSONObject2.getLong("id");
                            String string2 = jSONObject2.getString("name");
                            Long valueOf = Long.valueOf(j2);
                            Intrinsics.checkNotNull(string2);
                            linkedHashMap.put(valueOf, string2);
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                    CloseableKt.closeFinally(rawQuery, null);
                } finally {
                    try {
                        throw th;
                    } finally {
                    }
                }
            } catch (Exception e2) {
                Log.e(TAG, "Could not query col table decks column: " + e2.getMessage());
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0039 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String getFileName(android.content.Context r9, android.net.Uri r10) {
        /*
            r8 = this;
            java.lang.String r0 = r10.getScheme()
            java.lang.String r1 = "content"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            r1 = 0
            if (r0 == 0) goto L3d
            android.content.ContentResolver r2 = r9.getContentResolver()
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r3 = r10
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)
            if (r9 == 0) goto L36
            boolean r0 = r9.moveToFirst()     // Catch: java.lang.Throwable -> L2f
            if (r0 == 0) goto L36
            java.lang.String r0 = "_display_name"
            int r0 = r9.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L2f
            if (r0 < 0) goto L36
            java.lang.String r0 = r9.getString(r0)     // Catch: java.lang.Throwable -> L2f
            goto L37
        L2f:
            r10 = move-exception
            if (r9 == 0) goto L35
            r9.close()
        L35:
            throw r10
        L36:
            r0 = r1
        L37:
            if (r9 == 0) goto L3e
            r9.close()
            goto L3e
        L3d:
            r0 = r1
        L3e:
            if (r0 != 0) goto L67
            java.lang.String r0 = r10.getPath()
            r9 = -1
            if (r0 == 0) goto L55
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 47
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            int r10 = kotlin.text.StringsKt.lastIndexOf$default(r2, r3, r4, r5, r6, r7)
            goto L56
        L55:
            r10 = r9
        L56:
            if (r10 == r9) goto L67
            if (r0 == 0) goto L66
            int r10 = r10 + 1
            java.lang.String r1 = r0.substring(r10)
            java.lang.String r9 = "substring(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r9)
        L66:
            r0 = r1
        L67:
            if (r0 != 0) goto L6c
            java.lang.String r0 = "unknown.apkg"
        L6c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.ApkgImporter.getFileName(android.content.Context, android.net.Uri):java.lang.String");
    }
}

package com.example.flashcardapp.data;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AnkiDroidBridge.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u0011H\u0002J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u001a\u001a\u00020\u0004J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/example/flashcardapp/data/AnkiDroidBridge;", "", "()V", "AUTHORITY", "", "CARDS_URI", "Landroid/net/Uri;", "getCARDS_URI", "()Landroid/net/Uri;", "DECKS_URI", "getDECKS_URI", "NOTES_URI", "getNOTES_URI", "PACKAGE_NAME", "PERMISSION", "TAG", "getCardsAndNotesForDeck", "", "Lcom/example/flashcardapp/data/AnkiFlashcard;", "context", "Landroid/content/Context;", "deckId", "", "getDecks", "Lcom/example/flashcardapp/data/AnkiDeck;", "getLeafDeckName", "deckName", "getMockCardsForDeck", "getMockDecks", "getParentDeckPath", "hasPermission", "", "isAnkiDroidInstalled", "parseDeckHierarchy", "stripHtml", "html", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class AnkiDroidBridge {
    public static final int $stable;
    private static final String AUTHORITY = "com.ichi2.anki.providers.info";
    private static final Uri CARDS_URI;
    private static final Uri DECKS_URI;
    public static final AnkiDroidBridge INSTANCE = new AnkiDroidBridge();
    private static final Uri NOTES_URI;
    public static final String PACKAGE_NAME = "com.ichi2.anki";
    public static final String PERMISSION = "com.ichi2.anki.permission.READ_WRITE_DATABASE";
    private static final String TAG = "AnkiDroidBridge";

    public final Uri getCARDS_URI() {
        return CARDS_URI;
    }

    public final Uri getDECKS_URI() {
        return DECKS_URI;
    }

    public final Uri getNOTES_URI() {
        return NOTES_URI;
    }

    private AnkiDroidBridge() {
    }

    static {
        Uri parse = Uri.parse("content://com.ichi2.anki.providers.info/decks");
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        DECKS_URI = parse;
        Uri parse2 = Uri.parse("content://com.ichi2.anki.providers.info/cards");
        Intrinsics.checkNotNullExpressionValue(parse2, "parse(...)");
        CARDS_URI = parse2;
        Uri parse3 = Uri.parse("content://com.ichi2.anki.providers.info/notes");
        Intrinsics.checkNotNullExpressionValue(parse3, "parse(...)");
        NOTES_URI = parse3;
        $stable = 8;
    }

    public final boolean isAnkiDroidInstalled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            context.getPackageManager().getPackageInfo(PACKAGE_NAME, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final boolean hasPermission(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.checkSelfPermission(PERMISSION) == 0;
    }

    public final List<AnkiDeck> getDecks(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!isAnkiDroidInstalled(context) || !hasPermission(context)) {
            Log.w(TAG, "AnkiDroid not available, returning mock decks");
            return getMockDecks();
        }
        ArrayList arrayList = new ArrayList();
        try {
            Cursor query = context.getContentResolver().query(DECKS_URI, new String[]{"_id", "name"}, null, null, null);
            if (query != null) {
                Cursor cursor = query;
                try {
                    Cursor cursor2 = cursor;
                    int columnIndex = cursor2.getColumnIndex("_id");
                    int columnIndex2 = cursor2.getColumnIndex("name");
                    if (columnIndex >= 0 && columnIndex2 >= 0) {
                        while (cursor2.moveToNext()) {
                            long j = cursor2.getLong(columnIndex);
                            String string = cursor2.getString(columnIndex2);
                            if (string == null) {
                                string = "";
                            } else {
                                Intrinsics.checkNotNull(string);
                            }
                            arrayList.add(new AnkiDeck(j, string, 0, 4, null));
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor, null);
                } finally {
                }
            }
            Log.d(TAG, "Loaded " + arrayList.size() + " decks from AnkiDroid");
        } catch (Exception e) {
            Log.e(TAG, "Error querying decks from AnkiDroid", e);
        }
        return arrayList;
    }

    public final List<AnkiFlashcard> getCardsAndNotesForDeck(Context context, long deckId) {
        int i;
        String str;
        String str2;
        String str3;
        Object obj;
        Cursor cursor;
        String str4;
        String str5;
        String str6;
        int i2;
        String str7;
        String string;
        String str8 = "tags";
        String str9 = "flds";
        String str10 = "_id";
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        if (!hasPermission(context)) {
            Log.w(TAG, "No permission, returning mock cards for deck " + deckId);
            return getMockCardsForDeck(deckId);
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        try {
        } catch (Exception e) {
            e = e;
        }
        try {
            Cursor query = context.getContentResolver().query(CARDS_URI, new String[]{"_id", "note_id", "deck_id"}, "deck_id = ?", new String[]{String.valueOf(deckId)}, null);
            if (query != null) {
                cursor = query;
                try {
                    Cursor cursor2 = cursor;
                    int columnIndex = cursor2.getColumnIndex("_id");
                    int columnIndex2 = cursor2.getColumnIndex("note_id");
                    if (columnIndex >= 0 && columnIndex2 >= 0) {
                        while (cursor2.moveToNext()) {
                            arrayList2.add(Long.valueOf(cursor2.getLong(columnIndex)));
                            arrayList3.add(Long.valueOf(cursor2.getLong(columnIndex2)));
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor, null);
                } finally {
                }
            }
            if (arrayList3.isEmpty()) {
                Log.d(TAG, "No cards found for deck " + deckId);
                return arrayList;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i3 = 10;
            try {
                for (List list : CollectionsKt.chunked(CollectionsKt.distinct(arrayList3), 500)) {
                    String str11 = "_id IN (" + CollectionsKt.joinToString$default(list, ",", null, null, 0, null, new Function1<Long, CharSequence>() { // from class: com.example.flashcardapp.data.AnkiDroidBridge$getCardsAndNotesForDeck$2$placeholders$1
                        public final CharSequence invoke(long j) {
                            return "?";
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ CharSequence invoke(Long l) {
                            return invoke(l.longValue());
                        }
                    }, 30, null) + ")";
                    List list2 = list;
                    ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, i3));
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList4.add(String.valueOf(((Number) it.next()).longValue()));
                    }
                    Cursor query2 = context.getContentResolver().query(NOTES_URI, new String[]{str10, str9, str8}, str11, (String[]) arrayList4.toArray(new String[0]), null);
                    if (query2 != null) {
                        cursor = query2;
                        try {
                            Cursor cursor3 = cursor;
                            int columnIndex3 = cursor3.getColumnIndex(str10);
                            int columnIndex4 = cursor3.getColumnIndex(str9);
                            int columnIndex5 = cursor3.getColumnIndex(str8);
                            if (columnIndex3 >= 0 && columnIndex4 >= 0) {
                                while (cursor3.moveToNext()) {
                                    long j = cursor3.getLong(columnIndex3);
                                    String string2 = cursor3.getString(columnIndex4);
                                    if (string2 == null) {
                                        str4 = str8;
                                        str5 = "";
                                    } else {
                                        Intrinsics.checkNotNull(string2);
                                        str4 = str8;
                                        str5 = string2;
                                    }
                                    if (columnIndex5 >= 0 && (string = cursor3.getString(columnIndex5)) != null) {
                                        Intrinsics.checkNotNull(string);
                                        i2 = columnIndex5;
                                        str6 = str9;
                                        str7 = string;
                                        linkedHashMap.put(Long.valueOf(j), new AnkiDroidBridge$getCardsAndNotesForDeck$NoteData(str5, str7));
                                        str10 = str10;
                                        str9 = str6;
                                        str8 = str4;
                                        columnIndex5 = i2;
                                    }
                                    str6 = str9;
                                    i2 = columnIndex5;
                                    str7 = "";
                                    linkedHashMap.put(Long.valueOf(j), new AnkiDroidBridge$getCardsAndNotesForDeck$NoteData(str5, str7));
                                    str10 = str10;
                                    str9 = str6;
                                    str8 = str4;
                                    columnIndex5 = i2;
                                }
                            }
                            str = str8;
                            str2 = str9;
                            str3 = str10;
                            Unit unit2 = Unit.INSTANCE;
                            obj = null;
                            CloseableKt.closeFinally(cursor, null);
                        } finally {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    } else {
                        str = str8;
                        str2 = str9;
                        str3 = str10;
                        obj = null;
                    }
                    str10 = str3;
                    str9 = str2;
                    str8 = str;
                    i3 = 10;
                }
            } catch (Exception e2) {
                Log.e(TAG, "Error querying notes for deck " + deckId, e2);
            }
            int size = arrayList2.size();
            for (int i4 = 0; i4 < size; i4++) {
                long longValue = ((Number) arrayList2.get(i4)).longValue();
                long longValue2 = ((Number) arrayList3.get(i4)).longValue();
                AnkiDroidBridge$getCardsAndNotesForDeck$NoteData ankiDroidBridge$getCardsAndNotesForDeck$NoteData = (AnkiDroidBridge$getCardsAndNotesForDeck$NoteData) linkedHashMap.get(Long.valueOf(longValue2));
                if (ankiDroidBridge$getCardsAndNotesForDeck$NoteData != null) {
                    List split$default = StringsKt.split$default((CharSequence) ankiDroidBridge$getCardsAndNotesForDeck$NoteData.getFields(), new String[]{"\u001f"}, false, 0, 6, (Object) null);
                    String str12 = (String) CollectionsKt.getOrNull(split$default, 0);
                    if (str12 == null) {
                        str12 = "";
                    }
                    String str13 = (String) CollectionsKt.getOrNull(split$default, 1);
                    if (str13 == null) {
                        str13 = "";
                    }
                    String stripHtml = stripHtml(str12);
                    String stripHtml2 = stripHtml(str13);
                    List split$default2 = StringsKt.split$default((CharSequence) ankiDroidBridge$getCardsAndNotesForDeck$NoteData.getTags(), new String[]{" "}, false, 0, 6, (Object) null);
                    ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default2, 10));
                    Iterator it2 = split$default2.iterator();
                    while (it2.hasNext()) {
                        arrayList5.add(StringsKt.trim((CharSequence) it2.next()).toString());
                    }
                    ArrayList arrayList6 = new ArrayList();
                    for (Object obj2 : arrayList5) {
                        if (((String) obj2).length() > 0) {
                            arrayList6.add(obj2);
                        }
                    }
                    ArrayList arrayList7 = arrayList6;
                    if (stripHtml.length() > 0 && stripHtml2.length() > 0) {
                        arrayList.add(new AnkiFlashcard(longValue, longValue2, stripHtml, stripHtml2, arrayList7));
                    }
                }
            }
            int size2 = arrayList.size();
            ArrayList arrayList8 = arrayList;
            if ((arrayList8 instanceof Collection) && arrayList8.isEmpty()) {
                i = 0;
            } else {
                Iterator it3 = arrayList8.iterator();
                i = 0;
                while (it3.hasNext()) {
                    if ((!((AnkiFlashcard) it3.next()).getTags().isEmpty()) && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            Log.d(TAG, "Loaded " + size2 + " cards for deck " + deckId + " (" + i + " have tags)");
            return arrayList;
        } catch (Exception e3) {
            e = e3;
            Log.e(TAG, "Error querying cards for deck " + deckId, e);
            return arrayList;
        }
    }

    public final List<String> parseDeckHierarchy(String deckName) {
        Intrinsics.checkNotNullParameter(deckName, "deckName");
        return DeckHierarchyUtils.INSTANCE.parseDeckHierarchy(deckName);
    }

    public final String getLeafDeckName(String deckName) {
        Intrinsics.checkNotNullParameter(deckName, "deckName");
        return DeckHierarchyUtils.INSTANCE.getLeafDeckName(deckName);
    }

    public final String getParentDeckPath(String deckName) {
        Intrinsics.checkNotNullParameter(deckName, "deckName");
        return DeckHierarchyUtils.INSTANCE.getParentDeckPath(deckName);
    }

    private final String stripHtml(String html) {
        return DeckHierarchyUtils.INSTANCE.stripHtml(html);
    }

    private final List<AnkiDeck> getMockDecks() {
        return CollectionsKt.listOf((Object[]) new AnkiDeck[]{new AnkiDeck(1001L, "General Knowledge & Trivia", 12), new AnkiDeck(1002L, "Kotlin & Jetpack Compose", 12), new AnkiDeck(1003L, "World Geography", 10), new AnkiDeck(1004L, "Science::Biology::Genetics", 10), new AnkiDeck(1005L, "Science::Biology::Ecology", 10), new AnkiDeck(1006L, "Science::Physics", 10)});
    }

    private final List<AnkiFlashcard> getMockCardsForDeck(long deckId) {
        List<AnkiFlashcard> list = (List) MapsKt.mapOf(TuplesKt.to(1001L, CollectionsKt.listOf((Object[]) new AnkiFlashcard[]{new AnkiFlashcard(101L, 201L, "What is the capital of France?", "Paris", CollectionsKt.listOf((Object[]) new String[]{"geography", "europe"})), new AnkiFlashcard(102L, 202L, "What year did World War II end?", "1945", CollectionsKt.listOf((Object[]) new String[]{"history", "war"})), new AnkiFlashcard(103L, 203L, "What is the chemical symbol for water?", "H₂O", CollectionsKt.listOf("chemistry")), new AnkiFlashcard(104L, 204L, "Who painted the Mona Lisa?", "Leonardo da Vinci", CollectionsKt.listOf((Object[]) new String[]{"art", "renaissance"})), new AnkiFlashcard(105L, 205L, "What is the largest planet in our solar system?", "Jupiter", CollectionsKt.listOf("astronomy")), new AnkiFlashcard(106L, 206L, "What is the speed of light?", "299,792,458 m/s", CollectionsKt.listOf("physics")), new AnkiFlashcard(107L, 207L, "Who wrote Romeo and Juliet?", "William Shakespeare", CollectionsKt.listOf("literature")), new AnkiFlashcard(108L, 208L, "What is the smallest prime number?", ExifInterface.GPS_MEASUREMENT_2D, CollectionsKt.listOf("math")), new AnkiFlashcard(109L, 209L, "What is the currency of Japan?", "Yen", CollectionsKt.listOf((Object[]) new String[]{"geography", "asia"})), new AnkiFlashcard(110L, 210L, "What element has atomic number 1?", "Hydrogen", CollectionsKt.listOf("chemistry")), new AnkiFlashcard(111L, 211L, "What is the tallest mountain on Earth?", "Mount Everest", CollectionsKt.listOf("geography")), new AnkiFlashcard(112L, 212L, "Who discovered penicillin?", "Alexander Fleming", CollectionsKt.listOf((Object[]) new String[]{"medicine", "history"}))})), TuplesKt.to(1002L, CollectionsKt.listOf((Object[]) new AnkiFlashcard[]{new AnkiFlashcard(201L, 301L, "What keyword declares an immutable variable in Kotlin?", "val", CollectionsKt.listOf((Object[]) new String[]{"kotlin", "basics"})), new AnkiFlashcard(202L, 302L, "What is a data class in Kotlin?", "A class that automatically generates equals(), hashCode(), toString(), copy()", CollectionsKt.listOf((Object[]) new String[]{"kotlin", "classes"})), new AnkiFlashcard(203L, 303L, "What is a Composable function?", "A function annotated with @Composable that defines UI elements", CollectionsKt.listOf((Object[]) new String[]{"compose", "ui"})), new AnkiFlashcard(204L, 304L, "What is remember in Jetpack Compose?", "A composable function that stores a single object in memory across recompositions", CollectionsKt.listOf((Object[]) new String[]{"compose", "state"})), new AnkiFlashcard(205L, 305L, "What is LaunchedEffect?", "A side-effect handler that runs a suspend function when entering the composition", CollectionsKt.listOf((Object[]) new String[]{"compose", "effects"})), new AnkiFlashcard(206L, 306L, "What is a coroutine?", "A concurrency design pattern for asynchronous programming in Kotlin", CollectionsKt.listOf((Object[]) new String[]{"kotlin", "coroutines"})), new AnkiFlashcard(207L, 307L, "What does 'suspend' keyword do?", "Marks a function that can be paused and resumed, usable only in coroutines", CollectionsKt.listOf((Object[]) new String[]{"kotlin", "coroutines"})), new AnkiFlashcard(208L, 308L, "What is StateFlow?", "A hot observable state holder that emits updates to collectors", CollectionsKt.listOf((Object[]) new String[]{"kotlin", "flow"})), new AnkiFlashcard(209L, 309L, "What is Room?", "An abstraction layer over SQLite for local database persistence", CollectionsKt.listOf((Object[]) new String[]{"android", "database"})), new AnkiFlashcard(210L, 310L, "What is MVVM?", "Model-View-ViewModel architecture pattern separating UI from business logic", CollectionsKt.listOf("architecture")), new AnkiFlashcard(211L, 311L, "What is Hilt?", "A dependency injection library for Android built on Dagger", CollectionsKt.listOf((Object[]) new String[]{"android", "di"})), new AnkiFlashcard(212L, 312L, "What is Navigation Compose?", "Jetpack library for handling navigation between composable screens", CollectionsKt.listOf((Object[]) new String[]{"compose", NotificationCompat.CATEGORY_NAVIGATION}))})), TuplesKt.to(1003L, CollectionsKt.listOf((Object[]) new AnkiFlashcard[]{new AnkiFlashcard(301L, 401L, "What is the largest continent by area?", "Asia", CollectionsKt.listOf("continents")), new AnkiFlashcard(302L, 402L, "What is the longest river in the world?", "Nile", CollectionsKt.listOf("rivers")), new AnkiFlashcard(303L, 403L, "What country has the largest population?", "India", CollectionsKt.listOf("demographics")), new AnkiFlashcard(304L, 404L, "What is the smallest country in the world?", "Vatican City", CollectionsKt.listOf("countries")), new AnkiFlashcard(305L, 405L, "What ocean is the largest?", "Pacific Ocean", CollectionsKt.listOf("oceans")), new AnkiFlashcard(306L, 406L, "What desert is the largest?", "Sahara Desert", CollectionsKt.listOf("deserts")), new AnkiFlashcard(307L, 407L, "What is the capital of Australia?", "Canberra", CollectionsKt.listOf((Object[]) new String[]{"capitals", "oceania"})), new AnkiFlashcard(308L, 408L, "How many time zones does Russia span?", "11", CollectionsKt.listOf((Object[]) new String[]{"countries", "facts"})), new AnkiFlashcard(309L, 409L, "What mountain range separates Europe from Asia?", "Ural Mountains", CollectionsKt.listOf("mountains")), new AnkiFlashcard(310L, 410L, "What is the deepest ocean trench?", "Mariana Trench", CollectionsKt.listOf("oceans"))})), TuplesKt.to(1004L, CollectionsKt.listOf((Object[]) new AnkiFlashcard[]{new AnkiFlashcard(401L, 501L, "What is DNA?", "Deoxyribonucleic acid — carries genetic instructions", CollectionsKt.listOf((Object[]) new String[]{"genetics", "molecular"})), new AnkiFlashcard(402L, 502L, "What are alleles?", "Different versions of the same gene", CollectionsKt.listOf("genetics")), new AnkiFlashcard(403L, 503L, "What is a phenotype?", "The observable characteristics of an organism", CollectionsKt.listOf("genetics")), new AnkiFlashcard(404L, 504L, "What is a genotype?", "The genetic makeup of an organism", CollectionsKt.listOf("genetics")), new AnkiFlashcard(405L, 505L, "What is crossing over?", "Exchange of genetic material between homologous chromosomes during meiosis", CollectionsKt.listOf((Object[]) new String[]{"genetics", "meiosis"})), new AnkiFlashcard(406L, 506L, "What is a dominant allele?", "An allele that expresses its phenotype even in heterozygous form", CollectionsKt.listOf("genetics")), new AnkiFlashcard(407L, 507L, "What is Mendel's law of segregation?", "Each organism has two alleles for each trait, and they separate during gamete formation", CollectionsKt.listOf((Object[]) new String[]{"genetics", "mendel"})), new AnkiFlashcard(408L, 508L, "What is a mutation?", "A change in the DNA sequence", CollectionsKt.listOf((Object[]) new String[]{"genetics", "molecular"})), new AnkiFlashcard(409L, 509L, "What is PCR?", "Polymerase Chain Reaction — amplifies DNA segments", CollectionsKt.listOf((Object[]) new String[]{"genetics", "techniques"})), new AnkiFlashcard(410L, 510L, "What is CRISPR?", "A gene editing tool that allows precise modifications to DNA", CollectionsKt.listOf((Object[]) new String[]{"genetics", "techniques"}))})), TuplesKt.to(1005L, CollectionsKt.listOf((Object[]) new AnkiFlashcard[]{new AnkiFlashcard(501L, 601L, "What is an ecosystem?", "A community of organisms and their physical environment", CollectionsKt.listOf((Object[]) new String[]{"ecology", "basics"})), new AnkiFlashcard(502L, 602L, "What is a food chain?", "A linear pathway showing energy transfer between organisms", CollectionsKt.listOf((Object[]) new String[]{"ecology", "energy"})), new AnkiFlashcard(503L, 603L, "What is biodiversity?", "The variety of life in a particular habitat or ecosystem", CollectionsKt.listOf("ecology")), new AnkiFlashcard(504L, 604L, "What is symbiosis?", "A close ecological relationship between two or more species", CollectionsKt.listOf((Object[]) new String[]{"ecology", "relationships"})), new AnkiFlashcard(505L, 605L, "What is a keystone species?", "A species that has a disproportionately large effect on its ecosystem", CollectionsKt.listOf("ecology")), new AnkiFlashcard(506L, 606L, "What is carrying capacity?", "The maximum population size an environment can sustainably support", CollectionsKt.listOf((Object[]) new String[]{"ecology", "population"})), new AnkiFlashcard(507L, 607L, "What is primary succession?", "Ecological succession that occurs in lifeless areas with no soil", CollectionsKt.listOf((Object[]) new String[]{"ecology", "succession"})), new AnkiFlashcard(508L, 608L, "What is the carbon cycle?", "The biogeochemical cycle of carbon through Earth's systems", CollectionsKt.listOf((Object[]) new String[]{"ecology", "cycles"})), new AnkiFlashcard(509L, 609L, "What is eutrophication?", "Excessive nutrient enrichment in water bodies causing algal blooms", CollectionsKt.listOf((Object[]) new String[]{"ecology", "pollution"})), new AnkiFlashcard(510L, 610L, "What is a trophic level?", "A position in a food chain occupied by organisms", CollectionsKt.listOf((Object[]) new String[]{"ecology", "energy"}))})), TuplesKt.to(1006L, CollectionsKt.listOf((Object[]) new AnkiFlashcard[]{new AnkiFlashcard(601L, 701L, "What is Newton's first law?", "An object at rest stays at rest unless acted upon by a force", CollectionsKt.listOf((Object[]) new String[]{"physics", "mechanics"})), new AnkiFlashcard(602L, 702L, "What is F = ma?", "Newton's second law: Force equals mass times acceleration", CollectionsKt.listOf((Object[]) new String[]{"physics", "mechanics"})), new AnkiFlashcard(603L, 703L, "What is kinetic energy?", "Energy of motion: KE = ½mv²", CollectionsKt.listOf((Object[]) new String[]{"physics", "energy"})), new AnkiFlashcard(604L, 704L, "What is Ohm's law?", "V = IR — voltage equals current times resistance", CollectionsKt.listOf((Object[]) new String[]{"physics", "electricity"})), new AnkiFlashcard(605L, 705L, "What is the wavelength?", "The distance between consecutive crests of a wave", CollectionsKt.listOf((Object[]) new String[]{"physics", "waves"})), new AnkiFlashcard(606L, 706L, "What is entropy?", "A measure of disorder in a system", CollectionsKt.listOf((Object[]) new String[]{"physics", "thermodynamics"})), new AnkiFlashcard(607L, 707L, "What is a photon?", "A quantum of electromagnetic radiation", CollectionsKt.listOf((Object[]) new String[]{"physics", "quantum"})), new AnkiFlashcard(608L, 708L, "What is momentum?", "Product of mass and velocity: p = mv", CollectionsKt.listOf((Object[]) new String[]{"physics", "mechanics"})), new AnkiFlashcard(609L, 709L, "What is Boyle's law?", "At constant temperature, pressure and volume are inversely proportional", CollectionsKt.listOf((Object[]) new String[]{"physics", "gas-laws"})), new AnkiFlashcard(610L, 710L, "What is refraction?", "Bending of light when passing between media of different densities", CollectionsKt.listOf((Object[]) new String[]{"physics", "optics"}))}))).get(Long.valueOf(deckId));
        return list == null ? CollectionsKt.emptyList() : list;
    }
}

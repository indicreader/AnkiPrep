package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: DeckHierarchyUtils.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004¨\u0006\u000b"}, d2 = {"Lcom/example/flashcardapp/data/DeckHierarchyUtils;", "", "()V", "getLeafDeckName", "", "deckName", "getParentDeckPath", "parseDeckHierarchy", "", "stripHtml", "html", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class DeckHierarchyUtils {
    public static final int $stable = 0;
    public static final DeckHierarchyUtils INSTANCE = new DeckHierarchyUtils();

    private DeckHierarchyUtils() {
    }

    public final List<String> parseDeckHierarchy(String deckName) {
        Intrinsics.checkNotNullParameter(deckName, "deckName");
        List split$default = StringsKt.split$default((CharSequence) deckName, new String[]{"::"}, false, 0, 6, (Object) null);
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
        return arrayList2;
    }

    public final String getLeafDeckName(String deckName) {
        Intrinsics.checkNotNullParameter(deckName, "deckName");
        String str = (String) CollectionsKt.lastOrNull((List) parseDeckHierarchy(deckName));
        return str == null ? deckName : str;
    }

    public final String getParentDeckPath(String deckName) {
        Intrinsics.checkNotNullParameter(deckName, "deckName");
        List<String> parseDeckHierarchy = parseDeckHierarchy(deckName);
        if (parseDeckHierarchy.size() > 1) {
            return CollectionsKt.joinToString$default(CollectionsKt.dropLast(parseDeckHierarchy, 1), "::", null, null, 0, null, null, 62, null);
        }
        return null;
    }

    public final String stripHtml(String html) {
        Intrinsics.checkNotNullParameter(html, "html");
        return StringsKt.trim((CharSequence) new Regex("&#([0-9]+);").replace(new Regex("(?i)&#x([0-9a-f]+);").replace(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(new Regex("<[^>]*>").replace(new Regex("(?i)<br\\s*/?>").replace(html, "\n"), ""), "&nbsp;", " ", false, 4, (Object) null), "&lt;", "<", false, 4, (Object) null), "&gt;", ">", false, 4, (Object) null), "&amp;", "&", false, 4, (Object) null), "&quot;", "\"", false, 4, (Object) null), "&apos;", "'", false, 4, (Object) null), new Function1<MatchResult, CharSequence>() { // from class: com.example.flashcardapp.data.DeckHierarchyUtils$stripHtml$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MatchResult matchResult) {
                Intrinsics.checkNotNullParameter(matchResult, "matchResult");
                try {
                    return String.valueOf((char) Integer.parseInt(matchResult.getGroupValues().get(1), CharsKt.checkRadix(16)));
                } catch (Exception unused) {
                    return matchResult.getValue();
                }
            }
        }), new Function1<MatchResult, CharSequence>() { // from class: com.example.flashcardapp.data.DeckHierarchyUtils$stripHtml$2
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MatchResult matchResult) {
                Intrinsics.checkNotNullParameter(matchResult, "matchResult");
                try {
                    return String.valueOf((char) Integer.parseInt(matchResult.getGroupValues().get(1)));
                } catch (Exception unused) {
                    return matchResult.getValue();
                }
            }
        })).toString();
    }
}

package com.example.flashcardapp.ui;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ImageWebSearchDialog.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/example/flashcardapp/ui/SearchStage;", "", "(Ljava/lang/String;I)V", "SEARCH", "PREVIEW", "SAVING", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class SearchStage {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SearchStage[] $VALUES;
    public static final SearchStage SEARCH = new SearchStage("SEARCH", 0);
    public static final SearchStage PREVIEW = new SearchStage("PREVIEW", 1);
    public static final SearchStage SAVING = new SearchStage("SAVING", 2);

    private static final /* synthetic */ SearchStage[] $values() {
        return new SearchStage[]{SEARCH, PREVIEW, SAVING};
    }

    public static EnumEntries<SearchStage> getEntries() {
        return $ENTRIES;
    }

    public static SearchStage valueOf(String str) {
        return (SearchStage) Enum.valueOf(SearchStage.class, str);
    }

    public static SearchStage[] values() {
        return (SearchStage[]) $VALUES.clone();
    }

    static {
        SearchStage[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private SearchStage(String str, int i) {
    }
}

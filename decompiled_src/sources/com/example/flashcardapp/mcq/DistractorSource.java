package com.example.flashcardapp.mcq;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Mcq.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/example/flashcardapp/mcq/DistractorSource;", "", "(Ljava/lang/String;I)V", "SAME_TAG", "SAME_SUBDECK", "SAME_DECK", "SAME_ROOT", "GLOBAL_POOL", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class DistractorSource {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DistractorSource[] $VALUES;
    public static final DistractorSource SAME_TAG = new DistractorSource("SAME_TAG", 0);
    public static final DistractorSource SAME_SUBDECK = new DistractorSource("SAME_SUBDECK", 1);
    public static final DistractorSource SAME_DECK = new DistractorSource("SAME_DECK", 2);
    public static final DistractorSource SAME_ROOT = new DistractorSource("SAME_ROOT", 3);
    public static final DistractorSource GLOBAL_POOL = new DistractorSource("GLOBAL_POOL", 4);

    private static final /* synthetic */ DistractorSource[] $values() {
        return new DistractorSource[]{SAME_TAG, SAME_SUBDECK, SAME_DECK, SAME_ROOT, GLOBAL_POOL};
    }

    public static EnumEntries<DistractorSource> getEntries() {
        return $ENTRIES;
    }

    public static DistractorSource valueOf(String str) {
        return (DistractorSource) Enum.valueOf(DistractorSource.class, str);
    }

    public static DistractorSource[] values() {
        return (DistractorSource[]) $VALUES.clone();
    }

    private DistractorSource(String str, int i) {
    }

    static {
        DistractorSource[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}

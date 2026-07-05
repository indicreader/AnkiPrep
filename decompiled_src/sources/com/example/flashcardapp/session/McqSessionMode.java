package com.example.flashcardapp.session;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: McqSession.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/example/flashcardapp/session/McqSessionMode;", "", "(Ljava/lang/String;I)V", "PRACTICE", "TEST", "REVISION", "RATED_PRIORITY", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class McqSessionMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ McqSessionMode[] $VALUES;
    public static final McqSessionMode PRACTICE = new McqSessionMode("PRACTICE", 0);
    public static final McqSessionMode TEST = new McqSessionMode("TEST", 1);
    public static final McqSessionMode REVISION = new McqSessionMode("REVISION", 2);
    public static final McqSessionMode RATED_PRIORITY = new McqSessionMode("RATED_PRIORITY", 3);

    private static final /* synthetic */ McqSessionMode[] $values() {
        return new McqSessionMode[]{PRACTICE, TEST, REVISION, RATED_PRIORITY};
    }

    public static EnumEntries<McqSessionMode> getEntries() {
        return $ENTRIES;
    }

    public static McqSessionMode valueOf(String str) {
        return (McqSessionMode) Enum.valueOf(McqSessionMode.class, str);
    }

    public static McqSessionMode[] values() {
        return (McqSessionMode[]) $VALUES.clone();
    }

    private McqSessionMode(String str, int i) {
    }

    static {
        McqSessionMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}

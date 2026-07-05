package com.example.flashcardapp.fsrs;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FsrsAlgorithm.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/example/flashcardapp/fsrs/CardState;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "New", "Relearning", "Review", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class CardState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CardState[] $VALUES;
    public static final CardState New = new CardState("New", 0, 0);
    public static final CardState Relearning = new CardState("Relearning", 1, 1);
    public static final CardState Review = new CardState("Review", 2, 2);
    private final int value;

    private static final /* synthetic */ CardState[] $values() {
        return new CardState[]{New, Relearning, Review};
    }

    public static EnumEntries<CardState> getEntries() {
        return $ENTRIES;
    }

    public static CardState valueOf(String str) {
        return (CardState) Enum.valueOf(CardState.class, str);
    }

    public static CardState[] values() {
        return (CardState[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private CardState(String str, int i, int i2) {
        this.value = i2;
    }

    static {
        CardState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}

package com.example.flashcardapp.fsrs;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FsrsAlgorithm.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/example/flashcardapp/fsrs/Rating;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "Again", "Hard", "Good", "Easy", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class Rating {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Rating[] $VALUES;
    private final int value;
    public static final Rating Again = new Rating("Again", 0, 1);
    public static final Rating Hard = new Rating("Hard", 1, 2);
    public static final Rating Good = new Rating("Good", 2, 3);
    public static final Rating Easy = new Rating("Easy", 3, 4);

    private static final /* synthetic */ Rating[] $values() {
        return new Rating[]{Again, Hard, Good, Easy};
    }

    public static EnumEntries<Rating> getEntries() {
        return $ENTRIES;
    }

    public static Rating valueOf(String str) {
        return (Rating) Enum.valueOf(Rating.class, str);
    }

    public static Rating[] values() {
        return (Rating[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private Rating(String str, int i, int i2) {
        this.value = i2;
    }

    static {
        Rating[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}

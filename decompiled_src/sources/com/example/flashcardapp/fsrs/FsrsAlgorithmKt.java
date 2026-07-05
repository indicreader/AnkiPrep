package com.example.flashcardapp.fsrs;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FsrsAlgorithm.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0003¨\u0006\u0006"}, d2 = {"addMillisToNow", "Ljava/time/LocalDateTime;", "millis", "", "toEpochMillis", "toLocalDateTime", "app_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class FsrsAlgorithmKt {
    public static final LocalDateTime toLocalDateTime(long j) {
        LocalDateTime ofInstant = LocalDateTime.ofInstant(Instant.ofEpochMilli(j), ZoneId.systemDefault());
        Intrinsics.checkNotNullExpressionValue(ofInstant, "ofInstant(...)");
        return ofInstant;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.time.ZonedDateTime] */
    public static final long toEpochMillis(LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static final LocalDateTime addMillisToNow(long j) {
        LocalDateTime ofInstant = LocalDateTime.ofInstant(Instant.now().plusMillis(j), ZoneId.systemDefault());
        Intrinsics.checkNotNullExpressionValue(ofInstant, "ofInstant(...)");
        return ofInstant;
    }
}

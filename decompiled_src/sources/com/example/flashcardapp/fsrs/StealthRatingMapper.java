package com.example.flashcardapp.fsrs;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: StealthRatingMapper.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/example/flashcardapp/fsrs/StealthRatingMapper;", "", "()V", "EASY_THRESHOLD_MS", "", "GOOD_THRESHOLD_MS", "mapToRating", "Lcom/example/flashcardapp/fsrs/Rating;", "isCorrect", "", "timeTakenMs", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class StealthRatingMapper {
    public static final int $stable = 0;
    private static final long EASY_THRESHOLD_MS = 5000;
    private static final long GOOD_THRESHOLD_MS = 15000;
    public static final StealthRatingMapper INSTANCE = new StealthRatingMapper();

    private StealthRatingMapper() {
    }

    public final Rating mapToRating(boolean isCorrect, long timeTakenMs) {
        if (!isCorrect) {
            return Rating.Again;
        }
        if (timeTakenMs < 5000) {
            return Rating.Easy;
        }
        if (timeTakenMs <= 15000) {
            return Rating.Good;
        }
        return Rating.Hard;
    }
}

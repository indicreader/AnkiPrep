package com.example.flashcardapp.ui;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.SessionRecordEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: HomeScreenState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"computeHomeStats", "Lcom/example/flashcardapp/ui/HomeStats;", "cardCount", "", "sessionRecords", "", "Lcom/example/flashcardapp/data/entities/SessionRecordEntity;", "(ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class HomeScreenStateKt {
    public static final Object computeHomeStats(int i, List<SessionRecordEntity> list, Continuation<? super HomeStats> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new HomeScreenStateKt$computeHomeStats$2(i, list, null), continuation);
    }
}

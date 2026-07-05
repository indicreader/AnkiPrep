package com.example.flashcardapp.data.dao;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.CardOverrideEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: CardOverrideDao.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH§@¢\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u000eH'J\u0018\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0016\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/example/flashcardapp/data/dao/CardOverrideDao;", "", "deleteAllOverrides", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOverride", "cardId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllOverridesOnce", "", "Lcom/example/flashcardapp/data/entities/CardOverrideEntity;", "getOverrideForCard", "observeAllOverrides", "Lkotlinx/coroutines/flow/Flow;", "observeOverrideForCard", "upsertOverride", "override", "(Lcom/example/flashcardapp/data/entities/CardOverrideEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public interface CardOverrideDao {
    Object deleteAllOverrides(Continuation<? super Unit> continuation);

    Object deleteOverride(long j, Continuation<? super Unit> continuation);

    Object getAllOverridesOnce(Continuation<? super List<CardOverrideEntity>> continuation);

    Object getOverrideForCard(long j, Continuation<? super CardOverrideEntity> continuation);

    Flow<List<CardOverrideEntity>> observeAllOverrides();

    Flow<CardOverrideEntity> observeOverrideForCard(long cardId);

    Object upsertOverride(CardOverrideEntity cardOverrideEntity, Continuation<? super Unit> continuation);
}

package com.example.flashcardapp.data.dao;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.CardUserMetadataEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: CardUserMetadataDao.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH'J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH§@¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\nH§@¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/example/flashcardapp/data/dao/CardUserMetadataDao;", "", "deleteMetadata", "", "cardId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllMetadataFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/flashcardapp/data/entities/CardUserMetadataEntity;", "getAllMetadataOnce", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMetadataForCard", "upsertMetadata", "metadata", "(Lcom/example/flashcardapp/data/entities/CardUserMetadataEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public interface CardUserMetadataDao {
    Object deleteMetadata(long j, Continuation<? super Unit> continuation);

    Flow<List<CardUserMetadataEntity>> getAllMetadataFlow();

    Object getAllMetadataOnce(Continuation<? super List<CardUserMetadataEntity>> continuation);

    Object getMetadataForCard(long j, Continuation<? super CardUserMetadataEntity> continuation);

    Object upsertMetadata(CardUserMetadataEntity cardUserMetadataEntity, Continuation<? super Unit> continuation);
}

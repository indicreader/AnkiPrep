package com.example.flashcardapp.data.dao;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.SessionRecordEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: SessionRecordDao.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH§@¢\u0006\u0002\u0010\u0004J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\rH'J\u000e\u0010\u000e\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000fH§@¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000fH§@¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/example/flashcardapp/data/dao/SessionRecordDao;", "", "deleteAllRecords", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecordsForDeck", "deckId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllRecords", "", "Lcom/example/flashcardapp/data/entities/SessionRecordEntity;", "getAllRecordsFlow", "Lkotlinx/coroutines/flow/Flow;", "getPracticeSessionCount", "", "getRevisionSessionCount", "getSessionCount", "getTestSessionCount", "getTotalCorrectAnswers", "getTotalQuestionsAnswered", "insertRecord", "record", "(Lcom/example/flashcardapp/data/entities/SessionRecordEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public interface SessionRecordDao {
    Object deleteAllRecords(Continuation<? super Unit> continuation);

    Object deleteRecordsForDeck(long j, Continuation<? super Unit> continuation);

    Object getAllRecords(Continuation<? super List<SessionRecordEntity>> continuation);

    Flow<List<SessionRecordEntity>> getAllRecordsFlow();

    Object getPracticeSessionCount(Continuation<? super Integer> continuation);

    Object getRevisionSessionCount(Continuation<? super Integer> continuation);

    Object getSessionCount(Continuation<? super Integer> continuation);

    Object getTestSessionCount(Continuation<? super Integer> continuation);

    Object getTotalCorrectAnswers(Continuation<? super Integer> continuation);

    Object getTotalQuestionsAnswered(Continuation<? super Integer> continuation);

    Object insertRecord(SessionRecordEntity sessionRecordEntity, Continuation<? super Long> continuation);
}

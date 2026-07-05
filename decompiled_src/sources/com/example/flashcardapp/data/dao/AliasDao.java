package com.example.flashcardapp.data.dao;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.AliasEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: AliasDao.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rH§@¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\u0010H'J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/example/flashcardapp/data/dao/AliasDao;", "", "deleteAlias", "", "alias", "Lcom/example/flashcardapp/data/entities/AliasEntity;", "(Lcom/example/flashcardapp/data/entities/AliasEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exists", "", "name", "", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAliases", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAliasesFlow", "Lkotlinx/coroutines/flow/Flow;", "insertAlias", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public interface AliasDao {
    Object deleteAlias(AliasEntity aliasEntity, Continuation<? super Unit> continuation);

    Object exists(String str, String str2, Continuation<? super Integer> continuation);

    Object getAllAliases(Continuation<? super List<AliasEntity>> continuation);

    Flow<List<AliasEntity>> getAllAliasesFlow();

    Object insertAlias(AliasEntity aliasEntity, Continuation<? super Long> continuation);
}

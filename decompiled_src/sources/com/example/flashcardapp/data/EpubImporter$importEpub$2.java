package com.example.flashcardapp.data;

import android.content.Context;
import android.net.Uri;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.dao.CardDao;
import com.example.flashcardapp.data.entities.CardEntity;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EpubImporter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/example/flashcardapp/data/ImportResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.data.EpubImporter$importEpub$2", f = "EpubImporter.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {176, 178}, m = "invokeSuspend", n = {"fileName", "cardEntities", "decksToInsert", "appDb", "fileName", "cardEntities", "decksToInsert"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
/* loaded from: classes2.dex */
public final class EpubImporter$importEpub$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImportResult>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Long $targetDeckId;
    final /* synthetic */ String $targetDeckName;
    final /* synthetic */ Uri $uri;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EpubImporter$importEpub$2(Context context, Uri uri, String str, Long l, Continuation<? super EpubImporter$importEpub$2> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$uri = uri;
        this.$targetDeckName = str;
        this.$targetDeckId = l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EpubImporter$importEpub$2(this.$context, this.$uri, this.$targetDeckName, this.$targetDeckId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImportResult> continuation) {
        return ((EpubImporter$importEpub$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x05f0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x055e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x055f  */
    /* JADX WARN: Type inference failed for: r2v19, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r72) {
        /*
            Method dump skipped, instructions count: 1533
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.EpubImporter$importEpub$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EpubImporter.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.example.flashcardapp.data.EpubImporter$importEpub$2$2", f = "EpubImporter.kt", i = {}, l = {179}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.example.flashcardapp.data.EpubImporter$importEpub$2$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ AppDatabase $appDb;
        final /* synthetic */ List<CardEntity> $cardEntities;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(List<CardEntity> list, AppDatabase appDatabase, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$cardEntities = list;
            this.$appDb = appDatabase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.$cardEntities, this.$appDb, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AppDatabase appDatabase;
            Iterator it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List chunked = CollectionsKt.chunked(this.$cardEntities, 200);
                appDatabase = this.$appDb;
                it = chunked.iterator();
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.L$1;
                appDatabase = (AppDatabase) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (it.hasNext()) {
                List<CardEntity> list = (List) it.next();
                CardDao cardDao = appDatabase.cardDao();
                this.L$0 = appDatabase;
                this.L$1 = it;
                this.label = 1;
                if (cardDao.insertCardsIgnore(list, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }
}

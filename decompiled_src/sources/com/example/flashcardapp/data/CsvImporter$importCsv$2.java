package com.example.flashcardapp.data;

import android.content.Context;
import android.net.Uri;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.CardEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CsvImporter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/example/flashcardapp/data/ImportResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.data.CsvImporter$importCsv$2", f = "CsvImporter.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {111, 213}, m = "invokeSuspend", n = {"fileName", "deckName", "dataLines", "appDb", "deckId", "delimiter", "timestamp", "fileName", "deckName", "cardsToUpdate", "cardsToInsert", "totalProcessed"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "C$0", "J$1", "L$0", "L$1", "L$2", "L$3", "I$0"})
/* loaded from: classes2.dex */
public final class CsvImporter$importCsv$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImportResult>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $duplicateStrategy;
    final /* synthetic */ Long $targetDeckId;
    final /* synthetic */ String $targetDeckName;
    final /* synthetic */ Uri $uri;
    char C$0;
    int I$0;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CsvImporter$importCsv$2(Context context, Uri uri, Long l, String str, String str2, Continuation<? super CsvImporter$importCsv$2> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$uri = uri;
        this.$targetDeckId = l;
        this.$targetDeckName = str;
        this.$duplicateStrategy = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CsvImporter$importCsv$2(this.$context, this.$uri, this.$targetDeckId, this.$targetDeckName, this.$duplicateStrategy, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImportResult> continuation) {
        return ((CsvImporter$importCsv$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x04e5 A[Catch: Exception -> 0x0056, TryCatch #4 {Exception -> 0x0056, blocks: (B:24:0x004f, B:26:0x01e5, B:28:0x01fa, B:29:0x0217, B:32:0x0220, B:34:0x0242, B:35:0x025a, B:37:0x0260, B:39:0x0278, B:41:0x02ca, B:43:0x02ea, B:45:0x034f, B:50:0x0362, B:53:0x036d, B:54:0x03a2, B:56:0x03a8, B:58:0x03bc, B:59:0x03cb, B:61:0x03d1, B:64:0x03e1, B:69:0x03e5, B:71:0x0406, B:79:0x04a2, B:81:0x04c5, B:83:0x04c9, B:85:0x0421, B:89:0x042b, B:91:0x0443, B:94:0x044c, B:95:0x046b, B:98:0x0474, B:99:0x0491, B:101:0x0499, B:103:0x030b, B:106:0x0316, B:109:0x04da, B:111:0x04e5, B:113:0x04ff), top: B:23:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x04ff A[Catch: Exception -> 0x0056, TRY_LEAVE, TryCatch #4 {Exception -> 0x0056, blocks: (B:24:0x004f, B:26:0x01e5, B:28:0x01fa, B:29:0x0217, B:32:0x0220, B:34:0x0242, B:35:0x025a, B:37:0x0260, B:39:0x0278, B:41:0x02ca, B:43:0x02ea, B:45:0x034f, B:50:0x0362, B:53:0x036d, B:54:0x03a2, B:56:0x03a8, B:58:0x03bc, B:59:0x03cb, B:61:0x03d1, B:64:0x03e1, B:69:0x03e5, B:71:0x0406, B:79:0x04a2, B:81:0x04c5, B:83:0x04c9, B:85:0x0421, B:89:0x042b, B:91:0x0443, B:94:0x044c, B:95:0x046b, B:98:0x0474, B:99:0x0491, B:101:0x0499, B:103:0x030b, B:106:0x0316, B:109:0x04da, B:111:0x04e5, B:113:0x04ff), top: B:23:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0220 A[Catch: Exception -> 0x0056, LOOP:0: B:29:0x0217->B:32:0x0220, LOOP_END, TRY_ENTER, TryCatch #4 {Exception -> 0x0056, blocks: (B:24:0x004f, B:26:0x01e5, B:28:0x01fa, B:29:0x0217, B:32:0x0220, B:34:0x0242, B:35:0x025a, B:37:0x0260, B:39:0x0278, B:41:0x02ca, B:43:0x02ea, B:45:0x034f, B:50:0x0362, B:53:0x036d, B:54:0x03a2, B:56:0x03a8, B:58:0x03bc, B:59:0x03cb, B:61:0x03d1, B:64:0x03e1, B:69:0x03e5, B:71:0x0406, B:79:0x04a2, B:81:0x04c5, B:83:0x04c9, B:85:0x0421, B:89:0x042b, B:91:0x0443, B:94:0x044c, B:95:0x046b, B:98:0x0474, B:99:0x0491, B:101:0x0499, B:103:0x030b, B:106:0x0316, B:109:0x04da, B:111:0x04e5, B:113:0x04ff), top: B:23:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0260 A[Catch: Exception -> 0x0056, TryCatch #4 {Exception -> 0x0056, blocks: (B:24:0x004f, B:26:0x01e5, B:28:0x01fa, B:29:0x0217, B:32:0x0220, B:34:0x0242, B:35:0x025a, B:37:0x0260, B:39:0x0278, B:41:0x02ca, B:43:0x02ea, B:45:0x034f, B:50:0x0362, B:53:0x036d, B:54:0x03a2, B:56:0x03a8, B:58:0x03bc, B:59:0x03cb, B:61:0x03d1, B:64:0x03e1, B:69:0x03e5, B:71:0x0406, B:79:0x04a2, B:81:0x04c5, B:83:0x04c9, B:85:0x0421, B:89:0x042b, B:91:0x0443, B:94:0x044c, B:95:0x046b, B:98:0x0474, B:99:0x0491, B:101:0x0499, B:103:0x030b, B:106:0x0316, B:109:0x04da, B:111:0x04e5, B:113:0x04ff), top: B:23:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x04c5 A[Catch: Exception -> 0x0056, TryCatch #4 {Exception -> 0x0056, blocks: (B:24:0x004f, B:26:0x01e5, B:28:0x01fa, B:29:0x0217, B:32:0x0220, B:34:0x0242, B:35:0x025a, B:37:0x0260, B:39:0x0278, B:41:0x02ca, B:43:0x02ea, B:45:0x034f, B:50:0x0362, B:53:0x036d, B:54:0x03a2, B:56:0x03a8, B:58:0x03bc, B:59:0x03cb, B:61:0x03d1, B:64:0x03e1, B:69:0x03e5, B:71:0x0406, B:79:0x04a2, B:81:0x04c5, B:83:0x04c9, B:85:0x0421, B:89:0x042b, B:91:0x0443, B:94:0x044c, B:95:0x046b, B:98:0x0474, B:99:0x0491, B:101:0x0499, B:103:0x030b, B:106:0x0316, B:109:0x04da, B:111:0x04e5, B:113:0x04ff), top: B:23:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x04c9 A[Catch: Exception -> 0x0056, TryCatch #4 {Exception -> 0x0056, blocks: (B:24:0x004f, B:26:0x01e5, B:28:0x01fa, B:29:0x0217, B:32:0x0220, B:34:0x0242, B:35:0x025a, B:37:0x0260, B:39:0x0278, B:41:0x02ca, B:43:0x02ea, B:45:0x034f, B:50:0x0362, B:53:0x036d, B:54:0x03a2, B:56:0x03a8, B:58:0x03bc, B:59:0x03cb, B:61:0x03d1, B:64:0x03e1, B:69:0x03e5, B:71:0x0406, B:79:0x04a2, B:81:0x04c5, B:83:0x04c9, B:85:0x0421, B:89:0x042b, B:91:0x0443, B:94:0x044c, B:95:0x046b, B:98:0x0474, B:99:0x0491, B:101:0x0499, B:103:0x030b, B:106:0x0316, B:109:0x04da, B:111:0x04e5, B:113:0x04ff), top: B:23:0x004f }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r51) {
        /*
            Method dump skipped, instructions count: 1492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.CsvImporter$importCsv$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CsvImporter.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.example.flashcardapp.data.CsvImporter$importCsv$2$3", f = "CsvImporter.kt", i = {}, l = {224, 227, 229, 238, 241}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.example.flashcardapp.data.CsvImporter$importCsv$2$3, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ AppDatabase $appDb;
        final /* synthetic */ List<CardEntity> $cardsToInsert;
        final /* synthetic */ List<CardEntity> $cardsToUpdate;
        final /* synthetic */ long $deckId;
        final /* synthetic */ String $deckName;
        final /* synthetic */ Long $targetDeckId;
        final /* synthetic */ long $timestamp;
        final /* synthetic */ int $totalProcessed;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Long l, long j, String str, int i, long j2, AppDatabase appDatabase, List<CardEntity> list, List<CardEntity> list2, Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
            this.$targetDeckId = l;
            this.$deckId = j;
            this.$deckName = str;
            this.$totalProcessed = i;
            this.$timestamp = j2;
            this.$appDb = appDatabase;
            this.$cardsToInsert = list;
            this.$cardsToUpdate = list2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass3(this.$targetDeckId, this.$deckId, this.$deckName, this.$totalProcessed, this.$timestamp, this.$appDb, this.$cardsToInsert, this.$cardsToUpdate, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x010e  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x009a  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                Method dump skipped, instructions count: 297
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.CsvImporter$importCsv$2.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}

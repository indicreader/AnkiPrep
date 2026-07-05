package com.example.flashcardapp.data;

import android.content.Context;
import android.net.Uri;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.CardEntity;
import com.example.flashcardapp.data.entities.DeckEntity;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ApkgImporter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/example/flashcardapp/data/ImportResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.data.ApkgImporter$importApkg$2", f = "ApkgImporter.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {267, 271, 275}, m = "invokeSuspend", n = {"fileName", "tempApkgFile", "tempDbFile", "db", "cardEntities", "parsedNoteIds", "deckCardCounts", "deckEntities", "appDb", "fileName", "tempApkgFile", "tempDbFile", "db", "cardEntities", "parsedNoteIds", "deckCardCounts", "deckEntities", "appDb", "cardsToUpdate", "cardsToInsert", "fileName", "tempApkgFile", "tempDbFile", "db", "cardEntities", "parsedNoteIds", "deckEntities", "cardsToUpdate", "cardsToInsert"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"})
/* loaded from: classes2.dex */
public final class ApkgImporter$importApkg$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImportResult>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Long $targetDeckId;
    final /* synthetic */ String $targetDeckName;
    final /* synthetic */ Uri $uri;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApkgImporter$importApkg$2(Context context, Uri uri, String str, Long l, Continuation<? super ApkgImporter$importApkg$2> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$uri = uri;
        this.$targetDeckName = str;
        this.$targetDeckId = l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ApkgImporter$importApkg$2(this.$context, this.$uri, this.$targetDeckName, this.$targetDeckId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImportResult> continuation) {
        return ((ApkgImporter$importApkg$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:1|(1:(1:(1:(18:6|7|8|9|10|11|12|13|14|(6:17|18|(1:20)|21|22|15)|92|93|(2:105|106)|95|(3:97|(1:99)|100)|101|(1:103)|49)(2:129|130))(34:131|132|133|134|135|136|137|138|139|(4:142|143|145|140)|150|151|(6:154|155|156|(2:158|159)(1:161)|160|152)|166|167|168|169|(4:172|(2:174|175)(1:177)|176|170)|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|(1:195)(15:196|10|11|12|13|14|(1:15)|92|93|(0)|95|(0)|101|(0)|49)))(4:238|239|240|241))(5:291|292|293|294|(18:296|297|298|299|300|(3:301|302|(4:304|305|306|307)(1:329))|330|331|332|333|335|336|337|338|(2:738|739)|(3:341|(3:344|(2:347|348)(1:346)|342)|731)|737|(16:350|351|352|353|354|(3:355|356|(4:358|359|360|361)(1:383))|384|385|386|387|389|390|391|392|393|(28:395|(4:398|399|400|396)|406|407|408|409|410|411|412|413|414|415|416|417|418|419|420|421|422|423|424|(2:(16:433|434|(1:436)(1:511)|437|(1:439)(1:510)|440|(1:442)(1:509)|443|(1:445)|446|(17:450|451|(2:454|452)|455|456|(4:459|(3:461|462|463)(1:465)|464|457)|466|467|(1:469)|(5:471|(4:474|(2:476|477)(1:479)|478|472)|480|481|(1:502)(1:485))(1:503)|(1:489)|490|(3:492|(1:494)(1:500)|495)(1:501)|496|497|498|499)|505|506|499|430|431)|512)|523|524|525|526|527|(31:529|(6:532|533|(6:535|(4:538|(2:540|541)(1:543)|542|536)|544|545|(1:549)|552)(1:554)|550|551|530)|559|560|561|(5:564|(1:566)(1:575)|(2:573|574)(2:570|571)|572|562)|576|577|(4:580|(2:582|583)(1:585)|584|578)|586|587|(2:590|588)|591|592|(10:595|(1:597)|598|(1:600)(1:629)|601|(6:603|(2:604|(2:606|(2:608|609)(1:625))(2:626|627))|610|(1:612)(1:624)|(1:614)(1:623)|615)(1:628)|616|(2:618|619)(2:621|622)|620|593)|630|631|(4:634|(3:636|637|638)(1:640)|639|632)|642|643|644|645|646|647|648|649|650|651|652|653|(1:655)(1:656))(3:677|678|679))(2:702|703))(2:729|730))(2:754|755))|242|243|(3:246|247|244)|252|253|(4:256|(2:258|259)(1:261)|260|254)|262|263|(5:266|267|(2:269|270)(1:272)|271|264)|274|275|276|277|(1:279)(31:280|135|136|137|138|139|(1:140)|150|151|(1:152)|166|167|168|169|(1:170)|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|(0)(0))|(8:(0)|(1:518)|(1:324)|(1:319)|(1:313)|(1:367)|(1:378)|(1:373))) */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0c20, code lost:
    
        if (r3.exists() != false) goto L396;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x0cb0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x0cb1, code lost:
    
        r8 = r20;
        r5 = r28;
        r14 = r2;
        r12 = r11;
        r20 = r15;
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x0ca6, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x0ca7, code lost:
    
        r8 = r20;
        r5 = r28;
        r14 = r2;
        r12 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0ed2, code lost:
    
        if (r3.exists() != false) goto L396;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0c25, code lost:
    
        r3 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0c22, code lost:
    
        r3.delete();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0c1c  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0bf6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x08fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0942  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0998 A[Catch: all -> 0x0964, Exception -> 0x0970, TRY_ENTER, TryCatch #83 {Exception -> 0x0970, all -> 0x0964, blocks: (B:156:0x0944, B:158:0x095c, B:172:0x0998, B:174:0x09b4), top: B:155:0x0944 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0b06 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0a12 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0a13  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0e42 A[Catch: all -> 0x0ed7, TryCatch #36 {all -> 0x0ed7, blocks: (B:28:0x0e36, B:30:0x0e42, B:32:0x0e48, B:35:0x0e91, B:57:0x0e58, B:59:0x0e5c, B:60:0x0e74, B:62:0x0e78, B:65:0x0e89), top: B:27:0x0e36 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0ebd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0ece  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0eaa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0e5c A[Catch: all -> 0x0ed7, TryCatch #36 {all -> 0x0ed7, blocks: (B:28:0x0e36, B:30:0x0e42, B:32:0x0e48, B:35:0x0e91, B:57:0x0e58, B:59:0x0e5c, B:60:0x0e74, B:62:0x0e78, B:65:0x0e89), top: B:27:0x0e36 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0e74 A[Catch: all -> 0x0ed7, TryCatch #36 {all -> 0x0ed7, blocks: (B:28:0x0e36, B:30:0x0e42, B:32:0x0e48, B:35:0x0e91, B:57:0x0e58, B:59:0x0e5c, B:60:0x0e74, B:62:0x0e78, B:65:0x0e89), top: B:27:0x0e36 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0eef  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0f00  */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0edc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0c0b  */
    /* JADX WARN: Type inference failed for: r10v22, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v38 */
    /* JADX WARN: Type inference failed for: r10v39 */
    /* JADX WARN: Type inference failed for: r10v44 */
    /* JADX WARN: Type inference failed for: r10v45 */
    /* JADX WARN: Type inference failed for: r10v46, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v33 */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v36 */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r12v42 */
    /* JADX WARN: Type inference failed for: r12v45 */
    /* JADX WARN: Type inference failed for: r12v56 */
    /* JADX WARN: Type inference failed for: r12v57 */
    /* JADX WARN: Type inference failed for: r12v58 */
    /* JADX WARN: Type inference failed for: r12v59 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v60 */
    /* JADX WARN: Type inference failed for: r12v64 */
    /* JADX WARN: Type inference failed for: r12v65 */
    /* JADX WARN: Type inference failed for: r12v67, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r12v68 */
    /* JADX WARN: Type inference failed for: r12v69, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r12v71, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r12v86 */
    /* JADX WARN: Type inference failed for: r12v89 */
    /* JADX WARN: Type inference failed for: r12v90 */
    /* JADX WARN: Type inference failed for: r12v91 */
    /* JADX WARN: Type inference failed for: r12v92 */
    /* JADX WARN: Type inference failed for: r12v93 */
    /* JADX WARN: Type inference failed for: r14v52, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r15v13, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r2v26, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r4v6, types: [T, java.io.File] */
    /* JADX WARN: Type inference failed for: r6v11, types: [T, java.io.File] */
    /* JADX WARN: Type inference failed for: r6v77, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v62, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v43, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v90 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r67) {
        /*
            Method dump skipped, instructions count: 3852
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.ApkgImporter$importApkg$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ApkgImporter.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.example.flashcardapp.data.ApkgImporter$importApkg$2$4", f = "ApkgImporter.kt", i = {}, l = {278, 281, 285, 286, 288, 289}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.example.flashcardapp.data.ApkgImporter$importApkg$2$4, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ AppDatabase $appDb;
        final /* synthetic */ List<CardEntity> $cardsToInsert;
        final /* synthetic */ List<CardEntity> $cardsToUpdate;
        final /* synthetic */ Map<Long, Integer> $deckCardCounts;
        final /* synthetic */ List<DeckEntity> $decksToInsert;
        final /* synthetic */ List<DeckEntity> $decksToUpdate;
        final /* synthetic */ Long $targetDeckId;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Long l, AppDatabase appDatabase, Map<Long, Integer> map, List<DeckEntity> list, List<DeckEntity> list2, List<CardEntity> list3, List<CardEntity> list4, Continuation<? super AnonymousClass4> continuation) {
            super(1, continuation);
            this.$targetDeckId = l;
            this.$appDb = appDatabase;
            this.$deckCardCounts = map;
            this.$decksToInsert = list;
            this.$decksToUpdate = list2;
            this.$cardsToInsert = list3;
            this.$cardsToUpdate = list4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass4(this.$targetDeckId, this.$appDb, this.$deckCardCounts, this.$decksToInsert, this.$decksToUpdate, this.$cardsToInsert, this.$cardsToUpdate, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:10:0x011b  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00e6  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00cb A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00b6 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0067  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instructions count: 328
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.ApkgImporter$importApkg$2.AnonymousClass4.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}

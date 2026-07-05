package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnkiDataRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/example/flashcardapp/data/SyncResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.data.AnkiDataRepository$syncFromAnkiDroid$2", f = "AnkiDataRepository.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4}, l = {127, 160, 188, 193, 202}, m = "invokeSuspend", n = {"rawDecks", "startTime", "rawDecks", "deckPaths", "deckPathToId", "deckEntities", "startTime", "deckPaths", "deckPathToId", "deckEntities", "deck", "resolvedPath", "cardEntities", "startTime", "totalCards", "deckPaths", "deckPathToId", "deckEntities", "startTime", "totalCards", "deckEntities", "startTime", "totalCards", "duration"}, s = {"L$0", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "J$0", "I$0", "L$0", "L$1", "L$2", "J$0", "I$0", "L$0", "J$0", "I$0", "J$1"})
/* loaded from: classes2.dex */
public final class AnkiDataRepository$syncFromAnkiDroid$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SyncResult>, Object> {
    int I$0;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ AnkiDataRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnkiDataRepository$syncFromAnkiDroid$2(AnkiDataRepository ankiDataRepository, Continuation<? super AnkiDataRepository$syncFromAnkiDroid$2> continuation) {
        super(2, continuation);
        this.this$0 = ankiDataRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnkiDataRepository$syncFromAnkiDroid$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SyncResult> continuation) {
        return ((AnkiDataRepository$syncFromAnkiDroid$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x032c, code lost:
    
        r11 = r9.get(kotlin.coroutines.jvm.internal.Boxing.boxLong(r14.getId()));
        kotlin.jvm.internal.Intrinsics.checkNotNull(r11);
        r13 = (java.lang.String) r11;
        r10 = r10;
        r11 = r20;
        r15 = r11.this$0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0346, code lost:
    
        r19 = r4;
        r20 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x034c, code lost:
    
        r1 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(r10, 10));
        r4 = r10.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x035d, code lost:
    
        if (r4.hasNext() == false) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x035f, code lost:
    
        r10 = (com.example.flashcardapp.data.AnkiFlashcard) r4.next();
        r23 = r10.getCardId();
        r25 = r10.getNoteId();
        r27 = r14.getId();
        r29 = r15.resolveSubDeckId(r13, r3);
        r30 = r10.getFront();
        r31 = r10.getBack();
        r42 = r4;
        r4 = r15.gson;
        r4 = r4.toJson(r10.getTags());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "toJson(...)");
        r1.add(new com.example.flashcardapp.data.entities.CardEntity(r23, r25, r27, r29, r30, r31, r4, r13, java.lang.System.currentTimeMillis(), null, null, null, null, 7680, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x03af, code lost:
    
        r4 = r42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x03b4, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x03b5, code lost:
    
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x03b8, code lost:
    
        r1 = r1;
        r4 = r11.this$0.cardDao;
        r11.L$0 = r9;
        r11.L$1 = r3;
        r11.L$2 = r7;
        r11.L$3 = r8;
        r11.L$4 = r14;
        r11.L$5 = r13;
        r11.L$6 = r1;
        r11.J$0 = r5;
        r11.I$0 = r0;
        r11.label = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x03dc, code lost:
    
        if (r4.upsertCards(r1, r11) != r2) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x03de, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x03df, code lost:
    
        r4 = r5;
        r15 = r8;
        r6 = r3;
        r3 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0492, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0493, code lost:
    
        r8 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0497, code lost:
    
        r8 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0498, code lost:
    
        r3 = java.lang.System.currentTimeMillis() - r5;
        android.util.Log.d(r8, "━━━ Sync complete: " + r0 + " cards across " + r7.size() + " decks in " + r3 + "ms ━━━");
        r11.L$0 = r7;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.L$3 = null;
        r11.J$0 = r5;
        r11.I$0 = r0;
        r11.J$1 = r3;
        r11.label = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x04f1, code lost:
    
        if (r11.this$0.getFsrsScheduler().initializeNewCards(r11) != r2) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x04f3, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x04f4, code lost:
    
        r12 = r0;
        r13 = r3;
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x050b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x02eb A[Catch: Exception -> 0x050d, TRY_LEAVE, TryCatch #1 {Exception -> 0x050d, blocks: (B:10:0x02e5, B:12:0x02eb, B:18:0x032c, B:8:0x02b8, B:107:0x0126, B:108:0x0141, B:112:0x015a, B:113:0x016c, B:126:0x01dc, B:127:0x01fc, B:131:0x0220, B:132:0x0232, B:142:0x0292, B:148:0x00cb, B:152:0x010f), top: B:147:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0497 A[EDGE_INSN: B:69:0x0497->B:70:0x0497 BREAK  A[LOOP:0: B:10:0x02e5->B:16:0x047e], SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r45) {
        /*
            Method dump skipped, instructions count: 1349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.AnkiDataRepository$syncFromAnkiDroid$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

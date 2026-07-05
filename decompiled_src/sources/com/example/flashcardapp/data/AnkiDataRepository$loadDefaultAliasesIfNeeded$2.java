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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.data.AnkiDataRepository$loadDefaultAliasesIfNeeded$2", f = "AnkiDataRepository.kt", i = {1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {793, 828, 839}, m = "invokeSuspend", n = {"assetManager", "subj", "reader", "primaryName", "isFirstLine", "isNewFormat", "assetManager", "subj", "reader", "isFirstLine", "isNewFormat"}, s = {"L$0", "L$2", "L$5", "L$6", "I$0", "I$1", "L$0", "L$2", "L$5", "I$0", "I$1"})
/* loaded from: classes2.dex */
public final class AnkiDataRepository$loadDefaultAliasesIfNeeded$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    final /* synthetic */ AnkiDataRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnkiDataRepository$loadDefaultAliasesIfNeeded$2(AnkiDataRepository ankiDataRepository, Continuation<? super AnkiDataRepository$loadDefaultAliasesIfNeeded$2> continuation) {
        super(2, continuation);
        this.this$0 = ankiDataRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnkiDataRepository$loadDefaultAliasesIfNeeded$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnkiDataRepository$loadDefaultAliasesIfNeeded$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:8|9|10|11|12|14|(8:17|18|(1:127)(1:(3:21|22|(2:24|25)(1:26))(1:126))|55|11|12|14|(1:15))|132|133|134|135|136|70|71|(16:73|74|75|77|78|79|14|(1:15)|132|133|134|135|136|70|71|(0))|87|88) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x027a, code lost:
    
        if (r1.size() < 2) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x027c, code lost:
    
        r7 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r1.get(0)).toString().toLowerCase(java.util.Locale.ROOT);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, "toLowerCase(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0296, code lost:
    
        r9 = 1;
        r9 = 1;
        r9 = 1;
        r9 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0297, code lost:
    
        r1 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r1.get(1)).toString().toLowerCase(java.util.Locale.ROOT);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "toLowerCase(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02b7, code lost:
    
        if (r7.length() <= 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02c0, code lost:
    
        if (r1.length() <= 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02c2, code lost:
    
        r4 = r10.getAliasDao();
        r8 = new com.example.flashcardapp.data.entities.AliasEntity(r7, r1);
        r3.L$0 = r14;
        r3.L$1 = r13;
        r3.L$2 = r12;
        r3.L$3 = r11;
        r3.L$4 = r10;
        r3.L$5 = r6;
        r3.L$6 = null;
        r3.L$7 = null;
        r3.I$0 = r15;
        r3.I$1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02e0, code lost:
    
        r1 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02e1, code lost:
    
        r3.label = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x02e7, code lost:
    
        if (r4.insertAlias(r8, r3) != r2) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02e9, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02ea, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x030a, code lost:
    
        r1 = 3;
        r9 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x02ef, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02f0, code lost:
    
        r9 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x02f2, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02f3, code lost:
    
        r1 = 3;
        r9 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x02f7, code lost:
    
        r9 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0160, code lost:
    
        r15 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x016b, code lost:
    
        if (r0 == 0) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x016d, code lost:
    
        r1 = new java.lang.String[1];
        r1[r7] = ",";
        r1 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r9, r1, false, 3, 2, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0189, code lost:
    
        if (r1.size() < 3) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x018b, code lost:
    
        r8 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r1.get(1)).toString().toLowerCase(java.util.Locale.ROOT);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, "toLowerCase(...)");
        r1 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r1.get(2)).toString().toLowerCase(java.util.Locale.ROOT);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "toLowerCase(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x01c6, code lost:
    
        if (r8.length() <= 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x01cf, code lost:
    
        if (r1.length() <= 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x01d1, code lost:
    
        r4 = new java.lang.String[1];
        r4[r7] = "|";
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x01f1, code lost:
    
        r9 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r1, r4, false, 0, 6, (java.lang.Object) null).iterator();
        r1 = r12;
        r12 = r10;
        r10 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x024d, code lost:
    
        r10 = r12;
        r9 = 1;
        r12 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0336, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x035f, code lost:
    
        android.util.Log.e("AnkiDataRepository", "Failed to load default aliases for " + r12 + ": " + r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02ec, code lost:
    
        r1 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02ed, code lost:
    
        r9 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x025a, code lost:
    
        r1 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x02fa, code lost:
    
        r9 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x025d, code lost:
    
        r18 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0262, code lost:
    
        r7 = new java.lang.String[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0265, code lost:
    
        r7[0] = ",";
        r1 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r18, r7, false, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0139 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01fb A[Catch: all -> 0x0253, TryCatch #11 {all -> 0x0253, blocks: (B:40:0x01f5, B:42:0x01fb, B:46:0x0214), top: B:39:0x01f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x023a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x024d A[EDGE_INSN: B:53:0x024d->B:54:0x024d BREAK  A[LOOP:1: B:39:0x01f5->B:44:0x01f5], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f8 A[Catch: Exception -> 0x008d, TRY_LEAVE, TryCatch #1 {Exception -> 0x008d, blocks: (B:71:0x00f2, B:73:0x00f8, B:86:0x033b, B:151:0x0087, B:153:0x00a5, B:155:0x00b1, B:157:0x00c8, B:159:0x0093), top: B:2:0x0010 }] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v35 */
    /* JADX WARN: Type inference failed for: r9v44 */
    /* JADX WARN: Type inference failed for: r9v45 */
    /* JADX WARN: Type inference failed for: r9v46 */
    /* JADX WARN: Type inference failed for: r9v52 */
    /* JADX WARN: Type inference failed for: r9v53 */
    /* JADX WARN: Type inference failed for: r9v54 */
    /* JADX WARN: Type inference failed for: r9v55 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x02e7 -> B:11:0x02fa). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0133 -> B:13:0x0136). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0250 -> B:11:0x02fa). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            Method dump skipped, instructions count: 895
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.AnkiDataRepository$loadDefaultAliasesIfNeeded$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

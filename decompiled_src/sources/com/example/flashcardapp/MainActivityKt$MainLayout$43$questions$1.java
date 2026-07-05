package com.example.flashcardapp;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.AnkiDataRepository;
import com.example.flashcardapp.mcq.Mcq;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/example/flashcardapp/mcq/Mcq;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.MainActivityKt$MainLayout$43$questions$1", f = "MainActivity.kt", i = {0, 1, 2, 2, 3, 4, 5, 5, 6, 6, 6, 6, 7, 7, 8, 8, 9, 9, 9, 10, 10, 10, 11, 11, 11}, l = {1211, 1226, 1227, 1230, 1233, 1240, 1241, 1242, 1247, 1251, 1286, 1297, 1311}, m = "invokeSuspend", n = {"progressManager", "progressManager", "progressManager", "starredIds", "progressManager", "progressManager", "allCards", "targetCards", "progressManager", "allCards", "targetCards", "destination$iv$iv", "allCards", "targetCards", "allCards", "targetCards", "allCards", "targetCards", "allAliases", "allCards", "allAliases", "maxForRevision", "allCards", "allAliases", "shuffledPool"}, s = {"L$0", "L$0", "L$0", "L$1", "L$0", "L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "I$0", "L$0", "L$1", "L$2"})
/* loaded from: classes2.dex */
final class MainActivityKt$MainLayout$43$questions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Mcq>>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<Integer> $numberOfOptions$delegate;
    final /* synthetic */ MutableState<Integer> $questionLimit$delegate;
    final /* synthetic */ AnkiDataRepository $repo;
    final /* synthetic */ Screen $screen;
    final /* synthetic */ MutableState<Boolean> $showCapacityAlert$delegate;
    final /* synthetic */ MutableState<Boolean> $shuffleQuestions$delegate;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivityKt$MainLayout$43$questions$1(Context context, Screen screen, AnkiDataRepository ankiDataRepository, MutableState<Boolean> mutableState, MutableState<Integer> mutableState2, MutableState<Boolean> mutableState3, MutableState<Integer> mutableState4, Continuation<? super MainActivityKt$MainLayout$43$questions$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$screen = screen;
        this.$repo = ankiDataRepository;
        this.$showCapacityAlert$delegate = mutableState;
        this.$questionLimit$delegate = mutableState2;
        this.$shuffleQuestions$delegate = mutableState3;
        this.$numberOfOptions$delegate = mutableState4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivityKt$MainLayout$43$questions$1(this.$context, this.$screen, this.$repo, this.$showCapacityAlert$delegate, this.$questionLimit$delegate, this.$shuffleQuestions$delegate, this.$numberOfOptions$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Mcq>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<Mcq>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<Mcq>> continuation) {
        return ((MainActivityKt$MainLayout$43$questions$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x04ef  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0579  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0389 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x01a6 A[LOOP:11: B:204:0x01a0->B:206:0x01a6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x01d2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x05bd A[LOOP:1: B:20:0x05b7->B:22:0x05bd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x05ee  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0630 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x03d2 A[LOOP:2: B:40:0x03cc->B:42:0x03d2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x04e7  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:117:0x0302 -> B:113:0x0305). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            Method dump skipped, instructions count: 1618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.MainActivityKt$MainLayout$43$questions$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

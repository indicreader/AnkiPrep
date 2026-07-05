package com.example.flashcardapp;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.AnkiDataRepository;
import com.example.flashcardapp.session.McqSessionState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.MainActivityKt$MainLayout$54", f = "MainActivity.kt", i = {1, 1}, l = {1536, 1549, 1566}, m = "invokeSuspend", n = {"attempts", "record"}, s = {"L$0", "L$2"})
/* loaded from: classes2.dex */
public final class MainActivityKt$MainLayout$54 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Screen> $currentScreen$delegate;
    final /* synthetic */ AnkiDataRepository $repo;
    final /* synthetic */ Screen $screen;
    final /* synthetic */ MutableState<McqSessionState> $sessionState$delegate;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivityKt$MainLayout$54(AnkiDataRepository ankiDataRepository, Screen screen, MutableState<McqSessionState> mutableState, MutableState<Screen> mutableState2, Continuation<? super MainActivityKt$MainLayout$54> continuation) {
        super(2, continuation);
        this.$repo = ankiDataRepository;
        this.$screen = screen;
        this.$sessionState$delegate = mutableState;
        this.$currentScreen$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivityKt$MainLayout$54(this.$repo, this.$screen, this.$sessionState$delegate, this.$currentScreen$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivityKt$MainLayout$54) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|2|(1:(1:(1:(5:7|8|9|10|11)(2:13|14))(8:15|16|17|18|19|20|21|(2:23|(1:25)(7:26|17|18|19|20|21|(5:27|(2:29|(1:31))|9|10|11)(0)))(0)))(1:38))(4:41|(2:43|(1:45))|10|11)|39|40|20|21|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0169, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00da A[Catch: Exception -> 0x0169, TRY_LEAVE, TryCatch #1 {Exception -> 0x0169, blocks: (B:21:0x00d4, B:23:0x00da, B:27:0x0149, B:29:0x0153), top: B:20:0x00d4 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0149 A[Catch: Exception -> 0x0169, TRY_ENTER, TryCatch #1 {Exception -> 0x0169, blocks: (B:21:0x00d4, B:23:0x00da, B:27:0x0149, B:29:0x0153), top: B:20:0x00d4 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0109 -> B:17:0x010e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r39) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.MainActivityKt$MainLayout$54.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

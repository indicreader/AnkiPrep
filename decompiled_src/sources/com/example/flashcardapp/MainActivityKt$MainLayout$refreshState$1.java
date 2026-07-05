package com.example.flashcardapp;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.AnkiDataRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.MainActivityKt$MainLayout$refreshState$1", f = "MainActivity.kt", i = {}, l = {695}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class MainActivityKt$MainLayout$refreshState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Integer> $cardCount$delegate;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ MutableState<Integer> $deckCount$delegate;
    final /* synthetic */ MutableState<Boolean> $hasPermission$delegate;
    final /* synthetic */ AnkiDataRepository $repo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivityKt$MainLayout$refreshState$1(AnkiDataRepository ankiDataRepository, MutableState<Boolean> mutableState, CoroutineScope coroutineScope, MutableState<Integer> mutableState2, MutableState<Integer> mutableState3, Continuation<? super MainActivityKt$MainLayout$refreshState$1> continuation) {
        super(2, continuation);
        this.$repo = ankiDataRepository;
        this.$hasPermission$delegate = mutableState;
        this.$coroutineScope = coroutineScope;
        this.$deckCount$delegate = mutableState2;
        this.$cardCount$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivityKt$MainLayout$refreshState$1(this.$repo, this.$hasPermission$delegate, this.$coroutineScope, this.$deckCount$delegate, this.$cardCount$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivityKt$MainLayout$refreshState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean MainLayout$lambda$19;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MainLayout$lambda$19 = MainActivityKt.MainLayout$lambda$19(this.$hasPermission$delegate);
            if (MainLayout$lambda$19) {
                this.label = 1;
                if (this.$repo.syncFromAnkiDroid(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        MainActivityKt.MainLayout$reloadDbStats(this.$coroutineScope, this.$repo, this.$deckCount$delegate, this.$cardCount$delegate);
        return Unit.INSTANCE;
    }
}

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
@DebugMetadata(c = "com.example.flashcardapp.MainActivityKt$MainLayout$reloadDbStats$1", f = "MainActivity.kt", i = {}, l = {685, 686}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class MainActivityKt$MainLayout$reloadDbStats$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Integer> $cardCount$delegate;
    final /* synthetic */ MutableState<Integer> $deckCount$delegate;
    final /* synthetic */ AnkiDataRepository $repo;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivityKt$MainLayout$reloadDbStats$1(AnkiDataRepository ankiDataRepository, MutableState<Integer> mutableState, MutableState<Integer> mutableState2, Continuation<? super MainActivityKt$MainLayout$reloadDbStats$1> continuation) {
        super(2, continuation);
        this.$repo = ankiDataRepository;
        this.$deckCount$delegate = mutableState;
        this.$cardCount$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivityKt$MainLayout$reloadDbStats$1(this.$repo, this.$deckCount$delegate, this.$cardCount$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivityKt$MainLayout$reloadDbStats$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableState<Integer> mutableState;
        MutableState<Integer> mutableState2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableState = this.$deckCount$delegate;
            this.L$0 = mutableState;
            this.label = 1;
            obj = this.$repo.getDeckCount(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableState2 = (MutableState) this.L$0;
                ResultKt.throwOnFailure(obj);
                MainActivityKt.MainLayout$lambda$64(mutableState2, ((Number) obj).intValue());
                return Unit.INSTANCE;
            }
            mutableState = (MutableState) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        MainActivityKt.MainLayout$lambda$61(mutableState, ((Number) obj).intValue());
        MutableState<Integer> mutableState3 = this.$cardCount$delegate;
        this.L$0 = mutableState3;
        this.label = 2;
        Object cardCount = this.$repo.getCardCount(this);
        if (cardCount == coroutine_suspended) {
            return coroutine_suspended;
        }
        mutableState2 = mutableState3;
        obj = cardCount;
        MainActivityKt.MainLayout$lambda$64(mutableState2, ((Number) obj).intValue());
        return Unit.INSTANCE;
    }
}

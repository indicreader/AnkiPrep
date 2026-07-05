package com.example.flashcardapp;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.AnkiDataRepository;
import com.example.flashcardapp.mcq.Mcq;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.MainActivityKt$MainLayout$43", f = "MainActivity.kt", i = {}, l = {1207}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class MainActivityKt$MainLayout$43 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<List<Mcq>> $mcqsState$delegate;
    final /* synthetic */ MutableState<Integer> $numberOfOptions$delegate;
    final /* synthetic */ MutableState<Integer> $questionLimit$delegate;
    final /* synthetic */ AnkiDataRepository $repo;
    final /* synthetic */ Screen $screen;
    final /* synthetic */ MutableState<Boolean> $showCapacityAlert$delegate;
    final /* synthetic */ MutableState<Boolean> $shuffleQuestions$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivityKt$MainLayout$43(Context context, Screen screen, AnkiDataRepository ankiDataRepository, MutableState<Boolean> mutableState, MutableState<Integer> mutableState2, MutableState<Boolean> mutableState3, MutableState<Integer> mutableState4, MutableState<List<Mcq>> mutableState5, Continuation<? super MainActivityKt$MainLayout$43> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$screen = screen;
        this.$repo = ankiDataRepository;
        this.$showCapacityAlert$delegate = mutableState;
        this.$questionLimit$delegate = mutableState2;
        this.$shuffleQuestions$delegate = mutableState3;
        this.$numberOfOptions$delegate = mutableState4;
        this.$mcqsState$delegate = mutableState5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivityKt$MainLayout$43(this.$context, this.$screen, this.$repo, this.$showCapacityAlert$delegate, this.$questionLimit$delegate, this.$shuffleQuestions$delegate, this.$numberOfOptions$delegate, this.$mcqsState$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivityKt$MainLayout$43) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean MainLayout$lambda$102;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getDefault(), new MainActivityKt$MainLayout$43$questions$1(this.$context, this.$screen, this.$repo, this.$showCapacityAlert$delegate, this.$questionLimit$delegate, this.$shuffleQuestions$delegate, this.$numberOfOptions$delegate, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        List list = (List) obj;
        MainLayout$lambda$102 = MainActivityKt.MainLayout$lambda$102(this.$showCapacityAlert$delegate);
        if (MainLayout$lambda$102) {
            this.$mcqsState$delegate.setValue(CollectionsKt.emptyList());
        } else {
            this.$mcqsState$delegate.setValue(list);
        }
        return Unit.INSTANCE;
    }
}

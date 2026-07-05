package com.example.flashcardapp.ui;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReviewTab.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$11$1", f = "ReviewTab.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class ReviewTabKt$ReviewTab$11$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $isFabVisible$delegate;
    final /* synthetic */ MutableState<Integer> $lastScrollIndex$delegate;
    final /* synthetic */ MutableState<Integer> $lastScrollOffset$delegate;
    final /* synthetic */ LazyListState $listState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewTabKt$ReviewTab$11$1(LazyListState lazyListState, MutableState<Integer> mutableState, MutableState<Integer> mutableState2, MutableState<Boolean> mutableState3, Continuation<? super ReviewTabKt$ReviewTab$11$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
        this.$lastScrollIndex$delegate = mutableState;
        this.$lastScrollOffset$delegate = mutableState2;
        this.$isFabVisible$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReviewTabKt$ReviewTab$11$1(this.$listState, this.$lastScrollIndex$delegate, this.$lastScrollOffset$delegate, this.$isFabVisible$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ReviewTabKt$ReviewTab$11$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
    
        if (r0 < r1) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002c, code lost:
    
        if (r0 > r1) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        /*
            r3 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r3.label
            if (r0 != 0) goto L61
            kotlin.ResultKt.throwOnFailure(r4)
            androidx.compose.foundation.lazy.LazyListState r4 = r3.$listState
            int r4 = r4.getFirstVisibleItemIndex()
            androidx.compose.foundation.lazy.LazyListState r0 = r3.$listState
            int r0 = r0.getFirstVisibleItemScrollOffset()
            androidx.compose.runtime.MutableState<java.lang.Integer> r1 = r3.$lastScrollIndex$delegate
            int r1 = com.example.flashcardapp.ui.ReviewTabKt.access$ReviewTab$lambda$32(r1)
            if (r4 > r1) goto L4e
            androidx.compose.runtime.MutableState<java.lang.Integer> r1 = r3.$lastScrollIndex$delegate
            int r1 = com.example.flashcardapp.ui.ReviewTabKt.access$ReviewTab$lambda$32(r1)
            if (r4 != r1) goto L2f
            androidx.compose.runtime.MutableState<java.lang.Integer> r1 = r3.$lastScrollOffset$delegate
            int r1 = com.example.flashcardapp.ui.ReviewTabKt.access$ReviewTab$lambda$29(r1)
            if (r0 <= r1) goto L2f
            goto L4e
        L2f:
            androidx.compose.runtime.MutableState<java.lang.Integer> r1 = r3.$lastScrollIndex$delegate
            int r1 = com.example.flashcardapp.ui.ReviewTabKt.access$ReviewTab$lambda$32(r1)
            if (r4 < r1) goto L47
            androidx.compose.runtime.MutableState<java.lang.Integer> r1 = r3.$lastScrollIndex$delegate
            int r1 = com.example.flashcardapp.ui.ReviewTabKt.access$ReviewTab$lambda$32(r1)
            if (r4 != r1) goto L54
            androidx.compose.runtime.MutableState<java.lang.Integer> r1 = r3.$lastScrollOffset$delegate
            int r1 = com.example.flashcardapp.ui.ReviewTabKt.access$ReviewTab$lambda$29(r1)
            if (r0 >= r1) goto L54
        L47:
            androidx.compose.runtime.MutableState<java.lang.Boolean> r1 = r3.$isFabVisible$delegate
            r2 = 1
            com.example.flashcardapp.ui.ReviewTabKt.access$ReviewTab$lambda$27(r1, r2)
            goto L54
        L4e:
            androidx.compose.runtime.MutableState<java.lang.Boolean> r1 = r3.$isFabVisible$delegate
            r2 = 0
            com.example.flashcardapp.ui.ReviewTabKt.access$ReviewTab$lambda$27(r1, r2)
        L54:
            androidx.compose.runtime.MutableState<java.lang.Integer> r1 = r3.$lastScrollIndex$delegate
            com.example.flashcardapp.ui.ReviewTabKt.access$ReviewTab$lambda$33(r1, r4)
            androidx.compose.runtime.MutableState<java.lang.Integer> r4 = r3.$lastScrollOffset$delegate
            com.example.flashcardapp.ui.ReviewTabKt.access$ReviewTab$lambda$30(r4, r0)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L61:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$11$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

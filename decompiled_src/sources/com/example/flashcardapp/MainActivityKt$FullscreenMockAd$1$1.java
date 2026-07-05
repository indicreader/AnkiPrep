package com.example.flashcardapp;

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
/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.MainActivityKt$FullscreenMockAd$1$1", f = "MainActivity.kt", i = {}, l = {409}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class MainActivityKt$FullscreenMockAd$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Integer> $countdown$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivityKt$FullscreenMockAd$1$1(MutableState<Integer> mutableState, Continuation<? super MainActivityKt$FullscreenMockAd$1$1> continuation) {
        super(2, continuation);
        this.$countdown$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivityKt$FullscreenMockAd$1$1(this.$countdown$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivityKt$FullscreenMockAd$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002f -> B:5:0x0032). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L18
            if (r1 != r2) goto L10
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r5
            goto L32
        L10:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L18:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r5
        L1c:
            androidx.compose.runtime.MutableState<java.lang.Integer> r1 = r6.$countdown$delegate
            int r1 = com.example.flashcardapp.MainActivityKt.access$FullscreenMockAd$lambda$1(r1)
            if (r1 <= 0) goto L40
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r6.label = r2
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r3, r1)
            if (r1 != r0) goto L32
            return r0
        L32:
            androidx.compose.runtime.MutableState<java.lang.Integer> r1 = r6.$countdown$delegate
            int r1 = com.example.flashcardapp.MainActivityKt.access$FullscreenMockAd$lambda$1(r1)
            androidx.compose.runtime.MutableState<java.lang.Integer> r3 = r6.$countdown$delegate
            int r1 = r1 + (-1)
            com.example.flashcardapp.MainActivityKt.access$FullscreenMockAd$lambda$2(r3, r1)
            goto L1c
        L40:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.MainActivityKt$FullscreenMockAd$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

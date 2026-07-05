package com.example.flashcardapp.mcq;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.CardEntity;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: McqEngine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/example/flashcardapp/data/entities/CardEntity;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.mcq.HierarchyIndex$Companion$buildAsync$2$deferreds$1$1", f = "McqEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class HierarchyIndex$Companion$buildAsync$2$deferreds$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends CardEntity, ? extends String>>, Object> {
    final /* synthetic */ CardEntity $card;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HierarchyIndex$Companion$buildAsync$2$deferreds$1$1(CardEntity cardEntity, Continuation<? super HierarchyIndex$Companion$buildAsync$2$deferreds$1$1> continuation) {
        super(2, continuation);
        this.$card = cardEntity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HierarchyIndex$Companion$buildAsync$2$deferreds$1$1(this.$card, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends CardEntity, ? extends String>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<CardEntity, String>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<CardEntity, String>> continuation) {
        return ((HierarchyIndex$Companion$buildAsync$2$deferreds$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return TuplesKt.to(this.$card, SemanticClassifier.INSTANCE.classify(this.$card.getFront(), this.$card.getBack()));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

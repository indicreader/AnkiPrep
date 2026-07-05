package com.example.flashcardapp.ui;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.DeckEntity;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReviseTab.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.ui.ReviseTabKt$ReviseTab$1$1", f = "ReviseTab.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class ReviseTabKt$ReviseTab$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<List<DeckEntity>> $decks$delegate;
    final /* synthetic */ MutableState<DeckEntity> $selectedDeck$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ReviseTabKt$ReviseTab$1$1(MutableState<DeckEntity> mutableState, State<? extends List<DeckEntity>> state, Continuation<? super ReviseTabKt$ReviseTab$1$1> continuation) {
        super(2, continuation);
        this.$selectedDeck$delegate = mutableState;
        this.$decks$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReviseTabKt$ReviseTab$1$1(this.$selectedDeck$delegate, this.$decks$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ReviseTabKt$ReviseTab$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DeckEntity ReviseTab$lambda$6;
        List ReviseTab$lambda$0;
        List ReviseTab$lambda$02;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ReviseTab$lambda$6 = ReviseTabKt.ReviseTab$lambda$6(this.$selectedDeck$delegate);
            if (ReviseTab$lambda$6 == null) {
                ReviseTab$lambda$0 = ReviseTabKt.ReviseTab$lambda$0(this.$decks$delegate);
                if (!ReviseTab$lambda$0.isEmpty()) {
                    MutableState<DeckEntity> mutableState = this.$selectedDeck$delegate;
                    ReviseTab$lambda$02 = ReviseTabKt.ReviseTab$lambda$0(this.$decks$delegate);
                    mutableState.setValue((DeckEntity) CollectionsKt.firstOrNull(ReviseTab$lambda$02));
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

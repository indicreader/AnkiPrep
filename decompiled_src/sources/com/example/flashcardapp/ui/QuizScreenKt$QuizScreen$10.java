package com.example.flashcardapp.ui;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.AnkiDataRepository;
import com.example.flashcardapp.data.entities.CardUserMetadataEntity;
import com.example.flashcardapp.mcq.Mcq;
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
/* compiled from: QuizScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.ui.QuizScreenKt$QuizScreen$10", f = "QuizScreen.kt", i = {}, l = {220}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class QuizScreenKt$QuizScreen$10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Mcq $currentQuestion;
    final /* synthetic */ MutableState<Boolean> $isStarred$delegate;
    final /* synthetic */ AnkiDataRepository $repo;
    final /* synthetic */ MutableState<Integer> $userRating$delegate;
    final /* synthetic */ SnapshotStateList<DrawingStroke> $whiteboardStrokes;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuizScreenKt$QuizScreen$10(Mcq mcq, AnkiDataRepository ankiDataRepository, SnapshotStateList<DrawingStroke> snapshotStateList, MutableState<Boolean> mutableState, MutableState<Integer> mutableState2, Continuation<? super QuizScreenKt$QuizScreen$10> continuation) {
        super(2, continuation);
        this.$currentQuestion = mcq;
        this.$repo = ankiDataRepository;
        this.$whiteboardStrokes = snapshotStateList;
        this.$isStarred$delegate = mutableState;
        this.$userRating$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QuizScreenKt$QuizScreen$10(this.$currentQuestion, this.$repo, this.$whiteboardStrokes, this.$isStarred$delegate, this.$userRating$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QuizScreenKt$QuizScreen$10) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mcq mcq = this.$currentQuestion;
            if (mcq != null) {
                this.label = 1;
                obj = this.$repo.getCardUserMetadata(mcq.getSourceCardId(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            this.$whiteboardStrokes.clear();
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CardUserMetadataEntity cardUserMetadataEntity = (CardUserMetadataEntity) obj;
        QuizScreenKt.QuizScreen$lambda$57(this.$isStarred$delegate, cardUserMetadataEntity != null && cardUserMetadataEntity.isStarred());
        QuizScreenKt.QuizScreen$lambda$60(this.$userRating$delegate, cardUserMetadataEntity != null ? cardUserMetadataEntity.getRating() : 0);
        this.$whiteboardStrokes.clear();
        return Unit.INSTANCE;
    }
}

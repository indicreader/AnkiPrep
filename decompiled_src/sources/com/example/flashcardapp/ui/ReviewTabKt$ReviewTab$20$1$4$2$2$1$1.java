package com.example.flashcardapp.ui;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.AnkiDeck;
import com.example.flashcardapp.data.SettingsRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReviewTab.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$2$2$1$1", f = "ReviewTab.kt", i = {}, l = {842}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class ReviewTabKt$ReviewTab$20$1$4$2$2$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<AnkiDeck> $decks;
    final /* synthetic */ MutableIntState $draggingIndex$delegate;
    final /* synthetic */ MutableState<Long> $draggingNodeId$delegate;
    final /* synthetic */ MutableFloatState $draggingOffset$delegate;
    final /* synthetic */ Function0<Unit> $onDeckOrderChanged;
    final /* synthetic */ AnkiDeck $playableDeck;
    final /* synthetic */ SettingsRepository $settingsRepo;
    final /* synthetic */ State<List<Pair<DeckNode, Integer>>> $visibleNodes$delegate;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ReviewTabKt$ReviewTab$20$1$4$2$2$1$1(AnkiDeck ankiDeck, MutableState<Long> mutableState, MutableFloatState mutableFloatState, State<? extends List<Pair<DeckNode, Integer>>> state, MutableIntState mutableIntState, List<AnkiDeck> list, SettingsRepository settingsRepository, Function0<Unit> function0, Continuation<? super ReviewTabKt$ReviewTab$20$1$4$2$2$1$1> continuation) {
        super(2, continuation);
        this.$playableDeck = ankiDeck;
        this.$draggingNodeId$delegate = mutableState;
        this.$draggingOffset$delegate = mutableFloatState;
        this.$visibleNodes$delegate = state;
        this.$draggingIndex$delegate = mutableIntState;
        this.$decks = list;
        this.$settingsRepo = settingsRepository;
        this.$onDeckOrderChanged = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ReviewTabKt$ReviewTab$20$1$4$2$2$1$1 reviewTabKt$ReviewTab$20$1$4$2$2$1$1 = new ReviewTabKt$ReviewTab$20$1$4$2$2$1$1(this.$playableDeck, this.$draggingNodeId$delegate, this.$draggingOffset$delegate, this.$visibleNodes$delegate, this.$draggingIndex$delegate, this.$decks, this.$settingsRepo, this.$onDeckOrderChanged, continuation);
        reviewTabKt$ReviewTab$20$1$4$2$2$1$1.L$0 = obj;
        return reviewTabKt$ReviewTab$20$1$4$2$2$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((ReviewTabKt$ReviewTab$20$1$4$2$2$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            final AnkiDeck ankiDeck = this.$playableDeck;
            final MutableState<Long> mutableState = this.$draggingNodeId$delegate;
            final MutableFloatState mutableFloatState = this.$draggingOffset$delegate;
            final State<List<Pair<DeckNode, Integer>>> state = this.$visibleNodes$delegate;
            final MutableIntState mutableIntState = this.$draggingIndex$delegate;
            Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$2$2$1$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m6343invokek4lQ0M(offset.getPackedValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m6343invokek4lQ0M(long j) {
                    List ReviewTab$lambda$77;
                    mutableState.setValue(Long.valueOf(AnkiDeck.this.getId()));
                    mutableFloatState.setFloatValue(0.0f);
                    MutableIntState mutableIntState2 = mutableIntState;
                    ReviewTab$lambda$77 = ReviewTabKt.ReviewTab$lambda$77(state);
                    AnkiDeck ankiDeck2 = AnkiDeck.this;
                    Iterator it = ReviewTab$lambda$77.iterator();
                    int i2 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i2 = -1;
                            break;
                        }
                        AnkiDeck deck = ((DeckNode) ((Pair) it.next()).getFirst()).getDeck();
                        if (deck != null && deck.getId() == ankiDeck2.getId()) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    mutableIntState2.setIntValue(i2);
                }
            };
            final MutableState<Long> mutableState2 = this.$draggingNodeId$delegate;
            final MutableFloatState mutableFloatState2 = this.$draggingOffset$delegate;
            final MutableIntState mutableIntState2 = this.$draggingIndex$delegate;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$2$2$1$1.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    mutableState2.setValue(null);
                    mutableFloatState2.setFloatValue(0.0f);
                    mutableIntState2.setIntValue(-1);
                }
            };
            final MutableState<Long> mutableState3 = this.$draggingNodeId$delegate;
            final MutableFloatState mutableFloatState3 = this.$draggingOffset$delegate;
            final MutableIntState mutableIntState3 = this.$draggingIndex$delegate;
            Function0<Unit> function02 = new Function0<Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$2$2$1$1.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    mutableState3.setValue(null);
                    mutableFloatState3.setFloatValue(0.0f);
                    mutableIntState3.setIntValue(-1);
                }
            };
            final List<AnkiDeck> list = this.$decks;
            final SettingsRepository settingsRepository = this.$settingsRepo;
            final AnkiDeck ankiDeck2 = this.$playableDeck;
            final Function0<Unit> function03 = this.$onDeckOrderChanged;
            final MutableFloatState mutableFloatState4 = this.$draggingOffset$delegate;
            final MutableIntState mutableIntState4 = this.$draggingIndex$delegate;
            final State<List<Pair<DeckNode, Integer>>> state2 = this.$visibleNodes$delegate;
            this.label = 1;
            if (DragGestureDetectorKt.detectDragGesturesAfterLongPress(pointerInputScope, function1, function0, function02, new Function2<PointerInputChange, Offset, Unit>() { // from class: com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$20$1$4$2$2$1$1.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                    m6344invokeUv8p0NA(pointerInputChange, offset.getPackedValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
                public final void m6344invokeUv8p0NA(PointerInputChange change, long j) {
                    float ReviewTab$lambda$71;
                    float ReviewTab$lambda$712;
                    int ReviewTab$lambda$74;
                    List ReviewTab$lambda$77;
                    List ReviewTab$lambda$772;
                    float ReviewTab$lambda$713;
                    Intrinsics.checkNotNullParameter(change, "change");
                    change.consume();
                    MutableFloatState mutableFloatState5 = mutableFloatState4;
                    ReviewTab$lambda$71 = ReviewTabKt.ReviewTab$lambda$71(mutableFloatState5);
                    mutableFloatState5.setFloatValue(ReviewTab$lambda$71 + Offset.m3177getYimpl(j));
                    ReviewTab$lambda$712 = ReviewTabKt.ReviewTab$lambda$71(mutableFloatState4);
                    int i2 = (int) (ReviewTab$lambda$712 / 150.0f);
                    if (i2 != 0) {
                        ReviewTab$lambda$74 = ReviewTabKt.ReviewTab$lambda$74(mutableIntState4);
                        int i3 = ReviewTab$lambda$74 + i2;
                        if (i3 >= 0) {
                            ReviewTab$lambda$77 = ReviewTabKt.ReviewTab$lambda$77(state2);
                            if (i3 < ReviewTab$lambda$77.size()) {
                                ReviewTab$lambda$772 = ReviewTabKt.ReviewTab$lambda$77(state2);
                                AnkiDeck deck = ((DeckNode) ((Pair) ReviewTab$lambda$772.get(i3)).getFirst()).getDeck();
                                if (deck == null || deck.getId() == -1) {
                                    return;
                                }
                                List<AnkiDeck> list2 = list;
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                                Iterator<T> it = list2.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(Long.valueOf(((AnkiDeck) it.next()).getId()));
                                }
                                List<Long> mutableList = CollectionsKt.toMutableList((Collection) settingsRepository.getDeckOrderList());
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    long longValue = ((Number) it2.next()).longValue();
                                    if (!mutableList.contains(Long.valueOf(longValue))) {
                                        mutableList.add(Long.valueOf(longValue));
                                    }
                                }
                                int indexOf = mutableList.indexOf(Long.valueOf(ankiDeck2.getId()));
                                int indexOf2 = mutableList.indexOf(Long.valueOf(deck.getId()));
                                if (indexOf == -1 || indexOf2 == -1) {
                                    return;
                                }
                                long longValue2 = mutableList.get(indexOf).longValue();
                                mutableList.set(indexOf, mutableList.get(indexOf2));
                                mutableList.set(indexOf2, Long.valueOf(longValue2));
                                settingsRepository.setDeckOrderList(mutableList);
                                function03.invoke();
                                mutableIntState4.setIntValue(i3);
                                MutableFloatState mutableFloatState6 = mutableFloatState4;
                                ReviewTab$lambda$713 = ReviewTabKt.ReviewTab$lambda$71(mutableFloatState6);
                                mutableFloatState6.setFloatValue(ReviewTab$lambda$713 - (i2 * 150.0f));
                            }
                        }
                    }
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}

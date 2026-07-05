package com.example.flashcardapp.ui;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.AnkiDeck;
import com.example.flashcardapp.data.SettingsRepository;
import com.example.flashcardapp.session.McqSessionMode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReviewTab.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.ui.ReviewTabKt$ReviewTab$12", f = "ReviewTab.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class ReviewTabKt$ReviewTab$12 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Map<Long, McqSessionMode>> $deckModes$delegate;
    final /* synthetic */ List<AnkiDeck> $decks;
    final /* synthetic */ SettingsRepository $settingsRepo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewTabKt$ReviewTab$12(List<AnkiDeck> list, SettingsRepository settingsRepository, MutableState<Map<Long, McqSessionMode>> mutableState, Continuation<? super ReviewTabKt$ReviewTab$12> continuation) {
        super(2, continuation);
        this.$decks = list;
        this.$settingsRepo = settingsRepository;
        this.$deckModes$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReviewTabKt$ReviewTab$12(this.$decks, this.$settingsRepo, this.$deckModes$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ReviewTabKt$ReviewTab$12) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            MutableState<Map<Long, McqSessionMode>> mutableState = this.$deckModes$delegate;
            List<AnkiDeck> list = this.$decks;
            SettingsRepository settingsRepository = this.$settingsRepo;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
            for (AnkiDeck ankiDeck : list) {
                Pair pair = TuplesKt.to(Boxing.boxLong(ankiDeck.getId()), settingsRepository.getPreferredModeForDeck(ankiDeck.getId()));
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            mutableState.setValue(linkedHashMap);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

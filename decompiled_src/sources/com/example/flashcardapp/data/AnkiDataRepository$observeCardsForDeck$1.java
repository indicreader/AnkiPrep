package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.CardEntity;
import com.example.flashcardapp.data.entities.CardOverrideEntity;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnkiDataRepository.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/example/flashcardapp/data/entities/CardEntity;", "cards", "overrides", "Lcom/example/flashcardapp/data/entities/CardOverrideEntity;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.data.AnkiDataRepository$observeCardsForDeck$1", f = "AnkiDataRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class AnkiDataRepository$observeCardsForDeck$1 extends SuspendLambda implements Function3<List<? extends CardEntity>, List<? extends CardOverrideEntity>, Continuation<? super List<? extends CardEntity>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnkiDataRepository$observeCardsForDeck$1(Continuation<? super AnkiDataRepository$observeCardsForDeck$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(List<? extends CardEntity> list, List<? extends CardOverrideEntity> list2, Continuation<? super List<? extends CardEntity>> continuation) {
        return invoke2((List<CardEntity>) list, (List<CardOverrideEntity>) list2, (Continuation<? super List<CardEntity>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<CardEntity> list, List<CardOverrideEntity> list2, Continuation<? super List<CardEntity>> continuation) {
        AnkiDataRepository$observeCardsForDeck$1 ankiDataRepository$observeCardsForDeck$1 = new AnkiDataRepository$observeCardsForDeck$1(continuation);
        ankiDataRepository$observeCardsForDeck$1.L$0 = list;
        ankiDataRepository$observeCardsForDeck$1.L$1 = list2;
        return ankiDataRepository$observeCardsForDeck$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List list = (List) this.L$0;
            List list2 = (List) this.L$1;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
            for (Object obj2 : list2) {
                linkedHashMap.put(Boxing.boxLong(((CardOverrideEntity) obj2).getCardId()), obj2);
            }
            if (linkedHashMap.isEmpty()) {
                return list;
            }
            List<CardEntity> list3 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (CardEntity cardEntity : list3) {
                CardOverrideEntity cardOverrideEntity = (CardOverrideEntity) linkedHashMap.get(Boxing.boxLong(cardEntity.getId()));
                if (cardOverrideEntity != null) {
                    String frontOverride = cardOverrideEntity.getFrontOverride();
                    String backOverride = cardOverrideEntity.getBackOverride();
                    String tagsOverride = cardOverrideEntity.getTagsOverride();
                    if (tagsOverride == null) {
                        tagsOverride = cardEntity.getTags();
                    }
                    String str = tagsOverride;
                    String frontImageOverride = cardOverrideEntity.getFrontImageOverride();
                    if (frontImageOverride == null) {
                        frontImageOverride = cardEntity.getFrontImage();
                    }
                    String str2 = frontImageOverride;
                    String backImageOverride = cardOverrideEntity.getBackImageOverride();
                    if (backImageOverride == null) {
                        backImageOverride = cardEntity.getBackImage();
                    }
                    String str3 = backImageOverride;
                    String explanationImageOverride = cardOverrideEntity.getExplanationImageOverride();
                    if (explanationImageOverride == null) {
                        explanationImageOverride = cardEntity.getExplanationImage();
                    }
                    String str4 = explanationImageOverride;
                    String optionImagesOverrideJson = cardOverrideEntity.getOptionImagesOverrideJson();
                    if (optionImagesOverrideJson == null) {
                        optionImagesOverrideJson = cardEntity.getOptionImagesJson();
                    }
                    cardEntity = cardEntity.copy((r34 & 1) != 0 ? cardEntity.id : 0L, (r34 & 2) != 0 ? cardEntity.noteId : 0L, (r34 & 4) != 0 ? cardEntity.deckId : 0L, (r34 & 8) != 0 ? cardEntity.subDeckId : null, (r34 & 16) != 0 ? cardEntity.front : frontOverride, (r34 & 32) != 0 ? cardEntity.back : backOverride, (r34 & 64) != 0 ? cardEntity.tags : str, (r34 & 128) != 0 ? cardEntity.deckHierarchy : null, (r34 & 256) != 0 ? cardEntity.lastSyncTimestamp : 0L, (r34 & 512) != 0 ? cardEntity.frontImage : str2, (r34 & 1024) != 0 ? cardEntity.backImage : str3, (r34 & 2048) != 0 ? cardEntity.explanationImage : str4, (r34 & 4096) != 0 ? cardEntity.optionImagesJson : optionImagesOverrideJson);
                }
                arrayList.add(cardEntity);
            }
            return arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

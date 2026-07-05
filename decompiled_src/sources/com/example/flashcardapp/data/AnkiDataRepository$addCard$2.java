package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnkiDataRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.data.AnkiDataRepository$addCard$2", f = "AnkiDataRepository.kt", i = {1, 2, 3}, l = {615, 635, 639, 641}, m = "invokeSuspend", n = {"deckId", "id", "id"}, s = {"J$0", "J$0", "J$0"})
/* loaded from: classes2.dex */
public final class AnkiDataRepository$addCard$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ String $back;
    final /* synthetic */ String $backImage;
    final /* synthetic */ String $deckHierarchy;
    final /* synthetic */ String $explanationImage;
    final /* synthetic */ String $front;
    final /* synthetic */ String $frontImage;
    final /* synthetic */ String $optionImagesJson;
    final /* synthetic */ String $tagsJson;
    long J$0;
    int label;
    final /* synthetic */ AnkiDataRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnkiDataRepository$addCard$2(AnkiDataRepository ankiDataRepository, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Continuation<? super AnkiDataRepository$addCard$2> continuation) {
        super(2, continuation);
        this.this$0 = ankiDataRepository;
        this.$deckHierarchy = str;
        this.$front = str2;
        this.$back = str3;
        this.$tagsJson = str4;
        this.$frontImage = str5;
        this.$backImage = str6;
        this.$explanationImage = str7;
        this.$optionImagesJson = str8;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnkiDataRepository$addCard$2(this.this$0, this.$deckHierarchy, this.$front, this.$back, this.$tagsJson, this.$frontImage, this.$backImage, this.$explanationImage, this.$optionImagesJson, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
        return ((AnkiDataRepository$addCard$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0116 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r28) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.data.AnkiDataRepository$addCard$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

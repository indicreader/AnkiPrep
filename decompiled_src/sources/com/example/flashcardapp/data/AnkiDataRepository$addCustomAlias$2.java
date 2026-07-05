package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.entities.AliasEntity;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AnkiDataRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.data.AnkiDataRepository$addCustomAlias$2", f = "AnkiDataRepository.kt", i = {0, 0}, l = {782, 786}, m = "invokeSuspend", n = {"normName", "normAlias"}, s = {"L$0", "L$1"})
/* loaded from: classes2.dex */
final class AnkiDataRepository$addCustomAlias$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $alias;
    final /* synthetic */ String $name;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AnkiDataRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnkiDataRepository$addCustomAlias$2(String str, String str2, AnkiDataRepository ankiDataRepository, Continuation<? super AnkiDataRepository$addCustomAlias$2> continuation) {
        super(2, continuation);
        this.$name = str;
        this.$alias = str2;
        this.this$0 = ankiDataRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnkiDataRepository$addCustomAlias$2(this.$name, this.$alias, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((AnkiDataRepository$addCustomAlias$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String lowerCase;
        String lowerCase2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = false;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            lowerCase = StringsKt.trim((CharSequence) this.$name).toString().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            lowerCase2 = StringsKt.trim((CharSequence) this.$alias).toString().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (lowerCase.length() == 0 || lowerCase2.length() == 0) {
                return Boxing.boxBoolean(false);
            }
            this.L$0 = lowerCase;
            this.L$1 = lowerCase2;
            this.label = 1;
            obj = this.this$0.getAliasDao().exists(lowerCase, lowerCase2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(z);
            }
            lowerCase2 = (String) this.L$1;
            lowerCase = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (((Number) obj).intValue() > 0) {
            z = true;
        } else {
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (this.this$0.getAliasDao().insertAlias(new AliasEntity(lowerCase, lowerCase2), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Boxing.boxBoolean(z);
    }
}

package com.example.flashcardapp.ui;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.ImageStorageManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ImageWebSearchDialog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.ui.ImageWebSearchDialogKt$ImageWebSearchDialog$1$1$1$2$3$2$2$1$path$1", f = "ImageWebSearchDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class ImageWebSearchDialogKt$ImageWebSearchDialog$1$1$1$2$3$2$2$1$path$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $url;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageWebSearchDialogKt$ImageWebSearchDialog$1$1$1$2$3$2$2$1$path$1(Context context, String str, Continuation<? super ImageWebSearchDialogKt$ImageWebSearchDialog$1$1$1$2$3$2$2$1$path$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$url = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImageWebSearchDialogKt$ImageWebSearchDialog$1$1$1$2$3$2$2$1$path$1(this.$context, this.$url, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((ImageWebSearchDialogKt$ImageWebSearchDialog$1$1$1$2$3$2$2$1$path$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return ImageStorageManager.INSTANCE.downloadImageFromUrl(this.$context, this.$url);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

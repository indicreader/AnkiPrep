package com.example.flashcardapp;

import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.AnkiDataRepository;
import com.example.flashcardapp.data.AnkiDeck;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.MainActivityKt$MainLayout$exportApkgLauncher$1$1$1", f = "MainActivity.kt", i = {}, l = {845}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class MainActivityKt$MainLayout$exportApkgLauncher$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ AnkiDeck $deck;
    final /* synthetic */ Uri $fileUri;
    final /* synthetic */ AnkiDataRepository $repo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivityKt$MainLayout$exportApkgLauncher$1$1$1(Context context, AnkiDataRepository ankiDataRepository, AnkiDeck ankiDeck, Uri uri, Continuation<? super MainActivityKt$MainLayout$exportApkgLauncher$1$1$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$repo = ankiDataRepository;
        this.$deck = ankiDeck;
        this.$fileUri = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivityKt$MainLayout$exportApkgLauncher$1$1$1(this.$context, this.$repo, this.$deck, this.$fileUri, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivityKt$MainLayout$exportApkgLauncher$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Toast.makeText(this.$context, "Exporting deck...", 0).show();
            this.label = 1;
            obj = this.$repo.exportApkg(this.$deck.getId(), this.$deck.getName(), this.$fileUri, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            Toast.makeText(this.$context, "Exported successfully", 0).show();
        } else {
            Toast.makeText(this.$context, "Export failed", 0).show();
        }
        return Unit.INSTANCE;
    }
}

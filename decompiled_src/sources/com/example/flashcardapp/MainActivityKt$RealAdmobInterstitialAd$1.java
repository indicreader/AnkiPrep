package com.example.flashcardapp;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.example.flashcardapp.MainActivityKt$RealAdmobInterstitialAd$1", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class MainActivityKt$RealAdmobInterstitialAd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MainActivity $activity;
    final /* synthetic */ Function0<Unit> $onAdDismissed;
    final /* synthetic */ RewardedInterstitialAd $preloadedAd;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivityKt$RealAdmobInterstitialAd$1(RewardedInterstitialAd rewardedInterstitialAd, MainActivity mainActivity, Function0<Unit> function0, Continuation<? super MainActivityKt$RealAdmobInterstitialAd$1> continuation) {
        super(2, continuation);
        this.$preloadedAd = rewardedInterstitialAd;
        this.$activity = mainActivity;
        this.$onAdDismissed = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(RewardItem rewardItem) {
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivityKt$RealAdmobInterstitialAd$1(this.$preloadedAd, this.$activity, this.$onAdDismissed, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivityKt$RealAdmobInterstitialAd$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            RewardedInterstitialAd rewardedInterstitialAd = this.$preloadedAd;
            final MainActivity mainActivity = this.$activity;
            final Function0<Unit> function0 = this.$onAdDismissed;
            rewardedInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: com.example.flashcardapp.MainActivityKt$RealAdmobInterstitialAd$1.1
                @Override // com.google.android.gms.ads.FullScreenContentCallback
                public void onAdDismissedFullScreenContent() {
                    MainActivity.this.clearInterstitialAd();
                    MainActivity.this.loadInterstitialAd();
                    function0.invoke();
                }

                @Override // com.google.android.gms.ads.FullScreenContentCallback
                public void onAdFailedToShowFullScreenContent(AdError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    MainActivity.this.clearInterstitialAd();
                    MainActivity.this.loadInterstitialAd();
                    function0.invoke();
                }
            });
            MainActivity mainActivity2 = this.$activity;
            if (mainActivity2 != null) {
                this.$preloadedAd.show(mainActivity2, new OnUserEarnedRewardListener() { // from class: com.example.flashcardapp.MainActivityKt$RealAdmobInterstitialAd$1$$ExternalSyntheticLambda0
                    @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
                    public final void onUserEarnedReward(RewardItem rewardItem) {
                        MainActivityKt$RealAdmobInterstitialAd$1.invokeSuspend$lambda$0(rewardItem);
                    }
                });
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

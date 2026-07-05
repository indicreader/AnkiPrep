package com.example.flashcardapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.flashcardapp.data.SettingsRepository;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014J\u0006\u0010\u000b\u001a\u00020\bJ\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010\u0010\u001a\u00020\bJ\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/example/flashcardapp/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "isAdLoading", "", "mInterstitialAd", "Lcom/google/android/gms/ads/rewardedinterstitial/RewardedInterstitialAd;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "clearInterstitialAd", "getInterstitialAd", "handleIntent", "intent", "Landroid/content/Intent;", "loadInterstitialAd", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class MainActivity extends ComponentActivity {
    public static final int $stable = 8;
    private boolean isAdLoading;
    private RewardedInterstitialAd mInterstitialAd;

    public final void clearInterstitialAd() {
        this.mInterstitialAd = null;
    }

    /* renamed from: getInterstitialAd, reason: from getter */
    public final RewardedInterstitialAd getMInterstitialAd() {
        return this.mInterstitialAd;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context newBase) {
        Intrinsics.checkNotNullParameter(newBase, "newBase");
        super.attachBaseContext(LocaleContextWrapper.INSTANCE.wrap(newBase, SettingsRepository.INSTANCE.getInstance(newBase).getAppLanguage()));
    }

    public final void loadInterstitialAd() {
        MainActivity mainActivity = this;
        if (SettingsRepository.INSTANCE.getInstance(mainActivity).isPremium() || this.mInterstitialAd != null || this.isAdLoading) {
            return;
        }
        this.isAdLoading = true;
        AdRequest build = new AdRequest.Builder().build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        RewardedInterstitialAd.load(mainActivity, MainActivityKt.ADMOB_INTERSTITIAL_AD_UNIT_ID, build, new RewardedInterstitialAdLoadCallback() { // from class: com.example.flashcardapp.MainActivity$loadInterstitialAd$1
            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(RewardedInterstitialAd rewardedInterstitialAd) {
                Intrinsics.checkNotNullParameter(rewardedInterstitialAd, "rewardedInterstitialAd");
                MainActivity.this.mInterstitialAd = rewardedInterstitialAd;
                MainActivity.this.isAdLoading = false;
                Log.d("AdMob", "Rewarded Interstitial Ad loaded successfully.");
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                Intrinsics.checkNotNullParameter(loadAdError, "loadAdError");
                Log.e("AdMob", "Rewarded Interstitial Ad failed to load: " + loadAdError.getMessage());
                MainActivity.this.mInterstitialAd = null;
                MainActivity.this.isAdLoading = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MobileAds.initialize(this, new OnInitializationCompleteListener() { // from class: com.example.flashcardapp.MainActivity$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.ads.initialization.OnInitializationCompleteListener
            public final void onInitializationComplete(InitializationStatus initializationStatus) {
                MainActivity.onCreate$lambda$0(MainActivity.this, initializationStatus);
            }
        });
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        handleIntent(intent);
        ComponentActivityKt.setContent$default(this, null, ComposableSingletons$MainActivityKt.INSTANCE.m6099getLambda1$app_release(), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(MainActivity this$0, InitializationStatus it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.loadInterstitialAd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            handleIntent(intent);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003b, code lost:
    
        if (r1 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void handleIntent(android.content.Intent r11) {
        /*
            r10 = this;
            java.lang.String r0 = r11.getAction()
            java.lang.String r1 = "android.intent.action.VIEW"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            r2 = 0
            if (r1 == 0) goto L12
            android.net.Uri r0 = r11.getData()
            goto L24
        L12:
            java.lang.String r1 = "android.intent.action.SEND"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L23
            java.lang.String r0 = "android.intent.extra.STREAM"
            android.os.Parcelable r0 = r11.getParcelableExtra(r0)
            android.net.Uri r0 = (android.net.Uri) r0
            goto L24
        L23:
            r0 = r2
        L24:
            if (r0 != 0) goto L27
            return
        L27:
            java.lang.String r1 = r0.getPath()
            java.lang.String r3 = "toLowerCase(...)"
            java.lang.String r4 = ""
            if (r1 == 0) goto L3d
            java.util.Locale r5 = java.util.Locale.ROOT
            java.lang.String r1 = r1.toLowerCase(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            if (r1 != 0) goto L3e
        L3d:
            r1 = r4
        L3e:
            java.lang.String r11 = r11.getType()
            if (r11 == 0) goto L51
            java.util.Locale r5 = java.util.Locale.ROOT
            java.lang.String r11 = r11.toLowerCase(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r3)
            if (r11 != 0) goto L50
            goto L51
        L50:
            r4 = r11
        L51:
            java.lang.String r11 = ".csv"
            r3 = 0
            r5 = 2
            boolean r11 = kotlin.text.StringsKt.endsWith$default(r1, r11, r3, r5, r2)
            if (r11 != 0) goto L7a
            r11 = r4
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            java.lang.String r1 = "csv"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r11 = kotlin.text.StringsKt.contains$default(r11, r1, r3, r5, r2)
            if (r11 != 0) goto L7a
            java.lang.String r11 = "text/plain"
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r11)
            if (r11 != 0) goto L7a
            java.lang.String r11 = "text/comma-separated-values"
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r11)
            if (r11 == 0) goto L7b
        L7a:
            r3 = 1
        L7b:
            r11 = r10
            androidx.lifecycle.LifecycleOwner r11 = (androidx.lifecycle.LifecycleOwner) r11
            androidx.lifecycle.LifecycleCoroutineScope r11 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r11)
            r4 = r11
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            r5 = 0
            r6 = 0
            com.example.flashcardapp.MainActivity$handleIntent$1 r11 = new com.example.flashcardapp.MainActivity$handleIntent$1
            r11.<init>(r10, r3, r0, r2)
            r7 = r11
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r8 = 3
            r9 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flashcardapp.MainActivity.handleIntent(android.content.Intent):void");
    }
}

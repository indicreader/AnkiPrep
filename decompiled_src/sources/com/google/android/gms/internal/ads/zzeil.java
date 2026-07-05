package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeil {
    private final Context zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeil(Context context) {
        this.zza = context;
    }

    public final ListenableFuture zza(boolean z) {
        GetTopicsRequest build = new GetTopicsRequest.Builder().setAdsSdkName(MobileAds.ERROR_DOMAIN).setShouldRecordObservation(z).build();
        TopicsManagerFutures from = TopicsManagerFutures.from(this.zza);
        if (from != null) {
            return from.getTopicsAsync(build);
        }
        return zzgen.zzg(new IllegalStateException());
    }
}

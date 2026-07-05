package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeij {
    private MeasurementManagerFutures zza;
    private final Context zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeij(Context context) {
        this.zzb = context;
    }

    public final ListenableFuture zza() {
        MeasurementManagerFutures from = MeasurementManagerFutures.from(this.zzb);
        this.zza = from;
        if (from == null) {
            return zzgen.zzg(new IllegalStateException("MeasurementManagerFutures is null"));
        }
        return from.getMeasurementApiStatusAsync();
    }

    public final ListenableFuture zzb(Uri uri, InputEvent inputEvent) {
        return ((MeasurementManagerFutures) Objects.requireNonNull(this.zza)).registerSourceAsync(uri, inputEvent);
    }
}

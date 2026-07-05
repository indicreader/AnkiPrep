package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcdb implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzceu zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcdb(zzcdc zzcdcVar, Context context, zzceu zzceuVar) {
        this.zza = context;
        this.zzb = zzceuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzb.zzc(AdvertisingIdClient.getAdvertisingIdInfo(this.zza));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            this.zzb.zzd(e);
            zzcec.zzh("Exception while getting advertising Id info", e);
        }
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcbv {
    private final Clock zza;
    private final com.google.android.gms.ads.internal.util.zzg zzb;
    private final zzcch zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcbv(Clock clock, com.google.android.gms.ads.internal.util.zzg zzgVar, zzcch zzcchVar) {
        this.zza = clock;
        this.zzb = zzgVar;
        this.zzc = zzcchVar;
    }

    public final void zza(int i, long j) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzap)).booleanValue()) {
            return;
        }
        if (j - this.zzb.zzf() < 0) {
            com.google.android.gms.ads.internal.util.zze.zza("Receiving npa decision in the past, ignoring.");
            return;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaq)).booleanValue()) {
            this.zzb.zzL(-1);
            this.zzb.zzM(j);
        } else {
            this.zzb.zzL(i);
            this.zzb.zzM(j);
        }
    }
}

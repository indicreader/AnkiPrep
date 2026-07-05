package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdError;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzeny implements zzdcg {
    boolean zza = false;
    final /* synthetic */ zzeiq zzb;
    final /* synthetic */ zzceu zzc;
    final /* synthetic */ zzenz zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeny(zzenz zzenzVar, zzeiq zzeiqVar, zzceu zzceuVar) {
        this.zzb = zzeiqVar;
        this.zzc = zzceuVar;
        this.zzd = zzenzVar;
    }

    private final synchronized void zze(com.google.android.gms.ads.internal.client.zze zzeVar) {
        int i = 1;
        if (true == ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfs)).booleanValue()) {
            i = 3;
        }
        this.zzc.zzd(new zzeir(i, zzeVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdcg
    public final synchronized void zza(int i) {
        if (this.zza) {
            return;
        }
        this.zza = true;
        zze(new com.google.android.gms.ads.internal.client.zze(i, zzenz.zze(this.zzb.zza, i), AdError.UNDEFINED_DOMAIN, null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzdcg
    public final synchronized void zzb(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (this.zza) {
            return;
        }
        this.zza = true;
        zze(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdcg
    public final synchronized void zzc(int i, String str) {
        if (this.zza) {
            return;
        }
        this.zza = true;
        if (str == null) {
            str = zzenz.zze(this.zzb.zza, i);
        }
        zze(new com.google.android.gms.ads.internal.client.zze(i, str, AdError.UNDEFINED_DOMAIN, null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzdcg
    public final synchronized void zzd() {
        this.zzc.zzc(null);
    }
}

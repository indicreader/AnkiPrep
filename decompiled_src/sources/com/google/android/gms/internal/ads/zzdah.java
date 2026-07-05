package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdah {
    private final Context zza;
    private final zzfhh zzb;
    private final Bundle zzc;
    private final zzfgz zzd;
    private final zzczz zze;
    private final zzeis zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdah(zzdaf zzdafVar, zzdag zzdagVar) {
        this.zza = zzdaf.zza(zzdafVar);
        this.zzb = zzdaf.zzm(zzdafVar);
        this.zzc = zzdaf.zzb(zzdafVar);
        this.zzd = zzdaf.zzl(zzdafVar);
        this.zze = zzdaf.zzc(zzdafVar);
        this.zzf = zzdaf.zzk(zzdafVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context zza(Context context) {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zzb() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzczz zzc() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzdaf zzd() {
        zzdaf zzdafVar = new zzdaf();
        zzdafVar.zze(this.zza);
        zzdafVar.zzi(this.zzb);
        zzdafVar.zzf(this.zzc);
        zzdafVar.zzg(this.zze);
        zzdafVar.zzd(this.zzf);
        return zzdafVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzeis zze(String str) {
        zzeis zzeisVar = this.zzf;
        return zzeisVar != null ? zzeisVar : new zzeis(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzfgz zzf() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzfhh zzg() {
        return this.zzb;
    }
}

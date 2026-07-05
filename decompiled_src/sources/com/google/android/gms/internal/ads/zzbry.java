package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbry implements zzcey {
    final /* synthetic */ zzbrd zza;
    final /* synthetic */ Object zzb;
    final /* synthetic */ zzceu zzc;
    final /* synthetic */ zzbsb zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbry(zzbsb zzbsbVar, zzbrd zzbrdVar, Object obj, zzceu zzceuVar) {
        this.zza = zzbrdVar;
        this.zzb = obj;
        this.zzc = zzceuVar;
        this.zzd = zzbsbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcey
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        com.google.android.gms.ads.internal.util.zze.zza("callJs > getEngine: Promise fulfilled");
        Object obj2 = this.zzb;
        zzceu zzceuVar = this.zzc;
        zzbsb.zzd(this.zzd, this.zza, (zzbrk) obj, obj2, zzceuVar);
    }
}

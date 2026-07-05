package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcya implements zzhhd {
    private final zzhhu zza;

    public zzcya(zzhhu zzhhuVar) {
        this.zza = zzhhuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgaf zzn;
        zzcym zzcymVar = (zzcym) this.zza.zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfC)).booleanValue()) {
            zzn = zzgaf.zzo(new zzdim(zzcymVar, zzcep.zzf));
        } else {
            zzn = zzgaf.zzn();
        }
        zzhhl.zzb(zzn);
        return zzn;
    }
}

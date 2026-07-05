package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcze implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;

    public zzcze(zzhhu zzhhuVar, zzhhu zzhhuVar2) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgaf zzn;
        zzcyk zzcykVar = (zzcyk) this.zza.zzb();
        zzgey zzgeyVar = zzcep.zza;
        zzhhl.zzb(zzgeyVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfC)).booleanValue()) {
            zzn = zzgaf.zzo(new zzdim(zzcykVar, zzgeyVar));
        } else {
            zzn = zzgaf.zzn();
        }
        zzhhl.zzb(zzn);
        return zzn;
    }
}

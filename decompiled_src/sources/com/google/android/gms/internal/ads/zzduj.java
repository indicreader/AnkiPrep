package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzduj implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;
    private final zzhhu zzc;
    private final zzhhu zzd;
    private final zzhhu zze;

    public zzduj(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3, zzhhu zzhhuVar4, zzhhu zzhhuVar5) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
        this.zzc = zzhhuVar3;
        this.zzd = zzhhuVar4;
        this.zze = zzhhuVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza = ((zzclm) this.zza).zza();
        final String zzb = ((zzeau) this.zzb).zzb();
        zzcei zza2 = ((zzcly) this.zzc).zza();
        final zzbbz zzbbzVar = (zzbbz) this.zzd.zzb();
        final String str = (String) this.zze.zzb();
        zzbbp zzbbpVar = new zzbbp(new zzbbv(zza));
        zzbeo zza3 = zzbep.zza();
        zza3.zza(zza2.zzb);
        zza3.zzc(zza2.zzc);
        zza3.zzb(true != zza2.zzd ? 2 : 0);
        final zzbep zzbepVar = (zzbep) zza3.zzal();
        zzbbpVar.zzb(new zzbbo() { // from class: com.google.android.gms.internal.ads.zzdui
            @Override // com.google.android.gms.internal.ads.zzbbo
            public final void zza(zzbde zzbdeVar) {
                zzbca zzbcaVar = (zzbca) zzbdeVar.zza().zzaB();
                zzbcaVar.zza(zzbbz.this);
                zzbdeVar.zze(zzbcaVar);
                zzbcw zzbcwVar = (zzbcw) zzbdeVar.zzb().zzaB();
                zzbcwVar.zza(zzb);
                zzbcwVar.zzb(zzbepVar);
                zzbdeVar.zzg(zzbcwVar);
                zzbdeVar.zzh(str);
            }
        });
        return zzbbpVar;
    }
}

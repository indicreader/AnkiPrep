package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdat implements zzhhd {
    private final zzdas zza;
    private final zzhhu zzb;
    private final zzhhu zzc;
    private final zzhhu zzd;
    private final zzhhu zze;

    public zzdat(zzdas zzdasVar, zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3, zzhhu zzhhuVar4) {
        this.zza = zzdasVar;
        this.zzb = zzhhuVar;
        this.zzc = zzhhuVar2;
        this.zzd = zzhhuVar3;
        this.zze = zzhhuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* synthetic */ Object zzb() {
        Context context = (Context) this.zzb.zzb();
        zzcei zza = ((zzcly) this.zzc).zza();
        zzfgm zza2 = ((zzcwy) this.zzd).zza();
        zzcbo zzcboVar = new zzcbo();
        zzcbp zzcbpVar = zza2.zzB;
        if (zzcbpVar == null) {
            return null;
        }
        zzfgr zzfgrVar = zza2.zzt;
        return new zzcbn(context, zza, zzcbpVar, zzfgrVar == null ? null : zzfgrVar.zzb, zzcboVar);
    }
}

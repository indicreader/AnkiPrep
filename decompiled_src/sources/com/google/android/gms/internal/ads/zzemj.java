package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzemj {
    private final zzfhz zza;
    private final zzdtx zzb;
    private final zzdwf zzc;
    private final zzflw zzd;

    public zzemj(zzfhz zzfhzVar, zzdtx zzdtxVar, zzdwf zzdwfVar, zzflw zzflwVar) {
        this.zza = zzfhzVar;
        this.zzb = zzdtxVar;
        this.zzc = zzdwfVar;
        this.zzd = zzflwVar;
    }

    public final void zza(zzfgp zzfgpVar, zzfgm zzfgmVar, int i, @Nullable zzeir zzeirVar, long j) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziz)).booleanValue()) {
            zzdwe zza = this.zzc.zza();
            zza.zze(zzfgpVar);
            zza.zzd(zzfgmVar);
            zza.zzb("action", "adapter_status");
            zza.zzb("adapter_l", String.valueOf(j));
            zza.zzb("sc", Integer.toString(i));
            if (zzeirVar != null) {
                zza.zzb("arec", Integer.toString(zzeirVar.zzb().zza));
                String zza2 = this.zza.zza(zzeirVar.getMessage());
                if (zza2 != null) {
                    zza.zzb("areec", zza2);
                }
            }
            zzdtw zzb = this.zzb.zzb(zzfgmVar.zzu);
            if (zzb != null) {
                zza.zzb("ancn", zzb.zza);
                zzbvg zzbvgVar = zzb.zzb;
                if (zzbvgVar != null) {
                    zza.zzb("adapter_v", zzbvgVar.toString());
                }
                zzbvg zzbvgVar2 = zzb.zzc;
                if (zzbvgVar2 != null) {
                    zza.zzb("adapter_sv", zzbvgVar2.toString());
                }
            }
            zza.zzg();
            return;
        }
        zzflv zzb2 = zzflv.zzb("adapter_status");
        zzb2.zzg(zzfgpVar);
        zzb2.zzf(zzfgmVar);
        zzb2.zza("adapter_l", String.valueOf(j));
        zzb2.zza("sc", Integer.toString(i));
        if (zzeirVar != null) {
            zzb2.zza("arec", Integer.toString(zzeirVar.zzb().zza));
            String zza3 = this.zza.zza(zzeirVar.getMessage());
            if (zza3 != null) {
                zzb2.zza("areec", zza3);
            }
        }
        zzdtw zzb3 = this.zzb.zzb(zzfgmVar.zzu);
        if (zzb3 != null) {
            zzb2.zza("ancn", zzb3.zza);
            zzbvg zzbvgVar3 = zzb3.zzb;
            if (zzbvgVar3 != null) {
                zzb2.zza("adapter_v", zzbvgVar3.toString());
            }
            zzbvg zzbvgVar4 = zzb3.zzc;
            if (zzbvgVar4 != null) {
                zzb2.zza("adapter_sv", zzbvgVar4.toString());
            }
        }
        this.zzd.zzb(zzb2);
    }
}

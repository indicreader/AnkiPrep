package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcvu implements zzdcl, zzdbr {
    private final Context zza;
    private final zzcjk zzb;
    private final zzfgm zzc;
    private final zzcei zzd;
    private zzfod zze;
    private boolean zzf;

    public zzcvu(Context context, zzcjk zzcjkVar, zzfgm zzfgmVar, zzcei zzceiVar) {
        this.zza = context;
        this.zzb = zzcjkVar;
        this.zzc = zzfgmVar;
        this.zzd = zzceiVar;
    }

    private final synchronized void zza() {
        zzeii zzeiiVar;
        zzeii zzeiiVar2;
        zzeih zzeihVar;
        if (this.zzc.zzU && this.zzb != null) {
            if (com.google.android.gms.ads.internal.zzt.zzA().zzj(this.zza)) {
                zzcei zzceiVar = this.zzd;
                String str = zzceiVar.zzb + "." + zzceiVar.zzc;
                zzfhk zzfhkVar = this.zzc.zzW;
                String zza = zzfhkVar.zza();
                if (zzfhkVar.zzb() == 1) {
                    zzeihVar = zzeih.VIDEO;
                    zzeiiVar2 = zzeii.DEFINED_BY_JAVASCRIPT;
                } else {
                    zzfgm zzfgmVar = this.zzc;
                    zzeih zzeihVar2 = zzeih.HTML_DISPLAY;
                    if (zzfgmVar.zzf == 1) {
                        zzeiiVar = zzeii.ONE_PIXEL;
                    } else {
                        zzeiiVar = zzeii.BEGIN_TO_RENDER;
                    }
                    zzeiiVar2 = zzeiiVar;
                    zzeihVar = zzeihVar2;
                }
                zzfod zza2 = com.google.android.gms.ads.internal.zzt.zzA().zza(str, this.zzb.zzG(), "", "javascript", zza, zzeiiVar2, zzeihVar, this.zzc.zzam);
                this.zze = zza2;
                Object obj = this.zzb;
                if (zza2 != null) {
                    com.google.android.gms.ads.internal.zzt.zzA().zzh(this.zze, (View) obj);
                    this.zzb.zzaq(this.zze);
                    com.google.android.gms.ads.internal.zzt.zzA().zzi(this.zze);
                    this.zzf = true;
                    this.zzb.zzd("onSdkLoaded", new ArrayMap());
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbr
    public final synchronized void zzq() {
        zzcjk zzcjkVar;
        if (!this.zzf) {
            zza();
        }
        if (!this.zzc.zzU || this.zze == null || (zzcjkVar = this.zzb) == null) {
            return;
        }
        zzcjkVar.zzd("onSdkImpression", new ArrayMap());
    }

    @Override // com.google.android.gms.internal.ads.zzdcl
    public final synchronized void zzr() {
        if (this.zzf) {
            return;
        }
        zza();
    }
}

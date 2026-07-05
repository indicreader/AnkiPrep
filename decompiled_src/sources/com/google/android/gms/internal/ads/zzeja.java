package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzeja implements zzdkw {
    private final zzcei zza;
    private final ListenableFuture zzb;
    private final zzfgm zzc;
    private final zzcjk zzd;
    private final zzfhh zze;
    private final zzbni zzf;
    private final boolean zzg;
    private final zzehs zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeja(zzcei zzceiVar, ListenableFuture listenableFuture, zzfgm zzfgmVar, zzcjk zzcjkVar, zzfhh zzfhhVar, boolean z, zzbni zzbniVar, zzehs zzehsVar) {
        this.zza = zzceiVar;
        this.zzb = listenableFuture;
        this.zzc = zzfgmVar;
        this.zzd = zzcjkVar;
        this.zze = zzfhhVar;
        this.zzg = z;
        this.zzf = zzbniVar;
        this.zzh = zzehsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdkw
    public final void zza(boolean z, Context context, zzdbk zzdbkVar) {
        zzctq zzctqVar = (zzctq) zzgen.zzq(this.zzb);
        this.zzd.zzao(true);
        boolean zze = this.zzg ? this.zzf.zze(true) : true;
        boolean z2 = this.zzg;
        com.google.android.gms.ads.internal.zzj zzjVar = new com.google.android.gms.ads.internal.zzj(zze, true, z2 ? this.zzf.zzd() : false, z2 ? this.zzf.zza() : 0.0f, -1, z, this.zzc.zzP, false);
        if (zzdbkVar != null) {
            zzdbkVar.zzf();
        }
        com.google.android.gms.ads.internal.zzt.zzi();
        zzdkl zzg = zzctqVar.zzg();
        zzcjk zzcjkVar = this.zzd;
        int i = this.zzc.zzR;
        if (i == -1) {
            com.google.android.gms.ads.internal.client.zzw zzwVar = this.zze.zzj;
            if (zzwVar != null) {
                int i2 = zzwVar.zza;
                if (i2 == 1) {
                    i = 7;
                } else if (i2 == 2) {
                    i = 6;
                }
            }
            zzcec.zze("Error setting app open orientation; no targeting orientation available.");
            i = this.zzc.zzR;
        }
        int i3 = i;
        zzcei zzceiVar = this.zza;
        zzfgm zzfgmVar = this.zzc;
        String str = zzfgmVar.zzC;
        zzfgr zzfgrVar = zzfgmVar.zzt;
        com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel((com.google.android.gms.ads.internal.client.zza) null, zzg, (com.google.android.gms.ads.internal.overlay.zzaa) null, zzcjkVar, i3, zzceiVar, str, zzjVar, zzfgrVar.zzb, zzfgrVar.zza, this.zze.zzf, zzdbkVar, zzfgmVar.zzaj ? this.zzh : null), true);
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzekp implements zzdkw {
    private final Context zza;
    private final zzcei zzb;
    private final ListenableFuture zzc;
    private final zzfgm zzd;
    private final zzcjk zze;
    private final zzfhh zzf;
    private final zzbni zzg;
    private final boolean zzh;
    private final zzehs zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzekp(Context context, zzcei zzceiVar, ListenableFuture listenableFuture, zzfgm zzfgmVar, zzcjk zzcjkVar, zzfhh zzfhhVar, boolean z, zzbni zzbniVar, zzehs zzehsVar) {
        this.zza = context;
        this.zzb = zzceiVar;
        this.zzc = listenableFuture;
        this.zzd = zzfgmVar;
        this.zze = zzcjkVar;
        this.zzf = zzfhhVar;
        this.zzg = zzbniVar;
        this.zzh = z;
        this.zzi = zzehsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdkw
    public final void zza(boolean z, Context context, zzdbk zzdbkVar) {
        zzdjo zzdjoVar = (zzdjo) zzgen.zzq(this.zzc);
        this.zze.zzao(true);
        boolean zze = this.zzh ? this.zzg.zze(false) : false;
        com.google.android.gms.ads.internal.zzt.zzp();
        com.google.android.gms.ads.internal.zzj zzjVar = new com.google.android.gms.ads.internal.zzj(zze, com.google.android.gms.ads.internal.util.zzt.zzH(this.zza), this.zzh ? this.zzg.zzd() : false, this.zzh ? this.zzg.zza() : 0.0f, -1, z, this.zzd.zzP, false);
        if (zzdbkVar != null) {
            zzdbkVar.zzf();
        }
        com.google.android.gms.ads.internal.zzt.zzi();
        zzdkl zzh = zzdjoVar.zzh();
        zzcjk zzcjkVar = this.zze;
        zzfgm zzfgmVar = this.zzd;
        zzcei zzceiVar = this.zzb;
        int i = zzfgmVar.zzR;
        String str = zzfgmVar.zzC;
        zzfgr zzfgrVar = zzfgmVar.zzt;
        com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel((com.google.android.gms.ads.internal.client.zza) null, zzh, (com.google.android.gms.ads.internal.overlay.zzaa) null, zzcjkVar, i, zzceiVar, str, zzjVar, zzfgrVar.zzb, zzfgrVar.zza, this.zzf.zzf, zzdbkVar, zzfgmVar.zzaj ? this.zzi : null), true);
    }
}

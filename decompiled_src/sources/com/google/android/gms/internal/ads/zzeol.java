package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeol implements zzein {
    private final zzbha zza;
    private final zzgey zzb;
    private final zzflm zzc;
    private final zzeou zzd;

    public zzeol(zzflm zzflmVar, zzgey zzgeyVar, zzbha zzbhaVar, zzeou zzeouVar) {
        this.zzc = zzflmVar;
        this.zzb = zzgeyVar;
        this.zza = zzbhaVar;
        this.zzd = zzeouVar;
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final ListenableFuture zza(zzfgy zzfgyVar, zzfgm zzfgmVar) {
        zzceu zzceuVar = new zzceu();
        zzeoq zzeoqVar = new zzeoq();
        zzeoqVar.zzd(new zzeok(this, zzceuVar, zzfgyVar, zzfgmVar, zzeoqVar));
        zzfgr zzfgrVar = zzfgmVar.zzt;
        final zzbgv zzbgvVar = new zzbgv(zzeoqVar, zzfgrVar.zzb, zzfgrVar.zza);
        zzflg zzflgVar = zzflg.CUSTOM_RENDER_SYN;
        return zzfkw.zzd(new zzfkq() { // from class: com.google.android.gms.internal.ads.zzeoj
            @Override // com.google.android.gms.internal.ads.zzfkq
            public final void zza() {
                zzeol.this.zzc(zzbgvVar);
            }
        }, this.zzb, zzflgVar, this.zzc).zzb(zzflg.CUSTOM_RENDER_ACK).zzd(zzceuVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final boolean zzb(zzfgy zzfgyVar, zzfgm zzfgmVar) {
        zzfgr zzfgrVar;
        return (this.zza == null || (zzfgrVar = zzfgmVar.zzt) == null || zzfgrVar.zza == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbgv zzbgvVar) throws Exception {
        this.zza.zze(zzbgvVar);
    }
}

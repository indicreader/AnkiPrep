package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeog implements zzein {
    private final Context zza;
    private final zzcvc zzb;
    private final zzbha zzc;
    private final zzgey zzd;
    private final zzflm zze;

    public zzeog(Context context, zzcvc zzcvcVar, zzflm zzflmVar, zzgey zzgeyVar, zzbha zzbhaVar) {
        this.zza = context;
        this.zzb = zzcvcVar;
        this.zze = zzflmVar;
        this.zzd = zzgeyVar;
        this.zzc = zzbhaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final ListenableFuture zza(zzfgy zzfgyVar, zzfgm zzfgmVar) {
        zzeoe zzeoeVar = new zzeoe(this, new View(this.zza), null, new zzcwf() { // from class: com.google.android.gms.internal.ads.zzeoc
            @Override // com.google.android.gms.internal.ads.zzcwf
            public final com.google.android.gms.ads.internal.client.zzdq zza() {
                return null;
            }
        }, (zzfgn) zzfgmVar.zzv.get(0));
        zzcug zza = this.zzb.zza(new zzcwx(zzfgyVar, zzfgmVar, null), zzeoeVar);
        zzeof zzk = zza.zzk();
        zzfgr zzfgrVar = zzfgmVar.zzt;
        final zzbgv zzbgvVar = new zzbgv(zzk, zzfgrVar.zzb, zzfgrVar.zza);
        zzflg zzflgVar = zzflg.CUSTOM_RENDER_SYN;
        return zzfkw.zzd(new zzfkq() { // from class: com.google.android.gms.internal.ads.zzeod
            @Override // com.google.android.gms.internal.ads.zzfkq
            public final void zza() {
                zzeog.this.zzc(zzbgvVar);
            }
        }, this.zzd, zzflgVar, this.zze).zzb(zzflg.CUSTOM_RENDER_ACK).zzd(zzgen.zzh(zza.zza())).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final boolean zzb(zzfgy zzfgyVar, zzfgm zzfgmVar) {
        zzfgr zzfgrVar;
        return (this.zzc == null || (zzfgrVar = zzfgmVar.zzt) == null || zzfgrVar.zza == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbgv zzbgvVar) throws Exception {
        this.zzc.zze(zzbgvVar);
    }
}

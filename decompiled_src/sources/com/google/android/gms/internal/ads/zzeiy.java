package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeiy implements zzein {
    private final zzctt zza;
    private final Context zzb;
    private final zzdtk zzc;
    private final zzfhh zzd;
    private final Executor zze;
    private final zzcei zzf;
    private final zzbni zzg;
    private final boolean zzh = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziM)).booleanValue();
    private final zzehs zzi;

    public zzeiy(zzctt zzcttVar, Context context, Executor executor, zzdtk zzdtkVar, zzfhh zzfhhVar, zzcei zzceiVar, zzbni zzbniVar, zzehs zzehsVar) {
        this.zzb = context;
        this.zza = zzcttVar;
        this.zze = executor;
        this.zzc = zzdtkVar;
        this.zzd = zzfhhVar;
        this.zzf = zzceiVar;
        this.zzg = zzbniVar;
        this.zzi = zzehsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final ListenableFuture zza(final zzfgy zzfgyVar, final zzfgm zzfgmVar) {
        final zzdto zzdtoVar = new zzdto();
        ListenableFuture zzn = zzgen.zzn(zzgen.zzh(null), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeiu
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzeiy.this.zzc(zzfgmVar, zzfgyVar, zzdtoVar, obj);
            }
        }, this.zze);
        Objects.requireNonNull(zzdtoVar);
        zzn.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeiv
            @Override // java.lang.Runnable
            public final void run() {
                zzdto.this.zzb();
            }
        }, this.zze);
        return zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final boolean zzb(zzfgy zzfgyVar, zzfgm zzfgmVar) {
        zzfgr zzfgrVar = zzfgmVar.zzt;
        return (zzfgrVar == null || zzfgrVar.zza == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ ListenableFuture zzc(final zzfgm zzfgmVar, zzfgy zzfgyVar, zzdto zzdtoVar, Object obj) throws Exception {
        final zzcjk zza = this.zzc.zza(this.zzd.zze, zzfgmVar, zzfgyVar.zzb.zzb);
        zza.zzaa(zzfgmVar.zzX);
        zzdtoVar.zza(this.zzb, (View) zza);
        zzceu zzceuVar = new zzceu();
        final zzctq zza2 = this.zza.zza(new zzcwx(zzfgyVar, zzfgmVar, null), new zzdjr(new zzeja(this.zzf, zzceuVar, zzfgmVar, zza, this.zzd, this.zzh, this.zzg, this.zzi), zza), new zzctr(zzfgmVar.zzab));
        zza2.zzh().zzi(zza, false, this.zzh ? this.zzg : null);
        zzceuVar.zzc(zza2);
        zza2.zzc().zzo(new zzdbr() { // from class: com.google.android.gms.internal.ads.zzeiw
            @Override // com.google.android.gms.internal.ads.zzdbr
            public final void zzq() {
                zzcjk zzcjkVar = zzcjk.this;
                if (zzcjkVar.zzN() != null) {
                    zzcjkVar.zzN().zzr();
                }
            }
        }, zzcep.zzf);
        zza2.zzh();
        zzfgr zzfgrVar = zzfgmVar.zzt;
        return zzgen.zzm(zzdtj.zzj(zza, zzfgrVar.zzb, zzfgrVar.zza), new zzfws() { // from class: com.google.android.gms.internal.ads.zzeix
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj2) {
                zzcjk zzcjkVar = zza;
                if (zzfgmVar.zzN) {
                    zzcjkVar.zzaf();
                }
                zzctq zzctqVar = zza2;
                zzcjkVar.zzZ();
                zzcjkVar.onPause();
                return zzctqVar.zza();
            }
        }, this.zze);
    }
}

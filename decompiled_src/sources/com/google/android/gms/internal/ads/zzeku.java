package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeku implements zzeit {
    private final Context zza;
    private final zzdko zzb;
    private final zzcei zzc;
    private final Executor zzd;

    public zzeku(Context context, zzcei zzceiVar, zzdko zzdkoVar, Executor executor) {
        this.zza = context;
        this.zzc = zzceiVar;
        this.zzb = zzdkoVar;
        this.zzd = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final /* bridge */ /* synthetic */ Object zza(zzfgy zzfgyVar, zzfgm zzfgmVar, final zzeiq zzeiqVar) throws zzfho, zzeml {
        zzdjo zze = this.zzb.zze(new zzcwx(zzfgyVar, zzfgmVar, zzeiqVar.zza), new zzdjr(new zzdkw() { // from class: com.google.android.gms.internal.ads.zzekt
            @Override // com.google.android.gms.internal.ads.zzdkw
            public final void zza(boolean z, Context context, zzdbk zzdbkVar) {
                zzeku.this.zzc(zzeiqVar, z, context, zzdbkVar);
            }
        }, null));
        zze.zzd().zzo(new zzcrv((zzfif) zzeiqVar.zzb), this.zzd);
        ((zzekj) zzeiqVar.zzc).zzc(zze.zzj());
        return zze.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final void zzb(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzfho {
        zzfif zzfifVar = (zzfif) zzeiqVar.zzb;
        zzfhh zzfhhVar = zzfgyVar.zza.zza;
        zzfifVar.zzo(this.zza, zzfhhVar.zzd, zzfgmVar.zzw.toString(), com.google.android.gms.ads.internal.util.zzbw.zzl(zzfgmVar.zzt), (zzbtb) zzeiqVar.zzc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzeiq zzeiqVar, boolean z, Context context, zzdbk zzdbkVar) throws zzdkv {
        try {
            ((zzfif) zzeiqVar.zzb).zzv(z);
            if (this.zzc.zzc < ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaH)).intValue()) {
                ((zzfif) zzeiqVar.zzb).zzx();
            } else {
                ((zzfif) zzeiqVar.zzb).zzy(context);
            }
        } catch (zzfho e) {
            zzcec.zzi("Cannot show interstitial.");
            throw new zzdkv(e.getCause());
        }
    }
}

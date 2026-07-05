package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeln implements zzeit {
    private final Context zza;
    private final zzdlk zzb;
    private zzbtk zzc;
    private final zzcei zzd;

    public zzeln(Context context, zzdlk zzdlkVar, zzcei zzceiVar) {
        this.zza = context;
        this.zzb = zzdlkVar;
        this.zzd = zzceiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final /* bridge */ /* synthetic */ Object zza(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzfho, zzeml {
        if (!zzfgyVar.zza.zza.zzg.contains(Integer.toString(6))) {
            throw new zzeml(2, "Unified must be used for RTB.");
        }
        zzdna zzt = zzdna.zzt(this.zzc);
        zzfhh zzfhhVar = zzfgyVar.zza.zza;
        if (!zzfhhVar.zzg.contains(Integer.toString(zzt.zzc()))) {
            throw new zzeml(1, "No corresponding native ad listener");
        }
        zzdnc zze = this.zzb.zze(new zzcwx(zzfgyVar, zzfgmVar, zzeiqVar.zza), new zzdnm(zzt), new zzdpd(null, null, this.zzc));
        ((zzekj) zzeiqVar.zzc).zzc(zze.zzi());
        return zze.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final void zzb(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzfho {
        try {
            ((zzbus) zzeiqVar.zzb).zzq(zzfgmVar.zzaa);
            if (this.zzd.zzc < ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbH)).intValue()) {
                ((zzbus) zzeiqVar.zzb).zzm(zzfgmVar.zzV, zzfgmVar.zzw.toString(), zzfgyVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzelm(this, zzeiqVar, null), (zzbtb) zzeiqVar.zzc);
            } else {
                ((zzbus) zzeiqVar.zzb).zzn(zzfgmVar.zzV, zzfgmVar.zzw.toString(), zzfgyVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzelm(this, zzeiqVar, null), (zzbtb) zzeiqVar.zzc, zzfgyVar.zza.zza.zzi);
            }
        } catch (RemoteException e) {
            throw new zzfho(e);
        }
    }
}

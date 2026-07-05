package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzelj implements zzeit {
    private final Context zza;
    private final zzdlk zzb;
    private final Executor zzc;

    public zzelj(Context context, zzdlk zzdlkVar, Executor executor) {
        this.zza = context;
        this.zzb = zzdlkVar;
        this.zzc = executor;
    }

    private static final boolean zzc(zzfgy zzfgyVar, int i) {
        return zzfgyVar.zza.zza.zzg.contains(Integer.toString(i));
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final /* bridge */ /* synthetic */ Object zza(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzfho, zzeml {
        zzdna zzah;
        zzbtg zzD = ((zzfif) zzeiqVar.zzb).zzD();
        zzbth zzE = ((zzfif) zzeiqVar.zzb).zzE();
        zzbtk zzd = ((zzfif) zzeiqVar.zzb).zzd();
        if (zzd == null || !zzc(zzfgyVar, 6)) {
            if (zzD == null || !zzc(zzfgyVar, 6)) {
                if (zzD == null || !zzc(zzfgyVar, 2)) {
                    if (zzE == null || !zzc(zzfgyVar, 6)) {
                        if (zzE == null || !zzc(zzfgyVar, 1)) {
                            throw new zzeml(1, "No native ad mappers");
                        }
                        zzah = zzdna.zzah(zzE);
                    } else {
                        zzah = zzdna.zzaj(zzE);
                    }
                } else {
                    zzah = zzdna.zzag(zzD);
                }
            } else {
                zzah = zzdna.zzai(zzD);
            }
        } else {
            zzah = zzdna.zzt(zzd);
        }
        zzfhh zzfhhVar = zzfgyVar.zza.zza;
        if (!zzfhhVar.zzg.contains(Integer.toString(zzah.zzc()))) {
            throw new zzeml(1, "No corresponding native ad listener");
        }
        zzdnc zze = this.zzb.zze(new zzcwx(zzfgyVar, zzfgmVar, zzeiqVar.zza), new zzdnm(zzah), new zzdpd(zzE, zzD, zzd));
        ((zzekj) zzeiqVar.zzc).zzc(zze.zzj());
        zze.zzd().zzo(new zzcrv((zzfif) zzeiqVar.zzb), this.zzc);
        return zze.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final void zzb(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzfho {
        zzfif zzfifVar = (zzfif) zzeiqVar.zzb;
        zzfhh zzfhhVar = zzfgyVar.zza.zza;
        String jSONObject = zzfgmVar.zzw.toString();
        String zzl = com.google.android.gms.ads.internal.util.zzbw.zzl(zzfgmVar.zzt);
        zzbtb zzbtbVar = (zzbtb) zzeiqVar.zzc;
        zzfhh zzfhhVar2 = zzfgyVar.zza.zza;
        zzfifVar.zzp(this.zza, zzfhhVar.zzd, jSONObject, zzl, zzbtbVar, zzfhhVar2.zzi, zzfhhVar2.zzg);
    }
}

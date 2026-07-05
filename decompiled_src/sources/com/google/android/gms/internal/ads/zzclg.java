package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzclg implements zzcqs {

    @Nullable
    private static zzclg zza;

    private static synchronized zzclg zzD(Context context, @Nullable zzbsv zzbsvVar, int i, boolean z, int i2, zzcmk zzcmkVar) {
        synchronized (zzclg.class) {
            zzclg zzclgVar = zza;
            if (zzclgVar != null) {
                return zzclgVar;
            }
            zzbgc.zza(context);
            zzfid zzd = zzfid.zzd(context);
            zzcei zzc = zzd.zzc(240304000, false, i2);
            zzd.zzf(zzbsvVar);
            zzcny zzcnyVar = new zzcny(null);
            zzclh zzclhVar = new zzclh();
            zzclhVar.zzd(zzc);
            zzclhVar.zzc(context);
            zzcnyVar.zzb(new zzclj(zzclhVar, null));
            zzcnyVar.zzc(new zzcpl(zzcmkVar));
            zzclg zza2 = zzcnyVar.zza();
            com.google.android.gms.ads.internal.zzt.zzo().zzu(context, zzc);
            com.google.android.gms.ads.internal.zzt.zzc().zzi(context);
            com.google.android.gms.ads.internal.zzt.zzp().zzl(context);
            com.google.android.gms.ads.internal.zzt.zzp().zzk(context);
            com.google.android.gms.ads.internal.util.zzd.zza(context);
            com.google.android.gms.ads.internal.zzt.zzb().zzd(context);
            com.google.android.gms.ads.internal.zzt.zzv().zzb(context);
            zza2.zza().zzc();
            zzcci.zzd(context);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgj)).booleanValue()) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzav)).booleanValue()) {
                    zzbbp zzbbpVar = new zzbbp(new zzbbv(context));
                    zzefy zzefyVar = new zzefy(new zzefu(context), zza2.zzA());
                    com.google.android.gms.ads.internal.zzt.zzp();
                    new zzegu(context, zzc, zzbbpVar, zzefyVar, UUID.randomUUID().toString(), zza2.zzy()).zzb(com.google.android.gms.ads.internal.zzt.zzo().zzi().zzQ());
                }
            }
            zza = zza2;
            return zza2;
        }
    }

    public static zzclg zzb(Context context, @Nullable zzbsv zzbsvVar, int i) {
        return zzD(context, zzbsvVar, 240304000, false, i, new zzcmk());
    }

    public abstract zzgey zzA();

    public abstract Executor zzB();

    public abstract ScheduledExecutorService zzC();

    public abstract com.google.android.gms.ads.internal.util.zzcf zza();

    public abstract zzcpv zzc();

    public abstract zzcts zzd();

    public abstract zzcvb zze();

    public abstract zzddm zzf();

    public abstract zzdkn zzg();

    public abstract zzdlj zzh();

    public abstract zzdss zzi();

    public abstract zzdxo zzj();

    public abstract zzdzd zzk();

    public abstract zzdzx zzl();

    public abstract zzehs zzm();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzc zzn();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzg zzo();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzaa zzp();

    @Override // com.google.android.gms.internal.ads.zzcqs
    public final zzeyo zzq(zzbze zzbzeVar, int i) {
        return zzr(new zzfar(zzbzeVar, i));
    }

    protected abstract zzeyo zzr(zzfar zzfarVar);

    public abstract zzfbm zzs();

    public abstract zzfda zzt();

    public abstract zzfer zzu();

    public abstract zzfgf zzv();

    public abstract zzfhw zzw();

    public abstract zzfig zzx();

    public abstract zzflw zzy();

    public abstract zzfnc zzz();
}

package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzelr {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final zzcwk zzc;
    private final zzemh zzd;
    private final zzfnu zze;
    private final zzgfg zzf = zzgfg.zze();
    private final AtomicBoolean zzg = new AtomicBoolean();
    private zzels zzh;
    private zzfgy zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzelr(Executor executor, ScheduledExecutorService scheduledExecutorService, zzcwk zzcwkVar, zzemh zzemhVar, zzfnu zzfnuVar) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = zzcwkVar;
        this.zzd = zzemhVar;
        this.zze = zzfnuVar;
    }

    private final synchronized ListenableFuture zzd(zzfgm zzfgmVar) {
        Iterator it = zzfgmVar.zza.iterator();
        while (it.hasNext()) {
            zzein zza = this.zzc.zza(zzfgmVar.zzb, (String) it.next());
            if (zza != null && zza.zzb(this.zzi, zzfgmVar)) {
                return zzgen.zzo(zza.zza(this.zzi, zzfgmVar), zzfgmVar.zzS, TimeUnit.MILLISECONDS, this.zzb);
            }
        }
        return zzgen.zzg(new zzead(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zze(zzfgm zzfgmVar) {
        if (zzfgmVar == null) {
            return;
        }
        ListenableFuture zzd = zzd(zzfgmVar);
        this.zzd.zzf(this.zzi, zzfgmVar, zzd, this.zze);
        zzgen.zzr(zzd, new zzelq(this, zzfgmVar), this.zza);
    }

    public final synchronized ListenableFuture zzb(zzfgy zzfgyVar) {
        if (!this.zzg.getAndSet(true)) {
            if (!zzfgyVar.zzb.zza.isEmpty()) {
                this.zzi = zzfgyVar;
                this.zzh = new zzels(zzfgyVar, this.zzd, this.zzf);
                this.zzd.zzk(zzfgyVar.zzb.zza);
                while (this.zzh.zze()) {
                    zze(this.zzh.zza());
                }
            } else {
                this.zzf.zzd(new zzeml(3, zzemo.zzc(zzfgyVar)));
            }
        }
        return this.zzf;
    }
}

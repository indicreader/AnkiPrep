package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbqz implements zzcew {
    final /* synthetic */ zzbri zza;
    final /* synthetic */ zzfmo zzb;
    final /* synthetic */ zzbrj zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbqz(zzbrj zzbrjVar, zzbri zzbriVar, zzfmo zzfmoVar) {
        this.zza = zzbriVar;
        this.zzb = zzfmoVar;
        this.zzc = zzbrjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcew
    public final void zza() {
        Object obj;
        zzfnc zzfncVar;
        zzfnc zzfncVar2;
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Trying to acquire lock");
        obj = this.zzc.zza;
        synchronized (obj) {
            com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Lock acquired");
            this.zzc.zzi = 1;
            com.google.android.gms.ads.internal.util.zze.zza("Failed loading new engine. Marking new engine destroyable.");
            this.zza.zzb();
            if (((Boolean) zzbht.zzd.zze()).booleanValue()) {
                zzbrj zzbrjVar = this.zzc;
                zzfncVar = zzbrjVar.zze;
                if (zzfncVar != null) {
                    zzfncVar2 = zzbrjVar.zze;
                    zzfmo zzfmoVar = this.zzb;
                    zzfmoVar.zzc("Failed loading new engine");
                    zzfmoVar.zzf(false);
                    zzfncVar2.zzb(zzfmoVar.zzl());
                }
            }
        }
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Lock released");
    }
}

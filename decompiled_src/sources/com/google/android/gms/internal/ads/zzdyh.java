package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdyh extends zzbpg {
    final /* synthetic */ Object zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzfmo zzd;
    final /* synthetic */ zzceu zze;
    final /* synthetic */ zzdyi zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdyh(zzdyi zzdyiVar, Object obj, String str, long j, zzfmo zzfmoVar, zzceu zzceuVar) {
        this.zza = obj;
        this.zzb = str;
        this.zzc = j;
        this.zzd = zzfmoVar;
        this.zze = zzceuVar;
        this.zzf = zzdyiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final void zze(String str) {
        zzdwp zzdwpVar;
        zzdht zzdhtVar;
        zzfnc zzfncVar;
        synchronized (this.zza) {
            this.zzf.zzv(this.zzb, false, str, (int) (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zzc));
            zzdwpVar = this.zzf.zzl;
            zzdwpVar.zzb(this.zzb, "error");
            zzdhtVar = this.zzf.zzo;
            zzdhtVar.zzb(this.zzb, "error");
            zzfncVar = this.zzf.zzp;
            zzfmo zzfmoVar = this.zzd;
            zzfmoVar.zzc(str);
            zzfmoVar.zzf(false);
            zzfncVar.zzb(zzfmoVar.zzl());
            this.zze.zzc(false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final void zzf() {
        zzdwp zzdwpVar;
        zzdht zzdhtVar;
        zzfnc zzfncVar;
        synchronized (this.zza) {
            this.zzf.zzv(this.zzb, true, "", (int) (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zzc));
            zzdwpVar = this.zzf.zzl;
            zzdwpVar.zzd(this.zzb);
            zzdhtVar = this.zzf.zzo;
            zzdhtVar.zzd(this.zzb);
            zzfncVar = this.zzf.zzp;
            zzfmo zzfmoVar = this.zzd;
            zzfmoVar.zzf(true);
            zzfncVar.zzb(zzfmoVar.zzl());
            this.zze.zzc(true);
        }
    }
}

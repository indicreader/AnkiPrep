package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzano implements zzanx {
    private zzam zza;
    private zzfw zzb;
    private zzaea zzc;

    public zzano(String str) {
        zzak zzakVar = new zzak();
        zzakVar.zzW(str);
        this.zza = zzakVar.zzac();
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zza(zzfp zzfpVar) {
        zzek.zzb(this.zzb);
        int i = zzfy.zza;
        long zze = this.zzb.zze();
        long zzf = this.zzb.zzf();
        if (zze == -9223372036854775807L || zzf == -9223372036854775807L) {
            return;
        }
        zzam zzamVar = this.zza;
        if (zzf != zzamVar.zzq) {
            zzak zzb = zzamVar.zzb();
            zzb.zzaa(zzf);
            zzam zzac = zzb.zzac();
            this.zza = zzac;
            this.zzc.zzl(zzac);
        }
        int zzb2 = zzfpVar.zzb();
        this.zzc.zzr(zzfpVar, zzb2);
        this.zzc.zzt(zze, 1, zzb2, 0, null);
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zzb(zzfw zzfwVar, zzacx zzacxVar, zzaok zzaokVar) {
        this.zzb = zzfwVar;
        zzaokVar.zzc();
        zzaea zzw = zzacxVar.zzw(zzaokVar.zza(), 5);
        this.zzc = zzw;
        zzw.zzl(this.zza);
    }
}

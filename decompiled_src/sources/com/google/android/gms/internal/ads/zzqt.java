package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzqt {
    private final zzdt[] zza;
    private final zzrl zzb;
    private final zzdw zzc;

    public zzqt(zzdt... zzdtVarArr) {
        zzrl zzrlVar = new zzrl();
        zzdw zzdwVar = new zzdw();
        this.zza = r2;
        System.arraycopy(zzdtVarArr, 0, r2, 0, 0);
        this.zzb = zzrlVar;
        this.zzc = zzdwVar;
        zzdt[] zzdtVarArr2 = {zzrlVar, zzdwVar};
    }

    public final long zza(long j) {
        return this.zzc.zzi(j);
    }

    public final long zzb() {
        return this.zzb.zzo();
    }

    public final zzcg zzc(zzcg zzcgVar) {
        this.zzc.zzk(zzcgVar.zzc);
        this.zzc.zzj(zzcgVar.zzd);
        return zzcgVar;
    }

    public final boolean zzd(boolean z) {
        this.zzb.zzp(z);
        return z;
    }

    public final zzdt[] zze() {
        return this.zza;
    }
}

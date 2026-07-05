package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzajt implements zzajz {
    private final zzadh zza;
    private final zzadg zzb;
    private long zzc = -1;
    private long zzd = -1;

    public zzajt(zzadh zzadhVar, zzadg zzadgVar) {
        this.zza = zzadhVar;
        this.zzb = zzadgVar;
    }

    public final void zza(long j) {
        this.zzc = j;
    }

    @Override // com.google.android.gms.internal.ads.zzajz
    public final long zzd(zzacv zzacvVar) {
        long j = this.zzd;
        if (j < 0) {
            return -1L;
        }
        this.zzd = -1L;
        return -(j + 2);
    }

    @Override // com.google.android.gms.internal.ads.zzajz
    public final zzadu zze() {
        zzek.zzf(this.zzc != -1);
        return new zzadf(this.zza, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzajz
    public final void zzg(long j) {
        long[] jArr = this.zzb.zza;
        this.zzd = jArr[zzfy.zzc(jArr, j, true, true)];
    }
}

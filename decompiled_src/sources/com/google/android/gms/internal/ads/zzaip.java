package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzaip {
    public final int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    private final boolean zze;
    private final zzfp zzf;
    private final zzfp zzg;
    private int zzh;
    private int zzi;

    public zzaip(zzfp zzfpVar, zzfp zzfpVar2, boolean z) throws zzcc {
        this.zzg = zzfpVar;
        this.zzf = zzfpVar2;
        this.zze = z;
        zzfpVar2.zzK(12);
        this.zza = zzfpVar2.zzp();
        zzfpVar.zzK(12);
        this.zzi = zzfpVar.zzp();
        zzacy.zzb(zzfpVar.zzg() == 1, "first_chunk must be 1");
        this.zzb = -1;
    }

    public final boolean zza() {
        long zzu;
        int i = this.zzb + 1;
        this.zzb = i;
        if (i == this.zza) {
            return false;
        }
        if (this.zze) {
            zzu = this.zzf.zzv();
        } else {
            zzu = this.zzf.zzu();
        }
        this.zzd = zzu;
        if (this.zzb == this.zzh) {
            this.zzc = this.zzg.zzp();
            this.zzg.zzL(4);
            int i2 = this.zzi - 1;
            this.zzi = i2;
            this.zzh = i2 > 0 ? (-1) + this.zzg.zzp() : -1;
        }
        return true;
    }
}

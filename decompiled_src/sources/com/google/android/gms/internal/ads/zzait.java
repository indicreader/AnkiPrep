package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzait implements zzair {
    private final int zza;
    private final int zzb;
    private final zzfp zzc;

    public zzait(zzain zzainVar, zzam zzamVar) {
        zzfp zzfpVar = zzainVar.zza;
        this.zzc = zzfpVar;
        zzfpVar.zzK(12);
        int zzp = zzfpVar.zzp();
        if ("audio/raw".equals(zzamVar.zzm)) {
            int zzl = zzfy.zzl(zzamVar.zzB, zzamVar.zzz);
            if (zzp == 0 || zzp % zzl != 0) {
                zzff.zzf("AtomParsers", "Audio sample size mismatch. stsd sample size: " + zzl + ", stsz sample size: " + zzp);
                zzp = zzl;
            }
        }
        this.zza = zzp == 0 ? -1 : zzp;
        this.zzb = zzfpVar.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzair
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzair
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzair
    public final int zzc() {
        int i = this.zza;
        return i == -1 ? this.zzc.zzp() : i;
    }
}

package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzqr {
    private boolean zzb;
    private zzqt zzd;
    private zzqj zze;
    private zzpd zza = zzpd.zza;
    private final zzqq zzc = zzqq.zza;

    @Deprecated
    public zzqr() {
    }

    @Deprecated
    public final zzqr zzc(zzpd zzpdVar) {
        this.zza = zzpdVar;
        return this;
    }

    public final zzqr zzd(zzdt[] zzdtVarArr) {
        this.zzd = new zzqt(zzdtVarArr);
        return this;
    }

    public final zzrd zze() {
        zzek.zzf(!this.zzb);
        this.zzb = true;
        if (this.zzd == null) {
            this.zzd = new zzqt(new zzdt[0]);
        }
        zzrc zzrcVar = null;
        if (this.zze == null) {
            this.zze = new zzqj(null);
        }
        return new zzrd(this, zzrcVar);
    }
}

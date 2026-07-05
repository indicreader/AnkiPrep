package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzvz implements zzyr {
    public long zza;
    public long zzb;
    public zzyq zzc;
    public zzvz zzd;

    public zzvz(long j, int i) {
        zze(j, 65536);
    }

    public final int zza(long j) {
        long j2 = j - this.zza;
        int i = this.zzc.zzb;
        return (int) j2;
    }

    public final zzvz zzb() {
        this.zzc = null;
        zzvz zzvzVar = this.zzd;
        this.zzd = null;
        return zzvzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyr
    public final zzyq zzc() {
        zzyq zzyqVar = this.zzc;
        zzyqVar.getClass();
        return zzyqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyr
    public final zzyr zzd() {
        zzvz zzvzVar = this.zzd;
        if (zzvzVar == null || zzvzVar.zzc == null) {
            return null;
        }
        return zzvzVar;
    }

    public final void zze(long j, int i) {
        zzek.zzf(this.zzc == null);
        this.zza = j;
        this.zzb = j + 65536;
    }
}

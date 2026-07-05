package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzxp implements Comparable {
    private final boolean zza;
    private final boolean zzb;

    public zzxp(zzam zzamVar, int i) {
        this.zza = 1 == (zzamVar.zze & 1);
        this.zzb = zzyg.zzo(i, false);
    }

    @Override // java.lang.Comparable
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxp zzxpVar) {
        return zzfzp.zzk().zze(this.zzb, zzxpVar.zzb).zze(this.zza, zzxpVar.zza).zza();
    }
}

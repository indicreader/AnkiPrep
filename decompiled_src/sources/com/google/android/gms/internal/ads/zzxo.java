package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzxo extends zzyc implements Comparable {
    private final int zze;
    private final int zzf;

    public zzxo(int i, zzcz zzczVar, int i2, zzxu zzxuVar, int i3) {
        super(i, zzczVar, i2);
        this.zze = zzyg.zzo(i3, zzxuVar.zzT) ? 1 : 0;
        this.zzf = this.zzd.zza();
    }

    @Override // java.lang.Comparable
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxo zzxoVar) {
        return Integer.compare(this.zzf, zzxoVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final /* bridge */ /* synthetic */ boolean zzc(zzyc zzycVar) {
        return false;
    }
}

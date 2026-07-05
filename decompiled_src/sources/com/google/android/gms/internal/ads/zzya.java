package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzya extends zzyc implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;

    /* JADX WARN: Multi-variable type inference failed */
    public zzya(int i, zzcz zzczVar, int i2, zzxu zzxuVar, int i3, String str) {
        super(i, zzczVar, i2);
        zzgaa zzgaaVar;
        int i4;
        int i5 = 0;
        this.zzf = zzyg.zzo(i3, false);
        int i6 = this.zzd.zze;
        int i7 = zzxuVar.zzy;
        this.zzg = 1 == (i6 & 1);
        this.zzh = (i6 & 2) != 0;
        if (zzxuVar.zzw.isEmpty()) {
            zzgaaVar = zzgaa.zzm("");
        } else {
            zzgaaVar = zzxuVar.zzw;
        }
        int i8 = 0;
        while (true) {
            if (i8 >= zzgaaVar.size()) {
                i8 = Integer.MAX_VALUE;
                i4 = 0;
                break;
            }
            zzam zzamVar = this.zzd;
            String str2 = (String) zzgaaVar.get(i8);
            boolean z = zzxuVar.zzz;
            i4 = zzyg.zzb(zzamVar, str2, false);
            if (i4 > 0) {
                break;
            } else {
                i8++;
            }
        }
        this.zzi = i8;
        this.zzj = i4;
        int zza = zzyg.zza(this.zzd.zzf, zzxuVar.zzx);
        this.zzk = zza;
        this.zzm = (this.zzd.zzf & 1088) != 0;
        int zzb = zzyg.zzb(this.zzd, str, zzyg.zzh(str) == null);
        this.zzl = zzb;
        boolean z2 = i4 > 0 || (zzxuVar.zzw.isEmpty() && zza > 0) || this.zzg || (this.zzh && zzb > 0);
        if (zzyg.zzo(i3, zzxuVar.zzT) && z2) {
            i5 = 1;
        }
        this.zze = i5;
    }

    @Override // java.lang.Comparable
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzya zzyaVar) {
        zzfzp zzb = zzfzp.zzk().zze(this.zzf, zzyaVar.zzf).zzd(Integer.valueOf(this.zzi), Integer.valueOf(zzyaVar.zzi), zzgbj.zzc().zza()).zzb(this.zzj, zzyaVar.zzj).zzb(this.zzk, zzyaVar.zzk).zze(this.zzg, zzyaVar.zzg).zzd(Boolean.valueOf(this.zzh), Boolean.valueOf(zzyaVar.zzh), this.zzj == 0 ? zzgbj.zzc() : zzgbj.zzc().zza()).zzb(this.zzl, zzyaVar.zzl);
        if (this.zzk == 0) {
            zzb = zzb.zzf(this.zzm, zzyaVar.zzm);
        }
        return zzb.zza();
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

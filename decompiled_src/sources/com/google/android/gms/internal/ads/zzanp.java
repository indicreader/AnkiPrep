package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzanp implements zzaol {
    private final zzamy zza;
    private final zzfo zzb = new zzfo(new byte[10], 10);
    private int zzc = 0;
    private int zzd;
    private zzfw zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    public zzanp(zzamy zzamyVar) {
        this.zza = zzamyVar;
    }

    private final void zzd(int i) {
        this.zzc = i;
        this.zzd = 0;
    }

    private final boolean zze(zzfp zzfpVar, byte[] bArr, int i) {
        int min = Math.min(zzfpVar.zzb(), i - this.zzd);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            zzfpVar.zzL(min);
        } else {
            zzfpVar.zzG(bArr, this.zzd, min);
        }
        int i2 = this.zzd + min;
        this.zzd = i2;
        return i2 == i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r8v16, types: [com.google.android.gms.internal.ads.zzfo] */
    /* JADX WARN: Type inference failed for: r8v9, types: [com.google.android.gms.internal.ads.zzamy] */
    @Override // com.google.android.gms.internal.ads.zzaol
    public final void zza(zzfp zzfpVar, int i) throws zzcc {
        int i2;
        boolean z;
        int i3;
        int i4;
        long j;
        int i5;
        zzek.zzb(this.zze);
        int i6 = -1;
        int i7 = 2;
        ?? r6 = 0;
        int i8 = 1;
        if ((i & 1) != 0) {
            int i9 = this.zzc;
            if (i9 != 0 && i9 != 1) {
                if (i9 != 2) {
                    int i10 = this.zzj;
                    if (i10 != -1) {
                        zzff.zzf("PesReader", "Unexpected start indicator: expected " + i10 + " more bytes");
                    }
                    this.zza.zzc(zzfpVar.zze() == 0);
                } else {
                    zzff.zzf("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            zzd(1);
        }
        int i11 = i;
        while (zzfpVar.zzb() > 0) {
            int i12 = this.zzc;
            if (i12 == 0) {
                i2 = i7;
                z = r6;
                i3 = i8;
                zzfpVar.zzL(zzfpVar.zzb());
            } else if (i12 != i8) {
                if (i12 != i7) {
                    int zzb = zzfpVar.zzb();
                    int i13 = this.zzj;
                    int i14 = i13 == i6 ? r6 : zzb - i13;
                    if (i14 > 0) {
                        zzb -= i14;
                        zzfpVar.zzJ(zzfpVar.zzd() + zzb);
                    }
                    this.zza.zza(zzfpVar);
                    int i15 = this.zzj;
                    if (i15 != i6) {
                        int i16 = i15 - zzb;
                        this.zzj = i16;
                        if (i16 == 0) {
                            this.zza.zzc(r6);
                            zzd(i8);
                        }
                    }
                } else {
                    if (zze(zzfpVar, this.zzb.zza, Math.min(10, this.zzi)) && zze(zzfpVar, null, this.zzi)) {
                        this.zzb.zzk(r6);
                        if (this.zzf) {
                            this.zzb.zzm(4);
                            long zzd = this.zzb.zzd(3);
                            this.zzb.zzm(i8);
                            int zzd2 = this.zzb.zzd(15) << 15;
                            this.zzb.zzm(i8);
                            long zzd3 = this.zzb.zzd(15);
                            this.zzb.zzm(i8);
                            if (this.zzh || !this.zzg) {
                                i5 = zzd2;
                            } else {
                                this.zzb.zzm(4);
                                this.zzb.zzm(i8);
                                int zzd4 = this.zzb.zzd(15) << 15;
                                this.zzb.zzm(i8);
                                long zzd5 = this.zzb.zzd(15);
                                this.zzb.zzm(i8);
                                i5 = zzd2;
                                this.zze.zzb((this.zzb.zzd(3) << 30) | zzd4 | zzd5);
                                this.zzh = true;
                            }
                            j = this.zze.zzb((zzd << 30) | i5 | zzd3);
                        } else {
                            j = -9223372036854775807L;
                        }
                        i11 |= true != this.zzk ? 0 : 4;
                        this.zza.zzd(j, i11);
                        zzd(3);
                        i6 = -1;
                        i7 = 2;
                        r6 = 0;
                        i8 = 1;
                    }
                }
                i2 = i7;
                z = r6;
                i3 = i8;
            } else if (zze(zzfpVar, this.zzb.zza, 9)) {
                z = false;
                this.zzb.zzk(0);
                int zzd6 = this.zzb.zzd(24);
                i3 = 1;
                if (zzd6 != 1) {
                    zzff.zzf("PesReader", "Unexpected start code prefix: " + zzd6);
                    i6 = -1;
                    this.zzj = -1;
                    i4 = 0;
                    i2 = 2;
                } else {
                    this.zzb.zzm(8);
                    zzfo zzfoVar = this.zzb;
                    int zzd7 = zzfoVar.zzd(16);
                    zzfoVar.zzm(5);
                    this.zzk = this.zzb.zzo();
                    i2 = 2;
                    this.zzb.zzm(2);
                    this.zzf = this.zzb.zzo();
                    this.zzg = this.zzb.zzo();
                    this.zzb.zzm(6);
                    int zzd8 = this.zzb.zzd(8);
                    this.zzi = zzd8;
                    if (zzd7 == 0) {
                        this.zzj = -1;
                        i6 = -1;
                    } else {
                        int i17 = (zzd7 - 3) - zzd8;
                        this.zzj = i17;
                        if (i17 < 0) {
                            zzff.zzf("PesReader", "Found negative packet payload size: " + i17);
                            i6 = -1;
                            this.zzj = -1;
                        } else {
                            i6 = -1;
                        }
                    }
                    i4 = 2;
                }
                zzd(i4);
            } else {
                i6 = -1;
                z = false;
                i3 = 1;
                i2 = 2;
            }
            i8 = i3;
            r6 = z;
            i7 = i2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaol
    public final void zzb(zzfw zzfwVar, zzacx zzacxVar, zzaok zzaokVar) {
        this.zze = zzfwVar;
        this.zza.zzb(zzacxVar, zzaokVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaol
    public final void zzc() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zze();
    }
}

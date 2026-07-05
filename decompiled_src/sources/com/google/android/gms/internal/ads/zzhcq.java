package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhcq {
    private static final zzhcq zza = new zzhcq(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzhcq() {
        this(0, new int[8], new Object[8], true);
    }

    private zzhcq(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzhcq zzc() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhcq zze(zzhcq zzhcqVar, zzhcq zzhcqVar2) {
        int i = zzhcqVar.zzb + zzhcqVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzhcqVar.zzc, i);
        System.arraycopy(zzhcqVar2.zzc, 0, copyOf, zzhcqVar.zzb, zzhcqVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzhcqVar.zzd, i);
        System.arraycopy(zzhcqVar2.zzd, 0, copyOf2, zzhcqVar.zzb, zzhcqVar2.zzb);
        return new zzhcq(i, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhcq zzf() {
        return new zzhcq(0, new int[8], new Object[8], true);
    }

    private final void zzl(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhcq)) {
            return false;
        }
        zzhcq zzhcqVar = (zzhcq) obj;
        int i = this.zzb;
        if (i == zzhcqVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzhcqVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzhcqVar.zzd;
                    int i3 = this.zzb;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = ((i2 * 31) + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final int zza() {
        int zzz;
        int zzA;
        int i;
        int i2 = this.zze;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzb; i4++) {
            int i5 = this.zzc[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 != 0) {
                if (i7 == 1) {
                    ((Long) this.zzd[i4]).longValue();
                    i = zzgza.zzz(i6 << 3) + 8;
                } else if (i7 == 2) {
                    int i8 = i6 << 3;
                    zzgyl zzgylVar = (zzgyl) this.zzd[i4];
                    int zzz2 = zzgza.zzz(i8);
                    int zzd = zzgylVar.zzd();
                    i = zzz2 + zzgza.zzz(zzd) + zzd;
                } else if (i7 == 3) {
                    int zzz3 = zzgza.zzz(i6 << 3);
                    zzz = zzz3 + zzz3;
                    zzA = ((zzhcq) this.zzd[i4]).zza();
                } else if (i7 == 5) {
                    ((Integer) this.zzd[i4]).intValue();
                    i = zzgza.zzz(i6 << 3) + 4;
                } else {
                    throw new IllegalStateException(zzhag.zza());
                }
                i3 += i;
            } else {
                int i9 = i6 << 3;
                long longValue = ((Long) this.zzd[i4]).longValue();
                zzz = zzgza.zzz(i9);
                zzA = zzgza.zzA(longValue);
            }
            i = zzz + zzA;
            i3 += i;
        }
        this.zze = i3;
        return i3;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3] >>> 3;
            zzgyl zzgylVar = (zzgyl) this.zzd[i3];
            int zzz = zzgza.zzz(8);
            int zzz2 = zzgza.zzz(16) + zzgza.zzz(i4);
            int zzz3 = zzgza.zzz(24);
            int zzd = zzgylVar.zzd();
            i2 += zzz + zzz + zzz2 + zzz3 + zzgza.zzz(zzd) + zzd;
        }
        this.zze = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzhcq zzd(zzhcq zzhcqVar) {
        if (zzhcqVar.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzhcqVar.zzb;
        zzl(i);
        System.arraycopy(zzhcqVar.zzc, 0, this.zzc, this.zzb, zzhcqVar.zzb);
        System.arraycopy(zzhcqVar.zzd, 0, this.zzd, this.zzb, zzhcqVar.zzb);
        this.zzb = i;
        return this;
    }

    final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzhbg.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(int i, Object obj) {
        zzg();
        zzl(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    public final void zzk(zzgzb zzgzbVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzgzbVar.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzgzbVar.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzgzbVar.zzd(i4, (zzgyl) obj);
                } else if (i3 == 3) {
                    zzgzbVar.zzE(i4);
                    ((zzhcq) obj).zzk(zzgzbVar);
                    zzgzbVar.zzh(i4);
                } else if (i3 == 5) {
                    zzgzbVar.zzk(i4, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzhag.zza());
                }
            }
        }
    }
}

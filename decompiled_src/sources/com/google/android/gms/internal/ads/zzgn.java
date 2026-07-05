package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgn {
    private byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    public zzgn(byte[] bArr, int i, int i2) {
        this.zza = bArr;
        this.zzc = i;
        this.zzb = i2;
        zzh();
    }

    private final int zzg() {
        int i = 0;
        while (!zzf()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? zza(i) : 0);
    }

    private final void zzh() {
        int i;
        int i2 = this.zzc;
        boolean z = false;
        if (i2 >= 0 && (i2 < (i = this.zzb) || (i2 == i && this.zzd == 0))) {
            z = true;
        }
        zzek.zzf(z);
    }

    private final boolean zzi(int i) {
        if (i < 2 || i >= this.zzb) {
            return false;
        }
        byte[] bArr = this.zza;
        return bArr[i] == 3 && bArr[i + (-2)] == 0 && bArr[i + (-1)] == 0;
    }

    public final int zza(int i) {
        int i2;
        this.zzd += i;
        int i3 = 0;
        while (true) {
            i2 = this.zzd;
            if (i2 <= 8) {
                break;
            }
            int i4 = i2 - 8;
            this.zzd = i4;
            byte[] bArr = this.zza;
            int i5 = this.zzc;
            i3 |= (bArr[i5] & 255) << i4;
            if (true != zzi(i5 + 1)) {
                r3 = 1;
            }
            this.zzc = i5 + r3;
        }
        byte[] bArr2 = this.zza;
        int i6 = this.zzc;
        int i7 = i3 | ((bArr2[i6] & 255) >> (8 - i2));
        int i8 = 32 - i;
        if (i2 == 8) {
            this.zzd = 0;
            this.zzc = i6 + (true != zzi(i6 + 1) ? 1 : 2);
        }
        int i9 = ((-1) >>> i8) & i7;
        zzh();
        return i9;
    }

    public final int zzb() {
        int zzg = zzg();
        return (zzg % 2 == 0 ? -1 : 1) * ((zzg + 1) / 2);
    }

    public final int zzc() {
        return zzg();
    }

    public final void zzd() {
        int i = this.zzd + 1;
        this.zzd = i;
        if (i == 8) {
            this.zzd = 0;
            int i2 = this.zzc;
            this.zzc = i2 + (true == zzi(i2 + 1) ? 2 : 1);
        }
        zzh();
    }

    public final void zze(int i) {
        int i2 = this.zzc;
        int i3 = i / 8;
        int i4 = i2 + i3;
        this.zzc = i4;
        int i5 = this.zzd + (i - (i3 * 8));
        this.zzd = i5;
        if (i5 > 7) {
            this.zzc = i4 + 1;
            this.zzd = i5 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.zzc) {
                zzh();
                return;
            } else if (zzi(i2)) {
                this.zzc++;
                i2 += 2;
            }
        }
    }

    public final boolean zzf() {
        int i = this.zza[this.zzc] & (128 >> this.zzd);
        zzd();
        return i != 0;
    }
}

package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfp {
    private static final char[] zza = {'\r', '\n'};
    private static final char[] zzb = {'\n'};
    private static final zzgaf zzc = zzgaf.zzr(zzfwq.zza, zzfwq.zzc, zzfwq.zzf, zzfwq.zzd, zzfwq.zze);
    private byte[] zzd;
    private int zze;
    private int zzf;

    public zzfp() {
        this.zzd = zzfy.zzf;
    }

    public zzfp(byte[] bArr, int i) {
        this.zzd = bArr;
        this.zzf = i;
    }

    private final char zzN(Charset charset, char[] cArr) {
        int zzO = zzO(charset);
        if (zzO != 0) {
            int i = zzO >> 16;
            for (char c : cArr) {
                char c2 = (char) i;
                if (c == c2) {
                    this.zze += (char) zzO;
                    return c2;
                }
            }
        }
        return (char) 0;
    }

    private final int zzO(Charset charset) {
        byte zza2;
        char zzb2;
        int i = 1;
        if (charset.equals(zzfwq.zzc) || charset.equals(zzfwq.zza)) {
            if (this.zzf - this.zze > 0) {
                zza2 = (byte) zzgct.zza(this.zzd[r2] & 255);
                return (zzgct.zza(zza2) << 16) + i;
            }
        }
        if (charset.equals(zzfwq.zzf) || charset.equals(zzfwq.zzd)) {
            int i2 = this.zzf;
            int i3 = this.zze;
            if (i2 - i3 >= 2) {
                byte[] bArr = this.zzd;
                zzb2 = zzgct.zzb(bArr[i3], bArr[i3 + 1]);
                zza2 = (byte) zzb2;
                i = 2;
                return (zzgct.zza(zza2) << 16) + i;
            }
        }
        if (!charset.equals(zzfwq.zze)) {
            return 0;
        }
        int i4 = this.zzf;
        int i5 = this.zze;
        if (i4 - i5 < 2) {
            return 0;
        }
        byte[] bArr2 = this.zzd;
        zzb2 = zzgct.zzb(bArr2[i5 + 1], bArr2[i5]);
        zza2 = (byte) zzb2;
        i = 2;
        return (zzgct.zza(zza2) << 16) + i;
    }

    public final String zzA(int i, Charset charset) {
        byte[] bArr = this.zzd;
        int i2 = this.zze;
        String str = new String(bArr, i2, i, charset);
        this.zze = i2 + i;
        return str;
    }

    public final Charset zzB() {
        int i = this.zzf;
        int i2 = this.zze;
        int i3 = i - i2;
        if (i3 >= 3) {
            byte[] bArr = this.zzd;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                this.zze = i2 + 3;
                return zzfwq.zzc;
            }
        }
        if (i3 < 2) {
            return null;
        }
        byte[] bArr2 = this.zzd;
        byte b = bArr2[i2];
        if (b == -2) {
            if (bArr2[i2 + 1] != -1) {
                return null;
            }
            this.zze = i2 + 2;
            return zzfwq.zzd;
        }
        if (b != -1 || bArr2[i2 + 1] != -2) {
            return null;
        }
        this.zze = i2 + 2;
        return zzfwq.zze;
    }

    public final short zzC() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        this.zze = i + 2;
        return (short) (((bArr[i2] & 255) << 8) | i3);
    }

    public final short zzD() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        this.zze = i + 2;
        return (short) ((bArr[i2] & 255) | (i3 << 8));
    }

    public final void zzE(int i) {
        byte[] bArr = this.zzd;
        if (i > bArr.length) {
            this.zzd = Arrays.copyOf(bArr, i);
        }
    }

    public final void zzF(zzfo zzfoVar, int i) {
        zzG(zzfoVar.zza, 0, i);
        zzfoVar.zzk(0);
    }

    public final void zzG(byte[] bArr, int i, int i2) {
        System.arraycopy(this.zzd, this.zze, bArr, i, i2);
        this.zze += i2;
    }

    public final void zzH(int i) {
        byte[] bArr = this.zzd;
        if (bArr.length < i) {
            bArr = new byte[i];
        }
        zzI(bArr, i);
    }

    public final void zzI(byte[] bArr, int i) {
        this.zzd = bArr;
        this.zzf = i;
        this.zze = 0;
    }

    public final void zzJ(int i) {
        boolean z = false;
        if (i >= 0 && i <= this.zzd.length) {
            z = true;
        }
        zzek.zzd(z);
        this.zzf = i;
    }

    public final void zzK(int i) {
        boolean z = false;
        if (i >= 0 && i <= this.zzf) {
            z = true;
        }
        zzek.zzd(z);
        this.zze = i;
    }

    public final void zzL(int i) {
        zzK(this.zze + i);
    }

    public final byte[] zzM() {
        return this.zzd;
    }

    public final char zza(Charset charset) {
        zzek.zze(zzc.contains(charset), "Unsupported charset: ".concat(String.valueOf(String.valueOf(charset))));
        return (char) (zzO(charset) >> 16);
    }

    public final int zzb() {
        return this.zzf - this.zze;
    }

    public final int zzc() {
        return this.zzd.length;
    }

    public final int zzd() {
        return this.zze;
    }

    public final int zze() {
        return this.zzf;
    }

    public final int zzf() {
        return this.zzd[this.zze] & 255;
    }

    public final int zzg() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = i + 3;
        int i5 = bArr[i + 2] & 255;
        this.zze = i + 4;
        return (bArr[i4] & 255) | (i2 << 24) | (i3 << 16) | (i5 << 8);
    }

    public final int zzh() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = bArr[i] & 255;
        int i3 = i + 2;
        int i4 = bArr[i + 1] & 255;
        this.zze = i + 3;
        return (bArr[i3] & 255) | ((i2 << 24) >> 8) | (i4 << 8);
    }

    public final int zzi() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        this.zze = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    public final int zzj() {
        int zzi = zzi();
        if (zzi >= 0) {
            return zzi;
        }
        throw new IllegalStateException("Top bit not zero: " + zzi);
    }

    public final int zzk() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        this.zze = i + 2;
        return ((bArr[i2] & 255) << 8) | i3;
    }

    public final int zzl() {
        return (zzm() << 21) | (zzm() << 14) | (zzm() << 7) | zzm();
    }

    public final int zzm() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        this.zze = i + 1;
        return bArr[i] & 255;
    }

    public final int zzn() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        this.zze = i + 4;
        return i3 | (i2 << 8);
    }

    public final int zzo() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = bArr[i] & 255;
        int i3 = i + 2;
        int i4 = bArr[i + 1] & 255;
        this.zze = i + 3;
        return (bArr[i3] & 255) | (i2 << 16) | (i4 << 8);
    }

    public final int zzp() {
        int zzg = zzg();
        if (zzg >= 0) {
            return zzg;
        }
        throw new IllegalStateException("Top bit not zero: " + zzg);
    }

    public final int zzq() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        this.zze = i + 2;
        return (bArr[i2] & 255) | (i3 << 8);
    }

    public final long zzr() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        long j = bArr[i];
        long j2 = bArr[i + 1];
        long j3 = bArr[i + 2];
        long j4 = bArr[i + 3];
        long j5 = bArr[i + 4];
        long j6 = bArr[i + 5];
        long j7 = bArr[i + 6];
        this.zze = i + 8;
        return ((bArr[i + 7] & 255) << 56) | ((j7 & 255) << 48) | ((j2 & 255) << 8) | (j & 255) | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((j5 & 255) << 32) | ((j6 & 255) << 40);
    }

    public final long zzs() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        long j = bArr[i];
        long j2 = bArr[i + 1];
        long j3 = bArr[i + 2];
        this.zze = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (j & 255) | ((j2 & 255) << 8) | ((j3 & 255) << 16);
    }

    public final long zzt() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        long j = bArr[i];
        long j2 = bArr[i + 1];
        long j3 = bArr[i + 2];
        long j4 = bArr[i + 3];
        long j5 = bArr[i + 4];
        long j6 = bArr[i + 5];
        long j7 = bArr[i + 6];
        this.zze = i + 8;
        return (bArr[i + 7] & 255) | ((j & 255) << 56) | ((j2 & 255) << 48) | ((j3 & 255) << 40) | ((j4 & 255) << 32) | ((j5 & 255) << 24) | ((j6 & 255) << 16) | ((j7 & 255) << 8);
    }

    public final long zzu() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        long j = bArr[i];
        long j2 = bArr[i + 1];
        long j3 = bArr[i + 2];
        this.zze = i + 4;
        return (bArr[i + 3] & 255) | ((j & 255) << 24) | ((j2 & 255) << 16) | ((j3 & 255) << 8);
    }

    public final long zzv() {
        long zzt = zzt();
        if (zzt >= 0) {
            return zzt;
        }
        throw new IllegalStateException("Top bit not zero: " + zzt);
    }

    public final long zzw() {
        int i;
        int i2;
        long j = this.zzd[this.zze];
        int i3 = 7;
        while (true) {
            i = 0;
            if (i3 < 0) {
                break;
            }
            if (((1 << i3) & j) != 0) {
                i3--;
            } else if (i3 < 6) {
                j &= r7 - 1;
                i = 7 - i3;
            } else if (i3 == 7) {
                i = 1;
            }
        }
        if (i == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
        }
        for (i2 = 1; i2 < i; i2++) {
            if ((this.zzd[this.zze + i2] & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
            }
            j = (j << 6) | (r2 & Utf8.REPLACEMENT_BYTE);
        }
        this.zze += i;
        return j;
    }

    public final String zzx(char c) {
        int i = this.zzf;
        int i2 = this.zze;
        if (i - i2 == 0) {
            return null;
        }
        while (i2 < this.zzf && this.zzd[i2] != 0) {
            i2++;
        }
        byte[] bArr = this.zzd;
        int i3 = this.zze;
        String zzA = zzfy.zzA(bArr, i3, i2 - i3);
        this.zze = i2;
        if (i2 < this.zzf) {
            this.zze = i2 + 1;
        }
        return zzA;
    }

    public final String zzy(Charset charset) {
        zzek.zze(zzc.contains(charset), "Unsupported charset: ".concat(String.valueOf(String.valueOf(charset))));
        if (this.zzf - this.zze == 0) {
            return null;
        }
        if (!charset.equals(zzfwq.zza)) {
            zzB();
        }
        int i = 1;
        if (!charset.equals(zzfwq.zzc) && !charset.equals(zzfwq.zza)) {
            i = 2;
            if (!charset.equals(zzfwq.zzf) && !charset.equals(zzfwq.zze) && !charset.equals(zzfwq.zzd)) {
                throw new IllegalArgumentException("Unsupported charset: ".concat(String.valueOf(String.valueOf(charset))));
            }
        }
        int i2 = this.zze;
        while (true) {
            int i3 = this.zzf;
            if (i2 >= i3 - (i - 1)) {
                i2 = i3;
                break;
            }
            if ((charset.equals(zzfwq.zzc) || charset.equals(zzfwq.zza)) && zzfy.zzI(this.zzd[i2])) {
                break;
            }
            if (charset.equals(zzfwq.zzf) || charset.equals(zzfwq.zzd)) {
                byte[] bArr = this.zzd;
                if (bArr[i2] == 0 && zzfy.zzI(bArr[i2 + 1])) {
                    break;
                }
            }
            if (charset.equals(zzfwq.zze)) {
                byte[] bArr2 = this.zzd;
                if (bArr2[i2 + 1] == 0 && zzfy.zzI(bArr2[i2])) {
                    break;
                }
            }
            i2 += i;
        }
        String zzA = zzA(i2 - this.zze, charset);
        if (this.zze != this.zzf && zzN(charset, zza) == '\r') {
            zzN(charset, zzb);
        }
        return zzA;
    }

    public final String zzz(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.zze;
        int i3 = (i2 + i) - 1;
        String zzA = zzfy.zzA(this.zzd, i2, (i3 >= this.zzf || this.zzd[i3] != 0) ? i : i - 1);
        this.zze += i;
        return zzA;
    }

    public zzfp(int i) {
        this.zzd = new byte[i];
        this.zzf = i;
    }

    public zzfp(byte[] bArr) {
        this.zzd = bArr;
        this.zzf = bArr.length;
    }
}

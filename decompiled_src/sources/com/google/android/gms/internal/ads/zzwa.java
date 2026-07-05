package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzwa {
    private final zzfp zza = new zzfp(32);
    private zzvz zzb;
    private zzvz zzc;
    private zzvz zzd;
    private long zze;
    private final zzyx zzf;

    public zzwa(zzyx zzyxVar) {
        this.zzf = zzyxVar;
        zzvz zzvzVar = new zzvz(0L, 65536);
        this.zzb = zzvzVar;
        this.zzc = zzvzVar;
        this.zzd = zzvzVar;
    }

    private final int zzi(int i) {
        zzvz zzvzVar = this.zzd;
        if (zzvzVar.zzc == null) {
            zzyq zzb = this.zzf.zzb();
            zzvz zzvzVar2 = new zzvz(this.zzd.zzb, 65536);
            zzvzVar.zzc = zzb;
            zzvzVar.zzd = zzvzVar2;
        }
        return Math.min(i, (int) (this.zzd.zzb - this.zze));
    }

    private static zzvz zzj(zzvz zzvzVar, long j) {
        while (j >= zzvzVar.zzb) {
            zzvzVar = zzvzVar.zzd;
        }
        return zzvzVar;
    }

    private static zzvz zzk(zzvz zzvzVar, long j, ByteBuffer byteBuffer, int i) {
        zzvz zzj = zzj(zzvzVar, j);
        while (i > 0) {
            int min = Math.min(i, (int) (zzj.zzb - j));
            byteBuffer.put(zzj.zzc.zza, zzj.zza(j), min);
            i -= min;
            j += min;
            if (j == zzj.zzb) {
                zzj = zzj.zzd;
            }
        }
        return zzj;
    }

    private static zzvz zzl(zzvz zzvzVar, long j, byte[] bArr, int i) {
        zzvz zzj = zzj(zzvzVar, j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (zzj.zzb - j));
            System.arraycopy(zzj.zzc.zza, zzj.zza(j), bArr, i - i2, min);
            i2 -= min;
            j += min;
            if (j == zzj.zzb) {
                zzj = zzj.zzd;
            }
        }
        return zzj;
    }

    private static zzvz zzm(zzvz zzvzVar, zzih zzihVar, zzwc zzwcVar, zzfp zzfpVar) {
        zzvz zzvzVar2;
        if (zzihVar.zzk()) {
            long j = zzwcVar.zzb;
            int i = 1;
            zzfpVar.zzH(1);
            zzvz zzl = zzl(zzvzVar, j, zzfpVar.zzM(), 1);
            long j2 = j + 1;
            byte b = zzfpVar.zzM()[0];
            int i2 = b & 128;
            int i3 = b & Byte.MAX_VALUE;
            zzie zzieVar = zzihVar.zzb;
            byte[] bArr = zzieVar.zza;
            if (bArr == null) {
                zzieVar.zza = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            boolean z = i2 != 0;
            zzvzVar2 = zzl(zzl, j2, zzieVar.zza, i3);
            long j3 = j2 + i3;
            if (z) {
                zzfpVar.zzH(2);
                zzvzVar2 = zzl(zzvzVar2, j3, zzfpVar.zzM(), 2);
                j3 += 2;
                i = zzfpVar.zzq();
            }
            int i4 = i;
            int[] iArr = zzieVar.zzd;
            if (iArr == null || iArr.length < i4) {
                iArr = new int[i4];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzieVar.zze;
            if (iArr3 == null || iArr3.length < i4) {
                iArr3 = new int[i4];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i5 = i4 * 6;
                zzfpVar.zzH(i5);
                zzvzVar2 = zzl(zzvzVar2, j3, zzfpVar.zzM(), i5);
                j3 += i5;
                zzfpVar.zzK(0);
                for (int i6 = 0; i6 < i4; i6++) {
                    iArr2[i6] = zzfpVar.zzq();
                    iArr4[i6] = zzfpVar.zzp();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzwcVar.zza - ((int) (j3 - zzwcVar.zzb));
            }
            zzadz zzadzVar = zzwcVar.zzc;
            int i7 = zzfy.zza;
            zzieVar.zzc(i4, iArr2, iArr4, zzadzVar.zzb, zzieVar.zza, zzadzVar.zza, zzadzVar.zzc, zzadzVar.zzd);
            long j4 = zzwcVar.zzb;
            int i8 = (int) (j3 - j4);
            zzwcVar.zzb = j4 + i8;
            zzwcVar.zza -= i8;
        } else {
            zzvzVar2 = zzvzVar;
        }
        if (zzihVar.zze()) {
            zzfpVar.zzH(4);
            zzvz zzl2 = zzl(zzvzVar2, zzwcVar.zzb, zzfpVar.zzM(), 4);
            int zzp = zzfpVar.zzp();
            zzwcVar.zzb += 4;
            zzwcVar.zza -= 4;
            zzihVar.zzi(zzp);
            zzvz zzk = zzk(zzl2, zzwcVar.zzb, zzihVar.zzc, zzp);
            zzwcVar.zzb += zzp;
            int i9 = zzwcVar.zza - zzp;
            zzwcVar.zza = i9;
            ByteBuffer byteBuffer = zzihVar.zzf;
            if (byteBuffer == null || byteBuffer.capacity() < i9) {
                zzihVar.zzf = ByteBuffer.allocate(i9);
            } else {
                zzihVar.zzf.clear();
            }
            return zzk(zzk, zzwcVar.zzb, zzihVar.zzf, zzwcVar.zza);
        }
        zzihVar.zzi(zzwcVar.zza);
        return zzk(zzvzVar2, zzwcVar.zzb, zzihVar.zzc, zzwcVar.zza);
    }

    private final void zzn(int i) {
        long j = this.zze + i;
        this.zze = j;
        zzvz zzvzVar = this.zzd;
        if (j == zzvzVar.zzb) {
            this.zzd = zzvzVar.zzd;
        }
    }

    public final int zza(zzu zzuVar, int i, boolean z) throws IOException {
        int zzi = zzi(i);
        zzvz zzvzVar = this.zzd;
        int zza = zzuVar.zza(zzvzVar.zzc.zza, zzvzVar.zza(this.zze), zzi);
        if (zza != -1) {
            zzn(zza);
            return zza;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public final long zzb() {
        return this.zze;
    }

    public final void zzc(long j) {
        zzvz zzvzVar;
        if (j != -1) {
            while (true) {
                zzvzVar = this.zzb;
                if (j < zzvzVar.zzb) {
                    break;
                }
                this.zzf.zzc(zzvzVar.zzc);
                this.zzb = this.zzb.zzb();
            }
            if (this.zzc.zza < zzvzVar.zza) {
                this.zzc = zzvzVar;
            }
        }
    }

    public final void zzd(zzih zzihVar, zzwc zzwcVar) {
        zzm(this.zzc, zzihVar, zzwcVar, this.zza);
    }

    public final void zze(zzih zzihVar, zzwc zzwcVar) {
        this.zzc = zzm(this.zzc, zzihVar, zzwcVar, this.zza);
    }

    public final void zzf() {
        zzvz zzvzVar = this.zzb;
        if (zzvzVar.zzc != null) {
            this.zzf.zzd(zzvzVar);
            zzvzVar.zzb();
        }
        this.zzb.zze(0L, 65536);
        zzvz zzvzVar2 = this.zzb;
        this.zzc = zzvzVar2;
        this.zzd = zzvzVar2;
        this.zze = 0L;
        this.zzf.zzg();
    }

    public final void zzg() {
        this.zzc = this.zzb;
    }

    public final void zzh(zzfp zzfpVar, int i) {
        while (i > 0) {
            int zzi = zzi(i);
            zzvz zzvzVar = this.zzd;
            zzfpVar.zzG(zzvzVar.zzc.zza, zzvzVar.zza(this.zze), zzi);
            i -= zzi;
            zzn(zzi);
        }
    }
}

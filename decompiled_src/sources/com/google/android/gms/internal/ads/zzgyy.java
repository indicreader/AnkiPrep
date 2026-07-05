package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgyy extends zzgyv {
    private final OutputStream zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgyy(OutputStream outputStream, int i) {
        super(i);
        this.zzg = outputStream;
    }

    private final void zzF() throws IOException {
        this.zzg.write(this.zza, 0, this.zzc);
        this.zzc = 0;
    }

    private final void zzG(int i) throws IOException {
        if (this.zzb - this.zzc < i) {
            zzF();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzH() throws IOException {
        if (this.zzc > 0) {
            zzF();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzI(byte b) throws IOException {
        if (this.zzc == this.zzb) {
            zzF();
        }
        zzc(b);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzJ(int i, boolean z) throws IOException {
        zzG(11);
        zzf(i << 3);
        zzc(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzK(int i, zzgyl zzgylVar) throws IOException {
        zzs((i << 3) | 2);
        zzs(zzgylVar.zzd());
        zzgylVar.zzo(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgza, com.google.android.gms.internal.ads.zzgya
    public final void zza(byte[] bArr, int i, int i2) throws IOException {
        zzp(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzh(int i, int i2) throws IOException {
        zzG(14);
        zzf((i << 3) | 5);
        zzd(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzi(int i) throws IOException {
        zzG(4);
        zzd(i);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzj(int i, long j) throws IOException {
        zzG(18);
        zzf((i << 3) | 1);
        zze(j);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzk(long j) throws IOException {
        zzG(8);
        zze(j);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzl(int i, int i2) throws IOException {
        zzG(20);
        zzf(i << 3);
        if (i2 >= 0) {
            zzf(i2);
        } else {
            zzg(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzm(int i) throws IOException {
        if (i >= 0) {
            zzs(i);
        } else {
            zzu(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzn(int i, zzhbe zzhbeVar, zzhby zzhbyVar) throws IOException {
        zzs((i << 3) | 2);
        zzs(((zzgxt) zzhbeVar).zzat(zzhbyVar));
        zzhbyVar.zzm(zzhbeVar, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzo(int i, String str) throws IOException {
        zzs((i << 3) | 2);
        zzv(str);
    }

    public final void zzp(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.zzb;
        int i4 = this.zzc;
        int i5 = i3 - i4;
        if (i5 >= i2) {
            System.arraycopy(bArr, i, this.zza, i4, i2);
            this.zzc += i2;
            this.zzd += i2;
            return;
        }
        System.arraycopy(bArr, i, this.zza, i4, i5);
        int i6 = i + i5;
        this.zzc = this.zzb;
        this.zzd += i5;
        zzF();
        int i7 = i2 - i5;
        if (i7 <= this.zzb) {
            System.arraycopy(bArr, i6, this.zza, 0, i7);
            this.zzc = i7;
        } else {
            this.zzg.write(bArr, i6, i7);
        }
        this.zzd += i7;
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzq(int i, int i2) throws IOException {
        zzs((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzr(int i, int i2) throws IOException {
        zzG(20);
        zzf(i << 3);
        zzf(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzs(int i) throws IOException {
        zzG(5);
        zzf(i);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzt(int i, long j) throws IOException {
        zzG(20);
        zzf(i << 3);
        zzg(j);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzu(long j) throws IOException {
        zzG(10);
        zzg(j);
    }

    public final void zzv(String str) throws IOException {
        int zze;
        try {
            int length = str.length() * 3;
            int zzz = zzz(length);
            int i = zzz + length;
            int i2 = this.zzb;
            if (i <= i2) {
                if (i > i2 - this.zzc) {
                    zzF();
                }
                int zzz2 = zzz(str.length());
                int i3 = this.zzc;
                try {
                    if (zzz2 == zzz) {
                        int i4 = i3 + zzz2;
                        this.zzc = i4;
                        int zzd = zzhde.zzd(str, this.zza, i4, this.zzb - i4);
                        this.zzc = i3;
                        zze = (zzd - i3) - zzz2;
                        zzf(zze);
                        this.zzc = zzd;
                    } else {
                        zze = zzhde.zze(str);
                        zzf(zze);
                        this.zzc = zzhde.zzd(str, this.zza, this.zzc, zze);
                    }
                    this.zzd += zze;
                    return;
                } catch (zzhdd e) {
                    this.zzd -= this.zzc - i3;
                    this.zzc = i3;
                    throw e;
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new zzgyx(e2);
                }
            }
            byte[] bArr = new byte[length];
            int zzd2 = zzhde.zzd(str, bArr, 0, length);
            zzs(zzd2);
            zzp(bArr, 0, zzd2);
        } catch (zzhdd e3) {
            zzD(str, e3);
        }
    }
}

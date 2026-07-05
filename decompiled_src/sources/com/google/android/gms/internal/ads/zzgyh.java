package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public class zzgyh extends zzgyg {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgyh(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgyl) || zzd() != ((zzgyl) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (obj instanceof zzgyh) {
            zzgyh zzgyhVar = (zzgyh) obj;
            int zzr = zzr();
            int zzr2 = zzgyhVar.zzr();
            if (zzr == 0 || zzr2 == 0 || zzr == zzr2) {
                return zzg(zzgyhVar, 0, zzd());
            }
            return false;
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public byte zza(int i) {
        return this.zza[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgyl
    public byte zzb(int i) {
        return this.zza[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public int zzd() {
        return this.zza.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgyl
    public void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzgyg
    final boolean zzg(zzgyl zzgylVar, int i, int i2) {
        if (i2 > zzgylVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + i2 + zzd());
        }
        int i3 = i + i2;
        if (i3 <= zzgylVar.zzd()) {
            if (zzgylVar instanceof zzgyh) {
                zzgyh zzgyhVar = (zzgyh) zzgylVar;
                byte[] bArr = this.zza;
                byte[] bArr2 = zzgyhVar.zza;
                int zzc = zzc() + i2;
                int zzc2 = zzc();
                int zzc3 = zzgyhVar.zzc() + i;
                while (zzc2 < zzc) {
                    if (bArr[zzc2] != bArr2[zzc3]) {
                        return false;
                    }
                    zzc2++;
                    zzc3++;
                }
                return true;
            }
            return zzgylVar.zzk(i, i3).equals(zzk(0, i2));
        }
        throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + zzgylVar.zzd());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgyl
    public final int zzi(int i, int i2, int i3) {
        return zzhae.zzb(i, this.zza, zzc() + i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgyl
    public final int zzj(int i, int i2, int i3) {
        int zzc = zzc() + i2;
        return zzhde.zzf(i, this.zza, zzc, i3 + zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final zzgyl zzk(int i, int i2) {
        int zzq = zzq(i, i2, zzd());
        return zzq == 0 ? zzgyl.zzb : new zzgye(this.zza, zzc() + i, zzq);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final zzgyt zzl() {
        return zzgyt.zzI(this.zza, zzc(), zzd(), true);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    protected final String zzm(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final ByteBuffer zzn() {
        return ByteBuffer.wrap(this.zza, zzc(), zzd()).asReadOnlyBuffer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgyl
    public final void zzo(zzgya zzgyaVar) throws IOException {
        zzgyaVar.zza(this.zza, zzc(), zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final boolean zzp() {
        int zzc = zzc();
        return zzhde.zzj(this.zza, zzc, zzd() + zzc);
    }
}

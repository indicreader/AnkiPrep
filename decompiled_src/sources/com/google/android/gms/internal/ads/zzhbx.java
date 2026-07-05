package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhbx extends zzgyl {
    static final int[] zza = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzc;
    private final zzgyl zzd;
    private final zzgyl zze;
    private final int zzf;
    private final int zzg;

    private zzhbx(zzgyl zzgylVar, zzgyl zzgylVar2) {
        this.zzd = zzgylVar;
        this.zze = zzgylVar2;
        int zzd = zzgylVar.zzd();
        this.zzf = zzd;
        this.zzc = zzd + zzgylVar2.zzd();
        this.zzg = Math.max(zzgylVar.zzf(), zzgylVar2.zzf()) + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgyl zzC(zzgyl zzgylVar, zzgyl zzgylVar2) {
        if (zzgylVar2.zzd() == 0) {
            return zzgylVar;
        }
        if (zzgylVar.zzd() == 0) {
            return zzgylVar2;
        }
        int zzd = zzgylVar.zzd() + zzgylVar2.zzd();
        if (zzd < 128) {
            return zzD(zzgylVar, zzgylVar2);
        }
        if (zzgylVar instanceof zzhbx) {
            zzhbx zzhbxVar = (zzhbx) zzgylVar;
            if (zzhbxVar.zze.zzd() + zzgylVar2.zzd() < 128) {
                return new zzhbx(zzhbxVar.zzd, zzD(zzhbxVar.zze, zzgylVar2));
            }
            if (zzhbxVar.zzd.zzf() > zzhbxVar.zze.zzf() && zzhbxVar.zzg > zzgylVar2.zzf()) {
                return new zzhbx(zzhbxVar.zzd, new zzhbx(zzhbxVar.zze, zzgylVar2));
            }
        }
        if (zzd >= zzc(Math.max(zzgylVar.zzf(), zzgylVar2.zzf()) + 1)) {
            return new zzhbx(zzgylVar, zzgylVar2);
        }
        return zzhbt.zza(new zzhbt(null), zzgylVar, zzgylVar2);
    }

    private static zzgyl zzD(zzgyl zzgylVar, zzgyl zzgylVar2) {
        int zzd = zzgylVar.zzd();
        int zzd2 = zzgylVar2.zzd();
        byte[] bArr = new byte[zzd + zzd2];
        zzgylVar.zzz(bArr, 0, 0, zzd);
        zzgylVar2.zzz(bArr, 0, zzd, zzd2);
        return new zzgyh(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i) {
        int[] iArr = zza;
        int length = iArr.length;
        if (i >= 47) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final boolean equals(Object obj) {
        boolean zzg;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgyl)) {
            return false;
        }
        zzgyl zzgylVar = (zzgyl) obj;
        if (this.zzc != zzgylVar.zzd()) {
            return false;
        }
        if (this.zzc == 0) {
            return true;
        }
        int zzr = zzr();
        int zzr2 = zzgylVar.zzr();
        if (zzr != 0 && zzr2 != 0 && zzr != zzr2) {
            return false;
        }
        zzhbu zzhbuVar = null;
        zzhbv zzhbvVar = new zzhbv(this, zzhbuVar);
        zzgyg next = zzhbvVar.next();
        zzhbv zzhbvVar2 = new zzhbv(zzgylVar, zzhbuVar);
        zzgyg next2 = zzhbvVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int zzd = next.zzd() - i;
            int zzd2 = next2.zzd() - i2;
            int min = Math.min(zzd, zzd2);
            if (i == 0) {
                zzg = next.zzg(next2, i2, min);
            } else {
                zzg = next2.zzg(next, i, min);
            }
            if (!zzg) {
                return false;
            }
            i3 += min;
            int i4 = this.zzc;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == zzd) {
                next = zzhbvVar.next();
                i = 0;
            } else {
                i += min;
                next = next;
            }
            if (min == zzd2) {
                next2 = zzhbvVar2.next();
                i2 = 0;
            } else {
                i2 += min;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyl, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzhbr(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final byte zza(int i) {
        zzy(i, this.zzc);
        return zzb(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgyl
    public final byte zzb(int i) {
        int i2 = this.zzf;
        if (i < i2) {
            return this.zzd.zzb(i);
        }
        return this.zze.zzb(i - i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final int zzd() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgyl
    public final void zze(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            this.zzd.zze(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.zze.zze(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.zzd.zze(bArr, i, i2, i6);
            this.zze.zze(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgyl
    public final int zzf() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgyl
    public final boolean zzh() {
        return this.zzc >= zzc(this.zzg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgyl
    public final int zzi(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return this.zzd.zzi(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zze.zzi(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zze.zzi(this.zzd.zzi(i, i2, i6), 0, i3 - i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgyl
    public final int zzj(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return this.zzd.zzj(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zze.zzj(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zze.zzj(this.zzd.zzj(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final zzgyl zzk(int i, int i2) {
        int zzq = zzq(i, i2, this.zzc);
        if (zzq == 0) {
            return zzgyl.zzb;
        }
        if (zzq == this.zzc) {
            return this;
        }
        int i3 = this.zzf;
        if (i2 <= i3) {
            return this.zzd.zzk(i, i2);
        }
        if (i >= i3) {
            return this.zze.zzk(i - i3, i2 - i3);
        }
        zzgyl zzgylVar = this.zzd;
        return new zzhbx(zzgylVar.zzk(i, zzgylVar.zzd()), this.zze.zzk(0, i2 - this.zzf));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzgyl
    public final zzgyt zzl() {
        ArrayList<ByteBuffer> arrayList = new ArrayList();
        Object[] objArr = 0;
        zzhbv zzhbvVar = new zzhbv(this, null);
        while (zzhbvVar.hasNext()) {
            arrayList.add(zzhbvVar.next().zzn());
        }
        int i = zzgyt.zzd;
        int i2 = 0;
        int i3 = 0;
        for (ByteBuffer byteBuffer : arrayList) {
            i3 += byteBuffer.remaining();
            if (byteBuffer.hasArray()) {
                i2 |= 1;
            } else {
                i2 = byteBuffer.isDirect() ? i2 | 2 : i2 | 4;
            }
        }
        if (i2 == 2) {
            return new zzgyp(arrayList, i3, true, objArr == true ? 1 : 0);
        }
        return zzgyt.zzH(new zzhah(arrayList), 4096);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    protected final String zzm(Charset charset) {
        return new String(zzA(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final ByteBuffer zzn() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgyl
    public final void zzo(zzgya zzgyaVar) throws IOException {
        this.zzd.zzo(zzgyaVar);
        this.zze.zzo(zzgyaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final boolean zzp() {
        zzgyl zzgylVar = this.zzd;
        zzgyl zzgylVar2 = this.zze;
        return zzgylVar2.zzj(zzgylVar.zzj(0, 0, this.zzf), 0, zzgylVar2.zzd()) == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    /* renamed from: zzs */
    public final zzgyf iterator() {
        return new zzhbr(this);
    }
}

package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzam {
    public final int zzA;
    public final int zzB;
    public final int zzC;
    public final int zzD;
    public final int zzE;
    public final int zzF;
    public final int zzG;
    private int zzao;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final String zzj;
    public final zzby zzk;
    public final String zzl;
    public final String zzm;
    public final int zzn;
    public final List zzo;
    public final zzae zzp;
    public final long zzq;
    public final int zzr;
    public final int zzs;
    public final float zzt;
    public final int zzu;
    public final float zzv;
    public final byte[] zzw;
    public final int zzx;
    public final zzt zzy;
    public final int zzz;
    private static final zzam zzH = new zzam(new zzak());
    private static final String zzI = Integer.toString(0, 36);
    private static final String zzJ = Integer.toString(1, 36);
    private static final String zzK = Integer.toString(2, 36);
    private static final String zzL = Integer.toString(3, 36);
    private static final String zzM = Integer.toString(4, 36);
    private static final String zzN = Integer.toString(5, 36);
    private static final String zzO = Integer.toString(6, 36);
    private static final String zzP = Integer.toString(7, 36);
    private static final String zzQ = Integer.toString(8, 36);
    private static final String zzR = Integer.toString(9, 36);
    private static final String zzS = Integer.toString(10, 36);
    private static final String zzT = Integer.toString(11, 36);
    private static final String zzU = Integer.toString(12, 36);
    private static final String zzV = Integer.toString(13, 36);
    private static final String zzW = Integer.toString(14, 36);
    private static final String zzX = Integer.toString(15, 36);
    private static final String zzY = Integer.toString(16, 36);
    private static final String zzZ = Integer.toString(17, 36);
    private static final String zzaa = Integer.toString(18, 36);
    private static final String zzab = Integer.toString(19, 36);
    private static final String zzac = Integer.toString(20, 36);
    private static final String zzad = Integer.toString(21, 36);
    private static final String zzae = Integer.toString(22, 36);
    private static final String zzaf = Integer.toString(23, 36);
    private static final String zzag = Integer.toString(24, 36);
    private static final String zzah = Integer.toString(25, 36);
    private static final String zzai = Integer.toString(26, 36);
    private static final String zzaj = Integer.toString(27, 36);
    private static final String zzak = Integer.toString(28, 36);
    private static final String zzal = Integer.toString(29, 36);
    private static final String zzam = Integer.toString(30, 36);
    private static final String zzan = Integer.toString(31, 36);

    @Deprecated
    public static final zzn zza = new zzn() { // from class: com.google.android.gms.internal.ads.zzai
    };

    private zzam(zzak zzakVar) {
        this.zzb = zzak.zzag(zzakVar);
        this.zzc = zzak.zzah(zzakVar);
        this.zzd = zzfy.zzC(zzak.zzai(zzakVar));
        this.zze = zzak.zzq(zzakVar);
        this.zzf = zzak.zzn(zzakVar);
        int zzd = zzak.zzd(zzakVar);
        this.zzg = zzd;
        int zzm = zzak.zzm(zzakVar);
        this.zzh = zzm;
        this.zzi = zzm != -1 ? zzm : zzd;
        this.zzj = zzak.zzae(zzakVar);
        this.zzk = zzak.zzad(zzakVar);
        this.zzl = zzak.zzaf(zzakVar);
        this.zzm = zzak.zzaj(zzakVar);
        this.zzn = zzak.zzk(zzakVar);
        this.zzo = zzak.zzak(zzakVar) == null ? Collections.emptyList() : zzak.zzak(zzakVar);
        zzae zzv = zzak.zzv(zzakVar);
        this.zzp = zzv;
        this.zzq = zzak.zzt(zzakVar);
        this.zzr = zzak.zzs(zzakVar);
        this.zzs = zzak.zzj(zzakVar);
        this.zzt = zzak.zza(zzakVar);
        this.zzu = zzak.zzo(zzakVar) == -1 ? 0 : zzak.zzo(zzakVar);
        this.zzv = zzak.zzb(zzakVar) == -1.0f ? 1.0f : zzak.zzb(zzakVar);
        this.zzw = zzak.zzal(zzakVar);
        this.zzx = zzak.zzr(zzakVar);
        this.zzy = zzak.zzu(zzakVar);
        this.zzz = zzak.zze(zzakVar);
        this.zzA = zzak.zzp(zzakVar);
        this.zzB = zzak.zzl(zzakVar);
        this.zzC = zzak.zzh(zzakVar) == -1 ? 0 : zzak.zzh(zzakVar);
        this.zzD = zzak.zzi(zzakVar) != -1 ? zzak.zzi(zzakVar) : 0;
        this.zzE = zzak.zzc(zzakVar);
        this.zzF = zzak.zzg(zzakVar);
        this.zzG = (zzak.zzf(zzakVar) != 0 || zzv == null) ? zzak.zzf(zzakVar) : 1;
    }

    public final boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzam zzamVar = (zzam) obj;
            int i2 = this.zzao;
            if ((i2 == 0 || (i = zzamVar.zzao) == 0 || i2 == i) && this.zze == zzamVar.zze && this.zzf == zzamVar.zzf && this.zzg == zzamVar.zzg && this.zzh == zzamVar.zzh && this.zzn == zzamVar.zzn && this.zzq == zzamVar.zzq && this.zzr == zzamVar.zzr && this.zzs == zzamVar.zzs && this.zzu == zzamVar.zzu && this.zzx == zzamVar.zzx && this.zzz == zzamVar.zzz && this.zzA == zzamVar.zzA && this.zzB == zzamVar.zzB && this.zzC == zzamVar.zzC && this.zzD == zzamVar.zzD && this.zzE == zzamVar.zzE && this.zzG == zzamVar.zzG && Float.compare(this.zzt, zzamVar.zzt) == 0 && Float.compare(this.zzv, zzamVar.zzv) == 0 && zzfy.zzF(this.zzb, zzamVar.zzb) && zzfy.zzF(this.zzc, zzamVar.zzc) && zzfy.zzF(this.zzj, zzamVar.zzj) && zzfy.zzF(this.zzl, zzamVar.zzl) && zzfy.zzF(this.zzm, zzamVar.zzm) && zzfy.zzF(this.zzd, zzamVar.zzd) && Arrays.equals(this.zzw, zzamVar.zzw) && zzfy.zzF(this.zzk, zzamVar.zzk) && zzfy.zzF(this.zzy, zzamVar.zzy) && zzfy.zzF(this.zzp, zzamVar.zzp) && zzd(zzamVar)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzao;
        if (i != 0) {
            return i;
        }
        String str = this.zzb;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.zzc;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        int i2 = hashCode + 527;
        String str3 = this.zzd;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        int i3 = (i2 * 31) + hashCode2;
        int i4 = this.zze;
        int i5 = this.zzf;
        int i6 = this.zzg;
        int i7 = this.zzh;
        String str4 = this.zzj;
        int hashCode4 = ((((((((((((i3 * 31) + hashCode3) * 31) + i4) * 31) + i5) * 31) + i6) * 31) + i7) * 31) + (str4 == null ? 0 : str4.hashCode())) * 31;
        zzby zzbyVar = this.zzk;
        int hashCode5 = (hashCode4 + (zzbyVar == null ? 0 : zzbyVar.hashCode())) * 31;
        String str5 = this.zzl;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        int hashCode7 = ((((((((((((((((((((((((((((((((((hashCode6 + (this.zzm != null ? r2.hashCode() : 0)) * 31) + this.zzn) * 31) + ((int) this.zzq)) * 31) + this.zzr) * 31) + this.zzs) * 31) + Float.floatToIntBits(this.zzt)) * 31) + this.zzu) * 31) + Float.floatToIntBits(this.zzv)) * 31) + this.zzx) * 31) + this.zzz) * 31) + this.zzA) * 31) + this.zzB) * 31) + this.zzC) * 31) + this.zzD) * 31) + this.zzE) * 31) - 1) * 31) - 1) * 31) + this.zzG;
        this.zzao = hashCode7;
        return hashCode7;
    }

    public final String toString() {
        return "Format(" + this.zzb + ", " + this.zzc + ", " + this.zzl + ", " + this.zzm + ", " + this.zzj + ", " + this.zzi + ", " + this.zzd + ", [" + this.zzr + ", " + this.zzs + ", " + this.zzt + ", " + String.valueOf(this.zzy) + "], [" + this.zzz + ", " + this.zzA + "])";
    }

    public final int zza() {
        int i;
        int i2 = this.zzr;
        if (i2 == -1 || (i = this.zzs) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public final zzak zzb() {
        return new zzak(this, null);
    }

    public final zzam zzc(int i) {
        zzak zzakVar = new zzak(this, null);
        zzakVar.zzC(i);
        return new zzam(zzakVar);
    }

    public final boolean zzd(zzam zzamVar) {
        if (this.zzo.size() != zzamVar.zzo.size()) {
            return false;
        }
        for (int i = 0; i < this.zzo.size(); i++) {
            if (!Arrays.equals((byte[]) this.zzo.get(i), (byte[]) zzamVar.zzo.get(i))) {
                return false;
            }
        }
        return true;
    }
}

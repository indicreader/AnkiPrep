package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Locale;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzt {
    public static final zzt zza;
    public static final zzt zzb;

    @Deprecated
    public static final zzn zzc;
    private static final String zzj;
    private static final String zzk;
    private static final String zzl;
    private static final String zzm;
    private static final String zzn;
    private static final String zzo;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final byte[] zzg;
    public final int zzh;
    public final int zzi;
    private int zzp;

    static {
        zzr zzrVar = new zzr();
        zzrVar.zzc(1);
        zzrVar.zzb(2);
        zzrVar.zzd(3);
        zza = zzrVar.zzg();
        zzr zzrVar2 = new zzr();
        zzrVar2.zzc(1);
        zzrVar2.zzb(1);
        zzrVar2.zzd(2);
        zzb = zzrVar2.zzg();
        zzj = Integer.toString(0, 36);
        zzk = Integer.toString(1, 36);
        zzl = Integer.toString(2, 36);
        zzm = Integer.toString(3, 36);
        zzn = Integer.toString(4, 36);
        zzo = Integer.toString(5, 36);
        zzc = new zzn() { // from class: com.google.android.gms.internal.ads.zzp
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzt(int i, int i2, int i3, byte[] bArr, int i4, int i5, zzs zzsVar) {
        this.zzd = i;
        this.zze = i2;
        this.zzf = i3;
        this.zzg = bArr;
        this.zzh = i4;
        this.zzi = i5;
    }

    @Pure
    public static int zza(int i) {
        if (i == 1) {
            return 1;
        }
        if (i != 9) {
            return (i == 4 || i == 5 || i == 6 || i == 7) ? 2 : -1;
        }
        return 6;
    }

    @Pure
    public static int zzb(int i) {
        if (i == 1) {
            return 3;
        }
        if (i == 4) {
            return 10;
        }
        if (i == 13) {
            return 2;
        }
        if (i == 16) {
            return 6;
        }
        if (i != 18) {
            return (i == 6 || i == 7) ? 3 : -1;
        }
        return 7;
    }

    private static String zzg(int i) {
        return i != -1 ? i != 1 ? i != 2 ? "Undefined color range" : "Limited range" : "Full range" : "Unset color range";
    }

    private static String zzh(int i) {
        return i != -1 ? i != 6 ? i != 1 ? i != 2 ? "Undefined color space" : "BT601" : "BT709" : "BT2020" : "Unset color space";
    }

    private static String zzi(int i) {
        return i != -1 ? i != 10 ? i != 1 ? i != 2 ? i != 3 ? i != 6 ? i != 7 ? "Undefined color transfer" : "HLG" : "ST2084 PQ" : "SDR SMPTE 170M" : "sRGB" : "Linear" : "Gamma 2.2" : "Unset color transfer";
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzt zztVar = (zzt) obj;
            if (this.zzd == zztVar.zzd && this.zze == zztVar.zze && this.zzf == zztVar.zzf && Arrays.equals(this.zzg, zztVar.zzg) && this.zzh == zztVar.zzh && this.zzi == zztVar.zzi) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzp;
        if (i != 0) {
            return i;
        }
        int hashCode = ((((((((((this.zzd + 527) * 31) + this.zze) * 31) + this.zzf) * 31) + Arrays.hashCode(this.zzg)) * 31) + this.zzh) * 31) + this.zzi;
        this.zzp = hashCode;
        return hashCode;
    }

    public final String toString() {
        String str;
        int i = this.zzh;
        String str2 = "NA";
        if (i != -1) {
            str = i + "bit Luma";
        } else {
            str = "NA";
        }
        int i2 = this.zzi;
        if (i2 != -1) {
            str2 = i2 + "bit Chroma";
        }
        byte[] bArr = this.zzg;
        int i3 = this.zzf;
        int i4 = this.zze;
        int i5 = this.zzd;
        return "ColorInfo(" + zzh(i5) + ", " + zzg(i4) + ", " + zzi(i3) + ", " + (bArr != null) + ", " + str + ", " + str2 + ")";
    }

    public final zzr zzc() {
        return new zzr(this, null);
    }

    public final String zzd() {
        String str;
        String str2;
        if (zzf()) {
            str = String.format(Locale.US, "%s/%s/%s", zzh(this.zzd), zzg(this.zze), zzi(this.zzf));
        } else {
            str = "NA/NA/NA";
        }
        if (zze()) {
            str2 = this.zzh + "/" + this.zzi;
        } else {
            str2 = "NA/NA";
        }
        return str + "/" + str2;
    }

    public final boolean zze() {
        return (this.zzh == -1 || this.zzi == -1) ? false : true;
    }

    public final boolean zzf() {
        return (this.zzd == -1 || this.zze == -1 || this.zzf == -1) ? false : true;
    }
}

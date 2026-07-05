package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgc implements zzbx {
    public static final Parcelable.Creator<zzgc> CREATOR = new zzga();
    public final String zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgc(Parcel parcel, zzgb zzgbVar) {
        String readString = parcel.readString();
        int i = zzfy.zza;
        this.zza = readString;
        this.zzb = parcel.createByteArray();
        this.zzc = parcel.readInt();
        this.zzd = parcel.readInt();
    }

    public zzgc(String str, byte[] bArr, int i, int i2) {
        this.zza = str;
        this.zzb = bArr;
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzgc zzgcVar = (zzgc) obj;
            if (this.zza.equals(zzgcVar.zza) && Arrays.equals(this.zzb, zzgcVar.zzb) && this.zzc == zzgcVar.zzc && this.zzd == zzgcVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.zza.hashCode() + 527) * 31) + Arrays.hashCode(this.zzb)) * 31) + this.zzc) * 31) + this.zzd;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeInt(this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzbx
    public final /* synthetic */ void zza(zzbt zzbtVar) {
    }

    public final String toString() {
        String zzz;
        int i = this.zzd;
        if (i != 1) {
            if (i == 23) {
                byte[] bArr = this.zzb;
                int i2 = zzfy.zza;
                zzek.zzd(bArr.length == 4);
                zzz = String.valueOf(Float.intBitsToFloat((bArr[3] & 255) | ((bArr[1] & 255) << 16) | (bArr[0] << Ascii.CAN) | ((bArr[2] & 255) << 8)));
            } else if (i == 67) {
                byte[] bArr2 = this.zzb;
                int i3 = zzfy.zza;
                zzek.zzd(bArr2.length == 4);
                zzz = String.valueOf(bArr2[3] | (bArr2[1] << Ascii.DLE) | (bArr2[0] << Ascii.CAN) | (bArr2[2] << 8));
            } else {
                byte[] bArr3 = this.zzb;
                int length = bArr3.length;
                StringBuilder sb = new StringBuilder(length + length);
                for (int i4 = 0; i4 < bArr3.length; i4++) {
                    sb.append(Character.forDigit((bArr3[i4] >> 4) & 15, 16));
                    sb.append(Character.forDigit(bArr3[i4] & Ascii.SI, 16));
                }
                zzz = sb.toString();
            }
        } else {
            zzz = zzfy.zzz(this.zzb);
        }
        return "mdta: key=" + this.zza + ", value=" + zzz;
    }
}

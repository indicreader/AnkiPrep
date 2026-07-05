package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzagg extends zzagr {
    public static final Parcelable.Creator<zzagg> CREATOR = new zzagf();
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final long zze;
    private final zzagr[] zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagg(Parcel parcel) {
        super("CHAP");
        String readString = parcel.readString();
        int i = zzfy.zza;
        this.zza = readString;
        this.zzb = parcel.readInt();
        this.zzc = parcel.readInt();
        this.zzd = parcel.readLong();
        this.zze = parcel.readLong();
        int readInt = parcel.readInt();
        this.zzg = new zzagr[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.zzg[i2] = (zzagr) parcel.readParcelable(zzagr.class.getClassLoader());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzagr, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzagg zzaggVar = (zzagg) obj;
            if (this.zzb == zzaggVar.zzb && this.zzc == zzaggVar.zzc && this.zzd == zzaggVar.zzd && this.zze == zzaggVar.zze && zzfy.zzF(this.zza, zzaggVar.zza) && Arrays.equals(this.zzg, zzaggVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        return ((((((((this.zzb + 527) * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + ((int) this.zze)) * 31) + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeLong(this.zze);
        parcel.writeInt(this.zzg.length);
        for (zzagr zzagrVar : this.zzg) {
            parcel.writeParcelable(zzagrVar, 0);
        }
    }

    public zzagg(String str, int i, int i2, long j, long j2, zzagr[] zzagrVarArr) {
        super("CHAP");
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = j;
        this.zze = j2;
        this.zzg = zzagrVarArr;
    }
}

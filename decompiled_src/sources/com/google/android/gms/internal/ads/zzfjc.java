package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes3.dex */
public final class zzfjc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfjc> CREATOR = new zzfjd();

    @Nullable
    public final Context zza;
    public final zzfiz zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final String zzf;
    public final int zzg;
    private final zzfiz[] zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int[] zzl;
    private final int[] zzm;

    public zzfjc(int i, int i2, int i3, int i4, String str, int i5, int i6) {
        zzfiz[] values = zzfiz.values();
        this.zzh = values;
        int[] zza = zzfja.zza();
        this.zzl = zza;
        int[] zza2 = zzfjb.zza();
        this.zzm = zza2;
        this.zza = null;
        this.zzi = i;
        this.zzb = values[i];
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = str;
        this.zzj = i5;
        this.zzg = zza[i5];
        this.zzk = i6;
        int i7 = zza2[i6];
    }

    @Nullable
    public static zzfjc zza(zzfiz zzfizVar, Context context) {
        if (zzfizVar == zzfiz.Rewarded) {
            return new zzfjc(context, zzfizVar, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgt)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgz)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgB)).intValue(), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgD), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgv), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgx));
        }
        if (zzfizVar == zzfiz.Interstitial) {
            return new zzfjc(context, zzfizVar, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgu)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgA)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgC)).intValue(), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgE), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgw), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgy));
        }
        if (zzfizVar != zzfiz.AppOpen) {
            return null;
        }
        return new zzfjc(context, zzfizVar, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgH)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgJ)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgK)).intValue(), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgF), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgG), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgI));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zzi;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeInt(parcel, 2, this.zzc);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 4, this.zze);
        SafeParcelWriter.writeString(parcel, 5, this.zzf, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzj);
        SafeParcelWriter.writeInt(parcel, 7, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private zzfjc(@Nullable Context context, zzfiz zzfizVar, int i, int i2, int i3, String str, String str2, String str3) {
        int i4;
        this.zzh = zzfiz.values();
        this.zzl = zzfja.zza();
        this.zzm = zzfjb.zza();
        this.zza = context;
        this.zzi = zzfizVar.ordinal();
        this.zzb = zzfizVar;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = str;
        if ("oldest".equals(str2)) {
            i4 = 1;
        } else {
            i4 = (!"lru".equals(str2) && "lfu".equals(str2)) ? 3 : 2;
        }
        this.zzg = i4;
        this.zzj = i4 - 1;
        "onAdClosed".equals(str3);
        this.zzk = 0;
    }
}

package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzfuu extends zzfvn {
    private final IBinder zza;
    private final String zzb;
    private final int zzc;
    private final float zzd;
    private final int zze;
    private final String zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfuu(IBinder iBinder, boolean z, String str, int i, float f, int i2, String str2, int i3, String str3, String str4, String str5, zzfut zzfutVar) {
        this.zza = iBinder;
        this.zzb = str;
        this.zzc = i;
        this.zzd = f;
        this.zze = i3;
        this.zzf = str4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfvn) {
            zzfvn zzfvnVar = (zzfvn) obj;
            if (this.zza.equals(zzfvnVar.zze())) {
                zzfvnVar.zzk();
                String str = this.zzb;
                if (str != null ? str.equals(zzfvnVar.zzg()) : zzfvnVar.zzg() == null) {
                    if (this.zzc == zzfvnVar.zzc() && Float.floatToIntBits(this.zzd) == Float.floatToIntBits(zzfvnVar.zza())) {
                        zzfvnVar.zzb();
                        zzfvnVar.zzi();
                        if (this.zze == zzfvnVar.zzd()) {
                            zzfvnVar.zzh();
                            String str2 = this.zzf;
                            if (str2 != null ? str2.equals(zzfvnVar.zzf()) : zzfvnVar.zzf() == null) {
                                zzfvnVar.zzj();
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.zza.hashCode() ^ 1000003;
        String str = this.zzb;
        int hashCode2 = (((((((hashCode * 1000003) ^ 1237) * 1000003) ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.zzc) * 1000003) ^ Float.floatToIntBits(this.zzd);
        int i = this.zze;
        String str2 = this.zzf;
        return ((((hashCode2 * 583896283) ^ i) * (-721379959)) ^ (str2 != null ? str2.hashCode() : 0)) * 1000003;
    }

    public final String toString() {
        return "OverlayDisplayShowRequest{windowToken=" + this.zza.toString() + ", stableSessionToken=false, appId=" + this.zzb + ", layoutGravity=" + this.zzc + ", layoutVerticalMargin=" + this.zzd + ", displayMode=0, sessionToken=null, windowWidthPx=" + this.zze + ", deeplinkUrl=null, adFieldEnifd=" + this.zzf + ", thirdPartyAuthCallerId=null}";
    }

    @Override // com.google.android.gms.internal.ads.zzfvn
    public final float zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzfvn
    public final int zzb() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfvn
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfvn
    public final int zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzfvn
    public final IBinder zze() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfvn
    public final String zzf() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzfvn
    public final String zzg() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfvn
    public final String zzh() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfvn
    public final String zzi() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfvn
    public final String zzj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfvn
    public final boolean zzk() {
        return false;
    }
}

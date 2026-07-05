package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdp {
    public final int zzc;
    public final int zzd;
    public final int zze = 0;
    public final float zzf;
    public static final zzdp zza = new zzdp(0, 0, 0, 1.0f);
    private static final String zzg = Integer.toString(0, 36);
    private static final String zzh = Integer.toString(1, 36);
    private static final String zzi = Integer.toString(2, 36);
    private static final String zzj = Integer.toString(3, 36);

    @Deprecated
    public static final zzn zzb = new zzn() { // from class: com.google.android.gms.internal.ads.zzdo
    };

    public zzdp(int i, int i2, int i3, float f) {
        this.zzc = i;
        this.zzd = i2;
        this.zzf = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzdp) {
            zzdp zzdpVar = (zzdp) obj;
            if (this.zzc == zzdpVar.zzc && this.zzd == zzdpVar.zzd) {
                int i = zzdpVar.zze;
                if (this.zzf == zzdpVar.zzf) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zzc + 217) * 31) + this.zzd) * 961) + Float.floatToRawIntBits(this.zzf);
    }
}

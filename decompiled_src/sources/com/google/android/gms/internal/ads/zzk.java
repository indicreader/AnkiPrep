package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzk {
    private zzi zzh;
    public static final zzk zza = new zzk(0, 0, 1, 1, 0, null);
    private static final String zzc = Integer.toString(0, 36);
    private static final String zzd = Integer.toString(1, 36);
    private static final String zze = Integer.toString(2, 36);
    private static final String zzf = Integer.toString(3, 36);
    private static final String zzg = Integer.toString(4, 36);

    @Deprecated
    public static final zzn zzb = new zzn() { // from class: com.google.android.gms.internal.ads.zze
    };

    /* synthetic */ zzk(int i, int i2, int i3, int i4, int i5, zzj zzjVar) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return 486696559;
    }

    public final zzi zza() {
        if (this.zzh == null) {
            this.zzh = new zzi(this, null);
        }
        return this.zzh;
    }
}

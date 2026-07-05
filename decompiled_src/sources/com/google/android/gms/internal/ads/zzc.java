package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzc {
    public final long zzc;
    public final int zzd;

    @Deprecated
    public final Uri[] zze;
    public final zzbp[] zzf;
    public final int[] zzg;
    public final long[] zzh;
    public final long zzi;
    public final boolean zzj;
    private static final String zzk = Integer.toString(0, 36);
    private static final String zzl = Integer.toString(1, 36);
    private static final String zzm = Integer.toString(2, 36);
    private static final String zzn = Integer.toString(3, 36);
    private static final String zzo = Integer.toString(4, 36);
    private static final String zzp = Integer.toString(5, 36);
    private static final String zzq = Integer.toString(6, 36);
    private static final String zzr = Integer.toString(7, 36);
    static final String zza = Integer.toString(8, 36);

    @Deprecated
    public static final zzn zzb = new zzn() { // from class: com.google.android.gms.internal.ads.zzb
    };

    public zzc(long j) {
        this(0L, -1, -1, new int[0], new zzbp[0], new long[0], 0L, false);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzc zzcVar = (zzc) obj;
            if (this.zzd == zzcVar.zzd && Arrays.equals(this.zzf, zzcVar.zzf) && Arrays.equals(this.zzg, zzcVar.zzg) && Arrays.equals(this.zzh, zzcVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.zzd * 31) - 1) * 961) + Arrays.hashCode(this.zzf)) * 31) + Arrays.hashCode(this.zzg)) * 31) + Arrays.hashCode(this.zzh)) * 961;
    }

    public final int zza(int i) {
        int i2;
        int i3 = i + 1;
        while (true) {
            int[] iArr = this.zzg;
            if (i3 >= iArr.length || (i2 = iArr[i3]) == 0 || i2 == 1) {
                break;
            }
            i3++;
        }
        return i3;
    }

    public final zzc zzb(int i) {
        int[] iArr = this.zzg;
        int length = iArr.length;
        int max = Math.max(0, length);
        int[] copyOf = Arrays.copyOf(iArr, max);
        Arrays.fill(copyOf, length, max, 0);
        long[] jArr = this.zzh;
        int length2 = jArr.length;
        int max2 = Math.max(0, length2);
        long[] copyOf2 = Arrays.copyOf(jArr, max2);
        Arrays.fill(copyOf2, length2, max2, -9223372036854775807L);
        return new zzc(0L, 0, -1, copyOf, (zzbp[]) Arrays.copyOf(this.zzf, 0), copyOf2, 0L, false);
    }

    private zzc(long j, int i, int i2, int[] iArr, zzbp[] zzbpVarArr, long[] jArr, long j2, boolean z) {
        Uri uri;
        int length = iArr.length;
        int length2 = zzbpVarArr.length;
        int i3 = 0;
        zzek.zzd(length == length2);
        this.zzc = 0L;
        this.zzd = i;
        this.zzg = iArr;
        this.zzf = zzbpVarArr;
        this.zzh = jArr;
        this.zzi = 0L;
        this.zzj = false;
        this.zze = new Uri[length2];
        while (true) {
            Uri[] uriArr = this.zze;
            if (i3 >= uriArr.length) {
                return;
            }
            zzbp zzbpVar = zzbpVarArr[i3];
            if (zzbpVar == null) {
                uri = null;
            } else {
                zzbi zzbiVar = zzbpVar.zzd;
                zzbiVar.getClass();
                uri = zzbiVar.zzb;
            }
            uriArr[i3] = uri;
            i3++;
        }
    }
}

package com.google.android.gms.internal.ads;

import java.io.IOException;
import okhttp3.internal.ws.RealWebSocket;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzahz {
    private final zzfp zza = new zzfp(8);
    private int zzb;

    private final long zzb(zzacv zzacvVar) throws IOException {
        int i;
        zzack zzackVar = (zzack) zzacvVar;
        int i2 = 0;
        zzackVar.zzm(this.zza.zzM(), 0, 1, false);
        int i3 = this.zza.zzM()[0] & 255;
        if (i3 == 0) {
            return Long.MIN_VALUE;
        }
        int i4 = 128;
        int i5 = 0;
        while (true) {
            i = i5 + 1;
            if ((i3 & i4) != 0) {
                break;
            }
            i4 >>= 1;
            i5 = i;
        }
        int i6 = i3 & (~i4);
        zzackVar.zzm(this.zza.zzM(), 1, i5, false);
        while (i2 < i5) {
            i2++;
            i6 = (this.zza.zzM()[i2] & 255) + (i6 << 8);
        }
        this.zzb += i;
        return i6;
    }

    public final boolean zza(zzacv zzacvVar) throws IOException {
        long zzd = zzacvVar.zzd();
        long j = RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        if (zzd != -1 && zzd <= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            j = zzd;
        }
        zzack zzackVar = (zzack) zzacvVar;
        zzackVar.zzm(this.zza.zzM(), 0, 4, false);
        long zzu = this.zza.zzu();
        this.zzb = 4;
        while (zzu != 440786851) {
            int i = (int) j;
            int i2 = this.zzb + 1;
            this.zzb = i2;
            if (i2 == i) {
                return false;
            }
            zzackVar.zzm(this.zza.zzM(), 0, 1, false);
            zzu = ((zzu << 8) & (-256)) | (this.zza.zzM()[0] & 255);
        }
        long zzb = zzb(zzacvVar);
        long j2 = this.zzb;
        if (zzb != Long.MIN_VALUE) {
            long j3 = j2 + zzb;
            if (zzd == -1 || j3 < zzd) {
                while (true) {
                    long j4 = this.zzb;
                    if (j4 < j3) {
                        if (zzb(zzacvVar) == Long.MIN_VALUE) {
                            return false;
                        }
                        long zzb2 = zzb(zzacvVar);
                        if (zzb2 < 0) {
                            return false;
                        }
                        if (zzb2 != 0) {
                            int i3 = (int) zzb2;
                            zzackVar.zzl(i3, false);
                            this.zzb += i3;
                        }
                    } else if (j4 == j3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

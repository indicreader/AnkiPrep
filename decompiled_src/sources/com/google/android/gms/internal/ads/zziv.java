package com.google.android.gms.internal.ads;

import androidx.lifecycle.CoroutineLiveDataKt;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zziv implements zzlc {
    private final zzyx zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    private final long zzf;
    private final long zzg;
    private int zzh;
    private boolean zzi;

    public zziv() {
        zzyx zzyxVar = new zzyx(true, 65536);
        zzj(2500, 0, "bufferForPlaybackMs", "0");
        zzj(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        zzj(50000, 2500, "minBufferMs", "bufferForPlaybackMs");
        zzj(50000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        zzj(50000, 50000, "maxBufferMs", "minBufferMs");
        zzj(0, 0, "backBufferDurationMs", "0");
        this.zzb = zzyxVar;
        this.zzc = zzfy.zzq(50000L);
        this.zzd = zzfy.zzq(50000L);
        this.zze = zzfy.zzq(2500L);
        this.zzf = zzfy.zzq(CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        this.zzh = 13107200;
        this.zzg = zzfy.zzq(0L);
    }

    private static void zzj(int i, int i2, String str, String str2) {
        zzek.zze(i >= i2, str + " cannot be less than " + str2);
    }

    private final void zzk(boolean z) {
        this.zzh = 13107200;
        this.zzi = false;
        if (z) {
            this.zzb.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final long zza() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final void zzb() {
        zzk(false);
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final void zzc() {
        zzk(true);
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final void zzd() {
        zzk(true);
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final void zze(zzcx zzcxVar, zzur zzurVar, zzmf[] zzmfVarArr, zzws zzwsVar, zzyi[] zzyiVarArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int length = zzmfVarArr.length;
            if (i < 2) {
                if (zzyiVarArr[i] != null) {
                    i2 += zzmfVarArr[i].zzbj() != 1 ? 131072000 : 13107200;
                }
                i++;
            } else {
                int max = Math.max(13107200, i2);
                this.zzh = max;
                this.zzb.zzf(max);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final boolean zzg(long j, long j2, float f) {
        int zza = this.zzb.zza();
        int i = this.zzh;
        long j3 = this.zzc;
        if (f > 1.0f) {
            j3 = Math.min(zzfy.zzo(j3, f), this.zzd);
        }
        if (j2 < Math.max(j3, 500000L)) {
            boolean z = zza < i;
            this.zzi = z;
            if (!z && j2 < 500000) {
                zzff.zzf("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j2 >= this.zzd || zza >= i) {
            this.zzi = false;
        }
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final boolean zzh(zzcx zzcxVar, zzur zzurVar, long j, float f, boolean z, long j2) {
        long zzp = zzfy.zzp(j, f);
        long j3 = z ? this.zzf : this.zze;
        if (j2 != -9223372036854775807L) {
            j3 = Math.min(j2 / 2, j3);
        }
        return j3 <= 0 || zzp >= j3 || this.zzb.zza() >= this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzlc
    public final zzyx zzi() {
        return this.zzb;
    }
}

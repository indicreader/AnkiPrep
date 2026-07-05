package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzaeb {
    private final byte[] zza = new byte[10];
    private boolean zzb;
    private int zzc;
    private long zzd;
    private int zze;
    private int zzf;
    private int zzg;

    public final void zza(zzaea zzaeaVar, zzadz zzadzVar) {
        if (this.zzc > 0) {
            zzaeaVar.zzt(this.zzd, this.zze, this.zzf, this.zzg, zzadzVar);
            this.zzc = 0;
        }
    }

    public final void zzb() {
        this.zzb = false;
        this.zzc = 0;
    }

    public final void zzc(zzaea zzaeaVar, long j, int i, int i2, int i3, zzadz zzadzVar) {
        if (this.zzg > i2 + i3) {
            throw new IllegalStateException("TrueHD chunk samples must be contiguous in the sample queue.");
        }
        if (this.zzb) {
            int i4 = this.zzc;
            int i5 = i4 + 1;
            this.zzc = i5;
            if (i4 == 0) {
                this.zzd = j;
                this.zze = i;
                this.zzf = 0;
            }
            this.zzf += i2;
            this.zzg = i3;
            if (i5 >= 16) {
                zza(zzaeaVar, zzadzVar);
            }
        }
    }

    public final void zzd(zzacv zzacvVar) throws IOException {
        if (this.zzb) {
            return;
        }
        zzacvVar.zzh(this.zza, 0, 10);
        zzacvVar.zzj();
        byte[] bArr = this.zza;
        int i = zzabv.zza;
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
            this.zzb = true;
        }
    }
}

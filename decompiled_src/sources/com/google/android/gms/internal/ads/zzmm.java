package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzmm implements zzlh {
    private final zzel zza;
    private boolean zzb;
    private long zzc;
    private long zzd;
    private zzcg zze = zzcg.zza;

    public zzmm(zzel zzelVar) {
        this.zza = zzelVar;
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final long zza() {
        long zza;
        long j = this.zzc;
        if (!this.zzb) {
            return j;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzd;
        zzcg zzcgVar = this.zze;
        if (zzcgVar.zzc == 1.0f) {
            zza = zzfy.zzq(elapsedRealtime);
        } else {
            zza = zzcgVar.zza(elapsedRealtime);
        }
        return j + zza;
    }

    public final void zzb(long j) {
        this.zzc = j;
        if (this.zzb) {
            this.zzd = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final zzcg zzc() {
        return this.zze;
    }

    public final void zzd() {
        if (this.zzb) {
            return;
        }
        this.zzd = SystemClock.elapsedRealtime();
        this.zzb = true;
    }

    public final void zze() {
        if (this.zzb) {
            zzb(zza());
            this.zzb = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final void zzg(zzcg zzcgVar) {
        if (this.zzb) {
            zzb(zza());
        }
        this.zze = zzcgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final /* synthetic */ boolean zzj() {
        throw null;
    }
}

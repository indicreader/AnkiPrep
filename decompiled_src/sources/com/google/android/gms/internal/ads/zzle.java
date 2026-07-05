package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzle {
    private long zza;
    private float zzb;
    private long zzc;

    public zzle() {
        this.zza = -9223372036854775807L;
        this.zzb = -3.4028235E38f;
        this.zzc = -9223372036854775807L;
    }

    public /* synthetic */ zzle(zzlg zzlgVar, zzld zzldVar) {
        this.zza = zzlgVar.zza;
        this.zzb = zzlgVar.zzb;
        this.zzc = zzlgVar.zzc;
    }

    public final zzle zzd(long j) {
        boolean z = true;
        if (j < 0) {
            if (j == -9223372036854775807L) {
                j = -9223372036854775807L;
            } else {
                z = false;
            }
        }
        zzek.zzd(z);
        this.zzc = j;
        return this;
    }

    public final zzle zze(long j) {
        this.zza = j;
        return this;
    }

    public final zzle zzf(float f) {
        boolean z = true;
        if (f <= 0.0f && f != -3.4028235E38f) {
            z = false;
        }
        zzek.zzd(z);
        this.zzb = f;
        return this;
    }

    public final zzlg zzg() {
        return new zzlg(this, null);
    }
}

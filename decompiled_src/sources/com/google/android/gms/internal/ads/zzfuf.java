package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfuf extends zzfuc {
    private static zzfuf zzc;

    private zzfuf(Context context) {
        super(context, "paidv2_id", "paidv2_creation_time", "PaidV2LifecycleImpl");
    }

    public static final zzfuf zzi(Context context) {
        zzfuf zzfufVar;
        synchronized (zzfuf.class) {
            if (zzc == null) {
                zzc = new zzfuf(context);
            }
            zzfufVar = zzc;
        }
        return zzfufVar;
    }

    public final zzfub zzh(long j, boolean z) throws IOException {
        synchronized (zzfuf.class) {
            if (zzo()) {
                return zzb(null, null, j, z);
            }
            return new zzfub();
        }
    }

    public final void zzj() throws IOException {
        synchronized (zzfuf.class) {
            if (zzg(false)) {
                zzf(false);
            }
        }
    }

    public final void zzk() throws IOException {
        this.zzb.zze("paidv2_publisher_option");
    }

    public final void zzl() throws IOException {
        this.zzb.zze("paidv2_user_option");
    }

    public final void zzm(boolean z) throws IOException {
        this.zzb.zzd("paidv2_user_option", Boolean.valueOf(z));
    }

    public final void zzn(boolean z) throws IOException {
        this.zzb.zzd("paidv2_publisher_option", Boolean.valueOf(z));
        if (z) {
            return;
        }
        zzj();
    }

    public final boolean zzo() {
        return this.zzb.zzf("paidv2_publisher_option", true);
    }

    public final boolean zzp() {
        return this.zzb.zzf("paidv2_user_option", true);
    }
}

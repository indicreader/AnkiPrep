package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes3.dex */
public final class zzbro {
    private final Object zza = new Object();
    private final Object zzb = new Object();
    private zzbrx zzc;
    private zzbrx zzd;

    private static final Context zzc(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final zzbrx zza(Context context, zzcei zzceiVar, zzfnc zzfncVar) {
        zzbrx zzbrxVar;
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = new zzbrx(zzc(context), zzceiVar, (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zza), zzfncVar);
            }
            zzbrxVar = this.zzc;
        }
        return zzbrxVar;
    }

    public final zzbrx zzb(Context context, zzcei zzceiVar, zzfnc zzfncVar) {
        zzbrx zzbrxVar;
        synchronized (this.zzb) {
            if (this.zzd == null) {
                this.zzd = new zzbrx(zzc(context), zzceiVar, (String) zzbik.zzb.zze(), zzfncVar);
            }
            zzbrxVar = this.zzd;
        }
        return zzbrxVar;
    }
}

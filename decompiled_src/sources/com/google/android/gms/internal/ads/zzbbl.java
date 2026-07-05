package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbbl {
    private zzbba zza;
    private boolean zzb;
    private final Context zzc;
    private final Object zzd = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbbl(Context context) {
        this.zzc = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Future zzc(zzbbb zzbbbVar) {
        zzbbf zzbbfVar = new zzbbf(this);
        zzbbj zzbbjVar = new zzbbj(this, zzbbbVar, zzbbfVar);
        zzbbk zzbbkVar = new zzbbk(this, zzbbfVar);
        synchronized (this.zzd) {
            zzbba zzbbaVar = new zzbba(this.zzc, com.google.android.gms.ads.internal.zzt.zzt().zzb(), zzbbjVar, zzbbkVar);
            this.zza = zzbbaVar;
            zzbbaVar.checkAvailabilityAndConnect();
        }
        return zzbbfVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zze(zzbbl zzbblVar) {
        synchronized (zzbblVar.zzd) {
            zzbba zzbbaVar = zzbblVar.zza;
            if (zzbbaVar == null) {
                return;
            }
            zzbbaVar.disconnect();
            zzbblVar.zza = null;
            Binder.flushPendingCommands();
        }
    }
}

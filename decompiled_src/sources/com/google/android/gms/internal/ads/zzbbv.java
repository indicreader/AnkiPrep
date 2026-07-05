package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbbv {
    zzayl zza;
    boolean zzb;
    private final ExecutorService zzc;

    public zzbbv() {
        this.zzc = zzcdr.zzb;
    }

    public zzbbv(final Context context) {
        ExecutorService executorService = zzcdr.zzb;
        this.zzc = executorService;
        executorService.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbbq
            @Override // java.lang.Runnable
            public final void run() {
                boolean booleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeO)).booleanValue();
                zzbbv zzbbvVar = zzbbv.this;
                Context context2 = context;
                if (booleanValue) {
                    try {
                        zzbbvVar.zza = (zzayl) zzceg.zzb(context2, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", new zzcee() { // from class: com.google.android.gms.internal.ads.zzbbr
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // com.google.android.gms.internal.ads.zzcee
                            public final Object zza(Object obj) {
                                return zzayk.zzb(obj);
                            }
                        });
                        zzbbvVar.zza.zze(ObjectWrapper.wrap(context2), "GMA_SDK");
                        zzbbvVar.zzb = true;
                    } catch (RemoteException | zzcef | NullPointerException unused) {
                        zzcec.zze("Cannot dynamite load clearcut");
                    }
                }
            }
        });
    }
}

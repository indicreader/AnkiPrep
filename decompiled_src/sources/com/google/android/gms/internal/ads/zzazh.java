package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzazh implements Runnable {
    final /* synthetic */ zzazi zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzazh(zzazi zzaziVar) {
        this.zza = zzaziVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z;
        boolean z2;
        List list;
        obj = this.zza.zzc;
        synchronized (obj) {
            zzazi zzaziVar = this.zza;
            z = zzaziVar.zzd;
            if (z) {
                z2 = zzaziVar.zze;
                if (z2) {
                    zzaziVar.zzd = false;
                    zzcec.zze("App went background");
                    list = this.zza.zzf;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            ((zzazj) it.next()).zza(false);
                        } catch (Exception e) {
                            zzcec.zzh("", e);
                        }
                    }
                }
            }
            zzcec.zze("App is still foreground");
        }
    }
}

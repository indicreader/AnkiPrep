package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfny {
    private final Context zza;
    private final Executor zzb;
    private final zzceh zzc;
    private final zzfnc zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfny(Context context, Executor executor, zzceh zzcehVar, zzfnc zzfncVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcehVar;
        this.zzd = zzfncVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str) {
        this.zzc.zza(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(String str, zzfmz zzfmzVar) {
        zzfmo zza = zzfmn.zza(this.zza, 14);
        zza.zzh();
        zza.zzf(this.zzc.zza(str));
        if (zzfmzVar == null) {
            this.zzd.zzb(zza.zzl());
        } else {
            zzfmzVar.zza(zza);
            zzfmzVar.zzg();
        }
    }

    public final void zzc(final String str, final zzfmz zzfmzVar) {
        if (!zzfnc.zza() || !((Boolean) zzbht.zzd.zze()).booleanValue()) {
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfnw
                @Override // java.lang.Runnable
                public final void run() {
                    zzfny.this.zza(str);
                }
            });
        } else {
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfnx
                @Override // java.lang.Runnable
                public final void run() {
                    zzfny.this.zzb(str, zzfmzVar);
                }
            });
        }
    }

    public final void zzd(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzc((String) it.next(), null);
        }
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbzk implements Callable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbzm zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbzk(zzbzm zzbzmVar, Context context) {
        this.zza = context;
        this.zzb = zzbzmVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        WeakHashMap weakHashMap;
        zzbzj zza;
        WeakHashMap weakHashMap2;
        weakHashMap = this.zzb.zza;
        zzbzl zzbzlVar = (zzbzl) weakHashMap.get(this.zza);
        if (zzbzlVar != null) {
            if (zzbzlVar.zza + ((Long) zzbhq.zza.zze()).longValue() >= com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()) {
                zza = new zzbzi(this.zza, zzbzlVar.zzb).zza();
                zzbzm zzbzmVar = this.zzb;
                Context context = this.zza;
                weakHashMap2 = zzbzmVar.zza;
                weakHashMap2.put(context, new zzbzl(zzbzmVar, zza));
                return zza;
            }
        }
        zza = new zzbzi(this.zza).zza();
        zzbzm zzbzmVar2 = this.zzb;
        Context context2 = this.zza;
        weakHashMap2 = zzbzmVar2.zza;
        weakHashMap2.put(context2, new zzbzl(zzbzmVar2, zza));
        return zza;
    }
}

package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzemh {
    private final Clock zza;
    private final zzemj zzb;
    private final zzfny zzc;
    private final LinkedHashMap zzd = new LinkedHashMap();
    private final boolean zze = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgS)).booleanValue();
    private final zzeis zzf;
    private boolean zzg;
    private long zzh;
    private long zzi;

    public zzemh(Clock clock, zzemj zzemjVar, zzeis zzeisVar, zzfny zzfnyVar) {
        this.zza = clock;
        this.zzb = zzemjVar;
        this.zzf = zzeisVar;
        this.zzc = zzfnyVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized boolean zzq(zzfgm zzfgmVar) {
        zzemg zzemgVar = (zzemg) this.zzd.get(zzfgmVar);
        if (zzemgVar == null) {
            return false;
        }
        return zzemgVar.zzc == 8;
    }

    public final synchronized long zza() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized ListenableFuture zzf(zzfgy zzfgyVar, zzfgm zzfgmVar, ListenableFuture listenableFuture, zzfnu zzfnuVar) {
        zzfgp zzfgpVar = zzfgyVar.zzb.zzb;
        long elapsedRealtime = this.zza.elapsedRealtime();
        String str = zzfgmVar.zzx;
        if (str != null) {
            this.zzd.put(zzfgmVar, new zzemg(str, zzfgmVar.zzag, 9, 0L, null));
            zzgen.zzr(listenableFuture, new zzemf(this, elapsedRealtime, zzfgpVar, zzfgmVar, str, zzfnuVar, zzfgyVar), zzcep.zzf);
        }
        return listenableFuture;
    }

    public final synchronized String zzg() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.zzd.entrySet().iterator();
        while (it.hasNext()) {
            zzemg zzemgVar = (zzemg) ((Map.Entry) it.next()).getValue();
            if (zzemgVar.zzc != Integer.MAX_VALUE) {
                arrayList.add(zzemgVar.toString());
            }
        }
        return TextUtils.join("_", arrayList);
    }

    public final synchronized void zzi(zzfgm zzfgmVar) {
        this.zzh = this.zza.elapsedRealtime() - this.zzi;
        if (zzfgmVar != null) {
            this.zzf.zze(zzfgmVar);
        }
        this.zzg = true;
    }

    public final synchronized void zzj() {
        this.zzh = this.zza.elapsedRealtime() - this.zzi;
    }

    public final synchronized void zzk(List list) {
        this.zzi = this.zza.elapsedRealtime();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfgm zzfgmVar = (zzfgm) it.next();
            if (!TextUtils.isEmpty(zzfgmVar.zzx)) {
                this.zzd.put(zzfgmVar, new zzemg(zzfgmVar.zzx, zzfgmVar.zzag, Integer.MAX_VALUE, 0L, null));
            }
        }
    }

    public final synchronized void zzl() {
        this.zzi = this.zza.elapsedRealtime();
    }

    public final synchronized void zzm(zzfgm zzfgmVar) {
        zzemg zzemgVar = (zzemg) this.zzd.get(zzfgmVar);
        if (zzemgVar == null || this.zzg) {
            return;
        }
        zzemgVar.zzc = 8;
    }
}

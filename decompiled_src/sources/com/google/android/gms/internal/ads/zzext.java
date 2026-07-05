package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzext {
    private final Context zza;
    private final Set zzb;
    private final Executor zzc;
    private final zzfmz zzd;
    private final zzdwf zze;
    private long zzf = 0;
    private int zzg = 0;

    public zzext(Context context, Executor executor, Set set, zzfmz zzfmzVar, zzdwf zzdwfVar) {
        this.zza = context;
        this.zzc = executor;
        this.zzb = set;
        this.zzd = zzfmzVar;
        this.zze = zzdwfVar;
    }

    public final ListenableFuture zza(final Object obj) {
        zzfmo zza = zzfmn.zza(this.zza, 8);
        zza.zzh();
        final ArrayList arrayList = new ArrayList(this.zzb.size());
        List arrayList2 = new ArrayList();
        if (!((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlh)).isEmpty()) {
            arrayList2 = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlh)).split(","));
        }
        this.zzf = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
        for (final zzexq zzexqVar : this.zzb) {
            if (!arrayList2.contains(String.valueOf(zzexqVar.zza()))) {
                final long elapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
                ListenableFuture zzb = zzexqVar.zzb();
                zzb.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzexr
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzext.this.zzb(elapsedRealtime, zzexqVar);
                    }
                }, zzcep.zzf);
                arrayList.add(zzb);
            }
        }
        ListenableFuture zza2 = zzgen.zzb(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzexs
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Iterator it = arrayList.iterator();
                while (true) {
                    Object obj2 = obj;
                    if (!it.hasNext()) {
                        return obj2;
                    }
                    zzexp zzexpVar = (zzexp) ((ListenableFuture) it.next()).get();
                    if (zzexpVar != null) {
                        zzexpVar.zzj(obj2);
                    }
                }
            }
        }, this.zzc);
        if (zzfnc.zza()) {
            zzfmy.zza(zza2, this.zzd, zza);
        }
        return zza2;
    }

    public final void zzb(long j, zzexq zzexqVar) {
        long elapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - j;
        if (((Boolean) zzbid.zza.zze()).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zza("Signal runtime (ms) : " + zzfxt.zzc(zzexqVar.getClass().getCanonicalName()) + " = " + elapsedRealtime);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzca)).booleanValue()) {
            zzdwe zza = this.zze.zza();
            zza.zzb("action", "lat_ms");
            zza.zzb("lat_grp", "sig_lat_grp");
            zza.zzb("lat_id", String.valueOf(zzexqVar.zza()));
            zza.zzb("clat_ms", String.valueOf(elapsedRealtime));
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcb)).booleanValue()) {
                synchronized (this) {
                    this.zzg++;
                }
                zza.zzb("seq_num", com.google.android.gms.ads.internal.zzt.zzo().zzh().zzd());
                synchronized (this) {
                    if (this.zzg == this.zzb.size() && this.zzf != 0) {
                        this.zzg = 0;
                        String valueOf = String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zzf);
                        if (zzexqVar.zza() <= 39 || zzexqVar.zza() >= 52) {
                            zza.zzb("lat_clsg", valueOf);
                        } else {
                            zza.zzb("lat_gmssg", valueOf);
                        }
                    }
                }
            }
            zza.zzh();
        }
    }
}

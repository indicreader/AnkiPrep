package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdwe {
    final /* synthetic */ zzdwf zza;
    private final Map zzb = new ConcurrentHashMap();

    public zzdwe(zzdwf zzdwfVar) {
        this.zza = zzdwfVar;
    }

    public static /* bridge */ /* synthetic */ zzdwe zza(zzdwe zzdweVar) {
        Map map;
        zzdwf zzdwfVar = zzdweVar.zza;
        Map map2 = zzdweVar.zzb;
        map = zzdwfVar.zzc;
        map2.putAll(map);
        return zzdweVar;
    }

    public final zzdwe zzb(String str, String str2) {
        this.zzb.put(str, str2);
        return this;
    }

    public final zzdwe zzc(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.zzb.put(str, str2);
        }
        return this;
    }

    public final zzdwe zzd(zzfgm zzfgmVar) {
        this.zzb.put("aai", zzfgmVar.zzx);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzha)).booleanValue()) {
            zzc("rid", zzfgmVar.zzao);
        }
        return this;
    }

    public final zzdwe zze(zzfgp zzfgpVar) {
        this.zzb.put("gqi", zzfgpVar.zzb);
        return this;
    }

    public final String zzf() {
        zzdwk zzdwkVar;
        zzdwkVar = this.zza.zza;
        return zzdwkVar.zzb(this.zzb);
    }

    public final void zzg() {
        Executor executor;
        executor = this.zza.zzb;
        executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdwc
            @Override // java.lang.Runnable
            public final void run() {
                zzdwe.this.zzi();
            }
        });
    }

    public final void zzh() {
        Executor executor;
        executor = this.zza.zzb;
        executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdwd
            @Override // java.lang.Runnable
            public final void run() {
                zzdwe.this.zzj();
            }
        });
    }

    public final /* synthetic */ void zzi() {
        zzdwk zzdwkVar;
        zzdwkVar = this.zza.zza;
        zzdwkVar.zzf(this.zzb);
    }

    public final /* synthetic */ void zzj() {
        zzdwk zzdwkVar;
        zzdwkVar = this.zza.zza;
        zzdwkVar.zze(this.zzb);
    }
}

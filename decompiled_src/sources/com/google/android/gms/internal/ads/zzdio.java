package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdio extends zzdgl implements zzayq {
    private final Map zzb;
    private final Context zzc;
    private final zzfgm zzd;

    public zzdio(Context context, Set set, zzfgm zzfgmVar) {
        super(set);
        this.zzb = new WeakHashMap(1);
        this.zzc = context;
        this.zzd = zzfgmVar;
    }

    public final synchronized void zza(View view) {
        zzayr zzayrVar = (zzayr) this.zzb.get(view);
        if (zzayrVar == null) {
            zzayr zzayrVar2 = new zzayr(this.zzc, view);
            zzayrVar2.zzc(this);
            this.zzb.put(view, zzayrVar2);
            zzayrVar = zzayrVar2;
        }
        if (this.zzd.zzY) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbo)).booleanValue()) {
                zzayrVar.zzg(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbn)).longValue());
                return;
            }
        }
        zzayrVar.zzf();
    }

    public final synchronized void zzb(View view) {
        if (this.zzb.containsKey(view)) {
            ((zzayr) this.zzb.get(view)).zze(this);
            this.zzb.remove(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayq
    public final synchronized void zzby(final zzayp zzaypVar) {
        zzu(new zzdgk() { // from class: com.google.android.gms.internal.ads.zzdin
            @Override // com.google.android.gms.internal.ads.zzdgk
            public final void zza(Object obj) {
                ((zzayq) obj).zzby(zzayp.this);
            }
        });
    }
}

package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzefp implements zzfln {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private final zzflv zzc;

    public zzefp(Set set, zzflv zzflvVar) {
        zzflg zzflgVar;
        String str;
        zzflg zzflgVar2;
        String str2;
        this.zzc = zzflvVar;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzefo zzefoVar = (zzefo) it.next();
            Map map = this.zza;
            zzflgVar = zzefoVar.zzb;
            str = zzefoVar.zza;
            map.put(zzflgVar, str);
            Map map2 = this.zzb;
            zzflgVar2 = zzefoVar.zzc;
            str2 = zzefoVar.zza;
            map2.put(zzflgVar2, str2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfln
    public final void zzbL(zzflg zzflgVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzfln
    public final void zzbM(zzflg zzflgVar, String str, Throwable th) {
        this.zzc.zze("task.".concat(String.valueOf(str)), "f.");
        if (this.zzb.containsKey(zzflgVar)) {
            this.zzc.zze("label.".concat(String.valueOf((String) this.zzb.get(zzflgVar))), "f.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfln
    public final void zzbN(zzflg zzflgVar, String str) {
        this.zzc.zzd("task.".concat(String.valueOf(str)));
        if (this.zza.containsKey(zzflgVar)) {
            this.zzc.zzd("label.".concat(String.valueOf((String) this.zza.get(zzflgVar))));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfln
    public final void zzd(zzflg zzflgVar, String str) {
        this.zzc.zze("task.".concat(String.valueOf(str)), "s.");
        if (this.zzb.containsKey(zzflgVar)) {
            this.zzc.zze("label.".concat(String.valueOf((String) this.zzb.get(zzflgVar))), "s.");
        }
    }
}

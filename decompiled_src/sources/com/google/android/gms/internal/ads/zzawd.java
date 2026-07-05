package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzawd implements zzfsq {
    private final zzfqt zza;
    private final zzfrk zzb;
    private final zzawq zzc;
    private final zzawc zzd;
    private final zzavm zze;
    private final zzaws zzf;
    private final zzawk zzg;
    private final zzawb zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawd(zzfqt zzfqtVar, zzfrk zzfrkVar, zzawq zzawqVar, zzawc zzawcVar, zzavm zzavmVar, zzaws zzawsVar, zzawk zzawkVar, zzawb zzawbVar) {
        this.zza = zzfqtVar;
        this.zzb = zzfrkVar;
        this.zzc = zzawqVar;
        this.zzd = zzawcVar;
        this.zze = zzavmVar;
        this.zzf = zzawsVar;
        this.zzg = zzawkVar;
        this.zzh = zzawbVar;
    }

    private final Map zze() {
        HashMap hashMap = new HashMap();
        zzfqt zzfqtVar = this.zza;
        zzatd zzb = this.zzb.zzb();
        hashMap.put("v", zzfqtVar.zzb());
        hashMap.put("gms", Boolean.valueOf(this.zza.zzc()));
        hashMap.put("int", zzb.zzh());
        hashMap.put("up", Boolean.valueOf(this.zzd.zza()));
        hashMap.put("t", new Throwable());
        zzawk zzawkVar = this.zzg;
        if (zzawkVar != null) {
            hashMap.put("tcq", Long.valueOf(zzawkVar.zzc()));
            hashMap.put("tpq", Long.valueOf(this.zzg.zzg()));
            hashMap.put("tcv", Long.valueOf(this.zzg.zzd()));
            hashMap.put("tpv", Long.valueOf(this.zzg.zzh()));
            hashMap.put("tchv", Long.valueOf(this.zzg.zzb()));
            hashMap.put("tphv", Long.valueOf(this.zzg.zzf()));
            hashMap.put("tcc", Long.valueOf(this.zzg.zza()));
            hashMap.put("tpc", Long.valueOf(this.zzg.zze()));
        }
        return hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzfsq
    public final Map zza() {
        zzawq zzawqVar = this.zzc;
        Map zze = zze();
        zze.put("lts", Long.valueOf(zzawqVar.zza()));
        return zze;
    }

    @Override // com.google.android.gms.internal.ads.zzfsq
    public final Map zzb() {
        Map zze = zze();
        zzatd zza = this.zzb.zza();
        zze.put("gai", Boolean.valueOf(this.zza.zzd()));
        zze.put("did", zza.zzg());
        zze.put("dst", Integer.valueOf(zza.zzal() - 1));
        zze.put("doo", Boolean.valueOf(zza.zzai()));
        zzavm zzavmVar = this.zze;
        if (zzavmVar != null) {
            zze.put("nt", Long.valueOf(zzavmVar.zza()));
        }
        zzaws zzawsVar = this.zzf;
        if (zzawsVar != null) {
            zze.put("vs", Long.valueOf(zzawsVar.zzc()));
            zze.put("vf", Long.valueOf(this.zzf.zzb()));
        }
        return zze;
    }

    @Override // com.google.android.gms.internal.ads.zzfsq
    public final Map zzc() {
        zzawb zzawbVar = this.zzh;
        Map zze = zze();
        if (zzawbVar != null) {
            zze.put("vst", zzawbVar.zza());
        }
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(View view) {
        this.zzc.zzd(view);
    }
}

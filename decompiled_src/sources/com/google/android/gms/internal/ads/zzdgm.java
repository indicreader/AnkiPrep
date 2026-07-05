package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdgm {
    private final Set zza = new HashSet();
    private final Set zzb = new HashSet();
    private final Set zzc = new HashSet();
    private final Set zzd = new HashSet();
    private final Set zze = new HashSet();
    private final Set zzf = new HashSet();
    private final Set zzg = new HashSet();
    private final Set zzh = new HashSet();
    private final Set zzi = new HashSet();
    private final Set zzj = new HashSet();
    private final Set zzk = new HashSet();
    private final Set zzl = new HashSet();
    private final Set zzm = new HashSet();
    private final Set zzn = new HashSet();
    private zzfea zzo;

    public final zzdgm zza(com.google.android.gms.ads.internal.client.zza zzaVar, Executor executor) {
        this.zzc.add(new zzdim(zzaVar, executor));
        return this;
    }

    public final zzdgm zzb(zzdba zzdbaVar, Executor executor) {
        this.zzi.add(new zzdim(zzdbaVar, executor));
        return this;
    }

    public final zzdgm zzc(zzdbn zzdbnVar, Executor executor) {
        this.zzl.add(new zzdim(zzdbnVar, executor));
        return this;
    }

    public final zzdgm zzd(zzdbr zzdbrVar, Executor executor) {
        this.zzf.add(new zzdim(zzdbrVar, executor));
        return this;
    }

    public final zzdgm zze(zzdax zzdaxVar, Executor executor) {
        this.zze.add(new zzdim(zzdaxVar, executor));
        return this;
    }

    public final zzdgm zzf(zzdcl zzdclVar, Executor executor) {
        this.zzh.add(new zzdim(zzdclVar, executor));
        return this;
    }

    public final zzdgm zzg(zzdcw zzdcwVar, Executor executor) {
        this.zzg.add(new zzdim(zzdcwVar, executor));
        return this;
    }

    public final zzdgm zzh(com.google.android.gms.ads.internal.overlay.zzp zzpVar, Executor executor) {
        this.zzn.add(new zzdim(zzpVar, executor));
        return this;
    }

    public final zzdgm zzi(zzddi zzddiVar, Executor executor) {
        this.zzm.add(new zzdim(zzddiVar, executor));
        return this;
    }

    public final zzdgm zzj(zzdds zzddsVar, Executor executor) {
        this.zzb.add(new zzdim(zzddsVar, executor));
        return this;
    }

    public final zzdgm zzk(AppEventListener appEventListener, Executor executor) {
        this.zzk.add(new zzdim(appEventListener, executor));
        return this;
    }

    public final zzdgm zzl(zzdiu zzdiuVar, Executor executor) {
        this.zzd.add(new zzdim(zzdiuVar, executor));
        return this;
    }

    public final zzdgm zzm(zzfea zzfeaVar) {
        this.zzo = zzfeaVar;
        return this;
    }

    public final zzdgo zzn() {
        return new zzdgo(this, null);
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzzs {
    private final Context zza;
    private zzdm zzb;
    private zzcp zzc;
    private zzaao zzd;
    private boolean zze;

    public zzzs(Context context) {
        this.zza = context;
    }

    public final zzzs zzc(zzaao zzaaoVar) {
        this.zzd = zzaaoVar;
        return this;
    }

    public final zzaab zzd() {
        zzek.zzf(!this.zze);
        zzaaa zzaaaVar = null;
        if (this.zzc == null) {
            if (this.zzb == null) {
                this.zzb = new zzzx(null);
            }
            this.zzc = new zzzy(this.zzb);
        }
        if (this.zzd == null) {
            this.zzd = new zzaao(this.zza, new zzzu(null), 0L);
        }
        zzaab zzaabVar = new zzaab(this, zzaaaVar);
        this.zze = true;
        return zzaabVar;
    }
}

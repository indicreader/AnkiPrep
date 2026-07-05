package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcvz {
    private final zzddm zza;
    private final zzdft zzb;

    public zzcvz(zzddm zzddmVar, zzdft zzdftVar) {
        this.zza = zzddmVar;
        this.zzb = zzdftVar;
    }

    public final zzddm zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzdft zzb() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzdim zzc() {
        zzdft zzdftVar = this.zzb;
        if (zzdftVar != null) {
            return new zzdim(zzdftVar, zzcep.zzf);
        }
        return new zzdim(new zzcvy(this), zzcep.zzf);
    }
}

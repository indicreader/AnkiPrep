package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzuk extends zzuf {
    public static final Object zzd = new Object();
    private final Object zze;
    private final Object zzf;

    private zzuk(zzcx zzcxVar, Object obj, Object obj2) {
        super(zzcxVar);
        this.zze = obj;
        this.zzf = obj2;
    }

    public static zzuk zzq(zzbp zzbpVar) {
        return new zzuk(new zzul(zzbpVar), zzcw.zza, zzd);
    }

    public static zzuk zzr(zzcx zzcxVar, Object obj, Object obj2) {
        return new zzuk(zzcxVar, obj, obj2);
    }

    @Override // com.google.android.gms.internal.ads.zzuf, com.google.android.gms.internal.ads.zzcx
    public final int zza(Object obj) {
        Object obj2;
        if (zzd.equals(obj) && (obj2 = this.zzf) != null) {
            obj = obj2;
        }
        return this.zzc.zza(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzuf, com.google.android.gms.internal.ads.zzcx
    public final zzcu zzd(int i, zzcu zzcuVar, boolean z) {
        this.zzc.zzd(i, zzcuVar, z);
        if (zzfy.zzF(zzcuVar.zzc, this.zzf) && z) {
            zzcuVar.zzc = zzd;
        }
        return zzcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzuf, com.google.android.gms.internal.ads.zzcx
    public final zzcw zze(int i, zzcw zzcwVar, long j) {
        this.zzc.zze(i, zzcwVar, j);
        if (zzfy.zzF(zzcwVar.zzc, this.zze)) {
            zzcwVar.zzc = zzcw.zza;
        }
        return zzcwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzuf, com.google.android.gms.internal.ads.zzcx
    public final Object zzf(int i) {
        Object zzf = this.zzc.zzf(i);
        return zzfy.zzF(zzf, this.zzf) ? zzd : zzf;
    }

    public final zzuk zzp(zzcx zzcxVar) {
        return new zzuk(zzcxVar, this.zze, this.zzf);
    }
}

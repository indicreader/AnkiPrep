package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public class zzhak {
    private static final zzgzf zzb = zzgzf.zza;
    protected volatile zzhbe zza;
    private volatile zzgyl zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhak)) {
            return false;
        }
        zzhak zzhakVar = (zzhak) obj;
        zzhbe zzhbeVar = this.zza;
        zzhbe zzhbeVar2 = zzhakVar.zza;
        if (zzhbeVar == null && zzhbeVar2 == null) {
            return zzb().equals(zzhakVar.zzb());
        }
        if (zzhbeVar != null && zzhbeVar2 != null) {
            return zzhbeVar.equals(zzhbeVar2);
        }
        if (zzhbeVar != null) {
            zzhakVar.zzc(zzhbeVar.zzbk());
            return zzhbeVar.equals(zzhakVar.zza);
        }
        zzc(zzhbeVar2.zzbk());
        return this.zza.equals(zzhbeVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzgyh) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzaz();
        }
        return 0;
    }

    public final zzgyl zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                return this.zzc;
            }
            if (this.zza == null) {
                this.zzc = zzgyl.zzb;
            } else {
                this.zzc = this.zza.zzau();
            }
            return this.zzc;
        }
    }

    protected final void zzc(zzhbe zzhbeVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza != null) {
                return;
            }
            try {
                this.zza = zzhbeVar;
                this.zzc = zzgyl.zzb;
            } catch (zzhag unused) {
                this.zza = zzhbeVar;
                this.zzc = zzgyl.zzb;
            }
        }
    }
}

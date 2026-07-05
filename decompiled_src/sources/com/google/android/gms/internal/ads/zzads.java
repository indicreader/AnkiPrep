package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzads {
    public final zzadv zza;
    public final zzadv zzb;

    public zzads(zzadv zzadvVar, zzadv zzadvVar2) {
        this.zza = zzadvVar;
        this.zzb = zzadvVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzads zzadsVar = (zzads) obj;
            if (this.zza.equals(zzadsVar.zza) && this.zzb.equals(zzadsVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza.hashCode() * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        zzadv zzadvVar = this.zza;
        zzadv zzadvVar2 = this.zzb;
        return "[" + zzadvVar.toString() + (zzadvVar.equals(zzadvVar2) ? "" : ", ".concat(this.zzb.toString())) + "]";
    }
}

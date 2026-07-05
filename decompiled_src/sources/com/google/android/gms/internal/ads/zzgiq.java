package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgiq extends zzghi {
    private final int zza;
    private final int zzb;
    private final int zzc = 16;
    private final zzgio zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgiq(int i, int i2, int i3, zzgio zzgioVar, zzgip zzgipVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzd = zzgioVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgiq)) {
            return false;
        }
        zzgiq zzgiqVar = (zzgiq) obj;
        if (zzgiqVar.zza == this.zza && zzgiqVar.zzb == this.zzb) {
            int i = zzgiqVar.zzc;
            if (zzgiqVar.zzd == this.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(zzgiq.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), 16, this.zzd);
    }

    public final String toString() {
        return "AesEax Parameters (variant: " + String.valueOf(this.zzd) + ", " + this.zzb + "-byte IV, 16-byte tag, and " + this.zza + "-byte key)";
    }

    @Override // com.google.android.gms.internal.ads.zzggq
    public final boolean zza() {
        return this.zzd != zzgio.zzc;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzgio zzd() {
        return this.zzd;
    }
}

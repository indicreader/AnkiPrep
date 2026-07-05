package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgqx extends zzgra {
    private final int zza;
    private final int zzb;
    private final zzgqv zzc;
    private final zzgqu zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgqx(int i, int i2, zzgqv zzgqvVar, zzgqu zzgquVar, zzgqw zzgqwVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzgqvVar;
        this.zzd = zzgquVar;
    }

    public static zzgqt zze() {
        return new zzgqt(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgqx)) {
            return false;
        }
        zzgqx zzgqxVar = (zzgqx) obj;
        return zzgqxVar.zza == this.zza && zzgqxVar.zzd() == zzd() && zzgqxVar.zzc == this.zzc && zzgqxVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Objects.hash(zzgqx.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    public final String toString() {
        zzgqu zzgquVar = this.zzd;
        return "HMAC Parameters (variant: " + String.valueOf(this.zzc) + ", hashType: " + String.valueOf(zzgquVar) + ", " + this.zzb + "-byte tags, and " + this.zza + "-byte key)";
    }

    @Override // com.google.android.gms.internal.ads.zzggq
    public final boolean zza() {
        return this.zzc != zzgqv.zzd;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        zzgqv zzgqvVar = this.zzc;
        if (zzgqvVar == zzgqv.zzd) {
            return this.zzb;
        }
        if (zzgqvVar == zzgqv.zza || zzgqvVar == zzgqv.zzb || zzgqvVar == zzgqv.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzgqu zzf() {
        return this.zzd;
    }

    public final zzgqv zzg() {
        return this.zzc;
    }
}

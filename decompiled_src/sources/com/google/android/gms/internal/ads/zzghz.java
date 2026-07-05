package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzghz extends zzghi {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzghx zze;
    private final zzghw zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzghz(int i, int i2, int i3, int i4, zzghx zzghxVar, zzghw zzghwVar, zzghy zzghyVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = zzghxVar;
        this.zzf = zzghwVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghz)) {
            return false;
        }
        zzghz zzghzVar = (zzghz) obj;
        return zzghzVar.zza == this.zza && zzghzVar.zzb == this.zzb && zzghzVar.zzc == this.zzc && zzghzVar.zzd == this.zzd && zzghzVar.zze == this.zze && zzghzVar.zzf == this.zzf;
    }

    public final int hashCode() {
        return Objects.hash(zzghz.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf);
    }

    public final String toString() {
        zzghw zzghwVar = this.zzf;
        return "AesCtrHmacAead Parameters (variant: " + String.valueOf(this.zze) + ", hashType: " + String.valueOf(zzghwVar) + ", " + this.zzc + "-byte IV, and " + this.zzd + "-byte tags, and " + this.zza + "-byte AES key, and " + this.zzb + "-byte HMAC key)";
    }

    @Override // com.google.android.gms.internal.ads.zzggq
    public final boolean zza() {
        return this.zze != zzghx.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final int zzd() {
        return this.zzc;
    }

    public final int zze() {
        return this.zzd;
    }

    public final zzghw zzf() {
        return this.zzf;
    }

    public final zzghx zzg() {
        return this.zze;
    }
}

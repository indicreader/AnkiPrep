package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgsb {
    private final zzgge zza;
    private final int zzb;
    private final String zzc;
    private final String zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgsb(zzgge zzggeVar, int i, String str, String str2, zzgsa zzgsaVar) {
        this.zza = zzggeVar;
        this.zzb = i;
        this.zzc = str;
        this.zzd = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgsb)) {
            return false;
        }
        zzgsb zzgsbVar = (zzgsb) obj;
        return this.zza == zzgsbVar.zza && this.zzb == zzgsbVar.zzb && this.zzc.equals(zzgsbVar.zzc) && this.zzd.equals(zzgsbVar.zzd);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    public final String toString() {
        return String.format("(status=%s, keyId=%s, keyType='%s', keyPrefix='%s')", this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    public final int zza() {
        return this.zzb;
    }
}

package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzglf extends zzghi {
    private final String zza;
    private final zzgld zzb;
    private final zzghi zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzglf(String str, zzgld zzgldVar, zzghi zzghiVar, zzgle zzgleVar) {
        this.zza = str;
        this.zzb = zzgldVar;
        this.zzc = zzghiVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzglf)) {
            return false;
        }
        zzglf zzglfVar = (zzglf) obj;
        return zzglfVar.zzb.equals(this.zzb) && zzglfVar.zzc.equals(this.zzc) && zzglfVar.zza.equals(this.zza);
    }

    public final int hashCode() {
        return Objects.hash(zzglf.class, this.zza, this.zzb, this.zzc);
    }

    public final String toString() {
        zzghi zzghiVar = this.zzc;
        return "LegacyKmsEnvelopeAead Parameters (kekUri: " + this.zza + ", dekParsingStrategy: " + String.valueOf(this.zzb) + ", dekParametersForNewKeys: " + String.valueOf(zzghiVar) + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzggq
    public final boolean zza() {
        return false;
    }

    public final zzghi zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zza;
    }
}

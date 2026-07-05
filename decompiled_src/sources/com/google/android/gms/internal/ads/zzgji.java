package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgji extends zzghi {
    private final int zza;
    private final int zzb = 12;
    private final int zzc = 16;
    private final zzgjg zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgji(int i, int i2, int i3, zzgjg zzgjgVar, zzgjh zzgjhVar) {
        this.zza = i;
        this.zzd = zzgjgVar;
    }

    public static zzgjf zzc() {
        return new zzgjf(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgji)) {
            return false;
        }
        zzgji zzgjiVar = (zzgji) obj;
        if (zzgjiVar.zza == this.zza) {
            int i = zzgjiVar.zzb;
            int i2 = zzgjiVar.zzc;
            if (zzgjiVar.zzd == this.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(zzgji.class, Integer.valueOf(this.zza), 12, 16, this.zzd);
    }

    public final String toString() {
        return "AesGcm Parameters (variant: " + String.valueOf(this.zzd) + ", 12-byte IV, 16-byte tag, and " + this.zza + "-byte key)";
    }

    @Override // com.google.android.gms.internal.ads.zzggq
    public final boolean zza() {
        return this.zzd != zzgjg.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzgjg zzd() {
        return this.zzd;
    }
}

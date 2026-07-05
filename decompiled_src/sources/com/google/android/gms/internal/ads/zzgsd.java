package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgsd {
    private final zzgrw zza;
    private final List zzb;

    @Nullable
    private final Integer zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgsd(zzgrw zzgrwVar, List list, Integer num, zzgsc zzgscVar) {
        this.zza = zzgrwVar;
        this.zzb = list;
        this.zzc = num;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgsd)) {
            return false;
        }
        zzgsd zzgsdVar = (zzgsd) obj;
        return this.zza.equals(zzgsdVar.zza) && this.zzb.equals(zzgsdVar.zzb) && Objects.equals(this.zzc, zzgsdVar.zzc);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", this.zza, this.zzb, this.zzc);
    }
}

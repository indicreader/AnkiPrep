package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzhbr extends zzgyd {
    final zzhbv zza;
    zzgyf zzb = zzb();
    final /* synthetic */ zzhbx zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhbr(zzhbx zzhbxVar) {
        this.zzc = zzhbxVar;
        this.zza = new zzhbv(zzhbxVar, null);
    }

    private final zzgyf zzb() {
        zzhbv zzhbvVar = this.zza;
        if (zzhbvVar.hasNext()) {
            return zzhbvVar.next().iterator();
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final byte zza() {
        zzgyf zzgyfVar = this.zzb;
        if (zzgyfVar == null) {
            throw new NoSuchElementException();
        }
        byte zza = zzgyfVar.zza();
        if (!this.zzb.hasNext()) {
            this.zzb = zzb();
        }
        return zza;
    }
}

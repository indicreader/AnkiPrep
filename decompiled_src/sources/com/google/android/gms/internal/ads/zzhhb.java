package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhhb implements zzhhd {
    private zzhhm zza;

    public static void zza(zzhhm zzhhmVar, zzhhm zzhhmVar2) {
        zzhhb zzhhbVar = (zzhhb) zzhhmVar;
        if (zzhhbVar.zza != null) {
            throw new IllegalStateException();
        }
        zzhhbVar.zza = zzhhmVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final Object zzb() {
        zzhhm zzhhmVar = this.zza;
        if (zzhhmVar == null) {
            throw new IllegalStateException();
        }
        return zzhhmVar.zzb();
    }
}

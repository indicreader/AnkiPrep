package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzhav implements zzhbc {
    private final zzhbc[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhav(zzhbc... zzhbcVarArr) {
        this.zza = zzhbcVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzhbc
    public final zzhbb zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzhbc zzhbcVar = this.zza[i];
            if (zzhbcVar.zzc(cls)) {
                return zzhbcVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    @Override // com.google.android.gms.internal.ads.zzhbc
    public final boolean zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}

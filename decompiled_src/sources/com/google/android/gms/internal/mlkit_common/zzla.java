package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes3.dex */
public enum zzla implements zzbm {
    UNKNOWN(0),
    TRANSLATE(1);

    private final int zzd;

    zzla(int i) {
        this.zzd = i;
    }

    public static zzla zzb(int i) {
        for (zzla zzlaVar : values()) {
            if (zzlaVar.zzd == i) {
                return zzlaVar;
            }
        }
        return UNKNOWN;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzbm
    public final int zza() {
        return this.zzd;
    }
}

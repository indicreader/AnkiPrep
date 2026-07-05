package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes3.dex */
final class zzap extends zzah {
    private final zzar zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzap(zzar zzarVar, int i) {
        super(zzarVar.size(), i);
        this.zza = zzarVar;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzah
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}

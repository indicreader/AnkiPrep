package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfzy extends zzfya {
    private final zzgaa zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfzy(zzgaa zzgaaVar, int i) {
        super(zzgaaVar.size(), i);
        this.zza = zzgaaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfya
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}

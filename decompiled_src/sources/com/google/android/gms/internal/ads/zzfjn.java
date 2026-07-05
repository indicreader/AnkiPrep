package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfjn implements zzgej {
    final /* synthetic */ zzfjq zza;
    final /* synthetic */ zzfjr zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfjn(zzfjr zzfjrVar, zzfjq zzfjqVar) {
        this.zza = zzfjqVar;
        this.zzb = zzfjrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        synchronized (this.zzb) {
            this.zzb.zze = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ArrayDeque arrayDeque;
        int i;
        synchronized (this.zzb) {
            this.zzb.zze = null;
            arrayDeque = this.zzb.zzd;
            arrayDeque.addFirst(this.zza);
            zzfjr zzfjrVar = this.zzb;
            i = zzfjrVar.zzf;
            if (i == 1) {
                zzfjrVar.zzh();
            }
        }
    }
}

package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcxo implements zzgej {
    final /* synthetic */ zzcxp zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcxo(zzcxp zzcxpVar) {
        this.zza = zzcxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        zzdgc zzdgcVar;
        zzdgcVar = this.zza.zzf;
        zzdgcVar.zzl(false);
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(@NullableDecl Object obj) {
        zzdgc zzdgcVar;
        zzdgcVar = this.zza.zzf;
        zzdgcVar.zzl(true);
    }
}

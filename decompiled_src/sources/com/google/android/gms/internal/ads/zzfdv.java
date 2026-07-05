package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfdv implements zzfws {
    final /* synthetic */ zzfdz zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfdv(zzfdz zzfdzVar) {
        this.zza = zzfdzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfws
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzfjf zze;
        zzfdy zzfdyVar;
        zzcec.zzh("", (zzecf) obj);
        com.google.android.gms.ads.internal.util.zze.zza("Failed to get a cache key, reverting to legacy flow.");
        zzfdz zzfdzVar = this.zza;
        zze = zzfdzVar.zze();
        zzfdzVar.zzd = new zzfdy(null, zze, null);
        zzfdyVar = this.zza.zzd;
        return zzfdyVar;
    }
}

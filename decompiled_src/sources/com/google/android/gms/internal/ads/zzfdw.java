package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfdw implements zzfws {
    final /* synthetic */ zzfdz zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfdw(zzfdz zzfdzVar) {
        this.zza = zzfdzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfws
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzfdy zzfdyVar;
        zzbze zzbzeVar = (zzbze) obj;
        this.zza.zzd = new zzfdy(zzbzeVar, new zzfjh(zzbzeVar.zzj), null);
        zzfdyVar = this.zza.zzd;
        return zzfdyVar;
    }
}

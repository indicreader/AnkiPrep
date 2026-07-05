package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgne extends zzgnh {
    final /* synthetic */ zzgnf zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgne(zzgxq zzgxqVar, Class cls, zzgnf zzgnfVar) {
        super(zzgxqVar, cls, null);
        this.zza = zzgnfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgnh
    public final zzggc zza(zzgpc zzgpcVar, @Nullable zzghc zzghcVar) throws GeneralSecurityException {
        return this.zza.zza(zzgpcVar, zzghcVar);
    }
}

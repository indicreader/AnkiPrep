package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzgnh {
    private final zzgxq zza;
    private final Class zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgnh(zzgxq zzgxqVar, Class cls, zzgng zzgngVar) {
        this.zza = zzgxqVar;
        this.zzb = cls;
    }

    public static zzgnh zzb(zzgnf zzgnfVar, zzgxq zzgxqVar, Class cls) {
        return new zzgne(zzgxqVar, cls, zzgnfVar);
    }

    public abstract zzggc zza(zzgpc zzgpcVar, @Nullable zzghc zzghcVar) throws GeneralSecurityException;

    public final zzgxq zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}

package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzgom {
    private final Class zza;
    private final Class zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgom(Class cls, Class cls2, zzgol zzgolVar) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzgom zzb(zzgok zzgokVar, Class cls, Class cls2) {
        return new zzgoj(cls, cls2, zzgokVar);
    }

    public abstract zzgpc zza(zzggq zzggqVar) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}

package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfdi implements zzfjq {
    public final zzfec zza;
    public final zzfee zzb;
    public final com.google.android.gms.ads.internal.client.zzl zzc;
    public final String zzd;
    public final Executor zze;
    public final com.google.android.gms.ads.internal.client.zzw zzf;
    public final zzfjf zzg;

    public zzfdi(zzfec zzfecVar, zzfee zzfeeVar, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, Executor executor, com.google.android.gms.ads.internal.client.zzw zzwVar, zzfjf zzfjfVar) {
        this.zza = zzfecVar;
        this.zzb = zzfeeVar;
        this.zzc = zzlVar;
        this.zzd = str;
        this.zze = executor;
        this.zzf = zzwVar;
        this.zzg = zzfjfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfjq
    public final zzfjf zza() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzfjq
    public final Executor zzb() {
        return this.zze;
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzcog implements zzdxh {
    private final Long zza;
    private final String zzb;
    private final zzcnc zzc;
    private final zzcok zzd;
    private final zzcog zze = this;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcog(zzcnc zzcncVar, zzcok zzcokVar, Long l, String str, zzcof zzcofVar) {
        this.zzc = zzcncVar;
        this.zzd = zzcokVar;
        this.zza = l;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdxh
    public final zzdxr zza() {
        Context context;
        zzdxk zzc;
        zzcok zzcokVar = this.zzd;
        long longValue = this.zza.longValue();
        context = zzcokVar.zza;
        zzc = zzdxl.zzc(zzcokVar.zzb);
        return zzdxs.zza(longValue, context, zzc, this.zzc, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzdxh
    public final zzdxv zzb() {
        Context context;
        zzdxk zzc;
        zzcok zzcokVar = this.zzd;
        long longValue = this.zza.longValue();
        context = zzcokVar.zza;
        zzc = zzdxl.zzc(zzcokVar.zzb);
        return zzdxw.zza(longValue, context, zzc, this.zzc, this.zzb);
    }
}

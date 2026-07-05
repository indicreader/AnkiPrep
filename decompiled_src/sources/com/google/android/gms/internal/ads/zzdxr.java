package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdxr implements zzdxf {
    private final long zza;
    private final zzeqm zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxr(long j, Context context, zzdxk zzdxkVar, zzclg zzclgVar, String str) {
        this.zza = j;
        zzfer zzu = zzclgVar.zzu();
        zzu.zzc(context);
        zzu.zza(new com.google.android.gms.ads.internal.client.zzq());
        zzu.zzb(str);
        zzeqm zza = zzu.zzd().zza();
        this.zzb = zza;
        zza.zzD(new zzdxq(this, zzdxkVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdxf
    public final void zza() {
        this.zzb.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzdxf
    public final void zzb(com.google.android.gms.ads.internal.client.zzl zzlVar) {
        this.zzb.zzaa(zzlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxf
    public final void zzc() {
        this.zzb.zzW(ObjectWrapper.wrap(null));
    }
}

package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzdoy implements zzgej {
    final /* synthetic */ zzdoz zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdoy(zzdoz zzdozVar) {
        this.zza = zzdozVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfb)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(th, "omid native display exp");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final void zzb(List list) {
        try {
            zzcjk zzcjkVar = (zzcjk) list.get(0);
            if (zzcjkVar != null) {
                this.zza.zzb(zzcjkVar);
            }
        } catch (ClassCastException | IndexOutOfBoundsException e) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfb)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "omid native display exp");
            }
        }
    }
}

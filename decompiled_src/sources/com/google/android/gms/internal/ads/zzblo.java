package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
final class zzblo extends zzbkp {
    final /* synthetic */ zzblr zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzblo(zzblr zzblrVar, zzbln zzblnVar) {
        this.zza = zzblrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkq
    public final void zze(zzbkg zzbkgVar, String str) {
        zzblr zzblrVar = this.zza;
        if (zzblr.zza(zzblrVar) == null) {
            return;
        }
        zzblr.zza(zzblrVar).zzb(zzblr.zze(zzblrVar, zzbkgVar), str);
    }
}

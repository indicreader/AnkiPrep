package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
final class zzbwd extends zzbkp {
    final /* synthetic */ zzbwg zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbwd(zzbwg zzbwgVar, zzbwc zzbwcVar) {
        this.zza = zzbwgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkq
    public final void zze(zzbkg zzbkgVar, String str) {
        zzbwg zzbwgVar = this.zza;
        if (zzbwg.zzc(zzbwgVar) == null) {
            return;
        }
        zzbwg.zzc(zzbwgVar).onCustomClick(zzbwg.zze(zzbwgVar, zzbkgVar), str);
    }
}

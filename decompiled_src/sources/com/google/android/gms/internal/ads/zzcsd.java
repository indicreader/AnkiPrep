package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcsd implements zzgej {
    final /* synthetic */ zzfny zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcse zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcsd(zzcse zzcseVar, zzfny zzfnyVar, String str) {
        this.zza = zzfnyVar;
        this.zzb = str;
        this.zzc = zzcseVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(final Throwable th) {
        zzgey zzgeyVar;
        zzgeyVar = this.zzc.zzg;
        final zzfny zzfnyVar = this.zza;
        final String str = this.zzb;
        zzgeyVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcsb
            @Override // java.lang.Runnable
            public final void run() {
                Context context;
                Context context2;
                boolean booleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjT)).booleanValue();
                zzcsd zzcsdVar = zzcsd.this;
                Throwable th2 = th;
                if (booleanValue) {
                    zzcse zzcseVar = zzcsdVar.zzc;
                    context2 = zzcseVar.zzc;
                    zzcseVar.zzb = zzbxw.zzc(context2);
                    zzcsdVar.zzc.zzb.zzg(th2, "AttributionReporting.registerSourceAndPingClickUrl");
                } else {
                    zzcse zzcseVar2 = zzcsdVar.zzc;
                    context = zzcseVar2.zzc;
                    zzcseVar2.zza = zzbxw.zza(context);
                    zzcsdVar.zzc.zza.zzg(th2, "AttributionReporting.registerSourceAndPingClickUrl");
                }
                zzfnyVar.zzc(str, null);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzgey zzgeyVar;
        zzcse zzcseVar = this.zzc;
        final zzfny zzfnyVar = this.zza;
        final String str = (String) obj;
        zzgeyVar = zzcseVar.zzg;
        zzgeyVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcsc
            @Override // java.lang.Runnable
            public final void run() {
                zzfny.this.zzc(str, null);
            }
        });
    }
}

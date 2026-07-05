package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcdh extends com.google.android.gms.ads.internal.util.zzb {
    final /* synthetic */ zzcdl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcdh(zzcdl zzcdlVar) {
        this.zza = zzcdlVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        Context context;
        zzcei zzceiVar;
        Object obj;
        zzbgk zzbgkVar;
        zzcdl zzcdlVar = this.zza;
        context = zzcdlVar.zze;
        zzceiVar = zzcdlVar.zzf;
        zzbgi zzbgiVar = new zzbgi(context, zzceiVar.zza);
        obj = this.zza.zza;
        synchronized (obj) {
            try {
                com.google.android.gms.ads.internal.zzt.zze();
                zzbgkVar = this.zza.zzh;
                zzbgl.zza(zzbgkVar, zzbgiVar);
            } catch (IllegalArgumentException e) {
                zzcec.zzk("Cannot config CSI reporter.", e);
            }
        }
    }
}

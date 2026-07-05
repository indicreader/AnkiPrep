package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzejx extends zzbuf {
    final /* synthetic */ zzejy zza;
    private final zzeiq zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzejx(zzejy zzejyVar, zzeiq zzeiqVar, zzejw zzejwVar) {
        this.zza = zzejyVar;
        this.zzb = zzeiqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbug
    public final void zze(String str) throws RemoteException {
        ((zzekj) this.zzb.zzc).zzi(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbug
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzekj) this.zzb.zzc).zzh(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbug
    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzejy.zze(this.zza, (View) ObjectWrapper.unwrap(iObjectWrapper));
        ((zzekj) this.zzb.zzc).zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzbug
    public final void zzh(zzbte zzbteVar) throws RemoteException {
        zzejy.zzd(this.zza, zzbteVar);
        ((zzekj) this.zzb.zzc).zzo();
    }
}

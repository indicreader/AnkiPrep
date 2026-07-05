package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzfgi implements OnAdMetadataChangedListener {
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzby zza;
    final /* synthetic */ zzfgj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfgi(zzfgj zzfgjVar, com.google.android.gms.ads.internal.client.zzby zzbyVar) {
        this.zza = zzbyVar;
        this.zzb = zzfgjVar;
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void onAdMetadataChanged() {
        zzdso zzdsoVar;
        zzdsoVar = this.zzb.zzd;
        if (zzdsoVar != null) {
            try {
                this.zza.zze();
            } catch (RemoteException e) {
                zzcec.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}

package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdrl implements zzbng {
    private final zzbkq zza;
    private final zzdrz zzb;
    private final zzhgx zzc;

    public zzdrl(zzdnl zzdnlVar, zzdna zzdnaVar, zzdrz zzdrzVar, zzhgx zzhgxVar) {
        this.zza = zzdnlVar.zzc(zzdnaVar.zzA());
        this.zzb = zzdrzVar;
        this.zzc = zzhgxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("asset");
        try {
            this.zza.zze((zzbkg) this.zzc.zzb(), str);
        } catch (RemoteException e) {
            zzcec.zzk("Failed to call onCustomClick for asset " + str + ".", e);
        }
    }

    public final void zzb() {
        if (this.zza == null) {
            return;
        }
        this.zzb.zzi("/nativeAdCustomClick", this);
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdlb implements zzdax, zzdhz {
    private final zzccd zza;
    private final Context zzb;
    private final zzcch zzc;
    private final View zzd;
    private String zze;
    private final zzbbz zzf;

    public zzdlb(zzccd zzccdVar, Context context, zzcch zzcchVar, View view, zzbbz zzbbzVar) {
        this.zza = zzccdVar;
        this.zzb = context;
        this.zzc = zzcchVar;
        this.zzd = view;
        this.zzf = zzbbzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zza() {
        this.zza.zzb(false);
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzb() {
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    @ParametersAreNonnullByDefault
    public final void zzbB(zzbzu zzbzuVar, String str, String str2) {
        if (this.zzc.zzp(this.zzb)) {
            try {
                zzcch zzcchVar = this.zzc;
                Context context = this.zzb;
                zzcchVar.zzl(context, zzcchVar.zza(context), this.zza.zza(), zzbzuVar.zzc(), zzbzuVar.zzb());
            } catch (RemoteException e) {
                zzcec.zzk("Remote Exception to get reward item.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzc() {
        View view = this.zzd;
        if (view != null && this.zze != null) {
            this.zzc.zzo(view.getContext(), this.zze);
        }
        this.zza.zzb(true);
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzdhz
    public final void zzk() {
    }

    @Override // com.google.android.gms.internal.ads.zzdhz
    public final void zzl() {
        if (this.zzf == zzbbz.APP_OPEN) {
            return;
        }
        String zzc = this.zzc.zzc(this.zzb);
        this.zze = zzc;
        this.zze = String.valueOf(zzc).concat(this.zzf == zzbbz.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial");
    }
}

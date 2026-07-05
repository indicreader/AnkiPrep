package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdoe implements View.OnClickListener {
    String zza;
    Long zzb;
    WeakReference zzc;
    private final zzdrz zzd;
    private final Clock zze;
    private zzblg zzf;
    private zzbng zzg;

    public zzdoe(zzdrz zzdrzVar, Clock clock) {
        this.zzd = zzdrzVar;
        this.zze = clock;
    }

    private final void zzd() {
        View view;
        this.zza = null;
        this.zzb = null;
        WeakReference weakReference = this.zzc;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        view.setClickable(false);
        view.setOnClickListener(null);
        this.zzc = null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WeakReference weakReference = this.zzc;
        if (weakReference == null || weakReference.get() != view) {
            return;
        }
        if (this.zza != null && this.zzb != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("id", this.zza);
            hashMap.put("time_interval", String.valueOf(this.zze.currentTimeMillis() - this.zzb.longValue()));
            hashMap.put("messageType", "onePointFiveClick");
            this.zzd.zzg("sendMessageToNativeJs", hashMap);
        }
        zzd();
    }

    public final zzblg zza() {
        return this.zzf;
    }

    public final void zzb() {
        if (this.zzf == null || this.zzb == null) {
            return;
        }
        zzd();
        try {
            this.zzf.zze();
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzc(final zzblg zzblgVar) {
        this.zzf = zzblgVar;
        zzbng zzbngVar = this.zzg;
        if (zzbngVar != null) {
            this.zzd.zzk("/unconfirmedClick", zzbngVar);
        }
        zzbng zzbngVar2 = new zzbng() { // from class: com.google.android.gms.internal.ads.zzdod
            @Override // com.google.android.gms.internal.ads.zzbng
            public final void zza(Object obj, Map map) {
                zzdoe zzdoeVar = zzdoe.this;
                try {
                    zzdoeVar.zzb = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
                } catch (NumberFormatException unused) {
                    zzcec.zzg("Failed to call parse unconfirmedClickTimestamp.");
                }
                zzblg zzblgVar2 = zzblgVar;
                zzdoeVar.zza = (String) map.get("id");
                String str = (String) map.get("asset_id");
                if (zzblgVar2 == null) {
                    zzcec.zze("Received unconfirmed click but UnconfirmedClickListener is null.");
                    return;
                }
                try {
                    zzblgVar2.zzf(str);
                } catch (RemoteException e) {
                    zzcec.zzl("#007 Could not call remote method.", e);
                }
            }
        };
        this.zzg = zzbngVar2;
        this.zzd.zzi("/unconfirmedClick", zzbngVar2);
    }
}

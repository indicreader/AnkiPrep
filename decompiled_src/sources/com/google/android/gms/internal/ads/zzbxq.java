package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbxq {

    @Nonnull
    private final View zza;
    private final Map zzb;
    private final zzcct zzc;

    public zzbxq(zzbxp zzbxpVar) {
        View view;
        Map map;
        View view2;
        view = zzbxpVar.zza;
        this.zza = view;
        map = zzbxpVar.zzb;
        this.zzb = map;
        view2 = zzbxpVar.zza;
        zzcct zza = zzbxk.zza(view2.getContext());
        this.zzc = zza;
        if (zza == null || map.isEmpty()) {
            return;
        }
        try {
            zza.zzg(new zzbxr(ObjectWrapper.wrap(view).asBinder(), ObjectWrapper.wrap(map).asBinder()));
        } catch (RemoteException unused) {
            zzcec.zzg("Failed to call remote method.");
        }
    }

    public final void zza(List list) {
        if (list == null || list.isEmpty()) {
            zzcec.zzj("No click urls were passed to recordClick");
            return;
        }
        if (this.zzc == null) {
            zzcec.zzj("Failed to get internal reporting info generator in recordClick.");
        }
        try {
            this.zzc.zzh(list, ObjectWrapper.wrap(this.zza), new zzbxo(this, list));
        } catch (RemoteException e) {
            zzcec.zzg("RemoteException recording click: ".concat(e.toString()));
        }
    }

    public final void zzb(List list) {
        if (list == null || list.isEmpty()) {
            zzcec.zzj("No impression urls were passed to recordImpression");
            return;
        }
        zzcct zzcctVar = this.zzc;
        if (zzcctVar != null) {
            try {
                zzcctVar.zzi(list, ObjectWrapper.wrap(this.zza), new zzbxn(this, list));
                return;
            } catch (RemoteException e) {
                zzcec.zzg("RemoteException recording impression urls: ".concat(e.toString()));
                return;
            }
        }
        zzcec.zzj("Failed to get internal reporting info generator from recordImpression.");
    }

    public final void zzc(MotionEvent motionEvent) {
        zzcct zzcctVar = this.zzc;
        if (zzcctVar != null) {
            try {
                zzcctVar.zzk(ObjectWrapper.wrap(motionEvent));
                return;
            } catch (RemoteException unused) {
                zzcec.zzg("Failed to call remote method.");
                return;
            }
        }
        zzcec.zze("Failed to get internal reporting info generator.");
    }

    public final void zzd(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        if (this.zzc == null) {
            updateClickUrlCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzc.zzl(new ArrayList(Arrays.asList(uri)), ObjectWrapper.wrap(this.zza), new zzbxm(this, updateClickUrlCallback));
        } catch (RemoteException e) {
            updateClickUrlCallback.onFailure("Internal error: ".concat(e.toString()));
        }
    }

    public final void zze(List list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        if (this.zzc == null) {
            updateImpressionUrlsCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzc.zzm(list, ObjectWrapper.wrap(this.zza), new zzbxl(this, updateImpressionUrlsCallback));
        } catch (RemoteException e) {
            updateImpressionUrlsCallback.onFailure("Internal error: ".concat(e.toString()));
        }
    }
}

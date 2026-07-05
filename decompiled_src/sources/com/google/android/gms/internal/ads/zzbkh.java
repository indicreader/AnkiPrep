package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbkh {
    private final zzbkg zza;
    private final MediaView zzb;
    private final VideoController zzc = new VideoController();

    public zzbkh(zzbkg zzbkgVar) {
        Context context;
        this.zza = zzbkgVar;
        MediaView mediaView = null;
        try {
            context = (Context) ObjectWrapper.unwrap(zzbkgVar.zzh());
        } catch (RemoteException | NullPointerException e) {
            zzcec.zzh("", e);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (true == this.zza.zzs(ObjectWrapper.wrap(mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (RemoteException e2) {
                zzcec.zzh("", e2);
            }
        }
        this.zzb = mediaView;
    }

    public final zzbkg zza() {
        return this.zza;
    }

    public final String zzb() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e) {
            zzcec.zzh("", e);
            return null;
        }
    }
}

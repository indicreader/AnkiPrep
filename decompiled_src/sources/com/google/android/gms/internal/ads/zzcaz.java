package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcaz {
    public static final zzcan zza(Context context, String str, zzbsv zzbsvVar) {
        try {
            IBinder zze = ((zzcar) zzceg.zzb(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", new zzcee() { // from class: com.google.android.gms.internal.ads.zzcay
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.internal.ads.zzcee
                public final Object zza(Object obj) {
                    if (obj == 0) {
                        return null;
                    }
                    IInterface queryLocalInterface = obj.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
                    return queryLocalInterface instanceof zzcar ? (zzcar) queryLocalInterface : new zzcar(obj);
                }
            })).zze(ObjectWrapper.wrap(context), str, zzbsvVar, 240304000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            return queryLocalInterface instanceof zzcan ? (zzcan) queryLocalInterface : new zzcal(zze);
        } catch (RemoteException | zzcef e) {
            zzcec.zzl("#007 Could not call remote method.", e);
            return null;
        }
    }
}

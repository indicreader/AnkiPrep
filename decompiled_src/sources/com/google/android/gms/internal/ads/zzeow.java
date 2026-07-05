package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeow {
    private final ConcurrentHashMap zza = new ConcurrentHashMap();
    private final zzdua zzb;

    public zzeow(zzdua zzduaVar) {
        this.zzb = zzduaVar;
    }

    @CheckForNull
    public final zzbus zza(String str) {
        if (this.zza.containsKey(str)) {
            return (zzbus) this.zza.get(str);
        }
        return null;
    }

    public final void zzb(String str) {
        try {
            this.zza.put(str, this.zzb.zzb(str));
        } catch (RemoteException e) {
            zzcec.zzh("Couldn't create RTB adapter : ", e);
        }
    }
}

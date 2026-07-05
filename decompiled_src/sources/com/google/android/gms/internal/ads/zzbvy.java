package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbvy extends NativeAd.AdChoicesInfo {
    private final List zza = new ArrayList();
    private String zzb;

    public zzbvy(zzbjf zzbjfVar) {
        try {
            this.zzb = zzbjfVar.zzg();
        } catch (RemoteException e) {
            zzcec.zzh("", e);
            this.zzb = "";
        }
        try {
            for (Object obj : zzbjfVar.zzh()) {
                zzbjm zzg = obj instanceof IBinder ? zzbjl.zzg((IBinder) obj) : null;
                if (zzg != null) {
                    this.zza.add(new zzbwa(zzg));
                }
            }
        } catch (RemoteException e2) {
            zzcec.zzh("", e2);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.AdChoicesInfo
    public final List<NativeAd.Image> getImages() {
        return this.zza;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.AdChoicesInfo
    public final CharSequence getText() {
        return this.zzb;
    }
}

package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzens implements zzeip {
    private final zzeow zza;
    private final zzdua zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzens(zzeow zzeowVar, zzdua zzduaVar) {
        this.zza = zzeowVar;
        this.zzb = zzduaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final zzeiq zza(String str, JSONObject jSONObject) throws zzfho {
        zzbus zzbusVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbE)).booleanValue()) {
            try {
                zzbusVar = this.zzb.zzb(str);
            } catch (RemoteException e) {
                zzcec.zzh("Coundn't create RTB adapter: ", e);
                zzbusVar = null;
            }
        } else {
            zzbusVar = this.zza.zza(str);
        }
        if (zzbusVar == null) {
            return null;
        }
        return new zzeiq(zzbusVar, new zzekj(), str);
    }
}

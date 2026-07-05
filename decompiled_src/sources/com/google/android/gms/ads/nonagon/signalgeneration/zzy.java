package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import coil.disk.DiskLruCache;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbxi;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzfny;
import com.google.android.gms.internal.ads.zzgej;
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzy implements zzgej {
    final /* synthetic */ zzbxi zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzaa zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzy(zzaa zzaaVar, zzbxi zzbxiVar, boolean z) {
        this.zza = zzbxiVar;
        this.zzb = z;
        this.zzc = zzaaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        try {
            this.zza.zze("Internal error: " + th.getMessage());
        } catch (RemoteException e) {
            zzcec.zzh("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(@Nonnull Object obj) {
        boolean z;
        String str;
        Uri zzac;
        zzfny zzfnyVar;
        zzfny zzfnyVar2;
        List<Uri> list = (List) obj;
        try {
            zzaa.zzI(this.zzc, list);
            this.zza.zzf(list);
            z = this.zzc.zzv;
            if (z || this.zzb) {
                for (Uri uri : list) {
                    if (this.zzc.zzR(uri)) {
                        str = this.zzc.zzD;
                        zzac = zzaa.zzac(uri, str, DiskLruCache.VERSION);
                        zzfnyVar = this.zzc.zzt;
                        zzfnyVar.zzc(zzac.toString(), null);
                    } else {
                        if (((Boolean) zzba.zzc().zza(zzbgc.zzhx)).booleanValue()) {
                            zzfnyVar2 = this.zzc.zzt;
                            zzfnyVar2.zzc(uri.toString(), null);
                        }
                    }
                }
            }
        } catch (RemoteException e) {
            zzcec.zzh("", e);
        }
    }
}

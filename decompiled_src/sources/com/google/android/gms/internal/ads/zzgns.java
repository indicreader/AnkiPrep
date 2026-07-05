package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgns {
    public static final zzgrx zza = new zzgnr(null);

    public static zzgsd zza(zzggx zzggxVar) {
        zzgge zzggeVar;
        zzgrz zzgrzVar = new zzgrz();
        zzgrzVar.zzb(zzggxVar.zzb());
        Iterator it = zzggxVar.zzd().iterator();
        while (it.hasNext()) {
            for (zzggt zzggtVar : (List) it.next()) {
                int zzh = zzggtVar.zzh() - 2;
                if (zzh == 1) {
                    zzggeVar = zzgge.zza;
                } else if (zzh == 2) {
                    zzggeVar = zzgge.zzb;
                } else if (zzh == 3) {
                    zzggeVar = zzgge.zzc;
                } else {
                    throw new IllegalStateException("Unknown key status");
                }
                int zza2 = zzggtVar.zza();
                String zzf = zzggtVar.zzf();
                if (zzf.startsWith("type.googleapis.com/google.crypto.")) {
                    zzf = zzf.substring(34);
                }
                zzgrzVar.zza(zzggeVar, zza2, zzf, zzggtVar.zzc().name());
            }
        }
        if (zzggxVar.zza() != null) {
            zzgrzVar.zzc(zzggxVar.zza().zza());
        }
        try {
            return zzgrzVar.zzd();
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}

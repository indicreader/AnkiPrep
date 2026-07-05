package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgqi implements zzggy {
    private static final zzgqi zza = new zzgqi();

    private zzgqi() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzd() throws GeneralSecurityException {
        zzghb.zzf(zza);
    }

    @Override // com.google.android.gms.internal.ads.zzggy
    public final Class zza() {
        return zzgqf.class;
    }

    @Override // com.google.android.gms.internal.ads.zzggy
    public final Class zzb() {
        return zzgqf.class;
    }

    @Override // com.google.android.gms.internal.ads.zzggy
    public final /* bridge */ /* synthetic */ Object zzc(zzggx zzggxVar) throws GeneralSecurityException {
        if (zzggxVar.zza() == null) {
            throw new GeneralSecurityException("no primary in primitive set");
        }
        Iterator it = zzggxVar.zzd().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            while (it2.hasNext()) {
            }
        }
        return new zzgqh(zzggxVar, null);
    }
}

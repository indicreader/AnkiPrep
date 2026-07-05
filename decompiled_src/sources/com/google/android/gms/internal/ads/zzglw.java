package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzglw {
    public static final /* synthetic */ int zza = 0;
    private static final zzgoq zzb = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzglt
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzggc zzggcVar) {
            return zzgxp.zzb((zzgls) zzggcVar);
        }
    }, zzgls.class, zzgfs.class);
    private static final zzggd zzc = zzgnm.zzd("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", zzgfs.class, zzgus.SYMMETRIC, zzgwf.zzg());
    private static final zzgnv zzd = new zzgnv() { // from class: com.google.android.gms.internal.ads.zzglu
    };
    private static final zzgnt zze = new zzgnt() { // from class: com.google.android.gms.internal.ads.zzglv
        @Override // com.google.android.gms.internal.ads.zzgnt
        public final zzggc zza(zzggq zzggqVar, Integer num) {
            int i = zzglw.zza;
            return zzgls.zza(((zzgly) zzggqVar).zzb(), zzgxr.zzc(32), null);
        }
    };

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzgms.zza;
        zzgms.zze(zzgoe.zzd());
        zzgob.zza().zze(zzb);
        zzgoa zzb2 = zzgoa.zzb();
        HashMap hashMap = new HashMap();
        hashMap.put("XCHACHA20_POLY1305", zzgly.zzc(zzglx.zza));
        hashMap.put("XCHACHA20_POLY1305_RAW", zzgly.zzc(zzglx.zzc));
        zzb2.zzd(Collections.unmodifiableMap(hashMap));
        zzgnu.zzb().zzc(zze, zzgly.class);
        zzgnw.zza().zzb(zzd, zzgly.class);
        zzghb.zze(zzc, true);
    }
}

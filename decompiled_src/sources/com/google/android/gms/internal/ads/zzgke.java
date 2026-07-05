package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgke {
    public static final /* synthetic */ int zza = 0;
    private static final zzgoq zzb = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgkc
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzggc zzggcVar) {
            return zzgwq.zzb((zzgkb) zzggcVar);
        }
    }, zzgkb.class, zzgfs.class);
    private static final zzgnt zzc = new zzgnt() { // from class: com.google.android.gms.internal.ads.zzgkd
        @Override // com.google.android.gms.internal.ads.zzgnt
        public final zzggc zza(zzggq zzggqVar, Integer num) {
            int i = zzgke.zza;
            return zzgkb.zza(((zzgkg) zzggqVar).zzb(), zzgxr.zzc(32), null);
        }
    };
    private static final zzggd zzd = zzgnm.zzd("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", zzgfs.class, zzgus.SYMMETRIC, zzgua.zzg());

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzgkl.zza;
        zzgkl.zze(zzgoe.zzd());
        zzgob.zza().zze(zzb);
        zzgnu.zzb().zzc(zzc, zzgkg.class);
        zzgoa zzb2 = zzgoa.zzb();
        HashMap hashMap = new HashMap();
        hashMap.put("CHACHA20_POLY1305", zzgkg.zzc(zzgkf.zza));
        hashMap.put("CHACHA20_POLY1305_RAW", zzgkg.zzc(zzgkf.zzc));
        zzb2.zzd(Collections.unmodifiableMap(hashMap));
        zzghb.zze(zzd, true);
    }
}

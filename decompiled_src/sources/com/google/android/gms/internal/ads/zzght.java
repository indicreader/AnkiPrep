package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzght {
    public static final /* synthetic */ int zza = 0;
    private static final zzgoq zzb = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzghq
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzggc zzggcVar) {
            return zzgwr.zzb((zzghp) zzggcVar);
        }
    }, zzghp.class, zzgfs.class);
    private static final zzggd zzc = zzgnm.zzd("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", zzgfs.class, zzgus.SYMMETRIC, zzgsq.zzh());
    private static final zzgnv zzd = new zzgnv() { // from class: com.google.android.gms.internal.ads.zzghr
    };
    private static final zzgnt zze = new zzgnt() { // from class: com.google.android.gms.internal.ads.zzghs
        @Override // com.google.android.gms.internal.ads.zzgnt
        public final zzggc zza(zzggq zzggqVar, Integer num) {
            zzghz zzghzVar = (zzghz) zzggqVar;
            int i = zzght.zza;
            if (zzghzVar.zzb() == 16 || zzghzVar.zzb() == 32) {
                zzghn zzghnVar = new zzghn(null);
                zzghnVar.zzd(zzghzVar);
                zzghnVar.zzc(null);
                zzghnVar.zza(zzgxr.zzc(zzghzVar.zzb()));
                zzghnVar.zzb(zzgxr.zzc(zzghzVar.zzc()));
                return zzghnVar.zze();
            }
            throw new GeneralSecurityException("AES key size must be 16 or 32 bytes");
        }
    };

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzgie.zza;
        zzgie.zze(zzgoe.zzd());
        zzgob.zza().zze(zzb);
        zzgoa zzb2 = zzgoa.zzb();
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_CTR_HMAC_SHA256", zzglr.zze);
        zzghv zzghvVar = new zzghv(null);
        zzghvVar.zza(16);
        zzghvVar.zzc(32);
        zzghvVar.zze(16);
        zzghvVar.zzd(16);
        zzghvVar.zzb(zzghw.zzc);
        zzghvVar.zzf(zzghx.zzc);
        hashMap.put("AES128_CTR_HMAC_SHA256_RAW", zzghvVar.zzg());
        hashMap.put("AES256_CTR_HMAC_SHA256", zzglr.zzf);
        zzghv zzghvVar2 = new zzghv(null);
        zzghvVar2.zza(32);
        zzghvVar2.zzc(32);
        zzghvVar2.zze(32);
        zzghvVar2.zzd(16);
        zzghvVar2.zzb(zzghw.zzc);
        zzghvVar2.zzf(zzghx.zzc);
        hashMap.put("AES256_CTR_HMAC_SHA256_RAW", zzghvVar2.zzg());
        zzb2.zzd(Collections.unmodifiableMap(hashMap));
        zzgnw.zza().zzb(zzd, zzghz.class);
        zzgnu.zzb().zzc(zze, zzghz.class);
        zzgnd.zzc().zzf(zzc, 2, true);
    }
}

package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgjq {
    private static final zzgoq zza = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgjn
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzggc zzggcVar) {
            return zzgmu.zzb((zzgjm) zzggcVar);
        }
    }, zzgjm.class, zzgfs.class);
    private static final zzgnt zzb = new zzgnt() { // from class: com.google.android.gms.internal.ads.zzgjo
        @Override // com.google.android.gms.internal.ads.zzgnt
        public final zzggc zza(zzggq zzggqVar, Integer num) {
            zzgjv zzgjvVar = (zzgjv) zzggqVar;
            zzgjk zzgjkVar = new zzgjk(null);
            zzgjkVar.zzc(zzgjvVar);
            zzgjkVar.zza(null);
            zzgjkVar.zzb(zzgxr.zzc(zzgjvVar.zzb()));
            return zzgjkVar.zzd();
        }
    };
    private static final zzgnv zzc = new zzgnv() { // from class: com.google.android.gms.internal.ads.zzgjp
    };
    private static final zzggd zzd = zzgnm.zzd("type.googleapis.com/google.crypto.tink.AesGcmSivKey", zzgfs.class, zzgus.SYMMETRIC, zzgtu.zzg());

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzgka.zza;
        zzgka.zze(zzgoe.zzd());
        if (zzb()) {
            zzgob.zza().zze(zza);
            zzgoa zzb2 = zzgoa.zzb();
            HashMap hashMap = new HashMap();
            zzgjs zzgjsVar = new zzgjs(null);
            zzgjsVar.zza(16);
            zzgjsVar.zzb(zzgjt.zza);
            hashMap.put("AES128_GCM_SIV", zzgjsVar.zzc());
            zzgjs zzgjsVar2 = new zzgjs(null);
            zzgjsVar2.zza(16);
            zzgjsVar2.zzb(zzgjt.zzc);
            hashMap.put("AES128_GCM_SIV_RAW", zzgjsVar2.zzc());
            zzgjs zzgjsVar3 = new zzgjs(null);
            zzgjsVar3.zza(32);
            zzgjsVar3.zzb(zzgjt.zza);
            hashMap.put("AES256_GCM_SIV", zzgjsVar3.zzc());
            zzgjs zzgjsVar4 = new zzgjs(null);
            zzgjsVar4.zza(32);
            zzgjsVar4.zzb(zzgjt.zzc);
            hashMap.put("AES256_GCM_SIV_RAW", zzgjsVar4.zzc());
            zzb2.zzd(Collections.unmodifiableMap(hashMap));
            zzgnw.zza().zzb(zzc, zzgjv.class);
            zzgnu.zzb().zzc(zzb, zzgjv.class);
            zzghb.zze(zzd, true);
        }
    }

    private static boolean zzb() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }
}

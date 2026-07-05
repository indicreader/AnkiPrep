package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgpu {
    private static final zzgnt zza = new zzgnt() { // from class: com.google.android.gms.internal.ads.zzgpr
        @Override // com.google.android.gms.internal.ads.zzgnt
        public final zzggc zza(zzggq zzggqVar, Integer num) {
            return zzgpu.zzb((zzgpz) zzggqVar, null);
        }
    };
    private static final zzgoq zzb = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgps
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzggc zzggcVar) {
            return zzgpu.zzc((zzgpq) zzggcVar);
        }
    }, zzgpq.class, zzgqf.class);
    private static final zzgoq zzc = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgpt
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzggc zzggcVar) {
            return zzgpu.zza((zzgpq) zzggcVar);
        }
    }, zzgpq.class, zzggp.class);
    private static final zzggd zzd = zzgnm.zzd("type.googleapis.com/google.crypto.tink.AesCmacKey", zzggp.class, zzgus.SYMMETRIC, zzgsh.zzh());

    public static /* synthetic */ zzggp zza(zzgpq zzgpqVar) {
        zze(zzgpqVar.zza());
        return zzgxn.zza(zzgpqVar);
    }

    public static /* synthetic */ zzgpq zzb(zzgpz zzgpzVar, Integer num) {
        zze(zzgpzVar);
        zzgpo zzgpoVar = new zzgpo(null);
        zzgpoVar.zzc(zzgpzVar);
        zzgpoVar.zza(zzgxr.zzc(zzgpzVar.zzc()));
        zzgpoVar.zzb(null);
        return zzgpoVar.zzd();
    }

    public static /* synthetic */ zzgqf zzc(zzgpq zzgpqVar) {
        zze(zzgpqVar.zza());
        return new zzgrm(zzgpqVar);
    }

    public static void zzd(boolean z) throws GeneralSecurityException {
        int i = zzgqe.zza;
        zzgqe.zze(zzgoe.zzd());
        zzgnu.zzb().zzc(zza, zzgpz.class);
        zzgob.zza().zze(zzb);
        zzgob.zza().zze(zzc);
        zzgoa zzb2 = zzgoa.zzb();
        HashMap hashMap = new HashMap();
        hashMap.put("AES_CMAC", zzgrk.zze);
        hashMap.put("AES256_CMAC", zzgrk.zze);
        zzgpw zzgpwVar = new zzgpw(null);
        zzgpwVar.zza(32);
        zzgpwVar.zzb(16);
        zzgpwVar.zzc(zzgpx.zzd);
        hashMap.put("AES256_CMAC_RAW", zzgpwVar.zzd());
        zzb2.zzd(Collections.unmodifiableMap(hashMap));
        zzghb.zze(zzd, true);
    }

    private static void zze(zzgpz zzgpzVar) throws GeneralSecurityException {
        if (zzgpzVar.zzc() != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }
}

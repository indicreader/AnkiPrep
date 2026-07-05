package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgqr {
    private static final zzgoq zza = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgqn
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzggc zzggcVar) {
            return new zzgrn((zzgqm) zzggcVar);
        }
    }, zzgqm.class, zzgqf.class);
    private static final zzgoq zzb = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgqo
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzggc zzggcVar) {
            return zzgxn.zzb((zzgqm) zzggcVar);
        }
    }, zzgqm.class, zzggp.class);
    private static final zzggd zzc = zzgnm.zzd("type.googleapis.com/google.crypto.tink.HmacKey", zzggp.class, zzgus.SYMMETRIC, zzgui.zzi());
    private static final zzgnv zzd = new zzgnv() { // from class: com.google.android.gms.internal.ads.zzgqp
    };
    private static final zzgnt zze = new zzgnt() { // from class: com.google.android.gms.internal.ads.zzgqq
        @Override // com.google.android.gms.internal.ads.zzgnt
        public final zzggc zza(zzggq zzggqVar, Integer num) {
            zzgqx zzgqxVar = (zzgqx) zzggqVar;
            zzgqk zzgqkVar = new zzgqk(null);
            zzgqkVar.zzc(zzgqxVar);
            zzgqkVar.zzb(zzgxr.zzc(zzgqxVar.zzc()));
            zzgqkVar.zza(null);
            return zzgqkVar.zzd();
        }
    };

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzgrs.zza;
        zzgrs.zze(zzgoe.zzd());
        zzgob.zza().zze(zza);
        zzgob.zza().zze(zzb);
        zzgoa zzb2 = zzgoa.zzb();
        HashMap hashMap = new HashMap();
        hashMap.put("HMAC_SHA256_128BITTAG", zzgrk.zza);
        zzgqt zzgqtVar = new zzgqt(null);
        zzgqtVar.zzb(32);
        zzgqtVar.zzc(16);
        zzgqtVar.zzd(zzgqv.zzd);
        zzgqtVar.zza(zzgqu.zzc);
        hashMap.put("HMAC_SHA256_128BITTAG_RAW", zzgqtVar.zze());
        zzgqt zzgqtVar2 = new zzgqt(null);
        zzgqtVar2.zzb(32);
        zzgqtVar2.zzc(32);
        zzgqtVar2.zzd(zzgqv.zza);
        zzgqtVar2.zza(zzgqu.zzc);
        hashMap.put("HMAC_SHA256_256BITTAG", zzgqtVar2.zze());
        zzgqt zzgqtVar3 = new zzgqt(null);
        zzgqtVar3.zzb(32);
        zzgqtVar3.zzc(32);
        zzgqtVar3.zzd(zzgqv.zzd);
        zzgqtVar3.zza(zzgqu.zzc);
        hashMap.put("HMAC_SHA256_256BITTAG_RAW", zzgqtVar3.zze());
        zzgqt zzgqtVar4 = new zzgqt(null);
        zzgqtVar4.zzb(64);
        zzgqtVar4.zzc(16);
        zzgqtVar4.zzd(zzgqv.zza);
        zzgqtVar4.zza(zzgqu.zze);
        hashMap.put("HMAC_SHA512_128BITTAG", zzgqtVar4.zze());
        zzgqt zzgqtVar5 = new zzgqt(null);
        zzgqtVar5.zzb(64);
        zzgqtVar5.zzc(16);
        zzgqtVar5.zzd(zzgqv.zzd);
        zzgqtVar5.zza(zzgqu.zze);
        hashMap.put("HMAC_SHA512_128BITTAG_RAW", zzgqtVar5.zze());
        zzgqt zzgqtVar6 = new zzgqt(null);
        zzgqtVar6.zzb(64);
        zzgqtVar6.zzc(32);
        zzgqtVar6.zzd(zzgqv.zza);
        zzgqtVar6.zza(zzgqu.zze);
        hashMap.put("HMAC_SHA512_256BITTAG", zzgqtVar6.zze());
        zzgqt zzgqtVar7 = new zzgqt(null);
        zzgqtVar7.zzb(64);
        zzgqtVar7.zzc(32);
        zzgqtVar7.zzd(zzgqv.zzd);
        zzgqtVar7.zza(zzgqu.zze);
        hashMap.put("HMAC_SHA512_256BITTAG_RAW", zzgqtVar7.zze());
        hashMap.put("HMAC_SHA512_512BITTAG", zzgrk.zzd);
        zzgqt zzgqtVar8 = new zzgqt(null);
        zzgqtVar8.zzb(64);
        zzgqtVar8.zzc(64);
        zzgqtVar8.zzd(zzgqv.zzd);
        zzgqtVar8.zza(zzgqu.zze);
        hashMap.put("HMAC_SHA512_512BITTAG_RAW", zzgqtVar8.zze());
        zzb2.zzd(Collections.unmodifiableMap(hashMap));
        zzgnu.zzb().zzc(zze, zzgqx.class);
        zzgnw.zza().zzb(zzd, zzgqx.class);
        zzgnd.zzc().zzf(zzc, 2, true);
    }
}

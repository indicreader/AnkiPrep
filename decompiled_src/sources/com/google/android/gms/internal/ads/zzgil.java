package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgil {
    public static final /* synthetic */ int zza = 0;
    private static final zzgoq zzb = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgij
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzggc zzggcVar) {
            return zzgwn.zzb((zzgii) zzggcVar);
        }
    }, zzgii.class, zzgfs.class);
    private static final zzggd zzc = zzgnm.zzd("type.googleapis.com/google.crypto.tink.AesEaxKey", zzgfs.class, zzgus.SYMMETRIC, zzgtf.zzh());
    private static final zzgnt zzd = new zzgnt() { // from class: com.google.android.gms.internal.ads.zzgik
        @Override // com.google.android.gms.internal.ads.zzgnt
        public final zzggc zza(zzggq zzggqVar, Integer num) {
            zzgiq zzgiqVar = (zzgiq) zzggqVar;
            int i = zzgil.zza;
            if (zzgiqVar.zzc() != 24) {
                zzgig zzgigVar = new zzgig(null);
                zzgigVar.zzc(zzgiqVar);
                zzgigVar.zza(null);
                zzgigVar.zzb(zzgxr.zzc(zzgiqVar.zzc()));
                return zzgigVar.zzd();
            }
            throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
        }
    };

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzgiv.zza;
        zzgiv.zze(zzgoe.zzd());
        zzgob.zza().zze(zzb);
        zzgoa zzb2 = zzgoa.zzb();
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_EAX", zzglr.zzc);
        zzgin zzginVar = new zzgin(null);
        zzginVar.zza(16);
        zzginVar.zzb(16);
        zzginVar.zzc(16);
        zzginVar.zzd(zzgio.zzc);
        hashMap.put("AES128_EAX_RAW", zzginVar.zze());
        hashMap.put("AES256_EAX", zzglr.zzd);
        zzgin zzginVar2 = new zzgin(null);
        zzginVar2.zza(16);
        zzginVar2.zzb(32);
        zzginVar2.zzc(16);
        zzginVar2.zzd(zzgio.zzc);
        hashMap.put("AES256_EAX_RAW", zzginVar2.zze());
        zzb2.zzd(Collections.unmodifiableMap(hashMap));
        zzgnu.zzb().zzc(zzd, zzgiq.class);
        zzghb.zze(zzc, true);
    }
}

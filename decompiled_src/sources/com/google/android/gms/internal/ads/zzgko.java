package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgko {
    public static final /* synthetic */ int zza = 0;
    private static final zzgoq zzb = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgkm
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzggc zzggcVar) {
            zzgkt zzgktVar = (zzgkt) zzggcVar;
            int i = zzgko.zza;
            zzggn zza2 = zzggo.zza(zzgktVar.zzb().zzc());
            zzgktVar.zzb().zzc();
            return zza2.zzb();
        }
    }, zzgkt.class, zzgfs.class);
    private static final zzggd zzc = zzgnm.zzd("type.googleapis.com/google.crypto.tink.KmsAeadKey", zzgfs.class, zzgus.REMOTE, zzgvo.zzg());
    private static final zzgnt zzd = new zzgnt() { // from class: com.google.android.gms.internal.ads.zzgkn
        @Override // com.google.android.gms.internal.ads.zzgnt
        public final zzggc zza(zzggq zzggqVar, Integer num) {
            return zzgkt.zza((zzgku) zzggqVar);
        }
    };

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzgkz.zza;
        zzgkz.zza(zzgoe.zzd());
        zzgob.zza().zze(zzb);
        zzgnu.zzb().zzc(zzd, zzgku.class);
        zzghb.zze(zzc, true);
    }
}

package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgkz {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxq zzb;
    private static final zzgom zzc;
    private static final zzgoi zzd;
    private static final zzgnl zze;
    private static final zzgnh zzf;

    static {
        zzgxq zza2 = zzgpm.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zzb = zza2;
        zzc = zzgom.zzb(new zzgok() { // from class: com.google.android.gms.internal.ads.zzgkv
            @Override // com.google.android.gms.internal.ads.zzgok
            public final zzgpc zza(zzggq zzggqVar) {
                int i = zzgkz.zza;
                zzgux zza3 = zzguy.zza();
                zza3.zzb("type.googleapis.com/google.crypto.tink.KmsAeadKey");
                zzgvq zza4 = zzgvr.zza();
                zza4.zza(((zzgku) zzggqVar).zzc());
                zza3.zzc(((zzgvr) zza4.zzal()).zzau());
                zza3.zza(zzgvz.RAW);
                return zzgoy.zzb((zzguy) zza3.zzal());
            }
        }, zzgku.class, zzgoy.class);
        zzd = zzgoi.zzb(new zzgog() { // from class: com.google.android.gms.internal.ads.zzgkw
            @Override // com.google.android.gms.internal.ads.zzgog
            public final zzggq zza(zzgpc zzgpcVar) {
                int i = zzgkz.zza;
                zzgoy zzgoyVar = (zzgoy) zzgpcVar;
                if (!zzgoyVar.zzc().zzh().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzh())));
                }
                try {
                    zzgvr zze2 = zzgvr.zze(((zzgoy) zzgpcVar).zzc().zzg(), zzgzf.zza());
                    if (zzgoyVar.zzc().zzf() != zzgvz.RAW) {
                        throw new GeneralSecurityException("Only key templates with RAW are accepted, but got " + String.valueOf(zzgoyVar.zzc().zzf()) + " with format " + String.valueOf(zze2));
                    }
                    return zzgku.zzb(zze2.zzf());
                } catch (zzhag e) {
                    throw new GeneralSecurityException("Parsing KmsAeadKeyFormat failed: ", e);
                }
            }
        }, zza2, zzgoy.class);
        zze = zzgnl.zzb(new zzgnj() { // from class: com.google.android.gms.internal.ads.zzgkx
            @Override // com.google.android.gms.internal.ads.zzgnj
            public final zzgpc zza(zzggc zzggcVar, zzghc zzghcVar) {
                int i = zzgkz.zza;
                zzgvn zzc2 = zzgvo.zzc();
                zzgvq zza3 = zzgvr.zza();
                zza3.zza(((zzgkt) zzggcVar).zzb().zzc());
                zzc2.zza((zzgvr) zza3.zzal());
                return zzgox.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey", ((zzgvo) zzc2.zzal()).zzau(), zzgus.REMOTE, zzgvz.RAW, null);
            }
        }, zzgkt.class, zzgox.class);
        zzf = zzgnh.zzb(new zzgnf() { // from class: com.google.android.gms.internal.ads.zzgky
            @Override // com.google.android.gms.internal.ads.zzgnf
            public final zzggc zza(zzgpc zzgpcVar, zzghc zzghcVar) {
                int i = zzgkz.zza;
                zzgox zzgoxVar = (zzgox) zzgpcVar;
                if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseKey");
                }
                if (zzgoxVar.zzc() != zzgvz.RAW) {
                    throw new GeneralSecurityException("KmsAeadKey are only accepted with RAW, got ".concat(String.valueOf(String.valueOf(zzgoxVar.zzc()))));
                }
                try {
                    zzgvo zze2 = zzgvo.zze(((zzgox) zzgpcVar).zze(), zzgzf.zza());
                    if (zze2.zza() != 0) {
                        throw new GeneralSecurityException("KmsAeadKey are only accepted with version 0, got " + String.valueOf(zze2));
                    }
                    return zzgkt.zza(zzgku.zzb(zze2.zzf().zzf()));
                } catch (zzhag e) {
                    throw new GeneralSecurityException("Parsing KmsAeadKey failed: ", e);
                }
            }
        }, zza2, zzgox.class);
    }

    public static void zza(zzgoe zzgoeVar) throws GeneralSecurityException {
        zzgoeVar.zzj(zzc);
        zzgoeVar.zzi(zzd);
        zzgoeVar.zzh(zze);
        zzgoeVar.zzg(zzf);
    }
}

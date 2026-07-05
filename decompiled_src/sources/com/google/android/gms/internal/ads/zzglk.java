package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzglk {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxq zzb;
    private static final zzgom zzc;
    private static final zzgoi zzd;
    private static final zzgnl zze;
    private static final zzgnh zzf;

    static {
        zzgxq zza2 = zzgpm.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zzb = zza2;
        zzc = zzgom.zzb(new zzgok() { // from class: com.google.android.gms.internal.ads.zzglg
            @Override // com.google.android.gms.internal.ads.zzgok
            public final zzgpc zza(zzggq zzggqVar) {
                return zzglk.zzd((zzglf) zzggqVar);
            }
        }, zzglf.class, zzgoy.class);
        zzd = zzgoi.zzb(new zzgog() { // from class: com.google.android.gms.internal.ads.zzglh
            @Override // com.google.android.gms.internal.ads.zzgog
            public final zzggq zza(zzgpc zzgpcVar) {
                return zzglk.zzb((zzgoy) zzgpcVar);
            }
        }, zza2, zzgoy.class);
        zze = zzgnl.zzb(new zzgnj() { // from class: com.google.android.gms.internal.ads.zzgli
            @Override // com.google.android.gms.internal.ads.zzgnj
            public final zzgpc zza(zzggc zzggcVar, zzghc zzghcVar) {
                return zzglk.zzc((zzgla) zzggcVar, zzghcVar);
            }
        }, zzgla.class, zzgox.class);
        zzf = zzgnh.zzb(new zzgnf() { // from class: com.google.android.gms.internal.ads.zzglj
            @Override // com.google.android.gms.internal.ads.zzgnf
            public final zzggc zza(zzgpc zzgpcVar, zzghc zzghcVar) {
                return zzglk.zza((zzgox) zzgpcVar, zzghcVar);
            }
        }, zza2, zzgox.class);
    }

    public static /* synthetic */ zzgla zza(zzgox zzgoxVar, zzghc zzghcVar) {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseKey");
        }
        try {
            zzgvu zze2 = zzgvu.zze(zzgoxVar.zze(), zzgzf.zza());
            if (zzgoxVar.zzc() != zzgvz.RAW) {
                throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with OutputPrefixType RAW, got " + String.valueOf(zze2));
            }
            if (zze2.zza() != 0) {
                throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with version 0, got " + String.valueOf(zze2));
            }
            return zzgla.zza(zzf(zze2.zzf()));
        } catch (zzhag e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKey failed: ", e);
        }
    }

    public static /* synthetic */ zzglf zzb(zzgoy zzgoyVar) {
        if (!zzgoyVar.zzc().zzh().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzh())));
        }
        try {
            return zzf(zzgvx.zzf(zzgoyVar.zzc().zzg(), zzgzf.zza()));
        } catch (zzhag e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzgla zzglaVar, zzghc zzghcVar) {
        zzgvt zzc2 = zzgvu.zzc();
        zzc2.zza(zzg(zzglaVar.zzb()));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", ((zzgvu) zzc2.zzal()).zzau(), zzgus.REMOTE, zzgvz.RAW, null);
    }

    public static /* synthetic */ zzgoy zzd(zzglf zzglfVar) {
        zzgux zza2 = zzguy.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zza2.zzc(zzg(zzglfVar).zzau());
        zza2.zza(zzgvz.RAW);
        return zzgoy.zzb((zzguy) zza2.zzal());
    }

    public static void zze(zzgoe zzgoeVar) throws GeneralSecurityException {
        zzgoeVar.zzj(zzc);
        zzgoeVar.zzi(zzd);
        zzgoeVar.zzh(zze);
        zzgoeVar.zzg(zzf);
    }

    private static zzglf zzf(zzgvx zzgvxVar) throws GeneralSecurityException {
        zzgld zzgldVar;
        zzgux zza2 = zzguy.zza();
        zza2.zzb(zzgvxVar.zza().zzh());
        zza2.zzc(zzgvxVar.zza().zzg());
        zza2.zza(zzgvz.RAW);
        zzggq zza3 = zzghe.zza(((zzguy) zza2.zzal()).zzax());
        if (zza3 instanceof zzgji) {
            zzgldVar = zzgld.zza;
        } else if (zza3 instanceof zzgkg) {
            zzgldVar = zzgld.zzc;
        } else if (zza3 instanceof zzgly) {
            zzgldVar = zzgld.zzb;
        } else if (zza3 instanceof zzghz) {
            zzgldVar = zzgld.zzd;
        } else if (zza3 instanceof zzgiq) {
            zzgldVar = zzgld.zze;
        } else if (zza3 instanceof zzgjv) {
            zzgldVar = zzgld.zzf;
        } else {
            throw new GeneralSecurityException("Unsupported DEK parameters when parsing ".concat(zza3.toString()));
        }
        zzglc zzglcVar = new zzglc(null);
        zzglcVar.zzc(zzgvxVar.zzg());
        zzglcVar.zza((zzghi) zza3);
        zzglcVar.zzb(zzgldVar);
        return zzglcVar.zzd();
    }

    private static zzgvx zzg(zzglf zzglfVar) throws GeneralSecurityException {
        try {
            zzguy zze2 = zzguy.zze(zzghe.zzb(zzglfVar.zzb()), zzgzf.zza());
            zzgvw zzc2 = zzgvx.zzc();
            zzc2.zzb(zzglfVar.zzc());
            zzc2.zza(zze2);
            return (zzgvx) zzc2.zzal();
        } catch (zzhag e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }
}

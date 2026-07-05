package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgmd {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxq zzb;
    private static final zzgom zzc;
    private static final zzgoi zzd;
    private static final zzgnl zze;
    private static final zzgnh zzf;

    static {
        zzgxq zza2 = zzgpm.zza("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzb = zza2;
        zzc = zzgom.zzb(new zzgok() { // from class: com.google.android.gms.internal.ads.zzglz
            @Override // com.google.android.gms.internal.ads.zzgok
            public final zzgpc zza(zzggq zzggqVar) {
                return zzgmd.zzd((zzgji) zzggqVar);
            }
        }, zzgji.class, zzgoy.class);
        zzd = zzgoi.zzb(new zzgog() { // from class: com.google.android.gms.internal.ads.zzgma
            @Override // com.google.android.gms.internal.ads.zzgog
            public final zzggq zza(zzgpc zzgpcVar) {
                return zzgmd.zzb((zzgoy) zzgpcVar);
            }
        }, zza2, zzgoy.class);
        zze = zzgnl.zzb(new zzgnj() { // from class: com.google.android.gms.internal.ads.zzgmb
            @Override // com.google.android.gms.internal.ads.zzgnj
            public final zzgpc zza(zzggc zzggcVar, zzghc zzghcVar) {
                return zzgmd.zzc((zzgiz) zzggcVar, zzghcVar);
            }
        }, zzgiz.class, zzgox.class);
        zzf = zzgnh.zzb(new zzgnf() { // from class: com.google.android.gms.internal.ads.zzgmc
            @Override // com.google.android.gms.internal.ads.zzgnf
            public final zzggc zza(zzgpc zzgpcVar, zzghc zzghcVar) {
                return zzgmd.zza((zzgox) zzgpcVar, zzghcVar);
            }
        }, zza2, zzgox.class);
    }

    public static /* synthetic */ zzgiz zza(zzgox zzgoxVar, zzghc zzghcVar) {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseKey");
        }
        try {
            zzgto zze2 = zzgto.zze(zzgoxVar.zze(), zzgzf.zza());
            if (zze2.zza() == 0) {
                zzgjf zzc2 = zzgji.zzc();
                zzc2.zzb(zze2.zzf().zzd());
                zzc2.zza(12);
                zzc2.zzc(16);
                zzc2.zzd(zzf(zzgoxVar.zzc()));
                zzgji zze3 = zzc2.zze();
                zzgix zza2 = zzgiz.zza();
                zza2.zzc(zze3);
                zza2.zzb(zzgxr.zzb(zze2.zzf().zzA(), zzghcVar));
                zza2.zza(zzgoxVar.zzf());
                return zza2.zzd();
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzhag unused) {
            throw new GeneralSecurityException("Parsing AesGcmKey failed");
        }
    }

    public static /* synthetic */ zzgji zzb(zzgoy zzgoyVar) {
        if (!zzgoyVar.zzc().zzh().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzh())));
        }
        try {
            zzgtr zzf2 = zzgtr.zzf(zzgoyVar.zzc().zzg(), zzgzf.zza());
            if (zzf2.zzc() == 0) {
                zzgjf zzc2 = zzgji.zzc();
                zzc2.zzb(zzf2.zza());
                zzc2.zza(12);
                zzc2.zzc(16);
                zzc2.zzd(zzf(zzgoyVar.zzc().zzf()));
                return zzc2.zze();
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (zzhag e) {
            throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzgiz zzgizVar, zzghc zzghcVar) {
        zzgtn zzc2 = zzgto.zzc();
        byte[] zzd2 = zzgizVar.zzd().zzd(zzghcVar);
        zzc2.zza(zzgyl.zzv(zzd2, 0, zzd2.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.AesGcmKey", ((zzgto) zzc2.zzal()).zzau(), zzgus.SYMMETRIC, zzg(zzgizVar.zzb().zzd()), zzgizVar.zze());
    }

    public static /* synthetic */ zzgoy zzd(zzgji zzgjiVar) {
        zzgux zza2 = zzguy.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzgtq zzd2 = zzgtr.zzd();
        zzd2.zza(zzgjiVar.zzb());
        zza2.zzc(((zzgtr) zzd2.zzal()).zzau());
        zza2.zza(zzg(zzgjiVar.zzd()));
        return zzgoy.zzb((zzguy) zza2.zzal());
    }

    public static void zze(zzgoe zzgoeVar) throws GeneralSecurityException {
        zzgoeVar.zzj(zzc);
        zzgoeVar.zzi(zzd);
        zzgoeVar.zzh(zze);
        zzgoeVar.zzg(zzf);
    }

    private static zzgjg zzf(zzgvz zzgvzVar) throws GeneralSecurityException {
        zzgvz zzgvzVar2 = zzgvz.UNKNOWN_PREFIX;
        int ordinal = zzgvzVar.ordinal();
        if (ordinal == 1) {
            return zzgjg.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzgjg.zzc;
            }
            if (ordinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgvzVar.zza());
            }
        }
        return zzgjg.zzb;
    }

    private static zzgvz zzg(zzgjg zzgjgVar) throws GeneralSecurityException {
        if (zzgjg.zza.equals(zzgjgVar)) {
            return zzgvz.TINK;
        }
        if (zzgjg.zzb.equals(zzgjgVar)) {
            return zzgvz.CRUNCHY;
        }
        if (zzgjg.zzc.equals(zzgjgVar)) {
            return zzgvz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgjgVar))));
    }
}

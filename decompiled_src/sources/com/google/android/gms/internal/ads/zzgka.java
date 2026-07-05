package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgka {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxq zzb;
    private static final zzgom zzc;
    private static final zzgoi zzd;
    private static final zzgnl zze;
    private static final zzgnh zzf;

    static {
        zzgxq zza2 = zzgpm.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzb = zza2;
        zzc = zzgom.zzb(new zzgok() { // from class: com.google.android.gms.internal.ads.zzgjw
            @Override // com.google.android.gms.internal.ads.zzgok
            public final zzgpc zza(zzggq zzggqVar) {
                return zzgka.zzd((zzgjv) zzggqVar);
            }
        }, zzgjv.class, zzgoy.class);
        zzd = zzgoi.zzb(new zzgog() { // from class: com.google.android.gms.internal.ads.zzgjx
            @Override // com.google.android.gms.internal.ads.zzgog
            public final zzggq zza(zzgpc zzgpcVar) {
                return zzgka.zzb((zzgoy) zzgpcVar);
            }
        }, zza2, zzgoy.class);
        zze = zzgnl.zzb(new zzgnj() { // from class: com.google.android.gms.internal.ads.zzgjy
            @Override // com.google.android.gms.internal.ads.zzgnj
            public final zzgpc zza(zzggc zzggcVar, zzghc zzghcVar) {
                return zzgka.zzc((zzgjm) zzggcVar, zzghcVar);
            }
        }, zzgjm.class, zzgox.class);
        zzf = zzgnh.zzb(new zzgnf() { // from class: com.google.android.gms.internal.ads.zzgjz
            @Override // com.google.android.gms.internal.ads.zzgnf
            public final zzggc zza(zzgpc zzgpcVar, zzghc zzghcVar) {
                return zzgka.zza((zzgox) zzgpcVar, zzghcVar);
            }
        }, zza2, zzgox.class);
    }

    public static /* synthetic */ zzgjm zza(zzgox zzgoxVar, zzghc zzghcVar) {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
        }
        try {
            zzgtu zze2 = zzgtu.zze(zzgoxVar.zze(), zzgzf.zza());
            if (zze2.zza() == 0) {
                zzgjs zzgjsVar = new zzgjs(null);
                zzgjsVar.zza(zze2.zzf().zzd());
                zzgjsVar.zzb(zzf(zzgoxVar.zzc()));
                zzgjv zzc2 = zzgjsVar.zzc();
                zzgjk zzgjkVar = new zzgjk(null);
                zzgjkVar.zzc(zzc2);
                zzgjkVar.zzb(zzgxr.zzb(zze2.zzf().zzA(), zzghcVar));
                zzgjkVar.zza(zzgoxVar.zzf());
                return zzgjkVar.zzd();
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzhag unused) {
            throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
        }
    }

    public static /* synthetic */ zzgjv zzb(zzgoy zzgoyVar) {
        if (!zzgoyVar.zzc().zzh().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzh())));
        }
        try {
            zzgtx zzf2 = zzgtx.zzf(zzgoyVar.zzc().zzg(), zzgzf.zza());
            if (zzf2.zzc() == 0) {
                zzgjs zzgjsVar = new zzgjs(null);
                zzgjsVar.zza(zzf2.zza());
                zzgjsVar.zzb(zzf(zzgoyVar.zzc().zzf()));
                return zzgjsVar.zzc();
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (zzhag e) {
            throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzgjm zzgjmVar, zzghc zzghcVar) {
        zzgtt zzc2 = zzgtu.zzc();
        byte[] zzd2 = zzgjmVar.zzc().zzd(zzghcVar);
        zzc2.zza(zzgyl.zzv(zzd2, 0, zzd2.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey", ((zzgtu) zzc2.zzal()).zzau(), zzgus.SYMMETRIC, zzg(zzgjmVar.zza().zzc()), zzgjmVar.zzd());
    }

    public static /* synthetic */ zzgoy zzd(zzgjv zzgjvVar) {
        zzgux zza2 = zzguy.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzgtw zzd2 = zzgtx.zzd();
        zzd2.zza(zzgjvVar.zzb());
        zza2.zzc(((zzgtx) zzd2.zzal()).zzau());
        zza2.zza(zzg(zzgjvVar.zzc()));
        return zzgoy.zzb((zzguy) zza2.zzal());
    }

    public static void zze(zzgoe zzgoeVar) throws GeneralSecurityException {
        zzgoeVar.zzj(zzc);
        zzgoeVar.zzi(zzd);
        zzgoeVar.zzh(zze);
        zzgoeVar.zzg(zzf);
    }

    private static zzgjt zzf(zzgvz zzgvzVar) throws GeneralSecurityException {
        zzgvz zzgvzVar2 = zzgvz.UNKNOWN_PREFIX;
        int ordinal = zzgvzVar.ordinal();
        if (ordinal == 1) {
            return zzgjt.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzgjt.zzc;
            }
            if (ordinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgvzVar.zza());
            }
        }
        return zzgjt.zzb;
    }

    private static zzgvz zzg(zzgjt zzgjtVar) throws GeneralSecurityException {
        if (zzgjt.zza.equals(zzgjtVar)) {
            return zzgvz.TINK;
        }
        if (zzgjt.zzb.equals(zzgjtVar)) {
            return zzgvz.CRUNCHY;
        }
        if (zzgjt.zzc.equals(zzgjtVar)) {
            return zzgvz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgjtVar))));
    }
}

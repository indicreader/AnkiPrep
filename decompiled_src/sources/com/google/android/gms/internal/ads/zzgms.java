package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgms {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxq zzb;
    private static final zzgom zzc;
    private static final zzgoi zzd;
    private static final zzgnl zze;
    private static final zzgnh zzf;

    static {
        zzgxq zza2 = zzgpm.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzb = zza2;
        zzc = zzgom.zzb(new zzgok() { // from class: com.google.android.gms.internal.ads.zzgmo
            @Override // com.google.android.gms.internal.ads.zzgok
            public final zzgpc zza(zzggq zzggqVar) {
                return zzgms.zzd((zzgly) zzggqVar);
            }
        }, zzgly.class, zzgoy.class);
        zzd = zzgoi.zzb(new zzgog() { // from class: com.google.android.gms.internal.ads.zzgmp
            @Override // com.google.android.gms.internal.ads.zzgog
            public final zzggq zza(zzgpc zzgpcVar) {
                return zzgms.zzb((zzgoy) zzgpcVar);
            }
        }, zza2, zzgoy.class);
        zze = zzgnl.zzb(new zzgnj() { // from class: com.google.android.gms.internal.ads.zzgmq
            @Override // com.google.android.gms.internal.ads.zzgnj
            public final zzgpc zza(zzggc zzggcVar, zzghc zzghcVar) {
                return zzgms.zzc((zzgls) zzggcVar, zzghcVar);
            }
        }, zzgls.class, zzgox.class);
        zzf = zzgnh.zzb(new zzgnf() { // from class: com.google.android.gms.internal.ads.zzgmr
            @Override // com.google.android.gms.internal.ads.zzgnf
            public final zzggc zza(zzgpc zzgpcVar, zzghc zzghcVar) {
                return zzgms.zza((zzgox) zzgpcVar, zzghcVar);
            }
        }, zza2, zzgox.class);
    }

    public static /* synthetic */ zzgls zza(zzgox zzgoxVar, zzghc zzghcVar) {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            zzgwf zze2 = zzgwf.zze(zzgoxVar.zze(), zzgzf.zza());
            if (zze2.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return zzgls.zza(zzf(zzgoxVar.zzc()), zzgxr.zzb(zze2.zzf().zzA(), zzghcVar), zzgoxVar.zzf());
        } catch (zzhag unused) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
        }
    }

    public static /* synthetic */ zzgly zzb(zzgoy zzgoyVar) {
        if (!zzgoyVar.zzc().zzh().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzh())));
        }
        try {
            if (zzgwi.zze(zzgoyVar.zzc().zzg(), zzgzf.zza()).zza() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            return zzgly.zzc(zzf(zzgoyVar.zzc().zzf()));
        } catch (zzhag e) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzgls zzglsVar, zzghc zzghcVar) {
        zzgwe zzc2 = zzgwf.zzc();
        byte[] zzd2 = zzglsVar.zzd().zzd(zzghcVar);
        zzc2.zza(zzgyl.zzv(zzd2, 0, zzd2.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", ((zzgwf) zzc2.zzal()).zzau(), zzgus.SYMMETRIC, zzg(zzglsVar.zzb().zzb()), zzglsVar.zze());
    }

    public static /* synthetic */ zzgoy zzd(zzgly zzglyVar) {
        zzgux zza2 = zzguy.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zza2.zzc(zzgwi.zzd().zzau());
        zza2.zza(zzg(zzglyVar.zzb()));
        return zzgoy.zzb((zzguy) zza2.zzal());
    }

    public static void zze(zzgoe zzgoeVar) throws GeneralSecurityException {
        zzgoeVar.zzj(zzc);
        zzgoeVar.zzi(zzd);
        zzgoeVar.zzh(zze);
        zzgoeVar.zzg(zzf);
    }

    private static zzglx zzf(zzgvz zzgvzVar) throws GeneralSecurityException {
        zzgvz zzgvzVar2 = zzgvz.UNKNOWN_PREFIX;
        int ordinal = zzgvzVar.ordinal();
        if (ordinal == 1) {
            return zzglx.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzglx.zzc;
            }
            if (ordinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgvzVar.zza());
            }
        }
        return zzglx.zzb;
    }

    private static zzgvz zzg(zzglx zzglxVar) throws GeneralSecurityException {
        if (zzglx.zza.equals(zzglxVar)) {
            return zzgvz.TINK;
        }
        if (zzglx.zzb.equals(zzglxVar)) {
            return zzgvz.CRUNCHY;
        }
        if (zzglx.zzc.equals(zzglxVar)) {
            return zzgvz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzglxVar.toString()));
    }
}

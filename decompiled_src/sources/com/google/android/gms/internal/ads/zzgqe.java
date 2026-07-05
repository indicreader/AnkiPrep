package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzgqe {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxq zzb;
    private static final zzgom zzc;
    private static final zzgoi zzd;
    private static final zzgnl zze;
    private static final zzgnh zzf;

    static {
        zzgxq zza2 = zzgpm.zza("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzb = zza2;
        zzc = zzgom.zzb(new zzgok() { // from class: com.google.android.gms.internal.ads.zzgqa
            @Override // com.google.android.gms.internal.ads.zzgok
            public final zzgpc zza(zzggq zzggqVar) {
                return zzgqe.zzb((zzgpz) zzggqVar);
            }
        }, zzgpz.class, zzgoy.class);
        zzd = zzgoi.zzb(new zzgog() { // from class: com.google.android.gms.internal.ads.zzgqb
            @Override // com.google.android.gms.internal.ads.zzgog
            public final zzggq zza(zzgpc zzgpcVar) {
                return zzgqe.zzd((zzgoy) zzgpcVar);
            }
        }, zza2, zzgoy.class);
        zze = zzgnl.zzb(new zzgnj() { // from class: com.google.android.gms.internal.ads.zzgqc
            @Override // com.google.android.gms.internal.ads.zzgnj
            public final zzgpc zza(zzggc zzggcVar, zzghc zzghcVar) {
                return zzgqe.zza((zzgpq) zzggcVar, zzghcVar);
            }
        }, zzgpq.class, zzgox.class);
        zzf = zzgnh.zzb(new zzgnf() { // from class: com.google.android.gms.internal.ads.zzgqd
            @Override // com.google.android.gms.internal.ads.zzgnf
            public final zzggc zza(zzgpc zzgpcVar, zzghc zzghcVar) {
                return zzgqe.zzc((zzgox) zzgpcVar, zzghcVar);
            }
        }, zza2, zzgox.class);
    }

    public static /* synthetic */ zzgox zza(zzgpq zzgpqVar, zzghc zzghcVar) {
        zzgsg zzc2 = zzgsh.zzc();
        zzc2.zzb(zzg(zzgpqVar.zza()));
        byte[] zzd2 = zzgpqVar.zzd().zzd(zzghcVar);
        zzc2.zza(zzgyl.zzv(zzd2, 0, zzd2.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.AesCmacKey", ((zzgsh) zzc2.zzal()).zzau(), zzgus.SYMMETRIC, zzh(zzgpqVar.zza().zze()), zzgpqVar.zze());
    }

    public static /* synthetic */ zzgoy zzb(zzgpz zzgpzVar) {
        zzgux zza2 = zzguy.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzgsj zzc2 = zzgsk.zzc();
        zzc2.zzb(zzg(zzgpzVar));
        zzc2.zza(zzgpzVar.zzc());
        zza2.zzc(((zzgsk) zzc2.zzal()).zzau());
        zza2.zza(zzh(zzgpzVar.zze()));
        return zzgoy.zzb((zzguy) zza2.zzal());
    }

    public static /* synthetic */ zzgpq zzc(zzgox zzgoxVar, zzghc zzghcVar) {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseKey");
        }
        try {
            zzgsh zze2 = zzgsh.zze(zzgoxVar.zze(), zzgzf.zza());
            if (zze2.zza() == 0) {
                zzgpw zzgpwVar = new zzgpw(null);
                zzgpwVar.zza(zze2.zzg().zzd());
                zzgpwVar.zzb(zze2.zzf().zza());
                zzgpwVar.zzc(zzf(zzgoxVar.zzc()));
                zzgpz zzd2 = zzgpwVar.zzd();
                zzgpo zzgpoVar = new zzgpo(null);
                zzgpoVar.zzc(zzd2);
                zzgpoVar.zza(zzgxr.zzb(zze2.zzg().zzA(), zzghcVar));
                zzgpoVar.zzb(zzgoxVar.zzf());
                return zzgpoVar.zzd();
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzhag | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing AesCmacKey failed");
        }
    }

    public static /* synthetic */ zzgpz zzd(zzgoy zzgoyVar) {
        if (!zzgoyVar.zzc().zzh().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzh())));
        }
        try {
            zzgsk zze2 = zzgsk.zze(zzgoyVar.zzc().zzg(), zzgzf.zza());
            zzgpw zzgpwVar = new zzgpw(null);
            zzgpwVar.zza(zze2.zza());
            zzgpwVar.zzb(zze2.zzf().zza());
            zzgpwVar.zzc(zzf(zzgoyVar.zzc().zzf()));
            return zzgpwVar.zzd();
        } catch (zzhag e) {
            throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e);
        }
    }

    public static void zze(zzgoe zzgoeVar) throws GeneralSecurityException {
        zzgoeVar.zzj(zzc);
        zzgoeVar.zzi(zzd);
        zzgoeVar.zzh(zze);
        zzgoeVar.zzg(zzf);
    }

    private static zzgpx zzf(zzgvz zzgvzVar) throws GeneralSecurityException {
        zzgvz zzgvzVar2 = zzgvz.UNKNOWN_PREFIX;
        int ordinal = zzgvzVar.ordinal();
        if (ordinal == 1) {
            return zzgpx.zza;
        }
        if (ordinal == 2) {
            return zzgpx.zzc;
        }
        if (ordinal == 3) {
            return zzgpx.zzd;
        }
        if (ordinal == 4) {
            return zzgpx.zzb;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgvzVar.zza());
    }

    private static zzgsn zzg(zzgpz zzgpzVar) {
        zzgsm zzc2 = zzgsn.zzc();
        zzc2.zza(zzgpzVar.zzb());
        return (zzgsn) zzc2.zzal();
    }

    private static zzgvz zzh(zzgpx zzgpxVar) throws GeneralSecurityException {
        if (zzgpx.zza.equals(zzgpxVar)) {
            return zzgvz.TINK;
        }
        if (zzgpx.zzb.equals(zzgpxVar)) {
            return zzgvz.CRUNCHY;
        }
        if (zzgpx.zzd.equals(zzgpxVar)) {
            return zzgvz.RAW;
        }
        if (zzgpx.zzc.equals(zzgpxVar)) {
            return zzgvz.LEGACY;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgpxVar))));
    }
}

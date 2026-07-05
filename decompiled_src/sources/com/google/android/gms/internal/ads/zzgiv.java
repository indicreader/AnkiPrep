package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgiv {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxq zzb;
    private static final zzgom zzc;
    private static final zzgoi zzd;
    private static final zzgnl zze;
    private static final zzgnh zzf;

    static {
        zzgxq zza2 = zzgpm.zza("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = zza2;
        zzc = zzgom.zzb(new zzgok() { // from class: com.google.android.gms.internal.ads.zzgir
            @Override // com.google.android.gms.internal.ads.zzgok
            public final zzgpc zza(zzggq zzggqVar) {
                return zzgiv.zzd((zzgiq) zzggqVar);
            }
        }, zzgiq.class, zzgoy.class);
        zzd = zzgoi.zzb(new zzgog() { // from class: com.google.android.gms.internal.ads.zzgis
            @Override // com.google.android.gms.internal.ads.zzgog
            public final zzggq zza(zzgpc zzgpcVar) {
                return zzgiv.zzb((zzgoy) zzgpcVar);
            }
        }, zza2, zzgoy.class);
        zze = zzgnl.zzb(new zzgnj() { // from class: com.google.android.gms.internal.ads.zzgit
            @Override // com.google.android.gms.internal.ads.zzgnj
            public final zzgpc zza(zzggc zzggcVar, zzghc zzghcVar) {
                return zzgiv.zzc((zzgii) zzggcVar, zzghcVar);
            }
        }, zzgii.class, zzgox.class);
        zzf = zzgnh.zzb(new zzgnf() { // from class: com.google.android.gms.internal.ads.zzgiu
            @Override // com.google.android.gms.internal.ads.zzgnf
            public final zzggc zza(zzgpc zzgpcVar, zzghc zzghcVar) {
                return zzgiv.zza((zzgox) zzgpcVar, zzghcVar);
            }
        }, zza2, zzgox.class);
    }

    public static /* synthetic */ zzgii zza(zzgox zzgoxVar, zzghc zzghcVar) {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
        }
        try {
            zzgtf zze2 = zzgtf.zze(zzgoxVar.zze(), zzgzf.zza());
            if (zze2.zza() == 0) {
                zzgin zzginVar = new zzgin(null);
                zzginVar.zzb(zze2.zzg().zzd());
                zzginVar.zza(zze2.zzf().zza());
                zzginVar.zzc(16);
                zzginVar.zzd(zzf(zzgoxVar.zzc()));
                zzgiq zze3 = zzginVar.zze();
                zzgig zzgigVar = new zzgig(null);
                zzgigVar.zzc(zze3);
                zzgigVar.zzb(zzgxr.zzb(zze2.zzg().zzA(), zzghcVar));
                zzgigVar.zza(zzgoxVar.zzf());
                return zzgigVar.zzd();
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzhag unused) {
            throw new GeneralSecurityException("Parsing AesEaxcKey failed");
        }
    }

    public static /* synthetic */ zzgiq zzb(zzgoy zzgoyVar) {
        if (!zzgoyVar.zzc().zzh().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzh())));
        }
        try {
            zzgti zze2 = zzgti.zze(zzgoyVar.zzc().zzg(), zzgzf.zza());
            zzgin zzginVar = new zzgin(null);
            zzginVar.zzb(zze2.zza());
            zzginVar.zza(zze2.zzf().zza());
            zzginVar.zzc(16);
            zzginVar.zzd(zzf(zzgoyVar.zzc().zzf()));
            return zzginVar.zze();
        } catch (zzhag e) {
            throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzgii zzgiiVar, zzghc zzghcVar) {
        zzgte zzc2 = zzgtf.zzc();
        zzc2.zzb(zzg(zzgiiVar.zza()));
        byte[] zzd2 = zzgiiVar.zzc().zzd(zzghcVar);
        zzc2.zza(zzgyl.zzv(zzd2, 0, zzd2.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", ((zzgtf) zzc2.zzal()).zzau(), zzgus.SYMMETRIC, zzh(zzgiiVar.zza().zzd()), zzgiiVar.zzd());
    }

    public static /* synthetic */ zzgoy zzd(zzgiq zzgiqVar) {
        zzgux zza2 = zzguy.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzgth zzc2 = zzgti.zzc();
        zzc2.zzb(zzg(zzgiqVar));
        zzc2.zza(zzgiqVar.zzc());
        zza2.zzc(((zzgti) zzc2.zzal()).zzau());
        zza2.zza(zzh(zzgiqVar.zzd()));
        return zzgoy.zzb((zzguy) zza2.zzal());
    }

    public static void zze(zzgoe zzgoeVar) throws GeneralSecurityException {
        zzgoeVar.zzj(zzc);
        zzgoeVar.zzi(zzd);
        zzgoeVar.zzh(zze);
        zzgoeVar.zzg(zzf);
    }

    private static zzgio zzf(zzgvz zzgvzVar) throws GeneralSecurityException {
        zzgvz zzgvzVar2 = zzgvz.UNKNOWN_PREFIX;
        int ordinal = zzgvzVar.ordinal();
        if (ordinal == 1) {
            return zzgio.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzgio.zzc;
            }
            if (ordinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgvzVar.zza());
            }
        }
        return zzgio.zzb;
    }

    private static zzgtl zzg(zzgiq zzgiqVar) throws GeneralSecurityException {
        zzgtk zzc2 = zzgtl.zzc();
        zzc2.zza(zzgiqVar.zzb());
        return (zzgtl) zzc2.zzal();
    }

    private static zzgvz zzh(zzgio zzgioVar) throws GeneralSecurityException {
        if (zzgio.zza.equals(zzgioVar)) {
            return zzgvz.TINK;
        }
        if (zzgio.zzb.equals(zzgioVar)) {
            return zzgvz.CRUNCHY;
        }
        if (zzgio.zzc.equals(zzgioVar)) {
            return zzgvz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgioVar))));
    }
}

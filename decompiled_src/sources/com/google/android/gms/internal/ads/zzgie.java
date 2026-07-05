package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgie {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxq zzb;
    private static final zzgom zzc;
    private static final zzgoi zzd;
    private static final zzgnl zze;
    private static final zzgnh zzf;

    static {
        zzgxq zza2 = zzgpm.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzb = zza2;
        zzc = zzgom.zzb(new zzgok() { // from class: com.google.android.gms.internal.ads.zzgia
            @Override // com.google.android.gms.internal.ads.zzgok
            public final zzgpc zza(zzggq zzggqVar) {
                return zzgie.zzd((zzghz) zzggqVar);
            }
        }, zzghz.class, zzgoy.class);
        zzd = zzgoi.zzb(new zzgog() { // from class: com.google.android.gms.internal.ads.zzgib
            @Override // com.google.android.gms.internal.ads.zzgog
            public final zzggq zza(zzgpc zzgpcVar) {
                return zzgie.zzb((zzgoy) zzgpcVar);
            }
        }, zza2, zzgoy.class);
        zze = zzgnl.zzb(new zzgnj() { // from class: com.google.android.gms.internal.ads.zzgic
            @Override // com.google.android.gms.internal.ads.zzgnj
            public final zzgpc zza(zzggc zzggcVar, zzghc zzghcVar) {
                return zzgie.zzc((zzghp) zzggcVar, zzghcVar);
            }
        }, zzghp.class, zzgox.class);
        zzf = zzgnh.zzb(new zzgnf() { // from class: com.google.android.gms.internal.ads.zzgid
            @Override // com.google.android.gms.internal.ads.zzgnf
            public final zzggc zza(zzgpc zzgpcVar, zzghc zzghcVar) {
                return zzgie.zza((zzgox) zzgpcVar, zzghcVar);
            }
        }, zza2, zzgox.class);
    }

    public static /* synthetic */ zzghp zza(zzgox zzgoxVar, zzghc zzghcVar) {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
        }
        try {
            zzgsq zze2 = zzgsq.zze(zzgoxVar.zze(), zzgzf.zza());
            if (zze2.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            if (zze2.zzf().zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
            }
            if (zze2.zzg().zza() == 0) {
                zzghv zzghvVar = new zzghv(null);
                zzghvVar.zza(zze2.zzf().zzg().zzd());
                zzghvVar.zzc(zze2.zzg().zzh().zzd());
                zzghvVar.zzd(zze2.zzf().zzf().zza());
                zzghvVar.zze(zze2.zzg().zzg().zza());
                zzghvVar.zzb(zzf(zze2.zzg().zzg().zzc()));
                zzghvVar.zzf(zzg(zzgoxVar.zzc()));
                zzghz zzg = zzghvVar.zzg();
                zzghn zzghnVar = new zzghn(null);
                zzghnVar.zzd(zzg);
                zzghnVar.zza(zzgxr.zzb(zze2.zzf().zzg().zzA(), zzghcVar));
                zzghnVar.zzb(zzgxr.zzb(zze2.zzg().zzh().zzA(), zzghcVar));
                zzghnVar.zzc(zzgoxVar.zzf());
                return zzghnVar.zze();
            }
            throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
        } catch (zzhag unused) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
        }
    }

    public static /* synthetic */ zzghz zzb(zzgoy zzgoyVar) {
        if (!zzgoyVar.zzc().zzh().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzh())));
        }
        try {
            zzgst zzd2 = zzgst.zzd(zzgoyVar.zzc().zzg(), zzgzf.zza());
            if (zzd2.zzf().zzc() == 0) {
                zzghv zzghvVar = new zzghv(null);
                zzghvVar.zza(zzd2.zze().zza());
                zzghvVar.zzc(zzd2.zzf().zza());
                zzghvVar.zzd(zzd2.zze().zzf().zza());
                zzghvVar.zze(zzd2.zzf().zzh().zza());
                zzghvVar.zzb(zzf(zzd2.zzf().zzh().zzc()));
                zzghvVar.zzf(zzg(zzgoyVar.zzc().zzf()));
                return zzghvVar.zzg();
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzhag e) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzghp zzghpVar, zzghc zzghcVar) {
        zzgsp zzc2 = zzgsq.zzc();
        zzgsv zzc3 = zzgsw.zzc();
        zzgtb zzc4 = zzgtc.zzc();
        zzc4.zza(zzghpVar.zza().zzd());
        zzc3.zzb((zzgtc) zzc4.zzal());
        byte[] zzd2 = zzghpVar.zzc().zzd(zzghcVar);
        zzc3.zza(zzgyl.zzv(zzd2, 0, zzd2.length));
        zzc2.zza((zzgsw) zzc3.zzal());
        zzguh zzc5 = zzgui.zzc();
        zzc5.zzb(zzh(zzghpVar.zza()));
        byte[] zzd3 = zzghpVar.zzd().zzd(zzghcVar);
        zzc5.zza(zzgyl.zzv(zzd3, 0, zzd3.length));
        zzc2.zzb((zzgui) zzc5.zzal());
        return zzgox.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", ((zzgsq) zzc2.zzal()).zzau(), zzgus.SYMMETRIC, zzi(zzghpVar.zza().zzg()), zzghpVar.zze());
    }

    public static /* synthetic */ zzgoy zzd(zzghz zzghzVar) {
        zzgux zza2 = zzguy.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzgss zza3 = zzgst.zza();
        zzgsy zzc2 = zzgsz.zzc();
        zzgtb zzc3 = zzgtc.zzc();
        zzc3.zza(zzghzVar.zzd());
        zzc2.zzb((zzgtc) zzc3.zzal());
        zzc2.zza(zzghzVar.zzb());
        zza3.zza((zzgsz) zzc2.zzal());
        zzguk zzd2 = zzgul.zzd();
        zzd2.zzb(zzh(zzghzVar));
        zzd2.zza(zzghzVar.zzc());
        zza3.zzb((zzgul) zzd2.zzal());
        zza2.zzc(((zzgst) zza3.zzal()).zzau());
        zza2.zza(zzi(zzghzVar.zzg()));
        return zzgoy.zzb((zzguy) zza2.zzal());
    }

    public static void zze(zzgoe zzgoeVar) throws GeneralSecurityException {
        zzgoeVar.zzj(zzc);
        zzgoeVar.zzi(zzd);
        zzgoeVar.zzh(zze);
        zzgoeVar.zzg(zzf);
    }

    private static zzghw zzf(zzguf zzgufVar) throws GeneralSecurityException {
        zzguf zzgufVar2 = zzguf.UNKNOWN_HASH;
        zzgvz zzgvzVar = zzgvz.UNKNOWN_PREFIX;
        int ordinal = zzgufVar.ordinal();
        if (ordinal == 1) {
            return zzghw.zza;
        }
        if (ordinal == 2) {
            return zzghw.zzd;
        }
        if (ordinal == 3) {
            return zzghw.zzc;
        }
        if (ordinal == 4) {
            return zzghw.zze;
        }
        if (ordinal == 5) {
            return zzghw.zzb;
        }
        throw new GeneralSecurityException("Unable to parse HashType: " + zzgufVar.zza());
    }

    private static zzghx zzg(zzgvz zzgvzVar) throws GeneralSecurityException {
        zzguf zzgufVar = zzguf.UNKNOWN_HASH;
        zzgvz zzgvzVar2 = zzgvz.UNKNOWN_PREFIX;
        int ordinal = zzgvzVar.ordinal();
        if (ordinal == 1) {
            return zzghx.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzghx.zzc;
            }
            if (ordinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgvzVar.zza());
            }
        }
        return zzghx.zzb;
    }

    private static zzguo zzh(zzghz zzghzVar) throws GeneralSecurityException {
        zzguf zzgufVar;
        zzgun zzd2 = zzguo.zzd();
        zzd2.zzb(zzghzVar.zze());
        zzghw zzf2 = zzghzVar.zzf();
        if (zzghw.zza.equals(zzf2)) {
            zzgufVar = zzguf.SHA1;
        } else if (zzghw.zzb.equals(zzf2)) {
            zzgufVar = zzguf.SHA224;
        } else if (zzghw.zzc.equals(zzf2)) {
            zzgufVar = zzguf.SHA256;
        } else if (zzghw.zzd.equals(zzf2)) {
            zzgufVar = zzguf.SHA384;
        } else if (zzghw.zze.equals(zzf2)) {
            zzgufVar = zzguf.SHA512;
        } else {
            throw new GeneralSecurityException("Unable to serialize HashType ".concat(String.valueOf(String.valueOf(zzf2))));
        }
        zzd2.zza(zzgufVar);
        return (zzguo) zzd2.zzal();
    }

    private static zzgvz zzi(zzghx zzghxVar) throws GeneralSecurityException {
        if (zzghx.zza.equals(zzghxVar)) {
            return zzgvz.TINK;
        }
        if (zzghx.zzb.equals(zzghxVar)) {
            return zzgvz.CRUNCHY;
        }
        if (zzghx.zzc.equals(zzghxVar)) {
            return zzgvz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzghxVar))));
    }
}

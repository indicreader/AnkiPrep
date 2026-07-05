package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgkl {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxq zzb;
    private static final zzgom zzc;
    private static final zzgoi zzd;
    private static final zzgnl zze;
    private static final zzgnh zzf;

    static {
        zzgxq zza2 = zzgpm.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzb = zza2;
        zzc = zzgom.zzb(new zzgok() { // from class: com.google.android.gms.internal.ads.zzgkh
            @Override // com.google.android.gms.internal.ads.zzgok
            public final zzgpc zza(zzggq zzggqVar) {
                return zzgkl.zzd((zzgkg) zzggqVar);
            }
        }, zzgkg.class, zzgoy.class);
        zzd = zzgoi.zzb(new zzgog() { // from class: com.google.android.gms.internal.ads.zzgki
            @Override // com.google.android.gms.internal.ads.zzgog
            public final zzggq zza(zzgpc zzgpcVar) {
                return zzgkl.zzb((zzgoy) zzgpcVar);
            }
        }, zza2, zzgoy.class);
        zze = zzgnl.zzb(new zzgnj() { // from class: com.google.android.gms.internal.ads.zzgkj
            @Override // com.google.android.gms.internal.ads.zzgnj
            public final zzgpc zza(zzggc zzggcVar, zzghc zzghcVar) {
                return zzgkl.zzc((zzgkb) zzggcVar, zzghcVar);
            }
        }, zzgkb.class, zzgox.class);
        zzf = zzgnh.zzb(new zzgnf() { // from class: com.google.android.gms.internal.ads.zzgkk
            @Override // com.google.android.gms.internal.ads.zzgnf
            public final zzggc zza(zzgpc zzgpcVar, zzghc zzghcVar) {
                return zzgkl.zza((zzgox) zzgpcVar, zzghcVar);
            }
        }, zza2, zzgox.class);
    }

    public static /* synthetic */ zzgkb zza(zzgox zzgoxVar, zzghc zzghcVar) {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            zzgua zze2 = zzgua.zze(zzgoxVar.zze(), zzgzf.zza());
            if (zze2.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return zzgkb.zza(zzf(zzgoxVar.zzc()), zzgxr.zzb(zze2.zzf().zzA(), zzghcVar), zzgoxVar.zzf());
        } catch (zzhag unused) {
            throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
        }
    }

    public static /* synthetic */ zzgkg zzb(zzgoy zzgoyVar) {
        if (!zzgoyVar.zzc().zzh().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzh())));
        }
        try {
            zzgud.zzd(zzgoyVar.zzc().zzg(), zzgzf.zza());
            return zzgkg.zzc(zzf(zzgoyVar.zzc().zzf()));
        } catch (zzhag e) {
            throw new GeneralSecurityException("Parsing ChaCha20Poly1305Parameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzgkb zzgkbVar, zzghc zzghcVar) {
        zzgtz zzc2 = zzgua.zzc();
        byte[] zzd2 = zzgkbVar.zzd().zzd(zzghcVar);
        zzc2.zza(zzgyl.zzv(zzd2, 0, zzd2.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", ((zzgua) zzc2.zzal()).zzau(), zzgus.SYMMETRIC, zzg(zzgkbVar.zzb().zzb()), zzgkbVar.zze());
    }

    public static /* synthetic */ zzgoy zzd(zzgkg zzgkgVar) {
        zzgux zza2 = zzguy.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zza2.zzc(zzgud.zzc().zzau());
        zza2.zza(zzg(zzgkgVar.zzb()));
        return zzgoy.zzb((zzguy) zza2.zzal());
    }

    public static void zze(zzgoe zzgoeVar) throws GeneralSecurityException {
        zzgoeVar.zzj(zzc);
        zzgoeVar.zzi(zzd);
        zzgoeVar.zzh(zze);
        zzgoeVar.zzg(zzf);
    }

    private static zzgkf zzf(zzgvz zzgvzVar) throws GeneralSecurityException {
        zzgvz zzgvzVar2 = zzgvz.UNKNOWN_PREFIX;
        int ordinal = zzgvzVar.ordinal();
        if (ordinal == 1) {
            return zzgkf.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzgkf.zzc;
            }
            if (ordinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgvzVar.zza());
            }
        }
        return zzgkf.zzb;
    }

    private static zzgvz zzg(zzgkf zzgkfVar) throws GeneralSecurityException {
        if (zzgkf.zza.equals(zzgkfVar)) {
            return zzgvz.TINK;
        }
        if (zzgkf.zzb.equals(zzgkfVar)) {
            return zzgvz.CRUNCHY;
        }
        if (zzgkf.zzc.equals(zzgkfVar)) {
            return zzgvz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzgkfVar.toString()));
    }
}

package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgrs {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxq zzb;
    private static final zzgna zzc;
    private static final zzgna zzd;
    private static final zzgom zze;
    private static final zzgoi zzf;
    private static final zzgnl zzg;
    private static final zzgnh zzh;

    static {
        zzgxq zza2 = zzgpm.zza("type.googleapis.com/google.crypto.tink.HmacKey");
        zzb = zza2;
        zzgmy zza3 = zzgna.zza();
        zza3.zza(zzgvz.RAW, zzgqv.zzd);
        zza3.zza(zzgvz.TINK, zzgqv.zza);
        zza3.zza(zzgvz.LEGACY, zzgqv.zzc);
        zza3.zza(zzgvz.CRUNCHY, zzgqv.zzb);
        zzc = zza3.zzb();
        zzgmy zza4 = zzgna.zza();
        zza4.zza(zzguf.SHA1, zzgqu.zza);
        zza4.zza(zzguf.SHA224, zzgqu.zzb);
        zza4.zza(zzguf.SHA256, zzgqu.zzc);
        zza4.zza(zzguf.SHA384, zzgqu.zzd);
        zza4.zza(zzguf.SHA512, zzgqu.zze);
        zzd = zza4.zzb();
        zze = zzgom.zzb(new zzgok() { // from class: com.google.android.gms.internal.ads.zzgro
            @Override // com.google.android.gms.internal.ads.zzgok
            public final zzgpc zza(zzggq zzggqVar) {
                return zzgrs.zzb((zzgqx) zzggqVar);
            }
        }, zzgqx.class, zzgoy.class);
        zzf = zzgoi.zzb(new zzgog() { // from class: com.google.android.gms.internal.ads.zzgrp
            @Override // com.google.android.gms.internal.ads.zzgog
            public final zzggq zza(zzgpc zzgpcVar) {
                return zzgrs.zzd((zzgoy) zzgpcVar);
            }
        }, zza2, zzgoy.class);
        zzg = zzgnl.zzb(new zzgnj() { // from class: com.google.android.gms.internal.ads.zzgrq
            @Override // com.google.android.gms.internal.ads.zzgnj
            public final zzgpc zza(zzggc zzggcVar, zzghc zzghcVar) {
                return zzgrs.zza((zzgqm) zzggcVar, zzghcVar);
            }
        }, zzgqm.class, zzgox.class);
        zzh = zzgnh.zzb(new zzgnf() { // from class: com.google.android.gms.internal.ads.zzgrr
            @Override // com.google.android.gms.internal.ads.zzgnf
            public final zzggc zza(zzgpc zzgpcVar, zzghc zzghcVar) {
                return zzgrs.zzc((zzgox) zzgpcVar, zzghcVar);
            }
        }, zza2, zzgox.class);
    }

    public static /* synthetic */ zzgox zza(zzgqm zzgqmVar, zzghc zzghcVar) {
        zzguh zzc2 = zzgui.zzc();
        zzc2.zzb(zzf(zzgqmVar.zzd()));
        byte[] zzd2 = zzgqmVar.zze().zzd(zzghcVar);
        zzc2.zza(zzgyl.zzv(zzd2, 0, zzd2.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.HmacKey", ((zzgui) zzc2.zzal()).zzau(), zzgus.SYMMETRIC, (zzgvz) zzc.zzb(zzgqmVar.zzd().zzg()), zzgqmVar.zzf());
    }

    public static /* synthetic */ zzgoy zzb(zzgqx zzgqxVar) {
        zzgux zza2 = zzguy.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzguk zzd2 = zzgul.zzd();
        zzd2.zzb(zzf(zzgqxVar));
        zzd2.zza(zzgqxVar.zzc());
        zza2.zzc(((zzgul) zzd2.zzal()).zzau());
        zza2.zza((zzgvz) zzc.zzb(zzgqxVar.zzg()));
        return zzgoy.zzb((zzguy) zza2.zzal());
    }

    public static /* synthetic */ zzgqm zzc(zzgox zzgoxVar, zzghc zzghcVar) {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
        try {
            zzgui zzf2 = zzgui.zzf(zzgoxVar.zze(), zzgzf.zza());
            if (zzf2.zza() == 0) {
                zzgqt zze2 = zzgqx.zze();
                zze2.zzb(zzf2.zzh().zzd());
                zze2.zzc(zzf2.zzg().zza());
                zze2.zza((zzgqu) zzd.zzc(zzf2.zzg().zzc()));
                zze2.zzd((zzgqv) zzc.zzc(zzgoxVar.zzc()));
                zzgqx zze3 = zze2.zze();
                zzgqk zza2 = zzgqm.zza();
                zza2.zzc(zze3);
                zza2.zzb(zzgxr.zzb(zzf2.zzh().zzA(), zzghcVar));
                zza2.zza(zzgoxVar.zzf());
                return zza2.zzd();
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzhag | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing HmacKey failed");
        }
    }

    public static /* synthetic */ zzgqx zzd(zzgoy zzgoyVar) {
        if (!zzgoyVar.zzc().zzh().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzh())));
        }
        try {
            zzgul zzg2 = zzgul.zzg(zzgoyVar.zzc().zzg(), zzgzf.zza());
            if (zzg2.zzc() == 0) {
                zzgqt zze2 = zzgqx.zze();
                zze2.zzb(zzg2.zza());
                zze2.zzc(zzg2.zzh().zza());
                zze2.zza((zzgqu) zzd.zzc(zzg2.zzh().zzc()));
                zze2.zzd((zzgqv) zzc.zzc(zzgoyVar.zzc().zzf()));
                return zze2.zze();
            }
            throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + zzg2.zzc());
        } catch (zzhag e) {
            throw new GeneralSecurityException("Parsing HmacParameters failed: ", e);
        }
    }

    public static void zze(zzgoe zzgoeVar) throws GeneralSecurityException {
        zzgoeVar.zzj(zze);
        zzgoeVar.zzi(zzf);
        zzgoeVar.zzh(zzg);
        zzgoeVar.zzg(zzh);
    }

    private static zzguo zzf(zzgqx zzgqxVar) throws GeneralSecurityException {
        zzgun zzd2 = zzguo.zzd();
        zzd2.zzb(zzgqxVar.zzb());
        zzd2.zza((zzguf) zzd.zzb(zzgqxVar.zzf()));
        return (zzguo) zzd2.zzal();
    }
}

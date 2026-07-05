package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzggm {
    private final zzgvg zza;
    private final List zzb;
    private final zzgrw zzc;

    private zzggm(zzgvg zzgvgVar, List list) {
        this.zza = zzgvgVar;
        this.zzb = list;
        this.zzc = zzgrw.zza;
    }

    private zzggm(zzgvg zzgvgVar, List list, zzgrw zzgrwVar) {
        this.zza = zzgvgVar;
        this.zzb = list;
        this.zzc = zzgrwVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final zzggm zza(zzgvg zzgvgVar) throws GeneralSecurityException {
        zzi(zzgvgVar);
        return new zzggm(zzgvgVar, zzh(zzgvgVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final zzggm zzb(zzgvg zzgvgVar, zzgrw zzgrwVar) throws GeneralSecurityException {
        zzi(zzgvgVar);
        return new zzggm(zzgvgVar, zzh(zzgvgVar), zzgrwVar);
    }

    public static final zzggm zzc(zzggq zzggqVar) throws GeneralSecurityException {
        zzggj zzggjVar = new zzggj();
        zzggh zzgghVar = new zzggh(zzggqVar, null);
        zzgghVar.zze();
        zzgghVar.zzd();
        zzggjVar.zza(zzgghVar);
        return zzggjVar.zzb();
    }

    private static zzgox zzf(zzgvf zzgvfVar) {
        try {
            return zzgox.zza(zzgvfVar.zzc().zzg(), zzgvfVar.zzc().zzf(), zzgvfVar.zzc().zzc(), zzgvfVar.zzf(), zzgvfVar.zzf() == zzgvz.RAW ? null : Integer.valueOf(zzgvfVar.zza()));
        } catch (GeneralSecurityException e) {
            throw new zzgpl("Creating a protokey serialization failed", e);
        }
    }

    @Nullable
    private static Object zzg(zzgnb zzgnbVar, zzgvf zzgvfVar, Class cls) throws GeneralSecurityException {
        try {
            return zzghb.zzc(zzgvfVar.zzc(), cls);
        } catch (UnsupportedOperationException unused) {
            return null;
        } catch (GeneralSecurityException e) {
            if (e.getMessage().contains("No key manager found for key type ") || e.getMessage().contains(" not supported by key manager of type ")) {
                return null;
            }
            throw e;
        }
    }

    private static List zzh(zzgvg zzgvgVar) {
        zzgge zzggeVar;
        ArrayList arrayList = new ArrayList(zzgvgVar.zza());
        for (zzgvf zzgvfVar : zzgvgVar.zzh()) {
            int zza = zzgvfVar.zza();
            try {
                zzggc zzb = zzgoe.zzd().zzb(zzf(zzgvfVar), zzghc.zza());
                int zzk = zzgvfVar.zzk() - 2;
                if (zzk != 1) {
                    if (zzk != 2) {
                        if (zzk == 3) {
                            zzggeVar = zzgge.zzc;
                        } else {
                            throw new GeneralSecurityException("Unknown key status");
                            break;
                        }
                    } else {
                        zzggeVar = zzgge.zzb;
                    }
                } else {
                    zzggeVar = zzgge.zza;
                }
                arrayList.add(new zzggl(zzb, zzggeVar, zza, zza == zzgvgVar.zzc(), null));
            } catch (GeneralSecurityException unused) {
                arrayList.add(null);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static void zzi(zzgvg zzgvgVar) throws GeneralSecurityException {
        if (zzgvgVar == null || zzgvgVar.zza() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    @Nullable
    private static final Object zzj(zzgnb zzgnbVar, zzggc zzggcVar, Class cls) throws GeneralSecurityException {
        try {
            return zzgob.zza().zzc(zzggcVar, cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public final String toString() {
        Charset charset = zzghf.zza;
        zzgvg zzgvgVar = this.zza;
        zzgvi zza = zzgvl.zza();
        zza.zzb(zzgvgVar.zzc());
        for (zzgvf zzgvfVar : zzgvgVar.zzh()) {
            zzgvj zza2 = zzgvk.zza();
            zza2.zzc(zzgvfVar.zzc().zzg());
            zza2.zzd(zzgvfVar.zzk());
            zza2.zzb(zzgvfVar.zzf());
            zza2.zza(zzgvfVar.zza());
            zza.zza((zzgvk) zza2.zzal());
        }
        return ((zzgvl) zza.zzal()).toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzgvg zzd() {
        return this.zza;
    }

    public final Object zze(zzgfw zzgfwVar, Class cls) throws GeneralSecurityException {
        Class zzb = zzghb.zzb(cls);
        if (zzb == null) {
            throw new GeneralSecurityException("No wrapper found for ".concat(String.valueOf(cls.getName())));
        }
        zzgvg zzgvgVar = this.zza;
        Charset charset = zzghf.zza;
        int zzc = zzgvgVar.zzc();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzgvf zzgvfVar : zzgvgVar.zzh()) {
            if (zzgvfVar.zzk() == 3) {
                if (zzgvfVar.zzj()) {
                    if (zzgvfVar.zzf() != zzgvz.UNKNOWN_PREFIX) {
                        if (zzgvfVar.zzk() != 2) {
                            if (zzgvfVar.zza() == zzc) {
                                if (z) {
                                    throw new GeneralSecurityException("keyset contains multiple primary keys");
                                }
                                z = true;
                            }
                            z2 &= zzgvfVar.zzc().zzc() == zzgus.ASYMMETRIC_PUBLIC;
                            i++;
                        } else {
                            throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzgvfVar.zza())));
                        }
                    } else {
                        throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzgvfVar.zza())));
                    }
                } else {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzgvfVar.zza())));
                }
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (z || z2) {
            zzggs zzggsVar = new zzggs(zzb, null);
            zzggsVar.zzc(this.zzc);
            for (int i2 = 0; i2 < this.zza.zza(); i2++) {
                zzgvf zze = this.zza.zze(i2);
                if (zze.zzk() == 3) {
                    zzgnb zzgnbVar = (zzgnb) zzgfwVar;
                    Object zzg = zzg(zzgnbVar, zze, zzb);
                    Object zzj = this.zzb.get(i2) != null ? zzj(zzgnbVar, ((zzggl) this.zzb.get(i2)).zza(), zzb) : null;
                    if (zzj != null || zzg != null) {
                        if (zze.zza() == this.zza.zzc()) {
                            zzggsVar.zzb(zzj, zzg, zze);
                        } else {
                            zzggsVar.zza(zzj, zzg, zze);
                        }
                    } else {
                        throw new GeneralSecurityException("Unable to get primitive " + zzb.toString() + " for key of type " + zze.zzc().zzg());
                    }
                }
            }
            return zzgob.zza().zzd(zzggsVar.zzd(), cls);
        }
        throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
    }
}

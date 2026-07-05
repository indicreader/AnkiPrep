package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzghb {
    public static final /* synthetic */ int zza = 0;
    private static final Logger zzb = Logger.getLogger(zzghb.class.getName());
    private static final ConcurrentMap zzc = new ConcurrentHashMap();
    private static final Set zzd;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add(zzgfs.class);
        hashSet.add(zzgfy.class);
        hashSet.add(zzghd.class);
        hashSet.add(zzgga.class);
        hashSet.add(zzgfz.class);
        hashSet.add(zzggp.class);
        hashSet.add(zzgse.class);
        hashSet.add(zzggz.class);
        hashSet.add(zzgha.class);
        zzd = Collections.unmodifiableSet(hashSet);
    }

    private zzghb() {
    }

    public static synchronized zzgut zza(zzguy zzguyVar) throws GeneralSecurityException {
        zzgut zza2;
        synchronized (zzghb.class) {
            zzggd zzb2 = zzgnd.zzc().zzb(zzguyVar.zzh());
            if (zzgnd.zzc().zze(zzguyVar.zzh())) {
                zza2 = zzb2.zza(zzguyVar.zzg());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type ".concat(String.valueOf(zzguyVar.zzh())));
            }
        }
        return zza2;
    }

    @Nullable
    public static Class zzb(Class cls) {
        try {
            return zzgob.zza().zzb(cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public static Object zzc(zzgut zzgutVar, Class cls) throws GeneralSecurityException {
        return zzd(zzgutVar.zzg(), zzgutVar.zzf(), cls);
    }

    public static Object zzd(String str, zzgyl zzgylVar, Class cls) throws GeneralSecurityException {
        return zzgnd.zzc().zza(str, cls).zzc(zzgylVar);
    }

    public static synchronized void zze(zzggd zzggdVar, boolean z) throws GeneralSecurityException {
        synchronized (zzghb.class) {
            try {
                if (zzggdVar == null) {
                    throw new IllegalArgumentException("key manager must be non-null.");
                }
                if (!zzd.contains(zzggdVar.zzb())) {
                    throw new GeneralSecurityException("Registration of key managers for class " + zzggdVar.zzb().toString() + " has been disabled. Please file an issue on https://github.com/tink-crypto/tink-java");
                }
                if (!zzgmv.zza(1)) {
                    throw new GeneralSecurityException("Registering key managers is not supported in FIPS mode");
                }
                zzgnd.zzc().zzd(zzggdVar, true);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized void zzf(zzggy zzggyVar) throws GeneralSecurityException {
        synchronized (zzghb.class) {
            zzgob.zza().zzf(zzggyVar);
        }
    }
}

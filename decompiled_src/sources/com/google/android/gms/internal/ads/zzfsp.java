package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfsp {
    private static final HashMap zza = new HashMap();
    private final Context zzb;
    private final zzfsq zzc;
    private final zzfqr zzd;
    private final zzfqm zze;
    private zzfse zzf;
    private final Object zzg = new Object();

    public zzfsp(Context context, zzfsq zzfsqVar, zzfqr zzfqrVar, zzfqm zzfqmVar) {
        this.zzb = context;
        this.zzc = zzfsqVar;
        this.zzd = zzfqrVar;
        this.zze = zzfqmVar;
    }

    private final synchronized Class zzd(zzfsf zzfsfVar) throws zzfso {
        String zzk = zzfsfVar.zza().zzk();
        HashMap hashMap = zza;
        Class cls = (Class) hashMap.get(zzk);
        if (cls != null) {
            return cls;
        }
        try {
            if (this.zze.zza(zzfsfVar.zzc())) {
                try {
                    File zzb = zzfsfVar.zzb();
                    if (!zzb.exists()) {
                        zzb.mkdirs();
                    }
                    Class loadClass = new DexClassLoader(zzfsfVar.zzc().getAbsolutePath(), zzb.getAbsolutePath(), null, this.zzb.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                    hashMap.put(zzk, loadClass);
                    return loadClass;
                } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e) {
                    throw new zzfso(2008, e);
                }
            }
            throw new zzfso(2026, "VM did not pass signature verification");
        } catch (GeneralSecurityException e2) {
            throw new zzfso(2026, e2);
        }
    }

    public final zzfqu zza() {
        zzfse zzfseVar;
        synchronized (this.zzg) {
            zzfseVar = this.zzf;
        }
        return zzfseVar;
    }

    public final zzfsf zzb() {
        synchronized (this.zzg) {
            zzfse zzfseVar = this.zzf;
            if (zzfseVar == null) {
                return null;
            }
            return zzfseVar.zzf();
        }
    }

    public final boolean zzc(zzfsf zzfsfVar) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                zzfse zzfseVar = new zzfse(zzd(zzfsfVar).getDeclaredConstructor(Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE).newInstance(this.zzb, "msa-r", zzfsfVar.zze(), null, new Bundle(), 2), zzfsfVar, this.zzc, this.zzd);
                if (!zzfseVar.zzh()) {
                    throw new zzfso(4000, "init failed");
                }
                int zze = zzfseVar.zze();
                if (zze == 0) {
                    synchronized (this.zzg) {
                        zzfse zzfseVar2 = this.zzf;
                        if (zzfseVar2 != null) {
                            try {
                                zzfseVar2.zzg();
                            } catch (zzfso e) {
                                this.zzd.zzc(e.zza(), -1L, e);
                            }
                        }
                        this.zzf = zzfseVar;
                    }
                    this.zzd.zzd(PathInterpolatorCompat.MAX_NUM_POINTS, System.currentTimeMillis() - currentTimeMillis);
                    return true;
                }
                throw new zzfso(4001, "ci: " + zze);
            } catch (Exception e2) {
                throw new zzfso(2004, e2);
            }
        } catch (zzfso e3) {
            this.zzd.zzc(e3.zza(), System.currentTimeMillis() - currentTimeMillis, e3);
            return false;
        } catch (Exception e4) {
            this.zzd.zzc(4010, System.currentTimeMillis() - currentTimeMillis, e4);
            return false;
        }
    }
}

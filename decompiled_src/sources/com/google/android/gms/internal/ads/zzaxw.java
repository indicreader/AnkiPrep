package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzaxw {
    protected static final String zza = "zzaxw";
    private final zzawj zzb;
    private final String zzc;
    private final String zzd;
    private final Class[] zzf;
    private volatile Method zze = null;
    private final CountDownLatch zzg = new CountDownLatch(1);

    public zzaxw(zzawj zzawjVar, String str, String str2, Class... clsArr) {
        this.zzb = zzawjVar;
        this.zzc = str;
        this.zzd = str2;
        this.zzf = clsArr;
        zzawjVar.zzk().submit(new zzaxv(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzb(zzaxw zzaxwVar) {
        try {
            zzawj zzawjVar = zzaxwVar.zzb;
            Class loadClass = zzawjVar.zzi().loadClass(zzaxwVar.zzc(zzawjVar.zzu(), zzaxwVar.zzc));
            if (loadClass != null) {
                zzaxwVar.zze = loadClass.getMethod(zzaxwVar.zzc(zzaxwVar.zzb.zzu(), zzaxwVar.zzd), zzaxwVar.zzf);
                Method method = zzaxwVar.zze;
            }
        } catch (zzavn | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException | NullPointerException unused) {
        } catch (Throwable th) {
            zzaxwVar.zzg.countDown();
            throw th;
        }
        zzaxwVar.zzg.countDown();
    }

    private final String zzc(byte[] bArr, String str) throws zzavn, UnsupportedEncodingException {
        return new String(this.zzb.zze().zzb(bArr, str), "UTF-8");
    }

    public final Method zza() {
        if (this.zze != null) {
            return this.zze;
        }
        try {
            if (this.zzg.await(2L, TimeUnit.SECONDS)) {
                return this.zze;
            }
            return null;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}

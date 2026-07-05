package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcif extends zzchw implements zzcgb {
    public static final /* synthetic */ int zzd = 0;
    private zzcgc zze;
    private String zzf;
    private boolean zzg;
    private boolean zzh;
    private zzcho zzi;
    private long zzj;
    private long zzk;

    public zzcif(zzcgl zzcglVar, zzcgk zzcgkVar) {
        super(zzcglVar);
        zzcix zzcixVar = new zzcix(zzcglVar.getContext(), zzcgkVar, (zzcgl) this.zzc.get(), null);
        zzcec.zzi("ExoPlayerAdapter initialized.");
        this.zze = zzcixVar;
        zzcixVar.zzL(this);
    }

    protected static final String zzc(String str) {
        return "cache:".concat(String.valueOf(zzcdv.zze(str)));
    }

    private static String zzd(String str, Exception exc) {
        return str + "/" + exc.getClass().getCanonicalName() + ":" + exc.getMessage();
    }

    private final void zzx(long j) {
        com.google.android.gms.ads.internal.util.zzt.zza.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcie
            @Override // java.lang.Runnable
            public final void run() {
                zzcif.this.zzb();
            }
        }, j);
    }

    @Override // com.google.android.gms.internal.ads.zzchw, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzcgc zzcgcVar = this.zze;
        if (zzcgcVar != null) {
            zzcgcVar.zzL(null);
            this.zze.zzH();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzD(int i, int i2) {
    }

    public final zzcgc zza() {
        synchronized (this) {
            this.zzh = true;
            notify();
        }
        this.zze.zzL(null);
        zzcgc zzcgcVar = this.zze;
        this.zze = null;
        return zzcgcVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [long] */
    /* JADX WARN: Type inference failed for: r3v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22, types: [com.google.android.gms.internal.ads.zzchw, com.google.android.gms.internal.ads.zzcif] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26, types: [com.google.android.gms.internal.ads.zzcif] */
    /* JADX WARN: Type inference failed for: r3v31 */
    public final /* synthetic */ void zzb() {
        String str;
        zzcif zzcifVar;
        zzcif zzcifVar2;
        ?? longValue;
        long intValue;
        zzcif zzcifVar3;
        long j;
        long j2;
        String str2;
        long j3;
        String zzc = zzc(this.zzf);
        String str3 = "error";
        try {
            longValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzx)).longValue() * 1000;
            intValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzw)).intValue();
            zzcifVar = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbQ)).booleanValue();
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
            str = zzc;
            zzcifVar = this;
        }
        synchronized (this) {
            try {
                long currentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
                long j4 = this.zzj;
                if (currentTimeMillis - j4 <= longValue) {
                    try {
                        if (this.zzg) {
                            throw new IOException("Abort requested before buffering finished. ");
                        }
                        if (!this.zzh) {
                            if (!this.zze.zzV()) {
                                throw new IOException("ExoPlayer was released during preloading.");
                            }
                            long zzz = this.zze.zzz();
                            if (zzz > 0) {
                                long zzv = this.zze.zzv();
                                if (zzv != this.zzk) {
                                    try {
                                        j2 = intValue;
                                        str2 = zzc;
                                        try {
                                            zzo(this.zzf, zzc, zzv, zzz, zzv > 0, zzcifVar != 0 ? this.zze.zzA() : -1L, zzcifVar != 0 ? this.zze.zzx() : -1L, zzcifVar != 0 ? this.zze.zzB() : -1L, zzcgc.zzs(), zzcgc.zzu());
                                            zzcifVar = this;
                                            j = zzv;
                                            try {
                                                zzcifVar.zzk = j;
                                                j3 = zzz;
                                                zzcifVar = zzcifVar;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                str = str2;
                                                throw th;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            zzcifVar = this;
                                            str = str2;
                                            throw th;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        str2 = zzc;
                                        zzcifVar = this;
                                    }
                                } else {
                                    j = zzv;
                                    j2 = intValue;
                                    str2 = zzc;
                                    zzcifVar = this;
                                    j3 = zzz;
                                }
                                if (j >= j3) {
                                    zzcifVar.zzj(zzcifVar.zzf, str2, j3);
                                    zzcifVar2 = zzcifVar;
                                } else {
                                    long zzw = zzcifVar.zze.zzw();
                                    zzcifVar3 = zzcifVar;
                                    if (zzw >= j2) {
                                        zzcifVar3 = zzcifVar;
                                        if (j > 0) {
                                            zzcifVar2 = zzcifVar;
                                        }
                                    }
                                }
                            } else {
                                zzcifVar3 = this;
                            }
                            zzcifVar3.zzx(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzy)).longValue());
                            return;
                        }
                        zzcifVar2 = this;
                        com.google.android.gms.ads.internal.zzt.zzy().zzc(zzcifVar2.zzi);
                    } catch (Throwable th5) {
                        th = th5;
                        str3 = longValue;
                        str = j4;
                    }
                } else {
                    str = zzc;
                    zzcifVar = this;
                    try {
                        throw new IOException("Timeout reached. Limit: " + ((long) longValue) + " ms");
                    } catch (Throwable th6) {
                        th = th6;
                        str3 = "downloadTimeout";
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                str = zzc;
                zzcifVar = this;
            }
            try {
                throw th;
            } catch (Exception e2) {
                e = e2;
                String str4 = str3;
                zzcec.zzj("Failed to preload url " + zzcifVar.zzf + " Exception: " + e.getMessage());
                com.google.android.gms.ads.internal.zzt.zzo().zzv(e, "VideoStreamExoPlayerCache.preload");
                release();
                zzcifVar.zzg(zzcifVar.zzf, str, str4, zzd(str4, e));
                zzcifVar2 = zzcifVar;
                com.google.android.gms.ads.internal.zzt.zzy().zzc(zzcifVar2.zzi);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzchw
    public final void zzf() {
        synchronized (this) {
            this.zzg = true;
            notify();
            release();
        }
        String str = this.zzf;
        if (str != null) {
            zzg(this.zzf, zzc(str), "externalAbort", "Programmatic precache abort.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzi(final boolean z, final long j) {
        final zzcgl zzcglVar = (zzcgl) this.zzc.get();
        if (zzcglVar != null) {
            zzcep.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcid
                @Override // java.lang.Runnable
                public final void run() {
                    int i = zzcif.zzd;
                    zzcgl.this.zzv(z, j);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzk(String str, Exception exc) {
        zzcec.zzk("Precache error", exc);
        com.google.android.gms.ads.internal.zzt.zzo().zzv(exc, "VideoStreamExoPlayerCache.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzl(String str, Exception exc) {
        zzcec.zzk("Precache exception", exc);
        com.google.android.gms.ads.internal.zzt.zzo().zzv(exc, "VideoStreamExoPlayerCache.onException");
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzm(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzchw
    public final void zzp(int i) {
        this.zze.zzJ(i);
    }

    @Override // com.google.android.gms.internal.ads.zzchw
    public final void zzq(int i) {
        this.zze.zzK(i);
    }

    @Override // com.google.android.gms.internal.ads.zzchw
    public final void zzr(int i) {
        this.zze.zzM(i);
    }

    @Override // com.google.android.gms.internal.ads.zzchw
    public final void zzs(int i) {
        this.zze.zzN(i);
    }

    @Override // com.google.android.gms.internal.ads.zzchw
    public final boolean zzt(String str) {
        return zzu(str, new String[]{str});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.android.gms.internal.ads.zzchw] */
    /* JADX WARN: Type inference failed for: r5v10, types: [int] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // com.google.android.gms.internal.ads.zzchw
    public final boolean zzu(String str, String[] strArr) {
        ?? r6;
        String str2;
        ?? r5;
        long j;
        long j2;
        long j3;
        ?? r1;
        long j4;
        String str3;
        long j5;
        long j6;
        zzcif zzcifVar = this;
        String str4 = str;
        zzcifVar.zzf = str4;
        String str5 = "error";
        String zzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                uriArr[i] = Uri.parse(strArr[i]);
            }
            zzcifVar.zze.zzF(uriArr, zzcifVar.zzb);
            zzcgl zzcglVar = (zzcgl) zzcifVar.zzc.get();
            if (zzcglVar != null) {
                zzcglVar.zzt(zzc, zzcifVar);
            }
            Clock zzB = com.google.android.gms.ads.internal.zzt.zzB();
            long currentTimeMillis = zzB.currentTimeMillis();
            long longValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzy)).longValue();
            long longValue2 = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzx)).longValue() * 1000;
            long intValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzw)).intValue();
            boolean booleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbQ)).booleanValue();
            long j7 = -1;
            long j8 = intValue;
            while (true) {
                synchronized (this) {
                    try {
                        if (zzB.currentTimeMillis() - currentTimeMillis > longValue2) {
                            throw new IOException("Timeout reached. Limit: " + longValue2 + " ms");
                        }
                        if (zzcifVar.zzg) {
                            throw new IOException("Abort requested before buffering finished. ");
                        }
                        if (zzcifVar.zzh) {
                            break;
                        }
                        if (zzcifVar.zze.zzV()) {
                            long zzz = zzcifVar.zze.zzz();
                            if (zzz > 0) {
                                long zzv = zzcifVar.zze.zzv();
                                if (zzv != j7) {
                                    try {
                                        j = j8;
                                        long j9 = zzz;
                                        j2 = longValue2;
                                        j4 = longValue;
                                        str3 = zzc;
                                        try {
                                            zzo(str, zzc, zzv, j9, zzv > 0, booleanValue ? zzcifVar.zze.zzA() : -1L, booleanValue ? zzcifVar.zze.zzx() : -1L, booleanValue ? zzcifVar.zze.zzB() : -1L, zzcgc.zzs(), zzcgc.zzu());
                                            j6 = zzv;
                                            j5 = zzz;
                                            r6 = j9;
                                        } catch (Throwable th) {
                                            th = th;
                                            r5 = this;
                                            r6 = str;
                                            str2 = str3;
                                            try {
                                                throw th;
                                            } catch (Exception e) {
                                                e = e;
                                                String str6 = str5;
                                                zzcec.zzj("Failed to preload url " + r6 + " Exception: " + e.getMessage());
                                                com.google.android.gms.ads.internal.zzt.zzo().zzv(e, "VideoStreamExoPlayerCache.preload");
                                                release();
                                                r5.zzg(r6, str2, str6, zzd(str6, e));
                                                return false;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        str3 = zzc;
                                    }
                                } else {
                                    j = j8;
                                    j2 = longValue2;
                                    j4 = longValue;
                                    str3 = zzc;
                                    j5 = zzz;
                                    j6 = j7;
                                    r6 = j8;
                                }
                                r5 = (zzv > j5 ? 1 : (zzv == j5 ? 0 : -1));
                                if (r5 >= 0) {
                                    zzj(str, str3, j5);
                                } else {
                                    try {
                                        zzcif zzcifVar2 = this;
                                        r6 = str;
                                        str2 = str3;
                                        if (zzcifVar2.zze.zzw() < j || zzv <= 0) {
                                            j3 = j4;
                                            r1 = j6;
                                            r5 = zzcifVar2;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        throw th;
                                    }
                                }
                            } else {
                                j = j8;
                                j2 = longValue2;
                                r6 = str4;
                                str2 = zzc;
                                r5 = zzcifVar;
                                j3 = longValue;
                                r1 = j7;
                            }
                            try {
                                try {
                                    r5.wait(j3);
                                } catch (InterruptedException unused) {
                                    throw new IOException("Wait interrupted.");
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                str5 = r1;
                                throw th;
                            }
                        } else {
                            throw new IOException("ExoPlayer was released during preloading.");
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        r6 = str4;
                        str2 = zzc;
                        r5 = zzcifVar;
                    }
                }
                longValue = j3;
                zzcifVar = r5;
                str4 = r6;
                zzc = str2;
                j8 = j;
                longValue2 = j2;
                j7 = r1;
            }
            return true;
        } catch (Exception e2) {
            e = e2;
            r6 = str4;
            str2 = zzc;
            r5 = zzcifVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzv() {
        zzcec.zzj("Precache onRenderedFirstFrame");
    }

    @Override // com.google.android.gms.internal.ads.zzchw
    public final boolean zzw(String str, String[] strArr, zzcho zzchoVar) {
        this.zzf = str;
        this.zzi = zzchoVar;
        String zzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                uriArr[i] = Uri.parse(strArr[i]);
            }
            this.zze.zzF(uriArr, this.zzb);
            zzcgl zzcglVar = (zzcgl) this.zzc.get();
            if (zzcglVar != null) {
                zzcglVar.zzt(zzc, this);
            }
            this.zzj = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
            this.zzk = -1L;
            zzx(0L);
            return true;
        } catch (Exception e) {
            zzcec.zzj("Failed to preload url " + str + " Exception: " + e.getMessage());
            com.google.android.gms.ads.internal.zzt.zzo().zzv(e, "VideoStreamExoPlayerCache.preload");
            release();
            zzg(str, zzc, "error", zzd("error", e));
            return false;
        }
    }
}

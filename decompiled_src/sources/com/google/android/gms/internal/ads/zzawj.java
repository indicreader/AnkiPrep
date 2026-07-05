package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzawj {
    private static final String zzd = "zzawj";
    protected final Context zza;
    private ExecutorService zze;
    private DexClassLoader zzf;
    private zzavo zzg;
    private byte[] zzh;
    private final boolean zzl;
    private zzavd zzo;
    private final Map zzp;
    private zzawc zzr;
    private volatile AdvertisingIdClient zzi = null;
    private volatile boolean zzj = false;
    private Future zzk = null;
    private volatile zzatd zzm = null;
    private Future zzn = null;
    protected boolean zzb = false;
    protected boolean zzc = false;
    private boolean zzq = false;

    private zzawj(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.zzl = applicationContext != null;
        context = applicationContext != null ? applicationContext : context;
        this.zza = context;
        this.zzp = new HashMap();
        if (this.zzr != null) {
            return;
        }
        this.zzr = new zzawc(context);
    }

    public static zzawj zzg(Context context, String str, String str2, boolean z) {
        zzavo zzavoVar;
        zzawj zzawjVar = new zzawj(context);
        try {
            zzawjVar.zze = Executors.newCachedThreadPool(new zzawf());
            zzawjVar.zzj = z;
            if (z) {
                zzawjVar.zzk = zzawjVar.zze.submit(new zzawg(zzawjVar));
            }
            zzawjVar.zze.execute(new zzawi(zzawjVar));
            try {
                GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
                zzawjVar.zzb = googleApiAvailabilityLight.getApkVersion(zzawjVar.zza) > 0;
                zzawjVar.zzc = googleApiAvailabilityLight.isGooglePlayServicesAvailable(zzawjVar.zza) == 0;
            } catch (Throwable unused) {
            }
            zzawjVar.zzo(0, true);
            if (zzawm.zzc()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzde)).booleanValue()) {
                    throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
                }
            }
            zzavoVar = new zzavo(null);
            zzawjVar.zzg = zzavoVar;
        } catch (zzavz unused2) {
        }
        try {
            try {
                byte[] zzb = zzatt.zzb("wsk3Vojf7RmX+WtFiGWOJo7xhFKFeiDn9iUtTCe0eNY=", false);
                if (zzb.length != 32) {
                    throw new zzavn(zzavoVar);
                }
                byte[] bArr = new byte[16];
                ByteBuffer.wrap(zzb, 4, 16).get(bArr);
                for (int i = 0; i < 16; i++) {
                    bArr[i] = (byte) (bArr[i] ^ 68);
                }
                zzawjVar.zzh = bArr;
                try {
                    try {
                        try {
                            File cacheDir = zzawjVar.zza.getCacheDir();
                            if (cacheDir == null && (cacheDir = zzawjVar.zza.getDir("dex", 0)) == null) {
                                throw new zzavz();
                            }
                            File file = new File(String.format("%s/%s.jar", cacheDir, "1700159444520"));
                            if (!file.exists()) {
                                byte[] zzb2 = zzawjVar.zzg.zzb(zzawjVar.zzh, "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");
                                file.createNewFile();
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                if (Build.VERSION.SDK_INT >= 33) {
                                    file.setReadOnly();
                                }
                                fileOutputStream.write(zzb2, 0, zzb2.length);
                                fileOutputStream.close();
                            }
                            zzawjVar.zzx(cacheDir, "1700159444520");
                            try {
                                zzawjVar.zzf = new DexClassLoader(file.getAbsolutePath(), cacheDir.getAbsolutePath(), null, zzawjVar.zza.getClassLoader());
                                zzawjVar.zzo = new zzavd(zzawjVar);
                                zzawjVar.zzq = true;
                                return zzawjVar;
                            } finally {
                                zzy(file);
                                zzawjVar.zzw(cacheDir, "1700159444520");
                                zzz(String.format("%s/%s.dex", cacheDir, "1700159444520"));
                            }
                        } catch (zzavn e) {
                            throw new zzavz(e);
                        }
                    } catch (NullPointerException e2) {
                        throw new zzavz(e2);
                    }
                } catch (FileNotFoundException e3) {
                    throw new zzavz(e3);
                } catch (IOException e4) {
                    throw new zzavz(e4);
                }
            } catch (zzavn e5) {
                throw new zzavz(e5);
            }
        } catch (IllegalArgumentException e6) {
            throw new zzavn(zzavoVar, e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzv() {
        try {
            if (this.zzi == null && this.zzl) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zza);
                advertisingIdClient.start();
                this.zzi = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.zzi = null;
        }
    }

    private final void zzw(File file, String str) {
        Throwable th;
        FileOutputStream fileOutputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, "1700159444520"));
        if (file2.exists()) {
            return;
        }
        File file3 = new File(String.format("%s/%s.dex", file, "1700159444520"));
        if (!file3.exists()) {
            return;
        }
        long length = file3.length();
        if (length <= 0) {
            return;
        }
        byte[] bArr = new byte[(int) length];
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file3);
            try {
                try {
                    if (fileInputStream2.read(bArr) <= 0) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused) {
                        }
                        zzy(file3);
                        return;
                    }
                    System.out.print("test");
                    System.out.print("test");
                    System.out.print("test");
                    zzatg zza = zzath.zza();
                    byte[] bytes = Build.VERSION.SDK.getBytes();
                    zzgyl zzgylVar = zzgyl.zzb;
                    zza.zzc(zzgyl.zzv(bytes, 0, bytes.length));
                    byte[] bytes2 = "1700159444520".getBytes();
                    zza.zzd(zzgyl.zzv(bytes2, 0, bytes2.length));
                    byte[] bytes3 = this.zzg.zza(this.zzh, bArr).getBytes();
                    zza.zza(zzgyl.zzv(bytes3, 0, bytes3.length));
                    byte[] zze = zzatx.zze(bytes3);
                    zza.zzb(zzgyl.zzv(zze, 0, zze.length));
                    file2.createNewFile();
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        byte[] zzax = ((zzath) zza.zzal()).zzax();
                        fileOutputStream.write(zzax, 0, zzax.length);
                        fileOutputStream.close();
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused2) {
                        }
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                        zzy(file3);
                    } catch (zzavn | IOException | NoSuchAlgorithmException unused4) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused5) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused6) {
                            }
                        }
                        zzy(file3);
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused7) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused8) {
                            }
                        }
                        zzy(file3);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (zzavn | IOException | NoSuchAlgorithmException unused9) {
                fileOutputStream = null;
            }
        } catch (zzavn | IOException | NoSuchAlgorithmException unused10) {
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    private final boolean zzx(File file, String str) {
        FileOutputStream fileOutputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, "1700159444520"));
        if (!file2.exists()) {
            return false;
        }
        File file3 = new File(String.format("%s/%s.dex", file, "1700159444520"));
        if (!file3.exists()) {
            FileInputStream fileInputStream = null;
            try {
                long length = file2.length();
                if (length <= 0) {
                    zzy(file2);
                    return false;
                }
                byte[] bArr = new byte[(int) length];
                FileInputStream fileInputStream2 = new FileInputStream(file2);
                try {
                    try {
                        if (fileInputStream2.read(bArr) <= 0) {
                            Log.d(zzd, "Cannot read the cache data.");
                            zzy(file2);
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused) {
                            }
                            return false;
                        }
                        try {
                            try {
                                zzath zzd2 = zzath.zzd(bArr, zzgzf.zza());
                                if ("1700159444520".equals(new String(zzd2.zzh().zzA())) && Arrays.equals(zzd2.zzf().zzA(), zzatx.zze(zzd2.zze().zzA())) && Arrays.equals(zzd2.zzg().zzA(), Build.VERSION.SDK.getBytes())) {
                                    byte[] zzb = this.zzg.zzb(this.zzh, new String(zzd2.zze().zzA()));
                                    file3.createNewFile();
                                    fileOutputStream = new FileOutputStream(file3);
                                    try {
                                        fileOutputStream.write(zzb, 0, zzb.length);
                                        try {
                                            fileInputStream2.close();
                                        } catch (IOException unused2) {
                                        }
                                        try {
                                            fileOutputStream.close();
                                            return true;
                                        } catch (IOException unused3) {
                                            return true;
                                        }
                                    } catch (zzavn | IOException | NoSuchAlgorithmException unused4) {
                                        fileInputStream = fileInputStream2;
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (IOException unused5) {
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException unused6) {
                                            }
                                        }
                                        return false;
                                    } catch (Throwable th) {
                                        th = th;
                                        fileInputStream = fileInputStream2;
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (IOException unused7) {
                                            }
                                        }
                                        if (fileOutputStream == null) {
                                            throw th;
                                        }
                                        try {
                                            fileOutputStream.close();
                                            throw th;
                                        } catch (IOException unused8) {
                                            throw th;
                                        }
                                    }
                                }
                                zzy(file2);
                                try {
                                    fileInputStream2.close();
                                } catch (IOException unused9) {
                                }
                                return false;
                            } catch (IOException unused10) {
                                return false;
                            }
                        } catch (NullPointerException unused11) {
                            fileInputStream2.close();
                            return false;
                        }
                    } catch (zzavn | IOException | NoSuchAlgorithmException unused12) {
                        fileOutputStream = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (zzavn | IOException | NoSuchAlgorithmException unused13) {
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        }
        return false;
    }

    private static final void zzy(File file) {
        if (!file.exists()) {
            Log.d(zzd, String.format("File %s not found. No need for deletion", file.getAbsolutePath()));
        } else {
            file.delete();
        }
    }

    private static final void zzz(String str) {
        zzy(new File(str));
    }

    public final int zza() {
        if (this.zzo != null) {
            return zzavd.zzd();
        }
        return Integer.MIN_VALUE;
    }

    public final Context zzb() {
        return this.zza;
    }

    public final zzatd zzc() {
        return this.zzm;
    }

    public final zzavd zzd() {
        return this.zzo;
    }

    public final zzavo zze() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzawc zzf() {
        return this.zzr;
    }

    public final AdvertisingIdClient zzh() {
        Future future;
        if (!this.zzj) {
            return null;
        }
        if (this.zzi == null && (future = this.zzk) != null) {
            try {
                future.get(2000L, TimeUnit.MILLISECONDS);
                this.zzk = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.zzk.cancel(true);
            }
        }
        return this.zzi;
    }

    public final DexClassLoader zzi() {
        return this.zzf;
    }

    public final Method zzj(String str, String str2) {
        zzaxw zzaxwVar = (zzaxw) this.zzp.get(new Pair(str, str2));
        if (zzaxwVar == null) {
            return null;
        }
        return zzaxwVar.zza();
    }

    public final ExecutorService zzk() {
        return this.zze;
    }

    public final Future zzl() {
        return this.zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzo(int i, boolean z) {
        if (this.zzc) {
            Future<?> submit = this.zze.submit(new zzawh(this, i, true));
            if (i == 0) {
                this.zzn = submit;
            }
        }
    }

    public final boolean zzp() {
        return this.zzc;
    }

    public final boolean zzq() {
        return this.zzb;
    }

    public final boolean zzr() {
        return this.zzq;
    }

    public final boolean zzs() {
        return this.zzr.zza();
    }

    public final boolean zzt(String str, String str2, Class... clsArr) {
        Pair pair = new Pair(str, str2);
        if (this.zzp.containsKey(pair)) {
            return false;
        }
        this.zzp.put(pair, new zzaxw(this, str, str2, clsArr));
        return true;
    }

    public final byte[] zzu() {
        return this.zzh;
    }
}

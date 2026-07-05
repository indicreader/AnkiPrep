package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzaqw implements zzapk {
    private final zzaqv zzc;
    private final Map zza = new LinkedHashMap(16, 0.75f, true);
    private long zzb = 0;
    private final int zzd = 5242880;

    public zzaqw(zzaqv zzaqvVar, int i) {
        this.zzc = zzaqvVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(InputStream inputStream) throws IOException {
        return (zzn(inputStream) << 24) | zzn(inputStream) | (zzn(inputStream) << 8) | (zzn(inputStream) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzf(InputStream inputStream) throws IOException {
        return (zzn(inputStream) & 255) | ((zzn(inputStream) & 255) << 8) | ((zzn(inputStream) & 255) << 16) | ((zzn(inputStream) & 255) << 24) | ((zzn(inputStream) & 255) << 32) | ((zzn(inputStream) & 255) << 40) | ((zzn(inputStream) & 255) << 48) | ((zzn(inputStream) & 255) << 56);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzh(zzaqu zzaquVar) throws IOException {
        return new String(zzm(zzaquVar, zzf(zzaquVar)), "UTF-8");
    }

    static void zzj(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void zzk(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) j);
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static void zzl(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        int length = bytes.length;
        zzk(outputStream, length);
        outputStream.write(bytes, 0, length);
    }

    static byte[] zzm(zzaqu zzaquVar, long j) throws IOException {
        long zza = zzaquVar.zza();
        if (j >= 0 && j <= zza) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(zzaquVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + zza);
    }

    private static int zzn(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private final void zzo(String str, zzaqt zzaqtVar) {
        if (this.zza.containsKey(str)) {
            this.zzb += zzaqtVar.zza - ((zzaqt) this.zza.get(str)).zza;
        } else {
            this.zzb += zzaqtVar.zza;
        }
        this.zza.put(str, zzaqtVar);
    }

    private final void zzp(String str) {
        zzaqt zzaqtVar = (zzaqt) this.zza.remove(str);
        if (zzaqtVar != null) {
            this.zzb -= zzaqtVar.zza;
        }
    }

    private static final String zzq(String str) {
        int length = str.length() / 2;
        return String.valueOf(String.valueOf(str.substring(0, length).hashCode())).concat(String.valueOf(String.valueOf(str.substring(length).hashCode())));
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final synchronized zzapj zza(String str) {
        zzaqt zzaqtVar = (zzaqt) this.zza.get(str);
        if (zzaqtVar == null) {
            return null;
        }
        File zzg = zzg(str);
        try {
            zzaqu zzaquVar = new zzaqu(new BufferedInputStream(new FileInputStream(zzg)), zzg.length());
            try {
                zzaqt zza = zzaqt.zza(zzaquVar);
                if (!TextUtils.equals(str, zza.zzb)) {
                    zzaqm.zza("%s: key=%s, found=%s", zzg.getAbsolutePath(), str, zza.zzb);
                    zzp(str);
                    return null;
                }
                byte[] zzm = zzm(zzaquVar, zzaquVar.zza());
                zzapj zzapjVar = new zzapj();
                zzapjVar.zza = zzm;
                zzapjVar.zzb = zzaqtVar.zzc;
                zzapjVar.zzc = zzaqtVar.zzd;
                zzapjVar.zzd = zzaqtVar.zze;
                zzapjVar.zze = zzaqtVar.zzf;
                zzapjVar.zzf = zzaqtVar.zzg;
                List<zzaps> list = zzaqtVar.zzh;
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (zzaps zzapsVar : list) {
                    treeMap.put(zzapsVar.zza(), zzapsVar.zzb());
                }
                zzapjVar.zzg = treeMap;
                zzapjVar.zzh = Collections.unmodifiableList(zzaqtVar.zzh);
                return zzapjVar;
            } finally {
                zzaquVar.close();
            }
        } catch (IOException e) {
            zzaqm.zza("%s: %s", zzg.getAbsolutePath(), e.toString());
            zzi(str);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final synchronized void zzb() {
        File zza = this.zzc.zza();
        if (!zza.exists()) {
            if (!zza.mkdirs()) {
                zzaqm.zzb("Unable to create cache dir %s", zza.getAbsolutePath());
            }
        } else {
            File[] listFiles = zza.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    try {
                        long length = file.length();
                        zzaqu zzaquVar = new zzaqu(new BufferedInputStream(new FileInputStream(file)), length);
                        try {
                            zzaqt zza2 = zzaqt.zza(zzaquVar);
                            zza2.zza = length;
                            zzo(zza2.zzb, zza2);
                            zzaquVar.close();
                        } catch (Throwable th) {
                            zzaquVar.close();
                            throw th;
                            break;
                        }
                    } catch (IOException unused) {
                        file.delete();
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final synchronized void zzc(String str, boolean z) {
        zzapj zza = zza(str);
        if (zza != null) {
            zza.zzf = 0L;
            zza.zze = 0L;
            zzd(str, zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final synchronized void zzd(String str, zzapj zzapjVar) {
        long j = this.zzb;
        int length = zzapjVar.zza.length;
        long j2 = j + length;
        int i = this.zzd;
        if (j2 <= i || length <= i * 0.9f) {
            File zzg = zzg(str);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(zzg));
                zzaqt zzaqtVar = new zzaqt(str, zzapjVar);
                try {
                    zzj(bufferedOutputStream, 538247942);
                    zzl(bufferedOutputStream, zzaqtVar.zzb);
                    String str2 = zzaqtVar.zzc;
                    if (str2 == null) {
                        str2 = "";
                    }
                    zzl(bufferedOutputStream, str2);
                    zzk(bufferedOutputStream, zzaqtVar.zzd);
                    zzk(bufferedOutputStream, zzaqtVar.zze);
                    zzk(bufferedOutputStream, zzaqtVar.zzf);
                    zzk(bufferedOutputStream, zzaqtVar.zzg);
                    List<zzaps> list = zzaqtVar.zzh;
                    if (list != null) {
                        zzj(bufferedOutputStream, list.size());
                        for (zzaps zzapsVar : list) {
                            zzl(bufferedOutputStream, zzapsVar.zza());
                            zzl(bufferedOutputStream, zzapsVar.zzb());
                        }
                    } else {
                        zzj(bufferedOutputStream, 0);
                    }
                    bufferedOutputStream.flush();
                    bufferedOutputStream.write(zzapjVar.zza);
                    bufferedOutputStream.close();
                    zzaqtVar.zza = zzg.length();
                    zzo(str, zzaqtVar);
                    if (this.zzb >= this.zzd) {
                        if (zzaqm.zzb) {
                            zzaqm.zzd("Pruning old cache entries.", new Object[0]);
                        }
                        long j3 = this.zzb;
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        Iterator it = this.zza.entrySet().iterator();
                        int i2 = 0;
                        while (it.hasNext()) {
                            zzaqt zzaqtVar2 = (zzaqt) ((Map.Entry) it.next()).getValue();
                            if (zzg(zzaqtVar2.zzb).delete()) {
                                this.zzb -= zzaqtVar2.zza;
                            } else {
                                String str3 = zzaqtVar2.zzb;
                                zzaqm.zza("Could not delete cache entry for key=%s, filename=%s", str3, zzq(str3));
                            }
                            it.remove();
                            i2++;
                            if (((float) this.zzb) < this.zzd * 0.9f) {
                                break;
                            }
                        }
                        if (zzaqm.zzb) {
                            zzaqm.zzd("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.zzb - j3), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                        }
                    }
                } catch (IOException e) {
                    zzaqm.zza("%s", e.toString());
                    bufferedOutputStream.close();
                    zzaqm.zza("Failed to write header for %s", zzg.getAbsolutePath());
                    throw new IOException();
                }
            } catch (IOException unused) {
                if (!zzg.delete()) {
                    zzaqm.zza("Could not clean up file %s", zzg.getAbsolutePath());
                }
                if (!this.zzc.zza().exists()) {
                    zzaqm.zza("Re-initializing cache after external clearing.", new Object[0]);
                    this.zza.clear();
                    this.zzb = 0L;
                    zzb();
                }
            }
        }
    }

    public final File zzg(String str) {
        return new File(this.zzc.zza(), zzq(str));
    }

    public final synchronized void zzi(String str) {
        boolean delete = zzg(str).delete();
        zzp(str);
        if (delete) {
            return;
        }
        zzaqm.zza("Could not delete cache entry for key=%s, filename=%s", str, zzq(str));
    }

    public zzaqw(File file, int i) {
        this.zzc = new zzaqs(this, file);
    }
}

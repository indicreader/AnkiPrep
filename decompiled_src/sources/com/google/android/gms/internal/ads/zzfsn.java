package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import coil.disk.DiskLruCache;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfsn {
    private static final Object zza = new Object();
    private final Context zzb;
    private final SharedPreferences zzc;
    private final String zzd;
    private final zzfru zze;
    private boolean zzf;

    public zzfsn(Context context, int i, zzfru zzfruVar, boolean z) {
        this.zzf = false;
        this.zzb = context;
        this.zzd = Integer.toString(i - 1);
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        this.zze = zzfruVar;
        this.zzf = z;
    }

    private final File zze(String str) {
        return new File(new File(this.zzb.getDir("pccache", 0), this.zzd), str);
    }

    private static String zzf(zzayc zzaycVar) {
        zzaye zze = zzayf.zze();
        zze.zze(zzaycVar.zzd().zzk());
        zze.zza(zzaycVar.zzd().zzj());
        zze.zzb(zzaycVar.zzd().zza());
        zze.zzd(zzaycVar.zzd().zzd());
        zze.zzc(zzaycVar.zzd().zzc());
        return Hex.bytesToStringLowercase(((zzayf) zze.zzal()).zzax());
    }

    private final String zzg() {
        return "FBAMTD".concat(String.valueOf(this.zzd));
    }

    private final String zzh() {
        return "LATMTD".concat(String.valueOf(this.zzd));
    }

    private final void zzi(int i, long j) {
        this.zze.zza(i, j);
    }

    private final void zzj(int i, long j, String str) {
        this.zze.zzb(i, j, str);
    }

    private final zzayf zzk(int i) {
        String string;
        zzgzf zzb;
        if (i == 1) {
            string = this.zzc.getString(zzh(), null);
        } else {
            string = this.zzc.getString(zzg(), null);
        }
        if (string == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            byte[] stringToBytes = Hex.stringToBytes(string);
            zzgyl zzgylVar = zzgyl.zzb;
            zzgyl zzv = zzgyl.zzv(stringToBytes, 0, stringToBytes.length);
            if (this.zzf) {
                zzb = zzgzf.zza();
            } else {
                zzb = zzgzf.zzb();
            }
            return zzayf.zzi(zzv, zzb);
        } catch (zzhag unused) {
            return null;
        } catch (NullPointerException unused2) {
            zzi(2029, currentTimeMillis);
            return null;
        } catch (RuntimeException unused3) {
            zzi(2032, currentTimeMillis);
            return null;
        }
    }

    public final boolean zza(zzayc zzaycVar) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            if (!zzfsh.zze(new File(zze(zzaycVar.zzd().zzk()), "pcbc"), zzaycVar.zze().zzA())) {
                zzi(4020, currentTimeMillis);
                return false;
            }
            String zzf = zzf(zzaycVar);
            SharedPreferences.Editor edit = this.zzc.edit();
            edit.putString(zzh(), zzf);
            boolean commit = edit.commit();
            if (commit) {
                zzi(5015, currentTimeMillis);
            } else {
                zzi(4021, currentTimeMillis);
            }
            return commit;
        }
    }

    public final boolean zzb(zzayc zzaycVar, zzfsm zzfsmVar) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            zzayf zzk = zzk(1);
            String zzk2 = zzaycVar.zzd().zzk();
            if (zzk == null || !zzk.zzk().equals(zzk2)) {
                long currentTimeMillis2 = System.currentTimeMillis();
                File zze = zze(zzk2);
                if (zze.exists()) {
                    boolean isDirectory = zze.isDirectory();
                    String str = DiskLruCache.VERSION;
                    if (true != isDirectory) {
                        str = "0";
                    }
                    boolean isFile = zze.isFile();
                    String str2 = DiskLruCache.VERSION;
                    if (true != isFile) {
                        str2 = "0";
                    }
                    zzj(4023, currentTimeMillis2, "d:" + str + ",f:" + str2);
                    zzi(4015, currentTimeMillis2);
                } else if (!zze.mkdirs()) {
                    boolean canWrite = zze.canWrite();
                    String str3 = DiskLruCache.VERSION;
                    if (true != canWrite) {
                        str3 = "0";
                    }
                    zzj(4024, currentTimeMillis2, "cw:".concat(str3));
                    zzi(4015, currentTimeMillis2);
                    return false;
                }
                File zze2 = zze(zzk2);
                File file = new File(zze2, "pcam.jar");
                File file2 = new File(zze2, "pcbc");
                if (!zzfsh.zze(file, zzaycVar.zzf().zzA())) {
                    zzi(4016, currentTimeMillis);
                    return false;
                }
                if (!zzfsh.zze(file2, zzaycVar.zze().zzA())) {
                    zzi(4017, currentTimeMillis);
                    return false;
                }
                if (zzfsmVar == null || zzfsmVar.zza(file)) {
                    String zzf = zzf(zzaycVar);
                    long currentTimeMillis3 = System.currentTimeMillis();
                    String string = this.zzc.getString(zzh(), null);
                    SharedPreferences.Editor edit = this.zzc.edit();
                    edit.putString(zzh(), zzf);
                    if (string != null) {
                        edit.putString(zzg(), string);
                    }
                    if (edit.commit()) {
                        HashSet hashSet = new HashSet();
                        zzayf zzk3 = zzk(1);
                        if (zzk3 != null) {
                            hashSet.add(zzk3.zzk());
                        }
                        zzayf zzk4 = zzk(2);
                        if (zzk4 != null) {
                            hashSet.add(zzk4.zzk());
                        }
                        for (File file3 : new File(this.zzb.getDir("pccache", 0), this.zzd).listFiles()) {
                            if (!hashSet.contains(file3.getName())) {
                                zzfsh.zzd(file3);
                            }
                        }
                        zzi(5014, currentTimeMillis);
                        return true;
                    }
                    zzi(4019, currentTimeMillis3);
                    return false;
                }
                zzi(4018, currentTimeMillis);
                zzfsh.zzd(zze2);
                return false;
            }
            zzi(4014, currentTimeMillis);
            return false;
        }
    }

    public final zzfsf zzc(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            zzayf zzk = zzk(1);
            if (zzk == null) {
                zzi(4022, currentTimeMillis);
                return null;
            }
            File zze = zze(zzk.zzk());
            File file = new File(zze, "pcam.jar");
            if (!file.exists()) {
                file = new File(zze, "pcam");
            }
            File file2 = new File(zze, "pcbc");
            File file3 = new File(zze, "pcopt");
            zzi(5016, currentTimeMillis);
            return new zzfsf(zzk, file, file2, file3);
        }
    }

    public final boolean zzd(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            zzayf zzk = zzk(1);
            if (zzk == null) {
                zzi(4025, currentTimeMillis);
                return false;
            }
            File zze = zze(zzk.zzk());
            if (!new File(zze, "pcam.jar").exists()) {
                zzi(4026, currentTimeMillis);
                return false;
            }
            if (!new File(zze, "pcbc").exists()) {
                zzi(4027, currentTimeMillis);
                return false;
            }
            zzi(5019, currentTimeMillis);
            return true;
        }
    }
}

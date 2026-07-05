package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhca {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzhcp zzc;
    private static final zzhcp zzd;

    static {
        Class<?> cls;
        Class<?> cls2;
        zzhcp zzhcpVar = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzhcpVar = (zzhcp) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzhcpVar;
        zzd = new zzhcr();
    }

    public static void zzA(int i, List list, zzgzb zzgzbVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzu(i, list, z);
    }

    public static void zzB(int i, List list, zzgzb zzgzbVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzx(i, list, z);
    }

    public static void zzC(int i, List list, zzgzb zzgzbVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzz(i, list, z);
    }

    public static void zzD(int i, List list, zzgzb zzgzbVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzB(i, list, z);
    }

    public static void zzE(int i, List list, zzgzb zzgzbVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzD(i, list, z);
    }

    public static void zzF(int i, List list, zzgzb zzgzbVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzI(i, list, z);
    }

    public static void zzG(int i, List list, zzgzb zzgzbVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzK(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgzv) {
            zzgzv zzgzvVar = (zzgzv) list;
            i = 0;
            while (i2 < size) {
                i += zzgza.zzA(zzgzvVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzgza.zzA(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgza.zzz(i << 3) + 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(List list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgza.zzz(i << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgzv) {
            zzgzv zzgzvVar = (zzgzv) list;
            i = 0;
            while (i2 < size) {
                i += zzgza.zzA(zzgzvVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzgza.zzA(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhat) {
            zzhat zzhatVar = (zzhat) list;
            i = 0;
            while (i2 < size) {
                i += zzgza.zzA(zzhatVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzgza.zzA(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i, Object obj, zzhby zzhbyVar) {
        int i2 = i << 3;
        if (obj instanceof zzhak) {
            int zzz = zzgza.zzz(i2);
            int zza2 = ((zzhak) obj).zza();
            return zzz + zzgza.zzz(zza2) + zza2;
        }
        return zzgza.zzz(i2) + zzgza.zzx((zzhbe) obj, zzhbyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgzv) {
            zzgzv zzgzvVar = (zzgzv) list;
            i = 0;
            while (i2 < size) {
                int zze = zzgzvVar.zze(i2);
                i += zzgza.zzz((zze >> 31) ^ (zze + zze));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i += zzgza.zzz((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhat) {
            zzhat zzhatVar = (zzhat) list;
            i = 0;
            while (i2 < size) {
                long zze = zzhatVar.zze(i2);
                i += zzgza.zzA((zze >> 63) ^ (zze + zze));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i += zzgza.zzA((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgzv) {
            zzgzv zzgzvVar = (zzgzv) list;
            i = 0;
            while (i2 < size) {
                i += zzgza.zzz(zzgzvVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzgza.zzz(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhat) {
            zzhat zzhatVar = (zzhat) list;
            i = 0;
            while (i2 < size) {
                i += zzgza.zzA(zzhatVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzgza.zzA(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzhcp zzm() {
        return zzc;
    }

    public static zzhcp zzn() {
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzo(Object obj, int i, List list, zzgzy zzgzyVar, Object obj2, zzhcp zzhcpVar) {
        if (zzgzyVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ((Integer) list.get(i3)).intValue();
                if (zzgzyVar.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    obj2 = zzp(obj, i, intValue, obj2, zzhcpVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return obj2;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzgzyVar.zza(intValue2)) {
                    obj2 = zzp(obj, i, intValue2, obj2, zzhcpVar);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzp(Object obj, int i, int i2, Object obj2, zzhcp zzhcpVar) {
        if (obj2 == null) {
            obj2 = zzhcpVar.zzc(obj);
        }
        zzhcpVar.zzl(obj2, i, i2);
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzq(zzhcp zzhcpVar, Object obj, Object obj2) {
        zzhcpVar.zzo(obj, zzhcpVar.zze(zzhcpVar.zzd(obj), zzhcpVar.zzd(obj2)));
    }

    public static void zzr(Class cls) {
        Class cls2;
        if (!zzgzu.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzs(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void zzt(int i, List list, zzgzb zzgzbVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzc(i, list, z);
    }

    public static void zzu(int i, List list, zzgzb zzgzbVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzg(i, list, z);
    }

    public static void zzv(int i, List list, zzgzb zzgzbVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzj(i, list, z);
    }

    public static void zzw(int i, List list, zzgzb zzgzbVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzl(i, list, z);
    }

    public static void zzx(int i, List list, zzgzb zzgzbVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzn(i, list, z);
    }

    public static void zzy(int i, List list, zzgzb zzgzbVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzp(i, list, z);
    }

    public static void zzz(int i, List list, zzgzb zzgzbVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzs(i, list, z);
    }
}

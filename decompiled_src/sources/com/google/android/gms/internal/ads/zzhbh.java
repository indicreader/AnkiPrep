package com.google.android.gms.internal.ads;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhbh<T> implements zzhby<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhcz.zzi();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzhbe zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzhas zzm;
    private final zzhcp zzn;
    private final zzgzg zzo;
    private final zzhbj zzp;
    private final zzhaz zzq;

    private zzhbh(int[] iArr, Object[] objArr, int i, int i2, zzhbe zzhbeVar, int i3, boolean z, int[] iArr2, int i4, int i5, zzhbj zzhbjVar, zzhas zzhasVar, zzhcp zzhcpVar, zzgzg zzgzgVar, zzhaz zzhazVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzhbeVar instanceof zzgzu;
        boolean z2 = false;
        if (zzgzgVar != null && zzgzgVar.zzh(zzhbeVar)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i4;
        this.zzl = i5;
        this.zzp = zzhbjVar;
        this.zzm = zzhasVar;
        this.zzn = zzhcpVar;
        this.zzo = zzgzgVar;
        this.zzg = zzhbeVar;
        this.zzq = zzhazVar;
    }

    private final Object zzA(Object obj, int i) {
        zzhby zzx = zzx(i);
        int zzu = zzu(i) & 1048575;
        if (!zzN(obj, i)) {
            return zzx.zze();
        }
        Object object = zzb.getObject(obj, zzu);
        if (zzQ(object)) {
            return object;
        }
        Object zze = zzx.zze();
        if (object != null) {
            zzx.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzB(Object obj, int i, int i2) {
        zzhby zzx = zzx(i2);
        if (!zzR(obj, i, i2)) {
            return zzx.zze();
        }
        Object object = zzb.getObject(obj, zzu(i2) & 1048575);
        if (zzQ(object)) {
            return object;
        }
        Object zze = zzx.zze();
        if (object != null) {
            zzx.zzg(zze, object);
        }
        return zze;
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zzD(Object obj) {
        if (!zzQ(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzE(Object obj, Object obj2, int i) {
        if (zzN(obj2, i)) {
            int zzu = zzu(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzu;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzhby zzx = zzx(i);
            if (!zzN(obj, i)) {
                if (!zzQ(object)) {
                    unsafe.putObject(obj, j, object);
                } else {
                    Object zze = zzx.zze();
                    zzx.zzg(zze, object);
                    unsafe.putObject(obj, j, zze);
                }
                zzH(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzQ(object2)) {
                Object zze2 = zzx.zze();
                zzx.zzg(zze2, object2);
                unsafe.putObject(obj, j, zze2);
                object2 = zze2;
            }
            zzx.zzg(object2, object);
        }
    }

    private final void zzF(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzR(obj2, i2, i)) {
            int zzu = zzu(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzu;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzhby zzx = zzx(i);
            if (!zzR(obj, i2, i)) {
                if (!zzQ(object)) {
                    unsafe.putObject(obj, j, object);
                } else {
                    Object zze = zzx.zze();
                    zzx.zzg(zze, object);
                    unsafe.putObject(obj, j, zze);
                }
                zzI(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzQ(object2)) {
                Object zze2 = zzx.zze();
                zzx.zzg(zze2, object2);
                unsafe.putObject(obj, j, zze2);
                object2 = zze2;
            }
            zzx.zzg(object2, object);
        }
    }

    private final void zzG(Object obj, int i, zzhbq zzhbqVar) throws IOException {
        long j = i & 1048575;
        if (zzM(i)) {
            zzhcz.zzv(obj, j, zzhbqVar.zzs());
        } else if (!this.zzi) {
            zzhcz.zzv(obj, j, zzhbqVar.zzp());
        } else {
            zzhcz.zzv(obj, j, zzhbqVar.zzr());
        }
    }

    private final void zzH(Object obj, int i) {
        int zzr = zzr(i);
        long j = 1048575 & zzr;
        if (j == 1048575) {
            return;
        }
        zzhcz.zzt(obj, j, (1 << (zzr >>> 20)) | zzhcz.zzd(obj, j));
    }

    private final void zzI(Object obj, int i, int i2) {
        zzhcz.zzt(obj, zzr(i2) & 1048575, i);
    }

    private final void zzJ(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzu(i) & 1048575, obj2);
        zzH(obj, i);
    }

    private final void zzK(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzu(i2) & 1048575, obj2);
        zzI(obj, i, i2);
    }

    private final boolean zzL(Object obj, Object obj2, int i) {
        return zzN(obj, i) == zzN(obj2, i);
    }

    private static boolean zzM(int i) {
        return (i & 536870912) != 0;
    }

    private final boolean zzN(Object obj, int i) {
        int zzr = zzr(i);
        long j = zzr & 1048575;
        if (j != 1048575) {
            return (zzhcz.zzd(obj, j) & (1 << (zzr >>> 20))) != 0;
        }
        int zzu = zzu(i);
        long j2 = zzu & 1048575;
        switch (zzt(zzu)) {
            case 0:
                return Double.doubleToRawLongBits(zzhcz.zzb(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhcz.zzc(obj, j2)) != 0;
            case 2:
                return zzhcz.zzf(obj, j2) != 0;
            case 3:
                return zzhcz.zzf(obj, j2) != 0;
            case 4:
                return zzhcz.zzd(obj, j2) != 0;
            case 5:
                return zzhcz.zzf(obj, j2) != 0;
            case 6:
                return zzhcz.zzd(obj, j2) != 0;
            case 7:
                return zzhcz.zzz(obj, j2);
            case 8:
                Object zzh = zzhcz.zzh(obj, j2);
                if (zzh instanceof String) {
                    return !((String) zzh).isEmpty();
                }
                if (zzh instanceof zzgyl) {
                    return !zzgyl.zzb.equals(zzh);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhcz.zzh(obj, j2) != null;
            case 10:
                return !zzgyl.zzb.equals(zzhcz.zzh(obj, j2));
            case 11:
                return zzhcz.zzd(obj, j2) != 0;
            case 12:
                return zzhcz.zzd(obj, j2) != 0;
            case 13:
                return zzhcz.zzd(obj, j2) != 0;
            case 14:
                return zzhcz.zzf(obj, j2) != 0;
            case 15:
                return zzhcz.zzd(obj, j2) != 0;
            case 16:
                return zzhcz.zzf(obj, j2) != 0;
            case 17:
                return zzhcz.zzh(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzO(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzN(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzP(Object obj, int i, zzhby zzhbyVar) {
        return zzhbyVar.zzk(zzhcz.zzh(obj, i & 1048575));
    }

    private static boolean zzQ(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzgzu) {
            return ((zzgzu) obj).zzaY();
        }
        return true;
    }

    private final boolean zzR(Object obj, int i, int i2) {
        return zzhcz.zzd(obj, (long) (zzr(i2) & 1048575)) == i;
    }

    private static boolean zzS(Object obj, long j) {
        return ((Boolean) zzhcz.zzh(obj, j)).booleanValue();
    }

    private static final void zzT(int i, Object obj, zzgzb zzgzbVar) throws IOException {
        if (obj instanceof String) {
            zzgzbVar.zzF(i, (String) obj);
        } else {
            zzgzbVar.zzd(i, (zzgyl) obj);
        }
    }

    static zzhcq zzd(Object obj) {
        zzgzu zzgzuVar = (zzgzu) obj;
        zzhcq zzhcqVar = zzgzuVar.zzc;
        if (zzhcqVar != zzhcq.zzc()) {
            return zzhcqVar;
        }
        zzhcq zzf = zzhcq.zzf();
        zzgzuVar.zzc = zzf;
        return zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0268  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzhbh zzl(java.lang.Class r33, com.google.android.gms.internal.ads.zzhbb r34, com.google.android.gms.internal.ads.zzhbj r35, com.google.android.gms.internal.ads.zzhas r36, com.google.android.gms.internal.ads.zzhcp r37, com.google.android.gms.internal.ads.zzgzg r38, com.google.android.gms.internal.ads.zzhaz r39) {
        /*
            Method dump skipped, instructions count: 1030
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhbh.zzl(java.lang.Class, com.google.android.gms.internal.ads.zzhbb, com.google.android.gms.internal.ads.zzhbj, com.google.android.gms.internal.ads.zzhas, com.google.android.gms.internal.ads.zzhcp, com.google.android.gms.internal.ads.zzgzg, com.google.android.gms.internal.ads.zzhaz):com.google.android.gms.internal.ads.zzhbh");
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzhcz.zzh(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzhcz.zzh(obj, j)).floatValue();
    }

    private static int zzp(Object obj, long j) {
        return ((Integer) zzhcz.zzh(obj, j)).intValue();
    }

    private final int zzq(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzs(i, 0);
    }

    private final int zzr(int i) {
        return this.zzc[i + 2];
    }

    private final int zzs(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzt(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzu(int i) {
        return this.zzc[i + 1];
    }

    private static long zzv(Object obj, long j) {
        return ((Long) zzhcz.zzh(obj, j)).longValue();
    }

    private final zzgzy zzw(int i) {
        int i2 = i / 3;
        return (zzgzy) this.zzd[i2 + i2 + 1];
    }

    private final zzhby zzx(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzhby zzhbyVar = (zzhby) objArr[i3];
        if (zzhbyVar != null) {
            return zzhbyVar;
        }
        zzhby zzb2 = zzhbn.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzy(Object obj, int i, Object obj2, zzhcp zzhcpVar, Object obj3) {
        int i2 = this.zzc[i];
        Object zzh = zzhcz.zzh(obj, zzu(i) & 1048575);
        if (zzh == null || zzw(i) == null) {
            return obj2;
        }
        throw null;
    }

    private final Object zzz(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0055. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v108, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v109, types: [com.google.android.gms.internal.ads.zzham] */
    /* JADX WARN: Type inference failed for: r0v111, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v113, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v130 */
    /* JADX WARN: Type inference failed for: r0v178, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v248, types: [int] */
    /* JADX WARN: Type inference failed for: r0v255, types: [int] */
    /* JADX WARN: Type inference failed for: r0v260 */
    /* JADX WARN: Type inference failed for: r0v261 */
    /* JADX WARN: Type inference failed for: r0v262 */
    /* JADX WARN: Type inference failed for: r0v263 */
    /* JADX WARN: Type inference failed for: r0v264 */
    /* JADX WARN: Type inference failed for: r0v265 */
    /* JADX WARN: Type inference failed for: r0v266 */
    /* JADX WARN: Type inference failed for: r0v267 */
    /* JADX WARN: Type inference failed for: r0v268 */
    /* JADX WARN: Type inference failed for: r0v269 */
    /* JADX WARN: Type inference failed for: r0v270 */
    /* JADX WARN: Type inference failed for: r0v271 */
    /* JADX WARN: Type inference failed for: r0v272 */
    /* JADX WARN: Type inference failed for: r0v273 */
    /* JADX WARN: Type inference failed for: r0v274 */
    /* JADX WARN: Type inference failed for: r0v275 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v112, types: [int] */
    /* JADX WARN: Type inference failed for: r1v115, types: [int] */
    /* JADX WARN: Type inference failed for: r1v154 */
    /* JADX WARN: Type inference failed for: r1v157 */
    /* JADX WARN: Type inference failed for: r1v158 */
    /* JADX WARN: Type inference failed for: r1v159 */
    /* JADX WARN: Type inference failed for: r1v160 */
    /* JADX WARN: Type inference failed for: r1v72, types: [int] */
    /* JADX WARN: Type inference failed for: r1v74 */
    /* JADX WARN: Type inference failed for: r2v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v36, types: [int] */
    /* JADX WARN: Type inference failed for: r2v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49, types: [int] */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r2v84 */
    /* JADX WARN: Type inference failed for: r2v85 */
    /* JADX WARN: Type inference failed for: r2v86 */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23, types: [int] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26, types: [int] */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v35, types: [int] */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v42, types: [int] */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v50 */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30, types: [int] */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v37, types: [int] */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v41 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.ads.zzhby
    public final int zza(Object obj) {
        int i;
        int i2;
        ?? r5;
        int zzz;
        int zzz2;
        int zzz3;
        int zzA;
        int zzz4;
        int zzz5;
        int zzd;
        int zzz6;
        ?? zzg;
        int size;
        int zzz7;
        int zzy;
        int zzy2;
        ?? r3;
        int zzx;
        ?? r1;
        ?? r0;
        int zze;
        int zzz8;
        int zzz9;
        ?? r4;
        Unsafe unsafe = zzb;
        boolean z = false;
        int i3 = 1048575;
        ?? r12 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i4 < this.zzc.length) {
            int zzu = zzu(i4);
            int zzt = zzt(zzu);
            int[] iArr = this.zzc;
            int i7 = iArr[i4];
            int i8 = iArr[i4 + 2];
            int i9 = i8 & i3;
            if (zzt <= 17) {
                if (i9 != i6) {
                    r12 = i9 == i3 ? z : unsafe.getInt(obj, i9);
                    i6 = i9;
                }
                i = i6;
                i2 = r12;
                r5 = 1 << (i8 >>> 20);
            } else {
                i = i6;
                i2 = r12;
                r5 = z;
            }
            int i10 = zzu & i3;
            if (zzt >= zzgzl.DOUBLE_LIST_PACKED.zza()) {
                zzgzl.SINT64_LIST_PACKED.zza();
            }
            long j = i10;
            switch (zzt) {
                case 0:
                    if (zzO(obj, i4, i, i2, r5)) {
                        zzz = zzgza.zzz(i7 << 3);
                        r0 = zzz + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 1:
                    if (zzO(obj, i4, i, i2, r5)) {
                        zzz2 = zzgza.zzz(i7 << 3);
                        r0 = zzz2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 2:
                    if (zzO(obj, i4, i, i2, r5)) {
                        long j2 = unsafe.getLong(obj, j);
                        zzz3 = zzgza.zzz(i7 << 3);
                        zzA = zzgza.zzA(j2);
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 3:
                    if (zzO(obj, i4, i, i2, r5)) {
                        long j3 = unsafe.getLong(obj, j);
                        zzz3 = zzgza.zzz(i7 << 3);
                        zzA = zzgza.zzA(j3);
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 4:
                    if (zzO(obj, i4, i, i2, r5)) {
                        long j4 = unsafe.getInt(obj, j);
                        zzz3 = zzgza.zzz(i7 << 3);
                        zzA = zzgza.zzA(j4);
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 5:
                    if (zzO(obj, i4, i, i2, r5)) {
                        zzz = zzgza.zzz(i7 << 3);
                        r0 = zzz + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 6:
                    if (zzO(obj, i4, i, i2, r5)) {
                        zzz2 = zzgza.zzz(i7 << 3);
                        r0 = zzz2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 7:
                    if (zzO(obj, i4, i, i2, r5)) {
                        zzz4 = zzgza.zzz(i7 << 3);
                        r0 = zzz4 + 1;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 8:
                    if (zzO(obj, i4, i, i2, r5)) {
                        int i11 = i7 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzgyl) {
                            zzz5 = zzgza.zzz(i11);
                            zzd = ((zzgyl) object).zzd();
                            zzz6 = zzgza.zzz(zzd);
                            r0 = zzz5 + zzz6 + zzd;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            zzz3 = zzgza.zzz(i11);
                            zzA = zzgza.zzy((String) object);
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 9:
                    if (zzO(obj, i4, i, i2, r5)) {
                        r0 = zzhca.zzh(i7, unsafe.getObject(obj, j), zzx(i4));
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 10:
                    if (zzO(obj, i4, i, i2, r5)) {
                        zzgyl zzgylVar = (zzgyl) unsafe.getObject(obj, j);
                        zzz5 = zzgza.zzz(i7 << 3);
                        zzd = zzgylVar.zzd();
                        zzz6 = zzgza.zzz(zzd);
                        r0 = zzz5 + zzz6 + zzd;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 11:
                    if (zzO(obj, i4, i, i2, r5)) {
                        int i12 = unsafe.getInt(obj, j);
                        zzz3 = zzgza.zzz(i7 << 3);
                        zzA = zzgza.zzz(i12);
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 12:
                    if (zzO(obj, i4, i, i2, r5)) {
                        long j5 = unsafe.getInt(obj, j);
                        zzz3 = zzgza.zzz(i7 << 3);
                        zzA = zzgza.zzA(j5);
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 13:
                    if (zzO(obj, i4, i, i2, r5)) {
                        zzz2 = zzgza.zzz(i7 << 3);
                        r0 = zzz2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 14:
                    if (zzO(obj, i4, i, i2, r5)) {
                        zzz = zzgza.zzz(i7 << 3);
                        r0 = zzz + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 15:
                    if (zzO(obj, i4, i, i2, r5)) {
                        int i13 = unsafe.getInt(obj, j);
                        zzz3 = zzgza.zzz(i7 << 3);
                        zzA = zzgza.zzz((i13 >> 31) ^ (i13 + i13));
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 16:
                    if (zzO(obj, i4, i, i2, r5)) {
                        long j6 = unsafe.getLong(obj, j);
                        zzz3 = zzgza.zzz(i7 << 3);
                        zzA = zzgza.zzA((j6 >> 63) ^ (j6 + j6));
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 17:
                    if (zzO(obj, i4, i, i2, r5)) {
                        r0 = zzgza.zzw(i7, (zzhbe) unsafe.getObject(obj, j), zzx(i4));
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 18:
                    r0 = zzhca.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 19:
                    r0 = zzhca.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i14 = zzhca.zza;
                    if (list.size() != 0) {
                        zzg = zzhca.zzg(list) + (list.size() * zzgza.zzz(i7 << 3));
                        i5 += zzg;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    zzg = z;
                    i5 += zzg;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i15 = zzhca.zza;
                    size = list2.size();
                    if (size != 0) {
                        zzz3 = zzhca.zzl(list2);
                        zzz7 = zzgza.zzz(i7 << 3);
                        zzA = size * zzz7;
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i16 = zzhca.zza;
                    size = list3.size();
                    if (size != 0) {
                        zzz3 = zzhca.zzf(list3);
                        zzz7 = zzgza.zzz(i7 << 3);
                        zzA = size * zzz7;
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 23:
                    r0 = zzhca.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 24:
                    r0 = zzhca.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i17 = zzhca.zza;
                    int size2 = list4.size();
                    if (size2 != 0) {
                        r0 = size2 * (zzgza.zzz(i7 << 3) + 1);
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 26:
                    ?? r02 = (List) unsafe.getObject(obj, j);
                    int i18 = zzhca.zza;
                    int size3 = r02.size();
                    if (size3 != 0) {
                        int zzz10 = zzgza.zzz(i7 << 3) * size3;
                        if (r02 instanceof zzham) {
                            ?? r03 = (zzham) r02;
                            zzg = zzz10;
                            for (?? r32 = z; r32 < size3; r32++) {
                                Object zzf = r03.zzf(r32);
                                if (zzf instanceof zzgyl) {
                                    int zzd2 = ((zzgyl) zzf).zzd();
                                    zzy2 = zzg + zzgza.zzz(zzd2) + zzd2;
                                } else {
                                    zzy2 = zzg + zzgza.zzy((String) zzf);
                                }
                                zzg = zzy2;
                            }
                        } else {
                            zzg = zzz10;
                            for (?? r33 = z; r33 < size3; r33++) {
                                Object obj2 = r02.get(r33);
                                if (obj2 instanceof zzgyl) {
                                    int zzd3 = ((zzgyl) obj2).zzd();
                                    zzy = zzg + zzgza.zzz(zzd3) + zzd3;
                                } else {
                                    zzy = zzg + zzgza.zzy((String) obj2);
                                }
                                zzg = zzy;
                            }
                        }
                        i5 += zzg;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    zzg = z;
                    i5 += zzg;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 27:
                    ?? r04 = (List) unsafe.getObject(obj, j);
                    zzhby zzx2 = zzx(i4);
                    int i19 = zzhca.zza;
                    int size4 = r04.size();
                    if (size4 == 0) {
                        r3 = z;
                    } else {
                        r3 = zzgza.zzz(i7 << 3) * size4;
                        for (?? r42 = z; r42 < size4; r42++) {
                            Object obj3 = r04.get(r42);
                            if (obj3 instanceof zzhak) {
                                int zza2 = ((zzhak) obj3).zza();
                                zzx = (r3 == true ? 1 : 0) + zzgza.zzz(zza2) + zza2;
                            } else {
                                zzx = (r3 == true ? 1 : 0) + zzgza.zzx((zzhbe) obj3, zzx2);
                            }
                            r3 = zzx;
                        }
                    }
                    i5 += r3;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 28:
                    ?? r05 = (List) unsafe.getObject(obj, j);
                    int i20 = zzhca.zza;
                    int size5 = r05.size();
                    if (size5 == 0) {
                        r1 = z;
                    } else {
                        r1 = size5 * zzgza.zzz(i7 << 3);
                        for (?? r2 = z; r2 < r05.size(); r2++) {
                            int zzd4 = ((zzgyl) r05.get(r2)).zzd();
                            r1 += zzgza.zzz(zzd4) + zzd4;
                        }
                    }
                    i5 += r1;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i21 = zzhca.zza;
                    size = list5.size();
                    if (size != 0) {
                        zzz3 = zzhca.zzk(list5);
                        zzz7 = zzgza.zzz(i7 << 3);
                        zzA = size * zzz7;
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 30:
                    List list6 = (List) unsafe.getObject(obj, j);
                    int i22 = zzhca.zza;
                    size = list6.size();
                    if (size != 0) {
                        zzz3 = zzhca.zza(list6);
                        zzz7 = zzgza.zzz(i7 << 3);
                        zzA = size * zzz7;
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 31:
                    r0 = zzhca.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 32:
                    r0 = zzhca.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 33:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i23 = zzhca.zza;
                    size = list7.size();
                    if (size != 0) {
                        zzz3 = zzhca.zzi(list7);
                        zzz7 = zzgza.zzz(i7 << 3);
                        zzA = size * zzz7;
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 34:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i24 = zzhca.zza;
                    size = list8.size();
                    if (size != 0) {
                        zzz3 = zzhca.zzj(list8);
                        zzz7 = zzgza.zzz(i7 << 3);
                        zzA = size * zzz7;
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 35:
                    zze = zzhca.zze((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgza.zzz(i7 << 3);
                        zzz9 = zzgza.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 36:
                    zze = zzhca.zzc((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgza.zzz(i7 << 3);
                        zzz9 = zzgza.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 37:
                    zze = zzhca.zzg((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgza.zzz(i7 << 3);
                        zzz9 = zzgza.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 38:
                    zze = zzhca.zzl((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgza.zzz(i7 << 3);
                        zzz9 = zzgza.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 39:
                    zze = zzhca.zzf((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgza.zzz(i7 << 3);
                        zzz9 = zzgza.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 40:
                    zze = zzhca.zze((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgza.zzz(i7 << 3);
                        zzz9 = zzgza.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 41:
                    zze = zzhca.zzc((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgza.zzz(i7 << 3);
                        zzz9 = zzgza.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 42:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i25 = zzhca.zza;
                    zze = list9.size();
                    if (zze > 0) {
                        zzz8 = zzgza.zzz(i7 << 3);
                        zzz9 = zzgza.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 43:
                    zze = zzhca.zzk((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgza.zzz(i7 << 3);
                        zzz9 = zzgza.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 44:
                    zze = zzhca.zza((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgza.zzz(i7 << 3);
                        zzz9 = zzgza.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 45:
                    zze = zzhca.zzc((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgza.zzz(i7 << 3);
                        zzz9 = zzgza.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 46:
                    zze = zzhca.zze((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgza.zzz(i7 << 3);
                        zzz9 = zzgza.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 47:
                    zze = zzhca.zzi((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgza.zzz(i7 << 3);
                        zzz9 = zzgza.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    zze = zzhca.zzj((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgza.zzz(i7 << 3);
                        zzz9 = zzgza.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    ?? r06 = (List) unsafe.getObject(obj, j);
                    zzhby zzx3 = zzx(i4);
                    int i26 = zzhca.zza;
                    int size6 = r06.size();
                    if (size6 == 0) {
                        r4 = z;
                    } else {
                        boolean z2 = z;
                        r4 = z2;
                        ?? r34 = z2;
                        while (r34 < size6) {
                            int zzw = zzgza.zzw(i7, (zzhbe) r06.get(r34), zzx3);
                            r34++;
                            r4 = (r4 == true ? 1 : 0) + zzw;
                        }
                    }
                    i5 += r4;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 50:
                    zzhay zzhayVar = (zzhay) unsafe.getObject(obj, j);
                    if (zzhayVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzhayVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzR(obj, i7, i4)) {
                        zzz = zzgza.zzz(i7 << 3);
                        r0 = zzz + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 52:
                    if (zzR(obj, i7, i4)) {
                        zzz2 = zzgza.zzz(i7 << 3);
                        r0 = zzz2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 53:
                    if (zzR(obj, i7, i4)) {
                        long zzv = zzv(obj, j);
                        zzz3 = zzgza.zzz(i7 << 3);
                        zzA = zzgza.zzA(zzv);
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 54:
                    if (zzR(obj, i7, i4)) {
                        long zzv2 = zzv(obj, j);
                        zzz3 = zzgza.zzz(i7 << 3);
                        zzA = zzgza.zzA(zzv2);
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 55:
                    if (zzR(obj, i7, i4)) {
                        long zzp = zzp(obj, j);
                        zzz3 = zzgza.zzz(i7 << 3);
                        zzA = zzgza.zzA(zzp);
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 56:
                    if (zzR(obj, i7, i4)) {
                        zzz = zzgza.zzz(i7 << 3);
                        r0 = zzz + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 57:
                    if (zzR(obj, i7, i4)) {
                        zzz2 = zzgza.zzz(i7 << 3);
                        r0 = zzz2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 58:
                    if (zzR(obj, i7, i4)) {
                        zzz4 = zzgza.zzz(i7 << 3);
                        r0 = zzz4 + 1;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 59:
                    if (zzR(obj, i7, i4)) {
                        int i27 = i7 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzgyl) {
                            zzz5 = zzgza.zzz(i27);
                            zzd = ((zzgyl) object2).zzd();
                            zzz6 = zzgza.zzz(zzd);
                            r0 = zzz5 + zzz6 + zzd;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            zzz3 = zzgza.zzz(i27);
                            zzA = zzgza.zzy((String) object2);
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzR(obj, i7, i4)) {
                        r0 = zzhca.zzh(i7, unsafe.getObject(obj, j), zzx(i4));
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzR(obj, i7, i4)) {
                        zzgyl zzgylVar2 = (zzgyl) unsafe.getObject(obj, j);
                        zzz5 = zzgza.zzz(i7 << 3);
                        zzd = zzgylVar2.zzd();
                        zzz6 = zzgza.zzz(zzd);
                        r0 = zzz5 + zzz6 + zzd;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 62:
                    if (zzR(obj, i7, i4)) {
                        int zzp2 = zzp(obj, j);
                        zzz3 = zzgza.zzz(i7 << 3);
                        zzA = zzgza.zzz(zzp2);
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 63:
                    if (zzR(obj, i7, i4)) {
                        long zzp3 = zzp(obj, j);
                        zzz3 = zzgza.zzz(i7 << 3);
                        zzA = zzgza.zzA(zzp3);
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 64:
                    if (zzR(obj, i7, i4)) {
                        zzz2 = zzgza.zzz(i7 << 3);
                        r0 = zzz2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 65:
                    if (zzR(obj, i7, i4)) {
                        zzz = zzgza.zzz(i7 << 3);
                        r0 = zzz + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 66:
                    if (zzR(obj, i7, i4)) {
                        int zzp4 = zzp(obj, j);
                        zzz3 = zzgza.zzz(i7 << 3);
                        zzA = zzgza.zzz((zzp4 >> 31) ^ (zzp4 + zzp4));
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 67:
                    if (zzR(obj, i7, i4)) {
                        long zzv3 = zzv(obj, j);
                        zzz3 = zzgza.zzz(i7 << 3);
                        zzA = zzgza.zzA((zzv3 >> 63) ^ (zzv3 + zzv3));
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 68:
                    if (zzR(obj, i7, i4)) {
                        r0 = zzgza.zzw(i7, (zzhbe) unsafe.getObject(obj, j), zzx(i4));
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                default:
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
            }
        }
        zzhcp zzhcpVar = this.zzn;
        int zza3 = i5 + zzhcpVar.zza(zzhcpVar.zzd(obj));
        if (!this.zzh) {
            return zza3;
        }
        this.zzo.zza(obj);
        throw null;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001c. Please report as an issue. */
    @Override // com.google.android.gms.internal.ads.zzhby
    public final int zzb(Object obj) {
        int i;
        long doubleToLongBits;
        int floatToIntBits;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int zzu = zzu(i4);
            int[] iArr = this.zzc;
            int i5 = 1048575 & zzu;
            int zzt = zzt(zzu);
            int i6 = iArr[i4];
            long j = i5;
            int i7 = 37;
            switch (zzt) {
                case 0:
                    i = i3 * 53;
                    doubleToLongBits = Double.doubleToLongBits(zzhcz.zzb(obj, j));
                    byte[] bArr = zzhae.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 1:
                    i = i3 * 53;
                    floatToIntBits = Float.floatToIntBits(zzhcz.zzc(obj, j));
                    i3 = i + floatToIntBits;
                    break;
                case 2:
                    i = i3 * 53;
                    doubleToLongBits = zzhcz.zzf(obj, j);
                    byte[] bArr2 = zzhae.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 3:
                    i = i3 * 53;
                    doubleToLongBits = zzhcz.zzf(obj, j);
                    byte[] bArr3 = zzhae.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 4:
                    i = i3 * 53;
                    floatToIntBits = zzhcz.zzd(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 5:
                    i = i3 * 53;
                    doubleToLongBits = zzhcz.zzf(obj, j);
                    byte[] bArr4 = zzhae.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 6:
                    i = i3 * 53;
                    floatToIntBits = zzhcz.zzd(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 7:
                    i = i3 * 53;
                    floatToIntBits = zzhae.zza(zzhcz.zzz(obj, j));
                    i3 = i + floatToIntBits;
                    break;
                case 8:
                    i = i3 * 53;
                    floatToIntBits = ((String) zzhcz.zzh(obj, j)).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 9:
                    i2 = i3 * 53;
                    Object zzh = zzhcz.zzh(obj, j);
                    if (zzh != null) {
                        i7 = zzh.hashCode();
                    }
                    i3 = i2 + i7;
                    break;
                case 10:
                    i = i3 * 53;
                    floatToIntBits = zzhcz.zzh(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 11:
                    i = i3 * 53;
                    floatToIntBits = zzhcz.zzd(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 12:
                    i = i3 * 53;
                    floatToIntBits = zzhcz.zzd(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 13:
                    i = i3 * 53;
                    floatToIntBits = zzhcz.zzd(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 14:
                    i = i3 * 53;
                    doubleToLongBits = zzhcz.zzf(obj, j);
                    byte[] bArr5 = zzhae.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 15:
                    i = i3 * 53;
                    floatToIntBits = zzhcz.zzd(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 16:
                    i = i3 * 53;
                    doubleToLongBits = zzhcz.zzf(obj, j);
                    byte[] bArr6 = zzhae.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 17:
                    i2 = i3 * 53;
                    Object zzh2 = zzhcz.zzh(obj, j);
                    if (zzh2 != null) {
                        i7 = zzh2.hashCode();
                    }
                    i3 = i2 + i7;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    i = i3 * 53;
                    floatToIntBits = zzhcz.zzh(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 50:
                    i = i3 * 53;
                    floatToIntBits = zzhcz.zzh(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzn(obj, j));
                        byte[] bArr7 = zzhae.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = Float.floatToIntBits(zzo(obj, j));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzv(obj, j);
                        byte[] bArr8 = zzhae.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzv(obj, j);
                        byte[] bArr9 = zzhae.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzp(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzv(obj, j);
                        byte[] bArr10 = zzhae.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzp(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzhae.zza(zzS(obj, j));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = ((String) zzhcz.zzh(obj, j)).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzhcz.zzh(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzhcz.zzh(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzp(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzp(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzp(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzv(obj, j);
                        byte[] bArr11 = zzhae.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzp(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzv(obj, j);
                        byte[] bArr12 = zzhae.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzhcz.zzh(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.zzn.zzd(obj).hashCode();
        if (!this.zzh) {
            return hashCode;
        }
        this.zzo.zza(obj);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0b68, code lost:
    
        if (r5 == r0) goto L486;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0b6a, code lost:
    
        r14.putInt(r7, r5, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0b6e, code lost:
    
        r11 = r12.zzk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0b73, code lost:
    
        if (r11 >= r12.zzl) goto L592;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0b75, code lost:
    
        zzy(r34, r12.zzj[r11], null, r12.zzn, r34);
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0b88, code lost:
    
        if (r9 != 0) goto L495;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0b8a, code lost:
    
        if (r6 != r10) goto L493;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0b91, code lost:
    
        throw com.google.android.gms.internal.ads.zzhag.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0b96, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0b92, code lost:
    
        if (r6 > r10) goto L498;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0b94, code lost:
    
        if (r8 != r9) goto L498;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0b9b, code lost:
    
        throw com.google.android.gms.internal.ads.zzhag.zzg();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:157:0x0383. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x08a2. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:497:0x00ac. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0836 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0847 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0ae3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0af6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzc(java.lang.Object r34, byte[] r35, int r36, int r37, int r38, com.google.android.gms.internal.ads.zzgxx r39) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3116
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhbh.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.zzgxx):int");
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final Object zze() {
        return ((zzgzu) this.zzg).zzaD();
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzf(Object obj) {
        if (zzQ(obj)) {
            if (obj instanceof zzgzu) {
                zzgzu zzgzuVar = (zzgzu) obj;
                zzgzuVar.zzaV(Integer.MAX_VALUE);
                zzgzuVar.zza = 0;
                zzgzuVar.zzaT();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int zzu = zzu(i);
                int i2 = 1048575 & zzu;
                int zzt = zzt(zzu);
                long j = i2;
                if (zzt != 9) {
                    if (zzt == 60 || zzt == 68) {
                        if (zzR(obj, this.zzc[i], i)) {
                            zzx(i).zzf(zzb.getObject(obj, j));
                        }
                    } else {
                        switch (zzt) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                this.zzm.zzb(obj, j);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzhay) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                }
                if (zzN(obj, i)) {
                    zzx(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzn.zzm(obj);
            if (this.zzh) {
                this.zzo.zze(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzg(Object obj, Object obj2) {
        zzD(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzu = zzu(i);
            int i2 = 1048575 & zzu;
            int[] iArr = this.zzc;
            int zzt = zzt(zzu);
            int i3 = iArr[i];
            long j = i2;
            switch (zzt) {
                case 0:
                    if (zzN(obj2, i)) {
                        zzhcz.zzr(obj, j, zzhcz.zzb(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzN(obj2, i)) {
                        zzhcz.zzs(obj, j, zzhcz.zzc(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzN(obj2, i)) {
                        zzhcz.zzu(obj, j, zzhcz.zzf(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzN(obj2, i)) {
                        zzhcz.zzu(obj, j, zzhcz.zzf(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzN(obj2, i)) {
                        zzhcz.zzt(obj, j, zzhcz.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzN(obj2, i)) {
                        zzhcz.zzu(obj, j, zzhcz.zzf(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzN(obj2, i)) {
                        zzhcz.zzt(obj, j, zzhcz.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzN(obj2, i)) {
                        zzhcz.zzp(obj, j, zzhcz.zzz(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzN(obj2, i)) {
                        zzhcz.zzv(obj, j, zzhcz.zzh(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzE(obj, obj2, i);
                    break;
                case 10:
                    if (zzN(obj2, i)) {
                        zzhcz.zzv(obj, j, zzhcz.zzh(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzN(obj2, i)) {
                        zzhcz.zzt(obj, j, zzhcz.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzN(obj2, i)) {
                        zzhcz.zzt(obj, j, zzhcz.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzN(obj2, i)) {
                        zzhcz.zzt(obj, j, zzhcz.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzN(obj2, i)) {
                        zzhcz.zzu(obj, j, zzhcz.zzf(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzN(obj2, i)) {
                        zzhcz.zzt(obj, j, zzhcz.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzN(obj2, i)) {
                        zzhcz.zzu(obj, j, zzhcz.zzf(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzE(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    this.zzm.zzc(obj, obj2, j);
                    break;
                case 50:
                    int i4 = zzhca.zza;
                    zzhcz.zzv(obj, j, zzhaz.zzb(zzhcz.zzh(obj, j), zzhcz.zzh(obj2, j)));
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzR(obj2, i3, i)) {
                        zzhcz.zzv(obj, j, zzhcz.zzh(obj2, j));
                        zzI(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    zzF(obj, obj2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzR(obj2, i3, i)) {
                        zzhcz.zzv(obj, j, zzhcz.zzh(obj2, j));
                        zzI(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzF(obj, obj2, i);
                    break;
            }
        }
        zzhca.zzq(this.zzn, obj, obj2);
        if (this.zzh) {
            this.zzo.zza(obj2);
            throw null;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x00bb. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0636  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0649 A[LOOP:2: B:38:0x0645->B:40:0x0649, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x065d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0611 A[Catch: all -> 0x0606, TryCatch #4 {all -> 0x0606, blocks: (B:17:0x05e5, B:46:0x060c, B:48:0x0611, B:49:0x0616), top: B:16:0x05e5 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x061c A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhby
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzh(java.lang.Object r18, com.google.android.gms.internal.ads.zzhbq r19, com.google.android.gms.internal.ads.zzgzf r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1776
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhbh.zzh(java.lang.Object, com.google.android.gms.internal.ads.zzhbq, com.google.android.gms.internal.ads.zzgzf):void");
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzgxx zzgxxVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzgxxVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01c3 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhby
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzj(java.lang.Object r8, java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 634
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhbh.zzj(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i4 < this.zzk) {
            int[] iArr = this.zzj;
            int[] iArr2 = this.zzc;
            int i6 = iArr[i4];
            int i7 = iArr2[i6];
            int zzu = zzu(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i5) {
                if (i9 != 1048575) {
                    i3 = zzb.getInt(obj, i9);
                }
                i2 = i3;
                i = i9;
            } else {
                i = i5;
                i2 = i3;
            }
            if ((268435456 & zzu) != 0 && !zzO(obj, i6, i, i2, i10)) {
                return false;
            }
            int zzt = zzt(zzu);
            if (zzt != 9 && zzt != 17) {
                if (zzt != 27) {
                    if (zzt == 60 || zzt == 68) {
                        if (zzR(obj, i7, i6) && !zzP(obj, zzu, zzx(i6))) {
                            return false;
                        }
                    } else if (zzt != 49) {
                        if (zzt == 50 && !((zzhay) zzhcz.zzh(obj, zzu & 1048575)).isEmpty()) {
                            throw null;
                        }
                    }
                }
                List list = (List) zzhcz.zzh(obj, zzu & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzhby zzx = zzx(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzx.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                }
            } else if (zzO(obj, i6, i, i2, i10) && !zzP(obj, zzu, zzx(i6))) {
                return false;
            }
            i4++;
            i5 = i;
            i3 = i2;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzm(Object obj, zzgzb zzgzbVar) throws IOException {
        int i;
        int i2;
        int i3;
        if (!this.zzh) {
            int[] iArr = this.zzc;
            Unsafe unsafe = zzb;
            int i4 = 1048575;
            int i5 = 1048575;
            int i6 = 0;
            int i7 = 0;
            while (i7 < iArr.length) {
                int zzu = zzu(i7);
                int[] iArr2 = this.zzc;
                int zzt = zzt(zzu);
                int i8 = iArr2[i7];
                if (zzt <= 17) {
                    int i9 = iArr2[i7 + 2];
                    int i10 = i9 & i4;
                    if (i10 != i5) {
                        i6 = i10 == i4 ? 0 : unsafe.getInt(obj, i10);
                        i5 = i10;
                    }
                    i = i5;
                    i2 = i6;
                    i3 = 1 << (i9 >>> 20);
                } else {
                    i = i5;
                    i2 = i6;
                    i3 = 0;
                }
                long j = zzu & i4;
                switch (zzt) {
                    case 0:
                        if (zzO(obj, i7, i, i2, i3)) {
                            zzgzbVar.zzf(i8, zzhcz.zzb(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zzO(obj, i7, i, i2, i3)) {
                            zzgzbVar.zzo(i8, zzhcz.zzc(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zzO(obj, i7, i, i2, i3)) {
                            zzgzbVar.zzt(i8, unsafe.getLong(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zzO(obj, i7, i, i2, i3)) {
                            zzgzbVar.zzJ(i8, unsafe.getLong(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zzO(obj, i7, i, i2, i3)) {
                            zzgzbVar.zzr(i8, unsafe.getInt(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zzO(obj, i7, i, i2, i3)) {
                            zzgzbVar.zzm(i8, unsafe.getLong(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zzO(obj, i7, i, i2, i3)) {
                            zzgzbVar.zzk(i8, unsafe.getInt(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zzO(obj, i7, i, i2, i3)) {
                            zzgzbVar.zzb(i8, zzhcz.zzz(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zzO(obj, i7, i, i2, i3)) {
                            zzT(i8, unsafe.getObject(obj, j), zzgzbVar);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zzO(obj, i7, i, i2, i3)) {
                            zzgzbVar.zzv(i8, unsafe.getObject(obj, j), zzx(i7));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zzO(obj, i7, i, i2, i3)) {
                            zzgzbVar.zzd(i8, (zzgyl) unsafe.getObject(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zzO(obj, i7, i, i2, i3)) {
                            zzgzbVar.zzH(i8, unsafe.getInt(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zzO(obj, i7, i, i2, i3)) {
                            zzgzbVar.zzi(i8, unsafe.getInt(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zzO(obj, i7, i, i2, i3)) {
                            zzgzbVar.zzw(i8, unsafe.getInt(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zzO(obj, i7, i, i2, i3)) {
                            zzgzbVar.zzy(i8, unsafe.getLong(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zzO(obj, i7, i, i2, i3)) {
                            zzgzbVar.zzA(i8, unsafe.getInt(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zzO(obj, i7, i, i2, i3)) {
                            zzgzbVar.zzC(i8, unsafe.getLong(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zzO(obj, i7, i, i2, i3)) {
                            zzgzbVar.zzq(i8, unsafe.getObject(obj, j), zzx(i7));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzhca.zzu(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                        break;
                    case 19:
                        zzhca.zzy(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                        break;
                    case 20:
                        zzhca.zzA(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                        break;
                    case 21:
                        zzhca.zzG(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                        break;
                    case 22:
                        zzhca.zzz(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                        break;
                    case 23:
                        zzhca.zzx(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                        break;
                    case 24:
                        zzhca.zzw(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                        break;
                    case 25:
                        zzhca.zzt(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                        break;
                    case 26:
                        int i11 = this.zzc[i7];
                        List list = (List) unsafe.getObject(obj, j);
                        int i12 = zzhca.zza;
                        if (list != null && !list.isEmpty()) {
                            zzgzbVar.zzG(i11, list);
                            break;
                        }
                        break;
                    case 27:
                        int i13 = this.zzc[i7];
                        List list2 = (List) unsafe.getObject(obj, j);
                        zzhby zzx = zzx(i7);
                        int i14 = zzhca.zza;
                        if (list2 != null && !list2.isEmpty()) {
                            for (int i15 = 0; i15 < list2.size(); i15++) {
                                zzgzbVar.zzv(i13, list2.get(i15), zzx);
                            }
                            break;
                        }
                        break;
                    case 28:
                        int i16 = this.zzc[i7];
                        List list3 = (List) unsafe.getObject(obj, j);
                        int i17 = zzhca.zza;
                        if (list3 != null && !list3.isEmpty()) {
                            zzgzbVar.zze(i16, list3);
                            break;
                        }
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                        zzhca.zzF(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                        break;
                    case 30:
                        zzhca.zzv(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                        break;
                    case 31:
                        zzhca.zzB(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                        break;
                    case 32:
                        zzhca.zzC(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                        break;
                    case 33:
                        zzhca.zzD(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                        break;
                    case 34:
                        zzhca.zzE(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                        break;
                    case 35:
                        zzhca.zzu(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                        break;
                    case 36:
                        zzhca.zzy(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                        break;
                    case 37:
                        zzhca.zzA(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                        break;
                    case 38:
                        zzhca.zzG(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                        break;
                    case 39:
                        zzhca.zzz(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                        break;
                    case 40:
                        zzhca.zzx(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                        break;
                    case 41:
                        zzhca.zzw(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                        break;
                    case 42:
                        zzhca.zzt(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                        break;
                    case 43:
                        zzhca.zzF(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                        break;
                    case 44:
                        zzhca.zzv(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                        break;
                    case 45:
                        zzhca.zzB(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                        break;
                    case 46:
                        zzhca.zzC(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                        break;
                    case 47:
                        zzhca.zzD(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                        zzhca.zzE(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                        int i18 = this.zzc[i7];
                        List list4 = (List) unsafe.getObject(obj, j);
                        zzhby zzx2 = zzx(i7);
                        int i19 = zzhca.zza;
                        if (list4 != null && !list4.isEmpty()) {
                            for (int i20 = 0; i20 < list4.size(); i20++) {
                                zzgzbVar.zzq(i18, list4.get(i20), zzx2);
                            }
                            break;
                        }
                        break;
                    case 50:
                        if (unsafe.getObject(obj, j) != null) {
                            throw null;
                        }
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                        if (zzR(obj, i8, i7)) {
                            zzgzbVar.zzf(i8, zzn(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zzR(obj, i8, i7)) {
                            zzgzbVar.zzo(i8, zzo(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zzR(obj, i8, i7)) {
                            zzgzbVar.zzt(i8, zzv(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zzR(obj, i8, i7)) {
                            zzgzbVar.zzJ(i8, zzv(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zzR(obj, i8, i7)) {
                            zzgzbVar.zzr(i8, zzp(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zzR(obj, i8, i7)) {
                            zzgzbVar.zzm(i8, zzv(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zzR(obj, i8, i7)) {
                            zzgzbVar.zzk(i8, zzp(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zzR(obj, i8, i7)) {
                            zzgzbVar.zzb(i8, zzS(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zzR(obj, i8, i7)) {
                            zzT(i8, unsafe.getObject(obj, j), zzgzbVar);
                            break;
                        } else {
                            break;
                        }
                    case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                        if (zzR(obj, i8, i7)) {
                            zzgzbVar.zzv(i8, unsafe.getObject(obj, j), zzx(i7));
                            break;
                        } else {
                            break;
                        }
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                        if (zzR(obj, i8, i7)) {
                            zzgzbVar.zzd(i8, (zzgyl) unsafe.getObject(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zzR(obj, i8, i7)) {
                            zzgzbVar.zzH(i8, zzp(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zzR(obj, i8, i7)) {
                            zzgzbVar.zzi(i8, zzp(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zzR(obj, i8, i7)) {
                            zzgzbVar.zzw(i8, zzp(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zzR(obj, i8, i7)) {
                            zzgzbVar.zzy(i8, zzv(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zzR(obj, i8, i7)) {
                            zzgzbVar.zzA(i8, zzp(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zzR(obj, i8, i7)) {
                            zzgzbVar.zzC(i8, zzv(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zzR(obj, i8, i7)) {
                            zzgzbVar.zzq(i8, unsafe.getObject(obj, j), zzx(i7));
                            break;
                        } else {
                            break;
                        }
                }
                i7 += 3;
                i5 = i;
                i6 = i2;
                i4 = 1048575;
            }
            zzhcp zzhcpVar = this.zzn;
            zzhcpVar.zzr(zzhcpVar.zzd(obj), zzgzbVar);
            return;
        }
        this.zzo.zza(obj);
        throw null;
    }
}

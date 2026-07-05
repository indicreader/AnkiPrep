package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzwz extends zzxb {
    private final zzyw zzd;
    private final zzgaa zze;
    private final zzel zzf;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzwz(zzcz zzczVar, int[] iArr, int i, zzyw zzywVar, long j, long j2, long j3, int i2, int i3, float f, float f2, List list, zzel zzelVar) {
        super(zzczVar, iArr, 0);
        this.zzd = zzywVar;
        this.zze = zzgaa.zzj(list);
        this.zzf = zzelVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* bridge */ /* synthetic */ zzgaa zzf(zzyh[] zzyhVarArr) {
        int i;
        int i2;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = 2;
            i2 = 1;
            if (i4 >= 2) {
                break;
            }
            zzyh zzyhVar = zzyhVarArr[i4];
            if (zzyhVar == null || zzyhVar.zzb.length <= 1) {
                arrayList.add(null);
            } else {
                zzfzx zzfzxVar = new zzfzx();
                zzfzxVar.zzf(new zzwx(0L, 0L));
                arrayList.add(zzfzxVar);
            }
            i4++;
        }
        long[][] jArr = new long[2];
        for (int i5 = 0; i5 < 2; i5++) {
            zzyh zzyhVar2 = zzyhVarArr[i5];
            if (zzyhVar2 == null) {
                jArr[i5] = new long[0];
            } else {
                jArr[i5] = new long[zzyhVar2.zzb.length];
                int i6 = 0;
                while (true) {
                    int[] iArr = zzyhVar2.zzb;
                    if (i6 >= iArr.length) {
                        break;
                    }
                    long j = zzyhVar2.zza.zzb(iArr[i6]).zzi;
                    long[] jArr2 = jArr[i5];
                    if (j == -1) {
                        j = 0;
                    }
                    jArr2[i6] = j;
                    i6++;
                }
                Arrays.sort(jArr[i5]);
            }
        }
        int[] iArr2 = new int[2];
        long[] jArr3 = new long[2];
        for (int i7 = 0; i7 < 2; i7++) {
            long[] jArr4 = jArr[i7];
            jArr3[i7] = jArr4.length == 0 ? 0L : jArr4[0];
        }
        zzg(arrayList, jArr3);
        zzgal zza = zzgbe.zzc(zzgbj.zzc()).zzb(2).zza();
        int i8 = 0;
        while (i8 < i) {
            int length = jArr[i8].length;
            if (length > i2) {
                double[] dArr = new double[length];
                int i9 = i3;
                while (true) {
                    long[] jArr5 = jArr[i8];
                    double d = 0.0d;
                    if (i9 >= jArr5.length) {
                        break;
                    }
                    long j2 = jArr5[i9];
                    if (j2 != -1) {
                        d = Math.log(j2);
                    }
                    dArr[i9] = d;
                    i9++;
                }
                int i10 = length - 1;
                double d2 = dArr[i10] - dArr[i3];
                int i11 = i3;
                while (i11 < i10) {
                    double d3 = dArr[i11];
                    i11++;
                    zza.zzq(Double.valueOf(d2 == 0.0d ? 1.0d : (((d3 + dArr[i11]) * 0.5d) - dArr[i3]) / d2), Integer.valueOf(i8));
                    i3 = 0;
                }
            }
            i8++;
            i3 = 0;
            i = 2;
            i2 = 1;
        }
        zzgaa zzj = zzgaa.zzj(zza.zzr());
        for (int i12 = 0; i12 < zzj.size(); i12++) {
            int intValue = ((Integer) zzj.get(i12)).intValue();
            int i13 = iArr2[intValue] + 1;
            iArr2[intValue] = i13;
            jArr3[intValue] = jArr[intValue][i13];
            zzg(arrayList, jArr3);
        }
        for (int i14 = 0; i14 < 2; i14++) {
            if (arrayList.get(i14) != null) {
                long j3 = jArr3[i14];
                jArr3[i14] = j3 + j3;
            }
        }
        zzg(arrayList, jArr3);
        zzfzx zzfzxVar2 = new zzfzx();
        for (int i15 = 0; i15 < arrayList.size(); i15++) {
            zzfzx zzfzxVar3 = (zzfzx) arrayList.get(i15);
            zzfzxVar2.zzf(zzfzxVar3 == null ? zzgaa.zzl() : zzfzxVar3.zzi());
        }
        return zzfzxVar2.zzi();
    }

    private static void zzg(List list, long[] jArr) {
        long j = 0;
        for (int i = 0; i < 2; i++) {
            j += jArr[i];
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzfzx zzfzxVar = (zzfzx) list.get(i2);
            if (zzfzxVar != null) {
                zzfzxVar.zzf(new zzwx(j, jArr[i2]));
            }
        }
    }
}

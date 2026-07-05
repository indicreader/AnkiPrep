package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzyl extends zzyo {
    private zzyk zza;

    protected abstract Pair zzc(zzyk zzykVar, int[][][] iArr, int[] iArr2, zzur zzurVar, zzcx zzcxVar) throws zziz;

    @Override // com.google.android.gms.internal.ads.zzyo
    public final zzyp zzp(zzmh[] zzmhVarArr, zzws zzwsVar, zzur zzurVar, zzcx zzcxVar) throws zziz {
        boolean z;
        int[] iArr;
        int[] iArr2 = new int[3];
        zzcz[][] zzczVarArr = new zzcz[3];
        int[][][] iArr3 = new int[3][];
        for (int i = 0; i < 3; i++) {
            int i2 = zzwsVar.zzc;
            zzczVarArr[i] = new zzcz[i2];
            iArr3[i] = new int[i2];
        }
        int i3 = 2;
        int[] iArr4 = new int[2];
        for (int i4 = 0; i4 < 2; i4++) {
            iArr4[i4] = zzmhVarArr[i4].zze();
        }
        int i5 = 0;
        while (i5 < zzwsVar.zzc) {
            zzcz zzb = zzwsVar.zzb(i5);
            int i6 = zzb.zzd;
            int i7 = i3;
            int i8 = 0;
            int i9 = 0;
            boolean z2 = true;
            while (i8 < i3) {
                zzmh zzmhVar = zzmhVarArr[i8];
                int i10 = 0;
                int i11 = 0;
                while (true) {
                    int i12 = zzb.zzb;
                    if (i10 > 0) {
                        break;
                    }
                    i11 = Math.max(i11, zzmhVar.zzX(zzb.zzb(i10)) & 7);
                    i10++;
                }
                boolean z3 = iArr2[i8] == 0;
                if (i11 > i9) {
                    z2 = z3;
                    i7 = i8;
                    i9 = i11;
                } else if (i11 == i9 && i6 == 5 && !z2 && z3) {
                    i7 = i8;
                    i9 = i11;
                    z2 = true;
                }
                i8++;
                i3 = 2;
            }
            if (i7 == i3) {
                int i13 = zzb.zzb;
                iArr = new int[1];
            } else {
                zzmh zzmhVar2 = zzmhVarArr[i7];
                int i14 = zzb.zzb;
                int[] iArr5 = new int[1];
                int i15 = 0;
                while (true) {
                    int i16 = zzb.zzb;
                    if (i15 > 0) {
                        break;
                    }
                    iArr5[i15] = zzmhVar2.zzX(zzb.zzb(i15));
                    i15++;
                }
                iArr = iArr5;
            }
            int i17 = iArr2[i7];
            zzczVarArr[i7][i17] = zzb;
            iArr3[i7][i17] = iArr;
            iArr2[i7] = i17 + 1;
            i5++;
            i3 = 2;
        }
        zzws[] zzwsVarArr = new zzws[i3];
        String[] strArr = new String[i3];
        int[] iArr6 = new int[i3];
        int i18 = 0;
        while (i18 < i3) {
            int i19 = iArr2[i18];
            zzwsVarArr[i18] = new zzws((zzcz[]) zzfy.zzL(zzczVarArr[i18], i19));
            iArr3[i18] = (int[][]) zzfy.zzL(iArr3[i18], i19);
            strArr[i18] = zzmhVarArr[i18].zzT();
            iArr6[i18] = zzmhVarArr[i18].zzbj();
            i18++;
            i3 = 2;
        }
        int i20 = i3;
        zzyk zzykVar = new zzyk(strArr, iArr6, zzwsVarArr, iArr4, iArr3, new zzws((zzcz[]) zzfy.zzL(zzczVarArr[i20], iArr2[i20])));
        Pair zzc = zzc(zzykVar, iArr3, iArr4, zzurVar, zzcxVar);
        zzym[] zzymVarArr = (zzym[]) zzc.second;
        List[] listArr = new List[zzymVarArr.length];
        for (int i21 = 0; i21 < zzymVarArr.length; i21++) {
            zzym zzymVar = zzymVarArr[i21];
            listArr[i21] = zzymVar != null ? zzgaa.zzm(zzymVar) : zzgaa.zzl();
        }
        zzfzx zzfzxVar = new zzfzx();
        for (int i22 = 0; i22 < 2; i22++) {
            zzws zzd = zzykVar.zzd(i22);
            List list = listArr[i22];
            for (int i23 = 0; i23 < zzd.zzc; i23++) {
                zzcz zzb2 = zzd.zzb(i23);
                boolean z4 = zzykVar.zza(i22, i23, false) != 0;
                int i24 = zzb2.zzb;
                int[] iArr7 = new int[1];
                boolean[] zArr = new boolean[1];
                int i25 = 0;
                while (true) {
                    int i26 = zzb2.zzb;
                    if (i25 <= 0) {
                        iArr7[i25] = zzykVar.zzb(i22, i23, i25) & 7;
                        int i27 = 0;
                        while (true) {
                            if (i27 >= list.size()) {
                                z = false;
                                break;
                            }
                            zzym zzymVar2 = (zzym) list.get(i27);
                            if (zzymVar2.zze().equals(zzb2) && zzymVar2.zzb(i25) != -1) {
                                z = true;
                                break;
                            }
                            i27++;
                        }
                        zArr[i25] = z;
                        i25++;
                    }
                }
                zzfzxVar.zzf(new zzdj(zzb2, z4, iArr7, zArr));
            }
        }
        zzws zze = zzykVar.zze();
        for (int i28 = 0; i28 < zze.zzc; i28++) {
            zzcz zzb3 = zze.zzb(i28);
            int i29 = zzb3.zzb;
            int[] iArr8 = new int[1];
            Arrays.fill(iArr8, 0);
            int i30 = zzb3.zzb;
            zzfzxVar.zzf(new zzdj(zzb3, false, iArr8, new boolean[1]));
        }
        return new zzyp((zzmi[]) zzc.first, (zzyi[]) zzc.second, new zzdk(zzfzxVar.zzi()), zzykVar);
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void zzq(Object obj) {
        this.zza = (zzyk) obj;
    }
}

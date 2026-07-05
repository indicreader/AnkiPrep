package com.google.android.gms.internal.mlkit_common;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes3.dex */
public final class zzbc extends zzau {
    static final zzau zza = new zzbc(null, new Object[0], 0);
    final transient Object[] zzb;

    @CheckForNull
    private final transient Object zzc;
    private final transient int zzd;

    private zzbc(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r4v2, types: [int[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v3 */
    public static zzbc zzg(int i, Object[] objArr, zzat zzatVar) {
        int i2;
        short[] sArr;
        int i3 = i;
        Object[] objArr2 = objArr;
        if (i3 == 0) {
            return (zzbc) zza;
        }
        Object obj = null;
        if (i3 == 1) {
            Object obj2 = objArr2[0];
            obj2.getClass();
            Object obj3 = objArr2[1];
            obj3.getClass();
            zzai.zza(obj2, obj3);
            return new zzbc(null, objArr2, 1);
        }
        zzaf.zzb(i3, objArr2.length >> 1, "index");
        int max = Math.max(i3, 2);
        if (max < 751619276) {
            i2 = Integer.highestOneBit(max - 1);
            do {
                i2 += i2;
            } while (i2 * 0.7d < max);
        } else {
            i2 = 1073741824;
            if (max >= 1073741824) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i3 == 1) {
            Object obj4 = objArr2[0];
            obj4.getClass();
            Object obj5 = objArr2[1];
            obj5.getClass();
            zzai.zza(obj4, obj5);
        } else {
            int i4 = i2 - 1;
            char c = 65535;
            if (i2 <= 128) {
                byte[] bArr = new byte[i2];
                Arrays.fill(bArr, (byte) -1);
                int i5 = 0;
                for (int i6 = 0; i6 < i3; i6++) {
                    int i7 = i5 + i5;
                    int i8 = i6 + i6;
                    Object obj6 = objArr2[i8];
                    obj6.getClass();
                    Object obj7 = objArr2[i8 ^ 1];
                    obj7.getClass();
                    zzai.zza(obj6, obj7);
                    int zza2 = zzak.zza(obj6.hashCode());
                    while (true) {
                        int i9 = zza2 & i4;
                        int i10 = bArr[i9] & 255;
                        if (i10 != 255) {
                            if (obj6.equals(objArr2[i10])) {
                                int i11 = i10 ^ 1;
                                Object obj8 = objArr2[i11];
                                obj8.getClass();
                                zzas zzasVar = new zzas(obj6, obj7, obj8);
                                objArr2[i11] = obj7;
                                obj = zzasVar;
                                break;
                            }
                            zza2 = i9 + 1;
                        } else {
                            bArr[i9] = (byte) i7;
                            if (i5 < i6) {
                                objArr2[i7] = obj6;
                                objArr2[i7 ^ 1] = obj7;
                            }
                            i5++;
                        }
                    }
                }
                obj = i5 == i3 ? bArr : new Object[]{bArr, Integer.valueOf(i5), obj};
            } else if (i2 <= 32768) {
                sArr = new short[i2];
                Arrays.fill(sArr, (short) -1);
                int i12 = 0;
                for (int i13 = 0; i13 < i3; i13++) {
                    int i14 = i12 + i12;
                    int i15 = i13 + i13;
                    Object obj9 = objArr2[i15];
                    obj9.getClass();
                    Object obj10 = objArr2[i15 ^ 1];
                    obj10.getClass();
                    zzai.zza(obj9, obj10);
                    int zza3 = zzak.zza(obj9.hashCode());
                    while (true) {
                        int i16 = zza3 & i4;
                        char c2 = (char) sArr[i16];
                        if (c2 != 65535) {
                            if (obj9.equals(objArr2[c2])) {
                                int i17 = c2 ^ 1;
                                Object obj11 = objArr2[i17];
                                obj11.getClass();
                                zzas zzasVar2 = new zzas(obj9, obj10, obj11);
                                objArr2[i17] = obj10;
                                obj = zzasVar2;
                                break;
                            }
                            zza3 = i16 + 1;
                        } else {
                            sArr[i16] = (short) i14;
                            if (i12 < i13) {
                                objArr2[i14] = obj9;
                                objArr2[i14 ^ 1] = obj10;
                            }
                            i12++;
                        }
                    }
                }
                if (i12 != i3) {
                    obj = new Object[]{sArr, Integer.valueOf(i12), obj};
                }
                obj = sArr;
            } else {
                sArr = new int[i2];
                Arrays.fill((int[]) sArr, -1);
                int i18 = 0;
                int i19 = 0;
                while (i18 < i3) {
                    int i20 = i19 + i19;
                    int i21 = i18 + i18;
                    Object obj12 = objArr2[i21];
                    obj12.getClass();
                    Object obj13 = objArr2[i21 ^ 1];
                    obj13.getClass();
                    zzai.zza(obj12, obj13);
                    int zza4 = zzak.zza(obj12.hashCode());
                    while (true) {
                        int i22 = zza4 & i4;
                        ?? r15 = sArr[i22];
                        if (r15 != c) {
                            if (obj12.equals(objArr2[r15])) {
                                int i23 = r15 ^ 1;
                                Object obj14 = objArr2[i23];
                                obj14.getClass();
                                zzas zzasVar3 = new zzas(obj12, obj13, obj14);
                                objArr2[i23] = obj13;
                                obj = zzasVar3;
                                break;
                            }
                            zza4 = i22 + 1;
                            c = 65535;
                        } else {
                            sArr[i22] = i20;
                            if (i19 < i18) {
                                objArr2[i20] = obj12;
                                objArr2[i20 ^ 1] = obj13;
                            }
                            i19++;
                        }
                    }
                    i18++;
                    c = 65535;
                }
                if (i19 != i3) {
                    obj = new Object[]{sArr, Integer.valueOf(i19), obj};
                }
                obj = sArr;
            }
        }
        boolean z = obj instanceof Object[];
        Object obj15 = obj;
        if (z) {
            Object[] objArr3 = (Object[]) obj;
            zzas zzasVar4 = (zzas) objArr3[2];
            if (zzatVar != null) {
                zzatVar.zzc = zzasVar4;
                Object obj16 = objArr3[0];
                int intValue = ((Integer) objArr3[1]).intValue();
                objArr2 = Arrays.copyOf(objArr2, intValue + intValue);
                obj15 = obj16;
                i3 = intValue;
            } else {
                throw zzasVar4.zza();
            }
        }
        return new zzbc(obj15, objArr2, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x009f A[RETURN] */
    @Override // com.google.android.gms.internal.mlkit_common.zzau, java.util.Map
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(@javax.annotation.CheckForNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.zzc
            java.lang.Object[] r1 = r9.zzb
            int r2 = r9.zzd
            r3 = 0
            if (r10 != 0) goto Lc
        L9:
            r10 = r3
            goto L9c
        Lc:
            r4 = 1
            if (r2 != r4) goto L22
            r0 = 0
            r0 = r1[r0]
            r0.getClass()
            boolean r10 = r0.equals(r10)
            if (r10 == 0) goto L9
            r10 = r1[r4]
            r10.getClass()
            goto L9c
        L22:
            if (r0 != 0) goto L25
            goto L9
        L25:
            boolean r2 = r0 instanceof byte[]
            r5 = -1
            if (r2 == 0) goto L51
            r2 = r0
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            int r6 = r0 + (-1)
            int r0 = r10.hashCode()
            int r0 = com.google.android.gms.internal.mlkit_common.zzak.zza(r0)
        L38:
            r0 = r0 & r6
            r5 = r2[r0]
            r7 = 255(0xff, float:3.57E-43)
            r5 = r5 & r7
            if (r5 != r7) goto L41
            goto L9
        L41:
            r7 = r1[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L4e
            r10 = r5 ^ 1
            r10 = r1[r10]
            goto L9c
        L4e:
            int r0 = r0 + 1
            goto L38
        L51:
            boolean r2 = r0 instanceof short[]
            if (r2 == 0) goto L7d
            r2 = r0
            short[] r2 = (short[]) r2
            int r0 = r2.length
            int r6 = r0 + (-1)
            int r0 = r10.hashCode()
            int r0 = com.google.android.gms.internal.mlkit_common.zzak.zza(r0)
        L63:
            r0 = r0 & r6
            short r5 = r2[r0]
            char r5 = (char) r5
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r7) goto L6d
            goto L9
        L6d:
            r7 = r1[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L7a
            r10 = r5 ^ 1
            r10 = r1[r10]
            goto L9c
        L7a:
            int r0 = r0 + 1
            goto L63
        L7d:
            int[] r0 = (int[]) r0
            int r2 = r0.length
            int r2 = r2 + r5
            int r6 = r10.hashCode()
            int r6 = com.google.android.gms.internal.mlkit_common.zzak.zza(r6)
        L89:
            r6 = r6 & r2
            r7 = r0[r6]
            if (r7 != r5) goto L90
            goto L9
        L90:
            r8 = r1[r7]
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto La0
            r10 = r7 ^ 1
            r10 = r1[r10]
        L9c:
            if (r10 != 0) goto L9f
            return r3
        L9f:
            return r10
        La0:
            int r6 = r6 + 1
            goto L89
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzbc.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzau
    final zzan zza() {
        return new zzbb(this.zzb, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzau
    final zzav zzd() {
        return new zzaz(this, this.zzb, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzau
    final zzav zze() {
        return new zzba(this, new zzbb(this.zzb, 0, this.zzd));
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzyg extends zzyl implements zzmg {
    public static final /* synthetic */ int zzb = 0;
    private static final zzgbj zzc = zzgbj.zzb(new Comparator() { // from class: com.google.android.gms.internal.ads.zzxc
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            Integer num = (Integer) obj;
            Integer num2 = (Integer) obj2;
            int i = zzyg.zzb;
            if (num.intValue() == -1) {
                return num2.intValue() == -1 ? 0 : -1;
            }
            if (num2.intValue() == -1) {
                return 1;
            }
            return num.intValue() - num2.intValue();
        }
    });
    private static final zzgbj zzd = zzgbj.zzb(new Comparator() { // from class: com.google.android.gms.internal.ads.zzxe
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int i = zzyg.zzb;
            return 0;
        }
    });
    public final Context zza;
    private final Object zze;
    private final boolean zzf;
    private zzxu zzg;
    private zzxz zzh;
    private zzk zzi;
    private final zzwy zzj;

    public zzyg(Context context) {
        zzwy zzwyVar = new zzwy();
        zzxu zzd2 = zzxu.zzd(context);
        this.zze = new Object();
        this.zza = context != null ? context.getApplicationContext() : null;
        this.zzj = zzwyVar;
        this.zzg = zzd2;
        this.zzi = zzk.zza;
        boolean z = false;
        if (context != null && zzfy.zzJ(context)) {
            z = true;
        }
        this.zzf = z;
        if (!z && context != null && zzfy.zza >= 32) {
            this.zzh = zzxz.zza(context);
        }
        if (this.zzg.zzS && context == null) {
            zzff.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    public static /* bridge */ /* synthetic */ int zza(int i, int i2) {
        if (i == 0 || i != i2) {
            return Integer.bitCount(i & i2);
        }
        return Integer.MAX_VALUE;
    }

    public static int zzb(zzam zzamVar, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(zzamVar.zzd)) {
            return 4;
        }
        String zzh = zzh(str);
        String zzh2 = zzh(zzamVar.zzd);
        if (zzh2 == null || zzh == null) {
            return (z && zzh2 == null) ? 1 : 0;
        }
        if (zzh2.startsWith(zzh) || zzh.startsWith(zzh2)) {
            return 3;
        }
        int i = zzfy.zza;
        return zzh2.split("-", 2)[0].equals(zzh.split("-", 2)[0]) ? 2 : 0;
    }

    public static String zzh(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    public static /* bridge */ /* synthetic */ void zzi(zzyg zzygVar) {
        zzygVar.zzv();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0053, code lost:
    
        if (r1 != 3) goto L105;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ boolean zzm(com.google.android.gms.internal.ads.zzyg r8, com.google.android.gms.internal.ads.zzam r9) {
        /*
            java.lang.Object r0 = r8.zze
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzxu r1 = r8.zzg     // Catch: java.lang.Throwable -> L8f
            boolean r1 = r1.zzS     // Catch: java.lang.Throwable -> L8f
            r2 = 1
            if (r1 == 0) goto L8d
            boolean r1 = r8.zzf     // Catch: java.lang.Throwable -> L8f
            if (r1 != 0) goto L8d
            int r1 = r9.zzz     // Catch: java.lang.Throwable -> L8f
            r3 = 2
            if (r1 <= r3) goto L8d
            java.lang.String r1 = r9.zzm     // Catch: java.lang.Throwable -> L8f
            r4 = 32
            r5 = 0
            if (r1 != 0) goto L1b
            goto L65
        L1b:
            int r6 = r1.hashCode()     // Catch: java.lang.Throwable -> L8f
            r7 = 3
            switch(r6) {
                case -2123537834: goto L42;
                case 187078296: goto L38;
                case 187078297: goto L2e;
                case 1504578661: goto L24;
                default: goto L23;
            }
        L23:
            goto L4c
        L24:
            java.lang.String r6 = "audio/eac3"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L4c
            r1 = r2
            goto L4d
        L2e:
            java.lang.String r6 = "audio/ac4"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L4c
            r1 = r7
            goto L4d
        L38:
            java.lang.String r6 = "audio/ac3"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L4c
            r1 = r5
            goto L4d
        L42:
            java.lang.String r6 = "audio/eac3-joc"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L4c
            r1 = r3
            goto L4d
        L4c:
            r1 = -1
        L4d:
            if (r1 == 0) goto L56
            if (r1 == r2) goto L56
            if (r1 == r3) goto L56
            if (r1 == r7) goto L56
            goto L65
        L56:
            int r1 = com.google.android.gms.internal.ads.zzfy.zza     // Catch: java.lang.Throwable -> L8f
            if (r1 < r4) goto L8d
            com.google.android.gms.internal.ads.zzxz r1 = r8.zzh     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L8d
            boolean r1 = r1.zzg()     // Catch: java.lang.Throwable -> L8f
            if (r1 != 0) goto L65
            goto L8d
        L65:
            int r1 = com.google.android.gms.internal.ads.zzfy.zza     // Catch: java.lang.Throwable -> L8f
            if (r1 < r4) goto L8c
            com.google.android.gms.internal.ads.zzxz r1 = r8.zzh     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L8c
            boolean r3 = r1.zzg()     // Catch: java.lang.Throwable -> L8f
            if (r3 == 0) goto L8c
            boolean r1 = r1.zze()     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L8c
            com.google.android.gms.internal.ads.zzxz r1 = r8.zzh     // Catch: java.lang.Throwable -> L8f
            boolean r1 = r1.zzf()     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L8c
            com.google.android.gms.internal.ads.zzxz r1 = r8.zzh     // Catch: java.lang.Throwable -> L8f
            com.google.android.gms.internal.ads.zzk r8 = r8.zzi     // Catch: java.lang.Throwable -> L8f
            boolean r8 = r1.zzd(r8, r9)     // Catch: java.lang.Throwable -> L8f
            if (r8 == 0) goto L8c
            goto L8d
        L8c:
            r2 = r5
        L8d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8f
            return r2
        L8f:
            r8 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8f
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyg.zzm(com.google.android.gms.internal.ads.zzyg, com.google.android.gms.internal.ads.zzam):boolean");
    }

    public static boolean zzo(int i, boolean z) {
        int i2 = i & 7;
        if (i2 != 4) {
            return z && i2 == 3;
        }
        return true;
    }

    private static void zzu(zzws zzwsVar, zzdg zzdgVar, Map map) {
        for (int i = 0; i < zzwsVar.zzc; i++) {
            if (((zzdb) zzdgVar.zzD.get(zzwsVar.zzb(i))) != null) {
                throw null;
            }
        }
    }

    public final void zzv() {
        boolean z;
        zzxz zzxzVar;
        synchronized (this.zze) {
            z = false;
            if (this.zzg.zzS && !this.zzf && zzfy.zza >= 32 && (zzxzVar = this.zzh) != null && zzxzVar.zzg()) {
                z = true;
            }
        }
        if (z) {
            zzt();
        }
    }

    private static final Pair zzw(int i, zzyk zzykVar, int[][][] iArr, zzyb zzybVar, Comparator comparator) {
        int i2;
        List arrayList;
        zzyk zzykVar2 = zzykVar;
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        while (i3 < 2) {
            if (i == zzykVar2.zzc(i3)) {
                zzws zzd2 = zzykVar2.zzd(i3);
                for (int i4 = 0; i4 < zzd2.zzc; i4++) {
                    zzcz zzb2 = zzd2.zzb(i4);
                    List zza = zzybVar.zza(i3, zzb2, iArr[i3][i4]);
                    int i5 = zzb2.zzb;
                    int i6 = 1;
                    boolean[] zArr = new boolean[1];
                    int i7 = 0;
                    while (true) {
                        int i8 = zzb2.zzb;
                        if (i7 <= 0) {
                            int i9 = i7 + 1;
                            zzyc zzycVar = (zzyc) zza.get(i7);
                            int zzb3 = zzycVar.zzb();
                            if (zArr[i7] || zzb3 == 0) {
                                i2 = i6;
                            } else {
                                if (zzb3 == i6) {
                                    arrayList = zzgaa.zzm(zzycVar);
                                    i2 = i6;
                                } else {
                                    arrayList = new ArrayList();
                                    arrayList.add(zzycVar);
                                    int i10 = i9;
                                    while (true) {
                                        int i11 = zzb2.zzb;
                                        if (i10 > 0) {
                                            break;
                                        }
                                        zzyc zzycVar2 = (zzyc) zza.get(i10);
                                        if (zzycVar2.zzb() == 2 && zzycVar.zzc(zzycVar2)) {
                                            arrayList.add(zzycVar2);
                                            zArr[i10] = true;
                                        }
                                        i10++;
                                    }
                                    i2 = 1;
                                }
                                arrayList2.add(arrayList);
                            }
                            i6 = i2;
                            i7 = i9;
                        }
                    }
                }
            }
            i3++;
            zzykVar2 = zzykVar;
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList2, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i12 = 0; i12 < list.size(); i12++) {
            iArr2[i12] = ((zzyc) list.get(i12)).zzc;
        }
        zzyc zzycVar3 = (zzyc) list.get(0);
        return Pair.create(new zzyh(zzycVar3.zzb, iArr2, 0), Integer.valueOf(zzycVar3.zza));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzyl
    protected final Pair zzc(zzyk zzykVar, int[][][] iArr, final int[] iArr2, zzur zzurVar, zzcx zzcxVar) throws zziz {
        final zzxu zzxuVar;
        Pair pair;
        int i;
        final boolean z;
        int[] iArr3;
        int length;
        zzyi zza;
        zzxz zzxzVar;
        synchronized (this.zze) {
            zzxuVar = this.zzg;
            if (zzxuVar.zzS && zzfy.zza >= 32 && (zzxzVar = this.zzh) != null) {
                Looper myLooper = Looper.myLooper();
                zzek.zzb(myLooper);
                zzxzVar.zzb(this, myLooper);
            }
        }
        int i2 = 2;
        zzyh[] zzyhVarArr = new zzyh[2];
        zzde zzdeVar = zzxuVar.zzv;
        Pair zzw = zzw(2, zzykVar, iArr, new zzyb() { // from class: com.google.android.gms.internal.ads.zzxk
            /* JADX WARN: Removed duplicated region for block: B:20:0x0048  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x0053  */
            @Override // com.google.android.gms.internal.ads.zzyb
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.util.List zza(int r19, com.google.android.gms.internal.ads.zzcz r20, int[] r21) {
                /*
                    Method dump skipped, instructions count: 197
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxk.zza(int, com.google.android.gms.internal.ads.zzcz, int[]):java.util.List");
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxl
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                List list = (List) obj;
                List list2 = (List) obj2;
                return zzfzp.zzk().zzd((zzyf) Collections.max(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zzyd
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzyf.zzd((zzyf) obj3, (zzyf) obj4);
                    }
                }), (zzyf) Collections.max(list2, new Comparator() { // from class: com.google.android.gms.internal.ads.zzyd
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzyf.zzd((zzyf) obj3, (zzyf) obj4);
                    }
                }), new Comparator() { // from class: com.google.android.gms.internal.ads.zzyd
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzyf.zzd((zzyf) obj3, (zzyf) obj4);
                    }
                }).zzb(list.size(), list2.size()).zzd((zzyf) Collections.max(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zzye
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzyf.zza((zzyf) obj3, (zzyf) obj4);
                    }
                }), (zzyf) Collections.max(list2, new Comparator() { // from class: com.google.android.gms.internal.ads.zzye
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzyf.zza((zzyf) obj3, (zzyf) obj4);
                    }
                }), new Comparator() { // from class: com.google.android.gms.internal.ads.zzye
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzyf.zza((zzyf) obj3, (zzyf) obj4);
                    }
                }).zza();
            }
        });
        boolean z2 = zzxuVar.zzA;
        int i3 = 4;
        if (zzw == null) {
            zzde zzdeVar2 = zzxuVar.zzv;
            pair = zzw(4, zzykVar, iArr, new zzyb() { // from class: com.google.android.gms.internal.ads.zzxf
                @Override // com.google.android.gms.internal.ads.zzyb
                public final List zza(int i4, zzcz zzczVar, int[] iArr4) {
                    int i5 = zzyg.zzb;
                    zzfzx zzfzxVar = new zzfzx();
                    int i6 = 0;
                    while (true) {
                        int i7 = zzczVar.zzb;
                        if (i6 <= 0) {
                            zzfzxVar.zzf(new zzxo(i4, zzczVar, i6, zzxu.this, iArr4[i6]));
                            i6++;
                        } else {
                            return zzfzxVar.zzi();
                        }
                    }
                }
            }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxg
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ((zzxo) ((List) obj).get(0)).zza((zzxo) ((List) obj2).get(0));
                }
            });
        } else {
            pair = null;
        }
        if (pair != null) {
            zzyhVarArr[((Integer) pair.second).intValue()] = (zzyh) pair.first;
        } else if (zzw != null) {
            zzyhVarArr[((Integer) zzw.second).intValue()] = (zzyh) zzw.first;
        }
        int i4 = 0;
        while (true) {
            i = 1;
            if (i4 >= 2) {
                z = false;
                break;
            }
            if (zzykVar.zzc(i4) == 2 && zzykVar.zzd(i4).zzc > 0) {
                z = true;
                break;
            }
            i4++;
        }
        Pair zzw2 = zzw(1, zzykVar, iArr, new zzyb() { // from class: com.google.android.gms.internal.ads.zzxi
            @Override // com.google.android.gms.internal.ads.zzyb
            public final List zza(int i5, zzcz zzczVar, int[] iArr4) {
                final zzyg zzygVar = zzyg.this;
                zzfxf zzfxfVar = new zzfxf() { // from class: com.google.android.gms.internal.ads.zzxh
                    @Override // com.google.android.gms.internal.ads.zzfxf
                    public final boolean zza(Object obj) {
                        return zzyg.zzm(zzyg.this, (zzam) obj);
                    }
                };
                int i6 = iArr2[i5];
                zzfzx zzfzxVar = new zzfzx();
                int i7 = 0;
                while (true) {
                    int i8 = zzczVar.zzb;
                    if (i7 <= 0) {
                        zzfzxVar.zzf(new zzxn(i5, zzczVar, i7, zzxuVar, iArr4[i7], z, zzfxfVar, i6));
                        i7++;
                    } else {
                        return zzfzxVar.zzi();
                    }
                }
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxj
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((zzxn) Collections.max((List) obj)).zza((zzxn) Collections.max((List) obj2));
            }
        });
        if (zzw2 != null) {
            zzyhVarArr[((Integer) zzw2.second).intValue()] = (zzyh) zzw2.first;
        }
        final String str = zzw2 == null ? null : ((zzyh) zzw2.first).zza.zzb(((zzyh) zzw2.first).zzb[0]).zzd;
        zzde zzdeVar3 = zzxuVar.zzv;
        int i5 = 3;
        Pair zzw3 = zzw(3, zzykVar, iArr, new zzyb() { // from class: com.google.android.gms.internal.ads.zzxm
            @Override // com.google.android.gms.internal.ads.zzyb
            public final List zza(int i6, zzcz zzczVar, int[] iArr4) {
                int i7 = zzyg.zzb;
                zzfzx zzfzxVar = new zzfzx();
                int i8 = 0;
                while (true) {
                    int i9 = zzczVar.zzb;
                    if (i8 <= 0) {
                        int i10 = i8;
                        zzfzxVar.zzf(new zzya(i6, zzczVar, i10, zzxu.this, iArr4[i8], str));
                        i8++;
                    } else {
                        return zzfzxVar.zzi();
                    }
                }
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxd
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((zzya) ((List) obj).get(0)).zza((zzya) ((List) obj2).get(0));
            }
        });
        if (zzw3 != null) {
            zzyhVarArr[((Integer) zzw3.second).intValue()] = (zzyh) zzw3.first;
        }
        int i6 = 0;
        while (i6 < i2) {
            int zzc2 = zzykVar.zzc(i6);
            if (zzc2 != i2 && zzc2 != i && zzc2 != i5 && zzc2 != i3) {
                zzws zzd2 = zzykVar.zzd(i6);
                int[][] iArr4 = iArr[i6];
                zzde zzdeVar4 = zzxuVar.zzv;
                int i7 = 0;
                zzcz zzczVar = null;
                zzxp zzxpVar = null;
                while (i7 < zzd2.zzc) {
                    zzcz zzb2 = zzd2.zzb(i7);
                    int[] iArr5 = iArr4[i7];
                    zzxp zzxpVar2 = zzxpVar;
                    char c = 0;
                    while (true) {
                        int i8 = zzb2.zzb;
                        if (c <= 0) {
                            if (zzo(iArr5[0], zzxuVar.zzT)) {
                                zzxp zzxpVar3 = new zzxp(zzb2.zzb(0), iArr5[0]);
                                if (zzxpVar2 == null || zzxpVar3.compareTo(zzxpVar2) > 0) {
                                    zzczVar = zzb2;
                                    zzxpVar2 = zzxpVar3;
                                }
                            }
                            c = 1;
                        }
                    }
                    i7++;
                    zzxpVar = zzxpVar2;
                }
                zzyhVarArr[i6] = zzczVar == null ? null : new zzyh(zzczVar, new int[]{0}, 0);
            }
            i6++;
            i2 = 2;
            i3 = 4;
            i = 1;
            i5 = 3;
        }
        HashMap hashMap = new HashMap();
        int i9 = 2;
        for (int i10 = 0; i10 < 2; i10++) {
            zzu(zzykVar.zzd(i10), zzxuVar, hashMap);
        }
        zzu(zzykVar.zze(), zzxuVar, hashMap);
        for (int i11 = 0; i11 < 2; i11++) {
            if (((zzdb) hashMap.get(Integer.valueOf(zzykVar.zzc(i11)))) != null) {
                throw null;
            }
        }
        int i12 = 0;
        while (i12 < i9) {
            zzws zzd3 = zzykVar.zzd(i12);
            if (zzxuVar.zzg(i12, zzd3)) {
                if (zzxuVar.zze(i12, zzd3) != null) {
                    throw null;
                }
                zzyhVarArr[i12] = null;
            }
            i12++;
            i9 = 2;
        }
        int i13 = 0;
        for (int i14 = i9; i13 < i14; i14 = 2) {
            int zzc3 = zzykVar.zzc(i13);
            if (zzxuVar.zzf(i13) || zzxuVar.zzE.contains(Integer.valueOf(zzc3))) {
                zzyhVarArr[i13] = null;
            }
            i13++;
        }
        zzwy zzwyVar = this.zzj;
        zzyw zzr = zzr();
        zzgaa zzf = zzwz.zzf(zzyhVarArr);
        int i15 = 2;
        zzyi[] zzyiVarArr = new zzyi[2];
        int i16 = 0;
        while (i16 < i15) {
            zzyh zzyhVar = zzyhVarArr[i16];
            if (zzyhVar != null && (length = (iArr3 = zzyhVar.zzb).length) != 0) {
                if (length == 1) {
                    zza = new zzyj(zzyhVar.zza, iArr3[0], 0, 0, null);
                } else {
                    zza = zzwyVar.zza(zzyhVar.zza, iArr3, 0, zzr, (zzgaa) zzf.get(i16));
                }
                zzyiVarArr[i16] = zza;
            }
            i16++;
            i15 = 2;
        }
        zzmi[] zzmiVarArr = new zzmi[i15];
        for (int i17 = 0; i17 < i15; i17++) {
            zzmiVarArr[i17] = (zzxuVar.zzf(i17) || zzxuVar.zzE.contains(Integer.valueOf(zzykVar.zzc(i17))) || (zzykVar.zzc(i17) != -2 && zzyiVarArr[i17] == null)) ? null : zzmi.zza;
        }
        boolean z3 = zzxuVar.zzU;
        zzde zzdeVar5 = zzxuVar.zzv;
        return Pair.create(zzmiVarArr, zzyiVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final zzmg zzd() {
        return this;
    }

    public final zzxu zze() {
        zzxu zzxuVar;
        synchronized (this.zze) {
            zzxuVar = this.zzg;
        }
        return zzxuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void zzj() {
        zzxz zzxzVar;
        synchronized (this.zze) {
            if (zzfy.zza >= 32 && (zzxzVar = this.zzh) != null) {
                zzxzVar.zzc();
            }
        }
        super.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void zzk(zzk zzkVar) {
        boolean z;
        synchronized (this.zze) {
            z = !this.zzi.equals(zzkVar);
            this.zzi = zzkVar;
        }
        if (z) {
            zzv();
        }
    }

    public final void zzl(zzxs zzxsVar) {
        boolean z;
        zzxu zzxuVar = new zzxu(zzxsVar);
        synchronized (this.zze) {
            z = !this.zzg.equals(zzxuVar);
            this.zzg = zzxuVar;
        }
        if (z) {
            if (zzxuVar.zzS && this.zza == null) {
                zzff.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            zzt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final boolean zzn() {
        return true;
    }
}

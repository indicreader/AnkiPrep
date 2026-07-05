package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzkz implements Handler.Callback, zzuo, zzyn, zzlw, zziw, zzlz {
    private boolean zzB;
    private boolean zzE;
    private int zzF;
    private zzky zzG;
    private long zzH;
    private int zzI;
    private boolean zzJ;
    private zziz zzK;
    private final zzjk zzM;
    private final zziu zzN;
    private final zzmf[] zza;
    private final Set zzb;
    private final zzmh[] zzc;
    private final zzyo zzd;
    private final zzyp zze;
    private final zzlc zzf;
    private final zzyw zzg;
    private final zzew zzh;
    private final HandlerThread zzi;
    private final Looper zzj;
    private final zzcw zzk;
    private final zzcu zzl;
    private final long zzm;
    private final zzix zzn;
    private final ArrayList zzo;
    private final zzel zzp;
    private final zzll zzq;
    private final zzlx zzr;
    private final long zzs;
    private zzmj zzt;
    private zzly zzu;
    private zzkx zzv;
    private boolean zzw;
    private boolean zzy;
    private boolean zzz;
    private int zzC = 0;
    private boolean zzD = false;
    private boolean zzx = false;
    private long zzL = -9223372036854775807L;
    private long zzA = -9223372036854775807L;

    public zzkz(zzmf[] zzmfVarArr, zzyo zzyoVar, zzyp zzypVar, zzlc zzlcVar, zzyw zzywVar, int i, boolean z, zzmp zzmpVar, zzmj zzmjVar, zziu zziuVar, long j, boolean z2, Looper looper, zzel zzelVar, zzjk zzjkVar, zzpb zzpbVar, Looper looper2) {
        this.zzM = zzjkVar;
        this.zza = zzmfVarArr;
        this.zzd = zzyoVar;
        this.zze = zzypVar;
        this.zzf = zzlcVar;
        this.zzg = zzywVar;
        int i2 = 0;
        this.zzt = zzmjVar;
        this.zzN = zziuVar;
        this.zzs = j;
        this.zzp = zzelVar;
        this.zzm = zzlcVar.zza();
        zzlcVar.zzf();
        this.zzu = zzly.zzg(zzypVar);
        this.zzv = new zzkx(this.zzu);
        int length = zzmfVarArr.length;
        this.zzc = new zzmh[2];
        zzmg zzd = zzyoVar.zzd();
        while (true) {
            int length2 = zzmfVarArr.length;
            if (i2 < 2) {
                zzmfVarArr[i2].zzu(i2, zzpbVar, zzelVar);
                this.zzc[i2] = zzmfVarArr[i2].zzl();
                this.zzc[i2].zzK(zzd);
                i2++;
            } else {
                this.zzn = new zzix(this, zzelVar);
                this.zzo = new ArrayList();
                this.zzb = Collections.newSetFromMap(new IdentityHashMap());
                this.zzk = new zzcw();
                this.zzl = new zzcu();
                zzyoVar.zzs(this, zzywVar);
                this.zzJ = true;
                zzew zzb = zzelVar.zzb(looper, null);
                this.zzq = new zzll(zzmpVar, zzb, new zzkr(this));
                this.zzr = new zzlx(this, zzmpVar, zzb, zzpbVar);
                HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
                this.zzi = handlerThread;
                handlerThread.start();
                Looper looper3 = handlerThread.getLooper();
                this.zzj = looper3;
                this.zzh = zzelVar.zzb(looper3, this);
                return;
            }
        }
    }

    private final void zzA(zzmf zzmfVar) throws zziz {
        if (zzaf(zzmfVar)) {
            this.zzn.zzd(zzmfVar);
            zzam(zzmfVar);
            zzmfVar.zzq();
            this.zzF--;
        }
    }

    private final void zzB() throws zziz {
        int length = this.zza.length;
        zzC(new boolean[2], this.zzq.zzf().zzf());
    }

    private final void zzC(boolean[] zArr, long j) throws zziz {
        zzli zzf = this.zzq.zzf();
        zzyp zzi = zzf.zzi();
        int i = 0;
        while (true) {
            int length = this.zza.length;
            if (i >= 2) {
                break;
            }
            if (!zzi.zzb(i) && this.zzb.remove(this.zza[i])) {
                this.zza[i].zzH();
            }
            i++;
        }
        int i2 = 0;
        while (true) {
            int length2 = this.zza.length;
            if (i2 < 2) {
                if (zzi.zzb(i2)) {
                    boolean z = zArr[i2];
                    zzmf zzmfVar = this.zza[i2];
                    if (!zzaf(zzmfVar)) {
                        zzll zzllVar = this.zzq;
                        zzli zzf2 = zzllVar.zzf();
                        boolean z2 = zzf2 == zzllVar.zze();
                        zzyp zzi2 = zzf2.zzi();
                        zzmi zzmiVar = zzi2.zzb[i2];
                        zzam[] zzak = zzak(zzi2.zzc[i2]);
                        boolean z3 = zzai() && this.zzu.zze == 3;
                        boolean z4 = !z && z3;
                        this.zzF++;
                        this.zzb.add(zzmfVar);
                        zzmfVar.zzr(zzmiVar, zzak, zzf2.zzc[i2], this.zzH, z4, z2, j, zzf2.zze(), zzf2.zzf.zza);
                        zzmfVar.zzt(11, new zzks(this));
                        this.zzn.zze(zzmfVar);
                        if (z3) {
                            zzmfVar.zzN();
                        }
                    }
                }
                i2++;
            } else {
                zzf.zzg = true;
                return;
            }
        }
    }

    private final void zzD(IOException iOException, int i) {
        zzll zzllVar = this.zzq;
        zziz zzc = zziz.zzc(iOException, i);
        zzli zze = zzllVar.zze();
        if (zze != null) {
            zzc = zzc.zza(zze.zzf.zza);
        }
        zzff.zzd("ExoPlayerImplInternal", "Playback error", zzc);
        zzW(false, false);
        this.zzu = this.zzu.zzd(zzc);
    }

    private final void zzE(boolean z) {
        long zzc;
        zzli zzd = this.zzq.zzd();
        zzur zzurVar = zzd == null ? this.zzu.zzb : zzd.zzf.zza;
        boolean z2 = !this.zzu.zzk.equals(zzurVar);
        if (z2) {
            this.zzu = this.zzu.zza(zzurVar);
        }
        zzly zzlyVar = this.zzu;
        if (zzd == null) {
            zzc = zzlyVar.zzr;
        } else {
            zzc = zzd.zzc();
        }
        zzlyVar.zzp = zzc;
        this.zzu.zzq = zzt();
        if ((z2 || z) && zzd != null && zzd.zzd) {
            zzZ(zzd.zzf.zza, zzd.zzh(), zzd.zzi());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x03d4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x03ab  */
    /* JADX WARN: Type inference failed for: r1v79 */
    /* JADX WARN: Type inference failed for: r1v80, types: [int] */
    /* JADX WARN: Type inference failed for: r1v96 */
    /* JADX WARN: Type inference failed for: r21v0, types: [long] */
    /* JADX WARN: Type inference failed for: r21v6 */
    /* JADX WARN: Type inference failed for: r21v7 */
    /* JADX WARN: Type inference failed for: r21v9 */
    /* JADX WARN: Type inference failed for: r31v0, types: [com.google.android.gms.internal.ads.zzcx] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzF(com.google.android.gms.internal.ads.zzcx r31, boolean r32) throws com.google.android.gms.internal.ads.zziz {
        /*
            Method dump skipped, instructions count: 1062
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkz.zzF(com.google.android.gms.internal.ads.zzcx, boolean):void");
    }

    private final void zzG(zzcg zzcgVar, boolean z) throws zziz {
        zzH(zzcgVar, zzcgVar.zzc, true, z);
    }

    private final void zzH(zzcg zzcgVar, float f, boolean z, boolean z2) throws zziz {
        int i;
        zzkz zzkzVar = this;
        if (z) {
            if (z2) {
                zzkzVar.zzv.zza(1);
            }
            zzly zzlyVar = zzkzVar.zzu;
            zzcx zzcxVar = zzlyVar.zza;
            zzur zzurVar = zzlyVar.zzb;
            long j = zzlyVar.zzc;
            long j2 = zzlyVar.zzd;
            int i2 = zzlyVar.zze;
            zziz zzizVar = zzlyVar.zzf;
            boolean z3 = zzlyVar.zzg;
            zzws zzwsVar = zzlyVar.zzh;
            zzyp zzypVar = zzlyVar.zzi;
            List list = zzlyVar.zzj;
            zzur zzurVar2 = zzlyVar.zzk;
            boolean z4 = zzlyVar.zzl;
            int i3 = zzlyVar.zzm;
            long j3 = zzlyVar.zzp;
            long j4 = zzlyVar.zzq;
            long j5 = zzlyVar.zzr;
            long j6 = zzlyVar.zzs;
            boolean z5 = zzlyVar.zzo;
            zzkzVar = this;
            zzkzVar.zzu = new zzly(zzcxVar, zzurVar, j, j2, i2, zzizVar, z3, zzwsVar, zzypVar, list, zzurVar2, z4, i3, zzcgVar, j3, j4, j5, j6, false);
        }
        float f2 = zzcgVar.zzc;
        zzli zze = zzkzVar.zzq.zze();
        while (true) {
            i = 0;
            if (zze == null) {
                break;
            }
            zzyi[] zzyiVarArr = zze.zzi().zzc;
            int length = zzyiVarArr.length;
            while (i < length) {
                zzyi zzyiVar = zzyiVarArr[i];
                i++;
            }
            zze = zze.zzg();
        }
        zzmf[] zzmfVarArr = zzkzVar.zza;
        int length2 = zzmfVarArr.length;
        while (i < 2) {
            zzmf zzmfVar = zzmfVarArr[i];
            if (zzmfVar != null) {
                zzmfVar.zzL(f, zzcgVar.zzc);
            }
            i++;
        }
    }

    private final void zzI() {
        long zze;
        long j;
        boolean z = false;
        if (zzae()) {
            zzli zzd = this.zzq.zzd();
            long zzu = zzu(zzd.zzd());
            if (zzd == this.zzq.zze()) {
                zze = this.zzH;
                j = zzd.zze();
            } else {
                zze = this.zzH - zzd.zze();
                j = zzd.zzf.zzb;
            }
            long j2 = zze - j;
            boolean zzg = this.zzf.zzg(j2, zzu, this.zzn.zzc().zzc);
            if (zzg || zzu >= 500000 || this.zzm <= 0) {
                z = zzg;
            } else {
                this.zzq.zze().zza.zzj(this.zzu.zzr, false);
                z = this.zzf.zzg(j2, zzu, this.zzn.zzc().zzc);
            }
        }
        this.zzB = z;
        if (z) {
            this.zzq.zzd().zzk(this.zzH, this.zzn.zzc().zzc, this.zzA);
        }
        zzY();
    }

    private final void zzJ() {
        boolean z;
        this.zzv.zzc(this.zzu);
        z = this.zzv.zzg;
        if (z) {
            zzjk zzjkVar = this.zzM;
            zzjkVar.zza.zzT(this.zzv);
            this.zzv = new zzkx(this.zzu);
        }
    }

    private final void zzK() throws zziz {
        int i;
        float f = this.zzn.zzc().zzc;
        zzll zzllVar = this.zzq;
        zzli zzf = zzllVar.zzf();
        boolean z = true;
        for (zzli zze = zzllVar.zze(); zze != null && zze.zzd; zze = zze.zzg()) {
            zzyp zzj = zze.zzj(f, this.zzu.zza);
            zzyp zzi = zze.zzi();
            boolean z2 = false;
            if (zzi != null) {
                if (zzi.zzc.length == zzj.zzc.length) {
                    for (int i2 = 0; i2 < zzj.zzc.length; i2++) {
                        if (zzj.zza(zzi, i2)) {
                        }
                    }
                    if (zze != zzf) {
                        z2 = true;
                    }
                    z &= z2;
                }
            }
            if (z) {
                zzll zzllVar2 = this.zzq;
                zzli zze2 = zzllVar2.zze();
                boolean zzn = zzllVar2.zzn(zze2);
                int length = this.zza.length;
                boolean[] zArr = new boolean[2];
                long zzb = zze2.zzb(zzj, this.zzu.zzr, zzn, zArr);
                zzly zzlyVar = this.zzu;
                boolean z3 = (zzlyVar.zze == 4 || zzb == zzlyVar.zzr) ? false : true;
                zzly zzlyVar2 = this.zzu;
                i = 2;
                this.zzu = zzz(zzlyVar2.zzb, zzb, zzlyVar2.zzc, zzlyVar2.zzd, z3, 5);
                if (z3) {
                    zzO(zzb);
                }
                int length2 = this.zza.length;
                boolean[] zArr2 = new boolean[2];
                int i3 = 0;
                while (true) {
                    zzmf[] zzmfVarArr = this.zza;
                    int length3 = zzmfVarArr.length;
                    if (i3 >= 2) {
                        break;
                    }
                    zzmf zzmfVar = zzmfVarArr[i3];
                    boolean zzaf = zzaf(zzmfVar);
                    zArr2[i3] = zzaf;
                    zzwh zzwhVar = zze2.zzc[i3];
                    if (zzaf) {
                        if (zzwhVar != zzmfVar.zzo()) {
                            zzA(zzmfVar);
                        } else if (zArr[i3]) {
                            zzmfVar.zzI(this.zzH);
                        }
                    }
                    i3++;
                }
                zzC(zArr2, this.zzH);
            } else {
                i = 2;
                this.zzq.zzn(zze);
                if (zze.zzd) {
                    zze.zza(zzj, Math.max(zze.zzf.zzb, this.zzH - zze.zze()), false);
                }
            }
            zzE(true);
            if (this.zzu.zze != 4) {
                zzI();
                zzaa();
                this.zzh.zzi(i);
                return;
            }
            return;
        }
    }

    private final void zzL() throws zziz {
        zzK();
        zzR(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a0, code lost:
    
        if (r2.equals(r32.zzu.zzb) == false) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzM(boolean r33, boolean r34, boolean r35, boolean r36) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkz.zzM(boolean, boolean, boolean, boolean):void");
    }

    private final void zzN() {
        zzli zze = this.zzq.zze();
        boolean z = false;
        if (zze != null && zze.zzf.zzh && this.zzx) {
            z = true;
        }
        this.zzy = z;
    }

    private final void zzO(long j) throws zziz {
        zzli zze = this.zzq.zze();
        long zze2 = j + (zze == null ? 1000000000000L : zze.zze());
        this.zzH = zze2;
        this.zzn.zzf(zze2);
        zzmf[] zzmfVarArr = this.zza;
        int length = zzmfVarArr.length;
        for (int i = 0; i < 2; i++) {
            zzmf zzmfVar = zzmfVarArr[i];
            if (zzaf(zzmfVar)) {
                zzmfVar.zzI(this.zzH);
            }
        }
        for (zzli zze3 = this.zzq.zze(); zze3 != null; zze3 = zze3.zzg()) {
            for (zzyi zzyiVar : zze3.zzi().zzc) {
            }
        }
    }

    private final void zzP(zzcx zzcxVar, zzcx zzcxVar2) {
        if (zzcxVar.zzo() && zzcxVar2.zzo()) {
            return;
        }
        int size = this.zzo.size() - 1;
        if (size >= 0) {
            zzkw zzkwVar = (zzkw) this.zzo.get(size);
            Object obj = zzkwVar.zzb;
            zzmb zzmbVar = zzkwVar.zza;
            int i = zzfy.zza;
            zzmb zzmbVar2 = zzkwVar.zza;
            throw null;
        }
        Collections.sort(this.zzo);
    }

    private final void zzQ(long j, long j2) {
        this.zzh.zzj(2, j + j2);
    }

    private final void zzR(boolean z) throws zziz {
        zzur zzurVar = this.zzq.zze().zzf.zza;
        long zzw = zzw(zzurVar, this.zzu.zzr, true, false);
        if (zzw != this.zzu.zzr) {
            zzly zzlyVar = this.zzu;
            this.zzu = zzz(zzurVar, zzw, zzlyVar.zzc, zzlyVar.zzd, z, 5);
        }
    }

    private final void zzS(zzcg zzcgVar) {
        this.zzh.zzf(16);
        this.zzn.zzg(zzcgVar);
    }

    private final void zzT(boolean z, int i, boolean z2, int i2) throws zziz {
        this.zzv.zza(z2 ? 1 : 0);
        this.zzv.zzb(i2);
        this.zzu = this.zzu.zzc(z, i);
        zzac(false, false);
        for (zzli zze = this.zzq.zze(); zze != null; zze = zze.zzg()) {
            for (zzyi zzyiVar : zze.zzi().zzc) {
            }
        }
        if (!zzai()) {
            zzX();
            zzaa();
            return;
        }
        int i3 = this.zzu.zze;
        if (i3 == 3) {
            zzV();
            this.zzh.zzi(2);
        } else if (i3 == 2) {
            this.zzh.zzi(2);
        }
    }

    private final void zzU(int i) {
        zzly zzlyVar = this.zzu;
        if (zzlyVar.zze != i) {
            if (i != 2) {
                this.zzL = -9223372036854775807L;
            }
            this.zzu = zzlyVar.zze(i);
        }
    }

    private final void zzV() throws zziz {
        zzac(false, false);
        this.zzn.zzh();
        zzmf[] zzmfVarArr = this.zza;
        int length = zzmfVarArr.length;
        for (int i = 0; i < 2; i++) {
            zzmf zzmfVar = zzmfVarArr[i];
            if (zzaf(zzmfVar)) {
                zzmfVar.zzN();
            }
        }
    }

    private final void zzW(boolean z, boolean z2) {
        zzM(z || !this.zzE, false, true, false);
        this.zzv.zza(z2 ? 1 : 0);
        this.zzf.zzd();
        zzU(1);
    }

    private final void zzX() throws zziz {
        this.zzn.zzi();
        zzmf[] zzmfVarArr = this.zza;
        int length = zzmfVarArr.length;
        for (int i = 0; i < 2; i++) {
            zzmf zzmfVar = zzmfVarArr[i];
            if (zzaf(zzmfVar)) {
                zzam(zzmfVar);
            }
        }
    }

    private final void zzY() {
        zzli zzd = this.zzq.zzd();
        boolean z = this.zzB || (zzd != null && zzd.zza.zzp());
        zzly zzlyVar = this.zzu;
        if (z != zzlyVar.zzg) {
            zzcx zzcxVar = zzlyVar.zza;
            zzur zzurVar = zzlyVar.zzb;
            long j = zzlyVar.zzc;
            long j2 = zzlyVar.zzd;
            int i = zzlyVar.zze;
            zziz zzizVar = zzlyVar.zzf;
            zzws zzwsVar = zzlyVar.zzh;
            zzyp zzypVar = zzlyVar.zzi;
            List list = zzlyVar.zzj;
            zzur zzurVar2 = zzlyVar.zzk;
            boolean z2 = zzlyVar.zzl;
            int i2 = zzlyVar.zzm;
            zzcg zzcgVar = zzlyVar.zzn;
            long j3 = zzlyVar.zzp;
            long j4 = zzlyVar.zzq;
            long j5 = zzlyVar.zzr;
            long j6 = zzlyVar.zzs;
            boolean z3 = zzlyVar.zzo;
            this.zzu = new zzly(zzcxVar, zzurVar, j, j2, i, zzizVar, z, zzwsVar, zzypVar, list, zzurVar2, z2, i2, zzcgVar, j3, j4, j5, j6, false);
        }
    }

    private final void zzZ(zzur zzurVar, zzws zzwsVar, zzyp zzypVar) {
        zzcx zzcxVar = this.zzu.zza;
        zzyi[] zzyiVarArr = zzypVar.zzc;
        this.zzf.zze(zzcxVar, zzurVar, this.zza, zzwsVar, zzyiVarArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ad, code lost:
    
        r5 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzaa() throws com.google.android.gms.internal.ads.zziz {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkz.zzaa():void");
    }

    private final void zzab(zzcx zzcxVar, zzur zzurVar, zzcx zzcxVar2, zzur zzurVar2, long j, boolean z) throws zziz {
        if (!zzaj(zzcxVar, zzurVar)) {
            zzcg zzcgVar = zzurVar.zzb() ? zzcg.zza : this.zzu.zzn;
            if (this.zzn.zzc().equals(zzcgVar)) {
                return;
            }
            zzS(zzcgVar);
            zzH(this.zzu.zzn, zzcgVar.zzc, false, false);
            return;
        }
        zzcxVar.zze(zzcxVar.zzn(zzurVar.zza, this.zzl).zzd, this.zzk, 0L);
        zziu zziuVar = this.zzN;
        zzbf zzbfVar = this.zzk.zzl;
        int i = zzfy.zza;
        zziuVar.zzd(zzbfVar);
        if (j != -9223372036854775807L) {
            this.zzN.zze(zzs(zzcxVar, zzurVar.zza, j));
            return;
        }
        if (!zzfy.zzF(!zzcxVar2.zzo() ? zzcxVar2.zze(zzcxVar2.zzn(zzurVar2.zza, this.zzl).zzd, this.zzk, 0L).zzc : null, this.zzk.zzc) || z) {
            this.zzN.zze(-9223372036854775807L);
        }
    }

    private final void zzac(boolean z, boolean z2) {
        this.zzz = z;
        this.zzA = z2 ? -9223372036854775807L : SystemClock.elapsedRealtime();
    }

    private final synchronized void zzad(zzfxu zzfxuVar, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime() + j;
        boolean z = false;
        while (!Boolean.valueOf(((zzkp) zzfxuVar).zza.zzw).booleanValue() && j > 0) {
            try {
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = elapsedRealtime - SystemClock.elapsedRealtime();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private final boolean zzae() {
        zzli zzd = this.zzq.zzd();
        return (zzd == null || zzd.zzd() == Long.MIN_VALUE) ? false : true;
    }

    private static boolean zzaf(zzmf zzmfVar) {
        return zzmfVar.zzbf() != 0;
    }

    private final boolean zzag() {
        zzli zze = this.zzq.zze();
        long j = zze.zzf.zze;
        if (!zze.zzd) {
            return false;
        }
        if (j == -9223372036854775807L || this.zzu.zzr < j) {
            return true;
        }
        return !zzai();
    }

    private static boolean zzah(zzly zzlyVar, zzcu zzcuVar) {
        zzur zzurVar = zzlyVar.zzb;
        zzcx zzcxVar = zzlyVar.zza;
        return zzcxVar.zzo() || zzcxVar.zzn(zzurVar.zza, zzcuVar).zzg;
    }

    private final boolean zzai() {
        zzly zzlyVar = this.zzu;
        return zzlyVar.zzl && zzlyVar.zzm == 0;
    }

    private final boolean zzaj(zzcx zzcxVar, zzur zzurVar) {
        if (!zzurVar.zzb() && !zzcxVar.zzo()) {
            zzcxVar.zze(zzcxVar.zzn(zzurVar.zza, this.zzl).zzd, this.zzk, 0L);
            if (this.zzk.zzb()) {
                zzcw zzcwVar = this.zzk;
                if (zzcwVar.zzj && zzcwVar.zzg != -9223372036854775807L) {
                    return true;
                }
            }
        }
        return false;
    }

    private static zzam[] zzak(zzyi zzyiVar) {
        int zzc = zzyiVar != null ? zzyiVar.zzc() : 0;
        zzam[] zzamVarArr = new zzam[zzc];
        for (int i = 0; i < zzc; i++) {
            zzamVarArr[i] = zzyiVar.zzd(i);
        }
        return zzamVarArr;
    }

    private static final void zzal(zzmb zzmbVar) throws zziz {
        zzmbVar.zzj();
        try {
            zzmbVar.zzc().zzt(zzmbVar.zza(), zzmbVar.zzg());
        } finally {
            zzmbVar.zzh(true);
        }
    }

    private static final void zzam(zzmf zzmfVar) {
        if (zzmfVar.zzbf() == 2) {
            zzmfVar.zzO();
        }
    }

    private static final void zzan(zzmf zzmfVar, long j) {
        zzmfVar.zzJ();
        if (zzmfVar instanceof zzww) {
            throw null;
        }
    }

    public static /* synthetic */ zzli zzd(zzkz zzkzVar, zzlj zzljVar, long j) {
        zzlc zzlcVar = zzkzVar.zzf;
        zzyo zzyoVar = zzkzVar.zzd;
        zzyx zzi = zzlcVar.zzi();
        zzyp zzypVar = zzkzVar.zze;
        return new zzli(zzkzVar.zzc, j, zzyoVar, zzi, zzkzVar.zzr, zzljVar, zzypVar);
    }

    static Object zzf(zzcw zzcwVar, zzcu zzcuVar, int i, boolean z, Object obj, zzcx zzcxVar, zzcx zzcxVar2) {
        int zza = zzcxVar.zza(obj);
        int zzb = zzcxVar.zzb();
        int i2 = 0;
        int i3 = zza;
        int i4 = -1;
        while (true) {
            if (i2 >= zzb || i4 != -1) {
                break;
            }
            i3 = zzcxVar.zzi(i3, zzcuVar, zzcwVar, i, z);
            if (i3 == -1) {
                i4 = -1;
                break;
            }
            i4 = zzcxVar2.zza(zzcxVar.zzf(i3));
            i2++;
        }
        if (i4 == -1) {
            return null;
        }
        return zzcxVar2.zzf(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zzr(zzmb zzmbVar) {
        try {
            zzal(zzmbVar);
        } catch (zziz e) {
            zzff.zzd("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    private final long zzs(zzcx zzcxVar, Object obj, long j) {
        long elapsedRealtime;
        zzcxVar.zze(zzcxVar.zzn(obj, this.zzl).zzd, this.zzk, 0L);
        zzcw zzcwVar = this.zzk;
        if (zzcwVar.zzg != -9223372036854775807L && zzcwVar.zzb()) {
            zzcw zzcwVar2 = this.zzk;
            if (zzcwVar2.zzj) {
                long j2 = zzcwVar2.zzh;
                if (j2 == -9223372036854775807L) {
                    elapsedRealtime = System.currentTimeMillis();
                } else {
                    elapsedRealtime = j2 + SystemClock.elapsedRealtime();
                }
                return zzfy.zzq(elapsedRealtime - this.zzk.zzg) - j;
            }
        }
        return -9223372036854775807L;
    }

    private final long zzt() {
        return zzu(this.zzu.zzp);
    }

    private final long zzu(long j) {
        zzli zzd = this.zzq.zzd();
        if (zzd == null) {
            return 0L;
        }
        return Math.max(0L, j - (this.zzH - zzd.zze()));
    }

    private final long zzv(zzur zzurVar, long j, boolean z) throws zziz {
        zzll zzllVar = this.zzq;
        return zzw(zzurVar, j, zzllVar.zze() != zzllVar.zzf(), z);
    }

    private final long zzw(zzur zzurVar, long j, boolean z, boolean z2) throws zziz {
        zzX();
        zzac(false, true);
        if (z2 || this.zzu.zze == 3) {
            zzU(2);
        }
        zzli zze = this.zzq.zze();
        zzli zzliVar = zze;
        while (zzliVar != null && !zzurVar.equals(zzliVar.zzf.zza)) {
            zzliVar = zzliVar.zzg();
        }
        if (z || zze != zzliVar || (zzliVar != null && zzliVar.zze() + j < 0)) {
            zzmf[] zzmfVarArr = this.zza;
            int length = zzmfVarArr.length;
            for (int i = 0; i < 2; i++) {
                zzA(zzmfVarArr[i]);
            }
            if (zzliVar != null) {
                while (this.zzq.zze() != zzliVar) {
                    this.zzq.zza();
                }
                this.zzq.zzn(zzliVar);
                zzliVar.zzp(1000000000000L);
                zzB();
            }
        }
        if (zzliVar != null) {
            this.zzq.zzn(zzliVar);
            if (!zzliVar.zzd) {
                zzliVar.zzf = zzliVar.zzf.zzb(j);
            } else if (zzliVar.zze) {
                j = zzliVar.zza.zze(j);
                zzliVar.zza.zzj(j - this.zzm, false);
            }
            zzO(j);
            zzI();
        } else {
            this.zzq.zzj();
            zzO(j);
        }
        zzE(false);
        this.zzh.zzi(2);
        return j;
    }

    private final Pair zzx(zzcx zzcxVar) {
        long j = 0;
        if (zzcxVar.zzo()) {
            return Pair.create(zzly.zzh(), 0L);
        }
        Pair zzl = zzcxVar.zzl(this.zzk, this.zzl, zzcxVar.zzg(this.zzD), -9223372036854775807L);
        zzur zzi = this.zzq.zzi(zzcxVar, zzl.first, 0L);
        long longValue = ((Long) zzl.second).longValue();
        if (zzi.zzb()) {
            zzcxVar.zzn(zzi.zza, this.zzl);
            if (zzi.zzc == this.zzl.zze(zzi.zzb)) {
                this.zzl.zzj();
            }
        } else {
            j = longValue;
        }
        return Pair.create(zzi, Long.valueOf(j));
    }

    private static Pair zzy(zzcx zzcxVar, zzky zzkyVar, boolean z, int i, boolean z2, zzcw zzcwVar, zzcu zzcuVar) {
        Pair zzl;
        zzcx zzcxVar2 = zzkyVar.zza;
        if (zzcxVar.zzo()) {
            return null;
        }
        zzcx zzcxVar3 = true == zzcxVar2.zzo() ? zzcxVar : zzcxVar2;
        try {
            zzl = zzcxVar3.zzl(zzcwVar, zzcuVar, zzkyVar.zzb, zzkyVar.zzc);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (zzcxVar.equals(zzcxVar3)) {
            return zzl;
        }
        if (zzcxVar.zza(zzl.first) != -1) {
            return (zzcxVar3.zzn(zzl.first, zzcuVar).zzg && zzcxVar3.zze(zzcuVar.zzd, zzcwVar, 0L).zzp == zzcxVar3.zza(zzl.first)) ? zzcxVar.zzl(zzcwVar, zzcuVar, zzcxVar.zzn(zzl.first, zzcuVar).zzd, zzkyVar.zzc) : zzl;
        }
        Object zzf = zzf(zzcwVar, zzcuVar, i, z2, zzl.first, zzcxVar3, zzcxVar);
        if (zzf != null) {
            return zzcxVar.zzl(zzcwVar, zzcuVar, zzcxVar.zzn(zzf, zzcuVar).zzd, -9223372036854775807L);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.android.gms.internal.ads.zzly zzz(com.google.android.gms.internal.ads.zzur r17, long r18, long r20, long r22, boolean r24, int r25) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkz.zzz(com.google.android.gms.internal.ads.zzur, long, long, long, boolean, int):com.google.android.gms.internal.ads.zzly");
    }

    /* JADX WARN: Code restructure failed: missing block: B:506:0x07e7, code lost:
    
        if (zzag() != false) goto L406;
     */
    /* JADX WARN: Code restructure failed: missing block: B:555:0x088b, code lost:
    
        if (r7 == false) goto L443;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0011. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:234:0x05fd A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:8:0x0016, B:12:0x002e, B:13:0x0033, B:14:0x0038, B:17:0x003f, B:19:0x0048, B:21:0x0056, B:23:0x005e, B:24:0x0069, B:25:0x007d, B:26:0x0095, B:27:0x00b1, B:29:0x00c0, B:30:0x00c4, B:31:0x00d5, B:33:0x00e4, B:34:0x0100, B:35:0x0113, B:36:0x011c, B:38:0x012e, B:39:0x013a, B:40:0x014a, B:42:0x0156, B:45:0x0161, B:46:0x0168, B:47:0x0175, B:50:0x017c, B:52:0x0184, B:54:0x0188, B:56:0x018e, B:58:0x0196, B:60:0x019e, B:62:0x01a1, B:67:0x01a6, B:76:0x01b3, B:78:0x01b4, B:81:0x01bb, B:83:0x01c9, B:84:0x01cc, B:86:0x01d1, B:88:0x01e1, B:89:0x01e4, B:90:0x01e9, B:91:0x01ee, B:93:0x01fa, B:94:0x0206, B:96:0x0212, B:98:0x023e, B:99:0x025e, B:100:0x0262, B:101:0x0266, B:103:0x026b, B:105:0x027c, B:107:0x0288, B:108:0x028b, B:117:0x0296, B:118:0x0297, B:119:0x029d, B:120:0x02a4, B:121:0x02b5, B:123:0x02dc, B:131:0x03f3, B:132:0x03c0, B:159:0x03bc, B:174:0x0404, B:175:0x0411, B:189:0x02fe, B:192:0x0311, B:194:0x0321, B:196:0x0338, B:198:0x0342, B:205:0x0412, B:207:0x0426, B:210:0x0430, B:212:0x043f, B:214:0x044b, B:216:0x0460, B:217:0x0465, B:218:0x0469, B:220:0x046d, B:221:0x047a, B:224:0x05d6, B:226:0x05de, B:228:0x05e6, B:231:0x05eb, B:232:0x05f7, B:234:0x05fd, B:236:0x0605, B:241:0x0615, B:243:0x061b, B:245:0x063b, B:247:0x0641, B:240:0x0646, B:254:0x064b, B:256:0x064f, B:258:0x0655, B:260:0x0659, B:262:0x0661, B:264:0x0667, B:266:0x0671, B:269:0x0677, B:270:0x067a, B:272:0x0683, B:274:0x0695, B:276:0x069e, B:278:0x06a6, B:281:0x06b0, B:282:0x06dc, B:284:0x06e2, B:286:0x06e8, B:288:0x06ef, B:301:0x0489, B:303:0x048f, B:306:0x0495, B:309:0x04a0, B:311:0x04a5, B:314:0x04b3, B:317:0x04b9, B:319:0x04c1, B:323:0x04c4, B:325:0x04cc, B:327:0x04da, B:329:0x0516, B:331:0x0520, B:334:0x052b, B:336:0x0533, B:338:0x0536, B:341:0x0539, B:343:0x053f, B:345:0x054e, B:347:0x0554, B:349:0x0560, B:351:0x056a, B:353:0x057b, B:357:0x0581, B:356:0x058c, B:362:0x0591, B:364:0x059c, B:367:0x05a1, B:369:0x05a7, B:371:0x05af, B:373:0x05b5, B:375:0x05bb, B:379:0x05c9, B:380:0x05d0, B:382:0x05d3, B:388:0x0477, B:389:0x06fb, B:393:0x0706, B:395:0x0710, B:396:0x0715, B:398:0x0723, B:399:0x073b, B:401:0x0741, B:403:0x0749, B:405:0x0750, B:408:0x0759, B:412:0x0768, B:417:0x0775, B:419:0x077b, B:427:0x078e, B:430:0x0793, B:438:0x079f, B:440:0x07a5, B:444:0x07b2, B:446:0x07ba, B:448:0x07be, B:449:0x07c9, B:451:0x07cf, B:452:0x08c1, B:455:0x08c9, B:457:0x08ce, B:459:0x08d6, B:461:0x08e4, B:463:0x08eb, B:467:0x08ef, B:469:0x08f5, B:471:0x08fe, B:473:0x0904, B:475:0x090f, B:476:0x0933, B:478:0x0939, B:481:0x0942, B:484:0x0964, B:490:0x0955, B:492:0x0959, B:493:0x095f, B:495:0x0916, B:498:0x0924, B:499:0x092b, B:500:0x092c, B:501:0x07d8, B:503:0x07df, B:505:0x07e3, B:508:0x0869, B:510:0x0875, B:513:0x07f0, B:515:0x07f4, B:517:0x0808, B:518:0x0816, B:520:0x0822, B:523:0x082b, B:525:0x0835, B:530:0x0840, B:536:0x0879, B:538:0x0880, B:540:0x0884, B:543:0x088d, B:545:0x089d, B:547:0x08a5, B:549:0x08af, B:551:0x08b4, B:553:0x08b9, B:554:0x08be, B:556:0x0798, B:557:0x0969, B:560:0x0970, B:562:0x0978, B:565:0x0996), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0649 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0677 A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:8:0x0016, B:12:0x002e, B:13:0x0033, B:14:0x0038, B:17:0x003f, B:19:0x0048, B:21:0x0056, B:23:0x005e, B:24:0x0069, B:25:0x007d, B:26:0x0095, B:27:0x00b1, B:29:0x00c0, B:30:0x00c4, B:31:0x00d5, B:33:0x00e4, B:34:0x0100, B:35:0x0113, B:36:0x011c, B:38:0x012e, B:39:0x013a, B:40:0x014a, B:42:0x0156, B:45:0x0161, B:46:0x0168, B:47:0x0175, B:50:0x017c, B:52:0x0184, B:54:0x0188, B:56:0x018e, B:58:0x0196, B:60:0x019e, B:62:0x01a1, B:67:0x01a6, B:76:0x01b3, B:78:0x01b4, B:81:0x01bb, B:83:0x01c9, B:84:0x01cc, B:86:0x01d1, B:88:0x01e1, B:89:0x01e4, B:90:0x01e9, B:91:0x01ee, B:93:0x01fa, B:94:0x0206, B:96:0x0212, B:98:0x023e, B:99:0x025e, B:100:0x0262, B:101:0x0266, B:103:0x026b, B:105:0x027c, B:107:0x0288, B:108:0x028b, B:117:0x0296, B:118:0x0297, B:119:0x029d, B:120:0x02a4, B:121:0x02b5, B:123:0x02dc, B:131:0x03f3, B:132:0x03c0, B:159:0x03bc, B:174:0x0404, B:175:0x0411, B:189:0x02fe, B:192:0x0311, B:194:0x0321, B:196:0x0338, B:198:0x0342, B:205:0x0412, B:207:0x0426, B:210:0x0430, B:212:0x043f, B:214:0x044b, B:216:0x0460, B:217:0x0465, B:218:0x0469, B:220:0x046d, B:221:0x047a, B:224:0x05d6, B:226:0x05de, B:228:0x05e6, B:231:0x05eb, B:232:0x05f7, B:234:0x05fd, B:236:0x0605, B:241:0x0615, B:243:0x061b, B:245:0x063b, B:247:0x0641, B:240:0x0646, B:254:0x064b, B:256:0x064f, B:258:0x0655, B:260:0x0659, B:262:0x0661, B:264:0x0667, B:266:0x0671, B:269:0x0677, B:270:0x067a, B:272:0x0683, B:274:0x0695, B:276:0x069e, B:278:0x06a6, B:281:0x06b0, B:282:0x06dc, B:284:0x06e2, B:286:0x06e8, B:288:0x06ef, B:301:0x0489, B:303:0x048f, B:306:0x0495, B:309:0x04a0, B:311:0x04a5, B:314:0x04b3, B:317:0x04b9, B:319:0x04c1, B:323:0x04c4, B:325:0x04cc, B:327:0x04da, B:329:0x0516, B:331:0x0520, B:334:0x052b, B:336:0x0533, B:338:0x0536, B:341:0x0539, B:343:0x053f, B:345:0x054e, B:347:0x0554, B:349:0x0560, B:351:0x056a, B:353:0x057b, B:357:0x0581, B:356:0x058c, B:362:0x0591, B:364:0x059c, B:367:0x05a1, B:369:0x05a7, B:371:0x05af, B:373:0x05b5, B:375:0x05bb, B:379:0x05c9, B:380:0x05d0, B:382:0x05d3, B:388:0x0477, B:389:0x06fb, B:393:0x0706, B:395:0x0710, B:396:0x0715, B:398:0x0723, B:399:0x073b, B:401:0x0741, B:403:0x0749, B:405:0x0750, B:408:0x0759, B:412:0x0768, B:417:0x0775, B:419:0x077b, B:427:0x078e, B:430:0x0793, B:438:0x079f, B:440:0x07a5, B:444:0x07b2, B:446:0x07ba, B:448:0x07be, B:449:0x07c9, B:451:0x07cf, B:452:0x08c1, B:455:0x08c9, B:457:0x08ce, B:459:0x08d6, B:461:0x08e4, B:463:0x08eb, B:467:0x08ef, B:469:0x08f5, B:471:0x08fe, B:473:0x0904, B:475:0x090f, B:476:0x0933, B:478:0x0939, B:481:0x0942, B:484:0x0964, B:490:0x0955, B:492:0x0959, B:493:0x095f, B:495:0x0916, B:498:0x0924, B:499:0x092b, B:500:0x092c, B:501:0x07d8, B:503:0x07df, B:505:0x07e3, B:508:0x0869, B:510:0x0875, B:513:0x07f0, B:515:0x07f4, B:517:0x0808, B:518:0x0816, B:520:0x0822, B:523:0x082b, B:525:0x0835, B:530:0x0840, B:536:0x0879, B:538:0x0880, B:540:0x0884, B:543:0x088d, B:545:0x089d, B:547:0x08a5, B:549:0x08af, B:551:0x08b4, B:553:0x08b9, B:554:0x08be, B:556:0x0798, B:557:0x0969, B:560:0x0970, B:562:0x0978, B:565:0x0996), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0695 A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:8:0x0016, B:12:0x002e, B:13:0x0033, B:14:0x0038, B:17:0x003f, B:19:0x0048, B:21:0x0056, B:23:0x005e, B:24:0x0069, B:25:0x007d, B:26:0x0095, B:27:0x00b1, B:29:0x00c0, B:30:0x00c4, B:31:0x00d5, B:33:0x00e4, B:34:0x0100, B:35:0x0113, B:36:0x011c, B:38:0x012e, B:39:0x013a, B:40:0x014a, B:42:0x0156, B:45:0x0161, B:46:0x0168, B:47:0x0175, B:50:0x017c, B:52:0x0184, B:54:0x0188, B:56:0x018e, B:58:0x0196, B:60:0x019e, B:62:0x01a1, B:67:0x01a6, B:76:0x01b3, B:78:0x01b4, B:81:0x01bb, B:83:0x01c9, B:84:0x01cc, B:86:0x01d1, B:88:0x01e1, B:89:0x01e4, B:90:0x01e9, B:91:0x01ee, B:93:0x01fa, B:94:0x0206, B:96:0x0212, B:98:0x023e, B:99:0x025e, B:100:0x0262, B:101:0x0266, B:103:0x026b, B:105:0x027c, B:107:0x0288, B:108:0x028b, B:117:0x0296, B:118:0x0297, B:119:0x029d, B:120:0x02a4, B:121:0x02b5, B:123:0x02dc, B:131:0x03f3, B:132:0x03c0, B:159:0x03bc, B:174:0x0404, B:175:0x0411, B:189:0x02fe, B:192:0x0311, B:194:0x0321, B:196:0x0338, B:198:0x0342, B:205:0x0412, B:207:0x0426, B:210:0x0430, B:212:0x043f, B:214:0x044b, B:216:0x0460, B:217:0x0465, B:218:0x0469, B:220:0x046d, B:221:0x047a, B:224:0x05d6, B:226:0x05de, B:228:0x05e6, B:231:0x05eb, B:232:0x05f7, B:234:0x05fd, B:236:0x0605, B:241:0x0615, B:243:0x061b, B:245:0x063b, B:247:0x0641, B:240:0x0646, B:254:0x064b, B:256:0x064f, B:258:0x0655, B:260:0x0659, B:262:0x0661, B:264:0x0667, B:266:0x0671, B:269:0x0677, B:270:0x067a, B:272:0x0683, B:274:0x0695, B:276:0x069e, B:278:0x06a6, B:281:0x06b0, B:282:0x06dc, B:284:0x06e2, B:286:0x06e8, B:288:0x06ef, B:301:0x0489, B:303:0x048f, B:306:0x0495, B:309:0x04a0, B:311:0x04a5, B:314:0x04b3, B:317:0x04b9, B:319:0x04c1, B:323:0x04c4, B:325:0x04cc, B:327:0x04da, B:329:0x0516, B:331:0x0520, B:334:0x052b, B:336:0x0533, B:338:0x0536, B:341:0x0539, B:343:0x053f, B:345:0x054e, B:347:0x0554, B:349:0x0560, B:351:0x056a, B:353:0x057b, B:357:0x0581, B:356:0x058c, B:362:0x0591, B:364:0x059c, B:367:0x05a1, B:369:0x05a7, B:371:0x05af, B:373:0x05b5, B:375:0x05bb, B:379:0x05c9, B:380:0x05d0, B:382:0x05d3, B:388:0x0477, B:389:0x06fb, B:393:0x0706, B:395:0x0710, B:396:0x0715, B:398:0x0723, B:399:0x073b, B:401:0x0741, B:403:0x0749, B:405:0x0750, B:408:0x0759, B:412:0x0768, B:417:0x0775, B:419:0x077b, B:427:0x078e, B:430:0x0793, B:438:0x079f, B:440:0x07a5, B:444:0x07b2, B:446:0x07ba, B:448:0x07be, B:449:0x07c9, B:451:0x07cf, B:452:0x08c1, B:455:0x08c9, B:457:0x08ce, B:459:0x08d6, B:461:0x08e4, B:463:0x08eb, B:467:0x08ef, B:469:0x08f5, B:471:0x08fe, B:473:0x0904, B:475:0x090f, B:476:0x0933, B:478:0x0939, B:481:0x0942, B:484:0x0964, B:490:0x0955, B:492:0x0959, B:493:0x095f, B:495:0x0916, B:498:0x0924, B:499:0x092b, B:500:0x092c, B:501:0x07d8, B:503:0x07df, B:505:0x07e3, B:508:0x0869, B:510:0x0875, B:513:0x07f0, B:515:0x07f4, B:517:0x0808, B:518:0x0816, B:520:0x0822, B:523:0x082b, B:525:0x0835, B:530:0x0840, B:536:0x0879, B:538:0x0880, B:540:0x0884, B:543:0x088d, B:545:0x089d, B:547:0x08a5, B:549:0x08af, B:551:0x08b4, B:553:0x08b9, B:554:0x08be, B:556:0x0798, B:557:0x0969, B:560:0x0970, B:562:0x0978, B:565:0x0996), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:284:0x06e2 A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:8:0x0016, B:12:0x002e, B:13:0x0033, B:14:0x0038, B:17:0x003f, B:19:0x0048, B:21:0x0056, B:23:0x005e, B:24:0x0069, B:25:0x007d, B:26:0x0095, B:27:0x00b1, B:29:0x00c0, B:30:0x00c4, B:31:0x00d5, B:33:0x00e4, B:34:0x0100, B:35:0x0113, B:36:0x011c, B:38:0x012e, B:39:0x013a, B:40:0x014a, B:42:0x0156, B:45:0x0161, B:46:0x0168, B:47:0x0175, B:50:0x017c, B:52:0x0184, B:54:0x0188, B:56:0x018e, B:58:0x0196, B:60:0x019e, B:62:0x01a1, B:67:0x01a6, B:76:0x01b3, B:78:0x01b4, B:81:0x01bb, B:83:0x01c9, B:84:0x01cc, B:86:0x01d1, B:88:0x01e1, B:89:0x01e4, B:90:0x01e9, B:91:0x01ee, B:93:0x01fa, B:94:0x0206, B:96:0x0212, B:98:0x023e, B:99:0x025e, B:100:0x0262, B:101:0x0266, B:103:0x026b, B:105:0x027c, B:107:0x0288, B:108:0x028b, B:117:0x0296, B:118:0x0297, B:119:0x029d, B:120:0x02a4, B:121:0x02b5, B:123:0x02dc, B:131:0x03f3, B:132:0x03c0, B:159:0x03bc, B:174:0x0404, B:175:0x0411, B:189:0x02fe, B:192:0x0311, B:194:0x0321, B:196:0x0338, B:198:0x0342, B:205:0x0412, B:207:0x0426, B:210:0x0430, B:212:0x043f, B:214:0x044b, B:216:0x0460, B:217:0x0465, B:218:0x0469, B:220:0x046d, B:221:0x047a, B:224:0x05d6, B:226:0x05de, B:228:0x05e6, B:231:0x05eb, B:232:0x05f7, B:234:0x05fd, B:236:0x0605, B:241:0x0615, B:243:0x061b, B:245:0x063b, B:247:0x0641, B:240:0x0646, B:254:0x064b, B:256:0x064f, B:258:0x0655, B:260:0x0659, B:262:0x0661, B:264:0x0667, B:266:0x0671, B:269:0x0677, B:270:0x067a, B:272:0x0683, B:274:0x0695, B:276:0x069e, B:278:0x06a6, B:281:0x06b0, B:282:0x06dc, B:284:0x06e2, B:286:0x06e8, B:288:0x06ef, B:301:0x0489, B:303:0x048f, B:306:0x0495, B:309:0x04a0, B:311:0x04a5, B:314:0x04b3, B:317:0x04b9, B:319:0x04c1, B:323:0x04c4, B:325:0x04cc, B:327:0x04da, B:329:0x0516, B:331:0x0520, B:334:0x052b, B:336:0x0533, B:338:0x0536, B:341:0x0539, B:343:0x053f, B:345:0x054e, B:347:0x0554, B:349:0x0560, B:351:0x056a, B:353:0x057b, B:357:0x0581, B:356:0x058c, B:362:0x0591, B:364:0x059c, B:367:0x05a1, B:369:0x05a7, B:371:0x05af, B:373:0x05b5, B:375:0x05bb, B:379:0x05c9, B:380:0x05d0, B:382:0x05d3, B:388:0x0477, B:389:0x06fb, B:393:0x0706, B:395:0x0710, B:396:0x0715, B:398:0x0723, B:399:0x073b, B:401:0x0741, B:403:0x0749, B:405:0x0750, B:408:0x0759, B:412:0x0768, B:417:0x0775, B:419:0x077b, B:427:0x078e, B:430:0x0793, B:438:0x079f, B:440:0x07a5, B:444:0x07b2, B:446:0x07ba, B:448:0x07be, B:449:0x07c9, B:451:0x07cf, B:452:0x08c1, B:455:0x08c9, B:457:0x08ce, B:459:0x08d6, B:461:0x08e4, B:463:0x08eb, B:467:0x08ef, B:469:0x08f5, B:471:0x08fe, B:473:0x0904, B:475:0x090f, B:476:0x0933, B:478:0x0939, B:481:0x0942, B:484:0x0964, B:490:0x0955, B:492:0x0959, B:493:0x095f, B:495:0x0916, B:498:0x0924, B:499:0x092b, B:500:0x092c, B:501:0x07d8, B:503:0x07df, B:505:0x07e3, B:508:0x0869, B:510:0x0875, B:513:0x07f0, B:515:0x07f4, B:517:0x0808, B:518:0x0816, B:520:0x0822, B:523:0x082b, B:525:0x0835, B:530:0x0840, B:536:0x0879, B:538:0x0880, B:540:0x0884, B:543:0x088d, B:545:0x089d, B:547:0x08a5, B:549:0x08af, B:551:0x08b4, B:553:0x08b9, B:554:0x08be, B:556:0x0798, B:557:0x0969, B:560:0x0970, B:562:0x0978, B:565:0x0996), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:293:0x06ae  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x078e A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:8:0x0016, B:12:0x002e, B:13:0x0033, B:14:0x0038, B:17:0x003f, B:19:0x0048, B:21:0x0056, B:23:0x005e, B:24:0x0069, B:25:0x007d, B:26:0x0095, B:27:0x00b1, B:29:0x00c0, B:30:0x00c4, B:31:0x00d5, B:33:0x00e4, B:34:0x0100, B:35:0x0113, B:36:0x011c, B:38:0x012e, B:39:0x013a, B:40:0x014a, B:42:0x0156, B:45:0x0161, B:46:0x0168, B:47:0x0175, B:50:0x017c, B:52:0x0184, B:54:0x0188, B:56:0x018e, B:58:0x0196, B:60:0x019e, B:62:0x01a1, B:67:0x01a6, B:76:0x01b3, B:78:0x01b4, B:81:0x01bb, B:83:0x01c9, B:84:0x01cc, B:86:0x01d1, B:88:0x01e1, B:89:0x01e4, B:90:0x01e9, B:91:0x01ee, B:93:0x01fa, B:94:0x0206, B:96:0x0212, B:98:0x023e, B:99:0x025e, B:100:0x0262, B:101:0x0266, B:103:0x026b, B:105:0x027c, B:107:0x0288, B:108:0x028b, B:117:0x0296, B:118:0x0297, B:119:0x029d, B:120:0x02a4, B:121:0x02b5, B:123:0x02dc, B:131:0x03f3, B:132:0x03c0, B:159:0x03bc, B:174:0x0404, B:175:0x0411, B:189:0x02fe, B:192:0x0311, B:194:0x0321, B:196:0x0338, B:198:0x0342, B:205:0x0412, B:207:0x0426, B:210:0x0430, B:212:0x043f, B:214:0x044b, B:216:0x0460, B:217:0x0465, B:218:0x0469, B:220:0x046d, B:221:0x047a, B:224:0x05d6, B:226:0x05de, B:228:0x05e6, B:231:0x05eb, B:232:0x05f7, B:234:0x05fd, B:236:0x0605, B:241:0x0615, B:243:0x061b, B:245:0x063b, B:247:0x0641, B:240:0x0646, B:254:0x064b, B:256:0x064f, B:258:0x0655, B:260:0x0659, B:262:0x0661, B:264:0x0667, B:266:0x0671, B:269:0x0677, B:270:0x067a, B:272:0x0683, B:274:0x0695, B:276:0x069e, B:278:0x06a6, B:281:0x06b0, B:282:0x06dc, B:284:0x06e2, B:286:0x06e8, B:288:0x06ef, B:301:0x0489, B:303:0x048f, B:306:0x0495, B:309:0x04a0, B:311:0x04a5, B:314:0x04b3, B:317:0x04b9, B:319:0x04c1, B:323:0x04c4, B:325:0x04cc, B:327:0x04da, B:329:0x0516, B:331:0x0520, B:334:0x052b, B:336:0x0533, B:338:0x0536, B:341:0x0539, B:343:0x053f, B:345:0x054e, B:347:0x0554, B:349:0x0560, B:351:0x056a, B:353:0x057b, B:357:0x0581, B:356:0x058c, B:362:0x0591, B:364:0x059c, B:367:0x05a1, B:369:0x05a7, B:371:0x05af, B:373:0x05b5, B:375:0x05bb, B:379:0x05c9, B:380:0x05d0, B:382:0x05d3, B:388:0x0477, B:389:0x06fb, B:393:0x0706, B:395:0x0710, B:396:0x0715, B:398:0x0723, B:399:0x073b, B:401:0x0741, B:403:0x0749, B:405:0x0750, B:408:0x0759, B:412:0x0768, B:417:0x0775, B:419:0x077b, B:427:0x078e, B:430:0x0793, B:438:0x079f, B:440:0x07a5, B:444:0x07b2, B:446:0x07ba, B:448:0x07be, B:449:0x07c9, B:451:0x07cf, B:452:0x08c1, B:455:0x08c9, B:457:0x08ce, B:459:0x08d6, B:461:0x08e4, B:463:0x08eb, B:467:0x08ef, B:469:0x08f5, B:471:0x08fe, B:473:0x0904, B:475:0x090f, B:476:0x0933, B:478:0x0939, B:481:0x0942, B:484:0x0964, B:490:0x0955, B:492:0x0959, B:493:0x095f, B:495:0x0916, B:498:0x0924, B:499:0x092b, B:500:0x092c, B:501:0x07d8, B:503:0x07df, B:505:0x07e3, B:508:0x0869, B:510:0x0875, B:513:0x07f0, B:515:0x07f4, B:517:0x0808, B:518:0x0816, B:520:0x0822, B:523:0x082b, B:525:0x0835, B:530:0x0840, B:536:0x0879, B:538:0x0880, B:540:0x0884, B:543:0x088d, B:545:0x089d, B:547:0x08a5, B:549:0x08af, B:551:0x08b4, B:553:0x08b9, B:554:0x08be, B:556:0x0798, B:557:0x0969, B:560:0x0970, B:562:0x0978, B:565:0x0996), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:454:0x08c8  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x0939 A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:8:0x0016, B:12:0x002e, B:13:0x0033, B:14:0x0038, B:17:0x003f, B:19:0x0048, B:21:0x0056, B:23:0x005e, B:24:0x0069, B:25:0x007d, B:26:0x0095, B:27:0x00b1, B:29:0x00c0, B:30:0x00c4, B:31:0x00d5, B:33:0x00e4, B:34:0x0100, B:35:0x0113, B:36:0x011c, B:38:0x012e, B:39:0x013a, B:40:0x014a, B:42:0x0156, B:45:0x0161, B:46:0x0168, B:47:0x0175, B:50:0x017c, B:52:0x0184, B:54:0x0188, B:56:0x018e, B:58:0x0196, B:60:0x019e, B:62:0x01a1, B:67:0x01a6, B:76:0x01b3, B:78:0x01b4, B:81:0x01bb, B:83:0x01c9, B:84:0x01cc, B:86:0x01d1, B:88:0x01e1, B:89:0x01e4, B:90:0x01e9, B:91:0x01ee, B:93:0x01fa, B:94:0x0206, B:96:0x0212, B:98:0x023e, B:99:0x025e, B:100:0x0262, B:101:0x0266, B:103:0x026b, B:105:0x027c, B:107:0x0288, B:108:0x028b, B:117:0x0296, B:118:0x0297, B:119:0x029d, B:120:0x02a4, B:121:0x02b5, B:123:0x02dc, B:131:0x03f3, B:132:0x03c0, B:159:0x03bc, B:174:0x0404, B:175:0x0411, B:189:0x02fe, B:192:0x0311, B:194:0x0321, B:196:0x0338, B:198:0x0342, B:205:0x0412, B:207:0x0426, B:210:0x0430, B:212:0x043f, B:214:0x044b, B:216:0x0460, B:217:0x0465, B:218:0x0469, B:220:0x046d, B:221:0x047a, B:224:0x05d6, B:226:0x05de, B:228:0x05e6, B:231:0x05eb, B:232:0x05f7, B:234:0x05fd, B:236:0x0605, B:241:0x0615, B:243:0x061b, B:245:0x063b, B:247:0x0641, B:240:0x0646, B:254:0x064b, B:256:0x064f, B:258:0x0655, B:260:0x0659, B:262:0x0661, B:264:0x0667, B:266:0x0671, B:269:0x0677, B:270:0x067a, B:272:0x0683, B:274:0x0695, B:276:0x069e, B:278:0x06a6, B:281:0x06b0, B:282:0x06dc, B:284:0x06e2, B:286:0x06e8, B:288:0x06ef, B:301:0x0489, B:303:0x048f, B:306:0x0495, B:309:0x04a0, B:311:0x04a5, B:314:0x04b3, B:317:0x04b9, B:319:0x04c1, B:323:0x04c4, B:325:0x04cc, B:327:0x04da, B:329:0x0516, B:331:0x0520, B:334:0x052b, B:336:0x0533, B:338:0x0536, B:341:0x0539, B:343:0x053f, B:345:0x054e, B:347:0x0554, B:349:0x0560, B:351:0x056a, B:353:0x057b, B:357:0x0581, B:356:0x058c, B:362:0x0591, B:364:0x059c, B:367:0x05a1, B:369:0x05a7, B:371:0x05af, B:373:0x05b5, B:375:0x05bb, B:379:0x05c9, B:380:0x05d0, B:382:0x05d3, B:388:0x0477, B:389:0x06fb, B:393:0x0706, B:395:0x0710, B:396:0x0715, B:398:0x0723, B:399:0x073b, B:401:0x0741, B:403:0x0749, B:405:0x0750, B:408:0x0759, B:412:0x0768, B:417:0x0775, B:419:0x077b, B:427:0x078e, B:430:0x0793, B:438:0x079f, B:440:0x07a5, B:444:0x07b2, B:446:0x07ba, B:448:0x07be, B:449:0x07c9, B:451:0x07cf, B:452:0x08c1, B:455:0x08c9, B:457:0x08ce, B:459:0x08d6, B:461:0x08e4, B:463:0x08eb, B:467:0x08ef, B:469:0x08f5, B:471:0x08fe, B:473:0x0904, B:475:0x090f, B:476:0x0933, B:478:0x0939, B:481:0x0942, B:484:0x0964, B:490:0x0955, B:492:0x0959, B:493:0x095f, B:495:0x0916, B:498:0x0924, B:499:0x092b, B:500:0x092c, B:501:0x07d8, B:503:0x07df, B:505:0x07e3, B:508:0x0869, B:510:0x0875, B:513:0x07f0, B:515:0x07f4, B:517:0x0808, B:518:0x0816, B:520:0x0822, B:523:0x082b, B:525:0x0835, B:530:0x0840, B:536:0x0879, B:538:0x0880, B:540:0x0884, B:543:0x088d, B:545:0x089d, B:547:0x08a5, B:549:0x08af, B:551:0x08b4, B:553:0x08b9, B:554:0x08be, B:556:0x0798, B:557:0x0969, B:560:0x0970, B:562:0x0978, B:565:0x0996), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:483:0x094c  */
    /* JADX WARN: Removed duplicated region for block: B:485:0x094d  */
    /* JADX WARN: Type inference failed for: r2v35, types: [com.google.android.gms.internal.ads.zzyw, com.google.android.gms.internal.ads.zzhy] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean handleMessage(android.os.Message r36) {
        /*
            Method dump skipped, instructions count: 2798
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkz.handleMessage(android.os.Message):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zziw
    public final void zza(zzcg zzcgVar) {
        this.zzh.zzc(16, zzcgVar).zza();
    }

    public final Looper zzb() {
        return this.zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Boolean zze() {
        return Boolean.valueOf(this.zzw);
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final /* bridge */ /* synthetic */ void zzg(zzwj zzwjVar) {
        this.zzh.zzc(9, (zzup) zzwjVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzlw
    public final void zzh() {
        this.zzh.zzi(22);
    }

    @Override // com.google.android.gms.internal.ads.zzuo
    public final void zzi(zzup zzupVar) {
        this.zzh.zzc(8, zzupVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzyn
    public final void zzj() {
        this.zzh.zzi(10);
    }

    public final void zzk() {
        this.zzh.zzb(0).zza();
    }

    public final void zzl(zzcx zzcxVar, int i, long j) {
        this.zzh.zzc(3, new zzky(zzcxVar, i, j)).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final synchronized void zzm(zzmb zzmbVar) {
        if (!this.zzw && this.zzj.getThread().isAlive()) {
            this.zzh.zzc(14, zzmbVar).zza();
            return;
        }
        zzff.zzf("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        zzmbVar.zzh(false);
    }

    public final void zzn(boolean z, int i) {
        this.zzh.zzd(1, z ? 1 : 0, i).zza();
    }

    public final void zzo() {
        this.zzh.zzb(6).zza();
    }

    public final synchronized boolean zzp() {
        if (!this.zzw && this.zzj.getThread().isAlive()) {
            this.zzh.zzi(7);
            zzad(new zzkp(this), this.zzs);
            return this.zzw;
        }
        return true;
    }

    public final void zzq(List list, int i, long j, zzwk zzwkVar) {
        this.zzh.zzc(17, new zzku(list, zzwkVar, i, j, null)).zza();
    }
}

package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzajh implements zzacu, zzadu {

    @Deprecated
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzajf
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i = zzada.zza;
            zzadb zzadbVar = zzajh.zza;
            return new zzacu[]{new zzajh()};
        }
    };
    private zzahe zzA;
    private final zzakp zzb;
    private final int zzc;
    private final zzfp zzd;
    private final zzfp zze;
    private final zzfp zzf;
    private final zzfp zzg;
    private final ArrayDeque zzh;
    private final zzajk zzi;
    private final List zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private int zzn;
    private zzfp zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private zzacx zzu;
    private zzajg[] zzv;
    private long[][] zzw;
    private int zzx;
    private long zzy;
    private int zzz;

    @Deprecated
    public zzajh() {
        this(zzakp.zza, 16);
    }

    private static int zzf(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static int zzi(zzajp zzajpVar, long j) {
        int zza2 = zzajpVar.zza(j);
        return zza2 == -1 ? zzajpVar.zzb(j) : zza2;
    }

    private static long zzj(zzajp zzajpVar, long j, long j2) {
        int zzi = zzi(zzajpVar, j);
        return zzi == -1 ? j2 : Math.min(zzajpVar.zzc[zzi], j2);
    }

    private final void zzk() {
        this.zzk = 0;
        this.zzn = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01af A[LOOP:3: B:85:0x01ad->B:86:0x01af, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzl(long r28) throws com.google.android.gms.internal.ads.zzcc {
        /*
            Method dump skipped, instructions count: 665
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajh.zzl(long):void");
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zzy;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        if ((this.zzc & 16) == 0) {
            zzacxVar = new zzaks(zzacxVar, this.zzb);
        }
        this.zzu = zzacxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j, long j2) {
        this.zzh.clear();
        this.zzn = 0;
        this.zzp = -1;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        if (j == 0) {
            if (this.zzk != 3) {
                zzk();
                return;
            } else {
                this.zzi.zzb();
                this.zzj.clear();
                return;
            }
        }
        for (zzajg zzajgVar : this.zzv) {
            zzajp zzajpVar = zzajgVar.zzb;
            int zza2 = zzajpVar.zza(j2);
            if (zza2 == -1) {
                zza2 = zzajpVar.zzb(j2);
            }
            zzajgVar.zze = zza2;
            zzaeb zzaebVar = zzajgVar.zzd;
            if (zzaebVar != null) {
                zzaebVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        return zzajl.zzb(zzacvVar, (this.zzc & 2) != 0);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j) {
        long j2;
        long j3;
        int zzb;
        zzajg[] zzajgVarArr = this.zzv;
        if (zzajgVarArr.length == 0) {
            zzadv zzadvVar = zzadv.zza;
            return new zzads(zzadvVar, zzadvVar);
        }
        int i = this.zzx;
        long j4 = -1;
        if (i != -1) {
            zzajp zzajpVar = zzajgVarArr[i].zzb;
            int zzi = zzi(zzajpVar, j);
            if (zzi == -1) {
                zzadv zzadvVar2 = zzadv.zza;
                return new zzads(zzadvVar2, zzadvVar2);
            }
            long j5 = zzajpVar.zzf[zzi];
            j2 = zzajpVar.zzc[zzi];
            if (j5 >= j || zzi >= zzajpVar.zzb - 1 || (zzb = zzajpVar.zzb(j)) == -1 || zzb == zzi) {
                j3 = -9223372036854775807L;
            } else {
                j3 = zzajpVar.zzf[zzb];
                j4 = zzajpVar.zzc[zzb];
            }
            j = j5;
        } else {
            j2 = Long.MAX_VALUE;
            j3 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            zzajg[] zzajgVarArr2 = this.zzv;
            if (i2 >= zzajgVarArr2.length) {
                break;
            }
            if (i2 != this.zzx) {
                zzajp zzajpVar2 = zzajgVarArr2[i2].zzb;
                long zzj = zzj(zzajpVar2, j, j2);
                if (j3 != -9223372036854775807L) {
                    j4 = zzj(zzajpVar2, j3, j4);
                }
                j2 = zzj;
            }
            i2++;
        }
        zzadv zzadvVar3 = new zzadv(j, j2);
        return j3 == -9223372036854775807L ? new zzads(zzadvVar3, zzadvVar3) : new zzads(zzadvVar3, new zzadv(j3, j4));
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }

    public zzajh(zzakp zzakpVar, int i) {
        this.zzb = zzakpVar;
        this.zzc = i;
        this.zzk = (i & 4) != 0 ? 3 : 0;
        this.zzi = new zzajk();
        this.zzj = new ArrayList();
        this.zzg = new zzfp(16);
        this.zzh = new ArrayDeque();
        this.zzd = new zzfp(zzgm.zza);
        this.zze = new zzfp(4);
        this.zzf = new zzfp();
        this.zzp = -1;
        this.zzu = zzacx.zza;
        this.zzv = new zzajg[0];
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x03e6, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:214:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0095 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzacu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(com.google.android.gms.internal.ads.zzacv r33, com.google.android.gms.internal.ads.zzadr r34) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1137
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajh.zzb(com.google.android.gms.internal.ads.zzacv, com.google.android.gms.internal.ads.zzadr):int");
    }
}

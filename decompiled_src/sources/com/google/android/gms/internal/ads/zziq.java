package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zziq implements zzmf, zzmh {
    private final int zzb;
    private zzmi zzd;
    private int zze;
    private zzpb zzf;
    private zzel zzg;
    private int zzh;
    private zzwh zzi;
    private zzam[] zzj;
    private long zzk;
    private long zzl;
    private boolean zzn;
    private boolean zzo;
    private zzmg zzq;
    private final Object zza = new Object();
    private final zzlb zzc = new zzlb();
    private long zzm = Long.MIN_VALUE;
    private zzcx zzp = zzcx.zza;

    public zziq(int i) {
        this.zzb = i;
    }

    private final void zzY(long j, boolean z) throws zziz {
        this.zzn = false;
        this.zzl = j;
        this.zzm = j;
        zzz(j, z);
    }

    protected void zzA() {
    }

    protected void zzB() {
    }

    protected void zzC() throws zziz {
    }

    protected void zzD() {
    }

    protected void zzE(zzam[] zzamVarArr, long j, long j2, zzur zzurVar) throws zziz {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzF() {
        zzek.zzf(this.zzh == 0);
        zzA();
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzG(zzam[] zzamVarArr, zzwh zzwhVar, long j, long j2, zzur zzurVar) throws zziz {
        zzek.zzf(!this.zzn);
        this.zzi = zzwhVar;
        if (this.zzm == Long.MIN_VALUE) {
            this.zzm = j;
        }
        this.zzj = zzamVarArr;
        this.zzk = j2;
        zzE(zzamVarArr, j, j2, zzurVar);
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzH() {
        zzek.zzf(this.zzh == 0);
        zzlb zzlbVar = this.zzc;
        zzlbVar.zzb = null;
        zzlbVar.zza = null;
        zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzI(long j) throws zziz {
        zzY(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzJ() {
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzmh
    public final void zzK(zzmg zzmgVar) {
        synchronized (this.zza) {
            this.zzq = zzmgVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public /* synthetic */ void zzL(float f, float f2) {
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzM(zzcx zzcxVar) {
        if (zzfy.zzF(this.zzp, zzcxVar)) {
            return;
        }
        this.zzp = zzcxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzN() throws zziz {
        zzek.zzf(this.zzh == 1);
        this.zzh = 2;
        zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzO() {
        zzek.zzf(this.zzh == 2);
        this.zzh = 1;
        zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final boolean zzP() {
        return this.zzm == Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final boolean zzQ() {
        return this.zzn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzam[] zzS() {
        zzam[] zzamVarArr = this.zzj;
        zzamVarArr.getClass();
        return zzamVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final int zzbf() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final long zzbh() {
        return this.zzm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzlb zzbi() {
        zzlb zzlbVar = this.zzc;
        zzlbVar.zzb = null;
        zzlbVar.zza = null;
        return zzlbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzmf, com.google.android.gms.internal.ads.zzmh
    public final int zzbj() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzmh
    public int zze() throws zziz {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long zzf() {
        return this.zzl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzel zzh() {
        zzel zzelVar = this.zzg;
        zzelVar.getClass();
        return zzelVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zziz zzi(Throwable th, zzam zzamVar, boolean z, int i) {
        int i2 = 4;
        if (zzamVar != null && !this.zzo) {
            this.zzo = true;
            try {
                i2 = zzX(zzamVar) & 7;
            } catch (zziz unused) {
            } finally {
                this.zzo = false;
            }
        }
        return zziz.zzb(th, zzT(), this.zze, zzamVar, i2, z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public zzlh zzk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final zzmh zzl() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzmi zzm() {
        zzmi zzmiVar = this.zzd;
        zzmiVar.getClass();
        return zzmiVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzpb zzn() {
        zzpb zzpbVar = this.zzf;
        zzpbVar.getClass();
        return zzpbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final zzwh zzo() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzmh
    public final void zzp() {
        synchronized (this.zza) {
            this.zzq = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzq() {
        zzek.zzf(this.zzh == 1);
        zzlb zzlbVar = this.zzc;
        zzlbVar.zzb = null;
        zzlbVar.zza = null;
        this.zzh = 0;
        this.zzi = null;
        this.zzj = null;
        this.zzn = false;
        zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzr(zzmi zzmiVar, zzam[] zzamVarArr, zzwh zzwhVar, long j, boolean z, boolean z2, long j2, long j3, zzur zzurVar) throws zziz {
        zzek.zzf(this.zzh == 0);
        this.zzd = zzmiVar;
        this.zzh = 1;
        zzx(z, z2);
        zzG(zzamVarArr, zzwhVar, j2, j3, zzurVar);
        zzY(j2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public /* synthetic */ void zzs() {
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public void zzt(int i, Object obj) throws zziz {
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzu(int i, zzpb zzpbVar, zzel zzelVar) {
        this.zze = i;
        this.zzf = zzpbVar;
        this.zzg = zzelVar;
        zzy();
    }

    protected void zzw() {
        throw null;
    }

    protected void zzx(boolean z, boolean z2) throws zziz {
    }

    protected void zzy() {
    }

    protected void zzz(long j, boolean z) throws zziz {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzR() {
        if (zzP()) {
            return this.zzn;
        }
        zzwh zzwhVar = this.zzi;
        zzwhVar.getClass();
        return zzwhVar.zze();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzd(long j) {
        zzwh zzwhVar = this.zzi;
        zzwhVar.getClass();
        return zzwhVar.zzb(j - this.zzk);
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzv() throws IOException {
        zzwh zzwhVar = this.zzi;
        zzwhVar.getClass();
        zzwhVar.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzbg(zzlb zzlbVar, zzih zzihVar, int i) {
        zzwh zzwhVar = this.zzi;
        zzwhVar.getClass();
        int zza = zzwhVar.zza(zzlbVar, zzihVar, i);
        if (zza == -4) {
            if (zzihVar.zzf()) {
                this.zzm = Long.MIN_VALUE;
                return this.zzn ? -4 : -3;
            }
            long j = zzihVar.zze + this.zzk;
            zzihVar.zze = j;
            this.zzm = Math.max(this.zzm, j);
        } else if (zza == -5) {
            zzam zzamVar = zzlbVar.zza;
            zzamVar.getClass();
            long j2 = zzamVar.zzq;
            if (j2 != Long.MAX_VALUE) {
                zzak zzb = zzamVar.zzb();
                zzb.zzaa(j2 + this.zzk);
                zzlbVar.zza = zzb.zzac();
                return -5;
            }
        }
        return zza;
    }
}

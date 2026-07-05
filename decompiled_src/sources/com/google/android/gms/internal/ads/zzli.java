package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzli {
    public final zzup zza;
    public final Object zzb;
    public boolean zzd;
    public boolean zze;
    public zzlj zzf;
    public boolean zzg;
    private final zzmh[] zzi;
    private final zzyo zzj;
    private final zzlx zzk;
    private zzli zzl;
    private zzyp zzn;
    private long zzo;
    private zzws zzm = zzws.zza;
    public final zzwh[] zzc = new zzwh[2];
    private final boolean[] zzh = new boolean[2];

    public zzli(zzmh[] zzmhVarArr, long j, zzyo zzyoVar, zzyx zzyxVar, zzlx zzlxVar, zzlj zzljVar, zzyp zzypVar) {
        this.zzi = zzmhVarArr;
        this.zzo = j;
        this.zzj = zzyoVar;
        this.zzk = zzlxVar;
        this.zzb = zzljVar.zza.zza;
        this.zzf = zzljVar;
        this.zzn = zzypVar;
        zzur zzurVar = zzljVar.zza;
        long j2 = zzljVar.zzb;
        long j3 = zzljVar.zzd;
        zzup zzp = zzlxVar.zzp(zzurVar, zzyxVar, j2);
        this.zza = j3 != -9223372036854775807L ? new zztw(zzp, true, 0L, j3) : zzp;
    }

    private final void zzs() {
        if (!zzu()) {
            return;
        }
        int i = 0;
        while (true) {
            zzyp zzypVar = this.zzn;
            if (i >= zzypVar.zza) {
                return;
            }
            zzypVar.zzb(i);
            zzyi zzyiVar = this.zzn.zzc[i];
            i++;
        }
    }

    private final void zzt() {
        if (!zzu()) {
            return;
        }
        int i = 0;
        while (true) {
            zzyp zzypVar = this.zzn;
            if (i >= zzypVar.zza) {
                return;
            }
            zzypVar.zzb(i);
            zzyi zzyiVar = this.zzn.zzc[i];
            i++;
        }
    }

    private final boolean zzu() {
        return this.zzl == null;
    }

    public final long zza(zzyp zzypVar, long j, boolean z) {
        return zzb(zzypVar, j, false, new boolean[2]);
    }

    public final long zzb(zzyp zzypVar, long j, boolean z, boolean[] zArr) {
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzypVar.zza) {
                break;
            }
            boolean[] zArr2 = this.zzh;
            if (z || !zzypVar.zza(this.zzn, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        int i2 = 0;
        while (true) {
            zzmh[] zzmhVarArr = this.zzi;
            if (i2 >= 2) {
                break;
            }
            zzmhVarArr[i2].zzbj();
            i2++;
        }
        zzs();
        this.zzn = zzypVar;
        zzt();
        long zzf = this.zza.zzf(zzypVar.zzc, this.zzh, this.zzc, zArr, j);
        int i3 = 0;
        while (true) {
            zzmh[] zzmhVarArr2 = this.zzi;
            if (i3 >= 2) {
                break;
            }
            zzmhVarArr2[i3].zzbj();
            i3++;
        }
        this.zze = false;
        int i4 = 0;
        while (true) {
            zzwh[] zzwhVarArr = this.zzc;
            if (i4 >= 2) {
                return zzf;
            }
            if (zzwhVarArr[i4] != null) {
                zzek.zzf(zzypVar.zzb(i4));
                this.zzi[i4].zzbj();
                this.zze = true;
            } else {
                zzek.zzf(zzypVar.zzc[i4] == null);
            }
            i4++;
        }
    }

    public final long zzc() {
        if (!this.zzd) {
            return this.zzf.zzb;
        }
        long zzb = this.zze ? this.zza.zzb() : Long.MIN_VALUE;
        return zzb == Long.MIN_VALUE ? this.zzf.zze : zzb;
    }

    public final long zzd() {
        if (this.zzd) {
            return this.zza.zzc();
        }
        return 0L;
    }

    public final long zze() {
        return this.zzo;
    }

    public final long zzf() {
        return this.zzf.zzb + this.zzo;
    }

    public final zzli zzg() {
        return this.zzl;
    }

    public final zzws zzh() {
        return this.zzm;
    }

    public final zzyp zzi() {
        return this.zzn;
    }

    public final zzyp zzj(float f, zzcx zzcxVar) throws zziz {
        zzyp zzp = this.zzj.zzp(this.zzi, this.zzm, this.zzf.zza, zzcxVar);
        for (zzyi zzyiVar : zzp.zzc) {
        }
        return zzp;
    }

    public final void zzk(long j, float f, long j2) {
        zzek.zzf(zzu());
        long j3 = j - this.zzo;
        zzle zzleVar = new zzle();
        zzleVar.zze(j3);
        zzleVar.zzf(f);
        zzleVar.zzd(j2);
        this.zza.zzo(new zzlg(zzleVar, null));
    }

    public final void zzl(float f, zzcx zzcxVar) throws zziz {
        this.zzd = true;
        this.zzm = this.zza.zzh();
        zzyp zzj = zzj(f, zzcxVar);
        zzlj zzljVar = this.zzf;
        long j = zzljVar.zzb;
        long j2 = zzljVar.zze;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        long zza = zza(zzj, j, false);
        long j3 = this.zzo;
        zzlj zzljVar2 = this.zzf;
        this.zzo = j3 + (zzljVar2.zzb - zza);
        this.zzf = zzljVar2.zzb(zza);
    }

    public final void zzm(long j) {
        zzek.zzf(zzu());
        if (this.zzd) {
            this.zza.zzm(j - this.zzo);
        }
    }

    public final void zzn() {
        zzs();
        zzup zzupVar = this.zza;
        try {
            boolean z = zzupVar instanceof zztw;
            zzlx zzlxVar = this.zzk;
            if (z) {
                zzlxVar.zzi(((zztw) zzupVar).zza);
            } else {
                zzlxVar.zzi(zzupVar);
            }
        } catch (RuntimeException e) {
            zzff.zzd("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public final void zzo(zzli zzliVar) {
        if (zzliVar == this.zzl) {
            return;
        }
        zzs();
        this.zzl = zzliVar;
        zzt();
    }

    public final void zzp(long j) {
        this.zzo = 1000000000000L;
    }

    public final void zzq() {
        zzup zzupVar = this.zza;
        if (zzupVar instanceof zztw) {
            long j = this.zzf.zzd;
            if (j == -9223372036854775807L) {
                j = Long.MIN_VALUE;
            }
            ((zztw) zzupVar).zzn(0L, j);
        }
    }

    public final boolean zzr() {
        if (this.zzd) {
            return !this.zze || this.zza.zzb() == Long.MIN_VALUE;
        }
        return false;
    }
}

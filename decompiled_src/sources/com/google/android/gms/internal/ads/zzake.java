package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzake {
    private zzaea zzb;
    private zzacx zzc;
    private zzajz zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private final zzajx zza = new zzajx();
    private zzakb zzj = new zzakb();

    protected abstract long zza(zzfp zzfpVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzb(boolean z) {
        int i;
        if (z) {
            this.zzj = new zzakb();
            this.zzf = 0L;
            i = 0;
        } else {
            i = 1;
        }
        this.zzh = i;
        this.zze = -1L;
        this.zzg = 0L;
    }

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected abstract boolean zzc(zzfp zzfpVar, long j, zzakb zzakbVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zze(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        zzek.zzb(this.zzb);
        int i = zzfy.zza;
        int i2 = this.zzh;
        if (i2 == 0) {
            while (this.zza.zze(zzacvVar)) {
                long zzf = zzacvVar.zzf();
                long j = this.zzf;
                this.zzk = zzf - j;
                if (zzc(this.zza.zza(), j, this.zzj)) {
                    this.zzf = zzacvVar.zzf();
                } else {
                    zzam zzamVar = this.zzj.zza;
                    this.zzi = zzamVar.zzA;
                    if (!this.zzm) {
                        this.zzb.zzl(zzamVar);
                        this.zzm = true;
                    }
                    zzajz zzajzVar = this.zzj.zzb;
                    if (zzajzVar != null) {
                        this.zzd = zzajzVar;
                    } else if (zzacvVar.zzd() == -1) {
                        this.zzd = new zzakd(null);
                    } else {
                        zzajy zzb = this.zza.zzb();
                        this.zzd = new zzajs(this, this.zzf, zzacvVar.zzd(), zzb.zzd + zzb.zze, zzb.zzb, (zzb.zza & 4) != 0);
                    }
                    this.zzh = 2;
                    this.zza.zzd();
                }
            }
            this.zzh = 3;
            return -1;
        }
        if (i2 == 1) {
            ((zzack) zzacvVar).zzo((int) this.zzf, false);
            this.zzh = 2;
            return 0;
        }
        if (i2 != 2) {
            return -1;
        }
        long zzd = this.zzd.zzd(zzacvVar);
        if (zzd >= 0) {
            zzadrVar.zza = zzd;
            return 1;
        }
        if (zzd < -1) {
            zzi(-(zzd + 2));
        }
        if (!this.zzl) {
            zzadu zze = this.zzd.zze();
            zzek.zzb(zze);
            this.zzc.zzO(zze);
            this.zzl = true;
        }
        if (this.zzk <= 0 && !this.zza.zze(zzacvVar)) {
            this.zzh = 3;
            return -1;
        }
        this.zzk = 0L;
        zzfp zza = this.zza.zza();
        long zza2 = zza(zza);
        if (zza2 >= 0) {
            long j2 = this.zzg;
            if (j2 + zza2 >= this.zze) {
                long zzf2 = zzf(j2);
                zzady.zzb(this.zzb, zza, zza.zze());
                this.zzb.zzt(zzf2, 1, zza.zze(), 0, null);
                this.zze = -1L;
            }
        }
        this.zzg += zza2;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long zzf(long j) {
        return (j * AnimationKt.MillisToNanos) / this.zzi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long zzg(long j) {
        return (this.zzi * j) / AnimationKt.MillisToNanos;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzh(zzacx zzacxVar, zzaea zzaeaVar) {
        this.zzc = zzacxVar;
        this.zzb = zzaeaVar;
        zzb(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzi(long j) {
        this.zzg = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(long j, long j2) {
        this.zza.zzc();
        if (j == 0) {
            zzb(!this.zzl);
            return;
        }
        if (this.zzh != 0) {
            this.zze = zzg(j2);
            zzajz zzajzVar = this.zzd;
            int i = zzfy.zza;
            zzajzVar.zzg(this.zze);
            this.zzh = 2;
        }
    }
}

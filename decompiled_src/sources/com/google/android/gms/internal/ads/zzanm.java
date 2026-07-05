package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzanm implements zzamy {
    private final zzfp zza;
    private final zzado zzb;
    private final String zzc;
    private zzaea zzd;
    private String zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private boolean zzi;
    private long zzj;
    private int zzk;
    private long zzl;

    public zzanm() {
        this(null);
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zza(zzfp zzfpVar) {
        zzek.zzb(this.zzd);
        while (zzfpVar.zzb() > 0) {
            int i = this.zzf;
            if (i == 0) {
                byte[] zzM = zzfpVar.zzM();
                int zzd = zzfpVar.zzd();
                int zze = zzfpVar.zze();
                while (true) {
                    if (zzd < zze) {
                        int i2 = zzd + 1;
                        byte b = zzM[zzd];
                        boolean z = (b & 255) == 255;
                        boolean z2 = this.zzi && (b & 224) == 224;
                        this.zzi = z;
                        if (z2) {
                            zzfpVar.zzK(i2);
                            this.zzi = false;
                            this.zza.zzM()[1] = zzM[zzd];
                            this.zzg = 2;
                            this.zzf = 1;
                            break;
                        }
                        zzd = i2;
                    } else {
                        zzfpVar.zzK(zze);
                        break;
                    }
                }
            } else if (i == 1) {
                int min = Math.min(zzfpVar.zzb(), 4 - this.zzg);
                zzfpVar.zzG(this.zza.zzM(), this.zzg, min);
                int i3 = this.zzg + min;
                this.zzg = i3;
                if (i3 >= 4) {
                    this.zza.zzK(0);
                    if (this.zzb.zza(this.zza.zzg())) {
                        this.zzk = this.zzb.zzc;
                        if (!this.zzh) {
                            this.zzj = (r0.zzg * AnimationKt.MillisToNanos) / r0.zzd;
                            zzak zzakVar = new zzak();
                            zzakVar.zzK(this.zze);
                            zzakVar.zzW(this.zzb.zzb);
                            zzakVar.zzO(4096);
                            zzakVar.zzy(this.zzb.zze);
                            zzakVar.zzX(this.zzb.zzd);
                            zzakVar.zzN(this.zzc);
                            this.zzd.zzl(zzakVar.zzac());
                            this.zzh = true;
                        }
                        this.zza.zzK(0);
                        this.zzd.zzr(this.zza, 4);
                        this.zzf = 2;
                    } else {
                        this.zzg = 0;
                        this.zzf = 1;
                    }
                }
            } else {
                int min2 = Math.min(zzfpVar.zzb(), this.zzk - this.zzg);
                this.zzd.zzr(zzfpVar, min2);
                int i4 = this.zzg + min2;
                this.zzg = i4;
                if (i4 >= this.zzk) {
                    zzek.zzf(this.zzl != -9223372036854775807L);
                    this.zzd.zzt(this.zzl, 1, this.zzk, 0, null);
                    this.zzl += this.zzj;
                    this.zzg = 0;
                    this.zzf = 0;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        zzaokVar.zzc();
        this.zze = zzaokVar.zzb();
        this.zzd = zzacxVar.zzw(zzaokVar.zza(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzd(long j, int i) {
        this.zzl = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zze() {
        this.zzf = 0;
        this.zzg = 0;
        this.zzi = false;
        this.zzl = -9223372036854775807L;
    }

    public zzanm(String str) {
        this.zzf = 0;
        zzfp zzfpVar = new zzfp(4);
        this.zza = zzfpVar;
        zzfpVar.zzM()[0] = -1;
        this.zzb = new zzado();
        this.zzl = -9223372036854775807L;
        this.zzc = str;
    }
}

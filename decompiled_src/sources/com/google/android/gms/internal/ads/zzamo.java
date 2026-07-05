package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import com.google.common.base.Ascii;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzamo implements zzamy {
    private final zzfo zza;
    private final zzfp zzb;
    private final String zzc;
    private String zzd;
    private zzaea zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private long zzi;
    private zzam zzj;
    private int zzk;
    private long zzl;

    public zzamo() {
        this(null);
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zza(zzfp zzfpVar) {
        zzek.zzb(this.zze);
        while (zzfpVar.zzb() > 0) {
            int i = this.zzf;
            if (i == 0) {
                while (true) {
                    if (zzfpVar.zzb() <= 0) {
                        break;
                    }
                    if (!this.zzh) {
                        this.zzh = zzfpVar.zzm() == 11;
                    } else {
                        int zzm = zzfpVar.zzm();
                        if (zzm == 119) {
                            this.zzh = false;
                            this.zzf = 1;
                            zzfp zzfpVar2 = this.zzb;
                            zzfpVar2.zzM()[0] = Ascii.VT;
                            zzfpVar2.zzM()[1] = 119;
                            this.zzg = 2;
                            break;
                        }
                        this.zzh = zzm == 11;
                    }
                }
            } else if (i != 1) {
                int min = Math.min(zzfpVar.zzb(), this.zzk - this.zzg);
                this.zze.zzr(zzfpVar, min);
                int i2 = this.zzg + min;
                this.zzg = i2;
                if (i2 == this.zzk) {
                    zzek.zzf(this.zzl != -9223372036854775807L);
                    this.zze.zzt(this.zzl, 1, this.zzk, 0, null);
                    this.zzl += this.zzi;
                    this.zzf = 0;
                }
            } else {
                byte[] zzM = this.zzb.zzM();
                int min2 = Math.min(zzfpVar.zzb(), 128 - this.zzg);
                zzfpVar.zzG(zzM, this.zzg, min2);
                int i3 = this.zzg + min2;
                this.zzg = i3;
                if (i3 == 128) {
                    this.zza.zzk(0);
                    zzabu zze = zzabv.zze(this.zza);
                    zzam zzamVar = this.zzj;
                    if (zzamVar == null || zze.zzc != zzamVar.zzz || zze.zzb != zzamVar.zzA || !zzfy.zzF(zze.zza, zzamVar.zzm)) {
                        zzak zzakVar = new zzak();
                        zzakVar.zzK(this.zzd);
                        zzakVar.zzW(zze.zza);
                        zzakVar.zzy(zze.zzc);
                        zzakVar.zzX(zze.zzb);
                        zzakVar.zzN(this.zzc);
                        zzakVar.zzR(zze.zzf);
                        if ("audio/ac3".equals(zze.zza)) {
                            zzakVar.zzx(zze.zzf);
                        }
                        zzam zzac = zzakVar.zzac();
                        this.zzj = zzac;
                        this.zze.zzl(zzac);
                    }
                    this.zzk = zze.zzd;
                    this.zzi = (zze.zze * AnimationKt.MillisToNanos) / this.zzj.zzA;
                    this.zzb.zzK(0);
                    this.zze.zzr(this.zzb, 128);
                    this.zzf = 2;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        zzaokVar.zzc();
        this.zzd = zzaokVar.zzb();
        this.zze = zzacxVar.zzw(zzaokVar.zza(), 1);
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
        this.zzh = false;
        this.zzl = -9223372036854775807L;
    }

    public zzamo(String str) {
        zzfo zzfoVar = new zzfo(new byte[128], 128);
        this.zza = zzfoVar;
        this.zzb = new zzfp(zzfoVar.zza);
        this.zzf = 0;
        this.zzl = -9223372036854775807L;
        this.zzc = str;
    }
}

package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzadw implements zzacu {
    private final int zza;
    private final int zzb;
    private final String zzc;
    private int zzd;
    private int zze;
    private zzacx zzf;
    private zzaea zzg;

    public zzadw(int i, int i2, String str) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = str;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzf = zzacxVar;
        zzaea zzw = zzacxVar.zzw(1024, 4);
        this.zzg = zzw;
        zzak zzakVar = new zzak();
        zzakVar.zzB(this.zzc);
        zzw.zzl(zzakVar.zzac());
        this.zzf.zzD();
        this.zzf.zzO(new zzadx(-9223372036854775807L));
        this.zze = 1;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j, long j2) {
        if (j == 0 || this.zze == 1) {
            this.zze = 1;
            this.zzd = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        zzek.zzf((this.zza == -1 || this.zzb == -1) ? false : true);
        zzfp zzfpVar = new zzfp(this.zzb);
        ((zzack) zzacvVar).zzm(zzfpVar.zzM(), 0, this.zzb, false);
        return zzfpVar.zzq() == this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        int i = this.zze;
        if (i != 1) {
            if (i == 2) {
                return -1;
            }
            throw new IllegalStateException();
        }
        zzaea zzaeaVar = this.zzg;
        zzaeaVar.getClass();
        int zza = zzady.zza(zzaeaVar, zzacvVar, 1024, true);
        if (zza == -1) {
            this.zze = 2;
            this.zzg.zzt(0L, 1, this.zzd, 0, null);
            this.zzd = 0;
        } else {
            this.zzd += zza;
        }
        return 0;
    }
}

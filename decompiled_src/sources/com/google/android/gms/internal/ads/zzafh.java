package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzafh extends zzafg {
    private final zzfp zzb;
    private final zzfp zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    public zzafh(zzaea zzaeaVar) {
        super(zzaeaVar);
        this.zzb = new zzfp(zzgm.zza);
        this.zzc = new zzfp(4);
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    protected final boolean zza(zzfp zzfpVar) throws zzaff {
        int zzm = zzfpVar.zzm();
        int i = zzm >> 4;
        int i2 = zzm & 15;
        if (i2 == 7) {
            this.zzg = i;
            return i != 5;
        }
        throw new zzaff("Video format not supported: " + i2);
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    protected final boolean zzb(zzfp zzfpVar, long j) throws zzcc {
        int i;
        int zzm = zzfpVar.zzm();
        long zzh = zzfpVar.zzh();
        if (zzm == 0) {
            if (!this.zze) {
                zzfp zzfpVar2 = new zzfp(new byte[zzfpVar.zzb()]);
                zzfpVar.zzG(zzfpVar2.zzM(), 0, zzfpVar.zzb());
                zzabz zza = zzabz.zza(zzfpVar2);
                this.zzd = zza.zzb;
                zzak zzakVar = new zzak();
                zzakVar.zzW("video/avc");
                zzakVar.zzz(zza.zzk);
                zzakVar.zzab(zza.zzc);
                zzakVar.zzI(zza.zzd);
                zzakVar.zzS(zza.zzj);
                zzakVar.zzL(zza.zza);
                this.zza.zzl(zzakVar.zzac());
                this.zze = true;
                return false;
            }
        } else if (zzm == 1 && this.zze) {
            int i2 = this.zzg == 1 ? 1 : 0;
            if (this.zzf) {
                i = i2;
            } else if (i2 != 0) {
                i = 1;
            }
            byte[] zzM = this.zzc.zzM();
            zzM[0] = 0;
            zzM[1] = 0;
            zzM[2] = 0;
            int i3 = 4 - this.zzd;
            int i4 = 0;
            while (zzfpVar.zzb() > 0) {
                zzfpVar.zzG(this.zzc.zzM(), i3, this.zzd);
                this.zzc.zzK(0);
                zzfp zzfpVar3 = this.zzc;
                zzfp zzfpVar4 = this.zzb;
                int zzp = zzfpVar3.zzp();
                zzfpVar4.zzK(0);
                this.zza.zzr(this.zzb, 4);
                this.zza.zzr(zzfpVar, zzp);
                i4 = i4 + 4 + zzp;
            }
            this.zza.zzt(j + (zzh * 1000), i, i4, 0, null);
            this.zzf = true;
            return true;
        }
        return false;
    }
}

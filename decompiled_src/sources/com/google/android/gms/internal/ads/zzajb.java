package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzajb {
    public final zzaea zza;
    public zzajp zzd;
    public zzaix zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    private boolean zzl;
    public final zzajo zzb = new zzajo();
    public final zzfp zzc = new zzfp();
    private final zzfp zzj = new zzfp(1);
    private final zzfp zzk = new zzfp();

    public zzajb(zzaea zzaeaVar, zzajp zzajpVar, zzaix zzaixVar) {
        this.zza = zzaeaVar;
        this.zzd = zzajpVar;
        this.zze = zzaixVar;
        zzh(zzajpVar, zzaixVar);
    }

    public final int zza() {
        int i;
        if (!this.zzl) {
            i = this.zzd.zzg[this.zzf];
        } else {
            i = this.zzb.zzj[this.zzf] ? 1 : 0;
        }
        return zzf() != null ? i | 1073741824 : i;
    }

    public final int zzb() {
        if (!this.zzl) {
            return this.zzd.zzd[this.zzf];
        }
        return this.zzb.zzh[this.zzf];
    }

    public final int zzc(int i, int i2) {
        zzfp zzfpVar;
        zzajn zzf = zzf();
        if (zzf == null) {
            return 0;
        }
        int i3 = zzf.zzd;
        if (i3 != 0) {
            zzfpVar = this.zzb.zzn;
        } else {
            byte[] bArr = zzf.zze;
            int i4 = zzfy.zza;
            zzfp zzfpVar2 = this.zzk;
            int length = bArr.length;
            zzfpVar2.zzI(bArr, length);
            zzfpVar = this.zzk;
            i3 = length;
        }
        boolean zzb = this.zzb.zzb(this.zzf);
        boolean z = zzb || i2 != 0;
        zzfp zzfpVar3 = this.zzj;
        zzfpVar3.zzM()[0] = (byte) ((true != z ? 0 : 128) | i3);
        zzfpVar3.zzK(0);
        this.zza.zzs(this.zzj, 1, 1);
        this.zza.zzs(zzfpVar, i3, 1);
        if (!z) {
            return i3 + 1;
        }
        if (!zzb) {
            this.zzc.zzH(8);
            zzfp zzfpVar4 = this.zzc;
            byte[] zzM = zzfpVar4.zzM();
            zzM[0] = 0;
            zzM[1] = 1;
            zzM[2] = 0;
            zzM[3] = (byte) i2;
            zzM[4] = (byte) ((i >> 24) & 255);
            zzM[5] = (byte) ((i >> 16) & 255);
            zzM[6] = (byte) ((i >> 8) & 255);
            zzM[7] = (byte) (i & 255);
            this.zza.zzs(zzfpVar4, 8, 1);
            return i3 + 9;
        }
        int i5 = i3 + 1;
        zzfp zzfpVar5 = this.zzb.zzn;
        int zzq = zzfpVar5.zzq();
        zzfpVar5.zzL(-2);
        int i6 = (zzq * 6) + 2;
        if (i2 != 0) {
            this.zzc.zzH(i6);
            byte[] zzM2 = this.zzc.zzM();
            zzfpVar5.zzG(zzM2, 0, i6);
            int i7 = (((zzM2[2] & 255) << 8) | (zzM2[3] & 255)) + i2;
            zzM2[2] = (byte) ((i7 >> 8) & 255);
            zzM2[3] = (byte) (i7 & 255);
            zzfpVar5 = this.zzc;
        }
        this.zza.zzs(zzfpVar5, i6, 1);
        return i5 + i6;
    }

    public final long zzd() {
        if (!this.zzl) {
            return this.zzd.zzc[this.zzf];
        }
        return this.zzb.zzf[this.zzh];
    }

    public final long zze() {
        if (!this.zzl) {
            return this.zzd.zzf[this.zzf];
        }
        zzajo zzajoVar = this.zzb;
        return zzajoVar.zzi[this.zzf];
    }

    public final zzajn zzf() {
        if (!this.zzl) {
            return null;
        }
        zzaix zzaixVar = this.zzb.zza;
        int i = zzfy.zza;
        int i2 = zzaixVar.zza;
        zzajn zzajnVar = this.zzb.zzm;
        if (zzajnVar == null) {
            zzajnVar = this.zzd.zza.zza(i2);
        }
        if (zzajnVar == null || !zzajnVar.zza) {
            return null;
        }
        return zzajnVar;
    }

    public final void zzh(zzajp zzajpVar, zzaix zzaixVar) {
        this.zzd = zzajpVar;
        this.zze = zzaixVar;
        this.zza.zzl(zzajpVar.zza.zzf);
        zzi();
    }

    public final void zzi() {
        zzajo zzajoVar = this.zzb;
        zzajoVar.zzd = 0;
        zzajoVar.zzp = 0L;
        zzajoVar.zzq = false;
        zzajoVar.zzk = false;
        zzajoVar.zzo = false;
        zzajoVar.zzm = null;
        this.zzf = 0;
        this.zzh = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzl = false;
    }

    public final boolean zzk() {
        this.zzf++;
        if (!this.zzl) {
            return false;
        }
        int i = this.zzg + 1;
        this.zzg = i;
        int[] iArr = this.zzb.zzg;
        int i2 = this.zzh;
        if (i != iArr[i2]) {
            return true;
        }
        this.zzh = i2 + 1;
        this.zzg = 0;
        return false;
    }
}

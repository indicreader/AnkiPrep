package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbt {
    private CharSequence zza;
    private CharSequence zzb;
    private CharSequence zzc;
    private CharSequence zzd;
    private CharSequence zze;
    private byte[] zzf;
    private Integer zzg;
    private Integer zzh;
    private Integer zzi;
    private Integer zzj;
    private Boolean zzk;
    private Integer zzl;
    private Integer zzm;
    private Integer zzn;
    private Integer zzo;
    private Integer zzp;
    private Integer zzq;
    private CharSequence zzr;
    private CharSequence zzs;
    private CharSequence zzt;
    private CharSequence zzu;
    private CharSequence zzv;
    private Integer zzw;

    public zzbt() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbt(zzbv zzbvVar, zzbs zzbsVar) {
        this.zza = zzbvVar.zzc;
        this.zzb = zzbvVar.zzd;
        this.zzc = zzbvVar.zze;
        this.zzd = zzbvVar.zzf;
        this.zze = zzbvVar.zzg;
        this.zzf = zzbvVar.zzh;
        this.zzg = zzbvVar.zzi;
        this.zzh = zzbvVar.zzj;
        this.zzi = zzbvVar.zzk;
        this.zzj = zzbvVar.zzl;
        this.zzk = zzbvVar.zzm;
        this.zzl = zzbvVar.zzo;
        this.zzm = zzbvVar.zzp;
        this.zzn = zzbvVar.zzq;
        this.zzo = zzbvVar.zzr;
        this.zzp = zzbvVar.zzs;
        this.zzq = zzbvVar.zzt;
        this.zzr = zzbvVar.zzu;
        this.zzs = zzbvVar.zzv;
        this.zzt = zzbvVar.zzw;
        this.zzu = zzbvVar.zzx;
        this.zzv = zzbvVar.zzy;
        this.zzw = zzbvVar.zzz;
    }

    public final zzbt zza(byte[] bArr, int i) {
        if (this.zzf == null || zzfy.zzF(Integer.valueOf(i), 3) || !zzfy.zzF(this.zzg, 3)) {
            this.zzf = (byte[]) bArr.clone();
            this.zzg = Integer.valueOf(i);
        }
        return this;
    }

    public final zzbt zzb(zzbv zzbvVar) {
        if (zzbvVar != null) {
            CharSequence charSequence = zzbvVar.zzc;
            if (charSequence != null) {
                this.zza = charSequence;
            }
            CharSequence charSequence2 = zzbvVar.zzd;
            if (charSequence2 != null) {
                this.zzb = charSequence2;
            }
            CharSequence charSequence3 = zzbvVar.zze;
            if (charSequence3 != null) {
                this.zzc = charSequence3;
            }
            CharSequence charSequence4 = zzbvVar.zzf;
            if (charSequence4 != null) {
                this.zzd = charSequence4;
            }
            CharSequence charSequence5 = zzbvVar.zzg;
            if (charSequence5 != null) {
                this.zze = charSequence5;
            }
            byte[] bArr = zzbvVar.zzh;
            if (bArr != null) {
                Integer num = zzbvVar.zzi;
                this.zzf = (byte[]) bArr.clone();
                this.zzg = num;
            }
            Integer num2 = zzbvVar.zzj;
            if (num2 != null) {
                this.zzh = num2;
            }
            Integer num3 = zzbvVar.zzk;
            if (num3 != null) {
                this.zzi = num3;
            }
            Integer num4 = zzbvVar.zzl;
            if (num4 != null) {
                this.zzj = num4;
            }
            Boolean bool = zzbvVar.zzm;
            if (bool != null) {
                this.zzk = bool;
            }
            Integer num5 = zzbvVar.zzn;
            if (num5 != null) {
                this.zzl = num5;
            }
            Integer num6 = zzbvVar.zzo;
            if (num6 != null) {
                this.zzl = num6;
            }
            Integer num7 = zzbvVar.zzp;
            if (num7 != null) {
                this.zzm = num7;
            }
            Integer num8 = zzbvVar.zzq;
            if (num8 != null) {
                this.zzn = num8;
            }
            Integer num9 = zzbvVar.zzr;
            if (num9 != null) {
                this.zzo = num9;
            }
            Integer num10 = zzbvVar.zzs;
            if (num10 != null) {
                this.zzp = num10;
            }
            Integer num11 = zzbvVar.zzt;
            if (num11 != null) {
                this.zzq = num11;
            }
            CharSequence charSequence6 = zzbvVar.zzu;
            if (charSequence6 != null) {
                this.zzr = charSequence6;
            }
            CharSequence charSequence7 = zzbvVar.zzv;
            if (charSequence7 != null) {
                this.zzs = charSequence7;
            }
            CharSequence charSequence8 = zzbvVar.zzw;
            if (charSequence8 != null) {
                this.zzt = charSequence8;
            }
            CharSequence charSequence9 = zzbvVar.zzx;
            if (charSequence9 != null) {
                this.zzu = charSequence9;
            }
            CharSequence charSequence10 = zzbvVar.zzy;
            if (charSequence10 != null) {
                this.zzv = charSequence10;
            }
            Integer num12 = zzbvVar.zzz;
            if (num12 != null) {
                this.zzw = num12;
            }
        }
        return this;
    }

    public final zzbt zzc(CharSequence charSequence) {
        this.zzd = charSequence;
        return this;
    }

    public final zzbt zzd(CharSequence charSequence) {
        this.zzc = charSequence;
        return this;
    }

    public final zzbt zze(CharSequence charSequence) {
        this.zzb = charSequence;
        return this;
    }

    public final zzbt zzf(CharSequence charSequence) {
        this.zzs = charSequence;
        return this;
    }

    public final zzbt zzg(CharSequence charSequence) {
        this.zzt = charSequence;
        return this;
    }

    public final zzbt zzh(CharSequence charSequence) {
        this.zze = charSequence;
        return this;
    }

    public final zzbt zzi(CharSequence charSequence) {
        this.zzu = charSequence;
        return this;
    }

    public final zzbt zzj(Integer num) {
        this.zzn = num;
        return this;
    }

    public final zzbt zzk(Integer num) {
        this.zzm = num;
        return this;
    }

    public final zzbt zzl(Integer num) {
        this.zzl = num;
        return this;
    }

    public final zzbt zzm(Integer num) {
        this.zzq = num;
        return this;
    }

    public final zzbt zzn(Integer num) {
        this.zzp = num;
        return this;
    }

    public final zzbt zzo(Integer num) {
        this.zzo = num;
        return this;
    }

    public final zzbt zzp(CharSequence charSequence) {
        this.zzv = charSequence;
        return this;
    }

    public final zzbt zzq(CharSequence charSequence) {
        this.zza = charSequence;
        return this;
    }

    public final zzbt zzr(Integer num) {
        this.zzi = num;
        return this;
    }

    public final zzbt zzs(Integer num) {
        this.zzh = num;
        return this;
    }

    public final zzbt zzt(CharSequence charSequence) {
        this.zzr = charSequence;
        return this;
    }

    public final zzbv zzu() {
        return new zzbv(this);
    }
}

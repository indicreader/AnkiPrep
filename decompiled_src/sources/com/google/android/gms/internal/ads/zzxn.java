package com.google.android.gms.internal.ads;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzxn extends zzyc implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final String zzg;
    private final zzxu zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final int zzo;
    private final boolean zzp;
    private final int zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final boolean zzu;
    private final boolean zzv;

    /* JADX WARN: Multi-variable type inference failed */
    public zzxn(int i, zzcz zzczVar, int i2, zzxu zzxuVar, int i3, boolean z, zzfxf zzfxfVar, int i4) {
        super(i, zzczVar, i2);
        int i5;
        int i6;
        String[] strArr;
        int i7;
        boolean z2;
        this.zzh = zzxuVar;
        int i8 = 1;
        int i9 = true != zzxuVar.zzR ? 16 : 24;
        boolean z3 = zzxuVar.zzN;
        this.zzg = zzyg.zzh(this.zzd.zzd);
        this.zzi = zzyg.zzo(i3, false);
        int i10 = 0;
        while (true) {
            i5 = Integer.MAX_VALUE;
            if (i10 >= zzxuVar.zzq.size()) {
                i6 = 0;
                i10 = Integer.MAX_VALUE;
                break;
            } else {
                i6 = zzyg.zzb(this.zzd, (String) zzxuVar.zzq.get(i10), false);
                if (i6 > 0) {
                    break;
                } else {
                    i10++;
                }
            }
        }
        this.zzk = i10;
        this.zzj = i6;
        int i11 = this.zzd.zzf;
        int i12 = zzxuVar.zzr;
        this.zzl = zzyg.zza(i11, 0);
        zzam zzamVar = this.zzd;
        int i13 = zzamVar.zzf;
        this.zzm = i13 == 0 || (i13 & 1) != 0;
        this.zzp = 1 == (zzamVar.zze & 1);
        this.zzq = zzamVar.zzz;
        this.zzr = zzamVar.zzA;
        this.zzs = zzamVar.zzi;
        if (zzamVar.zzi != -1) {
            int i14 = zzxuVar.zzt;
        }
        if (zzamVar.zzz != -1) {
            int i15 = zzxuVar.zzs;
        }
        this.zzf = zzfxfVar.zza(zzamVar);
        Configuration configuration = Resources.getSystem().getConfiguration();
        if (zzfy.zza >= 24) {
            strArr = configuration.getLocales().toLanguageTags().split(",", -1);
        } else {
            strArr = new String[]{configuration.locale.toLanguageTag()};
        }
        for (int i16 = 0; i16 < strArr.length; i16++) {
            strArr[i16] = zzfy.zzC(strArr[i16]);
        }
        int i17 = 0;
        while (true) {
            if (i17 >= strArr.length) {
                i7 = 0;
                i17 = Integer.MAX_VALUE;
                break;
            } else {
                i7 = zzyg.zzb(this.zzd, strArr[i17], false);
                if (i7 > 0) {
                    break;
                } else {
                    i17++;
                }
            }
        }
        this.zzn = i17;
        this.zzo = i7;
        int i18 = 0;
        while (true) {
            if (i18 >= zzxuVar.zzu.size()) {
                break;
            }
            String str = this.zzd.zzm;
            if (str != null && str.equals(zzxuVar.zzu.get(i18))) {
                i5 = i18;
                break;
            }
            i18++;
        }
        this.zzt = i5;
        this.zzu = (i3 & 384) == 128;
        this.zzv = (i3 & 64) == 64;
        zzxu zzxuVar2 = this.zzh;
        if (zzyg.zzo(i3, zzxuVar2.zzT) && ((z2 = this.zzf) || zzxuVar2.zzM)) {
            zzde zzdeVar = zzxuVar2.zzv;
            if (zzyg.zzo(i3, false) && z2 && this.zzd.zzi != -1) {
                boolean z4 = zzxuVar2.zzC;
                boolean z5 = zzxuVar2.zzB;
                if ((zzxuVar2.zzV || !z) && (i9 & i3) != 0) {
                    i8 = 2;
                }
            }
        } else {
            i8 = 0;
        }
        this.zze = i8;
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final /* bridge */ /* synthetic */ boolean zzc(zzyc zzycVar) {
        String str;
        zzxn zzxnVar = (zzxn) zzycVar;
        boolean z = this.zzh.zzP;
        zzam zzamVar = this.zzd;
        int i = zzamVar.zzz;
        if (i == -1) {
            return false;
        }
        zzam zzamVar2 = zzxnVar.zzd;
        if (i != zzamVar2.zzz || (str = zzamVar.zzm) == null || !TextUtils.equals(str, zzamVar2.zzm)) {
            return false;
        }
        zzxu zzxuVar = this.zzh;
        boolean z2 = zzxuVar.zzO;
        int i2 = this.zzd.zzA;
        if (i2 == -1 || i2 != zzxnVar.zzd.zzA) {
            return false;
        }
        boolean z3 = zzxuVar.zzQ;
        return this.zzu == zzxnVar.zzu && this.zzv == zzxnVar.zzv;
    }

    @Override // java.lang.Comparable
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxn zzxnVar) {
        zzgbj zzgbjVar;
        zzgbj zza;
        zzgbj zzgbjVar2;
        if (!this.zzf || !this.zzi) {
            zzgbjVar = zzyg.zzc;
            zza = zzgbjVar.zza();
        } else {
            zza = zzyg.zzc;
        }
        zzfzp zzd = zzfzp.zzk().zze(this.zzi, zzxnVar.zzi).zzd(Integer.valueOf(this.zzk), Integer.valueOf(zzxnVar.zzk), zzgbj.zzc().zza()).zzb(this.zzj, zzxnVar.zzj).zzb(this.zzl, zzxnVar.zzl).zze(this.zzp, zzxnVar.zzp).zze(this.zzm, zzxnVar.zzm).zzd(Integer.valueOf(this.zzn), Integer.valueOf(zzxnVar.zzn), zzgbj.zzc().zza()).zzb(this.zzo, zzxnVar.zzo).zze(this.zzf, zzxnVar.zzf).zzd(Integer.valueOf(this.zzt), Integer.valueOf(zzxnVar.zzt), zzgbj.zzc().zza());
        Integer valueOf = Integer.valueOf(this.zzs);
        Integer valueOf2 = Integer.valueOf(zzxnVar.zzs);
        boolean z = this.zzh.zzB;
        zzgbjVar2 = zzyg.zzd;
        zzfzp zzd2 = zzd.zzd(valueOf, valueOf2, zzgbjVar2).zze(this.zzu, zzxnVar.zzu).zze(this.zzv, zzxnVar.zzv).zzd(Integer.valueOf(this.zzq), Integer.valueOf(zzxnVar.zzq), zza).zzd(Integer.valueOf(this.zzr), Integer.valueOf(zzxnVar.zzr), zza);
        Integer valueOf3 = Integer.valueOf(this.zzs);
        Integer valueOf4 = Integer.valueOf(zzxnVar.zzs);
        if (!zzfy.zzF(this.zzg, zzxnVar.zzg)) {
            zza = zzyg.zzd;
        }
        return zzd2.zzd(valueOf3, valueOf4, zza).zza();
    }
}

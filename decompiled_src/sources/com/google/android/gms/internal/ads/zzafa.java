package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.compose.animation.core.AnimationKt;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzafa implements zzacu {
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzaez
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i = zzada.zza;
            zzadb zzadbVar = zzafa.zza;
            return new zzacu[]{new zzafa(0)};
        }
    };
    private final byte[] zzb;
    private final zzfp zzc;
    private final zzadc zzd;
    private zzacx zze;
    private zzaea zzf;
    private int zzg;
    private zzby zzh;
    private zzadh zzi;
    private int zzj;
    private int zzk;
    private zzaey zzl;
    private int zzm;
    private long zzn;

    public zzafa() {
        this(0);
    }

    private final void zzf() {
        long j = this.zzn * AnimationKt.MillisToNanos;
        zzadh zzadhVar = this.zzi;
        int i = zzfy.zza;
        this.zzf.zzt(j / zzadhVar.zze, 1, this.zzm, 0, null);
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zze = zzacxVar;
        this.zzf = zzacxVar.zzw(0, 1);
        zzacxVar.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j, long j2) {
        if (j == 0) {
            this.zzg = 0;
        } else {
            zzaey zzaeyVar = this.zzl;
            if (zzaeyVar != null) {
                zzaeyVar.zzd(j2);
            }
        }
        this.zzn = j2 != 0 ? -1L : 0L;
        this.zzm = 0;
        this.zzc.zzH(0);
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        zzade.zza(zzacvVar, false);
        zzfp zzfpVar = new zzfp(4);
        ((zzack) zzacvVar).zzm(zzfpVar.zzM(), 0, 4, false);
        return zzfpVar.zzu() == 1716281667;
    }

    public zzafa(int i) {
        this.zzb = new byte[42];
        this.zzc = new zzfp(new byte[32768], 0);
        this.zzd = new zzadc();
        this.zzg = 0;
    }

    private final long zza(zzfp zzfpVar, boolean z) {
        boolean z2;
        this.zzi.getClass();
        int zzd = zzfpVar.zzd();
        while (zzd <= zzfpVar.zze() - 16) {
            zzfpVar.zzK(zzd);
            if (zzadd.zzc(zzfpVar, this.zzi, this.zzk, this.zzd)) {
                zzfpVar.zzK(zzd);
                return this.zzd.zza;
            }
            zzd++;
        }
        if (z) {
            while (zzd <= zzfpVar.zze() - this.zzj) {
                zzfpVar.zzK(zzd);
                try {
                    z2 = zzadd.zzc(zzfpVar, this.zzi, this.zzk, this.zzd);
                } catch (IndexOutOfBoundsException unused) {
                    z2 = false;
                }
                if (zzfpVar.zzd() <= zzfpVar.zze() && z2) {
                    zzfpVar.zzK(zzd);
                    return this.zzd.zza;
                }
                zzd++;
            }
            zzfpVar.zzK(zzfpVar.zze());
            return -1L;
        }
        zzfpVar.zzK(zzd);
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        boolean zzo;
        zzadu zzadtVar;
        boolean z;
        int i = this.zzg;
        if (i == 0) {
            zzacvVar.zzj();
            long zze = zzacvVar.zze();
            zzby zza2 = zzade.zza(zzacvVar, true);
            ((zzack) zzacvVar).zzo((int) (zzacvVar.zze() - zze), false);
            this.zzh = zza2;
            this.zzg = 1;
            return 0;
        }
        if (i == 1) {
            ((zzack) zzacvVar).zzm(this.zzb, 0, 42, false);
            zzacvVar.zzj();
            this.zzg = 2;
            return 0;
        }
        if (i == 2) {
            zzfp zzfpVar = new zzfp(4);
            ((zzack) zzacvVar).zzn(zzfpVar.zzM(), 0, 4, false);
            if (zzfpVar.zzu() != 1716281667) {
                throw zzcc.zza("Failed to read FLAC stream marker.", null);
            }
            this.zzg = 3;
            return 0;
        }
        if (i == 3) {
            zzadh zzadhVar = this.zzi;
            do {
                zzacvVar.zzj();
                zzfo zzfoVar = new zzfo(new byte[4], 4);
                zzack zzackVar = (zzack) zzacvVar;
                zzackVar.zzm(zzfoVar.zza, 0, 4, false);
                zzo = zzfoVar.zzo();
                int zzd = zzfoVar.zzd(7);
                int zzd2 = zzfoVar.zzd(24) + 4;
                if (zzd == 0) {
                    byte[] bArr = new byte[38];
                    zzackVar.zzn(bArr, 0, 38, false);
                    zzadhVar = new zzadh(bArr, 4);
                } else {
                    if (zzadhVar == null) {
                        throw new IllegalArgumentException();
                    }
                    if (zzd == 3) {
                        zzfp zzfpVar2 = new zzfp(zzd2);
                        zzackVar.zzn(zzfpVar2.zzM(), 0, zzd2, false);
                        zzadhVar = zzadhVar.zzf(zzade.zzb(zzfpVar2));
                    } else if (zzd == 4) {
                        zzfp zzfpVar3 = new zzfp(zzd2);
                        zzackVar.zzn(zzfpVar3.zzM(), 0, zzd2, false);
                        zzfpVar3.zzL(4);
                        zzadhVar = zzadhVar.zzg(Arrays.asList(zzaeg.zzc(zzfpVar3, false, false).zzb));
                    } else if (zzd != 6) {
                        zzackVar.zzo(zzd2, false);
                    } else {
                        zzfp zzfpVar4 = new zzfp(zzd2);
                        zzackVar.zzn(zzfpVar4.zzM(), 0, zzd2, false);
                        zzfpVar4.zzL(4);
                        zzadhVar = zzadhVar.zze(zzgaa.zzm(zzafw.zzb(zzfpVar4)));
                    }
                }
                int i2 = zzfy.zza;
                this.zzi = zzadhVar;
            } while (!zzo);
            zzadhVar.getClass();
            this.zzj = Math.max(zzadhVar.zzc, 6);
            this.zzf.zzl(this.zzi.zzc(this.zzb, this.zzh));
            this.zzg = 4;
            return 0;
        }
        if (i == 4) {
            zzacvVar.zzj();
            zzfp zzfpVar5 = new zzfp(2);
            ((zzack) zzacvVar).zzm(zzfpVar5.zzM(), 0, 2, false);
            int zzq = zzfpVar5.zzq();
            if ((zzq >> 2) != 16382) {
                zzacvVar.zzj();
                throw zzcc.zza("First frame does not start with sync code.", null);
            }
            zzacvVar.zzj();
            this.zzk = zzq;
            zzacx zzacxVar = this.zze;
            int i3 = zzfy.zza;
            long zzf = zzacvVar.zzf();
            long zzd3 = zzacvVar.zzd();
            zzadh zzadhVar2 = this.zzi;
            zzadhVar2.getClass();
            if (zzadhVar2.zzk != null) {
                zzadtVar = new zzadf(zzadhVar2, zzf);
            } else if (zzd3 != -1 && zzadhVar2.zzj > 0) {
                zzaey zzaeyVar = new zzaey(zzadhVar2, this.zzk, zzf, zzd3);
                this.zzl = zzaeyVar;
                zzadtVar = zzaeyVar.zzb();
            } else {
                zzadtVar = new zzadt(zzadhVar2.zza(), 0L);
            }
            zzacxVar.zzO(zzadtVar);
            this.zzg = 5;
            return 0;
        }
        this.zzf.getClass();
        zzadh zzadhVar3 = this.zzi;
        zzadhVar3.getClass();
        zzaey zzaeyVar2 = this.zzl;
        if (zzaeyVar2 != null && zzaeyVar2.zze()) {
            return zzaeyVar2.zza(zzacvVar, zzadrVar);
        }
        if (this.zzn == -1) {
            this.zzn = zzadd.zzb(zzacvVar, zzadhVar3);
            return 0;
        }
        zzfp zzfpVar6 = this.zzc;
        int zze2 = zzfpVar6.zze();
        if (zze2 < 32768) {
            int zza3 = zzacvVar.zza(zzfpVar6.zzM(), zze2, 32768 - zze2);
            z = zza3 == -1;
            if (!z) {
                this.zzc.zzJ(zze2 + zza3);
            } else if (this.zzc.zzb() == 0) {
                zzf();
                return -1;
            }
        } else {
            z = false;
        }
        zzfp zzfpVar7 = this.zzc;
        int zzd4 = zzfpVar7.zzd();
        int i4 = this.zzm;
        int i5 = this.zzj;
        if (i4 < i5) {
            zzfpVar7.zzL(Math.min(i5 - i4, zzfpVar7.zzb()));
        }
        long zza4 = zza(this.zzc, z);
        zzfp zzfpVar8 = this.zzc;
        int zzd5 = zzfpVar8.zzd() - zzd4;
        zzfpVar8.zzK(zzd4);
        zzady.zzb(this.zzf, this.zzc, zzd5);
        this.zzm += zzd5;
        if (zza4 != -1) {
            zzf();
            this.zzm = 0;
            this.zzn = zza4;
        }
        zzfp zzfpVar9 = this.zzc;
        if (zzfpVar9.zzb() >= 16) {
            return 0;
        }
        int zzb = zzfpVar9.zzb();
        System.arraycopy(zzfpVar9.zzM(), zzfpVar9.zzd(), zzfpVar9.zzM(), 0, zzb);
        this.zzc.zzK(0);
        this.zzc.zzJ(zzb);
        return 0;
    }
}

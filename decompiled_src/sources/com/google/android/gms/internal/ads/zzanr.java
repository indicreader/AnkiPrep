package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzanr implements zzacf {
    private final zzfw zza;
    private final zzfp zzb = new zzfp();

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzanr(zzfw zzfwVar, zzanq zzanqVar) {
        this.zza = zzfwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final zzace zza(zzacv zzacvVar, long j) throws IOException {
        int zzh;
        long j2;
        long zzf = zzacvVar.zzf();
        int min = (int) Math.min(20000L, zzacvVar.zzd() - zzf);
        this.zzb.zzH(min);
        ((zzack) zzacvVar).zzm(this.zzb.zzM(), 0, min, false);
        int i = -1;
        long j3 = -9223372036854775807L;
        int i2 = -1;
        while (true) {
            zzfp zzfpVar = this.zzb;
            if (zzfpVar.zzb() < 4) {
                return j3 != -9223372036854775807L ? zzace.zzf(j3, zzf + i) : zzace.zza;
            }
            if (zzans.zzh(zzfpVar.zzM(), zzfpVar.zzd()) != 442) {
                zzfpVar.zzL(1);
            } else {
                zzfpVar.zzL(4);
                long zzc = zzant.zzc(zzfpVar);
                if (zzc != -9223372036854775807L) {
                    long zzb = this.zza.zzb(zzc);
                    if (zzb > j) {
                        if (j3 == -9223372036854775807L) {
                            return zzace.zzd(zzb, zzf);
                        }
                        j2 = i2;
                    } else {
                        if (100000 + zzb > j) {
                            j2 = zzfpVar.zzd();
                            break;
                        }
                        i2 = zzfpVar.zzd();
                        j3 = zzb;
                    }
                }
                int zze = zzfpVar.zze();
                if (zzfpVar.zzb() < 10) {
                    zzfpVar.zzK(zze);
                } else {
                    zzfpVar.zzL(9);
                    int zzm = zzfpVar.zzm() & 7;
                    if (zzfpVar.zzb() < zzm) {
                        zzfpVar.zzK(zze);
                    } else {
                        zzfpVar.zzL(zzm);
                        if (zzfpVar.zzb() < 4) {
                            zzfpVar.zzK(zze);
                        } else {
                            if (zzans.zzh(zzfpVar.zzM(), zzfpVar.zzd()) == 443) {
                                zzfpVar.zzL(4);
                                int zzq = zzfpVar.zzq();
                                if (zzfpVar.zzb() < zzq) {
                                    zzfpVar.zzK(zze);
                                } else {
                                    zzfpVar.zzL(zzq);
                                }
                            }
                            while (true) {
                                if (zzfpVar.zzb() < 4 || (zzh = zzans.zzh(zzfpVar.zzM(), zzfpVar.zzd())) == 442 || zzh == 441 || (zzh >>> 8) != 1) {
                                    break;
                                }
                                zzfpVar.zzL(4);
                                if (zzfpVar.zzb() >= 2) {
                                    zzfpVar.zzK(Math.min(zzfpVar.zze(), zzfpVar.zzd() + zzfpVar.zzq()));
                                } else {
                                    zzfpVar.zzK(zze);
                                    break;
                                }
                            }
                        }
                    }
                }
                i = zzfpVar.zzd();
            }
        }
        return zzace.zze(zzf + j2);
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final void zzb() {
        byte[] bArr = zzfy.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
    }
}

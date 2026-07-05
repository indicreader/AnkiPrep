package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgyu implements zzhbq {
    private final zzgyt zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzgyu(zzgyt zzgytVar) {
        byte[] bArr = zzhae.zzd;
        this.zza = zzgytVar;
        zzgytVar.zzc = this;
    }

    private final void zzP(Object obj, zzhby zzhbyVar, zzgzf zzgzfVar) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzhbyVar.zzh(obj, this, zzgzfVar);
            if (this.zzb == this.zzc) {
            } else {
                throw zzhag.zzg();
            }
        } finally {
            this.zzc = i;
        }
    }

    private final void zzQ(Object obj, zzhby zzhbyVar, zzgzf zzgzfVar) throws IOException {
        zzgyt zzgytVar = this.zza;
        int zzn = zzgytVar.zzn();
        if (zzgytVar.zza >= zzgytVar.zzb) {
            throw new zzhag("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int zze = this.zza.zze(zzn);
        this.zza.zza++;
        zzhbyVar.zzh(obj, this, zzgzfVar);
        this.zza.zzz(0);
        r4.zza--;
        this.zza.zzA(zze);
    }

    private final void zzR(int i) throws IOException {
        if (this.zza.zzd() != i) {
            throw zzhag.zzj();
        }
    }

    private final void zzS(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzhag.zza();
        }
    }

    private static final void zzT(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzhag.zzg();
        }
    }

    private static final void zzU(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzhag.zzg();
        }
    }

    public static zzgyu zzq(zzgyt zzgytVar) {
        zzgyu zzgyuVar = zzgytVar.zzc;
        return zzgyuVar != null ? zzgyuVar : new zzgyu(zzgytVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzA(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzhat) {
            zzhat zzhatVar = (zzhat) list;
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 == 2) {
                    int zzn = this.zza.zzn();
                    zzU(zzn);
                    int zzd = this.zza.zzd() + zzn;
                    do {
                        zzhatVar.zzg(this.zza.zzo());
                    } while (this.zza.zzd() < zzd);
                    return;
                }
                throw zzhag.zza();
            }
            do {
                zzhatVar.zzg(this.zza.zzo());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i = this.zza.zzm();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 1) {
                if (i3 == 2) {
                    int zzn2 = this.zza.zzn();
                    zzU(zzn2);
                    int zzd2 = this.zza.zzd() + zzn2;
                    do {
                        list.add(Long.valueOf(this.zza.zzo()));
                    } while (this.zza.zzd() < zzd2);
                    return;
                }
                throw zzhag.zza();
            }
            do {
                list.add(Long.valueOf(this.zza.zzo()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzB(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzgzm) {
            zzgzm zzgzmVar = (zzgzm) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    zzgzmVar.zze(this.zza.zzc());
                } while (this.zza.zzd() < zzd);
                return;
            }
            if (i2 != 5) {
                throw zzhag.zza();
            }
            do {
                zzgzmVar.zze(this.zza.zzc());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i = this.zza.zzm();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
            if (i3 != 5) {
                throw zzhag.zza();
            }
            do {
                list.add(Float.valueOf(this.zza.zzc()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    @Deprecated
    public final void zzC(List list, zzhby zzhbyVar, zzgzf zzgzfVar) throws IOException {
        int zzm;
        int i = this.zzb;
        if ((i & 7) != 3) {
            throw zzhag.zza();
        }
        do {
            Object zze = zzhbyVar.zze();
            zzP(zze, zzhbyVar, zzgzfVar);
            zzhbyVar.zzf(zze);
            list.add(zze);
            if (this.zza.zzC() || this.zzd != 0) {
                return;
            } else {
                zzm = this.zza.zzm();
            }
        } while (zzm == i);
        this.zzd = zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzD(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzgzv) {
            zzgzv zzgzvVar = (zzgzv) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 == 2) {
                    zzgyt zzgytVar = this.zza;
                    int zzd = zzgytVar.zzd() + zzgytVar.zzn();
                    do {
                        zzgzvVar.zzh(this.zza.zzh());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzhag.zza();
            }
            do {
                zzgzvVar.zzh(this.zza.zzh());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i = this.zza.zzm();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    zzgyt zzgytVar2 = this.zza;
                    int zzd2 = zzgytVar2.zzd() + zzgytVar2.zzn();
                    do {
                        list.add(Integer.valueOf(this.zza.zzh()));
                    } while (this.zza.zzd() < zzd2);
                    zzR(zzd2);
                    return;
                }
                throw zzhag.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzE(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzhat) {
            zzhat zzhatVar = (zzhat) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 == 2) {
                    zzgyt zzgytVar = this.zza;
                    int zzd = zzgytVar.zzd() + zzgytVar.zzn();
                    do {
                        zzhatVar.zzg(this.zza.zzp());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzhag.zza();
            }
            do {
                zzhatVar.zzg(this.zza.zzp());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i = this.zza.zzm();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    zzgyt zzgytVar2 = this.zza;
                    int zzd2 = zzgytVar2.zzd() + zzgytVar2.zzn();
                    do {
                        list.add(Long.valueOf(this.zza.zzp()));
                    } while (this.zza.zzd() < zzd2);
                    zzR(zzd2);
                    return;
                }
                throw zzhag.zza();
            }
            do {
                list.add(Long.valueOf(this.zza.zzp()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzF(List list, zzhby zzhbyVar, zzgzf zzgzfVar) throws IOException {
        int zzm;
        int i = this.zzb;
        if ((i & 7) != 2) {
            throw zzhag.zza();
        }
        do {
            Object zze = zzhbyVar.zze();
            zzQ(zze, zzhbyVar, zzgzfVar);
            zzhbyVar.zzf(zze);
            list.add(zze);
            if (this.zza.zzC() || this.zzd != 0) {
                return;
            } else {
                zzm = this.zza.zzm();
            }
        } while (zzm == i);
        this.zzd = zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzG(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzgzv) {
            zzgzv zzgzvVar = (zzgzv) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    zzgzvVar.zzh(this.zza.zzk());
                } while (this.zza.zzd() < zzd);
                return;
            }
            if (i2 != 5) {
                throw zzhag.zza();
            }
            do {
                zzgzvVar.zzh(this.zza.zzk());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i = this.zza.zzm();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
            if (i3 != 5) {
                throw zzhag.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzk()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzH(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzhat) {
            zzhat zzhatVar = (zzhat) list;
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 == 2) {
                    int zzn = this.zza.zzn();
                    zzU(zzn);
                    int zzd = this.zza.zzd() + zzn;
                    do {
                        zzhatVar.zzg(this.zza.zzt());
                    } while (this.zza.zzd() < zzd);
                    return;
                }
                throw zzhag.zza();
            }
            do {
                zzhatVar.zzg(this.zza.zzt());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i = this.zza.zzm();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 1) {
                if (i3 == 2) {
                    int zzn2 = this.zza.zzn();
                    zzU(zzn2);
                    int zzd2 = this.zza.zzd() + zzn2;
                    do {
                        list.add(Long.valueOf(this.zza.zzt()));
                    } while (this.zza.zzd() < zzd2);
                    return;
                }
                throw zzhag.zza();
            }
            do {
                list.add(Long.valueOf(this.zza.zzt()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzI(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzgzv) {
            zzgzv zzgzvVar = (zzgzv) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 == 2) {
                    zzgyt zzgytVar = this.zza;
                    int zzd = zzgytVar.zzd() + zzgytVar.zzn();
                    do {
                        zzgzvVar.zzh(this.zza.zzl());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzhag.zza();
            }
            do {
                zzgzvVar.zzh(this.zza.zzl());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i = this.zza.zzm();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    zzgyt zzgytVar2 = this.zza;
                    int zzd2 = zzgytVar2.zzd() + zzgytVar2.zzn();
                    do {
                        list.add(Integer.valueOf(this.zza.zzl()));
                    } while (this.zza.zzd() < zzd2);
                    zzR(zzd2);
                    return;
                }
                throw zzhag.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzl()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzJ(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzhat) {
            zzhat zzhatVar = (zzhat) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 == 2) {
                    zzgyt zzgytVar = this.zza;
                    int zzd = zzgytVar.zzd() + zzgytVar.zzn();
                    do {
                        zzhatVar.zzg(this.zza.zzu());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzhag.zza();
            }
            do {
                zzhatVar.zzg(this.zza.zzu());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i = this.zza.zzm();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    zzgyt zzgytVar2 = this.zza;
                    int zzd2 = zzgytVar2.zzd() + zzgytVar2.zzn();
                    do {
                        list.add(Long.valueOf(this.zza.zzu()));
                    } while (this.zza.zzd() < zzd2);
                    zzR(zzd2);
                    return;
                }
                throw zzhag.zza();
            }
            do {
                list.add(Long.valueOf(this.zza.zzu()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    public final void zzK(List list, boolean z) throws IOException {
        int zzm;
        int i;
        if ((this.zzb & 7) == 2) {
            if ((list instanceof zzham) && !z) {
                zzham zzhamVar = (zzham) list;
                do {
                    zzhamVar.zzi(zzp());
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        i = this.zza.zzm();
                    }
                } while (i == this.zzb);
            } else {
                do {
                    list.add(z ? zzs() : zzr());
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        zzm = this.zza.zzm();
                    }
                } while (zzm == this.zzb);
                i = zzm;
            }
            this.zzd = i;
            return;
        }
        throw zzhag.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzL(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzgzv) {
            zzgzv zzgzvVar = (zzgzv) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 == 2) {
                    zzgyt zzgytVar = this.zza;
                    int zzd = zzgytVar.zzd() + zzgytVar.zzn();
                    do {
                        zzgzvVar.zzh(this.zza.zzn());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzhag.zza();
            }
            do {
                zzgzvVar.zzh(this.zza.zzn());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i = this.zza.zzm();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    zzgyt zzgytVar2 = this.zza;
                    int zzd2 = zzgytVar2.zzd() + zzgytVar2.zzn();
                    do {
                        list.add(Integer.valueOf(this.zza.zzn()));
                    } while (this.zza.zzd() < zzd2);
                    zzR(zzd2);
                    return;
                }
                throw zzhag.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzn()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzM(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzhat) {
            zzhat zzhatVar = (zzhat) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 == 2) {
                    zzgyt zzgytVar = this.zza;
                    int zzd = zzgytVar.zzd() + zzgytVar.zzn();
                    do {
                        zzhatVar.zzg(this.zza.zzv());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzhag.zza();
            }
            do {
                zzhatVar.zzg(this.zza.zzv());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i = this.zza.zzm();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    zzgyt zzgytVar2 = this.zza;
                    int zzd2 = zzgytVar2.zzd() + zzgytVar2.zzn();
                    do {
                        list.add(Long.valueOf(this.zza.zzv()));
                    } while (this.zza.zzd() < zzd2);
                    zzR(zzd2);
                    return;
                }
                throw zzhag.zza();
            }
            do {
                list.add(Long.valueOf(this.zza.zzv()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final boolean zzN() throws IOException {
        zzS(0);
        return this.zza.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final boolean zzO() throws IOException {
        int i;
        if (this.zza.zzC() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzE(i);
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final double zza() throws IOException {
        zzS(1);
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final float zzb() throws IOException {
        zzS(5);
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final int zzc() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            i = this.zza.zzm();
            this.zzb = i;
        }
        if (i == 0 || i == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i >>> 3;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final int zze() throws IOException {
        zzS(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final int zzf() throws IOException {
        zzS(5);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final int zzg() throws IOException {
        zzS(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final int zzh() throws IOException {
        zzS(5);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final int zzi() throws IOException {
        zzS(0);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final int zzj() throws IOException {
        zzS(0);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final long zzk() throws IOException {
        zzS(1);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final long zzl() throws IOException {
        zzS(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final long zzm() throws IOException {
        zzS(1);
        return this.zza.zzt();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final long zzn() throws IOException {
        zzS(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final long zzo() throws IOException {
        zzS(0);
        return this.zza.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final zzgyl zzp() throws IOException {
        zzS(2);
        return this.zza.zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final String zzr() throws IOException {
        zzS(2);
        return this.zza.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final String zzs() throws IOException {
        zzS(2);
        return this.zza.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzt(Object obj, zzhby zzhbyVar, zzgzf zzgzfVar) throws IOException {
        zzS(3);
        zzP(obj, zzhbyVar, zzgzfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzu(Object obj, zzhby zzhbyVar, zzgzf zzgzfVar) throws IOException {
        zzS(2);
        zzQ(obj, zzhbyVar, zzgzfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzv(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzgxz) {
            zzgxz zzgxzVar = (zzgxz) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 == 2) {
                    zzgyt zzgytVar = this.zza;
                    int zzd = zzgytVar.zzd() + zzgytVar.zzn();
                    do {
                        zzgxzVar.zze(this.zza.zzD());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzhag.zza();
            }
            do {
                zzgxzVar.zze(this.zza.zzD());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i = this.zza.zzm();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    zzgyt zzgytVar2 = this.zza;
                    int zzd2 = zzgytVar2.zzd() + zzgytVar2.zzn();
                    do {
                        list.add(Boolean.valueOf(this.zza.zzD()));
                    } while (this.zza.zzd() < zzd2);
                    zzR(zzd2);
                    return;
                }
                throw zzhag.zza();
            }
            do {
                list.add(Boolean.valueOf(this.zza.zzD()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzw(List list) throws IOException {
        int zzm;
        if ((this.zzb & 7) != 2) {
            throw zzhag.zza();
        }
        do {
            list.add(zzp());
            if (this.zza.zzC()) {
                return;
            } else {
                zzm = this.zza.zzm();
            }
        } while (zzm == this.zzb);
        this.zzd = zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzx(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzgzc) {
            zzgzc zzgzcVar = (zzgzc) list;
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 == 2) {
                    int zzn = this.zza.zzn();
                    zzU(zzn);
                    int zzd = this.zza.zzd() + zzn;
                    do {
                        zzgzcVar.zze(this.zza.zzb());
                    } while (this.zza.zzd() < zzd);
                    return;
                }
                throw zzhag.zza();
            }
            do {
                zzgzcVar.zze(this.zza.zzb());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i = this.zza.zzm();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 1) {
                if (i3 == 2) {
                    int zzn2 = this.zza.zzn();
                    zzU(zzn2);
                    int zzd2 = this.zza.zzd() + zzn2;
                    do {
                        list.add(Double.valueOf(this.zza.zzb()));
                    } while (this.zza.zzd() < zzd2);
                    return;
                }
                throw zzhag.zza();
            }
            do {
                list.add(Double.valueOf(this.zza.zzb()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzy(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzgzv) {
            zzgzv zzgzvVar = (zzgzv) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 == 2) {
                    zzgyt zzgytVar = this.zza;
                    int zzd = zzgytVar.zzd() + zzgytVar.zzn();
                    do {
                        zzgzvVar.zzh(this.zza.zzf());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzhag.zza();
            }
            do {
                zzgzvVar.zzh(this.zza.zzf());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i = this.zza.zzm();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    zzgyt zzgytVar2 = this.zza;
                    int zzd2 = zzgytVar2.zzd() + zzgytVar2.zzn();
                    do {
                        list.add(Integer.valueOf(this.zza.zzf()));
                    } while (this.zza.zzd() < zzd2);
                    zzR(zzd2);
                    return;
                }
                throw zzhag.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzz(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzgzv) {
            zzgzv zzgzvVar = (zzgzv) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    zzgzvVar.zzh(this.zza.zzg());
                } while (this.zza.zzd() < zzd);
                return;
            }
            if (i2 != 5) {
                throw zzhag.zza();
            }
            do {
                zzgzvVar.zzh(this.zza.zzg());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i = this.zza.zzm();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
            if (i3 != 5) {
                throw zzhag.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzg()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }
}

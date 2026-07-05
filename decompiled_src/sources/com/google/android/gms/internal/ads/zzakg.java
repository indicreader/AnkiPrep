package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzakg extends zzake {
    private zzakf zza;
    private int zzb;
    private boolean zzc;
    private zzaef zzd;
    private zzaed zze;

    @Override // com.google.android.gms.internal.ads.zzake
    protected final long zza(zzfp zzfpVar) {
        if ((zzfpVar.zzM()[0] & 1) == 1) {
            return -1L;
        }
        byte b = zzfpVar.zzM()[0];
        zzakf zzakfVar = this.zza;
        zzek.zzb(zzakfVar);
        int i = !zzakfVar.zzd[(b >> 1) & (255 >>> (8 - zzakfVar.zze))].zza ? zzakfVar.zza.zze : zzakfVar.zza.zzf;
        int i2 = this.zzc ? (this.zzb + i) / 4 : 0;
        if (zzfpVar.zzc() < zzfpVar.zze() + 4) {
            byte[] copyOf = Arrays.copyOf(zzfpVar.zzM(), zzfpVar.zze() + 4);
            zzfpVar.zzI(copyOf, copyOf.length);
        } else {
            zzfpVar.zzJ(zzfpVar.zze() + 4);
        }
        long j = i2;
        byte[] zzM = zzfpVar.zzM();
        zzM[zzfpVar.zze() - 4] = (byte) (j & 255);
        zzM[zzfpVar.zze() - 3] = (byte) ((j >>> 8) & 255);
        zzM[zzfpVar.zze() - 2] = (byte) ((j >>> 16) & 255);
        zzM[zzfpVar.zze() - 1] = (byte) ((j >>> 24) & 255);
        this.zzc = true;
        this.zzb = i;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzake
    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzake
    public final void zzi(long j) {
        super.zzi(j);
        this.zzc = j != 0;
        zzaef zzaefVar = this.zzd;
        this.zzb = zzaefVar != null ? zzaefVar.zze : 0;
    }

    @Override // com.google.android.gms.internal.ads.zzake
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean zzc(zzfp zzfpVar, long j, zzakb zzakbVar) throws IOException {
        zzakf zzakfVar;
        int i;
        int i2;
        int i3;
        int i4;
        zzaef zzaefVar;
        long j2;
        if (this.zza != null) {
            zzakbVar.zza.getClass();
            return false;
        }
        zzaef zzaefVar2 = this.zzd;
        int i5 = 4;
        if (zzaefVar2 == null) {
            zzaeg.zzd(1, zzfpVar, false);
            int zzj = zzfpVar.zzj();
            int zzm = zzfpVar.zzm();
            int zzj2 = zzfpVar.zzj();
            int zzi = zzfpVar.zzi();
            int i6 = zzi <= 0 ? -1 : zzi;
            int zzi2 = zzfpVar.zzi();
            int i7 = zzi2 <= 0 ? -1 : zzi2;
            int zzi3 = zzfpVar.zzi();
            int i8 = zzi3 <= 0 ? -1 : zzi3;
            int zzm2 = zzfpVar.zzm();
            this.zzd = new zzaef(zzj, zzm, zzj2, i6, i7, i8, (int) Math.pow(2.0d, zzm2 & 15), (int) Math.pow(2.0d, (zzm2 & 240) >> 4), 1 == (zzfpVar.zzm() & 1), Arrays.copyOf(zzfpVar.zzM(), zzfpVar.zze()));
        } else {
            zzaed zzaedVar = this.zze;
            if (zzaedVar == null) {
                this.zze = zzaeg.zzc(zzfpVar, true, true);
            } else {
                byte[] bArr = new byte[zzfpVar.zze()];
                System.arraycopy(zzfpVar.zzM(), 0, bArr, 0, zzfpVar.zze());
                int i9 = zzaefVar2.zza;
                int i10 = 5;
                zzaeg.zzd(5, zzfpVar, false);
                int zzm3 = zzfpVar.zzm() + 1;
                zzaec zzaecVar = new zzaec(zzfpVar.zzM());
                zzaecVar.zzc(zzfpVar.zzd() * 8);
                int i11 = 0;
                while (true) {
                    int i12 = 2;
                    int i13 = 16;
                    if (i11 < zzm3) {
                        if (zzaecVar.zzb(24) != 5653314) {
                            throw zzcc.zza("expected code book to start with [0x56, 0x43, 0x42] at " + zzaecVar.zza(), null);
                        }
                        int zzb = zzaecVar.zzb(16);
                        int zzb2 = zzaecVar.zzb(24);
                        if (!zzaecVar.zzd()) {
                            boolean zzd = zzaecVar.zzd();
                            for (int i14 = 0; i14 < zzb2; i14++) {
                                if (zzd) {
                                    if (zzaecVar.zzd()) {
                                        zzaecVar.zzc(5);
                                    }
                                } else {
                                    zzaecVar.zzc(5);
                                }
                            }
                        } else {
                            zzaecVar.zzc(5);
                            for (int i15 = 0; i15 < zzb2; i15 += zzaecVar.zzb(zzaeg.zza(zzb2 - i15))) {
                            }
                        }
                        int zzb3 = zzaecVar.zzb(i5);
                        if (zzb3 > 2) {
                            throw zzcc.zza("lookup type greater than 2 not decodable: " + zzb3, null);
                        }
                        if (zzb3 == 1) {
                            i12 = zzb3;
                        } else if (zzb3 != 2) {
                            zzaefVar = zzaefVar2;
                            i11++;
                            zzaefVar2 = zzaefVar;
                            i5 = 4;
                        }
                        zzaecVar.zzc(32);
                        zzaecVar.zzc(32);
                        int zzb4 = zzaecVar.zzb(i5) + 1;
                        zzaecVar.zzc(1);
                        if (i12 != 1) {
                            zzaefVar = zzaefVar2;
                            j2 = zzb * zzb2;
                        } else if (zzb != 0) {
                            zzaefVar = zzaefVar2;
                            j2 = (long) Math.floor(Math.pow(zzb2, 1.0d / zzb));
                        } else {
                            zzaefVar = zzaefVar2;
                            j2 = 0;
                        }
                        zzaecVar.zzc((int) (j2 * zzb4));
                        i11++;
                        zzaefVar2 = zzaefVar;
                        i5 = 4;
                    } else {
                        zzaef zzaefVar3 = zzaefVar2;
                        int i16 = 6;
                        int zzb5 = zzaecVar.zzb(6) + 1;
                        for (int i17 = 0; i17 < zzb5; i17++) {
                            if (zzaecVar.zzb(16) != 0) {
                                throw zzcc.zza("placeholder of time domain transforms not zeroed out", null);
                            }
                        }
                        int i18 = 1;
                        int zzb6 = zzaecVar.zzb(6) + 1;
                        int i19 = 0;
                        while (true) {
                            int i20 = 3;
                            if (i19 < zzb6) {
                                int zzb7 = zzaecVar.zzb(i13);
                                if (zzb7 == 0) {
                                    i3 = zzb6;
                                    int i21 = 8;
                                    zzaecVar.zzc(8);
                                    zzaecVar.zzc(16);
                                    zzaecVar.zzc(16);
                                    zzaecVar.zzc(6);
                                    zzaecVar.zzc(8);
                                    int zzb8 = zzaecVar.zzb(4) + 1;
                                    int i22 = 0;
                                    while (i22 < zzb8) {
                                        zzaecVar.zzc(i21);
                                        i22++;
                                        i21 = 8;
                                    }
                                } else {
                                    if (zzb7 != i18) {
                                        throw zzcc.zza("floor type greater than 1 not decodable: " + zzb7, null);
                                    }
                                    int zzb9 = zzaecVar.zzb(i10);
                                    int[] iArr = new int[zzb9];
                                    int i23 = -1;
                                    for (int i24 = 0; i24 < zzb9; i24++) {
                                        int zzb10 = zzaecVar.zzb(4);
                                        iArr[i24] = zzb10;
                                        if (zzb10 > i23) {
                                            i23 = zzb10;
                                        }
                                    }
                                    int i25 = i23 + 1;
                                    int[] iArr2 = new int[i25];
                                    int i26 = 0;
                                    while (i26 < i25) {
                                        iArr2[i26] = zzaecVar.zzb(i20) + 1;
                                        int zzb11 = zzaecVar.zzb(i12);
                                        if (zzb11 > 0) {
                                            i4 = 8;
                                            zzaecVar.zzc(8);
                                        } else {
                                            i4 = 8;
                                        }
                                        int i27 = zzb6;
                                        int i28 = 0;
                                        for (int i29 = 1; i28 < (i29 << zzb11); i29 = 1) {
                                            zzaecVar.zzc(i4);
                                            i28++;
                                            i4 = 8;
                                        }
                                        i26++;
                                        zzb6 = i27;
                                        i12 = 2;
                                        i20 = 3;
                                    }
                                    i3 = zzb6;
                                    zzaecVar.zzc(i12);
                                    int zzb12 = zzaecVar.zzb(4);
                                    int i30 = 0;
                                    int i31 = 0;
                                    for (int i32 = 0; i32 < zzb9; i32++) {
                                        i30 += iArr2[iArr[i32]];
                                        while (i31 < i30) {
                                            zzaecVar.zzc(zzb12);
                                            i31++;
                                        }
                                    }
                                }
                                i19++;
                                zzb6 = i3;
                                i16 = 6;
                                i12 = 2;
                                i13 = 16;
                                i18 = 1;
                                i10 = 5;
                            } else {
                                int i33 = 1;
                                int zzb13 = zzaecVar.zzb(i16) + 1;
                                int i34 = 0;
                                while (i34 < zzb13) {
                                    if (zzaecVar.zzb(16) <= 2) {
                                        zzaecVar.zzc(24);
                                        zzaecVar.zzc(24);
                                        zzaecVar.zzc(24);
                                        int zzb14 = zzaecVar.zzb(i16) + i33;
                                        int i35 = 8;
                                        zzaecVar.zzc(8);
                                        int[] iArr3 = new int[zzb14];
                                        for (int i36 = 0; i36 < zzb14; i36++) {
                                            iArr3[i36] = ((zzaecVar.zzd() ? zzaecVar.zzb(5) : 0) * 8) + zzaecVar.zzb(3);
                                        }
                                        int i37 = 0;
                                        while (i37 < zzb14) {
                                            int i38 = 0;
                                            while (i38 < i35) {
                                                if ((iArr3[i37] & (1 << i38)) != 0) {
                                                    zzaecVar.zzc(i35);
                                                }
                                                i38++;
                                                i35 = 8;
                                            }
                                            i37++;
                                            i35 = 8;
                                        }
                                        i34++;
                                        i16 = 6;
                                        i33 = 1;
                                    } else {
                                        throw zzcc.zza("residueType greater than 2 is not decodable", null);
                                    }
                                }
                                int zzb15 = zzaecVar.zzb(i16) + 1;
                                for (int i39 = 0; i39 < zzb15; i39++) {
                                    int zzb16 = zzaecVar.zzb(16);
                                    if (zzb16 != 0) {
                                        zzff.zzc("VorbisUtil", "mapping type other than 0 not supported: " + zzb16);
                                    } else {
                                        if (zzaecVar.zzd()) {
                                            i = 1;
                                            i2 = zzaecVar.zzb(4) + 1;
                                        } else {
                                            i = 1;
                                            i2 = 1;
                                        }
                                        if (zzaecVar.zzd()) {
                                            int zzb17 = zzaecVar.zzb(8) + i;
                                            for (int i40 = 0; i40 < zzb17; i40++) {
                                                int i41 = i9 - 1;
                                                zzaecVar.zzc(zzaeg.zza(i41));
                                                zzaecVar.zzc(zzaeg.zza(i41));
                                            }
                                        }
                                        if (zzaecVar.zzb(2) != 0) {
                                            throw zzcc.zza("to reserved bits must be zero after mapping coupling steps", null);
                                        }
                                        if (i2 > 1) {
                                            for (int i42 = 0; i42 < i9; i42++) {
                                                zzaecVar.zzc(4);
                                            }
                                        }
                                        for (int i43 = 0; i43 < i2; i43++) {
                                            zzaecVar.zzc(8);
                                            zzaecVar.zzc(8);
                                            zzaecVar.zzc(8);
                                        }
                                    }
                                }
                                int zzb18 = zzaecVar.zzb(6);
                                int i44 = zzb18 + 1;
                                zzaee[] zzaeeVarArr = new zzaee[i44];
                                for (int i45 = 0; i45 < i44; i45++) {
                                    zzaeeVarArr[i45] = new zzaee(zzaecVar.zzd(), zzaecVar.zzb(16), zzaecVar.zzb(16), zzaecVar.zzb(8));
                                }
                                if (!zzaecVar.zzd()) {
                                    throw zzcc.zza("framing bit after modes not set as expected", null);
                                }
                                zzakfVar = new zzakf(zzaefVar3, zzaedVar, bArr, zzaeeVarArr, zzaeg.zza(zzb18));
                            }
                        }
                    }
                }
            }
        }
        zzakfVar = null;
        this.zza = zzakfVar;
        if (zzakfVar == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        zzaef zzaefVar4 = zzakfVar.zza;
        arrayList.add(zzaefVar4.zzg);
        arrayList.add(zzakfVar.zzc);
        zzby zzb19 = zzaeg.zzb(zzgaa.zzk(zzakfVar.zzb.zzb));
        zzak zzakVar = new zzak();
        zzakVar.zzW("audio/vorbis");
        zzakVar.zzx(zzaefVar4.zzd);
        zzakVar.zzR(zzaefVar4.zzc);
        zzakVar.zzy(zzaefVar4.zza);
        zzakVar.zzX(zzaefVar4.zzb);
        zzakVar.zzL(arrayList);
        zzakVar.zzP(zzb19);
        zzakbVar.zza = zzakVar.zzac();
        return true;
    }
}

package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzaju extends zzake {
    private zzadh zza;
    private zzajt zzb;

    private static boolean zzd(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.google.android.gms.internal.ads.zzake
    protected final long zza(zzfp zzfpVar) {
        if (!zzd(zzfpVar.zzM())) {
            return -1L;
        }
        int i = (zzfpVar.zzM()[2] & 255) >> 4;
        if (i != 6) {
            if (i == 7) {
                i = 7;
            }
            int zza = zzadd.zza(zzfpVar, i);
            zzfpVar.zzK(0);
            return zza;
        }
        zzfpVar.zzL(4);
        zzfpVar.zzw();
        int zza2 = zzadd.zza(zzfpVar, i);
        zzfpVar.zzK(0);
        return zza2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzake
    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzb = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzake
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean zzc(zzfp zzfpVar, long j, zzakb zzakbVar) {
        byte[] zzM = zzfpVar.zzM();
        zzadh zzadhVar = this.zza;
        if (zzadhVar == null) {
            zzadh zzadhVar2 = new zzadh(zzM, 17);
            this.zza = zzadhVar2;
            zzakbVar.zza = zzadhVar2.zzc(Arrays.copyOfRange(zzM, 9, zzfpVar.zze()), null);
            return true;
        }
        if ((zzM[0] & Byte.MAX_VALUE) == 3) {
            zzadg zzb = zzade.zzb(zzfpVar);
            zzadh zzf = zzadhVar.zzf(zzb);
            this.zza = zzf;
            this.zzb = new zzajt(zzf, zzb);
            return true;
        }
        if (!zzd(zzM)) {
            return true;
        }
        zzajt zzajtVar = this.zzb;
        if (zzajtVar != null) {
            zzajtVar.zza(j);
            zzakbVar.zzb = this.zzb;
        }
        zzakbVar.zza.getClass();
        return false;
    }
}

package com.google.android.gms.internal.ads;

import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzafb extends zzafg {
    private static final int[] zzb = {5512, 11025, 22050, 44100};
    private boolean zzc;
    private boolean zzd;
    private int zze;

    public zzafb(zzaea zzaeaVar) {
        super(zzaeaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    protected final boolean zza(zzfp zzfpVar) throws zzaff {
        if (!this.zzc) {
            int zzm = zzfpVar.zzm();
            int i = zzm >> 4;
            this.zze = i;
            if (i == 2) {
                int i2 = zzb[(zzm >> 2) & 3];
                zzak zzakVar = new zzak();
                zzakVar.zzW("audio/mpeg");
                zzakVar.zzy(1);
                zzakVar.zzX(i2);
                this.zza.zzl(zzakVar.zzac());
                this.zzd = true;
            } else if (i == 7 || i == 8) {
                zzak zzakVar2 = new zzak();
                zzakVar2.zzW(i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw");
                zzakVar2.zzy(1);
                zzakVar2.zzX(8000);
                this.zza.zzl(zzakVar2.zzac());
                this.zzd = true;
            } else if (i != 10) {
                throw new zzaff("Audio format not supported: " + i);
            }
            this.zzc = true;
        } else {
            zzfpVar.zzL(1);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    protected final boolean zzb(zzfp zzfpVar, long j) throws zzcc {
        if (this.zze == 2) {
            int zzb2 = zzfpVar.zzb();
            this.zza.zzr(zzfpVar, zzb2);
            this.zza.zzt(j, 1, zzb2, 0, null);
            return true;
        }
        int zzm = zzfpVar.zzm();
        if (zzm != 0 || this.zzd) {
            if (this.zze == 10 && zzm != 1) {
                return false;
            }
            int zzb3 = zzfpVar.zzb();
            this.zza.zzr(zzfpVar, zzb3);
            this.zza.zzt(j, 1, zzb3, 0, null);
            return true;
        }
        int zzb4 = zzfpVar.zzb();
        byte[] bArr = new byte[zzb4];
        zzfpVar.zzG(bArr, 0, zzb4);
        zzabr zza = zzabs.zza(bArr);
        zzak zzakVar = new zzak();
        zzakVar.zzW("audio/mp4a-latm");
        zzakVar.zzz(zza.zzc);
        zzakVar.zzy(zza.zzb);
        zzakVar.zzX(zza.zza);
        zzakVar.zzL(Collections.singletonList(bArr));
        this.zza.zzl(zzakVar.zzac());
        this.zzd = true;
        return false;
    }
}

package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzadm {
    private final zzfp zza = new zzfp(10);

    public final zzby zza(zzacv zzacvVar, zzago zzagoVar) throws IOException {
        zzby zzbyVar = null;
        int i = 0;
        while (true) {
            try {
                ((zzack) zzacvVar).zzm(this.zza.zzM(), 0, 10, false);
                this.zza.zzK(0);
                if (this.zza.zzo() != 4801587) {
                    break;
                }
                this.zza.zzL(3);
                int zzl = this.zza.zzl();
                int i2 = zzl + 10;
                if (zzbyVar == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.zza.zzM(), 0, bArr, 0, 10);
                    ((zzack) zzacvVar).zzm(bArr, 10, zzl, false);
                    zzbyVar = zzagq.zza(bArr, i2, zzagoVar, new zzafr());
                } else {
                    ((zzack) zzacvVar).zzl(zzl, false);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        zzacvVar.zzj();
        ((zzack) zzacvVar).zzl(i, false);
        return zzbyVar;
    }
}

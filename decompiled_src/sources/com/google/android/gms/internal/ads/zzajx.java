package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzajx {
    private final zzajy zza = new zzajy();
    private final zzfp zzb = new zzfp(new byte[65025], 0);
    private int zzc = -1;
    private int zzd;
    private boolean zze;

    private final int zzf(int i) {
        int i2;
        int i3 = 0;
        this.zzd = 0;
        do {
            int i4 = this.zzd;
            int i5 = i + i4;
            zzajy zzajyVar = this.zza;
            if (i5 >= zzajyVar.zzc) {
                break;
            }
            this.zzd = i4 + 1;
            i2 = zzajyVar.zzf[i5];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public final zzfp zza() {
        return this.zzb;
    }

    public final zzajy zzb() {
        return this.zza;
    }

    public final void zzc() {
        this.zza.zza();
        this.zzb.zzH(0);
        this.zzc = -1;
        this.zze = false;
    }

    public final void zzd() {
        zzfp zzfpVar = this.zzb;
        if (zzfpVar.zzM().length == 65025) {
            return;
        }
        zzfpVar.zzI(Arrays.copyOf(zzfpVar.zzM(), Math.max(65025, zzfpVar.zze())), this.zzb.zze());
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x004d, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zze(com.google.android.gms.internal.ads.zzacv r7) throws java.io.IOException {
        /*
            r6 = this;
            boolean r0 = r6.zze
            r1 = 0
            if (r0 != 0) goto L6
            goto Ld
        L6:
            r6.zze = r1
            com.google.android.gms.internal.ads.zzfp r0 = r6.zzb
            r0.zzH(r1)
        Ld:
            boolean r0 = r6.zze
            r2 = 1
            if (r0 != 0) goto L99
            int r0 = r6.zzc
            if (r0 >= 0) goto L4e
            com.google.android.gms.internal.ads.zzajy r0 = r6.zza
            r3 = -1
            boolean r0 = r0.zzc(r7, r3)
            if (r0 == 0) goto L4d
            com.google.android.gms.internal.ads.zzajy r0 = r6.zza
            boolean r0 = r0.zzb(r7, r2)
            if (r0 != 0) goto L29
            goto L4d
        L29:
            com.google.android.gms.internal.ads.zzajy r0 = r6.zza
            int r3 = r0.zzd
            int r0 = r0.zza
            r0 = r0 & r2
            if (r0 != r2) goto L42
            com.google.android.gms.internal.ads.zzfp r0 = r6.zzb
            int r0 = r0.zze()
            if (r0 != 0) goto L42
            int r0 = r6.zzf(r1)
            int r3 = r3 + r0
            int r0 = r6.zzd
            goto L43
        L42:
            r0 = r1
        L43:
            boolean r3 = com.google.android.gms.internal.ads.zzacy.zze(r7, r3)
            if (r3 != 0) goto L4a
            return r1
        L4a:
            r6.zzc = r0
            goto L4e
        L4d:
            return r1
        L4e:
            int r0 = r6.zzf(r0)
            int r3 = r6.zzc
            int r4 = r6.zzd
            int r3 = r3 + r4
            if (r0 <= 0) goto L8e
            com.google.android.gms.internal.ads.zzfp r4 = r6.zzb
            int r5 = r4.zze()
            int r5 = r5 + r0
            r4.zzE(r5)
            com.google.android.gms.internal.ads.zzfp r4 = r6.zzb
            byte[] r5 = r4.zzM()
            int r4 = r4.zze()
            boolean r4 = com.google.android.gms.internal.ads.zzacy.zzd(r7, r5, r4, r0)
            if (r4 != 0) goto L74
            return r1
        L74:
            com.google.android.gms.internal.ads.zzfp r4 = r6.zzb
            int r5 = r4.zze()
            int r5 = r5 + r0
            r4.zzJ(r5)
            com.google.android.gms.internal.ads.zzajy r0 = r6.zza
            int r4 = r3 + (-1)
            int[] r0 = r0.zzf
            r0 = r0[r4]
            r4 = 255(0xff, float:3.57E-43)
            if (r0 == r4) goto L8b
            goto L8c
        L8b:
            r2 = r1
        L8c:
            r6.zze = r2
        L8e:
            com.google.android.gms.internal.ads.zzajy r0 = r6.zza
            int r0 = r0.zzc
            if (r3 != r0) goto L95
            r3 = -1
        L95:
            r6.zzc = r3
            goto Ld
        L99:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajx.zze(com.google.android.gms.internal.ads.zzacv):boolean");
    }
}

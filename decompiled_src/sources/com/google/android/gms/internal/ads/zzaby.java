package com.google.android.gms.internal.ads;

import com.google.common.primitives.SignedBytes;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzaby {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0090, code lost:
    
        if (r12 != 11) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0095, code lost:
    
        if (r12 != 11) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009a, code lost:
    
        if (r12 != 8) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzabx zza(com.google.android.gms.internal.ads.zzfo r12) {
        /*
            r0 = 16
            int r1 = r12.zzd(r0)
            int r0 = r12.zzd(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L18
            r0 = 24
            int r0 = r12.zzd(r0)
            r2 = 7
            goto L19
        L18:
            r2 = r3
        L19:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L21
            int r0 = r0 + 2
        L21:
            r8 = r0
            r0 = 2
            int r1 = r12.zzd(r0)
            r2 = 0
            r4 = 3
            if (r1 != r4) goto L3d
            r1 = r2
        L2c:
            int r5 = r12.zzd(r0)
            int r1 = r1 + r5
            boolean r5 = r12.zzo()
            if (r5 != 0) goto L39
            int r1 = r1 + r4
            goto L3d
        L39:
            int r1 = r1 + 1
            int r1 = r1 << r0
            goto L2c
        L3d:
            r5 = r1
            r1 = 10
            int r1 = r12.zzd(r1)
            boolean r6 = r12.zzo()
            if (r6 == 0) goto L53
            int r6 = r12.zzd(r4)
            if (r6 <= 0) goto L53
            r12.zzm(r0)
        L53:
            boolean r6 = r12.zzo()
            r7 = 44100(0xac44, float:6.1797E-41)
            r9 = 48000(0xbb80, float:6.7262E-41)
            r10 = 1
            if (r10 == r6) goto L62
            r11 = r7
            goto L63
        L62:
            r11 = r9
        L63:
            int r12 = r12.zzd(r3)
            if (r11 != r7) goto L73
            r6 = 13
            if (r12 != r6) goto L73
            int[] r12 = com.google.android.gms.internal.ads.zzaby.zzb
            r12 = r12[r6]
            r9 = r12
            goto L9f
        L73:
            if (r11 != r9) goto L9e
            r6 = 14
            if (r12 >= r6) goto L9e
            int[] r2 = com.google.android.gms.internal.ads.zzaby.zzb
            r2 = r2[r12]
            int r1 = r1 % 5
            r6 = 8
            if (r1 == r10) goto L98
            r7 = 11
            if (r1 == r0) goto L93
            if (r1 == r4) goto L98
            if (r1 == r3) goto L8c
            goto L9e
        L8c:
            if (r12 == r4) goto L9c
            if (r12 == r6) goto L9c
            if (r12 != r7) goto L9e
            goto L9c
        L93:
            if (r12 == r6) goto L9c
            if (r12 != r7) goto L9e
            goto L9c
        L98:
            if (r12 == r4) goto L9c
            if (r12 != r6) goto L9e
        L9c:
            int r2 = r2 + 1
        L9e:
            r9 = r2
        L9f:
            com.google.android.gms.internal.ads.zzabx r12 = new com.google.android.gms.internal.ads.zzabx
            r6 = 2
            r10 = 0
            r4 = r12
            r7 = r11
            r4.<init>(r5, r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaby.zza(com.google.android.gms.internal.ads.zzfo):com.google.android.gms.internal.ads.zzabx");
    }

    public static void zzb(int i, zzfp zzfpVar) {
        zzfpVar.zzH(7);
        byte[] zzM = zzfpVar.zzM();
        zzM[0] = -84;
        zzM[1] = SignedBytes.MAX_POWER_OF_TWO;
        zzM[2] = -1;
        zzM[3] = -1;
        zzM[4] = (byte) ((i >> 16) & 255);
        zzM[5] = (byte) ((i >> 8) & 255);
        zzM[6] = (byte) (i & 255);
    }
}

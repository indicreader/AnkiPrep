package com.google.android.gms.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public class MediationUtils {
    protected static final double MIN_HEIGHT_RATIO = 0.7d;
    protected static final double MIN_WIDTH_RATIO = 0.5d;

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c7 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.ads.AdSize findClosestSize(android.content.Context r9, com.google.android.gms.ads.AdSize r10, java.util.List<com.google.android.gms.ads.AdSize> r11) {
        /*
            r0 = 0
            if (r11 == 0) goto Lca
            if (r10 != 0) goto L7
            goto Lca
        L7:
            boolean r1 = r10.zzh()
            if (r1 != 0) goto L36
            boolean r1 = r10.zzi()
            if (r1 != 0) goto L36
            android.content.res.Resources r1 = r9.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            float r1 = r1.density
            int r2 = r10.getWidthInPixels(r9)
            float r2 = (float) r2
            float r2 = r2 / r1
            int r2 = java.lang.Math.round(r2)
            int r9 = r10.getHeightInPixels(r9)
            float r9 = (float) r9
            float r9 = r9 / r1
            int r9 = java.lang.Math.round(r9)
            com.google.android.gms.ads.AdSize r10 = new com.google.android.gms.ads.AdSize
            r10.<init>(r2, r9)
        L36:
            java.util.Iterator r9 = r11.iterator()
        L3a:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto Lca
            java.lang.Object r11 = r9.next()
            com.google.android.gms.ads.AdSize r11 = (com.google.android.gms.ads.AdSize) r11
            if (r11 == 0) goto L3a
            int r1 = r10.getWidth()
            int r2 = r11.getWidth()
            int r3 = r10.getHeight()
            double r4 = (double) r1
            r6 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r4 = r4 * r6
            double r6 = (double) r2
            int r8 = r11.getHeight()
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 > 0) goto L3a
            if (r1 < r2) goto L3a
            boolean r1 = r10.zzi()
            if (r1 == 0) goto L94
            int r1 = r10.zza()
            com.google.android.gms.internal.ads.zzbfu r3 = com.google.android.gms.internal.ads.zzbgc.zzhK
            com.google.android.gms.internal.ads.zzbga r4 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r3 = r4.zza(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r3 > r2) goto L3a
            com.google.android.gms.internal.ads.zzbfu r2 = com.google.android.gms.internal.ads.zzbgc.zzhL
            com.google.android.gms.internal.ads.zzbga r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r2 > r8) goto L3a
            if (r1 < r8) goto L3a
            goto Lb0
        L94:
            boolean r1 = r10.zzh()
            if (r1 == 0) goto La1
            int r1 = r10.zzb()
            if (r1 < r8) goto L3a
            goto Lb0
        La1:
            double r1 = (double) r3
            r4 = 4604480259023595110(0x3fe6666666666666, double:0.7)
            double r1 = r1 * r4
            double r4 = (double) r8
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 > 0) goto L3a
            if (r3 >= r8) goto Lb0
            goto L3a
        Lb0:
            if (r0 != 0) goto Lb3
            goto Lc7
        Lb3:
            int r1 = r0.getWidth()
            int r2 = r0.getHeight()
            int r1 = r1 * r2
            int r2 = r11.getWidth()
            int r3 = r11.getHeight()
            int r2 = r2 * r3
            if (r1 > r2) goto L3a
        Lc7:
            r0 = r11
            goto L3a
        Lca:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.MediationUtils.findClosestSize(android.content.Context, com.google.android.gms.ads.AdSize, java.util.List):com.google.android.gms.ads.AdSize");
    }
}

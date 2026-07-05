package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzpd {
    public static final zzpd zza = new zzpd(new int[]{2}, 10);
    private static final zzgaa zzb = zzgaa.zzo(2, 5, 6);
    private static final zzgad zzc;
    private final int[] zzd;
    private final int zze;

    static {
        zzgac zzgacVar = new zzgac();
        zzgacVar.zza(5, 6);
        zzgacVar.zza(17, 6);
        zzgacVar.zza(7, 6);
        zzgacVar.zza(30, 10);
        zzgacVar.zza(18, 6);
        zzgacVar.zza(6, 8);
        zzgacVar.zza(8, 8);
        zzgacVar.zza(14, 8);
        zzc = zzgacVar.zzc();
    }

    public zzpd(int[] iArr, int i) {
        int[] copyOf = Arrays.copyOf(iArr, 1);
        this.zzd = copyOf;
        Arrays.sort(copyOf);
        this.zze = 10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzpd)) {
            return false;
        }
        zzpd zzpdVar = (zzpd) obj;
        if (!Arrays.equals(this.zzd, zzpdVar.zzd)) {
            return false;
        }
        int i = zzpdVar.zze;
        return true;
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.zzd) * 31) + 10;
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=10, supportedEncodings=" + Arrays.toString(this.zzd) + "]";
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x009b, code lost:
    
        if (r6 != 5) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x003e, code lost:
    
        if (zzc(30) == false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair zza(com.google.android.gms.internal.ads.zzam r9, com.google.android.gms.internal.ads.zzk r10) {
        /*
            r8 = this;
            java.lang.String r0 = r9.zzm
            r0.getClass()
            java.lang.String r1 = r9.zzj
            int r0 = com.google.android.gms.internal.ads.zzcb.zza(r0, r1)
            com.google.android.gms.internal.ads.zzgad r1 = com.google.android.gms.internal.ads.zzpd.zzc
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            boolean r2 = r1.containsKey(r2)
            if (r2 != 0) goto L19
            goto Lc6
        L19:
            r2 = 7
            r3 = 6
            r4 = 8
            r5 = 18
            if (r0 != r5) goto L2a
            boolean r0 = r8.zzc(r5)
            if (r0 != 0) goto L29
            r0 = r3
            goto L41
        L29:
            r0 = r5
        L2a:
            if (r0 != r4) goto L36
            boolean r0 = r8.zzc(r4)
            if (r0 == 0) goto L34
            r0 = r4
            goto L36
        L34:
            r0 = r2
            goto L41
        L36:
            r6 = 30
            if (r0 != r6) goto L41
            boolean r6 = r8.zzc(r6)
            if (r6 != 0) goto L41
            goto L34
        L41:
            boolean r6 = r8.zzc(r0)
            if (r6 == 0) goto Lc6
            int r6 = r9.zzz
            r7 = -1
            if (r6 == r7) goto L62
            if (r0 != r5) goto L4f
            goto L62
        L4f:
            java.lang.String r9 = r9.zzm
            java.lang.String r10 = "audio/vnd.dts.uhd;profile=p2"
            boolean r9 = r9.equals(r10)
            r10 = 10
            if (r9 == 0) goto L5f
            if (r6 <= r10) goto L8a
            goto Lc6
        L5f:
            if (r6 <= r10) goto L8a
            goto Lc6
        L62:
            int r9 = r9.zzA
            if (r9 != r7) goto L69
            r9 = 48000(0xbb80, float:6.7262E-41)
        L69:
            int r5 = com.google.android.gms.internal.ads.zzfy.zza
            r6 = 29
            if (r5 < r6) goto L74
            int r6 = com.google.android.gms.internal.ads.zzpc.zza(r0, r9, r10)
            goto L8a
        L74:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r0)
            r10 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.Object r9 = r1.getOrDefault(r9, r10)
            java.lang.Integer r9 = (java.lang.Integer) r9
            r9.getClass()
            int r6 = r9.intValue()
        L8a:
            int r9 = com.google.android.gms.internal.ads.zzfy.zza
            r10 = 28
            if (r9 > r10) goto L9e
            if (r6 != r2) goto L94
            r3 = r4
            goto L9f
        L94:
            r9 = 3
            if (r6 == r9) goto L9f
            r9 = 4
            if (r6 == r9) goto L9f
            r9 = 5
            if (r6 != r9) goto L9e
            goto L9f
        L9e:
            r3 = r6
        L9f:
            int r9 = com.google.android.gms.internal.ads.zzfy.zza
            r10 = 26
            if (r9 > r10) goto Lb3
            java.lang.String r9 = "fugu"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzfy.zzb
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto Lb3
            r9 = 1
            if (r3 != r9) goto Lb3
            r3 = 2
        Lb3:
            int r9 = com.google.android.gms.internal.ads.zzfy.zzg(r3)
            if (r9 == 0) goto Lc6
            java.lang.Integer r10 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            android.util.Pair r9 = android.util.Pair.create(r10, r9)
            return r9
        Lc6:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpd.zza(com.google.android.gms.internal.ads.zzam, com.google.android.gms.internal.ads.zzk):android.util.Pair");
    }

    public final boolean zzc(int i) {
        return Arrays.binarySearch(this.zzd, i) >= 0;
    }
}

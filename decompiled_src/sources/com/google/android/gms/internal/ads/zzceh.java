package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzceh implements zzcdu {
    private final String zza;

    public zzceh() {
        this.zza = null;
    }

    public zzceh(String str) {
        this.zza = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0085, code lost:
    
        if (com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide() == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00d7, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00d4, code lost:
    
        android.net.TrafficStats.clearThreadStatsTag();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b2, code lost:
    
        if (com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide() != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d2, code lost:
    
        if (com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide() == false) goto L40;
     */
    @Override // com.google.android.gms.internal.ads.zzcdu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zza(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = ". "
            java.lang.String r1 = "Received non-success response code "
            java.lang.String r2 = "Error while pinging URL: "
            java.lang.String r3 = "Error while parsing ping URL: "
            java.lang.String r4 = "Pinging URL: "
            r5 = 0
            boolean r6 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()     // Catch: java.lang.RuntimeException -> L88 java.io.IOException -> L8a java.lang.IndexOutOfBoundsException -> L8c java.lang.Throwable -> L93
            if (r6 == 0) goto L16
            r6 = 263(0x107, float:3.69E-43)
            android.net.TrafficStats.setThreadStatsTag(r6)     // Catch: java.lang.RuntimeException -> L88 java.io.IOException -> L8a java.lang.IndexOutOfBoundsException -> L8c java.lang.Throwable -> L93
        L16:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.RuntimeException -> L88 java.io.IOException -> L8a java.lang.IndexOutOfBoundsException -> L8c java.lang.Throwable -> L93
            r6.<init>(r4)     // Catch: java.lang.RuntimeException -> L88 java.io.IOException -> L8a java.lang.IndexOutOfBoundsException -> L8c java.lang.Throwable -> L93
            r6.append(r10)     // Catch: java.lang.RuntimeException -> L88 java.io.IOException -> L8a java.lang.IndexOutOfBoundsException -> L8c java.lang.Throwable -> L93
            java.lang.String r4 = r6.toString()     // Catch: java.lang.RuntimeException -> L88 java.io.IOException -> L8a java.lang.IndexOutOfBoundsException -> L8c java.lang.Throwable -> L93
            com.google.android.gms.internal.ads.zzcec.zze(r4)     // Catch: java.lang.RuntimeException -> L88 java.io.IOException -> L8a java.lang.IndexOutOfBoundsException -> L8c java.lang.Throwable -> L93
            java.net.URL r4 = new java.net.URL     // Catch: java.lang.RuntimeException -> L88 java.io.IOException -> L8a java.lang.IndexOutOfBoundsException -> L8c java.lang.Throwable -> L93
            r4.<init>(r10)     // Catch: java.lang.RuntimeException -> L88 java.io.IOException -> L8a java.lang.IndexOutOfBoundsException -> L8c java.lang.Throwable -> L93
            java.net.URLConnection r4 = r4.openConnection()     // Catch: java.lang.RuntimeException -> L88 java.io.IOException -> L8a java.lang.IndexOutOfBoundsException -> L8c java.lang.Throwable -> L93
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch: java.lang.RuntimeException -> L88 java.io.IOException -> L8a java.lang.IndexOutOfBoundsException -> L8c java.lang.Throwable -> L93
            com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch: java.lang.Throwable -> L8e
            java.lang.String r6 = r9.zza     // Catch: java.lang.Throwable -> L8e
            r7 = 60000(0xea60, float:8.4078E-41)
            r4.setConnectTimeout(r7)     // Catch: java.lang.Throwable -> L8e
            r8 = 1
            r4.setInstanceFollowRedirects(r8)     // Catch: java.lang.Throwable -> L8e
            r4.setReadTimeout(r7)     // Catch: java.lang.Throwable -> L8e
            if (r6 == 0) goto L49
            java.lang.String r7 = "User-Agent"
            r4.setRequestProperty(r7, r6)     // Catch: java.lang.Throwable -> L8e
        L49:
            r4.setUseCaches(r5)     // Catch: java.lang.Throwable -> L8e
            com.google.android.gms.internal.ads.zzceb r6 = new com.google.android.gms.internal.ads.zzceb     // Catch: java.lang.Throwable -> L8e
            r7 = 0
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            r6.zzc(r4, r7)     // Catch: java.lang.Throwable -> L8e
            int r7 = r4.getResponseCode()     // Catch: java.lang.Throwable -> L8e
            r6.zze(r4, r7)     // Catch: java.lang.Throwable -> L8e
            r6 = 200(0xc8, float:2.8E-43)
            if (r7 < r6) goto L67
            r6 = 300(0x12c, float:4.2E-43)
            if (r7 < r6) goto L65
            goto L67
        L65:
            r5 = r8
            goto L7e
        L67:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8e
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L8e
            r6.append(r7)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r1 = " from pinging URL: "
            r6.append(r1)     // Catch: java.lang.Throwable -> L8e
            r6.append(r10)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r1 = r6.toString()     // Catch: java.lang.Throwable -> L8e
            com.google.android.gms.internal.ads.zzcec.zzj(r1)     // Catch: java.lang.Throwable -> L8e
        L7e:
            r4.disconnect()     // Catch: java.lang.RuntimeException -> L88 java.io.IOException -> L8a java.lang.IndexOutOfBoundsException -> L8c java.lang.Throwable -> L93
            boolean r10 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r10 == 0) goto Ld7
            goto Ld4
        L88:
            r1 = move-exception
            goto L95
        L8a:
            r1 = move-exception
            goto L95
        L8c:
            r1 = move-exception
            goto Lb5
        L8e:
            r1 = move-exception
            r4.disconnect()     // Catch: java.lang.RuntimeException -> L88 java.io.IOException -> L8a java.lang.IndexOutOfBoundsException -> L8c java.lang.Throwable -> L93
            throw r1     // Catch: java.lang.RuntimeException -> L88 java.io.IOException -> L8a java.lang.IndexOutOfBoundsException -> L8c java.lang.Throwable -> L93
        L93:
            r10 = move-exception
            goto Ld8
        L95:
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L93
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L93
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L93
            r3.append(r10)     // Catch: java.lang.Throwable -> L93
            r3.append(r0)     // Catch: java.lang.Throwable -> L93
            r3.append(r1)     // Catch: java.lang.Throwable -> L93
            java.lang.String r10 = r3.toString()     // Catch: java.lang.Throwable -> L93
            com.google.android.gms.internal.ads.zzcec.zzj(r10)     // Catch: java.lang.Throwable -> L93
            boolean r10 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r10 == 0) goto Ld7
            goto Ld4
        Lb5:
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L93
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L93
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L93
            r2.append(r10)     // Catch: java.lang.Throwable -> L93
            r2.append(r0)     // Catch: java.lang.Throwable -> L93
            r2.append(r1)     // Catch: java.lang.Throwable -> L93
            java.lang.String r10 = r2.toString()     // Catch: java.lang.Throwable -> L93
            com.google.android.gms.internal.ads.zzcec.zzj(r10)     // Catch: java.lang.Throwable -> L93
            boolean r10 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r10 == 0) goto Ld7
        Ld4:
            android.net.TrafficStats.clearThreadStatsTag()
        Ld7:
            return r5
        Ld8:
            boolean r0 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r0 == 0) goto Le1
            android.net.TrafficStats.clearThreadStatsTag()
        Le1:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzceh.zza(java.lang.String):boolean");
    }
}

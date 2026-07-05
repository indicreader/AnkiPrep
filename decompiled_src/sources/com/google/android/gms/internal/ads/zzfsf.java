package com.google.android.gms.internal.ads;

import java.io.File;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfsf {
    private final zzayf zza;
    private final File zzb;
    private final File zzc;
    private final File zzd;
    private byte[] zze;

    public zzfsf(zzayf zzayfVar, File file, File file2, File file3) {
        this.zza = zzayfVar;
        this.zzb = file;
        this.zzc = file3;
        this.zzd = file2;
    }

    public final zzayf zza() {
        return this.zza;
    }

    public final File zzb() {
        return this.zzc;
    }

    public final File zzc() {
        return this.zzb;
    }

    public final boolean zzd(long j) {
        return this.zza.zzc() - (System.currentTimeMillis() / 1000) < 3600;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0059 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] zze() {
        /*
            r9 = this;
            byte[] r0 = r9.zze
            r1 = 0
            if (r0 != 0) goto L55
            java.io.File r0 = r9.zzd
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4e
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4e
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L4f
            r0.<init>()     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L4f
            r3 = 256(0x100, float:3.59E-43)
        L13:
            byte[] r4 = new byte[r3]     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L4f
            r5 = 0
            r6 = r5
        L17:
            if (r6 >= r3) goto L25
            int r7 = r3 - r6
            int r7 = r2.read(r4, r6, r7)     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L4f
            r8 = -1
            if (r7 != r8) goto L23
            goto L25
        L23:
            int r6 = r6 + r7
            goto L17
        L25:
            if (r6 != 0) goto L29
            r4 = r1
            goto L2d
        L29:
            com.google.android.gms.internal.ads.zzgyl r4 = com.google.android.gms.internal.ads.zzgyl.zzv(r4, r5, r6)     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L4f
        L2d:
            if (r4 != 0) goto L3b
            com.google.android.gms.internal.ads.zzgyl r0 = com.google.android.gms.internal.ads.zzgyl.zzu(r0)     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L4f
            byte[] r0 = r0.zzA()     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L4f
            com.google.android.gms.common.util.IOUtils.closeQuietly(r2)
            goto L53
        L3b:
            r0.add(r4)     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L4f
            int r3 = r3 + r3
            r4 = 8192(0x2000, float:1.14794E-41)
            int r3 = java.lang.Math.min(r3, r4)     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L4f
            goto L13
        L46:
            r0 = move-exception
            r1 = r2
            goto L4a
        L49:
            r0 = move-exception
        L4a:
            com.google.android.gms.common.util.IOUtils.closeQuietly(r1)
            throw r0
        L4e:
            r2 = r1
        L4f:
            com.google.android.gms.common.util.IOUtils.closeQuietly(r2)
            r0 = r1
        L53:
            r9.zze = r0
        L55:
            byte[] r0 = r9.zze
            if (r0 != 0) goto L5a
            return r1
        L5a:
            int r1 = r0.length
            byte[] r0 = java.util.Arrays.copyOf(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfsf.zze():byte[]");
    }
}

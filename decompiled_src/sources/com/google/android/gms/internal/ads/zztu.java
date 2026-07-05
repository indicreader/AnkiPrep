package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zztu implements zzvi {
    private final zzadb zza;
    private zzacu zzb;
    private zzacv zzc;

    public zztu(zzadb zzadbVar) {
        this.zza = zzadbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvi
    public final long zzb() {
        zzacv zzacvVar = this.zzc;
        if (zzacvVar != null) {
            return zzacvVar.zzf();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzvi
    public final void zzc() {
        zzacu zzacuVar = this.zzb;
        if (zzacuVar != null && (zzacuVar instanceof zzaig)) {
            ((zzaig) zzacuVar).zza();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x004b, code lost:
    
        if (r6.zzf() != r11) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0070, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x006d, code lost:
    
        if (r6.zzf() != r11) goto L38;
     */
    @Override // com.google.android.gms.internal.ads.zzvi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzd(com.google.android.gms.internal.ads.zzu r8, android.net.Uri r9, java.util.Map r10, long r11, long r13, com.google.android.gms.internal.ads.zzacx r15) throws java.io.IOException {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzack r6 = new com.google.android.gms.internal.ads.zzack
            r0 = r6
            r1 = r8
            r2 = r11
            r4 = r13
            r0.<init>(r1, r2, r4)
            r7.zzc = r6
            com.google.android.gms.internal.ads.zzacu r8 = r7.zzb
            if (r8 == 0) goto L10
            return
        L10:
            com.google.android.gms.internal.ads.zzadb r8 = r7.zza
            com.google.android.gms.internal.ads.zzacu[] r8 = r8.zza(r9, r10)
            int r10 = r8.length
            r13 = 0
            r14 = 1
            if (r10 != r14) goto L21
            r8 = r8[r13]
            r7.zzb = r8
            goto Lbe
        L21:
            r0 = r13
        L22:
            if (r0 >= r10) goto L7c
            r1 = r8[r0]
            boolean r2 = r1.zze(r6)     // Catch: java.lang.Throwable -> L4e java.io.EOFException -> L63
            if (r2 == 0) goto L41
            r7.zzb = r1     // Catch: java.lang.Throwable -> L4e java.io.EOFException -> L63
            if (r1 != 0) goto L3a
            long r0 = r6.zzf()
            int r10 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r10 != 0) goto L39
            goto L3a
        L39:
            r14 = r13
        L3a:
            com.google.android.gms.internal.ads.zzek.zzf(r14)
            r6.zzj()
            goto L7c
        L41:
            com.google.android.gms.internal.ads.zzacu r1 = r7.zzb
            if (r1 != 0) goto L72
            long r1 = r6.zzf()
            int r1 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r1 != 0) goto L70
            goto L72
        L4e:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzacu r9 = r7.zzb
            if (r9 != 0) goto L5b
            long r9 = r6.zzf()
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 != 0) goto L5c
        L5b:
            r13 = r14
        L5c:
            com.google.android.gms.internal.ads.zzek.zzf(r13)
            r6.zzj()
            throw r8
        L63:
            com.google.android.gms.internal.ads.zzacu r1 = r7.zzb
            if (r1 != 0) goto L72
            long r1 = r6.zzf()
            int r1 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r1 != 0) goto L70
            goto L72
        L70:
            r1 = r13
            goto L73
        L72:
            r1 = r14
        L73:
            com.google.android.gms.internal.ads.zzek.zzf(r1)
            r6.zzj()
            int r0 = r0 + 1
            goto L22
        L7c:
            com.google.android.gms.internal.ads.zzacu r10 = r7.zzb
            if (r10 != 0) goto Lbe
            com.google.android.gms.internal.ads.zzwt r10 = new com.google.android.gms.internal.ads.zzwt
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
        L87:
            int r12 = r8.length
            if (r13 >= r12) goto La3
            r14 = r8[r13]
            java.lang.Class r14 = r14.getClass()
            java.lang.String r14 = r14.getSimpleName()
            r11.append(r14)
            int r12 = r12 + (-1)
            if (r13 >= r12) goto La0
            java.lang.String r12 = ", "
            r11.append(r12)
        La0:
            int r13 = r13 + 1
            goto L87
        La3:
            java.lang.String r8 = r11.toString()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "None of the available extractors ("
            r11.<init>(r12)
            r11.append(r8)
            java.lang.String r8 = ") could read the stream."
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            r10.<init>(r8, r9)
            throw r10
        Lbe:
            com.google.android.gms.internal.ads.zzacu r8 = r7.zzb
            r8.zzc(r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztu.zzd(com.google.android.gms.internal.ads.zzu, android.net.Uri, java.util.Map, long, long, com.google.android.gms.internal.ads.zzacx):void");
    }

    @Override // com.google.android.gms.internal.ads.zzvi
    public final void zze() {
        if (this.zzb != null) {
            this.zzb = null;
        }
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzvi
    public final void zzf(long j, long j2) {
        zzacu zzacuVar = this.zzb;
        zzacuVar.getClass();
        zzacuVar.zzd(j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzvi
    public final int zza(zzadr zzadrVar) throws IOException {
        zzacu zzacuVar = this.zzb;
        zzacuVar.getClass();
        zzacv zzacvVar = this.zzc;
        zzacvVar.getClass();
        return zzacuVar.zzb(zzacvVar, zzadrVar);
    }
}

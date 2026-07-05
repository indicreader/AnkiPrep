package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzum extends zzwu {
    private final boolean zzb;
    private final zzcw zzc;
    private final zzcu zzd;
    private zzuk zze;
    private zzuj zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    public zzum(zzut zzutVar, boolean z) {
        super(zzutVar);
        boolean z2;
        if (z) {
            zzutVar.zzv();
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzb = z2;
        this.zzc = new zzcw();
        this.zzd = new zzcu();
        zzutVar.zzM();
        this.zze = zzuk.zzq(zzutVar.zzJ());
    }

    private final Object zzK(Object obj) {
        return (zzuk.zzs(this.zze) == null || !obj.equals(zzuk.zzd)) ? obj : zzuk.zzs(this.zze);
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    private final void zzL(long j) {
        zzuj zzujVar = this.zzf;
        int zza = this.zze.zza(zzujVar.zza.zza);
        if (zza == -1) {
            return;
        }
        zzuk zzukVar = this.zze;
        zzcu zzcuVar = this.zzd;
        zzukVar.zzd(zza, zzcuVar, false);
        long j2 = zzcuVar.zze;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        zzujVar.zzs(j);
    }

    public final zzcx zzC() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    protected final zzur zzD(zzur zzurVar) {
        Object zzs = zzuk.zzs(this.zze);
        Object obj = zzurVar.zza;
        if (zzs != null && zzuk.zzs(this.zze).equals(obj)) {
            obj = zzuk.zzd;
        }
        return zzurVar.zza(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    @Override // com.google.android.gms.internal.ads.zzwu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void zzE(com.google.android.gms.internal.ads.zzcx r15) {
        /*
            r14 = this;
            boolean r0 = r14.zzh
            r1 = 0
            if (r0 == 0) goto L1a
            com.google.android.gms.internal.ads.zzuk r0 = r14.zze
            com.google.android.gms.internal.ads.zzuk r15 = r0.zzp(r15)
            r14.zze = r15
            com.google.android.gms.internal.ads.zzuj r15 = r14.zzf
            if (r15 == 0) goto L9b
            long r2 = r15.zzn()
            r14.zzL(r2)
            goto L9b
        L1a:
            boolean r0 = r15.zzo()
            if (r0 == 0) goto L36
            boolean r0 = r14.zzi
            if (r0 == 0) goto L2b
            com.google.android.gms.internal.ads.zzuk r0 = r14.zze
            com.google.android.gms.internal.ads.zzuk r15 = r0.zzp(r15)
            goto L33
        L2b:
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzcw.zza
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzuk.zzd
            com.google.android.gms.internal.ads.zzuk r15 = com.google.android.gms.internal.ads.zzuk.zzr(r15, r0, r2)
        L33:
            r14.zze = r15
            goto L9b
        L36:
            com.google.android.gms.internal.ads.zzcw r0 = r14.zzc
            r2 = 0
            r3 = 0
            r15.zze(r2, r0, r3)
            com.google.android.gms.internal.ads.zzcw r0 = r14.zzc
            java.lang.Object r0 = r0.zzc
            com.google.android.gms.internal.ads.zzuj r5 = r14.zzf
            if (r5 == 0) goto L62
            long r6 = r5.zzq()
            com.google.android.gms.internal.ads.zzuk r8 = r14.zze
            com.google.android.gms.internal.ads.zzcu r9 = r14.zzd
            com.google.android.gms.internal.ads.zzur r5 = r5.zza
            java.lang.Object r5 = r5.zza
            r8.zzn(r5, r9)
            com.google.android.gms.internal.ads.zzuk r5 = r14.zze
            com.google.android.gms.internal.ads.zzcw r8 = r14.zzc
            r5.zze(r2, r8, r3)
            int r2 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r2 == 0) goto L62
            r12 = r6
            goto L63
        L62:
            r12 = r3
        L63:
            com.google.android.gms.internal.ads.zzcw r9 = r14.zzc
            com.google.android.gms.internal.ads.zzcu r10 = r14.zzd
            r11 = 0
            r8 = r15
            android.util.Pair r2 = r8.zzl(r9, r10, r11, r12)
            java.lang.Object r3 = r2.first
            java.lang.Object r2 = r2.second
            java.lang.Long r2 = (java.lang.Long) r2
            long r4 = r2.longValue()
            boolean r2 = r14.zzi
            if (r2 == 0) goto L82
            com.google.android.gms.internal.ads.zzuk r0 = r14.zze
            com.google.android.gms.internal.ads.zzuk r15 = r0.zzp(r15)
            goto L86
        L82:
            com.google.android.gms.internal.ads.zzuk r15 = com.google.android.gms.internal.ads.zzuk.zzr(r15, r0, r3)
        L86:
            r14.zze = r15
            com.google.android.gms.internal.ads.zzuj r15 = r14.zzf
            if (r15 == 0) goto L9b
            r14.zzL(r4)
            com.google.android.gms.internal.ads.zzur r15 = r15.zza
            java.lang.Object r0 = r15.zza
            java.lang.Object r0 = r14.zzK(r0)
            com.google.android.gms.internal.ads.zzur r1 = r15.zza(r0)
        L9b:
            r15 = 1
            r14.zzi = r15
            r14.zzh = r15
            com.google.android.gms.internal.ads.zzuk r15 = r14.zze
            r14.zzo(r15)
            if (r1 == 0) goto Laf
            com.google.android.gms.internal.ads.zzuj r15 = r14.zzf
            r15.getClass()
            r15.zzr(r1)
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzum.zzE(com.google.android.gms.internal.ads.zzcx):void");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zzF() {
        if (this.zzb) {
            return;
        }
        this.zzg = true;
        zzB(null, ((zzwu) this).zza);
    }

    @Override // com.google.android.gms.internal.ads.zzwu, com.google.android.gms.internal.ads.zzut
    public final void zzG(zzup zzupVar) {
        ((zzuj) zzupVar).zzt();
        if (zzupVar == this.zzf) {
            this.zzf = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwu, com.google.android.gms.internal.ads.zzut
    /* renamed from: zzH, reason: merged with bridge method [inline-methods] */
    public final zzuj zzI(zzur zzurVar, zzyx zzyxVar, long j) {
        zzuj zzujVar = new zzuj(zzurVar, zzyxVar, j);
        zzujVar.zzu(this.zza);
        if (this.zzh) {
            zzujVar.zzr(zzurVar.zza(zzK(zzurVar.zza)));
        } else {
            this.zzf = zzujVar;
            if (!this.zzg) {
                this.zzg = true;
                zzB(null, ((zzwu) this).zza);
            }
        }
        return zzujVar;
    }

    @Override // com.google.android.gms.internal.ads.zzua, com.google.android.gms.internal.ads.zzts
    public final void zzq() {
        this.zzh = false;
        this.zzg = false;
        super.zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzts, com.google.android.gms.internal.ads.zzut
    public final void zzt(zzbp zzbpVar) {
        if (this.zzi) {
            this.zze = this.zze.zzp(new zzwq(this.zze.zzc, zzbpVar));
        } else {
            this.zze = zzuk.zzq(zzbpVar);
        }
        this.zza.zzt(zzbpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzua, com.google.android.gms.internal.ads.zzut
    public final void zzz() {
    }
}

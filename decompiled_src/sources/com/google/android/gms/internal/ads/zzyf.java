package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzyf extends zzyc {
    private final boolean zze;
    private final zzxu zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final boolean zzo;
    private final boolean zzp;
    private final int zzq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r2 <= 2.14748365E9f) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
    
        if (r1 >= 0) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0050, code lost:
    
        if (r1 >= 0) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
    
        if (r1 >= 0.0f) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0065, code lost:
    
        if (r10 >= 0) goto L169;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00b8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzyf(int r5, com.google.android.gms.internal.ads.zzcz r6, int r7, com.google.android.gms.internal.ads.zzxu r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyf.<init>(int, com.google.android.gms.internal.ads.zzcz, int, com.google.android.gms.internal.ads.zzxu, int, int, boolean):void");
    }

    public static /* synthetic */ int zza(zzyf zzyfVar, zzyf zzyfVar2) {
        zzgbj zzgbjVar;
        zzgbj zza;
        zzgbj zzgbjVar2;
        if (!zzyfVar.zze || !zzyfVar.zzh) {
            zzgbjVar = zzyg.zzc;
            zza = zzgbjVar.zza();
        } else {
            zza = zzyg.zzc;
        }
        zzfzp zzk = zzfzp.zzk();
        Integer valueOf = Integer.valueOf(zzyfVar.zzi);
        Integer valueOf2 = Integer.valueOf(zzyfVar2.zzi);
        boolean z = zzyfVar.zzf.zzB;
        zzgbjVar2 = zzyg.zzd;
        return zzk.zzd(valueOf, valueOf2, zzgbjVar2).zzd(Integer.valueOf(zzyfVar.zzj), Integer.valueOf(zzyfVar2.zzj), zza).zzd(Integer.valueOf(zzyfVar.zzi), Integer.valueOf(zzyfVar2.zzi), zza).zza();
    }

    public static /* synthetic */ int zzd(zzyf zzyfVar, zzyf zzyfVar2) {
        zzfzp zzd = zzfzp.zzk().zze(zzyfVar.zzh, zzyfVar2.zzh).zzb(zzyfVar.zzl, zzyfVar2.zzl).zze(zzyfVar.zzm, zzyfVar2.zzm).zze(zzyfVar.zze, zzyfVar2.zze).zze(zzyfVar.zzg, zzyfVar2.zzg).zzd(Integer.valueOf(zzyfVar.zzk), Integer.valueOf(zzyfVar2.zzk), zzgbj.zzc().zza());
        boolean z = zzyfVar.zzo;
        zzfzp zze = zzd.zze(z, zzyfVar2.zzo);
        boolean z2 = zzyfVar.zzp;
        zzfzp zze2 = zze.zze(z2, zzyfVar2.zzp);
        if (z && z2) {
            zze2 = zze2.zzb(zzyfVar.zzq, zzyfVar2.zzq);
        }
        return zze2.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final int zzb() {
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final /* bridge */ /* synthetic */ boolean zzc(zzyc zzycVar) {
        zzyf zzyfVar = (zzyf) zzycVar;
        if (!zzfy.zzF(this.zzd.zzm, zzyfVar.zzd.zzm)) {
            return false;
        }
        boolean z = this.zzf.zzL;
        return this.zzo == zzyfVar.zzo && this.zzp == zzyfVar.zzp;
    }
}

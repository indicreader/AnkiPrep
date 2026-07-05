package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzanl implements zzamy {
    private final String zza;
    private final zzfp zzb;
    private final zzfo zzc;
    private zzaea zzd;
    private String zze;
    private zzam zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private long zzk;
    private boolean zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private boolean zzp;
    private long zzq;
    private int zzr;
    private long zzs;
    private int zzt;
    private String zzu;

    public zzanl(String str) {
        this.zza = str;
        zzfp zzfpVar = new zzfp(1024);
        this.zzb = zzfpVar;
        byte[] zzM = zzfpVar.zzM();
        this.zzc = new zzfo(zzM, zzM.length);
        this.zzk = -9223372036854775807L;
    }

    private final int zzf(zzfo zzfoVar) throws zzcc {
        int zza = zzfoVar.zza();
        zzabr zzb = zzabs.zzb(zzfoVar, true);
        this.zzu = zzb.zzc;
        this.zzr = zzb.zza;
        this.zzt = zzb.zzb;
        return zza - zzfoVar.zza();
    }

    private static long zzg(zzfo zzfoVar) {
        return zzfoVar.zzd((zzfoVar.zzd(2) + 1) * 8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:134:0x0154, code lost:
    
        if (r14.zzl == false) goto L89;
     */
    @Override // com.google.android.gms.internal.ads.zzamy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.internal.ads.zzfp r15) throws com.google.android.gms.internal.ads.zzcc {
        /*
            Method dump skipped, instructions count: 544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanl.zza(com.google.android.gms.internal.ads.zzfp):void");
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        zzaokVar.zzc();
        this.zzd = zzacxVar.zzw(zzaokVar.zza(), 1);
        this.zze = zzaokVar.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzd(long j, int i) {
        this.zzk = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zze() {
        this.zzg = 0;
        this.zzk = -9223372036854775807L;
        this.zzl = false;
    }
}

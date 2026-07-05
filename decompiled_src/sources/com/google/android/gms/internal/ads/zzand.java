package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzand implements zzamy {
    private static final float[] zza = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    private final zzaon zzb;
    private final zzfp zzc;
    private final boolean[] zzd;
    private final zzanb zze;
    private final zzann zzf;
    private zzanc zzg;
    private long zzh;
    private String zzi;
    private zzaea zzj;
    private boolean zzk;
    private long zzl;

    public zzand() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x012c  */
    @Override // com.google.android.gms.internal.ads.zzamy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.internal.ads.zzfp r18) {
        /*
            Method dump skipped, instructions count: 481
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzand.zza(com.google.android.gms.internal.ads.zzfp):void");
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        zzaokVar.zzc();
        this.zzi = zzaokVar.zzb();
        this.zzj = zzacxVar.zzw(zzaokVar.zza(), 2);
        this.zzg = new zzanc(this.zzj);
        this.zzb.zzb(zzacxVar, zzaokVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzc(boolean z) {
        zzek.zzb(this.zzg);
        if (z) {
            this.zzg.zzb(this.zzh, 0, this.zzk);
            this.zzg.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzd(long j, int i) {
        this.zzl = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zze() {
        zzgm.zzf(this.zzd);
        this.zze.zzb();
        zzanc zzancVar = this.zzg;
        if (zzancVar != null) {
            zzancVar.zzd();
        }
        this.zzf.zzb();
        this.zzh = 0L;
        this.zzl = -9223372036854775807L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzand(zzaon zzaonVar) {
        this.zzb = zzaonVar;
        this.zzd = new boolean[4];
        this.zze = new zzanb(128);
        this.zzl = -9223372036854775807L;
        this.zzf = new zzann(178, 128);
        this.zzc = new zzfp();
    }
}

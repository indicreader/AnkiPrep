package com.google.android.gms.internal.ads;

import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzvy extends zzts implements zzvp {
    private final zzgv zza;
    private final zzry zzb;
    private final int zzc;
    private boolean zzd = true;
    private long zze = -9223372036854775807L;
    private boolean zzf;
    private boolean zzg;
    private zzhy zzh;
    private zzbp zzi;
    private final zzvv zzj;
    private final zzzb zzk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzvy(zzbp zzbpVar, zzgv zzgvVar, zzvv zzvvVar, zzry zzryVar, zzzb zzzbVar, int i, zzvx zzvxVar) {
        this.zzi = zzbpVar;
        this.zza = zzgvVar;
        this.zzj = zzvvVar;
        this.zzb = zzryVar;
        this.zzk = zzzbVar;
        this.zzc = i;
    }

    private final void zzw() {
        long j = this.zze;
        boolean z = this.zzf;
        boolean z2 = this.zzg;
        zzbp zzJ = zzJ();
        zzwl zzwlVar = new zzwl(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j, j, 0L, 0L, z, false, false, null, zzJ, z2 ? zzJ.zzf : null);
        zzo(this.zzd ? new zzvu(this, zzwlVar) : zzwlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzut
    public final void zzG(zzup zzupVar) {
        ((zzvt) zzupVar).zzN();
    }

    @Override // com.google.android.gms.internal.ads.zzut
    public final zzup zzI(zzur zzurVar, zzyx zzyxVar, long j) {
        zzgw zza = this.zza.zza();
        zzhy zzhyVar = this.zzh;
        if (zzhyVar != null) {
            zza.zzf(zzhyVar);
        }
        zzbi zzbiVar = zzJ().zzd;
        zzbiVar.getClass();
        zzvv zzvvVar = this.zzj;
        zzb();
        return new zzvt(zzbiVar.zzb, zza, new zztu(zzvvVar.zza), this.zzb, zzc(zzurVar), this.zzk, zze(zzurVar), this, zzyxVar, null, this.zzc, zzfy.zzq(-9223372036854775807L));
    }

    @Override // com.google.android.gms.internal.ads.zzut
    public final synchronized zzbp zzJ() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzvp
    public final void zza(long j, boolean z, boolean z2) {
        if (j == -9223372036854775807L) {
            j = this.zze;
        }
        if (!this.zzd && this.zze == j && this.zzf == z && this.zzg == z2) {
            return;
        }
        this.zze = j;
        this.zzf = z;
        this.zzg = z2;
        this.zzd = false;
        zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzts
    protected final void zzn(zzhy zzhyVar) {
        this.zzh = zzhyVar;
        Looper.myLooper().getClass();
        zzb();
        zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzts
    protected final void zzq() {
    }

    @Override // com.google.android.gms.internal.ads.zzts, com.google.android.gms.internal.ads.zzut
    public final synchronized void zzt(zzbp zzbpVar) {
        this.zzi = zzbpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzut
    public final void zzz() {
    }
}

package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzuj implements zzup, zzuo {
    public final zzur zza;
    private final long zzb;
    private zzut zzc;
    private zzup zzd;
    private zzuo zze;
    private long zzf = -9223372036854775807L;
    private final zzyx zzg;

    public zzuj(zzur zzurVar, zzyx zzyxVar, long j) {
        this.zza = zzurVar;
        this.zzg = zzyxVar;
        this.zzb = j;
    }

    private final long zzv(long j) {
        long j2 = this.zzf;
        return j2 != -9223372036854775807L ? j2 : j;
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zza(long j, zzmj zzmjVar) {
        zzup zzupVar = this.zzd;
        int i = zzfy.zza;
        return zzupVar.zza(j, zzmjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final long zzb() {
        zzup zzupVar = this.zzd;
        int i = zzfy.zza;
        return zzupVar.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final long zzc() {
        zzup zzupVar = this.zzd;
        int i = zzfy.zza;
        return zzupVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zzd() {
        zzup zzupVar = this.zzd;
        int i = zzfy.zza;
        return zzupVar.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zze(long j) {
        zzup zzupVar = this.zzd;
        int i = zzfy.zza;
        return zzupVar.zze(j);
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zzf(zzyi[] zzyiVarArr, boolean[] zArr, zzwh[] zzwhVarArr, boolean[] zArr2, long j) {
        long j2 = this.zzf;
        long j3 = (j2 == -9223372036854775807L || j != this.zzb) ? j : j2;
        this.zzf = -9223372036854775807L;
        zzup zzupVar = this.zzd;
        int i = zzfy.zza;
        return zzupVar.zzf(zzyiVarArr, zArr, zzwhVarArr, zArr2, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final /* bridge */ /* synthetic */ void zzg(zzwj zzwjVar) {
        zzuo zzuoVar = this.zze;
        int i = zzfy.zza;
        zzuoVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final zzws zzh() {
        zzup zzupVar = this.zzd;
        int i = zzfy.zza;
        return zzupVar.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzuo
    public final void zzi(zzup zzupVar) {
        zzuo zzuoVar = this.zze;
        int i = zzfy.zza;
        zzuoVar.zzi(this);
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzj(long j, boolean z) {
        zzup zzupVar = this.zzd;
        int i = zzfy.zza;
        zzupVar.zzj(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzk() throws IOException {
        zzup zzupVar = this.zzd;
        if (zzupVar != null) {
            zzupVar.zzk();
            return;
        }
        zzut zzutVar = this.zzc;
        if (zzutVar != null) {
            zzutVar.zzz();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzl(zzuo zzuoVar, long j) {
        this.zze = zzuoVar;
        zzup zzupVar = this.zzd;
        if (zzupVar != null) {
            zzupVar.zzl(this, zzv(this.zzb));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final void zzm(long j) {
        zzup zzupVar = this.zzd;
        int i = zzfy.zza;
        zzupVar.zzm(j);
    }

    public final long zzn() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final boolean zzo(zzlg zzlgVar) {
        zzup zzupVar = this.zzd;
        return zzupVar != null && zzupVar.zzo(zzlgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final boolean zzp() {
        zzup zzupVar = this.zzd;
        return zzupVar != null && zzupVar.zzp();
    }

    public final long zzq() {
        return this.zzb;
    }

    public final void zzr(zzur zzurVar) {
        long zzv = zzv(this.zzb);
        zzut zzutVar = this.zzc;
        zzutVar.getClass();
        zzup zzI = zzutVar.zzI(zzurVar, this.zzg, zzv);
        this.zzd = zzI;
        if (this.zze != null) {
            zzI.zzl(this, zzv);
        }
    }

    public final void zzs(long j) {
        this.zzf = j;
    }

    public final void zzu(zzut zzutVar) {
        zzek.zzf(this.zzc == null);
        this.zzc = zzutVar;
    }

    public final void zzt() {
        zzup zzupVar = this.zzd;
        if (zzupVar != null) {
            zzut zzutVar = this.zzc;
            zzutVar.getClass();
            zzutVar.zzG(zzupVar);
        }
    }
}

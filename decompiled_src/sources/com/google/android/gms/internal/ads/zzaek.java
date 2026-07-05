package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzaek implements zzadu {
    final /* synthetic */ zzaen zza;
    private final long zzb;

    public zzaek(zzaen zzaenVar, long j) {
        this.zza = zzaenVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j) {
        zzaeq[] zzaeqVarArr;
        zzaeq[] zzaeqVarArr2;
        zzaeq[] zzaeqVarArr3;
        zzaeqVarArr = this.zza.zzg;
        zzads zza = zzaeqVarArr[0].zza(j);
        int i = 1;
        while (true) {
            zzaen zzaenVar = this.zza;
            zzaeqVarArr2 = zzaenVar.zzg;
            if (i >= zzaeqVarArr2.length) {
                return zza;
            }
            zzaeqVarArr3 = zzaenVar.zzg;
            zzads zza2 = zzaeqVarArr3[i].zza(j);
            if (zza2.zza.zzc < zza.zza.zzc) {
                zza = zza2;
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }
}

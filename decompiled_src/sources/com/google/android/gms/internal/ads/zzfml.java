package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfml implements zzdhz, zzdbn, zzdid {
    private final zzfmz zza;
    private final zzfmo zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfml(Context context, zzfmz zzfmzVar) {
        this.zza = zzfmzVar;
        this.zzb = zzfmn.zza(context, 13);
    }

    @Override // com.google.android.gms.internal.ads.zzdid
    public final void zza() {
    }

    @Override // com.google.android.gms.internal.ads.zzdid
    public final void zzb() {
        if (((Boolean) zzbht.zzd.zze()).booleanValue()) {
            zzfmz zzfmzVar = this.zza;
            zzfmo zzfmoVar = this.zzb;
            zzfmoVar.zzf(true);
            zzfmzVar.zza(zzfmoVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdhz
    public final void zzk() {
    }

    @Override // com.google.android.gms.internal.ads.zzdhz
    public final void zzl() {
        if (((Boolean) zzbht.zzd.zze()).booleanValue()) {
            this.zzb.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbn
    public final void zzp(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (((Boolean) zzbht.zzd.zze()).booleanValue()) {
            zzfmz zzfmzVar = this.zza;
            zzfmo zzfmoVar = this.zzb;
            zzfmoVar.zzc(zzeVar.zza().toString());
            zzfmoVar.zzf(false);
            zzfmzVar.zza(zzfmoVar);
        }
    }
}

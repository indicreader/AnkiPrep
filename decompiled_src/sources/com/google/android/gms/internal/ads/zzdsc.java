package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdsc extends zzdrm implements zzdiu {
    private zzdiu zza;

    @Override // com.google.android.gms.internal.ads.zzdiu
    public final synchronized void zzbo() {
        zzdiu zzdiuVar = this.zza;
        if (zzdiuVar != null) {
            zzdiuVar.zzbo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void zzi(com.google.android.gms.ads.internal.client.zza zzaVar, zzblw zzblwVar, com.google.android.gms.ads.internal.overlay.zzp zzpVar, zzbly zzblyVar, com.google.android.gms.ads.internal.overlay.zzaa zzaaVar, zzdiu zzdiuVar) {
        super.zzh(zzaVar, zzblwVar, zzpVar, zzblyVar, zzaaVar);
        this.zza = zzdiuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdiu
    public final synchronized void zzs() {
        zzdiu zzdiuVar = this.zza;
        if (zzdiuVar != null) {
            zzdiuVar.zzs();
        }
    }
}

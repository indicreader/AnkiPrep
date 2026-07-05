package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdzw implements zzgej {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdzx zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdzw(zzdzx zzdzxVar, String str) {
        this.zza = str;
        this.zzb = zzdzxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdzl zzdzlVar;
        ((zzdyr) obj).zzf();
        zzdzlVar = this.zzb.zzd;
        zzdzlVar.zzk(this.zza);
    }
}

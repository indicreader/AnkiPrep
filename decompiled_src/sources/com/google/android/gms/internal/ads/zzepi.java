package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzepi extends com.google.android.gms.ads.internal.client.zzbm {
    private final zzeqp zza;

    public zzepi(Context context, zzclg zzclgVar, zzfhf zzfhfVar, zzdnl zzdnlVar, com.google.android.gms.ads.internal.client.zzbh zzbhVar) {
        zzeqr zzeqrVar = new zzeqr(zzdnlVar, zzclgVar.zzy());
        zzeqrVar.zze(zzbhVar);
        this.zza = new zzeqp(new zzerb(zzclgVar, context, zzeqrVar, zzfhfVar), zzfhfVar.zzI());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final synchronized String zze() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final synchronized String zzf() {
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zzg(com.google.android.gms.ads.internal.client.zzl zzlVar) throws RemoteException {
        this.zza.zzd(zzlVar, 1);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final synchronized void zzh(com.google.android.gms.ads.internal.client.zzl zzlVar, int i) throws RemoteException {
        this.zza.zzd(zzlVar, i);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final synchronized boolean zzi() throws RemoteException {
        return this.zza.zze();
    }
}

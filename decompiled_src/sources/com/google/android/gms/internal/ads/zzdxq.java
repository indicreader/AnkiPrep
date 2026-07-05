package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdxq extends com.google.android.gms.ads.internal.client.zzbg {
    final /* synthetic */ zzdxk zza;
    final /* synthetic */ zzdxr zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxq(zzdxr zzdxrVar, zzdxk zzdxkVar) {
        this.zza = zzdxkVar;
        this.zzb = zzdxrVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzc() throws RemoteException {
        long j;
        zzdxr zzdxrVar = this.zzb;
        zzdxk zzdxkVar = this.zza;
        j = zzdxrVar.zza;
        zzdxkVar.zzb(j);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzd() throws RemoteException {
        long j;
        zzdxr zzdxrVar = this.zzb;
        zzdxk zzdxkVar = this.zza;
        j = zzdxrVar.zza;
        zzdxkVar.zzc(j);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zze(int i) throws RemoteException {
        long j;
        zzdxr zzdxrVar = this.zzb;
        zzdxk zzdxkVar = this.zza;
        j = zzdxrVar.zza;
        zzdxkVar.zzd(j, i);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        long j;
        zzdxr zzdxrVar = this.zzb;
        zzdxk zzdxkVar = this.zza;
        j = zzdxrVar.zza;
        zzdxkVar.zzd(j, zzeVar.zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzg() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzh() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzi() throws RemoteException {
        long j;
        zzdxr zzdxrVar = this.zzb;
        zzdxk zzdxkVar = this.zza;
        j = zzdxrVar.zza;
        zzdxkVar.zze(j);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzj() throws RemoteException {
        long j;
        zzdxr zzdxrVar = this.zzb;
        zzdxk zzdxkVar = this.zza;
        j = zzdxrVar.zza;
        zzdxkVar.zzg(j);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzk() {
    }
}

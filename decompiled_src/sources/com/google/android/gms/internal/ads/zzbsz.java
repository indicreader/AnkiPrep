package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbsz extends zzayg implements zzbtb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbsz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zze() throws RemoteException {
        zzbm(1, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzf() throws RemoteException {
        zzbm(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzg(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzbm(3, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzh(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzd(zza, zzeVar);
        zzbm(23, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzi(int i, String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeString(str);
        zzbm(22, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzj(int i) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzk(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzd(zza, zzeVar);
        zzbm(24, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzl(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbm(21, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzm() throws RemoteException {
        zzbm(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzn() throws RemoteException {
        zzbm(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzo() throws RemoteException {
        zzbm(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzp() throws RemoteException {
        zzbm(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzq(String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbm(9, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzr(zzbkg zzbkgVar, String str) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, zzbkgVar);
        zza.writeString(str);
        zzbm(10, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzs(zzcag zzcagVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzt(zzcak zzcakVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, zzcakVar);
        zzbm(16, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzu() throws RemoteException {
        zzbm(18, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzv() throws RemoteException {
        zzbm(11, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzw() throws RemoteException {
        zzbm(15, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzx() throws RemoteException {
        zzbm(20, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzy() throws RemoteException {
        zzbm(13, zza());
    }
}

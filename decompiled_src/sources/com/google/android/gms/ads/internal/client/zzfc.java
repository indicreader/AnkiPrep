package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzcak;
import com.google.android.gms.internal.ads.zzcam;
import com.google.android.gms.internal.ads.zzcaq;
import com.google.android.gms.internal.ads.zzcau;
import com.google.android.gms.internal.ads.zzcav;
import com.google.android.gms.internal.ads.zzcbb;
import com.google.android.gms.internal.ads.zzcdv;
import com.google.android.gms.internal.ads.zzcec;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfc extends zzcam {
    private static void zzr(final zzcau zzcauVar) {
        zzcec.zzg("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzcdv.zza.post(new Runnable() { // from class: com.google.android.gms.ads.internal.client.zzfb
            @Override // java.lang.Runnable
            public final void run() {
                zzcau zzcauVar2 = zzcau.this;
                if (zzcauVar2 != null) {
                    try {
                        zzcauVar2.zze(1);
                    } catch (RemoteException e) {
                        zzcec.zzl("#007 Could not call remote method.", e);
                    }
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final Bundle zzb() throws RemoteException {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final zzdn zzc() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final zzcak zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final String zze() throws RemoteException {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzf(zzl zzlVar, zzcau zzcauVar) throws RemoteException {
        zzr(zzcauVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzg(zzl zzlVar, zzcau zzcauVar) throws RemoteException {
        zzr(zzcauVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzh(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzi(zzdd zzddVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzj(zzdg zzdgVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzk(zzcaq zzcaqVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzl(zzcbb zzcbbVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzn(IObjectWrapper iObjectWrapper, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final boolean zzo() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzp(zzcav zzcavVar) throws RemoteException {
    }
}

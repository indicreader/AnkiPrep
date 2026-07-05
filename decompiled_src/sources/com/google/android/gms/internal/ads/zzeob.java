package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public class zzeob extends zzbta {
    private final zzdav zza;
    private final zzdis zzb;
    private final zzdbp zzc;
    private final zzdce zzd;
    private final zzdcj zze;
    private final zzdfr zzf;
    private final zzddd zzg;
    private final zzdjk zzh;
    private final zzdfn zzi;
    private final zzdbk zzj;

    public zzeob(zzdav zzdavVar, zzdis zzdisVar, zzdbp zzdbpVar, zzdce zzdceVar, zzdcj zzdcjVar, zzdfr zzdfrVar, zzddd zzdddVar, zzdjk zzdjkVar, zzdfn zzdfnVar, zzdbk zzdbkVar) {
        this.zza = zzdavVar;
        this.zzb = zzdisVar;
        this.zzc = zzdbpVar;
        this.zzd = zzdceVar;
        this.zze = zzdcjVar;
        this.zzf = zzdfrVar;
        this.zzg = zzdddVar;
        this.zzh = zzdjkVar;
        this.zzi = zzdfnVar;
        this.zzj = zzdbkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zze() {
        this.zza.onAdClicked();
        this.zzb.zzs();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzf() {
        this.zzg.zzbD(4);
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzg(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzh(com.google.android.gms.ads.internal.client.zze zzeVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzi(int i, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    @Deprecated
    public final void zzj(int i) throws RemoteException {
        zzk(new com.google.android.gms.ads.internal.client.zze(i, "", AdError.UNDEFINED_DOMAIN, null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzk(com.google.android.gms.ads.internal.client.zze zzeVar) {
        this.zzj.zza(zzfij.zzc(8, zzeVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzl(String str) {
        zzk(new com.google.android.gms.ads.internal.client.zze(0, str, AdError.UNDEFINED_DOMAIN, null, null));
    }

    public void zzm() {
        this.zzc.zza();
        this.zzi.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzn() {
        this.zzd.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzo() {
        this.zze.zzr();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzp() {
        this.zzg.zzbA();
        this.zzi.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzq(String str, String str2) {
        this.zzf.zzb(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzr(zzbkg zzbkgVar, String str) {
    }

    public void zzs(zzcag zzcagVar) {
    }

    public void zzt(zzcak zzcakVar) throws RemoteException {
    }

    public void zzu() throws RemoteException {
    }

    public void zzv() {
        this.zzh.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzw() {
        this.zzh.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzx() throws RemoteException {
        this.zzh.zzc();
    }

    public void zzy() {
        this.zzh.zzd();
    }
}

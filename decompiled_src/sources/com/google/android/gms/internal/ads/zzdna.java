package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdna {
    private int zza;
    private com.google.android.gms.ads.internal.client.zzdq zzb;
    private zzbjf zzc;
    private View zzd;
    private List zze;
    private com.google.android.gms.ads.internal.client.zzel zzg;
    private Bundle zzh;
    private zzcjk zzi;
    private zzcjk zzj;
    private zzcjk zzk;
    private zzfod zzl;
    private ListenableFuture zzm;
    private zzceu zzn;
    private View zzo;
    private View zzp;
    private IObjectWrapper zzq;
    private double zzr;
    private zzbjm zzs;
    private zzbjm zzt;
    private String zzu;
    private float zzx;
    private String zzy;
    private final SimpleArrayMap zzv = new SimpleArrayMap();
    private final SimpleArrayMap zzw = new SimpleArrayMap();
    private List zzf = Collections.emptyList();

    public static zzdna zzag(zzbtg zzbtgVar) {
        try {
            zzdmz zzak = zzak(zzbtgVar.zzg(), null);
            zzbjf zzh = zzbtgVar.zzh();
            View view = (View) zzam(zzbtgVar.zzj());
            String zzo = zzbtgVar.zzo();
            List zzr = zzbtgVar.zzr();
            String zzm = zzbtgVar.zzm();
            Bundle zzf = zzbtgVar.zzf();
            String zzn = zzbtgVar.zzn();
            View view2 = (View) zzam(zzbtgVar.zzk());
            IObjectWrapper zzl = zzbtgVar.zzl();
            String zzq = zzbtgVar.zzq();
            String zzp = zzbtgVar.zzp();
            double zze = zzbtgVar.zze();
            zzbjm zzi = zzbtgVar.zzi();
            zzdna zzdnaVar = new zzdna();
            zzdnaVar.zza = 2;
            zzdnaVar.zzb = zzak;
            zzdnaVar.zzc = zzh;
            zzdnaVar.zzd = view;
            zzdnaVar.zzZ("headline", zzo);
            zzdnaVar.zze = zzr;
            zzdnaVar.zzZ("body", zzm);
            zzdnaVar.zzh = zzf;
            zzdnaVar.zzZ("call_to_action", zzn);
            zzdnaVar.zzo = view2;
            zzdnaVar.zzq = zzl;
            zzdnaVar.zzZ("store", zzq);
            zzdnaVar.zzZ("price", zzp);
            zzdnaVar.zzr = zze;
            zzdnaVar.zzs = zzi;
            return zzdnaVar;
        } catch (RemoteException e) {
            zzcec.zzk("Failed to get native ad from app install ad mapper", e);
            return null;
        }
    }

    public static zzdna zzah(zzbth zzbthVar) {
        try {
            zzdmz zzak = zzak(zzbthVar.zzf(), null);
            zzbjf zzg = zzbthVar.zzg();
            View view = (View) zzam(zzbthVar.zzi());
            String zzo = zzbthVar.zzo();
            List zzp = zzbthVar.zzp();
            String zzm = zzbthVar.zzm();
            Bundle zze = zzbthVar.zze();
            String zzn = zzbthVar.zzn();
            View view2 = (View) zzam(zzbthVar.zzj());
            IObjectWrapper zzk = zzbthVar.zzk();
            String zzl = zzbthVar.zzl();
            zzbjm zzh = zzbthVar.zzh();
            zzdna zzdnaVar = new zzdna();
            zzdnaVar.zza = 1;
            zzdnaVar.zzb = zzak;
            zzdnaVar.zzc = zzg;
            zzdnaVar.zzd = view;
            zzdnaVar.zzZ("headline", zzo);
            zzdnaVar.zze = zzp;
            zzdnaVar.zzZ("body", zzm);
            zzdnaVar.zzh = zze;
            zzdnaVar.zzZ("call_to_action", zzn);
            zzdnaVar.zzo = view2;
            zzdnaVar.zzq = zzk;
            zzdnaVar.zzZ("advertiser", zzl);
            zzdnaVar.zzt = zzh;
            return zzdnaVar;
        } catch (RemoteException e) {
            zzcec.zzk("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    public static zzdna zzai(zzbtg zzbtgVar) {
        try {
            return zzal(zzak(zzbtgVar.zzg(), null), zzbtgVar.zzh(), (View) zzam(zzbtgVar.zzj()), zzbtgVar.zzo(), zzbtgVar.zzr(), zzbtgVar.zzm(), zzbtgVar.zzf(), zzbtgVar.zzn(), (View) zzam(zzbtgVar.zzk()), zzbtgVar.zzl(), zzbtgVar.zzq(), zzbtgVar.zzp(), zzbtgVar.zze(), zzbtgVar.zzi(), null, 0.0f);
        } catch (RemoteException e) {
            zzcec.zzk("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzdna zzaj(zzbth zzbthVar) {
        try {
            return zzal(zzak(zzbthVar.zzf(), null), zzbthVar.zzg(), (View) zzam(zzbthVar.zzi()), zzbthVar.zzo(), zzbthVar.zzp(), zzbthVar.zzm(), zzbthVar.zze(), zzbthVar.zzn(), (View) zzam(zzbthVar.zzj()), zzbthVar.zzk(), null, null, -1.0d, zzbthVar.zzh(), zzbthVar.zzl(), 0.0f);
        } catch (RemoteException e) {
            zzcec.zzk("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    private static zzdmz zzak(com.google.android.gms.ads.internal.client.zzdq zzdqVar, zzbtk zzbtkVar) {
        if (zzdqVar == null) {
            return null;
        }
        return new zzdmz(zzdqVar, zzbtkVar);
    }

    private static zzdna zzal(com.google.android.gms.ads.internal.client.zzdq zzdqVar, zzbjf zzbjfVar, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzbjm zzbjmVar, String str6, float f) {
        zzdna zzdnaVar = new zzdna();
        zzdnaVar.zza = 6;
        zzdnaVar.zzb = zzdqVar;
        zzdnaVar.zzc = zzbjfVar;
        zzdnaVar.zzd = view;
        zzdnaVar.zzZ("headline", str);
        zzdnaVar.zze = list;
        zzdnaVar.zzZ("body", str2);
        zzdnaVar.zzh = bundle;
        zzdnaVar.zzZ("call_to_action", str3);
        zzdnaVar.zzo = view2;
        zzdnaVar.zzq = iObjectWrapper;
        zzdnaVar.zzZ("store", str4);
        zzdnaVar.zzZ("price", str5);
        zzdnaVar.zzr = d;
        zzdnaVar.zzs = zzbjmVar;
        zzdnaVar.zzZ("advertiser", str6);
        zzdnaVar.zzR(f);
        return zzdnaVar;
    }

    private static Object zzam(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    public static zzdna zzt(zzbtk zzbtkVar) {
        try {
            return zzal(zzak(zzbtkVar.zzj(), zzbtkVar), zzbtkVar.zzk(), (View) zzam(zzbtkVar.zzm()), zzbtkVar.zzs(), zzbtkVar.zzv(), zzbtkVar.zzq(), zzbtkVar.zzi(), zzbtkVar.zzr(), (View) zzam(zzbtkVar.zzn()), zzbtkVar.zzo(), zzbtkVar.zzu(), zzbtkVar.zzt(), zzbtkVar.zze(), zzbtkVar.zzl(), zzbtkVar.zzp(), zzbtkVar.zzf());
        } catch (RemoteException e) {
            zzcec.zzk("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    public final synchronized String zzA() {
        return this.zzu;
    }

    public final synchronized String zzB() {
        return zzF("headline");
    }

    public final synchronized String zzC() {
        return this.zzy;
    }

    public final synchronized String zzD() {
        return zzF("price");
    }

    public final synchronized String zzE() {
        return zzF("store");
    }

    public final synchronized String zzF(String str) {
        return (String) this.zzw.get(str);
    }

    public final synchronized List zzG() {
        return this.zze;
    }

    public final synchronized List zzH() {
        return this.zzf;
    }

    public final synchronized void zzI() {
        zzcjk zzcjkVar = this.zzi;
        if (zzcjkVar != null) {
            zzcjkVar.destroy();
            this.zzi = null;
        }
        zzcjk zzcjkVar2 = this.zzj;
        if (zzcjkVar2 != null) {
            zzcjkVar2.destroy();
            this.zzj = null;
        }
        zzcjk zzcjkVar3 = this.zzk;
        if (zzcjkVar3 != null) {
            zzcjkVar3.destroy();
            this.zzk = null;
        }
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture != null) {
            listenableFuture.cancel(false);
            this.zzm = null;
        }
        zzceu zzceuVar = this.zzn;
        if (zzceuVar != null) {
            zzceuVar.cancel(false);
            this.zzn = null;
        }
        this.zzl = null;
        this.zzv.clear();
        this.zzw.clear();
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        this.zzh = null;
        this.zzo = null;
        this.zzp = null;
        this.zzq = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
    }

    public final synchronized void zzJ(zzbjf zzbjfVar) {
        this.zzc = zzbjfVar;
    }

    public final synchronized void zzK(String str) {
        this.zzu = str;
    }

    public final synchronized void zzL(com.google.android.gms.ads.internal.client.zzel zzelVar) {
        this.zzg = zzelVar;
    }

    public final synchronized void zzM(zzbjm zzbjmVar) {
        this.zzs = zzbjmVar;
    }

    public final synchronized void zzN(String str, zzbiz zzbizVar) {
        if (zzbizVar == null) {
            this.zzv.remove(str);
        } else {
            this.zzv.put(str, zzbizVar);
        }
    }

    public final synchronized void zzO(zzcjk zzcjkVar) {
        this.zzj = zzcjkVar;
    }

    public final synchronized void zzP(List list) {
        this.zze = list;
    }

    public final synchronized void zzQ(zzbjm zzbjmVar) {
        this.zzt = zzbjmVar;
    }

    public final synchronized void zzR(float f) {
        this.zzx = f;
    }

    public final synchronized void zzS(List list) {
        this.zzf = list;
    }

    public final synchronized void zzT(zzcjk zzcjkVar) {
        this.zzk = zzcjkVar;
    }

    public final synchronized void zzU(ListenableFuture listenableFuture) {
        this.zzm = listenableFuture;
    }

    public final synchronized void zzV(String str) {
        this.zzy = str;
    }

    public final synchronized void zzW(zzfod zzfodVar) {
        this.zzl = zzfodVar;
    }

    public final synchronized void zzX(zzceu zzceuVar) {
        this.zzn = zzceuVar;
    }

    public final synchronized void zzY(double d) {
        this.zzr = d;
    }

    public final synchronized void zzZ(String str, String str2) {
        if (str2 == null) {
            this.zzw.remove(str);
        } else {
            this.zzw.put(str, str2);
        }
    }

    public final synchronized double zza() {
        return this.zzr;
    }

    public final synchronized void zzaa(int i) {
        this.zza = i;
    }

    public final synchronized void zzab(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        this.zzb = zzdqVar;
    }

    public final synchronized void zzac(View view) {
        this.zzo = view;
    }

    public final synchronized void zzad(zzcjk zzcjkVar) {
        this.zzi = zzcjkVar;
    }

    public final synchronized void zzae(View view) {
        this.zzp = view;
    }

    public final synchronized boolean zzaf() {
        return this.zzj != null;
    }

    public final synchronized float zzb() {
        return this.zzx;
    }

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized Bundle zzd() {
        if (this.zzh == null) {
            this.zzh = new Bundle();
        }
        return this.zzh;
    }

    public final synchronized View zze() {
        return this.zzd;
    }

    public final synchronized View zzf() {
        return this.zzo;
    }

    public final synchronized View zzg() {
        return this.zzp;
    }

    public final synchronized SimpleArrayMap zzh() {
        return this.zzv;
    }

    public final synchronized SimpleArrayMap zzi() {
        return this.zzw;
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzdq zzj() {
        return this.zzb;
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzel zzk() {
        return this.zzg;
    }

    public final synchronized zzbjf zzl() {
        return this.zzc;
    }

    public final zzbjm zzm() {
        List list = this.zze;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Object obj = this.zze.get(0);
        if (obj instanceof IBinder) {
            return zzbjl.zzg((IBinder) obj);
        }
        return null;
    }

    public final synchronized zzbjm zzn() {
        return this.zzs;
    }

    public final synchronized zzbjm zzo() {
        return this.zzt;
    }

    public final synchronized zzceu zzp() {
        return this.zzn;
    }

    public final synchronized zzcjk zzq() {
        return this.zzj;
    }

    public final synchronized zzcjk zzr() {
        return this.zzk;
    }

    public final synchronized zzcjk zzs() {
        return this.zzi;
    }

    public final synchronized zzfod zzu() {
        return this.zzl;
    }

    public final synchronized IObjectWrapper zzv() {
        return this.zzq;
    }

    public final synchronized ListenableFuture zzw() {
        return this.zzm;
    }

    public final synchronized String zzx() {
        return zzF("advertiser");
    }

    public final synchronized String zzy() {
        return zzF("body");
    }

    public final synchronized String zzz() {
        return zzF("call_to_action");
    }
}

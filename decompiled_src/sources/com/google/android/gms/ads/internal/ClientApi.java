package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbq;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzcd;
import com.google.android.gms.ads.internal.client.zzco;
import com.google.android.gms.ads.internal.client.zzdj;
import com.google.android.gms.ads.internal.client.zzew;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzad;
import com.google.android.gms.ads.internal.overlay.zzaf;
import com.google.android.gms.ads.internal.overlay.zzag;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbjq;
import com.google.android.gms.internal.ads.zzbjw;
import com.google.android.gms.internal.ads.zzboe;
import com.google.android.gms.internal.ads.zzboh;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzbwm;
import com.google.android.gms.internal.ads.zzbwt;
import com.google.android.gms.internal.ads.zzbzx;
import com.google.android.gms.internal.ads.zzcan;
import com.google.android.gms.internal.ads.zzcct;
import com.google.android.gms.internal.ads.zzcei;
import com.google.android.gms.internal.ads.zzclg;
import com.google.android.gms.internal.ads.zzdnu;
import com.google.android.gms.internal.ads.zzdnw;
import com.google.android.gms.internal.ads.zzdxo;
import com.google.android.gms.internal.ads.zzeph;
import com.google.android.gms.internal.ads.zzfbm;
import com.google.android.gms.internal.ads.zzfbn;
import com.google.android.gms.internal.ads.zzfda;
import com.google.android.gms.internal.ads.zzfer;
import com.google.android.gms.internal.ads.zzfgf;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public class ClientApi extends zzcd {
    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbq zzb(IObjectWrapper iObjectWrapper, String str, zzbsv zzbsvVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzeph(zzclg.zzb(context, zzbsvVar, i), context, str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zzc(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, String str, zzbsv zzbsvVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfbm zzs = zzclg.zzb(context, zzbsvVar, i).zzs();
        zzs.zza(str);
        zzs.zzb(context);
        zzfbn zzc = zzs.zzc();
        if (i >= ((Integer) zzba.zzc().zza(zzbgc.zzfh)).intValue()) {
            return zzc.zza();
        }
        return new zzew();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zzd(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, String str, zzbsv zzbsvVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfda zzt = zzclg.zzb(context, zzbsvVar, i).zzt();
        zzt.zzc(context);
        zzt.zza(zzqVar);
        zzt.zzb(str);
        return zzt.zzd().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zze(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, String str, zzbsv zzbsvVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfer zzu = zzclg.zzb(context, zzbsvVar, i).zzu();
        zzu.zzc(context);
        zzu.zza(zzqVar);
        zzu.zzb(str);
        return zzu.zzd().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zzf(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, String str, int i) {
        return new zzs((Context) ObjectWrapper.unwrap(iObjectWrapper), zzqVar, str, new zzcei(240304000, i, true, false));
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzco zzg(IObjectWrapper iObjectWrapper, int i) {
        return zzclg.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), null, i).zzc();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzdj zzh(IObjectWrapper iObjectWrapper, zzbsv zzbsvVar, int i) {
        return zzclg.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbsvVar, i).zzl();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbjq zzi(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzdnw((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), 240304000);
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbjw zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzdnu((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzboh zzk(IObjectWrapper iObjectWrapper, zzbsv zzbsvVar, int i, zzboe zzboeVar) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdxo zzj = zzclg.zzb(context, zzbsvVar, i).zzj();
        zzj.zzb(context);
        zzj.zza(zzboeVar);
        return zzj.zzc().zzd();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbwm zzl(IObjectWrapper iObjectWrapper, zzbsv zzbsvVar, int i) {
        return zzclg.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbsvVar, i).zzm();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbwt zzm(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel zza = AdOverlayInfoParcel.zza(activity.getIntent());
        if (zza == null) {
            return new zzu(activity);
        }
        int i = zza.zzk;
        if (i == 1) {
            return new com.google.android.gms.ads.internal.overlay.zzt(activity);
        }
        if (i == 2) {
            return new zzaf(activity);
        }
        if (i == 3) {
            return new zzag(activity);
        }
        if (i == 4) {
            return new zzz(activity, zza);
        }
        if (i == 5) {
            return new zzad(activity);
        }
        return new zzu(activity);
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbzx zzn(IObjectWrapper iObjectWrapper, zzbsv zzbsvVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfgf zzv = zzclg.zzb(context, zzbsvVar, i).zzv();
        zzv.zzb(context);
        return zzv.zzc().zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzcan zzo(IObjectWrapper iObjectWrapper, String str, zzbsv zzbsvVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfgf zzv = zzclg.zzb(context, zzbsvVar, i).zzv();
        zzv.zzb(context);
        zzv.zza(str);
        return zzv.zzc().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzcct zzp(IObjectWrapper iObjectWrapper, zzbsv zzbsvVar, int i) {
        return zzclg.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbsvVar, i).zzp();
    }
}

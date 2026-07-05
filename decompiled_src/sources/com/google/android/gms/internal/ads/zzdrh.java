package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdrh extends zzbkf {
    private final Context zza;
    private final zzdna zzb;
    private zzdoa zzc;
    private zzdmv zzd;

    public zzdrh(Context context, zzdna zzdnaVar, zzdoa zzdoaVar, zzdmv zzdmvVar) {
        this.zza = context;
        this.zzb = zzdnaVar;
        this.zzc = zzdoaVar;
        this.zzd = zzdmvVar;
    }

    private final zzbja zzd(String str) {
        return new zzdrg(this, NativeCustomFormatAd.ASSET_NAME_VIDEO);
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final com.google.android.gms.ads.internal.client.zzdq zze() {
        return this.zzb.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final zzbjj zzf() throws RemoteException {
        try {
            return this.zzd.zzc().zza();
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "InternalNativeCustomTemplateAdShim.getMediaContent");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final zzbjm zzg(String str) {
        return (zzbjm) this.zzb.zzh().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final IObjectWrapper zzh() {
        return ObjectWrapper.wrap(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final String zzi() {
        return this.zzb.zzA();
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final String zzj(String str) {
        return (String) this.zzb.zzi().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final List zzk() {
        try {
            SimpleArrayMap zzh = this.zzb.zzh();
            SimpleArrayMap zzi = this.zzb.zzi();
            String[] strArr = new String[zzh.getSize() + zzi.getSize()];
            int i = 0;
            for (int i2 = 0; i2 < zzh.getSize(); i2++) {
                strArr[i] = (String) zzh.keyAt(i2);
                i++;
            }
            for (int i3 = 0; i3 < zzi.getSize(); i3++) {
                strArr[i] = (String) zzi.keyAt(i3);
                i++;
            }
            return Arrays.asList(strArr);
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "InternalNativeCustomTemplateAdShim.getAvailableAssetNames");
            return new ArrayList();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final void zzl() {
        zzdmv zzdmvVar = this.zzd;
        if (zzdmvVar != null) {
            zzdmvVar.zzb();
        }
        this.zzd = null;
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final void zzm() {
        try {
            String zzC = this.zzb.zzC();
            if (Objects.equals(zzC, "Google")) {
                zzcec.zzj("Illegal argument specified for omid partner name.");
                return;
            }
            if (TextUtils.isEmpty(zzC)) {
                zzcec.zzj("Not starting OMID session. OM partner name has not been configured.");
                return;
            }
            zzdmv zzdmvVar = this.zzd;
            if (zzdmvVar != null) {
                zzdmvVar.zzf(zzC, false);
            }
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "InternalNativeCustomTemplateAdShim.initializeDisplayOpenMeasurement");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final void zzn(String str) {
        zzdmv zzdmvVar = this.zzd;
        if (zzdmvVar != null) {
            zzdmvVar.zzE(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final void zzo() {
        zzdmv zzdmvVar = this.zzd;
        if (zzdmvVar != null) {
            zzdmvVar.zzH();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final void zzp(IObjectWrapper iObjectWrapper) {
        zzdmv zzdmvVar;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof View) || this.zzb.zzu() == null || (zzdmvVar = this.zzd) == null) {
            return;
        }
        zzdmvVar.zzI((View) unwrap);
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final boolean zzq() {
        zzdmv zzdmvVar = this.zzd;
        return (zzdmvVar == null || zzdmvVar.zzV()) && this.zzb.zzr() != null && this.zzb.zzs() == null;
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final boolean zzr(IObjectWrapper iObjectWrapper) {
        zzdoa zzdoaVar;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup) || (zzdoaVar = this.zzc) == null || !zzdoaVar.zzf((ViewGroup) unwrap)) {
            return false;
        }
        this.zzb.zzq().zzap(zzd(NativeCustomFormatAd.ASSET_NAME_VIDEO));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final boolean zzs(IObjectWrapper iObjectWrapper) {
        zzdoa zzdoaVar;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup) || (zzdoaVar = this.zzc) == null || !zzdoaVar.zzg((ViewGroup) unwrap)) {
            return false;
        }
        this.zzb.zzs().zzap(zzd(NativeCustomFormatAd.ASSET_NAME_VIDEO));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final boolean zzt() {
        zzfod zzu = this.zzb.zzu();
        if (zzu != null) {
            com.google.android.gms.ads.internal.zzt.zzA().zzi(zzu);
            if (this.zzb.zzr() == null) {
                return true;
            }
            this.zzb.zzr().zzd("onSdkLoaded", new ArrayMap());
            return true;
        }
        zzcec.zzj("Trying to start OMID session before creation.");
        return false;
    }
}

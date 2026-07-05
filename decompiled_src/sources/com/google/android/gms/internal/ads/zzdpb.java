package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes3.dex */
public final class zzdpb implements zzdni {
    private final zzbtk zza;
    private final zzdbp zzb;
    private final zzdav zzc;
    private final zzdis zzd;
    private final Context zze;
    private final zzfgm zzf;
    private final zzcei zzg;
    private final zzfhh zzh;
    private boolean zzi = false;
    private boolean zzj = false;
    private boolean zzk = true;
    private final zzbtg zzl;
    private final zzbth zzm;

    public zzdpb(zzbtg zzbtgVar, zzbth zzbthVar, zzbtk zzbtkVar, zzdbp zzdbpVar, zzdav zzdavVar, zzdis zzdisVar, Context context, zzfgm zzfgmVar, zzcei zzceiVar, zzfhh zzfhhVar) {
        this.zzl = zzbtgVar;
        this.zzm = zzbthVar;
        this.zza = zzbtkVar;
        this.zzb = zzdbpVar;
        this.zzc = zzdavVar;
        this.zzd = zzdisVar;
        this.zze = context;
        this.zzf = zzfgmVar;
        this.zzg = zzceiVar;
        this.zzh = zzfhhVar;
    }

    private final void zzb(View view) {
        try {
            zzbtk zzbtkVar = this.zza;
            if (zzbtkVar == null || zzbtkVar.zzA()) {
                zzbtg zzbtgVar = this.zzl;
                if (zzbtgVar == null || zzbtgVar.zzx()) {
                    zzbth zzbthVar = this.zzm;
                    if (zzbthVar == null || zzbthVar.zzv()) {
                        return;
                    }
                    this.zzm.zzq(ObjectWrapper.wrap(view));
                    this.zzc.onAdClicked();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkm)).booleanValue()) {
                        this.zzd.zzs();
                        return;
                    }
                    return;
                }
                this.zzl.zzs(ObjectWrapper.wrap(view));
                this.zzc.onAdClicked();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkm)).booleanValue()) {
                    this.zzd.zzs();
                    return;
                }
                return;
            }
            this.zza.zzw(ObjectWrapper.wrap(view));
            this.zzc.onAdClicked();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkm)).booleanValue()) {
                this.zzd.zzs();
            }
        } catch (RemoteException e) {
            zzcec.zzk("Failed to call handleClick", e);
        }
    }

    private static final HashMap zzc(Map map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            synchronized (map) {
                for (Map.Entry entry : map.entrySet()) {
                    View view = (View) ((WeakReference) entry.getValue()).get();
                    if (view != null) {
                        hashMap.put((String) entry.getKey(), view);
                    }
                }
            }
        }
        return hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final boolean zzA() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final boolean zzB() {
        return this.zzf.zzM;
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final boolean zzC(Bundle bundle) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final JSONObject zze(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final JSONObject zzf(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzg() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzh() {
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzi() {
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzj(com.google.android.gms.ads.internal.client.zzcw zzcwVar) {
        zzcec.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzk(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType) {
        if (this.zzj && this.zzf.zzM) {
            return;
        }
        zzb(view);
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzl(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzm(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzo(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType, int i) {
        if (!this.zzj) {
            zzcec.zzj("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (!this.zzf.zzM) {
            zzcec.zzj("Custom click reporting for 3p ads failed. Ad unit id not in allow list.");
        } else {
            zzb(view2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzp() {
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzq(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        try {
            if (!this.zzi) {
                this.zzi = com.google.android.gms.ads.internal.zzt.zzs().zzn(this.zze, this.zzg.zza, this.zzf.zzD.toString(), this.zzh.zzf);
            }
            if (this.zzk) {
                zzbtk zzbtkVar = this.zza;
                if (zzbtkVar == null || zzbtkVar.zzB()) {
                    zzbtg zzbtgVar = this.zzl;
                    if (zzbtgVar == null || zzbtgVar.zzy()) {
                        zzbth zzbthVar = this.zzm;
                        if (zzbthVar == null || zzbthVar.zzw()) {
                            return;
                        }
                        this.zzm.zzr();
                        this.zzb.zza();
                        return;
                    }
                    this.zzl.zzt();
                    this.zzb.zza();
                    return;
                }
                this.zza.zzx();
                this.zzb.zza();
            }
        } catch (RemoteException e) {
            zzcec.zzk("Failed to call recordImpression", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzr() {
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzs(View view, MotionEvent motionEvent, View view2) {
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzt(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzu(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzv() {
        this.zzj = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzw(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
        zzcec.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzx(zzblg zzblgVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzy(View view, Map map, Map map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        Object obj;
        IObjectWrapper zzn;
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            JSONObject jSONObject = this.zzf.zzak;
            boolean z = true;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbx)).booleanValue() && jSONObject.length() != 0) {
                Map hashMap = map == null ? new HashMap() : map;
                Map hashMap2 = map2 == null ? new HashMap() : map2;
                HashMap hashMap3 = new HashMap();
                hashMap3.putAll(hashMap);
                hashMap3.putAll(hashMap2);
                Iterator<String> keys = jSONObject.keys();
                loop0: while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray optJSONArray = jSONObject.optJSONArray(next);
                    if (optJSONArray != null) {
                        WeakReference weakReference = (WeakReference) hashMap3.get(next);
                        if (weakReference != null && (obj = weakReference.get()) != null) {
                            Class<?> cls = obj.getClass();
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzby)).booleanValue() && next.equals("3010")) {
                                zzbtk zzbtkVar = this.zza;
                                Object obj2 = null;
                                if (zzbtkVar != null) {
                                    try {
                                        zzn = zzbtkVar.zzn();
                                    } catch (RemoteException | IllegalArgumentException unused) {
                                    }
                                } else {
                                    zzbtg zzbtgVar = this.zzl;
                                    if (zzbtgVar != null) {
                                        zzn = zzbtgVar.zzk();
                                    } else {
                                        zzbth zzbthVar = this.zzm;
                                        zzn = zzbthVar != null ? zzbthVar.zzj() : null;
                                    }
                                }
                                if (zzn != null) {
                                    obj2 = ObjectWrapper.unwrap(zzn);
                                }
                                if (obj2 != null) {
                                    cls = obj2.getClass();
                                }
                            }
                            try {
                                ArrayList arrayList = new ArrayList();
                                com.google.android.gms.ads.internal.util.zzbw.zzc(optJSONArray, arrayList);
                                com.google.android.gms.ads.internal.zzt.zzp();
                                ClassLoader classLoader = this.zze.getClassLoader();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    if (Class.forName((String) it.next(), false, classLoader).isAssignableFrom(cls)) {
                                        break;
                                    }
                                }
                            } catch (JSONException unused2) {
                                continue;
                            }
                        }
                        z = false;
                        break;
                    }
                }
            }
            this.zzk = z;
            HashMap zzc = zzc(map);
            HashMap zzc2 = zzc(map2);
            zzbtk zzbtkVar2 = this.zza;
            if (zzbtkVar2 != null) {
                zzbtkVar2.zzy(wrap, ObjectWrapper.wrap(zzc), ObjectWrapper.wrap(zzc2));
                return;
            }
            zzbtg zzbtgVar2 = this.zzl;
            if (zzbtgVar2 != null) {
                zzbtgVar2.zzv(wrap, ObjectWrapper.wrap(zzc), ObjectWrapper.wrap(zzc2));
                this.zzl.zzu(wrap);
                return;
            }
            zzbth zzbthVar2 = this.zzm;
            if (zzbthVar2 != null) {
                zzbthVar2.zzt(wrap, ObjectWrapper.wrap(zzc), ObjectWrapper.wrap(zzc2));
                this.zzm.zzs(wrap);
            }
        } catch (RemoteException e) {
            zzcec.zzk("Failed to call trackView", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzz(View view, Map map) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            zzbtk zzbtkVar = this.zza;
            if (zzbtkVar != null) {
                zzbtkVar.zzz(wrap);
                return;
            }
            zzbtg zzbtgVar = this.zzl;
            if (zzbtgVar != null) {
                zzbtgVar.zzw(wrap);
                return;
            }
            zzbth zzbthVar = this.zzm;
            if (zzbthVar != null) {
                zzbthVar.zzu(wrap);
            }
        } catch (RemoteException e) {
            zzcec.zzk("Failed to call untrackView", e);
        }
    }
}

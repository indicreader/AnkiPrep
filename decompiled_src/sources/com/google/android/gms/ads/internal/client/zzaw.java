package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.internal.ads.zzbjq;
import com.google.android.gms.internal.ads.zzbjw;
import com.google.android.gms.internal.ads.zzbll;
import com.google.android.gms.internal.ads.zzblm;
import com.google.android.gms.internal.ads.zzboh;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzbwm;
import com.google.android.gms.internal.ads.zzbwq;
import com.google.android.gms.internal.ads.zzbwt;
import com.google.android.gms.internal.ads.zzbxy;
import com.google.android.gms.internal.ads.zzcan;
import com.google.android.gms.internal.ads.zzcaz;
import com.google.android.gms.internal.ads.zzcct;
import com.google.android.gms.internal.ads.zzcec;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzaw {
    private final zzk zza;
    private final zzi zzb;
    private final zzeq zzc;
    private final zzbll zzd;
    private final zzcaz zze;
    private final zzbwq zzf;
    private final zzblm zzg;
    private zzbxy zzh;

    public zzaw(zzk zzkVar, zzi zziVar, zzeq zzeqVar, zzbll zzbllVar, zzcaz zzcazVar, zzbwq zzbwqVar, zzblm zzblmVar) {
        this.zza = zzkVar;
        this.zzb = zziVar;
        this.zzc = zzeqVar;
        this.zzd = zzbllVar;
        this.zze = zzcazVar;
        this.zzf = zzbwqVar;
        this.zzg = zzblmVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzt(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzay.zzb().zzn(context, zzay.zzc().zza, "gmob-apps", bundle, true);
    }

    public final zzbq zzc(Context context, String str, zzbsv zzbsvVar) {
        return (zzbq) new zzao(this, context, str, zzbsvVar).zzd(context, false);
    }

    public final zzbu zzd(Context context, zzq zzqVar, String str, zzbsv zzbsvVar) {
        return (zzbu) new zzak(this, context, zzqVar, str, zzbsvVar).zzd(context, false);
    }

    public final zzbu zze(Context context, zzq zzqVar, String str, zzbsv zzbsvVar) {
        return (zzbu) new zzam(this, context, zzqVar, str, zzbsvVar).zzd(context, false);
    }

    public final zzdj zzf(Context context, zzbsv zzbsvVar) {
        return (zzdj) new zzac(this, context, zzbsvVar).zzd(context, false);
    }

    public final zzbjq zzh(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzbjq) new zzas(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzbjw zzi(View view, HashMap hashMap, HashMap hashMap2) {
        return (zzbjw) new zzau(this, view, hashMap, hashMap2).zzd(view.getContext(), false);
    }

    public final zzboh zzl(Context context, zzbsv zzbsvVar, OnH5AdsEventListener onH5AdsEventListener) {
        return (zzboh) new zzai(this, context, zzbsvVar, onH5AdsEventListener).zzd(context, false);
    }

    public final zzbwm zzm(Context context, zzbsv zzbsvVar) {
        return (zzbwm) new zzag(this, context, zzbsvVar).zzd(context, false);
    }

    public final zzbwt zzo(Activity activity) {
        zzaa zzaaVar = new zzaa(this, activity);
        Intent intent = activity.getIntent();
        boolean z = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzcec.zzg("useClientJar flag not found in activity intent extras.");
        } else {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return (zzbwt) zzaaVar.zzd(activity, z);
    }

    public final zzcan zzq(Context context, String str, zzbsv zzbsvVar) {
        return (zzcan) new zzav(this, context, str, zzbsvVar).zzd(context, false);
    }

    public final zzcct zzr(Context context, zzbsv zzbsvVar) {
        return (zzcct) new zzae(this, context, zzbsvVar).zzd(context, false);
    }
}

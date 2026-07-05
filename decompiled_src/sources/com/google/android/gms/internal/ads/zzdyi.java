package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdyi {
    private final Context zzf;
    private final WeakReference zzg;
    private final zzdua zzh;
    private final Executor zzi;
    private final Executor zzj;
    private final ScheduledExecutorService zzk;
    private final zzdwp zzl;
    private final zzcei zzm;
    private final zzdht zzo;
    private final zzfnc zzp;
    private boolean zza = false;
    private boolean zzb = false;
    private boolean zzc = false;
    private final zzceu zze = new zzceu();
    private final Map zzn = new ConcurrentHashMap();
    private boolean zzq = true;
    private final long zzd = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();

    public zzdyi(Executor executor, Context context, WeakReference weakReference, Executor executor2, zzdua zzduaVar, ScheduledExecutorService scheduledExecutorService, zzdwp zzdwpVar, zzcei zzceiVar, zzdht zzdhtVar, zzfnc zzfncVar) {
        this.zzh = zzduaVar;
        this.zzf = context;
        this.zzg = weakReference;
        this.zzi = executor2;
        this.zzk = scheduledExecutorService;
        this.zzj = executor;
        this.zzl = zzdwpVar;
        this.zzm = zzceiVar;
        this.zzo = zzdhtVar;
        this.zzp = zzfncVar;
        zzv("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzj(final zzdyi zzdyiVar, String str) {
        int i = 5;
        final zzfmo zza = zzfmn.zza(zzdyiVar.zzf, 5);
        zza.zzh();
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                final String next = keys.next();
                final zzfmo zza2 = zzfmn.zza(zzdyiVar.zzf, i);
                zza2.zzh();
                zza2.zzd(next);
                final Object obj = new Object();
                final zzceu zzceuVar = new zzceu();
                ListenableFuture zzo = zzgen.zzo(zzceuVar, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbO)).longValue(), TimeUnit.SECONDS, zzdyiVar.zzk);
                zzdyiVar.zzl.zzc(next);
                zzdyiVar.zzo.zzc(next);
                final long elapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
                zzo.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxz
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdyi.this.zzq(obj, zzceuVar, next, elapsedRealtime, zza2);
                    }
                }, zzdyiVar.zzi);
                arrayList.add(zzo);
                final zzdyh zzdyhVar = new zzdyh(zzdyiVar, obj, next, elapsedRealtime, zza2, zzceuVar);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                final ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray("data");
                        int i2 = 0;
                        while (i2 < jSONArray.length()) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                            String optString = jSONObject2.optString("format", "");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                    jSONArray = jSONArray;
                                }
                            }
                            JSONArray jSONArray2 = jSONArray;
                            arrayList2.add(new zzbpn(optString, bundle));
                            i2++;
                            jSONArray = jSONArray2;
                        }
                    } catch (JSONException unused) {
                    }
                }
                zzdyiVar.zzv(next, false, "", 0);
                try {
                    try {
                        final zzfif zzc = zzdyiVar.zzh.zzc(next, new JSONObject());
                        zzdyiVar.zzj.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdyd
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzdyi.this.zzn(next, zzdyhVar, zzc, arrayList2);
                            }
                        });
                    } catch (zzfho unused2) {
                        zzdyhVar.zze("Failed to create Adapter.");
                    }
                } catch (RemoteException e) {
                    zzcec.zzh("", e);
                }
                i = 5;
            }
            zzgen.zza(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdya
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzdyi.this.zzf(zza);
                    return null;
                }
            }, zzdyiVar.zzi);
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zze.zzb("Malformed CLD response", e2);
            zzdyiVar.zzo.zza("MalformedJson");
            zzdyiVar.zzl.zza("MalformedJson");
            zzdyiVar.zze.zzd(e2);
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e2, "AdapterInitializer.updateAdapterStatus");
            zzfnc zzfncVar = zzdyiVar.zzp;
            zza.zzg(e2);
            zza.zzf(false);
            zzfncVar.zzb(zza.zzl());
        }
    }

    private final synchronized ListenableFuture zzu() {
        String zzc = com.google.android.gms.ads.internal.zzt.zzo().zzi().zzh().zzc();
        if (!TextUtils.isEmpty(zzc)) {
            return zzgen.zzh(zzc);
        }
        final zzceu zzceuVar = new zzceu();
        com.google.android.gms.ads.internal.zzt.zzo().zzi().zzq(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdyb
            @Override // java.lang.Runnable
            public final void run() {
                zzdyi.this.zzo(zzceuVar);
            }
        });
        return zzceuVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzv(String str, boolean z, String str2, int i) {
        this.zzn.put(str, new zzbpd(str, z, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object zzf(zzfmo zzfmoVar) throws Exception {
        this.zze.zzc(true);
        zzfmoVar.zzf(true);
        this.zzp.zzb(zzfmoVar.zzl());
        return null;
    }

    public final List zzg() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzn.keySet()) {
            zzbpd zzbpdVar = (zzbpd) this.zzn.get(str);
            arrayList.add(new zzbpd(str, zzbpdVar.zzb, zzbpdVar.zzc, zzbpdVar.zzd));
        }
        return arrayList;
    }

    public final void zzl() {
        this.zzq = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzm() {
        synchronized (this) {
            if (this.zzc) {
                return;
            }
            zzv("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zzd));
            this.zzl.zzb("com.google.android.gms.ads.MobileAds", "timeout");
            this.zzo.zzb("com.google.android.gms.ads.MobileAds", "timeout");
            this.zze.zzd(new Exception());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(String str, zzbph zzbphVar, zzfif zzfifVar, List list) {
        try {
            try {
                if (Objects.equals(str, "com.google.ads.mediation.admob.AdMobAdapter")) {
                    zzbphVar.zzf();
                    return;
                }
                Context context = (Context) this.zzg.get();
                if (context == null) {
                    context = this.zzf;
                }
                zzfifVar.zzi(context, zzbphVar, list);
            } catch (RemoteException e) {
                zzcec.zzh("", e);
            }
        } catch (RemoteException e2) {
            throw new zzfxz(e2);
        } catch (zzfho unused) {
            zzbphVar.zze("Failed to initialize adapter. " + str + " does not implement the initialize() method.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(final zzceu zzceuVar) {
        this.zzi.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxy
            @Override // java.lang.Runnable
            public final void run() {
                String zzc = com.google.android.gms.ads.internal.zzt.zzo().zzi().zzh().zzc();
                boolean isEmpty = TextUtils.isEmpty(zzc);
                zzceu zzceuVar2 = zzceuVar;
                if (!isEmpty) {
                    zzceuVar2.zzc(zzc);
                } else {
                    zzceuVar2.zzd(new Exception());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzp() {
        this.zzl.zze();
        this.zzo.zze();
        this.zzb = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(Object obj, zzceu zzceuVar, String str, long j, zzfmo zzfmoVar) {
        synchronized (obj) {
            if (!zzceuVar.isDone()) {
                zzv(str, false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - j));
                this.zzl.zzb(str, "timeout");
                this.zzo.zzb(str, "timeout");
                zzfnc zzfncVar = this.zzp;
                zzfmoVar.zzc("Timeout");
                zzfmoVar.zzf(false);
                zzfncVar.zzb(zzfmoVar.zzl());
                zzceuVar.zzc(false);
            }
        }
    }

    public final void zzr() {
        if (!((Boolean) zzbig.zza.zze()).booleanValue()) {
            if (this.zzm.zzc >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbN)).intValue() && this.zzq) {
                if (this.zza) {
                    return;
                }
                synchronized (this) {
                    if (this.zza) {
                        return;
                    }
                    this.zzl.zzf();
                    this.zzo.zzf();
                    this.zze.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdye
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzdyi.this.zzp();
                        }
                    }, this.zzi);
                    this.zza = true;
                    ListenableFuture zzu = zzu();
                    this.zzk.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxx
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzdyi.this.zzm();
                        }
                    }, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbP)).longValue(), TimeUnit.SECONDS);
                    zzgen.zzr(zzu, new zzdyg(this), this.zzi);
                    return;
                }
            }
        }
        if (this.zza) {
            return;
        }
        zzv("com.google.android.gms.ads.MobileAds", true, "", 0);
        this.zze.zzc(false);
        this.zza = true;
        this.zzb = true;
    }

    public final void zzs(final zzbpk zzbpkVar) {
        this.zze.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdyc
            @Override // java.lang.Runnable
            public final void run() {
                zzdyi zzdyiVar = zzdyi.this;
                try {
                    zzbpkVar.zzb(zzdyiVar.zzg());
                } catch (RemoteException e) {
                    zzcec.zzh("", e);
                }
            }
        }, this.zzj);
    }

    public final boolean zzt() {
        return this.zzb;
    }
}

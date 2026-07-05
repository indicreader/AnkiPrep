package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzbz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzavi;
import com.google.android.gms.internal.ads.zzavj;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbhh;
import com.google.android.gms.internal.ads.zzbht;
import com.google.android.gms.internal.ads.zzbxi;
import com.google.android.gms.internal.ads.zzbxr;
import com.google.android.gms.internal.ads.zzccq;
import com.google.android.gms.internal.ads.zzccs;
import com.google.android.gms.internal.ads.zzccx;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzcei;
import com.google.android.gms.internal.ads.zzcep;
import com.google.android.gms.internal.ads.zzclg;
import com.google.android.gms.internal.ads.zzdaf;
import com.google.android.gms.internal.ads.zzdgm;
import com.google.android.gms.internal.ads.zzdrz;
import com.google.android.gms.internal.ads.zzdwa;
import com.google.android.gms.internal.ads.zzdwk;
import com.google.android.gms.internal.ads.zzfhf;
import com.google.android.gms.internal.ads.zzfhl;
import com.google.android.gms.internal.ads.zzfig;
import com.google.android.gms.internal.ads.zzfmn;
import com.google.android.gms.internal.ads.zzfmo;
import com.google.android.gms.internal.ads.zzfmz;
import com.google.android.gms.internal.ads.zzfnc;
import com.google.android.gms.internal.ads.zzfny;
import com.google.android.gms.internal.ads.zzfws;
import com.google.android.gms.internal.ads.zzfxt;
import com.google.android.gms.internal.ads.zzgdt;
import com.google.android.gms.internal.ads.zzgdu;
import com.google.android.gms.internal.ads.zzgee;
import com.google.android.gms.internal.ads.zzgen;
import com.google.android.gms.internal.ads.zzgey;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzaa extends zzccs {
    protected static final List zza = new ArrayList(Arrays.asList("/aclk", "/pcs/click", "/dbm/clk"));
    protected static final List zzb = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com"));
    protected static final List zzc = new ArrayList(Arrays.asList("/pagead/adview", "/pcs/view", "/pagead/conversion", "/dbm/ad"));
    protected static final List zzd = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"));
    public static final /* synthetic */ int zze = 0;
    private final zzcei zzB;
    private String zzC;
    private final List zzE;
    private final List zzF;
    private final List zzG;
    private final List zzH;
    private final zzbhh zzL;
    private final zzclg zzf;
    private Context zzg;
    private final zzavi zzh;
    private final zzfhl zzi;
    private final zzfig zzj;
    private final zzgey zzl;
    private final ScheduledExecutorService zzm;
    private zzbxr zzn;
    private final zzc zzr;
    private final zzdwk zzs;
    private final zzfny zzt;
    private zzdwa zzk = null;
    private Point zzo = new Point();
    private Point zzp = new Point();
    private final Set zzq = Collections.newSetFromMap(new WeakHashMap());
    private final AtomicInteger zzA = new AtomicInteger(0);
    private final AtomicBoolean zzI = new AtomicBoolean(false);
    private final AtomicBoolean zzJ = new AtomicBoolean(false);
    private final AtomicInteger zzK = new AtomicInteger(0);
    private final boolean zzu = ((Boolean) zzba.zzc().zza(zzbgc.zzhl)).booleanValue();
    private final boolean zzv = ((Boolean) zzba.zzc().zza(zzbgc.zzhk)).booleanValue();
    private final boolean zzw = ((Boolean) zzba.zzc().zza(zzbgc.zzhn)).booleanValue();
    private final boolean zzx = ((Boolean) zzba.zzc().zza(zzbgc.zzhp)).booleanValue();
    private final String zzy = (String) zzba.zzc().zza(zzbgc.zzho);
    private final String zzz = (String) zzba.zzc().zza(zzbgc.zzhq);
    private final String zzD = (String) zzba.zzc().zza(zzbgc.zzhr);

    public zzaa(zzclg zzclgVar, Context context, zzavi zzaviVar, zzfig zzfigVar, zzgey zzgeyVar, ScheduledExecutorService scheduledExecutorService, zzdwk zzdwkVar, zzfny zzfnyVar, zzcei zzceiVar, zzbhh zzbhhVar, zzfhl zzfhlVar) {
        List list;
        this.zzf = zzclgVar;
        this.zzg = context;
        this.zzh = zzaviVar;
        this.zzi = zzfhlVar;
        this.zzj = zzfigVar;
        this.zzl = zzgeyVar;
        this.zzm = scheduledExecutorService;
        this.zzr = zzclgVar.zzn();
        this.zzs = zzdwkVar;
        this.zzt = zzfnyVar;
        this.zzB = zzceiVar;
        this.zzL = zzbhhVar;
        if (((Boolean) zzba.zzc().zza(zzbgc.zzhs)).booleanValue()) {
            this.zzE = zzad((String) zzba.zzc().zza(zzbgc.zzht));
            this.zzF = zzad((String) zzba.zzc().zza(zzbgc.zzhu));
            this.zzG = zzad((String) zzba.zzc().zza(zzbgc.zzhv));
            list = zzad((String) zzba.zzc().zza(zzbgc.zzhw));
        } else {
            this.zzE = zza;
            this.zzF = zzb;
            this.zzG = zzc;
            list = zzd;
        }
        this.zzH = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzI(zzaa zzaaVar, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (zzaaVar.zzR((Uri) it.next())) {
                zzaaVar.zzA.getAndIncrement();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzK(final zzaa zzaaVar, final String str, final String str2, final zzdwa zzdwaVar) {
        if (((Boolean) zzba.zzc().zza(zzbgc.zzgX)).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbgc.zzhd)).booleanValue()) {
                zzcep.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzk
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzaa.this.zzM(str, str2, zzdwaVar);
                    }
                });
            } else {
                zzaaVar.zzr.zzd(str, str2, zzdwaVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Uri zzT(Uri uri, String str) {
        return !TextUtils.isEmpty(str) ? zzac(uri, "nas", str) : uri;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final zzh zzU(Context context, String str, String str2, com.google.android.gms.ads.internal.client.zzq zzqVar, com.google.android.gms.ads.internal.client.zzl zzlVar) {
        char c;
        zzfhf zzfhfVar = new zzfhf();
        if ("REWARDED".equals(str2)) {
            zzfhfVar.zzo().zza(2);
        } else if ("REWARDED_INTERSTITIAL".equals(str2)) {
            zzfhfVar.zzo().zza(3);
        }
        zzg zzo = this.zzf.zzo();
        zzdaf zzdafVar = new zzdaf();
        zzdafVar.zze(context);
        if (str == null) {
            str = "adUnitId";
        }
        zzfhfVar.zzs(str);
        if (zzlVar == null) {
            zzlVar = new com.google.android.gms.ads.internal.client.zzm().zza();
        }
        zzfhfVar.zzE(zzlVar);
        if (zzqVar == null) {
            switch (str2.hashCode()) {
                case -1999289321:
                    if (str2.equals("NATIVE")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -428325382:
                    if (str2.equals("APP_OPEN_AD")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 543046670:
                    if (str2.equals("REWARDED")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1854800829:
                    if (str2.equals("REWARDED_INTERSTITIAL")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1951953708:
                    if (str2.equals("BANNER")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                zzqVar = new com.google.android.gms.ads.internal.client.zzq(context, AdSize.BANNER);
            } else if (c == 1 || c == 2) {
                zzqVar = com.google.android.gms.ads.internal.client.zzq.zzd();
            } else if (c == 3) {
                zzqVar = com.google.android.gms.ads.internal.client.zzq.zzc();
            } else if (c == 4) {
                zzqVar = com.google.android.gms.ads.internal.client.zzq.zzb();
            } else {
                zzqVar = new com.google.android.gms.ads.internal.client.zzq();
            }
        }
        zzfhfVar.zzr(zzqVar);
        zzfhfVar.zzx(true);
        zzdafVar.zzi(zzfhfVar.zzG());
        zzo.zza(zzdafVar.zzj());
        zzac zzacVar = new zzac();
        zzacVar.zza(str2);
        zzo.zzb(new zzae(zzacVar, null));
        new zzdgm();
        zzh zzc2 = zzo.zzc();
        this.zzk = zzc2.zza();
        return zzc2;
    }

    private final ListenableFuture zzV(final String str) {
        final zzdrz[] zzdrzVarArr = new zzdrz[1];
        ListenableFuture zzn = zzgen.zzn(this.zzj.zza(), new zzgdu() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzl
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzaa.this.zzw(zzdrzVarArr, str, (zzdrz) obj);
            }
        }, this.zzl);
        zzn.addListener(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzm
            @Override // java.lang.Runnable
            public final void run() {
                zzaa.this.zzL(zzdrzVarArr);
            }
        }, this.zzl);
        return zzgen.zze(zzgen.zzm((zzgee) zzgen.zzo(zzgee.zzu(zzn), ((Integer) zzba.zzc().zza(zzbgc.zzhE)).intValue(), TimeUnit.MILLISECONDS, this.zzm), new zzfws() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzs
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                int i = zzaa.zze;
                return ((JSONObject) obj).optString("nas");
            }
        }, this.zzl), Exception.class, new zzfws() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzt
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                int i = zzaa.zze;
                zzcec.zzh("", (Exception) obj);
                return null;
            }
        }, this.zzl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzW() {
        ListenableFuture zzc2;
        if (((Boolean) zzba.zzc().zza(zzbgc.zzkB)).booleanValue()) {
            zzc2 = zzgen.zzk(new zzgdt() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzi
                @Override // com.google.android.gms.internal.ads.zzgdt
                public final ListenableFuture zza() {
                    return zzaa.this.zzv();
                }
            }, zzcep.zza);
        } else {
            zzc2 = zzU(this.zzg, null, AdFormat.BANNER.name(), null, null).zzc();
        }
        zzgen.zzr(zzc2, new zzz(this), this.zzf.zzB());
    }

    private final void zzX() {
        if (((Boolean) zzba.zzc().zza(zzbgc.zzjp)).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbgc.zzjs)).booleanValue()) {
                return;
            }
            if (((Boolean) zzba.zzc().zza(zzbgc.zzjw)).booleanValue() && this.zzI.getAndSet(true)) {
                return;
            }
            zzW();
        }
    }

    private final void zzY(List list, final IObjectWrapper iObjectWrapper, zzbxi zzbxiVar, boolean z) {
        ListenableFuture zzb2;
        if (!((Boolean) zzba.zzc().zza(zzbgc.zzhD)).booleanValue()) {
            zzcec.zzj("The updating URL feature is not enabled.");
            try {
                zzbxiVar.zze("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e) {
                zzcec.zzh("", e);
                return;
            }
        }
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (zzR((Uri) it.next())) {
                i++;
            }
        }
        if (i > 1) {
            zzcec.zzj("Multiple google urls found: ".concat(String.valueOf(String.valueOf(list))));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            final Uri uri = (Uri) it2.next();
            if (!zzR(uri)) {
                zzcec.zzj("Not a Google URL: ".concat(String.valueOf(String.valueOf(uri))));
                zzb2 = zzgen.zzh(uri);
            } else {
                zzb2 = this.zzl.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzn
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return zzaa.this.zzn(uri, iObjectWrapper);
                    }
                });
                if (zzab()) {
                    zzb2 = zzgen.zzn(zzb2, new zzgdu() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzo
                        @Override // com.google.android.gms.internal.ads.zzgdu
                        public final ListenableFuture zza(Object obj) {
                            ListenableFuture zzm;
                            zzm = zzgen.zzm(r0.zzV("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzfws() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzp
                                @Override // com.google.android.gms.internal.ads.zzfws
                                public final Object apply(Object obj2) {
                                    return zzaa.zzT(r2, (String) obj2);
                                }
                            }, zzaa.this.zzl);
                            return zzm;
                        }
                    }, this.zzl);
                } else {
                    zzcec.zzi("Asset view map is empty.");
                }
            }
            arrayList.add(zzb2);
        }
        zzgen.zzr(zzgen.zzd(arrayList), new zzy(this, zzbxiVar, z), this.zzf.zzB());
    }

    private final void zzZ(final List list, final IObjectWrapper iObjectWrapper, zzbxi zzbxiVar, boolean z) {
        if (!((Boolean) zzba.zzc().zza(zzbgc.zzhD)).booleanValue()) {
            try {
                zzbxiVar.zze("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e) {
                zzcec.zzh("", e);
                return;
            }
        }
        ListenableFuture zzb2 = this.zzl.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzu
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzaa.this.zzD(list, iObjectWrapper);
            }
        });
        if (zzab()) {
            zzb2 = zzgen.zzn(zzb2, new zzgdu() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzv
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final ListenableFuture zza(Object obj) {
                    return zzaa.this.zzx((ArrayList) obj);
                }
            }, this.zzl);
        } else {
            zzcec.zzi("Asset view map is empty.");
        }
        zzgen.zzr(zzb2, new zzx(this, zzbxiVar, z), this.zzf.zzB());
    }

    private static boolean zzaa(Uri uri, List list, List list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (host != null && path != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.contains((String) it.next())) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (host.endsWith((String) it2.next())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private final boolean zzab() {
        Map map;
        zzbxr zzbxrVar = this.zzn;
        return (zzbxrVar == null || (map = zzbxrVar.zzb) == null || map.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri zzac(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl=");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl=");
        }
        if (indexOf != -1) {
            int i = indexOf + 1;
            return Uri.parse(uri2.substring(0, i) + str + "=" + str2 + "&" + uri2.substring(i));
        }
        return uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    private static final List zzad(String str) {
        String[] split = TextUtils.split(str, ",");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            if (!zzfxt.zzd(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzfmz zzs(ListenableFuture listenableFuture, zzccx zzccxVar) {
        if (!zzfnc.zza() || !((Boolean) zzbht.zze.zze()).booleanValue()) {
            return null;
        }
        try {
            zzfmz zzb2 = ((zzh) zzgen.zzp(listenableFuture)).zzb();
            zzb2.zzd(new ArrayList(Collections.singletonList(zzccxVar.zzb)));
            com.google.android.gms.ads.internal.client.zzl zzlVar = zzccxVar.zzd;
            zzb2.zzb(zzlVar == null ? "" : zzlVar.zzp);
            return zzb2;
        } catch (ExecutionException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "SignalGeneratorImpl.getConfiguredCriticalUserJourney");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzC(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!zzS(uri) || TextUtils.isEmpty(str)) {
                arrayList.add(uri);
            } else {
                arrayList.add(zzac(uri, "nas", str));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzD(List list, IObjectWrapper iObjectWrapper) throws Exception {
        this.zzh.zzc();
        String zzh = this.zzh.zzc().zzh(this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), null);
        if (TextUtils.isEmpty(zzh)) {
            throw new Exception("Failed to get view signals.");
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!zzS(uri)) {
                zzcec.zzj("Not a Google URL: ".concat(String.valueOf(String.valueOf(uri))));
                arrayList.add(uri);
            } else {
                arrayList.add(zzac(uri, "ms", zzh));
            }
        }
        if (arrayList.isEmpty()) {
            throw new Exception("Empty impression URLs result.");
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzL(zzdrz[] zzdrzVarArr) {
        zzdrz zzdrzVar = zzdrzVarArr[0];
        if (zzdrzVar != null) {
            this.zzj.zzb(zzgen.zzh(zzdrzVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzM(String str, String str2, zzdwa zzdwaVar) {
        this.zzr.zzd(str, str2, zzdwaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzR(Uri uri) {
        return zzaa(uri, this.zzE, this.zzF);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzS(Uri uri) {
        return zzaa(uri, this.zzG, this.zzH);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) {
        if (!((Boolean) zzba.zzc().zza(zzbgc.zzjz)).booleanValue()) {
            return ObjectWrapper.wrap(null);
        }
        this.zzL.zzg((Context) ObjectWrapper.unwrap(iObjectWrapper), (CustomTabsClient) ObjectWrapper.unwrap(iObjectWrapper2), str, (CustomTabsCallback) ObjectWrapper.unwrap(iObjectWrapper3));
        return ObjectWrapper.wrap(this.zzL.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzf(IObjectWrapper iObjectWrapper, final zzccx zzccxVar, zzccq zzccqVar) {
        ListenableFuture zzc2;
        ListenableFuture listenableFuture;
        ListenableFuture zzb2;
        ListenableFuture zzn;
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        this.zzg = context;
        zzfmo zza2 = zzfmn.zza(context, 22);
        zza2.zzh();
        if ("UNKNOWN".equals(zzccxVar.zzb)) {
            List arrayList = new ArrayList();
            if (!((String) zzba.zzc().zza(zzbgc.zzhC)).isEmpty()) {
                arrayList = Arrays.asList(((String) zzba.zzc().zza(zzbgc.zzhC)).split(","));
            }
            if (arrayList.contains(zzf.zzb(zzccxVar.zzd))) {
                zzb2 = zzgen.zzg(new IllegalArgumentException("Unknown format is no longer supported."));
                zzn = zzgen.zzg(new IllegalArgumentException("Unknown format is no longer supported."));
                listenableFuture = zzb2;
                zzc2 = zzn;
                zzgen.zzr(zzc2, new zzw(this, listenableFuture, zzccxVar, zzccqVar, zza2, com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()), this.zzf.zzB());
            }
        }
        if (((Boolean) zzba.zzc().zza(zzbgc.zzkB)).booleanValue()) {
            zzb2 = zzcep.zza.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzq
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return zzaa.this.zzr(zzccxVar);
                }
            });
            zzn = zzgen.zzn(zzb2, new zzgdu() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzr
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final ListenableFuture zza(Object obj) {
                    return ((zzh) obj).zzc();
                }
            }, zzcep.zza);
            listenableFuture = zzb2;
            zzc2 = zzn;
            zzgen.zzr(zzc2, new zzw(this, listenableFuture, zzccxVar, zzccqVar, zza2, com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()), this.zzf.zzB());
        }
        zzh zzU = zzU(this.zzg, zzccxVar.zza, zzccxVar.zzb, zzccxVar.zzc, zzccxVar.zzd);
        ListenableFuture zzh = zzgen.zzh(zzU);
        zzc2 = zzU.zzc();
        listenableFuture = zzh;
        zzgen.zzr(zzc2, new zzw(this, listenableFuture, zzccxVar, zzccqVar, zza2, com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()), this.zzf.zzB());
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzg(zzbxr zzbxrVar) {
        this.zzn = zzbxrVar;
        this.zzj.zzc(1);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbxi zzbxiVar) {
        zzY(list, iObjectWrapper, zzbxiVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzi(List list, IObjectWrapper iObjectWrapper, zzbxi zzbxiVar) {
        zzZ(list, iObjectWrapper, zzbxiVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzj(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzba.zzc().zza(zzbgc.zzjo)).booleanValue()) {
            if (!((Boolean) zzba.zzc().zza(zzbgc.zzhB)).booleanValue()) {
                zzX();
            }
            WebView webView = (WebView) ObjectWrapper.unwrap(iObjectWrapper);
            if (webView == null) {
                zzcec.zzg("The webView cannot be null.");
                return;
            }
            if (this.zzq.contains(webView)) {
                zzcec.zzi("This webview has already been registered.");
                return;
            }
            this.zzq.add(webView);
            webView.addJavascriptInterface(new TaggingLibraryJsInterface(webView, this.zzh, this.zzs, this.zzt, this.zzi), "gmaSdk");
            if (((Boolean) zzba.zzc().zza(zzbgc.zzjy)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzo().zzs();
            }
            if (((Boolean) zzba.zzc().zza(zzbgc.zzhB)).booleanValue()) {
                zzX();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzk(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzba.zzc().zza(zzbgc.zzhD)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzbxr zzbxrVar = this.zzn;
            this.zzo = zzbz.zza(motionEvent, zzbxrVar == null ? null : zzbxrVar.zza);
            if (motionEvent.getAction() == 0) {
                this.zzp = this.zzo;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setLocation(this.zzo.x, this.zzo.y);
            this.zzh.zzd(obtain);
            obtain.recycle();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbxi zzbxiVar) {
        zzY(list, iObjectWrapper, zzbxiVar, false);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzm(List list, IObjectWrapper iObjectWrapper, zzbxi zzbxiVar) {
        zzZ(list, iObjectWrapper, zzbxiVar, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Uri zzn(Uri uri, IObjectWrapper iObjectWrapper) throws Exception {
        zzfhl zzfhlVar;
        try {
            if (!((Boolean) zzba.zzc().zza(zzbgc.zzlr)).booleanValue() || (zzfhlVar = this.zzi) == null) {
                uri = this.zzh.zza(uri, this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), null);
            } else {
                uri = zzfhlVar.zza(uri, this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), null);
            }
        } catch (zzavj e) {
            zzcec.zzk("", e);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzh zzr(zzccx zzccxVar) throws Exception {
        return zzU(this.zzg, zzccxVar.zza, zzccxVar.zzb, zzccxVar.zzc, zzccxVar.zzd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzv() throws Exception {
        return zzU(this.zzg, null, AdFormat.BANNER.name(), null, null).zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzw(zzdrz[] zzdrzVarArr, String str, zzdrz zzdrzVar) throws Exception {
        zzdrzVarArr[0] = zzdrzVar;
        Context context = this.zzg;
        zzbxr zzbxrVar = this.zzn;
        Map map = zzbxrVar.zzb;
        JSONObject zzd2 = zzbz.zzd(context, map, map, zzbxrVar.zza, null);
        JSONObject zzg = zzbz.zzg(this.zzg, this.zzn.zza);
        JSONObject zzf = zzbz.zzf(this.zzn.zza);
        JSONObject zze2 = zzbz.zze(this.zzg, this.zzn.zza);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", zzd2);
        jSONObject.put("ad_view_signal", zzg);
        jSONObject.put("scroll_view_signal", zzf);
        jSONObject.put("lock_screen_signal", zze2);
        if ("google.afma.nativeAds.getPublisherCustomRenderedClickSignals".equals(str)) {
            jSONObject.put("click_signal", zzbz.zzc(null, this.zzg, this.zzp, this.zzo));
        }
        return zzdrzVar.zzd(str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzx(final ArrayList arrayList) throws Exception {
        return zzgen.zzm(zzV("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzfws() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzj
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                return zzaa.this.zzC(arrayList, (String) obj);
            }
        }, this.zzl);
    }
}

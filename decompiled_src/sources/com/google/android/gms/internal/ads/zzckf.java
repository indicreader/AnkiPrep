package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Looper;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import coil.disk.DiskLruCache;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzftt;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes3.dex */
public final class zzckf extends WebView implements DownloadListener, ViewTreeObserver.OnGlobalLayoutListener, zzcjk {
    public static final /* synthetic */ int zza = 0;
    private zzcki zzA;
    private boolean zzB;
    private boolean zzC;
    private zzbja zzD;
    private zzbiy zzE;
    private zzbad zzF;
    private int zzG;
    private int zzH;
    private zzbgr zzI;
    private final zzbgr zzJ;
    private zzbgr zzK;
    private final zzbgs zzL;
    private int zzM;
    private com.google.android.gms.ads.internal.overlay.zzm zzN;
    private boolean zzO;
    private final com.google.android.gms.ads.internal.util.zzco zzP;
    private int zzQ;
    private int zzR;
    private int zzS;
    private int zzT;
    private Map zzU;
    private final WindowManager zzV;
    private final zzbbp zzW;
    private boolean zzX;
    private final zzckz zzb;
    private final zzavi zzc;
    private final zzfhl zzd;
    private final zzbhj zze;
    private final zzcei zzf;
    private com.google.android.gms.ads.internal.zzl zzg;
    private final com.google.android.gms.ads.internal.zza zzh;
    private final DisplayMetrics zzi;
    private final float zzj;
    private zzfgm zzk;
    private zzfgp zzl;
    private boolean zzm;
    private boolean zzn;
    private zzcjs zzo;
    private com.google.android.gms.ads.internal.overlay.zzm zzp;
    private zzfod zzq;
    private zzcla zzr;
    private final String zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private Boolean zzx;
    private boolean zzy;
    private final String zzz;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzckf(zzckz zzckzVar, zzcla zzclaVar, String str, boolean z, boolean z2, zzavi zzaviVar, zzbhj zzbhjVar, zzcei zzceiVar, zzbgu zzbguVar, com.google.android.gms.ads.internal.zzl zzlVar, com.google.android.gms.ads.internal.zza zzaVar, zzbbp zzbbpVar, zzfgm zzfgmVar, zzfgp zzfgpVar, zzfhl zzfhlVar) {
        super(zzckzVar);
        zzfgp zzfgpVar2;
        this.zzm = false;
        this.zzn = false;
        this.zzy = true;
        this.zzz = "";
        this.zzQ = -1;
        this.zzR = -1;
        this.zzS = -1;
        this.zzT = -1;
        this.zzb = zzckzVar;
        this.zzr = zzclaVar;
        this.zzs = str;
        this.zzv = z;
        this.zzc = zzaviVar;
        this.zzd = zzfhlVar;
        this.zze = zzbhjVar;
        this.zzf = zzceiVar;
        this.zzg = zzlVar;
        this.zzh = zzaVar;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.zzV = windowManager;
        com.google.android.gms.ads.internal.zzt.zzp();
        DisplayMetrics zzs = com.google.android.gms.ads.internal.util.zzt.zzs(windowManager);
        this.zzi = zzs;
        this.zzj = zzs.density;
        this.zzW = zzbbpVar;
        this.zzk = zzfgmVar;
        this.zzl = zzfgpVar;
        this.zzP = new com.google.android.gms.ads.internal.util.zzco(zzckzVar.zza(), this, this, null);
        this.zzX = false;
        setBackgroundColor(0);
        final WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            zzcec.zzh("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkZ)).booleanValue()) {
            settings.setMixedContentMode(1);
        } else {
            settings.setMixedContentMode(2);
        }
        settings.setUserAgentString(com.google.android.gms.ads.internal.zzt.zzp().zzc(zzckzVar, zzceiVar.zza));
        com.google.android.gms.ads.internal.zzt.zzp();
        final Context context = getContext();
        com.google.android.gms.ads.internal.util.zzch.zza(context, new Callable() { // from class: com.google.android.gms.ads.internal.util.zzk
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzftt zzfttVar = zzt.zza;
                String absolutePath = context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath();
                WebSettings webSettings = settings;
                webSettings.setDatabasePath(absolutePath);
                webSettings.setDatabaseEnabled(true);
                webSettings.setDomStorageEnabled(true);
                webSettings.setDisplayZoomControls(false);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setSupportZoom(true);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaK)).booleanValue()) {
                    webSettings.setTextZoom(100);
                }
                webSettings.setAllowContentAccess(false);
                return true;
            }
        });
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setMediaPlaybackRequiresUserGesture(false);
        setDownloadListener(this);
        zzaV();
        addJavascriptInterface(new zzckm(this, new zzckl(this)), "googleAdsJsInterface");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        zzbd();
        zzbgs zzbgsVar = new zzbgs(new zzbgu(true, "make_wv", this.zzs));
        this.zzL = zzbgsVar;
        zzbgsVar.zza().zzc(null);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbQ)).booleanValue() && (zzfgpVar2 = this.zzl) != null && zzfgpVar2.zzb != null) {
            zzbgsVar.zza().zzd("gqi", this.zzl.zzb);
        }
        zzbgsVar.zza();
        zzbgr zzf = zzbgu.zzf();
        this.zzJ = zzf;
        zzbgsVar.zzb("native:view_create", zzf);
        this.zzK = null;
        this.zzI = null;
        com.google.android.gms.ads.internal.util.zzck.zza().zzb(zzckzVar);
        com.google.android.gms.ads.internal.zzt.zzo().zzt();
    }

    private final synchronized void zzaV() {
        zzfgm zzfgmVar = this.zzk;
        if (zzfgmVar != null && zzfgmVar.zzan) {
            zzcec.zze("Disabling hardware acceleration on an overlay.");
            zzaX();
            return;
        }
        if (!this.zzv && !this.zzr.zzi()) {
            zzcec.zze("Enabling hardware acceleration on an AdView.");
            zzaZ();
            return;
        }
        zzcec.zze("Enabling hardware acceleration on an overlay.");
        zzaZ();
    }

    private final synchronized void zzaW() {
        if (this.zzO) {
            return;
        }
        this.zzO = true;
        com.google.android.gms.ads.internal.zzt.zzo().zzr();
    }

    private final synchronized void zzaX() {
        if (!this.zzw) {
            setLayerType(1, null);
        }
        this.zzw = true;
    }

    private final void zzaY(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", true != z ? "0" : DiskLruCache.VERSION);
        zzd("onAdVisibilityChanged", hashMap);
    }

    private final synchronized void zzaZ() {
        if (this.zzw) {
            setLayerType(0, null);
        }
        this.zzw = false;
    }

    private final synchronized void zzba(String str) {
        try {
            super.loadUrl("about:blank");
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(th, "AdWebViewImpl.loadUrlUnsafe");
            zzcec.zzk("Could not call loadUrl in destroy(). ", th);
        }
    }

    private final void zzbb() {
        zzbgm.zza(this.zzL.zza(), this.zzJ, "aeh2");
    }

    private final synchronized void zzbc() {
        Map map = this.zzU;
        if (map != null) {
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                ((zzchw) it.next()).release();
            }
        }
        this.zzU = null;
    }

    private final void zzbd() {
        zzbgs zzbgsVar = this.zzL;
        if (zzbgsVar == null) {
            return;
        }
        zzbgu zza2 = zzbgsVar.zza();
        zzbgk zzg = com.google.android.gms.ads.internal.zzt.zzo().zzg();
        if (zzg != null) {
            zzg.zzf(zza2);
        }
    }

    private final synchronized void zzbe() {
        Boolean zzl = com.google.android.gms.ads.internal.zzt.zzo().zzl();
        this.zzx = zzl;
        if (zzl == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                zzaT(true);
            } catch (IllegalStateException unused) {
                zzaT(false);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcjk
    public final synchronized void destroy() {
        zzbd();
        this.zzP.zza();
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.zzb();
            this.zzp.zzm();
            this.zzp = null;
        }
        this.zzq = null;
        this.zzo.zzh();
        this.zzF = null;
        this.zzg = null;
        setOnClickListener(null);
        setOnTouchListener(null);
        if (this.zzu) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzy().zzd(this);
        zzbc();
        this.zzu = true;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkn)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zza("Initiating WebView self destruct sequence in 3...");
            com.google.android.gms.ads.internal.util.zze.zza("Loading blank page in WebView, 2...");
            zzba("about:blank");
        } else {
            com.google.android.gms.ads.internal.util.zze.zza("Destroying the WebView immediately...");
            zzV();
        }
    }

    @Override // android.webkit.WebView
    public final synchronized void evaluateJavascript(final String str, final ValueCallback valueCallback) {
        if (zzaB()) {
            zzcec.zzl("#004 The webview is destroyed. Ignoring action.", null);
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
                return;
            }
            return;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzko)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
            super.evaluateJavascript(str, valueCallback);
        } else {
            zzcep.zze.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzckb
                @Override // java.lang.Runnable
                public final void run() {
                    zzckf.this.zzaR(str, valueCallback);
                }
            });
        }
    }

    protected final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.zzu) {
                    this.zzo.zzh();
                    com.google.android.gms.ads.internal.zzt.zzy().zzd(this);
                    zzbc();
                    zzaW();
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcjk
    public final synchronized void loadData(String str, String str2, String str3) {
        if (zzaB()) {
            zzcec.zzj("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadData(str, str2, str3);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcjk
    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (zzaB()) {
            zzcec.zzj("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcjk
    public final synchronized void loadUrl(String str) {
        if (!zzaB()) {
            try {
                super.loadUrl(str);
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.zzt.zzo().zzw(th, "AdWebViewImpl.loadUrl");
                zzcec.zzk("Could not call loadUrl. ", th);
                return;
            }
        }
        zzcec.zzj("#004 The webview is destroyed. Ignoring action.");
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzcjs zzcjsVar = this.zzo;
        if (zzcjsVar != null) {
            zzcjsVar.onAdClicked();
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!zzaB()) {
            this.zzP.zzc();
        }
        if (this.zzX) {
            onResume();
            this.zzX = false;
        }
        boolean z = this.zzB;
        zzcjs zzcjsVar = this.zzo;
        if (zzcjsVar != null && zzcjsVar.zzM()) {
            if (!this.zzC) {
                this.zzo.zza();
                this.zzo.zzb();
                this.zzC = true;
            }
            zzaU();
            z = true;
        }
        zzaY(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        zzcjs zzcjsVar;
        synchronized (this) {
            if (!zzaB()) {
                this.zzP.zzd();
            }
            super.onDetachedFromWindow();
            if (this.zzC && (zzcjsVar = this.zzo) != null && zzcjsVar.zzM() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzo.zza();
                this.zzo.zzb();
                this.zzC = false;
            }
        }
        zzaY(false);
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkz)).booleanValue() && getContext() != null) {
                intent.setPackage(getContext().getPackageName());
            }
            com.google.android.gms.ads.internal.zzt.zzp();
            com.google.android.gms.ads.internal.util.zzt.zzS(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            zzcec.zze("Couldn't find an Activity to view url/mimetype: " + str + " / " + str4);
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "AdWebViewImpl.onDownloadStart: ".concat(String.valueOf(str)));
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected final void onDraw(Canvas canvas) {
        if (zzaB()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean zzaU = zzaU();
        com.google.android.gms.ads.internal.overlay.zzm zzL = zzL();
        if (zzL == null || !zzaU) {
            return;
        }
        zzL.zzn();
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01b7 A[Catch: all -> 0x01dd, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:10:0x000f, B:12:0x0015, B:14:0x0019, B:17:0x0023, B:19:0x002b, B:22:0x0030, B:24:0x0038, B:26:0x004a, B:29:0x004f, B:31:0x0056, B:34:0x0060, B:37:0x0065, B:40:0x0076, B:41:0x008c, B:45:0x007d, B:48:0x0082, B:52:0x0099, B:54:0x00a1, B:56:0x00b3, B:59:0x00b8, B:61:0x00d4, B:62:0x00dc, B:65:0x00d8, B:66:0x00e1, B:68:0x00e9, B:71:0x00f4, B:78:0x0118, B:80:0x011f, B:84:0x0127, B:86:0x0139, B:88:0x0147, B:91:0x0154, B:95:0x0159, B:97:0x019f, B:98:0x01a3, B:100:0x01aa, B:105:0x01b7, B:107:0x01bd, B:108:0x01c0, B:110:0x01c4, B:111:0x01cd, B:117:0x01d8), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0139 A[Catch: all -> 0x01dd, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:10:0x000f, B:12:0x0015, B:14:0x0019, B:17:0x0023, B:19:0x002b, B:22:0x0030, B:24:0x0038, B:26:0x004a, B:29:0x004f, B:31:0x0056, B:34:0x0060, B:37:0x0065, B:40:0x0076, B:41:0x008c, B:45:0x007d, B:48:0x0082, B:52:0x0099, B:54:0x00a1, B:56:0x00b3, B:59:0x00b8, B:61:0x00d4, B:62:0x00dc, B:65:0x00d8, B:66:0x00e1, B:68:0x00e9, B:71:0x00f4, B:78:0x0118, B:80:0x011f, B:84:0x0127, B:86:0x0139, B:88:0x0147, B:91:0x0154, B:95:0x0159, B:97:0x019f, B:98:0x01a3, B:100:0x01aa, B:105:0x01b7, B:107:0x01bd, B:108:0x01c0, B:110:0x01c4, B:111:0x01cd, B:117:0x01d8), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0159 A[Catch: all -> 0x01dd, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:10:0x000f, B:12:0x0015, B:14:0x0019, B:17:0x0023, B:19:0x002b, B:22:0x0030, B:24:0x0038, B:26:0x004a, B:29:0x004f, B:31:0x0056, B:34:0x0060, B:37:0x0065, B:40:0x0076, B:41:0x008c, B:45:0x007d, B:48:0x0082, B:52:0x0099, B:54:0x00a1, B:56:0x00b3, B:59:0x00b8, B:61:0x00d4, B:62:0x00dc, B:65:0x00d8, B:66:0x00e1, B:68:0x00e9, B:71:0x00f4, B:78:0x0118, B:80:0x011f, B:84:0x0127, B:86:0x0139, B:88:0x0147, B:91:0x0154, B:95:0x0159, B:97:0x019f, B:98:0x01a3, B:100:0x01aa, B:105:0x01b7, B:107:0x01bd, B:108:0x01c0, B:110:0x01c4, B:111:0x01cd, B:117:0x01d8), top: B:3:0x0003 }] */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final synchronized void onMeasure(int r10, int r11) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzckf.onMeasure(int, int):void");
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcjk
    public final void onPause() {
        if (zzaB()) {
            return;
        }
        try {
            super.onPause();
        } catch (Exception e) {
            zzcec.zzh("Could not pause webview.", e);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcjk
    public final void onResume() {
        if (zzaB()) {
            return;
        }
        try {
            super.onResume();
        } catch (Exception e) {
            zzcec.zzh("Could not resume webview.", e);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.zzo.zzM() || this.zzo.zzK()) {
            zzavi zzaviVar = this.zzc;
            if (zzaviVar != null) {
                zzaviVar.zzd(motionEvent);
            }
            zzbhj zzbhjVar = this.zze;
            if (zzbhjVar != null) {
                zzbhjVar.zzb(motionEvent);
            }
        } else {
            synchronized (this) {
                zzbja zzbjaVar = this.zzD;
                if (zzbjaVar != null) {
                    zzbjaVar.zzd(motionEvent);
                }
            }
        }
        if (zzaB()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcjk
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzcjs) {
            this.zzo = (zzcjs) webViewClient;
        }
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        if (zzaB()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e) {
            zzcec.zzh("Could not stop loading webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final synchronized void zzA(int i) {
        this.zzM = i;
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final void zzB(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcgl
    public final synchronized void zzC(zzcki zzckiVar) {
        if (this.zzA != null) {
            zzcec.zzg("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.zzA = zzckiVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcjb
    public final zzfgm zzD() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final Context zzE() {
        return this.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzckv
    public final View zzF() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final WebView zzG() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final WebViewClient zzH() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzckt
    public final zzavi zzI() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized zzbad zzJ() {
        return this.zzF;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized zzbja zzK() {
        return this.zzD;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized com.google.android.gms.ads.internal.overlay.zzm zzL() {
        return this.zzp;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized com.google.android.gms.ads.internal.overlay.zzm zzM() {
        return this.zzN;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final /* synthetic */ zzcky zzN() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcks
    public final synchronized zzcla zzO() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzckj
    public final zzfgp zzP() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final zzfhl zzQ() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized zzfod zzR() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final ListenableFuture zzS() {
        zzbhj zzbhjVar = this.zze;
        if (zzbhjVar == null) {
            return zzgen.zzh(null);
        }
        return zzbhjVar.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized String zzT() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzU(zzfgm zzfgmVar, zzfgp zzfgpVar) {
        this.zzk = zzfgmVar;
        this.zzl = zzfgpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzV() {
        com.google.android.gms.ads.internal.util.zze.zza("Destroying WebView!");
        zzaW();
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcke(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzW() {
        zzbb();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzf.zza);
        zzd("onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzX(int i) {
        if (i == 0) {
            zzbgs zzbgsVar = this.zzL;
            zzbgm.zza(zzbgsVar.zza(), this.zzJ, "aebb2");
        }
        zzbb();
        this.zzL.zza();
        this.zzL.zza().zzd("close_type", String.valueOf(i));
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.zzf.zza);
        zzd("onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzY() {
        if (this.zzI == null) {
            zzbgs zzbgsVar = this.zzL;
            zzbgm.zza(zzbgsVar.zza(), this.zzJ, "aes2");
            this.zzL.zza();
            zzbgr zzf = zzbgu.zzf();
            this.zzI = zzf;
            this.zzL.zzb("native:view_show", zzf);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzf.zza);
        zzd("onshow", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzZ() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbqn
    public final void zza(String str) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final boolean zzaA(final boolean z, final int i) {
        destroy();
        this.zzW.zzb(new zzbbo() { // from class: com.google.android.gms.internal.ads.zzckc
            @Override // com.google.android.gms.internal.ads.zzbbo
            public final void zza(zzbde zzbdeVar) {
                int i2 = zzckf.zza;
                zzbfj zza2 = zzbfk.zza();
                boolean zzc = zza2.zzc();
                boolean z2 = z;
                if (zzc != z2) {
                    zza2.zza(z2);
                }
                zza2.zzb(i);
                zzbdeVar.zzj((zzbfk) zza2.zzal());
            }
        });
        this.zzW.zzc(10003);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized boolean zzaB() {
        return this.zzu;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized boolean zzaC() {
        return this.zzv;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final boolean zzaD() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized boolean zzaE() {
        return this.zzy;
    }

    @Override // com.google.android.gms.internal.ads.zzckq
    public final void zzaF(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z) {
        this.zzo.zzu(zzcVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzckq
    public final void zzaG(String str, String str2, int i) {
        this.zzo.zzv(str, str2, 14);
    }

    @Override // com.google.android.gms.internal.ads.zzckq
    public final void zzaH(boolean z, int i, boolean z2) {
        this.zzo.zzw(z, i, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzckq
    public final void zzaI(boolean z, int i, String str, String str2, boolean z2) {
        this.zzo.zzy(z, i, str, str2, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzckq
    public final void zzaJ(boolean z, int i, String str, boolean z2, boolean z3) {
        this.zzo.zzz(z, i, str, z2, z3);
    }

    public final zzcjs zzaL() {
        return this.zzo;
    }

    final synchronized Boolean zzaM() {
        return this.zzx;
    }

    protected final synchronized void zzaP(String str, ValueCallback valueCallback) {
        if (zzaB()) {
            zzcec.zzj("#004 The webview is destroyed. Ignoring action.");
        } else {
            evaluateJavascript(str, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzaQ(String str) {
        if (PlatformVersion.isAtLeastKitKat()) {
            if (zzaM() == null) {
                zzbe();
            }
            if (zzaM().booleanValue()) {
                zzaP(str, null);
                return;
            } else {
                zzaS("javascript:".concat(str));
                return;
            }
        }
        zzaS("javascript:".concat(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaR(String str, ValueCallback valueCallback) {
        super.evaluateJavascript(str, valueCallback);
    }

    protected final synchronized void zzaS(String str) {
        if (zzaB()) {
            zzcec.zzj("#004 The webview is destroyed. Ignoring action.");
        } else {
            loadUrl(str);
        }
    }

    final void zzaT(Boolean bool) {
        synchronized (this) {
            this.zzx = bool;
        }
        com.google.android.gms.ads.internal.zzt.zzo().zzx(bool);
    }

    public final boolean zzaU() {
        int i;
        int i2;
        if (this.zzo.zzL() || this.zzo.zzM()) {
            com.google.android.gms.ads.internal.client.zzay.zzb();
            DisplayMetrics displayMetrics = this.zzi;
            int zzv = zzcdv.zzv(displayMetrics, displayMetrics.widthPixels);
            com.google.android.gms.ads.internal.client.zzay.zzb();
            DisplayMetrics displayMetrics2 = this.zzi;
            int zzv2 = zzcdv.zzv(displayMetrics2, displayMetrics2.heightPixels);
            Activity zza2 = this.zzb.zza();
            if (zza2 == null || zza2.getWindow() == null) {
                i = zzv;
                i2 = zzv2;
            } else {
                com.google.android.gms.ads.internal.zzt.zzp();
                int[] zzP = com.google.android.gms.ads.internal.util.zzt.zzP(zza2);
                com.google.android.gms.ads.internal.client.zzay.zzb();
                int zzv3 = zzcdv.zzv(this.zzi, zzP[0]);
                com.google.android.gms.ads.internal.client.zzay.zzb();
                i2 = zzcdv.zzv(this.zzi, zzP[1]);
                i = zzv3;
            }
            int i3 = this.zzR;
            if (i3 != zzv || this.zzQ != zzv2 || this.zzS != i || this.zzT != i2) {
                boolean z = (i3 == zzv && this.zzQ == zzv2) ? false : true;
                this.zzR = zzv;
                this.zzQ = zzv2;
                this.zzS = i;
                this.zzT = i2;
                new zzbvw(this, "").zzj(zzv, zzv2, i, i2, this.zzi.density, this.zzV.getDefaultDisplay().getRotation());
                return z;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzaa(boolean z) {
        this.zzo.zzi(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzab() {
        this.zzP.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzac(String str, String str2, String str3) {
        String str4;
        if (!zzaB()) {
            String[] strArr = new String[1];
            String str5 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzP);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("version", str5);
                jSONObject.put("sdk", "Google Mobile Ads");
                jSONObject.put("sdkVersion", "12.4.51-000");
                str4 = "<script>Object.defineProperty(window,'MRAID_ENV',{get:function(){return " + jSONObject.toString() + "}});</script>";
            } catch (JSONException e) {
                zzcec.zzk("Unable to build MRAID_ENV", e);
                str4 = null;
            }
            strArr[0] = str4;
            super.loadDataWithBaseURL(str, zzckr.zza(str2, strArr), "text/html", "UTF-8", null);
            return;
        }
        zzcec.zzj("#004 The webview is destroyed. Ignoring action.");
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzad() {
        if (this.zzK == null) {
            this.zzL.zza();
            zzbgr zzf = zzbgu.zzf();
            this.zzK = zzf;
            this.zzL.zzb("native:view_load", zzf);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzae(String str, zzbng zzbngVar) {
        zzcjs zzcjsVar = this.zzo;
        if (zzcjsVar != null) {
            zzcjsVar.zzA(str, zzbngVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzaf() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzag(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zzp = zzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzah(zzcla zzclaVar) {
        this.zzr = zzclaVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzai(zzbad zzbadVar) {
        this.zzF = zzbadVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzaj(boolean z) {
        this.zzy = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzak() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzal(Context context) {
        this.zzb.setBaseContext(context);
        this.zzP.zze(this.zzb.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzam(boolean z) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.zzy(this.zzo.zzL(), z);
        } else {
            this.zzt = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzan(zzbiy zzbiyVar) {
        this.zzE = zzbiyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzao(boolean z) {
        boolean z2 = this.zzv;
        this.zzv = z;
        zzaV();
        if (z != z2) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzQ)).booleanValue() || !this.zzr.zzi()) {
                new zzbvw(this, "").zzl(true != z ? "default" : "expanded");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzap(zzbja zzbjaVar) {
        this.zzD = zzbjaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzaq(zzfod zzfodVar) {
        this.zzq = zzfodVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzar(int i) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.zzA(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzas(boolean z) {
        this.zzX = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzat(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zzN = zzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzau(boolean z) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar;
        int i = this.zzG + (true != z ? -1 : 1);
        this.zzG = i;
        if (i > 0 || (zzmVar = this.zzp) == null) {
            return;
        }
        zzmVar.zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzav(boolean z) {
        if (z) {
            setBackgroundColor(0);
        }
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.zzB(z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzaw(String str, zzbng zzbngVar) {
        zzcjs zzcjsVar = this.zzo;
        if (zzcjsVar != null) {
            zzcjsVar.zzI(str, zzbngVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzax(String str, Predicate predicate) {
        zzcjs zzcjsVar = this.zzo;
        if (zzcjsVar != null) {
            zzcjsVar.zzJ(str, predicate);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized boolean zzay() {
        return this.zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized boolean zzaz() {
        return this.zzG > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbqn
    public final void zzb(String str, String str2) {
        zzaQ(str + "(" + str2 + ");");
    }

    @Override // com.google.android.gms.internal.ads.zzdiu
    public final void zzbo() {
        zzcjs zzcjsVar = this.zzo;
        if (zzcjsVar != null) {
            zzcjsVar.zzbo();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzl
    public final synchronized void zzbp() {
        com.google.android.gms.ads.internal.zzl zzlVar = this.zzg;
        if (zzlVar != null) {
            zzlVar.zzbp();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzl
    public final synchronized void zzbq() {
        com.google.android.gms.ads.internal.zzl zzlVar = this.zzg;
        if (zzlVar != null) {
            zzlVar.zzbq();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final synchronized String zzbr() {
        return this.zzz;
    }

    @Override // com.google.android.gms.internal.ads.zzayq
    public final void zzby(zzayp zzaypVar) {
        synchronized (this) {
            this.zzB = zzaypVar.zzj;
        }
        zzaY(zzaypVar.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzbqa
    public final void zzd(String str, Map map) {
        try {
            zze(str, com.google.android.gms.ads.internal.client.zzay.zzb().zzi(map));
        } catch (JSONException unused) {
            zzcec.zzj("Could not convert parameters to JSON.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqa
    public final void zze(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(jSONObject2);
        sb.append(");");
        zzcec.zze("Dispatching AFMA event: ".concat(sb.toString()));
        zzaQ(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final synchronized int zzf() {
        return this.zzM;
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final int zzg() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final int zzh() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzckn, com.google.android.gms.internal.ads.zzcgl
    public final Activity zzi() {
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcgl
    public final com.google.android.gms.ads.internal.zza zzj() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final zzbgr zzk() {
        return this.zzJ;
    }

    @Override // com.google.android.gms.internal.ads.zzbqn
    public final void zzl(String str, JSONObject jSONObject) {
        zzb(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcgl
    public final zzbgs zzm() {
        return this.zzL;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzcgl
    public final zzcei zzn() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final zzcga zzo() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final synchronized zzchw zzp(String str) {
        Map map = this.zzU;
        if (map == null) {
            return null;
        }
        return (zzchw) map.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcgl
    public final synchronized zzcki zzq() {
        return this.zzA;
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final synchronized String zzr() {
        zzfgp zzfgpVar = this.zzl;
        if (zzfgpVar == null) {
            return null;
        }
        return zzfgpVar.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdiu
    public final void zzs() {
        zzcjs zzcjsVar = this.zzo;
        if (zzcjsVar != null) {
            zzcjsVar.zzs();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcgl
    public final synchronized void zzt(String str, zzchw zzchwVar) {
        if (this.zzU == null) {
            this.zzU = new HashMap();
        }
        this.zzU.put(str, zzchwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final void zzu() {
        com.google.android.gms.ads.internal.overlay.zzm zzL = zzL();
        if (zzL != null) {
            zzL.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final void zzv(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("success", true != z ? "0" : DiskLruCache.VERSION);
        hashMap.put("duration", Long.toString(j));
        zzd("onCacheAccessComplete", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final synchronized void zzw() {
        zzbiy zzbiyVar = this.zzE;
        if (zzbiyVar != null) {
            final zzdra zzdraVar = (zzdra) zzbiyVar;
            com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdqy
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        zzdra.this.zzd();
                    } catch (RemoteException e) {
                        zzcec.zzl("#007 Could not call remote method.", e);
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final void zzx(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final void zzy(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final void zzz(boolean z) {
        this.zzo.zzD(false);
    }
}

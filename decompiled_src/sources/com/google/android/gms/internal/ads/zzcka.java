package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.common.util.Predicate;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcka extends FrameLayout implements zzcjk {
    private final zzcjk zza;
    private final zzcga zzb;
    private final AtomicBoolean zzc;

    /* JADX WARN: Multi-variable type inference failed */
    public zzcka(zzcjk zzcjkVar) {
        super(zzcjkVar.getContext());
        this.zzc = new AtomicBoolean();
        this.zza = zzcjkVar;
        this.zzb = new zzcga(zzcjkVar.zzE(), this, this);
        addView((View) zzcjkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final boolean canGoBack() {
        return this.zza.canGoBack();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void destroy() {
        final zzfod zzR = zzR();
        if (zzR != null) {
            com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjy
                @Override // java.lang.Runnable
                public final void run() {
                    com.google.android.gms.ads.internal.zzt.zzA().zzg(zzfod.this);
                }
            });
            final zzcjk zzcjkVar = this.zza;
            zzftt zzfttVar = com.google.android.gms.ads.internal.util.zzt.zza;
            Objects.requireNonNull(zzcjkVar);
            zzfttVar.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjz
                @Override // java.lang.Runnable
                public final void run() {
                    zzcjk.this.destroy();
                }
            }, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeV)).intValue());
            return;
        }
        this.zza.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void goBack() {
        this.zza.goBack();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void loadData(String str, String str2, String str3) {
        this.zza.loadData(str, "text/html", str3);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zza.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", null);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void loadUrl(String str) {
        this.zza.loadUrl(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzcjk zzcjkVar = this.zza;
        if (zzcjkVar != null) {
            zzcjkVar.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void onPause() {
        this.zzb.zzf();
        this.zza.onPause();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void onResume() {
        this.zza.onResume();
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzcjk
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zza.setOnClickListener(onClickListener);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzcjk
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zza.setOnTouchListener(onTouchListener);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zza.setWebChromeClient(webChromeClient);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zza.setWebViewClient(webViewClient);
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final void zzA(int i) {
        this.zza.zzA(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final void zzB(int i) {
        this.zzb.zzg(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcgl
    public final void zzC(zzcki zzckiVar) {
        this.zza.zzC(zzckiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcjb
    public final zzfgm zzD() {
        return this.zza.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final Context zzE() {
        return this.zza.zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzckv
    public final View zzF() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final WebView zzG() {
        return (WebView) this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final WebViewClient zzH() {
        return this.zza.zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzckt
    public final zzavi zzI() {
        return this.zza.zzI();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final zzbad zzJ() {
        return this.zza.zzJ();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final zzbja zzK() {
        return this.zza.zzK();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final com.google.android.gms.ads.internal.overlay.zzm zzL() {
        return this.zza.zzL();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final com.google.android.gms.ads.internal.overlay.zzm zzM() {
        return this.zza.zzM();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final zzcky zzN() {
        return ((zzckf) this.zza).zzaL();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcks
    public final zzcla zzO() {
        return this.zza.zzO();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzckj
    public final zzfgp zzP() {
        return this.zza.zzP();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final zzfhl zzQ() {
        return this.zza.zzQ();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final zzfod zzR() {
        return this.zza.zzR();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final ListenableFuture zzS() {
        return this.zza.zzS();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final String zzT() {
        return this.zza.zzT();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzU(zzfgm zzfgmVar, zzfgp zzfgpVar) {
        this.zza.zzU(zzfgmVar, zzfgpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzV() {
        this.zzb.zze();
        this.zza.zzV();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzW() {
        this.zza.zzW();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzX(int i) {
        this.zza.zzX(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzY() {
        this.zza.zzY();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzZ() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(com.google.android.gms.ads.internal.zzt.zzr().zze()));
        hashMap.put("app_volume", String.valueOf(com.google.android.gms.ads.internal.zzt.zzr().zza()));
        zzckf zzckfVar = (zzckf) this.zza;
        hashMap.put("device_volume", String.valueOf(com.google.android.gms.ads.internal.util.zzac.zzb(zzckfVar.getContext())));
        zzckfVar.zzd("volume", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbqn
    public final void zza(String str) {
        ((zzckf) this.zza).zzaQ(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final boolean zzaA(boolean z, int i) {
        if (!this.zzc.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaL)).booleanValue()) {
            return false;
        }
        if (this.zza.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.zza.getParent()).removeView((View) this.zza);
        }
        this.zza.zzaA(z, i);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final boolean zzaB() {
        return this.zza.zzaB();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final boolean zzaC() {
        return this.zza.zzaC();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final boolean zzaD() {
        return this.zzc.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final boolean zzaE() {
        return this.zza.zzaE();
    }

    @Override // com.google.android.gms.internal.ads.zzckq
    public final void zzaF(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z) {
        this.zza.zzaF(zzcVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzckq
    public final void zzaG(String str, String str2, int i) {
        this.zza.zzaG(str, str2, 14);
    }

    @Override // com.google.android.gms.internal.ads.zzckq
    public final void zzaH(boolean z, int i, boolean z2) {
        this.zza.zzaH(z, i, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzckq
    public final void zzaI(boolean z, int i, String str, String str2, boolean z2) {
        this.zza.zzaI(z, i, str, str2, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzckq
    public final void zzaJ(boolean z, int i, String str, boolean z2, boolean z3) {
        this.zza.zzaJ(z, i, str, z2, z3);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzaa(boolean z) {
        this.zza.zzaa(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzab() {
        this.zza.zzab();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzac(String str, String str2, String str3) {
        this.zza.zzac(str, str2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzad() {
        this.zza.zzad();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzae(String str, zzbng zzbngVar) {
        this.zza.zzae(str, zzbngVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzaf() {
        TextView textView = new TextView(getContext());
        com.google.android.gms.ads.internal.zzt.zzp();
        textView.setText(com.google.android.gms.ads.internal.util.zzt.zzx());
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzag(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zza.zzag(zzmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzah(zzcla zzclaVar) {
        this.zza.zzah(zzclaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzai(zzbad zzbadVar) {
        this.zza.zzai(zzbadVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzaj(boolean z) {
        this.zza.zzaj(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzak() {
        setBackgroundColor(0);
        this.zza.setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzal(Context context) {
        this.zza.zzal(context);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzam(boolean z) {
        this.zza.zzam(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzan(zzbiy zzbiyVar) {
        this.zza.zzan(zzbiyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzao(boolean z) {
        this.zza.zzao(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzap(zzbja zzbjaVar) {
        this.zza.zzap(zzbjaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzaq(zzfod zzfodVar) {
        this.zza.zzaq(zzfodVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzar(int i) {
        this.zza.zzar(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzas(boolean z) {
        this.zza.zzas(true);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzat(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zza.zzat(zzmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzau(boolean z) {
        this.zza.zzau(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzav(boolean z) {
        this.zza.zzav(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzaw(String str, zzbng zzbngVar) {
        this.zza.zzaw(str, zzbngVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzax(String str, Predicate predicate) {
        this.zza.zzax(str, predicate);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final boolean zzay() {
        return this.zza.zzay();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final boolean zzaz() {
        return this.zza.zzaz();
    }

    @Override // com.google.android.gms.internal.ads.zzbqn
    public final void zzb(String str, String str2) {
        this.zza.zzb("window.inspectorInfo", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzdiu
    public final void zzbo() {
        zzcjk zzcjkVar = this.zza;
        if (zzcjkVar != null) {
            zzcjkVar.zzbo();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzl
    public final void zzbp() {
        this.zza.zzbp();
    }

    @Override // com.google.android.gms.ads.internal.zzl
    public final void zzbq() {
        this.zza.zzbq();
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final String zzbr() {
        return this.zza.zzbr();
    }

    @Override // com.google.android.gms.internal.ads.zzayq
    public final void zzby(zzayp zzaypVar) {
        this.zza.zzby(zzaypVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbqa
    public final void zzd(String str, Map map) {
        this.zza.zzd(str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzbqa
    public final void zze(String str, JSONObject jSONObject) {
        this.zza.zze(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final int zzf() {
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final int zzg() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdK)).booleanValue()) {
            return this.zza.getMeasuredHeight();
        }
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final int zzh() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdK)).booleanValue()) {
            return this.zza.getMeasuredWidth();
        }
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzckn, com.google.android.gms.internal.ads.zzcgl
    public final Activity zzi() {
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcgl
    public final com.google.android.gms.ads.internal.zza zzj() {
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final zzbgr zzk() {
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzbqn
    public final void zzl(String str, JSONObject jSONObject) {
        ((zzckf) this.zza).zzb(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcgl
    public final zzbgs zzm() {
        return this.zza.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzcgl
    public final zzcei zzn() {
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final zzcga zzo() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final zzchw zzp(String str) {
        return this.zza.zzp(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcgl
    public final zzcki zzq() {
        return this.zza.zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final String zzr() {
        return this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.ads.zzdiu
    public final void zzs() {
        zzcjk zzcjkVar = this.zza;
        if (zzcjkVar != null) {
            zzcjkVar.zzs();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcgl
    public final void zzt(String str, zzchw zzchwVar) {
        this.zza.zzt(str, zzchwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final void zzu() {
        this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final void zzv(boolean z, long j) {
        this.zza.zzv(z, j);
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final void zzw() {
        this.zza.zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final void zzx(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final void zzy(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final void zzz(boolean z) {
        this.zza.zzz(false);
    }
}

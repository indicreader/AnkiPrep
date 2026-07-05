package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.Objects;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes3.dex */
public final class zzbrj {
    private final Context zzb;
    private final String zzc;
    private final zzcei zzd;
    private final zzfnc zze;
    private final com.google.android.gms.ads.internal.util.zzbd zzf;
    private final com.google.android.gms.ads.internal.util.zzbd zzg;
    private zzbri zzh;
    private final Object zza = new Object();
    private int zzi = 1;

    public zzbrj(Context context, zzcei zzceiVar, String str, com.google.android.gms.ads.internal.util.zzbd zzbdVar, com.google.android.gms.ads.internal.util.zzbd zzbdVar2, zzfnc zzfncVar) {
        this.zzc = str;
        this.zzb = context.getApplicationContext();
        this.zzd = zzceiVar;
        this.zze = zzfncVar;
        this.zzf = zzbdVar;
        this.zzg = zzbdVar2;
    }

    public final zzbrd zzb(zzavi zzaviVar) {
        com.google.android.gms.ads.internal.util.zze.zza("getEngine: Trying to acquire lock");
        synchronized (this.zza) {
            com.google.android.gms.ads.internal.util.zze.zza("getEngine: Lock acquired");
            com.google.android.gms.ads.internal.util.zze.zza("refreshIfDestroyed: Trying to acquire lock");
            synchronized (this.zza) {
                com.google.android.gms.ads.internal.util.zze.zza("refreshIfDestroyed: Lock acquired");
                zzbri zzbriVar = this.zzh;
                if (zzbriVar != null && this.zzi == 0) {
                    zzbriVar.zzi(new zzcey() { // from class: com.google.android.gms.internal.ads.zzbqp
                        @Override // com.google.android.gms.internal.ads.zzcey
                        public final void zza(Object obj) {
                            zzbrj.this.zzk((zzbqe) obj);
                        }
                    }, new zzcew() { // from class: com.google.android.gms.internal.ads.zzbqq
                        @Override // com.google.android.gms.internal.ads.zzcew
                        public final void zza() {
                        }
                    });
                }
            }
            com.google.android.gms.ads.internal.util.zze.zza("refreshIfDestroyed: Lock released");
            zzbri zzbriVar2 = this.zzh;
            if (zzbriVar2 != null && zzbriVar2.zze() != -1) {
                int i = this.zzi;
                if (i == 0) {
                    com.google.android.gms.ads.internal.util.zze.zza("getEngine (NO_UPDATE): Lock released");
                    return this.zzh.zza();
                }
                if (i != 1) {
                    com.google.android.gms.ads.internal.util.zze.zza("getEngine (UPDATING): Lock released");
                    return this.zzh.zza();
                }
                this.zzi = 2;
                zzd(null);
                com.google.android.gms.ads.internal.util.zze.zza("getEngine (PENDING_UPDATE): Lock released");
                return this.zzh.zza();
            }
            this.zzi = 2;
            this.zzh = zzd(null);
            com.google.android.gms.ads.internal.util.zze.zza("getEngine (NULL or REJECTED): Lock released");
            return this.zzh.zza();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzbri zzd(zzavi zzaviVar) {
        zzfmo zza = zzfmn.zza(this.zzb, 6);
        zza.zzh();
        final zzbri zzbriVar = new zzbri(this.zzg);
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before UI_THREAD_EXECUTOR");
        final zzavi zzaviVar2 = null;
        zzcep.zze.execute(new Runnable(zzaviVar2, zzbriVar) { // from class: com.google.android.gms.internal.ads.zzbqt
            public final /* synthetic */ zzbri zzb;

            {
                this.zzb = zzbriVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbrj.this.zzj(null, this.zzb);
            }
        });
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine: Promise created");
        zzbriVar.zzi(new zzbqy(this, zzbriVar, zza), new zzbqz(this, zzbriVar, zza));
        return zzbriVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(zzbri zzbriVar, final zzbqe zzbqeVar, ArrayList arrayList, long j) {
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Trying to acquire lock");
        synchronized (this.zza) {
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock acquired");
            if (zzbriVar.zze() != -1 && zzbriVar.zze() != 1) {
                zzbriVar.zzg();
                zzgey zzgeyVar = zzcep.zze;
                Objects.requireNonNull(zzbqeVar);
                zzgeyVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbqr
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzbqe.this.zzc();
                    }
                });
                com.google.android.gms.ads.internal.util.zze.zza("Could not receive /jsLoaded in " + String.valueOf(com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzc)) + " ms. JS engine session reference status(onEngLoadedTimeout) is " + zzbriVar.zze() + ". Update status(onEngLoadedTimeout) is " + this.zzi + ". LoadNewJavascriptEngine(onEngLoadedTimeout) latency is " + String.valueOf(arrayList.get(0)) + " ms. Total latency(onEngLoadedTimeout) is " + (com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - j) + " ms. Rejecting.");
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released");
                return;
            }
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released, the promise is already settled");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(zzavi zzaviVar, zzbri zzbriVar) {
        long currentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        try {
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before createJavascriptEngine");
            zzbqm zzbqmVar = new zzbqm(this.zzb, this.zzd, null, null);
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > After createJavascriptEngine");
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before setting new engine loaded listener");
            zzbqmVar.zzk(new zzbqs(this, arrayList, currentTimeMillis, zzbriVar, zzbqmVar));
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before registering GmsgHandler for /jsLoaded");
            zzbqmVar.zzq("/jsLoaded", new zzbqu(this, currentTimeMillis, zzbriVar, zzbqmVar));
            com.google.android.gms.ads.internal.util.zzcc zzccVar = new com.google.android.gms.ads.internal.util.zzcc();
            zzbqv zzbqvVar = new zzbqv(this, null, zzbqmVar, zzccVar);
            zzccVar.zzb(zzbqvVar);
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before registering GmsgHandler for /requestReload");
            zzbqmVar.zzq("/requestReload", zzbqvVar);
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > javascriptPath: ".concat(String.valueOf(this.zzc)));
            if (this.zzc.endsWith(".js")) {
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before newEngine.loadJavascript");
                zzbqmVar.zzh(this.zzc);
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > After newEngine.loadJavascript");
            } else if (this.zzc.startsWith("<html>")) {
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before newEngine.loadHtml");
                zzbqmVar.zzf(this.zzc);
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > After newEngine.loadHtml");
            } else {
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before newEngine.loadHtmlWrapper");
                zzbqmVar.zzg(this.zzc);
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > After newEngine.loadHtmlWrapper");
            }
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before calling ADMOB_UI_HANDLER.postDelayed");
            com.google.android.gms.ads.internal.util.zzt.zza.postDelayed(new zzbqx(this, zzbriVar, zzbqmVar, arrayList, currentTimeMillis), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzd)).intValue());
        } catch (Throwable th) {
            zzcec.zzh("Error creating webview.", th);
            com.google.android.gms.ads.internal.zzt.zzo().zzw(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzbriVar.zzg();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(zzbqe zzbqeVar) {
        if (zzbqeVar.zzi()) {
            this.zzi = 1;
        }
    }
}

package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzavb implements zzave {
    private static zzavb zzb;
    private final Context zzc;
    private final zzfsg zzd;
    private final zzfsn zze;
    private final zzfsp zzf;
    private final zzawd zzg;
    private final zzfqr zzh;
    private final Executor zzi;
    private final zzfsm zzj;
    private final zzaws zzl;
    private final zzawk zzm;
    private final zzawb zzn;
    private volatile boolean zzp;
    private volatile boolean zzq;
    private final int zzr;
    volatile long zza = 0;
    private final Object zzo = new Object();
    private final CountDownLatch zzk = new CountDownLatch(1);

    zzavb(Context context, zzfqr zzfqrVar, zzfsg zzfsgVar, zzfsn zzfsnVar, zzfsp zzfspVar, zzawd zzawdVar, Executor executor, zzfqm zzfqmVar, int i, zzaws zzawsVar, zzawk zzawkVar, zzawb zzawbVar) {
        this.zzq = false;
        this.zzc = context;
        this.zzh = zzfqrVar;
        this.zzd = zzfsgVar;
        this.zze = zzfsnVar;
        this.zzf = zzfspVar;
        this.zzg = zzawdVar;
        this.zzi = executor;
        this.zzr = i;
        this.zzl = zzawsVar;
        this.zzm = zzawkVar;
        this.zzn = zzawbVar;
        this.zzq = false;
        this.zzj = new zzauz(this, zzfqmVar);
    }

    public static synchronized zzavb zza(String str, Context context, boolean z, boolean z2) {
        zzavb zzb2;
        synchronized (zzavb.class) {
            zzb2 = zzb(str, context, Executors.newCachedThreadPool(), z, z2);
        }
        return zzb2;
    }

    @Deprecated
    public static synchronized zzavb zzb(String str, Context context, Executor executor, boolean z, boolean z2) {
        zzavb zzavbVar;
        synchronized (zzavb.class) {
            if (zzb == null) {
                zzfqs zza = zzfqt.zza();
                zza.zza(str);
                zza.zzc(z);
                zzfqt zzd = zza.zzd();
                zzfqr zza2 = zzfqr.zza(context, executor, z2);
                zzavm zzc = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdi)).booleanValue() ? zzavm.zzc(context) : null;
                zzaws zzd2 = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdj)).booleanValue() ? zzaws.zzd(context, executor) : null;
                zzawk zzawkVar = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcx)).booleanValue() ? new zzawk() : null;
                zzawb zzawbVar = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcz)).booleanValue() ? new zzawb() : null;
                zzfrk zze = zzfrk.zze(context, executor, zza2, zzd);
                zzawc zzawcVar = new zzawc(context);
                zzawd zzawdVar = new zzawd(zzd, zze, new zzawq(context, zzawcVar), zzawcVar, zzc, zzd2, zzawkVar, zzawbVar);
                int zzb2 = zzfrt.zzb(context, zza2);
                zzfqm zzfqmVar = new zzfqm();
                zzavb zzavbVar2 = new zzavb(context, zza2, new zzfsg(context, zzb2), new zzfsn(context, zzb2, new zzauy(zza2), ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcg)).booleanValue()), new zzfsp(context, zzawdVar, zza2, zzfqmVar), zzawdVar, executor, zzfqmVar, zzb2, zzd2, zzawkVar, zzawbVar);
                zzb = zzavbVar2;
                zzavbVar2.zzm();
                zzb.zzp();
            }
            zzavbVar = zzb;
        }
        return zzavbVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009a, code lost:
    
        if (r4.zzd().zzj().equals(r5.zzj()) != false) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* bridge */ /* synthetic */ void zzj(com.google.android.gms.internal.ads.zzavb r12) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzavb.zzj(com.google.android.gms.internal.ads.zzavb):void");
    }

    private final void zzs() {
        zzaws zzawsVar = this.zzl;
        if (zzawsVar != null) {
            zzawsVar.zzh();
        }
    }

    private final zzfsf zzt(int i) {
        if (!zzfrt.zza(this.zzr)) {
            return null;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzce)).booleanValue()) {
            return this.zze.zzc(1);
        }
        return this.zzd.zzc(1);
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final String zze(Context context, String str, View view) {
        return zzf(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final String zzf(Context context, String str, View view, Activity activity) {
        zzs();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcx)).booleanValue()) {
            this.zzm.zzi();
        }
        zzp();
        zzfqu zza = this.zzf.zza();
        if (zza == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zza2 = zza.zza(context, null, str, view, activity);
        this.zzh.zzf(5000, System.currentTimeMillis() - currentTimeMillis, zza2, null);
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final String zzg(Context context) {
        zzs();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcx)).booleanValue()) {
            this.zzm.zzj();
        }
        zzp();
        zzfqu zza = this.zzf.zza();
        if (zza == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzc = zza.zzc(context, null);
        this.zzh.zzf(5001, System.currentTimeMillis() - currentTimeMillis, zzc, null);
        return zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final String zzh(Context context, View view, Activity activity) {
        zzs();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcx)).booleanValue()) {
            this.zzm.zzk(context, view);
        }
        zzp();
        zzfqu zza = this.zzf.zza();
        if (zza == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzb2 = zza.zzb(context, null, view, activity);
        this.zzh.zzf(5002, System.currentTimeMillis() - currentTimeMillis, zzb2, null);
        return zzb2;
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final void zzk(MotionEvent motionEvent) {
        zzfqu zza = this.zzf.zza();
        if (zza != null) {
            try {
                zza.zzd(null, motionEvent);
            } catch (zzfso e) {
                this.zzh.zzc(e.zza(), -1L, e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final void zzl(int i, int i2, int i3) {
        DisplayMetrics displayMetrics;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlp)).booleanValue() || (displayMetrics = this.zzc.getResources().getDisplayMetrics()) == null) {
            return;
        }
        float f = i;
        float f2 = i2;
        MotionEvent obtain = MotionEvent.obtain(0L, 0L, 0, displayMetrics.density * f, displayMetrics.density * f2, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(obtain);
        obtain.recycle();
        MotionEvent obtain2 = MotionEvent.obtain(0L, 0L, 2, f * displayMetrics.density, f2 * displayMetrics.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(obtain2);
        obtain2.recycle();
        MotionEvent obtain3 = MotionEvent.obtain(0L, i3, 1, f * displayMetrics.density, f2 * displayMetrics.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(obtain3);
        obtain3.recycle();
    }

    final synchronized void zzm() {
        long currentTimeMillis = System.currentTimeMillis();
        zzfsf zzt = zzt(1);
        if (zzt != null) {
            if (this.zzf.zzc(zzt)) {
                this.zzq = true;
                this.zzk.countDown();
                return;
            }
            return;
        }
        this.zzh.zzd(4013, System.currentTimeMillis() - currentTimeMillis);
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzawb zzawbVar = this.zzn;
        if (zzawbVar != null) {
            zzawbVar.zzb(Arrays.asList(stackTraceElementArr));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final void zzo(View view) {
        this.zzg.zzd(view);
    }

    public final void zzp() {
        if (this.zzp) {
            return;
        }
        synchronized (this.zzo) {
            if (!this.zzp) {
                if ((System.currentTimeMillis() / 1000) - this.zza < 3600) {
                    return;
                }
                zzfsf zzb2 = this.zzf.zzb();
                if ((zzb2 == null || zzb2.zzd(3600L)) && zzfrt.zza(this.zzr)) {
                    this.zzi.execute(new zzava(this));
                }
            }
        }
    }

    public final synchronized boolean zzr() {
        return this.zzq;
    }
}

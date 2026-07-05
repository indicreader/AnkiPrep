package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.RemoteException;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfnc implements Runnable {
    public static Boolean zzb;
    private final Context zze;
    private final zzcei zzf;
    private int zzi;
    private final zzdtx zzj;
    private final List zzk;
    private final zzefb zzm;
    private final zzbzq zzn;
    public static final Object zza = new Object();
    private static final Object zzc = new Object();
    private static final Object zzd = new Object();
    private final zzfnh zzg = zzfnk.zzc();
    private String zzh = "";
    private boolean zzl = false;

    public zzfnc(Context context, zzcei zzceiVar, zzdtx zzdtxVar, zzefb zzefbVar, zzbzq zzbzqVar) {
        this.zze = context;
        this.zzf = zzceiVar;
        this.zzj = zzdtxVar;
        this.zzm = zzefbVar;
        this.zzn = zzbzqVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziJ)).booleanValue()) {
            this.zzk = com.google.android.gms.ads.internal.util.zzt.zzd();
        } else {
            this.zzk = zzgaa.zzl();
        }
    }

    public static boolean zza() {
        boolean booleanValue;
        synchronized (zza) {
            if (zzb == null) {
                if (((Boolean) zzbht.zzb.zze()).booleanValue()) {
                    zzb = Boolean.valueOf(Math.random() < ((Double) zzbht.zza.zze()).doubleValue());
                } else {
                    zzb = false;
                }
            }
            booleanValue = zzb.booleanValue();
        }
        return booleanValue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte[] zzax;
        if (zza()) {
            Object obj = zzc;
            synchronized (obj) {
                if (this.zzg.zza() == 0) {
                    return;
                }
                try {
                    synchronized (obj) {
                        zzax = ((zzfnk) this.zzg.zzal()).zzax();
                        this.zzg.zzc();
                    }
                    new zzefa(this.zze, this.zzf.zza, this.zzn, Binder.getCallingUid()).zza(new zzeey((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziD), 60000, new HashMap(), zzax, "application/x-protobuf", false));
                } catch (Exception e) {
                    if ((e instanceof zzead) && ((zzead) e).zza() == 3) {
                        return;
                    }
                    com.google.android.gms.ads.internal.zzt.zzo().zzv(e, "CuiMonitor.sendCuiPing");
                }
            }
        }
    }

    public final void zzb(final zzfms zzfmsVar) {
        zzcep.zza.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfnb
            @Override // java.lang.Runnable
            public final void run() {
                zzfnc.this.zzc(zzfmsVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzfms zzfmsVar) {
        synchronized (zzd) {
            if (!this.zzl) {
                this.zzl = true;
                if (zza()) {
                    try {
                        com.google.android.gms.ads.internal.zzt.zzp();
                        this.zzh = com.google.android.gms.ads.internal.util.zzt.zzp(this.zze);
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "CuiMonitor.gettingAppIdFromManifest");
                    }
                    this.zzi = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zze);
                    int intValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziE)).intValue();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlk)).booleanValue()) {
                        long j = intValue;
                        zzcep.zzd.scheduleWithFixedDelay(this, j, j, TimeUnit.MILLISECONDS);
                    } else {
                        long j2 = intValue;
                        zzcep.zzd.scheduleAtFixedRate(this, j2, j2, TimeUnit.MILLISECONDS);
                    }
                }
            }
        }
        if (zza() && zzfmsVar != null) {
            synchronized (zzc) {
                if (this.zzg.zza() >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziF)).intValue()) {
                    return;
                }
                zzfne zza2 = zzfnf.zza();
                zza2.zzt(zzfmsVar.zzl());
                zza2.zzp(zzfmsVar.zzk());
                zza2.zzg(zzfmsVar.zzb());
                zza2.zzv(3);
                zza2.zzm(this.zzf.zza);
                zza2.zzb(this.zzh);
                zza2.zzk(Build.VERSION.RELEASE);
                zza2.zzq(Build.VERSION.SDK_INT);
                zza2.zzu(zzfmsVar.zzn());
                zza2.zzj(zzfmsVar.zza());
                zza2.zze(this.zzi);
                zza2.zzs(zzfmsVar.zzm());
                zza2.zzc(zzfmsVar.zzd());
                zza2.zzf(zzfmsVar.zzf());
                zza2.zzh(zzfmsVar.zzg());
                zza2.zzi(this.zzj.zzc(zzfmsVar.zzg()));
                zza2.zzl(zzfmsVar.zzh());
                zza2.zzd(zzfmsVar.zze());
                zza2.zzr(zzfmsVar.zzj());
                zza2.zzn(zzfmsVar.zzi());
                zza2.zzo(zzfmsVar.zzc());
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziJ)).booleanValue()) {
                    zza2.zza(this.zzk);
                }
                zzfnh zzfnhVar = this.zzg;
                zzfni zza3 = zzfnj.zza();
                zza3.zza(zza2);
                zzfnhVar.zzb(zza3);
            }
        }
    }
}

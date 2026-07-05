package com.google.android.gms.internal.mlkit_vision_text_common;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
public final class zzrd {
    private static zzbn zza;
    private static final zzbp zzb = zzbp.zzc("optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID);
    private final String zzc;
    private final String zzd;
    private final zzqt zze;
    private final SharedPrefManager zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;
    private final Map zzk = new HashMap();
    private final Map zzl = new HashMap();

    public zzrd(Context context, final SharedPrefManager sharedPrefManager, zzqt zzqtVar, String str) {
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zzqtVar;
        zzrp.zza();
        this.zzi = str;
        this.zzg = MLTaskExecutor.getInstance().scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_text_common.zzqx
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzrd.this.zzb();
            }
        });
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzh = mLTaskExecutor.scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_text_common.zzqy
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SharedPrefManager.this.getMlSdkInstanceId();
            }
        });
        zzbp zzbpVar = zzb;
        this.zzj = zzbpVar.containsKey(str) ? DynamiteModule.getRemoteVersion(context, (String) zzbpVar.get(str)) : -1;
    }

    static long zza(List list, double d) {
        return ((Long) list.get(Math.max(((int) Math.ceil((d / 100.0d) * list.size())) - 1, 0))).longValue();
    }

    private static synchronized zzbn zzi() {
        synchronized (zzrd.class) {
            zzbn zzbnVar = zza;
            if (zzbnVar != null) {
                return zzbnVar;
            }
            LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
            zzbk zzbkVar = new zzbk();
            for (int i = 0; i < locales.size(); i++) {
                zzbkVar.zza(CommonUtils.languageTagFromLocale(locales.get(i)));
            }
            zzbn zzb2 = zzbkVar.zzb();
            zza = zzb2;
            return zzb2;
        }
    }

    private final String zzj() {
        if (this.zzg.isSuccessful()) {
            return (String) this.zzg.getResult();
        }
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    private final boolean zzk(zzmw zzmwVar, long j, long j2) {
        return this.zzk.get(zzmwVar) == null || j - ((Long) this.zzk.get(zzmwVar)).longValue() > TimeUnit.SECONDS.toMillis(30L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zzb() throws Exception {
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzqs zzqsVar, zzmw zzmwVar, String str) {
        String mlSdkInstanceId;
        zzqsVar.zzb(zzmwVar);
        String zzd = zzqsVar.zzd();
        zzps zzpsVar = new zzps();
        zzpsVar.zzb(this.zzc);
        zzpsVar.zzc(this.zzd);
        zzpsVar.zzh(zzi());
        zzpsVar.zzg(true);
        zzpsVar.zzl(zzd);
        zzpsVar.zzj(str);
        if (this.zzh.isSuccessful()) {
            mlSdkInstanceId = (String) this.zzh.getResult();
        } else {
            mlSdkInstanceId = this.zzf.getMlSdkInstanceId();
        }
        zzpsVar.zzi(mlSdkInstanceId);
        zzpsVar.zzd(10);
        zzpsVar.zzk(Integer.valueOf(this.zzj));
        zzqsVar.zzc(zzpsVar);
        this.zze.zza(zzqsVar);
    }

    public final void zzd(zzqs zzqsVar, zzmw zzmwVar) {
        zze(zzqsVar, zzmwVar, zzj());
    }

    public final void zze(final zzqs zzqsVar, final zzmw zzmwVar, final String str) {
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_text_common.zzqz
            @Override // java.lang.Runnable
            public final void run() {
                zzrd.this.zzc(zzqsVar, zzmwVar, str);
            }
        });
    }

    public final void zzf(zzrc zzrcVar, zzmw zzmwVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zzk(zzmwVar, elapsedRealtime, 30L)) {
            this.zzk.put(zzmwVar, Long.valueOf(elapsedRealtime));
            zze(zzrcVar.zza(), zzmwVar, zzj());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzmw zzmwVar, com.google.mlkit.vision.text.internal.zzp zzpVar) {
        zzbs zzbsVar = (zzbs) this.zzl.get(zzmwVar);
        if (zzbsVar != null) {
            for (Object obj : zzbsVar.zzo()) {
                ArrayList arrayList = new ArrayList(zzbsVar.zzc(obj));
                Collections.sort(arrayList);
                zzlz zzlzVar = new zzlz();
                Iterator it = arrayList.iterator();
                long j = 0;
                while (it.hasNext()) {
                    j += ((Long) it.next()).longValue();
                }
                zzlzVar.zza(Long.valueOf(j / arrayList.size()));
                zzlzVar.zzc(Long.valueOf(zza(arrayList, 100.0d)));
                zzlzVar.zzf(Long.valueOf(zza(arrayList, 75.0d)));
                zzlzVar.zzd(Long.valueOf(zza(arrayList, 50.0d)));
                zzlzVar.zzb(Long.valueOf(zza(arrayList, 25.0d)));
                zzlzVar.zze(Long.valueOf(zza(arrayList, 0.0d)));
                zze(zzpVar.zza(obj, arrayList.size(), zzlzVar.zzg()), zzmwVar, zzj());
            }
            this.zzl.remove(zzmwVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(final zzmw zzmwVar, Object obj, long j, final com.google.mlkit.vision.text.internal.zzp zzpVar) {
        if (!this.zzl.containsKey(zzmwVar)) {
            this.zzl.put(zzmwVar, zzar.zzp());
        }
        ((zzbs) this.zzl.get(zzmwVar)).zzm(obj, Long.valueOf(j));
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zzk(zzmwVar, elapsedRealtime, 30L)) {
            this.zzk.put(zzmwVar, Long.valueOf(elapsedRealtime));
            MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_text_common.zzrb
                @Override // java.lang.Runnable
                public final void run() {
                    zzrd.this.zzg(zzmwVar, zzpVar);
                }
            });
        }
    }
}

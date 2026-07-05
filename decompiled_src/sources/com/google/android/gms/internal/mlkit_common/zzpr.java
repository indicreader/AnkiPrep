package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes3.dex */
public final class zzpr {
    private static zzar zza;
    private static final zzau zzb = zzau.zzc("optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID);
    private final String zzc;
    private final String zzd;
    private final zzpj zze;
    private final SharedPrefManager zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;
    private final Map zzk = new HashMap();
    private final Map zzl = new HashMap();

    public zzpr(Context context, final SharedPrefManager sharedPrefManager, zzpj zzpjVar, String str) {
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zzpjVar;
        zzqf.zza();
        this.zzi = str;
        this.zzg = MLTaskExecutor.getInstance().scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzpn
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzpr.this.zza();
            }
        });
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzh = mLTaskExecutor.scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzpo
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SharedPrefManager.this.getMlSdkInstanceId();
            }
        });
        zzau zzauVar = zzb;
        this.zzj = zzauVar.containsKey(str) ? DynamiteModule.getRemoteVersion(context, (String) zzauVar.get(str)) : -1;
    }

    private static synchronized zzar zzh() {
        synchronized (zzpr.class) {
            zzar zzarVar = zza;
            if (zzarVar != null) {
                return zzarVar;
            }
            LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
            zzao zzaoVar = new zzao();
            for (int i = 0; i < locales.size(); i++) {
                zzaoVar.zzb(CommonUtils.languageTagFromLocale(locales.get(i)));
            }
            zzar zzc = zzaoVar.zzc();
            zza = zzc;
            return zzc;
        }
    }

    private final zzod zzi(String str, String str2) {
        String mlSdkInstanceId;
        zzod zzodVar = new zzod();
        zzodVar.zzb(this.zzc);
        zzodVar.zzc(this.zzd);
        zzodVar.zzh(zzh());
        zzodVar.zzg(true);
        zzodVar.zzl(str);
        zzodVar.zzj(str2);
        if (this.zzh.isSuccessful()) {
            mlSdkInstanceId = (String) this.zzh.getResult();
        } else {
            mlSdkInstanceId = this.zzf.getMlSdkInstanceId();
        }
        zzodVar.zzi(mlSdkInstanceId);
        zzodVar.zzd(10);
        zzodVar.zzk(Integer.valueOf(this.zzj));
        return zzodVar;
    }

    private final String zzj() {
        if (this.zzg.isSuccessful()) {
            return (String) this.zzg.getResult();
        }
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zza() throws Exception {
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzpi zzpiVar, zzlf zzlfVar, String str) {
        zzpiVar.zza(zzlfVar);
        zzpiVar.zzc(zzi(zzpiVar.zzd(), str));
        this.zze.zza(zzpiVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzpi zzpiVar, zzpt zzptVar, RemoteModel remoteModel) {
        zzpiVar.zza(zzlf.MODEL_DOWNLOAD);
        zzpiVar.zzc(zzi(zzptVar.zze(), zzj()));
        zzpiVar.zzb(zzqd.zza(remoteModel, this.zzf, zzptVar));
        this.zze.zza(zzpiVar);
    }

    public final void zzd(final zzpi zzpiVar, final zzlf zzlfVar) {
        final String zzj = zzj();
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_common.zzpp
            @Override // java.lang.Runnable
            public final void run() {
                zzpr.this.zzb(zzpiVar, zzlfVar, zzj);
            }
        });
    }

    public final void zze(zzpi zzpiVar, RemoteModel remoteModel, boolean z, int i) {
        zzps zzh = zzpt.zzh();
        zzh.zzf(false);
        zzh.zzd(remoteModel.getModelType());
        zzh.zza(zzlk.FAILED);
        zzh.zzb(zzle.DOWNLOAD_FAILED);
        zzh.zzc(i);
        zzg(zzpiVar, remoteModel, zzh.zzh());
    }

    public final void zzf(zzpi zzpiVar, RemoteModel remoteModel, zzle zzleVar, boolean z, ModelType modelType, zzlk zzlkVar) {
        zzps zzh = zzpt.zzh();
        zzh.zzf(z);
        zzh.zzd(modelType);
        zzh.zzb(zzleVar);
        zzh.zza(zzlkVar);
        zzg(zzpiVar, remoteModel, zzh.zzh());
    }

    public final void zzg(final zzpi zzpiVar, final RemoteModel remoteModel, final zzpt zzptVar) {
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_common.zzpq
            @Override // java.lang.Runnable
            public final void run() {
                zzpr.this.zzc(zzpiVar, zzptVar, remoteModel);
            }
        });
    }
}

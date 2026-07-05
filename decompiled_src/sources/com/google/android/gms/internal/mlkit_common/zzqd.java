package com.google.android.gms.internal.mlkit_common;

import android.os.SystemClock;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes3.dex */
public final class zzqd {
    private static final GmsLogger zza = new GmsLogger("RemoteModelUtils", "");

    public static zzlm zza(RemoteModel remoteModel, SharedPrefManager sharedPrefManager, zzpt zzptVar) {
        zzlo zzloVar;
        ModelType zzb = zzptVar.zzb();
        String modelHash = remoteModel.getModelHash();
        zzls zzlsVar = new zzls();
        zzln zzlnVar = new zzln();
        zzlnVar.zzc(remoteModel.getModelNameForBackend());
        zzlnVar.zzd(zzlp.CLOUD);
        zzlnVar.zza(zzag.zzb(modelHash));
        int ordinal = zzb.ordinal();
        if (ordinal == 2) {
            zzloVar = zzlo.BASE_TRANSLATE;
        } else if (ordinal == 4) {
            zzloVar = zzlo.CUSTOM;
        } else if (ordinal == 5) {
            zzloVar = zzlo.BASE_DIGITAL_INK;
        } else {
            zzloVar = zzlo.TYPE_UNKNOWN;
        }
        zzlnVar.zzb(zzloVar);
        zzlsVar.zzb(zzlnVar.zzg());
        zzlv zzc = zzlsVar.zzc();
        zzlj zzljVar = new zzlj();
        zzljVar.zzd(zzptVar.zzc());
        zzljVar.zzc(zzptVar.zzd());
        zzljVar.zzb(Long.valueOf(zzptVar.zza()));
        zzljVar.zzf(zzc);
        if (zzptVar.zzg()) {
            long modelDownloadBeginTimeMs = sharedPrefManager.getModelDownloadBeginTimeMs(remoteModel);
            if (modelDownloadBeginTimeMs == 0) {
                zza.w("RemoteModelUtils", "Model downloaded without its beginning time recorded.");
            } else {
                long modelFirstUseTimeMs = sharedPrefManager.getModelFirstUseTimeMs(remoteModel);
                if (modelFirstUseTimeMs == 0) {
                    modelFirstUseTimeMs = SystemClock.elapsedRealtime();
                    sharedPrefManager.setModelFirstUseTimeMs(remoteModel, modelFirstUseTimeMs);
                }
                zzljVar.zzg(Long.valueOf(modelFirstUseTimeMs - modelDownloadBeginTimeMs));
            }
        }
        if (zzptVar.zzf()) {
            long modelDownloadBeginTimeMs2 = sharedPrefManager.getModelDownloadBeginTimeMs(remoteModel);
            if (modelDownloadBeginTimeMs2 == 0) {
                zza.w("RemoteModelUtils", "Model downloaded without its beginning time recorded.");
            } else {
                zzljVar.zze(Long.valueOf(SystemClock.elapsedRealtime() - modelDownloadBeginTimeMs2));
            }
        }
        return zzljVar.zzi();
    }
}

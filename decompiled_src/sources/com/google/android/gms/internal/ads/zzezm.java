package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Tasks;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzezm implements zzexq {
    private final zzcdl zza;
    private final String zzb;
    private final ScheduledExecutorService zzc;
    private final zzgey zzd;
    private final zzbas zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzezm(String str, zzbas zzbasVar, zzcdl zzcdlVar, ScheduledExecutorService scheduledExecutorService, zzgey zzgeyVar) {
        this.zzb = str;
        this.zze = zzbasVar;
        this.zza = zzcdlVar;
        this.zzc = scheduledExecutorService;
        this.zzd = zzgeyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 43;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcC)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcH)).booleanValue()) {
                ListenableFuture zzn = zzgen.zzn(zzfui.zza(Tasks.forResult(null), null), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzezk
                    @Override // com.google.android.gms.internal.ads.zzgdu
                    public final ListenableFuture zza(Object obj) {
                        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
                        if (appSetIdInfo == null) {
                            return zzgen.zzh(new zzezn(null, -1));
                        }
                        return zzgen.zzh(new zzezn(appSetIdInfo.getId(), appSetIdInfo.getScope()));
                    }
                }, this.zzd);
                if (((Boolean) zzbhp.zza.zze()).booleanValue()) {
                    zzn = zzgen.zzo(zzn, ((Long) zzbhp.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzc);
                }
                return zzgen.zze(zzn, Exception.class, new zzfws() { // from class: com.google.android.gms.internal.ads.zzezl
                    @Override // com.google.android.gms.internal.ads.zzfws
                    public final Object apply(Object obj) {
                        return zzezm.this.zzc((Exception) obj);
                    }
                }, this.zzd);
            }
        }
        return zzgen.zzh(new zzezn(null, -1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzezn zzc(Exception exc) {
        this.zza.zzw(exc, "AppSetIdInfoGmscoreSignal");
        return new zzezn(null, -1);
    }
}

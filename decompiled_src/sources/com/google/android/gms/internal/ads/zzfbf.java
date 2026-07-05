package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfbf implements zzexq {
    private final zzcdl zza;
    private final boolean zzb;
    private final boolean zzc;
    private final ScheduledExecutorService zzd;
    private final zzgey zze;
    private final String zzf;
    private final zzcda zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfbf(zzcdl zzcdlVar, boolean z, boolean z2, zzcda zzcdaVar, zzgey zzgeyVar, String str, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzcdlVar;
        this.zzb = z;
        this.zzc = z2;
        this.zzg = zzcdaVar;
        this.zze = zzgeyVar;
        this.zzf = str;
        this.zzd = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 50;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhh)).booleanValue() && this.zzc) {
            return zzgen.zzh(null);
        }
        if (this.zzb) {
            return zzgen.zze(zzgen.zzo(zzgen.zzm(zzgen.zzh(null), new zzfws() { // from class: com.google.android.gms.internal.ads.zzfbd
                @Override // com.google.android.gms.internal.ads.zzfws
                public final Object apply(Object obj) {
                    String str = (String) obj;
                    if (str == null) {
                        return null;
                    }
                    return new zzfbg(str);
                }
            }, this.zze), ((Long) zzbio.zzc.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzd), Exception.class, new zzfws() { // from class: com.google.android.gms.internal.ads.zzfbe
                @Override // com.google.android.gms.internal.ads.zzfws
                public final Object apply(Object obj) {
                    zzfbf.this.zzc((Exception) obj);
                    return null;
                }
            }, this.zze);
        }
        return zzgen.zzh(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfbg zzc(Exception exc) {
        this.zza.zzw(exc, "TrustlessTokenSignal");
        return null;
    }
}

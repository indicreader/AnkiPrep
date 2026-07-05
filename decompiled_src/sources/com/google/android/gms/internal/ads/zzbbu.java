package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbbu {
    final /* synthetic */ zzbbv zza;
    private final byte[] zzb;
    private int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbbu(zzbbv zzbbvVar, byte[] bArr, zzbbt zzbbtVar) {
        this.zza = zzbbvVar;
        this.zzb = bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzd() {
        try {
            zzbbv zzbbvVar = this.zza;
            if (zzbbvVar.zzb) {
                zzbbvVar.zza.zzj(this.zzb);
                this.zza.zza.zzi(0);
                this.zza.zza.zzg(this.zzc);
                this.zza.zza.zzh(null);
                this.zza.zza.zzf();
            }
        } catch (RemoteException e) {
            zzcec.zzf("Clearcut log failed", e);
        }
    }

    public final zzbbu zza(int i) {
        this.zzc = i;
        return this;
    }

    public final synchronized void zzc() {
        ExecutorService executorService;
        executorService = this.zza.zzc;
        executorService.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbbs
            @Override // java.lang.Runnable
            public final void run() {
                zzbbu.this.zzd();
            }
        });
    }
}

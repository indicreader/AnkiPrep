package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbbj implements BaseGmsClient.BaseConnectionCallbacks {
    public static final /* synthetic */ int zzd = 0;
    final /* synthetic */ zzbbb zza;
    final /* synthetic */ zzceu zzb;
    final /* synthetic */ zzbbl zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbbj(zzbbl zzbblVar, zzbbb zzbbbVar, zzceu zzceuVar) {
        this.zza = zzbbbVar;
        this.zzb = zzceuVar;
        this.zzc = zzbblVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Object obj;
        boolean z;
        final zzbba zzbbaVar;
        obj = this.zzc.zzd;
        synchronized (obj) {
            zzbbl zzbblVar = this.zzc;
            z = zzbblVar.zzb;
            if (z) {
                return;
            }
            zzbblVar.zzb = true;
            zzbbaVar = this.zzc.zza;
            if (zzbbaVar == null) {
                return;
            }
            zzgey zzgeyVar = zzcep.zza;
            final zzbbb zzbbbVar = this.zza;
            final zzceu zzceuVar = this.zzb;
            final ListenableFuture zza = zzgeyVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbbg
                @Override // java.lang.Runnable
                public final void run() {
                    zzbay zzf;
                    zzbbj zzbbjVar = zzbbj.this;
                    zzbba zzbbaVar2 = zzbbaVar;
                    zzceu zzceuVar2 = zzceuVar;
                    try {
                        zzbbd zzq = zzbbaVar2.zzq();
                        boolean zzp = zzbbaVar2.zzp();
                        zzbbb zzbbbVar2 = zzbbbVar;
                        if (zzp) {
                            zzf = zzq.zzg(zzbbbVar2);
                        } else {
                            zzf = zzq.zzf(zzbbbVar2);
                        }
                        if (!zzf.zze()) {
                            zzceuVar2.zzd(new RuntimeException("No entry contents."));
                            zzbbl.zze(zzbbjVar.zzc);
                            return;
                        }
                        zzbbi zzbbiVar = new zzbbi(zzbbjVar, zzf.zzc(), 1);
                        int read = zzbbiVar.read();
                        if (read == -1) {
                            throw new IOException("Unable to read from cache.");
                        }
                        zzbbiVar.unread(read);
                        zzceuVar2.zzc(zzbbn.zzb(zzbbiVar, zzf.zzd(), zzf.zzg(), zzf.zza(), zzf.zzf()));
                    } catch (RemoteException | IOException e) {
                        zzcec.zzh("Unable to obtain a cache service instance.", e);
                        zzceuVar2.zzd(e);
                        zzbbl.zze(zzbbjVar.zzc);
                    }
                }
            });
            final zzceu zzceuVar2 = this.zzb;
            zzceuVar2.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbbh
                @Override // java.lang.Runnable
                public final void run() {
                    int i = zzbbj.zzd;
                    if (zzceu.this.isCancelled()) {
                        zza.cancel(true);
                    }
                }
            }, zzcep.zzf);
        }
    }
}

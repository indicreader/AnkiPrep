package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcvn extends zzcuf {
    private final zzbld zzc;
    private final Runnable zzd;
    private final Executor zze;

    public zzcvn(zzcwg zzcwgVar, zzbld zzbldVar, Runnable runnable, Executor executor) {
        super(zzcwgVar);
        this.zzc = zzbldVar;
        this.zzd = runnable;
        this.zze = executor;
    }

    public static /* synthetic */ void zzi(AtomicReference atomicReference) {
        Runnable runnable = (Runnable) atomicReference.getAndSet(null);
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcuf
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcuf
    public final View zzc() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcuf
    public final com.google.android.gms.ads.internal.client.zzdq zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcuf
    public final zzfgn zze() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcuf
    public final zzfgn zzf() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcuf
    public final void zzg() {
    }

    @Override // com.google.android.gms.internal.ads.zzcuf
    public final void zzh(ViewGroup viewGroup, com.google.android.gms.ads.internal.client.zzq zzqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcwh
    public final void zzj() {
        final zzcvl zzcvlVar = new zzcvl(new AtomicReference(this.zzd));
        this.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcvm
            @Override // java.lang.Runnable
            public final void run() {
                zzcvn.this.zzk(zzcvlVar);
            }
        });
    }

    public final /* synthetic */ void zzk(Runnable runnable) {
        try {
            if (this.zzc.zze(ObjectWrapper.wrap(runnable))) {
                return;
            }
            zzi(((zzcvl) runnable).zza);
        } catch (RemoteException unused) {
            zzi(((zzcvl) runnable).zza);
        }
    }
}

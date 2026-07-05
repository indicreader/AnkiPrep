package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzgdm extends zzgds {
    private static final zzgex zza = new zzgex(zzgdm.class);

    @CheckForNull
    private zzfzv zzb;
    private final boolean zzc;
    private final boolean zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgdm(zzfzv zzfzvVar, boolean z, boolean z2) {
        super(zzfzvVar.size());
        zzfzvVar.getClass();
        this.zzb = zzfzvVar;
        this.zzc = z;
        this.zzf = z2;
    }

    private final void zzG(int i, Future future) {
        try {
            zzf(i, zzgen.zzp(future));
        } catch (ExecutionException e) {
            zzI(e.getCause());
        } catch (Throwable th) {
            zzI(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzH, reason: merged with bridge method [inline-methods] */
    public final void zzx(@CheckForNull zzfzv zzfzvVar) {
        int zzA = zzA();
        int i = 0;
        zzfxe.zzj(zzA >= 0, "Less than 0 remaining futures");
        if (zzA == 0) {
            if (zzfzvVar != null) {
                zzgce it = zzfzvVar.iterator();
                while (it.hasNext()) {
                    Future future = (Future) it.next();
                    if (!future.isCancelled()) {
                        zzG(i, future);
                    }
                    i++;
                }
            }
            zzF();
            zzu();
            zzy(2);
        }
    }

    private static void zzJ(Throwable th) {
        zza.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", true != (th instanceof Error) ? "Got more than one input Future failure. Logging failures after the first" : "Input Future failed with Error", th);
    }

    private static boolean zzK(Set set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgdb
    @CheckForNull
    public final String zza() {
        zzfzv zzfzvVar = this.zzb;
        if (zzfzvVar != null) {
            return "futures=".concat(zzfzvVar.toString());
        }
        return super.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgdb
    protected final void zzb() {
        zzfzv zzfzvVar = this.zzb;
        zzy(1);
        if ((zzfzvVar != null) && isCancelled()) {
            boolean zzt = zzt();
            zzgce it = zzfzvVar.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(zzt);
            }
        }
    }

    abstract void zzf(int i, Object obj);

    abstract void zzu();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzv() {
        Objects.requireNonNull(this.zzb);
        if (this.zzb.isEmpty()) {
            zzu();
            return;
        }
        if (this.zzc) {
            zzgce it = this.zzb.iterator();
            final int i = 0;
            while (it.hasNext()) {
                final ListenableFuture listenableFuture = (ListenableFuture) it.next();
                listenableFuture.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgdk
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzgdm.this.zzw(listenableFuture, i);
                    }
                }, zzgeb.INSTANCE);
                i++;
            }
            return;
        }
        final zzfzv zzfzvVar = this.zzf ? this.zzb : null;
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzgdl
            @Override // java.lang.Runnable
            public final void run() {
                zzgdm.this.zzx(zzfzvVar);
            }
        };
        zzgce it2 = this.zzb.iterator();
        while (it2.hasNext()) {
            ((ListenableFuture) it2.next()).addListener(runnable, zzgeb.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzw(ListenableFuture listenableFuture, int i) {
        try {
            if (listenableFuture.isCancelled()) {
                this.zzb = null;
                cancel(false);
            } else {
                zzG(i, listenableFuture);
            }
        } finally {
            zzx(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zzy(int i) {
        this.zzb = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgds
    final void zze(Set set) {
        set.getClass();
        if (isCancelled()) {
            return;
        }
        zzK(set, (Throwable) Objects.requireNonNull(zzl()));
    }

    private final void zzI(Throwable th) {
        th.getClass();
        if (!this.zzc || zzd(th) || !zzK(zzC(), th)) {
            if (th instanceof Error) {
                zzJ(th);
                return;
            }
            return;
        }
        zzJ(th);
    }
}

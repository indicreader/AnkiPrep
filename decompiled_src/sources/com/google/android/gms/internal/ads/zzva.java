package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzva {
    public final int zza;
    public final zzur zzb;
    private final CopyOnWriteArrayList zzc;

    public zzva() {
        this(new CopyOnWriteArrayList(), 0, null);
    }

    private zzva(CopyOnWriteArrayList copyOnWriteArrayList, int i, zzur zzurVar) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzurVar;
    }

    public final zzva zza(int i, zzur zzurVar) {
        return new zzva(this.zzc, 0, zzurVar);
    }

    public final void zzb(Handler handler, zzvb zzvbVar) {
        this.zzc.add(new zzuz(handler, zzvbVar));
    }

    public final void zzc(final zzun zzunVar) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzuz zzuzVar = (zzuz) it.next();
            final zzvb zzvbVar = zzuzVar.zzb;
            zzfy.zzK(zzuzVar.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zzuu
                @Override // java.lang.Runnable
                public final void run() {
                    zzvbVar.zzae(0, zzva.this.zzb, zzunVar);
                }
            });
        }
    }

    public final void zzd(final zzui zzuiVar, final zzun zzunVar) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzuz zzuzVar = (zzuz) it.next();
            final zzvb zzvbVar = zzuzVar.zzb;
            zzfy.zzK(zzuzVar.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zzuy
                @Override // java.lang.Runnable
                public final void run() {
                    zzvbVar.zzaf(0, zzva.this.zzb, zzuiVar, zzunVar);
                }
            });
        }
    }

    public final void zze(final zzui zzuiVar, final zzun zzunVar) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzuz zzuzVar = (zzuz) it.next();
            final zzvb zzvbVar = zzuzVar.zzb;
            zzfy.zzK(zzuzVar.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zzuw
                @Override // java.lang.Runnable
                public final void run() {
                    zzvbVar.zzag(0, zzva.this.zzb, zzuiVar, zzunVar);
                }
            });
        }
    }

    public final void zzf(final zzui zzuiVar, final zzun zzunVar, final IOException iOException, final boolean z) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzuz zzuzVar = (zzuz) it.next();
            final zzvb zzvbVar = zzuzVar.zzb;
            zzfy.zzK(zzuzVar.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zzux
                @Override // java.lang.Runnable
                public final void run() {
                    zzvbVar.zzah(0, zzva.this.zzb, zzuiVar, zzunVar, iOException, z);
                }
            });
        }
    }

    public final void zzg(final zzui zzuiVar, final zzun zzunVar) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzuz zzuzVar = (zzuz) it.next();
            final zzvb zzvbVar = zzuzVar.zzb;
            zzfy.zzK(zzuzVar.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zzuv
                @Override // java.lang.Runnable
                public final void run() {
                    zzvbVar.zzai(0, zzva.this.zzb, zzuiVar, zzunVar);
                }
            });
        }
    }

    public final void zzh(zzvb zzvbVar) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzuz zzuzVar = (zzuz) it.next();
            if (zzuzVar.zzb == zzvbVar) {
                this.zzc.remove(zzuzVar);
            }
        }
    }
}

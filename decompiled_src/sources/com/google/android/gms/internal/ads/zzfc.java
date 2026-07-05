package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfc {
    private final zzel zza;
    private final zzew zzb;
    private final zzfa zzc;
    private final CopyOnWriteArraySet zzd;
    private final ArrayDeque zze;
    private final ArrayDeque zzf;
    private final Object zzg;
    private boolean zzh;
    private boolean zzi;

    public zzfc(Looper looper, zzel zzelVar, zzfa zzfaVar) {
        this(new CopyOnWriteArraySet(), looper, zzelVar, zzfaVar, true);
    }

    public static /* synthetic */ boolean zzg(zzfc zzfcVar, Message message) {
        Iterator it = zzfcVar.zzd.iterator();
        while (it.hasNext()) {
            ((zzfb) it.next()).zzb(zzfcVar.zzc);
            if (zzfcVar.zzb.zzg(0)) {
                return true;
            }
        }
        return true;
    }

    private final void zzh() {
        if (this.zzi) {
            zzek.zzf(Thread.currentThread() == this.zzb.zza().getThread());
        }
    }

    public final zzfc zza(Looper looper, zzfa zzfaVar) {
        return new zzfc(this.zzd, looper, this.zza, zzfaVar, this.zzi);
    }

    public final void zzb(Object obj) {
        synchronized (this.zzg) {
            if (this.zzh) {
                return;
            }
            this.zzd.add(new zzfb(obj));
        }
    }

    public final void zzc() {
        zzh();
        if (this.zzf.isEmpty()) {
            return;
        }
        if (!this.zzb.zzg(0)) {
            zzew zzewVar = this.zzb;
            zzewVar.zzk(zzewVar.zzb(0));
        }
        boolean z = !this.zze.isEmpty();
        this.zze.addAll(this.zzf);
        this.zzf.clear();
        if (z) {
            return;
        }
        while (!this.zze.isEmpty()) {
            ((Runnable) this.zze.peekFirst()).run();
            this.zze.removeFirst();
        }
    }

    public final void zzd(final int i, final zzez zzezVar) {
        zzh();
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.zzd);
        this.zzf.add(new Runnable() { // from class: com.google.android.gms.internal.ads.zzey
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    zzez zzezVar2 = zzezVar;
                    ((zzfb) it.next()).zza(i, zzezVar2);
                }
            }
        });
    }

    public final void zze() {
        zzh();
        synchronized (this.zzg) {
            this.zzh = true;
        }
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            ((zzfb) it.next()).zzc(this.zzc);
        }
        this.zzd.clear();
    }

    public final void zzf(Object obj) {
        zzh();
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            zzfb zzfbVar = (zzfb) it.next();
            if (zzfbVar.zza.equals(obj)) {
                zzfbVar.zzc(this.zzc);
                this.zzd.remove(zzfbVar);
            }
        }
    }

    private zzfc(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, zzel zzelVar, zzfa zzfaVar, boolean z) {
        this.zza = zzelVar;
        this.zzd = copyOnWriteArraySet;
        this.zzc = zzfaVar;
        this.zzg = new Object();
        this.zze = new ArrayDeque();
        this.zzf = new ArrayDeque();
        this.zzb = zzelVar.zzb(looper, new Handler.Callback() { // from class: com.google.android.gms.internal.ads.zzex
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                zzfc.zzg(zzfc.this, message);
                return true;
            }
        });
        this.zzi = z;
    }
}

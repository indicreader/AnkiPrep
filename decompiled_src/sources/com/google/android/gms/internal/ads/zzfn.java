package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfn {
    private static zzfn zza;
    private final Handler zzb = new Handler(Looper.getMainLooper());
    private final CopyOnWriteArrayList zzc = new CopyOnWriteArrayList();
    private final Object zzd = new Object();
    private int zze = 0;

    private zzfn(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new zzfm(this, null), intentFilter);
    }

    public static synchronized zzfn zzb(Context context) {
        zzfn zzfnVar;
        synchronized (zzfn.class) {
            if (zza == null) {
                zza = new zzfn(context);
            }
            zzfnVar = zza;
        }
        return zzfnVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzc(zzfn zzfnVar, int i) {
        synchronized (zzfnVar.zzd) {
            if (zzfnVar.zze == i) {
                return;
            }
            zzfnVar.zze = i;
            Iterator it = zzfnVar.zzc.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                zzyy zzyyVar = (zzyy) weakReference.get();
                if (zzyyVar != null) {
                    zzyyVar.zza.zzk(i);
                } else {
                    zzfnVar.zzc.remove(weakReference);
                }
            }
        }
    }

    public final int zza() {
        int i;
        synchronized (this.zzd) {
            i = this.zze;
        }
        return i;
    }

    public final void zzd(final zzyy zzyyVar) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == null) {
                this.zzc.remove(weakReference);
            }
        }
        this.zzc.add(new WeakReference(zzyyVar));
        this.zzb.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfj
            @Override // java.lang.Runnable
            public final void run() {
                zzyyVar.zza.zzk(zzfn.this.zza());
            }
        });
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfwe {
    private static final Map zza = new HashMap();
    private final Context zzb;
    private final zzfvt zzc;
    private boolean zzh;
    private final Intent zzi;
    private ServiceConnection zzm;
    private IInterface zzn;
    private final zzfvg zzo;
    private final List zze = new ArrayList();
    private final Set zzf = new HashSet();
    private final Object zzg = new Object();
    private final IBinder.DeathRecipient zzk = new IBinder.DeathRecipient() { // from class: com.google.android.gms.internal.ads.zzfvv
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            zzfwe.zzj(zzfwe.this);
        }
    };
    private final AtomicInteger zzl = new AtomicInteger(0);
    private final String zzd = "OverlayDisplayService";
    private final WeakReference zzj = new WeakReference(null);

    public zzfwe(Context context, zzfvt zzfvtVar, String str, Intent intent, zzfvg zzfvgVar, zzfvz zzfvzVar) {
        this.zzb = context;
        this.zzc = zzfvtVar;
        this.zzi = intent;
        this.zzo = zzfvgVar;
    }

    public static /* synthetic */ void zzj(zzfwe zzfweVar) {
        zzfweVar.zzc.zzc("reportBinderDeath", new Object[0]);
        zzfvz zzfvzVar = (zzfvz) zzfweVar.zzj.get();
        if (zzfvzVar == null) {
            zzfweVar.zzc.zzc("%s : Binder has died.", zzfweVar.zzd);
            Iterator it = zzfweVar.zze.iterator();
            while (it.hasNext()) {
                ((zzfvu) it.next()).zzc(zzfweVar.zzv());
            }
            zzfweVar.zze.clear();
        } else {
            zzfweVar.zzc.zzc("calling onBinderDied", new Object[0]);
            zzfvzVar.zza();
        }
        synchronized (zzfweVar.zzg) {
            zzfweVar.zzw();
        }
    }

    public static /* bridge */ /* synthetic */ void zzn(zzfwe zzfweVar, final TaskCompletionSource taskCompletionSource) {
        zzfweVar.zzf.add(taskCompletionSource);
        taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.internal.ads.zzfvw
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                zzfwe.this.zzt(taskCompletionSource, task);
            }
        });
    }

    public static /* bridge */ /* synthetic */ void zzq(zzfwe zzfweVar) {
        zzfweVar.zzc.zzc("linkToDeath", new Object[0]);
        try {
            zzfweVar.zzn.asBinder().linkToDeath(zzfweVar.zzk, 0);
        } catch (RemoteException e) {
            zzfweVar.zzc.zzb(e, "linkToDeath failed", new Object[0]);
        }
    }

    public static /* bridge */ /* synthetic */ void zzr(zzfwe zzfweVar) {
        zzfweVar.zzc.zzc("unlinkToDeath", new Object[0]);
        zzfweVar.zzn.asBinder().unlinkToDeath(zzfweVar.zzk, 0);
    }

    private final RemoteException zzv() {
        return new RemoteException(String.valueOf(this.zzd).concat(" : Binder has died."));
    }

    public final void zzw() {
        Iterator it = this.zzf.iterator();
        while (it.hasNext()) {
            ((TaskCompletionSource) it.next()).trySetException(zzv());
        }
        this.zzf.clear();
    }

    public final Handler zzc() {
        Handler handler;
        Map map = zza;
        synchronized (map) {
            if (!map.containsKey(this.zzd)) {
                HandlerThread handlerThread = new HandlerThread(this.zzd, 10);
                handlerThread.start();
                map.put(this.zzd, new Handler(handlerThread.getLooper()));
            }
            handler = (Handler) map.get(this.zzd);
        }
        return handler;
    }

    public final IInterface zze() {
        return this.zzn;
    }

    public final void zzs(zzfvu zzfvuVar, TaskCompletionSource taskCompletionSource) {
        zzc().post(new zzfvx(this, zzfvuVar.zzb(), taskCompletionSource, zzfvuVar));
    }

    public final /* synthetic */ void zzt(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.zzg) {
            this.zzf.remove(taskCompletionSource);
        }
    }

    public final void zzu() {
        zzc().post(new zzfvy(this));
    }

    public static /* bridge */ /* synthetic */ void zzp(zzfwe zzfweVar, zzfvu zzfvuVar) {
        if (zzfweVar.zzn != null || zzfweVar.zzh) {
            if (zzfweVar.zzh) {
                zzfweVar.zzc.zzc("Waiting to bind to the service.", new Object[0]);
                zzfweVar.zze.add(zzfvuVar);
                return;
            } else {
                zzfvuVar.run();
                return;
            }
        }
        zzfweVar.zzc.zzc("Initiate binding to the service.", new Object[0]);
        zzfweVar.zze.add(zzfvuVar);
        zzfwd zzfwdVar = new zzfwd(zzfweVar, null);
        zzfweVar.zzm = zzfwdVar;
        zzfweVar.zzh = true;
        if (zzfweVar.zzb.bindService(zzfweVar.zzi, zzfwdVar, 1)) {
            return;
        }
        zzfweVar.zzc.zzc("Failed to bind to the service.", new Object[0]);
        zzfweVar.zzh = false;
        Iterator it = zzfweVar.zze.iterator();
        while (it.hasNext()) {
            ((zzfvu) it.next()).zzc(new zzfwf());
        }
        zzfweVar.zze.clear();
    }
}

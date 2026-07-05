package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfdr {
    public static void zza(AtomicReference atomicReference, zzfdq zzfdqVar) {
        Object obj = atomicReference.get();
        if (obj == null) {
            return;
        }
        try {
            zzfdqVar.zza(obj);
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
        } catch (NullPointerException e2) {
            zzcec.zzk("NullPointerException occurs when invoking a method from a delegating listener.", e2);
        }
    }
}

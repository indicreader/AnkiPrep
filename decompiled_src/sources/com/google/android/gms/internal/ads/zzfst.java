package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfst {
    final zzfsw zza;
    final boolean zzb;

    private zzfst(zzfsw zzfswVar) {
        this.zza = zzfswVar;
        this.zzb = zzfswVar != null;
    }

    public static zzfst zzb(Context context, String str, String str2) {
        zzfsw zzfsuVar;
        try {
            try {
                try {
                    IBinder instantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
                    if (instantiate == null) {
                        zzfsuVar = null;
                    } else {
                        IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                        zzfsuVar = queryLocalInterface instanceof zzfsw ? (zzfsw) queryLocalInterface : new zzfsu(instantiate);
                    }
                    zzfsuVar.zze(ObjectWrapper.wrap(context), str, null);
                    Log.i("GASS", "GassClearcutLogger Initialized.");
                    return new zzfst(zzfsuVar);
                } catch (Exception e) {
                    throw new zzfrv(e);
                }
            } catch (Exception e2) {
                throw new zzfrv(e2);
            }
        } catch (RemoteException | zzfrv | NullPointerException | SecurityException unused) {
            Log.d("GASS", "Cannot dynamite load clearcut");
            return new zzfst(new zzfsx());
        }
    }

    public static zzfst zzc() {
        zzfsx zzfsxVar = new zzfsx();
        Log.d("GASS", "Clearcut logging disabled");
        return new zzfst(zzfsxVar);
    }

    public final zzfss zza(byte[] bArr) {
        return new zzfss(this, bArr, null);
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzceg {
    public static Context zza(Context context) throws zzcef {
        return zzc(context).getModuleContext();
    }

    public static Object zzb(Context context, String str, zzcee zzceeVar) throws zzcef {
        try {
            return zzceeVar.zza(zzc(context).instantiate(str));
        } catch (Exception e) {
            throw new zzcef(e);
        }
    }

    private static DynamiteModule zzc(Context context) throws zzcef {
        try {
            return DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID);
        } catch (Exception e) {
            throw new zzcef(e);
        }
    }
}

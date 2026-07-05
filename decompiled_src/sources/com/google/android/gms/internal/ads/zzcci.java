package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzcci {
    static zzcci zza;

    public static synchronized zzcci zzd(Context context) {
        synchronized (zzcci.class) {
            zzcci zzcciVar = zza;
            if (zzcciVar != null) {
                return zzcciVar;
            }
            Context applicationContext = context.getApplicationContext();
            zzbgc.zza(applicationContext);
            com.google.android.gms.ads.internal.util.zzg zzi = com.google.android.gms.ads.internal.zzt.zzo().zzi();
            zzi.zzr(applicationContext);
            zzcca zzccaVar = new zzcca(null);
            zzccaVar.zzb(applicationContext);
            zzccaVar.zzc(com.google.android.gms.ads.internal.zzt.zzB());
            zzccaVar.zza(zzi);
            zzccaVar.zzd(com.google.android.gms.ads.internal.zzt.zzn());
            zzcci zze = zzccaVar.zze();
            zza = zze;
            zze.zza().zza();
            zzccm zzc = zza.zzc();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaq)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzp();
                Map zzu = com.google.android.gms.ads.internal.util.zzt.zzu((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzas));
                Iterator it = zzu.keySet().iterator();
                while (it.hasNext()) {
                    zzc.zzc((String) it.next());
                }
                zzc.zzd(new zzcck(zzc, zzu));
            }
            return zza;
        }
    }

    abstract zzcbt zza();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract zzcbx zzb();

    abstract zzccm zzc();
}

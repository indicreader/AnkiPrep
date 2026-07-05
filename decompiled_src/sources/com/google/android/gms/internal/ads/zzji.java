package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzji {
    final Context zza;
    zzel zzb;
    zzfxu zzc;
    zzfxu zzd;
    zzfxu zze;
    zzfxu zzf;
    zzfxu zzg;
    zzfws zzh;
    Looper zzi;
    zzk zzj;
    int zzk;
    boolean zzl;
    zzmj zzm;
    long zzn;
    long zzo;
    boolean zzp;
    boolean zzq;
    zziu zzr;

    public static /* synthetic */ zzuq zza(Context context) {
        return new zzue(context, new zzacp());
    }

    public zzji(final Context context, zzciu zzciuVar) {
        zzjb zzjbVar = new zzjb(zzciuVar);
        zzjc zzjcVar = new zzjc(context);
        zzfxu zzfxuVar = new zzfxu() { // from class: com.google.android.gms.internal.ads.zzjd
            @Override // com.google.android.gms.internal.ads.zzfxu
            public final Object zza() {
                return new zzyg(context);
            }
        };
        zzje zzjeVar = new zzfxu() { // from class: com.google.android.gms.internal.ads.zzje
            @Override // com.google.android.gms.internal.ads.zzfxu
            public final Object zza() {
                return new zziv();
            }
        };
        zzjf zzjfVar = new zzjf(context);
        zzjg zzjgVar = new zzfws() { // from class: com.google.android.gms.internal.ads.zzjg
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                return new zzos((zzel) obj);
            }
        };
        context.getClass();
        this.zza = context;
        this.zzc = zzjbVar;
        this.zzd = zzjcVar;
        this.zze = zzfxuVar;
        this.zzf = zzjeVar;
        this.zzg = zzjfVar;
        this.zzh = zzjgVar;
        this.zzi = zzfy.zzx();
        this.zzj = zzk.zza;
        this.zzk = 1;
        this.zzl = true;
        this.zzm = zzmj.zze;
        this.zzr = new zziu(0.97f, 1.03f, 1000L, 1.0E-7f, zzfy.zzq(20L), zzfy.zzq(500L), 0.999f, null);
        this.zzb = zzel.zza;
        this.zzn = 500L;
        this.zzo = 2000L;
        this.zzp = true;
    }
}

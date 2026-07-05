package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.2.0 */
/* loaded from: classes3.dex */
public final class zzcb implements zzdn {
    private final zzdr zza;
    private final zzdr zzb;
    private final zzdr zzc;
    private final zzdr zzd;
    private final zzdr zze;
    private final zzdr zzf;
    private final zzdr zzg;
    private final zzdr zzh;

    public zzcb(zzdr zzdrVar, zzdr zzdrVar2, zzdr zzdrVar3, zzdr zzdrVar4, zzdr zzdrVar5, zzdr zzdrVar6, zzdr zzdrVar7, zzdr zzdrVar8) {
        this.zza = zzdrVar;
        this.zzb = zzdrVar2;
        this.zzc = zzdrVar3;
        this.zzd = zzdrVar4;
        this.zze = zzdrVar5;
        this.zzf = zzdrVar6;
        this.zzg = zzdrVar7;
        this.zzh = zzdrVar8;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdr
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzca zza() {
        Application application = (Application) this.zza.zza();
        zzbw zzbwVar = (zzbw) this.zzb.zza();
        Handler handler = zzcr.zza;
        zzdp.zza(handler);
        Executor executor = zzcr.zzb;
        zzdp.zza(executor);
        return new zzca(application, zzbwVar, handler, executor, (zze) this.zze.zza(), ((zzao) this.zzf).zza(), (zzbb) this.zzg.zza(), (zzap) this.zzh.zza());
    }
}

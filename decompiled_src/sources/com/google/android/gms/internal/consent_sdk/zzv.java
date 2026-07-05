package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.2.0 */
/* loaded from: classes3.dex */
public final class zzv implements zzdn {
    private final zzdr zza;
    private final zzdr zzb;
    private final zzdr zzc;
    private final zzdr zzd;
    private final zzdr zze;
    private final zzdr zzf;
    private final zzdr zzg;
    private final zzdr zzh;
    private final zzdr zzi;

    public zzv(zzdr zzdrVar, zzdr zzdrVar2, zzdr zzdrVar3, zzdr zzdrVar4, zzdr zzdrVar5, zzdr zzdrVar6, zzdr zzdrVar7, zzdr zzdrVar8, zzdr zzdrVar9) {
        this.zza = zzdrVar;
        this.zzb = zzdrVar2;
        this.zzc = zzdrVar3;
        this.zzd = zzdrVar4;
        this.zze = zzdrVar5;
        this.zzf = zzdrVar6;
        this.zzg = zzdrVar7;
        this.zzh = zzdrVar8;
        this.zzi = zzdrVar9;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdr
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzu zza() {
        Application application = (Application) this.zza.zza();
        zzab zzabVar = (zzab) this.zzb.zza();
        Handler handler = zzcr.zza;
        zzdp.zza(handler);
        Executor executor = zzcr.zzb;
        zzdp.zza(executor);
        return new zzu(application, zzabVar, handler, executor, (zzap) this.zze.zza(), (zzbn) this.zzf.zza(), ((zzo) this.zzg).zza(), ((zzaa) this.zzh).zza(), (zze) this.zzi.zza());
    }
}

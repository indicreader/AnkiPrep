package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeam implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;
    private final zzhhu zzc;

    public zzeam(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
        this.zzc = zzhhuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        final zzavi zzaviVar = (zzavi) this.zza.zzb();
        final Context zza = ((zzclm) this.zzb).zza();
        zzgey zzgeyVar = zzcep.zza;
        zzhhl.zzb(zzgeyVar);
        ListenableFuture zzb = zzgeyVar.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeaj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzavi.this.zzc().zzg(zza);
            }
        });
        zzhhl.zzb(zzb);
        return zzb;
    }
}

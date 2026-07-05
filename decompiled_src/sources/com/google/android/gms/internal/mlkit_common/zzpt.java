package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes3.dex */
public abstract class zzpt {
    public static zzps zzh() {
        zzpf zzpfVar = new zzpf();
        zzpfVar.zzg("NA");
        zzpfVar.zzf(false);
        zzpfVar.zze(false);
        zzpfVar.zzd(ModelType.UNKNOWN);
        zzpfVar.zzb(zzle.NO_ERROR);
        zzpfVar.zza(zzlk.UNKNOWN_STATUS);
        zzpfVar.zzc(0);
        return zzpfVar;
    }

    public abstract int zza();

    public abstract ModelType zzb();

    public abstract zzle zzc();

    public abstract zzlk zzd();

    public abstract String zze();

    public abstract boolean zzf();

    public abstract boolean zzg();
}

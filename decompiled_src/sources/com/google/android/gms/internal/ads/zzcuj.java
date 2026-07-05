package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcuj implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;
    private final zzhhu zzc;
    private final zzhhu zzd;
    private final zzhhu zze;
    private final zzhhu zzf;
    private final zzhhu zzg;
    private final zzhhu zzh;
    private final zzhhu zzi;
    private final zzhhu zzj;

    public zzcuj(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3, zzhhu zzhhuVar4, zzhhu zzhhuVar5, zzhhu zzhhuVar6, zzhhu zzhhuVar7, zzhhu zzhhuVar8, zzhhu zzhhuVar9, zzhhu zzhhuVar10) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
        this.zzc = zzhhuVar3;
        this.zzd = zzhhuVar4;
        this.zze = zzhhuVar5;
        this.zzf = zzhhuVar6;
        this.zzg = zzhhuVar7;
        this.zzh = zzhhuVar8;
        this.zzi = zzhhuVar9;
        this.zzj = zzhhuVar10;
    }

    public static zzcui zzc(zzcwg zzcwgVar, Context context, zzfgn zzfgnVar, View view, zzcjk zzcjkVar, zzcwf zzcwfVar, zzdnl zzdnlVar, zzdiw zzdiwVar, zzhgx zzhgxVar, Executor executor) {
        return new zzcui(zzcwgVar, context, zzfgnVar, view, zzcjkVar, zzcwfVar, zzdnlVar, zzdiwVar, zzhgxVar, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcui zzb() {
        return new zzcui(((zzcyr) this.zza).zzb(), (Context) this.zzb.zzb(), ((zzcup) this.zzc).zza(), ((zzcuo) this.zzd).zza(), ((zzcva) this.zze).zza(), ((zzcuq) this.zzf).zza(), ((zzdli) this.zzg).zza(), (zzdiw) this.zzh.zzb(), zzhhc.zza(zzhho.zza(this.zzi)), (Executor) this.zzj.zzb());
    }
}

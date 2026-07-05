package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfbc implements zzhhd {
    public static zzext zza(Context context, zzccz zzcczVar, zzcda zzcdaVar, Object obj, zzeyr zzeyrVar, zzfai zzfaiVar, zzhgx zzhgxVar, zzhgx zzhgxVar2, zzhgx zzhgxVar3, zzhgx zzhgxVar4, zzhgx zzhgxVar5, zzhgx zzhgxVar6, zzhgx zzhgxVar7, zzhgx zzhgxVar8, zzhgx zzhgxVar9, Executor executor, zzfmz zzfmzVar, zzdwf zzdwfVar) {
        HashSet hashSet = new HashSet();
        hashSet.add((zzfab) obj);
        hashSet.add(zzeyrVar);
        hashSet.add(zzfaiVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfK)).booleanValue()) {
            hashSet.add((zzexq) zzhgxVar.zzb());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfL)).booleanValue()) {
            hashSet.add((zzexq) zzhgxVar2.zzb());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfM)).booleanValue()) {
            hashSet.add((zzexq) zzhgxVar3.zzb());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfN)).booleanValue()) {
            hashSet.add((zzexq) zzhgxVar4.zzb());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfR)).booleanValue()) {
            hashSet.add((zzexq) zzhgxVar6.zzb());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfS)).booleanValue()) {
            hashSet.add((zzexq) zzhgxVar7.zzb());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcI)).booleanValue()) {
            hashSet.add((zzexq) zzhgxVar9.zzb());
        }
        return new zzext(context, executor, hashSet, zzfmzVar, zzdwfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        throw null;
    }
}

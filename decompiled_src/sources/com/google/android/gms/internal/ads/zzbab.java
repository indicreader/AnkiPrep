package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbab implements Comparator {
    public zzbab(zzbac zzbacVar) {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzazq zzazqVar = (zzazq) obj;
        zzazq zzazqVar2 = (zzazq) obj2;
        if (zzazqVar.zzd() < zzazqVar2.zzd()) {
            return -1;
        }
        if (zzazqVar.zzd() <= zzazqVar2.zzd()) {
            if (zzazqVar.zzb() < zzazqVar2.zzb()) {
                return -1;
            }
            if (zzazqVar.zzb() <= zzazqVar2.zzb()) {
                float zza = (zzazqVar.zza() - zzazqVar.zzd()) * (zzazqVar.zzc() - zzazqVar.zzb());
                float zza2 = (zzazqVar2.zza() - zzazqVar2.zzd()) * (zzazqVar2.zzc() - zzazqVar2.zzb());
                if (zza > zza2) {
                    return -1;
                }
                if (zza >= zza2) {
                    return 0;
                }
            }
        }
        return 1;
    }
}

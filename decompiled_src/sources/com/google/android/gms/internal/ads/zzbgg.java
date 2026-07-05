package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbgg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static List zza() {
        ArrayList arrayList = new ArrayList();
        zzc(arrayList, zzbhm.zzc("gad:dynamite_module:experiment_id", ""));
        zzc(arrayList, zzbhx.zza);
        zzc(arrayList, zzbhx.zzb);
        zzc(arrayList, zzbhx.zzc);
        zzc(arrayList, zzbhx.zzd);
        zzc(arrayList, zzbhx.zze);
        zzc(arrayList, zzbhx.zzu);
        zzc(arrayList, zzbhx.zzf);
        zzc(arrayList, zzbhx.zzm);
        zzc(arrayList, zzbhx.zzn);
        zzc(arrayList, zzbhx.zzo);
        zzc(arrayList, zzbhx.zzp);
        zzc(arrayList, zzbhx.zzq);
        zzc(arrayList, zzbhx.zzr);
        zzc(arrayList, zzbhx.zzs);
        zzc(arrayList, zzbhx.zzt);
        zzc(arrayList, zzbhx.zzg);
        zzc(arrayList, zzbhx.zzh);
        zzc(arrayList, zzbhx.zzi);
        zzc(arrayList, zzbhx.zzj);
        zzc(arrayList, zzbhx.zzk);
        zzc(arrayList, zzbhx.zzl);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List zzb() {
        ArrayList arrayList = new ArrayList();
        zzc(arrayList, zzbil.zza);
        return arrayList;
    }

    private static void zzc(List list, zzbhm zzbhmVar) {
        String str = (String) zzbhmVar.zze();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        list.add(str);
    }
}

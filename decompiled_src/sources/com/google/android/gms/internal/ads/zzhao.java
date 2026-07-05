package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzhao extends zzhas {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzhao() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzhao(zzhan zzhanVar) {
        super(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static List zzf(Object obj, long j, int i) {
        zzhal zzhalVar;
        List arrayList;
        List list = (List) zzhcz.zzh(obj, j);
        if (list.isEmpty()) {
            if (list instanceof zzham) {
                arrayList = new zzhal(i);
            } else if (!(list instanceof zzhbm) || !(list instanceof zzhad)) {
                arrayList = new ArrayList(i);
            } else {
                arrayList = ((zzhad) list).zzd(i);
            }
            zzhcz.zzv(obj, j, arrayList);
            return arrayList;
        }
        if (zza.isAssignableFrom(list.getClass())) {
            ArrayList arrayList2 = new ArrayList(list.size() + i);
            arrayList2.addAll(list);
            zzhcz.zzv(obj, j, arrayList2);
            zzhalVar = arrayList2;
        } else {
            if (!(list instanceof zzhcu)) {
                if (!(list instanceof zzhbm) || !(list instanceof zzhad)) {
                    return list;
                }
                zzhad zzhadVar = (zzhad) list;
                if (zzhadVar.zzc()) {
                    return list;
                }
                zzhad zzd = zzhadVar.zzd(list.size() + i);
                zzhcz.zzv(obj, j, zzd);
                return zzd;
            }
            zzhal zzhalVar2 = new zzhal(list.size() + i);
            zzhalVar2.addAll(zzhalVar2.size(), (zzhcu) list);
            zzhcz.zzv(obj, j, zzhalVar2);
            zzhalVar = zzhalVar2;
        }
        return zzhalVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzhas
    public final List zza(Object obj, long j) {
        return zzf(obj, j, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzhas
    public final void zzb(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) zzhcz.zzh(obj, j);
        if (list instanceof zzham) {
            unmodifiableList = ((zzham) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if (!(list instanceof zzhbm) || !(list instanceof zzhad)) {
                unmodifiableList = Collections.unmodifiableList(list);
            } else {
                zzhad zzhadVar = (zzhad) list;
                if (zzhadVar.zzc()) {
                    zzhadVar.zzb();
                    return;
                }
                return;
            }
        }
        zzhcz.zzv(obj, j, unmodifiableList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzhas
    public final void zzc(Object obj, Object obj2, long j) {
        List list = (List) zzhcz.zzh(obj2, j);
        List zzf = zzf(obj, j, list.size());
        int size = zzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            zzf.addAll(list);
        }
        if (size > 0) {
            list = zzf;
        }
        zzhcz.zzv(obj, j, list);
    }
}

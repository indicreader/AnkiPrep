package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
/* loaded from: classes3.dex */
final class zzit implements Comparator {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzjb zzjbVar = (zzjb) obj;
        zzjb zzjbVar2 = (zzjb) obj2;
        zzis zzisVar = new zzis(zzjbVar);
        zzis zzisVar2 = new zzis(zzjbVar2);
        while (zzisVar.hasNext() && zzisVar2.hasNext()) {
            int compareTo = Integer.valueOf(zzisVar.zza() & 255).compareTo(Integer.valueOf(zzisVar2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzjbVar.zzd()).compareTo(Integer.valueOf(zzjbVar2.zzd()));
    }
}

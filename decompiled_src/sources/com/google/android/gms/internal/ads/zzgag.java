package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgag {
    public static Object zza(Iterable iterable, Object obj) {
        zzgbt zzgbtVar = new zzgbt((zzgbu) iterable);
        return zzgbtVar.hasNext() ? zzgbtVar.next() : obj;
    }

    public static boolean zzb(Iterable iterable, zzfxf zzfxfVar) {
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            Iterator it = iterable.iterator();
            zzfxfVar.getClass();
            boolean z = false;
            while (it.hasNext()) {
                if (zzfxfVar.zza(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }
        zzfxfVar.getClass();
        return zzd((List) iterable, zzfxfVar);
    }

    private static void zzc(List list, zzfxf zzfxfVar, int i, int i2) {
        int size = list.size();
        while (true) {
            size--;
            if (size <= i2) {
                break;
            } else if (zzfxfVar.zza(list.get(size))) {
                list.remove(size);
            }
        }
        while (true) {
            i2--;
            if (i2 < i) {
                return;
            } else {
                list.remove(i2);
            }
        }
    }

    private static boolean zzd(List list, zzfxf zzfxfVar) {
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            Object obj = list.get(i);
            if (!zzfxfVar.zza(obj)) {
                if (i > i2) {
                    try {
                        list.set(i2, obj);
                    } catch (IllegalArgumentException unused) {
                        zzc(list, zzfxfVar, i2, i);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        zzc(list, zzfxfVar, i2, i);
                        return true;
                    }
                }
                i2++;
            }
            i++;
        }
        list.subList(i2, list.size()).clear();
        return i != i2;
    }
}

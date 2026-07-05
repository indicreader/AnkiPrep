package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes3.dex */
public final class zzazg {
    int zza;
    private final Object zzb = new Object();
    private final List zzc = new LinkedList();

    public final zzazf zza(boolean z) {
        synchronized (this.zzb) {
            zzazf zzazfVar = null;
            if (this.zzc.isEmpty()) {
                zzcec.zze("Queue empty");
                return null;
            }
            int i = 0;
            if (this.zzc.size() >= 2) {
                int i2 = Integer.MIN_VALUE;
                int i3 = 0;
                for (zzazf zzazfVar2 : this.zzc) {
                    int zzb = zzazfVar2.zzb();
                    if (zzb > i2) {
                        i = i3;
                    }
                    int i4 = zzb > i2 ? zzb : i2;
                    if (zzb > i2) {
                        zzazfVar = zzazfVar2;
                    }
                    i3++;
                    i2 = i4;
                }
                this.zzc.remove(i);
                return zzazfVar;
            }
            zzazf zzazfVar3 = (zzazf) this.zzc.get(0);
            if (z) {
                this.zzc.remove(0);
            } else {
                zzazfVar3.zzi();
            }
            return zzazfVar3;
        }
    }

    public final void zzb(zzazf zzazfVar) {
        synchronized (this.zzb) {
            if (this.zzc.size() >= 10) {
                zzcec.zze("Queue is full, current size = " + this.zzc.size());
                this.zzc.remove(0);
            }
            int i = this.zza;
            this.zza = i + 1;
            zzazfVar.zzj(i);
            zzazfVar.zzn();
            this.zzc.add(zzazfVar);
        }
    }

    public final boolean zzc(zzazf zzazfVar) {
        synchronized (this.zzb) {
            Iterator it = this.zzc.iterator();
            while (it.hasNext()) {
                zzazf zzazfVar2 = (zzazf) it.next();
                if (!com.google.android.gms.ads.internal.zzt.zzo().zzi().zzN()) {
                    if (!zzazfVar.equals(zzazfVar2) && zzazfVar2.zzd().equals(zzazfVar.zzd())) {
                        it.remove();
                        return true;
                    }
                } else if (!com.google.android.gms.ads.internal.zzt.zzo().zzi().zzO() && !zzazfVar.equals(zzazfVar2) && zzazfVar2.zzf().equals(zzazfVar.zzf())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean zzd(zzazf zzazfVar) {
        synchronized (this.zzb) {
            return this.zzc.contains(zzazfVar);
        }
    }
}

package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfov {
    private static final zzfov zza = new zzfov();
    private final ArrayList zzb = new ArrayList();
    private final ArrayList zzc = new ArrayList();

    private zzfov() {
    }

    public static zzfov zza() {
        return zza;
    }

    public final Collection zzb() {
        return Collections.unmodifiableCollection(this.zzc);
    }

    public final Collection zzc() {
        return Collections.unmodifiableCollection(this.zzb);
    }

    public final void zzd(zzfoh zzfohVar) {
        this.zzb.add(zzfohVar);
    }

    public final void zze(zzfoh zzfohVar) {
        ArrayList arrayList = this.zzb;
        boolean zzg = zzg();
        arrayList.remove(zzfohVar);
        this.zzc.remove(zzfohVar);
        if (!zzg || zzg()) {
            return;
        }
        zzfpc.zzb().zzg();
    }

    public final void zzf(zzfoh zzfohVar) {
        ArrayList arrayList = this.zzc;
        boolean zzg = zzg();
        arrayList.add(zzfohVar);
        if (zzg) {
            return;
        }
        zzfpc.zzb().zzf();
    }

    public final boolean zzg() {
        return this.zzc.size() > 0;
    }
}

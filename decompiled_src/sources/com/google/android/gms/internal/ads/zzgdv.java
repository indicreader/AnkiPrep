package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgdv extends zzgdx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgdv(zzfzv zzfzvVar, boolean z) {
        super(zzfzvVar, z);
        zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzgdx
    public final /* bridge */ /* synthetic */ Object zzG(List list) {
        ArrayList zza = zzgao.zza(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzgdw zzgdwVar = (zzgdw) it.next();
            zza.add(zzgdwVar != null ? zzgdwVar.zza : null);
        }
        return Collections.unmodifiableList(zza);
    }
}

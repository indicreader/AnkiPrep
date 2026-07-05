package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes3.dex */
public final class zzpm implements zzpj {
    final List zza;

    public zzpm(Context context, zzpl zzplVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzplVar.zzc()) {
            arrayList.add(new zzpz(context, zzplVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpj
    public final void zza(zzpi zzpiVar) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzpj) it.next()).zza(zzpiVar);
        }
    }
}

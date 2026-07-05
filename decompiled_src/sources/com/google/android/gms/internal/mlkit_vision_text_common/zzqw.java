package com.google.android.gms.internal.mlkit_vision_text_common;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
public final class zzqw implements zzqt {
    final List zza;

    public zzqw(Context context, zzqv zzqvVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzqvVar.zzc()) {
            arrayList.add(new zzrl(context, zzqvVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzqt
    public final void zza(zzqs zzqsVar) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzqt) it.next()).zza(zzqsVar);
        }
    }
}

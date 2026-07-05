package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfxr {
    private final zzfwp zza;
    private final zzfxq zzb;

    private zzfxr(zzfxq zzfxqVar) {
        zzfwp zzfwpVar = zzfwo.zza;
        this.zzb = zzfxqVar;
        this.zza = zzfwpVar;
    }

    public static zzfxr zzb(int i) {
        return new zzfxr(new zzfxn(4000));
    }

    public static zzfxr zzc(zzfwp zzfwpVar) {
        return new zzfxr(new zzfxl(zzfwpVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Iterator zzg(CharSequence charSequence) {
        return this.zzb.zza(this, charSequence);
    }

    public final Iterable zzd(CharSequence charSequence) {
        charSequence.getClass();
        return new zzfxo(this, charSequence);
    }

    public final List zzf(CharSequence charSequence) {
        charSequence.getClass();
        Iterator zzg = zzg(charSequence);
        ArrayList arrayList = new ArrayList();
        while (zzg.hasNext()) {
            arrayList.add((String) zzg.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}

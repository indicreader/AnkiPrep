package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.Spanned;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzef {
    private static final String zza = Integer.toString(0, 36);
    private static final String zzb = Integer.toString(1, 36);
    private static final String zzc = Integer.toString(2, 36);
    private static final String zzd = Integer.toString(3, 36);
    private static final String zze = Integer.toString(4, 36);

    public static ArrayList zza(Spanned spanned) {
        ArrayList arrayList = new ArrayList();
        for (zzeh zzehVar : (zzeh[]) spanned.getSpans(0, spanned.length(), zzeh.class)) {
            arrayList.add(zzb(spanned, zzehVar, 1, zzehVar.zza()));
        }
        for (zzej zzejVar : (zzej[]) spanned.getSpans(0, spanned.length(), zzej.class)) {
            arrayList.add(zzb(spanned, zzejVar, 2, zzejVar.zza()));
        }
        for (zzeg zzegVar : (zzeg[]) spanned.getSpans(0, spanned.length(), zzeg.class)) {
            arrayList.add(zzb(spanned, zzegVar, 3, null));
        }
        return arrayList;
    }

    private static Bundle zzb(Spanned spanned, Object obj, int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt(zza, spanned.getSpanStart(obj));
        bundle2.putInt(zzb, spanned.getSpanEnd(obj));
        bundle2.putInt(zzc, spanned.getSpanFlags(obj));
        bundle2.putInt(zzd, i);
        if (bundle != null) {
            bundle2.putBundle(zze, bundle);
        }
        return bundle2;
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzavh extends zzavg {
    protected zzavh(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static zzavh zzt(String str, Context context, boolean z) {
        zzr(context, false);
        return new zzavh(context, str, false);
    }

    @Deprecated
    public static zzavh zzu(String str, Context context, boolean z, int i) {
        zzr(context, z);
        return new zzavh(context, str, z);
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    protected final List zzp(zzawj zzawjVar, Context context, zzasg zzasgVar, zzarz zzarzVar) {
        if (zzawjVar.zzk() == null || !this.zzu) {
            return super.zzp(zzawjVar, context, zzasgVar, null);
        }
        int zza = zzawjVar.zza();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zzp(zzawjVar, context, zzasgVar, null));
        arrayList.add(new zzaxb(zzawjVar, "8UEA9TmdE+sqV3zcsNgnFI5Sf8uIsQHU61W37Ddl8zaNqY23x/FpuoK+mm9MWruA", "qlbJd0rViXaFpU2SvrkcezPlE/VtgXulMFWFUXmIBBg=", zzasgVar, zza, 24));
        return arrayList;
    }
}

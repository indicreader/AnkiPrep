package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzlg {
    public final long zza;
    public final float zzb;
    public final long zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzlg(zzle zzleVar, zzlf zzlfVar) {
        this.zza = zzle.zzc(zzleVar);
        this.zzb = zzle.zza(zzleVar);
        this.zzc = zzle.zzb(zzleVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlg)) {
            return false;
        }
        zzlg zzlgVar = (zzlg) obj;
        return this.zza == zzlgVar.zza && this.zzb == zzlgVar.zzb && this.zzc == zzlgVar.zzc;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), Float.valueOf(this.zzb), Long.valueOf(this.zzc)});
    }

    public final zzle zza() {
        return new zzle(this, null);
    }
}

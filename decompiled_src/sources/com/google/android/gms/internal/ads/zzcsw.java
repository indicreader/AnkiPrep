package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcsw {
    private final String zza;
    private final zzbsg zzb;
    private final Executor zzc;
    private zzctb zzd;
    private final zzbng zze = new zzcst(this);
    private final zzbng zzf = new zzcsv(this);

    public zzcsw(String str, zzbsg zzbsgVar, Executor executor) {
        this.zza = str;
        this.zzb = zzbsgVar;
        this.zzc = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ boolean zzg(zzcsw zzcswVar, Map map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(zzcswVar.zza);
    }

    public final void zzc(zzctb zzctbVar) {
        this.zzb.zzb("/updateActiveView", this.zze);
        this.zzb.zzb("/untrackActiveViewUnit", this.zzf);
        this.zzd = zzctbVar;
    }

    public final void zzd(zzcjk zzcjkVar) {
        zzcjkVar.zzae("/updateActiveView", this.zze);
        zzcjkVar.zzae("/untrackActiveViewUnit", this.zzf);
    }

    public final void zze() {
        this.zzb.zzc("/updateActiveView", this.zze);
        this.zzb.zzc("/untrackActiveViewUnit", this.zzf);
    }

    public final void zzf(zzcjk zzcjkVar) {
        zzcjkVar.zzaw("/updateActiveView", this.zze);
        zzcjkVar.zzaw("/untrackActiveViewUnit", this.zzf);
    }
}

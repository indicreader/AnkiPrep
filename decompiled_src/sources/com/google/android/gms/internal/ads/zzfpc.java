package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfpc implements zzfow {
    private static zzfpc zza;
    private float zzb = 0.0f;
    private final zzfos zzc;
    private final zzfoq zzd;
    private zzfor zze;
    private zzfov zzf;

    public zzfpc(zzfos zzfosVar, zzfoq zzfoqVar) {
        this.zzc = zzfosVar;
        this.zzd = zzfoqVar;
    }

    public static zzfpc zzb() {
        if (zza == null) {
            zza = new zzfpc(new zzfos(), new zzfoq());
        }
        return zza;
    }

    public final float zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfow
    public final void zzc(boolean z) {
        if (z) {
            zzfqd.zzd().zzi();
        } else {
            zzfqd.zzd().zzh();
        }
    }

    public final void zzd(Context context) {
        this.zze = new zzfor(new Handler(), context, new zzfop(), this);
    }

    public final void zze(float f) {
        this.zzb = f;
        if (this.zzf == null) {
            this.zzf = zzfov.zza();
        }
        Iterator it = this.zzf.zzb().iterator();
        while (it.hasNext()) {
            ((zzfoh) it.next()).zzg().zzi(f);
        }
    }

    public final void zzf() {
        zzfou.zza().zze(this);
        zzfou.zza().zzf();
        zzfqd.zzd().zzi();
        this.zze.zza();
    }

    public final void zzg() {
        zzfqd.zzd().zzj();
        zzfou.zza().zzg();
        this.zze.zzb();
    }
}

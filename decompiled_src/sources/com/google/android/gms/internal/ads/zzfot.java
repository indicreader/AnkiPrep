package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Date;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfot implements zzfow {
    private static final zzfot zzb = new zzfot(new zzfox());
    protected final zzfps zza = new zzfps();
    private Date zzc;
    private boolean zzd;
    private final zzfox zze;
    private boolean zzf;

    private zzfot(zzfox zzfoxVar) {
        this.zze = zzfoxVar;
    }

    public static zzfot zza() {
        return zzb;
    }

    public final Date zzb() {
        Date date = this.zzc;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfow
    public final void zzc(boolean z) {
        if (!this.zzf && z) {
            Date date = new Date();
            Date date2 = this.zzc;
            if (date2 == null || date.after(date2)) {
                this.zzc = date;
                if (this.zzd) {
                    Iterator it = zzfov.zza().zzb().iterator();
                    while (it.hasNext()) {
                        ((zzfoh) it.next()).zzg().zze(zzb());
                    }
                }
            }
        }
        this.zzf = z;
    }

    public final void zzd(Context context) {
        if (this.zzd) {
            return;
        }
        this.zze.zzd(context);
        this.zze.zze(this);
        this.zze.zzf();
        this.zzf = this.zze.zza;
        this.zzd = true;
    }
}

package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzaxi extends zzaxx {
    private final zzavm zzi;
    private final long zzj;
    private final long zzk;

    public zzaxi(zzawj zzawjVar, String str, String str2, zzasg zzasgVar, int i, int i2, zzavm zzavmVar, long j, long j2) {
        super(zzawjVar, "ChMYhePBDqkXl5DeRTg9cgSXXNPVEcIqgEVciYHEVlkZyx/HkVQXSnen8aw33G2s", "tJ+SvALjKnpAv9FF8u56pKKRS55/vzUDe+m9ct97Lx4=", zzasgVar, i, 11);
        this.zzi = zzavmVar;
        this.zzj = j;
        this.zzk = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzavm zzavmVar = this.zzi;
        if (zzavmVar != null) {
            zzavk zzavkVar = new zzavk((String) this.zzf.invoke(null, zzavmVar.zzb(), Long.valueOf(this.zzj), Long.valueOf(this.zzk)));
            synchronized (this.zze) {
                this.zze.zzz(zzavkVar.zza.longValue());
                if (zzavkVar.zzb.longValue() >= 0) {
                    this.zze.zzQ(zzavkVar.zzb.longValue());
                }
                if (zzavkVar.zzc.longValue() >= 0) {
                    this.zze.zzf(zzavkVar.zzc.longValue());
                }
            }
        }
    }
}

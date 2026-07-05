package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzaxr extends zzaxx {
    private final zzawq zzi;
    private long zzj;

    public zzaxr(zzawj zzawjVar, String str, String str2, zzasg zzasgVar, int i, int i2, zzawq zzawqVar) {
        super(zzawjVar, "2ZUgS25mCfmBpvNAAnoop42ZvK9H4E17vIqHMHWBgDSruAgpJ0/PRWhyN3sqcUbC", "ZqqofhkB4+yK9ARzF+IbcECpWBtuTXlqWFDkC/AVdcM=", zzasgVar, i, 53);
        this.zzi = zzawqVar;
        if (zzawqVar != null) {
            this.zzj = zzawqVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            this.zze.zzP(((Long) this.zzf.invoke(null, Long.valueOf(this.zzj))).longValue());
        }
    }
}

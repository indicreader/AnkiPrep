package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzaen implements zzacu {
    private int zzc;
    private zzaeo zze;
    private long zzh;
    private zzaeq zzi;
    private int zzm;
    private boolean zzn;
    private final zzfp zza = new zzfp(12);
    private final zzaem zzb = new zzaem(null);
    private zzacx zzd = new zzacs();
    private zzaeq[] zzg = new zzaeq[0];
    private long zzk = -1;
    private long zzl = -1;
    private int zzj = -1;
    private long zzf = -9223372036854775807L;

    private final zzaeq zzf(int i) {
        for (zzaeq zzaeqVar : this.zzg) {
            if (zzaeqVar.zzg(i)) {
                return zzaeqVar;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzc = 0;
        this.zzd = zzacxVar;
        this.zzh = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j, long j2) {
        this.zzh = -1L;
        this.zzi = null;
        for (zzaeq zzaeqVar : this.zzg) {
            zzaeqVar.zzf(j);
        }
        if (j == 0) {
            this.zzc = this.zzg.length != 0 ? 3 : 0;
        } else {
            this.zzc = 6;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        ((zzack) zzacvVar).zzm(this.zza.zzM(), 0, 12, false);
        this.zza.zzK(0);
        if (this.zza.zzi() != 1179011410) {
            return false;
        }
        this.zza.zzL(4);
        return this.zza.zzi() == 541677121;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0033 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    @Override // com.google.android.gms.internal.ads.zzacu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(com.google.android.gms.internal.ads.zzacv r28, com.google.android.gms.internal.ads.zzadr r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 958
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaen.zzb(com.google.android.gms.internal.ads.zzacv, com.google.android.gms.internal.ads.zzadr):int");
    }
}

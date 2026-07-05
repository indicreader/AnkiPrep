package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zztv implements zzwh {
    public final zzwh zza;
    final /* synthetic */ zztw zzb;
    private boolean zzc;

    public zztv(zztw zztwVar, zzwh zzwhVar) {
        this.zzb = zztwVar;
        this.zza = zzwhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final int zza(zzlb zzlbVar, zzih zzihVar, int i) {
        zztw zztwVar = this.zzb;
        if (zztwVar.zzq()) {
            return -3;
        }
        if (this.zzc) {
            zzihVar.zzc(4);
            return -4;
        }
        long zzb = zztwVar.zzb();
        int zza = this.zza.zza(zzlbVar, zzihVar, i);
        if (zza != -5) {
            long j = this.zzb.zzb;
            if (j == Long.MIN_VALUE || ((zza != -4 || zzihVar.zze < j) && !(zza == -3 && zzb == Long.MIN_VALUE && !zzihVar.zzd))) {
                return zza;
            }
            zzihVar.zzb();
            zzihVar.zzc(4);
            this.zzc = true;
            return -4;
        }
        zzam zzamVar = zzlbVar.zza;
        zzamVar.getClass();
        int i2 = zzamVar.zzC;
        if (i2 == 0) {
            if (zzamVar.zzD != 0) {
                i2 = 0;
            }
            return -5;
        }
        int i3 = this.zzb.zzb == Long.MIN_VALUE ? zzamVar.zzD : 0;
        zzak zzb2 = zzamVar.zzb();
        zzb2.zzF(i2);
        zzb2.zzG(i3);
        zzlbVar.zza = zzb2.zzac();
        return -5;
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final int zzb(long j) {
        if (this.zzb.zzq()) {
            return -3;
        }
        return this.zza.zzb(j);
    }

    public final void zzc() {
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final boolean zze() {
        return !this.zzb.zzq() && this.zza.zze();
    }
}

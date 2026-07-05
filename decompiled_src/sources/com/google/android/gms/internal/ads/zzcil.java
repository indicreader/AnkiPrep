package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzcil implements zzgw {
    private final zzgw zza;
    private final long zzb;
    private final zzgw zzc;
    private long zzd;
    private Uri zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcil(zzgw zzgwVar, int i, zzgw zzgwVar2) {
        this.zza = zzgwVar;
        this.zzb = i;
        this.zzc = zzgwVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzu
    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.zzd;
        long j2 = this.zzb;
        if (j < j2) {
            int zza = this.zza.zza(bArr, i, (int) Math.min(i2, j2 - j));
            long j3 = this.zzd + zza;
            this.zzd = j3;
            i3 = zza;
            j = j3;
        } else {
            i3 = 0;
        }
        if (j < this.zzb) {
            return i3;
        }
        int zza2 = this.zzc.zza(bArr, i + i3, i2 - i3);
        int i4 = i3 + zza2;
        this.zzd += zza2;
        return i4;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final long zzb(zzhb zzhbVar) throws IOException {
        zzhb zzhbVar2;
        this.zze = zzhbVar.zza;
        long j = this.zzb;
        long j2 = zzhbVar.zzf;
        zzhb zzhbVar3 = null;
        if (j2 >= j) {
            zzhbVar2 = null;
        } else {
            long j3 = zzhbVar.zzg;
            long j4 = j - j2;
            if (j3 != -1) {
                j4 = Math.min(j3, j4);
            }
            zzhbVar2 = new zzhb(zzhbVar.zza, null, j2, j2, j4, null, 0);
        }
        long j5 = zzhbVar.zzg;
        if (j5 == -1 || zzhbVar.zzf + j5 > this.zzb) {
            long max = Math.max(this.zzb, zzhbVar.zzf);
            long j6 = zzhbVar.zzg;
            zzhbVar3 = new zzhb(zzhbVar.zza, null, max, max, j6 != -1 ? Math.min(j6, (zzhbVar.zzf + j6) - this.zzb) : -1L, null, 0);
        }
        long zzb = zzhbVar2 != null ? this.zza.zzb(zzhbVar2) : 0L;
        long zzb2 = zzhbVar3 != null ? this.zzc.zzb(zzhbVar3) : 0L;
        this.zzd = zzhbVar.zzf;
        if (zzb == -1 || zzb2 == -1) {
            return -1L;
        }
        return zzb + zzb2;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final Uri zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzd() throws IOException {
        this.zza.zzd();
        this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final Map zze() {
        return zzgad.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzf(zzhy zzhyVar) {
    }
}

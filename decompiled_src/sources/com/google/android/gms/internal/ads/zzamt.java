package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzamt implements zzacu {
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzams
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i = zzada.zza;
            zzadb zzadbVar = zzamt.zza;
            return new zzacu[]{new zzamt(0)};
        }
    };
    private final zzamu zzb;
    private final zzfp zzc;
    private final zzfp zzd;
    private final zzfo zze;
    private zzacx zzf;
    private long zzg;
    private long zzh;
    private boolean zzi;
    private boolean zzj;

    public zzamt() {
        this(0);
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        zzek.zzb(this.zzf);
        int zza2 = zzacvVar.zza(this.zzc.zzM(), 0, 2048);
        if (!this.zzj) {
            this.zzf.zzO(new zzadt(-9223372036854775807L, 0L));
            this.zzj = true;
        }
        if (zza2 == -1) {
            return -1;
        }
        this.zzc.zzK(0);
        this.zzc.zzJ(zza2);
        if (!this.zzi) {
            this.zzb.zzd(this.zzg, 4);
            this.zzi = true;
        }
        this.zzb.zza(this.zzc);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzf = zzacxVar;
        this.zzb.zzb(zzacxVar, new zzaok(Integer.MIN_VALUE, 0, 1));
        zzacxVar.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j, long j2) {
        this.zzi = false;
        this.zzb.zze();
        this.zzg = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        zzack zzackVar;
        int i = 0;
        while (true) {
            zzackVar = (zzack) zzacvVar;
            zzackVar.zzm(this.zzd.zzM(), 0, 10, false);
            this.zzd.zzK(0);
            if (this.zzd.zzo() != 4801587) {
                break;
            }
            this.zzd.zzL(3);
            int zzl = this.zzd.zzl();
            i += zzl + 10;
            zzackVar.zzl(zzl, false);
        }
        zzacvVar.zzj();
        zzackVar.zzl(i, false);
        if (this.zzh == -1) {
            this.zzh = i;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        do {
            zzackVar.zzm(this.zzd.zzM(), 0, 2, false);
            this.zzd.zzK(0);
            if (zzamu.zzf(this.zzd.zzq())) {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                zzackVar.zzm(this.zzd.zzM(), 0, 4, false);
                this.zze.zzk(14);
                int zzd = this.zze.zzd(13);
                if (zzd <= 6) {
                    i4++;
                    zzacvVar.zzj();
                    zzackVar.zzl(i4, false);
                } else {
                    zzackVar.zzl(zzd - 6, false);
                    i3 += zzd;
                }
            } else {
                i4++;
                zzacvVar.zzj();
                zzackVar.zzl(i4, false);
            }
            i2 = 0;
            i3 = 0;
        } while (i4 - i < 8192);
        return false;
    }

    public zzamt(int i) {
        this.zzb = new zzamu(true, null);
        this.zzc = new zzfp(2048);
        this.zzh = -1L;
        zzfp zzfpVar = new zzfp(10);
        this.zzd = zzfpVar;
        byte[] zzM = zzfpVar.zzM();
        this.zze = new zzfo(zzM, zzM.length);
    }
}

package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.compose.ui.text.android.LayoutCompat;
import java.io.IOException;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzajw implements zzacu {
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzajv
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i = zzada.zza;
            zzadb zzadbVar = zzajw.zza;
            return new zzacu[]{new zzajw()};
        }
    };
    private zzacx zzb;
    private zzake zzc;
    private boolean zzd;

    @EnsuresNonNullIf(expression = {"streamReader"}, result = LayoutCompat.DEFAULT_FALLBACK_LINE_SPACING)
    private final boolean zza(zzacv zzacvVar) throws IOException {
        zzajy zzajyVar = new zzajy();
        if (zzajyVar.zzb(zzacvVar, true) && (zzajyVar.zza & 2) == 2) {
            int min = Math.min(zzajyVar.zze, 8);
            zzfp zzfpVar = new zzfp(min);
            ((zzack) zzacvVar).zzm(zzfpVar.zzM(), 0, min, false);
            zzfpVar.zzK(0);
            if (zzfpVar.zzb() < 5 || zzfpVar.zzm() != 127 || zzfpVar.zzu() != 1179402563) {
                zzfpVar.zzK(0);
                try {
                    if (zzaeg.zzd(1, zzfpVar, true)) {
                        this.zzc = new zzakg();
                    }
                } catch (zzcc unused) {
                }
                zzfpVar.zzK(0);
                if (zzaka.zzd(zzfpVar)) {
                    this.zzc = new zzaka();
                }
            } else {
                this.zzc = new zzaju();
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        zzek.zzb(this.zzb);
        if (this.zzc == null) {
            if (!zza(zzacvVar)) {
                throw zzcc.zza("Failed to determine bitstream type", null);
            }
            zzacvVar.zzj();
        }
        if (!this.zzd) {
            zzaea zzw = this.zzb.zzw(0, 1);
            this.zzb.zzD();
            this.zzc.zzh(this.zzb, zzw);
            this.zzd = true;
        }
        return this.zzc.zze(zzacvVar, zzadrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzb = zzacxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j, long j2) {
        zzake zzakeVar = this.zzc;
        if (zzakeVar != null) {
            zzakeVar.zzj(j, j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        try {
            return zza(zzacvVar);
        } catch (zzcc unused) {
            return false;
        }
    }
}

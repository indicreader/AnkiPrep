package com.google.android.gms.internal.ads;

import android.os.IBinder;
import com.google.common.base.Ascii;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzfus extends zzfvm {
    private IBinder zza;
    private String zzb;
    private int zzc;
    private float zzd;
    private int zze;
    private String zzf;
    private byte zzg;

    @Override // com.google.android.gms.internal.ads.zzfvm
    public final zzfvm zza(String str) {
        this.zzf = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfvm
    public final zzfvm zzb(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfvm
    public final zzfvm zzc(int i) {
        this.zzg = (byte) (this.zzg | 8);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfvm
    public final zzfvm zzd(int i) {
        this.zzc = i;
        this.zzg = (byte) (this.zzg | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfvm
    public final zzfvm zze(float f) {
        this.zzd = f;
        this.zzg = (byte) (this.zzg | 4);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfvm
    public final zzfvm zzf(boolean z) {
        this.zzg = (byte) (this.zzg | 1);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfvm
    public final zzfvm zzg(IBinder iBinder) {
        if (iBinder == null) {
            throw new NullPointerException("Null windowToken");
        }
        this.zza = iBinder;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfvm
    public final zzfvm zzh(int i) {
        this.zze = i;
        this.zzg = (byte) (this.zzg | Ascii.DLE);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfvm
    public final zzfvn zzi() {
        IBinder iBinder;
        if (this.zzg != 31 || (iBinder = this.zza) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.zza == null) {
                sb.append(" windowToken");
            }
            if ((this.zzg & 1) == 0) {
                sb.append(" stableSessionToken");
            }
            if ((this.zzg & 2) == 0) {
                sb.append(" layoutGravity");
            }
            if ((this.zzg & 4) == 0) {
                sb.append(" layoutVerticalMargin");
            }
            if ((this.zzg & 8) == 0) {
                sb.append(" displayMode");
            }
            if ((this.zzg & Ascii.DLE) == 0) {
                sb.append(" windowWidthPx");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
        }
        return new zzfuu(iBinder, false, this.zzb, this.zzc, this.zzd, 0, null, this.zze, null, this.zzf, null, null);
    }
}

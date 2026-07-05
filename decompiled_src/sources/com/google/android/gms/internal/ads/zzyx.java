package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzyx {
    private int zza;
    private int zzb;
    private int zzc = 0;
    private zzyq[] zzd = new zzyq[100];

    public zzyx(boolean z, int i) {
    }

    public final synchronized int zza() {
        return this.zzb * 65536;
    }

    public final synchronized zzyq zzb() {
        zzyq zzyqVar;
        this.zzb++;
        int i = this.zzc;
        if (i > 0) {
            zzyq[] zzyqVarArr = this.zzd;
            int i2 = i - 1;
            this.zzc = i2;
            zzyqVar = zzyqVarArr[i2];
            zzyqVar.getClass();
            zzyqVarArr[i2] = null;
        } else {
            zzyqVar = new zzyq(new byte[65536], 0);
            int i3 = this.zzb;
            zzyq[] zzyqVarArr2 = this.zzd;
            int length = zzyqVarArr2.length;
            if (i3 > length) {
                this.zzd = (zzyq[]) Arrays.copyOf(zzyqVarArr2, length + length);
                return zzyqVar;
            }
        }
        return zzyqVar;
    }

    public final synchronized void zzc(zzyq zzyqVar) {
        zzyq[] zzyqVarArr = this.zzd;
        int i = this.zzc;
        this.zzc = i + 1;
        zzyqVarArr[i] = zzyqVar;
        this.zzb--;
        notifyAll();
    }

    public final synchronized void zzd(zzyr zzyrVar) {
        while (zzyrVar != null) {
            zzyq[] zzyqVarArr = this.zzd;
            int i = this.zzc;
            this.zzc = i + 1;
            zzyqVarArr[i] = zzyrVar.zzc();
            this.zzb--;
            zzyrVar = zzyrVar.zzd();
        }
        notifyAll();
    }

    public final synchronized void zze() {
        zzf(0);
    }

    public final synchronized void zzf(int i) {
        int i2 = this.zza;
        this.zza = i;
        if (i < i2) {
            zzg();
        }
    }

    public final synchronized void zzg() {
        int i = this.zza;
        int i2 = zzfy.zza;
        int max = Math.max(0, ((i + 65535) / 65536) - this.zzb);
        int i3 = this.zzc;
        if (max >= i3) {
            return;
        }
        Arrays.fill(this.zzd, max, i3, (Object) null);
        this.zzc = max;
    }
}

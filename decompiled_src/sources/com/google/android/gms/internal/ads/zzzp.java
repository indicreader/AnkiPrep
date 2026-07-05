package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzzp {
    private static final Comparator zza = new Comparator() { // from class: com.google.android.gms.internal.ads.zzzl
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((zzzo) obj).zza - ((zzzo) obj2).zza;
        }
    };
    private static final Comparator zzb = new Comparator() { // from class: com.google.android.gms.internal.ads.zzzm
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Float.compare(((zzzo) obj).zzc, ((zzzo) obj2).zzc);
        }
    };
    private int zzf;
    private int zzg;
    private int zzh;
    private final zzzo[] zzd = new zzzo[5];
    private final ArrayList zzc = new ArrayList();
    private int zze = -1;

    public zzzp(int i) {
    }

    public final float zza(float f) {
        if (this.zze != 0) {
            Collections.sort(this.zzc, zzb);
            this.zze = 0;
        }
        float f2 = this.zzg;
        int i = 0;
        for (int i2 = 0; i2 < this.zzc.size(); i2++) {
            float f3 = 0.5f * f2;
            zzzo zzzoVar = (zzzo) this.zzc.get(i2);
            i += zzzoVar.zzb;
            if (i >= f3) {
                return zzzoVar.zzc;
            }
        }
        if (this.zzc.isEmpty()) {
            return Float.NaN;
        }
        return ((zzzo) this.zzc.get(r6.size() - 1)).zzc;
    }

    public final void zzb(int i, float f) {
        zzzo zzzoVar;
        if (this.zze != 1) {
            Collections.sort(this.zzc, zza);
            this.zze = 1;
        }
        int i2 = this.zzh;
        if (i2 > 0) {
            zzzo[] zzzoVarArr = this.zzd;
            int i3 = i2 - 1;
            this.zzh = i3;
            zzzoVar = zzzoVarArr[i3];
        } else {
            zzzoVar = new zzzo(null);
        }
        int i4 = this.zzf;
        this.zzf = i4 + 1;
        zzzoVar.zza = i4;
        zzzoVar.zzb = i;
        zzzoVar.zzc = f;
        this.zzc.add(zzzoVar);
        this.zzg += i;
        while (true) {
            int i5 = this.zzg;
            if (i5 <= 2000) {
                return;
            }
            int i6 = i5 - 2000;
            zzzo zzzoVar2 = (zzzo) this.zzc.get(0);
            int i7 = zzzoVar2.zzb;
            if (i7 <= i6) {
                this.zzg -= i7;
                this.zzc.remove(0);
                int i8 = this.zzh;
                if (i8 < 5) {
                    zzzo[] zzzoVarArr2 = this.zzd;
                    this.zzh = i8 + 1;
                    zzzoVarArr2[i8] = zzzoVar2;
                }
            } else {
                zzzoVar2.zzb = i7 - i6;
                this.zzg -= i6;
            }
        }
    }

    public final void zzc() {
        this.zzc.clear();
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
    }
}

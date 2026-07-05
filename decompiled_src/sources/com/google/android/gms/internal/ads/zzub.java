package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzub implements zzwj {
    protected final zzwj[] zza;

    public zzub(zzwj[] zzwjVarArr) {
        this.zza = zzwjVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final long zzb() {
        long j = Long.MAX_VALUE;
        for (zzwj zzwjVar : this.zza) {
            long zzb = zzwjVar.zzb();
            if (zzb != Long.MIN_VALUE) {
                j = Math.min(j, zzb);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final long zzc() {
        long j = Long.MAX_VALUE;
        for (zzwj zzwjVar : this.zza) {
            long zzc = zzwjVar.zzc();
            if (zzc != Long.MIN_VALUE) {
                j = Math.min(j, zzc);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final void zzm(long j) {
        for (zzwj zzwjVar : this.zza) {
            zzwjVar.zzm(j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final boolean zzo(zzlg zzlgVar) {
        boolean z;
        boolean z2 = false;
        do {
            long zzc = zzc();
            long j = Long.MIN_VALUE;
            if (zzc == Long.MIN_VALUE) {
                break;
            }
            zzwj[] zzwjVarArr = this.zza;
            int length = zzwjVarArr.length;
            int i = 0;
            z = false;
            while (i < length) {
                zzwj zzwjVar = zzwjVarArr[i];
                long zzc2 = zzwjVar.zzc();
                boolean z3 = zzc2 != j && zzc2 <= zzlgVar.zza;
                if (zzc2 == zzc || z3) {
                    z |= zzwjVar.zzo(zzlgVar);
                }
                i++;
                j = Long.MIN_VALUE;
            }
            z2 |= z;
        } while (z);
        return z2;
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final boolean zzp() {
        for (zzwj zzwjVar : this.zza) {
            if (zzwjVar.zzp()) {
                return true;
            }
        }
        return false;
    }
}

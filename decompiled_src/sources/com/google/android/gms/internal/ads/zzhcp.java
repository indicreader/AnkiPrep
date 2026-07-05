package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
abstract class zzhcp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zza(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzb(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object zzc(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object zzd(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object zze(Object obj, Object obj2);

    abstract Object zzf();

    abstract Object zzg(Object obj);

    abstract void zzh(Object obj, int i, int i2);

    abstract void zzi(Object obj, int i, long j);

    abstract void zzj(Object obj, int i, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzk(Object obj, int i, zzgyl zzgylVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzl(Object obj, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzm(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzn(Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzo(Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzq(zzhbq zzhbqVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzr(Object obj, zzgzb zzgzbVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzp(Object obj, zzhbq zzhbqVar) throws IOException {
        int zzd = zzhbqVar.zzd();
        int i = zzd >>> 3;
        int i2 = zzd & 7;
        if (i2 == 0) {
            zzl(obj, i, zzhbqVar.zzl());
            return true;
        }
        if (i2 == 1) {
            zzi(obj, i, zzhbqVar.zzk());
            return true;
        }
        if (i2 == 2) {
            zzk(obj, i, zzhbqVar.zzp());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 == 5) {
                zzh(obj, i, zzhbqVar.zzf());
                return true;
            }
            throw zzhag.zza();
        }
        Object zzf = zzf();
        int i3 = i << 3;
        while (zzhbqVar.zzc() != Integer.MAX_VALUE && zzp(zzf, zzhbqVar)) {
        }
        if ((4 | i3) != zzhbqVar.zzd()) {
            throw zzhag.zzb();
        }
        zzg(zzf);
        zzj(obj, i, zzf);
        return true;
    }
}

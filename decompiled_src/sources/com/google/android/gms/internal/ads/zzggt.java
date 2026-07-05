package com.google.android.gms.internal.ads;

import java.util.Arrays;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzggt {

    @Nullable
    private final Object zza;

    @Nullable
    private final Object zzb;
    private final byte[] zzc;
    private final zzgvz zzd;
    private final int zze;
    private final String zzf;
    private final zzggc zzg;
    private final int zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzggt(@Nullable Object obj, @Nullable Object obj2, byte[] bArr, int i, zzgvz zzgvzVar, int i2, String str, zzggc zzggcVar) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = Arrays.copyOf(bArr, bArr.length);
        this.zzh = i;
        this.zzd = zzgvzVar;
        this.zze = i2;
        this.zzf = str;
        this.zzg = zzggcVar;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzggc zzb() {
        return this.zzg;
    }

    public final zzgvz zzc() {
        return this.zzd;
    }

    @Nullable
    public final Object zzd() {
        return this.zza;
    }

    @Nullable
    public final Object zze() {
        return this.zzb;
    }

    public final String zzf() {
        return this.zzf;
    }

    @Nullable
    public final byte[] zzg() {
        byte[] bArr = this.zzc;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final int zzh() {
        return this.zzh;
    }
}

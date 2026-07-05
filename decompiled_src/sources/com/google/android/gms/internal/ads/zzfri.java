package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfri implements zzfrj {
    private static final zzatd zza;

    static {
        zzasg zza2 = zzatd.zza();
        zza2.zzx(ExifInterface.LONGITUDE_EAST);
        zza = (zzatd) zza2.zzal();
    }

    @Override // com.google.android.gms.internal.ads.zzfrj
    public final zzatd zza() {
        return zza;
    }
}

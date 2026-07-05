package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzchj extends zzari {
    static final zzchj zzb = new zzchj();

    zzchj() {
    }

    @Override // com.google.android.gms.internal.ads.zzari
    public final zzarm zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzaro();
        }
        if ("mvhd".equals(str)) {
            return new zzarp();
        }
        return new zzarq(str);
    }
}

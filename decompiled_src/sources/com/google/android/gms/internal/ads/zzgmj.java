package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgmj extends zzgmk {
    public zzgmj(byte[] bArr) throws GeneralSecurityException {
        super(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzgmk
    final zzgmi zza(byte[] bArr, int i) throws InvalidKeyException {
        return new zzgmh(bArr, i);
    }
}

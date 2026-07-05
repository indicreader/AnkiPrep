package com.google.mlkit.vision.common;

import android.media.Image;

/* compiled from: com.google.mlkit:vision-common@@17.3.0 */
/* loaded from: classes4.dex */
final class zzb {
    private final Image zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(Image image) {
        this.zza = image;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Image zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Image.Plane[] zzb() {
        return this.zza.getPlanes();
    }
}

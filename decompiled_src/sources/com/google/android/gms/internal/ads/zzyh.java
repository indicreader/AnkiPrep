package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzyh {
    public final zzcz zza;
    public final int[] zzb;

    public zzyh(zzcz zzczVar, int[] iArr, int i) {
        if (iArr.length == 0) {
            zzff.zzd("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
        }
        this.zza = zzczVar;
        this.zzb = iArr;
    }
}

package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzzx implements zzdm {
    private static final zzfxu zza = zzfxx.zza(new zzfxu() { // from class: com.google.android.gms.internal.ads.zzzv
        @Override // com.google.android.gms.internal.ads.zzfxu
        public final Object zza() {
            try {
                Class<?> cls = Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
                Object invoke = cls.getMethod("build", new Class[0]).invoke(cls.getConstructor(new Class[0]).newInstance(new Object[0]), new Object[0]);
                invoke.getClass();
                return (zzdm) invoke;
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    });

    private zzzx() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzzx(zzzw zzzwVar) {
    }
}

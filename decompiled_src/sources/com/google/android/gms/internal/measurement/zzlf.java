package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
/* loaded from: classes3.dex */
final class zzlf {
    private static final zzle zza;
    private static final zzle zzb;

    static {
        zzle zzleVar;
        try {
            zzleVar = (zzle) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzleVar = null;
        }
        zza = zzleVar;
        zzb = new zzle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzle zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzle zzb() {
        return zzb;
    }
}

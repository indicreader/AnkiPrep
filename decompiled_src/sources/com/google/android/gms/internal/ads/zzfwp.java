package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzfwp implements zzfxf {
    public static zzfwp zzc(char c) {
        return new zzfwm(c);
    }

    @Override // com.google.android.gms.internal.ads.zzfxf
    @Deprecated
    public final /* synthetic */ boolean zza(Object obj) {
        return zzb(((Character) obj).charValue());
    }

    public abstract boolean zzb(char c);
}

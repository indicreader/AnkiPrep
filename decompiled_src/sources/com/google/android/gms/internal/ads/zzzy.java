package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzzy implements zzcp {
    private final zzdm zza;

    public zzzy(zzdm zzdmVar) {
        this.zza = zzdmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final zzcq zza(Context context, zzt zztVar, zzt zztVar2, zzw zzwVar, zzdn zzdnVar, Executor executor, List list, long j) throws zzdl {
        Constructor<?> constructor;
        Object[] objArr;
        try {
            constructor = Class.forName("androidx.media3.effect.PreviewingSingleInputVideoGraph$Factory").getConstructor(zzdm.class);
            objArr = new Object[1];
        } catch (Exception e) {
            e = e;
        }
        try {
            objArr[0] = this.zza;
            return ((zzcp) constructor.newInstance(objArr)).zza(context, zztVar, zztVar2, zzwVar, zzdnVar, executor, list, 0L);
        } catch (Exception e2) {
            e = e2;
            if (e instanceof zzdl) {
                throw ((zzdl) e);
            }
            throw new zzdl(e, -9223372036854775807L);
        }
    }
}

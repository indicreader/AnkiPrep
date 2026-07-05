package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzccl implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzccm zza;
    private final String zzb;

    public zzccl(zzccm zzccmVar, String str) {
        this.zza = zzccmVar;
        this.zzb = str;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        List<zzcck> list;
        synchronized (this.zza) {
            list = this.zza.zzb;
            for (zzcck zzcckVar : list) {
                zzcckVar.zza.zzb(zzcckVar.zzb, sharedPreferences, this.zzb, str);
            }
        }
    }
}

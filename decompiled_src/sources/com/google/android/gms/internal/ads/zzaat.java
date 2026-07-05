package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.WindowManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzaat implements zzaas {
    private final WindowManager zza;

    private zzaat(WindowManager windowManager) {
        this.zza = windowManager;
    }

    public static zzaas zzc(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            return new zzaat(windowManager);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaas
    public final void zza() {
    }

    @Override // com.google.android.gms.internal.ads.zzaas
    public final void zzb(zzaap zzaapVar) {
        zzaaw.zzb(zzaapVar.zza, this.zza.getDefaultDisplay());
    }
}

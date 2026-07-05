package com.google.android.gms.internal.ads;

import android.app.AppOpsManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzawr implements AppOpsManager.OnOpActiveChangedListener {
    final /* synthetic */ zzaws zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawr(zzaws zzawsVar) {
        this.zza = zzawsVar;
    }

    @Override // android.app.AppOpsManager.OnOpActiveChangedListener
    public final void onOpActiveChanged(String str, int i, String str2, boolean z) {
        long j;
        long j2;
        long j3;
        if (z) {
            this.zza.zzb = System.currentTimeMillis();
            this.zza.zze = true;
            return;
        }
        zzaws zzawsVar = this.zza;
        long currentTimeMillis = System.currentTimeMillis();
        j = zzawsVar.zzc;
        if (j > 0) {
            zzaws zzawsVar2 = this.zza;
            j2 = zzawsVar2.zzc;
            if (currentTimeMillis >= j2) {
                j3 = zzawsVar2.zzc;
                zzawsVar2.zzd = currentTimeMillis - j3;
            }
        }
        this.zza.zze = false;
    }
}

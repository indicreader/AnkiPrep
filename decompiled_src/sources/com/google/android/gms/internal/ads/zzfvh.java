package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfvh extends zzfvu {
    final /* synthetic */ zzfvn zza;
    final /* synthetic */ zzfvq zzb;
    final /* synthetic */ TaskCompletionSource zzc;
    final /* synthetic */ zzfvl zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfvh(zzfvl zzfvlVar, TaskCompletionSource taskCompletionSource, zzfvn zzfvnVar, zzfvq zzfvqVar, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zza = zzfvnVar;
        this.zzb = zzfvqVar;
        this.zzc = taskCompletionSource2;
        this.zzd = zzfvlVar;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.gms.internal.ads.zzfum] */
    @Override // com.google.android.gms.internal.ads.zzfvu
    protected final void zza() {
        zzfvt zzfvtVar;
        String str;
        String str2;
        String str3;
        try {
            ?? zze = this.zzd.zza.zze();
            if (zze == 0) {
                return;
            }
            zzfvl zzfvlVar = this.zzd;
            str2 = zzfvlVar.zzd;
            zzfvn zzfvnVar = this.zza;
            str3 = zzfvlVar.zzd;
            Bundle bundle = new Bundle();
            bundle.putBinder("windowToken", zzfvnVar.zze());
            bundle.putString("adFieldEnifd", zzfvnVar.zzf());
            bundle.putInt("layoutGravity", zzfvnVar.zzc());
            bundle.putFloat("layoutVerticalMargin", zzfvnVar.zza());
            bundle.putInt("displayMode", 0);
            bundle.putInt("windowWidthPx", zzfvnVar.zzd());
            bundle.putString("deeplinkUrl", null);
            bundle.putBoolean("stableSessionToken", false);
            bundle.putString("callerPackage", str3);
            if (zzfvnVar.zzg() != null) {
                bundle.putString("appId", zzfvnVar.zzg());
            }
            zze.zzf(str2, bundle, new zzfvk(this.zzd, this.zzb));
        } catch (RemoteException e) {
            zzfvl zzfvlVar2 = this.zzd;
            zzfvtVar = zzfvl.zzb;
            str = zzfvlVar2.zzd;
            zzfvtVar.zzb(e, "show overlay display from: %s", str);
            this.zzc.trySetException(new RuntimeException(e));
        }
    }
}

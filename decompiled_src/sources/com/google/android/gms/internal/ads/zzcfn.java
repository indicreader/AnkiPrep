package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcfn implements Runnable {
    final /* synthetic */ zzcfp zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcfn(zzcfp zzcfpVar) {
        this.zza = zzcfpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcfq zzcfqVar;
        boolean z;
        zzcfq zzcfqVar2;
        zzcfq zzcfqVar3;
        zzcfp zzcfpVar = this.zza;
        zzcfqVar = zzcfpVar.zzq;
        if (zzcfqVar != null) {
            z = zzcfpVar.zzr;
            if (!z) {
                zzcfqVar3 = zzcfpVar.zzq;
                zzcfqVar3.zzg();
                this.zza.zzr = true;
            }
            zzcfqVar2 = this.zza.zzq;
            zzcfqVar2.zze();
        }
    }
}

package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzapy implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzaqa zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzapy(zzaqa zzaqaVar, String str, long j) {
        this.zza = str;
        this.zzb = j;
        this.zzc = zzaqaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaql zzaqlVar;
        zzaql zzaqlVar2;
        zzaqlVar = this.zzc.zza;
        zzaqlVar.zza(this.zza, this.zzb);
        zzaqa zzaqaVar = this.zzc;
        zzaqlVar2 = zzaqaVar.zza;
        zzaqlVar2.zzb(zzaqaVar.toString());
    }
}

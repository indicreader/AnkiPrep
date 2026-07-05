package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbrh implements zzcey {
    final /* synthetic */ zzbri zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbrh(zzbri zzbriVar) {
        this.zza = zzbriVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcey
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        final zzbqe zzbqeVar = (zzbqe) obj;
        zzcep.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbrg
            @Override // java.lang.Runnable
            public final void run() {
                zzbqe zzbqeVar2 = zzbqeVar;
                zzbqeVar2.zzr("/result", zzbnf.zzo);
                zzbqeVar2.zzc();
            }
        });
    }
}

package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzdwa;
import com.google.android.gms.internal.ads.zzdwk;
import com.google.android.gms.internal.ads.zzgej;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzz implements zzgej {
    final /* synthetic */ zzaa zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzz(zzaa zzaaVar) {
        this.zza = zzaaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        zzdwk zzdwkVar;
        zzdwa zzdwaVar;
        AtomicInteger atomicInteger;
        AtomicBoolean atomicBoolean;
        AtomicInteger atomicInteger2;
        com.google.android.gms.ads.internal.zzt.zzo().zzw(th, "SignalGeneratorImpl.initializeWebViewForSignalCollection");
        zzaa zzaaVar = this.zza;
        zzdwkVar = zzaaVar.zzs;
        zzdwaVar = zzaaVar.zzk;
        atomicInteger = this.zza.zzK;
        zzf.zzc(zzdwkVar, zzdwaVar, "sgf", new Pair("sgf_reason", th.getMessage()), new Pair("sgi_rn", Integer.toString(atomicInteger.get())));
        zzcec.zzh("Failed to initialize webview for loading SDKCore. ", th);
        if (((Boolean) zzba.zzc().zza(zzbgc.zzjw)).booleanValue()) {
            atomicBoolean = this.zza.zzJ;
            if (atomicBoolean.get()) {
                return;
            }
            atomicInteger2 = this.zza.zzK;
            if (atomicInteger2.getAndIncrement() < ((Integer) zzba.zzc().zza(zzbgc.zzjx)).intValue()) {
                this.zza.zzW();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdwk zzdwkVar;
        zzdwa zzdwaVar;
        AtomicInteger atomicInteger;
        AtomicBoolean atomicBoolean;
        zzcec.zze("Initialized webview successfully for SDKCore.");
        if (((Boolean) zzba.zzc().zza(zzbgc.zzjw)).booleanValue()) {
            zzaa zzaaVar = this.zza;
            zzdwkVar = zzaaVar.zzs;
            zzdwaVar = zzaaVar.zzk;
            atomicInteger = zzaaVar.zzK;
            zzf.zzc(zzdwkVar, zzdwaVar, "sgs", new Pair("sgi_rn", Integer.toString(atomicInteger.get())));
            atomicBoolean = this.zza.zzJ;
            atomicBoolean.set(true);
        }
    }
}

package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzfdz {
    private final zzfiv zza;
    private final zzdae zzb;
    private final Executor zzc;
    private zzfdy zzd;

    public zzfdz(zzfiv zzfivVar, zzdae zzdaeVar, Executor executor) {
        this.zza = zzfivVar;
        this.zzb = zzdaeVar;
        this.zzc = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public final zzfjf zze() {
        zzfhh zzg = this.zzb.zzg();
        return this.zza.zzc(zzg.zzd, zzg.zzf, zzg.zzj);
    }

    public final ListenableFuture zzc() {
        ListenableFuture zze;
        zzfdy zzfdyVar = this.zzd;
        if (zzfdyVar == null) {
            if (!((Boolean) zzbih.zza.zze()).booleanValue()) {
                zzfdy zzfdyVar2 = new zzfdy(null, zze(), null);
                this.zzd = zzfdyVar2;
                zze = zzgen.zzh(zzfdyVar2);
            } else {
                zze = zzgen.zze(zzgen.zzm(zzgee.zzu(this.zzb.zzb().zze(this.zza.zza())), new zzfdw(this), this.zzc), zzecf.class, new zzfdv(this), this.zzc);
            }
            return zzgen.zzm(zze, new zzfws() { // from class: com.google.android.gms.internal.ads.zzfdu
                @Override // com.google.android.gms.internal.ads.zzfws
                public final Object apply(Object obj) {
                    return (zzfdy) obj;
                }
            }, this.zzc);
        }
        return zzgen.zzh(zzfdyVar);
    }
}

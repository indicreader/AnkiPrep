package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzesd implements zzexq {
    private final zzgey zza;
    private final zzdua zzb;
    private final zzdyi zzc;
    private final zzesf zzd;

    public zzesd(zzgey zzgeyVar, zzdua zzduaVar, zzdyi zzdyiVar, zzesf zzesfVar) {
        this.zza = zzgeyVar;
        this.zzb = zzduaVar;
        this.zzc = zzdyiVar;
        this.zzd = zzesfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlc)).booleanValue() || this.zzd.zza() == null) {
            if (!zzfxt.zzd((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbr))) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlc)).booleanValue() || (!this.zzd.zzd() && this.zzc.zzt())) {
                    this.zzd.zzc(true);
                    return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesc
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return zzesd.this.zzc();
                        }
                    });
                }
            }
            return zzgen.zzh(new zzese(new Bundle()));
        }
        zzese zza = this.zzd.zza();
        zza.getClass();
        return zzgen.zzh(zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzese zzc() throws Exception {
        List<String> asList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbr)).split(";"));
        Bundle bundle = new Bundle();
        for (String str : asList) {
            try {
                zzfif zzc = this.zzb.zzc(str, new JSONObject());
                zzc.zzC();
                boolean zzt = this.zzc.zzt();
                Bundle bundle2 = new Bundle();
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlc)).booleanValue() || zzt) {
                    try {
                        zzbvg zzf = zzc.zzf();
                        if (zzf != null) {
                            bundle2.putString("sdk_version", zzf.toString());
                        }
                    } catch (zzfho unused) {
                    }
                }
                try {
                    zzbvg zze = zzc.zze();
                    if (zze != null) {
                        bundle2.putString("adapter_version", zze.toString());
                    }
                } catch (zzfho unused2) {
                }
                bundle.putBundle(str, bundle2);
            } catch (zzfho unused3) {
            }
        }
        zzese zzeseVar = new zzese(bundle);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlc)).booleanValue()) {
            this.zzd.zzb(zzeseVar);
        }
        return zzeseVar;
    }
}

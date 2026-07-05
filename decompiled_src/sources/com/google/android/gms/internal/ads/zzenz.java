package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzenz implements zzein {
    private final zzeip zza;
    private final zzeit zzb;
    private final zzflm zzc;
    private final zzgey zzd;

    public zzenz(zzflm zzflmVar, zzgey zzgeyVar, zzeip zzeipVar, zzeit zzeitVar) {
        this.zzc = zzflmVar;
        this.zzd = zzgeyVar;
        this.zzb = zzeitVar;
        this.zza = zzeipVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String zze(String str, int i) {
        return "Error from: " + str + ", code: " + i;
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final ListenableFuture zza(final zzfgy zzfgyVar, final zzfgm zzfgmVar) {
        final zzeiq zzeiqVar;
        Iterator it = zzfgmVar.zzu.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzeiqVar = null;
                break;
            }
            try {
                zzeiqVar = this.zza.zza((String) it.next(), zzfgmVar.zzw);
                break;
            } catch (zzfho unused) {
            }
        }
        if (zzeiqVar == null) {
            return zzgen.zzg(new zzelp("Unable to instantiate mediation adapter class."));
        }
        zzceu zzceuVar = new zzceu();
        zzeiqVar.zzc.zza(new zzeny(this, zzeiqVar, zzceuVar));
        if (zzfgmVar.zzN) {
            Bundle bundle = zzfgyVar.zza.zza.zzd.zzm;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        zzflm zzflmVar = this.zzc;
        return zzfkw.zzd(new zzfkq() { // from class: com.google.android.gms.internal.ads.zzenw
            @Override // com.google.android.gms.internal.ads.zzfkq
            public final void zza() {
                zzenz.this.zzd(zzfgyVar, zzfgmVar, zzeiqVar);
            }
        }, this.zzd, zzflg.ADAPTER_LOAD_AD_SYN, zzflmVar).zzb(zzflg.ADAPTER_LOAD_AD_ACK).zzd(zzceuVar).zzb(zzflg.ADAPTER_WRAP_ADAPTER).zze(new zzfkp() { // from class: com.google.android.gms.internal.ads.zzenx
            @Override // com.google.android.gms.internal.ads.zzfkp
            public final Object zza(Object obj) {
                return zzenz.this.zzc(zzfgyVar, zzfgmVar, zzeiqVar, (Void) obj);
            }
        }).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final boolean zzb(zzfgy zzfgyVar, zzfgm zzfgmVar) {
        return !zzfgmVar.zzu.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar, Void r4) throws Exception {
        return this.zzb.zza(zzfgyVar, zzfgmVar, zzeiqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws Exception {
        this.zzb.zzb(zzfgyVar, zzfgmVar, zzeiqVar);
    }
}

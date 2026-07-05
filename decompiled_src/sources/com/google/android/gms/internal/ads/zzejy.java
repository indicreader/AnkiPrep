package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzejy implements zzeit {
    private final Context zza;
    private final zzcvc zzb;
    private View zzc;
    private zzbte zzd;

    public zzejy(Context context, zzcvc zzcvcVar) {
        this.zza = context;
        this.zzb = zzcvcVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzeit
    public final /* bridge */ /* synthetic */ Object zza(zzfgy zzfgyVar, final zzfgm zzfgmVar, final zzeiq zzeiqVar) throws zzfho, zzeml {
        final View view;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhI)).booleanValue() && zzfgmVar.zzah) {
            try {
                view = (View) ObjectWrapper.unwrap(this.zzd.zze());
                boolean zzf = this.zzd.zzf();
                if (view == null) {
                    throw new zzfho(new Exception("BannerRtbAdapterWrapper interscrollerView should not be null"));
                }
                if (zzf) {
                    try {
                        view = (View) zzgen.zzn(zzgen.zzh(null), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzejv
                            @Override // com.google.android.gms.internal.ads.zzgdu
                            public final ListenableFuture zza(Object obj) {
                                return zzejy.this.zzc(view, zzfgmVar, obj);
                            }
                        }, zzcep.zze).get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new zzfho(e);
                    }
                }
            } catch (RemoteException e2) {
                throw new zzfho(e2);
            }
        } else {
            view = this.zzc;
        }
        zzcug zza = this.zzb.zza(new zzcwx(zzfgyVar, zzfgmVar, zzeiqVar.zza), new zzcum(view, null, new zzcwf() { // from class: com.google.android.gms.internal.ads.zzeju
            @Override // com.google.android.gms.internal.ads.zzcwf
            public final com.google.android.gms.ads.internal.client.zzdq zza() {
                try {
                    return ((zzbus) zzeiq.this.zzb).zze();
                } catch (RemoteException e3) {
                    throw new zzfho(e3);
                }
            }
        }, (zzfgn) zzfgmVar.zzv.get(0)));
        zza.zzg().zza(view);
        ((zzekj) zzeiqVar.zzc).zzc(zza.zzi());
        return zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final void zzb(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzfho {
        try {
            ((zzbus) zzeiqVar.zzb).zzq(zzfgmVar.zzaa);
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhI)).booleanValue() || !zzfgmVar.zzah) {
                ((zzbus) zzeiqVar.zzb).zzj(zzfgmVar.zzV, zzfgmVar.zzw.toString(), zzfgyVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzejx(this, zzeiqVar, null), (zzbtb) zzeiqVar.zzc, zzfgyVar.zza.zza.zze);
            } else {
                ((zzbus) zzeiqVar.zzb).zzk(zzfgmVar.zzV, zzfgmVar.zzw.toString(), zzfgyVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzejx(this, zzeiqVar, null), (zzbtb) zzeiqVar.zzc, zzfgyVar.zza.zza.zze);
            }
        } catch (RemoteException e) {
            throw new zzfho(e);
        }
    }

    public final /* synthetic */ ListenableFuture zzc(View view, zzfgm zzfgmVar, Object obj) throws Exception {
        return zzgen.zzh(zzcvt.zza(this.zza, view, zzfgmVar));
    }
}

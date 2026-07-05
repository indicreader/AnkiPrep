package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcui extends zzcuf {
    private final Context zzc;
    private final View zzd;
    private final zzcjk zze;
    private final zzfgn zzf;
    private final zzcwf zzg;
    private final zzdnl zzh;
    private final zzdiw zzi;
    private final zzhgx zzj;
    private final Executor zzk;
    private com.google.android.gms.ads.internal.client.zzq zzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcui(zzcwg zzcwgVar, Context context, zzfgn zzfgnVar, View view, zzcjk zzcjkVar, zzcwf zzcwfVar, zzdnl zzdnlVar, zzdiw zzdiwVar, zzhgx zzhgxVar, Executor executor) {
        super(zzcwgVar);
        this.zzc = context;
        this.zzd = view;
        this.zze = zzcjkVar;
        this.zzf = zzfgnVar;
        this.zzg = zzcwfVar;
        this.zzh = zzdnlVar;
        this.zzi = zzdiwVar;
        this.zzj = zzhgxVar;
        this.zzk = executor;
    }

    public static /* synthetic */ void zzi(zzcui zzcuiVar) {
        zzdnl zzdnlVar = zzcuiVar.zzh;
        if (zzdnlVar.zze() == null) {
            return;
        }
        try {
            zzdnlVar.zze().zze((com.google.android.gms.ads.internal.client.zzbu) zzcuiVar.zzj.zzb(), ObjectWrapper.wrap(zzcuiVar.zzc));
        } catch (RemoteException e) {
            zzcec.zzh("RemoteException when notifyAdLoad is called", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcuf
    public final int zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhI)).booleanValue() && this.zzb.zzah) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhJ)).booleanValue()) {
                return 0;
            }
        }
        return this.zza.zzb.zzb.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzcuf
    public final View zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcuf
    public final com.google.android.gms.ads.internal.client.zzdq zzd() {
        try {
            return this.zzg.zza();
        } catch (zzfho unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcuf
    public final zzfgn zze() {
        com.google.android.gms.ads.internal.client.zzq zzqVar = this.zzl;
        if (zzqVar != null) {
            return zzfhn.zzb(zzqVar);
        }
        zzfgm zzfgmVar = this.zzb;
        if (zzfgmVar.zzad) {
            for (String str : zzfgmVar.zza) {
                if (str == null || !str.contains("FirstParty")) {
                }
            }
            View view = this.zzd;
            return new zzfgn(view.getWidth(), view.getHeight(), false);
        }
        return (zzfgn) this.zzb.zzs.get(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcuf
    public final zzfgn zzf() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzcuf
    public final void zzg() {
        this.zzi.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcuf
    public final void zzh(ViewGroup viewGroup, com.google.android.gms.ads.internal.client.zzq zzqVar) {
        zzcjk zzcjkVar;
        if (viewGroup == null || (zzcjkVar = this.zze) == null) {
            return;
        }
        zzcjkVar.zzah(zzcla.zzc(zzqVar));
        viewGroup.setMinimumHeight(zzqVar.zzc);
        viewGroup.setMinimumWidth(zzqVar.zzf);
        this.zzl = zzqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcwh
    public final void zzj() {
        this.zzk.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcuh
            @Override // java.lang.Runnable
            public final void run() {
                zzcui.zzi(zzcui.this);
            }
        });
        super.zzj();
    }
}

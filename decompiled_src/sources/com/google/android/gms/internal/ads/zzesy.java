package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzesy implements zzexq {
    private static final Object zzb = new Object();
    final Context zza;
    private final String zzc;
    private final String zzd;
    private final zzcyb zze;
    private final zzfip zzf;
    private final zzfhh zzg;
    private final com.google.android.gms.ads.internal.util.zzg zzh = com.google.android.gms.ads.internal.zzt.zzo().zzi();
    private final zzdwa zzi;
    private final zzcyo zzj;

    public zzesy(Context context, String str, String str2, zzcyb zzcybVar, zzfip zzfipVar, zzfhh zzfhhVar, zzdwa zzdwaVar, zzcyo zzcyoVar) {
        this.zza = context;
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzcybVar;
        this.zzf = zzfipVar;
        this.zzg = zzfhhVar;
        this.zzi = zzdwaVar;
        this.zzj = zzcyoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 12;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        final Bundle bundle = new Bundle();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhy)).booleanValue()) {
            zzdwa zzdwaVar = this.zzi;
            zzdwaVar.zza().put("seq_num", this.zzc);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfA)).booleanValue()) {
            this.zze.zzk(this.zzg.zzd);
            bundle.putAll(this.zzf.zzb());
        }
        return zzgen.zzh(new zzexp() { // from class: com.google.android.gms.internal.ads.zzesx
            @Override // com.google.android.gms.internal.ads.zzexp
            public final void zzj(Object obj) {
                zzesy.this.zzc(bundle, (Bundle) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Bundle bundle, Bundle bundle2) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfA)).booleanValue()) {
            bundle2.putBundle("quality_signals", bundle);
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfz)).booleanValue()) {
                synchronized (zzb) {
                    this.zze.zzk(this.zzg.zzd);
                    bundle2.putBundle("quality_signals", this.zzf.zzb());
                }
            } else {
                this.zze.zzk(this.zzg.zzd);
                bundle2.putBundle("quality_signals", this.zzf.zzb());
            }
        }
        bundle2.putString("seq_num", this.zzc);
        if (!this.zzh.zzQ()) {
            bundle2.putString("session_id", this.zzd);
        }
        bundle2.putBoolean("client_purpose_one", !this.zzh.zzQ());
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfB)).booleanValue()) {
            try {
                com.google.android.gms.ads.internal.zzt.zzp();
                bundle2.putString("_app_id", com.google.android.gms.ads.internal.util.zzt.zzp(this.zza));
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "AppStatsSignal_AppId");
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfC)).booleanValue() && this.zzg.zzf != null) {
            Bundle bundle3 = new Bundle();
            bundle3.putLong("dload", this.zzj.zzb(this.zzg.zzf));
            bundle3.putInt("pcc", this.zzj.zza(this.zzg.zzf));
            bundle2.putBundle("ad_unit_quality_signals", bundle3);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjy)).booleanValue() || com.google.android.gms.ads.internal.zzt.zzo().zza() <= 0) {
            return;
        }
        bundle2.putInt("nrwv", com.google.android.gms.ads.internal.zzt.zzo().zza());
    }
}

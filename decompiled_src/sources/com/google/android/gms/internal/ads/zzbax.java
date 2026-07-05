package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbax {
    private ScheduledFuture zza = null;
    private final Runnable zzb = new zzbat(this);
    private final Object zzc = new Object();
    private zzbba zzd;
    private Context zze;
    private zzbbd zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzh(zzbax zzbaxVar) {
        synchronized (zzbaxVar.zzc) {
            zzbba zzbbaVar = zzbaxVar.zzd;
            if (zzbbaVar == null) {
                return;
            }
            if (zzbbaVar.isConnected() || zzbaxVar.zzd.isConnecting()) {
                zzbaxVar.zzd.disconnect();
            }
            zzbaxVar.zzd = null;
            zzbaxVar.zzf = null;
            Binder.flushPendingCommands();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzl() {
        synchronized (this.zzc) {
            if (this.zze != null && this.zzd == null) {
                zzbba zzd = zzd(new zzbav(this), new zzbaw(this));
                this.zzd = zzd;
                zzd.checkAvailabilityAndConnect();
            }
        }
    }

    public final long zza(zzbbb zzbbbVar) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                return -2L;
            }
            if (this.zzd.zzp()) {
                try {
                    return this.zzf.zze(zzbbbVar);
                } catch (RemoteException e) {
                    zzcec.zzh("Unable to call into cache service.", e);
                }
            }
            return -2L;
        }
    }

    public final zzbay zzb(zzbbb zzbbbVar) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                return new zzbay();
            }
            try {
                if (this.zzd.zzp()) {
                    return this.zzf.zzg(zzbbbVar);
                }
                return this.zzf.zzf(zzbbbVar);
            } catch (RemoteException e) {
                zzcec.zzh("Unable to call into cache service.", e);
                return new zzbay();
            }
        }
    }

    protected final synchronized zzbba zzd(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzbba(this.zze, com.google.android.gms.ads.internal.zzt.zzt().zzb(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    public final void zzi(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.zzc) {
            if (this.zze != null) {
                return;
            }
            this.zze = context.getApplicationContext();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzef)).booleanValue()) {
                zzl();
            } else {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzee)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzt.zzb().zzc(new zzbau(this));
                }
            }
        }
    }

    public final void zzj() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeg)).booleanValue()) {
            synchronized (this.zzc) {
                zzl();
                ScheduledFuture scheduledFuture = this.zza;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.zza = zzcep.zzd.schedule(this.zzb, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeh)).longValue(), TimeUnit.MILLISECONDS);
            }
        }
    }
}

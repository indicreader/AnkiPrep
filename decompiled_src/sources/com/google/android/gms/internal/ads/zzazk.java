package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes3.dex */
public final class zzazk {
    private final Object zza = new Object();
    private zzazi zzb = null;
    private boolean zzc = false;

    public final Activity zza() {
        synchronized (this.zza) {
            zzazi zzaziVar = this.zzb;
            if (zzaziVar == null) {
                return null;
            }
            return zzaziVar.zza();
        }
    }

    public final Context zzb() {
        synchronized (this.zza) {
            zzazi zzaziVar = this.zzb;
            if (zzaziVar == null) {
                return null;
            }
            return zzaziVar.zzb();
        }
    }

    public final void zzc(zzazj zzazjVar) {
        synchronized (this.zza) {
            if (this.zzb == null) {
                this.zzb = new zzazi();
            }
            this.zzb.zzf(zzazjVar);
        }
    }

    public final void zzd(Context context) {
        synchronized (this.zza) {
            if (!this.zzc) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                if (application == null) {
                    zzcec.zzj("Can not cast Context to Application");
                    return;
                }
                if (this.zzb == null) {
                    this.zzb = new zzazi();
                }
                this.zzb.zzg(application, context);
                this.zzc = true;
            }
        }
    }

    public final void zze(zzazj zzazjVar) {
        synchronized (this.zza) {
            zzazi zzaziVar = this.zzb;
            if (zzaziVar == null) {
                return;
            }
            zzaziVar.zzh(zzazjVar);
        }
    }
}

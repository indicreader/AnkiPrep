package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeac extends zzfua {
    private final Context zzb;

    @Nullable
    private SensorManager zzc;
    private Sensor zzd;
    private long zze;
    private int zzf;
    private zzeab zzg;
    private boolean zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeac(Context context) {
        super("ShakeDetector", "ads");
        this.zzb = context;
    }

    @Override // com.google.android.gms.internal.ads.zzfua
    public final void zza(SensorEvent sensorEvent) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziR)).booleanValue()) {
            float f = sensorEvent.values[0] / 9.80665f;
            float f2 = sensorEvent.values[1] / 9.80665f;
            float f3 = sensorEvent.values[2] / 9.80665f;
            if (((float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3))) >= ((Float) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziS)).floatValue()) {
                long currentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
                if (this.zze + ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziT)).intValue() <= currentTimeMillis) {
                    if (this.zze + ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziU)).intValue() < currentTimeMillis) {
                        this.zzf = 0;
                    }
                    com.google.android.gms.ads.internal.util.zze.zza("Shake detected.");
                    this.zze = currentTimeMillis;
                    int i = this.zzf + 1;
                    this.zzf = i;
                    zzeab zzeabVar = this.zzg;
                    if (zzeabVar != null) {
                        if (i == ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziV)).intValue()) {
                            zzdzd zzdzdVar = (zzdzd) zzeabVar;
                            zzdzdVar.zzh(new zzdza(zzdzdVar), zzdzc.GESTURE);
                        }
                    }
                }
            }
        }
    }

    public final void zzb() {
        synchronized (this) {
            if (this.zzh) {
                SensorManager sensorManager = this.zzc;
                if (sensorManager != null) {
                    sensorManager.unregisterListener(this, this.zzd);
                    com.google.android.gms.ads.internal.util.zze.zza("Stopped listening for shake gestures.");
                }
                this.zzh = false;
            }
        }
    }

    public final void zzc() {
        SensorManager sensorManager;
        Sensor sensor;
        synchronized (this) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziR)).booleanValue()) {
                if (this.zzc == null) {
                    SensorManager sensorManager2 = (SensorManager) this.zzb.getSystemService("sensor");
                    this.zzc = sensorManager2;
                    if (sensorManager2 != null) {
                        this.zzd = sensorManager2.getDefaultSensor(1);
                    } else {
                        zzcec.zzj("Shake detection failed to initialize. Failed to obtain accelerometer.");
                        return;
                    }
                }
                if (!this.zzh && (sensorManager = this.zzc) != null && (sensor = this.zzd) != null) {
                    sensorManager.registerListener(this, sensor, 2);
                    this.zze = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziT)).intValue();
                    this.zzh = true;
                    com.google.android.gms.ads.internal.util.zze.zza("Listening for shake gestures.");
                }
            }
        }
    }

    public final void zzd(zzeab zzeabVar) {
        this.zzg = zzeabVar;
    }
}

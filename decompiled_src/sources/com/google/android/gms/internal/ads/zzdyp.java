package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdyp extends zzfua {

    @Nullable
    private final SensorManager zzb;

    @Nullable
    private final Sensor zzc;
    private float zzd;
    private Float zze;
    private long zzf;
    private int zzg;
    private boolean zzh;
    private boolean zzi;

    @Nullable
    private zzdyo zzj;
    private boolean zzk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdyp(Context context) {
        super("FlickDetector", "ads");
        this.zzd = 0.0f;
        this.zze = Float.valueOf(0.0f);
        this.zzf = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
        this.zzg = 0;
        this.zzh = false;
        this.zzi = false;
        this.zzj = null;
        this.zzk = false;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.zzb = sensorManager;
        if (sensorManager != null) {
            this.zzc = sensorManager.getDefaultSensor(4);
        } else {
            this.zzc = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfua
    public final void zza(SensorEvent sensorEvent) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziW)).booleanValue()) {
            long currentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
            if (this.zzf + ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziY)).intValue() < currentTimeMillis) {
                this.zzg = 0;
                this.zzf = currentTimeMillis;
                this.zzh = false;
                this.zzi = false;
                this.zzd = this.zze.floatValue();
            }
            Float valueOf = Float.valueOf(this.zze.floatValue() + (sensorEvent.values[1] * 4.0f));
            this.zze = valueOf;
            if (valueOf.floatValue() > this.zzd + ((Float) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziX)).floatValue()) {
                this.zzd = this.zze.floatValue();
                this.zzi = true;
            } else {
                if (this.zze.floatValue() < this.zzd - ((Float) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziX)).floatValue()) {
                    this.zzd = this.zze.floatValue();
                    this.zzh = true;
                }
            }
            if (this.zze.isInfinite()) {
                this.zze = Float.valueOf(0.0f);
                this.zzd = 0.0f;
            }
            if (this.zzh && this.zzi) {
                com.google.android.gms.ads.internal.util.zze.zza("Flick detected.");
                this.zzf = currentTimeMillis;
                int i = this.zzg + 1;
                this.zzg = i;
                this.zzh = false;
                this.zzi = false;
                zzdyo zzdyoVar = this.zzj;
                if (zzdyoVar != null) {
                    if (i == ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziZ)).intValue()) {
                        zzdzd zzdzdVar = (zzdzd) zzdyoVar;
                        zzdzdVar.zzh(new zzdzb(zzdzdVar), zzdzc.GESTURE);
                    }
                }
            }
        }
    }

    public final void zzb() {
        SensorManager sensorManager;
        Sensor sensor;
        synchronized (this) {
            if (this.zzk && (sensorManager = this.zzb) != null && (sensor = this.zzc) != null) {
                sensorManager.unregisterListener(this, sensor);
                this.zzk = false;
                com.google.android.gms.ads.internal.util.zze.zza("Stopped listening for flick gestures.");
            }
        }
    }

    public final void zzc() {
        SensorManager sensorManager;
        Sensor sensor;
        synchronized (this) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziW)).booleanValue()) {
                if (!this.zzk && (sensorManager = this.zzb) != null && (sensor = this.zzc) != null) {
                    sensorManager.registerListener(this, sensor, 2);
                    this.zzk = true;
                    com.google.android.gms.ads.internal.util.zze.zza("Listening for flick gestures.");
                }
                if (this.zzb == null || this.zzc == null) {
                    zzcec.zzj("Flick detection failed to initialize. Failed to obtain gyroscope.");
                }
            }
        }
    }

    public final void zzd(zzdyo zzdyoVar) {
        this.zzj = zzdyoVar;
    }
}

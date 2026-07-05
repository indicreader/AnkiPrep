package com.google.android.gms.internal.ads;

import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import okhttp3.internal.ws.RealWebSocket;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdw implements zzdt {
    private int zzb;
    private float zzc = 1.0f;
    private float zzd = 1.0f;
    private zzdr zze = zzdr.zza;
    private zzdr zzf;
    private zzdr zzg;
    private zzdr zzh;
    private boolean zzi;
    private zzdv zzj;
    private ByteBuffer zzk;
    private ShortBuffer zzl;
    private ByteBuffer zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;

    public zzdw() {
        zzdr zzdrVar = zzdr.zza;
        this.zzf = zzdrVar;
        this.zzg = zzdrVar;
        this.zzh = zzdrVar;
        ByteBuffer byteBuffer = zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = zza;
        this.zzb = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final zzdr zza(zzdr zzdrVar) throws zzds {
        if (zzdrVar.zzd != 2) {
            throw new zzds("Unhandled input format:", zzdrVar);
        }
        int i = this.zzb;
        if (i == -1) {
            i = zzdrVar.zzb;
        }
        this.zze = zzdrVar;
        zzdr zzdrVar2 = new zzdr(i, zzdrVar.zzc, 2);
        this.zzf = zzdrVar2;
        this.zzi = true;
        return zzdrVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final ByteBuffer zzb() {
        int zza;
        zzdv zzdvVar = this.zzj;
        if (zzdvVar != null && (zza = zzdvVar.zza()) > 0) {
            if (this.zzk.capacity() < zza) {
                ByteBuffer order = ByteBuffer.allocateDirect(zza).order(ByteOrder.nativeOrder());
                this.zzk = order;
                this.zzl = order.asShortBuffer();
            } else {
                this.zzk.clear();
                this.zzl.clear();
            }
            zzdvVar.zzd(this.zzl);
            this.zzo += zza;
            this.zzk.limit(zza);
            this.zzm = this.zzk;
        }
        ByteBuffer byteBuffer = this.zzm;
        this.zzm = zza;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final void zzc() {
        if (zzg()) {
            this.zzg = this.zze;
            this.zzh = this.zzf;
            if (this.zzi) {
                zzdr zzdrVar = this.zzg;
                this.zzj = new zzdv(zzdrVar.zzb, zzdrVar.zzc, this.zzc, this.zzd, this.zzh.zzb);
            } else {
                zzdv zzdvVar = this.zzj;
                if (zzdvVar != null) {
                    zzdvVar.zzc();
                }
            }
        }
        this.zzm = zza;
        this.zzn = 0L;
        this.zzo = 0L;
        this.zzp = false;
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final void zzd() {
        zzdv zzdvVar = this.zzj;
        if (zzdvVar != null) {
            zzdvVar.zze();
        }
        this.zzp = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final void zze(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            zzdv zzdvVar = this.zzj;
            zzdvVar.getClass();
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.zzn += remaining;
            zzdvVar.zzf(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final void zzf() {
        this.zzc = 1.0f;
        this.zzd = 1.0f;
        this.zze = zzdr.zza;
        zzdr zzdrVar = zzdr.zza;
        this.zzf = zzdrVar;
        this.zzg = zzdrVar;
        this.zzh = zzdrVar;
        ByteBuffer byteBuffer = zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = zza;
        this.zzb = -1;
        this.zzi = false;
        this.zzj = null;
        this.zzn = 0L;
        this.zzo = 0L;
        this.zzp = false;
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final boolean zzg() {
        if (this.zzf.zzb == -1) {
            return false;
        }
        if (Math.abs(this.zzc - 1.0f) >= 1.0E-4f || Math.abs(this.zzd - 1.0f) >= 1.0E-4f) {
            return true;
        }
        return this.zzf.zzb != this.zze.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final boolean zzh() {
        if (!this.zzp) {
            return false;
        }
        zzdv zzdvVar = this.zzj;
        return zzdvVar == null || zzdvVar.zza() == 0;
    }

    public final void zzj(float f) {
        if (this.zzd != f) {
            this.zzd = f;
            this.zzi = true;
        }
    }

    public final void zzk(float f) {
        if (this.zzc != f) {
            this.zzc = f;
            this.zzi = true;
        }
    }

    public final long zzi(long j) {
        long j2 = this.zzo;
        if (j2 < RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            return (long) (this.zzc * j);
        }
        long j3 = this.zzn;
        this.zzj.getClass();
        long zzb = j3 - r3.zzb();
        int i = this.zzh.zzb;
        int i2 = this.zzg.zzb;
        if (i == i2) {
            return zzfy.zzs(j, zzb, j2, RoundingMode.FLOOR);
        }
        return zzfy.zzs(j, zzb * i, j2 * i2, RoundingMode.FLOOR);
    }
}

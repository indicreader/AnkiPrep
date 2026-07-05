package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzchf implements zzgw {
    private final Context zza;
    private final zzgw zzb;
    private final String zzc;
    private final int zzd;
    private InputStream zzf;
    private boolean zzg;
    private Uri zzh;
    private volatile zzbbb zzi;
    private zzhb zzm;
    private boolean zzj = false;
    private boolean zzk = false;
    private final AtomicLong zzl = new AtomicLong(-1);
    private final boolean zze = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbQ)).booleanValue();

    public zzchf(Context context, zzgw zzgwVar, String str, int i, zzhy zzhyVar, zzche zzcheVar) {
        this.zza = context;
        this.zzb = zzgwVar;
        this.zzc = str;
        this.zzd = i;
    }

    private final boolean zzg() {
        if (!this.zze) {
            return false;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzem)).booleanValue() || this.zzj) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzen)).booleanValue() && !this.zzk;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final Uri zzc() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final /* synthetic */ Map zze() {
        return Collections.emptyMap();
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzf(zzhy zzhyVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzu
    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        if (!this.zzg) {
            throw new IOException("Attempt to read closed CacheDataSource.");
        }
        InputStream inputStream = this.zzf;
        if (inputStream != null) {
            return inputStream.read(bArr, i, i2);
        }
        return this.zzb.zza(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final long zzb(zzhb zzhbVar) throws IOException {
        Long l;
        if (this.zzg) {
            throw new IOException("Attempt to open an already open CacheDataSource.");
        }
        this.zzg = true;
        this.zzh = zzhbVar.zza;
        this.zzm = zzhbVar;
        this.zzi = zzbbb.zza(zzhbVar.zza);
        zzbay zzbayVar = null;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzej)).booleanValue()) {
            if (this.zzi != null) {
                this.zzi.zzh = zzhbVar.zzf;
                this.zzi.zzi = zzfxt.zzc(this.zzc);
                this.zzi.zzj = this.zzd;
                zzbayVar = com.google.android.gms.ads.internal.zzt.zzc().zzb(this.zzi);
            }
            if (zzbayVar != null && zzbayVar.zze()) {
                this.zzj = zzbayVar.zzg();
                this.zzk = zzbayVar.zzf();
                if (!zzg()) {
                    this.zzf = zzbayVar.zzc();
                    return -1L;
                }
            }
        } else if (this.zzi != null) {
            this.zzi.zzh = zzhbVar.zzf;
            this.zzi.zzi = zzfxt.zzc(this.zzc);
            this.zzi.zzj = this.zzd;
            if (this.zzi.zzg) {
                l = (Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzel);
            } else {
                l = (Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzek);
            }
            long longValue = l.longValue();
            com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
            com.google.android.gms.ads.internal.zzt.zzd();
            Future zza = zzbbm.zza(this.zza, this.zzi);
            try {
                try {
                    zzbbn zzbbnVar = (zzbbn) zza.get(longValue, TimeUnit.MILLISECONDS);
                    zzbbnVar.zzd();
                    this.zzj = zzbbnVar.zzf();
                    this.zzk = zzbbnVar.zze();
                    zzbbnVar.zza();
                    if (!zzg()) {
                        this.zzf = zzbbnVar.zzc();
                    }
                } catch (InterruptedException unused) {
                    zza.cancel(false);
                    Thread.currentThread().interrupt();
                } catch (ExecutionException | TimeoutException unused2) {
                    zza.cancel(false);
                }
            } catch (Throwable unused3) {
            }
            com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
            throw null;
        }
        if (this.zzi != null) {
            Uri parse = Uri.parse(this.zzi.zza);
            byte[] bArr = zzhbVar.zzc;
            long j = zzhbVar.zze;
            long j2 = zzhbVar.zzf;
            long j3 = zzhbVar.zzg;
            String str = zzhbVar.zzh;
            this.zzm = new zzhb(parse, null, j, j2, j3, null, zzhbVar.zzi);
        }
        return this.zzb.zzb(this.zzm);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzd() throws IOException {
        if (!this.zzg) {
            throw new IOException("Attempt to close an already closed CacheDataSource.");
        }
        this.zzg = false;
        this.zzh = null;
        InputStream inputStream = this.zzf;
        if (inputStream != null) {
            IOUtils.closeQuietly(inputStream);
            this.zzf = null;
        } else {
            this.zzb.zzd();
        }
    }
}

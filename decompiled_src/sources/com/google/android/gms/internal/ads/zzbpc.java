package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbpc implements zzapt {
    private volatile zzbop zza;
    private final Context zzb;

    public zzbpc(Context context) {
        this.zzb = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzc(zzbpc zzbpcVar) {
        if (zzbpcVar.zza == null) {
            return;
        }
        zzbpcVar.zza.disconnect();
        Binder.flushPendingCommands();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzapt
    public final zzapw zza(zzaqa zzaqaVar) throws zzaqj {
        Parcelable.Creator<zzboq> creator = zzboq.CREATOR;
        Map zzl = zzaqaVar.zzl();
        int size = zzl.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        int i2 = 0;
        for (Map.Entry entry : zzl.entrySet()) {
            strArr[i2] = (String) entry.getKey();
            strArr2[i2] = (String) entry.getValue();
            i2++;
        }
        zzboq zzboqVar = new zzboq(zzaqaVar.zzk(), strArr, strArr2);
        long elapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
        try {
            zzceu zzceuVar = new zzceu();
            this.zza = new zzbop(this.zzb, com.google.android.gms.ads.internal.zzt.zzt().zzb(), new zzbpa(this, zzceuVar), new zzbpb(this, zzceuVar));
            this.zza.checkAvailabilityAndConnect();
            ListenableFuture zzo = zzgen.zzo(zzgen.zzn(zzceuVar, new zzboy(this, zzboqVar), zzcep.zza), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzet)).intValue(), TimeUnit.MILLISECONDS, zzcep.zzd);
            zzo.addListener(new zzboz(this), zzcep.zza);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzo.get();
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - elapsedRealtime) + "ms");
            zzbos zzbosVar = (zzbos) new zzbzc(parcelFileDescriptor).zza(zzbos.CREATOR);
            if (zzbosVar == null) {
                return null;
            }
            if (zzbosVar.zza) {
                throw new zzaqj(zzbosVar.zzb);
            }
            if (zzbosVar.zze.length != zzbosVar.zzf.length) {
                return null;
            }
            HashMap hashMap = new HashMap();
            while (true) {
                String[] strArr3 = zzbosVar.zze;
                if (i < strArr3.length) {
                    hashMap.put(strArr3[i], zzbosVar.zzf[i]);
                    i++;
                } else {
                    return new zzapw(zzbosVar.zzc, zzbosVar.zzd, hashMap, zzbosVar.zzg, zzbosVar.zzh);
                }
            }
        } catch (InterruptedException | ExecutionException unused) {
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - elapsedRealtime) + "ms");
            return null;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - elapsedRealtime) + "ms");
            throw th;
        }
    }
}

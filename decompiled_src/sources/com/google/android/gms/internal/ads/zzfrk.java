package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Base64;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfrk {
    private final Context zza;
    private final Executor zzb;
    private final zzfqr zzc;
    private final zzfqt zzd;
    private final zzfrj zze;
    private final zzfrj zzf;
    private Task zzg;
    private Task zzh;

    zzfrk(Context context, Executor executor, zzfqr zzfqrVar, zzfqt zzfqtVar, zzfrh zzfrhVar, zzfri zzfriVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzfqrVar;
        this.zzd = zzfqtVar;
        this.zze = zzfrhVar;
        this.zzf = zzfriVar;
    }

    public static zzfrk zze(Context context, Executor executor, zzfqr zzfqrVar, zzfqt zzfqtVar) {
        final zzfrk zzfrkVar = new zzfrk(context, executor, zzfqrVar, zzfqtVar, new zzfrh(), new zzfri());
        if (zzfrkVar.zzd.zzd()) {
            zzfrkVar.zzg = zzfrkVar.zzh(new Callable() { // from class: com.google.android.gms.internal.ads.zzfre
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return zzfrk.this.zzc();
                }
            });
        } else {
            zzfrkVar.zzg = Tasks.forResult(zzfrkVar.zze.zza());
        }
        zzfrkVar.zzh = zzfrkVar.zzh(new Callable() { // from class: com.google.android.gms.internal.ads.zzfrf
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzfrk.this.zzd();
            }
        });
        return zzfrkVar;
    }

    private static zzatd zzg(Task task, zzatd zzatdVar) {
        return !task.isSuccessful() ? zzatdVar : (zzatd) task.getResult();
    }

    private final Task zzh(Callable callable) {
        return Tasks.call(this.zzb, callable).addOnFailureListener(this.zzb, new OnFailureListener() { // from class: com.google.android.gms.internal.ads.zzfrg
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                zzfrk.this.zzf(exc);
            }
        });
    }

    public final zzatd zza() {
        return zzg(this.zzg, this.zze.zza());
    }

    public final zzatd zzb() {
        return zzg(this.zzh, this.zzf.zza());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzatd zzc() throws Exception {
        zzasg zza = zzatd.zza();
        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zza);
        String id = advertisingIdInfo.getId();
        if (id != null && id.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            UUID fromString = UUID.fromString(id);
            byte[] bArr = new byte[16];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.putLong(fromString.getMostSignificantBits());
            wrap.putLong(fromString.getLeastSignificantBits());
            id = Base64.encodeToString(bArr, 11);
        }
        if (id != null) {
            zza.zzs(id);
            zza.zzr(advertisingIdInfo.isLimitAdTrackingEnabled());
            zza.zzab(6);
        }
        return (zzatd) zza.zzal();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzatd zzd() throws Exception {
        Context context = this.zza;
        return zzfqz.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzc.zzc(2025, -1L, exc);
    }
}

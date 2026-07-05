package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.ClientLibraryUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcep {
    public static final zzgey zza;
    public static final zzgey zzb;
    public static final zzgey zzc;
    public static final ScheduledExecutorService zzd;
    public static final zzgey zze;
    public static final zzgey zzf;

    static {
        Executor threadPoolExecutor;
        Executor executor;
        Executor executor2;
        if (ClientLibraryUtils.isPackageSide()) {
            zzfts.zza();
            threadPoolExecutor = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(new zzcel("Default")));
        } else {
            threadPoolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new zzcel("Default"));
        }
        zzcen zzcenVar = null;
        zza = new zzceo(threadPoolExecutor, zzcenVar);
        if (ClientLibraryUtils.isPackageSide()) {
            executor = zzfts.zza().zzc(5, new zzcel("Loader"), 1);
        } else {
            ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(5, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzcel("Loader"));
            threadPoolExecutor2.allowCoreThreadTimeOut(true);
            executor = threadPoolExecutor2;
        }
        zzb = new zzceo(executor, zzcenVar);
        if (ClientLibraryUtils.isPackageSide()) {
            executor2 = zzfts.zza().zzb(new zzcel("Activeview"), 1);
        } else {
            ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzcel("Activeview"));
            threadPoolExecutor3.allowCoreThreadTimeOut(true);
            executor2 = threadPoolExecutor3;
        }
        zzc = new zzceo(executor2, zzcenVar);
        zzd = new zzcek(3, new zzcel("Schedule"));
        zze = new zzceo(new zzcem(), zzcenVar);
        zzf = new zzceo(zzgfe.zzb(), zzcenVar);
    }
}

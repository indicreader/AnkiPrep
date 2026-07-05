package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeyl implements zzexq {
    private final Context zza;
    private final ScheduledExecutorService zzb;
    private final Executor zzc;
    private final int zzd;
    private final boolean zze;
    private final boolean zzf;
    private final zzcdc zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeyl(zzcdc zzcdcVar, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i, boolean z, boolean z2) {
        this.zzg = zzcdcVar;
        this.zza = context;
        this.zzb = scheduledExecutorService;
        this.zzc = executor;
        this.zzd = i;
        this.zze = z;
        this.zzf = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 40;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaU)).booleanValue()) {
            return zzgen.zzg(new Exception("Did not ad Ad ID into query param."));
        }
        return zzgen.zze((zzgee) zzgen.zzo(zzgen.zzm(zzgee.zzu(this.zzg.zza(this.zza, this.zzd)), new zzfws() { // from class: com.google.android.gms.internal.ads.zzeyj
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                return zzeyl.this.zzc((AdvertisingIdClient.Info) obj);
            }
        }, this.zzc), ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaV)).longValue(), TimeUnit.MILLISECONDS, this.zzb), Throwable.class, new zzfws() { // from class: com.google.android.gms.internal.ads.zzeyk
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                return zzeyl.this.zzd((Throwable) obj);
            }
        }, this.zzc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0067, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0068, code lost:
    
        com.google.android.gms.ads.internal.zzt.zzo().zzw(r0, "AdIdInfoSignalSource.getPaidV1");
        r0 = new com.google.android.gms.internal.ads.zzfub();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbgc.zzcS)).booleanValue() != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0019, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbgc.zzcR)).booleanValue() == false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0031, code lost:
    
        r0 = com.google.android.gms.internal.ads.zzfue.zzj(r7.zza).zzi((java.lang.String) java.util.Objects.requireNonNull(((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) java.util.Objects.requireNonNull(r8)).getId()), r7.zza.getPackageName(), ((java.lang.Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbgc.zzcY)).longValue(), r7.zzf);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzeym zzc(com.google.android.gms.ads.identifier.AdvertisingIdClient.Info r8) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzfub r0 = new com.google.android.gms.internal.ads.zzfub
            r0.<init>()
            boolean r1 = r7.zze
            if (r1 != 0) goto L1b
            com.google.android.gms.internal.ads.zzbfu r1 = com.google.android.gms.internal.ads.zzbgc.zzcR
            com.google.android.gms.internal.ads.zzbga r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L31
        L1b:
            boolean r1 = r7.zze
            if (r1 == 0) goto L76
            com.google.android.gms.internal.ads.zzbfu r1 = com.google.android.gms.internal.ads.zzbgc.zzcS
            com.google.android.gms.internal.ads.zzbga r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L76
        L31:
            android.content.Context r0 = r7.zza     // Catch: java.lang.IllegalArgumentException -> L65 java.io.IOException -> L67
            com.google.android.gms.internal.ads.zzfue r1 = com.google.android.gms.internal.ads.zzfue.zzj(r0)     // Catch: java.lang.IllegalArgumentException -> L65 java.io.IOException -> L67
            java.lang.Object r0 = java.util.Objects.requireNonNull(r8)     // Catch: java.lang.IllegalArgumentException -> L65 java.io.IOException -> L67
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r0 = (com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) r0     // Catch: java.lang.IllegalArgumentException -> L65 java.io.IOException -> L67
            java.lang.String r0 = r0.getId()     // Catch: java.lang.IllegalArgumentException -> L65 java.io.IOException -> L67
            java.lang.Object r0 = java.util.Objects.requireNonNull(r0)     // Catch: java.lang.IllegalArgumentException -> L65 java.io.IOException -> L67
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.IllegalArgumentException -> L65 java.io.IOException -> L67
            android.content.Context r0 = r7.zza     // Catch: java.lang.IllegalArgumentException -> L65 java.io.IOException -> L67
            java.lang.String r3 = r0.getPackageName()     // Catch: java.lang.IllegalArgumentException -> L65 java.io.IOException -> L67
            com.google.android.gms.internal.ads.zzbfu r0 = com.google.android.gms.internal.ads.zzbgc.zzcY     // Catch: java.lang.IllegalArgumentException -> L65 java.io.IOException -> L67
            com.google.android.gms.internal.ads.zzbga r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch: java.lang.IllegalArgumentException -> L65 java.io.IOException -> L67
            java.lang.Object r0 = r4.zza(r0)     // Catch: java.lang.IllegalArgumentException -> L65 java.io.IOException -> L67
            java.lang.Long r0 = (java.lang.Long) r0     // Catch: java.lang.IllegalArgumentException -> L65 java.io.IOException -> L67
            long r4 = r0.longValue()     // Catch: java.lang.IllegalArgumentException -> L65 java.io.IOException -> L67
            boolean r6 = r7.zzf     // Catch: java.lang.IllegalArgumentException -> L65 java.io.IOException -> L67
            com.google.android.gms.internal.ads.zzfub r0 = r1.zzi(r2, r3, r4, r6)     // Catch: java.lang.IllegalArgumentException -> L65 java.io.IOException -> L67
            goto L76
        L65:
            r0 = move-exception
            goto L68
        L67:
            r0 = move-exception
        L68:
            java.lang.String r1 = "AdIdInfoSignalSource.getPaidV1"
            com.google.android.gms.internal.ads.zzcdl r2 = com.google.android.gms.ads.internal.zzt.zzo()
            r2.zzw(r0, r1)
            com.google.android.gms.internal.ads.zzfub r0 = new com.google.android.gms.internal.ads.zzfub
            r0.<init>()
        L76:
            com.google.android.gms.internal.ads.zzeym r1 = new com.google.android.gms.internal.ads.zzeym
            r2 = 0
            r1.<init>(r8, r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeyl.zzc(com.google.android.gms.ads.identifier.AdvertisingIdClient$Info):com.google.android.gms.internal.ads.zzeym");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzeym zzd(Throwable th) {
        com.google.android.gms.ads.internal.client.zzay.zzb();
        ContentResolver contentResolver = this.zza.getContentResolver();
        return new zzeym(null, contentResolver == null ? null : Settings.Secure.getString(contentResolver, "android_id"), new zzfub());
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeyf implements zzexq {
    private final com.google.android.gms.ads.internal.util.zzg zza;
    private final Context zzb;
    private final zzgey zzc;
    private final ScheduledExecutorService zzd;
    private final zzeil zze;
    private final zzfhh zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeyf(com.google.android.gms.ads.internal.util.zzg zzgVar, Context context, zzgey zzgeyVar, ScheduledExecutorService scheduledExecutorService, zzeil zzeilVar, zzfhh zzfhhVar) {
        this.zza = zzgVar;
        this.zzb = context;
        this.zzc = zzgeyVar;
        this.zzd = scheduledExecutorService;
        this.zze = zzeilVar;
        this.zzf = zzfhhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 56;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0038, code lost:
    
        if (r5.zzf.zzd.zzy != com.google.android.gms.ads.RequestConfiguration.PublisherPrivacyPersonalizationState.DISABLED.getValue()) goto L10;
     */
    @Override // com.google.android.gms.internal.ads.zzexq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.common.util.concurrent.ListenableFuture zzb() {
        /*
            r5 = this;
            com.google.android.gms.internal.ads.zzbfu r0 = com.google.android.gms.internal.ads.zzbgc.zzjU
            com.google.android.gms.internal.ads.zzbga r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L74
            com.google.android.gms.ads.internal.util.zzg r0 = r5.zza
            boolean r0 = r0.zzR()
            if (r0 == 0) goto L74
            com.google.android.gms.internal.ads.zzbfu r0 = com.google.android.gms.internal.ads.zzbgc.zzjX
            com.google.android.gms.internal.ads.zzbga r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L3a
            com.google.android.gms.internal.ads.zzfhh r0 = r5.zzf
            com.google.android.gms.ads.RequestConfiguration$PublisherPrivacyPersonalizationState r1 = com.google.android.gms.ads.RequestConfiguration.PublisherPrivacyPersonalizationState.DISABLED
            int r1 = r1.getValue()
            com.google.android.gms.ads.internal.client.zzl r0 = r0.zzd
            int r0 = r0.zzy
            if (r0 == r1) goto L74
        L3a:
            com.google.android.gms.internal.ads.zzeil r0 = r5.zze
            r1 = 0
            com.google.common.util.concurrent.ListenableFuture r0 = r0.zza(r1)
            com.google.android.gms.internal.ads.zzbfu r1 = com.google.android.gms.internal.ads.zzbgc.zzjV
            com.google.android.gms.internal.ads.zzbga r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            long r1 = (long) r1
            java.util.concurrent.ScheduledExecutorService r3 = r5.zzd
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgen.zzo(r0, r1, r4, r3)
            com.google.android.gms.internal.ads.zzgee r0 = com.google.android.gms.internal.ads.zzgee.zzu(r0)
            com.google.android.gms.internal.ads.zzgey r1 = r5.zzc
            com.google.android.gms.internal.ads.zzeyd r2 = new com.google.android.gms.internal.ads.zzgdu() { // from class: com.google.android.gms.internal.ads.zzeyd
                static {
                    /*
                        com.google.android.gms.internal.ads.zzeyd r0 = new com.google.android.gms.internal.ads.zzeyd
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.google.android.gms.internal.ads.zzeyd) com.google.android.gms.internal.ads.zzeyd.zza com.google.android.gms.internal.ads.zzeyd
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeyd.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeyd.<init>():void");
                }

                @Override // com.google.android.gms.internal.ads.zzgdu
                public final com.google.common.util.concurrent.ListenableFuture zza(java.lang.Object r6) {
                    /*
                        r5 = this;
                        androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse r6 = (androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse) r6
                        com.google.android.gms.internal.ads.zzhdn r0 = com.google.android.gms.internal.ads.zzhdo.zza()
                        java.util.List r6 = r6.getTopics()
                        java.util.Iterator r6 = r6.iterator()
                    Le:
                        boolean r1 = r6.hasNext()
                        if (r1 == 0) goto L3d
                        java.lang.Object r1 = r6.next()
                        androidx.privacysandbox.ads.adservices.topics.Topic r1 = (androidx.privacysandbox.ads.adservices.topics.Topic) r1
                        com.google.android.gms.internal.ads.zzhdl r2 = com.google.android.gms.internal.ads.zzhdm.zza()
                        int r3 = r1.getTopicId()
                        r2.zzc(r3)
                        long r3 = r1.getModelVersion()
                        r2.zza(r3)
                        long r3 = r1.getTaxonomyVersion()
                        r2.zzb(r3)
                        com.google.android.gms.internal.ads.zzgzu r1 = r2.zzal()
                        com.google.android.gms.internal.ads.zzhdm r1 = (com.google.android.gms.internal.ads.zzhdm) r1
                        r0.zza(r1)
                        goto Le
                    L3d:
                        com.google.android.gms.internal.ads.zzgzu r6 = r0.zzal()
                        com.google.android.gms.internal.ads.zzhdo r6 = (com.google.android.gms.internal.ads.zzhdo) r6
                        byte[] r6 = r6.zzax()
                        r0 = 1
                        java.lang.String r6 = android.util.Base64.encodeToString(r6, r0)
                        com.google.android.gms.internal.ads.zzeyh r1 = new com.google.android.gms.internal.ads.zzeyh
                        r2 = 0
                        r1.<init>(r6, r0, r2)
                        com.google.common.util.concurrent.ListenableFuture r6 = com.google.android.gms.internal.ads.zzgen.zzh(r1)
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeyd.zza(java.lang.Object):com.google.common.util.concurrent.ListenableFuture");
                }
            }
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgen.zzn(r0, r2, r1)
            com.google.android.gms.internal.ads.zzeye r1 = new com.google.android.gms.internal.ads.zzeye
            r1.<init>()
            com.google.android.gms.internal.ads.zzgey r2 = r5.zzc
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgen.zzf(r0, r3, r1, r2)
            return r0
        L74:
            com.google.android.gms.internal.ads.zzeyh r0 = new com.google.android.gms.internal.ads.zzeyh
            r1 = -1
            r2 = 0
            java.lang.String r3 = ""
            r0.<init>(r3, r1, r2)
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgen.zzh(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeyf.zzb():com.google.common.util.concurrent.ListenableFuture");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(Throwable th) throws Exception {
        zzeyh zzeyhVar;
        zzbxw.zza(this.zzb).zzg(th, "TopicsSignal.fetchTopicsSignal");
        if (th instanceof SecurityException) {
            zzeyhVar = new zzeyh("", 2, null);
        } else if (th instanceof IllegalStateException) {
            zzeyhVar = new zzeyh("", 3, null);
        } else if (th instanceof IllegalArgumentException) {
            zzeyhVar = new zzeyh("", 4, null);
        } else if (th instanceof TimeoutException) {
            zzeyhVar = new zzeyh("", 5, null);
        } else {
            zzeyhVar = new zzeyh("", 0, null);
        }
        return zzgen.zzh(zzeyhVar);
    }
}

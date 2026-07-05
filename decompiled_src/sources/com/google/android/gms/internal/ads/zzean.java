package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzean implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;

    public zzean(zzhhu zzhhuVar, zzhhu zzhhuVar2) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzflm zzflmVar = (zzflm) this.zza.zzb();
        final CookieManager zza = com.google.android.gms.ads.internal.zzt.zzq().zza((Context) this.zzb.zzb());
        zzfld zzi = zzfkw.zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeak
            @Override // java.util.concurrent.Callable
            public final Object call() {
                CookieManager cookieManager = zza;
                if (cookieManager == null) {
                    return "";
                }
                return cookieManager.getCookie((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaN));
            }
        }, zzflg.WEBVIEW_COOKIE, zzflmVar).zzi(1L, TimeUnit.SECONDS);
        final zzeal zzealVar = new zzfkp() { // from class: com.google.android.gms.internal.ads.zzeal
            @Override // com.google.android.gms.internal.ads.zzfkp
            public final Object zza(Object obj) {
                return "";
            }
        };
        return zzi.zzc(Exception.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzfkx
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzgen.zzh("");
            }
        }).zza();
    }
}

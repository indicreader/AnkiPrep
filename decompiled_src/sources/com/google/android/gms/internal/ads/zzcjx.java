package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.TrafficStats;
import android.os.StrictMode;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes3.dex */
public final class zzcjx {
    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.gms.internal.ads.zzcjk, java.lang.Object] */
    public static final zzcjk zza(final Context context, final zzcla zzclaVar, final String str, final boolean z, final boolean z2, final zzavi zzaviVar, final zzbhj zzbhjVar, final zzcei zzceiVar, zzbgu zzbguVar, final com.google.android.gms.ads.internal.zzl zzlVar, final com.google.android.gms.ads.internal.zza zzaVar, final zzbbp zzbbpVar, final zzfgm zzfgmVar, final zzfgp zzfgpVar, final zzehs zzehsVar, final zzfhl zzfhlVar) throws zzcjw {
        zzbgc.zza(context);
        try {
            final zzbgu zzbguVar2 = null;
            zzfxu zzfxuVar = new zzfxu(context, zzclaVar, str, z, z2, zzaviVar, zzbhjVar, zzceiVar, zzbguVar2, zzlVar, zzaVar, zzbbpVar, zzfgmVar, zzfgpVar, zzfhlVar, zzehsVar) { // from class: com.google.android.gms.internal.ads.zzcjt
                public final /* synthetic */ Context zza;
                public final /* synthetic */ zzcla zzb;
                public final /* synthetic */ String zzc;
                public final /* synthetic */ boolean zzd;
                public final /* synthetic */ boolean zze;
                public final /* synthetic */ zzavi zzf;
                public final /* synthetic */ zzbhj zzg;
                public final /* synthetic */ zzcei zzh;
                public final /* synthetic */ com.google.android.gms.ads.internal.zzl zzi;
                public final /* synthetic */ com.google.android.gms.ads.internal.zza zzj;
                public final /* synthetic */ zzbbp zzk;
                public final /* synthetic */ zzfgm zzl;
                public final /* synthetic */ zzfgp zzm;
                public final /* synthetic */ zzfhl zzn;
                public final /* synthetic */ zzehs zzo;

                {
                    this.zzi = zzlVar;
                    this.zzj = zzaVar;
                    this.zzk = zzbbpVar;
                    this.zzl = zzfgmVar;
                    this.zzm = zzfgpVar;
                    this.zzn = zzfhlVar;
                    this.zzo = zzehsVar;
                }

                @Override // com.google.android.gms.internal.ads.zzfxu
                public final Object zza() {
                    zzcla zzclaVar2 = this.zzb;
                    String str2 = this.zzc;
                    boolean z3 = this.zzd;
                    zzbbp zzbbpVar2 = this.zzk;
                    boolean z4 = this.zze;
                    zzavi zzaviVar2 = this.zzf;
                    zzfgm zzfgmVar2 = this.zzl;
                    zzbhj zzbhjVar2 = this.zzg;
                    com.google.android.gms.ads.internal.zzl zzlVar2 = this.zzi;
                    zzfgp zzfgpVar2 = this.zzm;
                    Context context2 = this.zza;
                    zzcei zzceiVar2 = this.zzh;
                    com.google.android.gms.ads.internal.zza zzaVar2 = this.zzj;
                    zzfhl zzfhlVar2 = this.zzn;
                    zzehs zzehsVar2 = this.zzo;
                    try {
                        TrafficStats.setThreadStatsTag(264);
                        int i = zzckf.zza;
                        zzcka zzckaVar = new zzcka(new zzckf(new zzckz(context2), zzclaVar2, str2, z3, z4, zzaviVar2, zzbhjVar2, zzceiVar2, null, zzlVar2, zzaVar2, zzbbpVar2, zzfgmVar2, zzfgpVar2, zzfhlVar2));
                        zzckaVar.setWebViewClient(com.google.android.gms.ads.internal.zzt.zzq().zzc(zzckaVar, zzbbpVar2, z4, zzehsVar2));
                        zzckaVar.setWebChromeClient(new zzcjj(zzckaVar));
                        return zzckaVar;
                    } finally {
                        TrafficStats.clearThreadStatsTag();
                    }
                }
            };
            StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            try {
                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
                return zzfxuVar.zza();
            } finally {
                StrictMode.setThreadPolicy(threadPolicy);
            }
        } catch (Throwable th) {
            throw new zzcjw("Webview initialization failed.", th);
        }
    }
}

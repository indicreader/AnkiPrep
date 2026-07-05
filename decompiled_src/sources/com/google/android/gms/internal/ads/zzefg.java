package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.core.app.NotificationCompat;
import coil.disk.DiskLruCache;
import com.google.android.gms.ads.MobileAds;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzefg implements zzdfp, com.google.android.gms.ads.internal.client.zza, zzdbr, zzdbb {
    private final Context zza;
    private final zzfhz zzb;
    private final zzfgy zzc;
    private final zzfgm zzd;
    private final zzehh zze;
    private Boolean zzf;
    private final boolean zzg = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgR)).booleanValue();
    private final zzflw zzh;
    private final String zzi;

    public zzefg(Context context, zzfhz zzfhzVar, zzfgy zzfgyVar, zzfgm zzfgmVar, zzehh zzehhVar, zzflw zzflwVar, String str) {
        this.zza = context;
        this.zzb = zzfhzVar;
        this.zzc = zzfgyVar;
        this.zzd = zzfgmVar;
        this.zze = zzehhVar;
        this.zzh = zzflwVar;
        this.zzi = str;
    }

    private final zzflv zzd(String str) {
        zzflv zzb = zzflv.zzb(str);
        zzb.zzh(this.zzc, null);
        zzb.zzf(this.zzd);
        zzb.zza("request_id", this.zzi);
        if (!this.zzd.zzu.isEmpty()) {
            zzb.zza("ancn", (String) this.zzd.zzu.get(0));
        }
        if (this.zzd.zzaj) {
            zzb.zza("device_connectivity", true != com.google.android.gms.ads.internal.zzt.zzo().zzz(this.zza) ? "offline" : CustomTabsCallback.ONLINE_EXTRAS_KEY);
            zzb.zza("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()));
            zzb.zza("offline_ad", DiskLruCache.VERSION);
        }
        return zzb;
    }

    private final void zze(zzflv zzflvVar) {
        if (this.zzd.zzaj) {
            this.zze.zzd(new zzehj(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis(), this.zzc.zzb.zzb.zzb, this.zzh.zza(zzflvVar), 2));
            return;
        }
        this.zzh.zzb(zzflvVar);
    }

    private final boolean zzf() {
        String str;
        if (this.zzf == null) {
            synchronized (this) {
                if (this.zzf == null) {
                    String str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbt);
                    com.google.android.gms.ads.internal.zzt.zzp();
                    try {
                        str = com.google.android.gms.ads.internal.util.zzt.zzp(this.zza);
                    } catch (RemoteException unused) {
                        str = null;
                    }
                    boolean z = false;
                    if (str2 != null && str != null) {
                        try {
                            z = Pattern.matches(str2, str);
                        } catch (RuntimeException e) {
                            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "CsiActionsListener.isPatternMatched");
                        }
                    }
                    this.zzf = Boolean.valueOf(z);
                }
            }
        }
        return this.zzf.booleanValue();
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        if (this.zzd.zzaj) {
            zze(zzd("click"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbb
    public final void zza(com.google.android.gms.ads.internal.client.zze zzeVar) {
        com.google.android.gms.ads.internal.client.zze zzeVar2;
        if (this.zzg) {
            int i = zzeVar.zza;
            String str = zzeVar.zzb;
            if (zzeVar.zzc.equals(MobileAds.ERROR_DOMAIN) && (zzeVar2 = zzeVar.zzd) != null && !zzeVar2.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                com.google.android.gms.ads.internal.client.zze zzeVar3 = zzeVar.zzd;
                i = zzeVar3.zza;
                str = zzeVar3.zzb;
            }
            String zza = this.zzb.zza(str);
            zzflv zzd = zzd("ifts");
            zzd.zza("reason", "adapter");
            if (i >= 0) {
                zzd.zza("arec", String.valueOf(i));
            }
            if (zza != null) {
                zzd.zza("areec", zza);
            }
            this.zzh.zzb(zzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbb
    public final void zzb() {
        if (this.zzg) {
            zzflw zzflwVar = this.zzh;
            zzflv zzd = zzd("ifts");
            zzd.zza("reason", "blocked");
            zzflwVar.zzb(zzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbb
    public final void zzc(zzdkv zzdkvVar) {
        if (this.zzg) {
            zzflv zzd = zzd("ifts");
            zzd.zza("reason", "exception");
            if (!TextUtils.isEmpty(zzdkvVar.getMessage())) {
                zzd.zza(NotificationCompat.CATEGORY_MESSAGE, zzdkvVar.getMessage());
            }
            this.zzh.zzb(zzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfp
    public final void zzi() {
        if (zzf()) {
            this.zzh.zzb(zzd("adapter_shown"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfp
    public final void zzj() {
        if (zzf()) {
            this.zzh.zzb(zzd("adapter_impression"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbr
    public final void zzq() {
        if (zzf() || this.zzd.zzaj) {
            zze(zzd("impression"));
        }
    }
}

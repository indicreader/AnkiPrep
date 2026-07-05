package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public class zzdf {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private int zze;
    private int zzf;
    private boolean zzg;
    private final zzgaa zzh;
    private final zzgaa zzi;
    private final int zzj;
    private final int zzk;
    private final zzgaa zzl;
    private final zzde zzm;
    private zzgaa zzn;
    private int zzo;
    private final HashMap zzp;
    private final HashSet zzq;

    @Deprecated
    public zzdf() {
        this.zza = Integer.MAX_VALUE;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = Integer.MAX_VALUE;
        this.zzd = Integer.MAX_VALUE;
        this.zze = Integer.MAX_VALUE;
        this.zzf = Integer.MAX_VALUE;
        this.zzg = true;
        this.zzh = zzgaa.zzl();
        this.zzi = zzgaa.zzl();
        this.zzj = Integer.MAX_VALUE;
        this.zzk = Integer.MAX_VALUE;
        this.zzl = zzgaa.zzl();
        this.zzm = zzde.zza;
        this.zzn = zzgaa.zzl();
        this.zzo = 0;
        this.zzp = new HashMap();
        this.zzq = new HashSet();
    }

    public final zzdf zze(Context context) {
        CaptioningManager captioningManager;
        if ((zzfy.zza >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
            this.zzo = 1088;
            Locale locale = captioningManager.getLocale();
            if (locale != null) {
                this.zzn = zzgaa.zzm(locale.toLanguageTag());
            }
        }
        return this;
    }

    public zzdf zzf(int i, int i2, boolean z) {
        this.zze = i;
        this.zzf = i2;
        this.zzg = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzdf(zzdg zzdgVar) {
        this.zza = Integer.MAX_VALUE;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = Integer.MAX_VALUE;
        this.zzd = Integer.MAX_VALUE;
        this.zze = zzdgVar.zzl;
        this.zzf = zzdgVar.zzm;
        this.zzg = zzdgVar.zzn;
        this.zzh = zzdgVar.zzo;
        this.zzi = zzdgVar.zzq;
        this.zzj = Integer.MAX_VALUE;
        this.zzk = Integer.MAX_VALUE;
        this.zzl = zzdgVar.zzu;
        this.zzm = zzdgVar.zzv;
        this.zzn = zzdgVar.zzw;
        this.zzo = zzdgVar.zzx;
        this.zzq = new HashSet(zzdgVar.zzE);
        this.zzp = new HashMap(zzdgVar.zzD);
    }
}

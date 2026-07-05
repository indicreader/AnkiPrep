package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbyk;
import com.google.android.gms.internal.ads.zzcbs;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes3.dex */
public final class zzb {
    private final Context zza;
    private boolean zzb;
    private final zzcbs zzc;
    private final zzbyk zzd = new zzbyk(false, Collections.emptyList());

    public zzb(Context context, zzcbs zzcbsVar, zzbyk zzbykVar) {
        this.zza = context;
        this.zzc = zzcbsVar;
    }

    private final boolean zzd() {
        zzcbs zzcbsVar = this.zzc;
        return (zzcbsVar != null && zzcbsVar.zza().zzf) || this.zzd.zza;
    }

    public final void zza() {
        this.zzb = true;
    }

    public final void zzb(String str) {
        List<String> list;
        if (zzd()) {
            if (str == null) {
                str = "";
            }
            zzcbs zzcbsVar = this.zzc;
            if (zzcbsVar != null) {
                zzcbsVar.zzd(str, null, 3);
                return;
            }
            zzbyk zzbykVar = this.zzd;
            if (!zzbykVar.zza || (list = zzbykVar.zzb) == null) {
                return;
            }
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    String replace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                    Context context = this.zza;
                    zzt.zzp();
                    com.google.android.gms.ads.internal.util.zzt.zzK(context, "", replace);
                }
            }
        }
    }

    public final boolean zzc() {
        return !zzd() || this.zzb;
    }
}

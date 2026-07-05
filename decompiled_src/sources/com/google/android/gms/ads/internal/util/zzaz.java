package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzapw;
import com.google.android.gms.internal.ads.zzaqa;
import com.google.android.gms.internal.ads.zzaqd;
import com.google.android.gms.internal.ads.zzaqj;
import com.google.android.gms.internal.ads.zzaqo;
import com.google.android.gms.internal.ads.zzaqp;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzara;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbpc;
import com.google.android.gms.internal.ads.zzcdv;
import java.io.File;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzaz extends zzaqp {
    private final Context zzc;

    private zzaz(Context context, zzaqo zzaqoVar) {
        super(zzaqoVar);
        this.zzc = context;
    }

    public static zzaqd zzb(Context context) {
        zzaqd zzaqdVar = new zzaqd(new zzaqw(new File(context.getCacheDir(), "admob_volley"), 20971520), new zzaz(context, new zzara()), 4);
        zzaqdVar.zzd();
        return zzaqdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaqp, com.google.android.gms.internal.ads.zzapt
    public final zzapw zza(zzaqa zzaqaVar) throws zzaqj {
        if (zzaqaVar.zza() == 0) {
            if (Pattern.matches((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzes), zzaqaVar.zzk())) {
                Context context = this.zzc;
                com.google.android.gms.ads.internal.client.zzay.zzb();
                if (zzcdv.zzs(context, 13400000)) {
                    zzapw zza = new zzbpc(this.zzc).zza(zzaqaVar);
                    if (zza != null) {
                        zze.zza("Got gmscore asset response: ".concat(String.valueOf(zzaqaVar.zzk())));
                        return zza;
                    }
                    zze.zza("Failed to get gmscore asset response: ".concat(String.valueOf(zzaqaVar.zzk())));
                }
            }
        }
        return super.zza(zzaqaVar);
    }
}

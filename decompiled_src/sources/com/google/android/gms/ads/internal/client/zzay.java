package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzbll;
import com.google.android.gms.internal.ads.zzblm;
import com.google.android.gms.internal.ads.zzbwq;
import com.google.android.gms.internal.ads.zzcaz;
import com.google.android.gms.internal.ads.zzcdv;
import com.google.android.gms.internal.ads.zzcei;
import java.util.Random;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzay {
    private static final zzay zza = new zzay();
    private final zzcdv zzb;
    private final zzaw zzc;
    private final String zzd;
    private final zzcei zze;
    private final Random zzf;

    protected zzay() {
        zzcdv zzcdvVar = new zzcdv();
        zzaw zzawVar = new zzaw(new zzk(), new zzi(), new zzeq(), new zzbll(), new zzcaz(), new zzbwq(), new zzblm());
        String zzd = zzcdv.zzd();
        zzcei zzceiVar = new zzcei(0, 240304000, true, false, false);
        Random random = new Random();
        this.zzb = zzcdvVar;
        this.zzc = zzawVar;
        this.zzd = zzd;
        this.zze = zzceiVar;
        this.zzf = random;
    }

    public static zzaw zza() {
        return zza.zzc;
    }

    public static zzcdv zzb() {
        return zza.zzb;
    }

    public static zzcei zzc() {
        return zza.zze;
    }

    public static String zzd() {
        return zza.zzd;
    }

    public static Random zze() {
        return zza.zzf;
    }
}
